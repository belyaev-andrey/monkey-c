package io.github.garmin.monkeyc.lang.resolve

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.ResolveState
import com.intellij.psi.impl.source.resolve.ResolveCache
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.indexing.FileBasedIndex
import io.github.garmin.monkeyc.lang.file.MonkeyFileType
import io.github.garmin.monkeyc.lang.psi.MonkeyComponentName
import io.github.garmin.monkeyc.lang.psi.MonkeyFile
import io.github.garmin.monkeyc.lang.psi.MonkeyReference

class MonkeyResolver : ResolveCache.AbstractResolver<MonkeyReference, List<PsiElement?>?> {
    override fun resolve(reference: MonkeyReference, incompleteCode: Boolean): List<PsiElement?> {
        // for some reason, aa.bb() reference for bb in param info, has canonical text ".bb" instead of bb
        // finding the child gives the correct reference
        val references = PsiTreeUtil.getChildrenOfType(reference, MonkeyReference::class.java)
        return if (!references.isNullOrEmpty()) {
            val reference1 = references[0]
            resolveSimpleReference(reference1, reference1.canonicalText)
        } else {
            resolveSimpleReference(reference, reference.canonicalText)
        }
    }

    companion object {
        val INSTANCE = MonkeyResolver()
        fun resolveSimpleReference(scopeElement: PsiElement, name: String): List<PsiElement?> {
            val result: MutableList<MonkeyComponentName> = ArrayList()
            // local
            val resolveProcessor = MonkeyResolveProcessor(result, name)
            PsiTreeUtil.treeWalkUp(resolveProcessor, scopeElement, null, ResolveState.initial())

            // global
            if (result.isEmpty()) {
                //GlobalSearchScope resolveScope = scopeElement.getResolveScope();
                val project = scopeElement.project
                val filter1 = GlobalSearchScope.allScope(project)
                val sourceFiles =
                    FileBasedIndex.getInstance().getContainingFiles(FileTypeIndex.NAME, MonkeyFileType, filter1)
                for (sourceFile in sourceFiles) {
                    val monkeyFile = PsiManager.getInstance(project).findFile(sourceFile!!) as MonkeyFile?
                    if (monkeyFile != null) {
                        val resolveProcessor2 = MonkeyResolveProcessor(result, name)
                        PsiTreeUtil.treeWalkUp(resolveProcessor2, monkeyFile, null, ResolveState.initial())
                    }
                }
            }

            // todo: add super, global, etc (check monkey c docs for order)

            /*
    Scoping
    Monkey C is a message-passed language. When a function is called, the virtual machine does a look up operation
    at runtime to find the function being called. Here is the hierarchy that it will search:

    1. Instance members of the class
    2. Members of the superclass
    3. Static members of the class
    4. Members of the parent module, and the parent modules up to the global namespace
    5. Members of the superclass’s parent module up to the global namespace
    */

            // You can bring a module into your scoping level with the using keyword.
            // using allows a module to be imported into another class or module by a symbol.
            // using statements are scoped to the class or module in which they are defined.
            return result
        }
    }
}

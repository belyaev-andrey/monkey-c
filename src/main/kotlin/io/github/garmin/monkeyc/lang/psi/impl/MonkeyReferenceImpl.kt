package io.github.garmin.monkeyc.lang.psi.impl

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.util.UnfairTextRange
import com.intellij.psi.*
import com.intellij.psi.impl.source.resolve.ResolveCache
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import io.github.garmin.monkeyc.lang.psi.MonkeyId
import io.github.garmin.monkeyc.lang.psi.MonkeyReference
import io.github.garmin.monkeyc.lang.psi.util.MonkeyElementGenerator.createIdentifierFromText
import io.github.garmin.monkeyc.lang.resolve.MonkeyResolver

open class MonkeyReferenceImpl(node: ASTNode?) : MonkeyExpressionImpl(node), MonkeyReference, PsiPolyVariantReference {
    override fun getElement(): PsiElement {
        return this
    }

    override fun getReference(): PsiReference? {
        return this
    }

    override fun getRangeInElement(): TextRange {
        val textRange = textRange
        val references = PsiTreeUtil.getChildrenOfType(this, MonkeyReference::class.java)
        if (!references.isNullOrEmpty()) {
            val lastReferenceRange = references[references.size - 1].textRange
            return UnfairTextRange(
                lastReferenceRange.startOffset - textRange.startOffset,
                lastReferenceRange.endOffset - textRange.endOffset
            )
        }
        return UnfairTextRange(0, textRange.endOffset - textRange.startOffset)
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(true)
        return if (resolveResults.isEmpty() || resolveResults.size > 1 ||
            !resolveResults[0].isValidResult
        ) null else resolveResults[0].element
    }

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        val elements = ResolveCache.getInstance(getProject())
            .resolveWithCaching(this, MonkeyResolver.INSTANCE, true, incompleteCode)!!
        //return MonkeyResolveUtil.toCandidateInfoArray(elements);
        return PsiElementResolveResult.createResults(elements)
    }

    override fun getCanonicalText(): String {
        return text
    }

    @Throws(IncorrectOperationException::class)
    override fun handleElementRename(newElementName: String): PsiElement {
        var element: PsiElement = this
        if (text.indexOf('.') != -1) {
            // libPrefix.name
            val lastChild = lastChild
            element = lastChild ?: this
        }
        val identifier = PsiTreeUtil.getChildOfType(element, MonkeyId::class.java)
        val identifierNew = createIdentifierFromText(getProject(), newElementName)
        if (identifier != null && identifierNew != null) {
            element.node.replaceChild(identifier.node, identifierNew.node)
        }
        return this
    }

    @Throws(IncorrectOperationException::class)
    override fun bindToElement(element: PsiElement): PsiElement {
        return this
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        val references = PsiTreeUtil.getChildrenOfType(this, MonkeyReference::class.java)
        val chain = references != null && references.size == 2
        if (chain) {
            return false
        }
        val target = resolve()
        return target === element
    }

    override fun getVariants(): Array<Any> {
        return emptyArray()
    }

    override fun isSoft(): Boolean {
        return false
    }
}

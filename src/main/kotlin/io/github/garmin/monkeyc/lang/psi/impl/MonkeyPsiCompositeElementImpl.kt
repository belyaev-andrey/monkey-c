package io.github.garmin.monkeyc.lang.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import com.intellij.psi.tree.IElementType
import gnu.trove.THashSet
import io.github.garmin.monkeyc.lang.psi.*

open class MonkeyPsiCompositeElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MonkeyPsiCompositeElement {
    private val tokenType: IElementType
        get() = node.elementType

    override fun toString(): String {
        return tokenType.toString()
    }

    override fun processDeclarations(
        processor: PsiScopeProcessor,
        state: ResolveState,
        lastParent: PsiElement?,
        place: PsiElement
    ): Boolean {
        return (processDeclarationsImpl(this, processor, state)
                && super.processDeclarations(processor, state, lastParent, place))
    }

    companion object {
        fun processDeclarationsImpl(
            context: PsiElement?,
            processor: PsiScopeProcessor,
            state: ResolveState?
        ): Boolean {
            if (context == null) {
                return true
            }
            for (element in getDeclarationElementToProcess(context)) {
                if (!processor.execute(element!!, state!!)) {
                    return false
                }
            }
            return true
        }

        private fun getDeclarationElementToProcess(context: PsiElement): Set<MonkeyComponentName?> {
            val result: MutableSet<MonkeyComponentName?> = THashSet()
            for (child in context.children) {
                when (child) {
                    is MonkeyUsingDeclaration -> {
                        if (child.getComponentName() != null) {
                            result.add(child.getComponentName())
                        }
                    }

                    is MonkeyModuleDeclaration -> {
                        val moduleBodyMembers = child.getModuleBody()!!.getModuleBodyMembers()
                        if (moduleBodyMembers != null) {
                            val moduleChildrenNames =
                                getDeclarationElementToProcess(moduleBodyMembers) // moduleBodyMembers.getChildren() will contain stuff
                            result.addAll(moduleChildrenNames)
                        }
                        result.add(child.getComponentName())
                    }

                    is MonkeyClassDeclaration -> {
                        if (child.getBodyMembers() != null) {
                            val classChildrenNames = getDeclarationElementToProcess(
                                child.getBodyMembers()!!
                            )
                            result.addAll(classChildrenNames)
                        }
                        result.add(child.getComponentName())
                    }

                    is MonkeyEnumDeclaration -> {
                        val enumConstantList = child.getEnumConstantList()
                        for (monkeyEnumConstant in enumConstantList) {
                            result.add(monkeyEnumConstant.getComponentName())
                        }
                    }

                    is MonkeyTypeDefinition -> {
                        result.add(child.componentName)
                    }

                    is MonkeyFieldDeclarationList -> {
                        for (fieldDeclaration in child.getFieldDeclarationList()) {
                            result.add(fieldDeclaration.getComponentName())
                        }
                    }

                    is MonkeyFormalParameterDeclarations -> {
                        for (monkeyComponentName in child.getComponentNameList()) {
                            result.add(monkeyComponentName)
                        }
                    }
                    // TODO: there must be some other way...
                    is MonkeyBlock -> {
                        val blockStatementList = child.getBlockStatementList()
                        for (monkeyBlockStatement in blockStatementList) {
                            val variableDeclarationList = monkeyBlockStatement.getVariableDeclarationList()
                            if (variableDeclarationList != null) {
                                for (monkeyVariableDeclaration in variableDeclarationList.getVariableDeclarationList()) {
                                    result.add(monkeyVariableDeclaration.getComponentName())
                                }
                            }
                        }
                    }

                    is MonkeyComponent -> {
                        result.add(child.getComponentName())
                    }
                }
            }
            return result
        }
    }
}
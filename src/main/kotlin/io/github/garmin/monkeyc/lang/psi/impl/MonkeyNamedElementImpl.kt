package io.github.garmin.monkeyc.lang.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import io.github.garmin.monkeyc.lang.psi.MonkeyId
import io.github.garmin.monkeyc.lang.psi.MonkeyNamedElement
import io.github.garmin.monkeyc.lang.psi.util.MonkeyElementGenerator.createIdentifierFromText

abstract class MonkeyNamedElementImpl(node: ASTNode) : MonkeyPsiCompositeElementImpl(node), MonkeyNamedElement {
    override fun getName(): String? {
        return getId().text
    }

    // if reference/declaration is renamed, then this is called on all references and declaration
    @Throws(IncorrectOperationException::class)
    override fun setName(newElementName: String): PsiElement {
        val identifier = getId()
        val identifierNew = createIdentifierFromText(getProject(), newElementName)
        if (identifierNew != null) {
            node.replaceChild(identifier.node, identifierNew.node)
        }
        return this
    }

    override fun getPresentation(): ItemPresentation? {
        val parent = parent
        return if (parent is NavigationItem) {
            (parent as NavigationItem).presentation
        } else null
    }

    override fun getNameIdentifier(): PsiElement? {
        return this
    }

    override fun getId(): MonkeyId {
        return PsiTreeUtil.getRequiredChildOfType(this, MonkeyId::class.java)
    }

    override fun toString(): String {
        return "MonkeyComponentName:$name"
    }
}

package io.github.garmin.monkeyc.lang.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import io.github.garmin.monkeyc.lang.psi.MonkeyDocComment

class MonkeyDocCommentImpl(node: ASTNode) : ASTWrapperPsiElement(node), MonkeyDocComment {
    override fun getOwner(): PsiElement? {
        val parent = parent

        // TODO: implement
        return null
    }

    override fun getTokenType(): IElementType {
        return node.elementType
    }
}

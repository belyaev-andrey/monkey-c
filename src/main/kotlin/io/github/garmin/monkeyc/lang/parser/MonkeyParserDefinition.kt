package io.github.garmin.monkeyc.lang.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import io.github.garmin.monkeyc.lang.MonkeyCLanguage
import io.github.garmin.monkeyc.lang.lexer.MonkeyLexerAdapter
import io.github.garmin.monkeyc.lang.psi.MonkeyFile
import io.github.garmin.monkeyc.lang.psi.MonkeyTypes
import io.github.garmin.monkeyc.lang.psi.impl.MonkeyDocCommentImpl

class MonkeyParserDefinition: ParserDefinition {

    companion object {
        val FILE = IFileElementType(MonkeyCLanguage)
    }

    override fun createLexer(project: Project?): Lexer {
        return MonkeyLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return MonkeyParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getWhitespaceTokens(): TokenSet {
        return MonkeyTokenTypesSets.WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return MonkeyTokenTypesSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return MonkeyTokenTypesSets.STRINGS
    }

    override fun createElement(node: ASTNode): PsiElement {
        return if (node.elementType === MonkeyTypes.SINGLE_LINE_DOC_COMMENT) {
            MonkeyDocCommentImpl(node)
        } else MonkeyTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return MonkeyFile(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }
}
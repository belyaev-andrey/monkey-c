package io.github.garmin.monkeyc.lang.parser

import com.intellij.psi.TokenType
import com.intellij.psi.tree.TokenSet
import io.github.garmin.monkeyc.lang.psi.MonkeyTypes

interface MonkeyTokenTypesSets {
    companion object {
        val STRINGS = TokenSet.create(MonkeyTypes.STRING, MonkeyTypes.CHARLITERAL)
        val COMMENTS = TokenSet.create(
            MonkeyTypes.SINGLE_LINE_COMMENT,
            MonkeyTypes.SINGLE_LINE_DOC_COMMENT,
            MonkeyTypes.BLOCK_COMMENT
        )
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val BUILT_IN_IDENTIFIERS = TokenSet.create(
            MonkeyTypes.AND,
            MonkeyTypes.AS,
            MonkeyTypes.BLING,
            MonkeyTypes.CATCH,
            MonkeyTypes.CASE,
            MonkeyTypes.CLASS,
            MonkeyTypes.CONST,
            MonkeyTypes.DO,
            MonkeyTypes.DEFAULT,
            MonkeyTypes.ELSE,
            MonkeyTypes.ENUM,
            MonkeyTypes.EXTENDS,
            MonkeyTypes.FALSE,
            MonkeyTypes.FINALLY,
            MonkeyTypes.FOR,
            MonkeyTypes.FUNCTION,
            MonkeyTypes.HAS,
            MonkeyTypes.HIDDEN,
            MonkeyTypes.IF,
            MonkeyTypes.IMPORT,
            MonkeyTypes.INSTANCEOF,
            MonkeyTypes.MODULE,
            MonkeyTypes.NATIVE,
            MonkeyTypes.NEW,
            MonkeyTypes.NULL,
            MonkeyTypes.OR,
            MonkeyTypes.RETURN,
            MonkeyTypes.SELF,
            MonkeyTypes.STATIC,
            MonkeyTypes.SWITCH,
            MonkeyTypes.THIS,
            MonkeyTypes.THROW,
            MonkeyTypes.TRUE,
            MonkeyTypes.TRY,
            MonkeyTypes.TYPEDEF,
            MonkeyTypes.USING,
            MonkeyTypes.VAR,
            MonkeyTypes.WHILE
        )
    }
}

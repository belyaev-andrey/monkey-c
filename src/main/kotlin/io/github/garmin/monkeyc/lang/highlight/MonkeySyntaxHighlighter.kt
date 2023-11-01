package io.github.garmin.monkeyc.lang.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import io.github.garmin.monkeyc.lang.lexer.MonkeyCLexer
import io.github.garmin.monkeyc.lang.parser.MonkeyTokenTypesSets
import io.github.garmin.monkeyc.lang.psi.MonkeyTypes
import java.util.*

class MonkeySyntaxHighlighter: SyntaxHighlighterBase() {


    override fun getHighlightingLexer(): Lexer {
        return MonkeyCLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return pack(TYPE_KEY_MAP[tokenType])
    }

    companion object {

        private val MC_LINE_COMMENT =
            TextAttributesKey.createTextAttributesKey("MC.LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        private val MC_LINE_DOC_COMMENT =
            TextAttributesKey.createTextAttributesKey("MC.LINE_DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT)
        private val MC_BLOCK_COMMENT =
            TextAttributesKey.createTextAttributesKey("MC.BLOCK_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        private val MC_CLASS_NAME =
            TextAttributesKey.createTextAttributesKey("MC.CLASS_NAME", DefaultLanguageHighlighterColors.CLASS_NAME)
        private val MC_FUNCTION_DECLARATION = TextAttributesKey.createTextAttributesKey(
            "MC.FUNCTION_DECLARATION",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION
        )
        private val MC_KEYWORD = TextAttributesKey.createTextAttributesKey("MC.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        private val MC_OPERATOR =
            TextAttributesKey.createTextAttributesKey("MC.OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        private val MC_STRING = TextAttributesKey.createTextAttributesKey("MC.STRING", DefaultLanguageHighlighterColors.STRING)
        private val MC_NUMBER = TextAttributesKey.createTextAttributesKey("MC.NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        private val MC_SYMBOL = TextAttributesKey.createTextAttributesKey("MC.MC_SYMBOL", DefaultLanguageHighlighterColors.METADATA)
        private val MC_CONSTANT =
            TextAttributesKey.createTextAttributesKey("MC.CONSTANT", DefaultLanguageHighlighterColors.CONSTANT)

        private val OPERATOR_TOKENS = TokenSet.create(
                MonkeyTypes.PLUS,
                MonkeyTypes.SUB,
                MonkeyTypes.STAR,
                MonkeyTypes.SLASH
            )

        private val NUMBER_LITERALS = TokenSet.create(
                MonkeyTypes.INTLITERAL,
                MonkeyTypes.LONGLITERAL,
                MonkeyTypes.FLOATLITERAL,
                MonkeyTypes.DOUBLELITERAL,
                MonkeyTypes.HEX_LITERAL
            )

        val TYPE_KEY_MAP: Map<IElementType, TextAttributesKey> = createTypeKeyMap()

        private fun createTypeKeyMap(): Map<IElementType, TextAttributesKey> {
            val aMap: MutableMap<IElementType, TextAttributesKey> = HashMap()
            fillMap(aMap, MonkeyTokenTypesSets.BUILT_IN_IDENTIFIERS, MC_KEYWORD)
            fillMap(aMap, OPERATOR_TOKENS, MC_OPERATOR)
            fillMap(aMap, MonkeyTokenTypesSets.STRINGS, MC_STRING)
            fillMap(aMap, NUMBER_LITERALS, MC_NUMBER)
            aMap[MonkeyTypes.SINGLE_LINE_COMMENT] = MC_LINE_COMMENT
            aMap[MonkeyTypes.SINGLE_LINE_DOC_COMMENT] = MC_LINE_DOC_COMMENT
            aMap[MonkeyTypes.BLOCK_COMMENT] = MC_BLOCK_COMMENT
            return Collections.unmodifiableMap(aMap)
        }
    }
}
package io.github.garmin.monkeyc.ide.settings

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import io.github.garmin.monkeyc.ide.i18n.MsgBundle
import io.github.garmin.monkeyc.ide.icons.MonkeyIcons
import io.github.garmin.monkeyc.lang.highlight.MonkeySyntaxHighlighter
import javax.swing.Icon

class MonkeyCColorSettingsPage: ColorSettingsPage {

    private val attributesDescriptors : Array<AttributesDescriptor> = arrayOf(
        AttributesDescriptor(MsgBundle.message("ide.settings.color.keyword"), MonkeySyntaxHighlighter.MC_KEYWORD),
        AttributesDescriptor(MsgBundle.message("ide.settings.color.line.comment"), MonkeySyntaxHighlighter.MC_LINE_COMMENT)
        //TODO add other categories
    )


    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return attributesDescriptors
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return MsgBundle.message("monkey.c")
    }

    override fun getIcon(): Icon? {
        return MonkeyIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return MonkeySyntaxHighlighter()
    }

    override fun getDemoText(): String {
        //TODO improve text
        return """
            class Circle
            {
                protected var mRadius;
                public function initialize( aRadius ) {
                  mRadius = aRadius;
                }
            }

            function createCircle() {
                var c = new Circle( 1.5 );
            }
        """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }
}
package io.github.garmin.monkeyc.lang.highlight

import com.intellij.codeInsight.CodeInsightUtilCore
import com.intellij.codeInsight.daemon.JavaErrorBundle
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.EditorColorsManager
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementVisitor
import io.github.garmin.monkeyc.lang.psi.MonkeyAnnotation
import io.github.garmin.monkeyc.lang.psi.MonkeyConstDeclaration
import io.github.garmin.monkeyc.lang.psi.MonkeyLiteral
import io.github.garmin.monkeyc.lang.psi.MonkeySymbol

class MonkeySyntaxAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        element.accept(object : PsiRecursiveElementVisitor() {
            override fun visitElement(element: PsiElement) {
                when (element) {
                    is MonkeyAnnotation -> {
                        AnnotatorUtils.highlightPsiElement(holder, MonkeySyntaxHighlighter.MC_SYMBOL)
                    }

                    is MonkeyConstDeclaration -> {
                        annotateConst(element)
                    }

                    is MonkeyLiteral -> {
                        annotateLiteral(element)
                    }
                }
            }

            private fun annotateLiteral(element: MonkeyLiteral) {
                val monkeyLiteral: MonkeyLiteral = element
                val charLiteral: PsiElement? = monkeyLiteral.getCharliteral()
                if (charLiteral != null) {
                    AnnotatorUtils.annotateCharLiteral(holder, charLiteral)
                }
            }

            private fun annotateConst(element: MonkeyConstDeclaration) {
                // TODO: would be nice to highlight usage (reference) as well
                val monkeyConstDeclaration: MonkeyConstDeclaration = element
                val componentName = monkeyConstDeclaration.getComponentName()
                if (componentName != null) {
                    AnnotatorUtils.highlightPsiElement(
                        holder,
                        MonkeySyntaxHighlighter.MC_CONSTANT
                    )
                }
            }
        })
    }

    object AnnotatorUtils {
        fun highlightPsiElement(holder: AnnotationHolder, colorKey: TextAttributesKey) {
            val textAttributes = EditorColorsManager.getInstance().globalScheme.getAttributes(colorKey)
             holder.newAnnotation(HighlightSeverity.INFORMATION, "")
                 .enforcedTextAttributes(textAttributes)
                 .create()
        }

        fun annotateCharLiteral(holder: AnnotationHolder, charLiteral: PsiElement) {
            val text: String = charLiteral.text
            if (text.length >= 2) {
                if (text.startsWith("'") && text.endsWith("'")) {
                    val withoutQuotes = text.substring(1, text.length - 1)
                    val chars = StringBuilder()
                    val success = CodeInsightUtilCore.parseStringCharacters(withoutQuotes, chars, null)
                    if (!success) {
                        val message: String = JavaErrorBundle.message("illegal.escape.character.in.character.literal")
                        holder.newAnnotation(HighlightSeverity.ERROR, message).create()

                    }
                    val length = chars.length
                    if (length > 1) {
                        val message: String = JavaErrorBundle.message("too.many.characters.in.character.literal")
                        holder.newAnnotation(HighlightSeverity.ERROR, message).create()
                    } else if (length == 0) {
                        val message: String = JavaErrorBundle.message("empty.character.literal")
                        holder.newAnnotation(HighlightSeverity.ERROR, message).create()
                    }
                }
            }
        }
    }

}
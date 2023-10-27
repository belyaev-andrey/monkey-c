package io.github.garmin.monkeyc.lang.resolve

import com.intellij.icons.AllIcons
import com.intellij.psi.PsiElement
import io.github.garmin.monkeyc.lang.psi.*
import javax.swing.Icon

enum class MonkeyComponentType(private val myIcon: Icon) {
    MODULE(AllIcons.Nodes.Package),
    CLASS(AllIcons.Nodes.Class),
    FUNCTION(AllIcons.Nodes.Function),
    PARAMETER(AllIcons.Nodes.Parameter),
    FIELD(AllIcons.Nodes.Field),
    CONSTANT(AllIcons.Nodes.Field),
    ENUM(AllIcons.Nodes.Enum),
    VARIABLE(AllIcons.Nodes.Variable);

    companion object {
        fun typeOf(element: PsiElement?): MonkeyComponentType? {
            if (element is MonkeyComponentName) {
                return typeOf(element.getParent())
            }
            if (element is MonkeyModuleDeclaration) {
                return MODULE
            }
            if (element is MonkeyClass) {
                return CLASS
            }
            if (element is MonkeyFunctionDeclaration) {
                return FUNCTION
            }
            if (element is MonkeyFormalParameterDeclarations) {
                return PARAMETER
            }
            if (element is MonkeyFieldDeclaration) {
                return FIELD
            }
            if (element is MonkeyConstDeclaration) {
                return CONSTANT
            }
            if (element is MonkeyEnumConstant) {
                return ENUM
            }
            return if (element is MonkeyVariableDeclaration) {
                VARIABLE
            } else null
        }
    }
}

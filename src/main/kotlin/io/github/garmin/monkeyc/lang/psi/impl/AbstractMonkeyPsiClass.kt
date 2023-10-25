package io.github.garmin.monkeyc.lang.psi.impl

import com.intellij.lang.ASTNode
import io.github.garmin.monkeyc.lang.psi.MonkeyClass
import io.github.garmin.monkeyc.lang.psi.MonkeyClassBodyMembers
import io.github.garmin.monkeyc.lang.psi.MonkeyClassDeclaration

abstract class AbstractMonkeyPsiClass(node: ASTNode) : AbstractMonkeyComponentImpl(node), MonkeyClass {
    override fun getBodyMembers(): MonkeyClassBodyMembers? {
        if (this is MonkeyClassDeclaration) {
            val monkeyClassDeclaration = this as MonkeyClassDeclaration
            val classBody = monkeyClassDeclaration.getClassBody()
            if (classBody != null) {
                return classBody.getClassBodyMembers()
            }
        }
        return null
    }

    override fun toString(): String {
        return "MonkeyClassDeclaration:" + getName()
    }
}

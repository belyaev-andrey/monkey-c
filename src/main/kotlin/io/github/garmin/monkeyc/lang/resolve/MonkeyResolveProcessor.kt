package io.github.garmin.monkeyc.lang.resolve

import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import io.github.garmin.monkeyc.lang.psi.MonkeyComponentName

/**
 * Gathers declarations for reference
 */
class MonkeyResolveProcessor(private val myResult: MutableList<MonkeyComponentName>, private val myName: String) : PsiScopeProcessor {
    override fun execute(element: PsiElement, state: ResolveState): Boolean {
        if (element !is MonkeyComponentName) return true
        val componentName = element
        val parentElement = componentName.parent
        if (myName == componentName.name) {
            myResult.add(componentName)
            return false
        }
        return true
    }

    companion object {
        private fun isMember(componentType: MonkeyComponentType?): Boolean {
            return componentType == MonkeyComponentType.FIELD
        }
    }
}

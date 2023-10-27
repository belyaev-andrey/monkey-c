package io.github.garmin.monkeyc.lang.resolve

import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import io.github.garmin.monkeyc.lang.psi.MonkeyComponentName

class ComponentNameScopeProcessor(private val myResult: MutableSet<MonkeyComponentName>) : PsiScopeProcessor {
    override fun execute(element: PsiElement, state: ResolveState): Boolean {
        val componentName = element as MonkeyComponentName
        myResult.add(componentName)
        return true
    }
}

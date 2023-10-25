package io.github.garmin.monkeyc.lang.psi

import com.intellij.psi.PsiNameIdentifierOwner

interface MonkeyComponent: MonkeyPsiCompositeElement, PsiNameIdentifierOwner {

    fun getComponentName(): MonkeyComponentName?

}
package io.github.garmin.monkeyc.lang.psi

import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement

interface MonkeyNamedElement: MonkeyPsiCompositeElement, PsiNamedElement, NavigationItem,
    PsiNameIdentifierOwner {

        fun getId(): MonkeyId
}
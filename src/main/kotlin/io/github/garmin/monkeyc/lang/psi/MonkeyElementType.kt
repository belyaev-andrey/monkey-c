package io.github.garmin.monkeyc.lang.psi

import com.intellij.psi.tree.IElementType
import io.github.garmin.monkeyc.lang.MonkeyCLanguage
import org.jetbrains.annotations.NonNls

class MonkeyElementType(@NonNls debugName: String): IElementType(debugName, MonkeyCLanguage) {

}
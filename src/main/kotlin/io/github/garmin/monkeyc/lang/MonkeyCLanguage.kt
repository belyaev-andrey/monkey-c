package io.github.garmin.monkeyc.lang

import com.intellij.lang.Language
import io.github.garmin.monkeyc.ide.i18n.MsgBundle

object MonkeyCLanguage: Language("MonkeyC") {

    override fun getDisplayName(): String = MsgBundle.message("monkey.c")

    override fun isCaseSensitive(): Boolean = true

}
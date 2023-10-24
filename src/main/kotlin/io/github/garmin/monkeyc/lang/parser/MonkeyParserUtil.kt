package io.github.garmin.monkeyc.lang.parser

import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import io.github.garmin.monkeyc.lang.psi.MonkeyTypes

object MonkeyParserUtil: GeneratedParserUtilBase() {

    fun strictID(builder_: PsiBuilder, level_: Int): Boolean {
        val marker_ = builder_.mark()
        val result_: Boolean = consumeToken(builder_, MonkeyTypes.IDENTIFIER)
        if (result_) {
            marker_.done(MonkeyTypes.ID)
            return true
        }
        marker_.rollbackTo()
        return false
    }

}
package io.github.garmin.monkeyc.lang.file

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import io.github.garmin.monkeyc.ide.i18n.MsgBundle
import io.github.garmin.monkeyc.ide.icons.MonkeyIcons
import io.github.garmin.monkeyc.lang.MonkeyCLanguage
import javax.swing.Icon

object MonkeyFileType : LanguageFileType(MonkeyCLanguage) {

    override fun getName(): String = MsgBundle.message("monkey.c")

    override fun getDescription(): String = MsgBundle.message("monkey.c.source.file")

    override fun getDefaultExtension(): String = "mc"

    override fun getIcon(): Icon = MonkeyIcons.FILE

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

}
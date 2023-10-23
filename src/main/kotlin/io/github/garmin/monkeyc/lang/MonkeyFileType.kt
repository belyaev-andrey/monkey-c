package io.github.garmin.monkeyc.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import io.github.garmin.monkeyc.ide.i18n.MsgBundle
import io.github.garmin.monkeyc.ide.icons.MonkeyIcons
import javax.swing.Icon

class MonkeyFileType : LanguageFileType(MonkeyCLanguage) {

    override fun getName(): String = MsgBundle.message("monkey.c")

    override fun getDescription(): String = MsgBundle.message("monkey.c.source.file")

    override fun getDefaultExtension(): String = "mc"

    override fun getIcon(): Icon = MonkeyIcons.FILE

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

}
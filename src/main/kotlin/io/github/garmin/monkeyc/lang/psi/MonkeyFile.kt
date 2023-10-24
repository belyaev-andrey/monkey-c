package io.github.garmin.monkeyc.lang.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.ResolveState
import com.intellij.psi.scope.PsiScopeProcessor
import io.github.garmin.monkeyc.ide.i18n.MsgBundle
import io.github.garmin.monkeyc.lang.MonkeyCLanguage
import io.github.garmin.monkeyc.lang.file.MonkeyFileType

class MonkeyFile(viewProvider: FileViewProvider): PsiFileBase(viewProvider, MonkeyCLanguage) {

    override fun getFileType(): FileType {
        return MonkeyFileType
    }

    override fun toString(): String {
        return buildString {
            append(MsgBundle.messageWithColon("monkey.c.file"))
            append(" ")
            append(name)
        }
    }

    override fun processDeclarations(
        processor: PsiScopeProcessor,
        state: ResolveState,
        lastParent: PsiElement?,
        place: PsiElement
    ): Boolean {
        //TODO implement properly
        return super.processDeclarations(processor, state, lastParent, place)
    }
}
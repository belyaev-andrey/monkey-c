package io.github.garmin.monkeyc.ide.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import icons.MonkeyIcons
import io.github.garmin.monkeyc.ide.i18n.MsgBundle

class CreateMonkeyFileAction: CreateFileFromTemplateAction(MsgBundle.message("monkey.c.file"),
    MsgBundle.message("monkey.c.file"), MonkeyIcons.FILE) {

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle(MsgBundle.message("new.monkey.c.file"))
            .addKind(MsgBundle.message("monkey.c.file"), MonkeyIcons.FILE, "Monkey C File.mc")
    }

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String {
        return MsgBundle.message("create.monkey.c.file.new.name");
    }
}
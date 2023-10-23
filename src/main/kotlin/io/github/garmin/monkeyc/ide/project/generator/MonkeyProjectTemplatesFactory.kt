package io.github.garmin.monkeyc.ide.project.generator

import com.intellij.ide.util.projectWizard.AbstractModuleBuilder
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.platform.ProjectTemplate
import com.intellij.platform.ProjectTemplatesFactory
import io.github.garmin.monkeyc.ide.icons.MonkeyIcons
import io.github.garmin.monkeyc.ide.i18n.MsgBundle
import io.github.garmin.monkeyc.ide.project.module.AppType
import io.github.garmin.monkeyc.ide.project.module.MonkeyModuleBuilder
import javax.swing.Icon

class MonkeyProjectTemplatesFactory: ProjectTemplatesFactory() {

    override fun getGroups(): Array<String> {
        return arrayOf(MsgBundle.message("connect.iq"))
    }

    override fun createTemplates(group: String?, context: WizardContext): Array<ProjectTemplate> {
        return arrayOf(
            MonkeyProjectTemplate(
                MsgBundle.message("app.type.watch.app"),
                MsgBundle.message("app.type.watch.app.description"),
                MonkeyModuleBuilder(AppType.WATCH_APP)
            ),
            MonkeyProjectTemplate(
                MsgBundle.message("app.type.widget"),
                MsgBundle.message("app.type.widget.description"),
                MonkeyModuleBuilder(AppType.WIDGET)
            ),
            MonkeyProjectTemplate(
                MsgBundle.message("app.type.data.field"),
                MsgBundle.message("app.type.data.field.description"),
                MonkeyModuleBuilder(AppType.DATA_FIELD)
            ),
            MonkeyProjectTemplate(
                MsgBundle.message("app.type.watch.face"),
                MsgBundle.message("app.type.watch.face.description"),
                MonkeyModuleBuilder(AppType.WATCH_FACE)
            )
        )
    }

    override fun getGroupIcon(group: String?): Icon {
        return MonkeyIcons.MODULE16
    }
}

private class MonkeyProjectTemplate(private val name: String,
                            private val description: String?,
                            private val moduleBuilder: MonkeyModuleBuilder) : ProjectTemplate {
    override fun getName(): String {
        return name;
    }

    override fun getDescription(): String? {
        return description
    }

    override fun getIcon(): Icon {
        return moduleBuilder.nodeIcon
    }

    override fun createModuleBuilder(): AbstractModuleBuilder {
        return moduleBuilder
    }

    @Deprecated("Deprecated in Java SDK", ReplaceWith("No replacement yet"))
    override fun validateSettings(): ValidationInfo? {
        return null
    }

}


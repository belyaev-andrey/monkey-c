package io.github.garmin.monkeyc.ide.project.generator

import com.intellij.ide.util.projectWizard.ModuleWizardStep
import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.ui.dsl.builder.panel
import io.github.garmin.monkeyc.ide.project.module.MonkeyModuleBuilder
import javax.swing.JComponent

class MonkeyApplicationModifiedSettingsStep(val moduleBuilder: MonkeyModuleBuilder,
                                            val context: WizardContext): ModuleWizardStep()  {

    override fun getComponent(): JComponent {
        return panel {
            row {
                label("Test panel")
            }
        }
    }

    override fun updateDataModel() {

    }
}
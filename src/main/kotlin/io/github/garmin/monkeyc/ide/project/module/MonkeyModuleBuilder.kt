package io.github.garmin.monkeyc.ide.project.module

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleBuilderListener
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType

class MonkeyModuleBuilder(val appType : AppType?) : ModuleBuilder(), ModuleBuilderListener {

    override fun getModuleType(): ModuleType<*> {
        return MonkeyModuleType.INSTANCE
    }

    override fun isAvailable(): Boolean {
        return false
    }

    override fun getBuilderId(): String {
        val builderId = moduleType.id
        // getBuilderId() is (besides other places) called in
        // com.intellij.ide.util.newProjectWizard.StepSequence.addStepsForBuilder() so it has to be unique per template
        if (appType != null) {
            return builderId+"_"+appType.typeId
        }
        return builderId
    }

    override fun moduleCreated(module: Module) {

    }
}
package io.github.garmin.monkeyc.ide.project.module

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.ide.util.projectWizard.ModuleBuilderListener
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleType

class MonkeyModuleBuilder(val appType : String?) : ModuleBuilder(), ModuleBuilderListener {

    override fun getModuleType(): ModuleType<*> {
        return MonkeyModuleType.getInstance()
    }

    override fun moduleCreated(module: Module) {

    }
}
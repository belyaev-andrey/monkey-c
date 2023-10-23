package io.github.garmin.monkeyc.ide.project.configuration

import com.intellij.openapi.module.ModuleConfigurationEditor
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationEditorProvider
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationState
import io.github.garmin.monkeyc.ide.project.module.MonkeyModuleType

class MonkeyModuleEditorsProvider: ModuleConfigurationEditorProvider {

    override fun createEditors(state: ModuleConfigurationState?): Array<ModuleConfigurationEditor> {
        val rootModel = state!!.modifiableRootModel
        val module = rootModel.module
        if (ModuleType.get(module) !is MonkeyModuleType) {
            return ModuleConfigurationEditor.EMPTY
        }

        val moduleName = module.name
        val editors: MutableList<ModuleConfigurationEditor> = ArrayList()
        editors.add(MonkeyContentEntriesEditor(moduleName, state))
        return editors.toTypedArray<ModuleConfigurationEditor>()
    }

}
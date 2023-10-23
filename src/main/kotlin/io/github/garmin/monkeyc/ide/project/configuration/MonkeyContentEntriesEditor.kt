package io.github.garmin.monkeyc.ide.project.configuration

import com.intellij.openapi.roots.ui.configuration.CommonContentEntriesEditor
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationState
import org.jetbrains.jps.model.java.JavaSourceRootType

class MonkeyContentEntriesEditor(moduleName: String, state: ModuleConfigurationState):
    CommonContentEntriesEditor(moduleName, state, JavaSourceRootType.SOURCE) {

}
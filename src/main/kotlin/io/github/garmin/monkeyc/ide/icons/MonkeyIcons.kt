package io.github.garmin.monkeyc.ide.icons

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.IconLoader
import com.intellij.ui.LayeredIcon
import javax.swing.Icon

object MonkeyIcons {

    private fun load(s: String): Icon {
        return IconLoader.getIcon(s, javaClass)
    }

    @JvmField
    val FILE: Icon = load("/icons/mc_file.png") // 16

    @JvmField
    val SDK: Icon = load("/icons/sdk.png") // 16

    @JvmField
    val ADD_SDK: Icon = load("/icons/addsdk.png") // 16

    @JvmField
    val MODULE24: Icon = load("/icons/module.png") // 24

    @JvmField
    val MODULE16: Icon = load("/icons/sdk.png") // 16

    @JvmField
    val MODULE_TEST_16: Icon = LayeredIcon(MODULE16, AllIcons.Nodes.JunitTestMark) // 16

    @JvmField
    val APP_SETTINGS13: Icon = load("/icons/app_settings_13.png") // 13

    @JvmField
    val SAVE16: Icon = load("/icons/saveTempConfig.png")

    @JvmField
    val REFRESH16 = AllIcons.Actions.Refresh

}
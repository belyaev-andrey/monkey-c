package io.github.garmin.monkeyc.ide.project.module

import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import icons.MonkeyIcons
import io.github.garmin.monkeyc.ide.i18n.MsgBundle
import javax.swing.Icon


class MonkeyModuleType : ModuleType<MonkeyModuleBuilder>(MonkeyConstants.MODULE_TYPE_ID) {

    companion object {
        fun getInstance() : MonkeyModuleType {
            return ModuleTypeManager.getInstance().findByID(MonkeyConstants.MODULE_TYPE_ID) as MonkeyModuleType
        }
    }

    override fun createModuleBuilder(): MonkeyModuleBuilder {
        return MonkeyModuleBuilder(null)
    }

    override fun getName(): String {
        return MsgBundle.message("monkey.c.module")
    }

    override fun getDescription(): String {
        return MsgBundle.message("monkey.c.module.description")
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return MonkeyIcons.MODULE16
    }
}
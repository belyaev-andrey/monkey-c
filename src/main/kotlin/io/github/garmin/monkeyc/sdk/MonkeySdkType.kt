package io.github.garmin.monkeyc.sdk

import com.intellij.openapi.projectRoots.*
import io.github.garmin.monkeyc.ide.i18n.MsgBundle
import io.github.garmin.monkeyc.ide.icons.MonkeyIcons
import io.github.garmin.monkeyc.ide.project.module.MonkeyConstants
import org.jdom.Element
import javax.swing.Icon

class MonkeySdkType: SdkType(MonkeyConstants.SDK_TYPE_ID) {

    override fun getIcon(): Icon {
        return MonkeyIcons.SDK
    }

    override fun saveAdditionalData(additionalData: SdkAdditionalData, additional: Element) {
        //TODO we don't need additional data yet
    }

    override fun suggestHomePath(): String? {
        TODO("Not yet implemented")
    }

    override fun isValidSdkHome(path: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun suggestSdkName(currentSdkName: String?, sdkHome: String): String {
        TODO("Not yet implemented")
    }

    override fun createAdditionalDataConfigurable(
        sdkModel: SdkModel,
        sdkModificator: SdkModificator
    ): AdditionalDataConfigurable? {
        return null //TODO we don't need additional data yet
    }

    override fun getPresentableName(): String {
        return MsgBundle.message("connect.iq.sdk")
    }
}
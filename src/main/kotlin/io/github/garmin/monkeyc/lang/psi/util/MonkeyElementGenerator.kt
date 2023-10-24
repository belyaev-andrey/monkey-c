package io.github.garmin.monkeyc.lang.psi.util

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.impl.PsiFileFactoryImpl
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.LightVirtualFile
import io.github.garmin.monkeyc.lang.MonkeyCLanguage
import io.github.garmin.monkeyc.lang.file.MonkeyFileType
import io.github.garmin.monkeyc.lang.psi.MonkeyComponent
import io.github.garmin.monkeyc.lang.psi.MonkeyId

object MonkeyElementGenerator {

    fun createIdentifierFromText(project: Project, name: String): MonkeyId? {
        val dummyFile: PsiFile = createDummyFile(project, "class $name {}")
        val monkeyComponent = PsiTreeUtil.getChildOfType(dummyFile, MonkeyComponent::class.java)
        val componentName = monkeyComponent?.getComponentName()
        return componentName?.getId()

    }

    private fun createDummyFile(
        project: Project,
        text: String
    ): PsiFile {
        val factory = PsiFileFactory.getInstance(project)
        val name = "dummy." + MonkeyFileType.getDefaultExtension()
        val virtualFile: LightVirtualFile =
            LightVirtualFile(name, MonkeyFileType, text)
        return (factory as PsiFileFactoryImpl).trySetupPsiForFile(virtualFile, MonkeyCLanguage, false, true)!!
    }


}
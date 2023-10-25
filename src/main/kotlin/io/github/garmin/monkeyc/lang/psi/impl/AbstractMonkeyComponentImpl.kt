package io.github.garmin.monkeyc.lang.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.util.IncorrectOperationException
import io.github.garmin.monkeyc.lang.psi.MonkeyComponent
import io.github.garmin.monkeyc.lang.psi.MonkeyComponentName
import javax.swing.Icon

abstract class AbstractMonkeyComponentImpl(node: ASTNode) : MonkeyPsiCompositeElementImpl(node), MonkeyComponent {

    override fun getName(): String? {
        val name = getComponentName()
        return name?.text ?: super.getName()
    }

    @Throws(IncorrectOperationException::class)
    override fun setName(name: String): PsiElement {
        getComponentName()?.setName(name)
        return this
    }

    override fun getNameIdentifier(): PsiElement? {
        return getComponentName()
    }

    override fun getPresentation(): ItemPresentation? {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return getName()
            }

            override fun getLocationString(): String? {
                return null
            }

            override fun getIcon(unused: Boolean): Icon? {
                return this@AbstractMonkeyComponentImpl.getIcon(0)
            }
        }
    }

    override fun getTextOffset(): Int {
        val name = getComponentName()
        return name?.textOffset ?: super.getTextOffset()
    }
}

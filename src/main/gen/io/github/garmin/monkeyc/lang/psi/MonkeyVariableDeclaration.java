// This is a generated file. Not intended for manual editing.
package io.github.garmin.monkeyc.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyVariableDeclaration extends MonkeyPsiCompositeElement {

  @Nullable
  MonkeyAsTypeClause getAsTypeClause();

  @NotNull
  MonkeyComponentName getComponentName();

  @Nullable
  MonkeyVariableInitializer getVariableInitializer();

}

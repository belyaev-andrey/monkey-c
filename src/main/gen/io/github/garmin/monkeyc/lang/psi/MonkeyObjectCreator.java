// This is a generated file. Not intended for manual editing.
package io.github.garmin.monkeyc.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyObjectCreator extends MonkeyPsiCompositeElement {

  @Nullable
  MonkeyArguments getArguments();

  @Nullable
  MonkeyClassBody getClassBody();

  @NotNull
  List<MonkeyExpression> getExpressionList();

}

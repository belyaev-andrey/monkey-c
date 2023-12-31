// This is a generated file. Not intended for manual editing.
package io.github.garmin.monkeyc.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyStatement extends MonkeyPsiCompositeElement {

  @Nullable
  MonkeyBlock getBlock();

  @Nullable
  MonkeyExpression getExpression();

  @Nullable
  MonkeyForStatement getForStatement();

  @NotNull
  List<MonkeyStatement> getStatementList();

  @Nullable
  MonkeySwitchBlockStatementGroups getSwitchBlockStatementGroups();

  @Nullable
  MonkeyTryStatement getTryStatement();

  @Nullable
  PsiElement getIdentifier();

}

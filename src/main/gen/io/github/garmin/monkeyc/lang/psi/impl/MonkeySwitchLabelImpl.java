// This is a generated file. Not intended for manual editing.
package io.github.garmin.monkeyc.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static io.github.garmin.monkeyc.lang.psi.MonkeyTypes.*;
import io.github.garmin.monkeyc.lang.psi.*;

public class MonkeySwitchLabelImpl extends MonkeyPsiCompositeElementImpl implements MonkeySwitchLabel {

  public MonkeySwitchLabelImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitSwitchLabel(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyExpression getExpression() {
    return findChildByClass(MonkeyExpression.class);
  }

  @Override
  @Nullable
  public MonkeyQualifiedName getQualifiedName() {
    return findChildByClass(MonkeyQualifiedName.class);
  }

}

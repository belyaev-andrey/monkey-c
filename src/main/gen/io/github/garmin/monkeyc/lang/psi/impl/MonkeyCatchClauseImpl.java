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

public class MonkeyCatchClauseImpl extends MonkeyPsiCompositeElementImpl implements MonkeyCatchClause {

  public MonkeyCatchClauseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitCatchClause(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MonkeyBlock getBlock() {
    return findNotNullChildByClass(MonkeyBlock.class);
  }

  @Override
  @NotNull
  public MonkeyCatchParameter getCatchParameter() {
    return findNotNullChildByClass(MonkeyCatchParameter.class);
  }

}

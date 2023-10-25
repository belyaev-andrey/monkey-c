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

public class MonkeyFunctionDeclarationImpl extends AbstractMonkeyComponentImpl implements MonkeyFunctionDeclaration {

  public MonkeyFunctionDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitFunctionDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyAsTypeClause getAsTypeClause() {
    return findChildByClass(MonkeyAsTypeClause.class);
  }

  @Override
  @Nullable
  public MonkeyBlock getBlock() {
    return findChildByClass(MonkeyBlock.class);
  }

  @Override
  @NotNull
  public MonkeyComponentName getComponentName() {
    return findNotNullChildByClass(MonkeyComponentName.class);
  }

  @Override
  @Nullable
  public MonkeyFormalParameterDeclarations getFormalParameterDeclarations() {
    return findChildByClass(MonkeyFormalParameterDeclarations.class);
  }

  @Override
  @NotNull
  public MonkeyModifiers getModifiers() {
    return findNotNullChildByClass(MonkeyModifiers.class);
  }

}

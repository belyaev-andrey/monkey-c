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

public class MonkeyVariableDeclarationListImpl extends MonkeyPsiCompositeElementImpl implements MonkeyVariableDeclarationList {

  public MonkeyVariableDeclarationListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitVariableDeclarationList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MonkeyVariableDeclaration> getVariableDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyVariableDeclaration.class);
  }

}

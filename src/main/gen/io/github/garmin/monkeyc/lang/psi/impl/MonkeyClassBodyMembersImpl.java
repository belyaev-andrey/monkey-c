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

public class MonkeyClassBodyMembersImpl extends MonkeyPsiCompositeElementImpl implements MonkeyClassBodyMembers {

  public MonkeyClassBodyMembersImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitClassBodyMembers(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<MonkeyClassDeclaration> getClassDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyClassDeclaration.class);
  }

  @Override
  @NotNull
  public List<MonkeyConstDeclaration> getConstDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyConstDeclaration.class);
  }

  @Override
  @NotNull
  public List<MonkeyEnumDeclaration> getEnumDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyEnumDeclaration.class);
  }

  @Override
  @NotNull
  public List<MonkeyFieldDeclarationList> getFieldDeclarationListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyFieldDeclarationList.class);
  }

  @Override
  @NotNull
  public List<MonkeyFunctionDeclaration> getFunctionDeclarationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyFunctionDeclaration.class);
  }

  @Override
  @NotNull
  public List<MonkeyMemberModifiers> getMemberModifiersList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, MonkeyMemberModifiers.class);
  }

}

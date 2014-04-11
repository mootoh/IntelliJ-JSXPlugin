package net.mootoh.intellij.JSXPlugin;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by takayama.motohiro on 4/11/14.
 */
public class JSXReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    public JSXReference(PsiElement psiElement, TextRange textRange) {
        super(psiElement, textRange);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        return null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return new Object[0];
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean b) {
        return new ResolveResult[0];
    }
}

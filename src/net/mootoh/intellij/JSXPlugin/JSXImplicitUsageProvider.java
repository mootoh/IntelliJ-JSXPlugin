package net.mootoh.intellij.JSXPlugin;

import com.intellij.codeInsight.daemon.ImplicitUsageProvider;
import com.intellij.psi.PsiElement;

/**
 * Created by takayama.motohiro on 4/7/14.
 */
public class JSXImplicitUsageProvider implements ImplicitUsageProvider {
    @Override
    public boolean isImplicitUsage(PsiElement psiElement) {
        return false;
    }

    @Override
    public boolean isImplicitRead(PsiElement psiElement) {
        return false;
    }

    @Override
    public boolean isImplicitWrite(PsiElement psiElement) {
        return false;
    }
}

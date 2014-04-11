package net.mootoh.intellij.JSXPlugin;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.*;

/**
 * Created by takayama.motohiro on 4/11/14.
 */
public class JSXReferenceContributor extends PsiReferenceContributor {
    @Override
    public void registerReferenceProviders(PsiReferenceRegistrar psiReferenceRegistrar) {
        psiReferenceRegistrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class), new PsiReferenceProvider() {
            @NotNull
            @Override
            public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement, @NotNull ProcessingContext processingContext) {
                PsiLiteralExpression literalExpression = (PsiLiteralExpression)psiElement;
                String text = (String)literalExpression.getValue();
                if (text != null && text.startsWith("jsx")) {
                    return new PsiReference[] { new JSXReference(psiElement, new TextRange(8, text.length() + 1))};
                }
                return new PsiReference[0];
            }
        });
    }
}

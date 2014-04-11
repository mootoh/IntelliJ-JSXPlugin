package net.mootoh.intellij.JSXPlugin;

import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.lexer.FlexAdapter;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.tree.TokenSet;
import net.mootoh.intellij.JSXPlugin.psi.JSXClass;
import net.mootoh.intellij.JSXPlugin.psi.JSXTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Reader;

/**
 * Created by takayama.motohiro on 4/11/14.
 */
public class JSXFindUsagesProvider implements FindUsagesProvider {
    static private WordsScanner WS = new DefaultWordsScanner(new FlexAdapter(new _JSXLexer((Reader)null)), TokenSet.create(JSXTypes.CLASS_DEFINITION, JSXTypes.LIDENTIFIER), TokenSet.create(JSXTypes.CLINE_COMMENT), TokenSet.EMPTY);
    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
//        return WS;
        return null;
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        boolean ret = psiElement instanceof PsiNamedElement;
        return ret;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return com.intellij.find.impl.HelpID.FIND_CLASS_USAGES;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement psiElement) {
        if (psiElement instanceof JSXClass) {
            return "jsx class";
        } else {
            return "";
        }
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement psiElement) {
        if (psiElement instanceof JSXClass) {
            return psiElement.getText();
        }
        return "";
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement psiElement, boolean b) {
        if (psiElement instanceof JSXClass) {
            return "JSX class : " + psiElement.getText();
        }
        return "";
    }
}

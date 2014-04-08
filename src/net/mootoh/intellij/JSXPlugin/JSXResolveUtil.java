package net.mootoh.intellij.JSXPlugin;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import net.mootoh.intellij.JSXPlugin.psi.JSXFile;

import java.util.Collections;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXResolveUtil {
    public static java.util.List<PsiElement> findJSXRoots(PsiFile psiFile) {
        /*
        if (psiFile instanceof XmlFile) {
            return findDartRootsInXml((XmlFile)psiFile);
        }
        */
        return psiFile instanceof JSXFile ? Collections.<PsiElement>singletonList(psiFile) : Collections.<PsiElement>emptyList();

    }
}

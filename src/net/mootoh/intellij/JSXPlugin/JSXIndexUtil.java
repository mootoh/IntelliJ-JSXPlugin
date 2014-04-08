package net.mootoh.intellij.JSXPlugin;

import com.intellij.openapi.util.Key;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.xml.XmlFile;
import com.intellij.util.indexing.FileContent;
import net.mootoh.intellij.JSXPlugin.psi.JSXClass;
import net.mootoh.intellij.JSXPlugin.psi.JSXClassDefinition;
import net.mootoh.intellij.JSXPlugin.psi.JSXTypeStatement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXIndexUtil {
    private static final Key<JSXFileIndexData> ourJSXCachesData = Key.create("jsx.caches.index.data");

    public static JSXFileIndexData indexFile(FileContent content) {
        JSXFileIndexData indexData = content.getUserData(ourJSXCachesData);
        if (indexData != null) return indexData;
        synchronized (content) {
            indexData = content.getUserData(ourJSXCachesData);
            if (indexData != null) return indexData;
            indexData = indexFileRoots(content.getPsiFile());
        }

        return indexData;
    }
    private static JSXFileIndexData indexFileRoots(PsiFile psiFile) {
        JSXFileIndexData result = new JSXFileIndexData();

        for (PsiElement rootElement : findJSXRoots(psiFile)) {
            PsiElement[] children = rootElement.getChildren();
            for (PsiElement element: children) {
                if (element instanceof JSXTypeStatement) {
                    for (PsiElement child: element.getChildren()) {
                        if (child instanceof JSXClass || child instanceof JSXClassDefinition) {
                            result.addClassName(child.getText());
                            result.addClass(child.getText(), (JSXClass)child);
                        }
                    }
                }
            }
        }

        return result;

    }

    private static List<PsiElement> findJSXRoots(PsiFile psiFile) {
        if (psiFile instanceof XmlFile) {
            return findJSXRootsInXml((XmlFile) psiFile);
        }
        return Collections.<PsiElement>singletonList(psiFile);
    }

    private static List<PsiElement> findJSXRootsInXml(XmlFile xmlFile) {
        final List<PsiElement> result = new ArrayList<PsiElement>();
        /*
        xmlFile.acceptChildren(new XmlRecursiveElementVisitor() {
            @Override
            public void visitElement(PsiElement element) {
                if (element instanceof DartEmbeddedContent) {
                    result.add(element);
                    return;
                }
                super.visitElement(element);
            }
        });
        */
        return result;
    }
}
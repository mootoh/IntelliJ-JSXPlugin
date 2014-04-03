package net.mootoh.intellij.JSXPlugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.*;
import com.intellij.util.io.EnumeratorStringDescriptor;
import com.intellij.util.io.KeyDescriptor;
import gnu.trove.THashMap;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXClassIndex extends ScalarIndexExtension<String> {
    public static final ID<String, Void> JSX_CLASS_INDEX = ID.create("JSXClassIndex");
    private DataIndexer<String, Void, FileContent> myDataIndexer = new MyDataIndexer();

    @NotNull
    @Override
    public ID<String, Void> getName() {
        return JSX_CLASS_INDEX;
    }

    @NotNull
    @Override
    public DataIndexer<String, Void, FileContent> getIndexer() {
        return myDataIndexer;
    }

    @NotNull
    @Override
    public KeyDescriptor<String> getKeyDescriptor() {
        return new EnumeratorStringDescriptor();
    }

    @NotNull
    @Override
    public FileBasedIndex.InputFilter getInputFilter() {
        return JSXInputFilter.INSTANCE;
    }

    @Override
    public boolean dependsOnFileContent() {
        return true;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    public static Collection<String> getNames(Project project) {
        return FileBasedIndex.getInstance().getAllKeys(JSX_CLASS_INDEX, project);
    }

    public static Collection<String> getItemsByName(String name, Project project, GlobalSearchScope searchScope) {
        final Collection<VirtualFile> files = FileBasedIndex.getInstance().getContainingFiles(JSX_CLASS_INDEX, name, searchScope);
        final Set<String> result = new THashSet<String>();
        for (VirtualFile vFile : files) {
            final PsiFile psiFile = PsiManager.getInstance(project).findFile(vFile);
            for (PsiElement root : JSXResolveUtil.findJSXRoots(psiFile)) {
                /*
                for (DartComponent component : DartResolveUtil.getClassDeclarations(root)) {
                    if (name.equals(component.getName())) {
                        result.add(component.getComponentName());
                    }
                }
                */
            }
        }
        return new ArrayList<String>(result);
    }

    private static class MyDataIndexer implements DataIndexer<String, Void, FileContent> {
        @Override
        @NotNull
        public Map<String, Void> map(final FileContent inputData) {
            JSXFileIndexData indexData = JSXIndexUtil.indexFile(inputData);
            final Map<String, Void> result = new THashMap<String, Void>();
            for (String componentName : indexData.getClassNames()) {
                result.put(componentName, null);
            }
            return result;
        }
    }
}
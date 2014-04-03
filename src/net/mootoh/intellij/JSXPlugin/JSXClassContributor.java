package net.mootoh.intellij.JSXPlugin;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;

class FakeItemPresentation implements ItemPresentation {
    private final String name;

    FakeItemPresentation(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public String getPresentableText() {
        return name;
    }

    @Nullable
    @Override
    public String getLocationString() {
        return name;
    }

    @Nullable
    @Override
    public Icon getIcon(boolean b) {
        return null;
    }
}

class FakeNavigationItem implements NavigationItem {
    final String name;

    FakeNavigationItem(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public String getName() {
        return name;
    }

    @Nullable
    @Override
    public ItemPresentation getPresentation() {
        return new FakeItemPresentation(name);
    }

    @Override
    public void navigate(boolean b) {

    }

    @Override
    public boolean canNavigate() {
        return false;
    }

    @Override
    public boolean canNavigateToSource() {
        return false;
    }
}
/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXClassContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean includeNonProjectItems) {
        final Collection<String> result = JSXClassIndex.getNames(project);
        return ArrayUtil.toStringArray(result);
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String name, String pattern, Project project, boolean includeNonProjectItems) {
/*
        final GlobalSearchScope scope = includeNonProjectItems ? GlobalSearchScope.allScope(project) : GlobalSearchScope.projectScope(project);
//        final Collection<JSXComponentName> result = JSXClassIndex.getItemsByName(name, project, scope);
//        if (result.size() == 0) {
//            return NavigationItem.EMPTY_NAVIGATION_ITEM_ARRAY;
//        }
//        return result.toArray(new NavigationItem[result.size()]);

        final Collection<String> result = JSXClassIndex.getNames(project);
        String[] strs = ArrayUtil.toStringArray(result);

        NavigationItem[] ret = new NavigationItem[strs.length];
        for (int i=0; i<ret.length; i++) {
            ret[i] = new FakeNavigationItem(strs[i]);
        }
        return ret;
        */
        final Collection<String> result = JSXClassIndex.getNames(project);
        NavigationItem[] ret = new NavigationItem[result.size()];

        int i = 0;
        for (String nm: result) {
            ret[i++] = new FakeNavigationItem(nm);
        }
        return ret;

    }
}

package net.mootoh.intellij.JSXPlugin;

import com.intellij.ide.util.PsiNavigationSupport;
import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.IconLoader;
import com.intellij.pom.Navigatable;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ArrayUtil;
import net.mootoh.intellij.JSXPlugin.psi.JSXClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;

class FakeNavigationItem implements NavigationItem {
    private static final Icon ICON = IconLoader.getIcon("/net/mootoh/intellij/JSXPlugin/icons/jsx-icon.png");

    final String name;
    final JSXClass klass;

    FakeNavigationItem(String name, JSXClass klass) {
        this.name = name;
        this.klass = klass;
    }

    @Nullable
    @Override
    public String getName() {
        return name;
    }

    @Nullable
    @Override
    public ItemPresentation getPresentation() {
        return new ItemPresentation() {

            @Nullable
            @Override
            public String getPresentableText() {
                final StringBuilder result = new StringBuilder();
                result.append(name);
                return result.toString();
            }

            @Nullable
            @Override
            public String getLocationString() {
                return klass.getContainingFile().getName();
            }

            @Nullable
            @Override
            public Icon getIcon(boolean b) {
                return ICON;
            }
        };
    }

    @Override
    public void navigate(boolean requestFocus) {
        final Navigatable descriptor = PsiNavigationSupport.getInstance().getDescriptor(klass);
        if (descriptor != null) descriptor.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return true;
    }

    @Override
    public boolean canNavigateToSource() {
        return true;
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
        final GlobalSearchScope scope = includeNonProjectItems ? GlobalSearchScope.allScope(project) : GlobalSearchScope.projectScope(project);
        final Collection<JSXClass> result = JSXClassIndex.getItemsByName(name, project, scope);

        if (result.size() == 0)
            return NavigationItem.EMPTY_NAVIGATION_ITEM_ARRAY;

        NavigationItem[] ret = new NavigationItem[result.size()];

        int i = 0;
        for (JSXClass klass: result) {
            ret[i++] = new FakeNavigationItem(klass.getText(), klass);
        }
        return ret;
    }
}

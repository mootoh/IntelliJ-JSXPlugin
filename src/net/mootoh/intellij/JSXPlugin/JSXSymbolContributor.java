package net.mootoh.intellij.JSXPlugin;

import com.intellij.navigation.ChooseByNameContributor;
import com.intellij.navigation.NavigationItem;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXSymbolContributor implements ChooseByNameContributor {
    @NotNull
    @Override
    public String[] getNames(Project project, boolean b) {
        String[] ret = new String[2];
        ret[0] = "gopher symbol";
        ret[1] = "terrible symbol";
        return ret;
    }

    @NotNull
    @Override
    public NavigationItem[] getItemsByName(String s, String s2, Project project, boolean b) {
        return new NavigationItem[0];
    }
}

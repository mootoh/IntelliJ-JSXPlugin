package net.mootoh.intellij.JSXPlugin;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXFileIndexData {
    private List<String> myClassNames = new ArrayList<String>();

    public List<String> getClassNames() {
        return myClassNames;
    }

    public void addClassName(@Nullable String name) {
        if (name != null) {
            myClassNames.add(name);
        }
    }
}

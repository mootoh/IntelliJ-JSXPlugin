package net.mootoh.intellij.JSXPlugin;

import gnu.trove.THashMap;
import net.mootoh.intellij.JSXPlugin.psi.JSXClass;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXFileIndexData {
    private List<String> classNames = new ArrayList<String>();
    private Map<String, JSXClass> classMap = new THashMap<String, JSXClass>();

    public List<String> getClassNames() {
        return classNames;
    }

    public void addClassName(@Nullable String name) {
        if (name != null) {
            classNames.add(name);
        }
    }

    public void addClass(String name, JSXClass classInfo) {
        classMap.put(name, classInfo);
    }
}

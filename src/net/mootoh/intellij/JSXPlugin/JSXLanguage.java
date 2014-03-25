package net.mootoh.intellij.JSXPlugin;

import com.intellij.lang.Language;

/**
 * Created by takayama.motohiro on 3/25/14.
 */
public class JSXLanguage extends Language {
    public static final JSXLanguage INSTANCE = new JSXLanguage();

    private JSXLanguage() {
        super("JSX");
    }
}

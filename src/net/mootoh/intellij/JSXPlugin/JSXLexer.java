package net.mootoh.intellij.JSXPlugin;

import com.intellij.lexer.FlexAdapter;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXLexer extends FlexAdapter {
    public JSXLexer() {
        super(new _JSXLexer());
    }
}

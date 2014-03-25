package net.mootoh.intellij.JSXPlugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by takayama.motohiro on 3/25/14.
 */
public class JSXLexerAdapter extends FlexAdapter {
    public JSXLexerAdapter() {
        super(new JSXLexer((Reader)null));
    }
}

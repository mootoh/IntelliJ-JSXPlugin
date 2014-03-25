package net.mootoh.intellij.JSXPlugin.psi;

import com.intellij.psi.tree.IElementType;
import net.mootoh.intellij.JSXPlugin.JSXLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by takayama.motohiro on 3/25/14.
 */
public class JSXElementType extends IElementType {
    public JSXElementType(@NotNull @NonNls String debugName) {
        super(debugName, JSXLanguage.INSTANCE);
    }
}

package net.mootoh.intellij.JSXPlugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import net.mootoh.intellij.JSXPlugin.JSXFileType;
import net.mootoh.intellij.JSXPlugin.JSXLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by takayama.motohiro on 3/25/14.
 */
public class JSXFile extends PsiFileBase {
    public JSXFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, JSXLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return JSXFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "JSX File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}

package net.mootoh.intellij.JSXPlugin;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by takayama.motohiro on 3/25/14.
 */
public class JSXFileType extends LanguageFileType {
    public static final JSXFileType INSTANCE = new JSXFileType();

    protected JSXFileType() {
        super(JSXLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "JSX";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "a faster, safer, easier JavaScript";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "jsx";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return JSXIcons.FILE;
    }
}

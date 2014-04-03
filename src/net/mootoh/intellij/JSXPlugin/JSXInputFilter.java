package net.mootoh.intellij.JSXPlugin;

import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.openapi.vfs.JarFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.util.indexing.DefaultFileTypeSpecificInputFilter;
import org.jetbrains.annotations.NotNull;

/**
 * Created by takayama.motohiro on 4/3/14.
 */
public class JSXInputFilter extends DefaultFileTypeSpecificInputFilter {
    public static JSXInputFilter INSTANCE = new JSXInputFilter();

    @Override
    public boolean acceptInput(@NotNull VirtualFile file) {
        boolean accepts = super.acceptInput(file);
        if (accepts && file.getFileType() == StdFileTypes.HTML) {
            accepts = !(file.getFileSystem() instanceof JarFileSystem);
        }
        return accepts;
    }

    public JSXInputFilter() { super(JSXFileType.INSTANCE, StdFileTypes.HTML); }
}

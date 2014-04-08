package net.mootoh.intellij.JSXPlugin;

import com.intellij.codeInsight.daemon.GutterIconNavigationHandler;
import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.openapi.editor.markup.GutterIconRenderer;
import com.intellij.openapi.util.IconLoader;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import net.mootoh.intellij.JSXPlugin.psi.JSXClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.List;

import static com.intellij.codeHighlighting.Pass.UPDATE_ALL;

/**
 * Created by takayama.motohiro on 4/7/14.
 */
public class JSXLineMarkerProvider implements LineMarkerProvider {
    public static final Icon ICON = IconLoader.getIcon("/net/mootoh/intellij/JSXPlugin/icons/jsx-icon.png");

    public static final GutterIconNavigationHandler<PsiElement> SHOW_INSTANTIATIONS_AND_PRODUCERS =
            new GutterIconNavigationHandler<PsiElement>() {
                @Override
                public void navigate(MouseEvent mouseEvent, PsiElement psiElement) {
                    return;
                }
            };

    @Nullable
    @Override
    public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement psiElement) {
        if (psiElement instanceof JSXClass) {
                return new LineMarkerInfo<PsiElement>(psiElement, psiElement.getTextRange(), ICON, UPDATE_ALL, null, SHOW_INSTANTIATIONS_AND_PRODUCERS, GutterIconRenderer.Alignment.RIGHT);
        }
        if (psiElement instanceof PsiClass) {
            return null;
        }

        return null;
    }

    @Override
    public void collectSlowLineMarkers(@NotNull List<PsiElement> psiElements, @NotNull Collection<LineMarkerInfo> lineMarkerInfos) {
        return;

    }
}

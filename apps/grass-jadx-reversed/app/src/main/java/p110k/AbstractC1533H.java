package p110k;

import android.content.res.Resources;
import android.widget.ThemedSpinnerAdapter;
import p026I.AbstractC0294b;

/* JADX INFO: renamed from: k.H */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1533H {
    /* JADX INFO: renamed from: a */
    public static void m3587a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
        if (AbstractC0294b.m569a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
            return;
        }
        themedSpinnerAdapter.setDropDownViewTheme(theme);
    }
}

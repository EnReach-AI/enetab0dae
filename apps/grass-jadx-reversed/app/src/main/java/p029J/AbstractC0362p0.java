package p029J;

import android.view.WindowInsets;

/* JADX INFO: renamed from: J.p0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0362p0 {
    /* JADX INFO: renamed from: a */
    public static int m826a(int i3) {
        int iStatusBars;
        int i4 = 0;
        for (int i5 = 1; i5 <= 256; i5 <<= 1) {
            if ((i3 & i5) != 0) {
                if (i5 == 1) {
                    iStatusBars = WindowInsets.Type.statusBars();
                } else if (i5 == 2) {
                    iStatusBars = WindowInsets.Type.navigationBars();
                } else if (i5 == 4) {
                    iStatusBars = WindowInsets.Type.captionBar();
                } else if (i5 == 8) {
                    iStatusBars = WindowInsets.Type.ime();
                } else if (i5 == 16) {
                    iStatusBars = WindowInsets.Type.systemGestures();
                } else if (i5 == 32) {
                    iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                } else if (i5 == 64) {
                    iStatusBars = WindowInsets.Type.tappableElement();
                } else if (i5 == 128) {
                    iStatusBars = WindowInsets.Type.displayCutout();
                }
                i4 |= iStatusBars;
            }
        }
        return i4;
    }
}

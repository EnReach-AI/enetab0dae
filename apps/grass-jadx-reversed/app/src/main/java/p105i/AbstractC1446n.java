package p105i;

import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;

/* JADX INFO: renamed from: i.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1446n {
    /* JADX INFO: renamed from: a */
    public static void m3454a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i3) {
        callback.onProvideKeyboardShortcuts(list, menu, i3);
    }
}

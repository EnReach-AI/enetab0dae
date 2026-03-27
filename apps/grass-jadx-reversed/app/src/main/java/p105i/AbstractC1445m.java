package p105i;

import android.view.ActionMode;
import android.view.SearchEvent;
import android.view.Window;

/* JADX INFO: renamed from: i.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1445m {
    /* JADX INFO: renamed from: a */
    public static boolean m3452a(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    /* JADX INFO: renamed from: b */
    public static ActionMode m3453b(Window.Callback callback, ActionMode.Callback callback2, int i3) {
        return callback.onWindowStartingActionMode(callback2, i3);
    }
}

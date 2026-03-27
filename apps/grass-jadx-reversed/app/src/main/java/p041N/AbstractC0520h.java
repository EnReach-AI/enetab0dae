package p041N;

import android.widget.ListView;

/* JADX INFO: renamed from: N.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0520h {
    /* JADX INFO: renamed from: a */
    public static boolean m1040a(ListView listView, int i3) {
        return listView.canScrollList(i3);
    }

    /* JADX INFO: renamed from: b */
    public static void m1041b(ListView listView, int i3) {
        listView.scrollListBy(i3);
    }
}

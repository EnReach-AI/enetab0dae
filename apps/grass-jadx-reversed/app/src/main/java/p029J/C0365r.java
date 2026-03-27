package p029J;

import android.view.View;
import p073Z.AbstractC0777X;

/* JADX INFO: renamed from: J.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0365r {

    /* JADX INFO: renamed from: a */
    public int f875a;

    /* JADX INFO: renamed from: b */
    public int f876b;

    public C0365r(int i3, int i4) {
        this.f875a = i3;
        this.f876b = i4;
    }

    /* JADX INFO: renamed from: a */
    public void m835a(AbstractC0777X abstractC0777X) {
        View view = abstractC0777X.f2202a;
        this.f875a = view.getLeft();
        this.f876b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}

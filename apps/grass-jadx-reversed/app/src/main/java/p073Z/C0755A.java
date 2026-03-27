package p073Z;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: Z.A */
/* JADX INFO: loaded from: classes.dex */
public final class C0755A {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RecyclerView f2126a;

    public /* synthetic */ C0755A(RecyclerView recyclerView) {
        this.f2126a = recyclerView;
    }

    /* JADX INFO: renamed from: a */
    public void m1943a(int i3) {
        RecyclerView recyclerView = this.f2126a;
        View childAt = recyclerView.getChildAt(i3);
        if (childAt != null) {
            RecyclerView.m2571I(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i3);
    }
}

package p073Z;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: Z.S */
/* JADX INFO: loaded from: classes.dex */
public final class C0772S {

    /* JADX INFO: renamed from: a */
    public int f2173a;

    /* JADX INFO: renamed from: b */
    public int f2174b;

    /* JADX INFO: renamed from: c */
    public int f2175c;

    /* JADX INFO: renamed from: d */
    public int f2176d;

    /* JADX INFO: renamed from: e */
    public Interpolator f2177e;

    /* JADX INFO: renamed from: f */
    public boolean f2178f;

    /* JADX INFO: renamed from: g */
    public int f2179g;

    /* JADX INFO: renamed from: a */
    public final void m2044a(RecyclerView recyclerView) {
        int i3 = this.f2176d;
        if (i3 >= 0) {
            this.f2176d = -1;
            recyclerView.m2587M(i3);
            this.f2178f = false;
            return;
        }
        if (!this.f2178f) {
            this.f2179g = 0;
            return;
        }
        Interpolator interpolator = this.f2177e;
        if (interpolator != null && this.f2175c < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        int i4 = this.f2175c;
        if (i4 < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
        recyclerView.f3411d0.m2049b(this.f2173a, this.f2174b, i4, interpolator);
        int i5 = this.f2179g + 1;
        this.f2179g = i5;
        if (i5 > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
        }
        this.f2178f = false;
    }
}

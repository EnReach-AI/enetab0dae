package p073Z;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.Arrays;

/* JADX INFO: renamed from: Z.b0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0783b0 {

    /* JADX INFO: renamed from: a */
    public int f2232a;

    /* JADX INFO: renamed from: b */
    public int f2233b;

    /* JADX INFO: renamed from: c */
    public boolean f2234c;

    /* JADX INFO: renamed from: d */
    public boolean f2235d;

    /* JADX INFO: renamed from: e */
    public boolean f2236e;

    /* JADX INFO: renamed from: f */
    public int[] f2237f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ StaggeredGridLayoutManager f2238g;

    public C0783b0(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.f2238g = staggeredGridLayoutManager;
        m2075a();
    }

    /* JADX INFO: renamed from: a */
    public final void m2075a() {
        this.f2232a = -1;
        this.f2233b = Integer.MIN_VALUE;
        this.f2234c = false;
        this.f2235d = false;
        this.f2236e = false;
        int[] iArr = this.f2237f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}

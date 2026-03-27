package p073Z;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p029J.AbstractC0323S;
import p029J.C0335c;
import p067W1.C0693a;

/* JADX INFO: renamed from: Z.O */
/* JADX INFO: loaded from: classes.dex */
public final class C0769O {

    /* JADX INFO: renamed from: a */
    public final ArrayList f2164a;

    /* JADX INFO: renamed from: b */
    public ArrayList f2165b;

    /* JADX INFO: renamed from: c */
    public final ArrayList f2166c;

    /* JADX INFO: renamed from: d */
    public final List f2167d;

    /* JADX INFO: renamed from: e */
    public int f2168e;

    /* JADX INFO: renamed from: f */
    public int f2169f;

    /* JADX INFO: renamed from: g */
    public C0768N f2170g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ RecyclerView f2171h;

    public C0769O(RecyclerView recyclerView) {
        this.f2171h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f2164a = arrayList;
        this.f2165b = null;
        this.f2166c = new ArrayList();
        this.f2167d = Collections.unmodifiableList(arrayList);
        this.f2168e = 2;
        this.f2169f = 2;
    }

    /* JADX INFO: renamed from: a */
    public final void m2033a(AbstractC0777X abstractC0777X, boolean z3) {
        RecyclerView.m2576j(abstractC0777X);
        RecyclerView recyclerView = this.f2171h;
        C0779Z c0779z = recyclerView.f3431n0;
        if (c0779z != null) {
            C0778Y c0778y = c0779z.f2223e;
            boolean z4 = c0778y instanceof C0778Y;
            View view = abstractC0777X.f2202a;
            AbstractC0323S.m701k(view, z4 ? (C0335c) c0778y.f2221e.remove(view) : null);
        }
        if (z3 && recyclerView.f3417g0 != null) {
            recyclerView.f3422j.m37O(abstractC0777X);
        }
        abstractC0777X.f2219r = null;
        C0768N c0768nM2035c = m2035c();
        c0768nM2035c.getClass();
        int i3 = abstractC0777X.f2207f;
        ArrayList arrayList = c0768nM2035c.m2032a(i3).f2158a;
        if (((C0767M) c0768nM2035c.f2162a.get(i3)).f2159b <= arrayList.size()) {
            return;
        }
        abstractC0777X.m2063n();
        arrayList.add(abstractC0777X);
    }

    /* JADX INFO: renamed from: b */
    public final int m2034b(int i3) {
        RecyclerView recyclerView = this.f2171h;
        if (i3 >= 0 && i3 < recyclerView.f3417g0.m2047b()) {
            return !recyclerView.f3417g0.f2186g ? i3 : recyclerView.f3418h.m3974g(i3, 0);
        }
        throw new IndexOutOfBoundsException("invalid position " + i3 + ". State item count is " + recyclerView.f3417g0.m2047b() + recyclerView.m2624y());
    }

    /* JADX INFO: renamed from: c */
    public final C0768N m2035c() {
        if (this.f2170g == null) {
            C0768N c0768n = new C0768N();
            c0768n.f2162a = new SparseArray();
            c0768n.f2163b = 0;
            this.f2170g = c0768n;
        }
        return this.f2170g;
    }

    /* JADX INFO: renamed from: d */
    public final void m2036d() {
        ArrayList arrayList = this.f2166c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            m2037e(size);
        }
        arrayList.clear();
        int[] iArr = RecyclerView.f3382w0;
        C0693a c0693a = this.f2171h.f3415f0;
        int[] iArr2 = (int[]) c0693a.f1884d;
        if (iArr2 != null) {
            Arrays.fill(iArr2, -1);
        }
        c0693a.f1883c = 0;
    }

    /* JADX INFO: renamed from: e */
    public final void m2037e(int i3) {
        ArrayList arrayList = this.f2166c;
        m2033a((AbstractC0777X) arrayList.get(i3), true);
        arrayList.remove(i3);
    }

    /* JADX INFO: renamed from: f */
    public final void m2038f(View view) {
        AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
        boolean zM2060k = abstractC0777XM2571I.m2060k();
        RecyclerView recyclerView = this.f2171h;
        if (zM2060k) {
            recyclerView.removeDetachedView(view, false);
        }
        if (abstractC0777XM2571I.m2059j()) {
            abstractC0777XM2571I.f2215n.m2042j(abstractC0777XM2571I);
        } else if (abstractC0777XM2571I.m2066q()) {
            abstractC0777XM2571I.f2211j &= -33;
        }
        m2039g(abstractC0777XM2571I);
        if (recyclerView.f3396L == null || abstractC0777XM2571I.m2057h()) {
            return;
        }
        recyclerView.f3396L.mo1953e(abstractC0777XM2571I);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0099, code lost:
    
        r5 = r5 - 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2039g(p073Z.AbstractC0777X r12) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.C0769O.m2039g(Z.X):void");
    }

    /* JADX INFO: renamed from: h */
    public final void m2040h(View view) {
        AbstractC0760F abstractC0760F;
        AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(view);
        boolean zM2053d = abstractC0777XM2571I.m2053d(12);
        RecyclerView recyclerView = this.f2171h;
        if (!zM2053d && abstractC0777XM2571I.m2061l() && (abstractC0760F = recyclerView.f3396L) != null) {
            C0796i c0796i = (C0796i) abstractC0760F;
            if (abstractC0777XM2571I.m2052c().isEmpty() && c0796i.f2296g && !abstractC0777XM2571I.m2056g()) {
                if (this.f2165b == null) {
                    this.f2165b = new ArrayList();
                }
                abstractC0777XM2571I.f2215n = this;
                abstractC0777XM2571I.f2216o = true;
                this.f2165b.add(abstractC0777XM2571I);
                return;
            }
        }
        if (abstractC0777XM2571I.m2056g() && !abstractC0777XM2571I.m2058i() && !recyclerView.f3432o.f2128b) {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.m2624y());
        }
        abstractC0777XM2571I.f2215n = this;
        abstractC0777XM2571I.f2216o = false;
        this.f2164a.add(abstractC0777XM2571I);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014a  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p073Z.AbstractC0777X m2041i(int r25, long r26) {
        /*
            Method dump skipped, instruction units count: 1378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.C0769O.m2041i(int, long):Z.X");
    }

    /* JADX INFO: renamed from: j */
    public final void m2042j(AbstractC0777X abstractC0777X) {
        if (abstractC0777X.f2216o) {
            this.f2165b.remove(abstractC0777X);
        } else {
            this.f2164a.remove(abstractC0777X);
        }
        abstractC0777X.f2215n = null;
        abstractC0777X.f2216o = false;
        abstractC0777X.f2211j &= -33;
    }

    /* JADX INFO: renamed from: k */
    public final void m2043k() {
        AbstractC0763I abstractC0763I = this.f2171h.f3434p;
        this.f2169f = this.f2168e + (abstractC0763I != null ? abstractC0763I.f2148j : 0);
        ArrayList arrayList = this.f2166c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f2169f; size--) {
            m2037e(size);
        }
    }
}

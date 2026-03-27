package p073Z;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import p006B0.C0038a;
import p018F.AbstractC0215g;
import p018F.AbstractC0216h;
import p067W1.C0693a;

/* JADX INFO: renamed from: Z.n */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0802n implements Runnable {

    /* JADX INFO: renamed from: i */
    public static final ThreadLocal f2351i = new ThreadLocal();

    /* JADX INFO: renamed from: j */
    public static final C0038a f2352j = new C0038a(4);

    /* JADX INFO: renamed from: e */
    public ArrayList f2353e;

    /* JADX INFO: renamed from: f */
    public long f2354f;

    /* JADX INFO: renamed from: g */
    public long f2355g;

    /* JADX INFO: renamed from: h */
    public ArrayList f2356h;

    /* JADX INFO: renamed from: c */
    public static AbstractC0777X m2097c(RecyclerView recyclerView, int i3, long j2) {
        int iM2855l = recyclerView.f3420i.m2855l();
        for (int i4 = 0; i4 < iM2855l; i4++) {
            AbstractC0777X abstractC0777XM2571I = RecyclerView.m2571I(recyclerView.f3420i.m2854k(i4));
            if (abstractC0777XM2571I.f2204c == i3 && !abstractC0777XM2571I.m2056g()) {
                return null;
            }
        }
        C0769O c0769o = recyclerView.f3414f;
        try {
            recyclerView.m2590P();
            AbstractC0777X abstractC0777XM2041i = c0769o.m2041i(i3, j2);
            if (abstractC0777XM2041i != null) {
                if (!abstractC0777XM2041i.m2055f() || abstractC0777XM2041i.m2056g()) {
                    c0769o.m2033a(abstractC0777XM2041i, false);
                } else {
                    c0769o.m2038f(abstractC0777XM2041i.f2202a);
                }
            }
            recyclerView.m2591Q(false);
            return abstractC0777XM2041i;
        } catch (Throwable th) {
            recyclerView.m2591Q(false);
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2098a(RecyclerView recyclerView, int i3, int i4) {
        if (recyclerView.f3442t && this.f2354f == 0) {
            this.f2354f = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        C0693a c0693a = recyclerView.f3415f0;
        c0693a.f1881a = i3;
        c0693a.f1882b = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x013a  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2099b(long r17) {
        /*
            Method dump skipped, instruction units count: 331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p073Z.RunnableC0802n.m2099b(long):void");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i3 = AbstractC0216h.f520a;
            AbstractC0215g.m424a("RV Prefetch");
            ArrayList arrayList = this.f2353e;
            if (arrayList.isEmpty()) {
                this.f2354f = 0L;
                AbstractC0215g.m425b();
                return;
            }
            int size = arrayList.size();
            long jMax = 0;
            for (int i4 = 0; i4 < size; i4++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i4);
                if (recyclerView.getWindowVisibility() == 0) {
                    jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                this.f2354f = 0L;
                AbstractC0215g.m425b();
            } else {
                m2099b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f2355g);
                this.f2354f = 0L;
                AbstractC0215g.m425b();
            }
        } catch (Throwable th) {
            this.f2354f = 0L;
            int i5 = AbstractC0216h.f520a;
            AbstractC0215g.m425b();
            throw th;
        }
    }
}

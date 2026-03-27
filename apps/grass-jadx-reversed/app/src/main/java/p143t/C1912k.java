package p143t;

import java.util.ArrayList;

/* JADX INFO: renamed from: t.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1912k {

    /* JADX INFO: renamed from: a */
    public AbstractC1914m f6682a;

    /* JADX INFO: renamed from: b */
    public ArrayList f6683b;

    /* JADX INFO: renamed from: a */
    public static long m4255a(C1907f c1907f, long j2) {
        AbstractC1914m abstractC1914m = c1907f.f6671d;
        if (abstractC1914m instanceof C1910i) {
            return j2;
        }
        ArrayList arrayList = c1907f.f6678k;
        int size = arrayList.size();
        long jMin = j2;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC1905d interfaceC1905d = (InterfaceC1905d) arrayList.get(i3);
            if (interfaceC1905d instanceof C1907f) {
                C1907f c1907f2 = (C1907f) interfaceC1905d;
                if (c1907f2.f6671d != abstractC1914m) {
                    jMin = Math.min(jMin, m4255a(c1907f2, ((long) c1907f2.f6673f) + j2));
                }
            }
        }
        if (c1907f != abstractC1914m.f6694i) {
            return jMin;
        }
        long jMo4237j = abstractC1914m.mo4237j();
        C1907f c1907f3 = abstractC1914m.f6693h;
        long j3 = j2 - jMo4237j;
        return Math.min(Math.min(jMin, m4255a(c1907f3, j3)), j3 - ((long) c1907f3.f6673f));
    }

    /* JADX INFO: renamed from: b */
    public static long m4256b(C1907f c1907f, long j2) {
        AbstractC1914m abstractC1914m = c1907f.f6671d;
        if (abstractC1914m instanceof C1910i) {
            return j2;
        }
        ArrayList arrayList = c1907f.f6678k;
        int size = arrayList.size();
        long jMax = j2;
        for (int i3 = 0; i3 < size; i3++) {
            InterfaceC1905d interfaceC1905d = (InterfaceC1905d) arrayList.get(i3);
            if (interfaceC1905d instanceof C1907f) {
                C1907f c1907f2 = (C1907f) interfaceC1905d;
                if (c1907f2.f6671d != abstractC1914m) {
                    jMax = Math.max(jMax, m4256b(c1907f2, ((long) c1907f2.f6673f) + j2));
                }
            }
        }
        if (c1907f != abstractC1914m.f6693h) {
            return jMax;
        }
        long jMo4237j = abstractC1914m.mo4237j();
        C1907f c1907f3 = abstractC1914m.f6694i;
        long j3 = j2 + jMo4237j;
        return Math.max(Math.max(jMax, m4256b(c1907f3, j3)), j3 - ((long) c1907f3.f6673f));
    }
}

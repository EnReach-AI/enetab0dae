package p100g1;

import p039M0.EnumC0471T;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p066W0.AbstractC0692s;
import p069X0.InterfaceC0714e;

/* JADX INFO: renamed from: g1.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1399h {
    /* JADX INFO: renamed from: a */
    public abstract AbstractC1399h mo3100a(InterfaceC0714e interfaceC0714e);

    /* JADX INFO: renamed from: b */
    public abstract String mo3101b();

    /* JADX INFO: renamed from: c */
    public abstract EnumC0471T mo3102c();

    /* JADX INFO: renamed from: d */
    public final C0672b m3406d(EnumC0548p enumC0548p, Object obj) {
        C0672b c0672b = new C0672b(enumC0548p, obj);
        int iOrdinal = mo3102c().ordinal();
        if (iOrdinal == 0) {
            c0672b.f1827e = 3;
            c0672b.f1826d = mo3101b();
        } else if (iOrdinal == 1) {
            c0672b.f1827e = 2;
        } else if (iOrdinal == 2) {
            c0672b.f1827e = 1;
        } else if (iOrdinal == 3) {
            c0672b.f1827e = 5;
            c0672b.f1826d = mo3101b();
        } else {
            if (iOrdinal != 4) {
                AbstractC0692s.m1666a();
                throw null;
            }
            c0672b.f1827e = 4;
            c0672b.f1826d = mo3101b();
        }
        return c0672b;
    }

    /* JADX INFO: renamed from: e */
    public abstract C0672b mo3103e(AbstractC0540h abstractC0540h, C0672b c0672b);

    /* JADX INFO: renamed from: f */
    public abstract C0672b mo3104f(AbstractC0540h abstractC0540h, C0672b c0672b);
}

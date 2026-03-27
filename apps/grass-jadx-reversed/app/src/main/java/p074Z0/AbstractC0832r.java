package p074Z0;

import java.io.Serializable;
import java.util.TimeZone;
import p039M0.C0453A;
import p039M0.C0502q;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.EnumC0731v;
import p082b1.AbstractC1017M;
import p082b1.C1005A;
import p082b1.C1006B;
import p082b1.C1029Z;
import p082b1.C1033d;
import p082b1.InterfaceC1008D;

/* JADX INFO: renamed from: Z0.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0832r implements InterfaceC1008D, Serializable {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final long f2480e;

    /* JADX INFO: renamed from: f */
    public final C0815a f2481f;

    static {
        C0453A c0453a = C0453A.f1095i;
        C0502q c0502q = C0502q.f1168l;
    }

    public AbstractC0832r(C0815a c0815a, long j2) {
        this.f2481f = c0815a;
        this.f2480e = j2;
    }

    /* JADX INFO: renamed from: b */
    public static int m2147b(Class cls) {
        int iMo1699a = 0;
        for (Object obj : (Enum[]) cls.getEnumConstants()) {
            InterfaceC0820f interfaceC0820f = (InterfaceC0820f) obj;
            if (interfaceC0820f.mo1700b()) {
                iMo1699a |= interfaceC0820f.mo1699a();
            }
        }
        return iMo1699a;
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC0721l m2148c(Class cls) {
        return this.f2481f.f2419e.m3780j(cls);
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC0711b m2149d() {
        return m2157l(EnumC0731v.USE_ANNOTATIONS) ? this.f2481f.f2421g : AbstractC1017M.f3608e;
    }

    /* JADX INFO: renamed from: e */
    public abstract C0821g mo2150e(Class cls);

    /* JADX INFO: renamed from: f */
    public abstract C0502q mo2151f(Class cls);

    /* JADX INFO: renamed from: g */
    public abstract C1029Z mo2152g(Class cls, C1033d c1033d);

    /* JADX INFO: renamed from: h */
    public final void m2153h() {
        this.f2481f.getClass();
    }

    /* JADX INFO: renamed from: i */
    public final TimeZone m2154i() {
        TimeZone timeZone = this.f2481f.f2428n;
        return timeZone == null ? C0815a.f2418p : timeZone;
    }

    /* JADX INFO: renamed from: j */
    public final C1005A m2155j(AbstractC0721l abstractC0721l) {
        ((C1006B) this.f2481f.f2420f).getClass();
        C1005A c1005aM2701b = C1006B.m2701b(this, abstractC0721l);
        return c1005aM2701b == null ? C1005A.m2696g(abstractC0721l, this, C1006B.m2702c(this, abstractC0721l, this)) : c1005aM2701b;
    }

    /* JADX INFO: renamed from: k */
    public final C1005A m2156k(Class cls) {
        return m2155j(m2148c(cls));
    }

    /* JADX INFO: renamed from: l */
    public final boolean m2157l(EnumC0731v enumC0731v) {
        return (enumC0731v.f2083f & this.f2480e) != 0;
    }

    /* JADX INFO: renamed from: m */
    public abstract boolean mo1694m(InterfaceC0826l interfaceC0826l);

    public AbstractC0832r(AbstractC0832r abstractC0832r, long j2) {
        this.f2481f = abstractC0832r.f2481f;
        this.f2480e = j2;
    }
}

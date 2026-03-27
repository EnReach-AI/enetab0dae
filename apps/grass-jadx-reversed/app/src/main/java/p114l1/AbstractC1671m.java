package p114l1;

import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.InterfaceC0727r;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: l1.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1671m extends AbstractC0721l implements InterfaceC0727r {

    /* JADX INFO: renamed from: m */
    public static final C1674p f5910m = C1674p.f5927k;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: j */
    public final AbstractC0721l f5911j;

    /* JADX INFO: renamed from: k */
    public final AbstractC0721l[] f5912k;

    /* JADX INFO: renamed from: l */
    public final C1674p f5913l;

    public AbstractC1671m(Class cls, C1674p c1674p, AbstractC0721l abstractC0721l, AbstractC0721l[] abstractC0721lArr, int i3, Object obj, Object obj2, boolean z3) {
        super(cls, i3, obj, obj2, z3);
        this.f5913l = c1674p == null ? f5910m : c1674p;
        this.f5911j = abstractC0721l;
        this.f5912k = abstractC0721lArr;
    }

    /* JADX INFO: renamed from: J */
    public static void m3759J(Class cls, StringBuilder sb, boolean z3) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = name.charAt(i3);
                if (cCharAt == '.') {
                    cCharAt = '/';
                }
                sb.append(cCharAt);
            }
            if (z3) {
                sb.append(';');
                return;
            }
            return;
        }
        if (cls == Boolean.TYPE) {
            sb.append('Z');
            return;
        }
        if (cls == Byte.TYPE) {
            sb.append('B');
            return;
        }
        if (cls == Short.TYPE) {
            sb.append('S');
            return;
        }
        if (cls == Character.TYPE) {
            sb.append('C');
            return;
        }
        if (cls == Integer.TYPE) {
            sb.append('I');
            return;
        }
        if (cls == Long.TYPE) {
            sb.append('J');
            return;
        }
        if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append('D');
        } else {
            if (cls != Void.TYPE) {
                throw new IllegalStateException("Unrecognized primitive type: ".concat(cls.getName()));
            }
            sb.append('V');
        }
    }

    /* JADX INFO: renamed from: K */
    public final boolean m3760K(int i3) {
        return this.f2036e.getTypeParameters().length == i3;
    }

    /* JADX INFO: renamed from: L */
    public String mo3749L() {
        return this.f2036e.getName();
    }

    @Override // p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: c */
    public final void mo1909c(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        abstractC0540h.mo1125R(mo3749L());
    }

    @Override // p069X0.InterfaceC0727r
    /* JADX INFO: renamed from: d */
    public final void mo1908d(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672b = new C0672b(EnumC0548p.VALUE_STRING, this);
        abstractC1399h.mo3103e(abstractC0540h, c0672b);
        mo1909c(abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672b);
    }

    @Override // p064V0.AbstractC0671a
    /* JADX INFO: renamed from: e */
    public final String mo1630e() {
        return mo3749L();
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: g */
    public final AbstractC0721l mo1872g(Class cls) {
        AbstractC0721l abstractC0721lMo1872g;
        AbstractC0721l[] abstractC0721lArr;
        if (cls == this.f2036e) {
            return this;
        }
        if (cls.isInterface() && (abstractC0721lArr = this.f5912k) != null) {
            for (AbstractC0721l abstractC0721l : abstractC0721lArr) {
                AbstractC0721l abstractC0721lMo1872g2 = abstractC0721l.mo1872g(cls);
                if (abstractC0721lMo1872g2 != null) {
                    return abstractC0721lMo1872g2;
                }
            }
        }
        AbstractC0721l abstractC0721l2 = this.f5911j;
        if (abstractC0721l2 == null || (abstractC0721lMo1872g = abstractC0721l2.mo1872g(cls)) == null) {
            return null;
        }
        return abstractC0721lMo1872g;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: h */
    public C1674p mo1873h() {
        return this.f5913l;
    }

    @Override // p069X0.AbstractC0721l
    /* JADX INFO: renamed from: n */
    public AbstractC0721l mo1879n() {
        return this.f5911j;
    }
}

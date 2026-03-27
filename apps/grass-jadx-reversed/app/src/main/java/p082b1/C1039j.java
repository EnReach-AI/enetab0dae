package p082b1;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import p019F0.C0221e;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1039j extends AbstractC1041l {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: g */
    public final transient Field f3694g;

    /* JADX INFO: renamed from: h */
    public final C1038i f3695h;

    public C1039j(InterfaceC1027X interfaceC1027X, Field field, C0221e c0221e) {
        super(interfaceC1027X, c0221e);
        this.f3694g = field;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: a */
    public final AnnotatedElement mo2766a() {
        return this.f3694g;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: d */
    public final String mo2767d() {
        return this.f3694g.getName();
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: e */
    public final Class mo2768e() {
        return this.f3694g.getType();
    }

    @Override // p082b1.AbstractC1031b
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!AbstractC1745j.m3896s(obj, C1039j.class)) {
            return false;
        }
        Field field = ((C1039j) obj).f3694g;
        Field field2 = this.f3694g;
        return field == null ? field2 == null : field.equals(field2);
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: f */
    public final AbstractC0721l mo2769f() {
        return this.f3699e.mo42b(this.f3694g.getGenericType());
    }

    @Override // p082b1.AbstractC1031b
    public final int hashCode() {
        return this.f3694g.getName().hashCode();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: i */
    public final Class mo2770i() {
        return this.f3694g.getDeclaringClass();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: k */
    public final Member mo2771k() {
        return this.f3694g;
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: l */
    public final Object mo2772l(Object obj) {
        try {
            return this.f3694g.get(obj);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException("Failed to getValue() for field " + mo2800j() + ": " + e3.getMessage(), e3);
        }
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: n */
    public final AbstractC1031b mo2773n(C0221e c0221e) {
        return new C1039j(this.f3699e, this.f3694g, c0221e);
    }

    /* JADX INFO: renamed from: o */
    public final void m2798o(Object obj, Object obj2) {
        try {
            this.f3694g.set(obj, obj2);
        } catch (IllegalAccessException e3) {
            throw new IllegalArgumentException("Failed to setValue() for field " + mo2800j() + ": " + e3.getMessage(), e3);
        }
    }

    public Object readResolve() {
        C1038i c1038i = this.f3695h;
        Class cls = c1038i.f3692e;
        try {
            Field declaredField = cls.getDeclaredField(c1038i.f3693f);
            if (!declaredField.isAccessible()) {
                AbstractC1745j.m3882e(declaredField, false);
            }
            return new C1039j(null, declaredField, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find method '" + c1038i.f3693f + "' from Class '" + cls.getName());
        }
    }

    @Override // p082b1.AbstractC1031b
    public final String toString() {
        return "[field " + mo2800j() + "]";
    }

    public Object writeReplace() {
        C1038i c1038i = new C1038i();
        Field field = this.f3694g;
        c1038i.f3692e = field.getDeclaringClass();
        c1038i.f3693f = field.getName();
        return new C1039j(c1038i);
    }

    public C1039j(C1038i c1038i) {
        super(null, null);
        this.f3694g = null;
        this.f3695h = c1038i;
    }
}

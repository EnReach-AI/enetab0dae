package p082b1;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import p019F0.C0221e;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1036g extends AbstractC1048s {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: h */
    public final Constructor f3687h;

    /* JADX INFO: renamed from: i */
    public final C1035f f3688i;

    public C1036g(InterfaceC1027X interfaceC1027X, Constructor constructor, C0221e c0221e, C0221e[] c0221eArr) {
        super(interfaceC1027X, c0221e, c0221eArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this.f3687h = constructor;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: a */
    public final AnnotatedElement mo2766a() {
        return this.f3687h;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: d */
    public final String mo2767d() {
        return this.f3687h.getName();
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: e */
    public final Class mo2768e() {
        return this.f3687h.getDeclaringClass();
    }

    @Override // p082b1.AbstractC1031b
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!AbstractC1745j.m3896s(obj, C1036g.class)) {
            return false;
        }
        Constructor constructor = ((C1036g) obj).f3687h;
        Constructor constructor2 = this.f3687h;
        return constructor == null ? constructor2 == null : constructor.equals(constructor2);
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: f */
    public final AbstractC0721l mo2769f() {
        return this.f3699e.mo42b(this.f3687h.getDeclaringClass());
    }

    @Override // p082b1.AbstractC1031b
    public final int hashCode() {
        return this.f3687h.getName().hashCode();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: i */
    public final Class mo2770i() {
        return this.f3687h.getDeclaringClass();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: k */
    public final Member mo2771k() {
        return this.f3687h;
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: l */
    public final Object mo2772l(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of ".concat(this.f3687h.getDeclaringClass().getName()));
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: n */
    public final AbstractC1031b mo2773n(C0221e c0221e) {
        return new C1036g(this.f3699e, this.f3687h, c0221e, this.f3717g);
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: o */
    public final Object mo2787o() {
        return this.f3687h.newInstance(null);
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: p */
    public final Object mo2788p(Object[] objArr) {
        return this.f3687h.newInstance(objArr);
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: q */
    public final Object mo2789q(Object obj) {
        return this.f3687h.newInstance(obj);
    }

    public Object readResolve() {
        C1035f c1035f = this.f3688i;
        Class cls = c1035f.f3685e;
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(c1035f.f3686f);
            if (!declaredConstructor.isAccessible()) {
                AbstractC1745j.m3882e(declaredConstructor, false);
            }
            return new C1036g(null, declaredConstructor, null, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find constructor with " + c1035f.f3686f.length + " args from Class '" + cls.getName());
        }
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: s */
    public final int mo2790s() {
        return this.f3687h.getParameterCount();
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: t */
    public final AbstractC0721l mo2791t(int i3) {
        Type[] genericParameterTypes = this.f3687h.getGenericParameterTypes();
        if (i3 >= genericParameterTypes.length) {
            return null;
        }
        return this.f3699e.mo42b(genericParameterTypes[i3]);
    }

    @Override // p082b1.AbstractC1031b
    public final String toString() {
        Constructor constructor = this.f3687h;
        int parameterCount = constructor.getParameterCount();
        return String.format("[constructor for %s (%d arg%s), annotations: %s", AbstractC1745j.m3903z(constructor.getDeclaringClass()), Integer.valueOf(parameterCount), parameterCount == 1 ? "" : "s", this.f3700f);
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: u */
    public final Class mo2792u(int i3) {
        Class<?>[] parameterTypes = this.f3687h.getParameterTypes();
        if (i3 >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i3];
    }

    public Object writeReplace() {
        C1035f c1035f = new C1035f();
        Constructor constructor = this.f3687h;
        c1035f.f3685e = constructor.getDeclaringClass();
        c1035f.f3686f = constructor.getParameterTypes();
        return new C1036g(c1035f);
    }

    public C1036g(C1035f c1035f) {
        super(null, null, null);
        this.f3687h = null;
        this.f3688i = c1035f;
    }
}

package p082b1;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import p019F0.C0221e;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: b1.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1043n extends AbstractC1048s {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: h */
    public final transient Method f3704h;

    /* JADX INFO: renamed from: i */
    public Class[] f3705i;

    /* JADX INFO: renamed from: j */
    public final C1042m f3706j;

    public C1043n(InterfaceC1027X interfaceC1027X, Method method, C0221e c0221e, C0221e[] c0221eArr) {
        super(interfaceC1027X, c0221e, c0221eArr);
        if (method == null) {
            throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
        }
        this.f3704h = method;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: a */
    public final AnnotatedElement mo2766a() {
        return this.f3704h;
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: d */
    public final String mo2767d() {
        return this.f3704h.getName();
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: e */
    public final Class mo2768e() {
        return this.f3704h.getReturnType();
    }

    @Override // p082b1.AbstractC1031b
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!AbstractC1745j.m3896s(obj, C1043n.class)) {
            return false;
        }
        Method method = ((C1043n) obj).f3704h;
        Method method2 = this.f3704h;
        return method == null ? method2 == null : method.equals(method2);
    }

    @Override // p082b1.AbstractC1031b
    /* JADX INFO: renamed from: f */
    public final AbstractC0721l mo2769f() {
        return this.f3699e.mo42b(this.f3704h.getGenericReturnType());
    }

    @Override // p082b1.AbstractC1031b
    public final int hashCode() {
        return this.f3704h.getName().hashCode();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: i */
    public final Class mo2770i() {
        return this.f3704h.getDeclaringClass();
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: j */
    public final String mo2800j() {
        String strMo2800j = super.mo2800j();
        Method method = this.f3704h;
        int parameterCount = method.getParameterCount();
        if (parameterCount == 0) {
            return AbstractC1849h.m4117a(strMo2800j, "()");
        }
        if (parameterCount != 1) {
            return String.format("%s(%d params)", super.mo2800j(), Integer.valueOf(method.getParameterCount()));
        }
        return strMo2800j + "(" + mo2792u(0).getName() + ")";
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: k */
    public final Member mo2771k() {
        return this.f3704h;
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: l */
    public final Object mo2772l(Object obj) {
        try {
            return this.f3704h.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e3) {
            throw new IllegalArgumentException("Failed to getValue() with method " + mo2800j() + ": " + AbstractC1745j.m3886i(e3), e3);
        }
    }

    @Override // p082b1.AbstractC1041l
    /* JADX INFO: renamed from: n */
    public final AbstractC1031b mo2773n(C0221e c0221e) {
        return new C1043n(this.f3699e, this.f3704h, c0221e, this.f3717g);
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: o */
    public final Object mo2787o() {
        return this.f3704h.invoke(null, null);
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: p */
    public final Object mo2788p(Object[] objArr) {
        return this.f3704h.invoke(null, objArr);
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: q */
    public final Object mo2789q(Object obj) {
        return this.f3704h.invoke(null, obj);
    }

    public Object readResolve() {
        C1042m c1042m = this.f3706j;
        Class cls = c1042m.f3701e;
        try {
            Method declaredMethod = cls.getDeclaredMethod(c1042m.f3702f, c1042m.f3703g);
            if (!declaredMethod.isAccessible()) {
                AbstractC1745j.m3882e(declaredMethod, false);
            }
            return new C1043n(null, declaredMethod, null, null);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Could not find method '" + c1042m.f3702f + "' from Class '" + cls.getName());
        }
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: s */
    public final int mo2790s() {
        return this.f3704h.getParameterCount();
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: t */
    public final AbstractC0721l mo2791t(int i3) {
        Type[] genericParameterTypes = this.f3704h.getGenericParameterTypes();
        if (i3 >= genericParameterTypes.length) {
            return null;
        }
        return this.f3699e.mo42b(genericParameterTypes[i3]);
    }

    @Override // p082b1.AbstractC1031b
    public final String toString() {
        return "[method " + mo2800j() + "]";
    }

    @Override // p082b1.AbstractC1048s
    /* JADX INFO: renamed from: u */
    public final Class mo2792u(int i3) {
        if (this.f3705i == null) {
            this.f3705i = this.f3704h.getParameterTypes();
        }
        Class[] clsArr = this.f3705i;
        if (clsArr.length <= 0) {
            return null;
        }
        return clsArr[0];
    }

    public Object writeReplace() {
        C1042m c1042m = new C1042m();
        Method method = this.f3704h;
        c1042m.f3701e = method.getDeclaringClass();
        c1042m.f3702f = method.getName();
        c1042m.f3703g = method.getParameterTypes();
        return new C1043n(c1042m);
    }

    public C1043n(C1042m c1042m) {
        super(null, null, null);
        this.f3704h = null;
        this.f3706j = c1042m;
    }
}

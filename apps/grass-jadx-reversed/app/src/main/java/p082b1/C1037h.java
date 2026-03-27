package p082b1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p001A.C0009j;
import p019F0.C0221e;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.C1743h;

/* JADX INFO: renamed from: b1.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1037h extends AbstractC1055z {

    /* JADX INFO: renamed from: e */
    public final boolean f3689e;

    /* JADX INFO: renamed from: f */
    public final Object f3690f;

    /* JADX INFO: renamed from: g */
    public Object f3691g;

    public C1037h(AbstractC0711b abstractC0711b, C1675q c1675q, InterfaceC1008D interfaceC1008D, boolean z3) {
        super(abstractC0711b);
        this.f3690f = c1675q;
        this.f3691g = abstractC0711b == null ? null : interfaceC1008D;
        this.f3689e = z3;
    }

    /* JADX INFO: renamed from: i */
    public Map m2793i(InterfaceC1027X interfaceC1027X, AbstractC0721l abstractC0721l) {
        InterfaceC1008D interfaceC1008D;
        Class clsMo2158a;
        C1040k c1040k;
        AbstractC0721l abstractC0721lMo1879n = abstractC0721l.mo1879n();
        if (abstractC0721lMo1879n == null) {
            return null;
        }
        Map mapM2793i = m2793i(new C0009j((C1675q) this.f3690f, 20, abstractC0721lMo1879n.mo1873h()), abstractC0721lMo1879n);
        Class cls = abstractC0721l.f2036e;
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isSynthetic() && !Modifier.isStatic(field.getModifiers())) {
                if (mapM2793i == null) {
                    mapM2793i = new LinkedHashMap();
                }
                C1040k c1040k2 = new C1040k(interfaceC1027X, field);
                if (this.f3689e) {
                    c1040k2.f3698c = m2810d(C1049t.f3718e, field.getDeclaredAnnotations());
                }
                mapM2793i.put(field.getName(), c1040k2);
            }
        }
        if (mapM2793i != null && (interfaceC1008D = (InterfaceC1008D) this.f3691g) != null && (clsMo2158a = interfaceC1008D.mo2158a(cls)) != null) {
            Iterator it = AbstractC1745j.m3889l(clsMo2158a, cls, true).iterator();
            while (it.hasNext()) {
                for (Field field2 : ((Class) it.next()).getDeclaredFields()) {
                    if (!field2.isSynthetic() && !Modifier.isStatic(field2.getModifiers()) && (c1040k = (C1040k) mapM2793i.get(field2.getName())) != null) {
                        c1040k.f3698c = m2810d(c1040k.f3698c, field2.getDeclaredAnnotations());
                    }
                }
            }
        }
        return mapM2793i;
    }

    /* JADX INFO: renamed from: j */
    public C0221e m2794j(C1743h c1743h, C1743h c1743h2) {
        if (!this.f3689e) {
            return new C0221e(14, false);
        }
        Annotation[] declaredAnnotations = c1743h.f6102b;
        if (declaredAnnotations == null) {
            declaredAnnotations = c1743h.f6101a.getDeclaredAnnotations();
            c1743h.f6102b = declaredAnnotations;
        }
        AbstractC1055z abstractC1055zM2811e = m2811e(declaredAnnotations);
        if (c1743h2 != null) {
            Annotation[] declaredAnnotations2 = c1743h2.f6102b;
            if (declaredAnnotations2 == null) {
                declaredAnnotations2 = c1743h2.f6101a.getDeclaredAnnotations();
                c1743h2.f6102b = declaredAnnotations2;
            }
            abstractC1055zM2811e = m2810d(abstractC1055zM2811e, declaredAnnotations2);
        }
        return abstractC1055zM2811e.mo2807b();
    }

    /* JADX INFO: renamed from: k */
    public C0221e[] m2795k(Annotation[][] annotationArr, Annotation[][] annotationArr2) {
        if (!this.f3689e) {
            return AbstractC1055z.f3729c;
        }
        int length = annotationArr.length;
        C0221e[] c0221eArr = new C0221e[length];
        for (int i3 = 0; i3 < length; i3++) {
            AbstractC1055z abstractC1055zM2810d = m2810d(C1049t.f3718e, annotationArr[i3]);
            if (annotationArr2 != null) {
                abstractC1055zM2810d = m2810d(abstractC1055zM2810d, annotationArr2[i3]);
            }
            c0221eArr[i3] = abstractC1055zM2810d.mo2807b();
        }
        return c0221eArr;
    }

    /* JADX INFO: renamed from: l */
    public C1043n m2796l(Method method, InterfaceC1027X interfaceC1027X, Method method2) {
        int parameterCount = method.getParameterCount();
        AbstractC0711b abstractC0711b = (AbstractC0711b) this.f3731a;
        C0221e[] c0221eArr = AbstractC1055z.f3729c;
        if (abstractC0711b == null) {
            C0221e c0221e = new C0221e(14, false);
            if (parameterCount != 0) {
                c0221eArr = new C0221e[parameterCount];
                for (int i3 = 0; i3 < parameterCount; i3++) {
                    c0221eArr[i3] = new C0221e(14, false);
                }
            }
            return new C1043n(interfaceC1027X, method, c0221e, c0221eArr);
        }
        if (parameterCount == 0) {
            AbstractC1055z abstractC1055zM2811e = m2811e(method.getDeclaredAnnotations());
            if (method2 != null) {
                abstractC1055zM2811e = m2810d(abstractC1055zM2811e, method2.getDeclaredAnnotations());
            }
            return new C1043n(interfaceC1027X, method, abstractC1055zM2811e.mo2807b(), c0221eArr);
        }
        AbstractC1055z abstractC1055zM2811e2 = m2811e(method.getDeclaredAnnotations());
        if (method2 != null) {
            abstractC1055zM2811e2 = m2810d(abstractC1055zM2811e2, method2.getDeclaredAnnotations());
        }
        return new C1043n(interfaceC1027X, method, abstractC1055zM2811e2.mo2807b(), m2795k(method.getParameterAnnotations(), method2 == null ? null : method2.getParameterAnnotations()));
    }

    /* JADX INFO: renamed from: m */
    public C1036g m2797m(C1743h c1743h, C1743h c1743h2) {
        int parameterCount = c1743h.f6104d;
        Constructor constructor = c1743h.f6101a;
        if (parameterCount < 0) {
            parameterCount = constructor.getParameterCount();
            c1743h.f6104d = parameterCount;
        }
        C0221e[] c0221eArr = AbstractC1055z.f3729c;
        AbstractC0711b abstractC0711b = (AbstractC0711b) this.f3731a;
        InterfaceC1027X interfaceC1027X = (InterfaceC1027X) this.f3690f;
        if (abstractC0711b == null) {
            C0221e c0221e = new C0221e(14, false);
            if (parameterCount != 0) {
                c0221eArr = new C0221e[parameterCount];
                for (int i3 = 0; i3 < parameterCount; i3++) {
                    c0221eArr[i3] = new C0221e(14, false);
                }
            }
            return new C1036g(interfaceC1027X, constructor, c0221e, c0221eArr);
        }
        if (parameterCount == 0) {
            return new C1036g(interfaceC1027X, constructor, m2794j(c1743h, c1743h2), c0221eArr);
        }
        Annotation[][] parameterAnnotations = c1743h.f6103c;
        if (parameterAnnotations == null) {
            parameterAnnotations = constructor.getParameterAnnotations();
            c1743h.f6103c = parameterAnnotations;
        }
        Annotation[][] annotationArr = null;
        c0221eArrM2795k = null;
        C0221e[] c0221eArrM2795k = null;
        if (parameterCount != parameterAnnotations.length) {
            Class declaringClass = constructor.getDeclaringClass();
            Annotation[] annotationArr2 = AbstractC1745j.f6110a;
            if (Enum.class.isAssignableFrom(declaringClass) && parameterCount == parameterAnnotations.length + 2) {
                Annotation[][] annotationArr3 = new Annotation[parameterAnnotations.length + 2][];
                System.arraycopy(parameterAnnotations, 0, annotationArr3, 2, parameterAnnotations.length);
                c0221eArrM2795k = m2795k(annotationArr3, null);
                parameterAnnotations = annotationArr3;
            } else if (declaringClass.isMemberClass() && parameterCount == parameterAnnotations.length + 1) {
                Annotation[][] annotationArr4 = new Annotation[parameterAnnotations.length + 1][];
                System.arraycopy(parameterAnnotations, 0, annotationArr4, 1, parameterAnnotations.length);
                annotationArr4[0] = AbstractC1055z.f3730d;
                c0221eArrM2795k = m2795k(annotationArr4, null);
                parameterAnnotations = annotationArr4;
            }
            if (c0221eArrM2795k == null) {
                throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", constructor.getDeclaringClass().getName(), Integer.valueOf(parameterCount), Integer.valueOf(parameterAnnotations.length)));
            }
        } else {
            if (c1743h2 != null) {
                Annotation[][] parameterAnnotations2 = c1743h2.f6103c;
                if (parameterAnnotations2 == null) {
                    parameterAnnotations2 = c1743h2.f6101a.getParameterAnnotations();
                    c1743h2.f6103c = parameterAnnotations2;
                }
                annotationArr = parameterAnnotations2;
            }
            c0221eArrM2795k = m2795k(parameterAnnotations, annotationArr);
        }
        return new C1036g(interfaceC1027X, constructor, m2794j(c1743h, c1743h2), c0221eArrM2795k);
    }

    public C1037h(AbstractC0711b abstractC0711b, InterfaceC1027X interfaceC1027X, boolean z3) {
        super(abstractC0711b);
        this.f3690f = interfaceC1027X;
        this.f3689e = z3;
    }
}

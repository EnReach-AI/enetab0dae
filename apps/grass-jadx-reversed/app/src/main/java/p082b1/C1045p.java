package p082b1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import p069X0.AbstractC0711b;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1045p extends AbstractC1055z {

    /* JADX INFO: renamed from: e */
    public final InterfaceC1008D f3710e;

    /* JADX INFO: renamed from: f */
    public final boolean f3711f;

    public C1045p(AbstractC0711b abstractC0711b, InterfaceC1008D interfaceC1008D, boolean z3) {
        super(abstractC0711b);
        this.f3710e = abstractC0711b == null ? null : interfaceC1008D;
        this.f3711f = z3;
    }

    /* JADX INFO: renamed from: k */
    public static boolean m2802k(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterCount() > 2) ? false : true;
    }

    /* JADX INFO: renamed from: i */
    public final void m2803i(InterfaceC1027X interfaceC1027X, Class cls, LinkedHashMap linkedHashMap, Class cls2) {
        if (cls2 != null) {
            m2804j(interfaceC1027X, cls, linkedHashMap, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : AbstractC1745j.m3891n(cls)) {
            if (m2802k(method)) {
                C1015K c1015k = new C1015K(method);
                C1044o c1044o = (C1044o) linkedHashMap.get(c1015k);
                if (c1044o == null) {
                    linkedHashMap.put(c1015k, new C1044o(interfaceC1027X, method, ((AbstractC0711b) this.f3731a) == null ? C1049t.f3718e : m2811e(method.getDeclaredAnnotations())));
                } else {
                    if (this.f3711f) {
                        c1044o.f3709c = m2812f(c1044o.f3709c, method.getDeclaredAnnotations());
                    }
                    Method method2 = c1044o.f3708b;
                    if (method2 == null) {
                        c1044o.f3708b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        c1044o.f3708b = method;
                        c1044o.f3707a = interfaceC1027X;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m2804j(InterfaceC1027X interfaceC1027X, Class cls, LinkedHashMap linkedHashMap, Class cls2) {
        List listEmptyList;
        if (((AbstractC0711b) this.f3731a) == null) {
            return;
        }
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        if (cls2 == null || cls2 == cls || cls2 == Object.class) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(8);
            AbstractC1745j.m3878a(cls2, cls, arrayList);
            listEmptyList = arrayList;
        }
        Iterator it = listEmptyList.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (m2802k(method)) {
                    C1015K c1015k = new C1015K(method);
                    C1044o c1044o = (C1044o) linkedHashMap.get(c1015k);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (c1044o == null) {
                        linkedHashMap.put(c1015k, new C1044o(interfaceC1027X, null, m2811e(declaredAnnotations)));
                    } else {
                        c1044o.f3709c = m2812f(c1044o.f3709c, declaredAnnotations);
                    }
                }
            }
        }
    }
}

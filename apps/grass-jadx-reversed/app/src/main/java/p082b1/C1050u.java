package p082b1;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p019F0.C0221e;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.u */
/* JADX INFO: loaded from: classes.dex */
public final class C1050u extends AbstractC1055z {

    /* JADX INFO: renamed from: e */
    public final HashMap f3719e;

    public C1050u(Object obj, Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
        super(obj);
        HashMap map = new HashMap();
        this.f3719e = map;
        map.put(cls, annotation);
        map.put(cls2, annotation2);
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: a */
    public final AbstractC1055z mo2806a(Annotation annotation) {
        this.f3719e.put(annotation.annotationType(), annotation);
        return this;
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: b */
    public final C0221e mo2807b() {
        C0221e c0221e = new C0221e(14, false);
        for (Annotation annotation : this.f3719e.values()) {
            if (((HashMap) c0221e.f534f) == null) {
                c0221e.f534f = new HashMap();
            }
            Annotation annotation2 = (Annotation) ((HashMap) c0221e.f534f).put(annotation.annotationType(), annotation);
            if (annotation2 != null) {
                annotation2.equals(annotation);
            }
        }
        return c0221e;
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: c */
    public final InterfaceC1737b mo2808c() {
        HashMap map = this.f3719e;
        if (map.size() != 2) {
            return new C0221e(14, map);
        }
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        Map.Entry entry2 = (Map.Entry) it.next();
        return new C1054y((Class) entry.getKey(), (Annotation) entry.getValue(), (Class) entry2.getKey(), (Annotation) entry2.getValue());
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: h */
    public final boolean mo2809h(Annotation annotation) {
        return this.f3719e.containsKey(annotation.annotationType());
    }
}

package p082b1;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import p019F0.C0221e;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1053x extends AbstractC1055z {

    /* JADX INFO: renamed from: e */
    public Class f3722e;

    /* JADX INFO: renamed from: f */
    public Annotation f3723f;

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: a */
    public final AbstractC1055z mo2806a(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Class<? extends Annotation> cls = this.f3722e;
        if (cls != clsAnnotationType) {
            return new C1050u(this.f3731a, cls, this.f3723f, clsAnnotationType, annotation);
        }
        this.f3723f = annotation;
        return this;
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: b */
    public final C0221e mo2807b() {
        Annotation annotation = this.f3723f;
        HashMap map = new HashMap(4);
        map.put(this.f3722e, annotation);
        return new C0221e(14, map);
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: c */
    public final InterfaceC1737b mo2808c() {
        return new C1052w(this.f3722e, this.f3723f);
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: h */
    public final boolean mo2809h(Annotation annotation) {
        return annotation.annotationType() == this.f3722e;
    }
}

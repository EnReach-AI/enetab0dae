package p082b1;

import java.lang.annotation.Annotation;
import p019F0.C0221e;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1049t extends AbstractC1055z {

    /* JADX INFO: renamed from: e */
    public static final C1049t f3718e = new C1049t(null);

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: a */
    public final AbstractC1055z mo2806a(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        C1053x c1053x = new C1053x(this.f3731a);
        c1053x.f3722e = clsAnnotationType;
        c1053x.f3723f = annotation;
        return c1053x;
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: b */
    public final C0221e mo2807b() {
        return new C0221e(14, false);
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: c */
    public final InterfaceC1737b mo2808c() {
        return AbstractC1055z.f3728b;
    }

    @Override // p082b1.AbstractC1055z
    /* JADX INFO: renamed from: h */
    public final boolean mo2809h(Annotation annotation) {
        return false;
    }
}

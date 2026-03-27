package p082b1;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import p019F0.C0221e;
import p069X0.AbstractC0711b;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.z */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1055z {

    /* JADX INFO: renamed from: b */
    public static final C1051v f3728b = new C1051v();

    /* JADX INFO: renamed from: c */
    public static final C0221e[] f3729c = new C0221e[0];

    /* JADX INFO: renamed from: d */
    public static final Annotation[] f3730d = new Annotation[0];

    /* JADX INFO: renamed from: a */
    public final Object f3731a;

    /* JADX INFO: renamed from: a */
    public abstract AbstractC1055z mo2806a(Annotation annotation);

    /* JADX INFO: renamed from: b */
    public abstract C0221e mo2807b();

    /* JADX INFO: renamed from: c */
    public abstract InterfaceC1737b mo2808c();

    /* JADX INFO: renamed from: d */
    public AbstractC1055z m2810d(AbstractC1055z abstractC1055z, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            abstractC1055z = abstractC1055z.mo2806a(annotation);
            if (((AbstractC0711b) this.f3731a).mo1780m0(annotation)) {
                abstractC1055z = m2813g(abstractC1055z, annotation);
            }
        }
        return abstractC1055z;
    }

    /* JADX INFO: renamed from: e */
    public AbstractC1055z m2811e(Annotation[] annotationArr) {
        AbstractC1055z abstractC1055zMo2806a = C1049t.f3718e;
        for (Annotation annotation : annotationArr) {
            abstractC1055zMo2806a = abstractC1055zMo2806a.mo2806a(annotation);
            if (((AbstractC0711b) this.f3731a).mo1780m0(annotation)) {
                abstractC1055zMo2806a = m2813g(abstractC1055zMo2806a, annotation);
            }
        }
        return abstractC1055zMo2806a;
    }

    /* JADX INFO: renamed from: f */
    public AbstractC1055z m2812f(AbstractC1055z abstractC1055z, Annotation[] annotationArr) {
        for (Annotation annotation : annotationArr) {
            if (!abstractC1055z.mo2809h(annotation)) {
                abstractC1055z = abstractC1055z.mo2806a(annotation);
                AbstractC0711b abstractC0711b = (AbstractC0711b) this.f3731a;
                if (abstractC0711b.mo1780m0(annotation)) {
                    for (Annotation annotation2 : AbstractC1745j.m3887j(annotation.annotationType())) {
                        if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !abstractC1055z.mo2809h(annotation2)) {
                            abstractC1055z = abstractC1055z.mo2806a(annotation2);
                            if (abstractC0711b.mo1780m0(annotation2)) {
                                abstractC1055z = m2813g(abstractC1055z, annotation2);
                            }
                        }
                    }
                }
            }
        }
        return abstractC1055z;
    }

    /* JADX INFO: renamed from: g */
    public AbstractC1055z m2813g(AbstractC1055z abstractC1055z, Annotation annotation) {
        for (Annotation annotation2 : AbstractC1745j.m3887j(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention)) {
                if (!((AbstractC0711b) this.f3731a).mo1780m0(annotation2)) {
                    abstractC1055z = abstractC1055z.mo2806a(annotation2);
                } else if (!abstractC1055z.mo2809h(annotation2)) {
                    abstractC1055z = m2813g(abstractC1055z.mo2806a(annotation2), annotation2);
                }
            }
        }
        return abstractC1055z;
    }

    /* JADX INFO: renamed from: h */
    public abstract boolean mo2809h(Annotation annotation);
}

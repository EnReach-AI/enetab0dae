package p082b1;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.y */
/* JADX INFO: loaded from: classes.dex */
public final class C1054y implements InterfaceC1737b, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f3724e;

    /* JADX INFO: renamed from: f */
    public final Class f3725f;

    /* JADX INFO: renamed from: g */
    public final Annotation f3726g;

    /* JADX INFO: renamed from: h */
    public final Annotation f3727h;

    public C1054y(Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
        this.f3724e = cls;
        this.f3726g = annotation;
        this.f3725f = cls2;
        this.f3727h = annotation2;
    }

    @Override // p118m1.InterfaceC1737b
    /* JADX INFO: renamed from: a */
    public final Annotation mo442a(Class cls) {
        if (this.f3724e == cls) {
            return this.f3726g;
        }
        if (this.f3725f == cls) {
            return this.f3727h;
        }
        return null;
    }

    @Override // p118m1.InterfaceC1737b
    /* JADX INFO: renamed from: o */
    public final boolean mo454o(Class[] clsArr) {
        for (Class cls : clsArr) {
            if (cls == this.f3724e || cls == this.f3725f) {
                return true;
            }
        }
        return false;
    }

    @Override // p118m1.InterfaceC1737b
    public final int size() {
        return 2;
    }
}

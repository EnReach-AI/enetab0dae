package p082b1;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p118m1.InterfaceC1737b;

/* JADX INFO: renamed from: b1.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1052w implements InterfaceC1737b, Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f3720e;

    /* JADX INFO: renamed from: f */
    public final Annotation f3721f;

    public C1052w(Class cls, Annotation annotation) {
        this.f3720e = cls;
        this.f3721f = annotation;
    }

    @Override // p118m1.InterfaceC1737b
    /* JADX INFO: renamed from: a */
    public final Annotation mo442a(Class cls) {
        if (this.f3720e == cls) {
            return this.f3721f;
        }
        return null;
    }

    @Override // p118m1.InterfaceC1737b
    /* JADX INFO: renamed from: o */
    public final boolean mo454o(Class[] clsArr) {
        for (Class cls : clsArr) {
            if (cls == this.f3720e) {
                return true;
            }
        }
        return false;
    }

    @Override // p118m1.InterfaceC1737b
    public final int size() {
        return 1;
    }
}

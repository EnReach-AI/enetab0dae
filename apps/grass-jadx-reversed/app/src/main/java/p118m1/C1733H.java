package p118m1;

/* JADX INFO: renamed from: m1.H */
/* JADX INFO: loaded from: classes.dex */
public final class C1733H extends C1735J {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f */
    public final Class[] f6078f;

    public C1733H(Class[] clsArr) {
        this.f6078f = clsArr;
    }

    @Override // p118m1.C1735J
    /* JADX INFO: renamed from: a */
    public final boolean mo3863a(Class cls) {
        for (Class cls2 : this.f6078f) {
            if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }
}

package p118m1;

/* JADX INFO: renamed from: m1.I */
/* JADX INFO: loaded from: classes.dex */
public final class C1734I extends C1735J {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f */
    public final Class f6079f;

    public C1734I(Class cls) {
        this.f6079f = cls;
    }

    @Override // p118m1.C1735J
    /* JADX INFO: renamed from: a */
    public final boolean mo3863a(Class cls) {
        Class cls2 = this.f6079f;
        return cls == cls2 || cls2.isAssignableFrom(cls);
    }
}

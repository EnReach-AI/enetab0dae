package p026I;

/* JADX INFO: renamed from: I.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0297e extends C0296d {

    /* JADX INFO: renamed from: d */
    public final Object f798d;

    public C0297e() {
        super(12);
        this.f798d = new Object();
    }

    @Override // p026I.C0296d
    /* JADX INFO: renamed from: a */
    public final Object mo571a() {
        Object objMo571a;
        synchronized (this.f798d) {
            objMo571a = super.mo571a();
        }
        return objMo571a;
    }

    @Override // p026I.C0296d
    /* JADX INFO: renamed from: c */
    public final boolean mo573c(Object obj) {
        boolean zMo573c;
        synchronized (this.f798d) {
            zMo573c = super.mo573c(obj);
        }
        return zMo573c;
    }
}

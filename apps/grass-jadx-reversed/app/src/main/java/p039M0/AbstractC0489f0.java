package p039M0;

/* JADX INFO: renamed from: M0.f0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0489f0 extends AbstractC0485d0 {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f1131e;

    public AbstractC0489f0(Class cls) {
        this.f1131e = cls;
    }

    @Override // p039M0.AbstractC0485d0
    /* JADX INFO: renamed from: a */
    public boolean mo1001a(AbstractC0485d0 abstractC0485d0) {
        if (abstractC0485d0.getClass() == getClass()) {
            if (((AbstractC0489f0) abstractC0485d0).f1131e == this.f1131e) {
                return true;
            }
        }
        return false;
    }
}

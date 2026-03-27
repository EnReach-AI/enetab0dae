package p074Z0;

/* JADX INFO: renamed from: Z0.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0827m {

    /* JADX INFO: renamed from: a */
    public static final C0828n f2458a;

    static {
        for (EnumC0830p enumC0830p : EnumC0830p.values()) {
            enumC0830p.getClass();
        }
        int iMo1234a = 0;
        for (EnumC0831q enumC0831q : EnumC0831q.values()) {
            enumC0831q.getClass();
            iMo1234a |= enumC0831q.mo1234a();
        }
        f2458a = new C0828n(0, iMo1234a);
    }
}

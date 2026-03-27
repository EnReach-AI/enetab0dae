package p066W0;

/* JADX INFO: renamed from: W0.k */
/* JADX INFO: loaded from: classes.dex */
public final class C0684k {

    /* JADX INFO: renamed from: a */
    public int f1859a;

    public /* synthetic */ C0684k(int i3) {
        this.f1859a = i3;
    }

    /* JADX INFO: renamed from: a */
    public static C0684k m1644a(InterfaceC0683j[] interfaceC0683jArr) {
        if (interfaceC0683jArr.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", interfaceC0683jArr[0].getClass().getName(), Integer.valueOf(interfaceC0683jArr.length)));
        }
        int iMo1234a = 0;
        for (InterfaceC0683j interfaceC0683j : interfaceC0683jArr) {
            if (interfaceC0683j.mo1235b()) {
                iMo1234a |= interfaceC0683j.mo1234a();
            }
        }
        return new C0684k(iMo1234a);
    }
}

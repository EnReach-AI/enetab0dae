package p089d2;

import java.io.Serializable;

/* JADX INFO: renamed from: d2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1308b implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: e */
    public final InterfaceC1317k[] f4668e;

    public C1308b(InterfaceC1317k[] interfaceC1317kArr) {
        this.f4668e = interfaceC1317kArr;
    }

    private final Object readResolve() {
        InterfaceC1317k interfaceC1317kPlus = C1318l.f4678e;
        for (InterfaceC1317k interfaceC1317k : this.f4668e) {
            interfaceC1317kPlus = interfaceC1317kPlus.plus(interfaceC1317k);
        }
        return interfaceC1317kPlus;
    }
}

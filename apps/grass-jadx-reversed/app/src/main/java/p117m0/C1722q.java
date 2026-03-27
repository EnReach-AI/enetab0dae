package p117m0;

import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: renamed from: m0.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1722q implements Serializable {
    private static final long serialVersionUID = 20160629001L;

    /* JADX INFO: renamed from: e */
    public final HashMap f6010e;

    public C1722q(HashMap map) {
        this.f6010e = map;
    }

    private Object readResolve() {
        C1723r c1723r = new C1723r();
        HashMap map = new HashMap();
        c1723r.f6011e = map;
        map.putAll(this.f6010e);
        return c1723r;
    }
}

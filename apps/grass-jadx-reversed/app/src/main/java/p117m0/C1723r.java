package p117m0;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: m0.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1723r implements Serializable {
    private static final long serialVersionUID = 20160629001L;

    /* JADX INFO: renamed from: e */
    public HashMap f6011e;

    private Object writeReplace() {
        if (AbstractC0147a.f354a.contains(this)) {
            return null;
        }
        try {
            return new C1722q(this.f6011e);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3823a(C1707b c1707b, List list) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        HashMap map = this.f6011e;
        try {
            if (map.containsKey(c1707b)) {
                ((List) map.get(c1707b)).addAll(list);
            } else {
                map.put(c1707b, list);
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}

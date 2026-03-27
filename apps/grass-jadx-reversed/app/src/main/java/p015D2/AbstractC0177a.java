package p015D2;

import p083b2.C1062g;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1899n;

/* JADX INFO: renamed from: D2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0177a {

    /* JADX INFO: renamed from: a */
    public static final int f415a;

    static {
        Object c1062g;
        try {
            String property = System.getProperty("kotlinx.serialization.json.pool.size");
            AbstractC1766e.m3919d("getProperty(...)", property);
            c1062g = AbstractC1899n.m4229f(property);
        } catch (Throwable th) {
            c1062g = new C1062g(th);
        }
        if (c1062g instanceof C1062g) {
            c1062g = null;
        }
        Integer num = (Integer) c1062g;
        f415a = num != null ? num.intValue() : 2097152;
    }
}

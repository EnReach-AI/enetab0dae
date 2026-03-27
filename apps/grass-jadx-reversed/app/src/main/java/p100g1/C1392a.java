package p100g1;

import java.io.Closeable;
import java.io.Serializable;
import java.util.HashSet;

/* JADX INFO: renamed from: g1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1392a {

    /* JADX INFO: renamed from: b */
    public static final C1392a f5022b = new C1392a();

    /* JADX INFO: renamed from: a */
    public final HashSet f5023a;

    public C1392a() {
        HashSet hashSet = new HashSet();
        this.f5023a = hashSet;
        hashSet.add(Object.class.getName());
        hashSet.add(Closeable.class.getName());
        hashSet.add(Serializable.class.getName());
        hashSet.add(AutoCloseable.class.getName());
        hashSet.add(Cloneable.class.getName());
        hashSet.add("java.util.logging.Handler");
        hashSet.add("javax.naming.Referenceable");
        hashSet.add("javax.sql.DataSource");
    }
}

package p074Z0;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: Z0.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0824j extends AbstractC0825k implements Serializable {

    /* JADX INFO: renamed from: g */
    public static final C0824j f2454g = new C0824j(Collections.emptyMap());

    /* JADX INFO: renamed from: h */
    public static final Object f2455h = new Object();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Map f2456e;

    /* JADX INFO: renamed from: f */
    public final transient Map f2457f;

    public C0824j(Map map) {
        this.f2456e = map;
        this.f2457f = null;
    }

    public C0824j(Map map, HashMap map2) {
        this.f2456e = map;
        this.f2457f = map2;
    }
}

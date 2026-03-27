package p113l;

import java.util.concurrent.Executors;
import p156w0.AbstractC1986a;

/* JADX INFO: renamed from: l.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1657a extends AbstractC1986a {

    /* JADX INFO: renamed from: g */
    public static volatile C1657a f5879g;

    /* JADX INFO: renamed from: f */
    public Object f5880f;

    /* JADX INFO: renamed from: u */
    public static C1657a m3748u() {
        if (f5879g != null) {
            return f5879g;
        }
        synchronized (C1657a.class) {
            try {
                if (f5879g == null) {
                    C1657a c1657a = new C1657a();
                    C1657a c1657a2 = new C1657a();
                    c1657a2.f5880f = new Object();
                    Executors.newFixedThreadPool(4, new ThreadFactoryC1658b());
                    c1657a.f5880f = c1657a2;
                    f5879g = c1657a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f5879g;
    }
}

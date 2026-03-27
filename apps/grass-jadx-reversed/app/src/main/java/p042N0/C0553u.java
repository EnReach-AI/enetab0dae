package p042N0;

import com.fasterxml.jackson.core.exc.C1131b;
import java.io.Serializable;

/* JADX INFO: renamed from: N0.u */
/* JADX INFO: loaded from: classes.dex */
public final class C0553u implements Serializable {

    /* JADX INFO: renamed from: e */
    public static final C0553u f1339e = new C0553u();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a */
    public static void m1236a(int i3) throws C1131b {
        if (Math.abs(i3) > 100000) {
            throw new C1131b(String.format("BigDecimal scale (%d) magnitude exceeds maximum allowed (%d)", Integer.valueOf(i3), 100000));
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1237b(int i3) throws C1131b {
        if (i3 > 1000) {
            throw new C1131b(String.format("Number length (%d) exceeds the maximum length (%d)", Integer.valueOf(i3), 1000));
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m1238c(int i3) throws C1131b {
        if (i3 > 1000) {
            throw new C1131b(String.format("Number length (%d) exceeds the maximum length (%d)", Integer.valueOf(i3), 1000));
        }
    }
}

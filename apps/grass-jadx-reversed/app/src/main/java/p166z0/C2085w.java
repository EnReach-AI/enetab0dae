package p166z0;

import com.facebook.AbstractC1117n;
import java.util.HashMap;

/* JADX INFO: renamed from: z0.w */
/* JADX INFO: loaded from: classes.dex */
public final class C2085w {

    /* JADX INFO: renamed from: b */
    public static final HashMap f7377b = new HashMap();

    /* JADX INFO: renamed from: a */
    public StringBuilder f7378a;

    /* JADX INFO: renamed from: a */
    public static synchronized void m4628a(String str) {
        AbstractC1117n.m2896f();
        synchronized (C2085w.class) {
            f7377b.put(str, "ACCESS_TOKEN_REMOVED");
        }
    }
}

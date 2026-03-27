package p066W0;

import p001A.C0009j;

/* JADX INFO: renamed from: W0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0675b {

    /* JADX INFO: renamed from: a */
    public static final C0009j f1836a;

    /* JADX INFO: renamed from: b */
    public static final ThreadLocal f1837b;

    static {
        boolean zEquals;
        try {
            zEquals = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers"));
        } catch (SecurityException unused) {
            zEquals = false;
        }
        f1836a = zEquals ? AbstractC0691r.f1880a : null;
        f1837b = new ThreadLocal();
    }
}

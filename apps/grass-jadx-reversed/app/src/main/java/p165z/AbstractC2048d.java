package p165z;

import android.content.Context;

/* JADX INFO: renamed from: z.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2048d {
    /* JADX INFO: renamed from: a */
    public static int m4520a(Context context, int i3) {
        return context.getColor(i3);
    }

    /* JADX INFO: renamed from: b */
    public static <T> T m4521b(Context context, Class<T> cls) {
        return (T) context.getSystemService(cls);
    }

    /* JADX INFO: renamed from: c */
    public static String m4522c(Context context, Class<?> cls) {
        return context.getSystemServiceName(cls);
    }
}

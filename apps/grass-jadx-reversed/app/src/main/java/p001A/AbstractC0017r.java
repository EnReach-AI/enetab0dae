package p001A;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: A.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0017r {

    /* JADX INFO: renamed from: a */
    public static final ThreadLocal f43a = new ThreadLocal();

    /* JADX INFO: renamed from: b */
    public static final WeakHashMap f44b = new WeakHashMap(0);

    /* JADX INFO: renamed from: c */
    public static final Object f45c = new Object();

    /* JADX INFO: renamed from: a */
    public static Typeface m72a(Context context, int i3) {
        if (context.isRestricted()) {
            return null;
        }
        return m73b(context, i3, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface m73b(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, p001A.AbstractC0001b r20, boolean r21, boolean r22) {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p001A.AbstractC0017r.m73b(android.content.Context, int, android.util.TypedValue, int, A.b, boolean, boolean):android.graphics.Typeface");
    }
}

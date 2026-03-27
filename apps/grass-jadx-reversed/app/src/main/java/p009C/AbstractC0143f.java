package p009C;

import android.graphics.drawable.Icon;
import android.net.Uri;

/* JADX INFO: renamed from: C.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0143f {
    /* JADX INFO: renamed from: a */
    public static int m289a(Object obj) {
        return ((Icon) obj).getResId();
    }

    /* JADX INFO: renamed from: b */
    public static String m290b(Object obj) {
        return ((Icon) obj).getResPackage();
    }

    /* JADX INFO: renamed from: c */
    public static int m291c(Object obj) {
        return ((Icon) obj).getType();
    }

    /* JADX INFO: renamed from: d */
    public static Uri m292d(Object obj) {
        return ((Icon) obj).getUri();
    }
}

package p165z;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: z.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2046b {
    /* JADX INFO: renamed from: a */
    public static File[] m4514a(Context context) {
        return context.getExternalCacheDirs();
    }

    /* JADX INFO: renamed from: b */
    public static File[] m4515b(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    /* JADX INFO: renamed from: c */
    public static File[] m4516c(Context context) {
        return context.getObbDirs();
    }
}

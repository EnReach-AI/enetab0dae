package p165z;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.io.File;

/* JADX INFO: renamed from: z.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2047c {
    /* JADX INFO: renamed from: a */
    public static File m4517a(Context context) {
        return context.getCodeCacheDir();
    }

    /* JADX INFO: renamed from: b */
    public static Drawable m4518b(Context context, int i3) {
        return context.getDrawable(i3);
    }

    /* JADX INFO: renamed from: c */
    public static File m4519c(Context context) {
        return context.getNoBackupFilesDir();
    }
}

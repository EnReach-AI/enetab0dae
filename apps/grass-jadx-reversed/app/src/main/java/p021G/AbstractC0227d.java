package p021G;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;

/* JADX INFO: renamed from: G.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0227d {
    /* JADX INFO: renamed from: a */
    public static Cursor m472a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
        return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
    }
}

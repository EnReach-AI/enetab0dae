package p005B;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;

/* JADX INFO: renamed from: B.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0037l {
    /* JADX INFO: renamed from: a */
    public static ParcelFileDescriptor m189a(ContentResolver contentResolver, Uri uri, String str, CancellationSignal cancellationSignal) {
        return contentResolver.openFileDescriptor(uri, str, cancellationSignal);
    }
}

package p162y;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: y.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2039r {
    /* JADX INFO: renamed from: a */
    public static void m4500a(C2041t c2041t, Intent intent, Map<String, Uri> map) {
        RemoteInput.addDataResultToIntent(C2041t.m4506a(c2041t), intent, map);
    }

    /* JADX INFO: renamed from: b */
    public static Set<String> m4501b(Object obj) {
        return ((RemoteInput) obj).getAllowedDataTypes();
    }

    /* JADX INFO: renamed from: c */
    public static Map<String, Uri> m4502c(Intent intent, String str) {
        return RemoteInput.getDataResultsFromIntent(intent, str);
    }

    /* JADX INFO: renamed from: d */
    public static RemoteInput.Builder m4503d(RemoteInput.Builder builder, String str, boolean z3) {
        return builder.setAllowDataType(str, z3);
    }
}

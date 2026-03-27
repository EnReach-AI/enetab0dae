package p162y;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: y.t */
/* JADX INFO: loaded from: classes.dex */
public final class C2041t {

    /* JADX INFO: renamed from: b */
    public final CharSequence f7243b;

    /* JADX INFO: renamed from: d */
    public final Bundle f7245d;

    /* JADX INFO: renamed from: e */
    public final Set f7246e;

    /* JADX INFO: renamed from: a */
    public final String f7242a = "NotificationRemoteInput";

    /* JADX INFO: renamed from: c */
    public final boolean f7244c = true;

    public C2041t(String str, Bundle bundle, HashSet hashSet) {
        this.f7243b = str;
        this.f7245d = bundle;
        this.f7246e = hashSet;
    }

    /* JADX INFO: renamed from: a */
    public static RemoteInput m4506a(C2041t c2041t) {
        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(c2041t.f7242a).setLabel(c2041t.f7243b).setChoices(null).setAllowFreeFormInput(c2041t.f7244c).addExtras(c2041t.f7245d);
        Set set = c2041t.f7246e;
        if (set != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                AbstractC2039r.m4503d(builderAddExtras, (String) it.next(), true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC2040s.m4505b(builderAddExtras, 0);
        }
        return builderAddExtras.build();
    }
}

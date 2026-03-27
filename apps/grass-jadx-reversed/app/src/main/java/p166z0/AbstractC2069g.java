package p166z0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import com.facebook.AbstractC1117n;
import com.facebook.C1118o;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p005B.AbstractC0032g;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: z0.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2069g {

    /* JADX INFO: renamed from: a */
    public static final String[] f7307a = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int f7308b = 0;

    /* JADX INFO: renamed from: a */
    public static String m4577a() {
        if (AbstractC0147a.f354a.contains(AbstractC2069g.class)) {
            return null;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            m4584h();
            Context context = AbstractC1117n.f3882h;
            List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 0);
            if (listQueryIntentServices != null) {
                HashSet hashSet2 = new HashSet(Arrays.asList(f7307a));
                Iterator<ResolveInfo> it = listQueryIntentServices.iterator();
                while (it.hasNext()) {
                    ServiceInfo serviceInfo = it.next().serviceInfo;
                    if (serviceInfo != null && hashSet2.contains(serviceInfo.packageName)) {
                        return serviceInfo.packageName;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2069g.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m4578b() {
        if (AbstractC0147a.f354a.contains(AbstractC2069g.class)) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder("fbconnect://cct.");
            HashSet hashSet = AbstractC1117n.f3875a;
            m4584h();
            sb.append(AbstractC1117n.f3882h.getPackageName());
            return sb.toString();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2069g.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m4579c(String str) {
        if (AbstractC0147a.f354a.contains(AbstractC2069g.class)) {
            return null;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            m4584h();
            if (m4580d(AbstractC1117n.f3882h, str)) {
                return str;
            }
            m4584h();
            return m4580d(AbstractC1117n.f3882h, m4578b()) ? m4578b() : "";
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2069g.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static boolean m4580d(Context context, String str) {
        List<ResolveInfo> listQueryIntentActivities;
        m4582f("context", context);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        } else {
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!activityInfo.name.equals("com.facebook.CustomTabActivity") || !activityInfo.packageName.equals(context.getPackageName())) {
                return false;
            }
            z3 = true;
        }
        return z3;
    }

    /* JADX INFO: renamed from: e */
    public static void m4581e(Collection collection) {
        m4582f("requests", collection);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container 'requests' cannot contain null values");
            }
        }
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container 'requests' cannot be empty");
        }
    }

    /* JADX INFO: renamed from: f */
    public static void m4582f(String str, Object obj) {
        if (obj == null) {
            throw new NullPointerException(AbstractC0032g.m154l("Argument '", str, "' cannot be null"));
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m4583g(String str, String str2) {
        if (AbstractC2056E.m4550s(str)) {
            throw new IllegalArgumentException(AbstractC0032g.m154l("Argument '", str2, "' cannot be null or empty"));
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m4584h() {
        if (!AbstractC1117n.m2895e()) {
            throw new C1118o("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }
}

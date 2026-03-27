package p163y0;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.facebook.AbstractC1117n;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;
import p166z0.EnumC2053B;

/* JADX INFO: renamed from: y0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2043b {

    /* JADX INFO: renamed from: a */
    public static final HashMap f7249a = new HashMap();

    /* JADX INFO: renamed from: a */
    public static void m4507a(String str) {
        if (AbstractC0147a.f354a.contains(AbstractC2043b.class)) {
            return;
        }
        try {
            m4508b(str);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2043b.class);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4508b(String str) {
        if (AbstractC0147a.f354a.contains(AbstractC2043b.class)) {
            return;
        }
        HashMap map = f7249a;
        try {
            NsdManager.RegistrationListener registrationListener = (NsdManager.RegistrationListener) map.get(str);
            if (registrationListener != null) {
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                try {
                    ((NsdManager) AbstractC1117n.f3882h.getSystemService("servicediscovery")).unregisterService(registrationListener);
                } catch (IllegalArgumentException unused) {
                    HashSet hashSet2 = AbstractC1117n.f3875a;
                }
                map.remove(str);
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2043b.class);
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m4509c() {
        if (AbstractC0147a.f354a.contains(AbstractC2043b.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device", Build.DEVICE);
                jSONObject.put("model", Build.MODEL);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2043b.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static boolean m4510d() {
        if (AbstractC0147a.f354a.contains(AbstractC2043b.class)) {
            return false;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079qM4621b = AbstractC2082t.m4621b(AbstractC1117n.f3877c);
            if (c2079qM4621b != null) {
                return c2079qM4621b.f7352c.contains(EnumC2053B.Enabled);
            }
            return false;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2043b.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    public static boolean m4511e(String str) {
        if (AbstractC0147a.f354a.contains(AbstractC2043b.class)) {
            return false;
        }
        try {
            HashMap map = f7249a;
            if (map.containsKey(str)) {
                return true;
            }
            HashSet hashSet = AbstractC1117n.f3875a;
            String str2 = "fbsdk_" + ("android-" + "8.2.0".replace('.', '|')) + "_" + str;
            NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
            nsdServiceInfo.setServiceType("_fb._tcp.");
            nsdServiceInfo.setServiceName(str2);
            nsdServiceInfo.setPort(80);
            AbstractC2069g.m4584h();
            NsdManager nsdManager = (NsdManager) AbstractC1117n.f3882h.getSystemService("servicediscovery");
            C2042a c2042a = new C2042a(str2, str);
            map.put(str, c2042a);
            nsdManager.registerService(nsdServiceInfo, 1, c2042a);
            return true;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2043b.class);
            return false;
        }
    }
}

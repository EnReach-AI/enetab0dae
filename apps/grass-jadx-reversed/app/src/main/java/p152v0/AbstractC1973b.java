package p152v0;

import android.util.Log;
import com.facebook.AbstractC1117n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;

/* JADX INFO: renamed from: v0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1973b {

    /* JADX INFO: renamed from: a */
    public static boolean f6991a = false;

    /* JADX INFO: renamed from: b */
    public static final ArrayList f6992b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public static final CopyOnWriteArraySet f6993c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: a */
    public static String m4366a(String str, String str2) {
        try {
            if (AbstractC0147a.f354a.contains(AbstractC1973b.class)) {
                return null;
            }
            try {
            } catch (Exception e3) {
                Log.w("v0.b", "getMatchedRuleType failed", e3);
            }
            for (C1972a c1972a : new ArrayList(f6992b)) {
                if (c1972a != null && str.equals(c1972a.f6989a)) {
                    for (String str3 : c1972a.f6990b.keySet()) {
                        if (str2.equals(str3)) {
                            return (String) c1972a.f6990b.get(str3);
                        }
                        return null;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1973b.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4367b() {
        String str;
        if (AbstractC0147a.f354a.contains(AbstractC1973b.class)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079qM4625f = AbstractC2082t.m4625f(AbstractC1117n.f3877c, false);
            if (c2079qM4625f != null && (str = c2079qM4625f.f7362m) != null && !str.isEmpty()) {
                JSONObject jSONObject = new JSONObject(str);
                f6992b.clear();
                f6993c.clear();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2 != null) {
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("restrictive_param");
                        HashMap map = new HashMap();
                        C1972a c1972a = new C1972a();
                        c1972a.f6989a = next;
                        c1972a.f6990b = map;
                        if (jSONObjectOptJSONObject != null) {
                            c1972a.f6990b = AbstractC2056E.m4537f(jSONObjectOptJSONObject);
                            f6992b.add(c1972a);
                        }
                        if (jSONObject2.has("process_event_name")) {
                            f6993c.add(next);
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1973b.class);
        }
    }
}

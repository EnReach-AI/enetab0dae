package p133q0;

import com.facebook.AbstractC1117n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p117m0.C1711f;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;

/* JADX INFO: renamed from: q0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1838b {

    /* JADX INFO: renamed from: a */
    public static boolean f6356a = false;

    /* JADX INFO: renamed from: b */
    public static final ArrayList f6357b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public static final HashSet f6358c = new HashSet();

    /* JADX INFO: renamed from: a */
    public static synchronized void m4076a() {
        C2079q c2079qM4625f;
        ArrayList arrayList;
        if (AbstractC0147a.f354a.contains(AbstractC1838b.class)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            c2079qM4625f = AbstractC2082t.m4625f(AbstractC1117n.f3877c, false);
        } catch (Exception unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1838b.class);
            return;
        }
        if (c2079qM4625f == null) {
            return;
        }
        String str = c2079qM4625f.f7362m;
        if (!str.isEmpty()) {
            JSONObject jSONObject = new JSONObject(str);
            f6357b.clear();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2 != null) {
                    if (jSONObject2.optBoolean("is_deprecated_event")) {
                        f6358c.add(next);
                    } else {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("deprecated_param");
                        ArrayList arrayList2 = new ArrayList();
                        C1837a c1837a = new C1837a();
                        c1837a.f6354a = next;
                        c1837a.f6355b = arrayList2;
                        if (jSONArrayOptJSONArray != null) {
                            try {
                                arrayList = new ArrayList();
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                    arrayList.add(jSONArrayOptJSONArray.getString(i3));
                                }
                            } catch (JSONException unused2) {
                                arrayList = new ArrayList();
                            }
                            c1837a.f6355b = arrayList;
                        }
                        f6357b.add(c1837a);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4077b(ArrayList arrayList) {
        if (AbstractC0147a.f354a.contains(AbstractC1838b.class)) {
            return;
        }
        try {
            if (f6356a) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (f6358c.contains(((C1711f) it.next()).f5987h)) {
                        it.remove();
                    }
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1838b.class);
        }
    }
}

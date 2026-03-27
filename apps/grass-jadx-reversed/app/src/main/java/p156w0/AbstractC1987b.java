package p156w0;

import android.content.SharedPreferences;
import android.view.View;
import com.facebook.AbstractC1117n;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p129p0.AbstractC1823e;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: w0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1987b {

    /* JADX INFO: renamed from: b */
    public static SharedPreferences f7052b;

    /* JADX INFO: renamed from: a */
    public static final HashMap f7051a = new HashMap();

    /* JADX INFO: renamed from: c */
    public static final AtomicBoolean f7053c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a */
    public static void m4393a(String str, String str2) {
        if (AbstractC0147a.f354a.contains(AbstractC1987b.class)) {
            return;
        }
        try {
            if (!f7053c.get()) {
                m4395c();
            }
            HashMap map = f7051a;
            map.put(str, str2);
            f7052b.edit().putString("SUGGESTED_EVENTS_HISTORY", AbstractC2056E.m4553v(map)).apply();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1987b.class);
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m4394b(View view, String str) {
        if (AbstractC0147a.f354a.contains(AbstractC1987b.class)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("text", str);
                JSONArray jSONArray = new JSONArray();
                while (view != null) {
                    jSONArray.put(view.getClass().getSimpleName());
                    view = AbstractC1823e.m4063i(view);
                }
                jSONObject.put("classname", jSONArray);
            } catch (JSONException unused) {
            }
            return AbstractC2056E.m4530B(jSONObject.toString());
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1987b.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4395c() {
        if (AbstractC0147a.f354a.contains(AbstractC1987b.class)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = f7053c;
            if (atomicBoolean.get()) {
                return;
            }
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            SharedPreferences sharedPreferences = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
            f7052b = sharedPreferences;
            f7051a.putAll(AbstractC2056E.m4532a(sharedPreferences.getString("SUGGESTED_EVENTS_HISTORY", "")));
            atomicBoolean.set(true);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1987b.class);
        }
    }
}

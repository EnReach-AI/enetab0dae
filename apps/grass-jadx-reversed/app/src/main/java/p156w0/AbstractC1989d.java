package p156w0;

import android.app.Activity;
import com.facebook.AbstractC1117n;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p019F0.RunnableC0218b;
import p141s0.AbstractC1874d;
import p144t0.AbstractC1918d;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;

/* JADX INFO: renamed from: w0.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1989d {

    /* JADX INFO: renamed from: a */
    public static final AtomicBoolean f7055a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b */
    public static final HashSet f7056b = new HashSet();

    /* JADX INFO: renamed from: c */
    public static final HashSet f7057c = new HashSet();

    /* JADX INFO: renamed from: a */
    public static synchronized void m4401a() {
        if (AbstractC0147a.f354a.contains(AbstractC1989d.class)) {
            return;
        }
        try {
            AbstractC1117n.m2891a().execute(new RunnableC0218b(14));
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1989d.class);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4402b() {
        String str;
        if (AbstractC0147a.f354a.contains(AbstractC1989d.class)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079qM4625f = AbstractC2082t.m4625f(AbstractC1117n.f3877c, false);
            if (c2079qM4625f == null || (str = c2079qM4625f.f7361l) == null) {
                return;
            }
            m4403c(str);
            if (f7056b.isEmpty() && f7057c.isEmpty()) {
                return;
            }
            File fileM4275e = AbstractC1918d.m4275e();
            if (fileM4275e == null) {
                return;
            }
            AbstractC1986a.m4378f(fileM4275e);
            WeakReference weakReference = AbstractC1874d.f6609j;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity != null) {
                m4404d(activity);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1989d.class);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4403c(String str) {
        if (AbstractC0147a.f354a.contains(AbstractC1989d.class)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("production_events")) {
                JSONArray jSONArray = jSONObject.getJSONArray("production_events");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    f7056b.add(jSONArray.getString(i3));
                }
            }
            if (jSONObject.has("eligible_for_prediction_events")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("eligible_for_prediction_events");
                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                    f7057c.add(jSONArray2.getString(i4));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1989d.class);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4404d(Activity activity) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1989d.class)) {
            return;
        }
        try {
            if (f7055a.get()) {
                boolean z3 = false;
                if (!set.contains(AbstractC1986a.class)) {
                    try {
                        z3 = AbstractC1986a.f7050e;
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1986a.class);
                    }
                }
                if (z3) {
                    if (f7056b.isEmpty()) {
                        if (!f7057c.isEmpty()) {
                        }
                    }
                    ViewTreeObserverOnGlobalLayoutListenerC1990e.m4405c(activity);
                    return;
                }
            }
            ViewTreeObserverOnGlobalLayoutListenerC1990e.m4406d(activity);
        } catch (Exception unused) {
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1989d.class);
        }
    }
}

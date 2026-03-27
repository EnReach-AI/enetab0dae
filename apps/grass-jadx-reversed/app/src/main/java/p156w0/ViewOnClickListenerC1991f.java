package p156w0;

import android.os.Bundle;
import android.view.View;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p021G.RunnableC0224a;
import p108j.RunnableC1471e;
import p117m0.C1718m;
import p129p0.AbstractC1823e;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: w0.f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1991f implements View.OnClickListener {

    /* JADX INFO: renamed from: i */
    public static final HashSet f7062i = new HashSet();

    /* JADX INFO: renamed from: e */
    public View.OnClickListener f7063e;

    /* JADX INFO: renamed from: f */
    public WeakReference f7064f;

    /* JADX INFO: renamed from: g */
    public WeakReference f7065g;

    /* JADX INFO: renamed from: h */
    public String f7066h;

    /* JADX INFO: renamed from: a */
    public static void m4409a(View view, View view2, String str) {
        if (AbstractC0147a.f354a.contains(ViewOnClickListenerC1991f.class)) {
            return;
        }
        try {
            int iHashCode = view.hashCode();
            HashSet hashSet = f7062i;
            if (hashSet.contains(Integer.valueOf(iHashCode))) {
                return;
            }
            ViewOnClickListenerC1991f viewOnClickListenerC1991f = new ViewOnClickListenerC1991f();
            viewOnClickListenerC1991f.f7063e = AbstractC1823e.m4060f(view);
            viewOnClickListenerC1991f.f7065g = new WeakReference(view);
            viewOnClickListenerC1991f.f7064f = new WeakReference(view2);
            viewOnClickListenerC1991f.f7066h = str.toLowerCase().replace("activity", "");
            AbstractC1823e.m4067m(view, viewOnClickListenerC1991f);
            hashSet.add(Integer.valueOf(iHashCode));
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, ViewOnClickListenerC1991f.class);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4410c(String str, String str2, float[] fArr) {
        boolean zContains;
        Set set = AbstractC0147a.f354a;
        if (set.contains(ViewOnClickListenerC1991f.class)) {
            return;
        }
        try {
            AtomicBoolean atomicBoolean = AbstractC1989d.f7055a;
            boolean zContains2 = false;
            if (set.contains(AbstractC1989d.class)) {
                zContains = false;
            } else {
                try {
                    zContains = AbstractC1989d.f7056b.contains(str);
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1989d.class);
                    zContains = false;
                }
            }
            if (!zContains) {
                if (!AbstractC0147a.f354a.contains(AbstractC1989d.class)) {
                    try {
                        zContains2 = AbstractC1989d.f7057c.contains(str);
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, AbstractC1989d.class);
                    }
                }
                if (zContains2) {
                    m4412e(str, str2, fArr);
                    return;
                }
                return;
            }
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C1718m c1718m = new C1718m(AbstractC1117n.f3882h, (String) null);
            if (AbstractC0147a.f354a.contains(c1718m)) {
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putString("_is_suggested_event", "1");
                bundle.putString("_button_text", str2);
                c1718m.m3815d(bundle, str);
                return;
            } catch (Throwable th3) {
                AbstractC0147a.m295a(th3, c1718m);
                return;
            }
        } catch (Throwable th4) {
            AbstractC0147a.m295a(th4, ViewOnClickListenerC1991f.class);
        }
        AbstractC0147a.m295a(th4, ViewOnClickListenerC1991f.class);
    }

    /* JADX INFO: renamed from: d */
    public static boolean m4411d(String str, String str2) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(ViewOnClickListenerC1991f.class)) {
            return false;
        }
        try {
            HashMap map = AbstractC1987b.f7051a;
            String str3 = null;
            if (!set.contains(AbstractC1987b.class)) {
                try {
                    HashMap map2 = AbstractC1987b.f7051a;
                    if (map2.containsKey(str)) {
                        str3 = (String) map2.get(str);
                    }
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC1987b.class);
                }
            }
            if (str3 == null) {
                return false;
            }
            if (str3.equals("other")) {
                return true;
            }
            try {
                AbstractC1117n.m2891a().execute(new RunnableC0224a(str3, 9, str2));
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, ViewOnClickListenerC1991f.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m4412e(String str, String str2, float[] fArr) {
        if (AbstractC0147a.f354a.contains(ViewOnClickListenerC1991f.class)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            try {
                bundle.putString("event_name", str);
                JSONObject jSONObject = new JSONObject();
                StringBuilder sb = new StringBuilder();
                for (float f3 : fArr) {
                    sb.append(f3);
                    sb.append(",");
                }
                jSONObject.put("dense", sb.toString());
                jSONObject.put("button_text", str2);
                bundle.putString("metadata", jSONObject.toString());
                Locale locale = Locale.US;
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                C1125v c1125vM2913l = C1125v.m2913l(null, AbstractC1117n.f3877c + "/suggested_events", null, null);
                c1125vM2913l.f3907e = bundle;
                c1125vM2913l.m2923d();
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, ViewOnClickListenerC1991f.class);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4413b() {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            View view = (View) this.f7064f.get();
            View view2 = (View) this.f7065g.get();
            if (view == null || view2 == null) {
                return;
            }
            try {
                String strM4399d = AbstractC1988c.m4399d(view2);
                String strM4394b = AbstractC1987b.m4394b(view2, strM4399d);
                if (strM4394b == null || m4411d(strM4394b, strM4399d)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("view", AbstractC1988c.m4397b(view, view2));
                jSONObject.put("screenname", this.f7066h);
                if (set.contains(this)) {
                    return;
                }
                try {
                    AbstractC1117n.m2891a().execute(new RunnableC1471e(this, jSONObject, strM4399d, strM4394b, 1));
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, this);
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            View.OnClickListener onClickListener = this.f7063e;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            m4413b();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}

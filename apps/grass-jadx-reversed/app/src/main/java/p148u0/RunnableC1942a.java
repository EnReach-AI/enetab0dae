package p148u0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p141s0.AbstractC1879i;
import p141s0.AbstractC1883m;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2078p;
import p166z0.AbstractC2082t;
import p166z0.C2079q;
import p166z0.EnumC2081s;

/* JADX INFO: renamed from: u0.a */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1942a implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f6935e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ String f6936f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Context f6937g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ String f6938h;

    public RunnableC1942a(Context context, String str) {
        this.f6935e = 0;
        this.f6937g = context;
        this.f6936f = "com.facebook.sdk.attributionTracking";
        this.f6938h = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject jSONObject;
        String str = this.f6938h;
        Context context = this.f6937g;
        String str2 = this.f6936f;
        switch (this.f6935e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Set set = AbstractC0147a.f354a;
                if (!set.contains(this)) {
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
                        String str3 = str + "pingForOnDevice";
                        if (sharedPreferences.getLong(str3, 0L) == 0) {
                            if (!set.contains(AbstractC1946e.class)) {
                                try {
                                    AbstractC1946e.m4349g(1, str, new LinkedList());
                                } catch (Throwable th) {
                                    AbstractC0147a.m295a(th, AbstractC1946e.class);
                                }
                            }
                            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                            editorEdit.putLong(str3, System.currentTimeMillis());
                            editorEdit.apply();
                        }
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, this);
                        return;
                    }
                    break;
                }
                break;
            case 1:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        JSONObject jSONObjectM4614a = AbstractC2078p.m4614a(str2);
                        if (jSONObjectM4614a != null) {
                            AbstractC2078p.m4617d(str2, jSONObjectM4614a);
                            context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(str, jSONObjectM4614a.toString()).apply();
                            AbstractC2078p.f7349d = Long.valueOf(System.currentTimeMillis());
                        }
                        AbstractC2078p.m4618e();
                        AbstractC2078p.f7346a.set(false);
                    } catch (Throwable th3) {
                        AbstractC0147a.m295a(th3, this);
                        return;
                    }
                    break;
                }
                break;
            default:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                        C2079q c2079qM4623d = null;
                        String string = sharedPreferences2.getString(str2, null);
                        if (!AbstractC2056E.m4550s(string)) {
                            try {
                                jSONObject = new JSONObject(string);
                            } catch (JSONException unused) {
                                HashSet hashSet = AbstractC1117n.f3875a;
                                jSONObject = null;
                            }
                            if (jSONObject != null) {
                                c2079qM4623d = AbstractC2082t.m4623d(str, jSONObject);
                            }
                        }
                        JSONObject jSONObjectM4620a = AbstractC2082t.m4620a(str);
                        if (jSONObjectM4620a != null) {
                            AbstractC2082t.m4623d(str, jSONObjectM4620a);
                            sharedPreferences2.edit().putString(str2, jSONObjectM4620a.toString()).apply();
                        }
                        if (c2079qM4623d != null) {
                            String str4 = c2079qM4623d.f7357h;
                            if (!AbstractC2082t.f7374e && str4 != null && str4.length() > 0) {
                                AbstractC2082t.f7374e = true;
                                Log.w("t", str4);
                            }
                        }
                        AbstractC2078p.m4619f(str);
                        AbstractC1879i.m4200a();
                        AbstractC1883m.m4204b();
                        AbstractC2082t.f7372c.set(AbstractC2082t.f7371b.containsKey(str) ? EnumC2081s.f7367g : EnumC2081s.f7368h);
                        AbstractC2082t.m4624e();
                    } catch (Throwable th4) {
                        AbstractC0147a.m295a(th4, this);
                    }
                    break;
                }
                break;
        }
    }

    public RunnableC1942a(String str, Context context, String str2) {
        this.f6935e = 1;
        this.f6936f = str;
        this.f6937g = context;
        this.f6938h = str2;
    }

    public RunnableC1942a(Context context, String str, String str2) {
        this.f6935e = 2;
        this.f6937g = context;
        this.f6936f = str;
        this.f6938h = str2;
    }
}

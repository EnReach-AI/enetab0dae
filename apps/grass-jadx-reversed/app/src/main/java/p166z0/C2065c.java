package p166z0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.AbstractC0935f;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.CustomTabActivity;
import com.facebook.CustomTabMainActivity;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p010C0.AbstractC0147a;
import p068X.C0698c;
import p117m0.C1718m;

/* JADX INFO: renamed from: z0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C2065c extends BroadcastReceiver {

    /* JADX INFO: renamed from: c */
    public static C2065c f7301c;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7302a;

    /* JADX INFO: renamed from: b */
    public Object f7303b;

    public /* synthetic */ C2065c() {
        this.f7302a = 0;
    }

    /* JADX INFO: renamed from: a */
    public static void m4571a(Context context) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(C2065c.class)) {
            return;
        }
        try {
            if (f7301c != null) {
                return;
            }
            C2065c c2065c = new C2065c();
            Context applicationContext = context.getApplicationContext();
            c2065c.f7303b = applicationContext;
            f7301c = c2065c;
            if (set.contains(c2065c)) {
                return;
            }
            try {
                C0698c.m1678a(applicationContext).m1679b(c2065c, new IntentFilter("com.parse.bolts.measurement_event"));
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, c2065c);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, C2065c.class);
        }
    }

    public void finalize() throws Throwable {
        switch (this.f7302a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Set set = AbstractC0147a.f354a;
                if (set.contains(this)) {
                    return;
                }
                try {
                    try {
                        if (!set.contains(this)) {
                            try {
                                C0698c.m1678a((Context) this.f7303b).m1681d(this);
                            } catch (Throwable th) {
                                AbstractC0147a.m295a(th, this);
                            }
                            break;
                        }
                        super.finalize();
                        return;
                    } finally {
                        super.finalize();
                    }
                } catch (Throwable th2) {
                    AbstractC0147a.m295a(th2, this);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.f7302a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        C1718m c1718m = new C1718m(context, (String) null);
                        String str = "bf_" + intent.getStringExtra("event_name");
                        Bundle bundleExtra = intent.getBundleExtra("event_args");
                        Bundle bundle = new Bundle();
                        for (String str2 : bundleExtra.keySet()) {
                            bundle.putString(str2.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String) bundleExtra.get(str2));
                        }
                        HashSet hashSet = AbstractC1117n.f3875a;
                        if (AbstractC1103F.m2866c()) {
                            c1718m.m3815d(bundle, str);
                        }
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, this);
                        return;
                    }
                    break;
                }
                break;
            case 1:
                ((CustomTabActivity) this.f7303b).finish();
                break;
            case 2:
                CustomTabMainActivity customTabMainActivity = (CustomTabMainActivity) this.f7303b;
                Intent intent2 = new Intent(customTabMainActivity, (Class<?>) CustomTabMainActivity.class);
                int i3 = CustomTabMainActivity.f3803g;
                intent2.setAction("CustomTabMainActivity.action_refresh");
                intent2.putExtra("CustomTabMainActivity.extra_url", intent.getStringExtra("CustomTabMainActivity.extra_url"));
                intent2.addFlags(603979776);
                customTabMainActivity.startActivity(intent2);
                break;
            default:
                ((AbstractC0935f) this.f7303b).mo2454i();
                break;
        }
    }

    public /* synthetic */ C2065c(int i3, Object obj) {
        this.f7302a = i3;
        this.f7303b = obj;
    }
}

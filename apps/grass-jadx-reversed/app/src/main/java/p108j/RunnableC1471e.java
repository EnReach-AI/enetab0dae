package p108j;

import android.view.MenuItem;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p036L0.C0444d;
import p144t0.AbstractC1918d;
import p156w0.AbstractC1986a;
import p156w0.AbstractC1987b;
import p156w0.ViewOnClickListenerC1991f;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: j.e */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1471e implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5295e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f5296f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f5297g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ Object f5298h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ Object f5299i;

    public /* synthetic */ RunnableC1471e(Object obj, Object obj2, Object obj3, Object obj4, int i3) {
        this.f5295e = i3;
        this.f5299i = obj;
        this.f5296f = obj2;
        this.f5297g = obj3;
        this.f5298h = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String[] strArrM4277g;
        Object obj = this.f5298h;
        String str = null;
        Object obj2 = this.f5299i;
        Object obj3 = this.f5296f;
        Object obj4 = this.f5297g;
        switch (this.f5295e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1472f c1472f = (C1472f) obj3;
                if (c1472f != null) {
                    C0444d c0444d = (C0444d) obj2;
                    ((ViewOnKeyListenerC1473g) c0444d.f1085e).f5307E = true;
                    c1472f.f5301b.m3513c(false);
                    ((ViewOnKeyListenerC1473g) c0444d.f1085e).f5307E = false;
                }
                MenuItem menuItem = (MenuItem) obj4;
                if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                    ((MenuC1479m) obj).m3519q(menuItem, null, 4);
                    break;
                }
                break;
            default:
                String str2 = (String) obj4;
                Set set = AbstractC0147a.f354a;
                if (!set.contains(this)) {
                    try {
                        HashSet hashSet = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        String lowerCase = AbstractC2056E.m4541j(AbstractC1117n.f3882h).toLowerCase();
                        float[] fArrM4374b = AbstractC1986a.m4374b(lowerCase, (JSONObject) obj3);
                        ViewOnClickListenerC1991f viewOnClickListenerC1991f = (ViewOnClickListenerC1991f) obj2;
                        if (!set.contains(ViewOnClickListenerC1991f.class)) {
                            try {
                                str = viewOnClickListenerC1991f.f7066h;
                            } catch (Throwable th) {
                                AbstractC0147a.m295a(th, ViewOnClickListenerC1991f.class);
                            }
                        }
                        String strM4376d = AbstractC1986a.m4376d(str2, str, lowerCase);
                        if (fArrM4374b != null && (strArrM4277g = AbstractC1918d.m4277g(2, new float[][]{fArrM4374b}, new String[]{strM4376d})) != null) {
                            String str3 = strArrM4277g[0];
                            AbstractC1987b.m4393a((String) obj, str3);
                            if (!str3.equals("other") && !AbstractC0147a.f354a.contains(ViewOnClickListenerC1991f.class)) {
                                try {
                                    ViewOnClickListenerC1991f.m4410c(str3, str2, fArrM4374b);
                                } catch (Throwable th2) {
                                    AbstractC0147a.m295a(th2, ViewOnClickListenerC1991f.class);
                                    return;
                                }
                                break;
                            }
                        }
                    } catch (Exception unused) {
                        return;
                    } catch (Throwable th3) {
                        AbstractC0147a.m295a(th3, this);
                    }
                    break;
                }
                break;
        }
    }
}

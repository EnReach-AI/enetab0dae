package p141s0;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import java.util.HashSet;
import java.util.Set;
import p010C0.AbstractC0147a;
import p019F0.RunnableC0218b;
import p036L0.C0444d;
import p117m0.AbstractC1708c;
import p117m0.AbstractC1725t;
import p117m0.C1718m;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;

/* JADX INFO: renamed from: s0.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1879i {

    /* JADX INFO: renamed from: a */
    public static final C0444d f6614a;

    static {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        f6614a = new C0444d(new C1718m(AbstractC1117n.f3882h, (String) null));
    }

    /* JADX INFO: renamed from: a */
    public static void m4200a() {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Context context = AbstractC1117n.f3882h;
        AbstractC2069g.m4584h();
        String str = AbstractC1117n.f3877c;
        boolean zM2866c = AbstractC1103F.m2866c();
        AbstractC2069g.m4582f("context", context);
        if (zM2866c) {
            if (!(context instanceof Application)) {
                Log.w("s0.i", "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
                return;
            }
            Application application = (Application) context;
            Set set = AbstractC0147a.f354a;
            if (set.contains(C1718m.class)) {
                return;
            }
            try {
                if (!AbstractC1117n.m2895e()) {
                    throw new C1111h("The Facebook sdk must be initialized before calling activateApp");
                }
                if (!AbstractC1708c.f5978c) {
                    C0444d.m976r().execute(new RunnableC0218b(2));
                }
                SharedPreferences sharedPreferences = AbstractC1725t.f6017a;
                if (!set.contains(AbstractC1725t.class)) {
                    try {
                        if (!AbstractC1725t.f6018b.get()) {
                            AbstractC1725t.m3832d();
                        }
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1725t.class);
                    }
                }
                if (str == null) {
                    AbstractC2069g.m4584h();
                    str = AbstractC1117n.f3877c;
                }
                AbstractC1117n.m2899i(application, str);
                AbstractC1874d.m4194c(application, str);
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, C1718m.class);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4201b(long j2, String str) {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Context context = AbstractC1117n.f3882h;
        AbstractC2069g.m4584h();
        String str2 = AbstractC1117n.f3877c;
        AbstractC2069g.m4582f("context", context);
        C2079q c2079qM4625f = AbstractC2082t.m4625f(str2, false);
        if (c2079qM4625f == null || !c2079qM4625f.f7353d || j2 <= 0) {
            return;
        }
        C1718m c1718m = new C1718m(context, (String) null);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence("fb_aa_time_spent_view_name", str);
        double d = j2;
        if (!AbstractC1103F.m2866c() || AbstractC0147a.f354a.contains(c1718m)) {
            return;
        }
        try {
            c1718m.m3816e("fb_aa_time_spent_on_view", Double.valueOf(d), bundle, false, AbstractC1874d.m4193b());
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, c1718m);
        }
    }
}

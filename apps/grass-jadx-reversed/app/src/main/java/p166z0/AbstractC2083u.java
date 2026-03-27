package p166z0;

import android.content.Context;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import java.util.Set;
import p010C0.AbstractC0147a;
import p111k0.C1632b;
import p160x0.C2011f;

/* JADX INFO: renamed from: z0.u */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2083u {
    /* JADX INFO: renamed from: a */
    public static void m4626a() {
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC2083u.class)) {
            return;
        }
        try {
            if (set.contains(AbstractC2083u.class)) {
                return;
            }
            try {
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                AbstractC1117n.f3882h.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putBoolean("is_referrer_updated", true).apply();
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC2083u.class);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC2083u.class);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4627b(C2068f c2068f) {
        if (AbstractC0147a.f354a.contains(AbstractC2083u.class)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            Context context = AbstractC1117n.f3882h;
            if (context == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            }
            C1632b c1632b = new C1632b(context);
            C2011f c2011f = new C2011f();
            c2011f.f7168a = c1632b;
            c2011f.f7169b = c2068f;
            try {
                c1632b.m3708b(c2011f);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2083u.class);
        }
    }
}

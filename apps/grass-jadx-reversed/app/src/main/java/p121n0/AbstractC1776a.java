package p121n0;

import com.facebook.AbstractC1117n;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;

/* JADX INFO: renamed from: n0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1776a {

    /* JADX INFO: renamed from: a */
    public static Boolean f6152a = Boolean.FALSE;

    /* JADX INFO: renamed from: a */
    public static void m3931a() {
        String str;
        Set set = AbstractC0147a.f354a;
        if (set.contains(AbstractC1776a.class)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079qM4625f = AbstractC2082t.m4625f(AbstractC1117n.f3877c, false);
            if (c2079qM4625f == null || (str = c2079qM4625f.f7360k) == null) {
                return;
            }
            CopyOnWriteArraySet copyOnWriteArraySet = C1778c.f6153d;
            if (set.contains(C1778c.class)) {
                return;
            }
            try {
                C1778c.f6153d.clear();
                C1778c.m3935a(new JSONObject(str));
            } catch (JSONException unused) {
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, C1778c.class);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, AbstractC1776a.class);
        }
    }
}

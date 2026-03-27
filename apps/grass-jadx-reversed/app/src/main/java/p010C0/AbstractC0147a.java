package p010C0;

import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import p002A0.C0021c;
import p002A0.EnumC0020b;
import p020F2.AbstractC0223a;
import p033K0.AbstractC0405c;
import p033K0.AbstractC0406d;

/* JADX INFO: renamed from: C0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0147a {

    /* JADX INFO: renamed from: a */
    public static final Set f354a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b */
    public static boolean f355b = false;

    /* JADX INFO: renamed from: a */
    public static void m295a(Throwable th, Object obj) {
        if (f355b) {
            f354a.add(obj);
            HashSet hashSet = AbstractC1117n.f3875a;
            if (AbstractC1103F.m2866c()) {
                AbstractC0223a.m465b(th);
                C0021c c0021cM884c = AbstractC0405c.m884c(th, EnumC0020b.f62h);
                if (c0021cM884c.m75a()) {
                    AbstractC0406d.m906p(c0021cM884c.f65a, c0021cM884c.toString());
                }
            }
        }
    }
}

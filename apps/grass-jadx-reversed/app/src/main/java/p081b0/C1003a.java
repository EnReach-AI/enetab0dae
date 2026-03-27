package p081b0;

import android.content.Context;
import android.os.Bundle;
import android.os.Trace;
import io.getgrass.www.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import p069X0.C0706H;
import p137r0.AbstractC1852a;

/* JADX INFO: renamed from: b0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1003a {

    /* JADX INFO: renamed from: d */
    public static volatile C1003a f3573d;

    /* JADX INFO: renamed from: e */
    public static final Object f3574e = new Object();

    /* JADX INFO: renamed from: c */
    public final Context f3577c;

    /* JADX INFO: renamed from: b */
    public final HashSet f3576b = new HashSet();

    /* JADX INFO: renamed from: a */
    public final HashMap f3575a = new HashMap();

    public C1003a(Context context) {
        this.f3577c = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: c */
    public static C1003a m2693c(Context context) {
        if (f3573d == null) {
            synchronized (f3574e) {
                try {
                    if (f3573d == null) {
                        f3573d = new C1003a(context);
                    }
                } finally {
                }
            }
        }
        return f3573d;
    }

    /* JADX INFO: renamed from: a */
    public final void m2694a(Bundle bundle) {
        HashSet hashSet;
        String string = this.f3577c.getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean zHasNext = it.hasNext();
                    hashSet = this.f3576b;
                    if (!zHasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (InterfaceC1004b.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    m2695b((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e3) {
                throw new C0706H(e3);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final Object m2695b(Class cls, HashSet hashSet) {
        Object objMo2336b;
        if (AbstractC1852a.m4128c()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap map = this.f3575a;
        if (map.containsKey(cls)) {
            objMo2336b = map.get(cls);
        } else {
            hashSet.add(cls);
            try {
                InterfaceC1004b interfaceC1004b = (InterfaceC1004b) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listMo2335a = interfaceC1004b.mo2335a();
                if (!listMo2335a.isEmpty()) {
                    for (Class cls2 : listMo2335a) {
                        if (!map.containsKey(cls2)) {
                            m2695b(cls2, hashSet);
                        }
                    }
                }
                objMo2336b = interfaceC1004b.mo2336b(this.f3577c);
                hashSet.remove(cls);
                map.put(cls, objMo2336b);
            } catch (Throwable th2) {
                throw new C0706H(th2);
            }
        }
        Trace.endSection();
        return objMo2336b;
    }
}

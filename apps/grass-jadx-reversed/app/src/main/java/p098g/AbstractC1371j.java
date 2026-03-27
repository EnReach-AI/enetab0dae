package p098g;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import p018F.C0213e;
import p128p.C1809c;

/* JADX INFO: renamed from: g.j */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1371j {

    /* JADX INFO: renamed from: e */
    public static final ExecutorC1355A f4908e = new ExecutorC1355A(new ExecutorC1356B());

    /* JADX INFO: renamed from: f */
    public static final int f4909f = -100;

    /* JADX INFO: renamed from: g */
    public static C0213e f4910g = null;

    /* JADX INFO: renamed from: h */
    public static C0213e f4911h = null;

    /* JADX INFO: renamed from: i */
    public static Boolean f4912i = null;

    /* JADX INFO: renamed from: j */
    public static boolean f4913j = false;

    /* JADX INFO: renamed from: k */
    public static final C1809c f4914k = new C1809c(0);

    /* JADX INFO: renamed from: l */
    public static final Object f4915l = new Object();

    /* JADX INFO: renamed from: m */
    public static final Object f4916m = new Object();

    /* JADX INFO: renamed from: e */
    public static boolean m3347e(Context context) {
        if (f4912i == null) {
            try {
                int i3 = AbstractServiceC1387z.f5015e;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AbstractServiceC1387z.class), AbstractC1386y.m3392a() | 128).metaData;
                if (bundle != null) {
                    f4912i = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f4912i = Boolean.FALSE;
            }
        }
        return f4912i.booleanValue();
    }

    /* JADX INFO: renamed from: h */
    public static void m3348h(AbstractC1371j abstractC1371j) {
        synchronized (f4915l) {
            try {
                Iterator it = f4914k.iterator();
                while (it.hasNext()) {
                    AbstractC1371j abstractC1371j2 = (AbstractC1371j) ((WeakReference) it.next()).get();
                    if (abstractC1371j2 == abstractC1371j || abstractC1371j2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo3349a();

    /* JADX INFO: renamed from: b */
    public abstract void mo3350b();

    /* JADX INFO: renamed from: f */
    public abstract void mo3351f();

    /* JADX INFO: renamed from: g */
    public abstract void mo3352g();

    /* JADX INFO: renamed from: i */
    public abstract boolean mo3353i(int i3);

    /* JADX INFO: renamed from: j */
    public abstract void mo3354j(int i3);

    /* JADX INFO: renamed from: k */
    public abstract void mo3355k(View view);

    /* JADX INFO: renamed from: l */
    public abstract void mo3356l(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: renamed from: m */
    public abstract void mo3357m(CharSequence charSequence);
}

package p007B1;

import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Set;
import p010C0.AbstractC0147a;
import p129p0.AbstractC1822d;
import p141s0.AbstractC1875e;
import p156w0.AbstractC1988c;
import p156w0.ViewOnClickListenerC1991f;
import p156w0.ViewTreeObserverOnGlobalLayoutListenerC1990e;

/* JADX INFO: renamed from: B1.o */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0055o implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f200e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f201f;

    public /* synthetic */ RunnableC0055o(int i3, Object obj) {
        this.f200e = i3;
        this.f201f = obj;
    }

    /* JADX INFO: renamed from: a */
    private final void m218a() {
        WeakReference weakReference;
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            boolean zContains = set.contains(ViewTreeObserverOnGlobalLayoutListenerC1990e.class);
            WeakReference weakReference2 = null;
            ViewTreeObserverOnGlobalLayoutListenerC1990e viewTreeObserverOnGlobalLayoutListenerC1990e = (ViewTreeObserverOnGlobalLayoutListenerC1990e) this.f201f;
            if (zContains) {
                weakReference = null;
            } else {
                try {
                    weakReference = viewTreeObserverOnGlobalLayoutListenerC1990e.f7059e;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, ViewTreeObserverOnGlobalLayoutListenerC1990e.class);
                    weakReference = null;
                }
            }
            View viewM4196b = AbstractC1875e.m4196b((Activity) weakReference.get());
            if (!AbstractC0147a.f354a.contains(ViewTreeObserverOnGlobalLayoutListenerC1990e.class)) {
                try {
                    weakReference2 = viewTreeObserverOnGlobalLayoutListenerC1990e.f7059e;
                } catch (Throwable th2) {
                    AbstractC0147a.m295a(th2, ViewTreeObserverOnGlobalLayoutListenerC1990e.class);
                }
            }
            Activity activity = (Activity) weakReference2.get();
            if (viewM4196b != null && activity != null) {
                for (View view : AbstractC1988c.m4396a(viewM4196b)) {
                    if (!AbstractC1822d.m4049c(view)) {
                        String strM4399d = AbstractC1988c.m4399d(view);
                        if (!strM4399d.isEmpty() && strM4399d.length() <= 300) {
                            ViewOnClickListenerC1991f.m4409a(view, viewM4196b, activity.getLocalClassName());
                        }
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th3) {
            AbstractC0147a.m295a(th3, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x01e9 A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #15 {all -> 0x010a, blocks: (B:70:0x00e5, B:72:0x0104, B:75:0x010d, B:80:0x0123, B:82:0x0128, B:84:0x012e, B:86:0x0139, B:89:0x0144, B:93:0x0152, B:102:0x019e, B:106:0x01a8, B:114:0x01be, B:116:0x01c4, B:142:0x01fd, B:149:0x020d, B:123:0x01d0, B:124:0x01d4, B:133:0x01e9, B:141:0x01fa, B:140:0x01f7, B:131:0x01e3, B:113:0x01ba, B:100:0x0198, B:92:0x014e, B:85:0x0136, B:127:0x01de, B:136:0x01f2, B:109:0x01b5, B:145:0x0208, B:119:0x01cb, B:96:0x0193), top: B:437:0x00e5, inners: #1, #8, #9, #16, #18, #23 }] */
    /* JADX WARN: Unreachable blocks removed: 3, instructions: 4 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1890
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p007B1.RunnableC0055o.run():void");
    }
}

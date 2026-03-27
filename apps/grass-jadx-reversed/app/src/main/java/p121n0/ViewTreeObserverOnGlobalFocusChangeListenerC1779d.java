package p121n0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p010C0.AbstractC0147a;
import p021G.RunnableC0224a;
import p141s0.AbstractC1875e;

/* JADX INFO: renamed from: n0.d */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalFocusChangeListenerC1779d implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: i */
    public static final HashMap f6157i = new HashMap();

    /* JADX INFO: renamed from: g */
    public final WeakReference f6160g;

    /* JADX INFO: renamed from: e */
    public final HashSet f6158e = new HashSet();

    /* JADX INFO: renamed from: f */
    public final Handler f6159f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: h */
    public final AtomicBoolean f6161h = new AtomicBoolean(false);

    public ViewTreeObserverOnGlobalFocusChangeListenerC1779d(Activity activity) {
        this.f6160g = new WeakReference(activity);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m3939c(java.util.HashMap r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = "m"
            java.lang.String r1 = "-"
            java.util.Set r2 = p010C0.AbstractC0147a.f354a
            java.lang.Class<n0.d> r3 = p121n0.ViewTreeObserverOnGlobalFocusChangeListenerC1779d.class
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto Lf
            return
        Lf:
            int r2 = r9.hashCode()     // Catch: java.lang.Throwable -> L25
            r4 = 0
            r5 = 1
            r6 = 2
            r7 = 3
            switch(r2) {
                case 3585: goto L3c;
                case 3586: goto L32;
                case 3587: goto L28;
                case 3588: goto L1b;
                default: goto L1a;
            }     // Catch: java.lang.Throwable -> L25
        L1a:
            goto L46
        L1b:
            java.lang.String r2 = "r6"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L46
            r2 = r7
            goto L47
        L25:
            r8 = move-exception
            goto L85
        L28:
            java.lang.String r2 = "r5"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L46
            r2 = r6
            goto L47
        L32:
            java.lang.String r2 = "r4"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L46
            r2 = r5
            goto L47
        L3c:
            java.lang.String r2 = "r3"
            boolean r2 = r9.equals(r2)     // Catch: java.lang.Throwable -> L25
            if (r2 == 0) goto L46
            r2 = r4
            goto L47
        L46:
            r2 = -1
        L47:
            if (r2 == 0) goto L66
            if (r2 == r5) goto L5d
            if (r2 == r6) goto L5d
            if (r2 == r7) goto L50
            goto L81
        L50:
            boolean r0 = r10.contains(r1)     // Catch: java.lang.Throwable -> L25
            if (r0 == 0) goto L81
            java.lang.String[] r10 = r10.split(r1)     // Catch: java.lang.Throwable -> L25
            r10 = r10[r4]     // Catch: java.lang.Throwable -> L25
            goto L81
        L5d:
            java.lang.String r0 = "[^a-z]+"
            java.lang.String r1 = ""
            java.lang.String r10 = r10.replaceAll(r0, r1)     // Catch: java.lang.Throwable -> L25
            goto L81
        L66:
            boolean r1 = r10.startsWith(r0)     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L80
            java.lang.String r1 = "b"
            boolean r1 = r10.startsWith(r1)     // Catch: java.lang.Throwable -> L25
            if (r1 != 0) goto L80
            java.lang.String r1 = "ge"
            boolean r10 = r10.startsWith(r1)     // Catch: java.lang.Throwable -> L25
            if (r10 == 0) goto L7d
            goto L80
        L7d:
            java.lang.String r10 = "f"
            goto L81
        L80:
            r10 = r0
        L81:
            r8.put(r9, r10)     // Catch: java.lang.Throwable -> L25
            return
        L85:
            p010C0.AbstractC0147a.m295a(r8, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p121n0.ViewTreeObserverOnGlobalFocusChangeListenerC1779d.m3939c(java.util.HashMap, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: renamed from: d */
    public static void m3940d(Activity activity) {
        ViewTreeObserverOnGlobalFocusChangeListenerC1779d viewTreeObserverOnGlobalFocusChangeListenerC1779d;
        View viewM4196b;
        Set set = AbstractC0147a.f354a;
        if (set.contains(ViewTreeObserverOnGlobalFocusChangeListenerC1779d.class)) {
            return;
        }
        try {
            int iHashCode = activity.hashCode();
            HashMap map = f6157i;
            if (map.containsKey(Integer.valueOf(iHashCode))) {
                viewTreeObserverOnGlobalFocusChangeListenerC1779d = (ViewTreeObserverOnGlobalFocusChangeListenerC1779d) map.get(Integer.valueOf(iHashCode));
            } else {
                viewTreeObserverOnGlobalFocusChangeListenerC1779d = new ViewTreeObserverOnGlobalFocusChangeListenerC1779d(activity);
                map.put(Integer.valueOf(activity.hashCode()), viewTreeObserverOnGlobalFocusChangeListenerC1779d);
            }
            viewTreeObserverOnGlobalFocusChangeListenerC1779d.getClass();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, ViewTreeObserverOnGlobalFocusChangeListenerC1779d.class);
        }
        if (set.contains(viewTreeObserverOnGlobalFocusChangeListenerC1779d)) {
            return;
        }
        try {
            if (!viewTreeObserverOnGlobalFocusChangeListenerC1779d.f6161h.getAndSet(true) && (viewM4196b = AbstractC1875e.m4196b((Activity) viewTreeObserverOnGlobalFocusChangeListenerC1779d.f6160g.get())) != null) {
                ViewTreeObserver viewTreeObserver = viewM4196b.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalFocusChangeListener(viewTreeObserverOnGlobalFocusChangeListenerC1779d);
                    return;
                }
                return;
                AbstractC0147a.m295a(th, ViewTreeObserverOnGlobalFocusChangeListenerC1779d.class);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, viewTreeObserverOnGlobalFocusChangeListenerC1779d);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3941a(View view) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            RunnableC0224a runnableC0224a = new RunnableC0224a(this, view, 4, false);
            if (set.contains(this)) {
                return;
            }
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    runnableC0224a.run();
                } else {
                    this.f6159f.post(runnableC0224a);
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, this);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00de A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0146 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x004a A[SYNTHETIC] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3942b(android.view.View r13) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p121n0.ViewTreeObserverOnGlobalFocusChangeListenerC1779d.m3942b(android.view.View):void");
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View view, View view2) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        if (view != null) {
            try {
                m3941a(view);
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, this);
                return;
            }
        }
        if (view2 != null) {
            m3941a(view2);
        }
    }
}

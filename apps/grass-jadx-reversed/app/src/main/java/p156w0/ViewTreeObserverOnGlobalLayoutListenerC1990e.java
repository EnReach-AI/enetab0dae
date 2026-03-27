package p156w0;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import p007B1.RunnableC0055o;
import p010C0.AbstractC0147a;
import p141s0.AbstractC1875e;

/* JADX INFO: renamed from: w0.e */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC1990e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: h */
    public static final HashMap f7058h = new HashMap();

    /* JADX INFO: renamed from: e */
    public final WeakReference f7059e;

    /* JADX INFO: renamed from: f */
    public final Handler f7060f = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g */
    public final AtomicBoolean f7061g = new AtomicBoolean(false);

    public ViewTreeObserverOnGlobalLayoutListenerC1990e(Activity activity) {
        this.f7059e = new WeakReference(activity);
    }

    /* JADX INFO: renamed from: c */
    public static void m4405c(Activity activity) {
        if (AbstractC0147a.f354a.contains(ViewTreeObserverOnGlobalLayoutListenerC1990e.class)) {
            return;
        }
        try {
            int iHashCode = activity.hashCode();
            HashMap map = f7058h;
            if (map.containsKey(Integer.valueOf(iHashCode))) {
                return;
            }
            ViewTreeObserverOnGlobalLayoutListenerC1990e viewTreeObserverOnGlobalLayoutListenerC1990e = new ViewTreeObserverOnGlobalLayoutListenerC1990e(activity);
            map.put(Integer.valueOf(iHashCode), viewTreeObserverOnGlobalLayoutListenerC1990e);
            viewTreeObserverOnGlobalLayoutListenerC1990e.m4408b();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, ViewTreeObserverOnGlobalLayoutListenerC1990e.class);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4406d(Activity activity) {
        View viewM4196b;
        Set set = AbstractC0147a.f354a;
        if (set.contains(ViewTreeObserverOnGlobalLayoutListenerC1990e.class)) {
            return;
        }
        try {
            int iHashCode = activity.hashCode();
            HashMap map = f7058h;
            if (map.containsKey(Integer.valueOf(iHashCode))) {
                ViewTreeObserverOnGlobalLayoutListenerC1990e viewTreeObserverOnGlobalLayoutListenerC1990e = (ViewTreeObserverOnGlobalLayoutListenerC1990e) map.get(Integer.valueOf(iHashCode));
                map.remove(Integer.valueOf(iHashCode));
                viewTreeObserverOnGlobalLayoutListenerC1990e.getClass();
                if (set.contains(viewTreeObserverOnGlobalLayoutListenerC1990e)) {
                    return;
                }
                try {
                    if (viewTreeObserverOnGlobalLayoutListenerC1990e.f7061g.getAndSet(false) && (viewM4196b = AbstractC1875e.m4196b((Activity) viewTreeObserverOnGlobalLayoutListenerC1990e.f7059e.get())) != null) {
                        ViewTreeObserver viewTreeObserver = viewM4196b.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.removeOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC1990e);
                        }
                    }
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, viewTreeObserverOnGlobalLayoutListenerC1990e);
                }
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, ViewTreeObserverOnGlobalLayoutListenerC1990e.class);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m4407a() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            RunnableC0055o runnableC0055o = new RunnableC0055o(22, this);
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                runnableC0055o.run();
            } else {
                this.f7060f.post(runnableC0055o);
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4408b() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            if (this.f7061g.getAndSet(true)) {
                return;
            }
            WeakReference weakReference = this.f7059e;
            View viewM4196b = AbstractC1875e.m4196b((Activity) weakReference.get());
            if (viewM4196b == null) {
                return;
            }
            ViewTreeObserver viewTreeObserver = viewM4196b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(this);
                m4407a();
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            m4407a();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}

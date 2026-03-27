package p029J;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: J.v */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0371v implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: e */
    public final View f880e;

    /* JADX INFO: renamed from: f */
    public ViewTreeObserver f881f;

    /* JADX INFO: renamed from: g */
    public final Runnable f882g;

    public ViewTreeObserverOnPreDrawListenerC0371v(View view, Runnable runnable) {
        this.f880e = view;
        this.f881f = view.getViewTreeObserver();
        this.f882g = runnable;
    }

    /* JADX INFO: renamed from: a */
    public static void m839a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        ViewTreeObserverOnPreDrawListenerC0371v viewTreeObserverOnPreDrawListenerC0371v = new ViewTreeObserverOnPreDrawListenerC0371v(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0371v);
        view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0371v);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean zIsAlive = this.f881f.isAlive();
        View view = this.f880e;
        if (zIsAlive) {
            this.f881f.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f882g.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f881f = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean zIsAlive = this.f881f.isAlive();
        View view2 = this.f880e;
        if (zIsAlive) {
            this.f881f.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}

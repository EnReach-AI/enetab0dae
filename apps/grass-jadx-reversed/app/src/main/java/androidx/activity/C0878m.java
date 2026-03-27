package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.C0918D;
import androidx.fragment.app.C0952w;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0979l;
import androidx.lifecycle.InterfaceC0984q;
import java.util.ArrayDeque;
import java.util.Iterator;
import p026I.InterfaceC0293a;
import p028I1.RunnableC0304d;
import p156w0.AbstractC1986a;

/* JADX INFO: renamed from: androidx.activity.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0878m {

    /* JADX INFO: renamed from: a */
    public final Runnable f2616a;

    /* JADX INFO: renamed from: c */
    public final C0874i f2618c;

    /* JADX INFO: renamed from: d */
    public final OnBackInvokedCallback f2619d;

    /* JADX INFO: renamed from: e */
    public OnBackInvokedDispatcher f2620e;

    /* JADX INFO: renamed from: b */
    public final ArrayDeque f2617b = new ArrayDeque();

    /* JADX INFO: renamed from: f */
    public boolean f2621f = false;

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.activity.i] */
    public C0878m(Runnable runnable) {
        this.f2616a = runnable;
        if (AbstractC1986a.m4379g()) {
            this.f2618c = new InterfaceC0293a() { // from class: androidx.activity.i
                @Override // p026I.InterfaceC0293a
                /* JADX INFO: renamed from: a */
                public final void mo474a(Object obj) {
                    C0878m c0878m = this.f2611a;
                    c0878m.getClass();
                    if (AbstractC1986a.m4379g()) {
                        c0878m.m2212c();
                    }
                }
            };
            this.f2619d = AbstractC0876k.m2207a(new RunnableC0304d(5, this));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2210a(InterfaceC0984q interfaceC0984q, C0952w c0952w) {
        C0986s c0986sMo2199d = interfaceC0984q.mo2199d();
        if (c0986sMo2199d.f3328b == EnumC0979l.f3318e) {
            return;
        }
        c0952w.f3267b.add(new OnBackPressedDispatcher$LifecycleOnBackPressedCancellable(this, c0986sMo2199d, c0952w));
        if (AbstractC1986a.m4379g()) {
            m2212c();
            c0952w.f3268c = this.f2618c;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2211b() {
        Iterator itDescendingIterator = this.f2617b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            C0952w c0952w = (C0952w) itDescendingIterator.next();
            if (c0952w.f3266a) {
                C0918D c0918d = c0952w.f3269d;
                c0918d.m2404t(true);
                if (c0918d.f3036h.f3266a) {
                    c0918d.m2372H();
                    return;
                } else {
                    c0918d.f3035g.m2211b();
                    return;
                }
            }
        }
        Runnable runnable = this.f2616a;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2212c() {
        boolean z3;
        Iterator itDescendingIterator = this.f2617b.descendingIterator();
        while (true) {
            if (!itDescendingIterator.hasNext()) {
                z3 = false;
                break;
            } else if (((C0952w) itDescendingIterator.next()).f3266a) {
                z3 = true;
                break;
            }
        }
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f2620e;
        if (onBackInvokedDispatcher != null) {
            if (z3 && !this.f2621f) {
                AbstractC0876k.m2208b(onBackInvokedDispatcher, 0, this.f2619d);
                this.f2621f = true;
            } else {
                if (z3 || !this.f2621f) {
                    return;
                }
                AbstractC0876k.m2209c(onBackInvokedDispatcher, this.f2619d);
                this.f2621f = false;
            }
        }
    }
}

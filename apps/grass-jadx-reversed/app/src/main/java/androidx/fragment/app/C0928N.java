package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p005B.AbstractC0032g;
import p018F.C0210b;
import p019F0.C0221e;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: androidx.fragment.app.N */
/* JADX INFO: loaded from: classes.dex */
public final class C0928N {

    /* JADX INFO: renamed from: a */
    public int f3109a;

    /* JADX INFO: renamed from: b */
    public int f3110b;

    /* JADX INFO: renamed from: c */
    public final AbstractComponentCallbacksC0944o f3111c;

    /* JADX INFO: renamed from: d */
    public final ArrayList f3112d;

    /* JADX INFO: renamed from: e */
    public final HashSet f3113e;

    /* JADX INFO: renamed from: f */
    public boolean f3114f;

    /* JADX INFO: renamed from: g */
    public boolean f3115g;

    /* JADX INFO: renamed from: h */
    public final C0923I f3116h;

    public C0928N(int i3, int i4, C0923I c0923i, C0210b c0210b) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
        this.f3112d = new ArrayList();
        this.f3113e = new HashSet();
        this.f3114f = false;
        this.f3115g = false;
        this.f3109a = i3;
        this.f3110b = i4;
        this.f3111c = abstractComponentCallbacksC0944o;
        c0210b.m417b(new C0221e(13, this));
        this.f3116h = c0923i;
    }

    /* JADX INFO: renamed from: a */
    public final void m2435a() {
        if (this.f3114f) {
            return;
        }
        this.f3114f = true;
        HashSet hashSet = this.f3113e;
        if (hashSet.isEmpty()) {
            m2436b();
            return;
        }
        Iterator it = new ArrayList(hashSet).iterator();
        while (it.hasNext()) {
            ((C0210b) it.next()).m416a();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2436b() {
        if (!this.f3115g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f3115g = true;
            Iterator it = this.f3112d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }
        this.f3116h.m2425k();
    }

    /* JADX INFO: renamed from: c */
    public final void m2437c(int i3, int i4) {
        int iM4118b = AbstractC1849h.m4118b(i4);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3111c;
        if (iM4118b == 0) {
            if (this.f3109a != 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + abstractComponentCallbacksC0944o + " mFinalState = " + AbstractC0032g.m167y(this.f3109a) + " -> " + AbstractC0032g.m167y(i3) + ". ");
                }
                this.f3109a = i3;
                return;
            }
            return;
        }
        if (iM4118b == 1) {
            if (this.f3109a == 1) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + abstractComponentCallbacksC0944o + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + AbstractC0032g.m166x(this.f3110b) + " to ADDING.");
                }
                this.f3109a = 2;
                this.f3110b = 2;
                return;
            }
            return;
        }
        if (iM4118b != 2) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + abstractComponentCallbacksC0944o + " mFinalState = " + AbstractC0032g.m167y(this.f3109a) + " -> REMOVED. mLifecycleImpact  = " + AbstractC0032g.m166x(this.f3110b) + " to REMOVING.");
        }
        this.f3109a = 1;
        this.f3110b = 3;
    }

    /* JADX INFO: renamed from: d */
    public final void m2438d() {
        if (this.f3110b == 2) {
            C0923I c0923i = this.f3116h;
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
            View viewFindFocus = abstractComponentCallbacksC0944o.f3210J.findFocus();
            if (viewFindFocus != null) {
                abstractComponentCallbacksC0944o.m2489g().f3199k = viewFindFocus;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC0944o);
                }
            }
            View viewM2482J = this.f3111c.m2482J();
            if (viewM2482J.getParent() == null) {
                c0923i.m2416b();
                viewM2482J.setAlpha(0.0f);
            }
            if (viewM2482J.getAlpha() == 0.0f && viewM2482J.getVisibility() == 0) {
                viewM2482J.setVisibility(4);
            }
            C0943n c0943n = abstractComponentCallbacksC0944o.f3213M;
            viewM2482J.setAlpha(c0943n == null ? 1.0f : c0943n.f3198j);
        }
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + AbstractC0032g.m167y(this.f3109a) + "} {mLifecycleImpact = " + AbstractC0032g.m166x(this.f3110b) + "} {mFragment = " + this.f3111c + "}";
    }
}

package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.facebook.C1100C;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p018F.C0210b;
import p019F0.C0221e;
import p021G.RunnableC0236m;
import p025H1.C0276e;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: androidx.fragment.app.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0937h {

    /* JADX INFO: renamed from: a */
    public final ViewGroup f3162a;

    /* JADX INFO: renamed from: b */
    public final ArrayList f3163b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final ArrayList f3164c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public boolean f3165d = false;

    /* JADX INFO: renamed from: e */
    public boolean f3166e = false;

    public C0937h(ViewGroup viewGroup) {
        this.f3162a = viewGroup;
    }

    /* JADX INFO: renamed from: f */
    public static C0937h m2456f(ViewGroup viewGroup, C0276e c0276e) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof C0937h) {
            return (C0937h) tag;
        }
        c0276e.getClass();
        C0937h c0937h = new C0937h(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, c0937h);
        return c0937h;
    }

    /* JADX INFO: renamed from: a */
    public final void m2457a(int i3, int i4, C0923I c0923i) {
        synchronized (this.f3163b) {
            try {
                C0210b c0210b = new C0210b();
                C0928N c0928nM2460d = m2460d(c0923i.f3090c);
                if (c0928nM2460d != null) {
                    c0928nM2460d.m2437c(i3, i4);
                    return;
                }
                C0928N c0928n = new C0928N(i3, i4, c0923i, c0210b);
                this.f3163b.add(c0928n);
                c0928n.f3112d.add(new RunnableC0927M(this, c0928n, 0));
                c0928n.f3112d.add(new RunnableC0927M(this, c0928n, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2458b(ArrayList arrayList, boolean z3) {
        char c3;
        boolean z4;
        int i3;
        char c4;
        Iterator it = arrayList.iterator();
        C0928N c0928n = null;
        C0928N c0928n2 = null;
        while (true) {
            c3 = 3;
            z4 = true;
            i3 = 2;
            if (!it.hasNext()) {
                break;
            }
            C0928N c0928n3 = (C0928N) it.next();
            int iM146d = AbstractC0032g.m146d(c0928n3.f3111c.f3210J);
            int iM4118b = AbstractC1849h.m4118b(c0928n3.f3109a);
            if (iM4118b != 0) {
                if (iM4118b != 1) {
                    if (iM4118b == 2 || iM4118b == 3) {
                    }
                } else if (iM146d != 2) {
                    c0928n2 = c0928n3;
                }
            }
            if (iM146d == 2 && c0928n == null) {
                c0928n = c0928n3;
            }
        }
        ArrayList<C0934e> arrayList2 = new ArrayList();
        ArrayList<C0936g> arrayList3 = new ArrayList();
        ArrayList<C0928N> arrayList4 = new ArrayList(arrayList);
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z5 = false;
            if (!it2.hasNext()) {
                break;
            }
            C0928N c0928n4 = (C0928N) it2.next();
            C0210b c0210b = new C0210b();
            c0928n4.m2438d();
            HashSet hashSet = c0928n4.f3113e;
            hashSet.add(c0210b);
            C0934e c0934e = new C0934e(c0928n4, c0210b);
            c0934e.f3158d = false;
            c0934e.f3157c = z3;
            arrayList2.add(c0934e);
            C0210b c0210b2 = new C0210b();
            c0928n4.m2438d();
            hashSet.add(c0210b2);
            if (!z3 ? c0928n4 == c0928n2 : c0928n4 == c0928n) {
                z5 = z4;
            }
            C0936g c0936g = new C0936g(c0928n4, c0210b2);
            int i4 = c0928n4.f3109a;
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0928n4.f3111c;
            if (i4 == 2) {
                if (z3) {
                    abstractComponentCallbacksC0944o.getClass();
                } else {
                    abstractComponentCallbacksC0944o.getClass();
                }
                if (z3) {
                    abstractComponentCallbacksC0944o.getClass();
                } else {
                    abstractComponentCallbacksC0944o.getClass();
                }
            } else if (z3) {
                abstractComponentCallbacksC0944o.getClass();
            } else {
                abstractComponentCallbacksC0944o.getClass();
            }
            if (z5) {
                if (z3) {
                    abstractComponentCallbacksC0944o.getClass();
                } else {
                    abstractComponentCallbacksC0944o.getClass();
                }
            }
            arrayList3.add(c0936g);
            c0928n4.f3112d.add(new RunnableC0236m(this, arrayList4, c0928n4));
            z4 = true;
        }
        HashMap map = new HashMap();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            C0928N c0928n5 = (C0928N) ((C0936g) it3.next()).f3160a;
            AbstractC0032g.m146d(c0928n5.f3111c.f3210J);
            int i5 = c0928n5.f3109a;
        }
        for (C0936g c0936g2 : arrayList3) {
            map.put((C0928N) c0936g2.f3160a, Boolean.FALSE);
            c0936g2.m2450e();
        }
        boolean zContainsValue = map.containsValue(Boolean.TRUE);
        ViewGroup viewGroup = this.f3162a;
        Context context = viewGroup.getContext();
        ArrayList<C0934e> arrayList5 = new ArrayList();
        boolean z6 = false;
        for (C0934e c0934e2 : arrayList2) {
            C0928N c0928n6 = (C0928N) c0934e2.f3160a;
            int iM146d2 = AbstractC0032g.m146d(c0928n6.f3111c.f3210J);
            int i6 = c0928n6.f3109a;
            if (iM146d2 == i6 || !(iM146d2 == i3 || i6 == i3)) {
                c4 = c3;
                c0934e2.m2450e();
            } else {
                C0009j c0009jM2447k = c0934e2.m2447k(context);
                if (c0009jM2447k == null) {
                    c0934e2.m2450e();
                } else {
                    Animator animator = (Animator) c0009jM2447k.f31g;
                    if (animator == null) {
                        arrayList5.add(c0934e2);
                    } else {
                        C0928N c0928n7 = (C0928N) c0934e2.f3160a;
                        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = c0928n7.f3111c;
                        if (Boolean.TRUE.equals(map.get(c0928n7))) {
                            if (Log.isLoggable("FragmentManager", 2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + abstractComponentCallbacksC0944o2 + " as this Fragment was involved in a Transition.");
                            }
                            c0934e2.m2450e();
                            c4 = 3;
                        } else {
                            boolean z7 = c0928n7.f3109a == 3;
                            if (z7) {
                                arrayList4.remove(c0928n7);
                            }
                            View view = abstractComponentCallbacksC0944o2.f3210J;
                            viewGroup.startViewTransition(view);
                            animator.addListener(new C0932c(viewGroup, view, z7, c0928n7, c0934e2));
                            animator.setTarget(view);
                            animator.start();
                            ((C0210b) c0934e2.f3161b).m417b(new C0221e(10, animator));
                            c3 = 3;
                            i3 = 2;
                            z6 = true;
                        }
                    }
                }
                c4 = c3;
            }
            c3 = c4;
            i3 = 2;
        }
        for (C0934e c0934e3 : arrayList5) {
            C0928N c0928n8 = (C0928N) c0934e3.f3160a;
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o3 = c0928n8.f3111c;
            if (zContainsValue) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0944o3 + " as Animations cannot run alongside Transitions.");
                }
                c0934e3.m2450e();
            } else if (z6) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + abstractComponentCallbacksC0944o3 + " as Animations cannot run alongside Animators.");
                }
                c0934e3.m2450e();
            } else {
                View view2 = abstractComponentCallbacksC0944o3.f3210J;
                C0009j c0009jM2447k2 = c0934e3.m2447k(context);
                c0009jM2447k2.getClass();
                Animation animation = (Animation) c0009jM2447k2.f30f;
                animation.getClass();
                if (c0928n8.f3109a != 1) {
                    view2.startAnimation(animation);
                    c0934e3.m2450e();
                } else {
                    viewGroup.startViewTransition(view2);
                    RunnableC0948s runnableC0948s = new RunnableC0948s(animation, viewGroup, view2);
                    runnableC0948s.setAnimationListener(new AnimationAnimationListenerC0933d(viewGroup, view2, c0934e3));
                    view2.startAnimation(runnableC0948s);
                }
                ((C0210b) c0934e3.f3161b).m417b(new C1100C(view2, viewGroup, c0934e3, 3));
            }
        }
        for (C0928N c0928n9 : arrayList4) {
            AbstractC0032g.m143a(c0928n9.f3111c.f3210J, c0928n9.f3109a);
        }
        arrayList4.clear();
    }

    /* JADX INFO: renamed from: c */
    public final void m2459c() {
        if (this.f3166e) {
            return;
        }
        ViewGroup viewGroup = this.f3162a;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (!AbstractC0310E.m619b(viewGroup)) {
            m2461e();
            this.f3165d = false;
            return;
        }
        synchronized (this.f3163b) {
            try {
                if (!this.f3163b.isEmpty()) {
                    ArrayList<C0928N> arrayList = new ArrayList(this.f3164c);
                    this.f3164c.clear();
                    for (C0928N c0928n : arrayList) {
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + c0928n);
                        }
                        c0928n.m2435a();
                        if (!c0928n.f3115g) {
                            this.f3164c.add(c0928n);
                        }
                    }
                    m2463h();
                    ArrayList arrayList2 = new ArrayList(this.f3163b);
                    this.f3163b.clear();
                    this.f3164c.addAll(arrayList2);
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((C0928N) it.next()).m2438d();
                    }
                    m2458b(arrayList2, this.f3165d);
                    this.f3165d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final C0928N m2460d(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        for (C0928N c0928n : this.f3163b) {
            if (c0928n.f3111c.equals(abstractComponentCallbacksC0944o) && !c0928n.f3114f) {
                return c0928n;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public final void m2461e() {
        ViewGroup viewGroup = this.f3162a;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean zM619b = AbstractC0310E.m619b(viewGroup);
        synchronized (this.f3163b) {
            try {
                m2463h();
                Iterator it = this.f3163b.iterator();
                while (it.hasNext()) {
                    ((C0928N) it.next()).m2438d();
                }
                for (C0928N c0928n : new ArrayList(this.f3164c)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        sb.append(zM619b ? "" : "Container " + this.f3162a + " is not attached to window. ");
                        sb.append("Cancelling running operation ");
                        sb.append(c0928n);
                        Log.v("FragmentManager", sb.toString());
                    }
                    c0928n.m2435a();
                }
                for (C0928N c0928n2 : new ArrayList(this.f3163b)) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        sb2.append(zM619b ? "" : "Container " + this.f3162a + " is not attached to window. ");
                        sb2.append("Cancelling pending operation ");
                        sb2.append(c0928n2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    c0928n2.m2435a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m2462g() {
        synchronized (this.f3163b) {
            try {
                m2463h();
                this.f3166e = false;
                int size = this.f3163b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    C0928N c0928n = (C0928N) this.f3163b.get(size);
                    int iM146d = AbstractC0032g.m146d(c0928n.f3111c.f3210J);
                    if (c0928n.f3109a == 2 && iM146d != 2) {
                        c0928n.f3111c.getClass();
                        this.f3166e = false;
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m2463h() {
        for (C0928N c0928n : this.f3163b) {
            if (c0928n.f3110b == 2) {
                c0928n.m2437c(AbstractC0032g.m145c(c0928n.f3111c.m2482J().getVisibility()), 1);
            }
        }
    }
}

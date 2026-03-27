package p073Z;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: Z.c */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0784c implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f2239e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ ArrayList f2240f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C0796i f2241g;

    public /* synthetic */ RunnableC0784c(C0796i c0796i, ArrayList arrayList, int i3) {
        this.f2239e = i3;
        this.f2241g = c0796i;
        this.f2240f = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator it;
        switch (this.f2239e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ArrayList arrayList = this.f2240f;
                Iterator it2 = arrayList.iterator();
                while (true) {
                    boolean zHasNext = it2.hasNext();
                    C0796i c0796i = this.f2241g;
                    if (!zHasNext) {
                        arrayList.clear();
                        c0796i.f2302m.remove(arrayList);
                    } else {
                        C0794h c0794h = (C0794h) it2.next();
                        AbstractC0777X abstractC0777X = c0794h.f2290a;
                        c0796i.getClass();
                        View view = abstractC0777X.f2202a;
                        int i3 = c0794h.f2293d - c0794h.f2291b;
                        int i4 = c0794h.f2294e - c0794h.f2292c;
                        if (i3 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i4 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                        c0796i.f2305p.add(abstractC0777X);
                        viewPropertyAnimatorAnimate.setDuration(c0796i.f2133e).setListener(new C0788e(c0796i, abstractC0777X, i3, view, i4, viewPropertyAnimatorAnimate)).start();
                    }
                    break;
                }
                break;
            case 1:
                ArrayList arrayList2 = this.f2240f;
                Iterator it3 = arrayList2.iterator();
                while (true) {
                    boolean zHasNext2 = it3.hasNext();
                    C0796i c0796i2 = this.f2241g;
                    if (!zHasNext2) {
                        arrayList2.clear();
                        c0796i2.f2303n.remove(arrayList2);
                    } else {
                        C0792g c0792g = (C0792g) it3.next();
                        c0796i2.getClass();
                        AbstractC0777X abstractC0777X2 = c0792g.f2279a;
                        View view2 = abstractC0777X2 == null ? null : abstractC0777X2.f2202a;
                        AbstractC0777X abstractC0777X3 = c0792g.f2280b;
                        View view3 = abstractC0777X3 != null ? abstractC0777X3.f2202a : null;
                        ArrayList arrayList3 = c0796i2.f2307r;
                        long j2 = c0796i2.f2134f;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(j2);
                            arrayList3.add(c0792g.f2279a);
                            duration.translationX(c0792g.f2283e - c0792g.f2281c);
                            duration.translationY(c0792g.f2284f - c0792g.f2282d);
                            it = it3;
                            duration.alpha(0.0f).setListener(new C0790f(c0796i2, c0792g, duration, view2, 0)).start();
                        } else {
                            it = it3;
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator viewPropertyAnimatorAnimate2 = view3.animate();
                            arrayList3.add(c0792g.f2280b);
                            viewPropertyAnimatorAnimate2.translationX(0.0f).translationY(0.0f).setDuration(j2).alpha(1.0f).setListener(new C0790f(c0796i2, c0792g, viewPropertyAnimatorAnimate2, view3, 1)).start();
                        }
                        it3 = it;
                    }
                    break;
                }
                break;
            default:
                ArrayList arrayList4 = this.f2240f;
                Iterator it4 = arrayList4.iterator();
                while (true) {
                    boolean zHasNext3 = it4.hasNext();
                    C0796i c0796i3 = this.f2241g;
                    if (!zHasNext3) {
                        arrayList4.clear();
                        c0796i3.f2301l.remove(arrayList4);
                    } else {
                        AbstractC0777X abstractC0777X4 = (AbstractC0777X) it4.next();
                        c0796i3.getClass();
                        View view4 = abstractC0777X4.f2202a;
                        ViewPropertyAnimator viewPropertyAnimatorAnimate3 = view4.animate();
                        c0796i3.f2304o.add(abstractC0777X4);
                        viewPropertyAnimatorAnimate3.alpha(1.0f).setDuration(c0796i3.f2131c).setListener(new C0786d(c0796i3, abstractC0777X4, view4, viewPropertyAnimatorAnimate3)).start();
                    }
                    break;
                }
                break;
        }
    }
}

package p028I1;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p019F0.C0221e;
import p137r0.AbstractC1852a;
import p144t0.AbstractC1920f;
import p155w.AbstractC1979a;

/* JADX INFO: renamed from: I1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0302b extends AbstractC1920f {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f802a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractC1979a f803b;

    public /* synthetic */ C0302b(AbstractC1979a abstractC1979a, int i3) {
        this.f802a = i3;
        this.f803b = abstractC1979a;
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: a */
    public final int mo575a(View view, int i3) {
        switch (this.f802a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f803b;
                return AbstractC1852a.m4126a(i3, sideSheetBehavior.f4439a.m458v(), sideSheetBehavior.f4451m);
            default:
                return view.getLeft();
        }
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: b */
    public final int mo576b(View view, int i3) {
        switch (this.f802a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return view.getTop();
            default:
                return AbstractC1852a.m4126a(i3, ((BottomSheetBehavior) this.f803b).m3154w(), mo578i());
        }
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: h */
    public int mo577h(View view) {
        switch (this.f802a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((SideSheetBehavior) this.f803b).f4451m;
            default:
                return super.mo577h(view);
        }
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: i */
    public int mo578i() {
        switch (this.f802a) {
            case 1:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f803b;
                return bottomSheetBehavior.f4245I ? bottomSheetBehavior.f4256T : bottomSheetBehavior.f4243G;
            default:
                return super.mo578i();
        }
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: o */
    public final void mo579o(int i3) {
        switch (this.f802a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (i3 == 1) {
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f803b;
                    if (sideSheetBehavior.f4445g) {
                        sideSheetBehavior.m3193r(1);
                    }
                }
                break;
            default:
                if (i3 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f803b;
                    if (bottomSheetBehavior.f4247K) {
                        bottomSheetBehavior.m3141A(1);
                    }
                }
                break;
        }
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: p */
    public final void mo580p(View view, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        switch (this.f802a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f803b;
                WeakReference weakReference = sideSheetBehavior.f4453o;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    C0221e c0221e = sideSheetBehavior.f4439a;
                    int left = view.getLeft();
                    view.getRight();
                    int i5 = ((SideSheetBehavior) c0221e.f534f).f4451m;
                    if (left <= i5) {
                        marginLayoutParams.rightMargin = i5 - left;
                    }
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.f4457s;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                C0221e c0221e2 = sideSheetBehavior.f4439a;
                int i6 = ((SideSheetBehavior) c0221e2.f534f).f4451m;
                c0221e2.m458v();
                Iterator it = linkedHashSet.iterator();
                if (it.hasNext()) {
                    AbstractC0032g.m162t(it.next());
                    throw null;
                }
                return;
            default:
                ((BottomSheetBehavior) this.f803b).m3153t(i4);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo581q(android.view.View r8, float r9, float r10) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p028I1.C0302b.mo581q(android.view.View, float, float):void");
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: r */
    public final boolean mo582r(View view, int i3) {
        WeakReference weakReference;
        switch (this.f802a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f803b;
                if (sideSheetBehavior.f4446h != 1 && (weakReference = sideSheetBehavior.f4452n) != null && weakReference.get() == view) {
                }
                break;
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.f803b;
                int i4 = bottomSheetBehavior.f4248L;
                if (i4 != 1 && !bottomSheetBehavior.f4264a0) {
                    if (i4 == 3 && bottomSheetBehavior.f4261Y == i3) {
                        WeakReference weakReference2 = bottomSheetBehavior.f4258V;
                        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
                        if (view2 != null && view2.canScrollVertically(-1)) {
                        }
                    }
                    System.currentTimeMillis();
                    WeakReference weakReference3 = bottomSheetBehavior.f4257U;
                    if (weakReference3 != null && weakReference3.get() == view) {
                        break;
                    }
                }
                break;
        }
        return true;
    }
}

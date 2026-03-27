package p028I1;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p007B1.RunnableC0055o;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p155w.AbstractC1979a;

/* JADX INFO: renamed from: I1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0305e {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f807a;

    /* JADX INFO: renamed from: b */
    public int f808b;

    /* JADX INFO: renamed from: c */
    public boolean f809c;

    /* JADX INFO: renamed from: d */
    public final Runnable f810d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ AbstractC1979a f811e;

    public C0305e(SideSheetBehavior sideSheetBehavior) {
        this.f807a = 0;
        this.f811e = sideSheetBehavior;
        this.f810d = new RunnableC0304d(0, this);
    }

    /* JADX INFO: renamed from: a */
    public final void m583a(int i3) {
        Runnable runnable = this.f810d;
        AbstractC1979a abstractC1979a = this.f811e;
        switch (this.f807a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) abstractC1979a;
                WeakReference weakReference = sideSheetBehavior.f4452n;
                if (weakReference != null && weakReference.get() != null) {
                    this.f808b = i3;
                    if (!this.f809c) {
                        View view = (View) sideSheetBehavior.f4452n.get();
                        WeakHashMap weakHashMap = AbstractC0323S.f816a;
                        AbstractC0307B.m597m(view, (RunnableC0304d) runnable);
                        this.f809c = true;
                    }
                    break;
                }
                break;
            default:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) abstractC1979a;
                WeakReference weakReference2 = bottomSheetBehavior.f4257U;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f808b = i3;
                    if (!this.f809c) {
                        View view2 = (View) bottomSheetBehavior.f4257U.get();
                        WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                        AbstractC0307B.m597m(view2, (RunnableC0055o) runnable);
                        this.f809c = true;
                    }
                    break;
                }
                break;
        }
    }

    public C0305e(BottomSheetBehavior bottomSheetBehavior) {
        this.f807a = 1;
        this.f811e = bottomSheetBehavior;
        this.f810d = new RunnableC0055o(21, this);
    }
}

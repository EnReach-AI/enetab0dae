package p007B1;

import android.graphics.Typeface;
import com.google.android.material.chip.Chip;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p148u0.AbstractC1944c;
import p157w1.C1996e;

/* JADX INFO: renamed from: B1.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0050j extends AbstractC1944c {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f189a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f190b;

    public /* synthetic */ C0050j(int i3, Object obj) {
        this.f189a = i3;
        this.f190b = obj;
    }

    /* JADX INFO: renamed from: h */
    private final void m208h(int i3) {
    }

    @Override // p148u0.AbstractC1944c
    /* JADX INFO: renamed from: d */
    public final void mo209d(int i3) {
        switch (this.f189a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0052l c0052l = (C0052l) this.f190b;
                c0052l.f194d = true;
                InterfaceC0051k interfaceC0051k = (InterfaceC0051k) c0052l.f195e.get();
                if (interfaceC0051k != null) {
                    C1996e c1996e = (C1996e) interfaceC0051k;
                    c1996e.m4443v();
                    c1996e.invalidateSelf();
                }
                break;
        }
    }

    @Override // p148u0.AbstractC1944c
    /* JADX INFO: renamed from: e */
    public final void mo210e(Typeface typeface, boolean z3) {
        switch (this.f189a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (!z3) {
                    C0052l c0052l = (C0052l) this.f190b;
                    c0052l.f194d = true;
                    InterfaceC0051k interfaceC0051k = (InterfaceC0051k) c0052l.f195e.get();
                    if (interfaceC0051k != null) {
                        C1996e c1996e = (C1996e) interfaceC0051k;
                        c1996e.m4443v();
                        c1996e.invalidateSelf();
                    }
                    break;
                }
                break;
            default:
                Chip chip = (Chip) this.f190b;
                C1996e c1996e2 = chip.f4322i;
                chip.setText(c1996e2.f7086H0 ? c1996e2.f7087I : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
        }
    }
}

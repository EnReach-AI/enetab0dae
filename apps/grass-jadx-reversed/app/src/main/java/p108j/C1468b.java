package p108j;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p110k.AbstractViewOnTouchListenerC1610p0;
import p110k.C1582e;
import p110k.C1585f;
import p110k.C1591h;
import p110k.C1594i;

/* JADX INFO: renamed from: j.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1468b extends AbstractViewOnTouchListenerC1610p0 {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ int f5291n = 0;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ View f5292o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1468b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f5292o = actionMenuItemView;
    }

    @Override // p110k.AbstractViewOnTouchListenerC1610p0
    /* JADX INFO: renamed from: b */
    public final InterfaceC1464D mo3500b() {
        C1582e c1582e;
        switch (this.f5291n) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC1469c abstractC1469c = ((ActionMenuItemView) this.f5292o).f2656p;
                if (abstractC1469c == null || (c1582e = ((C1585f) abstractC1469c).f5633a.f5660x) == null) {
                    return null;
                }
                return c1582e.m3538a();
            default:
                C1582e c1582e2 = ((C1591h) this.f5292o).f5639h.f5659w;
                if (c1582e2 == null) {
                    return null;
                }
                return c1582e2.m3538a();
        }
    }

    @Override // p110k.AbstractViewOnTouchListenerC1610p0
    /* JADX INFO: renamed from: c */
    public final boolean mo3501c() {
        InterfaceC1464D interfaceC1464DMo3500b;
        switch (this.f5291n) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f5292o;
                InterfaceC1478l interfaceC1478l = actionMenuItemView.f2654n;
                return interfaceC1478l != null && interfaceC1478l.mo2225b(actionMenuItemView.f2651k) && (interfaceC1464DMo3500b = mo3500b()) != null && interfaceC1464DMo3500b.mo3475b();
            default:
                ((C1591h) this.f5292o).f5639h.m3657l();
                return true;
        }
    }

    @Override // p110k.AbstractViewOnTouchListenerC1610p0
    /* JADX INFO: renamed from: d */
    public boolean mo3502d() {
        switch (this.f5291n) {
            case 1:
                C1594i c1594i = ((C1591h) this.f5292o).f5639h;
                if (c1594i.f5661y != null) {
                    return false;
                }
                c1594i.m3655f();
                return true;
            default:
                return super.mo3502d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1468b(C1591h c1591h, View view) {
        super(view);
        this.f5292o = c1591h;
    }
}

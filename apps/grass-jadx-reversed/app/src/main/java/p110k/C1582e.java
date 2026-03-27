package p110k;

import android.content.Context;
import android.view.View;
import io.getgrass.www.R;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p036L0.C0444d;
import p108j.AbstractC1487u;
import p108j.C1490x;
import p108j.MenuC1479m;
import p108j.SubMenuC1466F;

/* JADX INFO: renamed from: k.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1582e extends C1490x {

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ int f5616m = 0;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C1594i f5617n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1582e(C1594i c1594i, Context context, MenuC1479m menuC1479m, View view) {
        super(R.attr.actionOverflowMenuStyle, 0, context, view, menuC1479m, true);
        this.f5617n = c1594i;
        this.f5418g = 8388613;
        C0444d c0444d = c1594i.f5640A;
        this.f5420i = c0444d;
        AbstractC1487u abstractC1487u = this.f5421j;
        if (abstractC1487u != null) {
            abstractC1487u.mo3481i(c0444d);
        }
    }

    @Override // p108j.C1490x
    /* JADX INFO: renamed from: c */
    public final void mo3540c() {
        switch (this.f5616m) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                this.f5617n.f5660x = null;
                super.mo3540c();
                break;
            default:
                C1594i c1594i = this.f5617n;
                MenuC1479m menuC1479m = c1594i.f5643g;
                if (menuC1479m != null) {
                    menuC1479m.m3513c(true);
                }
                c1594i.f5659w = null;
                super.mo3540c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1582e(C1594i c1594i, Context context, SubMenuC1466F subMenuC1466F, View view) {
        super(R.attr.actionOverflowMenuStyle, 0, context, view, subMenuC1466F, false);
        this.f5617n = c1594i;
        if (!subMenuC1466F.f5273A.m3529f()) {
            View view2 = c1594i.f5649m;
            this.f5417f = view2 == null ? (View) c1594i.f5648l : view2;
        }
        C0444d c0444d = c1594i.f5640A;
        this.f5420i = c0444d;
        AbstractC1487u abstractC1487u = this.f5421j;
        if (abstractC1487u != null) {
            abstractC1487u.mo3481i(c0444d);
        }
    }
}

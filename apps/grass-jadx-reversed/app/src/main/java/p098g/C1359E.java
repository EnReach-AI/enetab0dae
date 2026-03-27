package p098g;

import android.support.v4.media.session.AbstractC0864a;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p029J.AbstractC0311F;
import p029J.AbstractC0323S;
import p105i.InterfaceC1433a;

/* JADX INFO: renamed from: g.E */
/* JADX INFO: loaded from: classes.dex */
public final class C1359E extends AbstractC0864a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4833a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C1361G f4834b;

    public /* synthetic */ C1359E(C1361G c1361g, int i3) {
        this.f4833a = i3;
        this.f4834b = c1361g;
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: a */
    public final void mo341a() {
        View view;
        C1361G c1361g = this.f4834b;
        switch (this.f4833a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (c1361g.f4856o && (view = c1361g.f4848g) != null) {
                    view.setTranslationY(0.0f);
                    c1361g.f4845d.setTranslationY(0.0f);
                }
                c1361g.f4845d.setVisibility(8);
                c1361g.f4845d.setTransitioning(false);
                c1361g.f4860s = null;
                InterfaceC1433a interfaceC1433a = c1361g.f4852k;
                if (interfaceC1433a != null) {
                    interfaceC1433a.mo47g(c1361g.f4851j);
                    c1361g.f4851j = null;
                    c1361g.f4852k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = c1361g.f4844c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    AbstractC0311F.m627c(actionBarOverlayLayout);
                }
                break;
            default:
                c1361g.f4860s = null;
                c1361g.f4845d.requestLayout();
                break;
        }
    }
}

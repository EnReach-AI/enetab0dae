package p044O;

import android.database.DataSetObserver;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p110k.C1628y0;

/* JADX INFO: renamed from: O.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0565b extends DataSetObserver {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1370a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1371b;

    public /* synthetic */ C0565b(int i3, Object obj) {
        this.f1370a = i3;
        this.f1371b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f1370a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0566c abstractC0566c = (AbstractC0566c) this.f1371b;
                abstractC0566c.f1372e = true;
                abstractC0566c.notifyDataSetChanged();
                break;
            default:
                C1628y0 c1628y0 = (C1628y0) this.f1371b;
                if (c1628y0.f5769D.isShowing()) {
                    c1628y0.mo3476f();
                }
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f1370a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0566c abstractC0566c = (AbstractC0566c) this.f1371b;
                abstractC0566c.f1372e = false;
                abstractC0566c.notifyDataSetInvalidated();
                break;
            default:
                ((C1628y0) this.f1371b).dismiss();
                break;
        }
    }
}

package p110k;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: k.s0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1616s0 implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f5740e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f5741f;

    public /* synthetic */ C1616s0(int i3, Object obj) {
        this.f5740e = i3;
        this.f5741f = obj;
    }

    /* JADX INFO: renamed from: a */
    private final void m3687a(AdapterView adapterView) {
    }

    /* JADX INFO: renamed from: b */
    private final void m3688b(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i3, long j2) {
        C1604m0 c1604m0;
        switch (this.f5740e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (i3 != -1 && (c1604m0 = ((C1628y0) this.f5741f).f5772g) != null) {
                    c1604m0.setListSelectionHidden(false);
                    break;
                }
                break;
            default:
                ((SearchView) this.f5741f).m2255q(i3);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i3 = this.f5740e;
    }
}

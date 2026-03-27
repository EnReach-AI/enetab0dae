package p034K1;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p110k.C1541L;
import p110k.C1628y0;

/* JADX INFO: renamed from: K1.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0435v implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f1049e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f1050f;

    public /* synthetic */ C0435v(int i3, Object obj) {
        this.f1049e = i3;
        this.f1050f = obj;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
        Object item;
        switch (this.f1049e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0437x c0437x = (C0437x) this.f1050f;
                if (i3 < 0) {
                    C1628y0 c1628y0 = c0437x.f1054i;
                    item = !c1628y0.f5769D.isShowing() ? null : c1628y0.f5772g.getSelectedItem();
                } else {
                    item = c0437x.getAdapter().getItem(i3);
                }
                C0437x.m967a(c0437x, item);
                AdapterView.OnItemClickListener onItemClickListener = c0437x.getOnItemClickListener();
                C1628y0 c1628y02 = c0437x.f1054i;
                if (onItemClickListener != null) {
                    if (view == null || i3 < 0) {
                        view = c1628y02.f5769D.isShowing() ? c1628y02.f5772g.getSelectedView() : null;
                        i3 = !c1628y02.f5769D.isShowing() ? -1 : c1628y02.f5772g.getSelectedItemPosition();
                        j2 = !c1628y02.f5769D.isShowing() ? Long.MIN_VALUE : c1628y02.f5772g.getSelectedItemId();
                    }
                    onItemClickListener.onItemClick(c1628y02.f5772g, view, i3, j2);
                }
                c1628y02.dismiss();
                break;
            case 1:
                C1541L c1541l = (C1541L) this.f1050f;
                c1541l.f5517K.setSelection(i3);
                if (c1541l.f5517K.getOnItemClickListener() != null) {
                    c1541l.f5517K.performItemClick(view, i3, c1541l.f5514H.getItemId(i3));
                }
                c1541l.dismiss();
                break;
            default:
                ((SearchView) this.f1050f).m2254p(i3);
                break;
        }
    }
}

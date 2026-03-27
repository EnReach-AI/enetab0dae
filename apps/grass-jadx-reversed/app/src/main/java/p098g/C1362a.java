package p098g;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: renamed from: g.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1362a implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C1365d f4866e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1363b f4867f;

    public C1362a(C1363b c1363b, C1365d c1365d) {
        this.f4867f = c1363b;
        this.f4866e = c1365d;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
        C1363b c1363b = this.f4867f;
        DialogInterface.OnClickListener onClickListener = c1363b.f4875h;
        C1365d c1365d = this.f4866e;
        onClickListener.onClick(c1365d.f4879b, i3);
        if (c1363b.f4876i) {
            return;
        }
        c1365d.f4879b.dismiss();
    }
}

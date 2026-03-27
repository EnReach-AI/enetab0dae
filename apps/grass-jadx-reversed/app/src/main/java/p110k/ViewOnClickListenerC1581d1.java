package p110k;

import android.view.View;
import android.view.Window;
import p108j.C1467a;

/* JADX INFO: renamed from: k.d1 */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1581d1 implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final C1467a f5614e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1584e1 f5615f;

    public ViewOnClickListenerC1581d1(C1584e1 c1584e1) {
        this.f5615f = c1584e1;
        this.f5614e = new C1467a(c1584e1.f5618a.getContext(), c1584e1.f5625h);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1584e1 c1584e1 = this.f5615f;
        Window.Callback callback = c1584e1.f5628k;
        if (callback == null || !c1584e1.f5629l) {
            return;
        }
        callback.onMenuItemSelected(0, this.f5614e);
    }
}

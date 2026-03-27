package p110k;

import android.os.Handler;
import android.widget.AbsListView;

/* JADX INFO: renamed from: k.w0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1624w0 implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1628y0 f5758a;

    public C1624w0(C1628y0 c1628y0) {
        this.f5758a = c1628y0;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i3, int i4, int i5) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i3) {
        if (i3 == 1) {
            C1628y0 c1628y0 = this.f5758a;
            if (c1628y0.f5769D.getInputMethodMode() == 2 || c1628y0.f5769D.getContentView() == null) {
                return;
            }
            Handler handler = c1628y0.f5791z;
            RunnableC1622v0 runnableC1622v0 = c1628y0.f5787v;
            handler.removeCallbacks(runnableC1622v0);
            runnableC1622v0.run();
        }
    }
}

package p029J;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: J.G */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnApplyWindowInsetsListenerC0312G implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a */
    public C0364q0 f812a = null;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f813b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ InterfaceC0367s f814c;

    public ViewOnApplyWindowInsetsListenerC0312G(View view, InterfaceC0367s interfaceC0367s) {
        this.f813b = view;
        this.f814c = interfaceC0367s;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        C0364q0 c0364q0M829g = C0364q0.m829g(windowInsets, view);
        int i3 = Build.VERSION.SDK_INT;
        InterfaceC0367s interfaceC0367s = this.f814c;
        if (i3 < 30) {
            AbstractC0313H.m628a(windowInsets, this.f813b);
            if (c0364q0M829g.equals(this.f812a)) {
                return interfaceC0367s.mo48h(view, c0364q0M829g).m834f();
            }
        }
        this.f812a = c0364q0M829g;
        C0364q0 c0364q0Mo48h = interfaceC0367s.mo48h(view, c0364q0M829g);
        if (i3 >= 30) {
            return c0364q0Mo48h.m834f();
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0311F.m627c(view);
        return c0364q0Mo48h.m834f();
    }
}

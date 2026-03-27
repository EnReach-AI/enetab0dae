package p108j;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import p105i.InterfaceC1435c;

/* JADX INFO: renamed from: j.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1483q extends FrameLayout implements InterfaceC1435c {

    /* JADX INFO: renamed from: e */
    public final CollapsibleActionView f5403e;

    /* JADX WARN: Multi-variable type inference failed */
    public C1483q(View view) {
        super(view.getContext());
        this.f5403e = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // p105i.InterfaceC1435c
    /* JADX INFO: renamed from: c */
    public final void mo2248c() {
        this.f5403e.onActionViewExpanded();
    }

    @Override // p105i.InterfaceC1435c
    /* JADX INFO: renamed from: e */
    public final void mo2249e() {
        this.f5403e.onActionViewCollapsed();
    }
}

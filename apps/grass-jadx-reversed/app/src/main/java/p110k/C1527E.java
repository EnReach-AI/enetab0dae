package p110k;

import android.view.View;
import p108j.InterfaceC1464D;

/* JADX INFO: renamed from: k.E */
/* JADX INFO: loaded from: classes.dex */
public final class C1527E extends AbstractViewOnTouchListenerC1610p0 {

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C1541L f5483n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C1547O f5484o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1527E(C1547O c1547o, View view, C1541L c1541l) {
        super(view);
        this.f5484o = c1547o;
        this.f5483n = c1541l;
    }

    @Override // p110k.AbstractViewOnTouchListenerC1610p0
    /* JADX INFO: renamed from: b */
    public final InterfaceC1464D mo3500b() {
        return this.f5483n;
    }

    @Override // p110k.AbstractViewOnTouchListenerC1610p0
    /* JADX INFO: renamed from: c */
    public final boolean mo3501c() {
        C1547O c1547o = this.f5484o;
        if (c1547o.getInternalPopup().mo3589b()) {
            return true;
        }
        c1547o.f5529j.mo3591e(AbstractC1531G.m3575b(c1547o), AbstractC1531G.m3574a(c1547o));
        return true;
    }
}

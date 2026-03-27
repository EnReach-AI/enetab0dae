package p110k;

import android.view.View;
import android.view.ViewConfiguration;
import p108j.InterfaceC1464D;

/* JADX INFO: renamed from: k.p0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC1610p0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: e */
    public final float f5708e;

    /* JADX INFO: renamed from: f */
    public final int f5709f;

    /* JADX INFO: renamed from: g */
    public final int f5710g;

    /* JADX INFO: renamed from: h */
    public final View f5711h;

    /* JADX INFO: renamed from: i */
    public RunnableC1608o0 f5712i;

    /* JADX INFO: renamed from: j */
    public RunnableC1608o0 f5713j;

    /* JADX INFO: renamed from: k */
    public boolean f5714k;

    /* JADX INFO: renamed from: l */
    public int f5715l;

    /* JADX INFO: renamed from: m */
    public final int[] f5716m = new int[2];

    public AbstractViewOnTouchListenerC1610p0(View view) {
        this.f5711h = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f5708e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f5709f = tapTimeout;
        this.f5710g = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    /* JADX INFO: renamed from: a */
    public final void m3679a() {
        RunnableC1608o0 runnableC1608o0 = this.f5713j;
        View view = this.f5711h;
        if (runnableC1608o0 != null) {
            view.removeCallbacks(runnableC1608o0);
        }
        RunnableC1608o0 runnableC1608o02 = this.f5712i;
        if (runnableC1608o02 != null) {
            view.removeCallbacks(runnableC1608o02);
        }
    }

    /* JADX INFO: renamed from: b */
    public abstract InterfaceC1464D mo3500b();

    /* JADX INFO: renamed from: c */
    public abstract boolean mo3501c();

    /* JADX INFO: renamed from: d */
    public boolean mo3502d() {
        InterfaceC1464D interfaceC1464DMo3500b = mo3500b();
        if (interfaceC1464DMo3500b == null || !interfaceC1464DMo3500b.mo3475b()) {
            return true;
        }
        interfaceC1464DMo3500b.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.AbstractViewOnTouchListenerC1610p0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f5714k = false;
        this.f5715l = -1;
        RunnableC1608o0 runnableC1608o0 = this.f5712i;
        if (runnableC1608o0 != null) {
            this.f5711h.removeCallbacks(runnableC1608o0);
        }
    }
}

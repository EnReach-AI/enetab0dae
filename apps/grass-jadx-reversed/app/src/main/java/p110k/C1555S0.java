package p110k;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: k.S0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1555S0 extends TouchDelegate {

    /* JADX INFO: renamed from: a */
    public final View f5537a;

    /* JADX INFO: renamed from: b */
    public final Rect f5538b;

    /* JADX INFO: renamed from: c */
    public final Rect f5539c;

    /* JADX INFO: renamed from: d */
    public final Rect f5540d;

    /* JADX INFO: renamed from: e */
    public final int f5541e;

    /* JADX INFO: renamed from: f */
    public boolean f5542f;

    public C1555S0(Rect rect, Rect rect2, View view) {
        super(rect, view);
        int scaledTouchSlop = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f5541e = scaledTouchSlop;
        Rect rect3 = new Rect();
        this.f5538b = rect3;
        Rect rect4 = new Rect();
        this.f5540d = rect4;
        Rect rect5 = new Rect();
        this.f5539c = rect5;
        rect3.set(rect);
        rect4.set(rect);
        int i3 = -scaledTouchSlop;
        rect4.inset(i3, i3);
        rect5.set(rect2);
        this.f5537a = view;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z3;
        boolean z4;
        int x3 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z5 = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                z4 = this.f5542f;
                if (z4 && !this.f5540d.contains(x3, y2)) {
                    z5 = z4;
                    z3 = false;
                }
            } else {
                if (action == 3) {
                    z4 = this.f5542f;
                    this.f5542f = false;
                }
                z3 = true;
                z5 = false;
            }
            z5 = z4;
            z3 = true;
        } else if (this.f5538b.contains(x3, y2)) {
            this.f5542f = true;
            z3 = true;
        } else {
            z3 = true;
            z5 = false;
        }
        if (!z5) {
            return false;
        }
        Rect rect = this.f5539c;
        View view = this.f5537a;
        if (!z3 || rect.contains(x3, y2)) {
            motionEvent.setLocation(x3 - rect.left, y2 - rect.top);
        } else {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        }
        return view.dispatchTouchEvent(motionEvent);
    }
}

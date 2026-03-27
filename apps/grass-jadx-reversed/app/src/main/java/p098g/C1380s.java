package p098g;

import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.appcompat.widget.ContentFrameLayout;
import p105i.C1437e;
import p125o0.AbstractC1800j;

/* JADX INFO: renamed from: g.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1380s extends ContentFrameLayout {

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ LayoutInflaterFactory2C1382u f4931m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1380s(LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u, C1437e c1437e) {
        super(c1437e, null);
        this.f4931m = layoutInflaterFactory2C1382u;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f4931m.m3385u(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x3 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (x3 < -5 || y2 < -5 || x3 > getWidth() + 5 || y2 > getHeight() + 5) {
                LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = this.f4931m;
                layoutInflaterFactory2C1382u.m3384s(layoutInflaterFactory2C1382u.m3390z(0), true);
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void setBackgroundResource(int i3) {
        setBackgroundDrawable(AbstractC1800j.m3991i(getContext(), i3));
    }
}

package p138r1;

import android.view.View;
import android.view.ViewParent;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: r1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1853a extends AbstractC1920f {

    /* JADX INFO: renamed from: a */
    public int f6426a;

    /* JADX INFO: renamed from: b */
    public int f6427b = -1;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ SwipeDismissBehavior f6428c;

    public C1853a(SwipeDismissBehavior swipeDismissBehavior) {
        this.f6428c = swipeDismissBehavior;
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: a */
    public final int mo575a(View view, int i3) {
        int width;
        int width2;
        int width3;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean z3 = AbstractC0308C.m607d(view) == 1;
        int i4 = this.f6428c.f4232d;
        if (i4 == 0) {
            if (z3) {
                width = this.f6426a - view.getWidth();
                width2 = this.f6426a;
            } else {
                width = this.f6426a;
                width3 = view.getWidth();
                width2 = width3 + width;
            }
        } else if (i4 != 1) {
            width = this.f6426a - view.getWidth();
            width2 = view.getWidth() + this.f6426a;
        } else if (z3) {
            width = this.f6426a;
            width3 = view.getWidth();
            width2 = width3 + width;
        } else {
            width = this.f6426a - view.getWidth();
            width2 = this.f6426a;
        }
        return Math.min(Math.max(width, i3), width2);
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: b */
    public final int mo576b(View view, int i3) {
        return view.getTop();
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: h */
    public final int mo577h(View view) {
        return view.getWidth();
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: n */
    public final void mo4133n(View view, int i3) {
        this.f6427b = i3;
        this.f6426a = view.getLeft();
        ViewParent parent = view.getParent();
        if (parent != null) {
            SwipeDismissBehavior swipeDismissBehavior = this.f6428c;
            swipeDismissBehavior.f4231c = true;
            parent.requestDisallowInterceptTouchEvent(true);
            swipeDismissBehavior.f4231c = false;
        }
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: o */
    public final void mo579o(int i3) {
        this.f6428c.getClass();
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: p */
    public final void mo580p(View view, int i3, int i4) {
        float width = view.getWidth();
        SwipeDismissBehavior swipeDismissBehavior = this.f6428c;
        float f3 = width * swipeDismissBehavior.f4234f;
        float width2 = view.getWidth() * swipeDismissBehavior.f4235g;
        float fAbs = Math.abs(i3 - this.f6426a);
        if (fAbs <= f3) {
            view.setAlpha(1.0f);
        } else if (fAbs >= width2) {
            view.setAlpha(0.0f);
        } else {
            view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f3) / (width2 - f3))), 1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo581q(android.view.View r9, float r10, float r11) {
        /*
            r8 = this;
            r11 = -1
            r8.f6427b = r11
            int r11 = r9.getWidth()
            r0 = 0
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            r2 = 1
            com.google.android.material.behavior.SwipeDismissBehavior r3 = r8.f6428c
            r4 = 0
            if (r1 == 0) goto L39
            java.util.WeakHashMap r5 = p029J.AbstractC0323S.f816a
            int r5 = p029J.AbstractC0308C.m607d(r9)
            if (r5 != r2) goto L1a
            r5 = r2
            goto L1b
        L1a:
            r5 = r4
        L1b:
            int r6 = r3.f4232d
            r7 = 2
            if (r6 != r7) goto L21
            goto L52
        L21:
            if (r6 != 0) goto L2d
            if (r5 == 0) goto L2a
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L66
            goto L52
        L2a:
            if (r1 <= 0) goto L66
            goto L52
        L2d:
            if (r6 != r2) goto L66
            if (r5 == 0) goto L34
            if (r1 <= 0) goto L66
            goto L52
        L34:
            int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r1 >= 0) goto L66
            goto L52
        L39:
            int r1 = r9.getLeft()
            int r5 = r8.f6426a
            int r1 = r1 - r5
            int r5 = r9.getWidth()
            float r5 = (float) r5
            float r6 = r3.f4233e
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            int r1 = java.lang.Math.abs(r1)
            if (r1 < r5) goto L66
        L52:
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 < 0) goto L61
            int r10 = r9.getLeft()
            int r0 = r8.f6426a
            if (r10 >= r0) goto L5f
            goto L61
        L5f:
            int r0 = r0 + r11
            goto L69
        L61:
            int r10 = r8.f6426a
            int r0 = r10 - r11
            goto L69
        L66:
            int r0 = r8.f6426a
            r2 = r4
        L69:
            Q.e r10 = r3.f4229a
            int r11 = r9.getTop()
            boolean r10 = r10.m1331o(r0, r11)
            if (r10 == 0) goto L7f
            G.a r10 = new G.a
            r10.<init>(r3, r9, r2)
            java.util.WeakHashMap r11 = p029J.AbstractC0323S.f816a
            p029J.AbstractC0307B.m597m(r9, r10)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p138r1.C1853a.mo581q(android.view.View, float, float):void");
    }

    @Override // p144t0.AbstractC1920f
    /* JADX INFO: renamed from: r */
    public final boolean mo582r(View view, int i3) {
        int i4 = this.f6427b;
        return (i4 == -1 || i4 == i3) && this.f6428c.mo3138r(view);
    }
}

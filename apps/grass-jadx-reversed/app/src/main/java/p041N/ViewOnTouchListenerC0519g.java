package p041N;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import p007B1.RunnableC0055o;

/* JADX INFO: renamed from: N.g */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnTouchListenerC0519g implements View.OnTouchListener {

    /* JADX INFO: renamed from: v */
    public static final int f1199v = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: e */
    public final C0513a f1200e;

    /* JADX INFO: renamed from: f */
    public final AccelerateInterpolator f1201f;

    /* JADX INFO: renamed from: g */
    public final View f1202g;

    /* JADX INFO: renamed from: h */
    public RunnableC0055o f1203h;

    /* JADX INFO: renamed from: i */
    public final float[] f1204i;

    /* JADX INFO: renamed from: j */
    public final float[] f1205j;

    /* JADX INFO: renamed from: k */
    public final int f1206k;

    /* JADX INFO: renamed from: l */
    public final int f1207l;

    /* JADX INFO: renamed from: m */
    public final float[] f1208m;

    /* JADX INFO: renamed from: n */
    public final float[] f1209n;

    /* JADX INFO: renamed from: o */
    public final float[] f1210o;

    /* JADX INFO: renamed from: p */
    public boolean f1211p;

    /* JADX INFO: renamed from: q */
    public boolean f1212q;

    /* JADX INFO: renamed from: r */
    public boolean f1213r;

    /* JADX INFO: renamed from: s */
    public boolean f1214s;

    /* JADX INFO: renamed from: t */
    public boolean f1215t;

    /* JADX INFO: renamed from: u */
    public final ListView f1216u;

    public ViewOnTouchListenerC0519g(ListView listView) {
        C0513a c0513a = new C0513a();
        c0513a.f1194e = Long.MIN_VALUE;
        c0513a.f1196g = -1L;
        c0513a.f1195f = 0L;
        this.f1200e = c0513a;
        this.f1201f = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f1204i = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1205j = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f1208m = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f1209n = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1210o = fArr5;
        this.f1202g = listView;
        float f3 = Resources.getSystem().getDisplayMetrics().density;
        float f4 = ((int) ((1575.0f * f3) + 0.5f)) / 1000.0f;
        fArr5[0] = f4;
        fArr5[1] = f4;
        float f5 = ((int) ((f3 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f5;
        fArr4[1] = f5;
        this.f1206k = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f1207l = f1199v;
        c0513a.f1190a = 500;
        c0513a.f1191b = 500;
        this.f1216u = listView;
    }

    /* JADX INFO: renamed from: b */
    public static float m1035b(float f3, float f4, float f5) {
        return f3 > f5 ? f5 : f3 < f4 ? f4 : f3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float m1036a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f1204i
            r0 = r0[r4]
            float[] r1 = r3.f1205j
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = m1035b(r0, r2, r1)
            float r1 = r3.m1037c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.m1037c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f1201f
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = m1035b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f1208m
            r0 = r0[r4]
            float[] r1 = r3.f1209n
            r1 = r1[r4]
            float[] r2 = r3.f1210o
            r4 = r2[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = m1035b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = m1035b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p041N.ViewOnTouchListenerC0519g.m1036a(int, float, float, float):float");
    }

    /* JADX INFO: renamed from: c */
    public final float m1037c(float f3, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        int i3 = this.f1206k;
        if (i3 == 0 || i3 == 1) {
            if (f3 < f4) {
                if (f3 >= 0.0f) {
                    return 1.0f - (f3 / f4);
                }
                if (this.f1214s && i3 == 1) {
                    return 1.0f;
                }
            }
        } else if (i3 == 2 && f3 < 0.0f) {
            return f3 / (-f4);
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: d */
    public final void m1038d() {
        int i3 = 0;
        if (this.f1212q) {
            this.f1214s = false;
            return;
        }
        C0513a c0513a = this.f1200e;
        c0513a.getClass();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i4 = (int) (jCurrentAnimationTimeMillis - c0513a.f1194e);
        int i5 = c0513a.f1191b;
        if (i4 > i5) {
            i3 = i5;
        } else if (i4 >= 0) {
            i3 = i4;
        }
        c0513a.f1198i = i3;
        c0513a.f1197h = c0513a.m1021a(jCurrentAnimationTimeMillis);
        c0513a.f1196g = jCurrentAnimationTimeMillis;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m1039e() {
        ListView listView;
        int count;
        C0513a c0513a = this.f1200e;
        float f3 = c0513a.f1193d;
        int iAbs = (int) (f3 / Math.abs(f3));
        Math.abs(c0513a.f1192c);
        if (iAbs == 0 || (count = (listView = this.f1216u).getCount()) == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i3 = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i3 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            r0 = 3
            boolean r1 = r7.f1215t
            r2 = 0
            if (r1 != 0) goto L7
            return r2
        L7:
            int r1 = r9.getActionMasked()
            r3 = 1
            if (r1 == 0) goto L1a
            if (r1 == r3) goto L16
            r4 = 2
            if (r1 == r4) goto L1e
            if (r1 == r0) goto L16
            goto L7b
        L16:
            r7.m1038d()
            goto L7b
        L1a:
            r7.f1213r = r3
            r7.f1211p = r2
        L1e:
            float r1 = r9.getX()
            int r4 = r8.getWidth()
            float r4 = (float) r4
            android.view.View r5 = r7.f1202g
            int r6 = r5.getWidth()
            float r6 = (float) r6
            float r1 = r7.m1036a(r2, r1, r4, r6)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r4 = r5.getHeight()
            float r4 = (float) r4
            float r8 = r7.m1036a(r3, r9, r8, r4)
            N.a r9 = r7.f1200e
            r9.f1192c = r1
            r9.f1193d = r8
            boolean r8 = r7.f1214s
            if (r8 != 0) goto L7b
            boolean r8 = r7.m1039e()
            if (r8 == 0) goto L7b
            B1.o r8 = r7.f1203h
            if (r8 != 0) goto L5f
            B1.o r8 = new B1.o
            r8.<init>(r0, r7)
            r7.f1203h = r8
        L5f:
            r7.f1214s = r3
            r7.f1212q = r3
            boolean r8 = r7.f1211p
            if (r8 != 0) goto L74
            int r8 = r7.f1207l
            if (r8 <= 0) goto L74
            B1.o r9 = r7.f1203h
            long r0 = (long) r8
            java.util.WeakHashMap r8 = p029J.AbstractC0323S.f816a
            p029J.AbstractC0307B.m598n(r5, r9, r0)
            goto L79
        L74:
            B1.o r8 = r7.f1203h
            r8.run()
        L79:
            r7.f1211p = r3
        L7b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p041N.ViewOnTouchListenerC0519g.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}

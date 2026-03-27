package p049Q;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;
import p007B1.RunnableC0055o;
import p029J.AbstractC0323S;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: Q.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0587e {

    /* JADX INFO: renamed from: v */
    public static final InterpolatorC0586d f1476v = new InterpolatorC0586d(0);

    /* JADX INFO: renamed from: a */
    public int f1477a;

    /* JADX INFO: renamed from: b */
    public final int f1478b;

    /* JADX INFO: renamed from: d */
    public float[] f1480d;

    /* JADX INFO: renamed from: e */
    public float[] f1481e;

    /* JADX INFO: renamed from: f */
    public float[] f1482f;

    /* JADX INFO: renamed from: g */
    public float[] f1483g;

    /* JADX INFO: renamed from: h */
    public int[] f1484h;

    /* JADX INFO: renamed from: i */
    public int[] f1485i;

    /* JADX INFO: renamed from: j */
    public int[] f1486j;

    /* JADX INFO: renamed from: k */
    public int f1487k;

    /* JADX INFO: renamed from: l */
    public VelocityTracker f1488l;

    /* JADX INFO: renamed from: m */
    public final float f1489m;

    /* JADX INFO: renamed from: n */
    public final float f1490n;

    /* JADX INFO: renamed from: o */
    public final int f1491o;

    /* JADX INFO: renamed from: p */
    public final OverScroller f1492p;

    /* JADX INFO: renamed from: q */
    public final AbstractC1920f f1493q;

    /* JADX INFO: renamed from: r */
    public View f1494r;

    /* JADX INFO: renamed from: s */
    public boolean f1495s;

    /* JADX INFO: renamed from: t */
    public final ViewGroup f1496t;

    /* JADX INFO: renamed from: c */
    public int f1479c = -1;

    /* JADX INFO: renamed from: u */
    public final RunnableC0055o f1497u = new RunnableC0055o(4, this);

    public C0587e(Context context, ViewGroup viewGroup, AbstractC1920f abstractC1920f) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC1920f == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1496t = viewGroup;
        this.f1493q = abstractC1920f;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1491o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1478b = viewConfiguration.getScaledTouchSlop();
        this.f1489m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1490n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1492p = new OverScroller(context, f1476v);
    }

    /* JADX INFO: renamed from: a */
    public final void m1317a() {
        this.f1479c = -1;
        float[] fArr = this.f1480d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f1481e, 0.0f);
            Arrays.fill(this.f1482f, 0.0f);
            Arrays.fill(this.f1483g, 0.0f);
            Arrays.fill(this.f1484h, 0);
            Arrays.fill(this.f1485i, 0);
            Arrays.fill(this.f1486j, 0);
            this.f1487k = 0;
        }
        VelocityTracker velocityTracker = this.f1488l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1488l = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m1318b(View view, int i3) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f1496t;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f1494r = view;
        this.f1479c = i3;
        this.f1493q.mo4133n(view, i3);
        m1330n(1);
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1319c(View view, float f3, float f4) {
        if (view == null) {
            return false;
        }
        AbstractC1920f abstractC1920f = this.f1493q;
        boolean z3 = abstractC1920f.mo577h(view) > 0;
        boolean z4 = abstractC1920f.mo578i() > 0;
        if (!z3 || !z4) {
            return z3 ? Math.abs(f3) > ((float) this.f1478b) : z4 && Math.abs(f4) > ((float) this.f1478b);
        }
        float f5 = (f4 * f4) + (f3 * f3);
        int i3 = this.f1478b;
        return f5 > ((float) (i3 * i3));
    }

    /* JADX INFO: renamed from: d */
    public final void m1320d(int i3) {
        float[] fArr = this.f1480d;
        if (fArr != null) {
            int i4 = this.f1487k;
            int i5 = 1 << i3;
            if ((i4 & i5) != 0) {
                fArr[i3] = 0.0f;
                this.f1481e[i3] = 0.0f;
                this.f1482f[i3] = 0.0f;
                this.f1483g[i3] = 0.0f;
                this.f1484h[i3] = 0;
                this.f1485i[i3] = 0;
                this.f1486j[i3] = 0;
                this.f1487k = (~i5) & i4;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m1321e(int i3, int i4, int i5) {
        if (i3 == 0) {
            return 0;
        }
        float width = this.f1496t.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i3) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i4);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i3) / i5) + 1.0f) * 256.0f), 600);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m1322f() {
        if (this.f1477a == 2) {
            OverScroller overScroller = this.f1492p;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f1494r.getLeft();
            int top = currY - this.f1494r.getTop();
            if (left != 0) {
                View view = this.f1494r;
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f1494r;
                WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f1493q.mo580p(this.f1494r, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.f1496t.post(this.f1497u);
            }
        }
        return this.f1477a == 2;
    }

    /* JADX INFO: renamed from: g */
    public final View m1323g(int i3, int i4) {
        ViewGroup viewGroup = this.f1496t;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f1493q.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i3 >= childAt.getLeft() && i3 < childAt.getRight() && i4 >= childAt.getTop() && i4 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m1324h(int i3, int i4, int i5, int i6) {
        float f3;
        float f4;
        float f5;
        float f6;
        int left = this.f1494r.getLeft();
        int top = this.f1494r.getTop();
        int i7 = i3 - left;
        int i8 = i4 - top;
        OverScroller overScroller = this.f1492p;
        int i9 = 0;
        if (i7 == 0 && i8 == 0) {
            overScroller.abortAnimation();
            m1330n(0);
            return false;
        }
        View view = this.f1494r;
        int i10 = (int) this.f1490n;
        int i11 = (int) this.f1489m;
        int iAbs = Math.abs(i5);
        if (iAbs < i10) {
            i5 = 0;
        } else if (iAbs > i11) {
            i5 = i5 > 0 ? i11 : -i11;
        }
        int iAbs2 = Math.abs(i6);
        if (iAbs2 < i10) {
            i6 = i9;
        } else if (iAbs2 > i11) {
            if (i6 > 0) {
                i6 = i11;
            } else {
                i9 = -i11;
                i6 = i9;
            }
        }
        int iAbs3 = Math.abs(i7);
        int iAbs4 = Math.abs(i8);
        int iAbs5 = Math.abs(i5);
        int iAbs6 = Math.abs(i6);
        int i12 = iAbs5 + iAbs6;
        int i13 = iAbs3 + iAbs4;
        if (i5 != 0) {
            f3 = iAbs5;
            f4 = i12;
        } else {
            f3 = iAbs3;
            f4 = i13;
        }
        float f7 = f3 / f4;
        if (i6 != 0) {
            f5 = iAbs6;
            f6 = i12;
        } else {
            f5 = iAbs4;
            f6 = i13;
        }
        float f8 = f5 / f6;
        AbstractC1920f abstractC1920f = this.f1493q;
        overScroller.startScroll(left, top, i7, i8, (int) ((m1321e(i8, i6, abstractC1920f.mo578i()) * f8) + (m1321e(i7, i5, abstractC1920f.mo577h(view)) * f7)));
        m1330n(2);
        return true;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m1325i(int i3) {
        if ((this.f1487k & (1 << i3)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i3 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* JADX INFO: renamed from: j */
    public final void m1326j(MotionEvent motionEvent) {
        int i3;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m1317a();
        }
        if (this.f1488l == null) {
            this.f1488l = VelocityTracker.obtain();
        }
        this.f1488l.addMovement(motionEvent);
        int i4 = 0;
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y2 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewM1323g = m1323g((int) x3, (int) y2);
            m1328l(x3, y2, pointerId);
            m1333q(viewM1323g, pointerId);
            int i5 = this.f1484h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f1477a == 1) {
                m1327k();
            }
            m1317a();
            return;
        }
        AbstractC1920f abstractC1920f = this.f1493q;
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f1477a == 1) {
                    this.f1495s = true;
                    abstractC1920f.mo581q(this.f1494r, 0.0f, 0.0f);
                    this.f1495s = false;
                    if (this.f1477a == 1) {
                        m1330n(0);
                    }
                }
                m1317a();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y3 = motionEvent.getY(actionIndex);
                m1328l(x4, y3, pointerId2);
                if (this.f1477a == 0) {
                    m1333q(m1323g((int) x4, (int) y3), pointerId2);
                    int i6 = this.f1484h[pointerId2];
                    return;
                }
                int i7 = (int) x4;
                int i8 = (int) y3;
                View view = this.f1494r;
                if (view != null) {
                    i4 = (i7 < view.getLeft() || i7 >= view.getRight() || i8 < view.getTop() || i8 >= view.getBottom()) ? 0 : 1;
                }
                if (i4 != 0) {
                    m1333q(this.f1494r, pointerId2);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f1477a == 1 && pointerId3 == this.f1479c) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i4 >= pointerCount) {
                        i3 = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i4);
                    if (pointerId4 != this.f1479c) {
                        View viewM1323g2 = m1323g((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
                        View view2 = this.f1494r;
                        if (viewM1323g2 == view2 && m1333q(view2, pointerId4)) {
                            i3 = this.f1479c;
                            break;
                        }
                    }
                    i4++;
                }
                if (i3 == -1) {
                    m1327k();
                }
            }
            m1320d(pointerId3);
            return;
        }
        if (this.f1477a == 1) {
            if (m1325i(this.f1479c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1479c);
                float x5 = motionEvent.getX(iFindPointerIndex);
                float y4 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f1482f;
                int i9 = this.f1479c;
                int i10 = (int) (x5 - fArr[i9]);
                int i11 = (int) (y4 - this.f1483g[i9]);
                int left = this.f1494r.getLeft() + i10;
                int top = this.f1494r.getTop() + i11;
                int left2 = this.f1494r.getLeft();
                int top2 = this.f1494r.getTop();
                if (i10 != 0) {
                    left = abstractC1920f.mo575a(this.f1494r, left);
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    this.f1494r.offsetLeftAndRight(left - left2);
                }
                if (i11 != 0) {
                    top = abstractC1920f.mo576b(this.f1494r, top);
                    WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                    this.f1494r.offsetTopAndBottom(top - top2);
                }
                if (i10 != 0 || i11 != 0) {
                    abstractC1920f.mo580p(this.f1494r, left, top);
                }
                m1329m(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i4 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i4);
            if (m1325i(pointerId5)) {
                float x6 = motionEvent.getX(i4);
                float y5 = motionEvent.getY(i4);
                float f3 = x6 - this.f1480d[pointerId5];
                float f4 = y5 - this.f1481e[pointerId5];
                Math.abs(f3);
                Math.abs(f4);
                int i12 = this.f1484h[pointerId5];
                Math.abs(f4);
                Math.abs(f3);
                int i13 = this.f1484h[pointerId5];
                Math.abs(f3);
                Math.abs(f4);
                int i14 = this.f1484h[pointerId5];
                Math.abs(f4);
                Math.abs(f3);
                int i15 = this.f1484h[pointerId5];
                if (this.f1477a != 1) {
                    View viewM1323g3 = m1323g((int) x6, (int) y5);
                    if (m1319c(viewM1323g3, f3, f4) && m1333q(viewM1323g3, pointerId5)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i4++;
        }
        m1329m(motionEvent);
    }

    /* JADX INFO: renamed from: k */
    public final void m1327k() {
        VelocityTracker velocityTracker = this.f1488l;
        float f3 = this.f1489m;
        velocityTracker.computeCurrentVelocity(1000, f3);
        float xVelocity = this.f1488l.getXVelocity(this.f1479c);
        float f4 = this.f1490n;
        float fAbs = Math.abs(xVelocity);
        float f5 = 0.0f;
        if (fAbs < f4) {
            xVelocity = 0.0f;
        } else if (fAbs > f3) {
            xVelocity = xVelocity > 0.0f ? f3 : -f3;
        }
        float yVelocity = this.f1488l.getYVelocity(this.f1479c);
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 >= f4) {
            if (fAbs2 > f3) {
                if (yVelocity <= 0.0f) {
                    f3 = -f3;
                }
                f5 = f3;
            } else {
                f5 = yVelocity;
            }
        }
        this.f1495s = true;
        this.f1493q.mo581q(this.f1494r, xVelocity, f5);
        this.f1495s = false;
        if (this.f1477a == 1) {
            m1330n(0);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m1328l(float f3, float f4, int i3) {
        float[] fArr = this.f1480d;
        if (fArr == null || fArr.length <= i3) {
            int i4 = i3 + 1;
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            float[] fArr5 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f1481e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1482f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1483g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1484h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1485i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1486j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1480d = fArr2;
            this.f1481e = fArr3;
            this.f1482f = fArr4;
            this.f1483g = fArr5;
            this.f1484h = iArr;
            this.f1485i = iArr2;
            this.f1486j = iArr3;
        }
        float[] fArr9 = this.f1480d;
        this.f1482f[i3] = f3;
        fArr9[i3] = f3;
        float[] fArr10 = this.f1481e;
        this.f1483g[i3] = f4;
        fArr10[i3] = f4;
        int[] iArr7 = this.f1484h;
        int i5 = (int) f3;
        int i6 = (int) f4;
        ViewGroup viewGroup = this.f1496t;
        int left = viewGroup.getLeft();
        int i7 = this.f1491o;
        int i8 = i5 < left + i7 ? 1 : 0;
        if (i6 < viewGroup.getTop() + i7) {
            i8 |= 4;
        }
        if (i5 > viewGroup.getRight() - i7) {
            i8 |= 2;
        }
        if (i6 > viewGroup.getBottom() - i7) {
            i8 |= 8;
        }
        iArr7[i3] = i8;
        this.f1487k |= 1 << i3;
    }

    /* JADX INFO: renamed from: m */
    public final void m1329m(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i3 = 0; i3 < pointerCount; i3++) {
            int pointerId = motionEvent.getPointerId(i3);
            if (m1325i(pointerId)) {
                float x3 = motionEvent.getX(i3);
                float y2 = motionEvent.getY(i3);
                this.f1482f[pointerId] = x3;
                this.f1483g[pointerId] = y2;
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m1330n(int i3) {
        this.f1496t.removeCallbacks(this.f1497u);
        if (this.f1477a != i3) {
            this.f1477a = i3;
            this.f1493q.mo579o(i3);
            if (this.f1477a == 0) {
                this.f1494r = null;
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public final boolean m1331o(int i3, int i4) {
        if (this.f1495s) {
            return m1324h(i3, i4, (int) this.f1488l.getXVelocity(this.f1479c), (int) this.f1488l.getYVelocity(this.f1479c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0114  */
    /* JADX INFO: renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m1332p(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p049Q.C0587e.m1332p(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: renamed from: q */
    public final boolean m1333q(View view, int i3) {
        if (view == this.f1494r && this.f1479c == i3) {
            return true;
        }
        if (view == null || !this.f1493q.mo582r(view, i3)) {
            return false;
        }
        this.f1479c = i3;
        m1318b(view, i3);
        return true;
    }
}

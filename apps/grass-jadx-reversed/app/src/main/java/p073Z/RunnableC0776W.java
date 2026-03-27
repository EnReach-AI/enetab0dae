package p073Z;

import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p049Q.InterpolatorC0586d;
import p067W1.C0693a;

/* JADX INFO: renamed from: Z.W */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0776W implements Runnable {

    /* JADX INFO: renamed from: e */
    public int f2194e;

    /* JADX INFO: renamed from: f */
    public int f2195f;

    /* JADX INFO: renamed from: g */
    public OverScroller f2196g;

    /* JADX INFO: renamed from: h */
    public Interpolator f2197h;

    /* JADX INFO: renamed from: i */
    public boolean f2198i;

    /* JADX INFO: renamed from: j */
    public boolean f2199j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ RecyclerView f2200k;

    public RunnableC0776W(RecyclerView recyclerView) {
        this.f2200k = recyclerView;
        InterpolatorC0586d interpolatorC0586d = RecyclerView.f3384y0;
        this.f2197h = interpolatorC0586d;
        this.f2198i = false;
        this.f2199j = false;
        this.f2196g = new OverScroller(recyclerView.getContext(), interpolatorC0586d);
    }

    /* JADX INFO: renamed from: a */
    public final void m2048a() {
        if (this.f2198i) {
            this.f2199j = true;
            return;
        }
        RecyclerView recyclerView = this.f2200k;
        recyclerView.removeCallbacks(this);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m597m(recyclerView, this);
    }

    /* JADX INFO: renamed from: b */
    public final void m2049b(int i3, int i4, int i5, Interpolator interpolator) {
        int iRound;
        RecyclerView recyclerView = this.f2200k;
        if (i5 == Integer.MIN_VALUE) {
            int iAbs = Math.abs(i3);
            int iAbs2 = Math.abs(i4);
            boolean z3 = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt(0);
            int iSqrt2 = (int) Math.sqrt((i4 * i4) + (i3 * i3));
            int width = z3 ? recyclerView.getWidth() : recyclerView.getHeight();
            int i6 = width / 2;
            float f3 = width;
            float f4 = i6;
            float fSin = (((float) Math.sin((Math.min(1.0f, (iSqrt2 * 1.0f) / f3) - 0.5f) * 0.47123894f)) * f4) + f4;
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fSin / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z3) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f3) + 1.0f) * 300.0f);
            }
            i5 = Math.min(iRound, 2000);
        }
        int i7 = i5;
        if (interpolator == null) {
            interpolator = RecyclerView.f3384y0;
        }
        if (this.f2197h != interpolator) {
            this.f2197h = interpolator;
            this.f2196g = new OverScroller(recyclerView.getContext(), interpolator);
        }
        this.f2195f = 0;
        this.f2194e = 0;
        recyclerView.setScrollState(2);
        this.f2196g.startScroll(0, 0, i3, i4, i7);
        m2048a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3;
        int i4;
        int i5;
        int i6;
        RecyclerView recyclerView = this.f2200k;
        if (recyclerView.f3434p == null) {
            recyclerView.removeCallbacks(this);
            this.f2196g.abortAnimation();
            return;
        }
        this.f2199j = false;
        this.f2198i = true;
        recyclerView.m2612m();
        OverScroller overScroller = this.f2196g;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i7 = currX - this.f2194e;
            int i8 = currY - this.f2195f;
            this.f2194e = currX;
            this.f2195f = currY;
            int[] iArr = recyclerView.f3441s0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean zM2617r = recyclerView.m2617r(i7, i8, iArr, null, 1);
            int[] iArr2 = recyclerView.f3441s0;
            if (zM2617r) {
                i7 -= iArr2[0];
                i8 -= iArr2[1];
            }
            if (recyclerView.getOverScrollMode() != 2) {
                recyclerView.m2611l(i7, i8);
            }
            if (recyclerView.f3432o != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
                recyclerView.m2600Z(i7, i8, iArr2);
                int i9 = iArr2[0];
                int i10 = iArr2[1];
                int i11 = i7 - i9;
                int i12 = i8 - i10;
                C0809u c0809u = recyclerView.f3434p.f2143e;
                if (c0809u != null && !c0809u.f2395d && c0809u.f2396e) {
                    int iM2047b = recyclerView.f3417g0.m2047b();
                    if (iM2047b == 0) {
                        c0809u.m2112g();
                    } else if (c0809u.f2392a >= iM2047b) {
                        c0809u.f2392a = iM2047b - 1;
                        c0809u.m2110e(i9, i10);
                    } else {
                        c0809u.m2110e(i9, i10);
                    }
                }
                i6 = i9;
                i3 = i11;
                i4 = i12;
                i5 = i10;
            } else {
                i3 = i7;
                i4 = i8;
                i5 = 0;
                i6 = 0;
            }
            if (!recyclerView.f3436q.isEmpty()) {
                recyclerView.invalidate();
            }
            int[] iArr3 = recyclerView.f3441s0;
            iArr3[0] = 0;
            iArr3[1] = 0;
            int i13 = i5;
            recyclerView.m2618s(i6, i5, i3, i4, null, 1, iArr3);
            int i14 = i3 - iArr2[0];
            int i15 = i4 - iArr2[1];
            if (i6 != 0 || i13 != 0) {
                recyclerView.m2619t(i6, i13);
            }
            if (!recyclerView.awakenScrollBars()) {
                recyclerView.invalidate();
            }
            boolean z3 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i14 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i15 != 0));
            C0809u c0809u2 = recyclerView.f3434p.f2143e;
            if ((c0809u2 == null || !c0809u2.f2395d) && z3) {
                if (recyclerView.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    int i16 = i14 < 0 ? -currVelocity : i14 > 0 ? currVelocity : 0;
                    if (i15 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i15 <= 0) {
                        currVelocity = 0;
                    }
                    if (i16 < 0) {
                        recyclerView.m2621v();
                        if (recyclerView.f3392H.isFinished()) {
                            recyclerView.f3392H.onAbsorb(-i16);
                        }
                    } else if (i16 > 0) {
                        recyclerView.m2622w();
                        if (recyclerView.f3394J.isFinished()) {
                            recyclerView.f3394J.onAbsorb(i16);
                        }
                    }
                    if (currVelocity < 0) {
                        recyclerView.m2623x();
                        if (recyclerView.f3393I.isFinished()) {
                            recyclerView.f3393I.onAbsorb(-currVelocity);
                        }
                    } else if (currVelocity > 0) {
                        recyclerView.m2620u();
                        if (recyclerView.f3395K.isFinished()) {
                            recyclerView.f3395K.onAbsorb(currVelocity);
                        }
                    }
                    if (i16 != 0 || currVelocity != 0) {
                        WeakHashMap weakHashMap = AbstractC0323S.f816a;
                        AbstractC0307B.m595k(recyclerView);
                    }
                }
                C0693a c0693a = recyclerView.f3415f0;
                int[] iArr4 = (int[]) c0693a.f1884d;
                if (iArr4 != null) {
                    Arrays.fill(iArr4, -1);
                }
                c0693a.f1883c = 0;
            } else {
                m2048a();
                RunnableC0802n runnableC0802n = recyclerView.f3413e0;
                if (runnableC0802n != null) {
                    runnableC0802n.m2098a(recyclerView, i6, i13);
                }
            }
        }
        C0809u c0809u3 = recyclerView.f3434p.f2143e;
        if (c0809u3 != null && c0809u3.f2395d) {
            c0809u3.m2110e(0, 0);
        }
        this.f2198i = false;
        if (!this.f2199j) {
            recyclerView.setScrollState(0);
            recyclerView.m2605e0(1);
        } else {
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
            AbstractC0307B.m597m(recyclerView, this);
        }
    }
}

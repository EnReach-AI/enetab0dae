package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.ArrayList;
import p140s.C1864d;
import p140s.C1867g;
import p143t.C1903b;
import p147u.AbstractC1940p;
import p147u.AbstractC1941q;

/* JADX INFO: loaded from: classes.dex */
public class Flow extends AbstractC1941q {

    /* JADX INFO: renamed from: m */
    public C1867g f2868m;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // p147u.AbstractC1941q, p147u.AbstractC1926b
    /* JADX INFO: renamed from: e */
    public final void mo2289e(AttributeSet attributeSet) {
        super.mo2289e(attributeSet);
        C1867g c1867g = new C1867g();
        c1867g.f6565f0 = 0;
        c1867g.f6566g0 = 0;
        c1867g.f6567h0 = 0;
        c1867g.f6568i0 = 0;
        c1867g.f6569j0 = 0;
        c1867g.f6570k0 = 0;
        c1867g.f6571l0 = false;
        c1867g.f6572m0 = 0;
        c1867g.f6573n0 = 0;
        c1867g.f6574o0 = new C1903b();
        c1867g.f6575p0 = null;
        c1867g.f6576q0 = -1;
        c1867g.f6577r0 = -1;
        c1867g.f6578s0 = -1;
        c1867g.f6579t0 = -1;
        c1867g.f6580u0 = -1;
        c1867g.f6581v0 = -1;
        c1867g.f6582w0 = 0.5f;
        c1867g.f6583x0 = 0.5f;
        c1867g.f6584y0 = 0.5f;
        c1867g.f6585z0 = 0.5f;
        c1867g.f6550A0 = 0.5f;
        c1867g.f6551B0 = 0.5f;
        c1867g.f6552C0 = 0;
        c1867g.f6553D0 = 0;
        c1867g.f6554E0 = 2;
        c1867g.f6555F0 = 2;
        c1867g.f6556G0 = 0;
        c1867g.f6557H0 = -1;
        c1867g.f6558I0 = 0;
        c1867g.f6559J0 = new ArrayList();
        c1867g.f6560K0 = null;
        c1867g.f6561L0 = null;
        c1867g.f6562M0 = null;
        c1867g.f6564O0 = 0;
        this.f2868m = c1867g;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC1940p.f6925b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == 0) {
                    this.f2868m.f6558I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    C1867g c1867g2 = this.f2868m;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c1867g2.f6565f0 = dimensionPixelSize;
                    c1867g2.f6566g0 = dimensionPixelSize;
                    c1867g2.f6567h0 = dimensionPixelSize;
                    c1867g2.f6568i0 = dimensionPixelSize;
                } else if (index == 11) {
                    C1867g c1867g3 = this.f2868m;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    c1867g3.f6567h0 = dimensionPixelSize2;
                    c1867g3.f6569j0 = dimensionPixelSize2;
                    c1867g3.f6570k0 = dimensionPixelSize2;
                } else if (index == 12) {
                    this.f2868m.f6568i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f2868m.f6569j0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f2868m.f6565f0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f2868m.f6570k0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f2868m.f6566g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 37) {
                    this.f2868m.f6556G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 27) {
                    this.f2868m.f6576q0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 36) {
                    this.f2868m.f6577r0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 21) {
                    this.f2868m.f6578s0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 29) {
                    this.f2868m.f6580u0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 23) {
                    this.f2868m.f6579t0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 31) {
                    this.f2868m.f6581v0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 25) {
                    this.f2868m.f6582w0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 20) {
                    this.f2868m.f6584y0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 28) {
                    this.f2868m.f6550A0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 22) {
                    this.f2868m.f6585z0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 30) {
                    this.f2868m.f6551B0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 34) {
                    this.f2868m.f6583x0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 24) {
                    this.f2868m.f6554E0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 33) {
                    this.f2868m.f6555F0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 26) {
                    this.f2868m.f6552C0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 35) {
                    this.f2868m.f6553D0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 32) {
                    this.f2868m.f6557H0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
        }
        this.f6750h = this.f2868m;
        m4324g();
    }

    @Override // p147u.AbstractC1926b
    /* JADX INFO: renamed from: f */
    public final void mo2290f(C1864d c1864d, boolean z3) {
        C1867g c1867g = this.f2868m;
        int i3 = c1867g.f6567h0;
        if (i3 > 0 || c1867g.f6568i0 > 0) {
            if (z3) {
                c1867g.f6569j0 = c1867g.f6568i0;
                c1867g.f6570k0 = i3;
            } else {
                c1867g.f6569j0 = i3;
                c1867g.f6570k0 = c1867g.f6568i0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x00d4 A[EDGE_INSN: B:338:0x00d4->B:63:0x00d4 BREAK  A[LOOP:1: B:57:0x00c0->B:62:0x00d0], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010f  */
    @Override // p147u.AbstractC1941q
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo2291h(p140s.C1867g r40, int r41, int r42) {
        /*
            Method dump skipped, instruction units count: 1528
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.mo2291h(s.g, int, int):void");
    }

    @Override // p147u.AbstractC1926b, android.view.View
    public final void onMeasure(int i3, int i4) {
        mo2291h(this.f2868m, i3, i4);
    }

    public void setFirstHorizontalBias(float f3) {
        this.f2868m.f6584y0 = f3;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i3) {
        this.f2868m.f6578s0 = i3;
        requestLayout();
    }

    public void setFirstVerticalBias(float f3) {
        this.f2868m.f6585z0 = f3;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i3) {
        this.f2868m.f6579t0 = i3;
        requestLayout();
    }

    public void setHorizontalAlign(int i3) {
        this.f2868m.f6554E0 = i3;
        requestLayout();
    }

    public void setHorizontalBias(float f3) {
        this.f2868m.f6582w0 = f3;
        requestLayout();
    }

    public void setHorizontalGap(int i3) {
        this.f2868m.f6552C0 = i3;
        requestLayout();
    }

    public void setHorizontalStyle(int i3) {
        this.f2868m.f6576q0 = i3;
        requestLayout();
    }

    public void setMaxElementsWrap(int i3) {
        this.f2868m.f6557H0 = i3;
        requestLayout();
    }

    public void setOrientation(int i3) {
        this.f2868m.f6558I0 = i3;
        requestLayout();
    }

    public void setPadding(int i3) {
        C1867g c1867g = this.f2868m;
        c1867g.f6565f0 = i3;
        c1867g.f6566g0 = i3;
        c1867g.f6567h0 = i3;
        c1867g.f6568i0 = i3;
        requestLayout();
    }

    public void setPaddingBottom(int i3) {
        this.f2868m.f6566g0 = i3;
        requestLayout();
    }

    public void setPaddingLeft(int i3) {
        this.f2868m.f6569j0 = i3;
        requestLayout();
    }

    public void setPaddingRight(int i3) {
        this.f2868m.f6570k0 = i3;
        requestLayout();
    }

    public void setPaddingTop(int i3) {
        this.f2868m.f6565f0 = i3;
        requestLayout();
    }

    public void setVerticalAlign(int i3) {
        this.f2868m.f6555F0 = i3;
        requestLayout();
    }

    public void setVerticalBias(float f3) {
        this.f2868m.f6583x0 = f3;
        requestLayout();
    }

    public void setVerticalGap(int i3) {
        this.f2868m.f6553D0 = i3;
        requestLayout();
    }

    public void setVerticalStyle(int i3) {
        this.f2868m.f6577r0 = i3;
        requestLayout();
    }

    public void setWrapMode(int i3) {
        this.f2868m.f6556G0 = i3;
        requestLayout();
    }
}

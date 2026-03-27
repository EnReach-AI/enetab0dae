package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashMap;
import p140s.C1861a;
import p140s.C1864d;
import p147u.AbstractC1926b;
import p147u.AbstractC1940p;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends AbstractC1926b {

    /* JADX INFO: renamed from: k */
    public int f2869k;

    /* JADX INFO: renamed from: l */
    public int f2870l;

    /* JADX INFO: renamed from: m */
    public C1861a f2871m;

    public Barrier(Context context) {
        super(context);
        this.f6747e = new int[32];
        this.f6752j = new HashMap();
        this.f6749g = context;
        mo2289e(null);
        super.setVisibility(8);
    }

    @Override // p147u.AbstractC1926b
    /* JADX INFO: renamed from: e */
    public final void mo2289e(AttributeSet attributeSet) {
        super.mo2289e(attributeSet);
        C1861a c1861a = new C1861a();
        c1861a.f6435f0 = 0;
        c1861a.f6436g0 = true;
        c1861a.f6437h0 = 0;
        this.f2871m = c1861a;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC1940p.f6925b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == 15) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == 14) {
                    this.f2871m.f6436g0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == 16) {
                    this.f2871m.f6437h0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
        }
        this.f6750h = this.f2871m;
        m4324g();
    }

    @Override // p147u.AbstractC1926b
    /* JADX INFO: renamed from: f */
    public final void mo2290f(C1864d c1864d, boolean z3) {
        int i3 = this.f2869k;
        this.f2870l = i3;
        if (z3) {
            if (i3 == 5) {
                this.f2870l = 1;
            } else if (i3 == 6) {
                this.f2870l = 0;
            }
        } else if (i3 == 5) {
            this.f2870l = 0;
        } else if (i3 == 6) {
            this.f2870l = 1;
        }
        if (c1864d instanceof C1861a) {
            ((C1861a) c1864d).f6435f0 = this.f2870l;
        }
    }

    public int getMargin() {
        return this.f2871m.f6437h0;
    }

    public int getType() {
        return this.f2869k;
    }

    public void setAllowsGoneWidget(boolean z3) {
        this.f2871m.f6436g0 = z3;
    }

    public void setDpMargin(int i3) {
        this.f2871m.f6437h0 = (int) ((i3 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i3) {
        this.f2871m.f6437h0 = i3;
    }

    public void setType(int i3) {
        this.f2869k = i3;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}

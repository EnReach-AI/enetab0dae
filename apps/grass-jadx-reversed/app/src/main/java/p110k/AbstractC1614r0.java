package p110k;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import p029J.AbstractC0323S;
import p094f.AbstractC1343a;
import p166z0.C2071i;

/* JADX INFO: renamed from: k.r0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1614r0 extends ViewGroup {

    /* JADX INFO: renamed from: e */
    public boolean f5724e;

    /* JADX INFO: renamed from: f */
    public int f5725f;

    /* JADX INFO: renamed from: g */
    public int f5726g;

    /* JADX INFO: renamed from: h */
    public int f5727h;

    /* JADX INFO: renamed from: i */
    public int f5728i;

    /* JADX INFO: renamed from: j */
    public int f5729j;

    /* JADX INFO: renamed from: k */
    public float f5730k;

    /* JADX INFO: renamed from: l */
    public boolean f5731l;

    /* JADX INFO: renamed from: m */
    public int[] f5732m;

    /* JADX INFO: renamed from: n */
    public int[] f5733n;

    /* JADX INFO: renamed from: o */
    public Drawable f5734o;

    /* JADX INFO: renamed from: p */
    public int f5735p;

    /* JADX INFO: renamed from: q */
    public int f5736q;

    /* JADX INFO: renamed from: r */
    public int f5737r;

    /* JADX INFO: renamed from: s */
    public int f5738s;

    public AbstractC1614r0(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f5724e = true;
        this.f5725f = -1;
        this.f5726g = 0;
        this.f5728i = 8388659;
        int[] iArr = AbstractC1343a.f4790n;
        C2071i c2071iM4591v = C2071i.m4591v(context, attributeSet, iArr, i3, 0);
        AbstractC0323S.m700j(this, context, iArr, attributeSet, (TypedArray) c2071iM4591v.f7315b, i3);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        int i4 = typedArray.getInt(1, -1);
        if (i4 >= 0) {
            setOrientation(i4);
        }
        int i5 = typedArray.getInt(0, -1);
        if (i5 >= 0) {
            setGravity(i5);
        }
        boolean z3 = typedArray.getBoolean(2, true);
        if (!z3) {
            setBaselineAligned(z3);
        }
        this.f5730k = typedArray.getFloat(4, -1.0f);
        this.f5725f = typedArray.getInt(3, -1);
        this.f5731l = typedArray.getBoolean(7, false);
        setDividerDrawable(c2071iM4591v.m4601l(5));
        this.f5737r = typedArray.getInt(8, 0);
        this.f5738s = typedArray.getDimensionPixelSize(6, 0);
        c2071iM4591v.m4608x();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C1612q0;
    }

    /* JADX INFO: renamed from: f */
    public final void m3684f(Canvas canvas, int i3) {
        this.f5734o.setBounds(getPaddingLeft() + this.f5738s, i3, (getWidth() - getPaddingRight()) - this.f5738s, this.f5736q + i3);
        this.f5734o.draw(canvas);
    }

    /* JADX INFO: renamed from: g */
    public final void m3685g(Canvas canvas, int i3) {
        this.f5734o.setBounds(i3, getPaddingTop() + this.f5738s, this.f5735p + i3, (getHeight() - getPaddingBottom()) - this.f5738s);
        this.f5734o.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i3;
        if (this.f5725f < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i4 = this.f5725f;
        if (childCount <= i4) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i4);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f5725f == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f5726g;
        if (this.f5727h == 1 && (i3 = this.f5728i & 112) != 48) {
            if (i3 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f5729j) / 2;
            } else if (i3 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f5729j;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((C1612q0) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f5725f;
    }

    public Drawable getDividerDrawable() {
        return this.f5734o;
    }

    public int getDividerPadding() {
        return this.f5738s;
    }

    public int getDividerWidth() {
        return this.f5735p;
    }

    public int getGravity() {
        return this.f5728i;
    }

    public int getOrientation() {
        return this.f5727h;
    }

    public int getShowDividers() {
        return this.f5737r;
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f5730k;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public C1612q0 generateDefaultLayoutParams() {
        int i3 = this.f5727h;
        if (i3 == 0) {
            return new C1612q0(-2, -2);
        }
        if (i3 == 1) {
            return new C1612q0(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public C1612q0 generateLayoutParams(AttributeSet attributeSet) {
        return new C1612q0(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public C1612q0 generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C1612q0(layoutParams);
    }

    /* JADX INFO: renamed from: k */
    public final boolean m3686k(int i3) {
        if (i3 == 0) {
            return (this.f5737r & 1) != 0;
        }
        if (i3 == getChildCount()) {
            return (this.f5737r & 4) != 0;
        }
        if ((this.f5737r & 2) == 0) {
            return false;
        }
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            if (getChildAt(i4).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int right;
        int left;
        int i3;
        if (this.f5734o == null) {
            return;
        }
        int i4 = 0;
        if (this.f5727h == 1) {
            int virtualChildCount = getVirtualChildCount();
            while (i4 < virtualChildCount) {
                View childAt = getChildAt(i4);
                if (childAt != null && childAt.getVisibility() != 8 && m3686k(i4)) {
                    m3684f(canvas, (childAt.getTop() - ((LinearLayout.LayoutParams) ((C1612q0) childAt.getLayoutParams())).topMargin) - this.f5736q);
                }
                i4++;
            }
            if (m3686k(virtualChildCount)) {
                View childAt2 = getChildAt(virtualChildCount - 1);
                m3684f(canvas, childAt2 == null ? (getHeight() - getPaddingBottom()) - this.f5736q : childAt2.getBottom() + ((LinearLayout.LayoutParams) ((C1612q0) childAt2.getLayoutParams())).bottomMargin);
                return;
            }
            return;
        }
        int virtualChildCount2 = getVirtualChildCount();
        boolean zM3658a = AbstractC1596i1.m3658a(this);
        while (i4 < virtualChildCount2) {
            View childAt3 = getChildAt(i4);
            if (childAt3 != null && childAt3.getVisibility() != 8 && m3686k(i4)) {
                C1612q0 c1612q0 = (C1612q0) childAt3.getLayoutParams();
                m3685g(canvas, zM3658a ? childAt3.getRight() + ((LinearLayout.LayoutParams) c1612q0).rightMargin : (childAt3.getLeft() - ((LinearLayout.LayoutParams) c1612q0).leftMargin) - this.f5735p);
            }
            i4++;
        }
        if (m3686k(virtualChildCount2)) {
            View childAt4 = getChildAt(virtualChildCount2 - 1);
            if (childAt4 != null) {
                C1612q0 c1612q02 = (C1612q0) childAt4.getLayoutParams();
                if (zM3658a) {
                    left = childAt4.getLeft() - ((LinearLayout.LayoutParams) c1612q02).leftMargin;
                    i3 = this.f5735p;
                    right = left - i3;
                } else {
                    right = childAt4.getRight() + ((LinearLayout.LayoutParams) c1612q02).rightMargin;
                }
            } else if (zM3658a) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i3 = this.f5735p;
                right = left - i3;
            }
            m3685g(canvas, right);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.AbstractC1614r0.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04cc  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0550  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0806  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0860  */
    /* JADX WARN: Removed duplicated region for block: B:442:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r38, int r39) {
        /*
            Method dump skipped, instruction units count: 2208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.AbstractC1614r0.onMeasure(int, int):void");
    }

    public void setBaselineAligned(boolean z3) {
        this.f5724e = z3;
    }

    public void setBaselineAlignedChildIndex(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.f5725f = i3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f5734o) {
            return;
        }
        this.f5734o = drawable;
        if (drawable != null) {
            this.f5735p = drawable.getIntrinsicWidth();
            this.f5736q = drawable.getIntrinsicHeight();
        } else {
            this.f5735p = 0;
            this.f5736q = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i3) {
        this.f5738s = i3;
    }

    public void setGravity(int i3) {
        if (this.f5728i != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f5728i = i3;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i3) {
        int i4 = i3 & 8388615;
        int i5 = this.f5728i;
        if ((8388615 & i5) != i4) {
            this.f5728i = i4 | ((-8388616) & i5);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z3) {
        this.f5731l = z3;
    }

    public void setOrientation(int i3) {
        if (this.f5727h != i3) {
            this.f5727h = i3;
            requestLayout();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.f5737r) {
            requestLayout();
        }
        this.f5737r = i3;
    }

    public void setVerticalGravity(int i3) {
        int i4 = i3 & 112;
        int i5 = this.f5728i;
        if ((i5 & 112) != i4) {
            this.f5728i = i4 | (i5 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f3) {
        this.f5730k = Math.max(0.0f, f3);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}

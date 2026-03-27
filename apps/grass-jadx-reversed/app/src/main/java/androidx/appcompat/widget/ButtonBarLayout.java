package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p094f.AbstractC1343a;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: e */
    public boolean f2754e;

    /* JADX INFO: renamed from: f */
    public boolean f2755f;

    /* JADX INFO: renamed from: g */
    public int f2756g;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2756g = -1;
        int[] iArr = AbstractC1343a.f4787k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        AbstractC0323S.m700j(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0);
        this.f2754e = typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.f2754e);
        }
    }

    private void setStacked(boolean z3) {
        if (this.f2755f != z3) {
            if (!z3 || this.f2754e) {
                this.f2755f = z3;
                setOrientation(z3 ? 1 : 0);
                setGravity(z3 ? 8388613 : 80);
                View viewFindViewById = findViewById(R.id.spacer);
                if (viewFindViewById != null) {
                    viewFindViewById.setVisibility(z3 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        int iMakeMeasureSpec;
        boolean z3;
        int i5;
        int size = View.MeasureSpec.getSize(i3);
        int paddingBottom = 0;
        if (this.f2754e) {
            if (size > this.f2756g && this.f2755f) {
                setStacked(false);
            }
            this.f2756g = size;
        }
        if (this.f2755f || View.MeasureSpec.getMode(i3) != 1073741824) {
            iMakeMeasureSpec = i3;
            z3 = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z3 = true;
        }
        super.onMeasure(iMakeMeasureSpec, i4);
        if (this.f2754e && !this.f2755f && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z3 = true;
        }
        if (z3) {
            super.onMeasure(i3, i4);
        }
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            i5 = -1;
            if (i6 >= childCount) {
                i6 = -1;
                break;
            } else if (getChildAt(i6).getVisibility() == 0) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            View childAt = getChildAt(i6);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (this.f2755f) {
                int i7 = i6 + 1;
                int childCount2 = getChildCount();
                while (true) {
                    if (i7 >= childCount2) {
                        break;
                    }
                    if (getChildAt(i7).getVisibility() == 0) {
                        i5 = i7;
                        break;
                    }
                    i7++;
                }
                paddingBottom = i5 >= 0 ? getChildAt(i5).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f)) + measuredHeight : measuredHeight;
            } else {
                paddingBottom = getPaddingBottom() + measuredHeight;
            }
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0307B.m588d(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
            if (i4 == 0) {
                super.onMeasure(i3, i4);
            }
        }
    }

    public void setAllowStacking(boolean z3) {
        if (this.f2754e != z3) {
            this.f2754e = z3;
            if (!z3 && this.f2755f) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}

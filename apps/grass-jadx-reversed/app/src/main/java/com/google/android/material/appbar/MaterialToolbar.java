package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import p006B0.C0038a;
import p007B1.AbstractC0054n;
import p009C.AbstractC0139b;
import p025H1.C0278g;
import p029J.AbstractC0307B;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p039M0.AbstractC0473V;
import p040M1.AbstractC0512a;
import p126o1.AbstractC1805a;

/* JADX INFO: loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {

    /* JADX INFO: renamed from: c0 */
    public static final ImageView.ScaleType[] f4215c0 = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: renamed from: U */
    public Integer f4216U;

    /* JADX INFO: renamed from: V */
    public boolean f4217V;

    /* JADX INFO: renamed from: W */
    public boolean f4218W;

    /* JADX INFO: renamed from: a0 */
    public ImageView.ScaleType f4219a0;

    /* JADX INFO: renamed from: b0 */
    public Boolean f4220b0;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(AbstractC0512a.m1020a(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, 0);
        Context context2 = getContext();
        TypedArray typedArrayM216f = AbstractC0054n.m216f(context2, attributeSet, AbstractC1805a.f6242r, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (typedArrayM216f.hasValue(2)) {
            setNavigationIconTint(typedArrayM216f.getColor(2, -1));
        }
        this.f4217V = typedArrayM216f.getBoolean(4, false);
        this.f4218W = typedArrayM216f.getBoolean(3, false);
        int i3 = typedArrayM216f.getInt(1, -1);
        if (i3 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f4215c0;
            if (i3 < scaleTypeArr.length) {
                this.f4219a0 = scaleTypeArr[i3];
            }
        }
        if (typedArrayM216f.hasValue(0)) {
            this.f4220b0 = Boolean.valueOf(typedArrayM216f.getBoolean(0, false));
        }
        typedArrayM216f.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            C0278g c0278g = new C0278g();
            c0278g.m547k(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            c0278g.m545i(context2);
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            c0278g.m546j(AbstractC0313H.m636i(this));
            AbstractC0307B.m601q(this, c0278g);
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f4219a0;
    }

    public Integer getNavigationIconTint() {
        return this.f4216U;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof C0278g) {
            AbstractC0473V.m998K(this, (C0278g) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z3, i3, i4, i5, i6);
        int i7 = 0;
        ImageView imageView2 = null;
        if (this.f4217V || this.f4218W) {
            ArrayList arrayListM214d = AbstractC0054n.m214d(this, getTitle());
            boolean zIsEmpty = arrayListM214d.isEmpty();
            C0038a c0038a = AbstractC0054n.f199c;
            TextView textView = zIsEmpty ? null : (TextView) Collections.min(arrayListM214d, c0038a);
            ArrayList arrayListM214d2 = AbstractC0054n.m214d(this, getSubtitle());
            TextView textView2 = arrayListM214d2.isEmpty() ? null : (TextView) Collections.max(arrayListM214d2, c0038a);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i8 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i9 = 0; i9 < getChildCount(); i9++) {
                    View childAt = getChildAt(i9);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i8 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i8 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.f4217V && textView != null) {
                    m3137u(textView, pair);
                }
                if (this.f4218W && textView2 != null) {
                    m3137u(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i7 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i7);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i7++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.f4220b0;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f4219a0;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        Drawable background = getBackground();
        if (background instanceof C0278g) {
            ((C0278g) background).m546j(f3);
        }
    }

    public void setLogoAdjustViewBounds(boolean z3) {
        Boolean bool = this.f4220b0;
        if (bool == null || bool.booleanValue() != z3) {
            this.f4220b0 = Boolean.valueOf(z3);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f4219a0 != scaleType) {
            this.f4219a0 = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.f4216U != null) {
            drawable = drawable.mutate();
            AbstractC0139b.m279g(drawable, this.f4216U.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int i3) {
        this.f4216U = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z3) {
        if (this.f4218W != z3) {
            this.f4218W = z3;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z3) {
        if (this.f4217V != z3) {
            this.f4217V = z3;
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: u */
    public final void m3137u(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i3 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i4 = measuredWidth2 + i3;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i3, 0), Math.max(i4 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i3 += iMax;
            i4 -= iMax;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i4 - i3, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i3, textView.getTop(), i4, textView.getBottom());
    }
}

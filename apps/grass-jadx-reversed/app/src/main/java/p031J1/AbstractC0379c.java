package p031J1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p007B1.AbstractC0054n;
import p009C.AbstractC0139b;
import p025H1.C0278g;
import p025H1.C0281j;
import p029J.AbstractC0307B;
import p029J.AbstractC0311F;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p040M1.AbstractC0512a;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: J1.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0379c extends FrameLayout {

    /* JADX INFO: renamed from: m */
    public static final ViewOnTouchListenerC0378b f891m = new ViewOnTouchListenerC0378b(0);

    /* JADX INFO: renamed from: e */
    public final C0281j f892e;

    /* JADX INFO: renamed from: f */
    public int f893f;

    /* JADX INFO: renamed from: g */
    public final float f894g;

    /* JADX INFO: renamed from: h */
    public final float f895h;

    /* JADX INFO: renamed from: i */
    public final int f896i;

    /* JADX INFO: renamed from: j */
    public final int f897j;

    /* JADX INFO: renamed from: k */
    public ColorStateList f898k;

    /* JADX INFO: renamed from: l */
    public PorterDuff.Mode f899l;

    public AbstractC0379c(Context context, AttributeSet attributeSet) {
        Drawable drawable;
        super(AbstractC0512a.m1020a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, AbstractC1805a.f6247w);
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(6, 0);
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0313H.m646s(this, dimensionPixelSize);
        }
        this.f893f = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (typedArrayObtainStyledAttributes.hasValue(8) || typedArrayObtainStyledAttributes.hasValue(9)) {
            this.f892e = C0281j.m552b(context2, attributeSet, 0, 0).m4266a();
        }
        this.f894g = typedArrayObtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(AbstractC1920f.m4303d(context2, typedArrayObtainStyledAttributes, 4));
        setBackgroundTintMode(AbstractC0054n.m217g(typedArrayObtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.f895h = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        this.f896i = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.f897j = typedArrayObtainStyledAttributes.getDimensionPixelSize(7, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(f891m);
        setFocusable(true);
        if (getBackground() == null) {
            int iM4309l = AbstractC1920f.m4309l(AbstractC1920f.m4302c(this, R.attr.colorSurface), AbstractC1920f.m4302c(this, R.attr.colorOnSurface), getBackgroundOverlayColorAlpha());
            C0281j c0281j = this.f892e;
            if (c0281j != null) {
                int i3 = AbstractC0380d.f900a;
                C0278g c0278g = new C0278g(c0281j);
                c0278g.m547k(ColorStateList.valueOf(iM4309l));
                drawable = c0278g;
            } else {
                Resources resources = getResources();
                int i4 = AbstractC0380d.f900a;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                gradientDrawable.setColor(iM4309l);
                drawable = gradientDrawable;
            }
            ColorStateList colorStateList = this.f898k;
            if (colorStateList != null) {
                AbstractC0139b.m280h(drawable, colorStateList);
            }
            WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
            AbstractC0307B.m601q(this, drawable);
        }
    }

    private void setBaseTransientBottomBar(AbstractC0380d abstractC0380d) {
    }

    public float getActionTextColorAlpha() {
        return this.f895h;
    }

    public int getAnimationMode() {
        return this.f893f;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.f894g;
    }

    public int getMaxInlineActionWidth() {
        return this.f897j;
    }

    public int getMaxWidth() {
        return this.f896i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0311F.m627c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        int i5 = this.f896i;
        if (i5 <= 0 || getMeasuredWidth() <= i5) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), i4);
    }

    public void setAnimationMode(int i3) {
        this.f893f = i3;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.f898k != null) {
            drawable = drawable.mutate();
            AbstractC0139b.m280h(drawable, this.f898k);
            AbstractC0139b.m281i(drawable, this.f899l);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.f898k = colorStateList;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            AbstractC0139b.m280h(drawableMutate, colorStateList);
            AbstractC0139b.m281i(drawableMutate, this.f899l);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.f899l = mode;
        if (getBackground() != null) {
            Drawable drawableMutate = getBackground().mutate();
            AbstractC0139b.m281i(drawableMutate, mode);
            if (drawableMutate != getBackground()) {
                super.setBackgroundDrawable(drawableMutate);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : f891m);
        super.setOnClickListener(onClickListener);
    }
}

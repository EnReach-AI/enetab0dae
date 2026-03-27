package p034K1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.google.android.material.textfield.TextInputLayout;
import io.getgrass.www.R;
import java.util.Locale;
import p007B1.AbstractC0054n;
import p040M1.AbstractC0512a;
import p110k.C1603m;
import p110k.C1628y0;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: K1.x */
/* JADX INFO: loaded from: classes.dex */
public final class C0437x extends C1603m {

    /* JADX INFO: renamed from: i */
    public final C1628y0 f1054i;

    /* JADX INFO: renamed from: j */
    public final AccessibilityManager f1055j;

    /* JADX INFO: renamed from: k */
    public final Rect f1056k;

    /* JADX INFO: renamed from: l */
    public final int f1057l;

    /* JADX INFO: renamed from: m */
    public final float f1058m;

    /* JADX INFO: renamed from: n */
    public int f1059n;

    /* JADX INFO: renamed from: o */
    public ColorStateList f1060o;

    public C0437x(Context context, AttributeSet attributeSet) {
        super(AbstractC0512a.m1020a(context, attributeSet, R.attr.autoCompleteTextViewStyle, 0), attributeSet);
        this.f1056k = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayM216f = AbstractC0054n.m216f(context2, attributeSet, AbstractC1805a.f6232h, R.attr.autoCompleteTextViewStyle, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayM216f.hasValue(0) && typedArrayM216f.getInt(0, 0) == 0) {
            setKeyListener(null);
        }
        this.f1057l = typedArrayM216f.getResourceId(2, R.layout.mtrl_auto_complete_simple_item);
        this.f1058m = typedArrayM216f.getDimensionPixelOffset(1, R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        this.f1059n = typedArrayM216f.getColor(3, 0);
        this.f1060o = AbstractC1920f.m4303d(context2, typedArrayM216f, 4);
        this.f1055j = (AccessibilityManager) context2.getSystemService("accessibility");
        C1628y0 c1628y0 = new C1628y0(context2, null, R.attr.listPopupWindowStyle, 0);
        this.f1054i = c1628y0;
        c1628y0.f5768C = true;
        c1628y0.f5769D.setFocusable(true);
        c1628y0.f5784s = this;
        c1628y0.f5769D.setInputMethodMode(2);
        c1628y0.mo3598o(getAdapter());
        c1628y0.f5785t = new C0435v(0, this);
        if (typedArrayM216f.hasValue(5)) {
            setSimpleItems(typedArrayM216f.getResourceId(5, 0));
        }
        typedArrayM216f.recycle();
    }

    /* JADX INFO: renamed from: a */
    public static void m967a(C0437x c0437x, Object obj) {
        c0437x.setText(c0437x.convertSelectionToString(obj), false);
    }

    /* JADX INFO: renamed from: b */
    public final TextInputLayout m968b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.AutoCompleteTextView
    public final void dismissDropDown() {
        AccessibilityManager accessibilityManager = this.f1055j;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.dismissDropDown();
        } else {
            this.f1054i.dismiss();
        }
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutM968b = m968b();
        return (textInputLayoutM968b == null || !textInputLayoutM968b.f4474G) ? super.getHint() : textInputLayoutM968b.getHint();
    }

    public float getPopupElevation() {
        return this.f1058m;
    }

    public int getSimpleItemSelectedColor() {
        return this.f1059n;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f1060o;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutM968b = m968b();
        if (textInputLayoutM968b != null && textInputLayoutM968b.f4474G && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1054i.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutM968b = m968b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutM968b != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                C1628y0 c1628y0 = this.f1054i;
                int iMin = Math.min(adapter.getCount(), Math.max(0, !c1628y0.f5769D.isShowing() ? -1 : c1628y0.f5772g.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutM968b);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = c1628y0.f5769D.getBackground();
                if (background != null) {
                    Rect rect = this.f1056k;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutM968b.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        AccessibilityManager accessibilityManager = this.f1055j;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.onWindowFocusChanged(z3);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t3) {
        super.setAdapter(t3);
        this.f1054i.mo3598o(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        C1628y0 c1628y0 = this.f1054i;
        if (c1628y0 != null) {
            c1628y0.m3703l(drawable);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f1054i.f5786u = getOnItemSelectedListener();
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i3) {
        super.setRawInputType(i3);
        TextInputLayout textInputLayoutM968b = m968b();
        if (textInputLayoutM968b != null) {
            textInputLayoutM968b.m3215r();
        }
    }

    public void setSimpleItemSelectedColor(int i3) {
        this.f1059n = i3;
        if (getAdapter() instanceof C0436w) {
            ((C0436w) getAdapter()).m966a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f1060o = colorStateList;
        if (getAdapter() instanceof C0436w) {
            ((C0436w) getAdapter()).m966a();
        }
    }

    public void setSimpleItems(int i3) {
        setSimpleItems(getResources().getStringArray(i3));
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.f1055j;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f1054i.mo3476f();
        }
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new C0436w(this, getContext(), this.f1057l, strArr));
    }
}

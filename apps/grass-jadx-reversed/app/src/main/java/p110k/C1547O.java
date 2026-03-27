package p110k;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import p108j.ViewTreeObserverOnGlobalLayoutListenerC1470d;
import p125o0.AbstractC1800j;

/* JADX INFO: renamed from: k.O */
/* JADX INFO: loaded from: classes.dex */
public final class C1547O extends Spinner {

    /* JADX INFO: renamed from: m */
    public static final int[] f5523m = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: e */
    public final C1605n f5524e;

    /* JADX INFO: renamed from: f */
    public final Context f5525f;

    /* JADX INFO: renamed from: g */
    public final C1527E f5526g;

    /* JADX INFO: renamed from: h */
    public SpinnerAdapter f5527h;

    /* JADX INFO: renamed from: i */
    public final boolean f5528i;

    /* JADX INFO: renamed from: j */
    public final InterfaceC1545N f5529j;

    /* JADX INFO: renamed from: k */
    public int f5530k;

    /* JADX INFO: renamed from: l */
    public final Rect f5531l;

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1547O(android.content.Context r13, android.util.AttributeSet r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.C1547O.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* JADX INFO: renamed from: a */
    public final int m3602a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i3 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.f5531l;
        drawable.getPadding(rect);
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1605n c1605n = this.f5524e;
        if (c1605n != null) {
            c1605n.m3669a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        return interfaceC1545N != null ? interfaceC1545N.mo3590d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        return interfaceC1545N != null ? interfaceC1545N.mo3592g() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f5529j != null ? this.f5530k : super.getDropDownWidth();
    }

    public final InterfaceC1545N getInternalPopup() {
        return this.f5529j;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        return interfaceC1545N != null ? interfaceC1545N.mo3593h() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f5525f;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        return interfaceC1545N != null ? interfaceC1545N.mo3594i() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1605n c1605n = this.f5524e;
        if (c1605n != null) {
            return c1605n.m3670d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1605n c1605n = this.f5524e;
        if (c1605n != null) {
            return c1605n.m3671e();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC1545N interfaceC1545N = this.f5529j;
        if (interfaceC1545N == null || !interfaceC1545N.mo3589b()) {
            return;
        }
        interfaceC1545N.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.f5529j == null || View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m3602a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        C1543M c1543m = (C1543M) parcelable;
        super.onRestoreInstanceState(c1543m.getSuperState());
        if (!c1543m.f5519e || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1470d(2, this));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        C1543M c1543m = new C1543M(super.onSaveInstanceState());
        InterfaceC1545N interfaceC1545N = this.f5529j;
        c1543m.f5519e = interfaceC1545N != null && interfaceC1545N.mo3589b();
        return c1543m;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C1527E c1527e = this.f5526g;
        if (c1527e == null || !c1527e.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        if (interfaceC1545N == null) {
            return super.performClick();
        }
        if (interfaceC1545N.mo3589b()) {
            return true;
        }
        this.f5529j.mo3591e(AbstractC1531G.m3575b(this), AbstractC1531G.m3574a(this));
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1605n c1605n = this.f5524e;
        if (c1605n != null) {
            c1605n.m3673g();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        C1605n c1605n = this.f5524e;
        if (c1605n != null) {
            c1605n.m3674h(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i3) {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        if (interfaceC1545N == null) {
            super.setDropDownHorizontalOffset(i3);
        } else {
            interfaceC1545N.mo3599p(i3);
            interfaceC1545N.mo3588a(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i3) {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        if (interfaceC1545N != null) {
            interfaceC1545N.mo3597m(i3);
        } else {
            super.setDropDownVerticalOffset(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i3) {
        if (this.f5529j != null) {
            this.f5530k = i3;
        } else {
            super.setDropDownWidth(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        if (interfaceC1545N != null) {
            interfaceC1545N.mo3596l(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i3) {
        setPopupBackgroundDrawable(AbstractC1800j.m3991i(getPopupContext(), i3));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        InterfaceC1545N interfaceC1545N = this.f5529j;
        if (interfaceC1545N != null) {
            interfaceC1545N.mo3595k(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1605n c1605n = this.f5524e;
        if (c1605n != null) {
            c1605n.m3676j(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1605n c1605n = this.f5524e;
        if (c1605n != null) {
            c1605n.m3677k(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f5528i) {
            this.f5527h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        InterfaceC1545N interfaceC1545N = this.f5529j;
        if (interfaceC1545N != null) {
            Context context = this.f5525f;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            C1537J c1537j = new C1537J();
            c1537j.f5507e = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                c1537j.f5508f = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                AbstractC1533H.m3587a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            interfaceC1545N.mo3598o(c1537j);
        }
    }
}

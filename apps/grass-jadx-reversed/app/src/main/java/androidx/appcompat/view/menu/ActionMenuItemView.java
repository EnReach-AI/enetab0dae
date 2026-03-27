package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import p094f.AbstractC1343a;
import p108j.AbstractC1469c;
import p108j.C1468b;
import p108j.C1481o;
import p108j.InterfaceC1461A;
import p108j.InterfaceC1478l;
import p108j.MenuC1479m;
import p110k.AbstractC1587f1;
import p110k.C1564X;
import p110k.InterfaceC1597j;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends C1564X implements InterfaceC1461A, View.OnClickListener, InterfaceC1597j {

    /* JADX INFO: renamed from: k */
    public C1481o f2651k;

    /* JADX INFO: renamed from: l */
    public CharSequence f2652l;

    /* JADX INFO: renamed from: m */
    public Drawable f2653m;

    /* JADX INFO: renamed from: n */
    public InterfaceC1478l f2654n;

    /* JADX INFO: renamed from: o */
    public C1468b f2655o;

    /* JADX INFO: renamed from: p */
    public AbstractC1469c f2656p;

    /* JADX INFO: renamed from: q */
    public boolean f2657q;

    /* JADX INFO: renamed from: r */
    public boolean f2658r;

    /* JADX INFO: renamed from: s */
    public final int f2659s;

    /* JADX INFO: renamed from: t */
    public int f2660t;

    /* JADX INFO: renamed from: u */
    public final int f2661u;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.f2657q = m2222g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4779c, 0, 0);
        this.f2659s = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f2661u = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f2660t = -1;
        setSaveEnabled(false);
    }

    @Override // p110k.InterfaceC1597j
    /* JADX INFO: renamed from: a */
    public final boolean mo2219a() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // p110k.InterfaceC1597j
    /* JADX INFO: renamed from: b */
    public final boolean mo2220b() {
        return (TextUtils.isEmpty(getText()) ^ true) && this.f2651k.getIcon() == null;
    }

    @Override // p108j.InterfaceC1461A
    /* JADX INFO: renamed from: d */
    public final void mo2221d(C1481o c1481o) {
        this.f2651k = c1481o;
        setIcon(c1481o.getIcon());
        setTitle(c1481o.getTitleCondensed());
        setId(c1481o.f5374a);
        setVisibility(c1481o.isVisible() ? 0 : 8);
        setEnabled(c1481o.isEnabled());
        if (c1481o.hasSubMenu() && this.f2655o == null) {
            this.f2655o = new C1468b(this);
        }
    }

    /* JADX INFO: renamed from: g */
    public final boolean m2222g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        return i3 >= 480 || (i3 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // p108j.InterfaceC1461A
    public C1481o getItemData() {
        return this.f2651k;
    }

    /* JADX INFO: renamed from: h */
    public final void m2223h() {
        boolean z3 = true;
        boolean z4 = !TextUtils.isEmpty(this.f2652l);
        if (this.f2653m != null && ((this.f2651k.f5398y & 4) != 4 || (!this.f2657q && !this.f2658r))) {
            z3 = false;
        }
        boolean z5 = z4 & z3;
        setText(z5 ? this.f2652l : null);
        CharSequence charSequence = this.f2651k.f5390q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z5 ? null : this.f2651k.f5378e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f2651k.f5391r;
        if (TextUtils.isEmpty(charSequence2)) {
            AbstractC1587f1.m3650a(this, z5 ? null : this.f2651k.f5378e);
        } else {
            AbstractC1587f1.m3650a(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1478l interfaceC1478l = this.f2654n;
        if (interfaceC1478l != null) {
            interfaceC1478l.mo2225b(this.f2651k);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2657q = m2222g();
        m2223h();
    }

    @Override // p110k.C1564X, android.widget.TextView, android.view.View
    public final void onMeasure(int i3, int i4) {
        int i5;
        boolean z3 = !TextUtils.isEmpty(getText());
        if (z3 && (i5 = this.f2660t) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i3, i4);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int measuredWidth = getMeasuredWidth();
        int i6 = this.f2659s;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i6) : i6;
        if (mode != 1073741824 && i6 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i4);
        }
        if (z3 || this.f2653m == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2653m.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C1468b c1468b;
        if (this.f2651k.hasSubMenu() && (c1468b = this.f2655o) != null && c1468b.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z3) {
    }

    public void setChecked(boolean z3) {
    }

    public void setExpandedFormat(boolean z3) {
        if (this.f2658r != z3) {
            this.f2658r = z3;
            C1481o c1481o = this.f2651k;
            if (c1481o != null) {
                MenuC1479m menuC1479m = c1481o.f5387n;
                menuC1479m.f5354k = true;
                menuC1479m.m3518p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2653m = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i3 = this.f2661u;
            if (intrinsicWidth > i3) {
                intrinsicHeight = (int) (intrinsicHeight * (i3 / intrinsicWidth));
                intrinsicWidth = i3;
            }
            if (intrinsicHeight > i3) {
                intrinsicWidth = (int) (intrinsicWidth * (i3 / intrinsicHeight));
            } else {
                i3 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i3);
        }
        setCompoundDrawables(drawable, null, null, null);
        m2223h();
    }

    public void setItemInvoker(InterfaceC1478l interfaceC1478l) {
        this.f2654n = interfaceC1478l;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i3, int i4, int i5, int i6) {
        this.f2660t = i3;
        super.setPadding(i3, i4, i5, i6);
    }

    public void setPopupCallback(AbstractC1469c abstractC1469c) {
        this.f2656p = abstractC1469c;
    }

    public void setTitle(CharSequence charSequence) {
        this.f2652l = charSequence;
        m2223h();
    }
}

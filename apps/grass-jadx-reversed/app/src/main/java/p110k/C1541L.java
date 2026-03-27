package p110k;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import io.getgrass.www.R;
import p034K1.C0435v;
import p108j.ViewTreeObserverOnGlobalLayoutListenerC1470d;

/* JADX INFO: renamed from: k.L */
/* JADX INFO: loaded from: classes.dex */
public final class C1541L extends C1628y0 implements InterfaceC1545N {

    /* JADX INFO: renamed from: G */
    public CharSequence f5513G;

    /* JADX INFO: renamed from: H */
    public ListAdapter f5514H;

    /* JADX INFO: renamed from: I */
    public final Rect f5515I;

    /* JADX INFO: renamed from: J */
    public int f5516J;

    /* JADX INFO: renamed from: K */
    public final /* synthetic */ C1547O f5517K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1541L(C1547O c1547o, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.f5517K = c1547o;
        this.f5515I = new Rect();
        this.f5784s = c1547o;
        this.f5768C = true;
        this.f5769D.setFocusable(true);
        this.f5785t = new C0435v(1, this);
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: e */
    public final void mo3591e(int i3, int i4) {
        ViewTreeObserver viewTreeObserver;
        C1625x c1625x = this.f5769D;
        boolean zIsShowing = c1625x.isShowing();
        m3601s();
        this.f5769D.setInputMethodMode(2);
        mo3476f();
        C1604m0 c1604m0 = this.f5772g;
        c1604m0.setChoiceMode(1);
        AbstractC1531G.m3577d(c1604m0, i3);
        AbstractC1531G.m3576c(c1604m0, i4);
        C1547O c1547o = this.f5517K;
        int selectedItemPosition = c1547o.getSelectedItemPosition();
        C1604m0 c1604m02 = this.f5772g;
        if (c1625x.isShowing() && c1604m02 != null) {
            c1604m02.setListSelectionHidden(false);
            c1604m02.setSelection(selectedItemPosition);
            if (c1604m02.getChoiceMode() != 0) {
                c1604m02.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = c1547o.getViewTreeObserver()) == null) {
            return;
        }
        ViewTreeObserverOnGlobalLayoutListenerC1470d viewTreeObserverOnGlobalLayoutListenerC1470d = new ViewTreeObserverOnGlobalLayoutListenerC1470d(3, this);
        viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserverOnGlobalLayoutListenerC1470d);
        this.f5769D.setOnDismissListener(new C1539K(this, viewTreeObserverOnGlobalLayoutListenerC1470d));
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: i */
    public final CharSequence mo3594i() {
        return this.f5513G;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: k */
    public final void mo3595k(CharSequence charSequence) {
        this.f5513G = charSequence;
    }

    @Override // p110k.C1628y0, p110k.InterfaceC1545N
    /* JADX INFO: renamed from: o */
    public final void mo3598o(ListAdapter listAdapter) {
        super.mo3598o(listAdapter);
        this.f5514H = listAdapter;
    }

    @Override // p110k.InterfaceC1545N
    /* JADX INFO: renamed from: p */
    public final void mo3599p(int i3) {
        this.f5516J = i3;
    }

    /* JADX INFO: renamed from: s */
    public final void m3601s() {
        int i3;
        C1625x c1625x = this.f5769D;
        Drawable background = c1625x.getBackground();
        C1547O c1547o = this.f5517K;
        if (background != null) {
            background.getPadding(c1547o.f5531l);
            boolean zM3658a = AbstractC1596i1.m3658a(c1547o);
            Rect rect = c1547o.f5531l;
            i3 = zM3658a ? rect.right : -rect.left;
        } else {
            Rect rect2 = c1547o.f5531l;
            rect2.right = 0;
            rect2.left = 0;
            i3 = 0;
        }
        int paddingLeft = c1547o.getPaddingLeft();
        int paddingRight = c1547o.getPaddingRight();
        int width = c1547o.getWidth();
        int i4 = c1547o.f5530k;
        if (i4 == -2) {
            int iM3602a = c1547o.m3602a((SpinnerAdapter) this.f5514H, c1625x.getBackground());
            int i5 = c1547o.getContext().getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = c1547o.f5531l;
            int i6 = (i5 - rect3.left) - rect3.right;
            if (iM3602a > i6) {
                iM3602a = i6;
            }
            m3705r(Math.max(iM3602a, (width - paddingLeft) - paddingRight));
        } else if (i4 == -1) {
            m3705r((width - paddingLeft) - paddingRight);
        } else {
            m3705r(i4);
        }
        this.f5775j = AbstractC1596i1.m3658a(c1547o) ? (((width - paddingRight) - this.f5774i) - this.f5516J) + i3 : paddingLeft + this.f5516J + i3;
    }
}

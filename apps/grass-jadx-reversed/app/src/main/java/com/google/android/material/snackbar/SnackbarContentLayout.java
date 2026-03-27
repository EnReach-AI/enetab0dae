package com.google.android.material.snackbar;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p125o0.AbstractC1794d;
import p130p1.AbstractC1824a;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* JADX INFO: renamed from: e */
    public TextView f4460e;

    /* JADX INFO: renamed from: f */
    public Button f4461f;

    /* JADX INFO: renamed from: g */
    public int f4462g;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AbstractC1794d.m3955m(context, R.attr.motionEasingEmphasizedInterpolator, AbstractC1824a.f6321b);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3197a(int i3, int i4, int i5) {
        boolean z3;
        if (i3 != getOrientation()) {
            setOrientation(i3);
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f4460e.getPaddingTop() == i4 && this.f4460e.getPaddingBottom() == i5) {
            return z3;
        }
        TextView textView = this.f4460e;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0308C.m610g(textView)) {
            AbstractC0308C.m614k(textView, AbstractC0308C.m609f(textView), i4, AbstractC0308C.m608e(textView), i5);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i4, textView.getPaddingRight(), i5);
        return true;
    }

    public Button getActionView() {
        return this.f4461f;
    }

    public TextView getMessageView() {
        return this.f4460e;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f4460e = (TextView) findViewById(R.id.snackbar_text);
        this.f4461f = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.f4460e.getLayout();
        boolean z3 = layout != null && layout.getLineCount() > 1;
        if (!z3 || this.f4462g <= 0 || this.f4461f.getMeasuredWidth() <= this.f4462g) {
            if (!z3) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!m3197a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!m3197a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i3, i4);
    }

    public void setMaxInlineActionWidth(int i3) {
        this.f4462g = i3;
    }
}

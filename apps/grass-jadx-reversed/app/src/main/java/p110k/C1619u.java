package p110k;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import p036L0.C0444d;
import p039M0.AbstractC0493h0;
import p055S.C0629g;
import p094f.AbstractC1343a;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: k.u */
/* JADX INFO: loaded from: classes.dex */
public final class C1619u {

    /* JADX INFO: renamed from: a */
    public final TextView f5747a;

    /* JADX INFO: renamed from: b */
    public final C0444d f5748b;

    public C1619u(TextView textView) {
        this.f5747a = textView;
        C0444d c0444d = new C0444d();
        AbstractC0493h0.m1010c("textView cannot be null", textView);
        c0444d.f1085e = new C0629g(textView);
        this.f5748b = c0444d;
    }

    /* JADX INFO: renamed from: a */
    public final void m3690a(AttributeSet attributeSet, int i3) {
        TypedArray typedArrayObtainStyledAttributes = this.f5747a.getContext().obtainStyledAttributes(attributeSet, AbstractC1343a.f4785i, i3, 0);
        try {
            boolean z3 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            m3692c(z3);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3691b(boolean z3) {
        ((AbstractC1946e) this.f5748b.f1085e).mo1443j(z3);
    }

    /* JADX INFO: renamed from: c */
    public final void m3692c(boolean z3) {
        ((AbstractC1946e) this.f5748b.f1085e).mo1444k(z3);
    }
}

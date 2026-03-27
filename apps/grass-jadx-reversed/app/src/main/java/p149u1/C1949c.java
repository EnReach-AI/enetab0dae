package p149u1;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p009C.AbstractC0139b;
import p025H1.C0277f;
import p025H1.C0278g;
import p025H1.C0281j;
import p025H1.InterfaceC0292u;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: u1.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1949c {

    /* JADX INFO: renamed from: a */
    public final MaterialButton f6944a;

    /* JADX INFO: renamed from: b */
    public C0281j f6945b;

    /* JADX INFO: renamed from: c */
    public int f6946c;

    /* JADX INFO: renamed from: d */
    public int f6947d;

    /* JADX INFO: renamed from: e */
    public int f6948e;

    /* JADX INFO: renamed from: f */
    public int f6949f;

    /* JADX INFO: renamed from: g */
    public int f6950g;

    /* JADX INFO: renamed from: h */
    public int f6951h;

    /* JADX INFO: renamed from: i */
    public PorterDuff.Mode f6952i;

    /* JADX INFO: renamed from: j */
    public ColorStateList f6953j;

    /* JADX INFO: renamed from: k */
    public ColorStateList f6954k;

    /* JADX INFO: renamed from: l */
    public ColorStateList f6955l;

    /* JADX INFO: renamed from: m */
    public C0278g f6956m;

    /* JADX INFO: renamed from: q */
    public boolean f6960q;

    /* JADX INFO: renamed from: s */
    public RippleDrawable f6962s;

    /* JADX INFO: renamed from: t */
    public int f6963t;

    /* JADX INFO: renamed from: n */
    public boolean f6957n = false;

    /* JADX INFO: renamed from: o */
    public boolean f6958o = false;

    /* JADX INFO: renamed from: p */
    public boolean f6959p = false;

    /* JADX INFO: renamed from: r */
    public boolean f6961r = true;

    public C1949c(MaterialButton materialButton, C0281j c0281j) {
        this.f6944a = materialButton;
        this.f6945b = c0281j;
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC0292u m4352a() {
        RippleDrawable rippleDrawable = this.f6962s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f6962s.getNumberOfLayers() > 2 ? (InterfaceC0292u) this.f6962s.getDrawable(2) : (InterfaceC0292u) this.f6962s.getDrawable(1);
    }

    /* JADX INFO: renamed from: b */
    public final C0278g m4353b(boolean z3) {
        RippleDrawable rippleDrawable = this.f6962s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (C0278g) ((LayerDrawable) ((InsetDrawable) this.f6962s.getDrawable(0)).getDrawable()).getDrawable(!z3 ? 1 : 0);
    }

    /* JADX INFO: renamed from: c */
    public final void m4354c(C0281j c0281j) {
        this.f6945b = c0281j;
        if (m4353b(false) != null) {
            m4353b(false).setShapeAppearanceModel(c0281j);
        }
        if (m4353b(true) != null) {
            m4353b(true).setShapeAppearanceModel(c0281j);
        }
        if (m4352a() != null) {
            m4352a().setShapeAppearanceModel(c0281j);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m4355d(int i3, int i4) {
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        MaterialButton materialButton = this.f6944a;
        int iM609f = AbstractC0308C.m609f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int iM608e = AbstractC0308C.m608e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i5 = this.f6948e;
        int i6 = this.f6949f;
        this.f6949f = i4;
        this.f6948e = i3;
        if (!this.f6958o) {
            m4356e();
        }
        AbstractC0308C.m614k(materialButton, iM609f, (paddingTop + i3) - i5, iM608e, (paddingBottom + i4) - i6);
    }

    /* JADX INFO: renamed from: e */
    public final void m4356e() {
        C0278g c0278g = new C0278g(this.f6945b);
        MaterialButton materialButton = this.f6944a;
        c0278g.m545i(materialButton.getContext());
        AbstractC0139b.m280h(c0278g, this.f6953j);
        PorterDuff.Mode mode = this.f6952i;
        if (mode != null) {
            AbstractC0139b.m281i(c0278g, mode);
        }
        float f3 = this.f6951h;
        ColorStateList colorStateList = this.f6954k;
        c0278g.f719e.f707k = f3;
        c0278g.invalidateSelf();
        C0277f c0277f = c0278g.f719e;
        if (c0277f.f700d != colorStateList) {
            c0277f.f700d = colorStateList;
            c0278g.onStateChange(c0278g.getState());
        }
        C0278g c0278g2 = new C0278g(this.f6945b);
        c0278g2.setTint(0);
        float f4 = this.f6951h;
        int iM4302c = this.f6957n ? AbstractC1920f.m4302c(materialButton, R.attr.colorSurface) : 0;
        c0278g2.f719e.f707k = f4;
        c0278g2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iM4302c);
        C0277f c0277f2 = c0278g2.f719e;
        if (c0277f2.f700d != colorStateListValueOf) {
            c0277f2.f700d = colorStateListValueOf;
            c0278g2.onStateChange(c0278g2.getState());
        }
        C0278g c0278g3 = new C0278g(this.f6945b);
        this.f6956m = c0278g3;
        AbstractC0139b.m279g(c0278g3, -1);
        ColorStateList colorStateListValueOf2 = this.f6955l;
        if (colorStateListValueOf2 == null) {
            colorStateListValueOf2 = ColorStateList.valueOf(0);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateListValueOf2, new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{c0278g2, c0278g}), this.f6946c, this.f6948e, this.f6947d, this.f6949f), this.f6956m);
        this.f6962s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        C0278g c0278gM4353b = m4353b(false);
        if (c0278gM4353b != null) {
            c0278gM4353b.m546j(this.f6963t);
            c0278gM4353b.setState(materialButton.getDrawableState());
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m4357f() {
        C0278g c0278gM4353b = m4353b(false);
        C0278g c0278gM4353b2 = m4353b(true);
        if (c0278gM4353b != null) {
            float f3 = this.f6951h;
            ColorStateList colorStateList = this.f6954k;
            c0278gM4353b.f719e.f707k = f3;
            c0278gM4353b.invalidateSelf();
            C0277f c0277f = c0278gM4353b.f719e;
            if (c0277f.f700d != colorStateList) {
                c0277f.f700d = colorStateList;
                c0278gM4353b.onStateChange(c0278gM4353b.getState());
            }
            if (c0278gM4353b2 != null) {
                float f4 = this.f6951h;
                int iM4302c = this.f6957n ? AbstractC1920f.m4302c(this.f6944a, R.attr.colorSurface) : 0;
                c0278gM4353b2.f719e.f707k = f4;
                c0278gM4353b2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iM4302c);
                C0277f c0277f2 = c0278gM4353b2.f719e;
                if (c0277f2.f700d != colorStateListValueOf) {
                    c0277f2.f700d = colorStateListValueOf;
                    c0278gM4353b2.onStateChange(c0278gM4353b2.getState());
                }
            }
        }
    }
}

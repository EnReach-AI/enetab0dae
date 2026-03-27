package p073Z;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: Z.v */
/* JADX INFO: loaded from: classes.dex */
public final class C0810v extends AbstractC0811w {

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ int f2408d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0810v(AbstractC0763I abstractC0763I, int i3) {
        super(abstractC0763I);
        this.f2408d = i3;
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: b */
    public final int mo2113b(View view) {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0764J c0764j = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                return view.getRight() + ((C0764J) view.getLayoutParams()).f2155b.right + ((ViewGroup.MarginLayoutParams) c0764j).rightMargin;
            default:
                C0764J c0764j2 = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                return view.getBottom() + ((C0764J) view.getLayoutParams()).f2155b.bottom + ((ViewGroup.MarginLayoutParams) c0764j2).bottomMargin;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: c */
    public final int mo2114c(View view) {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0764J c0764j = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                Rect rect = ((C0764J) view.getLayoutParams()).f2155b;
                return view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) c0764j).leftMargin + ((ViewGroup.MarginLayoutParams) c0764j).rightMargin;
            default:
                C0764J c0764j2 = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                Rect rect2 = ((C0764J) view.getLayoutParams()).f2155b;
                return view.getMeasuredHeight() + rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) c0764j2).topMargin + ((ViewGroup.MarginLayoutParams) c0764j2).bottomMargin;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: d */
    public final int mo2115d(View view) {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0764J c0764j = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                Rect rect = ((C0764J) view.getLayoutParams()).f2155b;
                return view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) c0764j).topMargin + ((ViewGroup.MarginLayoutParams) c0764j).bottomMargin;
            default:
                C0764J c0764j2 = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                Rect rect2 = ((C0764J) view.getLayoutParams()).f2155b;
                return view.getMeasuredWidth() + rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) c0764j2).leftMargin + ((ViewGroup.MarginLayoutParams) c0764j2).rightMargin;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: e */
    public final int mo2116e(View view) {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0764J c0764j = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                return (view.getLeft() - ((C0764J) view.getLayoutParams()).f2155b.left) - ((ViewGroup.MarginLayoutParams) c0764j).leftMargin;
            default:
                C0764J c0764j2 = (C0764J) view.getLayoutParams();
                ((AbstractC0763I) this.f2410b).getClass();
                return (view.getTop() - ((C0764J) view.getLayoutParams()).f2155b.top) - ((ViewGroup.MarginLayoutParams) c0764j2).topMargin;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: f */
    public final int mo2117f() {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((AbstractC0763I) this.f2410b).f2152n;
            default:
                return ((AbstractC0763I) this.f2410b).f2153o;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: g */
    public final int mo2118g() {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0763I abstractC0763I = (AbstractC0763I) this.f2410b;
                return abstractC0763I.f2152n - abstractC0763I.m1966B();
            default:
                AbstractC0763I abstractC0763I2 = (AbstractC0763I) this.f2410b;
                return abstractC0763I2.f2153o - abstractC0763I2.m2029z();
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: h */
    public final int mo2119h() {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((AbstractC0763I) this.f2410b).m1966B();
            default:
                return ((AbstractC0763I) this.f2410b).m2029z();
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: i */
    public final int mo2120i() {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((AbstractC0763I) this.f2410b).f2150l;
            default:
                return ((AbstractC0763I) this.f2410b).f2151m;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: j */
    public final int mo2121j() {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((AbstractC0763I) this.f2410b).f2151m;
            default:
                return ((AbstractC0763I) this.f2410b).f2150l;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: k */
    public final int mo2122k() {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((AbstractC0763I) this.f2410b).m1965A();
            default:
                return ((AbstractC0763I) this.f2410b).m1967C();
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: l */
    public final int mo2123l() {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0763I abstractC0763I = (AbstractC0763I) this.f2410b;
                return (abstractC0763I.f2152n - abstractC0763I.m1965A()) - abstractC0763I.m1966B();
            default:
                AbstractC0763I abstractC0763I2 = (AbstractC0763I) this.f2410b;
                return (abstractC0763I2.f2153o - abstractC0763I2.m1967C()) - abstractC0763I2.m2029z();
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: n */
    public final int mo2124n(View view) {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0763I abstractC0763I = (AbstractC0763I) this.f2410b;
                Rect rect = (Rect) this.f2411c;
                abstractC0763I.m1969G(view, rect);
                return rect.right;
            default:
                AbstractC0763I abstractC0763I2 = (AbstractC0763I) this.f2410b;
                Rect rect2 = (Rect) this.f2411c;
                abstractC0763I2.m1969G(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: o */
    public final int mo2125o(View view) {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0763I abstractC0763I = (AbstractC0763I) this.f2410b;
                Rect rect = (Rect) this.f2411c;
                abstractC0763I.m1969G(view, rect);
                return rect.left;
            default:
                AbstractC0763I abstractC0763I2 = (AbstractC0763I) this.f2410b;
                Rect rect2 = (Rect) this.f2411c;
                abstractC0763I2.m1969G(view, rect2);
                return rect2.top;
        }
    }

    @Override // p073Z.AbstractC0811w
    /* JADX INFO: renamed from: p */
    public final void mo2126p(int i3) {
        switch (this.f2408d) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                ((AbstractC0763I) this.f2410b).mo1971K(i3);
                break;
            default:
                ((AbstractC0763I) this.f2410b).mo1972L(i3);
                break;
        }
    }
}

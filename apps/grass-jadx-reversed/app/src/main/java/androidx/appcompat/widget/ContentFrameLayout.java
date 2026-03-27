package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import p029J.C0330Z;
import p098g.C1374m;
import p098g.LayoutInflaterFactory2C1382u;
import p108j.MenuC1479m;
import p110k.C1582e;
import p110k.C1584e1;
import p110k.C1594i;
import p110k.InterfaceC1580d0;
import p110k.InterfaceC1583e0;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: e */
    public TypedValue f2757e;

    /* JADX INFO: renamed from: f */
    public TypedValue f2758f;

    /* JADX INFO: renamed from: g */
    public TypedValue f2759g;

    /* JADX INFO: renamed from: h */
    public TypedValue f2760h;

    /* JADX INFO: renamed from: i */
    public TypedValue f2761i;

    /* JADX INFO: renamed from: j */
    public TypedValue f2762j;

    /* JADX INFO: renamed from: k */
    public final Rect f2763k;

    /* JADX INFO: renamed from: l */
    public InterfaceC1580d0 f2764l;

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2763k = new Rect();
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f2761i == null) {
            this.f2761i = new TypedValue();
        }
        return this.f2761i;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f2762j == null) {
            this.f2762j = new TypedValue();
        }
        return this.f2762j;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f2759g == null) {
            this.f2759g = new TypedValue();
        }
        return this.f2759g;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f2760h == null) {
            this.f2760h = new TypedValue();
        }
        return this.f2760h;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f2757e == null) {
            this.f2757e = new TypedValue();
        }
        return this.f2757e;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f2758f == null) {
            this.f2758f = new TypedValue();
        }
        return this.f2758f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC1580d0 interfaceC1580d0 = this.f2764l;
        if (interfaceC1580d0 != null) {
            interfaceC1580d0.getClass();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        C1594i c1594i;
        super.onDetachedFromWindow();
        InterfaceC1580d0 interfaceC1580d0 = this.f2764l;
        if (interfaceC1580d0 != null) {
            LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = ((C1374m) interfaceC1580d0).f4920e;
            InterfaceC1583e0 interfaceC1583e0 = layoutInflaterFactory2C1382u.f4997v;
            if (interfaceC1583e0 != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1583e0;
                actionBarOverlayLayout.m2239k();
                ActionMenuView actionMenuView = ((C1584e1) actionBarOverlayLayout.f2720i).f5618a.f2830e;
                if (actionMenuView != null && (c1594i = actionMenuView.f2747x) != null) {
                    c1594i.m3655f();
                    C1582e c1582e = c1594i.f5660x;
                    if (c1582e != null && c1582e.m3539b()) {
                        c1582e.f5421j.dismiss();
                    }
                }
            }
            if (layoutInflaterFactory2C1382u.f4952A != null) {
                layoutInflaterFactory2C1382u.f4991p.getDecorView().removeCallbacks(layoutInflaterFactory2C1382u.f4953B);
                if (layoutInflaterFactory2C1382u.f4952A.isShowing()) {
                    try {
                        layoutInflaterFactory2C1382u.f4952A.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                layoutInflaterFactory2C1382u.f4952A = null;
            }
            C0330Z c0330z = layoutInflaterFactory2C1382u.f4954C;
            if (c0330z != null) {
                c0330z.m716b();
            }
            MenuC1479m menuC1479m = layoutInflaterFactory2C1382u.m3390z(0).f4939h;
            if (menuC1479m != null) {
                menuC1479m.m3513c(true);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(InterfaceC1580d0 interfaceC1580d0) {
        this.f2764l = interfaceC1580d0;
    }
}

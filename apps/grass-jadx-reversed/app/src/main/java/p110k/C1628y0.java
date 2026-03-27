package p110k;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p041N.AbstractC0525m;
import p041N.AbstractC0526n;
import p044O.C0565b;
import p094f.AbstractC1343a;
import p108j.InterfaceC1464D;
import p125o0.AbstractC1800j;

/* JADX INFO: renamed from: k.y0 */
/* JADX INFO: loaded from: classes.dex */
public class C1628y0 implements InterfaceC1464D {

    /* JADX INFO: renamed from: E */
    public static final Method f5764E;

    /* JADX INFO: renamed from: F */
    public static final Method f5765F;

    /* JADX INFO: renamed from: B */
    public Rect f5767B;

    /* JADX INFO: renamed from: C */
    public boolean f5768C;

    /* JADX INFO: renamed from: D */
    public final C1625x f5769D;

    /* JADX INFO: renamed from: e */
    public final Context f5770e;

    /* JADX INFO: renamed from: f */
    public ListAdapter f5771f;

    /* JADX INFO: renamed from: g */
    public C1604m0 f5772g;

    /* JADX INFO: renamed from: j */
    public int f5775j;

    /* JADX INFO: renamed from: k */
    public int f5776k;

    /* JADX INFO: renamed from: m */
    public boolean f5778m;

    /* JADX INFO: renamed from: n */
    public boolean f5779n;

    /* JADX INFO: renamed from: o */
    public boolean f5780o;

    /* JADX INFO: renamed from: r */
    public C0565b f5783r;

    /* JADX INFO: renamed from: s */
    public View f5784s;

    /* JADX INFO: renamed from: t */
    public AdapterView.OnItemClickListener f5785t;

    /* JADX INFO: renamed from: u */
    public AdapterView.OnItemSelectedListener f5786u;

    /* JADX INFO: renamed from: z */
    public final Handler f5791z;

    /* JADX INFO: renamed from: h */
    public final int f5773h = -2;

    /* JADX INFO: renamed from: i */
    public int f5774i = -2;

    /* JADX INFO: renamed from: l */
    public final int f5777l = 1002;

    /* JADX INFO: renamed from: p */
    public int f5781p = 0;

    /* JADX INFO: renamed from: q */
    public final int f5782q = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: v */
    public final RunnableC1622v0 f5787v = new RunnableC1622v0(this, 1);

    /* JADX INFO: renamed from: w */
    public final ViewOnTouchListenerC1626x0 f5788w = new ViewOnTouchListenerC1626x0(this);

    /* JADX INFO: renamed from: x */
    public final C1624w0 f5789x = new C1624w0(this);

    /* JADX INFO: renamed from: y */
    public final RunnableC1622v0 f5790y = new RunnableC1622v0(this, 0);

    /* JADX INFO: renamed from: A */
    public final Rect f5766A = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f5764E = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f5765F = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public C1628y0(Context context, AttributeSet attributeSet, int i3, int i4) {
        int resourceId;
        this.f5770e = context;
        this.f5791z = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4791o, i3, i4);
        this.f5775j = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.f5776k = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f5778m = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        C1625x c1625x = new C1625x(context, attributeSet, i3, i4);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4795s, i3, i4);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            AbstractC0526n.m1046c(c1625x, typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        c1625x.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : AbstractC1800j.m3991i(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.f5769D = c1625x;
        c1625x.setInputMethodMode(1);
    }

    /* JADX INFO: renamed from: a */
    public final void m3699a(int i3) {
        this.f5775j = i3;
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: b */
    public final boolean mo3475b() {
        return this.f5769D.isShowing();
    }

    /* JADX INFO: renamed from: d */
    public final int m3700d() {
        return this.f5775j;
    }

    @Override // p108j.InterfaceC1464D
    public final void dismiss() {
        C1625x c1625x = this.f5769D;
        c1625x.dismiss();
        c1625x.setContentView(null);
        this.f5772g = null;
        this.f5791z.removeCallbacks(this.f5787v);
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: f */
    public final void mo3476f() {
        int i3;
        int paddingBottom;
        C1604m0 c1604m0;
        C1604m0 c1604m02 = this.f5772g;
        C1625x c1625x = this.f5769D;
        Context context = this.f5770e;
        if (c1604m02 == null) {
            C1604m0 c1604m0Mo3572q = mo3572q(context, !this.f5768C);
            this.f5772g = c1604m0Mo3572q;
            c1604m0Mo3572q.setAdapter(this.f5771f);
            this.f5772g.setOnItemClickListener(this.f5785t);
            this.f5772g.setFocusable(true);
            this.f5772g.setFocusableInTouchMode(true);
            this.f5772g.setOnItemSelectedListener(new C1616s0(0, this));
            this.f5772g.setOnScrollListener(this.f5789x);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f5786u;
            if (onItemSelectedListener != null) {
                this.f5772g.setOnItemSelectedListener(onItemSelectedListener);
            }
            c1625x.setContentView(this.f5772g);
        }
        Drawable background = c1625x.getBackground();
        Rect rect = this.f5766A;
        if (background != null) {
            background.getPadding(rect);
            int i4 = rect.top;
            i3 = rect.bottom + i4;
            if (!this.f5778m) {
                this.f5776k = -i4;
            }
        } else {
            rect.setEmpty();
            i3 = 0;
        }
        int iM3689a = AbstractC1618t0.m3689a(c1625x, this.f5784s, this.f5776k, c1625x.getInputMethodMode() == 2);
        int i5 = this.f5773h;
        if (i5 == -1) {
            paddingBottom = iM3689a + i3;
        } else {
            int i6 = this.f5774i;
            int iM3665a = this.f5772g.m3665a(i6 != -2 ? i6 != -1 ? View.MeasureSpec.makeMeasureSpec(i6, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iM3689a);
            paddingBottom = iM3665a + (iM3665a > 0 ? this.f5772g.getPaddingBottom() + this.f5772g.getPaddingTop() + i3 : 0);
        }
        boolean z3 = this.f5769D.getInputMethodMode() == 2;
        AbstractC0526n.m1047d(c1625x, this.f5777l);
        if (c1625x.isShowing()) {
            View view = this.f5784s;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if (AbstractC0310E.m619b(view)) {
                int width = this.f5774i;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.f5784s.getWidth();
                }
                if (i5 == -1) {
                    i5 = z3 ? paddingBottom : -1;
                    if (z3) {
                        c1625x.setWidth(this.f5774i == -1 ? -1 : 0);
                        c1625x.setHeight(0);
                    } else {
                        c1625x.setWidth(this.f5774i == -1 ? -1 : 0);
                        c1625x.setHeight(-1);
                    }
                } else if (i5 == -2) {
                    i5 = paddingBottom;
                }
                c1625x.setOutsideTouchable(true);
                c1625x.update(this.f5784s, this.f5775j, this.f5776k, width < 0 ? -1 : width, i5 < 0 ? -1 : i5);
                return;
            }
            return;
        }
        int width2 = this.f5774i;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.f5784s.getWidth();
        }
        if (i5 == -1) {
            i5 = -1;
        } else if (i5 == -2) {
            i5 = paddingBottom;
        }
        c1625x.setWidth(width2);
        c1625x.setHeight(i5);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f5764E;
            if (method != null) {
                try {
                    method.invoke(c1625x, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            AbstractC1620u0.m3694b(c1625x, true);
        }
        c1625x.setOutsideTouchable(true);
        c1625x.setTouchInterceptor(this.f5788w);
        if (this.f5780o) {
            AbstractC0526n.m1046c(c1625x, this.f5779n);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f5765F;
            if (method2 != null) {
                try {
                    method2.invoke(c1625x, this.f5767B);
                } catch (Exception e3) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e3);
                }
            }
        } else {
            AbstractC1620u0.m3693a(c1625x, this.f5767B);
        }
        AbstractC0525m.m1043a(c1625x, this.f5784s, this.f5775j, this.f5776k, this.f5781p);
        this.f5772g.setSelection(-1);
        if ((!this.f5768C || this.f5772g.isInTouchMode()) && (c1604m0 = this.f5772g) != null) {
            c1604m0.setListSelectionHidden(true);
            c1604m0.requestLayout();
        }
        if (this.f5768C) {
            return;
        }
        this.f5791z.post(this.f5790y);
    }

    /* JADX INFO: renamed from: g */
    public final int m3701g() {
        if (this.f5778m) {
            return this.f5776k;
        }
        return 0;
    }

    /* JADX INFO: renamed from: h */
    public final Drawable m3702h() {
        return this.f5769D.getBackground();
    }

    @Override // p108j.InterfaceC1464D
    /* JADX INFO: renamed from: j */
    public final C1604m0 mo3477j() {
        return this.f5772g;
    }

    /* JADX INFO: renamed from: l */
    public final void m3703l(Drawable drawable) {
        this.f5769D.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: renamed from: m */
    public final void m3704m(int i3) {
        this.f5776k = i3;
        this.f5778m = true;
    }

    /* JADX INFO: renamed from: o */
    public void mo3598o(ListAdapter listAdapter) {
        C0565b c0565b = this.f5783r;
        if (c0565b == null) {
            this.f5783r = new C0565b(1, this);
        } else {
            ListAdapter listAdapter2 = this.f5771f;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(c0565b);
            }
        }
        this.f5771f = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f5783r);
        }
        C1604m0 c1604m0 = this.f5772g;
        if (c1604m0 != null) {
            c1604m0.setAdapter(this.f5771f);
        }
    }

    /* JADX INFO: renamed from: q */
    public C1604m0 mo3572q(Context context, boolean z3) {
        return new C1604m0(context, z3);
    }

    /* JADX INFO: renamed from: r */
    public final void m3705r(int i3) {
        Drawable background = this.f5769D.getBackground();
        if (background == null) {
            this.f5774i = i3;
            return;
        }
        Rect rect = this.f5766A;
        background.getPadding(rect);
        this.f5774i = rect.left + rect.right + i3;
    }
}

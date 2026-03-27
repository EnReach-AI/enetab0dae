package p098g;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.media.session.AbstractC0864a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p029J.AbstractC0310E;
import p029J.AbstractC0311F;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.AbstractC0329Y;
import p029J.C0327W;
import p029J.C0330Z;
import p036L0.C0444d;
import p094f.AbstractC1343a;
import p105i.C1443k;
import p105i.C1444l;
import p105i.InterfaceC1433a;
import p110k.C1584e1;
import p110k.InterfaceC1576c;
import p110k.InterfaceC1586f0;

/* JADX INFO: renamed from: g.G */
/* JADX INFO: loaded from: classes.dex */
public final class C1361G extends AbstractC0864a implements InterfaceC1576c {

    /* JADX INFO: renamed from: y */
    public static final AccelerateInterpolator f4840y = new AccelerateInterpolator();

    /* JADX INFO: renamed from: z */
    public static final DecelerateInterpolator f4841z = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a */
    public Context f4842a;

    /* JADX INFO: renamed from: b */
    public Context f4843b;

    /* JADX INFO: renamed from: c */
    public ActionBarOverlayLayout f4844c;

    /* JADX INFO: renamed from: d */
    public ActionBarContainer f4845d;

    /* JADX INFO: renamed from: e */
    public InterfaceC1586f0 f4846e;

    /* JADX INFO: renamed from: f */
    public ActionBarContextView f4847f;

    /* JADX INFO: renamed from: g */
    public final View f4848g;

    /* JADX INFO: renamed from: h */
    public boolean f4849h;

    /* JADX INFO: renamed from: i */
    public C1360F f4850i;

    /* JADX INFO: renamed from: j */
    public C1360F f4851j;

    /* JADX INFO: renamed from: k */
    public InterfaceC1433a f4852k;

    /* JADX INFO: renamed from: l */
    public boolean f4853l;

    /* JADX INFO: renamed from: m */
    public final ArrayList f4854m;

    /* JADX INFO: renamed from: n */
    public int f4855n;

    /* JADX INFO: renamed from: o */
    public boolean f4856o;

    /* JADX INFO: renamed from: p */
    public boolean f4857p;

    /* JADX INFO: renamed from: q */
    public boolean f4858q;

    /* JADX INFO: renamed from: r */
    public boolean f4859r;

    /* JADX INFO: renamed from: s */
    public C1444l f4860s;

    /* JADX INFO: renamed from: t */
    public boolean f4861t;

    /* JADX INFO: renamed from: u */
    public boolean f4862u;

    /* JADX INFO: renamed from: v */
    public final C1359E f4863v;

    /* JADX INFO: renamed from: w */
    public final C1359E f4864w;

    /* JADX INFO: renamed from: x */
    public final C0444d f4865x;

    public C1361G(Activity activity, boolean z3) {
        new ArrayList();
        this.f4854m = new ArrayList();
        this.f4855n = 0;
        this.f4856o = true;
        this.f4859r = true;
        this.f4863v = new C1359E(this, 0);
        this.f4864w = new C1359E(this, 1);
        this.f4865x = new C0444d(this);
        View decorView = activity.getWindow().getDecorView();
        m3328l(decorView);
        if (z3) {
            return;
        }
        this.f4848g = decorView.findViewById(R.id.content);
    }

    /* JADX INFO: renamed from: j */
    public final void m3326j(boolean z3) {
        C0330Z c0330zM2234i;
        C0330Z c0330zM2234i2;
        if (z3) {
            if (!this.f4858q) {
                this.f4858q = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f4844c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                m3331o(false);
            }
        } else if (this.f4858q) {
            this.f4858q = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4844c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            m3331o(false);
        }
        ActionBarContainer actionBarContainer = this.f4845d;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (!AbstractC0310E.m620c(actionBarContainer)) {
            if (z3) {
                ((C1584e1) this.f4846e).f5618a.setVisibility(4);
                this.f4847f.setVisibility(0);
                return;
            } else {
                ((C1584e1) this.f4846e).f5618a.setVisibility(0);
                this.f4847f.setVisibility(8);
                return;
            }
        }
        if (z3) {
            C1584e1 c1584e1 = (C1584e1) this.f4846e;
            c0330zM2234i = AbstractC0323S.m691a(c1584e1.f5618a);
            c0330zM2234i.m715a(0.0f);
            c0330zM2234i.m717c(100L);
            c0330zM2234i.m718d(new C1443k(c1584e1, 4));
            c0330zM2234i2 = this.f4847f.m2234i(0, 200L);
        } else {
            C1584e1 c1584e12 = (C1584e1) this.f4846e;
            C0330Z c0330zM691a = AbstractC0323S.m691a(c1584e12.f5618a);
            c0330zM691a.m715a(1.0f);
            c0330zM691a.m717c(200L);
            c0330zM691a.m718d(new C1443k(c1584e12, 0));
            c0330zM2234i = this.f4847f.m2234i(8, 100L);
            c0330zM2234i2 = c0330zM691a;
        }
        C1444l c1444l = new C1444l();
        ArrayList arrayList = c1444l.f5137a;
        arrayList.add(c0330zM2234i);
        View view = (View) c0330zM2234i.f827a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) c0330zM2234i2.f827a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(c0330zM2234i2);
        c1444l.m3451b();
    }

    /* JADX INFO: renamed from: k */
    public final Context m3327k() {
        if (this.f4843b == null) {
            TypedValue typedValue = new TypedValue();
            this.f4842a.getTheme().resolveAttribute(io.getgrass.www.R.attr.actionBarWidgetTheme, typedValue, true);
            int i3 = typedValue.resourceId;
            if (i3 != 0) {
                this.f4843b = new ContextThemeWrapper(this.f4842a, i3);
            } else {
                this.f4843b = this.f4842a;
            }
        }
        return this.f4843b;
    }

    /* JADX INFO: renamed from: l */
    public final void m3328l(View view) {
        InterfaceC1586f0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(io.getgrass.www.R.id.decor_content_parent);
        this.f4844c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(io.getgrass.www.R.id.action_bar);
        if (callbackFindViewById instanceof InterfaceC1586f0) {
            wrapper = (InterfaceC1586f0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f4846e = wrapper;
        this.f4847f = (ActionBarContextView) view.findViewById(io.getgrass.www.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(io.getgrass.www.R.id.action_bar_container);
        this.f4845d = actionBarContainer;
        InterfaceC1586f0 interfaceC1586f0 = this.f4846e;
        if (interfaceC1586f0 == null || this.f4847f == null || actionBarContainer == null) {
            throw new IllegalStateException(C1361G.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((C1584e1) interfaceC1586f0).f5618a.getContext();
        this.f4842a = context;
        if ((((C1584e1) this.f4846e).f5619b & 4) != 0) {
            this.f4849h = true;
        }
        int i3 = context.getApplicationInfo().targetSdkVersion;
        this.f4846e.getClass();
        m3330n(context.getResources().getBoolean(io.getgrass.www.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f4842a.obtainStyledAttributes(null, AbstractC1343a.f4777a, io.getgrass.www.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f4844c;
            if (!actionBarOverlayLayout2.f2723l) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.f4862u = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f4845d;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0313H.m646s(actionBarContainer2, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: m */
    public final void m3329m(boolean z3) {
        if (this.f4849h) {
            return;
        }
        int i3 = z3 ? 4 : 0;
        C1584e1 c1584e1 = (C1584e1) this.f4846e;
        int i4 = c1584e1.f5619b;
        this.f4849h = true;
        c1584e1.m3647a((i3 & 4) | (i4 & (-5)));
    }

    /* JADX INFO: renamed from: n */
    public final void m3330n(boolean z3) {
        if (z3) {
            this.f4845d.setTabContainer(null);
            ((C1584e1) this.f4846e).getClass();
        } else {
            ((C1584e1) this.f4846e).getClass();
            this.f4845d.setTabContainer(null);
        }
        this.f4846e.getClass();
        ((C1584e1) this.f4846e).f5618a.setCollapsible(false);
        this.f4844c.setHasNonEmbeddedTabs(false);
    }

    /* JADX INFO: renamed from: o */
    public final void m3331o(boolean z3) {
        boolean z4 = this.f4858q || !this.f4857p;
        View view = this.f4848g;
        C0444d c0444d = this.f4865x;
        if (!z4) {
            if (this.f4859r) {
                this.f4859r = false;
                C1444l c1444l = this.f4860s;
                if (c1444l != null) {
                    c1444l.m3450a();
                }
                int i3 = this.f4855n;
                C1359E c1359e = this.f4863v;
                if (i3 != 0 || (!this.f4861t && !z3)) {
                    c1359e.mo341a();
                    return;
                }
                this.f4845d.setAlpha(1.0f);
                this.f4845d.setTransitioning(true);
                C1444l c1444l2 = new C1444l();
                float f3 = -this.f4845d.getHeight();
                if (z3) {
                    this.f4845d.getLocationInWindow(new int[]{0, 0});
                    f3 -= r12[1];
                }
                C0330Z c0330zM691a = AbstractC0323S.m691a(this.f4845d);
                c0330zM691a.m719e(f3);
                View view2 = (View) c0330zM691a.f827a.get();
                if (view2 != null) {
                    AbstractC0329Y.m714a(view2.animate(), c0444d != null ? new C0327W(c0444d, view2) : null);
                }
                boolean z5 = c1444l2.f5141e;
                ArrayList arrayList = c1444l2.f5137a;
                if (!z5) {
                    arrayList.add(c0330zM691a);
                }
                if (this.f4856o && view != null) {
                    C0330Z c0330zM691a2 = AbstractC0323S.m691a(view);
                    c0330zM691a2.m719e(f3);
                    if (!c1444l2.f5141e) {
                        arrayList.add(c0330zM691a2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = f4840y;
                boolean z6 = c1444l2.f5141e;
                if (!z6) {
                    c1444l2.f5139c = accelerateInterpolator;
                }
                if (!z6) {
                    c1444l2.f5138b = 250L;
                }
                if (!z6) {
                    c1444l2.f5140d = c1359e;
                }
                this.f4860s = c1444l2;
                c1444l2.m3451b();
                return;
            }
            return;
        }
        if (this.f4859r) {
            return;
        }
        this.f4859r = true;
        C1444l c1444l3 = this.f4860s;
        if (c1444l3 != null) {
            c1444l3.m3450a();
        }
        this.f4845d.setVisibility(0);
        int i4 = this.f4855n;
        C1359E c1359e2 = this.f4864w;
        if (i4 == 0 && (this.f4861t || z3)) {
            this.f4845d.setTranslationY(0.0f);
            float f4 = -this.f4845d.getHeight();
            if (z3) {
                this.f4845d.getLocationInWindow(new int[]{0, 0});
                f4 -= r12[1];
            }
            this.f4845d.setTranslationY(f4);
            C1444l c1444l4 = new C1444l();
            C0330Z c0330zM691a3 = AbstractC0323S.m691a(this.f4845d);
            c0330zM691a3.m719e(0.0f);
            View view3 = (View) c0330zM691a3.f827a.get();
            if (view3 != null) {
                AbstractC0329Y.m714a(view3.animate(), c0444d != null ? new C0327W(c0444d, view3) : null);
            }
            boolean z7 = c1444l4.f5141e;
            ArrayList arrayList2 = c1444l4.f5137a;
            if (!z7) {
                arrayList2.add(c0330zM691a3);
            }
            if (this.f4856o && view != null) {
                view.setTranslationY(f4);
                C0330Z c0330zM691a4 = AbstractC0323S.m691a(view);
                c0330zM691a4.m719e(0.0f);
                if (!c1444l4.f5141e) {
                    arrayList2.add(c0330zM691a4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = f4841z;
            boolean z8 = c1444l4.f5141e;
            if (!z8) {
                c1444l4.f5139c = decelerateInterpolator;
            }
            if (!z8) {
                c1444l4.f5138b = 250L;
            }
            if (!z8) {
                c1444l4.f5140d = c1359e2;
            }
            this.f4860s = c1444l4;
            c1444l4.m3451b();
        } else {
            this.f4845d.setAlpha(1.0f);
            this.f4845d.setTranslationY(0.0f);
            if (this.f4856o && view != null) {
                view.setTranslationY(0.0f);
            }
            c1359e2.mo341a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f4844c;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            AbstractC0311F.m627c(actionBarOverlayLayout);
        }
    }

    public C1361G(Dialog dialog) {
        new ArrayList();
        this.f4854m = new ArrayList();
        this.f4855n = 0;
        this.f4856o = true;
        this.f4859r = true;
        this.f4863v = new C1359E(this, 0);
        this.f4864w = new C1359E(this, 1);
        this.f4865x = new C0444d(this);
        m3328l(dialog.getWindow().getDecorView());
    }
}

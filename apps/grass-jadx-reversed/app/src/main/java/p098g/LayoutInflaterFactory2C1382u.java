package p098g;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.AbstractC0935f;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p018F.AbstractC0212d;
import p018F.C0213e;
import p018F.C0214f;
import p020F2.AbstractC0223a;
import p029J.AbstractC0306A;
import p029J.AbstractC0307B;
import p029J.AbstractC0310E;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.C0330Z;
import p029J.C0373x;
import p094f.AbstractC1343a;
import p105i.AbstractC1434b;
import p105i.C1437e;
import p105i.C1442j;
import p108j.C1475i;
import p108j.C1481o;
import p108j.InterfaceC1477k;
import p108j.MenuC1479m;
import p110k.AbstractC1590g1;
import p110k.AbstractC1596i1;
import p110k.C1519A;
import p110k.C1523C;
import p110k.C1547O;
import p110k.C1569Z0;
import p110k.C1577c0;
import p110k.C1582e;
import p110k.C1584e1;
import p110k.C1594i;
import p110k.C1611q;
import p110k.C1613r;
import p110k.C1617t;
import p110k.C1621v;
import p110k.C1623w;
import p110k.InterfaceC1583e0;
import p110k.InterfaceC1586f0;
import p128p.C1817k;
import p166z0.C2071i;

/* JADX INFO: renamed from: g.u */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterFactory2C1382u extends AbstractC1371j implements InterfaceC1477k, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: l0 */
    public static final C1817k f4948l0 = new C1817k();

    /* JADX INFO: renamed from: m0 */
    public static final int[] f4949m0 = {R.attr.windowBackground};

    /* JADX INFO: renamed from: n0 */
    public static final boolean f4950n0 = !"robolectric".equals(Build.FINGERPRINT);

    /* JADX INFO: renamed from: o0 */
    public static final boolean f4951o0 = true;

    /* JADX INFO: renamed from: A */
    public PopupWindow f4952A;

    /* JADX INFO: renamed from: B */
    public RunnableC1372k f4953B;

    /* JADX INFO: renamed from: D */
    public boolean f4955D;

    /* JADX INFO: renamed from: E */
    public ViewGroup f4956E;

    /* JADX INFO: renamed from: F */
    public TextView f4957F;

    /* JADX INFO: renamed from: G */
    public View f4958G;

    /* JADX INFO: renamed from: H */
    public boolean f4959H;

    /* JADX INFO: renamed from: I */
    public boolean f4960I;

    /* JADX INFO: renamed from: J */
    public boolean f4961J;

    /* JADX INFO: renamed from: K */
    public boolean f4962K;

    /* JADX INFO: renamed from: L */
    public boolean f4963L;

    /* JADX INFO: renamed from: M */
    public boolean f4964M;

    /* JADX INFO: renamed from: N */
    public boolean f4965N;

    /* JADX INFO: renamed from: O */
    public boolean f4966O;

    /* JADX INFO: renamed from: P */
    public C1381t[] f4967P;

    /* JADX INFO: renamed from: Q */
    public C1381t f4968Q;

    /* JADX INFO: renamed from: R */
    public boolean f4969R;

    /* JADX INFO: renamed from: S */
    public boolean f4970S;

    /* JADX INFO: renamed from: T */
    public boolean f4971T;

    /* JADX INFO: renamed from: U */
    public boolean f4972U;

    /* JADX INFO: renamed from: V */
    public Configuration f4973V;

    /* JADX INFO: renamed from: W */
    public final int f4974W;

    /* JADX INFO: renamed from: X */
    public int f4975X;

    /* JADX INFO: renamed from: Y */
    public int f4976Y;

    /* JADX INFO: renamed from: Z */
    public boolean f4977Z;

    /* JADX INFO: renamed from: a0 */
    public C1379r f4978a0;

    /* JADX INFO: renamed from: b0 */
    public C1379r f4979b0;

    /* JADX INFO: renamed from: c0 */
    public boolean f4980c0;

    /* JADX INFO: renamed from: d0 */
    public int f4981d0;

    /* JADX INFO: renamed from: f0 */
    public boolean f4983f0;

    /* JADX INFO: renamed from: g0 */
    public Rect f4984g0;

    /* JADX INFO: renamed from: h0 */
    public Rect f4985h0;

    /* JADX INFO: renamed from: i0 */
    public C1385x f4986i0;

    /* JADX INFO: renamed from: j0 */
    public OnBackInvokedDispatcher f4987j0;

    /* JADX INFO: renamed from: k0 */
    public OnBackInvokedCallback f4988k0;

    /* JADX INFO: renamed from: n */
    public final Object f4989n;

    /* JADX INFO: renamed from: o */
    public final Context f4990o;

    /* JADX INFO: renamed from: p */
    public Window f4991p;

    /* JADX INFO: renamed from: q */
    public WindowCallbackC1378q f4992q;

    /* JADX INFO: renamed from: r */
    public final InterfaceC1368g f4993r;

    /* JADX INFO: renamed from: s */
    public C1361G f4994s;

    /* JADX INFO: renamed from: t */
    public C1442j f4995t;

    /* JADX INFO: renamed from: u */
    public CharSequence f4996u;

    /* JADX INFO: renamed from: v */
    public InterfaceC1583e0 f4997v;

    /* JADX INFO: renamed from: w */
    public C1373l f4998w;

    /* JADX INFO: renamed from: x */
    public C1374m f4999x;

    /* JADX INFO: renamed from: y */
    public AbstractC1434b f5000y;

    /* JADX INFO: renamed from: z */
    public ActionBarContextView f5001z;

    /* JADX INFO: renamed from: C */
    public C0330Z f4954C = null;

    /* JADX INFO: renamed from: e0 */
    public final RunnableC1372k f4982e0 = new RunnableC1372k(this, 0);

    public LayoutInflaterFactory2C1382u(Context context, Window window, InterfaceC1368g interfaceC1368g, Object obj) {
        AbstractActivityC1367f abstractActivityC1367f;
        this.f4974W = -100;
        this.f4990o = context;
        this.f4993r = interfaceC1368g;
        this.f4989n = obj;
        if (obj instanceof Dialog) {
            while (context != null) {
                if (!(context instanceof AbstractActivityC1367f)) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    abstractActivityC1367f = (AbstractActivityC1367f) context;
                    break;
                }
            }
            abstractActivityC1367f = null;
            if (abstractActivityC1367f != null) {
                this.f4974W = ((LayoutInflaterFactory2C1382u) abstractActivityC1367f.m3342n()).f4974W;
            }
        }
        if (this.f4974W == -100) {
            C1817k c1817k = f4948l0;
            Integer num = (Integer) c1817k.getOrDefault(this.f4989n.getClass().getName(), null);
            if (num != null) {
                this.f4974W = num.intValue();
                c1817k.remove(this.f4989n.getClass().getName());
            }
        }
        if (window != null) {
            m3381o(window);
        }
        C1613r.m3681c();
    }

    /* JADX INFO: renamed from: p */
    public static C0213e m3369p(Context context) {
        C0213e c0213e;
        C0213e c0213e2;
        if (Build.VERSION.SDK_INT >= 33 || (c0213e = AbstractC1371j.f4910g) == null) {
            return null;
        }
        C0213e c0213eM3359b = AbstractC1376o.m3359b(context.getApplicationContext().getResources().getConfiguration());
        C0214f c0214f = c0213e.f518a;
        if (c0214f.f519a.isEmpty()) {
            c0213e2 = C0213e.f517b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i3 = 0;
            while (i3 < c0213eM3359b.f518a.f519a.size() + c0214f.f519a.size()) {
                Locale locale = i3 < c0214f.f519a.size() ? c0214f.f519a.get(i3) : c0213eM3359b.f518a.f519a.get(i3 - c0214f.f519a.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i3++;
            }
            c0213e2 = new C0213e(new C0214f(AbstractC0212d.m420a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return c0213e2.f518a.f519a.isEmpty() ? c0213eM3359b : c0213e2;
    }

    /* JADX INFO: renamed from: t */
    public static Configuration m3370t(Context context, int i3, C0213e c0213e, Configuration configuration, boolean z3) {
        int i4 = i3 != 1 ? i3 != 2 ? z3 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i4 | (configuration2.uiMode & (-49));
        if (c0213e != null) {
            AbstractC1376o.m3361d(configuration2, c0213e);
        }
        return configuration2;
    }

    /* JADX INFO: renamed from: A */
    public final void m3371A() {
        m3387w();
        if (this.f4961J && this.f4994s == null) {
            Object obj = this.f4989n;
            if (obj instanceof Activity) {
                this.f4994s = new C1361G((Activity) obj, this.f4962K);
            } else if (obj instanceof Dialog) {
                this.f4994s = new C1361G((Dialog) obj);
            }
            C1361G c1361g = this.f4994s;
            if (c1361g != null) {
                c1361g.m3329m(this.f4983f0);
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public final void m3372B(int i3) {
        this.f4981d0 = (1 << i3) | this.f4981d0;
        if (this.f4980c0) {
            return;
        }
        View decorView = this.f4991p.getDecorView();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m597m(decorView, this.f4982e0);
        this.f4980c0 = true;
    }

    /* JADX INFO: renamed from: C */
    public final int m3373C(Context context, int i3) {
        if (i3 == -100) {
            return -1;
        }
        if (i3 != -1) {
            if (i3 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return m3389y(context).mo2452g();
            }
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.f4979b0 == null) {
                    this.f4979b0 = new C1379r(this, context);
                }
                return this.f4979b0.mo2452g();
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: D */
    public final boolean m3374D() {
        InterfaceC1586f0 interfaceC1586f0;
        C1569Z0 c1569z0;
        boolean z3 = this.f4969R;
        this.f4969R = false;
        C1381t c1381tM3390z = m3390z(0);
        if (c1381tM3390z.f4944m) {
            if (!z3) {
                m3384s(c1381tM3390z, true);
            }
            return true;
        }
        AbstractC1434b abstractC1434b = this.f5000y;
        if (abstractC1434b != null) {
            abstractC1434b.mo3312a();
            return true;
        }
        m3371A();
        C1361G c1361g = this.f4994s;
        if (c1361g == null || (interfaceC1586f0 = c1361g.f4846e) == null || (c1569z0 = ((C1584e1) interfaceC1586f0).f5618a.f2824O) == null || c1569z0.f5593f == null) {
            return false;
        }
        C1569Z0 c1569z02 = ((C1584e1) interfaceC1586f0).f5618a.f2824O;
        C1481o c1481o = c1569z02 == null ? null : c1569z02.f5593f;
        if (c1481o != null) {
            c1481o.collapseActionView();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0172, code lost:
    
        if (r3.f5336j.getCount() > 0) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3375E(p098g.C1381t r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instruction units count: 471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.LayoutInflaterFactory2C1382u.m3375E(g.t, android.view.KeyEvent):void");
    }

    /* JADX INFO: renamed from: F */
    public final boolean m3376F(C1381t c1381t, int i3, KeyEvent keyEvent) {
        MenuC1479m menuC1479m;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c1381t.f4942k || m3377G(c1381t, keyEvent)) && (menuC1479m = c1381t.f4939h) != null) {
            return menuC1479m.performShortcut(i3, keyEvent, 1);
        }
        return false;
    }

    /* JADX INFO: renamed from: G */
    public final boolean m3377G(C1381t c1381t, KeyEvent keyEvent) {
        InterfaceC1583e0 interfaceC1583e0;
        InterfaceC1583e0 interfaceC1583e02;
        Resources.Theme themeNewTheme;
        InterfaceC1583e0 interfaceC1583e03;
        InterfaceC1583e0 interfaceC1583e04;
        if (this.f4972U) {
            return false;
        }
        if (c1381t.f4942k) {
            return true;
        }
        C1381t c1381t2 = this.f4968Q;
        if (c1381t2 != null && c1381t2 != c1381t) {
            m3384s(c1381t2, false);
        }
        Window.Callback callback = this.f4991p.getCallback();
        int i3 = c1381t.f4932a;
        if (callback != null) {
            c1381t.f4938g = callback.onCreatePanelView(i3);
        }
        boolean z3 = i3 == 0 || i3 == 108;
        if (z3 && (interfaceC1583e04 = this.f4997v) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1583e04;
            actionBarOverlayLayout.m2239k();
            ((C1584e1) actionBarOverlayLayout.f2720i).f5629l = true;
        }
        if (c1381t.f4938g == null) {
            MenuC1479m menuC1479m = c1381t.f4939h;
            if (menuC1479m == null || c1381t.f4946o) {
                if (menuC1479m == null) {
                    Context context = this.f4990o;
                    if ((i3 == 0 || i3 == 108) && this.f4997v != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme = context.getTheme();
                        theme.resolveAttribute(io.getgrass.www.R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            themeNewTheme = context.getResources().newTheme();
                            themeNewTheme.setTo(theme);
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                            themeNewTheme.resolveAttribute(io.getgrass.www.R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme.resolveAttribute(io.getgrass.www.R.attr.actionBarWidgetTheme, typedValue, true);
                            themeNewTheme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (themeNewTheme == null) {
                                themeNewTheme = context.getResources().newTheme();
                                themeNewTheme.setTo(theme);
                            }
                            themeNewTheme.applyStyle(typedValue.resourceId, true);
                        }
                        if (themeNewTheme != null) {
                            C1437e c1437e = new C1437e(context, 0);
                            c1437e.getTheme().setTo(themeNewTheme);
                            context = c1437e;
                        }
                    }
                    MenuC1479m menuC1479m2 = new MenuC1479m(context);
                    menuC1479m2.f5348e = this;
                    MenuC1479m menuC1479m3 = c1381t.f4939h;
                    if (menuC1479m2 != menuC1479m3) {
                        if (menuC1479m3 != null) {
                            menuC1479m3.m3520r(c1381t.f4940i);
                        }
                        c1381t.f4939h = menuC1479m2;
                        C1475i c1475i = c1381t.f4940i;
                        if (c1475i != null) {
                            menuC1479m2.m3512b(c1475i, menuC1479m2.f5344a);
                        }
                    }
                    if (c1381t.f4939h == null) {
                        return false;
                    }
                }
                if (z3 && (interfaceC1583e02 = this.f4997v) != null) {
                    if (this.f4998w == null) {
                        this.f4998w = new C1373l(this);
                    }
                    ((ActionBarOverlayLayout) interfaceC1583e02).m2240l(c1381t.f4939h, this.f4998w);
                }
                c1381t.f4939h.m3525w();
                if (!callback.onCreatePanelMenu(i3, c1381t.f4939h)) {
                    MenuC1479m menuC1479m4 = c1381t.f4939h;
                    if (menuC1479m4 != null) {
                        if (menuC1479m4 != null) {
                            menuC1479m4.m3520r(c1381t.f4940i);
                        }
                        c1381t.f4939h = null;
                    }
                    if (z3 && (interfaceC1583e0 = this.f4997v) != null) {
                        ((ActionBarOverlayLayout) interfaceC1583e0).m2240l(null, this.f4998w);
                    }
                    return false;
                }
                c1381t.f4946o = false;
            }
            c1381t.f4939h.m3525w();
            Bundle bundle = c1381t.f4947p;
            if (bundle != null) {
                c1381t.f4939h.m3521s(bundle);
                c1381t.f4947p = null;
            }
            if (!callback.onPreparePanel(0, c1381t.f4938g, c1381t.f4939h)) {
                if (z3 && (interfaceC1583e03 = this.f4997v) != null) {
                    ((ActionBarOverlayLayout) interfaceC1583e03).m2240l(null, this.f4998w);
                }
                c1381t.f4939h.m3524v();
                return false;
            }
            c1381t.f4939h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            c1381t.f4939h.m3524v();
        }
        c1381t.f4942k = true;
        c1381t.f4943l = false;
        this.f4968Q = c1381t;
        return true;
    }

    /* JADX INFO: renamed from: H */
    public final void m3378H() {
        if (this.f4955D) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: renamed from: I */
    public final void m3379I() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z3 = false;
            if (this.f4987j0 != null && (m3390z(0).f4944m || this.f5000y != null)) {
                z3 = true;
            }
            if (z3 && this.f4988k0 == null) {
                this.f4988k0 = AbstractC1377p.m3363b(this.f4987j0, this);
            } else {
                if (z3 || (onBackInvokedCallback = this.f4988k0) == null) {
                    return;
                }
                AbstractC1377p.m3364c(this.f4987j0, onBackInvokedCallback);
            }
        }
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: a */
    public final void mo3349a() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f4990o);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof LayoutInflaterFactory2C1382u) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: b */
    public final void mo3350b() {
        if (this.f4994s != null) {
            m3371A();
            this.f4994s.getClass();
            m3372B(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (r6.m3656j() != false) goto L20;
     */
    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo444c(p108j.MenuC1479m r6) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.LayoutInflaterFactory2C1382u.mo444c(j.m):void");
    }

    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: d */
    public final boolean mo445d(MenuC1479m menuC1479m, MenuItem menuItem) {
        C1381t c1381t;
        Window.Callback callback = this.f4991p.getCallback();
        if (callback != null && !this.f4972U) {
            MenuC1479m menuC1479mMo3495k = menuC1479m.mo3495k();
            C1381t[] c1381tArr = this.f4967P;
            int length = c1381tArr != null ? c1381tArr.length : 0;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    c1381t = c1381tArr[i3];
                    if (c1381t != null && c1381t.f4939h == menuC1479mMo3495k) {
                        break;
                    }
                    i3++;
                } else {
                    c1381t = null;
                    break;
                }
            }
            if (c1381t != null) {
                return callback.onMenuItemSelected(c1381t.f4932a, menuItem);
            }
        }
        return false;
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: f */
    public final void mo3351f() {
        String strM469f;
        this.f4970S = true;
        m3380n(false, true);
        m3388x();
        Object obj = this.f4989n;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strM469f = AbstractC0223a.m469f(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e3) {
                    throw new IllegalArgumentException(e3);
                }
            } catch (IllegalArgumentException unused) {
                strM469f = null;
            }
            if (strM469f != null) {
                C1361G c1361g = this.f4994s;
                if (c1361g == null) {
                    this.f4983f0 = true;
                } else {
                    c1361g.m3329m(true);
                }
            }
            synchronized (AbstractC1371j.f4915l) {
                AbstractC1371j.m3348h(this);
                AbstractC1371j.f4914k.add(new WeakReference(this));
            }
        }
        this.f4973V = new Configuration(this.f4990o.getResources().getConfiguration());
        this.f4971T = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo3352g() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4989n
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = p098g.AbstractC1371j.f4915l
            monitor-enter(r0)
            p098g.AbstractC1371j.m3348h(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f4980c0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f4991p
            android.view.View r0 = r0.getDecorView()
            g.k r1 = r3.f4982e0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f4972U = r0
            int r0 = r3.f4974W
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f4989n
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            p.k r0 = p098g.LayoutInflaterFactory2C1382u.f4948l0
            java.lang.Object r1 = r3.f4989n
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f4974W
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            p.k r0 = p098g.LayoutInflaterFactory2C1382u.f4948l0
            java.lang.Object r1 = r3.f4989n
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            g.r r0 = r3.f4978a0
            if (r0 == 0) goto L63
            r0.m2449d()
        L63:
            g.r r0 = r3.f4979b0
            if (r0 == 0) goto L6a
            r0.m2449d()
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.LayoutInflaterFactory2C1382u.mo3352g():void");
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: i */
    public final boolean mo3353i(int i3) {
        if (i3 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i3 = 108;
        } else if (i3 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i3 = 109;
        }
        if (this.f4965N && i3 == 108) {
            return false;
        }
        if (this.f4961J && i3 == 1) {
            this.f4961J = false;
        }
        if (i3 == 1) {
            m3378H();
            this.f4965N = true;
            return true;
        }
        if (i3 == 2) {
            m3378H();
            this.f4959H = true;
            return true;
        }
        if (i3 == 5) {
            m3378H();
            this.f4960I = true;
            return true;
        }
        if (i3 == 10) {
            m3378H();
            this.f4963L = true;
            return true;
        }
        if (i3 == 108) {
            m3378H();
            this.f4961J = true;
            return true;
        }
        if (i3 != 109) {
            return this.f4991p.requestFeature(i3);
        }
        m3378H();
        this.f4962K = true;
        return true;
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: j */
    public final void mo3354j(int i3) {
        m3387w();
        ViewGroup viewGroup = (ViewGroup) this.f4956E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f4990o).inflate(i3, viewGroup);
        this.f4992q.m3365a(this.f4991p.getCallback());
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: k */
    public final void mo3355k(View view) {
        m3387w();
        ViewGroup viewGroup = (ViewGroup) this.f4956E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f4992q.m3365a(this.f4991p.getCallback());
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: l */
    public final void mo3356l(View view, ViewGroup.LayoutParams layoutParams) {
        m3387w();
        ViewGroup viewGroup = (ViewGroup) this.f4956E.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f4992q.m3365a(this.f4991p.getCallback());
    }

    @Override // p098g.AbstractC1371j
    /* JADX INFO: renamed from: m */
    public final void mo3357m(CharSequence charSequence) {
        this.f4996u = charSequence;
        InterfaceC1583e0 interfaceC1583e0 = this.f4997v;
        if (interfaceC1583e0 != null) {
            interfaceC1583e0.setWindowTitle(charSequence);
            return;
        }
        C1361G c1361g = this.f4994s;
        if (c1361g == null) {
            TextView textView = this.f4957F;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        C1584e1 c1584e1 = (C1584e1) c1361g.f4846e;
        if (c1584e1.f5624g) {
            return;
        }
        c1584e1.f5625h = charSequence;
        if ((c1584e1.f5619b & 8) != 0) {
            Toolbar toolbar = c1584e1.f5618a;
            toolbar.setTitle(charSequence);
            if (c1584e1.f5624g) {
                AbstractC0323S.m702l(toolbar.getRootView(), charSequence);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c8  */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3380n(boolean r12, boolean r13) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.LayoutInflaterFactory2C1382u.m3380n(boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3381o(android.view.Window r8) {
        /*
            r7 = this;
            android.view.Window r0 = r7.f4991p
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L80
            android.view.Window$Callback r0 = r8.getCallback()
            boolean r2 = r0 instanceof p098g.WindowCallbackC1378q
            if (r2 != 0) goto L7a
            g.q r1 = new g.q
            r1.<init>(r7, r0)
            r7.f4992q = r1
            r8.setCallback(r1)
            int[] r0 = p098g.LayoutInflaterFactory2C1382u.f4949m0
            android.content.Context r1 = r7.f4990o
            r2 = 0
            android.content.res.TypedArray r0 = r1.obtainStyledAttributes(r2, r0)
            r3 = 0
            boolean r4 = r0.hasValue(r3)
            if (r4 == 0) goto L3f
            int r3 = r0.getResourceId(r3, r3)
            if (r3 == 0) goto L3f
            k.r r4 = p110k.C1613r.m3680a()
            monitor-enter(r4)
            k.G0 r5 = r4.f5723a     // Catch: java.lang.Throwable -> L3c
            r6 = 1
            android.graphics.drawable.Drawable r1 = r5.m3584f(r1, r3, r6)     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r4)
            goto L40
        L3c:
            r8 = move-exception
            monitor-exit(r4)
            throw r8
        L3f:
            r1 = r2
        L40:
            if (r1 == 0) goto L45
            r8.setBackgroundDrawable(r1)
        L45:
            r0.recycle()
            r7.f4991p = r8
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r8 < r0) goto L79
            android.window.OnBackInvokedDispatcher r8 = r7.f4987j0
            if (r8 != 0) goto L79
            if (r8 == 0) goto L5f
            android.window.OnBackInvokedCallback r0 = r7.f4988k0
            if (r0 == 0) goto L5f
            p098g.AbstractC1377p.m3364c(r8, r0)
            r7.f4988k0 = r2
        L5f:
            java.lang.Object r8 = r7.f4989n
            boolean r0 = r8 instanceof android.app.Activity
            if (r0 == 0) goto L74
            android.app.Activity r8 = (android.app.Activity) r8
            android.view.Window r0 = r8.getWindow()
            if (r0 == 0) goto L74
            android.window.OnBackInvokedDispatcher r8 = p098g.AbstractC1377p.m3362a(r8)
            r7.f4987j0 = r8
            goto L76
        L74:
            r7.f4987j0 = r2
        L76:
            r7.m3379I()
        L79:
            return
        L7a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
            throw r8
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.LayoutInflaterFactory2C1382u.m3381o(android.view.Window):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View c1519a;
        ?? r8;
        String attributeValue = str;
        byte b3 = 4;
        View view2 = null;
        if (this.f4986i0 == null) {
            int[] iArr = AbstractC1343a.f4786j;
            Context context2 = this.f4990o;
            String string = context2.obtainStyledAttributes(iArr).getString(116);
            if (string == null) {
                this.f4986i0 = new C1385x();
            } else {
                try {
                    this.f4986i0 = (C1385x) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f4986i0 = new C1385x();
                }
            }
        }
        C1385x c1385x = this.f4986i0;
        int i3 = AbstractC1590g1.f5638a;
        c1385x.getClass();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4801y, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        Context c1437e = (resourceId == 0 || ((context instanceof C1437e) && ((C1437e) context).f5080a == resourceId)) ? context : new C1437e(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                b3 = !attributeValue.equals("RatingBar") ? (byte) -1 : (byte) 0;
                break;
            case -1455429095:
                b3 = !attributeValue.equals("CheckedTextView") ? (byte) -1 : (byte) 1;
                break;
            case -1346021293:
                b3 = !attributeValue.equals("MultiAutoCompleteTextView") ? (byte) -1 : (byte) 2;
                break;
            case -938935918:
                b3 = !attributeValue.equals("TextView") ? (byte) -1 : (byte) 3;
                break;
            case -937446323:
                if (!attributeValue.equals("ImageButton")) {
                    b3 = -1;
                }
                break;
            case -658531749:
                b3 = !attributeValue.equals("SeekBar") ? (byte) -1 : (byte) 5;
                break;
            case -339785223:
                b3 = !attributeValue.equals("Spinner") ? (byte) -1 : (byte) 6;
                break;
            case 776382189:
                b3 = !attributeValue.equals("RadioButton") ? (byte) -1 : (byte) 7;
                break;
            case 799298502:
                b3 = !attributeValue.equals("ToggleButton") ? (byte) -1 : (byte) 8;
                break;
            case 1125864064:
                b3 = !attributeValue.equals("ImageView") ? (byte) -1 : (byte) 9;
                break;
            case 1413872058:
                b3 = !attributeValue.equals("AutoCompleteTextView") ? (byte) -1 : (byte) 10;
                break;
            case 1601505219:
                b3 = !attributeValue.equals("CheckBox") ? (byte) -1 : (byte) 11;
                break;
            case 1666676343:
                b3 = !attributeValue.equals("EditText") ? (byte) -1 : (byte) 12;
                break;
            case 2001146706:
                b3 = !attributeValue.equals("Button") ? (byte) -1 : (byte) 13;
                break;
            default:
                b3 = -1;
                break;
        }
        switch (b3) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                c1519a = new C1519A(c1437e, attributeSet);
                break;
            case 1:
                c1519a = new C1611q(c1437e, attributeSet);
                break;
            case 2:
                c1519a = new C1623w(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                c1519a = c1385x.mo3225e(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                c1519a = new C1621v(c1437e, attributeSet, io.getgrass.www.R.attr.imageButtonStyle);
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                c1519a = new C1523C(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                c1519a = new C1547O(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                c1519a = c1385x.mo3224d(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                c1519a = new C1577c0(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                c1519a = new AppCompatImageView(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                c1519a = c1385x.mo3221a(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                c1519a = c1385x.mo3223c(c1437e, attributeSet);
                break;
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                c1519a = new C1617t(c1437e, attributeSet);
                break;
            case 13:
                c1519a = c1385x.mo3222b(c1437e, attributeSet);
                break;
            default:
                c1519a = null;
                break;
        }
        if (c1519a == null && context != c1437e) {
            Object[] objArr = c1385x.f5014a;
            if (attributeValue.equals("view")) {
                attributeValue = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = c1437e;
                objArr[1] = attributeSet;
                if (-1 == attributeValue.indexOf(46)) {
                    int i4 = 0;
                    while (true) {
                        String[] strArr = C1385x.f5012g;
                        if (i4 < 3) {
                            View viewM3391f = c1385x.m3391f(c1437e, attributeValue, strArr[i4]);
                            if (viewM3391f != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = viewM3391f;
                            } else {
                                i4++;
                            }
                        }
                    }
                } else {
                    View viewM3391f2 = c1385x.m3391f(c1437e, attributeValue, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = viewM3391f2;
                }
            } catch (Exception unused) {
            } finally {
                objArr[0] = null;
                objArr[1] = null;
            }
            c1519a = view2;
        }
        if (c1519a != null) {
            Context context3 = c1519a.getContext();
            if (context3 instanceof ContextWrapper) {
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                if (AbstractC0306A.m584a(c1519a)) {
                    TypedArray typedArrayObtainStyledAttributes2 = context3.obtainStyledAttributes(attributeSet, C1385x.f5008c);
                    String string2 = typedArrayObtainStyledAttributes2.getString(0);
                    if (string2 != null) {
                        c1519a.setOnClickListener(new ViewOnClickListenerC1384w(c1519a, string2));
                    }
                    typedArrayObtainStyledAttributes2.recycle();
                }
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray typedArrayObtainStyledAttributes3 = c1437e.obtainStyledAttributes(attributeSet, C1385x.f5009d);
                if (typedArrayObtainStyledAttributes3.hasValue(0)) {
                    boolean z3 = typedArrayObtainStyledAttributes3.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                    r8 = 0;
                    new C0373x(io.getgrass.www.R.id.tag_accessibility_heading, Boolean.class, 0, 28, 2).m845e(c1519a, Boolean.valueOf(z3));
                } else {
                    r8 = 0;
                }
                typedArrayObtainStyledAttributes3.recycle();
                ?? ObtainStyledAttributes = c1437e.obtainStyledAttributes(attributeSet, C1385x.f5010e);
                if (ObtainStyledAttributes.hasValue(r8)) {
                    AbstractC0323S.m702l(c1519a, ObtainStyledAttributes.getString(r8));
                }
                ObtainStyledAttributes.recycle();
                ?? ObtainStyledAttributes2 = c1437e.obtainStyledAttributes(attributeSet, C1385x.f5011f);
                if (ObtainStyledAttributes2.hasValue(r8)) {
                    boolean z4 = ObtainStyledAttributes2.getBoolean(r8, r8);
                    WeakHashMap weakHashMap3 = AbstractC0323S.f816a;
                    new C0373x(io.getgrass.www.R.id.tag_screen_reader_focusable, Boolean.class, r8 == true ? 1 : 0, 28, 0).m845e(c1519a, Boolean.valueOf(z4));
                }
                ObtainStyledAttributes2.recycle();
            }
        }
        return c1519a;
    }

    /* JADX INFO: renamed from: q */
    public final void m3382q(int i3, C1381t c1381t, MenuC1479m menuC1479m) {
        if (menuC1479m == null) {
            if (c1381t == null && i3 >= 0) {
                C1381t[] c1381tArr = this.f4967P;
                if (i3 < c1381tArr.length) {
                    c1381t = c1381tArr[i3];
                }
            }
            if (c1381t != null) {
                menuC1479m = c1381t.f4939h;
            }
        }
        if ((c1381t == null || c1381t.f4944m) && !this.f4972U) {
            WindowCallbackC1378q windowCallbackC1378q = this.f4992q;
            Window.Callback callback = this.f4991p.getCallback();
            windowCallbackC1378q.getClass();
            try {
                windowCallbackC1378q.f4926h = true;
                callback.onPanelClosed(i3, menuC1479m);
            } finally {
                windowCallbackC1378q.f4926h = false;
            }
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m3383r(MenuC1479m menuC1479m) {
        C1594i c1594i;
        if (this.f4966O) {
            return;
        }
        this.f4966O = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f4997v;
        actionBarOverlayLayout.m2239k();
        ActionMenuView actionMenuView = ((C1584e1) actionBarOverlayLayout.f2720i).f5618a.f2830e;
        if (actionMenuView != null && (c1594i = actionMenuView.f2747x) != null) {
            c1594i.m3655f();
            C1582e c1582e = c1594i.f5660x;
            if (c1582e != null && c1582e.m3539b()) {
                c1582e.f5421j.dismiss();
            }
        }
        Window.Callback callback = this.f4991p.getCallback();
        if (callback != null && !this.f4972U) {
            callback.onPanelClosed(108, menuC1479m);
        }
        this.f4966O = false;
    }

    /* JADX INFO: renamed from: s */
    public final void m3384s(C1381t c1381t, boolean z3) {
        C1380s c1380s;
        InterfaceC1583e0 interfaceC1583e0;
        C1594i c1594i;
        if (z3 && c1381t.f4932a == 0 && (interfaceC1583e0 = this.f4997v) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC1583e0;
            actionBarOverlayLayout.m2239k();
            ActionMenuView actionMenuView = ((C1584e1) actionBarOverlayLayout.f2720i).f5618a.f2830e;
            if (actionMenuView != null && (c1594i = actionMenuView.f2747x) != null && c1594i.m3656j()) {
                m3383r(c1381t.f4939h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f4990o.getSystemService("window");
        if (windowManager != null && c1381t.f4944m && (c1380s = c1381t.f4936e) != null) {
            windowManager.removeView(c1380s);
            if (z3) {
                m3382q(c1381t.f4932a, c1381t, null);
            }
        }
        c1381t.f4942k = false;
        c1381t.f4943l = false;
        c1381t.f4944m = false;
        c1381t.f4937f = null;
        c1381t.f4945n = true;
        if (this.f4968Q == c1381t) {
            this.f4968Q = null;
        }
        if (c1381t.f4932a == 0) {
            m3379I();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011d  */
    /* JADX INFO: renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3385u(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p098g.LayoutInflaterFactory2C1382u.m3385u(android.view.KeyEvent):boolean");
    }

    /* JADX INFO: renamed from: v */
    public final void m3386v(int i3) {
        C1381t c1381tM3390z = m3390z(i3);
        if (c1381tM3390z.f4939h != null) {
            Bundle bundle = new Bundle();
            c1381tM3390z.f4939h.m3522t(bundle);
            if (bundle.size() > 0) {
                c1381tM3390z.f4947p = bundle;
            }
            c1381tM3390z.f4939h.m3525w();
            c1381tM3390z.f4939h.clear();
        }
        c1381tM3390z.f4946o = true;
        c1381tM3390z.f4945n = true;
        if ((i3 == 108 || i3 == 0) && this.f4997v != null) {
            C1381t c1381tM3390z2 = m3390z(0);
            c1381tM3390z2.f4942k = false;
            m3377G(c1381tM3390z2, null);
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m3387w() {
        ViewGroup viewGroup;
        if (this.f4955D) {
            return;
        }
        int[] iArr = AbstractC1343a.f4786j;
        Context context = this.f4990o;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(117)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(126, false)) {
            mo3353i(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(117, false)) {
            mo3353i(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(118, false)) {
            mo3353i(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(119, false)) {
            mo3353i(10);
        }
        this.f4964M = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        m3388x();
        this.f4991p.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.f4965N) {
            viewGroup = this.f4963L ? (ViewGroup) layoutInflaterFrom.inflate(io.getgrass.www.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(io.getgrass.www.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.f4964M) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(io.getgrass.www.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.f4962K = false;
            this.f4961J = false;
        } else if (this.f4961J) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(io.getgrass.www.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C1437e(context, typedValue.resourceId) : context).inflate(io.getgrass.www.R.layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC1583e0 interfaceC1583e0 = (InterfaceC1583e0) viewGroup.findViewById(io.getgrass.www.R.id.decor_content_parent);
            this.f4997v = interfaceC1583e0;
            interfaceC1583e0.setWindowCallback(this.f4991p.getCallback());
            if (this.f4962K) {
                ((ActionBarOverlayLayout) this.f4997v).m2238j(109);
            }
            if (this.f4959H) {
                ((ActionBarOverlayLayout) this.f4997v).m2238j(2);
            }
            if (this.f4960I) {
                ((ActionBarOverlayLayout) this.f4997v).m2238j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f4961J + ", windowActionBarOverlay: " + this.f4962K + ", android:windowIsFloating: " + this.f4964M + ", windowActionModeOverlay: " + this.f4963L + ", windowNoTitle: " + this.f4965N + " }");
        }
        C1373l c1373l = new C1373l(this);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0313H.m648u(viewGroup, c1373l);
        if (this.f4997v == null) {
            this.f4957F = (TextView) viewGroup.findViewById(io.getgrass.www.R.id.title);
        }
        Method method = AbstractC1596i1.f5667a;
        try {
            Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method2.isAccessible()) {
                method2.setAccessible(true);
            }
            method2.invoke(viewGroup, null);
        } catch (IllegalAccessException e3) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e3);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e4) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e4);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(io.getgrass.www.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f4991p.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f4991p.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C1374m(this));
        this.f4956E = viewGroup;
        Object obj = this.f4989n;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f4996u;
        if (!TextUtils.isEmpty(title)) {
            InterfaceC1583e0 interfaceC1583e02 = this.f4997v;
            if (interfaceC1583e02 != null) {
                interfaceC1583e02.setWindowTitle(title);
            } else {
                C1361G c1361g = this.f4994s;
                if (c1361g != null) {
                    C1584e1 c1584e1 = (C1584e1) c1361g.f4846e;
                    if (!c1584e1.f5624g) {
                        c1584e1.f5625h = title;
                        if ((c1584e1.f5619b & 8) != 0) {
                            Toolbar toolbar = c1584e1.f5618a;
                            toolbar.setTitle(title);
                            if (c1584e1.f5624g) {
                                AbstractC0323S.m702l(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.f4957F;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f4956E.findViewById(R.id.content);
        View decorView = this.f4991p.getDecorView();
        contentFrameLayout2.f2763k.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
        if (AbstractC0310E.m620c(contentFrameLayout2)) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        typedArrayObtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(122)) {
            typedArrayObtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(123)) {
            typedArrayObtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(120)) {
            typedArrayObtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(121)) {
            typedArrayObtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f4955D = true;
        C1381t c1381tM3390z = m3390z(0);
        if (this.f4972U || c1381tM3390z.f4939h != null) {
            return;
        }
        m3372B(108);
    }

    /* JADX INFO: renamed from: x */
    public final void m3388x() {
        if (this.f4991p == null) {
            Object obj = this.f4989n;
            if (obj instanceof Activity) {
                m3381o(((Activity) obj).getWindow());
            }
        }
        if (this.f4991p == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    /* JADX INFO: renamed from: y */
    public final AbstractC0935f m3389y(Context context) {
        if (this.f4978a0 == null) {
            if (C2071i.f7311e == null) {
                Context applicationContext = context.getApplicationContext();
                LocationManager locationManager = (LocationManager) applicationContext.getSystemService("location");
                C2071i c2071i = new C2071i();
                c2071i.f7316c = new C1358D();
                c2071i.f7314a = applicationContext;
                c2071i.f7315b = locationManager;
                C2071i.f7311e = c2071i;
            }
            this.f4978a0 = new C1379r(this, C2071i.f7311e);
        }
        return this.f4978a0;
    }

    /* JADX INFO: renamed from: z */
    public final C1381t m3390z(int i3) {
        C1381t[] c1381tArr = this.f4967P;
        if (c1381tArr == null || c1381tArr.length <= i3) {
            C1381t[] c1381tArr2 = new C1381t[i3 + 1];
            if (c1381tArr != null) {
                System.arraycopy(c1381tArr, 0, c1381tArr2, 0, c1381tArr.length);
            }
            this.f4967P = c1381tArr2;
            c1381tArr = c1381tArr2;
        }
        C1381t c1381t = c1381tArr[i3];
        if (c1381t != null) {
            return c1381t;
        }
        C1381t c1381t2 = new C1381t();
        c1381t2.f4932a = i3;
        c1381t2.f4945n = false;
        c1381tArr[i3] = c1381t2;
        return c1381t2;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}

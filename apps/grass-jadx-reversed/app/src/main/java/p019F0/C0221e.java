package p019F0;

import android.animation.Animator;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputContentInfo;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.activity.result.InterfaceC0882c;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.C0915A;
import androidx.fragment.app.C0918D;
import androidx.fragment.app.C0928N;
import androidx.fragment.app.C0946q;
import com.facebook.C1111h;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p010C0.AbstractC0147a;
import p015D2.C0191o;
import p016E1.AbstractC0207e;
import p018F.InterfaceC0209a;
import p020F2.AbstractC0223a;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p029J.InterfaceC0341f;
import p032K.InterfaceC0402t;
import p036L0.C0444d;
import p039M0.AbstractC0493h0;
import p043N1.InterfaceC0562d;
import p051Q1.C0601b;
import p062U1.C0664f;
import p073Z.AbstractC0763I;
import p073Z.C0764J;
import p073Z.InterfaceC0795h0;
import p102h0.InterfaceC1412l;
import p108j.InterfaceC1477k;
import p108j.MenuC1479m;
import p110k.C1594i;
import p110k.InterfaceC1601l;
import p117m0.C1718m;
import p118m1.InterfaceC1737b;
import p119m2.AbstractC1766e;
import p149u1.InterfaceC1947a;
import p166z0.C2070h;
import p166z0.C2071i;
import p166z0.InterfaceC2059H;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: F0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0221e implements InterfaceC0341f, InterfaceC0562d, InterfaceC0795h0, InterfaceC0209a, InterfaceC0882c, InterfaceC1737b, InterfaceC1412l, InterfaceC1477k, InterfaceC0402t, InterfaceC1947a, InterfaceC2059H {

    /* JADX INFO: renamed from: g */
    public static C0221e f532g;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f533e;

    /* JADX INFO: renamed from: f */
    public Object f534f;

    public /* synthetic */ C0221e(int i3, Object obj) {
        this.f533e = i3;
        this.f534f = obj;
    }

    /* JADX INFO: renamed from: u */
    public static String m438u(Context context) {
        if (AbstractC0147a.f354a.contains(C1718m.class)) {
            return null;
        }
        try {
            if (C1718m.f6002e == null) {
                synchronized (C1718m.f6001d) {
                    try {
                        if (C1718m.f6002e == null) {
                            String string = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                            C1718m.f6002e = string;
                            if (string == null) {
                                C1718m.f6002e = "XZ" + UUID.randomUUID().toString();
                                context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", C1718m.f6002e).apply();
                            }
                        }
                    } finally {
                    }
                }
            }
            return C1718m.f6002e;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1718m.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: x */
    public static C0221e m439x(C0221e c0221e, C0221e c0221e2) {
        HashMap map;
        HashMap map2;
        if (c0221e == null || (map = (HashMap) c0221e.f534f) == null || map.isEmpty()) {
            return c0221e2;
        }
        if (c0221e2 == null || (map2 = (HashMap) c0221e2.f534f) == null || map2.isEmpty()) {
            return c0221e;
        }
        HashMap map3 = new HashMap();
        for (Annotation annotation : ((HashMap) c0221e2.f534f).values()) {
            map3.put(annotation.annotationType(), annotation);
        }
        for (Annotation annotation2 : ((HashMap) c0221e.f534f).values()) {
            map3.put(annotation2.annotationType(), annotation2);
        }
        return new C0221e(14, map3);
    }

    /* JADX INFO: renamed from: y */
    public static C0221e m440y(Context context) {
        C0221e c0221e = new C0221e(20, false);
        c0221e.f534f = new C1718m(context, (String) null);
        return c0221e;
    }

    /* JADX INFO: renamed from: A */
    public void m441A() {
        ((InputContentInfo) this.f534f).requestPermission();
    }

    @Override // p118m1.InterfaceC1737b
    /* JADX INFO: renamed from: a */
    public Annotation mo442a(Class cls) {
        HashMap map = (HashMap) this.f534f;
        if (map == null) {
            return null;
        }
        return (Annotation) map.get(cls);
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: b */
    public ClipData mo443b() {
        return ((ContentInfo) this.f534f).getClip();
    }

    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: c */
    public void mo444c(MenuC1479m menuC1479m) {
        switch (this.f533e) {
            case 18:
                InterfaceC1477k interfaceC1477k = ((ActionMenuView) this.f534f).f2749z;
                if (interfaceC1477k != null) {
                    interfaceC1477k.mo444c(menuC1479m);
                    return;
                }
                return;
            default:
                Toolbar toolbar = (Toolbar) this.f534f;
                C1594i c1594i = toolbar.f2830e.f2747x;
                if (c1594i == null || !c1594i.m3656j()) {
                    Iterator it = ((CopyOnWriteArrayList) toolbar.f2820K.f1085e).iterator();
                    if (it.hasNext()) {
                        AbstractC0032g.m162t(it.next());
                        throw null;
                    }
                    return;
                }
                return;
        }
    }

    @Override // p102h0.InterfaceC1412l
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) AbstractC0223a.m464a(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f534f).createWebView(webView));
    }

    @Override // p108j.InterfaceC1477k
    /* JADX INFO: renamed from: d */
    public boolean mo445d(MenuC1479m menuC1479m, MenuItem menuItem) {
        switch (this.f533e) {
            case 18:
                InterfaceC1601l interfaceC1601l = ((ActionMenuView) this.f534f).f2742E;
                if (interfaceC1601l == null) {
                    return false;
                }
                Iterator it = ((CopyOnWriteArrayList) ((Toolbar) ((C0444d) interfaceC1601l).f1085e).f2820K.f1085e).iterator();
                if (!it.hasNext()) {
                    return false;
                }
                AbstractC0032g.m162t(it.next());
                throw null;
            default:
                ((Toolbar) this.f534f).getClass();
                return false;
        }
    }

    @Override // p032K.InterfaceC0402t
    /* JADX INFO: renamed from: e */
    public boolean mo338e(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f534f;
        if (!swipeDismissBehavior.mo3138r(view)) {
            return false;
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean z3 = AbstractC0308C.m607d(view) == 1;
        int i3 = swipeDismissBehavior.f4232d;
        view.offsetLeftAndRight((!(i3 == 0 && z3) && (i3 != 1 || z3)) ? view.getWidth() : -view.getWidth());
        view.setAlpha(0.0f);
        return true;
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: f */
    public int mo446f() {
        return ((ContentInfo) this.f534f).getFlags();
    }

    @Override // p102h0.InterfaceC1412l
    /* JADX INFO: renamed from: g */
    public String[] mo447g() {
        return ((WebViewProviderFactoryBoundaryInterface) this.f534f).getSupportedFeatures();
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: h */
    public ContentInfo mo448h() {
        return (ContentInfo) this.f534f;
    }

    @Override // p043N1.InterfaceC0562d
    /* JADX INFO: renamed from: i */
    public C0601b mo434i(String str, int i3, EnumMap enumMap) {
        if (i3 != 15) {
            throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(AbstractC0032g.m165w(i3)));
        }
        return ((C0664f) this.f534f).mo434i("0".concat(String.valueOf(str)), 8, enumMap);
    }

    @Override // androidx.activity.result.InterfaceC0882c
    /* JADX INFO: renamed from: j */
    public void mo449j(Object obj) {
        Map map = (Map) obj;
        ArrayList arrayList = new ArrayList(map.values());
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            iArr[i3] = ((Boolean) arrayList.get(i3)).booleanValue() ? 0 : -1;
        }
        C0918D c0918d = (C0918D) this.f534f;
        C0915A c0915a = (C0915A) c0918d.f3051w.pollFirst();
        if (c0915a == null) {
            Log.w("FragmentManager", "No permissions were requested for " + this);
            return;
        }
        C2071i c2071i = c0918d.f3031c;
        String str = c0915a.f3017e;
        if (c2071i.m4597f(str) == null) {
            Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
        }
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: k */
    public View mo450k(int i3) {
        return ((AbstractC0763I) this.f534f).m2025u(i3);
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: l */
    public int mo451l() {
        AbstractC0763I abstractC0763I = (AbstractC0763I) this.f534f;
        return abstractC0763I.f2152n - abstractC0763I.m1966B();
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: m */
    public int mo452m() {
        return ((AbstractC0763I) this.f534f).m1965A();
    }

    @Override // p029J.InterfaceC0341f
    /* JADX INFO: renamed from: n */
    public int mo453n() {
        return ((ContentInfo) this.f534f).getSource();
    }

    @Override // p118m1.InterfaceC1737b
    /* JADX INFO: renamed from: o */
    public boolean mo454o(Class[] clsArr) {
        if (((HashMap) this.f534f) != null) {
            for (Class cls : clsArr) {
                if (((HashMap) this.f534f).containsKey(cls)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: p */
    public int mo455p(View view) {
        C0764J c0764j = (C0764J) view.getLayoutParams();
        ((AbstractC0763I) this.f534f).getClass();
        return view.getRight() + ((C0764J) view.getLayoutParams()).f2155b.right + ((ViewGroup.MarginLayoutParams) c0764j).rightMargin;
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: q */
    public int mo456q(View view) {
        C0764J c0764j = (C0764J) view.getLayoutParams();
        ((AbstractC0763I) this.f534f).getClass();
        return (view.getLeft() - ((C0764J) view.getLayoutParams()).f2155b.left) - ((ViewGroup.MarginLayoutParams) c0764j).leftMargin;
    }

    @Override // p018F.InterfaceC0209a
    /* JADX INFO: renamed from: r */
    public void mo415r() {
        switch (this.f533e) {
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                ((Animator) this.f534f).end();
                break;
            default:
                ((C0928N) this.f534f).m2435a();
                break;
        }
    }

    @Override // p166z0.InterfaceC2059H
    /* JADX INFO: renamed from: s */
    public void mo59s(Bundle bundle, C1111h c1111h) {
        AbstractActivityC0947r abstractActivityC0947rM2490h = ((C2070h) this.f534f).m2490h();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        abstractActivityC0947rM2490h.setResult(-1, intent);
        abstractActivityC0947rM2490h.finish();
    }

    @Override // p118m1.InterfaceC1737b
    public int size() {
        HashMap map = (HashMap) this.f534f;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    /* JADX INFO: renamed from: t */
    public Object m457t(InterfaceC2095g interfaceC2095g, C0191o c0191o) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        Map map = (Map) ((ConcurrentHashMap) this.f534f).get(interfaceC2095g);
        Object obj = map != null ? map.get(c0191o) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }

    public String toString() {
        switch (this.f533e) {
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return "ContentInfoCompat{" + ((ContentInfo) this.f534f) + "}";
            case 14:
                HashMap map = (HashMap) this.f534f;
                return map == null ? "[null]" : map.toString();
            default:
                return super.toString();
        }
    }

    /* JADX INFO: renamed from: v */
    public int m458v() {
        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.f534f;
        return Math.max(0, sideSheetBehavior.f4451m - sideSheetBehavior.f4450l);
    }

    /* JADX INFO: renamed from: w */
    public boolean m459w(Class cls) {
        HashMap map = (HashMap) this.f534f;
        if (map == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    /* JADX INFO: renamed from: z */
    public void m460z() {
        ((C0946q) this.f534f).f3249h.m2371G();
    }

    public /* synthetic */ C0221e(int i3, boolean z3) {
        this.f533e = i3;
    }

    public C0221e(int i3) {
        this.f533e = i3;
        switch (i3) {
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                this.f534f = new C0664f(0);
                break;
            default:
                this.f534f = new ConcurrentHashMap(16);
                break;
        }
    }

    public C0221e(EditText editText) {
        this.f533e = 7;
        AbstractC0493h0.m1010c("editText cannot be null", editText);
        this.f534f = new C0009j(editText);
    }

    public C0221e(Object obj) {
        this.f533e = 6;
        this.f534f = (InputContentInfo) obj;
    }

    public C0221e(ContentInfo contentInfo) {
        this.f533e = 5;
        contentInfo.getClass();
        this.f534f = AbstractC0207e.m408f(contentInfo);
    }
}

package androidx.fragment.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.C0870e;
import androidx.activity.C0878m;
import androidx.activity.InterfaceC0866a;
import androidx.activity.InterfaceC0879n;
import androidx.activity.result.C0883d;
import androidx.activity.result.InterfaceC0887h;
import androidx.lifecycle.AbstractC0964I;
import androidx.lifecycle.C0965J;
import androidx.lifecycle.C0966K;
import androidx.lifecycle.EnumC0979l;
import androidx.lifecycle.InterfaceC0967L;
import io.getgrass.www.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p007B1.RunnableC0055o;
import p019F0.C0221e;
import p019F0.C0222f;
import p025H1.C0276e;
import p026I.InterfaceC0293a;
import p063V.C0667a;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1794d;
import p136r.AbstractC1849h;
import p166z0.C2068f;
import p166z0.C2071i;

/* JADX INFO: renamed from: androidx.fragment.app.D */
/* JADX INFO: loaded from: classes.dex */
public final class C0918D {

    /* JADX INFO: renamed from: A */
    public boolean f3022A;

    /* JADX INFO: renamed from: B */
    public boolean f3023B;

    /* JADX INFO: renamed from: C */
    public ArrayList f3024C;

    /* JADX INFO: renamed from: D */
    public ArrayList f3025D;

    /* JADX INFO: renamed from: E */
    public ArrayList f3026E;

    /* JADX INFO: renamed from: F */
    public C0920F f3027F;

    /* JADX INFO: renamed from: G */
    public final RunnableC0055o f3028G;

    /* JADX INFO: renamed from: b */
    public boolean f3030b;

    /* JADX INFO: renamed from: d */
    public ArrayList f3032d;

    /* JADX INFO: renamed from: e */
    public ArrayList f3033e;

    /* JADX INFO: renamed from: g */
    public C0878m f3035g;

    /* JADX INFO: renamed from: k */
    public final C0009j f3039k;

    /* JADX INFO: renamed from: l */
    public final CopyOnWriteArrayList f3040l;

    /* JADX INFO: renamed from: m */
    public int f3041m;

    /* JADX INFO: renamed from: n */
    public C0946q f3042n;

    /* JADX INFO: renamed from: o */
    public AbstractC1794d f3043o;

    /* JADX INFO: renamed from: p */
    public AbstractComponentCallbacksC0944o f3044p;

    /* JADX INFO: renamed from: q */
    public AbstractComponentCallbacksC0944o f3045q;

    /* JADX INFO: renamed from: r */
    public final C0953x f3046r;

    /* JADX INFO: renamed from: s */
    public final C0276e f3047s;

    /* JADX INFO: renamed from: t */
    public C0883d f3048t;

    /* JADX INFO: renamed from: u */
    public C0883d f3049u;

    /* JADX INFO: renamed from: v */
    public C0883d f3050v;

    /* JADX INFO: renamed from: w */
    public ArrayDeque f3051w;

    /* JADX INFO: renamed from: x */
    public boolean f3052x;

    /* JADX INFO: renamed from: y */
    public boolean f3053y;

    /* JADX INFO: renamed from: z */
    public boolean f3054z;

    /* JADX INFO: renamed from: a */
    public final ArrayList f3029a = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final C2071i f3031c = new C2071i(3);

    /* JADX INFO: renamed from: f */
    public final LayoutInflaterFactory2C0950u f3034f = new LayoutInflaterFactory2C0950u(this);

    /* JADX INFO: renamed from: h */
    public final C0952w f3036h = new C0952w(this);

    /* JADX INFO: renamed from: i */
    public final AtomicInteger f3037i = new AtomicInteger();

    /* JADX INFO: renamed from: j */
    public final Map f3038j = Collections.synchronizedMap(new HashMap());

    public C0918D() {
        Collections.synchronizedMap(new HashMap());
        Collections.synchronizedMap(new HashMap());
        new C0222f(7, this);
        this.f3039k = new C0009j(this);
        this.f3040l = new CopyOnWriteArrayList();
        this.f3041m = -1;
        this.f3046r = new C0953x(this);
        this.f3047s = new C0276e(7);
        this.f3051w = new ArrayDeque();
        this.f3028G = new RunnableC0055o(12, this);
    }

    /* JADX INFO: renamed from: C */
    public static boolean m2364C(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        abstractComponentCallbacksC0944o.getClass();
        boolean zM2364C = false;
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 : abstractComponentCallbacksC0944o.f3241x.f3031c.m4599i()) {
            if (abstractComponentCallbacksC0944o2 != null) {
                zM2364C = m2364C(abstractComponentCallbacksC0944o2);
            }
            if (zM2364C) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: D */
    public static boolean m2365D(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (abstractComponentCallbacksC0944o == null) {
            return true;
        }
        return abstractComponentCallbacksC0944o.f3207G && (abstractComponentCallbacksC0944o.f3239v == null || m2365D(abstractComponentCallbacksC0944o.f3242y));
    }

    /* JADX INFO: renamed from: E */
    public static boolean m2366E(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (abstractComponentCallbacksC0944o == null) {
            return true;
        }
        C0918D c0918d = abstractComponentCallbacksC0944o.f3239v;
        return abstractComponentCallbacksC0944o.equals(c0918d.f3045q) && m2366E(c0918d.f3044p);
    }

    /* JADX INFO: renamed from: S */
    public static void m2367S(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "show: " + abstractComponentCallbacksC0944o);
        }
        if (abstractComponentCallbacksC0944o.f3203C) {
            abstractComponentCallbacksC0944o.f3203C = false;
            abstractComponentCallbacksC0944o.f3214N = !abstractComponentCallbacksC0944o.f3214N;
        }
    }

    /* JADX INFO: renamed from: A */
    public final C0276e m2368A() {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3044p;
        return abstractComponentCallbacksC0944o != null ? abstractComponentCallbacksC0944o.f3239v.m2368A() : this.f3047s;
    }

    /* JADX INFO: renamed from: B */
    public final void m2369B(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "hide: " + abstractComponentCallbacksC0944o);
        }
        if (abstractComponentCallbacksC0944o.f3203C) {
            return;
        }
        abstractComponentCallbacksC0944o.f3203C = true;
        abstractComponentCallbacksC0944o.f3214N = true ^ abstractComponentCallbacksC0944o.f3214N;
        m2382R(abstractComponentCallbacksC0944o);
    }

    /* JADX INFO: renamed from: F */
    public final void m2370F(int i3, boolean z3) {
        HashMap map;
        C0946q c0946q;
        if (this.f3042n == null && i3 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z3 || i3 != this.f3041m) {
            this.f3041m = i3;
            C2071i c2071i = this.f3031c;
            Iterator it = ((ArrayList) c2071i.f7314a).iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                map = (HashMap) c2071i.f7315b;
                if (!zHasNext) {
                    break;
                }
                C0923I c0923i = (C0923I) map.get(((AbstractComponentCallbacksC0944o) it.next()).f3226i);
                if (c0923i != null) {
                    c0923i.m2425k();
                }
            }
            for (C0923I c0923i2 : map.values()) {
                if (c0923i2 != null) {
                    c0923i2.m2425k();
                    AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i2.f3090c;
                    if (abstractComponentCallbacksC0944o.f3233p && abstractComponentCallbacksC0944o.f3238u <= 0) {
                        c2071i.m4607s(c0923i2);
                    }
                }
            }
            m2383T();
            if (this.f3052x && (c0946q = this.f3042n) != null && this.f3041m == 7) {
                c0946q.f3250i.mo2206l();
                this.f3052x = false;
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m2371G() {
        if (this.f3042n == null) {
            return;
        }
        this.f3053y = false;
        this.f3054z = false;
        this.f3027F.f3069h = false;
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.f3241x.m2371G();
            }
        }
    }

    /* JADX INFO: renamed from: H */
    public final boolean m2372H() {
        m2404t(false);
        m2403s(true);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3045q;
        if (abstractComponentCallbacksC0944o != null && abstractComponentCallbacksC0944o.m2491i().m2372H()) {
            return true;
        }
        boolean zM2373I = m2373I(this.f3024C, this.f3025D, -1, 0);
        if (zM2373I) {
            this.f3030b = true;
            try {
                m2375K(this.f3024C, this.f3025D);
            } finally {
                m2388d();
            }
        }
        m2384U();
        if (this.f3023B) {
            this.f3023B = false;
            m2383T();
        }
        ((HashMap) this.f3031c.f7315b).values().removeAll(Collections.singleton(null));
        return zM2373I;
    }

    /* JADX INFO: renamed from: I */
    public final boolean m2373I(ArrayList arrayList, ArrayList arrayList2, int i3, int i4) {
        int size;
        C0930a c0930a;
        ArrayList arrayList3 = this.f3032d;
        if (arrayList3 == null) {
            return false;
        }
        if (i3 >= 0 || (i4 & 1) != 0) {
            if (i3 >= 0) {
                size = arrayList3.size() - 1;
                while (size >= 0) {
                    C0930a c0930a2 = (C0930a) this.f3032d.get(size);
                    if (i3 >= 0 && i3 == c0930a2.f3134r) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i4 & 1) != 0) {
                    do {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        c0930a = (C0930a) this.f3032d.get(size);
                        if (i3 < 0) {
                            break;
                        }
                    } while (i3 == c0930a.f3134r);
                }
            } else {
                size = -1;
            }
            if (size == this.f3032d.size() - 1) {
                return false;
            }
            for (int size2 = this.f3032d.size() - 1; size2 > size; size2--) {
                arrayList.add(this.f3032d.remove(size2));
                arrayList2.add(Boolean.TRUE);
            }
        } else {
            int size3 = arrayList3.size() - 1;
            if (size3 < 0) {
                return false;
            }
            arrayList.add(this.f3032d.remove(size3));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    /* JADX INFO: renamed from: J */
    public final void m2374J(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "remove: " + abstractComponentCallbacksC0944o + " nesting=" + abstractComponentCallbacksC0944o.f3238u);
        }
        boolean z3 = !(abstractComponentCallbacksC0944o.f3238u > 0);
        if (!abstractComponentCallbacksC0944o.f3204D || z3) {
            C2071i c2071i = this.f3031c;
            synchronized (((ArrayList) c2071i.f7314a)) {
                ((ArrayList) c2071i.f7314a).remove(abstractComponentCallbacksC0944o);
            }
            abstractComponentCallbacksC0944o.f3232o = false;
            if (m2364C(abstractComponentCallbacksC0944o)) {
                this.f3052x = true;
            }
            abstractComponentCallbacksC0944o.f3233p = true;
            m2382R(abstractComponentCallbacksC0944o);
        }
    }

    /* JADX INFO: renamed from: K */
    public final void m2375K(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            if (!((C0930a) arrayList.get(i3)).f3131o) {
                if (i4 != i3) {
                    m2405u(arrayList, arrayList2, i4, i3);
                }
                i4 = i3 + 1;
                if (((Boolean) arrayList2.get(i3)).booleanValue()) {
                    while (i4 < size && ((Boolean) arrayList2.get(i4)).booleanValue() && !((C0930a) arrayList.get(i4)).f3131o) {
                        i4++;
                    }
                }
                m2405u(arrayList, arrayList2, i3, i4);
                i3 = i4 - 1;
            }
            i3++;
        }
        if (i4 != size) {
            m2405u(arrayList, arrayList2, i4, size);
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m2376L(Parcelable parcelable) {
        int i3;
        C0009j c0009j;
        int i4;
        C0923I c0923i;
        if (parcelable == null) {
            return;
        }
        C0919E c0919e = (C0919E) parcelable;
        if (c0919e.f3055e == null) {
            return;
        }
        C2071i c2071i = this.f3031c;
        ((HashMap) c2071i.f7315b).clear();
        Iterator it = c0919e.f3055e.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            i3 = 2;
            c0009j = this.f3039k;
            if (!zHasNext) {
                break;
            }
            C0922H c0922h = (C0922H) it.next();
            if (c0922h != null) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = (AbstractComponentCallbacksC0944o) this.f3027F.f3064c.get(c0922h.f3076f);
                if (abstractComponentCallbacksC0944o != null) {
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + abstractComponentCallbacksC0944o);
                    }
                    c0923i = new C0923I(c0009j, c2071i, abstractComponentCallbacksC0944o, c0922h);
                } else {
                    c0923i = new C0923I(this.f3039k, this.f3031c, this.f3042n.f3247f.getClassLoader(), m2410z(), c0922h);
                }
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = c0923i.f3090c;
                abstractComponentCallbacksC0944o2.f3239v = this;
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + abstractComponentCallbacksC0944o2.f3226i + "): " + abstractComponentCallbacksC0944o2);
                }
                c0923i.m2427m(this.f3042n.f3247f.getClassLoader());
                c2071i.m4606r(c0923i);
                c0923i.f3092e = this.f3041m;
            }
        }
        C0920F c0920f = this.f3027F;
        c0920f.getClass();
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o3 : new ArrayList(c0920f.f3064c.values())) {
            if (!(((HashMap) c2071i.f7315b).get(abstractComponentCallbacksC0944o3.f3226i) != null)) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + abstractComponentCallbacksC0944o3 + " that was not found in the set of active Fragments " + c0919e.f3055e);
                }
                this.f3027F.m2412c(abstractComponentCallbacksC0944o3);
                abstractComponentCallbacksC0944o3.f3239v = this;
                C0923I c0923i2 = new C0923I(c0009j, c2071i, abstractComponentCallbacksC0944o3);
                c0923i2.f3092e = 1;
                c0923i2.m2425k();
                abstractComponentCallbacksC0944o3.f3233p = true;
                c0923i2.m2425k();
            }
        }
        ArrayList<String> arrayList = c0919e.f3056f;
        ((ArrayList) c2071i.f7314a).clear();
        if (arrayList != null) {
            for (String str : arrayList) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM4596e = c2071i.m4596e(str);
                if (abstractComponentCallbacksC0944oM4596e == null) {
                    throw new IllegalStateException(AbstractC0032g.m154l("No instantiated fragment for (", str, ")"));
                }
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + abstractComponentCallbacksC0944oM4596e);
                }
                c2071i.m4594b(abstractComponentCallbacksC0944oM4596e);
            }
        }
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o4 = null;
        if (c0919e.f3057g != null) {
            this.f3032d = new ArrayList(c0919e.f3057g.length);
            int i5 = 0;
            while (true) {
                C0931b[] c0931bArr = c0919e.f3057g;
                if (i5 >= c0931bArr.length) {
                    break;
                }
                C0931b c0931b = c0931bArr[i5];
                c0931b.getClass();
                C0930a c0930a = new C0930a(this);
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    int[] iArr = c0931b.f3135e;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    C0924J c0924j = new C0924J();
                    int i8 = i6 + 1;
                    c0924j.f3093a = iArr[i6];
                    if (Log.isLoggable("FragmentManager", i3)) {
                        Log.v("FragmentManager", "Instantiate " + c0930a + " op #" + i7 + " base fragment #" + iArr[i8]);
                    }
                    String str2 = (String) c0931b.f3136f.get(i7);
                    if (str2 != null) {
                        c0924j.f3094b = c2071i.m4596e(str2);
                    } else {
                        c0924j.f3094b = abstractComponentCallbacksC0944o4;
                    }
                    c0924j.f3099g = EnumC0979l.values()[c0931b.f3137g[i7]];
                    c0924j.f3100h = EnumC0979l.values()[c0931b.f3138h[i7]];
                    int i9 = iArr[i8];
                    c0924j.f3095c = i9;
                    int i10 = iArr[i6 + 2];
                    c0924j.f3096d = i10;
                    int i11 = i6 + 4;
                    int i12 = iArr[i6 + 3];
                    c0924j.f3097e = i12;
                    i6 += 5;
                    int i13 = iArr[i11];
                    c0924j.f3098f = i13;
                    c0930a.f3118b = i9;
                    c0930a.f3119c = i10;
                    c0930a.f3120d = i12;
                    c0930a.f3121e = i13;
                    c0930a.m2439b(c0924j);
                    i7++;
                    abstractComponentCallbacksC0944o4 = null;
                    i3 = 2;
                }
                c0930a.f3122f = c0931b.f3139i;
                c0930a.f3124h = c0931b.f3140j;
                c0930a.f3134r = c0931b.f3141k;
                c0930a.f3123g = true;
                c0930a.f3125i = c0931b.f3142l;
                c0930a.f3126j = c0931b.f3143m;
                c0930a.f3127k = c0931b.f3144n;
                c0930a.f3128l = c0931b.f3145o;
                c0930a.f3129m = c0931b.f3146p;
                c0930a.f3130n = c0931b.f3147q;
                c0930a.f3131o = c0931b.f3148r;
                c0930a.m2440c(1);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + c0930a.f3134r + "): " + c0930a);
                    PrintWriter printWriter = new PrintWriter(new C0926L());
                    c0930a.m2443f("  ", printWriter, false);
                    printWriter.close();
                }
                this.f3032d.add(c0930a);
                i5++;
                i3 = 2;
                abstractComponentCallbacksC0944o4 = null;
            }
            i4 = 0;
        } else {
            i4 = 0;
            this.f3032d = null;
        }
        this.f3037i.set(c0919e.f3058h);
        String str3 = c0919e.f3059i;
        if (str3 != null) {
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM4596e2 = c2071i.m4596e(str3);
            this.f3045q = abstractComponentCallbacksC0944oM4596e2;
            m2398n(abstractComponentCallbacksC0944oM4596e2);
        }
        ArrayList arrayList2 = c0919e.f3060j;
        if (arrayList2 != null) {
            while (i4 < arrayList2.size()) {
                Bundle bundle = (Bundle) c0919e.f3061k.get(i4);
                bundle.setClassLoader(this.f3042n.f3247f.getClassLoader());
                this.f3038j.put(arrayList2.get(i4), bundle);
                i4++;
            }
        }
        this.f3051w = new ArrayDeque(c0919e.f3062l);
    }

    /* JADX INFO: renamed from: M */
    public final C0919E m2377M() {
        int i3;
        ArrayList arrayList;
        C0931b[] c0931bArr;
        int size;
        Iterator it = m2389e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0937h c0937h = (C0937h) it.next();
            if (c0937h.f3166e) {
                c0937h.f3166e = false;
                c0937h.m2459c();
            }
        }
        Iterator it2 = m2389e().iterator();
        while (it2.hasNext()) {
            ((C0937h) it2.next()).m2461e();
        }
        m2404t(true);
        this.f3053y = true;
        this.f3027F.f3069h = true;
        C2071i c2071i = this.f3031c;
        c2071i.getClass();
        HashMap map = (HashMap) c2071i.f7315b;
        ArrayList arrayList2 = new ArrayList(map.size());
        Iterator it3 = map.values().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            C0923I c0923i = (C0923I) it3.next();
            if (c0923i != null) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
                C0922H c0922h = new C0922H(abstractComponentCallbacksC0944o);
                if (abstractComponentCallbacksC0944o.f3222e <= -1 || c0922h.f3087q != null) {
                    c0922h.f3087q = abstractComponentCallbacksC0944o.f3223f;
                } else {
                    Bundle bundle = new Bundle();
                    abstractComponentCallbacksC0944o.mo502y(bundle);
                    abstractComponentCallbacksC0944o.f3220T.m2185c(bundle);
                    C0919E c0919eM2377M = abstractComponentCallbacksC0944o.f3241x.m2377M();
                    if (c0919eM2377M != null) {
                        bundle.putParcelable("android:support:fragments", c0919eM2377M);
                    }
                    c0923i.f3088a.m58r(false);
                    Bundle bundle2 = bundle.isEmpty() ? null : bundle;
                    if (abstractComponentCallbacksC0944o.f3210J != null) {
                        c0923i.m2429o();
                    }
                    if (abstractComponentCallbacksC0944o.f3224g != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putSparseParcelableArray("android:view_state", abstractComponentCallbacksC0944o.f3224g);
                    }
                    if (abstractComponentCallbacksC0944o.f3225h != null) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBundle("android:view_registry_state", abstractComponentCallbacksC0944o.f3225h);
                    }
                    if (!abstractComponentCallbacksC0944o.f3212L) {
                        if (bundle2 == null) {
                            bundle2 = new Bundle();
                        }
                        bundle2.putBoolean("android:user_visible_hint", abstractComponentCallbacksC0944o.f3212L);
                    }
                    c0922h.f3087q = bundle2;
                    if (abstractComponentCallbacksC0944o.f3229l != null) {
                        if (bundle2 == null) {
                            c0922h.f3087q = new Bundle();
                        }
                        c0922h.f3087q.putString("android:target_state", abstractComponentCallbacksC0944o.f3229l);
                        int i4 = abstractComponentCallbacksC0944o.f3230m;
                        if (i4 != 0) {
                            c0922h.f3087q.putInt("android:target_req_state", i4);
                        }
                    }
                }
                arrayList2.add(c0922h);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Saved state of " + abstractComponentCallbacksC0944o + ": " + c0922h.f3087q);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        C2071i c2071i2 = this.f3031c;
        synchronized (((ArrayList) c2071i2.f7314a)) {
            try {
                if (((ArrayList) c2071i2.f7314a).isEmpty()) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(((ArrayList) c2071i2.f7314a).size());
                    for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 : (ArrayList) c2071i2.f7314a) {
                        arrayList.add(abstractComponentCallbacksC0944o2.f3226i);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "saveAllState: adding fragment (" + abstractComponentCallbacksC0944o2.f3226i + "): " + abstractComponentCallbacksC0944o2);
                        }
                    }
                }
            } finally {
            }
        }
        ArrayList arrayList3 = this.f3032d;
        if (arrayList3 == null || (size = arrayList3.size()) <= 0) {
            c0931bArr = null;
        } else {
            c0931bArr = new C0931b[size];
            for (i3 = 0; i3 < size; i3++) {
                c0931bArr[i3] = new C0931b((C0930a) this.f3032d.get(i3));
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f3032d.get(i3));
                }
            }
        }
        C0919E c0919e = new C0919E();
        c0919e.f3059i = null;
        ArrayList arrayList4 = new ArrayList();
        c0919e.f3060j = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        c0919e.f3061k = arrayList5;
        c0919e.f3055e = arrayList2;
        c0919e.f3056f = arrayList;
        c0919e.f3057g = c0931bArr;
        c0919e.f3058h = this.f3037i.get();
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o3 = this.f3045q;
        if (abstractComponentCallbacksC0944o3 != null) {
            c0919e.f3059i = abstractComponentCallbacksC0944o3.f3226i;
        }
        arrayList4.addAll(this.f3038j.keySet());
        arrayList5.addAll(this.f3038j.values());
        c0919e.f3062l = new ArrayList(this.f3051w);
        return c0919e;
    }

    /* JADX INFO: renamed from: N */
    public final void m2378N() {
        synchronized (this.f3029a) {
            try {
                if (this.f3029a.size() == 1) {
                    this.f3042n.f3248g.removeCallbacks(this.f3028G);
                    this.f3042n.f3248g.post(this.f3028G);
                    m2384U();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m2379O(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o, boolean z3) {
        ViewGroup viewGroupM2409y = m2409y(abstractComponentCallbacksC0944o);
        if (viewGroupM2409y == null || !(viewGroupM2409y instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupM2409y).setDrawDisappearingViewsLast(!z3);
    }

    /* JADX INFO: renamed from: P */
    public final void m2380P(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o, EnumC0979l enumC0979l) {
        if (abstractComponentCallbacksC0944o.equals(this.f3031c.m4596e(abstractComponentCallbacksC0944o.f3226i)) && (abstractComponentCallbacksC0944o.f3240w == null || abstractComponentCallbacksC0944o.f3239v == this)) {
            abstractComponentCallbacksC0944o.f3216P = enumC0979l;
            return;
        }
        throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0944o + " is not an active fragment of FragmentManager " + this);
    }

    /* JADX INFO: renamed from: Q */
    public final void m2381Q(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (abstractComponentCallbacksC0944o != null) {
            if (!abstractComponentCallbacksC0944o.equals(this.f3031c.m4596e(abstractComponentCallbacksC0944o.f3226i)) || (abstractComponentCallbacksC0944o.f3240w != null && abstractComponentCallbacksC0944o.f3239v != this)) {
                throw new IllegalArgumentException("Fragment " + abstractComponentCallbacksC0944o + " is not an active fragment of FragmentManager " + this);
            }
        }
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = this.f3045q;
        this.f3045q = abstractComponentCallbacksC0944o;
        m2398n(abstractComponentCallbacksC0944o2);
        m2398n(this.f3045q);
    }

    /* JADX INFO: renamed from: R */
    public final void m2382R(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        ViewGroup viewGroupM2409y = m2409y(abstractComponentCallbacksC0944o);
        if (viewGroupM2409y != null) {
            C0943n c0943n = abstractComponentCallbacksC0944o.f3213M;
            if ((c0943n == null ? 0 : c0943n.f3193e) + (c0943n == null ? 0 : c0943n.f3192d) + (c0943n == null ? 0 : c0943n.f3191c) + (c0943n == null ? 0 : c0943n.f3190b) > 0) {
                if (viewGroupM2409y.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    viewGroupM2409y.setTag(R.id.visible_removing_fragment_view_tag, abstractComponentCallbacksC0944o);
                }
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = (AbstractComponentCallbacksC0944o) viewGroupM2409y.getTag(R.id.visible_removing_fragment_view_tag);
                C0943n c0943n2 = abstractComponentCallbacksC0944o.f3213M;
                boolean z3 = c0943n2 != null ? c0943n2.f3189a : false;
                if (abstractComponentCallbacksC0944o2.f3213M == null) {
                    return;
                }
                abstractComponentCallbacksC0944o2.m2489g().f3189a = z3;
            }
        }
    }

    /* JADX INFO: renamed from: T */
    public final void m2383T() {
        for (C0923I c0923i : this.f3031c.m4598h()) {
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
            if (abstractComponentCallbacksC0944o.f3211K) {
                if (this.f3030b) {
                    this.f3023B = true;
                } else {
                    abstractComponentCallbacksC0944o.f3211K = false;
                    c0923i.m2425k();
                }
            }
        }
    }

    /* JADX INFO: renamed from: U */
    public final void m2384U() {
        synchronized (this.f3029a) {
            try {
                if (!this.f3029a.isEmpty()) {
                    C0952w c0952w = this.f3036h;
                    c0952w.f3266a = true;
                    InterfaceC0293a interfaceC0293a = c0952w.f3268c;
                    if (interfaceC0293a != null) {
                        interfaceC0293a.mo474a(Boolean.TRUE);
                    }
                    return;
                }
                C0952w c0952w2 = this.f3036h;
                ArrayList arrayList = this.f3032d;
                boolean z3 = (arrayList != null ? arrayList.size() : 0) > 0 && m2366E(this.f3044p);
                c0952w2.f3266a = z3;
                InterfaceC0293a interfaceC0293a2 = c0952w2.f3268c;
                if (interfaceC0293a2 != null) {
                    interfaceC0293a2.mo474a(Boolean.valueOf(z3));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final C0923I m2385a(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "add: " + abstractComponentCallbacksC0944o);
        }
        C0923I c0923iM2390f = m2390f(abstractComponentCallbacksC0944o);
        abstractComponentCallbacksC0944o.f3239v = this;
        C2071i c2071i = this.f3031c;
        c2071i.m4606r(c0923iM2390f);
        if (!abstractComponentCallbacksC0944o.f3204D) {
            c2071i.m4594b(abstractComponentCallbacksC0944o);
            abstractComponentCallbacksC0944o.f3233p = false;
            if (abstractComponentCallbacksC0944o.f3210J == null) {
                abstractComponentCallbacksC0944o.f3214N = false;
            }
            if (m2364C(abstractComponentCallbacksC0944o)) {
                this.f3052x = true;
            }
        }
        return c0923iM2390f;
    }

    /* JADX INFO: renamed from: b */
    public final void m2386b(C0946q c0946q, AbstractC1794d abstractC1794d, AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        AbstractC0964I abstractC0964IM4576e;
        if (this.f3042n != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f3042n = c0946q;
        this.f3043o = abstractC1794d;
        this.f3044p = abstractComponentCallbacksC0944o;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f3040l;
        if (abstractComponentCallbacksC0944o != null) {
            copyOnWriteArrayList.add(new C0954y(abstractComponentCallbacksC0944o));
        } else if (c0946q instanceof InterfaceC0921G) {
            copyOnWriteArrayList.add(c0946q);
        }
        if (this.f3044p != null) {
            m2384U();
        }
        if (c0946q instanceof InterfaceC0879n) {
            C0878m c0878m = c0946q.f3250i.f2603k;
            this.f3035g = c0878m;
            c0878m.m2210a(abstractComponentCallbacksC0944o != null ? abstractComponentCallbacksC0944o : c0946q, this.f3036h);
        }
        if (abstractComponentCallbacksC0944o != null) {
            C0920F c0920f = abstractComponentCallbacksC0944o.f3239v.f3027F;
            HashMap map = c0920f.f3065d;
            C0920F c0920f2 = (C0920F) map.get(abstractComponentCallbacksC0944o.f3226i);
            if (c0920f2 == null) {
                c0920f2 = new C0920F(c0920f.f3067f);
                map.put(abstractComponentCallbacksC0944o.f3226i, c0920f2);
            }
            this.f3027F = c0920f2;
        } else if (c0946q instanceof InterfaceC0967L) {
            C0966K c0966kMo2198c = c0946q.f3250i.mo2198c();
            AbstractC1766e.m3920e("store", c0966kMo2198c);
            C0667a c0667a = C0667a.f1819b;
            AbstractC1766e.m3920e("defaultCreationExtras", c0667a);
            C2068f c2068f = C0920F.f3063i;
            String canonicalName = C0920F.class.getCanonicalName();
            if (canonicalName == null) {
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            }
            String strConcat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
            AbstractC1766e.m3920e("key", strConcat);
            HashMap map2 = c0966kMo2198c.f3303a;
            AbstractC0964I abstractC0964I = (AbstractC0964I) map2.get(strConcat);
            if (!C0920F.class.isInstance(abstractC0964I)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.putAll(c0667a.f1820a);
                linkedHashMap.put(C0965J.f3302b, strConcat);
                try {
                    abstractC0964IM4576e = c2068f.m4576e(C0920F.class);
                } catch (AbstractMethodError unused) {
                    abstractC0964IM4576e = c2068f.m4576e(C0920F.class);
                }
                abstractC0964I = abstractC0964IM4576e;
                AbstractC0964I abstractC0964I2 = (AbstractC0964I) map2.put(strConcat, abstractC0964I);
                if (abstractC0964I2 != null) {
                    abstractC0964I2.mo1631a();
                }
            } else if (abstractC0964I == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            }
            this.f3027F = (C0920F) abstractC0964I;
        } else {
            this.f3027F = new C0920F(false);
        }
        C0920F c0920f3 = this.f3027F;
        c0920f3.f3069h = this.f3053y || this.f3054z;
        this.f3031c.f7316c = c0920f3;
        C0946q c0946q2 = this.f3042n;
        if (c0946q2 instanceof InterfaceC0887h) {
            C0870e c0870e = c0946q2.f3250i.f2605m;
            String strM152j = AbstractC0032g.m152j("FragmentManager:", abstractComponentCallbacksC0944o != null ? AbstractC0032g.m157o(new StringBuilder(), abstractComponentCallbacksC0944o.f3226i, ":") : "");
            this.f3048t = c0870e.m2215c(AbstractC1849h.m4117a(strM152j, "StartActivityForResult"), new C0955z(2), new C0951v(this, 1));
            this.f3049u = c0870e.m2215c(AbstractC1849h.m4117a(strM152j, "StartIntentSenderForResult"), new C0955z(0), new C0951v(this, 0));
            this.f3050v = c0870e.m2215c(AbstractC1849h.m4117a(strM152j, "RequestPermissions"), new C0955z(1), new C0221e(12, this));
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2387c(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "attach: " + abstractComponentCallbacksC0944o);
        }
        if (abstractComponentCallbacksC0944o.f3204D) {
            abstractComponentCallbacksC0944o.f3204D = false;
            if (abstractComponentCallbacksC0944o.f3232o) {
                return;
            }
            this.f3031c.m4594b(abstractComponentCallbacksC0944o);
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "add from attach: " + abstractComponentCallbacksC0944o);
            }
            if (m2364C(abstractComponentCallbacksC0944o)) {
                this.f3052x = true;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m2388d() {
        this.f3030b = false;
        this.f3025D.clear();
        this.f3024C.clear();
    }

    /* JADX INFO: renamed from: e */
    public final HashSet m2389e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f3031c.m4598h().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((C0923I) it.next()).f3090c.f3209I;
            if (viewGroup != null) {
                hashSet.add(C0937h.m2456f(viewGroup, m2368A()));
            }
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: f */
    public final C0923I m2390f(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        String str = abstractComponentCallbacksC0944o.f3226i;
        C2071i c2071i = this.f3031c;
        C0923I c0923i = (C0923I) ((HashMap) c2071i.f7315b).get(str);
        if (c0923i != null) {
            return c0923i;
        }
        C0923I c0923i2 = new C0923I(this.f3039k, c2071i, abstractComponentCallbacksC0944o);
        c0923i2.m2427m(this.f3042n.f3247f.getClassLoader());
        c0923i2.f3092e = this.f3041m;
        return c0923i2;
    }

    /* JADX INFO: renamed from: g */
    public final void m2391g(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "detach: " + abstractComponentCallbacksC0944o);
        }
        if (abstractComponentCallbacksC0944o.f3204D) {
            return;
        }
        abstractComponentCallbacksC0944o.f3204D = true;
        if (abstractComponentCallbacksC0944o.f3232o) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "remove from detach: " + abstractComponentCallbacksC0944o);
            }
            C2071i c2071i = this.f3031c;
            synchronized (((ArrayList) c2071i.f7314a)) {
                ((ArrayList) c2071i.f7314a).remove(abstractComponentCallbacksC0944o);
            }
            abstractComponentCallbacksC0944o.f3232o = false;
            if (m2364C(abstractComponentCallbacksC0944o)) {
                this.f3052x = true;
            }
            m2382R(abstractComponentCallbacksC0944o);
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m2392h(Configuration configuration) {
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.onConfigurationChanged(configuration);
                abstractComponentCallbacksC0944o.f3241x.m2392h(configuration);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final boolean m2393i() {
        if (this.f3041m < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                if (!abstractComponentCallbacksC0944o.f3203C ? abstractComponentCallbacksC0944o.f3241x.m2393i() : false) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m2394j() {
        if (this.f3041m < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z3 = false;
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null && m2365D(abstractComponentCallbacksC0944o)) {
                if (!abstractComponentCallbacksC0944o.f3203C ? abstractComponentCallbacksC0944o.f3241x.m2394j() : false) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(abstractComponentCallbacksC0944o);
                    z3 = true;
                }
            }
        }
        if (this.f3033e != null) {
            for (int i3 = 0; i3 < this.f3033e.size(); i3++) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = (AbstractComponentCallbacksC0944o) this.f3033e.get(i3);
                if (arrayList == null || !arrayList.contains(abstractComponentCallbacksC0944o2)) {
                    abstractComponentCallbacksC0944o2.getClass();
                }
            }
        }
        this.f3033e = arrayList;
        return z3;
    }

    /* JADX INFO: renamed from: k */
    public final void m2395k() {
        this.f3022A = true;
        m2404t(true);
        Iterator it = m2389e().iterator();
        while (it.hasNext()) {
            ((C0937h) it.next()).m2461e();
        }
        m2400p(-1);
        this.f3042n = null;
        this.f3043o = null;
        this.f3044p = null;
        if (this.f3035g != null) {
            Iterator it2 = this.f3036h.f3267b.iterator();
            while (it2.hasNext()) {
                ((InterfaceC0866a) it2.next()).cancel();
            }
            this.f3035g = null;
        }
        C0883d c0883d = this.f3048t;
        if (c0883d != null) {
            c0883d.f2632f.m2218f(c0883d.f2630d);
            C0883d c0883d2 = this.f3049u;
            c0883d2.f2632f.m2218f(c0883d2.f2630d);
            C0883d c0883d3 = this.f3050v;
            c0883d3.f2632f.m2218f(c0883d3.f2630d);
        }
    }

    /* JADX INFO: renamed from: l */
    public final boolean m2396l() {
        if (this.f3041m < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                if (!abstractComponentCallbacksC0944o.f3203C ? abstractComponentCallbacksC0944o.f3241x.m2396l() : false) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: m */
    public final void m2397m() {
        if (this.f3041m < 1) {
            return;
        }
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null && !abstractComponentCallbacksC0944o.f3203C) {
                abstractComponentCallbacksC0944o.f3241x.m2397m();
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m2398n(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        if (abstractComponentCallbacksC0944o != null) {
            if (abstractComponentCallbacksC0944o.equals(this.f3031c.m4596e(abstractComponentCallbacksC0944o.f3226i))) {
                abstractComponentCallbacksC0944o.f3239v.getClass();
                boolean zM2366E = m2366E(abstractComponentCallbacksC0944o);
                Boolean bool = abstractComponentCallbacksC0944o.f3231n;
                if (bool == null || bool.booleanValue() != zM2366E) {
                    abstractComponentCallbacksC0944o.f3231n = Boolean.valueOf(zM2366E);
                    C0918D c0918d = abstractComponentCallbacksC0944o.f3241x;
                    c0918d.m2384U();
                    c0918d.m2398n(c0918d.f3045q);
                }
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public final boolean m2399o() {
        boolean z3 = false;
        if (this.f3041m < 1) {
            return false;
        }
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null && m2365D(abstractComponentCallbacksC0944o) && abstractComponentCallbacksC0944o.m2480H()) {
                z3 = true;
            }
        }
        return z3;
    }

    /* JADX INFO: renamed from: p */
    public final void m2400p(int i3) {
        try {
            this.f3030b = true;
            for (C0923I c0923i : ((HashMap) this.f3031c.f7315b).values()) {
                if (c0923i != null) {
                    c0923i.f3092e = i3;
                }
            }
            m2370F(i3, false);
            Iterator it = m2389e().iterator();
            while (it.hasNext()) {
                ((C0937h) it.next()).m2461e();
            }
            this.f3030b = false;
            m2404t(true);
        } catch (Throwable th) {
            this.f3030b = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m2401q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String strM4117a = AbstractC1849h.m4117a(str, "    ");
        C2071i c2071i = this.f3031c;
        c2071i.getClass();
        String str2 = str + "    ";
        HashMap map = (HashMap) c2071i.f7315b;
        if (!map.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (C0923I c0923i : map.values()) {
                printWriter.print(str);
                if (c0923i != null) {
                    AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0923i.f3090c;
                    printWriter.println(abstractComponentCallbacksC0944o);
                    abstractComponentCallbacksC0944o.m2488f(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = (ArrayList) c2071i.f7314a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i3 = 0; i3 < size3; i3++) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = (AbstractComponentCallbacksC0944o) arrayList.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0944o2.toString());
            }
        }
        ArrayList arrayList2 = this.f3033e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i4 = 0; i4 < size2; i4++) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o3 = (AbstractComponentCallbacksC0944o) this.f3033e.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(abstractComponentCallbacksC0944o3.toString());
            }
        }
        ArrayList arrayList3 = this.f3032d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i5 = 0; i5 < size; i5++) {
                C0930a c0930a = (C0930a) this.f3032d.get(i5);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println(c0930a.toString());
                c0930a.m2443f(strM4117a, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f3037i.get());
        synchronized (this.f3029a) {
            try {
                int size4 = this.f3029a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i6 = 0; i6 < size4; i6++) {
                        Object obj = (InterfaceC0916B) this.f3029a.get(i6);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i6);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f3042n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f3043o);
        if (this.f3044p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f3044p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f3041m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f3053y);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3054z);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f3022A);
        if (this.f3052x) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f3052x);
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m2402r(InterfaceC0916B interfaceC0916B, boolean z3) {
        if (!z3) {
            if (this.f3042n == null) {
                if (!this.f3022A) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.f3053y || this.f3054z) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f3029a) {
            try {
                if (this.f3042n == null) {
                    if (!z3) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.f3029a.add(interfaceC0916B);
                    m2378N();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m2403s(boolean z3) {
        if (this.f3030b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f3042n == null) {
            if (!this.f3022A) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f3042n.f3248g.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z3 && (this.f3053y || this.f3054z)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f3024C == null) {
            this.f3024C = new ArrayList();
            this.f3025D = new ArrayList();
        }
        this.f3030b = false;
    }

    /* JADX INFO: renamed from: t */
    public final boolean m2404t(boolean z3) {
        boolean zMo2363a;
        m2403s(z3);
        boolean z4 = false;
        while (true) {
            ArrayList arrayList = this.f3024C;
            ArrayList arrayList2 = this.f3025D;
            synchronized (this.f3029a) {
                try {
                    if (this.f3029a.isEmpty()) {
                        zMo2363a = false;
                    } else {
                        int size = this.f3029a.size();
                        zMo2363a = false;
                        for (int i3 = 0; i3 < size; i3++) {
                            zMo2363a |= ((InterfaceC0916B) this.f3029a.get(i3)).mo2363a(arrayList, arrayList2);
                        }
                        this.f3029a.clear();
                        this.f3042n.f3248g.removeCallbacks(this.f3028G);
                    }
                } finally {
                }
            }
            if (!zMo2363a) {
                break;
            }
            z4 = true;
            this.f3030b = true;
            try {
                m2375K(this.f3024C, this.f3025D);
            } finally {
                m2388d();
            }
        }
        m2384U();
        if (this.f3023B) {
            this.f3023B = false;
            m2383T();
        }
        ((HashMap) this.f3031c.f7315b).values().removeAll(Collections.singleton(null));
        return z4;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            sb.append(abstractComponentCallbacksC0944o.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f3044p)));
            sb.append("}");
        } else {
            C0946q c0946q = this.f3042n;
            if (c0946q != null) {
                sb.append(c0946q.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.f3042n)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
    /* JADX INFO: renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2405u(java.util.ArrayList r21, java.util.ArrayList r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0918D.m2405u(java.util.ArrayList, java.util.ArrayList, int, int):void");
    }

    /* JADX INFO: renamed from: v */
    public final void m2406v(ArrayList arrayList, ArrayList arrayList2) {
    }

    /* JADX INFO: renamed from: w */
    public final AbstractComponentCallbacksC0944o m2407w(int i3) {
        C2071i c2071i = this.f3031c;
        ArrayList arrayList = (ArrayList) c2071i.f7314a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = (AbstractComponentCallbacksC0944o) arrayList.get(size);
            if (abstractComponentCallbacksC0944o != null && abstractComponentCallbacksC0944o.f3243z == i3) {
                return abstractComponentCallbacksC0944o;
            }
        }
        for (C0923I c0923i : ((HashMap) c2071i.f7315b).values()) {
            if (c0923i != null) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = c0923i.f3090c;
                if (abstractComponentCallbacksC0944o2.f3243z == i3) {
                    return abstractComponentCallbacksC0944o2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: x */
    public final AbstractComponentCallbacksC0944o m2408x(String str) {
        C2071i c2071i = this.f3031c;
        ArrayList arrayList = (ArrayList) c2071i.f7314a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = (AbstractComponentCallbacksC0944o) arrayList.get(size);
            if (abstractComponentCallbacksC0944o != null && str.equals(abstractComponentCallbacksC0944o.f3202B)) {
                return abstractComponentCallbacksC0944o;
            }
        }
        for (C0923I c0923i : ((HashMap) c2071i.f7315b).values()) {
            if (c0923i != null) {
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = c0923i.f3090c;
                if (str.equals(abstractComponentCallbacksC0944o2.f3202B)) {
                    return abstractComponentCallbacksC0944o2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: y */
    public final ViewGroup m2409y(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        ViewGroup viewGroup = abstractComponentCallbacksC0944o.f3209I;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (abstractComponentCallbacksC0944o.f3201A > 0 && this.f3043o.mo2465k()) {
            View viewMo2464j = this.f3043o.mo2464j(abstractComponentCallbacksC0944o.f3201A);
            if (viewMo2464j instanceof ViewGroup) {
                return (ViewGroup) viewMo2464j;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: z */
    public final C0953x m2410z() {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3044p;
        return abstractComponentCallbacksC0944o != null ? abstractComponentCallbacksC0944o.f3239v.m2410z() : this.f3046r;
    }
}

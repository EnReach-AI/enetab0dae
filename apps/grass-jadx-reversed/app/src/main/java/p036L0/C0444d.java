package p036L0;

import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.AbstractActivityC0947r;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import com.facebook.InterfaceC1122s;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import p001A.C0009j;
import p010C0.AbstractC0147a;
import p016E1.AbstractC0207e;
import p019F0.C0221e;
import p026I.AbstractC0294b;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p029J.C0343g;
import p029J.C0360o0;
import p029J.C0364q0;
import p029J.InterfaceC0337d;
import p029J.InterfaceC0367s;
import p073Z.AbstractC0763I;
import p073Z.C0764J;
import p073Z.InterfaceC0795h0;
import p108j.C1472f;
import p108j.C1481o;
import p108j.InterfaceC1491y;
import p108j.MenuC1479m;
import p108j.RunnableC1471e;
import p108j.SubMenuC1466F;
import p108j.ViewOnKeyListenerC1473g;
import p110k.C1594i;
import p110k.InterfaceC1601l;
import p110k.InterfaceC1630z0;
import p117m0.AbstractC1725t;
import p117m0.C1707b;
import p117m0.C1718m;
import p117m0.C1724s;
import p141s0.InterfaceC1880j;
import p144t0.C1916b;
import p144t0.C1917c;
import p155w.C1982d;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2087y;
import p166z0.C2064b;
import p166z0.C2070h;
import p166z0.InterfaceC2059H;

/* JADX INFO: renamed from: L0.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0444d implements InterfaceC0337d, InterfaceC0795h0, InterfaceC1122s, InterfaceC1630z0, InterfaceC1491y, InterfaceC1601l, InterfaceC1880j, InterfaceC0367s, InterfaceC2059H {

    /* JADX INFO: renamed from: e */
    public Object f1085e;

    public /* synthetic */ C0444d(Object obj) {
        this.f1085e = obj;
    }

    /* JADX INFO: renamed from: r */
    public static ScheduledThreadPoolExecutor m976r() {
        if (AbstractC0147a.f354a.contains(C1718m.class)) {
            return null;
        }
        try {
            if (C1718m.f6000c == null) {
                C1718m.m3812c();
            }
            return C1718m.f6000c;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1718m.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: w */
    public static C0444d m977w(boolean z3, int i3, int i4, int i5, int i6) {
        return new C0444d(AccessibilityNodeInfo.CollectionItemInfo.obtain(i3, i4, i5, i6, false, z3));
    }

    /* JADX INFO: renamed from: x */
    public static void m978x(HashMap map) {
        SharedPreferences sharedPreferences = AbstractC1725t.f6017a;
        if (AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
            return;
        }
        try {
            if (!AbstractC1725t.f6018b.get()) {
                AbstractC1725t.m3832d();
            }
            Iterator it = map.entrySet().iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                ConcurrentHashMap concurrentHashMap = AbstractC1725t.f6020d;
                if (!zHasNext) {
                    AbstractC1725t.m3835g("com.facebook.appevents.UserDataStore.internalUserData", AbstractC2056E.m4553v(concurrentHashMap));
                    return;
                }
                String str = (String) ((Map.Entry) it.next()).getKey();
                String strM4530B = AbstractC2056E.m4530B(AbstractC1725t.m3833e(str, ((String) map.get(str)).trim()));
                if (concurrentHashMap.containsKey(str)) {
                    String str2 = (String) concurrentHashMap.get(str);
                    String[] strArrSplit = str2 != null ? str2.split(",") : new String[0];
                    HashSet hashSet = new HashSet(Arrays.asList(strArrSplit));
                    if (hashSet.contains(strM4530B)) {
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    if (strArrSplit.length == 0) {
                        sb.append(strM4530B);
                    } else if (strArrSplit.length < 5) {
                        sb.append(str2);
                        sb.append(",");
                        sb.append(strM4530B);
                    } else {
                        for (int i3 = 1; i3 < 5; i3++) {
                            sb.append(strArrSplit[i3]);
                            sb.append(",");
                        }
                        sb.append(strM4530B);
                        hashSet.remove(strArrSplit[0]);
                    }
                    concurrentHashMap.put(str, sb.toString());
                } else {
                    concurrentHashMap.put(str, strM4530B);
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1725t.class);
        }
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: a */
    public void mo533a(MenuC1479m menuC1479m, boolean z3) {
        if (menuC1479m instanceof SubMenuC1466F) {
            ((SubMenuC1466F) menuC1479m).f5274z.mo3495k().m3513c(false);
        }
        InterfaceC1491y interfaceC1491y = ((C1594i) this.f1085e).f5645i;
        if (interfaceC1491y != null) {
            interfaceC1491y.mo533a(menuC1479m, z3);
        }
    }

    @Override // p108j.InterfaceC1491y
    /* JADX INFO: renamed from: b */
    public boolean mo534b(MenuC1479m menuC1479m) {
        C1594i c1594i = (C1594i) this.f1085e;
        if (menuC1479m == c1594i.f5643g) {
            return false;
        }
        ((SubMenuC1466F) menuC1479m).f5273A.getClass();
        c1594i.getClass();
        InterfaceC1491y interfaceC1491y = c1594i.f5645i;
        if (interfaceC1491y != null) {
            return interfaceC1491y.mo534b(menuC1479m);
        }
        return false;
    }

    @Override // p110k.InterfaceC1630z0
    /* JADX INFO: renamed from: c */
    public void mo979c(MenuC1479m menuC1479m, C1481o c1481o) {
        ViewOnKeyListenerC1473g viewOnKeyListenerC1473g = (ViewOnKeyListenerC1473g) this.f1085e;
        viewOnKeyListenerC1473g.f5313k.removeCallbacksAndMessages(null);
        ArrayList arrayList = viewOnKeyListenerC1473g.f5315m;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (menuC1479m == ((C1472f) arrayList.get(i3)).f5301b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == -1) {
            return;
        }
        int i4 = i3 + 1;
        viewOnKeyListenerC1473g.f5313k.postAtTime(new RunnableC1471e(this, i4 < arrayList.size() ? (C1472f) arrayList.get(i4) : null, c1481o, menuC1479m, 0), menuC1479m, SystemClock.uptimeMillis() + 200);
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: d */
    public C0343g mo731d() {
        return new C0343g(new C0221e(((ContentInfo.Builder) this.f1085e).build()));
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: e */
    public void mo732e(Bundle bundle) {
        ((ContentInfo.Builder) this.f1085e).setExtras(bundle);
    }

    @Override // com.facebook.InterfaceC1122s
    /* JADX INFO: renamed from: f */
    public void mo980f(String str, String str2) throws UnsupportedEncodingException {
        Locale locale = Locale.US;
        ((ArrayList) this.f1085e).add(str + "=" + URLEncoder.encode(str2, "UTF-8"));
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: g */
    public void mo733g(Uri uri) {
        ((ContentInfo.Builder) this.f1085e).setLinkUri(uri);
    }

    @Override // p029J.InterfaceC0367s
    /* JADX INFO: renamed from: h */
    public C0364q0 mo48h(View view, C0364q0 c0364q0) {
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f1085e;
        if (!AbstractC0294b.m569a(coordinatorLayout.f2905r, c0364q0)) {
            coordinatorLayout.f2905r = c0364q0;
            boolean z3 = c0364q0.m833d() > 0;
            coordinatorLayout.f2906s = z3;
            coordinatorLayout.setWillNotDraw(!z3 && coordinatorLayout.getBackground() == null);
            C0360o0 c0360o0 = c0364q0.f874a;
            if (!c0360o0.mo765m()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = coordinatorLayout.getChildAt(i3);
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    if (AbstractC0307B.m586b(childAt) && ((C1982d) childAt.getLayoutParams()).f7026a != null && c0360o0.mo765m()) {
                        break;
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return c0364q0;
    }

    @Override // p141s0.InterfaceC1880j
    /* JADX INFO: renamed from: i */
    public void mo49i(File file) {
        C1916b c1916b = null;
        if (!AbstractC0147a.f354a.contains(C1916b.class)) {
            try {
                try {
                    c1916b = new C1916b(C1916b.m4265c(file));
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, C1916b.class);
            }
        }
        if (c1916b != null) {
            for (C1917c c1917c : (List) this.f1085e) {
                C1917c.m4269b(c1917c.f6713c, c1917c.f6711a + "_" + c1917c.f6714d + "_rule", new C0009j(c1917c, 28, c1916b));
            }
        }
    }

    @Override // p029J.InterfaceC0337d
    /* JADX INFO: renamed from: j */
    public void mo734j(int i3) {
        ((ContentInfo.Builder) this.f1085e).setFlags(i3);
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: k */
    public View mo450k(int i3) {
        return ((AbstractC0763I) this.f1085e).m2025u(i3);
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: l */
    public int mo451l() {
        AbstractC0763I abstractC0763I = (AbstractC0763I) this.f1085e;
        return abstractC0763I.f2153o - abstractC0763I.m2029z();
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: m */
    public int mo452m() {
        return ((AbstractC0763I) this.f1085e).m1967C();
    }

    @Override // p110k.InterfaceC1630z0
    /* JADX INFO: renamed from: n */
    public void mo981n(MenuC1479m menuC1479m, C1481o c1481o) {
        ((ViewOnKeyListenerC1473g) this.f1085e).f5313k.removeCallbacksAndMessages(menuC1479m);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0026 A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #2 {, blocks: (B:6:0x0005, B:14:0x001c, B:15:0x0020, B:17:0x0026, B:24:0x0048, B:25:0x004c, B:27:0x0052, B:23:0x0044, B:13:0x0018, B:20:0x003a, B:10:0x0010), top: B:39:0x0005, inners: #0, #1 }] */
    /* JADX INFO: renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m982o(p117m0.C1723r r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 != 0) goto L5
            monitor-exit(r5)
            return
        L5:
            java.util.Set r0 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> L5c
            boolean r0 = r0.contains(r6)     // Catch: java.lang.Throwable -> L5c
            r1 = 0
            if (r0 == 0) goto L10
        Le:
            r0 = r1
            goto L1c
        L10:
            java.util.HashMap r0 = r6.f6011e     // Catch: java.lang.Throwable -> L17
            java.util.Set r0 = r0.keySet()     // Catch: java.lang.Throwable -> L17
            goto L1c
        L17:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r6)     // Catch: java.lang.Throwable -> L5c
            goto Le
        L1c:
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L5c
        L20:
            boolean r2 = r0.hasNext()     // Catch: java.lang.Throwable -> L5c
            if (r2 == 0) goto L5e
            java.lang.Object r2 = r0.next()     // Catch: java.lang.Throwable -> L5c
            m0.b r2 = (p117m0.C1707b) r2     // Catch: java.lang.Throwable -> L5c
            m0.s r3 = r5.m984u(r2)     // Catch: java.lang.Throwable -> L5c
            java.util.Set r4 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> L5c
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L3a
        L38:
            r2 = r1
            goto L48
        L3a:
            java.util.HashMap r4 = r6.f6011e     // Catch: java.lang.Throwable -> L43
            java.lang.Object r2 = r4.get(r2)     // Catch: java.lang.Throwable -> L43
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> L43
            goto L48
        L43:
            r2 = move-exception
            p010C0.AbstractC0147a.m295a(r2, r6)     // Catch: java.lang.Throwable -> L5c
            goto L38
        L48:
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L5c
        L4c:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto L20
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L5c
            m0.f r4 = (p117m0.C1711f) r4     // Catch: java.lang.Throwable -> L5c
            r3.m3824a(r4)     // Catch: java.lang.Throwable -> L5c
            goto L4c
        L5c:
            r6 = move-exception
            goto L60
        L5e:
            monitor-exit(r5)
            return
        L60:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p036L0.C0444d.m982o(m0.r):void");
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: p */
    public int mo455p(View view) {
        C0764J c0764j = (C0764J) view.getLayoutParams();
        ((AbstractC0763I) this.f1085e).getClass();
        return view.getBottom() + ((C0764J) view.getLayoutParams()).f2155b.bottom + ((ViewGroup.MarginLayoutParams) c0764j).bottomMargin;
    }

    @Override // p073Z.InterfaceC0795h0
    /* JADX INFO: renamed from: q */
    public int mo456q(View view) {
        C0764J c0764j = (C0764J) view.getLayoutParams();
        ((AbstractC0763I) this.f1085e).getClass();
        return (view.getTop() - ((C0764J) view.getLayoutParams()).f2155b.top) - ((ViewGroup.MarginLayoutParams) c0764j).topMargin;
    }

    @Override // p166z0.InterfaceC2059H
    /* JADX INFO: renamed from: s */
    public void mo59s(Bundle bundle, C1111h c1111h) {
        AbstractActivityC0947r abstractActivityC0947rM2490h = ((C2070h) this.f1085e).m2490h();
        abstractActivityC0947rM2490h.setResult(c1111h == null ? -1 : 0, AbstractC2087y.m4635d(abstractActivityC0947rM2490h.getIntent(), bundle, c1111h));
        abstractActivityC0947rM2490h.finish();
    }

    /* JADX INFO: renamed from: t */
    public synchronized int m983t() {
        int i3;
        int size;
        i3 = 0;
        for (C1724s c1724s : ((HashMap) this.f1085e).values()) {
            synchronized (c1724s) {
                if (!AbstractC0147a.f354a.contains(c1724s)) {
                    try {
                        size = c1724s.f6012a.size();
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, c1724s);
                        size = 0;
                    }
                }
                size = 0;
            }
            i3 += size;
        }
        return i3;
    }

    /* JADX INFO: renamed from: u */
    public synchronized C1724s m984u(C1707b c1707b) {
        C1724s c1724s;
        try {
            c1724s = (C1724s) ((HashMap) this.f1085e).get(c1707b);
            if (c1724s == null) {
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                Context context = AbstractC1117n.f3882h;
                C2064b c2064bM4569b = C2064b.m4569b(context);
                String strM438u = C0221e.m438u(context);
                C1724s c1724s2 = new C1724s();
                c1724s2.f6012a = new ArrayList();
                c1724s2.f6013b = new ArrayList();
                c1724s2.f6015d = c2064bM4569b;
                c1724s2.f6016e = strM438u;
                c1724s = c1724s2;
            }
            ((HashMap) this.f1085e).put(c1707b, c1724s);
        } catch (Throwable th) {
            throw th;
        }
        return c1724s;
    }

    /* JADX INFO: renamed from: v */
    public void m985v(Bundle bundle, String str) {
        HashSet hashSet = AbstractC1117n.f3875a;
        if (AbstractC1103F.m2866c()) {
            ((C1718m) this.f1085e).m3817g(bundle, str);
        }
    }

    public C0444d(int i3) {
        switch (i3) {
            case 14:
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                this.f1085e = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);
                break;
            case 21:
                this.f1085e = new HashMap();
                break;
            default:
                this.f1085e = new CopyOnWriteArrayList();
                new HashMap();
                break;
        }
    }

    public C0444d(ClipData clipData, int i3) {
        this.f1085e = AbstractC0207e.m406d(clipData, i3);
    }
}

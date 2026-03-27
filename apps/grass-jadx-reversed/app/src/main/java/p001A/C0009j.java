package p001A;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.SparseIntArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.EditText;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.AbstractComponentCallbacksC0944o;
import androidx.fragment.app.C0918D;
import androidx.lifecycle.AbstractC0964I;
import androidx.lifecycle.C0965J;
import androidx.lifecycle.C0966K;
import androidx.lifecycle.InterfaceC0984q;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.File;
import java.io.PrintWriter;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p005B.AbstractC0032g;
import p007B1.RunnableC0055o;
import p008B2.C0072L;
import p008B2.C0080U;
import p008B2.C0087a0;
import p008B2.C0104j;
import p008B2.C0118q;
import p010C0.AbstractC0147a;
import p019F0.C0221e;
import p019F0.C0222f;
import p021G.C0231h;
import p021G.RunnableC0224a;
import p021G.RunnableC0225b;
import p024H0.C0261o;
import p024H0.C0271y;
import p029J.AbstractC0311F;
import p029J.AbstractC0323S;
import p029J.C0330Z;
import p029J.C0365r;
import p029J.InterfaceC0367s;
import p054R1.C0621a;
import p054R1.C0622b;
import p055S.C0623a;
import p055S.C0631i;
import p063V.C0667a;
import p065W.C0673a;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p073Z.AbstractC0777X;
import p073Z.C0787d0;
import p073Z.C0793g0;
import p073Z.C0797i0;
import p073Z.InterfaceC0795h0;
import p082b1.InterfaceC1027X;
import p083b2.C1062g;
import p083b2.C1063h;
import p086c2.AbstractC1087f;
import p098g.C1375n;
import p098g.LayoutInflaterFactory2C1382u;
import p105i.AbstractC1434b;
import p105i.InterfaceC1433a;
import p108j.MenuC1479m;
import p114l1.C1674p;
import p114l1.C1675q;
import p115l2.InterfaceC1689l;
import p115l2.InterfaceC1693p;
import p118m1.C1732G;
import p118m1.C1752q;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1795e;
import p128p.C1811e;
import p128p.C1817k;
import p128p.C1818l;
import p135q2.InterfaceC1840a;
import p135q2.InterfaceC1841b;
import p141s0.InterfaceC1880j;
import p144t0.C1916b;
import p144t0.C1917c;
import p148u0.AbstractC1946e;
import p161x2.InterfaceC2012a;
import p166z0.C2068f;
import p166z0.C2079q;
import p166z0.InterfaceC2059H;

/* JADX INFO: renamed from: A.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0009j implements InterfaceC0367s, InterfaceC2059H, InterfaceC1027X, InterfaceC1433a, InterfaceC1880j {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f29e;

    /* JADX INFO: renamed from: f */
    public Object f30f;

    /* JADX INFO: renamed from: g */
    public Object f31g;

    public /* synthetic */ C0009j(int i3, boolean z3) {
        this.f29e = i3;
    }

    /* JADX INFO: renamed from: D */
    public static int m23D(int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            i5++;
            if (i5 == i4) {
                i6++;
                i5 = 0;
            } else if (i5 > i4) {
                i6++;
                i5 = 1;
            }
        }
        return i5 + 1 > i4 ? i6 + 1 : i6;
    }

    /* JADX INFO: renamed from: A */
    public View m24A(int i3, int i4, int i5, int i6) {
        InterfaceC0795h0 interfaceC0795h0 = (InterfaceC0795h0) this.f30f;
        int iMo452m = interfaceC0795h0.mo452m();
        int iMo451l = interfaceC0795h0.mo451l();
        int i7 = i4 > i3 ? 1 : -1;
        View view = null;
        while (i3 != i4) {
            View viewMo450k = interfaceC0795h0.mo450k(i3);
            int iMo456q = interfaceC0795h0.mo456q(viewMo450k);
            int iMo455p = interfaceC0795h0.mo455p(viewMo450k);
            C0793g0 c0793g0 = (C0793g0) this.f31g;
            c0793g0.f2286b = iMo452m;
            c0793g0.f2287c = iMo451l;
            c0793g0.f2288d = iMo456q;
            c0793g0.f2289e = iMo455p;
            if (i5 != 0) {
                c0793g0.f2285a = i5;
                if (c0793g0.m2084a()) {
                    return viewMo450k;
                }
            }
            if (i6 != 0) {
                c0793g0.f2285a = i6;
                if (c0793g0.m2084a()) {
                    view = viewMo450k;
                }
            }
            i3 += i7;
        }
        return view;
    }

    /* JADX INFO: renamed from: B */
    public InterfaceC2012a m25B(InterfaceC1840a interfaceC1840a) {
        Object objPutIfAbsent;
        switch (this.f29e) {
            case 2:
                Object obj = ((C0118q) this.f31g).get(AbstractC1946e.m4344b(interfaceC1840a));
                AbstractC1766e.m3919d("get(...)", obj);
                C0080U c0080u = (C0080U) obj;
                Object c0104j = c0080u.f250a.get();
                if (c0104j == null) {
                    synchronized (c0080u) {
                        c0104j = c0080u.f250a.get();
                        if (c0104j == null) {
                            c0104j = new C0104j((InterfaceC2012a) ((InterfaceC1689l) this.f30f).mo249f(interfaceC1840a));
                            c0080u.f250a = new SoftReference(c0104j);
                        }
                    }
                }
                return ((C0104j) c0104j).f293a;
            default:
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f31g;
                Class clsM4344b = AbstractC1946e.m4344b(interfaceC1840a);
                Object c0104j2 = concurrentHashMap.get(clsM4344b);
                if (c0104j2 == null && (objPutIfAbsent = concurrentHashMap.putIfAbsent(clsM4344b, (c0104j2 = new C0104j((InterfaceC2012a) ((InterfaceC1689l) this.f30f).mo249f(interfaceC1840a))))) != null) {
                    c0104j2 = objPutIfAbsent;
                }
                return ((C0104j) c0104j2).f293a;
        }
    }

    /* JADX INFO: renamed from: C */
    public Object m26C(InterfaceC1840a interfaceC1840a, ArrayList arrayList) {
        Object c1062g;
        Object c1062g2;
        Object objPutIfAbsent;
        switch (this.f29e) {
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                Object obj = ((C0118q) this.f31g).get(AbstractC1946e.m4344b(interfaceC1840a));
                AbstractC1766e.m3919d("get(...)", obj);
                C0080U c0080u = (C0080U) obj;
                Object c0087a0 = c0080u.f250a.get();
                if (c0087a0 == null) {
                    synchronized (c0080u) {
                        c0087a0 = c0080u.f250a.get();
                        if (c0087a0 == null) {
                            c0087a0 = new C0087a0();
                            c0080u.f250a = new SoftReference(c0087a0);
                        }
                    }
                }
                C0087a0 c0087a02 = (C0087a0) c0087a0;
                ArrayList arrayList2 = new ArrayList(AbstractC1087f.m2838v(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new C0072L((InterfaceC1841b) it.next()));
                }
                ConcurrentHashMap concurrentHashMap = c0087a02.f258a;
                Object obj2 = concurrentHashMap.get(arrayList2);
                if (obj2 == null) {
                    try {
                        c1062g = (InterfaceC2012a) ((InterfaceC1693p) this.f30f).mo317c(interfaceC1840a, arrayList);
                    } catch (Throwable th) {
                        c1062g = new C1062g(th);
                    }
                    C1063h c1063h = new C1063h(c1062g);
                    Object objPutIfAbsent2 = concurrentHashMap.putIfAbsent(arrayList2, c1063h);
                    obj2 = objPutIfAbsent2 == null ? c1063h : objPutIfAbsent2;
                    break;
                }
                return ((C1063h) obj2).f3739e;
            default:
                ConcurrentHashMap concurrentHashMap2 = (ConcurrentHashMap) this.f31g;
                Class clsM4344b = AbstractC1946e.m4344b(interfaceC1840a);
                Object c0087a03 = concurrentHashMap2.get(clsM4344b);
                if (c0087a03 == null && (objPutIfAbsent = concurrentHashMap2.putIfAbsent(clsM4344b, (c0087a03 = new C0087a0()))) != null) {
                    c0087a03 = objPutIfAbsent;
                }
                C0087a0 c0087a04 = (C0087a0) c0087a03;
                ArrayList arrayList3 = new ArrayList(AbstractC1087f.m2838v(arrayList, 10));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(new C0072L((InterfaceC1841b) it2.next()));
                }
                ConcurrentHashMap concurrentHashMap3 = c0087a04.f258a;
                Object obj3 = concurrentHashMap3.get(arrayList3);
                if (obj3 == null) {
                    try {
                        c1062g2 = (InterfaceC2012a) ((InterfaceC1693p) this.f30f).mo317c(interfaceC1840a, arrayList);
                    } catch (Throwable th2) {
                        c1062g2 = new C1062g(th2);
                    }
                    C1063h c1063h2 = new C1063h(c1062g2);
                    Object objPutIfAbsent3 = concurrentHashMap3.putIfAbsent(arrayList3, c1063h2);
                    obj3 = objPutIfAbsent3 == null ? c1063h2 : objPutIfAbsent3;
                    break;
                }
                return ((C1063h) obj3).f3739e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0012  */
    /* JADX INFO: renamed from: E */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m27E(int r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f30f
            int[] r0 = (int[]) r0
            r1 = -1
            if (r0 != 0) goto L8
            return r1
        L8:
            int r0 = r0.length
            if (r6 < r0) goto Lc
            return r1
        Lc:
            java.lang.Object r0 = r5.f31g
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L14
        L12:
            r0 = r1
            goto L6f
        L14:
            r2 = 0
            if (r0 != 0) goto L18
            goto L33
        L18:
            int r0 = r0.size()
            int r0 = r0 + (-1)
        L1e:
            if (r0 < 0) goto L33
            java.lang.Object r3 = r5.f31g
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r0)
            Z.d0 r3 = (p073Z.C0787d0) r3
            int r4 = r3.f2248e
            if (r4 != r6) goto L30
            r2 = r3
            goto L33
        L30:
            int r0 = r0 + (-1)
            goto L1e
        L33:
            if (r2 == 0) goto L3c
            java.lang.Object r0 = r5.f31g
            java.util.List r0 = (java.util.List) r0
            r0.remove(r2)
        L3c:
            java.lang.Object r0 = r5.f31g
            java.util.List r0 = (java.util.List) r0
            int r0 = r0.size()
            r2 = 0
        L45:
            if (r2 >= r0) goto L59
            java.lang.Object r3 = r5.f31g
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = r3.get(r2)
            Z.d0 r3 = (p073Z.C0787d0) r3
            int r3 = r3.f2248e
            if (r3 < r6) goto L56
            goto L5a
        L56:
            int r2 = r2 + 1
            goto L45
        L59:
            r2 = r1
        L5a:
            if (r2 == r1) goto L12
            java.lang.Object r0 = r5.f31g
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r2)
            Z.d0 r0 = (p073Z.C0787d0) r0
            java.lang.Object r3 = r5.f31g
            java.util.List r3 = (java.util.List) r3
            r3.remove(r2)
            int r0 = r0.f2248e
        L6f:
            if (r0 != r1) goto L7f
            java.lang.Object r0 = r5.f30f
            int[] r0 = (int[]) r0
            int r2 = r0.length
            java.util.Arrays.fill(r0, r6, r2, r1)
            java.lang.Object r6 = r5.f30f
            int[] r6 = (int[]) r6
            int r6 = r6.length
            return r6
        L7f:
            java.lang.Object r2 = r5.f30f
            int[] r2 = (int[]) r2
            int r0 = r0 + 1
            java.util.Arrays.fill(r2, r6, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p001A.C0009j.m27E(int):int");
    }

    /* JADX INFO: renamed from: F */
    public void m28F() {
        ((SparseIntArray) this.f30f).clear();
    }

    /* JADX INFO: renamed from: G */
    public boolean m29G(View view) {
        InterfaceC0795h0 interfaceC0795h0 = (InterfaceC0795h0) this.f30f;
        int iMo452m = interfaceC0795h0.mo452m();
        int iMo451l = interfaceC0795h0.mo451l();
        int iMo456q = interfaceC0795h0.mo456q(view);
        int iMo455p = interfaceC0795h0.mo455p(view);
        C0793g0 c0793g0 = (C0793g0) this.f31g;
        c0793g0.f2286b = iMo452m;
        c0793g0.f2287c = iMo451l;
        c0793g0.f2288d = iMo456q;
        c0793g0.f2289e = iMo455p;
        c0793g0.f2285a = 24579;
        return c0793g0.m2084a();
    }

    /* JADX INFO: renamed from: H */
    public void m30H(int i3, int i4) {
        int[] iArr = (int[]) this.f30f;
        if (iArr == null || i3 >= iArr.length) {
            return;
        }
        int i5 = i3 + i4;
        m66z(i5);
        int[] iArr2 = (int[]) this.f30f;
        System.arraycopy(iArr2, i3, iArr2, i5, (iArr2.length - i3) - i4);
        Arrays.fill((int[]) this.f30f, i3, i5, -1);
        List list = (List) this.f31g;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            C0787d0 c0787d0 = (C0787d0) ((List) this.f31g).get(size);
            int i6 = c0787d0.f2248e;
            if (i6 >= i3) {
                c0787d0.f2248e = i6 + i4;
            }
        }
    }

    /* JADX INFO: renamed from: I */
    public void m31I(int i3, int i4) {
        int[] iArr = (int[]) this.f30f;
        if (iArr == null || i3 >= iArr.length) {
            return;
        }
        int i5 = i3 + i4;
        m66z(i5);
        int[] iArr2 = (int[]) this.f30f;
        System.arraycopy(iArr2, i5, iArr2, i3, (iArr2.length - i3) - i4);
        int[] iArr3 = (int[]) this.f30f;
        Arrays.fill(iArr3, iArr3.length - i4, iArr3.length, -1);
        List list = (List) this.f31g;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            C0787d0 c0787d0 = (C0787d0) ((List) this.f31g).get(size);
            int i6 = c0787d0.f2248e;
            if (i6 >= i3) {
                if (i6 < i5) {
                    ((List) this.f31g).remove(size);
                } else {
                    c0787d0.f2248e = i6 - i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: J */
    public void m32J() {
        C2079q c2079q = (C2079q) this.f30f;
        boolean zM2863a = false;
        boolean z3 = c2079q != null && c2079q.f7356g;
        HashSet hashSet = AbstractC1117n.f3875a;
        AtomicBoolean atomicBoolean = AbstractC1103F.f3811a;
        if (!AbstractC0147a.f354a.contains(AbstractC1103F.class)) {
            try {
                AbstractC1103F.m2868e();
                zM2863a = AbstractC1103F.f3816f.m2863a();
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1103F.class);
            }
        }
        if (z3 && zM2863a) {
            C0222f c0222f = null;
            if (!AbstractC0147a.f354a.contains(AbstractC1795e.class)) {
                try {
                    c0222f = AbstractC1795e.f6200h;
                } catch (Throwable th2) {
                    AbstractC0147a.m295a(th2, AbstractC1795e.class);
                }
            }
            String str = (String) this.f31g;
            c0222f.getClass();
            if (AbstractC0147a.f354a.contains(AbstractC1795e.class)) {
                return;
            }
            try {
                if (AbstractC1795e.f6199g.booleanValue()) {
                    return;
                }
                AbstractC1795e.f6199g = Boolean.TRUE;
                AbstractC1117n.m2891a().execute(new RunnableC0055o(18, str));
            } catch (Throwable th3) {
                AbstractC0147a.m295a(th3, AbstractC1795e.class);
            }
        }
    }

    /* JADX INFO: renamed from: K */
    public void m33K(C0231h c0231h) {
        int i3 = c0231h.f553b;
        Handler handler = (Handler) this.f31g;
        C0221e c0221e = (C0221e) this.f30f;
        if (i3 != 0) {
            handler.post(new RunnableC0225b(c0221e, i3, 0));
        } else {
            handler.post(new RunnableC0224a(c0221e, 0, c0231h.f552a));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d3, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ed  */
    /* JADX INFO: renamed from: L */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m34L(android.content.Context r13, android.content.res.XmlResourceParser r14) {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p001A.C0009j.m34L(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    /* JADX INFO: renamed from: M */
    public C0365r m35M(AbstractC0777X abstractC0777X, int i3) {
        C0797i0 c0797i0;
        C0365r c0365r;
        C1817k c1817k = (C1817k) this.f30f;
        int iM4036e = c1817k.m4036e(abstractC0777X);
        if (iM4036e >= 0 && (c0797i0 = (C0797i0) c1817k.m4041j(iM4036e)) != null) {
            int i4 = c0797i0.f2309a;
            if ((i4 & i3) != 0) {
                int i5 = i4 & (~i3);
                c0797i0.f2309a = i5;
                if (i3 == 4) {
                    c0365r = c0797i0.f2310b;
                } else {
                    if (i3 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    c0365r = c0797i0.f2311c;
                }
                if ((i5 & 12) == 0) {
                    c1817k.m4040i(iM4036e);
                    c0797i0.f2309a = 0;
                    c0797i0.f2310b = null;
                    c0797i0.f2311c = null;
                    C0797i0.f2308d.mo573c(c0797i0);
                }
                return c0365r;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: N */
    public void m36N(AbstractC0777X abstractC0777X) {
        C0797i0 c0797i0 = (C0797i0) ((C1817k) this.f30f).getOrDefault(abstractC0777X, null);
        if (c0797i0 == null) {
            return;
        }
        c0797i0.f2309a &= -2;
    }

    /* JADX INFO: renamed from: O */
    public void m37O(AbstractC0777X abstractC0777X) {
        C1811e c1811e = (C1811e) this.f31g;
        int iM4028f = c1811e.m4028f() - 1;
        while (true) {
            if (iM4028f < 0) {
                break;
            }
            if (abstractC0777X == c1811e.m4029g(iM4028f)) {
                Object[] objArr = c1811e.f6272g;
                Object obj = objArr[iM4028f];
                Object obj2 = C1811e.f6269i;
                if (obj != obj2) {
                    objArr[iM4028f] = obj2;
                    c1811e.f6270e = true;
                }
            } else {
                iM4028f--;
            }
        }
        C0797i0 c0797i0 = (C0797i0) ((C1817k) this.f30f).remove(abstractC0777X);
        if (c0797i0 != null) {
            c0797i0.f2309a = 0;
            c0797i0.f2310b = null;
            c0797i0.f2311c = null;
            C0797i0.f2308d.mo573c(c0797i0);
        }
    }

    /* JADX INFO: renamed from: P */
    public void m38P(int i3, int i4, int i5, int i6) {
        CardView cardView = (CardView) this.f31g;
        cardView.f2866h.set(i3, i4, i5, i6);
        Rect rect = cardView.f2865g;
        super/*android.view.View*/.setPadding(i3 + rect.left, i4 + rect.top, i5 + rect.right, i6 + rect.bottom);
    }

    /* JADX INFO: renamed from: Q */
    public AbstractC0728s m39Q(AbstractC0721l abstractC0721l) {
        AbstractC0728s abstractC0728s;
        synchronized (this) {
            C1752q c1752q = (C1752q) this.f30f;
            abstractC0728s = (AbstractC0728s) c1752q.f6129g.get(new C1732G(abstractC0721l, false));
        }
        return abstractC0728s;
    }

    /* JADX INFO: renamed from: R */
    public AbstractC0728s m40R(Class cls) {
        AbstractC0728s abstractC0728s;
        synchronized (this) {
            C1752q c1752q = (C1752q) this.f30f;
            abstractC0728s = (AbstractC0728s) c1752q.f6129g.get(new C1732G(cls, false));
        }
        return abstractC0728s;
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: a */
    public boolean mo41a(AbstractC1434b abstractC1434b, MenuItem menuItem) {
        return ((InterfaceC1433a) this.f30f).mo41a(abstractC1434b, menuItem);
    }

    @Override // p082b1.InterfaceC1027X
    /* JADX INFO: renamed from: b */
    public AbstractC0721l mo42b(Type type) {
        return ((C1675q) this.f30f).m3774b(null, type, (C1674p) this.f31g);
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: c */
    public boolean mo43c(AbstractC1434b abstractC1434b, MenuC1479m menuC1479m) {
        return ((InterfaceC1433a) this.f30f).mo43c(abstractC1434b, menuC1479m);
    }

    /* JADX INFO: renamed from: d */
    public void m44d(AbstractC0777X abstractC0777X, C0365r c0365r) {
        C1817k c1817k = (C1817k) this.f30f;
        C0797i0 c0797i0M2091a = (C0797i0) c1817k.getOrDefault(abstractC0777X, null);
        if (c0797i0M2091a == null) {
            c0797i0M2091a = C0797i0.m2091a();
            c1817k.put(abstractC0777X, c0797i0M2091a);
        }
        c0797i0M2091a.f2311c = c0365r;
        c0797i0M2091a.f2309a |= 8;
    }

    /* JADX INFO: renamed from: e */
    public void m45e(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m45e(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: f */
    public boolean mo46f(AbstractC1434b abstractC1434b, Menu menu) {
        ViewGroup viewGroup = ((LayoutInflaterFactory2C1382u) this.f31g).f4956E;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0311F.m627c(viewGroup);
        return ((InterfaceC1433a) this.f30f).mo46f(abstractC1434b, menu);
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: g */
    public void mo47g(AbstractC1434b abstractC1434b) {
        ((InterfaceC1433a) this.f30f).mo47g(abstractC1434b);
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) this.f31g;
        if (layoutInflaterFactory2C1382u.f4952A != null) {
            layoutInflaterFactory2C1382u.f4991p.getDecorView().removeCallbacks(layoutInflaterFactory2C1382u.f4953B);
        }
        if (layoutInflaterFactory2C1382u.f5001z != null) {
            C0330Z c0330z = layoutInflaterFactory2C1382u.f4954C;
            if (c0330z != null) {
                c0330z.m716b();
            }
            C0330Z c0330zM691a = AbstractC0323S.m691a(layoutInflaterFactory2C1382u.f5001z);
            c0330zM691a.m715a(0.0f);
            layoutInflaterFactory2C1382u.f4954C = c0330zM691a;
            c0330zM691a.m718d(new C1375n(2, this));
        }
        layoutInflaterFactory2C1382u.f5000y = null;
        ViewGroup viewGroup = layoutInflaterFactory2C1382u.f4956E;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0311F.m627c(viewGroup);
        layoutInflaterFactory2C1382u.m3379I();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008b  */
    @Override // p029J.InterfaceC0367s
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p029J.C0364q0 mo48h(android.view.View r17, p029J.C0364q0 r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.Object r3 = r0.f31g
            B1.q r3 = (p007B1.C0057q) r3
            int r4 = r3.f202a
            java.lang.Object r5 = r0.f30f
            D2.e r5 = (p015D2.C0181e) r5
            r5.getClass()
            J.o0 r6 = r2.f874a
            r7 = 7
            B.d r7 = r6.mo751f(r7)
            r8 = 32
            B.d r6 = r6.mo751f(r8)
            int r8 = r7.f82b
            java.lang.Object r9 = r5.f423c
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r9
            r9.f4289w = r8
            boolean r8 = p007B1.AbstractC0054n.m215e(r17)
            int r10 = r17.getPaddingBottom()
            int r11 = r17.getPaddingLeft()
            int r12 = r17.getPaddingRight()
            boolean r13 = r9.f4281o
            if (r13 == 0) goto L45
            int r10 = r18.m830a()
            r9.f4288v = r10
            int r14 = r3.f204c
            int r10 = r10 + r14
        L45:
            int r3 = r3.f203b
            boolean r14 = r9.f4282p
            int r15 = r7.f81a
            if (r14 == 0) goto L53
            if (r8 == 0) goto L51
            r11 = r3
            goto L52
        L51:
            r11 = r4
        L52:
            int r11 = r11 + r15
        L53:
            boolean r14 = r9.f4283q
            int r0 = r7.f83c
            if (r14 == 0) goto L5f
            if (r8 == 0) goto L5c
            goto L5d
        L5c:
            r4 = r3
        L5d:
            int r12 = r4 + r0
        L5f:
            android.view.ViewGroup$LayoutParams r3 = r17.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
            boolean r4 = r9.f4285s
            r8 = 1
            if (r4 == 0) goto L72
            int r4 = r3.leftMargin
            if (r4 == r15) goto L72
            r3.leftMargin = r15
            r4 = r8
            goto L73
        L72:
            r4 = 0
        L73:
            boolean r14 = r9.f4286t
            if (r14 == 0) goto L7e
            int r14 = r3.rightMargin
            if (r14 == r0) goto L7e
            r3.rightMargin = r0
            r4 = r8
        L7e:
            boolean r0 = r9.f4287u
            if (r0 == 0) goto L8b
            int r0 = r3.topMargin
            int r7 = r7.f82b
            if (r0 == r7) goto L8b
            r3.topMargin = r7
            goto L8c
        L8b:
            r8 = r4
        L8c:
            if (r8 == 0) goto L91
            r1.setLayoutParams(r3)
        L91:
            int r0 = r17.getPaddingTop()
            r1.setPadding(r11, r0, r12, r10)
            boolean r0 = r5.f422b
            if (r0 == 0) goto La0
            int r1 = r6.f84d
            r9.f4279m = r1
        La0:
            if (r13 != 0) goto La4
            if (r0 == 0) goto La7
        La4:
            r9.m3147G()
        La7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p001A.C0009j.mo48h(android.view.View, J.q0):J.q0");
    }

    @Override // p141s0.InterfaceC1880j
    /* JADX INFO: renamed from: i */
    public void mo49i(File file) {
        C1916b c1916b = (C1916b) this.f31g;
        C1917c c1917c = (C1917c) this.f30f;
        c1917c.f6717g = c1916b;
        c1917c.f6716f = file;
        Runnable runnable = c1917c.f6718h;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: renamed from: j */
    public void m50j(boolean z3) {
        C0918D c0918d = (C0918D) this.f31g;
        Context context = c0918d.f3042n.f3247f;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0918d.f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m50j(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: k */
    public void m51k(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m51k(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: l */
    public void m52l(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m52l(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: m */
    public void m53m(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m53m(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: n */
    public void m54n(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m54n(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: o */
    public void m55o(boolean z3) {
        C0918D c0918d = (C0918D) this.f31g;
        Context context = c0918d.f3042n.f3247f;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0918d.f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m55o(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: p */
    public void m56p(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m56p(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: q */
    public void m57q(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m57q(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: r */
    public void m58r(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m58r(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    @Override // p166z0.InterfaceC2059H
    /* JADX INFO: renamed from: s */
    public void mo59s(Bundle bundle, C1111h c1111h) {
        ((C0271y) this.f31g).m528l((C0261o) this.f30f, bundle, c1111h);
    }

    /* JADX INFO: renamed from: t */
    public void m60t(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m60t(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    public String toString() {
        int iLastIndexOf;
        switch (this.f29e) {
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                StringBuilder sb = new StringBuilder(128);
                sb.append("LoaderManager{");
                sb.append(Integer.toHexString(System.identityHashCode(this)));
                sb.append(" in ");
                InterfaceC0984q interfaceC0984q = (InterfaceC0984q) this.f30f;
                if (interfaceC0984q == null) {
                    sb.append("null");
                } else {
                    String simpleName = interfaceC0984q.getClass().getSimpleName();
                    if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = interfaceC0984q.getClass().getName()).lastIndexOf(46)) > 0) {
                        simpleName = simpleName.substring(iLastIndexOf + 1);
                    }
                    sb.append(simpleName);
                    sb.append('{');
                    sb.append(Integer.toHexString(System.identityHashCode(interfaceC0984q)));
                }
                sb.append("}}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    /* JADX INFO: renamed from: u */
    public void m61u(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m61u(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: v */
    public void m62v(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m62v(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: w */
    public void m63w(boolean z3) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = ((C0918D) this.f31g).f3044p;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.m2494l().f3039k.m63w(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f30f).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            if (!z3) {
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: x */
    public void m64x(String str, PrintWriter printWriter) {
        C1818l c1818l = ((C0673a) this.f31g).f1831c;
        if (c1818l.f6301g > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (c1818l.f6301g <= 0) {
                return;
            }
            AbstractC0032g.m162t(c1818l.f6300f[0]);
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(c1818l.f6299e[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    /* JADX INFO: renamed from: y */
    public void m65y(int[] iArr, int i3) {
        C0622b c0622b;
        C0622b c0622b2;
        C0622b c0622b3;
        if (i3 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i3;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        ArrayList arrayList = (ArrayList) this.f31g;
        int size = arrayList.size();
        int i4 = 0;
        int i5 = 1;
        C0621a c0621a = (C0621a) this.f30f;
        if (i3 >= size) {
            C0622b c0622b4 = (C0622b) arrayList.get(arrayList.size() - 1);
            int size2 = arrayList.size();
            while (size2 <= i3) {
                int[] iArr2 = {i5, c0621a.f1594a[(size2 - 1) + c0621a.f1599f]};
                if (iArr2[i4] == 0) {
                    int i6 = i5;
                    while (i6 < 2 && iArr2[i6] == 0) {
                        i6++;
                    }
                    if (i6 == 2) {
                        iArr2 = new int[]{i4};
                    } else {
                        int i7 = 2 - i6;
                        int[] iArr3 = new int[i7];
                        System.arraycopy(iArr2, i6, iArr3, i4, i7);
                        iArr2 = iArr3;
                    }
                }
                c0622b4.getClass();
                C0621a c0621a2 = c0622b4.f1600a;
                if (!c0621a2.equals(c0621a)) {
                    throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
                }
                int[] iArr4 = c0622b4.f1601b;
                if (iArr4[i4] == 0 || iArr2[i4] == 0) {
                    c0622b4 = c0621a2.f1596c;
                } else {
                    int length2 = iArr4.length;
                    int length3 = iArr2.length;
                    int[] iArr5 = new int[(length2 + length3) - i5];
                    for (int i8 = i4; i8 < length2; i8++) {
                        int i9 = iArr4[i8];
                        int i10 = 0;
                        while (i10 < length3) {
                            int i11 = i8 + i10;
                            iArr5[i11] = iArr5[i11] ^ c0621a2.m1438a(i9, iArr2[i10]);
                            i10++;
                            iArr4 = iArr4;
                        }
                    }
                    c0622b4 = new C0622b(c0621a2, iArr5);
                }
                arrayList.add(c0622b4);
                size2++;
                i4 = 0;
                i5 = 1;
            }
        }
        C0622b c0622b5 = (C0622b) arrayList.get(i3);
        int[] iArr6 = new int[length];
        System.arraycopy(iArr, 0, iArr6, 0, length);
        if (length == 0) {
            throw new IllegalArgumentException();
        }
        if (length > 1 && iArr6[0] == 0) {
            int i12 = 1;
            while (i12 < length && iArr6[i12] == 0) {
                i12++;
            }
            if (i12 == length) {
                iArr6 = new int[]{0};
            } else {
                int i13 = length - i12;
                int[] iArr7 = new int[i13];
                System.arraycopy(iArr6, i12, iArr7, 0, i13);
                iArr6 = iArr7;
            }
        }
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        int length4 = iArr6.length;
        int[] iArr8 = new int[length4 + i3];
        for (int i14 = 0; i14 < length4; i14++) {
            iArr8[i14] = c0621a.m1438a(iArr6[i14], 1);
        }
        C0622b c0622b6 = new C0622b(c0621a, iArr8);
        if (!c0621a.equals(c0622b5.f1600a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        int[] iArr9 = c0622b5.f1601b;
        if (iArr9[0] == 0) {
            throw new IllegalArgumentException("Divide by 0");
        }
        int i15 = iArr9[(iArr9.length - 1) - c0622b5.m1440b()];
        if (i15 == 0) {
            throw new ArithmeticException();
        }
        int i16 = c0621a.f1594a[(c0621a.f1597d - c0621a.f1595b[i15]) - 1];
        C0622b c0622b7 = c0621a.f1596c;
        C0622b c0622bM1439a = c0622b7;
        while (c0622b6.m1440b() >= c0622b5.m1440b()) {
            int[] iArr10 = c0622b6.f1601b;
            if (iArr10[0] == 0) {
                break;
            }
            int iM1440b = c0622b6.m1440b() - c0622b5.m1440b();
            int iM1438a = c0621a.m1438a(iArr10[(iArr10.length - 1) - c0622b6.m1440b()], i16);
            if (iM1440b < 0) {
                throw new IllegalArgumentException();
            }
            C0621a c0621a3 = c0622b5.f1600a;
            if (iM1438a == 0) {
                c0622b2 = c0621a3.f1596c;
                c0622b = c0622b5;
            } else {
                int length5 = iArr9.length;
                int[] iArr11 = new int[length5 + iM1440b];
                int i17 = 0;
                while (i17 < length5) {
                    iArr11[i17] = c0621a3.m1438a(iArr9[i17], iM1438a);
                    i17++;
                    c0622b5 = c0622b5;
                }
                c0622b = c0622b5;
                c0622b2 = new C0622b(c0621a3, iArr11);
            }
            if (iM1440b < 0) {
                throw new IllegalArgumentException();
            }
            if (iM1438a == 0) {
                c0622b3 = c0622b7;
            } else {
                int[] iArr12 = new int[iM1440b + 1];
                iArr12[0] = iM1438a;
                c0622b3 = new C0622b(c0621a, iArr12);
            }
            c0622bM1439a = c0622bM1439a.m1439a(c0622b3);
            c0622b6 = c0622b6.m1439a(c0622b2);
            c0622b5 = c0622b;
        }
        int[] iArr13 = new C0622b[]{c0622bM1439a, c0622b6}[1].f1601b;
        int length6 = i3 - iArr13.length;
        for (int i18 = 0; i18 < length6; i18++) {
            iArr[length + i18] = 0;
        }
        System.arraycopy(iArr13, 0, iArr, length + length6, iArr13.length);
    }

    /* JADX INFO: renamed from: z */
    public void m66z(int i3) {
        int[] iArr = (int[]) this.f30f;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i3, 10) + 1];
            this.f30f = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i3 >= iArr.length) {
            int length = iArr.length;
            while (length <= i3) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f30f = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f30f;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public C0009j(EditText editText) {
        this.f29e = 10;
        this.f30f = editText;
        C0631i c0631i = new C0631i(editText);
        this.f31g = c0631i;
        editText.addTextChangedListener(c0631i);
        if (C0623a.f1603b == null) {
            synchronized (C0623a.f1602a) {
                try {
                    if (C0623a.f1603b == null) {
                        C0623a c0623a = new C0623a();
                        try {
                            C0623a.f1604c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C0623a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        C0623a.f1603b = c0623a;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(C0623a.f1603b);
    }

    public /* synthetic */ C0009j(Object obj, int i3, Object obj2) {
        this.f29e = i3;
        this.f30f = obj;
        this.f31g = obj2;
    }

    public /* synthetic */ C0009j(Object obj, Object obj2, int i3, boolean z3) {
        this.f29e = i3;
        this.f31g = obj;
        this.f30f = obj2;
    }

    public C0009j(int i3) {
        this.f29e = i3;
        switch (i3) {
            case 14:
                this.f30f = new SparseIntArray();
                this.f31g = new SparseIntArray();
                break;
            case 17:
                this.f30f = new C1817k();
                this.f31g = new C1811e();
                break;
            case 24:
                this.f30f = new C1752q(Math.min(64, 1000), 4000);
                this.f31g = new AtomicReference();
                break;
            default:
                this.f30f = new ConcurrentHashMap();
                this.f31g = new ReferenceQueue();
                break;
        }
    }

    public C0009j(C0621a c0621a) {
        this.f29e = 9;
        this.f30f = c0621a;
        ArrayList arrayList = new ArrayList();
        this.f31g = arrayList;
        arrayList.add(new C0622b(c0621a, new int[]{1}));
    }

    public C0009j(InterfaceC0984q interfaceC0984q, C0966K c0966k) {
        AbstractC0964I abstractC0964IM4576e;
        this.f29e = 11;
        this.f30f = interfaceC0984q;
        AbstractC1766e.m3920e("store", c0966k);
        C0667a c0667a = C0667a.f1819b;
        AbstractC1766e.m3920e("defaultCreationExtras", c0667a);
        C2068f c2068f = C0673a.f1830d;
        String canonicalName = C0673a.class.getCanonicalName();
        if (canonicalName != null) {
            String strConcat = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName);
            AbstractC1766e.m3920e("key", strConcat);
            HashMap map = c0966k.f3303a;
            AbstractC0964I abstractC0964I = (AbstractC0964I) map.get(strConcat);
            if (!C0673a.class.isInstance(abstractC0964I)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.putAll(c0667a.f1820a);
                linkedHashMap.put(C0965J.f3302b, strConcat);
                try {
                    abstractC0964IM4576e = c2068f.m4576e(C0673a.class);
                } catch (AbstractMethodError unused) {
                    abstractC0964IM4576e = c2068f.m4576e(C0673a.class);
                }
                abstractC0964I = abstractC0964IM4576e;
                AbstractC0964I abstractC0964I2 = (AbstractC0964I) map.put(strConcat, abstractC0964I);
                if (abstractC0964I2 != null) {
                    abstractC0964I2.mo1631a();
                }
            } else if (abstractC0964I == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            }
            this.f31g = (C0673a) abstractC0964I;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public C0009j(InterfaceC1689l interfaceC1689l, int i3) {
        this.f29e = i3;
        switch (i3) {
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                this.f30f = interfaceC1689l;
                this.f31g = new ConcurrentHashMap();
                break;
            default:
                this.f30f = interfaceC1689l;
                this.f31g = new C0118q();
                break;
        }
    }

    public C0009j(C0918D c0918d) {
        this.f29e = 19;
        this.f30f = new CopyOnWriteArrayList();
        this.f31g = c0918d;
    }

    public C0009j(InterfaceC1693p interfaceC1693p, int i3) {
        this.f29e = i3;
        switch (i3) {
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                this.f30f = interfaceC1693p;
                this.f31g = new ConcurrentHashMap();
                break;
            default:
                this.f30f = interfaceC1693p;
                this.f31g = new C0118q();
                break;
        }
    }

    public C0009j(InterfaceC0795h0 interfaceC0795h0) {
        this.f29e = 16;
        this.f30f = interfaceC0795h0;
        C0793g0 c0793g0 = new C0793g0();
        c0793g0.f2285a = 0;
        this.f31g = c0793g0;
    }

    public C0009j(ArrayList arrayList, ArrayList arrayList2) {
        this.f29e = 0;
        int size = arrayList.size();
        this.f30f = new int[size];
        this.f31g = new float[size];
        for (int i3 = 0; i3 < size; i3++) {
            ((int[]) this.f30f)[i3] = ((Integer) arrayList.get(i3)).intValue();
            ((float[]) this.f31g)[i3] = ((Float) arrayList2.get(i3)).floatValue();
        }
    }

    public C0009j(int i3, int i4) {
        this.f29e = 0;
        this.f30f = new int[]{i3, i4};
        this.f31g = new float[]{0.0f, 1.0f};
    }

    public C0009j(int i3, int i4, int i5) {
        this.f29e = 0;
        this.f30f = new int[]{i3, i4, i5};
        this.f31g = new float[]{0.0f, 0.5f, 1.0f};
    }

    public C0009j(Animation animation) {
        this.f29e = 18;
        this.f30f = animation;
        this.f31g = null;
    }

    public C0009j(Animator animator) {
        this.f29e = 18;
        this.f30f = null;
        this.f31g = animator;
    }

    public C0009j(CardView cardView) {
        this.f29e = 26;
        this.f31g = cardView;
    }
}

package p125o0;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.C1111h;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import p007B1.RunnableC0055o;
import p010C0.AbstractC0147a;
import p026I.C0296d;
import p036L0.C0444d;
import p073Z.C0780a;
import p073Z.C0814z;
import p129p0.AbstractC1823e;
import p129p0.C1819a;
import p129p0.C1820b;
import p141s0.AbstractC1875e;

/* JADX INFO: renamed from: o0.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1798h {

    /* JADX INFO: renamed from: f */
    public static C1798h f6207f;

    /* JADX INFO: renamed from: a */
    public final Object f6208a;

    /* JADX INFO: renamed from: b */
    public final Collection f6209b;

    /* JADX INFO: renamed from: c */
    public final AbstractCollection f6210c;

    /* JADX INFO: renamed from: d */
    public Object f6211d;

    /* JADX INFO: renamed from: e */
    public final Object f6212e;

    public C1798h() {
        this.f6208a = new Handler(Looper.getMainLooper());
        this.f6209b = Collections.newSetFromMap(new WeakHashMap());
        this.f6210c = new HashSet();
        this.f6211d = new HashSet();
        this.f6212e = new HashMap();
    }

    /* JADX INFO: renamed from: h */
    public static synchronized C1798h m3966h() {
        if (AbstractC0147a.f354a.contains(C1798h.class)) {
            return null;
        }
        try {
            if (f6207f == null) {
                f6207f = new C1798h();
            }
            return f6207f;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1798h.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: i */
    public static Bundle m3967i(C1819a c1819a, View view, View view2) {
        List<C1820b> listUnmodifiableList;
        if (AbstractC0147a.f354a.contains(C1798h.class)) {
            return null;
        }
        try {
            Bundle bundle = new Bundle();
            if (c1819a != null && (listUnmodifiableList = Collections.unmodifiableList(c1819a.f6304c)) != null) {
                for (C1820b c1820b : listUnmodifiableList) {
                    String str = c1820b.f6307b;
                    String str2 = c1820b.f6306a;
                    if (str == null || str.length() <= 0) {
                        ArrayList arrayList = c1820b.f6308c;
                        if (arrayList.size() > 0) {
                            Iterator it = (c1820b.f6309d.equals("relative") ? ViewTreeObserverOnGlobalLayoutListenerC1797g.m3960d(view2, arrayList, 0, -1, view2.getClass().getSimpleName()) : ViewTreeObserverOnGlobalLayoutListenerC1797g.m3960d(view, arrayList, 0, -1, view.getClass().getSimpleName())).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    C1796f c1796f = (C1796f) it.next();
                                    if (c1796f.m3959a() != null) {
                                        String strM4064j = AbstractC1823e.m4064j(c1796f.m3959a());
                                        if (strM4064j.length() > 0) {
                                            bundle.putString(str2, strM4064j);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        bundle.putString(str2, c1820b.f6307b);
                    }
                }
            }
            return bundle;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1798h.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3968a(Activity activity) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new C1111h("Can't add activity to CodelessMatcher on non-UI thread");
            }
            ((Set) this.f6209b).add(activity);
            ((HashSet) this.f6211d).clear();
            HashMap map = (HashMap) this.f6212e;
            if (map.containsKey(Integer.valueOf(activity.hashCode()))) {
                this.f6211d = (HashSet) map.get(Integer.valueOf(activity.hashCode()));
            }
            if (set.contains(this)) {
                return;
            }
            try {
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    m3976k();
                } else {
                    ((Handler) this.f6208a).post(new RunnableC0055o(19, this));
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, this);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m3969b(int i3) {
        ArrayList arrayList = (ArrayList) this.f6210c;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            C0780a c0780a = (C0780a) arrayList.get(i4);
            int i5 = c0780a.f2224a;
            if (i5 == 8) {
                if (m3974g(c0780a.f2227d, i4 + 1) == i3) {
                    return true;
                }
            } else if (i5 == 1) {
                int i6 = c0780a.f2225b;
                int i7 = c0780a.f2227d + i6;
                while (i6 < i7) {
                    if (m3974g(i6, i4 + 1) == i3) {
                        return true;
                    }
                    i6++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public void m3970c() {
        ArrayList arrayList = (ArrayList) this.f6210c;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((C0814z) this.f6211d).m2135a((C0780a) arrayList.get(i3));
        }
        m3980o(arrayList);
    }

    /* JADX INFO: renamed from: d */
    public void m3971d() {
        m3970c();
        ArrayList arrayList = (ArrayList) this.f6209b;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0780a c0780a = (C0780a) arrayList.get(i3);
            int i4 = c0780a.f2224a;
            C0814z c0814z = (C0814z) this.f6211d;
            if (i4 == 1) {
                c0814z.m2135a(c0780a);
                c0814z.m2138d(c0780a.f2225b, c0780a.f2227d);
            } else if (i4 == 2) {
                c0814z.m2135a(c0780a);
                int i5 = c0780a.f2225b;
                int i6 = c0780a.f2227d;
                RecyclerView recyclerView = c0814z.f2417a;
                recyclerView.m2589O(i5, i6, true);
                recyclerView.f3423j0 = true;
                recyclerView.f3417g0.f2182c += i6;
            } else if (i4 == 4) {
                c0814z.m2135a(c0780a);
                c0814z.m2137c(c0780a.f2225b, c0780a.f2227d);
            } else if (i4 == 8) {
                c0814z.m2135a(c0780a);
                c0814z.m2139e(c0780a.f2225b, c0780a.f2227d);
            }
        }
        m3980o(arrayList);
    }

    /* JADX INFO: renamed from: e */
    public void m3972e(C0780a c0780a) {
        int i3;
        C0296d c0296d;
        int i4 = c0780a.f2224a;
        if (i4 == 1 || i4 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM3982q = m3982q(c0780a.f2225b, i4);
        int i5 = c0780a.f2225b;
        int i6 = c0780a.f2224a;
        if (i6 == 2) {
            i3 = 0;
        } else {
            if (i6 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + c0780a);
            }
            i3 = 1;
        }
        int i7 = 1;
        int i8 = 1;
        while (true) {
            int i9 = c0780a.f2227d;
            c0296d = (C0296d) this.f6208a;
            if (i7 >= i9) {
                break;
            }
            int iM3982q2 = m3982q((i3 * i7) + c0780a.f2225b, c0780a.f2224a);
            int i10 = c0780a.f2224a;
            if (i10 == 2 ? iM3982q2 != iM3982q : !(i10 == 4 && iM3982q2 == iM3982q + 1)) {
                C0780a c0780aM3977l = m3977l(i10, iM3982q, i8);
                m3973f(c0780aM3977l, i5);
                c0780aM3977l.f2226c = null;
                c0296d.mo573c(c0780aM3977l);
                if (c0780a.f2224a == 4) {
                    i5 += i8;
                }
                i8 = 1;
                iM3982q = iM3982q2;
            } else {
                i8++;
            }
            i7++;
        }
        c0780a.f2226c = null;
        c0296d.mo573c(c0780a);
        if (i8 > 0) {
            C0780a c0780aM3977l2 = m3977l(c0780a.f2224a, iM3982q, i8);
            m3973f(c0780aM3977l2, i5);
            c0780aM3977l2.f2226c = null;
            c0296d.mo573c(c0780aM3977l2);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m3973f(C0780a c0780a, int i3) {
        C0814z c0814z = (C0814z) this.f6211d;
        c0814z.m2135a(c0780a);
        int i4 = c0780a.f2224a;
        if (i4 != 2) {
            if (i4 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            c0814z.m2137c(i3, c0780a.f2227d);
        } else {
            int i5 = c0780a.f2227d;
            RecyclerView recyclerView = c0814z.f2417a;
            recyclerView.m2589O(i3, i5, true);
            recyclerView.f3423j0 = true;
            recyclerView.f3417g0.f2182c += i5;
        }
    }

    /* JADX INFO: renamed from: g */
    public int m3974g(int i3, int i4) {
        ArrayList arrayList = (ArrayList) this.f6210c;
        int size = arrayList.size();
        while (i4 < size) {
            C0780a c0780a = (C0780a) arrayList.get(i4);
            int i5 = c0780a.f2224a;
            if (i5 == 8) {
                int i6 = c0780a.f2225b;
                if (i6 == i3) {
                    i3 = c0780a.f2227d;
                } else {
                    if (i6 < i3) {
                        i3--;
                    }
                    if (c0780a.f2227d <= i3) {
                        i3++;
                    }
                }
            } else {
                int i7 = c0780a.f2225b;
                if (i7 > i3) {
                    continue;
                } else if (i5 == 2) {
                    int i8 = c0780a.f2227d;
                    if (i3 < i7 + i8) {
                        return -1;
                    }
                    i3 -= i8;
                } else if (i5 == 1) {
                    i3 += c0780a.f2227d;
                }
            }
            i4++;
        }
        return i3;
    }

    /* JADX INFO: renamed from: j */
    public boolean m3975j() {
        return ((ArrayList) this.f6209b).size() > 0;
    }

    /* JADX INFO: renamed from: k */
    public void m3976k() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            for (Activity activity : (Set) this.f6209b) {
                if (activity != null) {
                    ((HashSet) this.f6210c).add(new ViewTreeObserverOnGlobalLayoutListenerC1797g(AbstractC1875e.m4196b(activity), (Handler) this.f6208a, (HashSet) this.f6211d, activity.getClass().getSimpleName()));
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    /* JADX INFO: renamed from: l */
    public C0780a m3977l(int i3, int i4, int i5) {
        C0780a c0780a = (C0780a) ((C0296d) this.f6208a).mo571a();
        if (c0780a != null) {
            c0780a.f2224a = i3;
            c0780a.f2225b = i4;
            c0780a.f2227d = i5;
            c0780a.f2226c = null;
            return c0780a;
        }
        C0780a c0780a2 = new C0780a();
        c0780a2.f2224a = i3;
        c0780a2.f2225b = i4;
        c0780a2.f2227d = i5;
        c0780a2.f2226c = null;
        return c0780a2;
    }

    /* JADX INFO: renamed from: m */
    public void m3978m(C0780a c0780a) {
        ((ArrayList) this.f6210c).add(c0780a);
        int i3 = c0780a.f2224a;
        C0814z c0814z = (C0814z) this.f6211d;
        if (i3 == 1) {
            c0814z.m2138d(c0780a.f2225b, c0780a.f2227d);
            return;
        }
        if (i3 == 2) {
            int i4 = c0780a.f2225b;
            int i5 = c0780a.f2227d;
            RecyclerView recyclerView = c0814z.f2417a;
            recyclerView.m2589O(i4, i5, false);
            recyclerView.f3423j0 = true;
            return;
        }
        if (i3 == 4) {
            c0814z.m2137c(c0780a.f2225b, c0780a.f2227d);
        } else if (i3 == 8) {
            c0814z.m2139e(c0780a.f2225b, c0780a.f2227d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + c0780a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0131 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x011d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x000d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a1  */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m3979n() {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p125o0.C1798h.m3979n():void");
    }

    /* JADX INFO: renamed from: o */
    public void m3980o(List list) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0780a c0780a = (C0780a) list.get(i3);
            c0780a.f2226c = null;
            ((C0296d) this.f6208a).mo573c(c0780a);
        }
        list.clear();
    }

    /* JADX INFO: renamed from: p */
    public void m3981p(Activity activity) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new C1111h("Can't remove activity from CodelessMatcher on non-UI thread");
            }
            ((Set) this.f6209b).remove(activity);
            ((HashSet) this.f6210c).clear();
            ((HashMap) this.f6212e).put(Integer.valueOf(activity.hashCode()), (HashSet) ((HashSet) this.f6211d).clone());
            ((HashSet) this.f6211d).clear();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    /* JADX INFO: renamed from: q */
    public int m3982q(int i3, int i4) {
        int i5;
        int i6;
        ArrayList arrayList = (ArrayList) this.f6210c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0780a c0780a = (C0780a) arrayList.get(size);
            int i7 = c0780a.f2224a;
            if (i7 == 8) {
                int i8 = c0780a.f2225b;
                int i9 = c0780a.f2227d;
                if (i8 < i9) {
                    i6 = i8;
                    i5 = i9;
                } else {
                    i5 = i8;
                    i6 = i9;
                }
                if (i3 < i6 || i3 > i5) {
                    if (i3 < i8) {
                        if (i4 == 1) {
                            c0780a.f2225b = i8 + 1;
                            c0780a.f2227d = i9 + 1;
                        } else if (i4 == 2) {
                            c0780a.f2225b = i8 - 1;
                            c0780a.f2227d = i9 - 1;
                        }
                    }
                } else if (i6 == i8) {
                    if (i4 == 1) {
                        c0780a.f2227d = i9 + 1;
                    } else if (i4 == 2) {
                        c0780a.f2227d = i9 - 1;
                    }
                    i3++;
                } else {
                    if (i4 == 1) {
                        c0780a.f2225b = i8 + 1;
                    } else if (i4 == 2) {
                        c0780a.f2225b = i8 - 1;
                    }
                    i3--;
                }
            } else {
                int i10 = c0780a.f2225b;
                if (i10 <= i3) {
                    if (i7 == 1) {
                        i3 -= c0780a.f2227d;
                    } else if (i7 == 2) {
                        i3 += c0780a.f2227d;
                    }
                } else if (i4 == 1) {
                    c0780a.f2225b = i10 + 1;
                } else if (i4 == 2) {
                    c0780a.f2225b = i10 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            C0780a c0780a2 = (C0780a) arrayList.get(size2);
            int i11 = c0780a2.f2224a;
            C0296d c0296d = (C0296d) this.f6208a;
            if (i11 == 8) {
                int i12 = c0780a2.f2227d;
                if (i12 == c0780a2.f2225b || i12 < 0) {
                    arrayList.remove(size2);
                    c0780a2.f2226c = null;
                    c0296d.mo573c(c0780a2);
                }
            } else if (c0780a2.f2227d <= 0) {
                arrayList.remove(size2);
                c0780a2.f2226c = null;
                c0296d.mo573c(c0780a2);
            }
        }
        return i3;
    }

    public C1798h(C0814z c0814z) {
        this.f6208a = new C0296d(30);
        this.f6209b = new ArrayList();
        this.f6210c = new ArrayList();
        this.f6211d = c0814z;
        this.f6212e = new C0444d(this);
    }
}

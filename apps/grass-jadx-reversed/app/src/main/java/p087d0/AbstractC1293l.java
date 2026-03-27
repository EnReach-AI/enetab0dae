package p087d0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;
import p019F0.C0222f;
import p029J.AbstractC0307B;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.C0328X;
import p034K1.C0424k;
import p039M0.AbstractC0473V;
import p125o0.C1803m;
import p128p.AbstractC1810d;
import p128p.C1808b;
import p128p.C1811e;
import p136r.AbstractC1849h;

/* JADX INFO: renamed from: d0.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1293l implements Cloneable {

    /* JADX INFO: renamed from: x */
    public static final int[] f4613x = {2, 1, 3, 4};

    /* JADX INFO: renamed from: y */
    public static final C0222f f4614y = new C0222f(10);

    /* JADX INFO: renamed from: z */
    public static final ThreadLocal f4615z = new ThreadLocal();

    /* JADX INFO: renamed from: o */
    public ArrayList f4626o;

    /* JADX INFO: renamed from: p */
    public ArrayList f4627p;

    /* JADX INFO: renamed from: e */
    public final String f4616e = getClass().getName();

    /* JADX INFO: renamed from: f */
    public long f4617f = -1;

    /* JADX INFO: renamed from: g */
    public long f4618g = -1;

    /* JADX INFO: renamed from: h */
    public TimeInterpolator f4619h = null;

    /* JADX INFO: renamed from: i */
    public final ArrayList f4620i = new ArrayList();

    /* JADX INFO: renamed from: j */
    public final ArrayList f4621j = new ArrayList();

    /* JADX INFO: renamed from: k */
    public C1803m f4622k = new C1803m(4);

    /* JADX INFO: renamed from: l */
    public C1803m f4623l = new C1803m(4);

    /* JADX INFO: renamed from: m */
    public C1282a f4624m = null;

    /* JADX INFO: renamed from: n */
    public final int[] f4625n = f4613x;

    /* JADX INFO: renamed from: q */
    public final ArrayList f4628q = new ArrayList();

    /* JADX INFO: renamed from: r */
    public int f4629r = 0;

    /* JADX INFO: renamed from: s */
    public boolean f4630s = false;

    /* JADX INFO: renamed from: t */
    public boolean f4631t = false;

    /* JADX INFO: renamed from: u */
    public ArrayList f4632u = null;

    /* JADX INFO: renamed from: v */
    public ArrayList f4633v = new ArrayList();

    /* JADX INFO: renamed from: w */
    public C0222f f4634w = f4614y;

    /* JADX INFO: renamed from: b */
    public static void m3262b(C1803m c1803m, View view, C1298q c1298q) {
        ((C1808b) c1803m.f6220f).put(view, c1298q);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) c1803m.f6221g;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        String strM638k = AbstractC0313H.m638k(view);
        if (strM638k != null) {
            C1808b c1808b = (C1808b) c1803m.f6219e;
            if (c1808b.containsKey(strM638k)) {
                c1808b.put(strM638k, null);
            } else {
                c1808b.put(strM638k, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                C1811e c1811e = (C1811e) c1803m.f6222h;
                if (c1811e.f6270e) {
                    c1811e.m4025c();
                }
                if (AbstractC1810d.m4022b(c1811e.f6271f, c1811e.f6273h, itemIdAtPosition) < 0) {
                    AbstractC0307B.m602r(view, true);
                    c1811e.m4027e(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) c1811e.m4026d(itemIdAtPosition, null);
                if (view2 != null) {
                    AbstractC0307B.m602r(view2, false);
                    c1811e.m4027e(itemIdAtPosition, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public static C1808b m3263n() {
        ThreadLocal threadLocal = f4615z;
        C1808b c1808b = (C1808b) threadLocal.get();
        if (c1808b != null) {
            return c1808b;
        }
        C1808b c1808b2 = new C1808b();
        threadLocal.set(c1808b2);
        return c1808b2;
    }

    /* JADX INFO: renamed from: s */
    public static boolean m3264s(C1298q c1298q, C1298q c1298q2, String str) {
        Object obj = c1298q.f4642a.get(str);
        Object obj2 = c1298q2.f4642a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    /* JADX INFO: renamed from: A */
    public void mo3234A(C0222f c0222f) {
        if (c0222f == null) {
            this.f4634w = f4614y;
        } else {
            this.f4634w = c0222f;
        }
    }

    /* JADX INFO: renamed from: B */
    public void mo3235B() {
    }

    /* JADX INFO: renamed from: C */
    public void mo3236C(long j2) {
        this.f4617f = j2;
    }

    /* JADX INFO: renamed from: D */
    public final void m3265D() {
        if (this.f4629r == 0) {
            ArrayList arrayList = this.f4632u;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f4632u.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((InterfaceC1292k) arrayList2.get(i3)).mo3257b();
                }
            }
            this.f4631t = false;
        }
        this.f4629r++;
    }

    /* JADX INFO: renamed from: E */
    public String mo3237E(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f4618g != -1) {
            str2 = str2 + "dur(" + this.f4618g + ") ";
        }
        if (this.f4617f != -1) {
            str2 = str2 + "dly(" + this.f4617f + ") ";
        }
        if (this.f4619h != null) {
            str2 = str2 + "interp(" + this.f4619h + ") ";
        }
        ArrayList arrayList = this.f4620i;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f4621j;
        if (size <= 0 && arrayList2.size() <= 0) {
            return str2;
        }
        String strM4117a = AbstractC1849h.m4117a(str2, "tgts(");
        if (arrayList.size() > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                if (i3 > 0) {
                    strM4117a = AbstractC1849h.m4117a(strM4117a, ", ");
                }
                strM4117a = strM4117a + arrayList.get(i3);
            }
        }
        if (arrayList2.size() > 0) {
            for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                if (i4 > 0) {
                    strM4117a = AbstractC1849h.m4117a(strM4117a, ", ");
                }
                strM4117a = strM4117a + arrayList2.get(i4);
            }
        }
        return AbstractC1849h.m4117a(strM4117a, ")");
    }

    /* JADX INFO: renamed from: a */
    public void m3266a(InterfaceC1292k interfaceC1292k) {
        if (this.f4632u == null) {
            this.f4632u = new ArrayList();
        }
        this.f4632u.add(interfaceC1292k);
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo3239c(C1298q c1298q);

    /* JADX INFO: renamed from: d */
    public final void m3267d(View view, boolean z3) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            C1298q c1298q = new C1298q(view);
            if (z3) {
                mo3241f(c1298q);
            } else {
                mo3239c(c1298q);
            }
            c1298q.f4644c.add(this);
            mo3240e(c1298q);
            if (z3) {
                m3262b(this.f4622k, view, c1298q);
            } else {
                m3262b(this.f4623l, view, c1298q);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                m3267d(viewGroup.getChildAt(i3), z3);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public void mo3240e(C1298q c1298q) {
    }

    /* JADX INFO: renamed from: f */
    public abstract void mo3241f(C1298q c1298q);

    /* JADX INFO: renamed from: g */
    public final void m3268g(ViewGroup viewGroup, boolean z3) {
        m3269h(z3);
        ArrayList arrayList = this.f4620i;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f4621j;
        if (size <= 0 && arrayList2.size() <= 0) {
            m3267d(viewGroup, z3);
            return;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            View viewFindViewById = viewGroup.findViewById(((Integer) arrayList.get(i3)).intValue());
            if (viewFindViewById != null) {
                C1298q c1298q = new C1298q(viewFindViewById);
                if (z3) {
                    mo3241f(c1298q);
                } else {
                    mo3239c(c1298q);
                }
                c1298q.f4644c.add(this);
                mo3240e(c1298q);
                if (z3) {
                    m3262b(this.f4622k, viewFindViewById, c1298q);
                } else {
                    m3262b(this.f4623l, viewFindViewById, c1298q);
                }
            }
        }
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            View view = (View) arrayList2.get(i4);
            C1298q c1298q2 = new C1298q(view);
            if (z3) {
                mo3241f(c1298q2);
            } else {
                mo3239c(c1298q2);
            }
            c1298q2.f4644c.add(this);
            mo3240e(c1298q2);
            if (z3) {
                m3262b(this.f4622k, view, c1298q2);
            } else {
                m3262b(this.f4623l, view, c1298q2);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m3269h(boolean z3) {
        if (z3) {
            ((C1808b) this.f4622k.f6220f).clear();
            ((SparseArray) this.f4622k.f6221g).clear();
            ((C1811e) this.f4622k.f6222h).m4023a();
        } else {
            ((C1808b) this.f4623l.f6220f).clear();
            ((SparseArray) this.f4623l.f6221g).clear();
            ((C1811e) this.f4623l.f6222h).m4023a();
        }
    }

    @Override // 
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public AbstractC1293l clone() {
        try {
            AbstractC1293l abstractC1293l = (AbstractC1293l) super.clone();
            abstractC1293l.f4633v = new ArrayList();
            abstractC1293l.f4622k = new C1803m(4);
            abstractC1293l.f4623l = new C1803m(4);
            abstractC1293l.f4626o = null;
            abstractC1293l.f4627p = null;
            return abstractC1293l;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: j */
    public Animator mo3255j(ViewGroup viewGroup, C1298q c1298q, C1298q c1298q2) {
        return null;
    }

    /* JADX INFO: renamed from: k */
    public void mo3243k(ViewGroup viewGroup, C1803m c1803m, C1803m c1803m2, ArrayList arrayList, ArrayList arrayList2) {
        Animator animatorMo3255j;
        int i3;
        View view;
        C1298q c1298q;
        Animator animator;
        C1808b c1808bM3263n = m3263n();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            C1298q c1298q2 = (C1298q) arrayList.get(i4);
            C1298q c1298q3 = (C1298q) arrayList2.get(i4);
            C1298q c1298q4 = null;
            if (c1298q2 != null && !c1298q2.f4644c.contains(this)) {
                c1298q2 = null;
            }
            if (c1298q3 != null && !c1298q3.f4644c.contains(this)) {
                c1298q3 = null;
            }
            if (!(c1298q2 == null && c1298q3 == null) && ((c1298q2 == null || c1298q3 == null || mo3261q(c1298q2, c1298q3)) && (animatorMo3255j = mo3255j(viewGroup, c1298q2, c1298q3)) != null)) {
                String str = this.f4616e;
                if (c1298q3 != null) {
                    String[] strArrMo3256o = mo3256o();
                    view = c1298q3.f4643b;
                    if (strArrMo3256o != null && strArrMo3256o.length > 0) {
                        c1298q = new C1298q(view);
                        C1298q c1298q5 = (C1298q) ((C1808b) c1803m2.f6220f).getOrDefault(view, null);
                        i3 = size;
                        if (c1298q5 != null) {
                            int i5 = 0;
                            while (i5 < strArrMo3256o.length) {
                                HashMap map = c1298q.f4642a;
                                String str2 = strArrMo3256o[i5];
                                map.put(str2, c1298q5.f4642a.get(str2));
                                i5++;
                                strArrMo3256o = strArrMo3256o;
                            }
                        }
                        int i6 = c1808bM3263n.f6297g;
                        for (int i7 = 0; i7 < i6; i7++) {
                            animator = null;
                            C1291j c1291j = (C1291j) c1808bM3263n.getOrDefault((Animator) c1808bM3263n.m4039h(i7), null);
                            if (c1291j.f4610c != null && c1291j.f4608a == view && c1291j.f4609b.equals(str) && c1291j.f4610c.equals(c1298q)) {
                                break;
                            }
                        }
                    } else {
                        i3 = size;
                        c1298q = null;
                    }
                    animator = animatorMo3255j;
                    animatorMo3255j = animator;
                    c1298q4 = c1298q;
                } else {
                    i3 = size;
                    view = c1298q2.f4643b;
                }
                if (animatorMo3255j != null) {
                    C1300s c1300s = AbstractC1299r.f4645a;
                    C1305x c1305x = new C1305x(viewGroup);
                    C1291j c1291j2 = new C1291j();
                    c1291j2.f4608a = view;
                    c1291j2.f4609b = str;
                    c1291j2.f4610c = c1298q4;
                    c1291j2.f4611d = c1305x;
                    c1291j2.f4612e = this;
                    c1808bM3263n.put(animatorMo3255j, c1291j2);
                    this.f4633v.add(animatorMo3255j);
                }
            } else {
                i3 = size;
            }
            i4++;
            size = i3;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator2 = (Animator) this.f4633v.get(sparseIntArray.keyAt(i8));
                animator2.setStartDelay(animator2.getStartDelay() + (((long) sparseIntArray.valueAt(i8)) - Long.MAX_VALUE));
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m3270l() {
        int i3 = this.f4629r - 1;
        this.f4629r = i3;
        if (i3 == 0) {
            ArrayList arrayList = this.f4632u;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f4632u.clone();
                int size = arrayList2.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ((InterfaceC1292k) arrayList2.get(i4)).mo3252d(this);
                }
            }
            for (int i5 = 0; i5 < ((C1811e) this.f4622k.f6222h).m4028f(); i5++) {
                View view = (View) ((C1811e) this.f4622k.f6222h).m4029g(i5);
                if (view != null) {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    AbstractC0307B.m602r(view, false);
                }
            }
            for (int i6 = 0; i6 < ((C1811e) this.f4623l.f6222h).m4028f(); i6++) {
                View view2 = (View) ((C1811e) this.f4623l.f6222h).m4029g(i6);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                    AbstractC0307B.m602r(view2, false);
                }
            }
            this.f4631t = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r6 = r5.f4627p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r6 = r5.f4626o;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return (p087d0.C1298q) r6.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p087d0.C1298q m3271m(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            d0.a r0 = r5.f4624m
            if (r0 == 0) goto L9
            d0.q r6 = r0.m3271m(r6, r7)
            return r6
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList r0 = r5.f4626o
            goto L10
        Le:
            java.util.ArrayList r0 = r5.f4627p
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            d0.q r4 = (p087d0.C1298q) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f4643b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList r6 = r5.f4627p
            goto L36
        L34:
            java.util.ArrayList r6 = r5.f4626o
        L36:
            java.lang.Object r6 = r6.get(r3)
            r1 = r6
            d0.q r1 = (p087d0.C1298q) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p087d0.AbstractC1293l.m3271m(android.view.View, boolean):d0.q");
    }

    /* JADX INFO: renamed from: o */
    public String[] mo3256o() {
        return null;
    }

    /* JADX INFO: renamed from: p */
    public final C1298q m3272p(View view, boolean z3) {
        C1282a c1282a = this.f4624m;
        if (c1282a != null) {
            return c1282a.m3272p(view, z3);
        }
        return (C1298q) ((C1808b) (z3 ? this.f4622k : this.f4623l).f6220f).getOrDefault(view, null);
    }

    /* JADX INFO: renamed from: q */
    public boolean mo3261q(C1298q c1298q, C1298q c1298q2) {
        if (c1298q == null || c1298q2 == null) {
            return false;
        }
        String[] strArrMo3256o = mo3256o();
        if (strArrMo3256o == null) {
            Iterator it = c1298q.f4642a.keySet().iterator();
            while (it.hasNext()) {
                if (m3264s(c1298q, c1298q2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : strArrMo3256o) {
            if (!m3264s(c1298q, c1298q2, str)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: renamed from: r */
    public final boolean m3273r(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f4620i;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f4621j;
        return (size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view);
    }

    /* JADX INFO: renamed from: t */
    public void mo3244t(View view) {
        if (this.f4631t) {
            return;
        }
        C1808b c1808bM3263n = m3263n();
        int i3 = c1808bM3263n.f6297g;
        C1300s c1300s = AbstractC1299r.f4645a;
        WindowId windowId = view.getWindowId();
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            C1291j c1291j = (C1291j) c1808bM3263n.m4041j(i4);
            if (c1291j.f4608a != null) {
                C1305x c1305x = c1291j.f4611d;
                if ((c1305x instanceof C1305x) && c1305x.f4667a.equals(windowId)) {
                    ((Animator) c1808bM3263n.m4039h(i4)).pause();
                }
            }
        }
        ArrayList arrayList = this.f4632u;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.f4632u.clone();
            int size = arrayList2.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((InterfaceC1292k) arrayList2.get(i5)).mo3251c();
            }
        }
        this.f4630s = true;
    }

    public final String toString() {
        return mo3237E("");
    }

    /* JADX INFO: renamed from: u */
    public void m3274u(InterfaceC1292k interfaceC1292k) {
        ArrayList arrayList = this.f4632u;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC1292k);
        if (this.f4632u.size() == 0) {
            this.f4632u = null;
        }
    }

    /* JADX INFO: renamed from: v */
    public void mo3245v(View view) {
        if (this.f4630s) {
            if (!this.f4631t) {
                C1808b c1808bM3263n = m3263n();
                int i3 = c1808bM3263n.f6297g;
                C1300s c1300s = AbstractC1299r.f4645a;
                WindowId windowId = view.getWindowId();
                for (int i4 = i3 - 1; i4 >= 0; i4--) {
                    C1291j c1291j = (C1291j) c1808bM3263n.m4041j(i4);
                    if (c1291j.f4608a != null) {
                        C1305x c1305x = c1291j.f4611d;
                        if ((c1305x instanceof C1305x) && c1305x.f4667a.equals(windowId)) {
                            ((Animator) c1808bM3263n.m4039h(i4)).resume();
                        }
                    }
                }
                ArrayList arrayList = this.f4632u;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.f4632u.clone();
                    int size = arrayList2.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        ((InterfaceC1292k) arrayList2.get(i5)).mo3253e();
                    }
                }
            }
            this.f4630s = false;
        }
    }

    /* JADX INFO: renamed from: w */
    public void mo3246w() {
        m3265D();
        C1808b c1808bM3263n = m3263n();
        for (Animator animator : this.f4633v) {
            if (c1808bM3263n.containsKey(animator)) {
                m3265D();
                if (animator != null) {
                    animator.addListener(new C0328X(this, c1808bM3263n));
                    long j2 = this.f4618g;
                    if (j2 >= 0) {
                        animator.setDuration(j2);
                    }
                    long j3 = this.f4617f;
                    if (j3 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j3);
                    }
                    TimeInterpolator timeInterpolator = this.f4619h;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new C0424k(1, this));
                    animator.start();
                }
            }
        }
        this.f4633v.clear();
        m3270l();
    }

    /* JADX INFO: renamed from: x */
    public void mo3247x(long j2) {
        this.f4618g = j2;
    }

    /* JADX INFO: renamed from: y */
    public void mo3248y(AbstractC0473V abstractC0473V) {
    }

    /* JADX INFO: renamed from: z */
    public void mo3249z(TimeInterpolator timeInterpolator) {
        this.f4619h = timeInterpolator;
    }
}

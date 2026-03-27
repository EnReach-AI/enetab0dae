package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p005B.AbstractC0032g;
import p113l.C1657a;
import p116m.C1700a;
import p116m.C1702c;

/* JADX INFO: renamed from: androidx.lifecycle.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0986s {

    /* JADX INFO: renamed from: a */
    public C1700a f3327a;

    /* JADX INFO: renamed from: b */
    public EnumC0979l f3328b;

    /* JADX INFO: renamed from: c */
    public final WeakReference f3329c;

    /* JADX INFO: renamed from: d */
    public int f3330d;

    /* JADX INFO: renamed from: e */
    public boolean f3331e;

    /* JADX INFO: renamed from: f */
    public boolean f3332f;

    /* JADX INFO: renamed from: g */
    public final ArrayList f3333g;

    /* JADX INFO: renamed from: h */
    public final boolean f3334h;

    public C0986s(InterfaceC0984q interfaceC0984q) {
        new AtomicReference();
        this.f3327a = new C1700a();
        this.f3330d = 0;
        this.f3331e = false;
        this.f3332f = false;
        this.f3333g = new ArrayList();
        this.f3329c = new WeakReference(interfaceC0984q);
        this.f3328b = EnumC0979l.f3319f;
        this.f3334h = true;
    }

    /* JADX INFO: renamed from: a */
    public final void m2515a(InterfaceC0983p interfaceC0983p) {
        InterfaceC0982o reflectiveGenericLifecycleObserver;
        InterfaceC0984q interfaceC0984q;
        ArrayList arrayList = this.f3333g;
        m2517c("addObserver");
        EnumC0979l enumC0979l = this.f3328b;
        EnumC0979l enumC0979l2 = EnumC0979l.f3318e;
        if (enumC0979l != enumC0979l2) {
            enumC0979l2 = EnumC0979l.f3319f;
        }
        C0985r c0985r = new C0985r();
        HashMap map = AbstractC0987t.f3335a;
        boolean z3 = interfaceC0983p instanceof InterfaceC0982o;
        boolean z4 = interfaceC0983p instanceof InterfaceC0971d;
        if (z3 && z4) {
            reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((InterfaceC0971d) interfaceC0983p, (InterfaceC0982o) interfaceC0983p);
        } else if (z4) {
            reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((InterfaceC0971d) interfaceC0983p, null);
        } else if (z3) {
            reflectiveGenericLifecycleObserver = (InterfaceC0982o) interfaceC0983p;
        } else {
            Class<?> cls = interfaceC0983p.getClass();
            if (AbstractC0987t.m2524c(cls) == 2) {
                List list = (List) AbstractC0987t.f3336b.get(cls);
                if (list.size() == 1) {
                    AbstractC0987t.m2522a((Constructor) list.get(0), interfaceC0983p);
                    reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver();
                } else {
                    InterfaceC0974g[] interfaceC0974gArr = new InterfaceC0974g[list.size()];
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        AbstractC0987t.m2522a((Constructor) list.get(i3), interfaceC0983p);
                        interfaceC0974gArr[i3] = null;
                    }
                    reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(interfaceC0974gArr);
                }
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(interfaceC0983p);
            }
        }
        c0985r.f3326b = reflectiveGenericLifecycleObserver;
        c0985r.f3325a = enumC0979l2;
        if (((C0985r) this.f3327a.m3785c(interfaceC0983p, c0985r)) == null && (interfaceC0984q = (InterfaceC0984q) this.f3329c.get()) != null) {
            boolean z5 = this.f3330d != 0 || this.f3331e;
            EnumC0979l enumC0979lM2516b = m2516b(interfaceC0983p);
            this.f3330d++;
            while (c0985r.f3325a.compareTo(enumC0979lM2516b) < 0 && this.f3327a.f5957i.containsKey(interfaceC0983p)) {
                arrayList.add(c0985r.f3325a);
                int iOrdinal = c0985r.f3325a.ordinal();
                EnumC0978k enumC0978k = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : EnumC0978k.ON_RESUME : EnumC0978k.ON_START : EnumC0978k.ON_CREATE;
                if (enumC0978k == null) {
                    throw new IllegalStateException("no event up from " + c0985r.f3325a);
                }
                c0985r.m2514a(interfaceC0984q, enumC0978k);
                arrayList.remove(arrayList.size() - 1);
                enumC0979lM2516b = m2516b(interfaceC0983p);
            }
            if (!z5) {
                m2521g();
            }
            this.f3330d--;
        }
    }

    /* JADX INFO: renamed from: b */
    public final EnumC0979l m2516b(InterfaceC0983p interfaceC0983p) {
        HashMap map = this.f3327a.f5957i;
        C1702c c1702c = map.containsKey(interfaceC0983p) ? ((C1702c) map.get(interfaceC0983p)).f5964h : null;
        EnumC0979l enumC0979l = c1702c != null ? ((C0985r) c1702c.f5962f).f3325a : null;
        ArrayList arrayList = this.f3333g;
        EnumC0979l enumC0979l2 = arrayList.isEmpty() ? null : (EnumC0979l) arrayList.get(arrayList.size() - 1);
        EnumC0979l enumC0979l3 = this.f3328b;
        if (enumC0979l == null || enumC0979l.compareTo(enumC0979l3) >= 0) {
            enumC0979l = enumC0979l3;
        }
        return (enumC0979l2 == null || enumC0979l2.compareTo(enumC0979l) >= 0) ? enumC0979l : enumC0979l2;
    }

    /* JADX INFO: renamed from: c */
    public final void m2517c(String str) {
        if (this.f3334h) {
            ((C1657a) C1657a.m3748u().f5880f).getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(AbstractC0032g.m154l("Method ", str, " must be called on the main thread"));
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m2518d(EnumC0978k enumC0978k) {
        m2517c("handleLifecycleEvent");
        m2519e(enumC0978k.m2512a());
    }

    /* JADX INFO: renamed from: e */
    public final void m2519e(EnumC0979l enumC0979l) {
        EnumC0979l enumC0979l2 = this.f3328b;
        if (enumC0979l2 == enumC0979l) {
            return;
        }
        EnumC0979l enumC0979l3 = EnumC0979l.f3319f;
        EnumC0979l enumC0979l4 = EnumC0979l.f3318e;
        if (enumC0979l2 == enumC0979l3 && enumC0979l == enumC0979l4) {
            throw new IllegalStateException("no event down from " + this.f3328b);
        }
        this.f3328b = enumC0979l;
        if (this.f3331e || this.f3330d != 0) {
            this.f3332f = true;
            return;
        }
        this.f3331e = true;
        m2521g();
        this.f3331e = false;
        if (this.f3328b == enumC0979l4) {
            this.f3327a = new C1700a();
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m2520f(InterfaceC0983p interfaceC0983p) {
        m2517c("removeObserver");
        this.f3327a.mo3784b(interfaceC0983p);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        r11.f3332f = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0051, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x00f4, code lost:
    
        continue;
     */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2521g() {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.C0986s.m2521g():void");
    }
}

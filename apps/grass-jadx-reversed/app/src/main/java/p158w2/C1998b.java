package p158w2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: w2.b */
/* JADX INFO: loaded from: classes.dex */
public class C1998b {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7137a = AtomicReferenceFieldUpdater.newUpdater(C1998b.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur = new C2000d(8, false);

    /* JADX INFO: renamed from: a */
    public final boolean m4448a(Object obj) {
        while (true) {
            C2000d c2000d = (C2000d) this._cur;
            int iM4452a = c2000d.m4452a(obj);
            if (iM4452a == 0) {
                return true;
            }
            if (iM4452a == 1) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7137a;
                C2000d c2000dM4456e = c2000d.m4456e();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, c2000d, c2000dM4456e) && atomicReferenceFieldUpdater.get(this) == c2000d) {
                }
            } else if (iM4452a == 2) {
                return false;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4449b() {
        while (true) {
            C2000d c2000d = (C2000d) this._cur;
            if (c2000d.m4453b()) {
                return;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7137a;
            C2000d c2000dM4456e = c2000d.m4456e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, c2000d, c2000dM4456e) && atomicReferenceFieldUpdater.get(this) == c2000d) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m4450c() {
        return ((C2000d) this._cur).m4454c();
    }

    /* JADX INFO: renamed from: d */
    public final Object m4451d() {
        while (true) {
            C2000d c2000d = (C2000d) this._cur;
            Object objM4457f = c2000d.m4457f();
            if (objM4457f != C2000d.f7141g) {
                return objM4457f;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7137a;
            C2000d c2000dM4456e = c2000d.m4456e();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, c2000d, c2000dM4456e) && atomicReferenceFieldUpdater.get(this) == c2000d) {
            }
        }
    }
}

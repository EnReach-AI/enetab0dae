package p083b2;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p115l2.InterfaceC1678a;

/* JADX INFO: renamed from: b2.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1064i implements InterfaceC1059d, Serializable {

    /* JADX INFO: renamed from: g */
    public static final AtomicReferenceFieldUpdater f3740g = AtomicReferenceFieldUpdater.newUpdater(C1064i.class, Object.class, "f");

    /* JADX INFO: renamed from: e */
    public volatile InterfaceC1678a f3741e;

    /* JADX INFO: renamed from: f */
    public volatile Object f3742f;

    private final Object writeReplace() {
        return new C1058c(getValue());
    }

    @Override // p083b2.InterfaceC1059d
    public final Object getValue() {
        Object obj = this.f3742f;
        C1074s c1074s = C1074s.f3758a;
        if (obj != c1074s) {
            return obj;
        }
        InterfaceC1678a interfaceC1678a = this.f3741e;
        if (interfaceC1678a != null) {
            Object objMo263a = interfaceC1678a.mo263a();
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3740g;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, c1074s, objMo263a)) {
                if (atomicReferenceFieldUpdater.get(this) != c1074s) {
                }
            }
            this.f3741e = null;
            return objMo263a;
        }
        return this.f3742f;
    }

    public final String toString() {
        return this.f3742f != C1074s.f3758a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}

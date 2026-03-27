package p008B2;

import java.lang.ref.SoftReference;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0118q extends ClassValue {
    @Override // java.lang.ClassValue
    public final Object computeValue(Class cls) {
        AbstractC1766e.m3920e("type", cls);
        C0080U c0080u = new C0080U();
        c0080u.f250a = new SoftReference(null);
        return c0080u;
    }
}

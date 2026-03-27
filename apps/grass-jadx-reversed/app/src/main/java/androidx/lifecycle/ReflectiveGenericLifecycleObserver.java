package androidx.lifecycle;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
class ReflectiveGenericLifecycleObserver implements InterfaceC0982o {

    /* JADX INFO: renamed from: a */
    public final Object f3304a;

    /* JADX INFO: renamed from: b */
    public final C0968a f3305b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3304a = obj;
        C0970c c0970c = C0970c.f3312c;
        Class<?> cls = obj.getClass();
        C0968a c0968a = (C0968a) c0970c.f3313a.get(cls);
        this.f3305b = c0968a == null ? c0970c.m2510a(cls, null) : c0968a;
    }

    @Override // androidx.lifecycle.InterfaceC0982o
    /* JADX INFO: renamed from: b */
    public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        HashMap map = this.f3305b.f3308a;
        List list = (List) map.get(enumC0978k);
        Object obj = this.f3304a;
        C0968a.m2508a(list, interfaceC0984q, enumC0978k, obj);
        C0968a.m2508a((List) map.get(EnumC0978k.ON_ANY), interfaceC0984q, enumC0978k, obj);
    }
}

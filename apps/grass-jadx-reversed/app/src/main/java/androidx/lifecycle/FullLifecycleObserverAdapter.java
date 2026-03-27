package androidx.lifecycle;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;

/* JADX INFO: loaded from: classes.dex */
class FullLifecycleObserverAdapter implements InterfaceC0982o {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0971d f3292a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC0982o f3293b;

    public FullLifecycleObserverAdapter(InterfaceC0971d interfaceC0971d, InterfaceC0982o interfaceC0982o) {
        this.f3292a = interfaceC0971d;
        this.f3293b = interfaceC0982o;
    }

    @Override // androidx.lifecycle.InterfaceC0982o
    /* JADX INFO: renamed from: b */
    public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        int i3 = AbstractC0973f.f3315a[enumC0978k.ordinal()];
        InterfaceC0971d interfaceC0971d = this.f3292a;
        switch (i3) {
            case 1:
                interfaceC0971d.getClass();
                break;
            case 2:
                interfaceC0971d.getClass();
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                interfaceC0971d.mo2338a();
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                interfaceC0971d.getClass();
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                interfaceC0971d.getClass();
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                interfaceC0971d.getClass();
                break;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC0982o interfaceC0982o = this.f3293b;
        if (interfaceC0982o != null) {
            interfaceC0982o.mo2170b(interfaceC0984q, enumC0978k);
        }
    }
}

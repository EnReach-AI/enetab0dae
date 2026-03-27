package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.C0976i;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.InterfaceC0982o;
import androidx.lifecycle.InterfaceC0984q;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import p005B.AbstractC0032g;
import p077a0.InterfaceC0844c;
import p077a0.InterfaceC0848g;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class Recreator implements InterfaceC0982o {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0848g f3474a;

    public Recreator(InterfaceC0848g interfaceC0848g) {
        AbstractC1766e.m3920e("owner", interfaceC0848g);
        this.f3474a = interfaceC0848g;
    }

    @Override // androidx.lifecycle.InterfaceC0982o
    /* JADX INFO: renamed from: b */
    public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
        if (enumC0978k != EnumC0978k.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        interfaceC0984q.mo2199d().m2520f(this);
        InterfaceC0848g interfaceC0848g = this.f3474a;
        Bundle bundleM2174d = interfaceC0848g.mo2186b().m2174d("androidx.savedstate.Restarter");
        if (bundleM2174d == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleM2174d.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        for (String str : stringArrayList) {
            try {
                Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(InterfaceC0844c.class);
                AbstractC1766e.m3919d("{\n                Class.…class.java)\n            }", clsAsSubclass);
                try {
                    Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object objNewInstance = declaredConstructor.newInstance(null);
                        AbstractC1766e.m3919d("{\n                constr…wInstance()\n            }", objNewInstance);
                        ((C0976i) ((InterfaceC0844c) objNewInstance)).m2511a(interfaceC0848g);
                    } catch (Exception e3) {
                        throw new RuntimeException(AbstractC0032g.m152j("Failed to instantiate ", str), e3);
                    }
                } catch (NoSuchMethodException e4) {
                    throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
                }
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException(AbstractC0032g.m154l("Class ", str, " wasn't found"), e5);
            }
        }
    }
}

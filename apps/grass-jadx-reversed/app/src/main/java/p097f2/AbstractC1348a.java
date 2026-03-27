package p097f2;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p083b2.C1062g;
import p089d2.InterfaceC1312f;
import p093e2.EnumC1340a;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: f2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1348a implements InterfaceC1312f, Serializable {

    /* JADX INFO: renamed from: e */
    public final InterfaceC1312f f4814e;

    public AbstractC1348a(InterfaceC1312f interfaceC1312f) {
        this.f4814e = interfaceC1312f;
    }

    @Override // p089d2.InterfaceC1312f
    /* JADX INFO: renamed from: e */
    public final void mo3284e(Object obj) {
        InterfaceC1312f interfaceC1312f = this;
        while (true) {
            AbstractC1348a abstractC1348a = (AbstractC1348a) interfaceC1312f;
            InterfaceC1312f interfaceC1312f2 = abstractC1348a.f4814e;
            AbstractC1766e.m3917b(interfaceC1312f2);
            try {
                obj = abstractC1348a.mo339g(obj);
                if (obj == EnumC1340a.f4774e) {
                    return;
                }
            } catch (Throwable th) {
                obj = new C1062g(th);
            }
            abstractC1348a.mo3303h();
            if (!(interfaceC1312f2 instanceof AbstractC1348a)) {
                interfaceC1312f2.mo3284e(obj);
                return;
            }
            interfaceC1312f = interfaceC1312f2;
        }
    }

    /* JADX INFO: renamed from: g */
    public abstract Object mo339g(Object obj);

    /* JADX INFO: renamed from: h */
    public void mo3303h() {
    }

    public String toString() {
        int iIntValue;
        String strM3304c;
        StringBuilder sb = new StringBuilder("Continuation at ");
        InterfaceC1351d interfaceC1351d = (InterfaceC1351d) getClass().getAnnotation(InterfaceC1351d.class);
        Object name = null;
        str = null;
        str = null;
        str = null;
        String str = null;
        if (interfaceC1351d != null) {
            int iM3308v = interfaceC1351d.m3308v();
            if (iM3308v > 1) {
                throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iM3308v + ". Please update the Kotlin standard library.").toString());
            }
            try {
                Field declaredField = getClass().getDeclaredField("label");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(this);
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                iIntValue = (num != null ? num.intValue() : 0) - 1;
            } catch (Exception unused) {
                iIntValue = -1;
            }
            int i3 = iIntValue >= 0 ? interfaceC1351d.m3306l()[iIntValue] : -1;
            C1352e c1352e = AbstractC1353f.f4822b;
            C1352e c1352e2 = AbstractC1353f.f4821a;
            if (c1352e == null) {
                try {
                    C1352e c1352e3 = new C1352e(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                    AbstractC1353f.f4822b = c1352e3;
                    c1352e = c1352e3;
                } catch (Exception unused2) {
                    AbstractC1353f.f4822b = c1352e2;
                    c1352e = c1352e2;
                }
            }
            if (c1352e != c1352e2) {
                Method method = c1352e.f4818a;
                Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
                if (objInvoke != null) {
                    Method method2 = c1352e.f4819b;
                    Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                    if (objInvoke2 != null) {
                        Method method3 = c1352e.f4820c;
                        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                        if (objInvoke3 instanceof String) {
                            str = (String) objInvoke3;
                        }
                    }
                }
            }
            if (str == null) {
                strM3304c = interfaceC1351d.m3304c();
            } else {
                strM3304c = str + '/' + interfaceC1351d.m3304c();
            }
            name = new StackTraceElement(strM3304c, interfaceC1351d.m3307m(), interfaceC1351d.m3305f(), i3);
        }
        if (name == null) {
            name = getClass().getName();
        }
        sb.append(name);
        return sb.toString();
    }
}

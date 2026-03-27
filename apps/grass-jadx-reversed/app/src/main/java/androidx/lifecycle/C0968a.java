package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0968a {

    /* JADX INFO: renamed from: a */
    public final HashMap f3308a = new HashMap();

    /* JADX INFO: renamed from: b */
    public final Map f3309b;

    public C0968a(HashMap map) {
        this.f3309b = map;
        for (Map.Entry entry : map.entrySet()) {
            EnumC0978k enumC0978k = (EnumC0978k) entry.getValue();
            List arrayList = (List) this.f3308a.get(enumC0978k);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f3308a.put(enumC0978k, arrayList);
            }
            arrayList.add((C0969b) entry.getKey());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2508a(List list, InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0969b c0969b = (C0969b) list.get(size);
                c0969b.getClass();
                try {
                    int i3 = c0969b.f3310a;
                    Method method = c0969b.f3311b;
                    if (i3 == 0) {
                        method.invoke(obj, null);
                    } else if (i3 == 1) {
                        method.invoke(obj, interfaceC0984q);
                    } else if (i3 == 2) {
                        method.invoke(obj, interfaceC0984q, enumC0978k);
                    }
                } catch (IllegalAccessException e3) {
                    throw new RuntimeException(e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException("Failed to call observer method", e4.getCause());
                }
            }
        }
    }
}

package androidx.lifecycle;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: androidx.lifecycle.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0970c {

    /* JADX INFO: renamed from: c */
    public static final C0970c f3312c = new C0970c();

    /* JADX INFO: renamed from: a */
    public final HashMap f3313a = new HashMap();

    /* JADX INFO: renamed from: b */
    public final HashMap f3314b = new HashMap();

    /* JADX INFO: renamed from: b */
    public static void m2509b(HashMap map, C0969b c0969b, EnumC0978k enumC0978k, Class cls) {
        EnumC0978k enumC0978k2 = (EnumC0978k) map.get(c0969b);
        if (enumC0978k2 == null || enumC0978k == enumC0978k2) {
            if (enumC0978k2 == null) {
                map.put(c0969b, enumC0978k);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0969b.f3311b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + enumC0978k2 + ", new value " + enumC0978k);
    }

    /* JADX INFO: renamed from: a */
    public final C0968a m2510a(Class cls, Method[] methodArr) {
        int i3;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        HashMap map2 = this.f3313a;
        if (superclass != null) {
            C0968a c0968aM2510a = (C0968a) map2.get(superclass);
            if (c0968aM2510a == null) {
                c0968aM2510a = m2510a(superclass, null);
            }
            map.putAll(c0968aM2510a.f3309b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            C0968a c0968aM2510a2 = (C0968a) map2.get(cls2);
            if (c0968aM2510a2 == null) {
                c0968aM2510a2 = m2510a(cls2, null);
            }
            for (Map.Entry entry : c0968aM2510a2.f3309b.entrySet()) {
                m2509b(map, (C0969b) entry.getKey(), (EnumC0978k) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e3) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e3);
            }
        }
        boolean z3 = false;
        for (Method method : methodArr) {
            InterfaceC0991x interfaceC0991x = (InterfaceC0991x) method.getAnnotation(InterfaceC0991x.class);
            if (interfaceC0991x != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i3 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(InterfaceC0984q.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i3 = 1;
                }
                EnumC0978k enumC0978kValue = interfaceC0991x.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(EnumC0978k.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (enumC0978kValue != EnumC0978k.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i3 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m2509b(map, new C0969b(i3, method), enumC0978kValue, cls);
                z3 = true;
            }
        }
        C0968a c0968a = new C0968a(map);
        map2.put(cls, c0968a);
        this.f3314b.put(cls, Boolean.valueOf(z3));
        return c0968a;
    }
}

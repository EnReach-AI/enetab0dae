package p119m2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p015D2.C0193q;
import p083b2.C1061f;
import p086c2.AbstractC1086e;
import p086c2.AbstractC1087f;
import p086c2.AbstractC1097p;
import p115l2.InterfaceC1678a;
import p115l2.InterfaceC1679b;
import p115l2.InterfaceC1680c;
import p115l2.InterfaceC1681d;
import p115l2.InterfaceC1682e;
import p115l2.InterfaceC1683f;
import p115l2.InterfaceC1684g;
import p115l2.InterfaceC1685h;
import p115l2.InterfaceC1686i;
import p115l2.InterfaceC1687j;
import p115l2.InterfaceC1688k;
import p115l2.InterfaceC1689l;
import p115l2.InterfaceC1690m;
import p115l2.InterfaceC1691n;
import p115l2.InterfaceC1692o;
import p115l2.InterfaceC1693p;
import p115l2.InterfaceC1694q;
import p115l2.InterfaceC1695r;
import p115l2.InterfaceC1696s;
import p115l2.InterfaceC1697t;
import p115l2.InterfaceC1698u;
import p115l2.InterfaceC1699v;
import p135q2.InterfaceC1840a;
import p142s2.AbstractC1892g;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: m2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1763b implements InterfaceC1840a, InterfaceC1762a {

    /* JADX INFO: renamed from: b */
    public static final Map f6140b;

    /* JADX INFO: renamed from: c */
    public static final LinkedHashMap f6141c;

    /* JADX INFO: renamed from: a */
    public final Class f6142a;

    static {
        List listM2837u = AbstractC1086e.m2837u(InterfaceC1678a.class, InterfaceC1689l.class, InterfaceC1693p.class, C0193q.class, InterfaceC1694q.class, InterfaceC1695r.class, InterfaceC1696s.class, InterfaceC1697t.class, InterfaceC1698u.class, InterfaceC1699v.class, InterfaceC1679b.class, InterfaceC1680c.class, InterfaceC1681d.class, InterfaceC1682e.class, InterfaceC1683f.class, InterfaceC1684g.class, InterfaceC1685h.class, InterfaceC1686i.class, InterfaceC1687j.class, InterfaceC1688k.class, InterfaceC1690m.class, InterfaceC1691n.class, InterfaceC1692o.class);
        ArrayList arrayList = new ArrayList(AbstractC1087f.m2838v(listM2837u, 10));
        int i3 = 0;
        for (Object obj : listM2837u) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                throw new ArithmeticException("Index overflow has happened.");
            }
            arrayList.add(new C1061f((Class) obj, Integer.valueOf(i3)));
            i3 = i4;
        }
        f6140b = AbstractC1097p.m2842k(arrayList);
        HashMap map = new HashMap();
        map.put("boolean", "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put("float", "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        HashMap map2 = new HashMap();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        HashMap map3 = new HashMap();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        AbstractC1766e.m3919d("<get-values>(...)", collectionValues);
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder("kotlin.jvm.internal.");
            AbstractC1766e.m3917b(str);
            sb.append(AbstractC1892g.m4226s(str));
            sb.append("CompanionObject");
            map3.put(sb.toString(), str.concat(".Companion"));
        }
        for (Map.Entry entry : f6140b.entrySet()) {
            Class cls = (Class) entry.getKey();
            int iIntValue = ((Number) entry.getValue()).intValue();
            map3.put(cls.getName(), "kotlin.Function" + iIntValue);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(AbstractC1097p.m2840i(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), AbstractC1892g.m4226s((String) entry2.getValue()));
        }
        f6141c = linkedHashMap;
    }

    public C1763b(Class cls) {
        AbstractC1766e.m3920e("jClass", cls);
        this.f6142a = cls;
    }

    @Override // p119m2.InterfaceC1762a
    /* JADX INFO: renamed from: a */
    public final Class mo3914a() {
        return this.f6142a;
    }

    /* JADX INFO: renamed from: b */
    public final String m3915b() {
        String str;
        Class cls = this.f6142a;
        AbstractC1766e.m3920e("jClass", cls);
        String strConcat = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            boolean zIsArray = cls.isArray();
            LinkedHashMap linkedHashMap = f6141c;
            if (!zIsArray) {
                String str2 = (String) linkedHashMap.get(cls.getName());
                return str2 == null ? cls.getSimpleName() : str2;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) linkedHashMap.get(componentType.getName())) != null) {
                strConcat = str.concat("Array");
            }
            return strConcat == null ? "Array" : strConcat;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return AbstractC1892g.m4225r(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor != null) {
            return AbstractC1892g.m4225r(simpleName, enclosingConstructor.getName() + '$');
        }
        int iM4221n = AbstractC1892g.m4221n(simpleName, '$', 0, false, 6);
        if (iM4221n == -1) {
            return simpleName;
        }
        String strSubstring = simpleName.substring(iM4221n + 1, simpleName.length());
        AbstractC1766e.m3919d("substring(...)", strSubstring);
        return strSubstring;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1763b) && AbstractC1946e.m4345c(this).equals(AbstractC1946e.m4345c((InterfaceC1840a) obj));
    }

    public final int hashCode() {
        return AbstractC1946e.m4345c(this).hashCode();
    }

    public final String toString() {
        return this.f6142a.toString() + " (Kotlin reflection is not available)";
    }
}

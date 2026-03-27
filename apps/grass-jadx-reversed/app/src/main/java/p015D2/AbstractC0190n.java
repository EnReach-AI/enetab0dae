package p015D2;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p005B.AbstractC0032g;
import p008B2.C0067G;
import p008B2.C0136z;
import p011C2.AbstractC0156i;
import p011C2.AbstractC0157j;
import p011C2.AbstractC0172y;
import p011C2.C0148a;
import p011C2.C0154g;
import p011C2.C0168u;
import p011C2.InterfaceC0153f;
import p019F0.C0221e;
import p033K0.AbstractC0406d;
import p039M0.AbstractC0493h0;
import p086c2.AbstractC1097p;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p161x2.C2015d;
import p161x2.InterfaceC2012a;
import p166z0.C2068f;
import p167z2.AbstractC2092d;
import p167z2.AbstractC2094f;
import p167z2.C2099k;
import p167z2.C2100l;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: D2.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0190n {

    /* JADX INFO: renamed from: a */
    public static final C0191o f440a = new C0191o();

    /* JADX INFO: renamed from: a */
    public static final C0186j m319a(Number number, String str) {
        return new C0186j(1, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) m329k(str, -1)));
    }

    /* JADX INFO: renamed from: b */
    public static final C0186j m320b(int i3, String str) {
        AbstractC1766e.m3920e("message", str);
        if (i3 >= 0) {
            str = "Unexpected JSON token at offset " + i3 + ": " + str;
        }
        return new C0186j(0, str);
    }

    /* JADX INFO: renamed from: c */
    public static final C0186j m321c(int i3, String str, CharSequence charSequence) {
        AbstractC1766e.m3920e("message", str);
        AbstractC1766e.m3920e("input", charSequence);
        return m320b(i3, str + "\nJSON input: " + ((Object) m329k(charSequence, i3)));
    }

    /* JADX INFO: renamed from: d */
    public static final void m322d(LinkedHashMap linkedHashMap, InterfaceC2095g interfaceC2095g, String str, int i3) {
        String str2 = AbstractC1766e.m3916a(interfaceC2095g.mo237i(), C2099k.f7423d) ? "enum value" : "property";
        if (!linkedHashMap.containsKey(str)) {
            linkedHashMap.put(str, Integer.valueOf(i3));
            return;
        }
        String str3 = "The suggested name '" + str + "' for " + str2 + ' ' + interfaceC2095g.mo230a(i3) + " is already one of the names for " + str2 + ' ' + interfaceC2095g.mo230a(((Number) AbstractC1097p.m2839h(linkedHashMap, str)).intValue()) + " in " + interfaceC2095g;
        AbstractC1766e.m3920e("message", str3);
        throw new C0189m(str3);
    }

    /* JADX INFO: renamed from: e */
    public static final InterfaceC2095g m323e(InterfaceC2095g interfaceC2095g, C2068f c2068f) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        AbstractC1766e.m3920e("module", c2068f);
        if (!AbstractC1766e.m3916a(interfaceC2095g.mo237i(), C2099k.f7422c)) {
            return interfaceC2095g.mo231b() ? m323e(interfaceC2095g.mo236h(0), c2068f) : interfaceC2095g;
        }
        AbstractC0406d.m896c(interfaceC2095g);
        return interfaceC2095g;
    }

    /* JADX INFO: renamed from: f */
    public static final byte m324f(char c3) {
        if (c3 < '~') {
            return C0180d.f420b[c3];
        }
        return (byte) 0;
    }

    /* JADX INFO: renamed from: g */
    public static final String m325g(C0148a c0148a, InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        AbstractC1766e.m3920e("json", c0148a);
        for (Annotation annotation : interfaceC2095g.mo239k()) {
            if (annotation instanceof InterfaceC0153f) {
                return ((InterfaceC0153f) annotation).discriminator();
            }
        }
        return c0148a.f357a.f375j;
    }

    /* JADX INFO: renamed from: h */
    public static final Object m326h(C0197u c0197u, InterfaceC2012a interfaceC2012a) {
        AbstractC1766e.m3920e("<this>", c0197u);
        AbstractC1766e.m3920e("deserializer", interfaceC2012a);
        if (!(interfaceC2012a instanceof C2015d) || c0197u.m348N().f357a.f374i) {
            return interfaceC2012a.mo220b(c0197u);
        }
        String strM325g = m325g(c0197u.m348N(), interfaceC2012a.mo221c());
        AbstractC0156i abstractC0156iM347M = c0197u.m347M();
        InterfaceC2095g interfaceC2095gMo221c = interfaceC2012a.mo221c();
        if (!(abstractC0156iM347M instanceof C0168u)) {
            throw m320b(-1, "Expected " + AbstractC1770i.m3927a(C0168u.class) + " as the serialized body of " + interfaceC2095gMo221c.mo233d() + ", but had " + AbstractC1770i.m3927a(abstractC0156iM347M.getClass()));
        }
        C0168u c0168u = (C0168u) abstractC0156iM347M;
        AbstractC0156i abstractC0156i = (AbstractC0156i) c0168u.get(strM325g);
        String strMo299a = null;
        if (abstractC0156i != null) {
            C0067G c0067g = AbstractC0157j.f379a;
            AbstractC0172y abstractC0172y = abstractC0156i instanceof AbstractC0172y ? (AbstractC0172y) abstractC0156i : null;
            if (abstractC0172y == null) {
                throw new IllegalArgumentException("Element " + AbstractC1770i.m3927a(abstractC0156i.getClass()) + " is not a JsonPrimitive");
            }
            strMo299a = abstractC0172y.mo299a();
        }
        ((C2015d) interfaceC2012a).m4466d(c0197u);
        throw m321c(-1, AbstractC0032g.m152j("Polymorphic serializer was not found for ", strMo299a == null ? "missing class discriminator ('null')" : AbstractC0032g.m153k("class discriminator '", strMo299a, '\'')), c0168u.toString());
    }

    /* JADX INFO: renamed from: i */
    public static final void m327i(C0148a c0148a, C0192p c0192p, InterfaceC2012a interfaceC2012a, Object obj) {
        AbstractC1766e.m3920e("<this>", c0148a);
        new C0198v(c0148a.f357a.f370e ? new C0184h(c0192p, c0148a) : new C0181e(c0192p), c0148a, EnumC0202z.OBJ, new C0198v[EnumC0202z.values().length]).m363o(interfaceC2012a, obj);
    }

    /* JADX INFO: renamed from: j */
    public static final int m328j(InterfaceC2095g interfaceC2095g, C0148a c0148a, String str) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        AbstractC1766e.m3920e("json", c0148a);
        AbstractC1766e.m3920e("name", str);
        C0154g c0154g = c0148a.f357a;
        boolean z3 = c0154g.f378m;
        C0191o c0191o = f440a;
        C0221e c0221e = c0148a.f359c;
        if (z3 && AbstractC1766e.m3916a(interfaceC2095g.mo237i(), C2099k.f7423d)) {
            String lowerCase = str.toLowerCase(Locale.ROOT);
            AbstractC1766e.m3919d("this as java.lang.String).toLowerCase(Locale.ROOT)", lowerCase);
            C0136z c0136z = new C0136z(interfaceC2095g, 2, c0148a);
            c0221e.getClass();
            Object objM457t = c0221e.m457t(interfaceC2095g, c0191o);
            if (objM457t == null) {
                objM457t = c0136z.mo263a();
                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) c0221e.f534f;
                Object concurrentHashMap2 = concurrentHashMap.get(interfaceC2095g);
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap(2);
                    concurrentHashMap.put(interfaceC2095g, concurrentHashMap2);
                }
                ((Map) concurrentHashMap2).put(c0191o, objM457t);
            }
            Integer num = (Integer) ((Map) objM457t).get(lowerCase);
            if (num != null) {
                return num.intValue();
            }
            return -3;
        }
        m330l(c0148a, interfaceC2095g);
        int iMo232c = interfaceC2095g.mo232c(str);
        if (iMo232c != -3 || !c0154g.f377l) {
            return iMo232c;
        }
        C0136z c0136z2 = new C0136z(interfaceC2095g, 2, c0148a);
        c0221e.getClass();
        Object objM457t2 = c0221e.m457t(interfaceC2095g, c0191o);
        if (objM457t2 == null) {
            objM457t2 = c0136z2.mo263a();
            ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) c0221e.f534f;
            Object concurrentHashMap4 = concurrentHashMap3.get(interfaceC2095g);
            if (concurrentHashMap4 == null) {
                concurrentHashMap4 = new ConcurrentHashMap(2);
                concurrentHashMap3.put(interfaceC2095g, concurrentHashMap4);
            }
            ((Map) concurrentHashMap4).put(c0191o, objM457t2);
        }
        Integer num2 = (Integer) ((Map) objM457t2).get(str);
        if (num2 != null) {
            return num2.intValue();
        }
        return -3;
    }

    /* JADX INFO: renamed from: k */
    public static final CharSequence m329k(CharSequence charSequence, int i3) {
        if (charSequence.length() < 200) {
            return charSequence;
        }
        if (i3 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i4 = i3 - 30;
        int i5 = i3 + 30;
        String str = i4 <= 0 ? "" : ".....";
        String str2 = i5 >= charSequence.length() ? "" : ".....";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (i4 < 0) {
            i4 = 0;
        }
        int length2 = charSequence.length();
        if (i5 > length2) {
            i5 = length2;
        }
        sb.append(charSequence.subSequence(i4, i5).toString());
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: l */
    public static final void m330l(C0148a c0148a, InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("<this>", interfaceC2095g);
        AbstractC1766e.m3920e("json", c0148a);
        if (AbstractC1766e.m3916a(interfaceC2095g.mo237i(), C2100l.f7424c)) {
            c0148a.f357a.getClass();
        }
    }

    /* JADX INFO: renamed from: m */
    public static final EnumC0202z m331m(C0148a c0148a, InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("<this>", c0148a);
        AbstractC1766e.m3920e("desc", interfaceC2095g);
        AbstractC0493h0 abstractC0493h0Mo237i = interfaceC2095g.mo237i();
        if (abstractC0493h0Mo237i instanceof AbstractC2092d) {
            return EnumC0202z.POLY_OBJ;
        }
        if (AbstractC1766e.m3916a(abstractC0493h0Mo237i, C2100l.f7425d)) {
            return EnumC0202z.LIST;
        }
        if (!AbstractC1766e.m3916a(abstractC0493h0Mo237i, C2100l.f7426e)) {
            return EnumC0202z.OBJ;
        }
        InterfaceC2095g interfaceC2095gM323e = m323e(interfaceC2095g.mo236h(0), c0148a.f358b);
        AbstractC0493h0 abstractC0493h0Mo237i2 = interfaceC2095gM323e.mo237i();
        if ((abstractC0493h0Mo237i2 instanceof AbstractC2094f) || AbstractC1766e.m3916a(abstractC0493h0Mo237i2, C2099k.f7423d)) {
            return EnumC0202z.MAP;
        }
        if (c0148a.f357a.f369d) {
            return EnumC0202z.LIST;
        }
        throw new C0186j(1, "Value of type '" + interfaceC2095gM323e.mo233d() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + interfaceC2095gM323e.mo237i() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    /* JADX INFO: renamed from: n */
    public static final void m332n(C0200x c0200x, Number number) {
        AbstractC1766e.m3920e("<this>", c0200x);
        C0200x.m369o(c0200x, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    /* JADX INFO: renamed from: o */
    public static final String m333o(byte b3) {
        return b3 == 1 ? "quotation mark '\"'" : b3 == 2 ? "string escape sequence '\\'" : b3 == 4 ? "comma ','" : b3 == 5 ? "colon ':'" : b3 == 6 ? "start of the object '{'" : b3 == 7 ? "end of the object '}'" : b3 == 8 ? "start of the array '['" : b3 == 9 ? "end of the array ']'" : b3 == 10 ? "end of the input" : b3 == 127 ? "invalid token" : "valid token";
    }
}

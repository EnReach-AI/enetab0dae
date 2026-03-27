package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import p042N0.C0533a;
import p050Q0.AbstractC0594g;
import p066W0.C0676c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0730u;
import p069X0.EnumC0719j;
import p078a1.C0851c;
import p114l1.C1675q;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.o */
/* JADX INFO: loaded from: classes.dex */
public class C1199o extends AbstractC0730u implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final int f4074e;

    /* JADX INFO: renamed from: f */
    public final Class f4075f;

    /* JADX INFO: renamed from: g */
    public final FromStringDeserializer f4076g;

    public C1199o(int i3, Class cls, FromStringDeserializer fromStringDeserializer) {
        this.f4074e = i3;
        this.f4075f = cls;
        this.f4076g = fromStringDeserializer;
    }

    @Override // p069X0.AbstractC0730u
    /* JADX INFO: renamed from: a */
    public Object mo1910a(AbstractC0718i abstractC0718i, String str) throws C0851c {
        Class cls = this.f4075f;
        if (str == null) {
            return null;
        }
        try {
            Object objMo3043b = mo3043b(abstractC0718i, str);
            if (objMo3043b != null) {
                return objMo3043b;
            }
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            if (Enum.class.isAssignableFrom(cls) && abstractC0718i.f1998g.m1820r(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            abstractC0718i.m1827E(cls, str, "not a valid representation", new Object[0]);
            throw null;
        } catch (Exception e3) {
            abstractC0718i.m1827E(cls, str, "not a valid representation, problem: (%s) %s", e3.getClass().getName(), AbstractC1745j.m3886i(e3));
            throw null;
        }
    }

    /* JADX INFO: renamed from: b */
    public Object mo3043b(AbstractC0718i abstractC0718i, String str) throws C0851c {
        int i3 = this.f4074e;
        FromStringDeserializer fromStringDeserializer = this.f4076g;
        Class cls = this.f4075f;
        switch (i3) {
            case 1:
                if ("true".equals(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equals(str)) {
                    return Boolean.FALSE;
                }
                abstractC0718i.m1827E(cls, str, "value not 'true' or 'false'", new Object[0]);
                throw null;
            case 2:
                int iM1349f = AbstractC0594g.m1349f(str);
                if (iM1349f >= -128 && iM1349f <= 255) {
                    return Byte.valueOf((byte) iM1349f);
                }
                abstractC0718i.m1827E(cls, str, "overflow, value cannot be represented as 8-bit value", new Object[0]);
                throw null;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                int iM1349f2 = AbstractC0594g.m1349f(str);
                if (iM1349f2 >= -32768 && iM1349f2 <= 32767) {
                    return Short.valueOf((short) iM1349f2);
                }
                abstractC0718i.m1827E(cls, str, "overflow, value cannot be represented as 16-bit value", new Object[0]);
                throw null;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                if (str.length() == 1) {
                    return Character.valueOf(str.charAt(0));
                }
                abstractC0718i.m1827E(cls, str, "can only convert 1-character Strings", new Object[0]);
                throw null;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return Integer.valueOf(AbstractC0594g.m1349f(str));
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return Long.valueOf(AbstractC0594g.m1351h(str));
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                String str2 = AbstractC0594g.f1522a;
                return Float.valueOf((float) Double.parseDouble(str));
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                String str3 = AbstractC0594g.f1522a;
                return Double.valueOf(Double.parseDouble(str));
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                try {
                    return fromStringDeserializer._deserialize(str, abstractC0718i);
                } catch (IllegalArgumentException e3) {
                    m3044c(abstractC0718i, str, e3);
                    throw null;
                }
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return abstractC0718i.m1836N(str);
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                Date dateM1836N = abstractC0718i.m1836N(str);
                Calendar calendar = Calendar.getInstance(abstractC0718i.f1998g.m2154i());
                calendar.setTime(dateM1836N);
                return calendar;
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                try {
                    return UUID.fromString(str);
                } catch (Exception e4) {
                    m3044c(abstractC0718i, str, e4);
                    throw null;
                }
            case 13:
                try {
                    return URI.create(str);
                } catch (Exception e5) {
                    m3044c(abstractC0718i, str, e5);
                    throw null;
                }
            case 14:
                try {
                    return new URL(str);
                } catch (MalformedURLException e6) {
                    m3044c(abstractC0718i, str, e6);
                    throw null;
                }
            case 15:
                try {
                    abstractC0718i.mo1711f().getClass();
                    return C1675q.m3770k(str);
                } catch (Exception unused) {
                    abstractC0718i.m1827E(cls, str, "unable to parse key as Class", new Object[0]);
                    throw null;
                }
            case 16:
                try {
                    return fromStringDeserializer._deserialize(str, abstractC0718i);
                } catch (IllegalArgumentException e7) {
                    m3044c(abstractC0718i, str, e7);
                    throw null;
                }
            case 17:
                try {
                    C0533a c0533a = abstractC0718i.f1998g.f2481f.f2429o;
                    c0533a.getClass();
                    C0676c c0676c = new C0676c(null);
                    c0533a.m1072b(str, c0676c);
                    return c0676c.m1639f();
                } catch (IllegalArgumentException e8) {
                    m3044c(abstractC0718i, str, e8);
                    throw null;
                }
            default:
                throw new IllegalStateException("Internal error: unknown key type " + cls);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m3044c(AbstractC0718i abstractC0718i, String str, Exception exc) throws C0851c {
        abstractC0718i.m1827E(this.f4075f, str, "problem: %s", AbstractC1745j.m3886i(exc));
        throw null;
    }
}

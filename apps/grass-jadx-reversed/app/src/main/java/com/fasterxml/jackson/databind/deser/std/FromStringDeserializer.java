package com.fasterxml.jackson.databind.deser.std;

import java.io.File;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Currency;
import java.util.IllformedLocaleException;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p066W0.AbstractC0692s;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p074Z0.EnumC0816b;
import p074Z0.EnumC0819e;
import p078a1.C0850b;
import p078a1.C0851c;
import p114l1.C1675q;
import p114l1.C1676r;
import p114l1.C1677s;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;

/* JADX INFO: loaded from: classes.dex */
public abstract class FromStringDeserializer<T> extends StdScalarDeserializer<T> {

    public static class Std extends FromStringDeserializer<Object> {
        protected static final String LOCALE_EXT_MARKER = "_#";
        public static final int STD_CHARSET = 9;
        public static final int STD_CLASS = 4;
        public static final int STD_CURRENCY = 6;
        public static final int STD_FILE = 1;
        public static final int STD_INET_ADDRESS = 11;
        public static final int STD_INET_SOCKET_ADDRESS = 12;
        public static final int STD_JAVA_TYPE = 5;
        public static final int STD_LOCALE = 8;
        public static final int STD_PATTERN = 7;
        public static final int STD_TIME_ZONE = 10;
        public static final int STD_URI = 3;
        public static final int STD_URL = 2;
        private static final long serialVersionUID = 1;
        protected final int _kind;

        public Std(Class<?> cls, int i3) {
            super(cls);
            this._kind = i3;
        }

        private Locale _deSerializeBCP47Locale(String str, int i3, String str2, String str3, int i4) {
            String strSubstring = "";
            if (i4 > 0 && i4 > i3) {
                try {
                    strSubstring = str.substring(i3 + 1, i4);
                } catch (IllformedLocaleException unused) {
                    return new Locale(str2, str3, "");
                }
            }
            String strSubstring2 = str.substring(i4 + 2);
            int iIndexOf = strSubstring2.indexOf(95);
            if (iIndexOf < 0) {
                int iIndexOf2 = strSubstring2.indexOf(45);
                return iIndexOf2 < 0 ? new Locale.Builder().setLanguage(str2).setRegion(str3).setVariant(strSubstring).setScript(strSubstring2).build() : new Locale.Builder().setLanguage(str2).setRegion(str3).setVariant(strSubstring).setExtension(strSubstring2.charAt(0), strSubstring2.substring(iIndexOf2 + 1)).build();
            }
            int length = strSubstring2.length();
            Locale.Builder script = new Locale.Builder().setLanguage(str2).setRegion(str3).setVariant(strSubstring).setScript(strSubstring2.substring(0, iIndexOf));
            int i5 = iIndexOf + 1;
            if (i5 < length) {
                script = script.setExtension(strSubstring2.charAt(i5), strSubstring2.substring(Math.min(length, iIndexOf + 3)));
            }
            return script.build();
        }

        private Locale _deserializeLocale(String str, AbstractC0718i abstractC0718i) {
            int i_firstHyphenOrUnderscore = _firstHyphenOrUnderscore(str);
            if (i_firstHyphenOrUnderscore < 0) {
                return new Locale(str);
            }
            String strSubstring = str.substring(0, i_firstHyphenOrUnderscore);
            String strSubstring2 = str.substring(i_firstHyphenOrUnderscore + 1);
            int i_firstHyphenOrUnderscore2 = _firstHyphenOrUnderscore(strSubstring2);
            if (i_firstHyphenOrUnderscore2 < 0) {
                return new Locale(strSubstring, strSubstring2);
            }
            String strSubstring3 = strSubstring2.substring(0, i_firstHyphenOrUnderscore2);
            int iIndexOf = strSubstring2.indexOf(LOCALE_EXT_MARKER);
            return iIndexOf < 0 ? new Locale(strSubstring, strSubstring3, strSubstring2.substring(i_firstHyphenOrUnderscore2 + 1)) : _deSerializeBCP47Locale(strSubstring2, i_firstHyphenOrUnderscore2, strSubstring, strSubstring3, iIndexOf);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserialize(String str, AbstractC0718i abstractC0718i) throws C0850b {
            switch (this._kind) {
                case 1:
                    return new File(str);
                case 2:
                    return new URL(str);
                case STD_URI /* 3 */:
                    return URI.create(str);
                case STD_CLASS /* 4 */:
                    try {
                        abstractC0718i.mo1711f().getClass();
                        return C1675q.m3770k(str);
                    } catch (Exception e3) {
                        abstractC0718i.m1859x(this._valueClass, AbstractC1745j.m3894q(e3));
                        throw null;
                    }
                case STD_JAVA_TYPE /* 5 */:
                    C1677s c1677s = abstractC0718i.mo1711f().f5952f;
                    c1677s.getClass();
                    C1676r c1676r = new C1676r(str.trim());
                    AbstractC0721l abstractC0721lM3782b = c1677s.m3782b(c1676r);
                    if (c1676r.hasMoreTokens()) {
                        throw C1677s.m3781a(c1676r, "Unexpected tokens after complete type");
                    }
                    return abstractC0721lM3782b;
                case STD_CURRENCY /* 6 */:
                    return Currency.getInstance(str);
                case STD_PATTERN /* 7 */:
                    return Pattern.compile(str);
                case STD_LOCALE /* 8 */:
                    return _deserializeLocale(str, abstractC0718i);
                case STD_CHARSET /* 9 */:
                    return Charset.forName(str);
                case STD_TIME_ZONE /* 10 */:
                    return TimeZone.getTimeZone(str);
                case STD_INET_ADDRESS /* 11 */:
                    return InetAddress.getByName(str);
                case STD_INET_SOCKET_ADDRESS /* 12 */:
                    if (str.startsWith("[")) {
                        int iLastIndexOf = str.lastIndexOf(93);
                        if (iLastIndexOf == -1) {
                            throw new C0851c(abstractC0718i.f2002k, "Bracketed IPv6 address must contain closing bracket", str);
                        }
                        int iIndexOf = str.indexOf(58, iLastIndexOf);
                        return new InetSocketAddress(str.substring(0, iLastIndexOf + 1), iIndexOf > -1 ? Integer.parseInt(str.substring(iIndexOf + 1)) : 0);
                    }
                    int iIndexOf2 = str.indexOf(58);
                    if (iIndexOf2 >= 0) {
                        int i3 = iIndexOf2 + 1;
                        if (str.indexOf(58, i3) < 0) {
                            return new InetSocketAddress(str.substring(0, iIndexOf2), Integer.parseInt(str.substring(i3)));
                        }
                    }
                    return new InetSocketAddress(str, 0);
                default:
                    AbstractC0692s.m1666a();
                    throw null;
            }
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserializeFromEmptyStringDefault(AbstractC0718i abstractC0718i) {
            return getEmptyValue(abstractC0718i);
        }

        public int _firstHyphenOrUnderscore(String str) {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt == '_' || cCharAt == '-') {
                    return i3;
                }
            }
            return -1;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public boolean _shouldTrim() {
            return this._kind != 7;
        }

        @Override // p069X0.AbstractC0722m
        public Object getEmptyValue(AbstractC0718i abstractC0718i) {
            int i3 = this._kind;
            return i3 != 3 ? i3 != 8 ? super.getEmptyValue(abstractC0718i) : Locale.ROOT : URI.create("");
        }
    }

    public static class StringBufferDeserializer extends FromStringDeserializer<Object> {
        public StringBufferDeserializer() {
            super(StringBuffer.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserialize(String str, AbstractC0718i abstractC0718i) {
            return new StringBuffer(str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, p069X0.AbstractC0722m
        public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            String strMo1165J = abstractC0545m.mo1165J();
            return strMo1165J != null ? _deserialize(strMo1165J, abstractC0718i) : super.deserialize(abstractC0545m, abstractC0718i);
        }

        @Override // p069X0.AbstractC0722m
        public Object getEmptyValue(AbstractC0718i abstractC0718i) {
            return new StringBuffer();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
        public EnumC1664f logicalType() {
            return EnumC1664f.f5898n;
        }
    }

    public static class StringBuilderDeserializer extends FromStringDeserializer<Object> {
        public StringBuilderDeserializer() {
            super(StringBuilder.class);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer
        public Object _deserialize(String str, AbstractC0718i abstractC0718i) {
            return new StringBuilder(str);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, p069X0.AbstractC0722m
        public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
            String strMo1165J = abstractC0545m.mo1165J();
            return strMo1165J != null ? _deserialize(strMo1165J, abstractC0718i) : super.deserialize(abstractC0545m, abstractC0718i);
        }

        @Override // p069X0.AbstractC0722m
        public Object getEmptyValue(AbstractC0718i abstractC0718i) {
            return new StringBuilder();
        }

        @Override // com.fasterxml.jackson.databind.deser.std.FromStringDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
        public EnumC1664f logicalType() {
            return EnumC1664f.f5898n;
        }
    }

    public FromStringDeserializer(Class<?> cls) {
        super(cls);
    }

    public static FromStringDeserializer<?> findDeserializer(Class<?> cls) {
        int i3;
        if (cls == File.class) {
            i3 = 1;
        } else if (cls == URL.class) {
            i3 = 2;
        } else if (cls == URI.class) {
            i3 = 3;
        } else if (cls == Class.class) {
            i3 = 4;
        } else if (cls == AbstractC0721l.class) {
            i3 = 5;
        } else if (cls == Currency.class) {
            i3 = 6;
        } else if (cls == Pattern.class) {
            i3 = 7;
        } else if (cls == Locale.class) {
            i3 = 8;
        } else if (cls == Charset.class) {
            i3 = 9;
        } else if (cls == TimeZone.class) {
            i3 = 10;
        } else if (cls == InetAddress.class) {
            i3 = 11;
        } else {
            if (cls != InetSocketAddress.class) {
                if (cls == StringBuilder.class) {
                    return new StringBuilderDeserializer();
                }
                if (cls == StringBuffer.class) {
                    return new StringBufferDeserializer();
                }
                return null;
            }
            i3 = 12;
        }
        return new Std(cls, i3);
    }

    public static Class<?>[] types() {
        return new Class[]{File.class, URL.class, URI.class, Class.class, AbstractC0721l.class, Currency.class, Pattern.class, Locale.class, Charset.class, TimeZone.class, InetAddress.class, InetSocketAddress.class, StringBuilder.class, StringBuffer.class};
    }

    public abstract T _deserialize(String str, AbstractC0718i abstractC0718i);

    public T _deserializeEmbedded(Object obj, AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1841S(this, "Don't know how to convert embedded Object of type %s into %s", obj.getClass().getName(), this._valueClass.getName());
        throw null;
    }

    @Deprecated
    public final T _deserializeFromEmptyString() {
        return null;
    }

    public Object _deserializeFromEmptyStringDefault(AbstractC0718i abstractC0718i) {
        return getNullValue(abstractC0718i);
    }

    public Object _deserializeFromOther(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumC0548p enumC0548p) throws C0850b {
        if (enumC0548p == EnumC0548p.START_ARRAY) {
            return _deserializeFromArray(abstractC0545m, abstractC0718i);
        }
        if (enumC0548p != EnumC0548p.VALUE_EMBEDDED_OBJECT) {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        Object objMo1202q = abstractC0545m.mo1202q();
        if (objMo1202q == null) {
            return null;
        }
        return this._valueClass.isAssignableFrom(objMo1202q.getClass()) ? objMo1202q : _deserializeEmbedded(objMo1202q, abstractC0718i);
    }

    public boolean _shouldTrim() {
        return true;
    }

    @Override // p069X0.AbstractC0722m
    public T deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        String strMo1165J = abstractC0545m.mo1165J();
        if (strMo1165J == null) {
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e != EnumC0548p.START_OBJECT) {
                return (T) _deserializeFromOther(abstractC0545m, abstractC0718i, enumC0548pMo1190e);
            }
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        if (strMo1165J.isEmpty()) {
            return (T) _deserializeFromEmptyString(abstractC0718i);
        }
        if (_shouldTrim()) {
            String strTrim = strMo1165J.trim();
            if (strTrim != strMo1165J && strTrim.isEmpty()) {
                return (T) _deserializeFromEmptyString(abstractC0718i);
            }
            strMo1165J = strTrim;
        }
        try {
            return _deserialize(strMo1165J, abstractC0718i);
        } catch (IllegalArgumentException | MalformedURLException e3) {
            String message = e3.getMessage();
            C0851c c0851cM1846Y = abstractC0718i.m1846Y(strMo1165J, this._valueClass, message != null ? "not a valid textual representation, problem: ".concat(message) : "not a valid textual representation");
            c0851cM1846Y.initCause(e3);
            throw c0851cM1846Y;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5901q;
    }

    public Object _deserializeFromEmptyString(AbstractC0718i abstractC0718i) throws C0850b {
        EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(logicalType(), this._valueClass, EnumC0819e.f2444j);
        if (enumC0816bM1850o != EnumC0816b.f2430e) {
            return enumC0816bM1850o == EnumC0816b.f2432g ? getNullValue(abstractC0718i) : enumC0816bM1850o == EnumC0816b.f2433h ? getEmptyValue(abstractC0718i) : _deserializeFromEmptyStringDefault(abstractC0718i);
        }
        abstractC0718i.m1841S(this, "Cannot coerce empty String (\"\") to %s (but could if enabling coercion using `CoercionConfig`)", _coercedTypeDesc());
        throw null;
    }
}

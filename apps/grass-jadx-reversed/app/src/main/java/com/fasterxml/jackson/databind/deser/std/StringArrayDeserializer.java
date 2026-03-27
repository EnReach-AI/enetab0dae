package com.fasterxml.jackson.databind.deser.std;

import com.facebook.C1106c;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.impl.C1165q;
import java.util.Objects;
import p039M0.EnumC0499n;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p074Z0.EnumC0819e;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class StringArrayDeserializer extends StdDeserializer<String[]> implements InterfaceC1139f {
    private static final String[] NO_STRINGS = new String[0];
    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    private static final long serialVersionUID = 2;
    protected AbstractC0722m _elementDeserializer;
    protected final InterfaceC1178m _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    public StringArrayDeserializer() {
        this(null, null, null);
    }

    private final String[] handleNonArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        String str_parseString;
        EnumC0816b enumC0816bM1851p;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !abstractC0718i.m1833K(EnumC0719j.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
                return _deserializeFromString(abstractC0545m, abstractC0718i);
            }
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL)) {
            str_parseString = (String) this._nullProvider.getNullValue(abstractC0718i);
        } else {
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
                String strMo1157B = abstractC0545m.mo1157B();
                boolean zIsEmpty = strMo1157B.isEmpty();
                EnumC0816b enumC0816b = EnumC0816b.f2430e;
                if (zIsEmpty) {
                    EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(logicalType(), handledType(), EnumC0819e.f2444j);
                    if (enumC0816bM1850o != enumC0816b) {
                        return (String[]) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1850o, handledType(), "empty String (\"\")");
                    }
                } else if (StdDeserializer._isBlank(strMo1157B) && (enumC0816bM1851p = abstractC0718i.m1851p(logicalType(), handledType())) != enumC0816b) {
                    return (String[]) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1851p, handledType(), "blank String (all whitespace)");
                }
            }
            str_parseString = _parseString(abstractC0545m, abstractC0718i, this._nullProvider);
        }
        return new String[]{str_parseString};
    }

    public final String[] _deserializeCustom(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String[] strArr) throws C0724o {
        int length;
        Object[] objArrM2886h;
        String str;
        int i3;
        C1106c c1106cM1835M = abstractC0718i.m1835M();
        if (strArr == null) {
            objArrM2886h = c1106cM1835M.m2885g();
            length = 0;
        } else {
            length = strArr.length;
            objArrM2886h = c1106cM1835M.m2886h(strArr, length);
        }
        AbstractC0722m abstractC0722m = this._elementDeserializer;
        while (true) {
            try {
                try {
                    if (abstractC0545m.mo1176U() == null) {
                        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
                        if (enumC0548pMo1190e == EnumC0548p.END_ARRAY) {
                            String[] strArr2 = (String[]) c1106cM1835M.m2884f(objArrM2886h, length, String.class);
                            abstractC0718i.m1845X(c1106cM1835M);
                            return strArr2;
                        }
                        if (enumC0548pMo1190e != EnumC0548p.VALUE_NULL) {
                            str = (String) abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
                        } else if (!this._skipNullValues) {
                            str = (String) this._nullProvider.getNullValue(abstractC0718i);
                        }
                    } else {
                        str = (String) abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
                    }
                    objArrM2886h[length] = str;
                    length = i3;
                } catch (Exception e3) {
                    e = e3;
                    length = i3;
                    throw C0724o.m1895h(e, String.class, length);
                }
                if (length >= objArrM2886h.length) {
                    objArrM2886h = c1106cM1835M.m2881c(objArrM2886h);
                    length = 0;
                }
                i3 = length + 1;
            } catch (Exception e4) {
                e = e4;
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) throws C0850b {
        AbstractC0722m abstractC0722mFindConvertingContentDeserializer = findConvertingContentDeserializer(abstractC0718i, interfaceC0714e, this._elementDeserializer);
        AbstractC0721l abstractC0721lM1848m = abstractC0718i.m1848m(String.class);
        AbstractC0722m abstractC0722mM1852q = abstractC0722mFindConvertingContentDeserializer == null ? abstractC0718i.m1852q(abstractC0721lM1848m, interfaceC0714e) : abstractC0718i.m1823A(abstractC0722mFindConvertingContentDeserializer, interfaceC0714e, abstractC0721lM1848m);
        Boolean boolFindFormatFeature = findFormatFeature(abstractC0718i, interfaceC0714e, String[].class, EnumC0499n.f1147e);
        InterfaceC1178m interfaceC1178mFindContentNullProvider = findContentNullProvider(abstractC0718i, interfaceC0714e, abstractC0722mM1852q);
        if (abstractC0722mM1852q != null && isDefaultDeserializer(abstractC0722mM1852q)) {
            abstractC0722mM1852q = null;
        }
        return (this._elementDeserializer == abstractC0722mM1852q && Objects.equals(this._unwrapSingle, boolFindFormatFeature) && this._nullProvider == interfaceC1178mFindContentNullProvider) ? this : new StringArrayDeserializer(abstractC0722mM1852q, interfaceC1178mFindContentNullProvider, boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3401c(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6082f;
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return NO_STRINGS;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5889e;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.TRUE;
    }

    public StringArrayDeserializer(AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super((Class<?>) String[].class);
        this._elementDeserializer = abstractC0722m;
        this._nullProvider = interfaceC1178m;
        this._unwrapSingle = bool;
        this._skipNullValues = C1165q.m3010a(interfaceC1178m);
    }

    @Override // p069X0.AbstractC0722m
    public String[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
        int i3;
        if (!abstractC0545m.mo1172Q()) {
            return handleNonArray(abstractC0545m, abstractC0718i);
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(abstractC0545m, abstractC0718i, null);
        }
        C1106c c1106cM1835M = abstractC0718i.m1835M();
        Object[] objArrM2885g = c1106cM1835M.m2885g();
        int i4 = 0;
        while (true) {
            try {
                String strMo1176U = abstractC0545m.mo1176U();
                try {
                    if (strMo1176U == null) {
                        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
                        if (enumC0548pMo1190e == EnumC0548p.END_ARRAY) {
                            String[] strArr = (String[]) c1106cM1835M.m2884f(objArrM2885g, i4, String.class);
                            abstractC0718i.m1845X(c1106cM1835M);
                            return strArr;
                        }
                        if (enumC0548pMo1190e == EnumC0548p.VALUE_NULL) {
                            if (!this._skipNullValues) {
                                strMo1176U = (String) this._nullProvider.getNullValue(abstractC0718i);
                            }
                        } else {
                            strMo1176U = _parseString(abstractC0545m, abstractC0718i, this._nullProvider);
                        }
                    }
                    objArrM2885g[i4] = strMo1176U;
                    i4 = i3;
                } catch (Exception e3) {
                    e = e3;
                    i4 = i3;
                    throw C0724o.m1895h(e, objArrM2885g, c1106cM1835M.f3841a + i4);
                }
                if (i4 >= objArrM2885g.length) {
                    objArrM2885g = c1106cM1835M.m2881c(objArrM2885g);
                    i4 = 0;
                }
                i3 = i4 + 1;
            } catch (Exception e4) {
                e = e4;
            }
        }
    }

    @Override // p069X0.AbstractC0722m
    public String[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String[] strArr) throws C0724o {
        String strMo1176U;
        if (!abstractC0545m.mo1172Q()) {
            String[] strArrHandleNonArray = handleNonArray(abstractC0545m, abstractC0718i);
            if (strArrHandleNonArray == null) {
                return strArr;
            }
            int length = strArr.length;
            String[] strArr2 = new String[strArrHandleNonArray.length + length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            System.arraycopy(strArrHandleNonArray, 0, strArr2, length, strArrHandleNonArray.length);
            return strArr2;
        }
        if (this._elementDeserializer != null) {
            return _deserializeCustom(abstractC0545m, abstractC0718i, strArr);
        }
        C1106c c1106cM1835M = abstractC0718i.m1835M();
        int length2 = strArr.length;
        Object[] objArrM2886h = c1106cM1835M.m2886h(strArr, length2);
        while (true) {
            try {
                strMo1176U = abstractC0545m.mo1176U();
            } catch (Exception e3) {
                e = e3;
            }
            if (strMo1176U == null) {
                EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
                if (enumC0548pMo1190e == EnumC0548p.END_ARRAY) {
                    String[] strArr3 = (String[]) c1106cM1835M.m2884f(objArrM2886h, length2, String.class);
                    abstractC0718i.m1845X(c1106cM1835M);
                    return strArr3;
                }
                if (enumC0548pMo1190e == EnumC0548p.VALUE_NULL) {
                    if (this._skipNullValues) {
                        return NO_STRINGS;
                    }
                    strMo1176U = (String) this._nullProvider.getNullValue(abstractC0718i);
                } else {
                    strMo1176U = _parseString(abstractC0545m, abstractC0718i, this._nullProvider);
                }
                throw C0724o.m1895h(e, objArrM2886h, c1106cM1835M.f3841a + length2);
            }
            if (length2 >= objArrM2886h.length) {
                objArrM2886h = c1106cM1835M.m2881c(objArrM2886h);
                length2 = 0;
            }
            int i3 = length2 + 1;
            try {
                objArrM2886h[length2] = strMo1176U;
                length2 = i3;
            } catch (Exception e4) {
                e = e4;
                length2 = i3;
            }
        }
    }
}

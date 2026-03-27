package com.fasterxml.jackson.databind.deser.std;

import com.facebook.C1106c;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;
import p039M0.EnumC0499n;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p074Z0.EnumC0819e;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.C1659a;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object[]> implements InterfaceC1139f {
    private static final long serialVersionUID = 1;
    protected final Class<?> _elementClass;
    protected AbstractC0722m _elementDeserializer;
    protected final AbstractC1398g _elementTypeDeserializer;
    protected final Object[] _emptyValue;
    protected final boolean _untyped;

    public ObjectArrayDeserializer(AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g) {
        super(abstractC0721l, (InterfaceC1178m) null, (Boolean) null);
        C1659a c1659a = (C1659a) abstractC0721l;
        Class<?> cls = c1659a.f5883n.f2036e;
        this._elementClass = cls;
        this._untyped = cls == Object.class;
        this._elementDeserializer = abstractC0722m;
        this._elementTypeDeserializer = abstractC1398g;
        this._emptyValue = (Object[]) c1659a.f5884o;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        AbstractC0722m abstractC0722m = this._elementDeserializer;
        Boolean boolFindFormatFeature = findFormatFeature(abstractC0718i, interfaceC0714e, this._containerType.f2036e, EnumC0499n.f1147e);
        AbstractC0722m abstractC0722mFindConvertingContentDeserializer = findConvertingContentDeserializer(abstractC0718i, interfaceC0714e, abstractC0722m);
        AbstractC0721l abstractC0721lMo1874i = this._containerType.mo1874i();
        AbstractC0722m abstractC0722mM1852q = abstractC0722mFindConvertingContentDeserializer == null ? abstractC0718i.m1852q(abstractC0721lMo1874i, interfaceC0714e) : abstractC0718i.m1823A(abstractC0722mFindConvertingContentDeserializer, interfaceC0714e, abstractC0721lMo1874i);
        AbstractC1398g abstractC1398gMo3404f = this._elementTypeDeserializer;
        if (abstractC1398gMo3404f != null) {
            abstractC1398gMo3404f = abstractC1398gMo3404f.mo3404f(interfaceC0714e);
        }
        return withResolved(abstractC1398gMo3404f, abstractC0722mM1852q, findContentNullProvider(abstractC0718i, interfaceC0714e, abstractC0722mM1852q), boolFindFormatFeature);
    }

    public Byte[] deserializeFromBase64(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        byte[] bArrMo1193h = abstractC0545m.mo1193h(abstractC0718i.f1998g.f2481f.f2429o);
        Byte[] bArr = new Byte[bArrMo1193h.length];
        int length = bArrMo1193h.length;
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = Byte.valueOf(bArrMo1193h[i3]);
        }
        return bArr;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public AbstractC0722m getContentDeserializer() {
        return this._elementDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6082f;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return this._emptyValue;
    }

    public Object[] handleNonArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        Object objDeserialize;
        EnumC0816b enumC0816bM1851p;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !abstractC0718i.m1833K(EnumC0719j.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
                return this._elementClass == Byte.class ? deserializeFromBase64(abstractC0545m, abstractC0718i) : _deserializeFromString(abstractC0545m, abstractC0718i);
            }
            abstractC0718i.m1824B(abstractC0545m, this._containerType);
            throw null;
        }
        if (!abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL)) {
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
                String strMo1157B = abstractC0545m.mo1157B();
                boolean zIsEmpty = strMo1157B.isEmpty();
                EnumC0816b enumC0816b = EnumC0816b.f2430e;
                if (zIsEmpty) {
                    EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(logicalType(), handledType(), EnumC0819e.f2444j);
                    if (enumC0816bM1850o != enumC0816b) {
                        return (Object[]) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1850o, handledType(), "empty String (\"\")");
                    }
                } else if (StdDeserializer._isBlank(strMo1157B) && (enumC0816bM1851p = abstractC0718i.m1851p(logicalType(), handledType())) != enumC0816b) {
                    return (Object[]) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1851p, handledType(), "blank String (all whitespace)");
                }
            }
            AbstractC1398g abstractC1398g = this._elementTypeDeserializer;
            objDeserialize = abstractC1398g == null ? this._elementDeserializer.deserialize(abstractC0545m, abstractC0718i) : this._elementDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
        } else {
            if (this._skipNullValues) {
                return this._emptyValue;
            }
            objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
        }
        Object[] objArr = this._untyped ? new Object[1] : (Object[]) Array.newInstance(this._elementClass, 1);
        objArr[0] = objDeserialize;
        return objArr;
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return this._elementDeserializer == null && this._elementTypeDeserializer == null;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5889e;
    }

    public ObjectArrayDeserializer withDeserializer(AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m) {
        return withResolved(abstractC1398g, abstractC0722m, this._nullProvider, this._unwrapSingle);
    }

    public ObjectArrayDeserializer withResolved(AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m, Boolean bool) {
        return (Objects.equals(bool, this._unwrapSingle) && interfaceC1178m == this._nullProvider && abstractC0722m == this._elementDeserializer && abstractC1398g == this._elementTypeDeserializer) ? this : new ObjectArrayDeserializer(this, abstractC0722m, abstractC1398g, interfaceC1178m, bool);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object[] deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return (Object[]) abstractC1398g.mo3401c(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public Object[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0724o {
        Object[] objArrM2884f;
        Object objDeserializeWithType;
        int i3;
        if (!abstractC0545m.mo1172Q()) {
            return handleNonArray(abstractC0545m, abstractC0718i);
        }
        C1106c c1106cM1835M = abstractC0718i.m1835M();
        Object[] objArrM2885g = c1106cM1835M.m2885g();
        AbstractC1398g abstractC1398g = this._elementTypeDeserializer;
        int i4 = 0;
        while (true) {
            try {
                EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                    break;
                }
                try {
                    if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            objDeserializeWithType = this._nullProvider.getNullValue(abstractC0718i);
                        }
                    } else if (abstractC1398g == null) {
                        objDeserializeWithType = this._elementDeserializer.deserialize(abstractC0545m, abstractC0718i);
                    } else {
                        objDeserializeWithType = this._elementDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                    }
                    objArrM2885g[i4] = objDeserializeWithType;
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
        if (this._untyped) {
            objArrM2884f = c1106cM1835M.m2883e(objArrM2885g, i4);
        } else {
            objArrM2884f = c1106cM1835M.m2884f(objArrM2885g, i4, this._elementClass);
        }
        abstractC0718i.m1845X(c1106cM1835M);
        return objArrM2884f;
    }

    public ObjectArrayDeserializer(ObjectArrayDeserializer objectArrayDeserializer, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(objectArrayDeserializer, interfaceC1178m, bool);
        this._elementClass = objectArrayDeserializer._elementClass;
        this._untyped = objectArrayDeserializer._untyped;
        this._emptyValue = objectArrayDeserializer._emptyValue;
        this._elementDeserializer = abstractC0722m;
        this._elementTypeDeserializer = abstractC1398g;
    }

    @Override // p069X0.AbstractC0722m
    public Object[] deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object[] objArr) throws C0724o {
        Object[] objArrM2884f;
        Object objDeserializeWithType;
        int i3;
        if (!abstractC0545m.mo1172Q()) {
            Object[] objArrHandleNonArray = handleNonArray(abstractC0545m, abstractC0718i);
            if (objArrHandleNonArray == null) {
                return objArr;
            }
            int length = objArr.length;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArrHandleNonArray.length + length);
            System.arraycopy(objArrHandleNonArray, 0, objArrCopyOf, length, objArrHandleNonArray.length);
            return objArrCopyOf;
        }
        C1106c c1106cM1835M = abstractC0718i.m1835M();
        int length2 = objArr.length;
        Object[] objArrM2886h = c1106cM1835M.m2886h(objArr, length2);
        AbstractC1398g abstractC1398g = this._elementTypeDeserializer;
        while (true) {
            try {
                EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                    break;
                }
                try {
                    if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            objDeserializeWithType = this._nullProvider.getNullValue(abstractC0718i);
                        }
                    } else if (abstractC1398g == null) {
                        objDeserializeWithType = this._elementDeserializer.deserialize(abstractC0545m, abstractC0718i);
                    } else {
                        objDeserializeWithType = this._elementDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                    }
                    objArrM2886h[length2] = objDeserializeWithType;
                    length2 = i3;
                } catch (Exception e3) {
                    e = e3;
                    length2 = i3;
                    throw C0724o.m1895h(e, objArrM2886h, c1106cM1835M.f3841a + length2);
                }
                if (length2 >= objArrM2886h.length) {
                    objArrM2886h = c1106cM1835M.m2881c(objArrM2886h);
                    length2 = 0;
                }
                i3 = length2 + 1;
            } catch (Exception e4) {
                e = e4;
            }
        }
        if (this._untyped) {
            objArrM2884f = c1106cM1835M.m2883e(objArrM2886h, length2);
        } else {
            objArrM2884f = c1106cM1835M.m2884f(objArrM2886h, length2, this._elementClass);
        }
        abstractC0718i.m1845X(c1106cM1835M);
        return objArrM2884f;
    }
}

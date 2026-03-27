package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.InterfaceC1179n;
import com.fasterxml.jackson.databind.deser.impl.C1143A;
import com.fasterxml.jackson.databind.deser.impl.C1171w;
import com.fasterxml.jackson.databind.deser.impl.C1174z;
import java.io.IOException;
import java.util.EnumMap;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.C0717h;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;

/* JADX INFO: loaded from: classes.dex */
public class EnumMapDeserializer extends ContainerDeserializerBase<EnumMap<?, ?>> implements InterfaceC1139f, InterfaceC1179n {
    private static final long serialVersionUID = 1;
    protected AbstractC0722m _delegateDeserializer;
    protected final Class<?> _enumClass;
    protected AbstractC0730u _keyDeserializer;
    protected C1171w _propertyBasedCreator;
    protected AbstractC0722m _valueDeserializer;
    protected final AbstractC1208x _valueInstantiator;
    protected final AbstractC1398g _valueTypeDeserializer;

    public EnumMapDeserializer(AbstractC0721l abstractC0721l, AbstractC1208x abstractC1208x, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m) {
        super(abstractC0721l, interfaceC1178m, (Boolean) null);
        this._enumClass = abstractC0721l.mo1877l().f2036e;
        this._keyDeserializer = abstractC0730u;
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
        this._valueInstantiator = abstractC1208x;
    }

    public EnumMap<?, ?> _deserializeUsingProperties(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        Object objDeserialize;
        C1171w c1171w = this._propertyBasedCreator;
        C1143A c1143aM3014d = c1171w.m3014d(abstractC0545m, abstractC0718i, null);
        String strMo1175T = abstractC0545m.mo1173R() ? abstractC0545m.mo1175T() : abstractC0545m.mo1168M(EnumC0548p.FIELD_NAME) ? abstractC0545m.mo1188d() : null;
        while (strMo1175T != null) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(strMo1175T);
            if (abstractC1204tM3013c == null) {
                Enum r5 = (Enum) this._keyDeserializer.mo1910a(abstractC0718i, strMo1175T);
                if (r5 != null) {
                    try {
                        if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                            AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
                            objDeserialize = abstractC1398g == null ? this._valueDeserializer.deserialize(abstractC0545m, abstractC0718i) : this._valueDeserializer.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                        } else if (!this._skipNullValues) {
                            objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
                        }
                        c1143aM3014d.f3960h = new C1174z(c1143aM3014d.f3960h, objDeserialize, r5, 0);
                    } catch (Exception e3) {
                        wrapAndThrow(abstractC0718i, e3, this._containerType.f2036e, strMo1175T);
                        return null;
                    }
                } else {
                    if (!abstractC0718i.m1833K(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                        abstractC0718i.m1829G(this._enumClass, strMo1175T, "value not one of declared Enum instance names for %s", this._containerType.mo1877l());
                        throw null;
                    }
                    abstractC0545m.mo1177V();
                    abstractC0545m.mo1187c0();
                }
            } else if (c1143aM3014d.m2977b(abstractC1204tM3013c, abstractC1204tM3013c.m3079j(abstractC0545m, abstractC0718i))) {
                abstractC0545m.mo1177V();
                try {
                    return deserialize(abstractC0545m, abstractC0718i, (EnumMap) c1171w.m3012a(abstractC0718i, c1143aM3014d));
                } catch (Exception e4) {
                    return (EnumMap) wrapAndThrow(abstractC0718i, e4, this._containerType.f2036e, strMo1175T);
                }
            }
            strMo1175T = abstractC0545m.mo1175T();
        }
        try {
            return (EnumMap) c1171w.m3012a(abstractC0718i, c1143aM3014d);
        } catch (Exception e5) {
            wrapAndThrow(abstractC0718i, e5, this._containerType.f2036e, strMo1175T);
            return null;
        }
    }

    public EnumMap<?, ?> constructMap(AbstractC0718i abstractC0718i) throws C0724o {
        AbstractC1208x abstractC1208x = this._valueInstantiator;
        if (abstractC1208x == null) {
            return new EnumMap<>(this._enumClass);
        }
        try {
            if (abstractC1208x.mo3005j()) {
                return (EnumMap) this._valueInstantiator.mo3007v(abstractC0718i);
            }
            abstractC0718i.m1860y(handledType(), getValueInstantiator(), "no default constructor found", new Object[0]);
            throw null;
        } catch (IOException e3) {
            AbstractC1745j.m3872B(abstractC0718i, e3);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) throws C0850b {
        AbstractC0730u abstractC0730uM1854s = this._keyDeserializer;
        if (abstractC0730uM1854s == null) {
            abstractC0730uM1854s = abstractC0718i.m1854s(this._containerType.mo1877l());
        }
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC0721l abstractC0721lMo1874i = this._containerType.mo1874i();
        AbstractC0722m abstractC0722mM1852q = abstractC0722m == null ? abstractC0718i.m1852q(abstractC0721lMo1874i, interfaceC0714e) : abstractC0718i.m1823A(abstractC0722m, interfaceC0714e, abstractC0721lMo1874i);
        AbstractC1398g abstractC1398gMo3404f = this._valueTypeDeserializer;
        if (abstractC1398gMo3404f != null) {
            abstractC1398gMo3404f = abstractC1398gMo3404f.mo3404f(interfaceC0714e);
        }
        return withResolved(abstractC0730uM1854s, abstractC0722mM1852q, abstractC1398gMo3404f, findContentNullProvider(abstractC0718i, interfaceC0714e, abstractC0722mM1852q));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3402d(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public AbstractC0722m getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return constructMap(abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC1208x getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5891g;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1179n
    public void resolve(AbstractC0718i abstractC0718i) throws C0850b {
        AbstractC1208x abstractC1208x = this._valueInstantiator;
        if (abstractC1208x != null) {
            if (abstractC1208x.mo3061k()) {
                AbstractC1208x abstractC1208x2 = this._valueInstantiator;
                C0717h c0717h = abstractC0718i.f1998g;
                AbstractC0721l abstractC0721lMo3048C = abstractC1208x2.mo3048C();
                if (abstractC0721lMo3048C != null) {
                    this._delegateDeserializer = findDeserializer(abstractC0718i, abstractC0721lMo3048C, null);
                    return;
                } else {
                    abstractC0718i.mo1713k(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
                    throw null;
                }
            }
            if (!this._valueInstantiator.mo3060i()) {
                if (this._valueInstantiator.mo3058g()) {
                    AbstractC1204t[] abstractC1204tArrMo3039D = this._valueInstantiator.mo3039D(abstractC0718i.f1998g);
                    this._propertyBasedCreator = C1171w.m3011b(abstractC0718i, this._valueInstantiator, abstractC1204tArrMo3039D, abstractC0718i.f1998g.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                    return;
                }
                return;
            }
            AbstractC1208x abstractC1208x3 = this._valueInstantiator;
            C0717h c0717h2 = abstractC0718i.f1998g;
            AbstractC0721l abstractC0721lMo3073z = abstractC1208x3.mo3073z();
            if (abstractC0721lMo3073z != null) {
                this._delegateDeserializer = findDeserializer(abstractC0718i, abstractC0721lMo3073z, null);
            } else {
                abstractC0718i.mo1713k(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
                throw null;
            }
        }
    }

    public EnumMapDeserializer withResolved(AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m) {
        return (abstractC0730u == this._keyDeserializer && interfaceC1178m == this._nullProvider && abstractC0722m == this._valueDeserializer && abstractC1398g == this._valueTypeDeserializer) ? this : new EnumMapDeserializer(this, abstractC0730u, abstractC0722m, abstractC1398g, interfaceC1178m);
    }

    @Override // p069X0.AbstractC0722m
    public EnumMap<?, ?> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingProperties(abstractC0545m, abstractC0718i);
        }
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        if (abstractC0722m != null) {
            return (EnumMap) this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
        }
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f != 1 && iMo1191f != 2) {
            if (iMo1191f == 3) {
                return _deserializeFromArray(abstractC0545m, abstractC0718i);
            }
            if (iMo1191f != 5) {
                if (iMo1191f == 6) {
                    return _deserializeFromString(abstractC0545m, abstractC0718i);
                }
                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                throw null;
            }
        }
        return deserialize(abstractC0545m, abstractC0718i, (EnumMap) constructMap(abstractC0718i));
    }

    public EnumMapDeserializer(EnumMapDeserializer enumMapDeserializer, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m) {
        super(enumMapDeserializer, interfaceC1178m, enumMapDeserializer._unwrapSingle);
        this._enumClass = enumMapDeserializer._enumClass;
        this._keyDeserializer = abstractC0730u;
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
        this._valueInstantiator = enumMapDeserializer._valueInstantiator;
        this._delegateDeserializer = enumMapDeserializer._delegateDeserializer;
        this._propertyBasedCreator = enumMapDeserializer._propertyBasedCreator;
    }

    @Override // p069X0.AbstractC0722m
    public EnumMap<?, ?> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumMap enumMap) throws C0850b {
        String strMo1188d;
        Object objDeserializeWithType;
        abstractC0545m.mo1183a0(enumMap);
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        if (abstractC0545m.mo1173R()) {
            strMo1188d = abstractC0545m.mo1175T();
        } else {
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            EnumC0548p enumC0548p = EnumC0548p.FIELD_NAME;
            if (enumC0548pMo1190e != enumC0548p) {
                if (enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
                    return enumMap;
                }
                abstractC0718i.m1844W(this, enumC0548p, null, new Object[0]);
                throw null;
            }
            strMo1188d = abstractC0545m.mo1188d();
        }
        while (strMo1188d != null) {
            Enum r4 = (Enum) this._keyDeserializer.mo1910a(abstractC0718i, strMo1188d);
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (r4 == null) {
                if (abstractC0718i.m1833K(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                    abstractC0545m.mo1187c0();
                } else {
                    abstractC0718i.m1829G(this._enumClass, strMo1188d, "value not one of declared Enum instance names for %s", this._containerType.mo1877l());
                    throw null;
                }
            } else {
                try {
                    if (enumC0548pMo1177V == EnumC0548p.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            objDeserializeWithType = this._nullProvider.getNullValue(abstractC0718i);
                        }
                    } else if (abstractC1398g == null) {
                        objDeserializeWithType = abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
                    } else {
                        objDeserializeWithType = abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                    }
                    enumMap.put(r4, objDeserializeWithType);
                } catch (Exception e3) {
                    return (EnumMap) wrapAndThrow(abstractC0718i, e3, enumMap, strMo1188d);
                }
            }
            strMo1188d = abstractC0545m.mo1175T();
        }
        return enumMap;
    }

    @Deprecated
    public EnumMapDeserializer(AbstractC0721l abstractC0721l, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g) {
        this(abstractC0721l, null, abstractC0730u, abstractC0722m, abstractC1398g, null);
    }
}

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.C1205u;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.util.ArrayList;
import java.util.Collection;
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
import p118m1.AbstractC1745j;
import p166z0.C2071i;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class CollectionDeserializer extends ContainerDeserializerBase<Collection<Object>> implements InterfaceC1139f {
    private static final long serialVersionUID = -1;
    protected final AbstractC0722m _delegateDeserializer;
    protected final AbstractC0722m _valueDeserializer;
    protected final AbstractC1208x _valueInstantiator;
    protected final AbstractC1398g _valueTypeDeserializer;

    public CollectionDeserializer(AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, AbstractC1208x abstractC1208x) {
        this(abstractC0721l, abstractC0722m, abstractC1398g, abstractC1208x, null, null, null);
    }

    public Collection<Object> _deserializeFromArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<Object> collection) throws C0724o {
        Object objDeserialize;
        abstractC0545m.mo1183a0(collection);
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        if (abstractC0722m.getObjectIdReader() != null) {
            return _deserializeWithObjectId(abstractC0545m, abstractC0718i, collection);
        }
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        while (true) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                return collection;
            }
            try {
                if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                    objDeserialize = abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                } else if (!this._skipNullValues) {
                    objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
                }
                collection.add(objDeserialize);
            } catch (Exception e3) {
                if (abstractC0718i != null && !abstractC0718i.m1833K(EnumC0719j.WRAP_EXCEPTIONS)) {
                    AbstractC1745j.m3875E(e3);
                }
                throw C0724o.m1895h(e3, collection, collection.size());
            }
        }
    }

    public Collection<Object> _deserializeFromString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, String str) {
        EnumC0816b enumC0816bM1851p;
        Class<?> clsHandledType = handledType();
        boolean zIsEmpty = str.isEmpty();
        EnumC0816b enumC0816b = EnumC0816b.f2430e;
        if (zIsEmpty) {
            EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(logicalType(), clsHandledType, EnumC0819e.f2444j);
            if (enumC0816bM1850o != null && enumC0816bM1850o != enumC0816b) {
                return (Collection) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1850o, clsHandledType, "empty String (\"\")");
            }
        } else if (StdDeserializer._isBlank(str) && (enumC0816bM1851p = abstractC0718i.m1851p(logicalType(), clsHandledType)) != enumC0816b) {
            return (Collection) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1851p, clsHandledType, "blank String (all whitespace)");
        }
        return handleNonArray(abstractC0545m, abstractC0718i, createDefaultInstance(abstractC0718i));
    }

    public Collection<Object> _deserializeWithObjectId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<Object> collection) throws C0724o {
        Object objDeserialize;
        if (!abstractC0545m.mo1172Q()) {
            return handleNonArray(abstractC0545m, abstractC0718i, collection);
        }
        abstractC0545m.mo1183a0(collection);
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        Class cls = this._containerType.mo1874i().f2036e;
        C2071i c2071i = new C2071i();
        c2071i.f7316c = new ArrayList();
        c2071i.f7314a = cls;
        c2071i.f7315b = collection;
        while (true) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                return collection;
            }
            try {
                if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                    objDeserialize = abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                } else if (!this._skipNullValues) {
                    objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
                }
                c2071i.m4593a(objDeserialize);
            } catch (C1205u e3) {
                ((ArrayList) c2071i.f7316c).add(new C1186b(c2071i, e3, (Class) c2071i.f7314a));
                throw null;
            } catch (Exception e4) {
                if (abstractC0718i != null && !abstractC0718i.m1833K(EnumC0719j.WRAP_EXCEPTIONS)) {
                    AbstractC1745j.m3875E(e4);
                }
                throw C0724o.m1895h(e4, collection, collection.size());
            }
        }
    }

    public Collection<Object> createDefaultInstance(AbstractC0718i abstractC0718i) {
        return (Collection) this._valueInstantiator.mo3007v(abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3401c(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public AbstractC0722m getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC1208x getValueInstantiator() {
        return this._valueInstantiator;
    }

    public final Collection<Object> handleNonArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<Object> collection) throws C0724o {
        Object objDeserialize;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !abstractC0718i.m1833K(EnumC0719j.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            abstractC0718i.m1824B(abstractC0545m, this._containerType);
            throw null;
        }
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        try {
            if (!abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL)) {
                objDeserialize = abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
            } else {
                if (this._skipNullValues) {
                    return collection;
                }
                objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
            }
            collection.add(objDeserialize);
            return collection;
        } catch (Exception e3) {
            if (!abstractC0718i.m1833K(EnumC0719j.WRAP_EXCEPTIONS)) {
                AbstractC1745j.m3875E(e3);
            }
            throw C0724o.m1895h(e3, Object.class, collection.size());
        }
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return this._valueDeserializer == null && this._valueTypeDeserializer == null && this._delegateDeserializer == null;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5890f;
    }

    public CollectionDeserializer withResolved(AbstractC0722m abstractC0722m, AbstractC0722m abstractC0722m2, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m, Boolean bool) {
        return new CollectionDeserializer(this._containerType, abstractC0722m2, abstractC1398g, this._valueInstantiator, abstractC0722m, interfaceC1178m, bool);
    }

    public CollectionDeserializer(AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, AbstractC1208x abstractC1208x, AbstractC0722m abstractC0722m2, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(abstractC0721l, interfaceC1178m, bool);
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
        this._valueInstantiator = abstractC1208x;
        this._delegateDeserializer = abstractC0722m2;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public CollectionDeserializer createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) throws C0850b {
        AbstractC1208x abstractC1208x = this._valueInstantiator;
        AbstractC0722m abstractC0722mFindDeserializer = null;
        if (abstractC1208x != null) {
            if (abstractC1208x.mo3061k()) {
                AbstractC1208x abstractC1208x2 = this._valueInstantiator;
                C0717h c0717h = abstractC0718i.f1998g;
                AbstractC0721l abstractC0721lMo3048C = abstractC1208x2.mo3048C();
                if (abstractC0721lMo3048C == null) {
                    abstractC0718i.mo1713k(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
                    throw null;
                }
                abstractC0722mFindDeserializer = findDeserializer(abstractC0718i, abstractC0721lMo3048C, interfaceC0714e);
            } else if (this._valueInstantiator.mo3060i()) {
                AbstractC1208x abstractC1208x3 = this._valueInstantiator;
                C0717h c0717h2 = abstractC0718i.f1998g;
                AbstractC0721l abstractC0721lMo3073z = abstractC1208x3.mo3073z();
                if (abstractC0721lMo3073z == null) {
                    abstractC0718i.mo1713k(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
                    throw null;
                }
                abstractC0722mFindDeserializer = findDeserializer(abstractC0718i, abstractC0721lMo3073z, interfaceC0714e);
            }
        }
        AbstractC0722m abstractC0722m = abstractC0722mFindDeserializer;
        Boolean boolFindFormatFeature = findFormatFeature(abstractC0718i, interfaceC0714e, Collection.class, EnumC0499n.f1147e);
        AbstractC0722m abstractC0722mFindConvertingContentDeserializer = findConvertingContentDeserializer(abstractC0718i, interfaceC0714e, this._valueDeserializer);
        AbstractC0721l abstractC0721lMo1874i = this._containerType.mo1874i();
        AbstractC0722m abstractC0722mM1852q = abstractC0722mFindConvertingContentDeserializer == null ? abstractC0718i.m1852q(abstractC0721lMo1874i, interfaceC0714e) : abstractC0718i.m1823A(abstractC0722mFindConvertingContentDeserializer, interfaceC0714e, abstractC0721lMo1874i);
        AbstractC1398g abstractC1398gMo3404f = this._valueTypeDeserializer;
        if (abstractC1398gMo3404f != null) {
            abstractC1398gMo3404f = abstractC1398gMo3404f.mo3404f(interfaceC0714e);
        }
        AbstractC1398g abstractC1398g = abstractC1398gMo3404f;
        InterfaceC1178m interfaceC1178mFindContentNullProvider = findContentNullProvider(abstractC0718i, interfaceC0714e, abstractC0722mM1852q);
        return (Objects.equals(boolFindFormatFeature, this._unwrapSingle) && interfaceC1178mFindContentNullProvider == this._nullProvider && abstractC0722m == this._delegateDeserializer && abstractC0722mM1852q == this._valueDeserializer && abstractC1398g == this._valueTypeDeserializer) ? this : withResolved(abstractC0722m, abstractC0722mM1852q, abstractC1398g, interfaceC1178mFindContentNullProvider, boolFindFormatFeature);
    }

    @Override // p069X0.AbstractC0722m
    public Collection<Object> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        if (abstractC0722m != null) {
            return (Collection) this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
        }
        if (abstractC0545m.mo1172Q()) {
            return _deserializeFromArray(abstractC0545m, abstractC0718i, createDefaultInstance(abstractC0718i));
        }
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
            return _deserializeFromString(abstractC0545m, abstractC0718i, abstractC0545m.mo1157B());
        }
        return handleNonArray(abstractC0545m, abstractC0718i, createDefaultInstance(abstractC0718i));
    }

    public CollectionDeserializer(CollectionDeserializer collectionDeserializer) {
        super(collectionDeserializer);
        this._valueDeserializer = collectionDeserializer._valueDeserializer;
        this._valueTypeDeserializer = collectionDeserializer._valueTypeDeserializer;
        this._valueInstantiator = collectionDeserializer._valueInstantiator;
        this._delegateDeserializer = collectionDeserializer._delegateDeserializer;
    }

    @Override // p069X0.AbstractC0722m
    public Collection<Object> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<Object> collection) {
        if (abstractC0545m.mo1172Q()) {
            return _deserializeFromArray(abstractC0545m, abstractC0718i, collection);
        }
        return handleNonArray(abstractC0545m, abstractC0718i, collection);
    }
}

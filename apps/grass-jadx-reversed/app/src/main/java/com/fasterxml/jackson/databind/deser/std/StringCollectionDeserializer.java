package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import java.util.Collection;
import java.util.Objects;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p071Y0.InterfaceC0738b;
import p074Z0.EnumC0816b;
import p074Z0.EnumC0819e;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements InterfaceC1139f {
    private static final long serialVersionUID = 1;
    protected final AbstractC0722m _delegateDeserializer;
    protected final AbstractC0722m _valueDeserializer;
    protected final AbstractC1208x _valueInstantiator;

    public StringCollectionDeserializer(AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, AbstractC1208x abstractC1208x) {
        this(abstractC0721l, abstractC1208x, null, abstractC0722m, abstractC0722m, null);
    }

    private Collection<String> deserializeUsingCustom(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<String> collection, AbstractC0722m abstractC0722m) throws C0724o {
        String str;
        while (true) {
            try {
                if (abstractC0545m.mo1176U() == null) {
                    EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
                    if (enumC0548pMo1190e == EnumC0548p.END_ARRAY) {
                        return collection;
                    }
                    if (enumC0548pMo1190e != EnumC0548p.VALUE_NULL) {
                        str = (String) abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
                    } else if (!this._skipNullValues) {
                        str = (String) this._nullProvider.getNullValue(abstractC0718i);
                    }
                } else {
                    str = (String) abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
                }
                collection.add(str);
            } catch (Exception e3) {
                throw C0724o.m1895h(e3, collection, collection.size());
            }
        }
    }

    private final Collection<String> handleNonArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<String> collection) throws C0724o {
        String str_parseString;
        EnumC0816b enumC0816bM1851p;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !abstractC0718i.m1833K(EnumC0719j.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
                return _deserializeFromString(abstractC0545m, abstractC0718i);
            }
            abstractC0718i.m1824B(abstractC0545m, this._containerType);
            throw null;
        }
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        if (abstractC0545m.mo1190e() != EnumC0548p.VALUE_NULL) {
            if (abstractC0545m.mo1168M(EnumC0548p.VALUE_STRING)) {
                String strMo1157B = abstractC0545m.mo1157B();
                boolean zIsEmpty = strMo1157B.isEmpty();
                EnumC0816b enumC0816b = EnumC0816b.f2430e;
                if (zIsEmpty) {
                    EnumC0816b enumC0816bM1850o = abstractC0718i.m1850o(logicalType(), handledType(), EnumC0819e.f2444j);
                    if (enumC0816bM1850o != enumC0816b) {
                        return (Collection) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1850o, handledType(), "empty String (\"\")");
                    }
                } else if (StdDeserializer._isBlank(strMo1157B) && (enumC0816bM1851p = abstractC0718i.m1851p(logicalType(), handledType())) != enumC0816b) {
                    return (Collection) _deserializeFromEmptyString(abstractC0545m, abstractC0718i, enumC0816bM1851p, handledType(), "blank String (all whitespace)");
                }
            }
            try {
                str_parseString = abstractC0722m == null ? _parseString(abstractC0545m, abstractC0718i, this._nullProvider) : (String) abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
            } catch (Exception e3) {
                throw C0724o.m1895h(e3, collection, collection.size());
            }
        } else {
            if (this._skipNullValues) {
                return collection;
            }
            str_parseString = (String) this._nullProvider.getNullValue(abstractC0718i);
        }
        collection.add(str_parseString);
        return collection;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0722m createContextual(p069X0.AbstractC0718i r6, p069X0.InterfaceC0714e r7) throws p078a1.C0850b {
        /*
            r5 = this;
            com.fasterxml.jackson.databind.deser.x r0 = r5._valueInstantiator
            r1 = 0
            if (r0 == 0) goto L2d
            b1.s r0 = r0.mo3072y()
            if (r0 == 0) goto L18
            com.fasterxml.jackson.databind.deser.x r0 = r5._valueInstantiator
            X0.h r2 = r6.f1998g
            X0.l r0 = r0.mo3073z()
            X0.m r0 = r5.findDeserializer(r6, r0, r7)
            goto L2e
        L18:
            com.fasterxml.jackson.databind.deser.x r0 = r5._valueInstantiator
            b1.s r0 = r0.mo3047B()
            if (r0 == 0) goto L2d
            com.fasterxml.jackson.databind.deser.x r0 = r5._valueInstantiator
            X0.h r2 = r6.f1998g
            X0.l r0 = r0.mo3048C()
            X0.m r0 = r5.findDeserializer(r6, r0, r7)
            goto L2e
        L2d:
            r0 = r1
        L2e:
            X0.m r2 = r5._valueDeserializer
            X0.l r3 = r5._containerType
            X0.l r3 = r3.mo1874i()
            if (r2 != 0) goto L43
            X0.m r2 = r5.findConvertingContentDeserializer(r6, r7, r2)
            if (r2 != 0) goto L47
            X0.m r2 = r6.m1852q(r3, r7)
            goto L47
        L43:
            X0.m r2 = r6.m1823A(r2, r7, r3)
        L47:
            M0.n r3 = p039M0.EnumC0499n.f1147e
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            java.lang.Boolean r3 = r5.findFormatFeature(r6, r7, r4, r3)
            com.fasterxml.jackson.databind.deser.m r6 = r5.findContentNullProvider(r6, r7, r2)
            boolean r7 = r5.isDefaultDeserializer(r2)
            if (r7 == 0) goto L5a
            goto L5b
        L5a:
            r1 = r2
        L5b:
            com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer r6 = r5.withResolved(r0, r1, r6, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer.createContextual(X0.i, X0.e):X0.m");
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

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return this._valueDeserializer == null && this._delegateDeserializer == null;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5890f;
    }

    public StringCollectionDeserializer withResolved(AbstractC0722m abstractC0722m, AbstractC0722m abstractC0722m2, InterfaceC1178m interfaceC1178m, Boolean bool) {
        return (Objects.equals(this._unwrapSingle, bool) && this._nullProvider == interfaceC1178m && this._valueDeserializer == abstractC0722m2 && this._delegateDeserializer == abstractC0722m) ? this : new StringCollectionDeserializer(this._containerType, this._valueInstantiator, abstractC0722m, abstractC0722m2, interfaceC1178m, bool);
    }

    public StringCollectionDeserializer(AbstractC0721l abstractC0721l, AbstractC1208x abstractC1208x, AbstractC0722m abstractC0722m, AbstractC0722m abstractC0722m2, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(abstractC0721l, interfaceC1178m, bool);
        this._valueDeserializer = abstractC0722m2;
        this._valueInstantiator = abstractC1208x;
        this._delegateDeserializer = abstractC0722m;
    }

    @Override // p069X0.AbstractC0722m
    public Collection<String> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        if (abstractC0722m != null) {
            return (Collection) this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
        }
        return deserialize(abstractC0545m, abstractC0718i, (Collection<String>) this._valueInstantiator.mo3007v(abstractC0718i));
    }

    @Override // p069X0.AbstractC0722m
    public Collection<String> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<String> collection) throws C0724o {
        String str_parseString;
        if (!abstractC0545m.mo1172Q()) {
            return handleNonArray(abstractC0545m, abstractC0718i, collection);
        }
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        if (abstractC0722m != null) {
            return deserializeUsingCustom(abstractC0545m, abstractC0718i, collection, abstractC0722m);
        }
        while (true) {
            try {
                String strMo1176U = abstractC0545m.mo1176U();
                if (strMo1176U != null) {
                    collection.add(strMo1176U);
                } else {
                    EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
                    if (enumC0548pMo1190e == EnumC0548p.END_ARRAY) {
                        return collection;
                    }
                    if (enumC0548pMo1190e == EnumC0548p.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            str_parseString = (String) this._nullProvider.getNullValue(abstractC0718i);
                        }
                    } else {
                        str_parseString = _parseString(abstractC0545m, abstractC0718i, this._nullProvider);
                    }
                    collection.add(str_parseString);
                }
            } catch (Exception e3) {
                throw C0724o.m1895h(e3, collection, collection.size());
            }
        }
    }
}

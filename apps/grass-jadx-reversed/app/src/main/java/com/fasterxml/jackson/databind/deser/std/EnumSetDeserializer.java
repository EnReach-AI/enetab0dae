package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.impl.C1165q;
import java.util.EnumSet;
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
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.EnumC1736a;

/* JADX INFO: loaded from: classes.dex */
public class EnumSetDeserializer extends StdDeserializer<EnumSet<?>> implements InterfaceC1139f {
    private static final long serialVersionUID = 1;
    protected AbstractC0722m _enumDeserializer;
    protected final AbstractC0721l _enumType;
    protected final InterfaceC1178m _nullProvider;
    protected final boolean _skipNullValues;
    protected final Boolean _unwrapSingle;

    public EnumSetDeserializer(AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m) {
        super((Class<?>) EnumSet.class);
        this._enumType = abstractC0721l;
        if (!abstractC0721l.m1888w()) {
            throw new IllegalArgumentException("Type " + abstractC0721l + " not Java Enum type");
        }
        this._enumDeserializer = abstractC0722m;
        this._unwrapSingle = null;
        this._nullProvider = null;
        this._skipNullValues = false;
    }

    private EnumSet constructSet() {
        return EnumSet.noneOf(this._enumType.f2036e);
    }

    public final EnumSet<?> _deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumSet enumSet) throws C0724o {
        Enum r02;
        while (true) {
            try {
                EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                if (enumC0548pMo1177V == EnumC0548p.END_ARRAY) {
                    return enumSet;
                }
                if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                    r02 = (Enum) this._enumDeserializer.deserialize(abstractC0545m, abstractC0718i);
                } else if (!this._skipNullValues) {
                    r02 = (Enum) this._nullProvider.getNullValue(abstractC0718i);
                }
                if (r02 != null) {
                    enumSet.add(r02);
                }
            } catch (Exception e3) {
                throw C0724o.m1895h(e3, enumSet, enumSet.size());
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        Boolean boolFindFormatFeature = findFormatFeature(abstractC0718i, interfaceC0714e, EnumSet.class, EnumC0499n.f1147e);
        AbstractC0722m abstractC0722m = this._enumDeserializer;
        AbstractC0722m abstractC0722mM1852q = abstractC0722m == null ? abstractC0718i.m1852q(this._enumType, interfaceC0714e) : abstractC0718i.m1823A(abstractC0722m, interfaceC0714e, this._enumType);
        return withResolved(abstractC0722mM1852q, findContentNullProvider(abstractC0718i, interfaceC0714e, abstractC0722mM1852q), boolFindFormatFeature);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3401c(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6083g;
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) {
        return constructSet();
    }

    public EnumSet<?> handleNonArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumSet enumSet) throws C0724o {
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !abstractC0718i.m1833K(EnumC0719j.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            abstractC0718i.m1825C(abstractC0545m, EnumSet.class);
            throw null;
        }
        if (abstractC0545m.mo1168M(EnumC0548p.VALUE_NULL)) {
            abstractC0718i.m1824B(abstractC0545m, this._enumType);
            throw null;
        }
        try {
            Enum r4 = (Enum) this._enumDeserializer.deserialize(abstractC0545m, abstractC0718i);
            if (r4 != null) {
                enumSet.add(r4);
            }
            return enumSet;
        } catch (Exception e3) {
            throw C0724o.m1895h(e3, enumSet, enumSet.size());
        }
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return this._enumType.f2038g == null;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5890f;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.TRUE;
    }

    public EnumSetDeserializer withDeserializer(AbstractC0722m abstractC0722m) {
        return this._enumDeserializer == abstractC0722m ? this : new EnumSetDeserializer(this, abstractC0722m, this._nullProvider, this._unwrapSingle);
    }

    @Deprecated
    public EnumSetDeserializer withResolved(AbstractC0722m abstractC0722m, Boolean bool) {
        return withResolved(abstractC0722m, this._nullProvider, bool);
    }

    public EnumSetDeserializer withResolved(AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m, Boolean bool) {
        return (Objects.equals(this._unwrapSingle, bool) && this._enumDeserializer == abstractC0722m && this._nullProvider == abstractC0722m) ? this : new EnumSetDeserializer(this, abstractC0722m, interfaceC1178m, bool);
    }

    @Override // p069X0.AbstractC0722m
    public EnumSet<?> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        EnumSet enumSetConstructSet = constructSet();
        if (!abstractC0545m.mo1172Q()) {
            return handleNonArray(abstractC0545m, abstractC0718i, enumSetConstructSet);
        }
        return _deserialize(abstractC0545m, abstractC0718i, enumSetConstructSet);
    }

    @Override // p069X0.AbstractC0722m
    public EnumSet<?> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumSet<?> enumSet) {
        if (!abstractC0545m.mo1172Q()) {
            return handleNonArray(abstractC0545m, abstractC0718i, enumSet);
        }
        return _deserialize(abstractC0545m, abstractC0718i, enumSet);
    }

    @Deprecated
    public EnumSetDeserializer(EnumSetDeserializer enumSetDeserializer, AbstractC0722m abstractC0722m, Boolean bool) {
        this(enumSetDeserializer, abstractC0722m, enumSetDeserializer._nullProvider, bool);
    }

    public EnumSetDeserializer(EnumSetDeserializer enumSetDeserializer, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m, Boolean bool) {
        super(enumSetDeserializer);
        this._enumType = enumSetDeserializer._enumType;
        this._enumDeserializer = abstractC0722m;
        this._nullProvider = interfaceC1178m;
        this._skipNullValues = C1165q.m3010a(interfaceC1178m);
        this._unwrapSingle = bool;
    }
}

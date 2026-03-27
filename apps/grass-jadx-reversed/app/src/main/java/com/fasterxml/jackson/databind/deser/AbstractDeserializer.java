package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.C1167s;
import com.fasterxml.jackson.databind.deser.impl.C1172x;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.Serializable;
import java.util.Map;
import p039M0.AbstractC0485d0;
import p039M0.AbstractC0489f0;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p082b1.AbstractC1041l;
import p082b1.C1018N;
import p100g1.AbstractC1398g;
import p114l1.C1675q;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;

/* JADX INFO: loaded from: classes.dex */
public class AbstractDeserializer extends AbstractC0722m implements InterfaceC1139f, Serializable {
    private static final long serialVersionUID = 1;
    protected final boolean _acceptBoolean;
    protected final boolean _acceptDouble;
    protected final boolean _acceptInt;
    protected final boolean _acceptString;
    protected final Map<String, AbstractC1204t> _backRefProperties;
    protected final AbstractC0721l _baseType;
    protected final C1167s _objectIdReader;
    protected transient Map<String, AbstractC1204t> _properties;

    public AbstractDeserializer(C1137d c1137d, AbstractC0712c abstractC0712c, Map<String, AbstractC1204t> map, Map<String, AbstractC1204t> map2) {
        AbstractC0721l abstractC0721l = abstractC0712c.f1980a;
        this._baseType = abstractC0721l;
        this._objectIdReader = c1137d.f3940j;
        this._backRefProperties = map;
        this._properties = map2;
        Class cls = abstractC0721l.f2036e;
        this._acceptString = cls.isAssignableFrom(String.class);
        boolean z3 = true;
        this._acceptBoolean = cls == Boolean.TYPE || cls.isAssignableFrom(Boolean.class);
        this._acceptInt = cls == Integer.TYPE || cls.isAssignableFrom(Integer.class);
        if (cls != Double.TYPE && !cls.isAssignableFrom(Double.class)) {
            z3 = false;
        }
        this._acceptDouble = z3;
    }

    public static AbstractDeserializer constructForNonPOJO(AbstractC0712c abstractC0712c) {
        return new AbstractDeserializer(abstractC0712c);
    }

    public Object _deserializeFromObjectId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        abstractC0718i.mo1855t(this._objectIdReader.f4026h.deserialize(abstractC0545m, abstractC0718i), this._objectIdReader.f4025g).getClass();
        throw null;
    }

    public Object _deserializeIfNatural(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        switch (abstractC0545m.mo1191f()) {
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                if (this._acceptString) {
                    return abstractC0545m.mo1157B();
                }
                return null;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                if (this._acceptInt) {
                    return Integer.valueOf(abstractC0545m.mo1204s());
                }
                return null;
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                if (this._acceptDouble) {
                    return Double.valueOf(abstractC0545m.mo1201p());
                }
                return null;
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                if (this._acceptBoolean) {
                    return Boolean.TRUE;
                }
                return null;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                if (this._acceptBoolean) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) throws C0850b {
        AbstractC1041l abstractC1041lMo1805c;
        C1018N c1018nMo1798z;
        AbstractC0721l abstractC0721l;
        AbstractC0485d0 abstractC0485d0M1813h;
        AbstractC1204t abstractC1204t;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        if (interfaceC0714e == null || abstractC0711bM2149d == null || (abstractC1041lMo1805c = interfaceC0714e.mo1805c()) == null || (c1018nMo1798z = abstractC0711bM2149d.mo1798z(abstractC1041lMo1805c)) == null) {
            return this._properties == null ? this : new AbstractDeserializer(this, this._objectIdReader, (Map<String, AbstractC1204t>) null);
        }
        abstractC0718i.m1814i(c1018nMo1798z);
        C1018N c1018nMo1729A = abstractC0711bM2149d.mo1729A(abstractC1041lMo1805c, c1018nMo1798z);
        Class cls = c1018nMo1729A.f3611b;
        if (cls == AbstractC0489f0.class) {
            Map<String, AbstractC1204t> map = this._properties;
            C0703E c0703e = c1018nMo1729A.f3610a;
            AbstractC1204t abstractC1204t2 = map == null ? null : map.get(c0703e.f1928e);
            if (abstractC1204t2 == null) {
                abstractC0718i.mo1713k("Invalid Object Id definition for " + AbstractC1745j.m3903z(handledType()) + ": cannot find property with name " + (c0703e == null ? "[null]" : AbstractC1745j.m3880c(c0703e.f1928e)));
                throw null;
            }
            abstractC0485d0M1813h = new C1172x(c1018nMo1729A.f3613d);
            abstractC0721l = abstractC1204t2.f4103h;
            abstractC1204t = abstractC1204t2;
        } else {
            abstractC0718i.m1814i(c1018nMo1729A);
            AbstractC0721l abstractC0721lM1848m = abstractC0718i.m1848m(cls);
            abstractC0718i.mo1711f().getClass();
            abstractC0721l = C1675q.m3771l(abstractC0721lM1848m, AbstractC0485d0.class)[0];
            abstractC0485d0M1813h = abstractC0718i.m1813h(c1018nMo1729A);
            abstractC1204t = null;
        }
        AbstractC0721l abstractC0721l2 = abstractC0721l;
        return new AbstractDeserializer(this, new C1167s(abstractC0721l2, c1018nMo1729A.f3610a, abstractC0485d0M1813h, abstractC0718i.m1856u(abstractC0721l2), abstractC1204t), (Map<String, AbstractC1204t>) null);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1860y(this._baseType.f2036e, new C1207w(this._baseType), "abstract types either need to be mapped to concrete types, have custom deserializer, or contain additional type information", new Object[0]);
        throw null;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        EnumC0548p enumC0548pMo1190e;
        if (this._objectIdReader != null && (enumC0548pMo1190e = abstractC0545m.mo1190e()) != null) {
            if (enumC0548pMo1190e.f1332l) {
                return _deserializeFromObjectId(abstractC0545m, abstractC0718i);
            }
            if (enumC0548pMo1190e == EnumC0548p.START_OBJECT) {
                enumC0548pMo1190e = abstractC0545m.mo1177V();
            }
            if (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
                this._objectIdReader.f4025g.getClass();
            }
        }
        Object obj_deserializeIfNatural = _deserializeIfNatural(abstractC0545m, abstractC0718i);
        return obj_deserializeIfNatural != null ? obj_deserializeIfNatural : abstractC1398g.mo3402d(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC1204t findBackReference(String str) {
        Map<String, AbstractC1204t> map = this._backRefProperties;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // p069X0.AbstractC0722m
    public C1167s getObjectIdReader() {
        return this._objectIdReader;
    }

    @Override // p069X0.AbstractC0722m
    public Class<?> handledType() {
        return this._baseType.f2036e;
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return true;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5892h;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return null;
    }

    @Deprecated
    public AbstractDeserializer(C1137d c1137d, AbstractC0712c abstractC0712c, Map<String, AbstractC1204t> map) {
        this(c1137d, abstractC0712c, map, null);
    }

    public AbstractDeserializer(AbstractC0712c abstractC0712c) {
        AbstractC0721l abstractC0721l = abstractC0712c.f1980a;
        this._baseType = abstractC0721l;
        this._objectIdReader = null;
        this._backRefProperties = null;
        Class cls = abstractC0721l.f2036e;
        this._acceptString = cls.isAssignableFrom(String.class);
        boolean z3 = true;
        this._acceptBoolean = cls == Boolean.TYPE || cls.isAssignableFrom(Boolean.class);
        this._acceptInt = cls == Integer.TYPE || cls.isAssignableFrom(Integer.class);
        if (cls != Double.TYPE && !cls.isAssignableFrom(Double.class)) {
            z3 = false;
        }
        this._acceptDouble = z3;
    }

    public AbstractDeserializer(AbstractDeserializer abstractDeserializer, C1167s c1167s, Map<String, AbstractC1204t> map) {
        this._baseType = abstractDeserializer._baseType;
        this._backRefProperties = abstractDeserializer._backRefProperties;
        this._acceptString = abstractDeserializer._acceptString;
        this._acceptBoolean = abstractDeserializer._acceptBoolean;
        this._acceptInt = abstractDeserializer._acceptInt;
        this._acceptDouble = abstractDeserializer._acceptDouble;
        this._objectIdReader = c1167s;
        this._properties = map;
    }
}

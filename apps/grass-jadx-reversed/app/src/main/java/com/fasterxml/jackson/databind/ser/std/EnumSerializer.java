package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import p005B.AbstractC0032g;
import p033K0.AbstractC0405c;
import p039M0.C0502q;
import p039M0.EnumC0501p;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p042N0.InterfaceC0551s;
import p050Q0.C0597j;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.C0707I;
import p069X0.EnumC0708J;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p082b1.C1005A;
import p082b1.C1033d;
import p092e1.InterfaceC1338c;
import p109j1.C1493a;
import p109j1.C1505m;
import p109j1.C1512t;
import p109j1.C1514v;
import p112k1.InterfaceC1638f;
import p118m1.C1750o;
import p125o0.AbstractC1800j;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class EnumSerializer extends StdScalarSerializer<Enum<?>> implements InterfaceC1638f {
    private static final long serialVersionUID = 1;
    protected final Boolean _serializeAsIndex;
    protected final C1750o _values;
    protected final C1750o _valuesByEnumNaming;

    public EnumSerializer(C1750o c1750o, Boolean bool) {
        super(c1750o.f6123e, false);
        this._values = c1750o;
        this._serializeAsIndex = bool;
        this._valuesByEnumNaming = null;
    }

    public static Boolean _isShapeWrittenUsingIndex(Class<?> cls, C0502q c0502q, boolean z3, Boolean bool) {
        EnumC0501p enumC0501p = c0502q == null ? null : c0502q.f1170f;
        if (enumC0501p == null || enumC0501p == EnumC0501p.f1157e || enumC0501p == EnumC0501p.f1159g) {
            return bool;
        }
        if (enumC0501p == EnumC0501p.f1165m || enumC0501p == EnumC0501p.f1158f) {
            return Boolean.FALSE;
        }
        if (enumC0501p.m1013a() || enumC0501p == EnumC0501p.f1160h) {
            return Boolean.TRUE;
        }
        String name = cls.getName();
        String str = z3 ? "class" : "property";
        StringBuilder sb = new StringBuilder("Unsupported serialization shape (");
        sb.append(enumC0501p);
        sb.append(") for Enum ");
        sb.append(name);
        sb.append(", not supported as ");
        throw new IllegalArgumentException(AbstractC0032g.m157o(sb, str, " annotation"));
    }

    public static EnumSerializer construct(Class<?> cls, C0707I c0707i, AbstractC0712c abstractC0712c, C0502q c0502q) {
        return new EnumSerializer(C1750o.m3909a(c0707i, cls), _isShapeWrittenUsingIndex(cls, c0502q, true, null), constructEnumNamingStrategyValues(c0707i, cls, ((C1005A) abstractC0712c).f3582e));
    }

    public static C1750o constructEnumNamingStrategyValues(C0707I c0707i, Class<Enum<?>> cls, C1033d c1033d) {
        AbstractC1800j.m3988f(c0707i.m2149d().mo1777l(c1033d), c0707i.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        return null;
    }

    public final boolean _serializeAsIndex(AbstractC0709K abstractC0709K) {
        Boolean bool = this._serializeAsIndex;
        if (bool != null) {
            return bool.booleanValue();
        }
        return abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_ENUMS_USING_INDEX);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        ((AbstractC0405c) interfaceC1338c).getClass();
        if (_serializeAsIndex(null)) {
            visitIntFormat(interfaceC1338c, abstractC0721l, EnumC0544l.f1298e);
        }
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, handledType());
        if (c0502qFindFormatOverrides != null) {
            Boolean bool_isShapeWrittenUsingIndex = _isShapeWrittenUsingIndex(handledType(), c0502qFindFormatOverrides, false, this._serializeAsIndex);
            if (!Objects.equals(bool_isShapeWrittenUsingIndex, this._serializeAsIndex)) {
                return new EnumSerializer(this._values, bool_isShapeWrittenUsingIndex);
            }
        }
        return this;
    }

    public C1750o getEnumValues() {
        return this._values;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        AbstractC0725p abstractC0725pM3551a;
        if (_serializeAsIndex(abstractC0709K)) {
            return createSchemaNode("integer", true);
        }
        C1514v c1514vCreateSchemaNode = createSchemaNode("string", true);
        if (type != null && abstractC0709K.m1811c(type).m1888w()) {
            C1505m c1505m = c1514vCreateSchemaNode.f5435e;
            c1505m.getClass();
            C1493a c1493a = new C1493a(c1505m);
            c1514vCreateSchemaNode.f5464f.put("enum", c1493a);
            Iterator it = Arrays.asList(this._values.f6124f).iterator();
            while (it.hasNext()) {
                String str = ((C0597j) ((InterfaceC0551s) it.next())).f1531e;
                C1505m c1505m2 = c1493a.f5435e;
                if (str == null) {
                    c1505m2.getClass();
                    abstractC0725pM3551a = C1512t.f5463e;
                } else {
                    c1505m2.getClass();
                    abstractC0725pM3551a = C1505m.m3551a(str);
                }
                c1493a.f5424f.add(abstractC0725pM3551a);
            }
        }
        return c1514vCreateSchemaNode;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public final void serialize(Enum<?> r22, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        C1750o c1750o = this._valuesByEnumNaming;
        if (c1750o != null) {
            abstractC0540h.mo1124Q(c1750o.f6124f[r22.ordinal()]);
            return;
        }
        if (_serializeAsIndex(abstractC0709K)) {
            abstractC0540h.mo1149v(r22.ordinal());
            return;
        }
        if (abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_ENUMS_USING_TO_STRING)) {
            abstractC0540h.mo1125R(r22.toString());
        } else {
            abstractC0540h.mo1124Q(this._values.f6124f[r22.ordinal()]);
        }
    }

    public EnumSerializer(C1750o c1750o, Boolean bool, C1750o c1750o2) {
        super(c1750o.f6123e, false);
        this._values = c1750o;
        this._serializeAsIndex = bool;
        this._valuesByEnumNaming = c1750o2;
    }
}

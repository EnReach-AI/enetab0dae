package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.AbstractC1671m;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class MapEntryDeserializer extends ContainerDeserializerBase<Map.Entry<Object, Object>> implements InterfaceC1139f {
    private static final long serialVersionUID = 1;
    protected final AbstractC0730u _keyDeserializer;
    protected final AbstractC0722m _valueDeserializer;
    protected final AbstractC1398g _valueTypeDeserializer;

    public MapEntryDeserializer(AbstractC0721l abstractC0721l, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g) {
        super(abstractC0721l);
        if (((AbstractC1671m) abstractC0721l).f5913l.f5929f.length != 2) {
            throw new IllegalArgumentException("Missing generic type information for " + abstractC0721l);
        }
        this._keyDeserializer = abstractC0730u;
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) throws C0850b {
        AbstractC0730u abstractC0730uM1854s = this._keyDeserializer;
        if (abstractC0730uM1854s == null) {
            abstractC0730uM1854s = abstractC0718i.m1854s(((AbstractC1671m) this._containerType).f5913l.m3764d(0));
        }
        AbstractC0722m abstractC0722mFindConvertingContentDeserializer = findConvertingContentDeserializer(abstractC0718i, interfaceC0714e, this._valueDeserializer);
        AbstractC0721l abstractC0721lM3764d = ((AbstractC1671m) this._containerType).f5913l.m3764d(1);
        AbstractC0722m abstractC0722mM1852q = abstractC0722mFindConvertingContentDeserializer == null ? abstractC0718i.m1852q(abstractC0721lM3764d, interfaceC0714e) : abstractC0718i.m1823A(abstractC0722mFindConvertingContentDeserializer, interfaceC0714e, abstractC0721lM3764d);
        AbstractC1398g abstractC1398gMo3404f = this._valueTypeDeserializer;
        if (abstractC1398gMo3404f != null) {
            abstractC1398gMo3404f = abstractC1398gMo3404f.mo3404f(interfaceC0714e);
        }
        return withResolved(abstractC0730uM1854s, abstractC1398gMo3404f, abstractC0722mM1852q);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3402d(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public AbstractC0722m getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public AbstractC0721l getContentType() {
        return ((AbstractC1671m) this._containerType).f5913l.m3764d(1);
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5891g;
    }

    public MapEntryDeserializer withResolved(AbstractC0730u abstractC0730u, AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m) {
        return (this._keyDeserializer == abstractC0730u && this._valueDeserializer == abstractC0722m && this._valueTypeDeserializer == abstractC1398g) ? this : new MapEntryDeserializer(this, abstractC0730u, abstractC0722m, abstractC1398g);
    }

    @Override // p069X0.AbstractC0722m
    public Map.Entry<Object, Object> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        Object objDeserializeWithType;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.START_OBJECT) {
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        } else if (enumC0548pMo1190e != EnumC0548p.FIELD_NAME && enumC0548pMo1190e != EnumC0548p.END_OBJECT) {
            if (enumC0548pMo1190e == EnumC0548p.START_ARRAY) {
                return _deserializeFromArray(abstractC0545m, abstractC0718i);
            }
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        if (enumC0548pMo1190e != EnumC0548p.FIELD_NAME) {
            if (enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
                abstractC0718i.m1841S(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]);
                throw null;
            }
            abstractC0718i.m1825C(abstractC0545m, handledType());
            throw null;
        }
        AbstractC0730u abstractC0730u = this._keyDeserializer;
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        String strMo1188d = abstractC0545m.mo1188d();
        Object objMo1910a = abstractC0730u.mo1910a(abstractC0718i, strMo1188d);
        try {
            if (abstractC0545m.mo1177V() == EnumC0548p.VALUE_NULL) {
                objDeserializeWithType = abstractC0722m.getNullValue(abstractC0718i);
            } else if (abstractC1398g == null) {
                objDeserializeWithType = abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
            } else {
                objDeserializeWithType = abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0718i, e3, Map.Entry.class, strMo1188d);
            objDeserializeWithType = null;
        }
        EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
        if (enumC0548pMo1177V != EnumC0548p.END_OBJECT) {
            if (enumC0548pMo1177V == EnumC0548p.FIELD_NAME) {
                abstractC0718i.m1841S(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", abstractC0545m.mo1188d());
                throw null;
            }
            abstractC0718i.m1841S(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + enumC0548pMo1177V, new Object[0]);
            throw null;
        }
        return new AbstractMap.SimpleEntry(objMo1910a, objDeserializeWithType);
    }

    public MapEntryDeserializer(MapEntryDeserializer mapEntryDeserializer) {
        super(mapEntryDeserializer);
        this._keyDeserializer = mapEntryDeserializer._keyDeserializer;
        this._valueDeserializer = mapEntryDeserializer._valueDeserializer;
        this._valueTypeDeserializer = mapEntryDeserializer._valueTypeDeserializer;
    }

    public MapEntryDeserializer(MapEntryDeserializer mapEntryDeserializer, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g) {
        super(mapEntryDeserializer);
        this._keyDeserializer = abstractC0730u;
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
    }

    @Override // p069X0.AbstractC0722m
    public Map.Entry<Object, Object> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map.Entry<Object, Object> entry) {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }
}

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.deser.impl.C1160l;
import java.lang.reflect.Type;
import p001A.C0009j;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;
import p112k1.InterfaceC1643k;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1748m;

/* JADX INFO: loaded from: classes.dex */
public class StdDelegatingSerializer extends StdSerializer<Object> implements InterfaceC1638f, InterfaceC1643k {
    protected final InterfaceC1748m _converter;
    protected final AbstractC0728s _delegateSerializer;
    protected final AbstractC0721l _delegateType;

    public StdDelegatingSerializer(InterfaceC1748m interfaceC1748m) {
        super(Object.class);
        this._converter = interfaceC1748m;
        this._delegateType = null;
        this._delegateSerializer = null;
    }

    public AbstractC0728s _findSerializer(Object obj, AbstractC0709K abstractC0709K) throws C0850b {
        Class<?> cls = obj.getClass();
        AbstractC0728s abstractC0728sM3095b = abstractC0709K.f1975n.m3095b(cls);
        if (abstractC0728sM3095b != null) {
            return abstractC0728sM3095b;
        }
        C0009j c0009j = abstractC0709K.f1969h;
        AbstractC0728s abstractC0728sM40R = c0009j.m40R(cls);
        if (abstractC0728sM40R != null) {
            return abstractC0728sM40R;
        }
        AbstractC0728s abstractC0728sM39Q = c0009j.m39Q(abstractC0709K.f1966e.m2148c(cls));
        if (abstractC0728sM39Q != null) {
            return abstractC0728sM39Q;
        }
        AbstractC0728s abstractC0728sM1715m = abstractC0709K.m1715m(cls);
        return abstractC0728sM1715m == null ? abstractC0709K.m1702B(cls) : abstractC0728sM1715m;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        AbstractC0728s abstractC0728s = this._delegateSerializer;
        if (abstractC0728s != null) {
            abstractC0728s.acceptJsonFormatVisitor(interfaceC1338c, abstractC0721l);
        }
    }

    public Object convertValue(Object obj) {
        return ((C1160l) this._converter).m3009b(obj);
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sM1704D = this._delegateSerializer;
        AbstractC0721l abstractC0721l = this._delegateType;
        if (abstractC0728sM1704D == null) {
            if (abstractC0721l == null) {
                InterfaceC1748m interfaceC1748m = this._converter;
                abstractC0709K.mo1711f();
                abstractC0721l = ((C1160l) interfaceC1748m).f4009a;
            }
            if (!abstractC0721l.m1889x() && (abstractC0728sM1704D = abstractC0709K.f1975n.m3094a(abstractC0721l)) == null && (abstractC0728sM1704D = abstractC0709K.f1969h.m39Q(abstractC0721l)) == null && (abstractC0728sM1704D = abstractC0709K.m1714l(abstractC0721l)) == null) {
                abstractC0728sM1704D = abstractC0709K.m1702B(abstractC0721l.f2036e);
            }
        }
        if (abstractC0728sM1704D instanceof InterfaceC1638f) {
            abstractC0728sM1704D = abstractC0709K.m1704D(abstractC0728sM1704D, interfaceC0714e);
        }
        return (abstractC0728sM1704D == this._delegateSerializer && abstractC0721l == this._delegateType) ? this : withDelegate(this._converter, abstractC0721l, abstractC0728sM1704D);
    }

    public InterfaceC1748m getConverter() {
        return this._converter;
    }

    @Override // p069X0.AbstractC0728s
    public AbstractC0728s getDelegatee() {
        return this._delegateSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        AbstractC0728s abstractC0728s = this._delegateSerializer;
        return abstractC0728s instanceof StdSerializer ? ((StdSerializer) abstractC0728s).getSchema(abstractC0709K, type) : super.getSchema(abstractC0709K, type);
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Object obj) {
        Object objConvertValue = convertValue(obj);
        if (objConvertValue == null) {
            return true;
        }
        AbstractC0728s abstractC0728s = this._delegateSerializer;
        return abstractC0728s == null ? obj == null : abstractC0728s.isEmpty(abstractC0709K, objConvertValue);
    }

    @Override // p112k1.InterfaceC1643k
    public void resolve(AbstractC0709K abstractC0709K) {
        Object obj = this._delegateSerializer;
        if (obj == null || !(obj instanceof InterfaceC1643k)) {
            return;
        }
        ((InterfaceC1643k) obj).resolve(abstractC0709K);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws C0850b {
        Object objConvertValue = convertValue(obj);
        if (objConvertValue == null) {
            abstractC0709K.m1719q(abstractC0540h);
            return;
        }
        AbstractC0728s abstractC0728s_findSerializer = this._delegateSerializer;
        if (abstractC0728s_findSerializer == null) {
            abstractC0728s_findSerializer = _findSerializer(objConvertValue, abstractC0709K);
        }
        abstractC0728s_findSerializer.serialize(objConvertValue, abstractC0540h, abstractC0709K);
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws C0850b {
        Object objConvertValue = convertValue(obj);
        AbstractC0728s abstractC0728s_findSerializer = this._delegateSerializer;
        if (abstractC0728s_findSerializer == null) {
            abstractC0728s_findSerializer = _findSerializer(obj, abstractC0709K);
        }
        abstractC0728s_findSerializer.serializeWithType(objConvertValue, abstractC0540h, abstractC0709K, abstractC1399h);
    }

    public StdDelegatingSerializer withDelegate(InterfaceC1748m interfaceC1748m, AbstractC0721l abstractC0721l, AbstractC0728s abstractC0728s) {
        AbstractC1745j.m3876F(StdDelegatingSerializer.class, this, "withDelegate");
        return new StdDelegatingSerializer(interfaceC1748m, abstractC0721l, abstractC0728s);
    }

    public <T> StdDelegatingSerializer(Class<T> cls, InterfaceC1748m interfaceC1748m) {
        super(cls, false);
        this._converter = interfaceC1748m;
        this._delegateType = null;
        this._delegateSerializer = null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type, boolean z3) {
        AbstractC0728s abstractC0728s = this._delegateSerializer;
        if (abstractC0728s instanceof StdSerializer) {
            return ((StdSerializer) abstractC0728s).getSchema(abstractC0709K, type, z3);
        }
        return super.getSchema(abstractC0709K, type);
    }

    public StdDelegatingSerializer(InterfaceC1748m interfaceC1748m, AbstractC0721l abstractC0721l, AbstractC0728s abstractC0728s) {
        super(abstractC0721l);
        this._converter = interfaceC1748m;
        this._delegateType = abstractC0721l;
        this._delegateSerializer = abstractC0728s;
    }
}

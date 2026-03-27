package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.impl.AbstractC1223k;
import com.fasterxml.jackson.databind.ser.impl.C1219g;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import p033K0.AbstractC0405c;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.C0706H;
import p069X0.C0724o;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p082b1.AbstractC1041l;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p109j1.C1505m;
import p109j1.C1514v;
import p112k1.InterfaceC1638f;
import p118m1.AbstractC1745j;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class JsonValueSerializer extends StdSerializer<Object> implements InterfaceC1638f {
    protected final AbstractC1041l _accessor;
    protected transient AbstractC1223k _dynamicSerializers;
    protected final boolean _forceTypeInformation;
    protected final InterfaceC0714e _property;
    protected final AbstractC0728s _valueSerializer;
    protected final AbstractC0721l _valueType;
    protected final AbstractC1399h _valueTypeSerializer;

    public JsonValueSerializer(AbstractC1041l abstractC1041l, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        super(abstractC1041l.mo2769f());
        this._accessor = abstractC1041l;
        this._valueType = abstractC1041l.mo2769f();
        this._valueTypeSerializer = abstractC1399h;
        this._valueSerializer = abstractC0728s;
        this._property = null;
        this._forceTypeInformation = true;
        this._dynamicSerializers = C1219g.f4140b;
    }

    private static final Class<Object> _notNullClass(Class<?> cls) {
        return cls == null ? Object.class : cls;
    }

    public boolean _acceptJsonFormatVisitorForEnum(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, Class<?> cls) {
        interfaceC1338c.getClass();
        return true;
    }

    public AbstractC0728s _findDynamicSerializer(AbstractC0709K abstractC0709K, Class<?> cls) {
        AbstractC0728s abstractC0728sMo3092c = this._dynamicSerializers.mo3092c(cls);
        if (abstractC0728sMo3092c != null) {
            return abstractC0728sMo3092c;
        }
        if (!this._valueType.mo1881p()) {
            AbstractC0728s abstractC0728sM1725w = abstractC0709K.m1725w(cls, this._property);
            this._dynamicSerializers = this._dynamicSerializers.mo3091b(cls, abstractC0728sM1725w);
            return abstractC0728sM1725w;
        }
        AbstractC0721l abstractC0721lM1718p = abstractC0709K.m1718p(this._valueType, cls);
        AbstractC0728s abstractC0728sM1724v = abstractC0709K.m1724v(abstractC0721lM1718p, this._property);
        AbstractC1223k abstractC1223k = this._dynamicSerializers;
        abstractC1223k.getClass();
        this._dynamicSerializers = abstractC1223k.mo3091b(abstractC0721lM1718p.f2036e, abstractC0728sM1724v);
        return abstractC0728sM1724v;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        Class clsMo2770i = this._accessor.mo2770i();
        if (clsMo2770i != null) {
            Annotation[] annotationArr = AbstractC1745j.f6110a;
            if (Enum.class.isAssignableFrom(clsMo2770i) && _acceptJsonFormatVisitorForEnum(interfaceC1338c, abstractC0721l, clsMo2770i)) {
                return;
            }
        }
        AbstractC0728s abstractC0728s = this._valueSerializer;
        if (abstractC0728s != null) {
            abstractC0728s.acceptJsonFormatVisitor(interfaceC1338c, this._valueType);
        } else {
            ((AbstractC0405c) interfaceC1338c).getClass();
            throw null;
        }
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        AbstractC1399h abstractC1399hMo3422g = this._valueTypeSerializer;
        if (abstractC1399hMo3422g != null) {
            abstractC1399hMo3422g = abstractC1399hMo3422g.mo3422g(interfaceC0714e);
        }
        AbstractC0728s abstractC0728s = this._valueSerializer;
        if (abstractC0728s != null) {
            return withResolved(interfaceC0714e, abstractC1399hMo3422g, abstractC0709K.m1703C(abstractC0728s, interfaceC0714e), this._forceTypeInformation);
        }
        if (!abstractC0709K.f1966e.m2157l(EnumC0731v.USE_STATIC_TYPING) && !Modifier.isFinal(this._valueType.f2036e.getModifiers())) {
            return interfaceC0714e != this._property ? withResolved(interfaceC0714e, abstractC1399hMo3422g, abstractC0728s, this._forceTypeInformation) : this;
        }
        AbstractC0728s abstractC0728sM1724v = abstractC0709K.m1724v(this._valueType, interfaceC0714e);
        return withResolved(interfaceC0714e, abstractC1399hMo3422g, abstractC0728sM1724v, isNaturalTypeWithStdHandling(this._valueType.f2036e, abstractC0728sM1724v));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        AbstractC0728s abstractC0728s = this._valueSerializer;
        if (abstractC0728s instanceof StdSerializer) {
            return ((StdSerializer) abstractC0728s).getSchema(abstractC0709K, null);
        }
        C1514v c1514v = new C1514v(C1505m.f5450e);
        c1514v.m3556p("type", "any");
        return c1514v;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Object obj) {
        Object objMo2772l = this._accessor.mo2772l(obj);
        if (objMo2772l == null) {
            return true;
        }
        AbstractC0728s abstractC0728s_findDynamicSerializer = this._valueSerializer;
        if (abstractC0728s_findDynamicSerializer == null) {
            try {
                abstractC0728s_findDynamicSerializer = _findDynamicSerializer(abstractC0709K, objMo2772l.getClass());
            } catch (C0724o e3) {
                throw new C0706H(e3);
            }
        }
        return abstractC0728s_findDynamicSerializer.isEmpty(abstractC0709K, objMo2772l);
    }

    public boolean isNaturalTypeWithStdHandling(Class<?> cls, AbstractC0728s abstractC0728s) {
        if (cls.isPrimitive()) {
            if (cls != Integer.TYPE && cls != Boolean.TYPE && cls != Double.TYPE) {
                return false;
            }
        } else if (cls != String.class && cls != Integer.class && cls != Boolean.class && cls != Double.class) {
            return false;
        }
        return isDefaultSerializer(abstractC0728s);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        Object objMo2772l;
        try {
            objMo2772l = this._accessor.mo2772l(obj);
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, obj, this._accessor.mo2767d() + "()");
            objMo2772l = null;
        }
        if (objMo2772l == null) {
            abstractC0709K.m1719q(abstractC0540h);
            return;
        }
        AbstractC0728s abstractC0728s_findDynamicSerializer = this._valueSerializer;
        if (abstractC0728s_findDynamicSerializer == null) {
            abstractC0728s_findDynamicSerializer = _findDynamicSerializer(abstractC0709K, objMo2772l.getClass());
        }
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        if (abstractC1399h != null) {
            abstractC0728s_findDynamicSerializer.serializeWithType(objMo2772l, abstractC0540h, abstractC0709K, abstractC1399h);
        } else {
            abstractC0728s_findDynamicSerializer.serialize(objMo2772l, abstractC0540h, abstractC0709K);
        }
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        Object objMo2772l;
        try {
            objMo2772l = this._accessor.mo2772l(obj);
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, obj, this._accessor.mo2767d() + "()");
            objMo2772l = null;
        }
        if (objMo2772l == null) {
            abstractC0709K.m1719q(abstractC0540h);
            return;
        }
        AbstractC0728s abstractC0728s_findDynamicSerializer = this._valueSerializer;
        if (abstractC0728s_findDynamicSerializer == null) {
            abstractC0728s_findDynamicSerializer = _findDynamicSerializer(abstractC0709K, objMo2772l.getClass());
        } else if (this._forceTypeInformation) {
            C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.VALUE_STRING, obj));
            abstractC0728s_findDynamicSerializer.serialize(objMo2772l, abstractC0540h, abstractC0709K);
            abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
            return;
        }
        abstractC0728s_findDynamicSerializer.serializeWithType(objMo2772l, abstractC0540h, abstractC0709K, new C1228a(abstractC1399h, obj));
    }

    public String toString() {
        return "(@JsonValue serializer for method " + this._accessor.mo2770i() + "#" + this._accessor.mo2767d() + ")";
    }

    public JsonValueSerializer withResolved(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, boolean z3) {
        return (this._property == interfaceC0714e && this._valueTypeSerializer == abstractC1399h && this._valueSerializer == abstractC0728s && z3 == this._forceTypeInformation) ? this : new JsonValueSerializer(this, interfaceC0714e, abstractC1399h, abstractC0728s, z3);
    }

    @Deprecated
    public JsonValueSerializer(AbstractC1041l abstractC1041l, AbstractC0728s abstractC0728s) {
        this(abstractC1041l, null, abstractC0728s);
    }

    public JsonValueSerializer(JsonValueSerializer jsonValueSerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, boolean z3) {
        super(_notNullClass(jsonValueSerializer.handledType()));
        this._accessor = jsonValueSerializer._accessor;
        this._valueType = jsonValueSerializer._valueType;
        this._valueTypeSerializer = abstractC1399h;
        this._valueSerializer = abstractC0728s;
        this._property = interfaceC0714e;
        this._forceTypeInformation = z3;
        this._dynamicSerializers = C1219g.f4140b;
    }
}

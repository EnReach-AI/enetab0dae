package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.impl.AbstractC1223k;
import com.fasterxml.jackson.databind.ser.impl.C1219g;
import java.lang.reflect.Modifier;
import p033K0.AbstractC0405c;
import p039M0.C0453A;
import p039M0.EnumC0511z;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p069X0.C0706H;
import p069X0.C0724o;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p071Y0.EnumC0747k;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;
import p114l1.C1668j;
import p118m1.AbstractC1757v;
import p118m1.C1739d;
import p118m1.C1755t;
import p118m1.C1756u;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReferenceTypeSerializer<T> extends StdSerializer<T> implements InterfaceC1638f {
    public static final Object MARKER_FOR_EMPTY = EnumC0511z.f1184g;
    private static final long serialVersionUID = 1;
    protected transient AbstractC1223k _dynamicSerializers;
    protected final InterfaceC0714e _property;
    protected final AbstractC0721l _referredType;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected final AbstractC1757v _unwrapper;
    protected final AbstractC0728s _valueSerializer;
    protected final AbstractC1399h _valueTypeSerializer;

    public ReferenceTypeSerializer(C1668j c1668j, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s) {
        super(c1668j);
        this._referredType = c1668j.f5907n;
        this._property = null;
        this._valueTypeSerializer = abstractC1399h;
        this._valueSerializer = abstractC0728s;
        this._unwrapper = null;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this._dynamicSerializers = C1219g.f4140b;
    }

    private final AbstractC0728s _findCachedSerializer(AbstractC0709K abstractC0709K, Class<?> cls) {
        AbstractC0728s abstractC0728sMo3092c = this._dynamicSerializers.mo3092c(cls);
        if (abstractC0728sMo3092c != null) {
            return abstractC0728sMo3092c;
        }
        AbstractC0728s abstractC0728sM1724v = this._referredType.mo1881p() ? abstractC0709K.m1724v(abstractC0709K.m1718p(this._referredType, cls), this._property) : abstractC0709K.m1725w(cls, this._property);
        AbstractC1757v abstractC1757v = this._unwrapper;
        if (abstractC1757v != null) {
            abstractC0728sM1724v = abstractC0728sM1724v.unwrappingSerializer(abstractC1757v);
        }
        AbstractC0728s abstractC0728s = abstractC0728sM1724v;
        this._dynamicSerializers = this._dynamicSerializers.mo3091b(cls, abstractC0728s);
        return abstractC0728s;
    }

    private final AbstractC0728s _findSerializer(AbstractC0709K abstractC0709K, AbstractC0721l abstractC0721l, InterfaceC0714e interfaceC0714e) {
        return abstractC0709K.m1724v(abstractC0721l, interfaceC0714e);
    }

    public abstract Object _getReferenced(T t3);

    public abstract Object _getReferencedIfPresent(T t3);

    public abstract boolean _isValuePresent(T t3);

    public boolean _useStatic(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e, AbstractC0721l abstractC0721l) {
        if (abstractC0721l.m1889x()) {
            return false;
        }
        if (Modifier.isFinal(abstractC0721l.f2036e.getModifiers()) || abstractC0721l.f2040i) {
            return true;
        }
        AbstractC0711b abstractC0711bM2149d = abstractC0709K.f1966e.m2149d();
        if (abstractC0711bM2149d != null && interfaceC0714e != null && interfaceC0714e.mo1805c() != null) {
            EnumC0747k enumC0747kMo1749U = abstractC0711bM2149d.mo1749U(interfaceC0714e.mo1805c());
            if (enumC0747kMo1749U == EnumC0747k.f2109f) {
                return true;
            }
            if (enumC0747kMo1749U == EnumC0747k.f2108e) {
                return false;
            }
        }
        return abstractC0709K.f1966e.m2157l(EnumC0731v.USE_STATIC_TYPING);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        AbstractC0728s abstractC0728s_findSerializer = this._valueSerializer;
        if (abstractC0728s_findSerializer == null) {
            ((AbstractC0405c) interfaceC1338c).getClass();
            abstractC0728s_findSerializer = _findSerializer(null, this._referredType, this._property);
            AbstractC1757v abstractC1757v = this._unwrapper;
            if (abstractC1757v != null) {
                abstractC0728s_findSerializer = abstractC0728s_findSerializer.unwrappingSerializer(abstractC1757v);
            }
        }
        abstractC0728s_findSerializer.acceptJsonFormatVisitor(interfaceC1338c, this._referredType);
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        C0453A c0453aMo1807e;
        AbstractC1399h abstractC1399hMo3422g = this._valueTypeSerializer;
        if (abstractC1399hMo3422g != null) {
            abstractC1399hMo3422g = abstractC1399hMo3422g.mo3422g(interfaceC0714e);
        }
        AbstractC0728s abstractC0728sFindAnnotatedContentSerializer = findAnnotatedContentSerializer(abstractC0709K, interfaceC0714e);
        if (abstractC0728sFindAnnotatedContentSerializer == null) {
            abstractC0728sFindAnnotatedContentSerializer = this._valueSerializer;
            if (abstractC0728sFindAnnotatedContentSerializer != null) {
                abstractC0728sFindAnnotatedContentSerializer = abstractC0709K.m1703C(abstractC0728sFindAnnotatedContentSerializer, interfaceC0714e);
            } else if (_useStatic(abstractC0709K, interfaceC0714e, this._referredType)) {
                abstractC0728sFindAnnotatedContentSerializer = _findSerializer(abstractC0709K, this._referredType, interfaceC0714e);
            }
        }
        ReferenceTypeSerializer<T> referenceTypeSerializerWithResolved = (this._property == interfaceC0714e && this._valueTypeSerializer == abstractC1399hMo3422g && this._valueSerializer == abstractC0728sFindAnnotatedContentSerializer) ? this : withResolved(interfaceC0714e, abstractC1399hMo3422g, abstractC0728sFindAnnotatedContentSerializer, this._unwrapper);
        if (interfaceC0714e == null || (c0453aMo1807e = interfaceC0714e.mo1807e(abstractC0709K.f1966e, handledType())) == null) {
            return referenceTypeSerializerWithResolved;
        }
        EnumC0511z enumC0511z = EnumC0511z.f1186i;
        EnumC0511z enumC0511z2 = c0453aMo1807e.f1097f;
        if (enumC0511z2 == enumC0511z) {
            return referenceTypeSerializerWithResolved;
        }
        int iOrdinal = enumC0511z2.ordinal();
        Object objM887h = null;
        boolean zMo1706F = true;
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    objM887h = MARKER_FOR_EMPTY;
                } else if (iOrdinal == 4) {
                    objM887h = AbstractC0405c.m887h(this._referredType);
                    if (objM887h != null && objM887h.getClass().isArray()) {
                        objM887h = C1739d.m3869b(objM887h);
                    }
                } else if (iOrdinal != 5) {
                    zMo1706F = false;
                } else {
                    objM887h = abstractC0709K.mo1705E(c0453aMo1807e.f1099h);
                    if (objM887h != null) {
                        zMo1706F = abstractC0709K.mo1706F(objM887h);
                    }
                }
            } else if (this._referredType.mo1629b()) {
                objM887h = MARKER_FOR_EMPTY;
            }
        }
        return (this._suppressableValue == objM887h && this._suppressNulls == zMo1706F) ? referenceTypeSerializerWithResolved : referenceTypeSerializerWithResolved.withContentInclusion(objM887h, zMo1706F);
    }

    public AbstractC0721l getReferredType() {
        return this._referredType;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, T t3) {
        if (!_isValuePresent(t3)) {
            return true;
        }
        Object obj_getReferenced = _getReferenced(t3);
        if (obj_getReferenced == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        AbstractC0728s abstractC0728s_findCachedSerializer = this._valueSerializer;
        if (abstractC0728s_findCachedSerializer == null) {
            try {
                abstractC0728s_findCachedSerializer = _findCachedSerializer(abstractC0709K, obj_getReferenced.getClass());
            } catch (C0724o e3) {
                throw new C0706H(e3);
            }
        }
        Object obj = this._suppressableValue;
        return obj == MARKER_FOR_EMPTY ? abstractC0728s_findCachedSerializer.isEmpty(abstractC0709K, obj_getReferenced) : obj.equals(obj_getReferenced);
    }

    @Override // p069X0.AbstractC0728s
    public boolean isUnwrappingSerializer() {
        return this._unwrapper != null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Object obj_getReferencedIfPresent = _getReferencedIfPresent(t3);
        if (obj_getReferencedIfPresent == null) {
            if (this._unwrapper == null) {
                abstractC0709K.m1719q(abstractC0540h);
                return;
            }
            return;
        }
        AbstractC0728s abstractC0728s_findCachedSerializer = this._valueSerializer;
        if (abstractC0728s_findCachedSerializer == null) {
            abstractC0728s_findCachedSerializer = _findCachedSerializer(abstractC0709K, obj_getReferencedIfPresent.getClass());
        }
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        if (abstractC1399h != null) {
            abstractC0728s_findCachedSerializer.serializeWithType(obj_getReferencedIfPresent, abstractC0540h, abstractC0709K, abstractC1399h);
        } else {
            abstractC0728s_findCachedSerializer.serialize(obj_getReferencedIfPresent, abstractC0540h, abstractC0709K);
        }
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        Object obj_getReferencedIfPresent = _getReferencedIfPresent(t3);
        if (obj_getReferencedIfPresent == null) {
            if (this._unwrapper == null) {
                abstractC0709K.m1719q(abstractC0540h);
            }
        } else {
            AbstractC0728s abstractC0728s_findCachedSerializer = this._valueSerializer;
            if (abstractC0728s_findCachedSerializer == null) {
                abstractC0728s_findCachedSerializer = _findCachedSerializer(abstractC0709K, obj_getReferencedIfPresent.getClass());
            }
            abstractC0728s_findCachedSerializer.serializeWithType(obj_getReferencedIfPresent, abstractC0540h, abstractC0709K, abstractC1399h);
        }
    }

    @Override // p069X0.AbstractC0728s
    public AbstractC0728s unwrappingSerializer(AbstractC1757v abstractC1757v) {
        AbstractC0728s abstractC0728sUnwrappingSerializer = this._valueSerializer;
        if (abstractC0728sUnwrappingSerializer != null && (abstractC0728sUnwrappingSerializer = abstractC0728sUnwrappingSerializer.unwrappingSerializer(abstractC1757v)) == this._valueSerializer) {
            return this;
        }
        AbstractC1757v abstractC1757v2 = this._unwrapper;
        if (abstractC1757v2 != null) {
            C1756u c1756u = AbstractC1757v.f6136e;
            abstractC1757v = new C1755t(abstractC1757v, abstractC1757v2);
        }
        return (this._valueSerializer == abstractC0728sUnwrappingSerializer && this._unwrapper == abstractC1757v) ? this : withResolved(this._property, this._valueTypeSerializer, abstractC0728sUnwrappingSerializer, abstractC1757v);
    }

    public abstract ReferenceTypeSerializer<T> withContentInclusion(Object obj, boolean z3);

    public abstract ReferenceTypeSerializer<T> withResolved(InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC1757v abstractC1757v);

    public ReferenceTypeSerializer(ReferenceTypeSerializer<?> referenceTypeSerializer, InterfaceC0714e interfaceC0714e, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC1757v abstractC1757v, Object obj, boolean z3) {
        super(referenceTypeSerializer);
        this._referredType = referenceTypeSerializer._referredType;
        this._dynamicSerializers = C1219g.f4140b;
        this._property = interfaceC0714e;
        this._valueTypeSerializer = abstractC1399h;
        this._valueSerializer = abstractC0728s;
        this._unwrapper = abstractC1757v;
        this._suppressableValue = obj;
        this._suppressNulls = z3;
    }
}

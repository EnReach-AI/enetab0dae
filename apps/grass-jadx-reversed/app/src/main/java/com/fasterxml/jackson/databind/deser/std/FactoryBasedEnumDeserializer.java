package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.impl.C1143A;
import com.fasterxml.jackson.databind.deser.impl.C1171w;
import java.io.IOException;
import p042N0.AbstractC0535c;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.C0723n;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p082b1.C1043n;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;

/* JADX INFO: loaded from: classes.dex */
class FactoryBasedEnumDeserializer extends StdDeserializer<Object> implements InterfaceC1139f {
    private static final long serialVersionUID = 1;
    protected final AbstractC1204t[] _creatorProps;
    protected final AbstractC0722m _deser;
    protected final C1043n _factory;
    protected final boolean _hasArgs;
    protected final AbstractC0721l _inputType;
    private volatile transient C1171w _propCreator;
    protected final AbstractC1208x _valueInstantiator;

    public FactoryBasedEnumDeserializer(Class<?> cls, C1043n c1043n, AbstractC0721l abstractC0721l, AbstractC1208x abstractC1208x, AbstractC1204t[] abstractC1204tArr) {
        super(cls);
        this._factory = c1043n;
        this._hasArgs = true;
        this._inputType = (abstractC0721l.m1883r(String.class) || abstractC0721l.m1883r(CharSequence.class)) ? null : abstractC0721l;
        this._deser = null;
        this._valueInstantiator = abstractC1208x;
        this._creatorProps = abstractC1204tArr;
    }

    private Throwable throwOrReturnThrowable(Throwable th, AbstractC0718i abstractC0718i) throws IOException {
        Throwable thM3894q = AbstractC1745j.m3894q(th);
        AbstractC1745j.m3873C(thM3894q);
        boolean z3 = abstractC0718i == null || abstractC0718i.m1833K(EnumC0719j.WRAP_EXCEPTIONS);
        if (thM3894q instanceof IOException) {
            if (!z3 || !(thM3894q instanceof AbstractC0535c)) {
                throw ((IOException) thM3894q);
            }
        } else if (!z3) {
            AbstractC1745j.m3875E(thM3894q);
        }
        return thM3894q;
    }

    public final Object _deserializeWithErrorWrapping(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t) {
        try {
            return abstractC1204t.m3079j(abstractC0545m, abstractC0718i);
        } catch (Exception e3) {
            return wrapAndThrow(e3, handledType(), abstractC1204t.f4102g.f1928e, abstractC0718i);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        AbstractC0721l abstractC0721l;
        return (this._deser == null && (abstractC0721l = this._inputType) != null && this._creatorProps == null) ? new FactoryBasedEnumDeserializer(this, abstractC0718i.m1852q(abstractC0721l, interfaceC0714e)) : this;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        String strMo1165J;
        Object objDeserialize;
        AbstractC0722m abstractC0722m = this._deser;
        if (abstractC0722m != null) {
            objDeserialize = abstractC0722m.deserialize(abstractC0545m, abstractC0718i);
        } else {
            if (!this._hasArgs) {
                abstractC0545m.mo1187c0();
                try {
                    return this._factory.mo2787o();
                } catch (Exception e3) {
                    Throwable thM3894q = AbstractC1745j.m3894q(e3);
                    AbstractC1745j.m3874D(thM3894q);
                    abstractC0718i.m1859x(this._valueClass, thM3894q);
                    throw null;
                }
            }
            if (this._creatorProps != null) {
                if (abstractC0545m.mo1173R()) {
                    C1171w c1171wM3011b = this._propCreator;
                    if (c1171wM3011b == null) {
                        c1171wM3011b = C1171w.m3011b(abstractC0718i, this._valueInstantiator, this._creatorProps, abstractC0718i.f1998g.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                        this._propCreator = c1171wM3011b;
                    }
                    abstractC0545m.mo1177V();
                    return deserializeEnumUsingPropertyBased(abstractC0545m, abstractC0718i, c1171wM3011b);
                }
                if (!this._valueInstantiator.mo3059h()) {
                    abstractC0718i.m1842T("Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", AbstractC1745j.m3895r(getValueType(abstractC0718i)), this._factory, abstractC0545m.mo1190e());
                    throw null;
                }
            }
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            boolean z3 = enumC0548pMo1190e == EnumC0548p.START_ARRAY && abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS);
            if (z3) {
                enumC0548pMo1190e = abstractC0545m.mo1177V();
            }
            if (enumC0548pMo1190e == null || !enumC0548pMo1190e.f1332l) {
                abstractC0545m.mo1187c0();
                strMo1165J = "";
            } else {
                strMo1165J = abstractC0545m.mo1165J();
            }
            if (z3 && abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
                handleMissingEndArrayForSingle(abstractC0545m, abstractC0718i);
            }
            objDeserialize = strMo1165J;
        }
        try {
            return this._factory.f3704h.invoke(this._valueClass, objDeserialize);
        } catch (Exception e4) {
            Throwable thM3894q2 = AbstractC1745j.m3894q(e4);
            AbstractC1745j.m3874D(thM3894q2);
            if ((thM3894q2 instanceof IllegalArgumentException) && abstractC0718i.m1833K(EnumC0719j.READ_UNKNOWN_ENUM_VALUES_AS_NULL)) {
                return null;
            }
            abstractC0718i.m1859x(this._valueClass, thM3894q2);
            throw null;
        }
    }

    public Object deserializeEnumUsingPropertyBased(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1171w c1171w) {
        C1143A c1143aM3014d = c1171w.m3014d(abstractC0545m, abstractC0718i, null);
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(strMo1188d);
            if (!c1143aM3014d.m2979d(strMo1188d) || abstractC1204tM3013c != null) {
                if (abstractC1204tM3013c != null) {
                    c1143aM3014d.m2977b(abstractC1204tM3013c, _deserializeWithErrorWrapping(abstractC0545m, abstractC0718i, abstractC1204tM3013c));
                } else {
                    abstractC0545m.mo1187c0();
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        return c1171w.m3012a(abstractC0718i, c1143aM3014d);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3400b(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC1208x getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return true;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5897m;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.FALSE;
    }

    public Object wrapAndThrow(Throwable th, Object obj, String str, AbstractC0718i abstractC0718i) throws IOException {
        Throwable thThrowOrReturnThrowable = throwOrReturnThrowable(th, abstractC0718i);
        int i3 = C0724o.f2045h;
        throw C0724o.m1894g(thThrowOrReturnThrowable, new C0723n(str, obj));
    }

    public FactoryBasedEnumDeserializer(Class<?> cls, C1043n c1043n) {
        super(cls);
        this._factory = c1043n;
        this._hasArgs = false;
        this._inputType = null;
        this._deser = null;
        this._valueInstantiator = null;
        this._creatorProps = null;
    }

    public FactoryBasedEnumDeserializer(FactoryBasedEnumDeserializer factoryBasedEnumDeserializer, AbstractC0722m abstractC0722m) {
        super(factoryBasedEnumDeserializer._valueClass);
        this._inputType = factoryBasedEnumDeserializer._inputType;
        this._factory = factoryBasedEnumDeserializer._factory;
        this._hasArgs = factoryBasedEnumDeserializer._hasArgs;
        this._valueInstantiator = factoryBasedEnumDeserializer._valueInstantiator;
        this._creatorProps = factoryBasedEnumDeserializer._creatorProps;
        this._deser = abstractC0722m;
    }
}

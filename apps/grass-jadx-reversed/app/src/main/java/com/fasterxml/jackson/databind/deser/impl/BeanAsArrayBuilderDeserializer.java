package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import java.io.Closeable;
import java.io.IOException;
import java.util.Set;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p078a1.C0850b;
import p082b1.C1043n;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1757v;

/* JADX INFO: loaded from: classes.dex */
public class BeanAsArrayBuilderDeserializer extends BeanDeserializerBase {
    private static final long serialVersionUID = 1;
    protected final C1043n _buildMethod;
    protected final BeanDeserializerBase _delegate;
    protected final AbstractC1204t[] _orderedProperties;
    protected final AbstractC0721l _targetType;

    public BeanAsArrayBuilderDeserializer(BeanDeserializerBase beanDeserializerBase, AbstractC0721l abstractC0721l, AbstractC1204t[] abstractC1204tArr, C1043n c1043n) {
        super(beanDeserializerBase);
        this._delegate = beanDeserializerBase;
        this._targetType = abstractC0721l;
        this._orderedProperties = abstractC1204tArr;
        this._buildMethod = c1043n;
    }

    public Object _deserializeFromNonArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.m1826D(getValueType(abstractC0718i), abstractC0545m.mo1190e(), abstractC0545m, "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", this._beanType.f2036e.getName(), abstractC0545m.mo1190e());
        throw null;
    }

    public Object _deserializeNonVanilla(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        if (this._nonStandardCreation) {
            return deserializeFromObjectUsingNonDefault(abstractC0545m, abstractC0718i);
        }
        Object objMo3007v = this._valueInstantiator.mo3007v(abstractC0718i);
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3007v);
        }
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        AbstractC1204t[] abstractC1204tArr = this._orderedProperties;
        int length = abstractC1204tArr.length;
        int i3 = 0;
        while (true) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            EnumC0548p enumC0548p = EnumC0548p.END_ARRAY;
            if (enumC0548pMo1177V == enumC0548p) {
                return objMo3007v;
            }
            if (i3 == length) {
                if (!this._ignoreAllUnknown && abstractC0718i.m1833K(EnumC0719j.FAIL_ON_UNKNOWN_PROPERTIES)) {
                    abstractC0718i.m1844W(this, enumC0548p, "Unexpected JSON value(s); expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                    throw null;
                }
                while (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
                    abstractC0545m.mo1187c0();
                }
                return objMo3007v;
            }
            AbstractC1204t abstractC1204t = abstractC1204tArr[i3];
            i3++;
            if (abstractC1204t == null || !(cls == null || abstractC1204t.mo3027E(cls))) {
                abstractC0545m.mo1187c0();
            } else {
                try {
                    abstractC1204t.mo2968l(abstractC0545m, abstractC0718i, objMo3007v);
                } catch (Exception e3) {
                    wrapAndThrow(e3, objMo3007v, abstractC1204t.f4102g.f1928e, abstractC0718i);
                }
            }
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final Object _deserializeUsingPropertyBased(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        C1171w c1171w = this._propertyBasedCreator;
        C1143A c1143aM3014d = c1171w.m3014d(abstractC0545m, abstractC0718i, this._objectIdReader);
        AbstractC1204t[] abstractC1204tArr = this._orderedProperties;
        int length = abstractC1204tArr.length;
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        int i3 = 0;
        Object objMo2968l = null;
        while (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
            AbstractC1204t abstractC1204t = i3 < length ? abstractC1204tArr[i3] : null;
            if (abstractC1204t == null) {
                abstractC0545m.mo1187c0();
            } else if (cls == null || abstractC1204t.mo3027E(cls)) {
                C0703E c0703e = abstractC1204t.f4102g;
                if (objMo2968l != null) {
                    try {
                        objMo2968l = abstractC1204t.mo2968l(abstractC0545m, abstractC0718i, objMo2968l);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, objMo2968l, c0703e.f1928e, abstractC0718i);
                    }
                } else {
                    String str = c0703e.f1928e;
                    AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(str);
                    if (!c1143aM3014d.m2979d(str) || abstractC1204tM3013c != null) {
                        if (abstractC1204tM3013c == null) {
                            c1143aM3014d.m2978c(abstractC1204t, abstractC1204t.m3079j(abstractC0545m, abstractC0718i));
                        } else if (c1143aM3014d.m2977b(abstractC1204tM3013c, abstractC1204tM3013c.m3079j(abstractC0545m, abstractC0718i))) {
                            try {
                                objMo2968l = c1171w.m3012a(abstractC0718i, c1143aM3014d);
                                Class<?> cls2 = objMo2968l.getClass();
                                AbstractC0721l abstractC0721l = this._beanType;
                                if (cls2 != abstractC0721l.f2036e) {
                                    abstractC0718i.mo1713k("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type " + AbstractC1745j.m3895r(abstractC0721l) + ", actual type " + objMo2968l.getClass().getName());
                                    throw null;
                                }
                            } catch (Exception e4) {
                                wrapAndThrow(e4, this._beanType.f2036e, str, abstractC0718i);
                            }
                        } else {
                            continue;
                        }
                    }
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            i3++;
        }
        if (objMo2968l != null) {
            return objMo2968l;
        }
        try {
            return c1171w.m3012a(abstractC0718i, c1143aM3014d);
        } catch (Exception e5) {
            return wrapInstantiationProblem(e5, abstractC0718i);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase asArrayDeserializer() {
        return this;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        if (!abstractC0545m.mo1172Q()) {
            return finishBuild(abstractC0718i, _deserializeFromNonArray(abstractC0545m, abstractC0718i));
        }
        if (!this._vanillaProcessing) {
            return finishBuild(abstractC0718i, _deserializeNonVanilla(abstractC0545m, abstractC0718i));
        }
        Object objMo3007v = this._valueInstantiator.mo3007v(abstractC0718i);
        AbstractC1204t[] abstractC1204tArr = this._orderedProperties;
        int length = abstractC1204tArr.length;
        int i3 = 0;
        while (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
            if (i3 == length) {
                if (this._ignoreAllUnknown || !abstractC0718i.m1833K(EnumC0719j.FAIL_ON_UNKNOWN_PROPERTIES)) {
                    while (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
                        abstractC0545m.mo1187c0();
                    }
                    return finishBuild(abstractC0718i, objMo3007v);
                }
                handledType();
                throw new C0850b((Closeable) abstractC0718i.f2002k, String.format("Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length)));
            }
            AbstractC1204t abstractC1204t = abstractC1204tArr[i3];
            if (abstractC1204t != null) {
                try {
                    objMo3007v = abstractC1204t.mo2968l(abstractC0545m, abstractC0718i, objMo3007v);
                } catch (Exception e3) {
                    wrapAndThrow(e3, objMo3007v, abstractC1204t.f4102g.f1928e, abstractC0718i);
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            i3++;
        }
        return finishBuild(abstractC0718i, objMo3007v);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return _deserializeFromNonArray(abstractC0545m, abstractC0718i);
    }

    public final Object finishBuild(AbstractC0718i abstractC0718i, Object obj) {
        try {
            return this._buildMethod.f3704h.invoke(obj, null);
        } catch (Exception e3) {
            return wrapInstantiationProblem(e3, abstractC0718i);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.FALSE;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, p069X0.AbstractC0722m
    public AbstractC0722m unwrappingDeserializer(AbstractC1757v abstractC1757v) {
        return this._delegate.unwrappingDeserializer(abstractC1757v);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withBeanProperties(C1149a c1149a) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.withBeanProperties(c1149a), this._targetType, this._orderedProperties, this._buildMethod);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.withByNameInclusion(set, set2), this._targetType, this._orderedProperties, this._buildMethod);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withIgnoreAllUnknown(boolean z3) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.withIgnoreAllUnknown(z3), this._targetType, this._orderedProperties, this._buildMethod);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withObjectIdReader(C1167s c1167s) {
        return new BeanAsArrayBuilderDeserializer(this._delegate.withObjectIdReader(c1167s), this._targetType, this._orderedProperties, this._buildMethod);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        return this._delegate.deserialize(abstractC0545m, abstractC0718i, obj);
    }
}

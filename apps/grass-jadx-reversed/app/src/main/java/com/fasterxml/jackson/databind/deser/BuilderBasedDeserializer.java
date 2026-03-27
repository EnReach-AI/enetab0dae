package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayBuilderDeserializer;
import com.fasterxml.jackson.databind.deser.impl.C1143A;
import com.fasterxml.jackson.databind.deser.impl.C1149a;
import com.fasterxml.jackson.databind.deser.impl.C1153e;
import com.fasterxml.jackson.databind.deser.impl.C1167s;
import com.fasterxml.jackson.databind.deser.impl.C1171w;
import com.fasterxml.jackson.databind.deser.impl.C1173y;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import p039M0.AbstractC0473V;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p074Z0.EnumC0816b;
import p078a1.C0850b;
import p082b1.C1043n;
import p118m1.AbstractC1757v;
import p118m1.C1730E;

/* JADX INFO: loaded from: classes.dex */
public class BuilderBasedDeserializer extends BeanDeserializerBase {
    private static final long serialVersionUID = 1;
    protected final C1043n _buildMethod;
    protected final AbstractC0721l _targetType;

    @Deprecated
    public BuilderBasedDeserializer(C1137d c1137d, AbstractC0712c abstractC0712c, C1149a c1149a, Map<String, AbstractC1204t> map, Set<String> set, boolean z3, boolean z4) {
        this(c1137d, abstractC0712c, abstractC0712c.f1980a, c1149a, map, set, z3, z4);
    }

    private final Object vanillaDeserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumC0548p enumC0548p) throws IOException {
        Object objMo3007v = this._valueInstantiator.mo3007v(abstractC0718i);
        while (abstractC0545m.mo1190e() == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                try {
                    objMo3007v = abstractC1204tM2984d.mo2968l(abstractC0545m, abstractC0718i, objMo3007v);
                } catch (Exception e3) {
                    wrapAndThrow(e3, objMo3007v, strMo1188d, abstractC0718i);
                }
            } else {
                handleUnknownVanilla(abstractC0545m, abstractC0718i, objMo3007v, strMo1188d);
            }
            abstractC0545m.mo1177V();
        }
        return objMo3007v;
    }

    public final Object _deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws IOException {
        Class<?> cls;
        if (this._injectables != null) {
            injectValues(abstractC0718i, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            if (abstractC0545m.mo1168M(EnumC0548p.START_OBJECT)) {
                abstractC0545m.mo1177V();
            }
            C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
            c1730eM1847l.mo1120M();
            return deserializeWithUnwrapped(abstractC0545m, abstractC0718i, obj, c1730eM1847l);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(abstractC0545m, abstractC0718i, obj);
        }
        if (this._needViewProcesing && (cls = abstractC0718i.f2001j) != null) {
            return deserializeWithView(abstractC0545m, abstractC0718i, obj, cls);
        }
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.START_OBJECT) {
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                try {
                    obj = abstractC1204tM2984d.mo2968l(abstractC0545m, abstractC0718i, obj);
                } catch (Exception e3) {
                    wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                }
            } else {
                handleUnknownVanilla(abstractC0545m, abstractC0718i, obj, strMo1188d);
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public Object _deserializeFromArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        AbstractC0722m abstractC0722m = this._arrayDelegateDeserializer;
        if (abstractC0722m != null || (abstractC0722m = this._delegateDeserializer) != null) {
            Object objMo3069u = this._valueInstantiator.mo3069u(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
            if (this._injectables != null) {
                injectValues(abstractC0718i, objMo3069u);
            }
            return finishBuild(abstractC0718i, objMo3069u);
        }
        EnumC0816b enumC0816b_findCoercionFromEmptyArray = _findCoercionFromEmptyArray(abstractC0718i);
        boolean zM1833K = abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS);
        if (zM1833K || enumC0816b_findCoercionFromEmptyArray != EnumC0816b.f2430e) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            EnumC0548p enumC0548p = EnumC0548p.END_ARRAY;
            if (enumC0548pMo1177V == enumC0548p) {
                int iOrdinal = enumC0816b_findCoercionFromEmptyArray.ordinal();
                if (iOrdinal == 1 || iOrdinal == 2) {
                    return getNullValue(abstractC0718i);
                }
                if (iOrdinal == 3) {
                    return getEmptyValue(abstractC0718i);
                }
                abstractC0718i.m1826D(getValueType(abstractC0718i), EnumC0548p.START_ARRAY, abstractC0545m, null, new Object[0]);
                throw null;
            }
            if (zM1833K) {
                Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
                if (abstractC0545m.mo1177V() != enumC0548p) {
                    handleMissingEndArrayForSingle(abstractC0545m, abstractC0718i);
                }
                return objDeserialize;
            }
        }
        abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object _deserializeUsingPropertyBased(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        Object objWrapInstantiationProblem;
        C1171w c1171w = this._propertyBasedCreator;
        C1143A c1143aM3014d = c1171w.m3014d(abstractC0545m, abstractC0718i, this._objectIdReader);
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        C1730E c1730eM1847l = null;
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(strMo1188d);
            if (!c1143aM3014d.m2979d(strMo1188d) || abstractC1204tM3013c != null) {
                if (abstractC1204tM3013c == null) {
                    AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
                    if (abstractC1204tM2984d != null) {
                        c1143aM3014d.m2978c(abstractC1204tM2984d, abstractC1204tM2984d.m3079j(abstractC0545m, abstractC0718i));
                    } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(abstractC0545m, abstractC0718i, handledType(), strMo1188d);
                    } else {
                        AbstractC1183r abstractC1183r = this._anySetter;
                        if (abstractC1183r != null) {
                            c1143aM3014d.f3960h = new C1173y(c1143aM3014d.f3960h, abstractC1183r.mo3022b(abstractC0545m, abstractC0718i), abstractC1183r, strMo1188d);
                        } else {
                            if (c1730eM1847l == null) {
                                c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
                            }
                            c1730eM1847l.mo1145r(strMo1188d);
                            c1730eM1847l.m3862g0(abstractC0545m);
                        }
                    }
                } else if (cls != null && !abstractC1204tM3013c.mo3027E(cls)) {
                    abstractC0545m.mo1187c0();
                } else if (c1143aM3014d.m2977b(abstractC1204tM3013c, abstractC1204tM3013c.m3079j(abstractC0545m, abstractC0718i))) {
                    abstractC0545m.mo1177V();
                    try {
                        Object objM3012a = c1171w.m3012a(abstractC0718i, c1143aM3014d);
                        if (objM3012a.getClass() != this._beanType.f2036e) {
                            return handlePolymorphic(abstractC0545m, abstractC0718i, abstractC0545m.mo1189d0(), objM3012a, c1730eM1847l);
                        }
                        if (c1730eM1847l != null) {
                            objM3012a = handleUnknownProperties(abstractC0718i, objM3012a, c1730eM1847l);
                        }
                        return _deserialize(abstractC0545m, abstractC0718i, objM3012a);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, this._beanType.f2036e, strMo1188d, abstractC0718i);
                    }
                } else {
                    continue;
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        try {
            objWrapInstantiationProblem = c1171w.m3012a(abstractC0718i, c1143aM3014d);
        } catch (Exception e4) {
            objWrapInstantiationProblem = wrapInstantiationProblem(e4, abstractC0718i);
        }
        Object obj = objWrapInstantiationProblem;
        return c1730eM1847l != null ? obj.getClass() != this._beanType.f2036e ? handlePolymorphic(null, abstractC0718i, abstractC0545m.mo1189d0(), obj, c1730eM1847l) : handleUnknownProperties(abstractC0718i, obj, c1730eM1847l) : obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayBuilderDeserializer(this, this._targetType, this._beanProperties.f3973j, this._buildMethod);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1173R()) {
            return this._vanillaProcessing ? finishBuild(abstractC0718i, vanillaDeserialize(abstractC0545m, abstractC0718i, abstractC0545m.mo1177V())) : finishBuild(abstractC0718i, deserializeFromObject(abstractC0545m, abstractC0718i));
        }
        switch (abstractC0545m.mo1191f()) {
            case 2:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return finishBuild(abstractC0718i, deserializeFromObject(abstractC0545m, abstractC0718i));
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return _deserializeFromArray(abstractC0545m, abstractC0718i);
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
            default:
                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                throw null;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return finishBuild(abstractC0718i, deserializeFromString(abstractC0545m, abstractC0718i));
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return finishBuild(abstractC0718i, deserializeFromNumber(abstractC0545m, abstractC0718i));
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return finishBuild(abstractC0718i, deserializeFromDouble(abstractC0545m, abstractC0718i));
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return finishBuild(abstractC0718i, deserializeFromBoolean(abstractC0545m, abstractC0718i));
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return abstractC0545m.mo1202q();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        Class<?> cls;
        if (this._nonStandardCreation) {
            return this._unwrappedPropertyHandler != null ? deserializeWithUnwrapped(abstractC0545m, abstractC0718i) : this._externalTypeIdHandler != null ? deserializeWithExternalTypeId(abstractC0545m, abstractC0718i) : deserializeFromObjectUsingNonDefault(abstractC0545m, abstractC0718i);
        }
        Object objMo3007v = this._valueInstantiator.mo3007v(abstractC0718i);
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3007v);
        }
        if (this._needViewProcesing && (cls = abstractC0718i.f2001j) != null) {
            return deserializeWithView(abstractC0545m, abstractC0718i, objMo3007v, cls);
        }
        while (abstractC0545m.mo1190e() == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                try {
                    objMo3007v = abstractC1204tM2984d.mo2968l(abstractC0545m, abstractC0718i, objMo3007v);
                } catch (Exception e3) {
                    wrapAndThrow(e3, objMo3007v, strMo1188d, abstractC0718i);
                }
            } else {
                handleUnknownVanilla(abstractC0545m, abstractC0718i, objMo3007v, strMo1188d);
            }
            abstractC0545m.mo1177V();
        }
        return objMo3007v;
    }

    public Object deserializeUsingPropertyBasedWithExternalTypeId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        abstractC0718i.mo1713k(String.format("Deserialization (of %s) with Builder, External type id, @JsonCreator not yet implemented", this._targetType));
        throw null;
    }

    public Object deserializeUsingPropertyBasedWithUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        C1171w c1171w = this._propertyBasedCreator;
        C1143A c1143aM3014d = c1171w.m3014d(abstractC0545m, abstractC0718i, this._objectIdReader);
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        c1730eM1847l.mo1120M();
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(strMo1188d);
            if (!c1143aM3014d.m2979d(strMo1188d) || abstractC1204tM3013c != null) {
                if (abstractC1204tM3013c == null) {
                    AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
                    if (abstractC1204tM2984d != null) {
                        c1143aM3014d.m2978c(abstractC1204tM2984d, abstractC1204tM2984d.m3079j(abstractC0545m, abstractC0718i));
                    } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(abstractC0545m, abstractC0718i, handledType(), strMo1188d);
                    } else {
                        c1730eM1847l.mo1145r(strMo1188d);
                        c1730eM1847l.m3862g0(abstractC0545m);
                        AbstractC1183r abstractC1183r = this._anySetter;
                        if (abstractC1183r != null) {
                            c1143aM3014d.f3960h = new C1173y(c1143aM3014d.f3960h, abstractC1183r.mo3022b(abstractC0545m, abstractC0718i), abstractC1183r, strMo1188d);
                        }
                    }
                } else if (c1143aM3014d.m2977b(abstractC1204tM3013c, abstractC1204tM3013c.m3079j(abstractC0545m, abstractC0718i))) {
                    abstractC0545m.mo1177V();
                    try {
                        Object objM3012a = c1171w.m3012a(abstractC0718i, c1143aM3014d);
                        return objM3012a.getClass() != this._beanType.f2036e ? handlePolymorphic(abstractC0545m, abstractC0718i, abstractC0545m.mo1189d0(), objM3012a, c1730eM1847l) : deserializeWithUnwrapped(abstractC0545m, abstractC0718i, objM3012a, c1730eM1847l);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, this._beanType.f2036e, strMo1188d, abstractC0718i);
                    }
                } else {
                    continue;
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        c1730eM1847l.mo1143p();
        try {
            Object objM3012a2 = c1171w.m3012a(abstractC0718i, c1143aM3014d);
            this._unwrappedPropertyHandler.m2980a(abstractC0545m, abstractC0718i, objM3012a2, c1730eM1847l);
            return objM3012a2;
        } catch (Exception e4) {
            return wrapInstantiationProblem(e4, abstractC0718i);
        }
    }

    public Object deserializeWithExternalTypeId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return this._propertyBasedCreator != null ? deserializeUsingPropertyBasedWithExternalTypeId(abstractC0545m, abstractC0718i) : deserializeWithExternalTypeId(abstractC0545m, abstractC0718i, this._valueInstantiator.mo3007v(abstractC0718i));
    }

    public Object deserializeWithUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        if (abstractC0722m != null) {
            return this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
        }
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithUnwrapped(abstractC0545m, abstractC0718i);
        }
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        c1730eM1847l.mo1120M();
        Object objMo3007v = this._valueInstantiator.mo3007v(abstractC0718i);
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3007v);
        }
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        while (abstractC0545m.mo1190e() == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                if (cls == null || abstractC1204tM2984d.mo3027E(cls)) {
                    try {
                        objMo3007v = abstractC1204tM2984d.mo2968l(abstractC0545m, abstractC0718i, objMo3007v);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, objMo3007v, strMo1188d, abstractC0718i);
                    }
                } else {
                    abstractC0545m.mo1187c0();
                }
            } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(abstractC0545m, abstractC0718i, objMo3007v, strMo1188d);
            } else {
                c1730eM1847l.mo1145r(strMo1188d);
                c1730eM1847l.m3862g0(abstractC0545m);
                AbstractC1183r abstractC1183r = this._anySetter;
                if (abstractC1183r != null) {
                    try {
                        abstractC1183r.mo3023c(abstractC0545m, abstractC0718i, objMo3007v, strMo1188d);
                    } catch (Exception e4) {
                        wrapAndThrow(e4, objMo3007v, strMo1188d, abstractC0718i);
                    }
                }
            }
            abstractC0545m.mo1177V();
        }
        c1730eM1847l.mo1143p();
        this._unwrappedPropertyHandler.m2980a(abstractC0545m, abstractC0718i, objMo3007v, c1730eM1847l);
        return objMo3007v;
    }

    public final Object deserializeWithView(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, Class<?> cls) throws IOException {
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d == null) {
                handleUnknownVanilla(abstractC0545m, abstractC0718i, obj, strMo1188d);
            } else if (abstractC1204tM2984d.mo3027E(cls)) {
                try {
                    obj = abstractC1204tM2984d.mo2968l(abstractC0545m, abstractC0718i, obj);
                } catch (Exception e3) {
                    wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        return obj;
    }

    public Object finishBuild(AbstractC0718i abstractC0718i, Object obj) {
        C1043n c1043n = this._buildMethod;
        if (c1043n == null) {
            return obj;
        }
        try {
            return c1043n.f3704h.invoke(obj, null);
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
        return new BuilderBasedDeserializer(this, abstractC1757v);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withBeanProperties(C1149a c1149a) {
        return new BuilderBasedDeserializer(this, c1149a);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BuilderBasedDeserializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withIgnoreAllUnknown(boolean z3) {
        return new BuilderBasedDeserializer(this, z3);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withObjectIdReader(C1167s c1167s) {
        return new BuilderBasedDeserializer(this, c1167s);
    }

    public BuilderBasedDeserializer(C1137d c1137d, AbstractC0712c abstractC0712c, AbstractC0721l abstractC0721l, C1149a c1149a, Map<String, AbstractC1204t> map, Set<String> set, boolean z3, boolean z4) {
        this(c1137d, abstractC0712c, abstractC0721l, c1149a, map, set, z3, null, z4);
    }

    public BuilderBasedDeserializer(C1137d c1137d, AbstractC0712c abstractC0712c, AbstractC0721l abstractC0721l, C1149a c1149a, Map<String, AbstractC1204t> map, Set<String> set, boolean z3, Set<String> set2, boolean z4) {
        super(c1137d, abstractC0712c, c1149a, map, set, z3, set2, z4);
        this._targetType = abstractC0721l;
        this._buildMethod = c1137d.f3943m;
        if (this._objectIdReader == null) {
            return;
        }
        throw new IllegalArgumentException("Cannot use Object Id with Builder-based deserialization (type " + abstractC0712c.f1980a + ")");
    }

    public Object deserializeWithExternalTypeId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws IOException {
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        C1153e c1153e = this._externalTypeIdHandler;
        c1153e.getClass();
        C1153e c1153e2 = new C1153e(c1153e);
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                if (enumC0548pMo1177V.f1332l) {
                    c1153e2.m3003f(abstractC0545m, abstractC0718i, obj, strMo1188d);
                }
                if (cls != null && !abstractC1204tM2984d.mo3027E(cls)) {
                    abstractC0545m.mo1187c0();
                } else {
                    try {
                        obj = abstractC1204tM2984d.mo2968l(abstractC0545m, abstractC0718i, obj);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                    }
                }
            } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(abstractC0545m, abstractC0718i, obj, strMo1188d);
            } else if (!c1153e2.m3002e(abstractC0545m, abstractC0718i, obj, strMo1188d)) {
                AbstractC1183r abstractC1183r = this._anySetter;
                if (abstractC1183r != null) {
                    try {
                        abstractC1183r.mo3023c(abstractC0545m, abstractC0718i, obj, strMo1188d);
                    } catch (Exception e4) {
                        wrapAndThrow(e4, obj, strMo1188d, abstractC0718i);
                    }
                } else {
                    handleUnknownProperty(abstractC0545m, abstractC0718i, obj, strMo1188d);
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        c1153e2.m3001d(abstractC0545m, abstractC0718i, obj);
        return obj;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer) {
        this(builderBasedDeserializer, builderBasedDeserializer._ignoreAllUnknown);
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, boolean z3) {
        super(builderBasedDeserializer, z3);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b {
        AbstractC0721l abstractC0721l = this._targetType;
        Class<?> clsHandledType = handledType();
        Class<?> cls = obj.getClass();
        if (clsHandledType.isAssignableFrom(cls)) {
            abstractC0718i.mo1713k(String.format("Deserialization of %s by passing existing Builder (%s) instance not supported", abstractC0721l, clsHandledType.getName()));
            throw null;
        }
        abstractC0718i.mo1713k(String.format("Deserialization of %s by passing existing instance (of %s) not supported", abstractC0721l, cls.getName()));
        throw null;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, AbstractC1757v abstractC1757v) {
        super(builderBasedDeserializer, abstractC1757v);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, C1167s c1167s) {
        super(builderBasedDeserializer, c1167s);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, Set<String> set) {
        this(builderBasedDeserializer, set, builderBasedDeserializer._includableProps);
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, Set<String> set, Set<String> set2) {
        super(builderBasedDeserializer, set, set2);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public BuilderBasedDeserializer(BuilderBasedDeserializer builderBasedDeserializer, C1149a c1149a) {
        super(builderBasedDeserializer, c1149a);
        this._buildMethod = builderBasedDeserializer._buildMethod;
        this._targetType = builderBasedDeserializer._targetType;
    }

    public Object deserializeWithUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, C1730E c1730e) throws IOException {
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            abstractC0545m.mo1177V();
            if (abstractC1204tM2984d != null) {
                if (cls != null && !abstractC1204tM2984d.mo3027E(cls)) {
                    abstractC0545m.mo1187c0();
                } else {
                    try {
                        obj = abstractC1204tM2984d.mo2968l(abstractC0545m, abstractC0718i, obj);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                    }
                }
            } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(abstractC0545m, abstractC0718i, obj, strMo1188d);
            } else {
                c1730e.mo1145r(strMo1188d);
                c1730e.m3862g0(abstractC0545m);
                AbstractC1183r abstractC1183r = this._anySetter;
                if (abstractC1183r != null) {
                    abstractC1183r.mo3023c(abstractC0545m, abstractC0718i, obj, strMo1188d);
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        c1730e.mo1143p();
        this._unwrappedPropertyHandler.m2980a(abstractC0545m, abstractC0718i, obj, c1730e);
        return obj;
    }
}

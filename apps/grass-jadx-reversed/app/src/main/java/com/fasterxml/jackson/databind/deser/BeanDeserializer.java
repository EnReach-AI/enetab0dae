package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.BeanAsArrayDeserializer;
import com.fasterxml.jackson.databind.deser.impl.C1143A;
import com.fasterxml.jackson.databind.deser.impl.C1149a;
import com.fasterxml.jackson.databind.deser.impl.C1153e;
import com.fasterxml.jackson.databind.deser.impl.C1163o;
import com.fasterxml.jackson.databind.deser.impl.C1167s;
import com.fasterxml.jackson.databind.deser.impl.C1171w;
import com.fasterxml.jackson.databind.deser.impl.C1173y;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p039M0.AbstractC0473V;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.EnumC0719j;
import p074Z0.EnumC0816b;
import p078a1.C0850b;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1757v;
import p118m1.C1728C;
import p118m1.C1730E;

/* JADX INFO: loaded from: classes.dex */
public class BeanDeserializer extends BeanDeserializerBase implements Serializable {
    private static final long serialVersionUID = 1;
    private volatile transient AbstractC1757v _currentlyTransforming;
    protected transient Exception _nullFromCreator;

    @Deprecated
    public BeanDeserializer(C1137d c1137d, AbstractC0712c abstractC0712c, C1149a c1149a, Map<String, AbstractC1204t> map, HashSet<String> hashSet, boolean z3, boolean z4) {
        super(c1137d, abstractC0712c, c1149a, map, hashSet, z3, null, z4);
    }

    private AbstractC1136c handleUnresolvedReference(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t, C1143A c1143a, C1205u c1205u) {
        Class cls = abstractC1204t.f4103h.f2036e;
        c1205u.getClass();
        throw null;
    }

    private final Object vanillaDeserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumC0548p enumC0548p) throws IOException {
        Object objMo3007v = this._valueInstantiator.mo3007v(abstractC0718i);
        abstractC0545m.mo1183a0(objMo3007v);
        if (abstractC0545m.mo1169N()) {
            String strMo1188d = abstractC0545m.mo1188d();
            do {
                abstractC0545m.mo1177V();
                AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
                if (abstractC1204tM2984d != null) {
                    try {
                        abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, objMo3007v);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, objMo3007v, strMo1188d, abstractC0718i);
                    }
                } else {
                    handleUnknownVanilla(abstractC0545m, abstractC0718i, objMo3007v, strMo1188d);
                }
                strMo1188d = abstractC0545m.mo1175T();
            } while (strMo1188d != null);
        }
        return objMo3007v;
    }

    public Exception _creatorReturnedNullException() {
        if (this._nullFromCreator == null) {
            this._nullFromCreator = new NullPointerException("JSON Creator returned null");
        }
        return this._nullFromCreator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public Object _deserializeFromArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        AbstractC0722m abstractC0722m = this._arrayDelegateDeserializer;
        if (abstractC0722m != null || (abstractC0722m = this._delegateDeserializer) != null) {
            Object objMo3069u = this._valueInstantiator.mo3069u(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
            if (this._injectables != null) {
                injectValues(abstractC0718i, objMo3069u);
            }
            return objMo3069u;
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
                EnumC0548p enumC0548p2 = EnumC0548p.START_ARRAY;
                if (enumC0548pMo1177V == enumC0548p2) {
                    AbstractC0721l valueType = getValueType(abstractC0718i);
                    abstractC0718i.m1826D(valueType, enumC0548p2, abstractC0545m, "Cannot deserialize value of type %s from deeply-nested Array: only single wrapper allowed with `%s`", AbstractC1745j.m3895r(valueType), "DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS");
                    throw null;
                }
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

    public final Object _deserializeOther(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, EnumC0548p enumC0548p) throws C0850b {
        if (enumC0548p != null) {
            switch (enumC0548p.ordinal()) {
                case 2:
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    return this._vanillaProcessing ? vanillaDeserialize(abstractC0545m, abstractC0718i, enumC0548p) : this._objectIdReader != null ? deserializeWithObjectId(abstractC0545m, abstractC0718i) : deserializeFromObject(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    return _deserializeFromArray(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    return deserializeFromEmbedded(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    return deserializeFromString(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    return deserializeFromNumber(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    return deserializeFromDouble(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    return deserializeFromBoolean(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                    return deserializeFromNull(abstractC0545m, abstractC0718i);
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
        Object objM3012a = null;
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        ArrayList arrayList = null;
        C1730E c1730eM1847l = null;
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(strMo1188d);
            if (!c1143aM3014d.m2979d(strMo1188d) || abstractC1204tM3013c != null) {
                if (abstractC1204tM3013c == null) {
                    AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
                    if (abstractC1204tM2984d != null && (!AbstractC1745j.m3901x(this._beanType.f2036e) || (abstractC1204tM2984d instanceof C1163o))) {
                        try {
                            c1143aM3014d.m2978c(abstractC1204tM2984d, _deserializeWithErrorWrapping(abstractC0545m, abstractC0718i, abstractC1204tM2984d));
                        } catch (C1205u e3) {
                            AbstractC1136c abstractC1136cHandleUnresolvedReference = handleUnresolvedReference(abstractC0718i, abstractC1204tM2984d, c1143aM3014d, e3);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(abstractC1136cHandleUnresolvedReference);
                        }
                    } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(abstractC0545m, abstractC0718i, handledType(), strMo1188d);
                    } else {
                        AbstractC1183r abstractC1183r = this._anySetter;
                        if (abstractC1183r != null) {
                            try {
                                c1143aM3014d.f3960h = new C1173y(c1143aM3014d.f3960h, abstractC1183r.mo3022b(abstractC0545m, abstractC0718i), abstractC1183r, strMo1188d);
                            } catch (Exception e4) {
                                wrapAndThrow(e4, this._beanType.f2036e, strMo1188d, abstractC0718i);
                            }
                        } else if (this._ignoreAllUnknown) {
                            abstractC0545m.mo1187c0();
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
                } else if (c1143aM3014d.m2977b(abstractC1204tM3013c, _deserializeWithErrorWrapping(abstractC0545m, abstractC0718i, abstractC1204tM3013c))) {
                    abstractC0545m.mo1177V();
                    try {
                        objWrapInstantiationProblem = c1171w.m3012a(abstractC0718i, c1143aM3014d);
                    } catch (Exception e5) {
                        objWrapInstantiationProblem = wrapInstantiationProblem(e5, abstractC0718i);
                    }
                    Object objHandleUnknownProperties = objWrapInstantiationProblem;
                    if (objHandleUnknownProperties == null) {
                        abstractC0718i.m1859x(handledType(), _creatorReturnedNullException());
                        throw null;
                    }
                    abstractC0545m.mo1183a0(objHandleUnknownProperties);
                    if (objHandleUnknownProperties.getClass() != this._beanType.f2036e) {
                        return handlePolymorphic(abstractC0545m, abstractC0718i, abstractC0545m.mo1189d0(), objHandleUnknownProperties, c1730eM1847l);
                    }
                    if (c1730eM1847l != null) {
                        objHandleUnknownProperties = handleUnknownProperties(abstractC0718i, objHandleUnknownProperties, c1730eM1847l);
                    }
                    return deserialize(abstractC0545m, abstractC0718i, objHandleUnknownProperties);
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        try {
            objM3012a = c1171w.m3012a(abstractC0718i, c1143aM3014d);
        } catch (Exception e6) {
            wrapInstantiationProblem(e6, abstractC0718i);
        }
        Object obj = objM3012a;
        if (this._injectables != null) {
            injectValues(abstractC0718i, obj);
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((AbstractC1136c) it.next()).f3930c = obj;
            }
        }
        return c1730eM1847l != null ? obj.getClass() != this._beanType.f2036e ? handlePolymorphic(null, abstractC0718i, abstractC0545m.mo1189d0(), obj, c1730eM1847l) : handleUnknownProperties(abstractC0718i, obj, c1730eM1847l) : obj;
    }

    public final Object _deserializeWithErrorWrapping(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t) throws IOException {
        try {
            return abstractC1204t.m3079j(abstractC0545m, abstractC0718i);
        } catch (Exception e3) {
            wrapAndThrow(e3, this._beanType.f2036e, abstractC1204t.f4102g.f1928e, abstractC0718i);
            return null;
        }
    }

    public Object _deserializeWithExternalTypeId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, C1153e c1153e) throws IOException {
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                if (enumC0548pMo1177V.f1332l) {
                    c1153e.m3003f(abstractC0545m, abstractC0718i, obj, strMo1188d);
                }
                if (cls == null || abstractC1204tM2984d.mo3027E(cls)) {
                    try {
                        abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, obj);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                    }
                } else {
                    abstractC0545m.mo1187c0();
                }
            } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(abstractC0545m, abstractC0718i, obj, strMo1188d);
            } else if (!c1153e.m3002e(abstractC0545m, abstractC0718i, obj, strMo1188d)) {
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
        c1153e.m3001d(abstractC0545m, abstractC0718i, obj);
        return obj;
    }

    @Deprecated
    public Object _missingToken(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        Class<?> clsHandledType = handledType();
        abstractC0718i.getClass();
        throw new C0850b((Closeable) abstractC0718i.f2002k, "Unexpected end-of-input when trying to deserialize a ".concat(clsHandledType.getName()));
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase asArrayDeserializer() {
        return new BeanAsArrayDeserializer(this, this._beanProperties.f3973j);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        if (!abstractC0545m.mo1173R()) {
            return _deserializeOther(abstractC0545m, abstractC0718i, abstractC0545m.mo1190e());
        }
        if (this._vanillaProcessing) {
            return vanillaDeserialize(abstractC0545m, abstractC0718i, abstractC0545m.mo1177V());
        }
        abstractC0545m.mo1177V();
        return this._objectIdReader != null ? deserializeWithObjectId(abstractC0545m, abstractC0718i) : deserializeFromObject(abstractC0545m, abstractC0718i);
    }

    public Object deserializeFromNull(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (!abstractC0545m.mo1181Z()) {
            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
            throw null;
        }
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        c1730eM1847l.mo1143p();
        C1728C c1728cM3860e0 = c1730eM1847l.m3860e0(abstractC0545m);
        c1728cM3860e0.mo1177V();
        Object objVanillaDeserialize = this._vanillaProcessing ? vanillaDeserialize(c1728cM3860e0, abstractC0718i, EnumC0548p.END_OBJECT) : deserializeFromObject(c1728cM3860e0, abstractC0718i);
        c1728cM3860e0.close();
        return objVanillaDeserialize;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        Class<?> cls;
        Object objMo1209x;
        C1167s c1167s = this._objectIdReader;
        if (c1167s != null) {
            c1167s.f4025g.getClass();
        }
        if (this._nonStandardCreation) {
            return this._unwrappedPropertyHandler != null ? deserializeWithUnwrapped(abstractC0545m, abstractC0718i) : this._externalTypeIdHandler != null ? deserializeWithExternalTypeId(abstractC0545m, abstractC0718i) : deserializeFromObjectUsingNonDefault(abstractC0545m, abstractC0718i);
        }
        Object objMo3007v = this._valueInstantiator.mo3007v(abstractC0718i);
        abstractC0545m.mo1183a0(objMo3007v);
        if (abstractC0545m.mo1182a() && (objMo1209x = abstractC0545m.mo1209x()) != null) {
            _handleTypedObjectId(abstractC0545m, abstractC0718i, objMo3007v, objMo1209x);
        }
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3007v);
        }
        if (this._needViewProcesing && (cls = abstractC0718i.f2001j) != null) {
            return deserializeWithView(abstractC0545m, abstractC0718i, objMo3007v, cls);
        }
        if (abstractC0545m.mo1169N()) {
            String strMo1188d = abstractC0545m.mo1188d();
            do {
                abstractC0545m.mo1177V();
                AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
                if (abstractC1204tM2984d != null) {
                    try {
                        abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, objMo3007v);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, objMo3007v, strMo1188d, abstractC0718i);
                    }
                } else {
                    handleUnknownVanilla(abstractC0545m, abstractC0718i, objMo3007v, strMo1188d);
                }
                strMo1188d = abstractC0545m.mo1175T();
            } while (strMo1188d != null);
        }
        return objMo3007v;
    }

    public Object deserializeUsingPropertyBasedWithExternalTypeId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        C1153e c1153e = this._externalTypeIdHandler;
        c1153e.getClass();
        C1153e c1153e2 = new C1153e(c1153e);
        C1171w c1171w = this._propertyBasedCreator;
        C1143A c1143aM3014d = c1171w.m3014d(abstractC0545m, abstractC0718i, this._objectIdReader);
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(strMo1188d);
            if (!c1143aM3014d.m2979d(strMo1188d) || abstractC1204tM3013c != null) {
                if (abstractC1204tM3013c == null) {
                    AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
                    if (abstractC1204tM2984d != null) {
                        if (enumC0548pMo1177V.f1332l) {
                            c1153e2.m3003f(abstractC0545m, abstractC0718i, null, strMo1188d);
                        }
                        if (cls == null || abstractC1204tM2984d.mo3027E(cls)) {
                            c1143aM3014d.m2978c(abstractC1204tM2984d, abstractC1204tM2984d.m3079j(abstractC0545m, abstractC0718i));
                        } else {
                            abstractC0545m.mo1187c0();
                        }
                    } else if (!c1153e2.m3002e(abstractC0545m, abstractC0718i, null, strMo1188d)) {
                        if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                            handleIgnoredProperty(abstractC0545m, abstractC0718i, handledType(), strMo1188d);
                        } else {
                            AbstractC1183r abstractC1183r = this._anySetter;
                            if (abstractC1183r != null) {
                                c1143aM3014d.f3960h = new C1173y(c1143aM3014d.f3960h, abstractC1183r.mo3022b(abstractC0545m, abstractC0718i), abstractC1183r, strMo1188d);
                            } else {
                                handleUnknownProperty(abstractC0545m, abstractC0718i, this._valueClass, strMo1188d);
                            }
                        }
                    }
                } else if (!c1153e2.m3002e(abstractC0545m, abstractC0718i, null, strMo1188d) && c1143aM3014d.m2977b(abstractC1204tM3013c, _deserializeWithErrorWrapping(abstractC0545m, abstractC0718i, abstractC1204tM3013c))) {
                    abstractC0545m.mo1177V();
                    try {
                        Object objM3012a = c1171w.m3012a(abstractC0718i, c1143aM3014d);
                        Class<?> cls2 = objM3012a.getClass();
                        AbstractC0721l abstractC0721l = this._beanType;
                        if (cls2 == abstractC0721l.f2036e) {
                            return _deserializeWithExternalTypeId(abstractC0545m, abstractC0718i, objM3012a, c1153e2);
                        }
                        abstractC0718i.mo1713k(String.format("Cannot create polymorphic instances with external type ids (%s -> %s)", abstractC0721l, objM3012a.getClass()));
                        throw null;
                    } catch (Exception e3) {
                        wrapAndThrow(e3, this._beanType.f2036e, strMo1188d, abstractC0718i);
                    }
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        try {
            return c1153e2.m3000c(abstractC0545m, abstractC0718i, c1143aM3014d, c1171w);
        } catch (Exception e4) {
            return wrapInstantiationProblem(e4, abstractC0718i);
        }
    }

    public Object deserializeUsingPropertyBasedWithUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        Object objWrapInstantiationProblem;
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
                        c1143aM3014d.m2978c(abstractC1204tM2984d, _deserializeWithErrorWrapping(abstractC0545m, abstractC0718i, abstractC1204tM2984d));
                    } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                        handleIgnoredProperty(abstractC0545m, abstractC0718i, handledType(), strMo1188d);
                    } else if (this._anySetter == null) {
                        c1730eM1847l.mo1145r(strMo1188d);
                        c1730eM1847l.m3862g0(abstractC0545m);
                    } else {
                        C1730E c1730eM1847l2 = abstractC0718i.m1847l(abstractC0545m);
                        c1730eM1847l2.m3862g0(abstractC0545m);
                        c1730eM1847l.mo1145r(strMo1188d);
                        c1730eM1847l.m3859d0(c1730eM1847l2);
                        try {
                            AbstractC1183r abstractC1183r = this._anySetter;
                            C1728C c1728cM3861f0 = c1730eM1847l2.m3861f0(c1730eM1847l2.f6056f);
                            c1728cM3861f0.mo1177V();
                            c1143aM3014d.f3960h = new C1173y(c1143aM3014d.f3960h, abstractC1183r.mo3022b(c1728cM3861f0, abstractC0718i), abstractC1183r, strMo1188d);
                        } catch (Exception e3) {
                            wrapAndThrow(e3, this._beanType.f2036e, strMo1188d, abstractC0718i);
                        }
                    }
                } else if (c1143aM3014d.m2977b(abstractC1204tM3013c, _deserializeWithErrorWrapping(abstractC0545m, abstractC0718i, abstractC1204tM3013c))) {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    try {
                        objWrapInstantiationProblem = c1171w.m3012a(abstractC0718i, c1143aM3014d);
                    } catch (Exception e4) {
                        objWrapInstantiationProblem = wrapInstantiationProblem(e4, abstractC0718i);
                    }
                    abstractC0545m.mo1183a0(objWrapInstantiationProblem);
                    while (enumC0548pMo1177V == EnumC0548p.FIELD_NAME) {
                        c1730eM1847l.m3862g0(abstractC0545m);
                        enumC0548pMo1177V = abstractC0545m.mo1177V();
                    }
                    EnumC0548p enumC0548p = EnumC0548p.END_OBJECT;
                    if (enumC0548pMo1177V != enumC0548p) {
                        abstractC0718i.m1844W(this, enumC0548p, "Attempted to unwrap '%s' value", handledType().getName());
                        throw null;
                    }
                    c1730eM1847l.mo1143p();
                    if (objWrapInstantiationProblem.getClass() == this._beanType.f2036e) {
                        this._unwrappedPropertyHandler.m2980a(abstractC0545m, abstractC0718i, objWrapInstantiationProblem, c1730eM1847l);
                        return objWrapInstantiationProblem;
                    }
                    abstractC0718i.m1840R(abstractC1204tM3013c, "Cannot create polymorphic instances with unwrapped values", new Object[0]);
                    throw null;
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        try {
            Object objM3012a = c1171w.m3012a(abstractC0718i, c1143aM3014d);
            this._unwrappedPropertyHandler.m2980a(abstractC0545m, abstractC0718i, objM3012a, c1730eM1847l);
            return objM3012a;
        } catch (Exception e5) {
            wrapInstantiationProblem(e5, abstractC0718i);
            return null;
        }
    }

    public Object deserializeWithExternalTypeId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        if (this._propertyBasedCreator != null) {
            return deserializeUsingPropertyBasedWithExternalTypeId(abstractC0545m, abstractC0718i);
        }
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        return abstractC0722m != null ? this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i)) : deserializeWithExternalTypeId(abstractC0545m, abstractC0718i, this._valueInstantiator.mo3007v(abstractC0718i));
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
        abstractC0545m.mo1183a0(objMo3007v);
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3007v);
        }
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        String strMo1188d = abstractC0545m.mo1169N() ? abstractC0545m.mo1188d() : null;
        while (strMo1188d != null) {
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                if (cls == null || abstractC1204tM2984d.mo3027E(cls)) {
                    try {
                        abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, objMo3007v);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, objMo3007v, strMo1188d, abstractC0718i);
                    }
                } else {
                    abstractC0545m.mo1187c0();
                }
            } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(abstractC0545m, abstractC0718i, objMo3007v, strMo1188d);
            } else if (this._anySetter == null) {
                c1730eM1847l.mo1145r(strMo1188d);
                c1730eM1847l.m3862g0(abstractC0545m);
            } else {
                C1730E c1730eM1847l2 = abstractC0718i.m1847l(abstractC0545m);
                c1730eM1847l2.m3862g0(abstractC0545m);
                c1730eM1847l.mo1145r(strMo1188d);
                c1730eM1847l.m3859d0(c1730eM1847l2);
                try {
                    AbstractC1183r abstractC1183r = this._anySetter;
                    C1728C c1728cM3861f0 = c1730eM1847l2.m3861f0(c1730eM1847l2.f6056f);
                    c1728cM3861f0.mo1177V();
                    abstractC1183r.mo3023c(c1728cM3861f0, abstractC0718i, objMo3007v, strMo1188d);
                } catch (Exception e4) {
                    wrapAndThrow(e4, objMo3007v, strMo1188d, abstractC0718i);
                }
            }
            strMo1188d = abstractC0545m.mo1175T();
        }
        c1730eM1847l.mo1143p();
        this._unwrappedPropertyHandler.m2980a(abstractC0545m, abstractC0718i, objMo3007v, c1730eM1847l);
        return objMo3007v;
    }

    public final Object deserializeWithView(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, Class<?> cls) throws IOException {
        if (abstractC0545m.mo1169N()) {
            String strMo1188d = abstractC0545m.mo1188d();
            do {
                abstractC0545m.mo1177V();
                AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
                if (abstractC1204tM2984d == null) {
                    handleUnknownVanilla(abstractC0545m, abstractC0718i, obj, strMo1188d);
                } else if (abstractC1204tM2984d.mo3027E(cls)) {
                    try {
                        abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, obj);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                    }
                } else {
                    abstractC0545m.mo1187c0();
                }
                strMo1188d = abstractC0545m.mo1175T();
            } while (strMo1188d != null);
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, p069X0.AbstractC0722m
    public AbstractC0722m unwrappingDeserializer(AbstractC1757v abstractC1757v) {
        if (getClass() != BeanDeserializer.class || this._currentlyTransforming == abstractC1757v) {
            return this;
        }
        this._currentlyTransforming = abstractC1757v;
        try {
            return new BeanDeserializer(this, abstractC1757v);
        } finally {
            this._currentlyTransforming = null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withBeanProperties(C1149a c1149a) {
        return new BeanDeserializer(this, c1149a);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public /* bridge */ /* synthetic */ BeanDeserializerBase withByNameInclusion(Set set, Set set2) {
        return withByNameInclusion((Set<String>) set, (Set<String>) set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializerBase withIgnoreAllUnknown(boolean z3) {
        return new BeanDeserializer(this, z3);
    }

    public BeanDeserializer(C1137d c1137d, AbstractC0712c abstractC0712c, C1149a c1149a, Map<String, AbstractC1204t> map, HashSet<String> hashSet, boolean z3, Set<String> set, boolean z4) {
        super(c1137d, abstractC0712c, c1149a, map, hashSet, z3, set, z4);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializer withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BeanDeserializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public BeanDeserializer withObjectIdReader(C1167s c1167s) {
        return new BeanDeserializer(this, c1167s);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase) {
        super(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, boolean z3) {
        super(beanDeserializerBase, z3);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, AbstractC1757v abstractC1757v) {
        super(beanDeserializerBase, abstractC1757v);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, C1167s c1167s) {
        super(beanDeserializerBase, c1167s);
    }

    @Deprecated
    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, Set<String> set) {
        super(beanDeserializerBase, set);
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, Set<String> set, Set<String> set2) {
        super(beanDeserializerBase, set, set2);
    }

    public Object deserializeWithExternalTypeId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        C1153e c1153e = this._externalTypeIdHandler;
        c1153e.getClass();
        return _deserializeWithExternalTypeId(abstractC0545m, abstractC0718i, obj, new C1153e(c1153e));
    }

    public BeanDeserializer(BeanDeserializerBase beanDeserializerBase, C1149a c1149a) {
        super(beanDeserializerBase, c1149a);
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws IOException {
        String strMo1188d;
        Class<?> cls;
        abstractC0545m.mo1183a0(obj);
        if (this._injectables != null) {
            injectValues(abstractC0718i, obj);
        }
        if (this._unwrappedPropertyHandler != null) {
            return deserializeWithUnwrapped(abstractC0545m, abstractC0718i, obj);
        }
        if (this._externalTypeIdHandler != null) {
            return deserializeWithExternalTypeId(abstractC0545m, abstractC0718i, obj);
        }
        if (abstractC0545m.mo1173R()) {
            strMo1188d = abstractC0545m.mo1175T();
            if (strMo1188d == null) {
                return obj;
            }
        } else {
            if (abstractC0545m.mo1169N()) {
                strMo1188d = abstractC0545m.mo1188d();
            }
            return obj;
        }
        if (this._needViewProcesing && (cls = abstractC0718i.f2001j) != null) {
            return deserializeWithView(abstractC0545m, abstractC0718i, obj, cls);
        }
        do {
            abstractC0545m.mo1177V();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            if (abstractC1204tM2984d != null) {
                try {
                    abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, obj);
                } catch (Exception e3) {
                    wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                }
            } else {
                handleUnknownVanilla(abstractC0545m, abstractC0718i, obj, strMo1188d);
            }
            strMo1188d = abstractC0545m.mo1175T();
        } while (strMo1188d != null);
        return obj;
    }

    public Object deserializeWithUnwrapped(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws IOException {
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.START_OBJECT) {
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        c1730eM1847l.mo1120M();
        Class cls = this._needViewProcesing ? abstractC0718i.f2001j : null;
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            abstractC0545m.mo1177V();
            if (abstractC1204tM2984d != null) {
                if (cls != null && !abstractC1204tM2984d.mo3027E(cls)) {
                    abstractC0545m.mo1187c0();
                } else {
                    try {
                        abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, obj);
                    } catch (Exception e3) {
                        wrapAndThrow(e3, obj, strMo1188d, abstractC0718i);
                    }
                }
            } else if (AbstractC0473V.m999L(strMo1188d, this._ignorableProps, this._includableProps)) {
                handleIgnoredProperty(abstractC0545m, abstractC0718i, obj, strMo1188d);
            } else if (this._anySetter == null) {
                c1730eM1847l.mo1145r(strMo1188d);
                c1730eM1847l.m3862g0(abstractC0545m);
            } else {
                C1730E c1730eM1847l2 = abstractC0718i.m1847l(abstractC0545m);
                c1730eM1847l2.m3862g0(abstractC0545m);
                c1730eM1847l.mo1145r(strMo1188d);
                c1730eM1847l.m3859d0(c1730eM1847l2);
                try {
                    AbstractC1183r abstractC1183r = this._anySetter;
                    C1728C c1728cM3861f0 = c1730eM1847l2.m3861f0(c1730eM1847l2.f6056f);
                    c1728cM3861f0.mo1177V();
                    abstractC1183r.mo3023c(c1728cM3861f0, abstractC0718i, obj, strMo1188d);
                } catch (Exception e4) {
                    wrapAndThrow(e4, obj, strMo1188d, abstractC0718i);
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        c1730eM1847l.mo1143p();
        this._unwrappedPropertyHandler.m2980a(abstractC0545m, abstractC0718i, obj, c1730eM1847l);
        return obj;
    }
}

package com.fasterxml.jackson.databind.deser;

import com.facebook.C1100C;
import com.fasterxml.jackson.databind.deser.impl.C1146D;
import com.fasterxml.jackson.databind.deser.impl.C1147E;
import com.fasterxml.jackson.databind.deser.impl.C1148F;
import com.fasterxml.jackson.databind.deser.impl.C1149a;
import com.fasterxml.jackson.databind.deser.impl.C1152d;
import com.fasterxml.jackson.databind.deser.impl.C1153e;
import com.fasterxml.jackson.databind.deser.impl.C1155g;
import com.fasterxml.jackson.databind.deser.impl.C1160l;
import com.fasterxml.jackson.databind.deser.impl.C1161m;
import com.fasterxml.jackson.databind.deser.impl.C1162n;
import com.fasterxml.jackson.databind.deser.impl.C1167s;
import com.fasterxml.jackson.databind.deser.impl.C1168t;
import com.fasterxml.jackson.databind.deser.impl.C1169u;
import com.fasterxml.jackson.databind.deser.impl.C1171w;
import com.fasterxml.jackson.databind.deser.impl.C1172x;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p015D2.C0181e;
import p039M0.AbstractC0473V;
import p039M0.AbstractC0485d0;
import p039M0.AbstractC0489f0;
import p039M0.C0502q;
import p039M0.C0508w;
import p039M0.EnumC0471T;
import p039M0.EnumC0499n;
import p039M0.EnumC0501p;
import p042N0.AbstractC0535c;
import p042N0.AbstractC0545m;
import p042N0.C0553u;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0713d;
import p069X0.C0717h;
import p069X0.C0723n;
import p069X0.C0724o;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p078a1.C0849a;
import p078a1.C0850b;
import p078a1.C0851c;
import p078a1.C0855g;
import p082b1.AbstractC1041l;
import p082b1.AbstractC1048s;
import p082b1.C1005A;
import p082b1.C1018N;
import p082b1.C1033d;
import p100g1.AbstractC1398g;
import p103h1.AbstractC1428p;
import p103h1.C1426n;
import p114l1.C1660b;
import p114l1.C1675q;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1757v;
import p118m1.C1728C;
import p118m1.C1730E;
import p118m1.EnumC1736a;
import p118m1.InterfaceC1748m;

/* JADX INFO: loaded from: classes.dex */
public abstract class BeanDeserializerBase extends StdDeserializer<Object> implements InterfaceC1139f, InterfaceC1179n, Serializable {
    protected static final C0703E TEMP_PROPERTY_NAME = new C0703E("#temporary-name", null);
    private static final long serialVersionUID = 1;
    protected AbstractC1183r _anySetter;
    protected AbstractC0722m _arrayDelegateDeserializer;
    protected final Map<String, AbstractC1204t> _backRefs;
    protected final C1149a _beanProperties;
    protected final AbstractC0721l _beanType;
    protected AbstractC0722m _delegateDeserializer;
    protected C1153e _externalTypeIdHandler;
    protected final Set<String> _ignorableProps;
    protected final boolean _ignoreAllUnknown;
    protected final Set<String> _includableProps;
    protected final C1148F[] _injectables;
    protected final boolean _needViewProcesing;
    protected boolean _nonStandardCreation;
    protected final C1167s _objectIdReader;
    protected C1171w _propertyBasedCreator;
    protected final EnumC0501p _serializationShape;
    protected transient HashMap<C1660b, AbstractC0722m> _subDeserializers;
    protected C1147E _unwrappedPropertyHandler;
    protected final AbstractC1208x _valueInstantiator;
    protected boolean _vanillaProcessing;

    public BeanDeserializerBase(C1137d c1137d, AbstractC0712c abstractC0712c, C1149a c1149a, Map<String, AbstractC1204t> map, Set<String> set, boolean z3, Set<String> set2, boolean z4) {
        super(abstractC0712c.f1980a);
        this._beanType = abstractC0712c.f1980a;
        AbstractC1208x abstractC1208x = c1137d.f3939i;
        this._valueInstantiator = abstractC1208x;
        C1148F[] c1148fArr = null;
        this._delegateDeserializer = null;
        this._arrayDelegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._beanProperties = c1149a;
        this._backRefs = map;
        this._ignorableProps = set;
        this._ignoreAllUnknown = z3;
        this._includableProps = set2;
        this._anySetter = c1137d.f3941k;
        ArrayList arrayList = c1137d.f3935e;
        if (arrayList != null && !arrayList.isEmpty()) {
            c1148fArr = (C1148F[]) arrayList.toArray(new C1148F[arrayList.size()]);
        }
        this._injectables = c1148fArr;
        C1167s c1167s = c1137d.f3940j;
        this._objectIdReader = c1167s;
        this._nonStandardCreation = this._unwrappedPropertyHandler != null || abstractC1208x.mo3061k() || abstractC1208x.mo3058g() || !abstractC1208x.mo3005j();
        this._serializationShape = abstractC0712c.mo1800b().f1170f;
        this._needViewProcesing = z4;
        this._vanillaProcessing = !this._nonStandardCreation && c1148fArr == null && !z4 && c1167s == null;
    }

    private AbstractC0722m _findDelegateDeserializer(AbstractC0718i abstractC0718i, AbstractC0721l abstractC0721l, AbstractC1048s abstractC1048s) {
        ArrayList arrayListMo3397b;
        C0713d c0713d = new C0713d(TEMP_PROPERTY_NAME, abstractC0721l, null, abstractC1048s, C0702D.f1917m);
        AbstractC1398g abstractC1398gM3436a = (AbstractC1398g) abstractC0721l.f2039h;
        if (abstractC1398gM3436a == null) {
            C0717h c0717h = abstractC0718i.f1998g;
            c0717h.getClass();
            C1005A c1005aM2156k = c0717h.m2156k(abstractC0721l.f2036e);
            AbstractC0711b abstractC0711bM2149d = c0717h.m2149d();
            C1033d c1033d = c1005aM2156k.f3582e;
            C1426n c1426nMo1754Z = abstractC0711bM2149d.mo1754Z(abstractC0721l, c0717h, c1033d);
            if (c1426nMo1754Z == null) {
                c1426nMo1754Z = c0717h.f2481f.f2424j;
                arrayListMo3397b = null;
                if (c1426nMo1754Z == null) {
                    abstractC1398gM3436a = null;
                }
            } else {
                arrayListMo3397b = c0717h.f2485h.mo3397b(c0717h, c1033d);
            }
            abstractC1398gM3436a = c1426nMo1754Z.m3436a(c0717h, abstractC0721l, arrayListMo3397b);
        }
        AbstractC0722m abstractC0722m = (AbstractC0722m) abstractC0721l.f2038g;
        AbstractC0722m abstractC0722mFindDeserializer = abstractC0722m == null ? findDeserializer(abstractC0718i, abstractC0721l, c0713d) : abstractC0718i.m1823A(abstractC0722m, c0713d, abstractC0721l);
        return abstractC1398gM3436a != null ? new TypeWrappedDeserializer(abstractC1398gM3436a.mo3404f(c0713d), abstractC0722mFindDeserializer) : abstractC0722mFindDeserializer;
    }

    private Throwable throwOrReturnThrowable(Throwable th, AbstractC0718i abstractC0718i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        AbstractC1745j.m3873C(th);
        boolean z3 = abstractC0718i == null || abstractC0718i.m1833K(EnumC0719j.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z3 || !(th instanceof AbstractC0535c)) {
                throw ((IOException) th);
            }
        } else if (!z3) {
            AbstractC1745j.m3875E(th);
        }
        return th;
    }

    public Object _convertObjectId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, AbstractC0722m abstractC0722m) {
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        if (obj instanceof String) {
            c1730eM1847l.mo1125R((String) obj);
        } else if (obj instanceof Long) {
            Long l3 = (Long) obj;
            l3.getClass();
            c1730eM1847l.m3855Z(EnumC0548p.VALUE_NUMBER_INT, l3);
        } else if (obj instanceof Integer) {
            Integer num = (Integer) obj;
            num.getClass();
            c1730eM1847l.m3855Z(EnumC0548p.VALUE_NUMBER_INT, num);
        } else {
            c1730eM1847l.mo1109B(obj);
        }
        C0553u c0553uMo1189d0 = abstractC0545m.mo1189d0();
        C1728C c1728c = new C1728C(c1730eM1847l.f6063m, c1730eM1847l.f6056f, c1730eM1847l.f6060j, c1730eM1847l.f6061k, c1730eM1847l.f6057g, c0553uMo1189d0);
        c1728c.mo1177V();
        return abstractC0722m.deserialize(c1728c, abstractC0718i);
    }

    public final AbstractC0722m _delegateDeserializer() {
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        return abstractC0722m == null ? this._arrayDelegateDeserializer : abstractC0722m;
    }

    public abstract Object _deserializeUsingPropertyBased(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    public AbstractC1757v _findPropertyUnwrapper(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t) throws C0850b {
        AbstractC1757v abstractC1757vMo1756a0;
        AbstractC1041l abstractC1041lMo1805c = abstractC1204t.mo1805c();
        if (abstractC1041lMo1805c == null || (abstractC1757vMo1756a0 = abstractC0718i.f1998g.m2149d().mo1756a0(abstractC1041lMo1805c)) == null) {
            return null;
        }
        if (!(abstractC1204t instanceof C1140g)) {
            return abstractC1757vMo1756a0;
        }
        getValueType();
        abstractC0718i.mo1713k("Cannot define Creator property \"" + abstractC1204t.f4102g.f1928e + "\" as `@JsonUnwrapped`: combination not yet supported");
        throw null;
    }

    public AbstractC0722m _findSubclassDeserializer(AbstractC0718i abstractC0718i, Object obj, C1730E c1730e) {
        AbstractC0722m abstractC0722m;
        synchronized (this) {
            HashMap<C1660b, AbstractC0722m> map = this._subDeserializers;
            abstractC0722m = map == null ? null : map.get(new C1660b(obj.getClass()));
        }
        if (abstractC0722m != null) {
            return abstractC0722m;
        }
        AbstractC0722m abstractC0722mM1856u = abstractC0718i.m1856u(abstractC0718i.m1848m(obj.getClass()));
        if (abstractC0722mM1856u != null) {
            synchronized (this) {
                try {
                    if (this._subDeserializers == null) {
                        this._subDeserializers = new HashMap<>();
                    }
                    this._subDeserializers.put(new C1660b(obj.getClass()), abstractC0722mM1856u);
                } finally {
                }
            }
        }
        return abstractC0722mM1856u;
    }

    public BeanDeserializerBase _handleByNameInclusion(AbstractC0718i abstractC0718i, AbstractC0711b abstractC0711b, BeanDeserializerBase beanDeserializerBase, AbstractC1041l abstractC1041l) {
        C0717h c0717h = abstractC0718i.f1998g;
        C0508w c0508wMo1737I = abstractC0711b.mo1737I(abstractC1041l);
        if (c0508wMo1737I.f1178f && !this._ignoreAllUnknown) {
            beanDeserializerBase = beanDeserializerBase.withIgnoreAllUnknown(true);
        }
        Set<String> setEmptySet = c0508wMo1737I.f1180h ? Collections.emptySet() : c0508wMo1737I.f1177e;
        Set<String> set = beanDeserializerBase._ignorableProps;
        if (setEmptySet.isEmpty()) {
            setEmptySet = set;
        } else if (set != null && !set.isEmpty()) {
            HashSet hashSet = new HashSet(set);
            hashSet.addAll(setEmptySet);
            setEmptySet = hashSet;
        }
        Set<String> set2 = beanDeserializerBase._includableProps;
        Set<String> set3 = abstractC0711b.mo1740L(abstractC1041l).f1101e;
        if (set2 != null) {
            if (set3 == null) {
                set3 = set2;
            } else {
                HashSet hashSet2 = new HashSet();
                for (String str : set3) {
                    if (set2.contains(str)) {
                        hashSet2.add(str);
                    }
                }
                set3 = hashSet2;
            }
        }
        return (setEmptySet == set && set3 == set2) ? beanDeserializerBase : beanDeserializerBase.withByNameInclusion(setEmptySet, set3);
    }

    public Object _handleTypedObjectId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, Object obj2) {
        AbstractC0722m abstractC0722m = this._objectIdReader.f4026h;
        if (abstractC0722m.handledType() != obj2.getClass()) {
            obj2 = _convertObjectId(abstractC0545m, abstractC0718i, obj2, abstractC0722m);
        }
        abstractC0718i.mo1855t(obj2, this._objectIdReader.f4025g).getClass();
        throw null;
    }

    public void _replaceProperty(C1149a c1149a, AbstractC1204t[] abstractC1204tArr, AbstractC1204t abstractC1204t, AbstractC1204t abstractC1204t2) {
        c1149a.m2988h(abstractC1204t, abstractC1204t2);
        if (abstractC1204tArr != null) {
            int length = abstractC1204tArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (abstractC1204tArr[i3] == abstractC1204t) {
                    abstractC1204tArr[i3] = abstractC1204t2;
                    return;
                }
            }
        }
    }

    public AbstractC1204t _resolveInnerClassValuedProperty(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t) {
        Class cls;
        Class clsM3893p;
        AbstractC0722m abstractC0722mMo3032t = abstractC1204t.mo3032t();
        if ((abstractC0722mMo3032t instanceof BeanDeserializerBase) && !((BeanDeserializerBase) abstractC0722mMo3032t).getValueInstantiator().mo3005j() && (clsM3893p = AbstractC1745j.m3893p((cls = abstractC1204t.f4103h.f2036e))) != null && clsM3893p == this._beanType.f2036e) {
            for (Constructor<?> constructor : cls.getConstructors()) {
                if (constructor.getParameterCount() == 1 && clsM3893p.equals(constructor.getParameterTypes()[0])) {
                    C0717h c0717h = abstractC0718i.f1998g;
                    c0717h.getClass();
                    if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                        AbstractC1745j.m3882e(constructor, abstractC0718i.f1998g.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                    }
                    return new C1155g(abstractC1204t, constructor);
                }
            }
        }
        return abstractC1204t;
    }

    public AbstractC1204t _resolveManagedReferenceProperty(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t) throws C0850b {
        String strMo3029q = abstractC1204t.mo3029q();
        if (strMo3029q == null) {
            return abstractC1204t;
        }
        AbstractC1204t abstractC1204tFindBackReference = abstractC1204t.mo3032t().findBackReference(strMo3029q);
        AbstractC0721l abstractC0721l = abstractC1204t.f4103h;
        if (abstractC1204tFindBackReference == null) {
            abstractC0718i.mo1713k("Cannot handle managed/back reference " + AbstractC1745j.m3880c(strMo3029q) + ": no back reference property found from type " + AbstractC1745j.m3895r(abstractC0721l));
            throw null;
        }
        AbstractC0721l abstractC0721l2 = this._beanType;
        boolean zMo1887v = abstractC0721l.mo1887v();
        AbstractC0721l abstractC0721l3 = abstractC1204tFindBackReference.f4103h;
        if (abstractC0721l3.f2036e.isAssignableFrom(abstractC0721l2.f2036e)) {
            return new C1161m(abstractC1204t, strMo3029q, abstractC1204tFindBackReference, zMo1887v);
        }
        abstractC0718i.mo1713k("Cannot handle managed/back reference " + AbstractC1745j.m3880c(strMo3029q) + ": back reference type (" + AbstractC1745j.m3895r(abstractC0721l3) + ") not compatible with managed type (" + abstractC0721l2.f2036e.getName() + ")");
        throw null;
    }

    public AbstractC1204t _resolveMergeAndNullSettings(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t, C0702D c0702d) throws C0850b {
        C0181e c0181e = c0702d.f1923i;
        if (c0181e != null) {
            AbstractC0722m abstractC0722mMo3032t = abstractC1204t.mo3032t();
            Boolean boolSupportsUpdate = abstractC0722mMo3032t.supportsUpdate(abstractC0718i.f1998g);
            boolean z3 = c0181e.f422b;
            if (boolSupportsUpdate == null) {
                if (z3) {
                    return abstractC1204t;
                }
            } else if (!boolSupportsUpdate.booleanValue()) {
                if (!z3) {
                    abstractC0718i.m1858w(abstractC0722mMo3032t);
                }
                return abstractC1204t;
            }
            boolean zM2157l = abstractC0718i.f1998g.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
            AbstractC1041l abstractC1041l = (AbstractC1041l) c0181e.f423c;
            abstractC1041l.m2799h(zM2157l);
            if (!(abstractC1204t instanceof C1146D)) {
                abstractC1204t = new C1162n(abstractC1204t, abstractC1041l);
            }
        }
        InterfaceC1178m interfaceC1178mFindValueNullProvider = findValueNullProvider(abstractC0718i, abstractC1204t, c0702d);
        return interfaceC1178mFindValueNullProvider != null ? abstractC1204t.mo2964G(interfaceC1178mFindValueNullProvider) : abstractC1204t;
    }

    public AbstractC1204t _resolvedObjectIdProperty(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t) {
        C1018N c1018nMo3030r = abstractC1204t.mo3030r();
        AbstractC0722m abstractC0722mMo3032t = abstractC1204t.mo3032t();
        return (c1018nMo3030r == null && (abstractC0722mMo3032t == null ? null : abstractC0722mMo3032t.getObjectIdReader()) == null) ? abstractC1204t : new C1168t(abstractC1204t, c1018nMo3030r);
    }

    public abstract BeanDeserializerBase asArrayDeserializer();

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) throws C0850b {
        C1018N c1018nMo1798z;
        AbstractC0721l abstractC0721l;
        AbstractC1204t abstractC1204t;
        AbstractC0485d0 abstractC0485d0M1813h;
        C1167s c1167s = this._objectIdReader;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        AbstractC1041l abstractC1041lMo1805c = StdDeserializer._neitherNull(interfaceC0714e, abstractC0711bM2149d) ? interfaceC0714e.mo1805c() : null;
        if (abstractC1041lMo1805c != null && (c1018nMo1798z = abstractC0711bM2149d.mo1798z(abstractC1041lMo1805c)) != null) {
            C1018N c1018nMo1729A = abstractC0711bM2149d.mo1729A(abstractC1041lMo1805c, c1018nMo1798z);
            Class cls = c1018nMo1729A.f3611b;
            abstractC0718i.m1814i(c1018nMo1729A);
            if (cls == AbstractC0489f0.class) {
                C0703E c0703e = c1018nMo1729A.f3610a;
                AbstractC1204t abstractC1204tFindProperty = findProperty(c0703e);
                if (abstractC1204tFindProperty == null) {
                    abstractC0718i.mo1713k("Invalid Object Id definition for " + AbstractC1745j.m3903z(handledType()) + ": cannot find property with name " + (c0703e == null ? "[null]" : AbstractC1745j.m3880c(c0703e.f1928e)));
                    throw null;
                }
                C1172x c1172x = new C1172x(c1018nMo1729A.f3613d);
                abstractC0721l = abstractC1204tFindProperty.f4103h;
                abstractC0485d0M1813h = c1172x;
                abstractC1204t = abstractC1204tFindProperty;
            } else {
                AbstractC0721l abstractC0721lM1848m = abstractC0718i.m1848m(cls);
                abstractC0718i.mo1711f().getClass();
                abstractC0721l = C1675q.m3771l(abstractC0721lM1848m, AbstractC0485d0.class)[0];
                abstractC1204t = null;
                abstractC0485d0M1813h = abstractC0718i.m1813h(c1018nMo1729A);
            }
            AbstractC0721l abstractC0721l2 = abstractC0721l;
            c1167s = new C1167s(abstractC0721l2, c1018nMo1729A.f3610a, abstractC0485d0M1813h, abstractC0718i.m1856u(abstractC0721l2), abstractC1204t);
        }
        BeanDeserializerBase beanDeserializerBaseWithObjectIdReader = (c1167s == null || c1167s == this._objectIdReader) ? this : withObjectIdReader(c1167s);
        if (abstractC1041lMo1805c != null) {
            beanDeserializerBaseWithObjectIdReader = _handleByNameInclusion(abstractC0718i, abstractC0711bM2149d, beanDeserializerBaseWithObjectIdReader, abstractC1041lMo1805c);
        }
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0718i, interfaceC0714e, handledType());
        if (c0502qFindFormatOverrides != null) {
            EnumC0501p enumC0501p = EnumC0501p.f1157e;
            EnumC0501p enumC0501p2 = c0502qFindFormatOverrides.f1170f;
            enumC0501p = enumC0501p2 != enumC0501p ? enumC0501p2 : null;
            Boolean boolM1015b = c0502qFindFormatOverrides.m1015b(EnumC0499n.f1148f);
            if (boolM1015b != null) {
                C1149a c1149a = this._beanProperties;
                boolean zBooleanValue = boolM1015b.booleanValue();
                C1149a c1149a2 = c1149a.f3968e == zBooleanValue ? c1149a : new C1149a(c1149a, zBooleanValue);
                if (c1149a2 != c1149a) {
                    beanDeserializerBaseWithObjectIdReader = beanDeserializerBaseWithObjectIdReader.withBeanProperties(c1149a2);
                }
            }
        }
        if (enumC0501p == null) {
            enumC0501p = this._serializationShape;
        }
        return enumC0501p == EnumC0501p.f1160h ? beanDeserializerBaseWithObjectIdReader.asArrayDeserializer() : beanDeserializerBaseWithObjectIdReader;
    }

    public Iterator<AbstractC1204t> creatorProperties() {
        C1171w c1171w = this._propertyBasedCreator;
        return c1171w == null ? Collections.emptyList().iterator() : c1171w.f4033c.values().iterator();
    }

    @Deprecated
    public Object deserializeFromArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return _deserializeFromArray(abstractC0545m, abstractC0718i);
    }

    public Object deserializeFromBoolean(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        AbstractC0722m abstractC0722m_delegateDeserializer = _delegateDeserializer();
        if (abstractC0722m_delegateDeserializer == null || this._valueInstantiator.mo3054c()) {
            return this._valueInstantiator.mo3064o(abstractC0718i, abstractC0545m.mo1190e() == EnumC0548p.VALUE_TRUE);
        }
        Object objMo3071x = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer.deserialize(abstractC0545m, abstractC0718i));
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3071x);
        }
        return objMo3071x;
    }

    public Object deserializeFromDouble(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        EnumC0544l enumC0544lMo1206u = abstractC0545m.mo1206u();
        if (enumC0544lMo1206u == EnumC0544l.f1302i || enumC0544lMo1206u == EnumC0544l.f1301h) {
            AbstractC0722m abstractC0722m_delegateDeserializer = _delegateDeserializer();
            if (abstractC0722m_delegateDeserializer == null || this._valueInstantiator.mo3055d()) {
                return this._valueInstantiator.mo3065p(abstractC0718i, abstractC0545m.mo1201p());
            }
            Object objMo3071x = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer.deserialize(abstractC0545m, abstractC0718i));
            if (this._injectables != null) {
                injectValues(abstractC0718i, objMo3071x);
            }
            return objMo3071x;
        }
        if (enumC0544lMo1206u != EnumC0544l.f1303j) {
            abstractC0718i.m1860y(handledType(), getValueInstantiator(), "no suitable creator method found to deserialize from Number value (%s)", abstractC0545m.mo1207v());
            throw null;
        }
        AbstractC0722m abstractC0722m_delegateDeserializer2 = _delegateDeserializer();
        if (abstractC0722m_delegateDeserializer2 == null || this._valueInstantiator.mo3052a()) {
            return this._valueInstantiator.mo3062m(abstractC0718i, abstractC0545m.mo1200o());
        }
        Object objMo3071x2 = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer2.deserialize(abstractC0545m, abstractC0718i));
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3071x2);
        }
        return objMo3071x2;
    }

    public Object deserializeFromEmbedded(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(abstractC0545m, abstractC0718i);
        }
        AbstractC0722m abstractC0722m_delegateDeserializer = _delegateDeserializer();
        if (abstractC0722m_delegateDeserializer != null && !this._valueInstantiator.mo3059h()) {
            Object objMo3071x = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer.deserialize(abstractC0545m, abstractC0718i));
            if (this._injectables != null) {
                injectValues(abstractC0718i, objMo3071x);
            }
            return objMo3071x;
        }
        Object objMo1202q = abstractC0545m.mo1202q();
        if (objMo1202q == null || this._beanType.m1862A(objMo1202q.getClass())) {
            return objMo1202q;
        }
        AbstractC0721l abstractC0721l = this._beanType;
        C0009j c0009j = abstractC0718i.f1998g.f1987q;
        Class cls = abstractC0721l.f2036e;
        if (c0009j != null) {
            AbstractC0032g.m162t(c0009j.f30f);
            throw null;
        }
        throw new C0851c(abstractC0718i.f2002k, AbstractC0032g.m156n("Cannot deserialize value of type ", AbstractC1745j.m3903z(cls), " from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type ", AbstractC1745j.m3883f(objMo1202q), ": incompatible types"), objMo1202q);
    }

    public Object deserializeFromNumber(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(abstractC0545m, abstractC0718i);
        }
        AbstractC0722m abstractC0722m_delegateDeserializer = _delegateDeserializer();
        EnumC0544l enumC0544lMo1206u = abstractC0545m.mo1206u();
        if (enumC0544lMo1206u == EnumC0544l.f1298e) {
            if (abstractC0722m_delegateDeserializer == null || this._valueInstantiator.mo3056e()) {
                return this._valueInstantiator.mo3066q(abstractC0718i, abstractC0545m.mo1204s());
            }
            Object objMo3071x = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer.deserialize(abstractC0545m, abstractC0718i));
            if (this._injectables != null) {
                injectValues(abstractC0718i, objMo3071x);
            }
            return objMo3071x;
        }
        if (enumC0544lMo1206u == EnumC0544l.f1299f) {
            if (abstractC0722m_delegateDeserializer == null || this._valueInstantiator.mo3056e()) {
                return this._valueInstantiator.mo3067r(abstractC0718i, abstractC0545m.mo1205t());
            }
            Object objMo3071x2 = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer.deserialize(abstractC0545m, abstractC0718i));
            if (this._injectables != null) {
                injectValues(abstractC0718i, objMo3071x2);
            }
            return objMo3071x2;
        }
        if (enumC0544lMo1206u != EnumC0544l.f1300g) {
            abstractC0718i.m1860y(handledType(), getValueInstantiator(), "no suitable creator method found to deserialize from Number value (%s)", abstractC0545m.mo1207v());
            throw null;
        }
        if (abstractC0722m_delegateDeserializer == null || this._valueInstantiator.mo3053b()) {
            return this._valueInstantiator.mo3063n(abstractC0718i, abstractC0545m.mo1192g());
        }
        Object objMo3071x3 = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer.deserialize(abstractC0545m, abstractC0718i));
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3071x3);
        }
        return objMo3071x3;
    }

    public abstract Object deserializeFromObject(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i);

    public Object deserializeFromObjectId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        abstractC0718i.mo1855t(this._objectIdReader.f4026h.deserialize(abstractC0545m, abstractC0718i), this._objectIdReader.f4025g).getClass();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object deserializeFromObjectUsingNonDefault(p042N0.AbstractC0545m r5, p069X0.AbstractC0718i r6) throws p078a1.C0850b {
        /*
            r4 = this;
            X0.m r0 = r4._delegateDeserializer()
            if (r0 == 0) goto L18
            com.fasterxml.jackson.databind.deser.x r1 = r4._valueInstantiator
            java.lang.Object r5 = r0.deserialize(r5, r6)
            java.lang.Object r5 = r1.mo3071x(r6, r5)
            com.fasterxml.jackson.databind.deser.impl.F[] r0 = r4._injectables
            if (r0 == 0) goto L17
            r4.injectValues(r6, r5)
        L17:
            return r5
        L18:
            com.fasterxml.jackson.databind.deser.impl.w r0 = r4._propertyBasedCreator
            if (r0 == 0) goto L21
            java.lang.Object r5 = r4._deserializeUsingPropertyBased(r5, r6)
            return r5
        L21:
            X0.l r5 = r4._beanType
            java.lang.Class r5 = r5.f2036e
            java.lang.annotation.Annotation[] r0 = p118m1.AbstractC1745j.f6110a
            int r0 = r5.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            r1 = 0
            r2 = 0
            if (r0 != 0) goto L43
            boolean r0 = p118m1.AbstractC1745j.m3900w(r5)
            if (r0 == 0) goto L3b
            r0 = r2
            goto L3f
        L3b:
            java.lang.Class r0 = r5.getEnclosingClass()
        L3f:
            if (r0 == 0) goto L43
            r0 = 1
            goto L44
        L43:
            r0 = r1
        L44:
            if (r0 != 0) goto L60
            boolean r0 = p118m1.AbstractC1759x.m3912a(r5)
            if (r0 == 0) goto L54
            java.lang.String r0 = "cannot deserialize from Object value (no delegate- or property-based Creator): this appears to be a native image, in which case you may need to configure reflection for the class that is to be deserialized"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r6.m1860y(r5, r2, r0, r1)
            throw r2
        L54:
            com.fasterxml.jackson.databind.deser.x r0 = r4.getValueInstantiator()
            java.lang.String r3 = "cannot deserialize from Object value (no delegate- or property-based Creator)"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r6.m1860y(r5, r0, r3, r1)
            throw r2
        L60:
            java.lang.String r0 = "non-static inner classes like this can only by instantiated using default, no-argument constructor"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r6.m1860y(r5, r2, r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(N0.m, X0.i):java.lang.Object");
    }

    public Object deserializeFromString(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (this._objectIdReader != null) {
            return deserializeFromObjectId(abstractC0545m, abstractC0718i);
        }
        AbstractC0722m abstractC0722m_delegateDeserializer = _delegateDeserializer();
        if (abstractC0722m_delegateDeserializer == null || this._valueInstantiator.mo3059h()) {
            return _deserializeFromString(abstractC0545m, abstractC0718i);
        }
        Object objMo3071x = this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m_delegateDeserializer.deserialize(abstractC0545m, abstractC0718i));
        if (this._injectables != null) {
            injectValues(abstractC0718i, objMo3071x);
        }
        return objMo3071x;
    }

    public Object deserializeWithObjectId(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        return deserializeFromObject(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        Object objMo1209x;
        if (this._objectIdReader != null) {
            if (abstractC0545m.mo1182a() && (objMo1209x = abstractC0545m.mo1209x()) != null) {
                return _handleTypedObjectId(abstractC0545m, abstractC0718i, abstractC1398g.mo3402d(abstractC0545m, abstractC0718i), objMo1209x);
            }
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e != null) {
                if (enumC0548pMo1190e.f1332l) {
                    return deserializeFromObjectId(abstractC0545m, abstractC0718i);
                }
                if (enumC0548pMo1190e == EnumC0548p.START_OBJECT) {
                    enumC0548pMo1190e = abstractC0545m.mo1177V();
                }
                if (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
                    this._objectIdReader.f4025g.getClass();
                }
            }
        }
        return abstractC1398g.mo3402d(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC1204t findBackReference(String str) {
        Map<String, AbstractC1204t> map = this._backRefs;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public AbstractC0722m findConvertingDeserializer(AbstractC0718i abstractC0718i, AbstractC1204t abstractC1204t) {
        Object objMo1771i;
        AbstractC0711b abstractC0711bM2149d = abstractC0718i.f1998g.m2149d();
        if (abstractC0711bM2149d == null || (objMo1771i = abstractC0711bM2149d.mo1771i(abstractC1204t.mo1805c())) == null) {
            return null;
        }
        abstractC1204t.mo1805c();
        InterfaceC1748m interfaceC1748mM1812d = abstractC0718i.m1812d(objMo1771i);
        abstractC0718i.mo1711f();
        AbstractC0721l abstractC0721l = ((C1160l) interfaceC1748mM1812d).f4009a;
        return new StdDelegatingDeserializer(interfaceC1748mM1812d, abstractC0721l, abstractC0718i.f1996e.m3020f(abstractC0718i, abstractC0718i.f1997f, abstractC0721l));
    }

    public AbstractC1204t findProperty(C0703E c0703e) {
        return findProperty(c0703e.f1928e);
    }

    @Deprecated
    public final Class<?> getBeanClass() {
        return this._beanType.f2036e;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getEmptyAccessPattern() {
        return EnumC1736a.f6083g;
    }

    @Override // p069X0.AbstractC0722m
    public Object getEmptyValue(AbstractC0718i abstractC0718i) throws C0724o {
        try {
            return this._valueInstantiator.mo3070w(abstractC0718i);
        } catch (IOException e3) {
            AbstractC1745j.m3872B(abstractC0718i, e3);
            throw null;
        }
    }

    @Override // p069X0.AbstractC0722m
    public Collection<Object> getKnownPropertyNames() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this._beanProperties.iterator();
        while (it.hasNext()) {
            arrayList.add(((AbstractC1204t) it.next()).f4102g.f1928e);
        }
        return arrayList;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1736a getNullAccessPattern() {
        return EnumC1736a.f6081e;
    }

    @Override // p069X0.AbstractC0722m
    public C1167s getObjectIdReader() {
        return this._objectIdReader;
    }

    public int getPropertyCount() {
        return this._beanProperties.f3970g;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC1208x getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC0721l getValueType() {
        return this._beanType;
    }

    public void handleIgnoredProperty(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, String str) throws C0849a {
        if (!abstractC0718i.m1833K(EnumC0719j.FAIL_ON_IGNORED_PROPERTIES)) {
            abstractC0545m.mo1187c0();
            return;
        }
        Collection<Object> knownPropertyNames = getKnownPropertyNames();
        int i3 = C0849a.f2521k;
        C0849a c0849a = new C0849a(abstractC0545m, AbstractC0032g.m156n("Ignored field \"", str, "\" (class ", (obj instanceof Class ? (Class) obj : obj.getClass()).getName(), ") encountered; mapper configured not to allow this"), abstractC0545m.mo1197l(), knownPropertyNames);
        c0849a.mo1816d(str, obj);
        throw c0849a;
    }

    @Deprecated
    public Object handlePolymorphic(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, C1730E c1730e) {
        return handlePolymorphic(abstractC0545m, abstractC0718i, abstractC0545m == null ? C0553u.f1339e : abstractC0545m.mo1189d0(), obj, c1730e);
    }

    public Object handleUnknownProperties(AbstractC0718i abstractC0718i, Object obj, C1730E c1730e) throws C0855g, C0849a {
        c1730e.mo1143p();
        C1728C c1728cM3861f0 = c1730e.m3861f0(c1730e.f6056f);
        while (c1728cM3861f0.mo1177V() != EnumC0548p.END_OBJECT) {
            String strMo1188d = c1728cM3861f0.mo1188d();
            c1728cM3861f0.mo1177V();
            handleUnknownProperty(c1728cM3861f0, abstractC0718i, obj, strMo1188d);
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public void handleUnknownProperty(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, String str) throws C0855g, C0849a {
        if (this._ignoreAllUnknown) {
            abstractC0545m.mo1187c0();
            return;
        }
        if (AbstractC0473V.m999L(str, this._ignorableProps, this._includableProps)) {
            handleIgnoredProperty(abstractC0545m, abstractC0718i, obj, str);
        }
        super.handleUnknownProperty(abstractC0545m, abstractC0718i, obj, str);
    }

    public void handleUnknownVanilla(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj, String str) throws IOException {
        if (AbstractC0473V.m999L(str, this._ignorableProps, this._includableProps)) {
            handleIgnoredProperty(abstractC0545m, abstractC0718i, obj, str);
            return;
        }
        AbstractC1183r abstractC1183r = this._anySetter;
        if (abstractC1183r == null) {
            handleUnknownProperty(abstractC0545m, abstractC0718i, obj, str);
            return;
        }
        try {
            abstractC1183r.mo3023c(abstractC0545m, abstractC0718i, obj, str);
        } catch (Exception e3) {
            wrapAndThrow(e3, obj, str, abstractC0718i);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Class<?> handledType() {
        return this._beanType.f2036e;
    }

    public boolean hasProperty(String str) {
        return this._beanProperties.m2984d(str) != null;
    }

    public boolean hasViews() {
        return this._needViewProcesing;
    }

    public void injectValues(AbstractC0718i abstractC0718i, Object obj) {
        C1148F[] c1148fArr = this._injectables;
        if (c1148fArr.length <= 0) {
            return;
        }
        abstractC0718i.m1853r(c1148fArr[0].f3967i);
        throw null;
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return true;
    }

    public boolean isCaseInsensitive() {
        return this._beanProperties.f3968e;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5892h;
    }

    public Iterator<AbstractC1204t> properties() {
        C1149a c1149a = this._beanProperties;
        if (c1149a != null) {
            return c1149a.iterator();
        }
        throw new IllegalStateException("Can only call after BeanDeserializer has been resolved");
    }

    public void replaceProperty(AbstractC1204t abstractC1204t, AbstractC1204t abstractC1204t2) {
        this._beanProperties.m2988h(abstractC1204t, abstractC1204t2);
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1179n
    public void resolve(AbstractC0718i abstractC0718i) throws C0850b {
        AbstractC1204t[] abstractC1204tArrMo3039D;
        AbstractC0722m abstractC0722mMo3032t;
        AbstractC0722m abstractC0722mUnwrappingDeserializer;
        boolean z3 = false;
        if (this._valueInstantiator.mo3058g()) {
            abstractC1204tArrMo3039D = this._valueInstantiator.mo3039D(abstractC0718i.f1998g);
            if (this._ignorableProps != null || this._includableProps != null) {
                int length = abstractC1204tArrMo3039D.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (AbstractC0473V.m999L(abstractC1204tArrMo3039D[i3].f4102g.f1928e, this._ignorableProps, this._includableProps)) {
                        abstractC1204tArrMo3039D[i3].mo2960A();
                    }
                }
            }
        } else {
            abstractC1204tArrMo3039D = null;
        }
        for (AbstractC1204t abstractC1204t : this._beanProperties) {
            if (!abstractC1204t.mo3034v()) {
                AbstractC0722m abstractC0722mFindConvertingDeserializer = findConvertingDeserializer(abstractC0718i, abstractC1204t);
                if (abstractC0722mFindConvertingDeserializer == null) {
                    abstractC0722mFindConvertingDeserializer = abstractC0718i.f1996e.m3020f(abstractC0718i, abstractC0718i.f1997f, abstractC1204t.f4103h);
                }
                _replaceProperty(this._beanProperties, abstractC1204tArrMo3039D, abstractC1204t, abstractC1204t.mo2965H(abstractC0722mFindConvertingDeserializer));
            }
        }
        C1100C c1100c = null;
        C1147E c1147e = null;
        for (AbstractC1204t abstractC1204t2 : this._beanProperties) {
            AbstractC1204t abstractC1204t_resolveManagedReferenceProperty = _resolveManagedReferenceProperty(abstractC0718i, abstractC1204t2.mo2965H(abstractC0718i.m1861z(abstractC1204t2.mo3032t(), abstractC1204t2, abstractC1204t2.f4103h)));
            if (!(abstractC1204t_resolveManagedReferenceProperty instanceof C1161m)) {
                abstractC1204t_resolveManagedReferenceProperty = _resolvedObjectIdProperty(abstractC0718i, abstractC1204t_resolveManagedReferenceProperty);
            }
            AbstractC1757v abstractC1757v_findPropertyUnwrapper = _findPropertyUnwrapper(abstractC0718i, abstractC1204t_resolveManagedReferenceProperty);
            if (abstractC1757v_findPropertyUnwrapper == null || (abstractC0722mUnwrappingDeserializer = (abstractC0722mMo3032t = abstractC1204t_resolveManagedReferenceProperty.mo3032t()).unwrappingDeserializer(abstractC1757v_findPropertyUnwrapper)) == abstractC0722mMo3032t || abstractC0722mUnwrappingDeserializer == null) {
                AbstractC1204t abstractC1204t_resolveInnerClassValuedProperty = _resolveInnerClassValuedProperty(abstractC0718i, _resolveMergeAndNullSettings(abstractC0718i, abstractC1204t_resolveManagedReferenceProperty, abstractC1204t_resolveManagedReferenceProperty.mo1804b()));
                if (abstractC1204t_resolveInnerClassValuedProperty != abstractC1204t2) {
                    _replaceProperty(this._beanProperties, abstractC1204tArrMo3039D, abstractC1204t2, abstractC1204t_resolveInnerClassValuedProperty);
                }
                if (abstractC1204t_resolveInnerClassValuedProperty.mo3035w()) {
                    AbstractC1398g abstractC1398gMo3033u = abstractC1204t_resolveInnerClassValuedProperty.mo3033u();
                    if (abstractC1398gMo3033u.mo3405g() == EnumC0471T.f1110h) {
                        if (c1100c == null) {
                            c1100c = new C1100C(this._beanType);
                        }
                        ArrayList arrayList = (ArrayList) c1100c.f3800g;
                        Integer numValueOf = Integer.valueOf(arrayList.size());
                        arrayList.add(new C1152d(abstractC1204t_resolveInnerClassValuedProperty, abstractC1398gMo3033u));
                        c1100c.m2847c(abstractC1204t_resolveInnerClassValuedProperty.f4102g.f1928e, numValueOf);
                        c1100c.m2847c(((AbstractC1428p) abstractC1398gMo3033u).f5064i, numValueOf);
                        this._beanProperties.m2987g(abstractC1204t_resolveInnerClassValuedProperty);
                    }
                }
            } else {
                AbstractC1204t abstractC1204tMo2965H = abstractC1204t_resolveManagedReferenceProperty.mo2965H(abstractC0722mUnwrappingDeserializer);
                if (c1147e == null) {
                    c1147e = new C1147E();
                }
                c1147e.f3966a.add(abstractC1204tMo2965H);
                this._beanProperties.m2987g(abstractC1204tMo2965H);
            }
        }
        AbstractC1183r abstractC1183r = this._anySetter;
        if (abstractC1183r != null && abstractC1183r.f4046h == null) {
            this._anySetter = abstractC1183r.mo3024e(findDeserializer(abstractC0718i, abstractC1183r.f4045g, abstractC1183r.f4043e));
        }
        if (this._valueInstantiator.mo3061k()) {
            AbstractC1208x abstractC1208x = this._valueInstantiator;
            C0717h c0717h = abstractC0718i.f1998g;
            AbstractC0721l abstractC0721lMo3048C = abstractC1208x.mo3048C();
            if (abstractC0721lMo3048C == null) {
                abstractC0718i.mo1713k(AbstractC0032g.m156n("Invalid delegate-creator definition for ", AbstractC1745j.m3895r(this._beanType), ": value instantiator (", AbstractC1745j.m3883f(this._valueInstantiator), ") returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'"));
                throw null;
            }
            this._delegateDeserializer = _findDelegateDeserializer(abstractC0718i, abstractC0721lMo3048C, this._valueInstantiator.mo3047B());
        }
        if (this._valueInstantiator.mo3060i()) {
            AbstractC1208x abstractC1208x2 = this._valueInstantiator;
            C0717h c0717h2 = abstractC0718i.f1998g;
            AbstractC0721l abstractC0721lMo3073z = abstractC1208x2.mo3073z();
            if (abstractC0721lMo3073z == null) {
                abstractC0718i.mo1713k(AbstractC0032g.m156n("Invalid delegate-creator definition for ", AbstractC1745j.m3895r(this._beanType), ": value instantiator (", AbstractC1745j.m3883f(this._valueInstantiator), ") returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'"));
                throw null;
            }
            this._arrayDelegateDeserializer = _findDelegateDeserializer(abstractC0718i, abstractC0721lMo3073z, this._valueInstantiator.mo3072y());
        }
        if (abstractC1204tArrMo3039D != null) {
            AbstractC1208x abstractC1208x3 = this._valueInstantiator;
            C1149a c1149a = this._beanProperties;
            int length2 = abstractC1204tArrMo3039D.length;
            AbstractC1204t[] abstractC1204tArr = new AbstractC1204t[length2];
            for (int i4 = 0; i4 < length2; i4++) {
                AbstractC1204t abstractC1204tMo2965H2 = abstractC1204tArrMo3039D[i4];
                if (!abstractC1204tMo2965H2.mo3034v() && !abstractC1204tMo2965H2.mo2973z()) {
                    abstractC1204tMo2965H2 = abstractC1204tMo2965H2.mo2965H(abstractC0718i.m1852q(abstractC1204tMo2965H2.f4103h, abstractC1204tMo2965H2));
                }
                abstractC1204tArr[i4] = abstractC1204tMo2965H2;
            }
            this._propertyBasedCreator = new C1171w(abstractC0718i, abstractC1208x3, abstractC1204tArr, c1149a.f3968e, true);
        }
        if (c1100c != null) {
            C1149a c1149a2 = this._beanProperties;
            ArrayList arrayList2 = (ArrayList) c1100c.f3800g;
            int size = arrayList2.size();
            C1152d[] c1152dArr = new C1152d[size];
            for (int i5 = 0; i5 < size; i5++) {
                C1152d c1152d = (C1152d) arrayList2.get(i5);
                AbstractC1204t abstractC1204tM2984d = c1149a2.m2984d(c1152d.f3993c);
                if (abstractC1204tM2984d != null) {
                    c1152d.f3994d = abstractC1204tM2984d;
                }
                c1152dArr[i5] = c1152d;
            }
            this._externalTypeIdHandler = new C1153e((AbstractC0721l) c1100c.f3799f, c1152dArr, (HashMap) c1100c.f3801h);
            this._nonStandardCreation = true;
        }
        this._unwrappedPropertyHandler = c1147e;
        if (c1147e != null) {
            this._nonStandardCreation = true;
        }
        if (this._vanillaProcessing && !this._nonStandardCreation) {
            z3 = true;
        }
        this._vanillaProcessing = z3;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return Boolean.TRUE;
    }

    @Override // p069X0.AbstractC0722m
    public abstract AbstractC0722m unwrappingDeserializer(AbstractC1757v abstractC1757v);

    public BeanDeserializerBase withBeanProperties(C1149a c1149a) {
        throw new UnsupportedOperationException("Class " + getClass().getName() + " does not override `withBeanProperties()`, needs to");
    }

    public abstract BeanDeserializerBase withByNameInclusion(Set<String> set, Set<String> set2);

    @Deprecated
    public BeanDeserializerBase withIgnorableProperties(Set<String> set) {
        return withByNameInclusion(set, this._includableProps);
    }

    public abstract BeanDeserializerBase withIgnoreAllUnknown(boolean z3);

    public abstract BeanDeserializerBase withObjectIdReader(C1167s c1167s);

    public void wrapAndThrow(Throwable th, Object obj, String str, AbstractC0718i abstractC0718i) throws IOException {
        Throwable thThrowOrReturnThrowable = throwOrReturnThrowable(th, abstractC0718i);
        int i3 = C0724o.f2045h;
        throw C0724o.m1894g(thThrowOrReturnThrowable, new C0723n(str, obj));
    }

    public Object wrapInstantiationProblem(Throwable th, AbstractC0718i abstractC0718i) throws IOException {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        AbstractC1745j.m3873C(th);
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        if (abstractC0718i == null) {
            throw new IllegalArgumentException(th.getMessage(), th);
        }
        if (!abstractC0718i.m1833K(EnumC0719j.WRAP_EXCEPTIONS)) {
            AbstractC1745j.m3875E(th);
        }
        abstractC0718i.m1859x(this._beanType.f2036e, th);
        throw null;
    }

    public AbstractC1204t findProperty(String str) {
        C1171w c1171w;
        C1149a c1149a = this._beanProperties;
        AbstractC1204t abstractC1204tM2984d = c1149a == null ? null : c1149a.m2984d(str);
        return (abstractC1204tM2984d != null || (c1171w = this._propertyBasedCreator) == null) ? abstractC1204tM2984d : c1171w.m3013c(str);
    }

    public Object handlePolymorphic(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C0553u c0553u, Object obj, C1730E c1730e) throws C0850b {
        AbstractC0722m abstractC0722m_findSubclassDeserializer = _findSubclassDeserializer(abstractC0718i, obj, c1730e);
        if (abstractC0722m_findSubclassDeserializer == null) {
            if (c1730e != null) {
                obj = handleUnknownProperties(abstractC0718i, obj, c1730e);
            }
            return abstractC0545m != null ? deserialize(abstractC0545m, abstractC0718i, obj) : obj;
        }
        if (c1730e != null) {
            c1730e.mo1143p();
            C1728C c1728c = new C1728C(c1730e.f6063m, c1730e.f6056f, c1730e.f6060j, c1730e.f6061k, c1730e.f6057g, c0553u);
            c1728c.mo1177V();
            obj = abstractC0722m_findSubclassDeserializer.deserialize(c1728c, abstractC0718i, obj);
        }
        return abstractC0545m != null ? abstractC0722m_findSubclassDeserializer.deserialize(abstractC0545m, abstractC0718i, obj) : obj;
    }

    public AbstractC1204t findProperty(int i3) {
        AbstractC1204t abstractC1204t;
        C1171w c1171w;
        C1149a c1149a = this._beanProperties;
        AbstractC1204t abstractC1204t2 = null;
        if (c1149a == null) {
            abstractC1204t = null;
        } else {
            int length = c1149a.f3972i.length;
            for (int i4 = 1; i4 < length; i4 += 2) {
                abstractC1204t = (AbstractC1204t) c1149a.f3972i[i4];
                if (abstractC1204t != null && i3 == abstractC1204t.mo3031s()) {
                    break;
                }
            }
            abstractC1204t = null;
        }
        if (abstractC1204t != null || (c1171w = this._propertyBasedCreator) == null) {
            return abstractC1204t;
        }
        Iterator it = c1171w.f4033c.values().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AbstractC1204t abstractC1204t3 = (AbstractC1204t) it.next();
            if (abstractC1204t3.mo3031s() == i3) {
                abstractC1204t2 = abstractC1204t3;
                break;
            }
        }
        return abstractC1204t2;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase) {
        this(beanDeserializerBase, beanDeserializerBase._ignoreAllUnknown);
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, boolean z3) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._beanProperties = beanDeserializerBase._beanProperties;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = z3;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, AbstractC1757v abstractC1757v) {
        C0703E c0703e;
        AbstractC0722m abstractC0722mUnwrappingDeserializer;
        C0703E c0703e2;
        AbstractC0722m abstractC0722mUnwrappingDeserializer2;
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = abstractC1757v != null || beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        C1147E c1147e = beanDeserializerBase._unwrappedPropertyHandler;
        if (abstractC1757v != null) {
            String str = null;
            if (c1147e != null) {
                List<AbstractC1204t> list = c1147e.f3966a;
                ArrayList arrayList = new ArrayList(list.size());
                for (AbstractC1204t abstractC1204tMo2963F : list) {
                    String strMo3911a = abstractC1757v.mo3911a(abstractC1204tMo2963F.f4102g.f1928e);
                    C0703E c0703e3 = abstractC1204tMo2963F.f4102g;
                    if (c0703e3 != null) {
                        strMo3911a = strMo3911a == null ? "" : strMo3911a;
                        c0703e2 = strMo3911a.equals(c0703e3.f1928e) ? c0703e3 : new C0703E(strMo3911a, c0703e3.f1929f);
                    } else {
                        c0703e2 = new C0703E(strMo3911a, null);
                    }
                    abstractC1204tMo2963F = c0703e2 != c0703e3 ? abstractC1204tMo2963F.mo2963F(c0703e2) : abstractC1204tMo2963F;
                    AbstractC0722m abstractC0722mMo3032t = abstractC1204tMo2963F.mo3032t();
                    if (abstractC0722mMo3032t != null && (abstractC0722mUnwrappingDeserializer2 = abstractC0722mMo3032t.unwrappingDeserializer(abstractC1757v)) != abstractC0722mMo3032t) {
                        abstractC1204tMo2963F = abstractC1204tMo2963F.mo2965H(abstractC0722mUnwrappingDeserializer2);
                    }
                    arrayList.add(abstractC1204tMo2963F);
                }
                c1147e = new C1147E(arrayList);
            }
            C1149a c1149a = beanDeserializerBase._beanProperties;
            c1149a.getClass();
            if (abstractC1757v != AbstractC1757v.f6136e) {
                AbstractC1204t[] abstractC1204tArr = c1149a.f3973j;
                int length = abstractC1204tArr.length;
                ArrayList arrayList2 = new ArrayList(length);
                int i3 = 0;
                while (i3 < length) {
                    AbstractC1204t abstractC1204tMo2963F2 = abstractC1204tArr[i3];
                    if (abstractC1204tMo2963F2 == null) {
                        arrayList2.add(abstractC1204tMo2963F2);
                    } else {
                        C0703E c0703e4 = abstractC1204tMo2963F2.f4102g;
                        String strMo3911a2 = abstractC1757v.mo3911a(c0703e4.f1928e);
                        if (c0703e4 != null) {
                            strMo3911a2 = strMo3911a2 == null ? "" : strMo3911a2;
                            c0703e = strMo3911a2.equals(c0703e4.f1928e) ? c0703e4 : new C0703E(strMo3911a2, c0703e4.f1929f);
                        } else {
                            c0703e = new C0703E(strMo3911a2, str);
                        }
                        abstractC1204tMo2963F2 = c0703e != c0703e4 ? abstractC1204tMo2963F2.mo2963F(c0703e) : abstractC1204tMo2963F2;
                        AbstractC0722m abstractC0722mMo3032t2 = abstractC1204tMo2963F2.mo3032t();
                        if (abstractC0722mMo3032t2 != null && (abstractC0722mUnwrappingDeserializer = abstractC0722mMo3032t2.unwrappingDeserializer(abstractC1757v)) != abstractC0722mMo3032t2) {
                            abstractC1204tMo2963F2 = abstractC1204tMo2963F2.mo2965H(abstractC0722mUnwrappingDeserializer);
                        }
                        arrayList2.add(abstractC1204tMo2963F2);
                    }
                    i3++;
                    str = null;
                }
                c1149a = new C1149a(c1149a.f3968e, arrayList2, c1149a.f3974k, c1149a.f3976m);
            }
            this._beanProperties = c1149a;
        } else {
            this._beanProperties = beanDeserializerBase._beanProperties;
        }
        this._unwrappedPropertyHandler = c1147e;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = false;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, C1167s c1167s) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._objectIdReader = c1167s;
        if (c1167s == null) {
            this._beanProperties = beanDeserializerBase._beanProperties;
            this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
        } else {
            this._beanProperties = beanDeserializerBase._beanProperties.m2989i(new C1169u(c1167s, C0702D.f1916l));
            this._vanillaProcessing = false;
        }
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, Set<String> set, Set<String> set2) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = set;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = set2;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        C1149a c1149a = beanDeserializerBase._beanProperties;
        c1149a.getClass();
        if ((set != null && !set.isEmpty()) || set2 != null) {
            AbstractC1204t[] abstractC1204tArr = c1149a.f3973j;
            ArrayList arrayList = new ArrayList(abstractC1204tArr.length);
            for (AbstractC1204t abstractC1204t : abstractC1204tArr) {
                if (abstractC1204t != null && !AbstractC0473V.m999L(abstractC1204t.f4102g.f1928e, set, set2)) {
                    arrayList.add(abstractC1204t);
                }
            }
            c1149a = new C1149a(c1149a.f3968e, arrayList, c1149a.f3974k, c1149a.f3976m);
        }
        this._beanProperties = c1149a;
    }

    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, C1149a c1149a) {
        super(beanDeserializerBase._beanType);
        this._beanType = beanDeserializerBase._beanType;
        this._valueInstantiator = beanDeserializerBase._valueInstantiator;
        this._delegateDeserializer = beanDeserializerBase._delegateDeserializer;
        this._arrayDelegateDeserializer = beanDeserializerBase._arrayDelegateDeserializer;
        this._propertyBasedCreator = beanDeserializerBase._propertyBasedCreator;
        this._beanProperties = c1149a;
        this._backRefs = beanDeserializerBase._backRefs;
        this._ignorableProps = beanDeserializerBase._ignorableProps;
        this._ignoreAllUnknown = beanDeserializerBase._ignoreAllUnknown;
        this._includableProps = beanDeserializerBase._includableProps;
        this._anySetter = beanDeserializerBase._anySetter;
        this._injectables = beanDeserializerBase._injectables;
        this._objectIdReader = beanDeserializerBase._objectIdReader;
        this._nonStandardCreation = beanDeserializerBase._nonStandardCreation;
        this._unwrappedPropertyHandler = beanDeserializerBase._unwrappedPropertyHandler;
        this._needViewProcesing = beanDeserializerBase._needViewProcesing;
        this._serializationShape = beanDeserializerBase._serializationShape;
        this._vanillaProcessing = beanDeserializerBase._vanillaProcessing;
    }

    @Deprecated
    public BeanDeserializerBase(BeanDeserializerBase beanDeserializerBase, Set<String> set) {
        this(beanDeserializerBase, set, beanDeserializerBase._includableProps);
    }
}

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.ser.impl.AbstractC1223k;
import com.fasterxml.jackson.databind.ser.impl.C1219g;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import p001A.C0009j;
import p033K0.AbstractC0405c;
import p039M0.AbstractC0473V;
import p039M0.C0453A;
import p039M0.C0502q;
import p039M0.C0508w;
import p039M0.EnumC0499n;
import p039M0.EnumC0511z;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0716g;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p071Y0.InterfaceC0738b;
import p082b1.AbstractC1041l;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.C1739d;
import p118m1.C1751p;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class MapSerializer extends ContainerSerializer<Map<?, ?>> implements InterfaceC1638f {
    private static final long serialVersionUID = 1;
    protected AbstractC1223k _dynamicValueSerializers;
    protected final Object _filterId;
    protected final Set<String> _ignoredEntries;
    protected final Set<String> _includedEntries;
    protected final C1751p _inclusionChecker;
    protected AbstractC0728s _keySerializer;
    protected final AbstractC0721l _keyType;
    protected final InterfaceC0714e _property;
    protected final boolean _sortKeys;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected AbstractC0728s _valueSerializer;
    protected final AbstractC0721l _valueType;
    protected final boolean _valueTypeIsStatic;
    protected final AbstractC1399h _valueTypeSerializer;
    protected static final AbstractC0721l UNSPECIFIED_TYPE = C1675q.m3773n();
    public static final Object MARKER_FOR_EMPTY = EnumC0511z.f1184g;

    public MapSerializer(Set<String> set, Set<String> set2, AbstractC0721l abstractC0721l, AbstractC0721l abstractC0721l2, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = abstractC0721l;
        this._valueType = abstractC0721l2;
        this._valueTypeIsStatic = z3;
        this._valueTypeSerializer = abstractC1399h;
        this._keySerializer = abstractC0728s;
        this._valueSerializer = abstractC0728s2;
        this._dynamicValueSerializers = C1219g.f4140b;
        this._property = null;
        this._filterId = null;
        this._sortKeys = false;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this._inclusionChecker = AbstractC0473V.m991C(set, set2);
    }

    private final AbstractC0728s _findSerializer(AbstractC0709K abstractC0709K, Object obj) {
        Class<?> cls = obj.getClass();
        AbstractC0728s abstractC0728sMo3092c = this._dynamicValueSerializers.mo3092c(cls);
        return abstractC0728sMo3092c != null ? abstractC0728sMo3092c : this._valueType.mo1881p() ? _findAndAddDynamic(this._dynamicValueSerializers, abstractC0709K.m1718p(this._valueType, cls), abstractC0709K) : _findAndAddDynamic(this._dynamicValueSerializers, cls, abstractC0709K);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.fasterxml.jackson.databind.ser.std.MapSerializer construct(java.util.Set<java.lang.String> r12, java.util.Set<java.lang.String> r13, p069X0.AbstractC0721l r14, boolean r15, p100g1.AbstractC1399h r16, p069X0.AbstractC0728s r17, p069X0.AbstractC0728s r18, java.lang.Object r19) {
        /*
            r0 = r14
            r1 = r19
            if (r0 != 0) goto La
            X0.l r0 = com.fasterxml.jackson.databind.ser.std.MapSerializer.UNSPECIFIED_TYPE
            r6 = r0
            r7 = r6
            goto L22
        La:
            X0.l r2 = r14.mo1877l()
            java.lang.Class<java.util.Properties> r3 = java.util.Properties.class
            boolean r3 = r14.m1883r(r3)
            if (r3 == 0) goto L1d
            l1.l r0 = p114l1.C1675q.m3773n()
        L1a:
            r7 = r0
            r6 = r2
            goto L22
        L1d:
            X0.l r0 = r14.mo1874i()
            goto L1a
        L22:
            r0 = 0
            if (r15 != 0) goto L36
            if (r7 == 0) goto L34
            java.lang.Class r2 = r7.f2036e
            int r2 = r2.getModifiers()
            boolean r2 = java.lang.reflect.Modifier.isFinal(r2)
            if (r2 == 0) goto L34
            r0 = 1
        L34:
            r8 = r0
            goto L3e
        L36:
            java.lang.Class r2 = r7.f2036e
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r2 != r3) goto L3d
            goto L34
        L3d:
            r8 = r15
        L3e:
            com.fasterxml.jackson.databind.ser.std.MapSerializer r0 = new com.fasterxml.jackson.databind.ser.std.MapSerializer
            r3 = r0
            r4 = r12
            r5 = r13
            r9 = r16
            r10 = r17
            r11 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r1 == 0) goto L52
            com.fasterxml.jackson.databind.ser.std.MapSerializer r0 = r0.withFilterId(r1)
        L52:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.construct(java.util.Set, java.util.Set, X0.l, boolean, g1.h, X0.s, X0.s, java.lang.Object):com.fasterxml.jackson.databind.ser.std.MapSerializer");
    }

    public void _ensureOverride(String str) {
        AbstractC1745j.m3876F(MapSerializer.class, this, str);
    }

    public final AbstractC0728s _findAndAddDynamic(AbstractC1223k abstractC1223k, Class<?> cls, AbstractC0709K abstractC0709K) {
        InterfaceC0714e interfaceC0714e = this._property;
        abstractC1223k.getClass();
        AbstractC0728s abstractC0728sM1721s = abstractC0709K.m1721s(cls, interfaceC0714e);
        AbstractC1223k abstractC1223kMo3091b = abstractC1223k.mo3091b(cls, abstractC0728sM1721s);
        if (abstractC1223k != abstractC1223kMo3091b) {
            this._dynamicValueSerializers = abstractC1223kMo3091b;
        }
        return abstractC0728sM1721s;
    }

    public boolean _hasNullKey(Map<?, ?> map) {
        return (map instanceof HashMap) && map.containsKey(null);
    }

    public Map<?, ?> _orderEntries(Map<?, ?> map, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        if (map instanceof SortedMap) {
            return map;
        }
        if (!_hasNullKey(map)) {
            return new TreeMap(map);
        }
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                _writeNullKeyedEntry(abstractC0540h, abstractC0709K, entry.getValue());
            } else {
                treeMap.put(key, entry.getValue());
            }
        }
        return treeMap;
    }

    public void _writeNullKeyedEntry(AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, Object obj) throws IOException {
        AbstractC0728s abstractC0728s_findSerializer;
        AbstractC0728s abstractC0728s = abstractC0709K.f1974m;
        if (obj != null) {
            abstractC0728s_findSerializer = this._valueSerializer;
            if (abstractC0728s_findSerializer == null) {
                abstractC0728s_findSerializer = _findSerializer(abstractC0709K, obj);
            }
            Object obj2 = this._suppressableValue;
            if (obj2 == MARKER_FOR_EMPTY) {
                if (abstractC0728s_findSerializer.isEmpty(abstractC0709K, obj)) {
                    return;
                }
            } else if (obj2 != null && obj2.equals(obj)) {
                return;
            }
        } else if (this._suppressNulls) {
            return;
        } else {
            abstractC0728s_findSerializer = abstractC0709K.f1973l;
        }
        try {
            abstractC0728s.serialize(null, abstractC0540h, abstractC0709K);
            abstractC0728s_findSerializer.serialize(obj, abstractC0540h, abstractC0709K);
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, obj, "");
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        AbstractC0728s abstractC0728sMo1709I;
        AbstractC0728s abstractC0728sMo1709I2;
        Set<String> set;
        Set<String> set2;
        boolean zEquals;
        Object objMo1781n;
        Boolean boolM1015b;
        AbstractC0711b abstractC0711bM2149d = abstractC0709K.f1966e.m2149d();
        Object objM887h = null;
        AbstractC1041l abstractC1041lMo1805c = interfaceC0714e == null ? null : interfaceC0714e.mo1805c();
        if (StdSerializer._neitherNull(abstractC1041lMo1805c, abstractC0711bM2149d)) {
            Object objMo1792t = abstractC0711bM2149d.mo1792t(abstractC1041lMo1805c);
            abstractC0728sMo1709I = objMo1792t != null ? abstractC0709K.mo1709I(abstractC1041lMo1805c, objMo1792t) : null;
            Object objMo1761d = abstractC0711bM2149d.mo1761d(abstractC1041lMo1805c);
            abstractC0728sMo1709I2 = objMo1761d != null ? abstractC0709K.mo1709I(abstractC1041lMo1805c, objMo1761d) : null;
        } else {
            abstractC0728sMo1709I = null;
            abstractC0728sMo1709I2 = null;
        }
        if (abstractC0728sMo1709I2 == null) {
            abstractC0728sMo1709I2 = this._valueSerializer;
        }
        AbstractC0728s abstractC0728sFindContextualConvertingSerializer = findContextualConvertingSerializer(abstractC0709K, interfaceC0714e, abstractC0728sMo1709I2);
        if (abstractC0728sFindContextualConvertingSerializer == null && this._valueTypeIsStatic && !this._valueType.m1889x()) {
            abstractC0728sFindContextualConvertingSerializer = abstractC0709K.m1720r(this._valueType, interfaceC0714e);
        }
        AbstractC0728s abstractC0728s = abstractC0728sFindContextualConvertingSerializer;
        if (abstractC0728sMo1709I == null) {
            abstractC0728sMo1709I = this._keySerializer;
        }
        AbstractC0728s abstractC0728sM1722t = abstractC0728sMo1709I == null ? abstractC0709K.m1722t(this._keyType, interfaceC0714e) : abstractC0709K.m1704D(abstractC0728sMo1709I, interfaceC0714e);
        Set<String> hashSet = this._ignoredEntries;
        Set<String> hashSet2 = this._includedEntries;
        boolean zMo1706F = false;
        if (StdSerializer._neitherNull(abstractC1041lMo1805c, abstractC0711bM2149d)) {
            C0508w c0508wMo1737I = abstractC0711bM2149d.mo1737I(abstractC1041lMo1805c);
            Set setEmptySet = c0508wMo1737I.f1179g ? Collections.emptySet() : c0508wMo1737I.f1177e;
            if (StdSerializer._nonEmpty(setEmptySet)) {
                hashSet = hashSet == null ? new HashSet<>() : new HashSet(hashSet);
                Iterator it = setEmptySet.iterator();
                while (it.hasNext()) {
                    hashSet.add((String) it.next());
                }
            }
            Set set3 = abstractC0711bM2149d.mo1740L(abstractC1041lMo1805c).f1101e;
            if (set3 != null) {
                hashSet2 = hashSet2 == null ? new HashSet<>() : new HashSet(hashSet2);
                Iterator it2 = set3.iterator();
                while (it2.hasNext()) {
                    hashSet2.add((String) it2.next());
                }
            }
            zEquals = Boolean.TRUE.equals(abstractC0711bM2149d.mo1748T(abstractC1041lMo1805c));
            set = hashSet;
            set2 = hashSet2;
        } else {
            set = hashSet;
            set2 = hashSet2;
            zEquals = false;
        }
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, Map.class);
        MapSerializer mapSerializerWithResolved = withResolved(interfaceC0714e, abstractC0728sM1722t, abstractC0728s, set, set2, (c0502qFindFormatOverrides == null || (boolM1015b = c0502qFindFormatOverrides.m1015b(EnumC0499n.f1152j)) == null) ? zEquals : boolM1015b.booleanValue());
        if (abstractC1041lMo1805c != null && (objMo1781n = abstractC0711bM2149d.mo1781n(abstractC1041lMo1805c)) != null) {
            mapSerializerWithResolved = mapSerializerWithResolved.withFilterId(objMo1781n);
        }
        C0453A c0453aFindIncludeOverrides = findIncludeOverrides(abstractC0709K, interfaceC0714e, Map.class);
        if (c0453aFindIncludeOverrides == null) {
            return mapSerializerWithResolved;
        }
        EnumC0511z enumC0511z = EnumC0511z.f1186i;
        EnumC0511z enumC0511z2 = c0453aFindIncludeOverrides.f1097f;
        if (enumC0511z2 == enumC0511z) {
            return mapSerializerWithResolved;
        }
        int iOrdinal = enumC0511z2.ordinal();
        if (iOrdinal == 1) {
            zMo1706F = true;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    objM887h = MARKER_FOR_EMPTY;
                } else if (iOrdinal == 4) {
                    objM887h = AbstractC0405c.m887h(this._valueType);
                    if (objM887h != null && objM887h.getClass().isArray()) {
                        objM887h = C1739d.m3869b(objM887h);
                    }
                } else if (iOrdinal == 5) {
                    objM887h = abstractC0709K.mo1705E(c0453aFindIncludeOverrides.f1099h);
                    if (objM887h != null) {
                        zMo1706F = abstractC0709K.mo1706F(objM887h);
                    }
                }
            } else if (this._valueType.mo1629b()) {
                objM887h = MARKER_FOR_EMPTY;
            }
            zMo1706F = true;
        }
        return mapSerializerWithResolved.withContentInclusion(objM887h, zMo1706F);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0728s getContentSerializer() {
        return this._valueSerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public AbstractC0721l getContentType() {
        return this._valueType;
    }

    public AbstractC0728s getKeySerializer() {
        return this._keySerializer;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("object", true);
    }

    public void serializeFields(Map<?, ?> map, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        Object obj = null;
        if (this._valueTypeSerializer != null) {
            serializeTypedFields(map, abstractC0540h, abstractC0709K, null);
            return;
        }
        AbstractC0728s abstractC0728s = this._keySerializer;
        try {
            Object key = null;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                try {
                    Object value = entry.getValue();
                    key = entry.getKey();
                    if (key == null) {
                        abstractC0709K.f1974m.serialize(null, abstractC0540h, abstractC0709K);
                    } else {
                        C1751p c1751p = this._inclusionChecker;
                        if (c1751p == null || !c1751p.m3910a(key)) {
                            abstractC0728s.serialize(key, abstractC0540h, abstractC0709K);
                        }
                    }
                    if (value == null) {
                        abstractC0709K.m1719q(abstractC0540h);
                    } else {
                        AbstractC0728s abstractC0728s_findSerializer = this._valueSerializer;
                        if (abstractC0728s_findSerializer == null) {
                            abstractC0728s_findSerializer = _findSerializer(abstractC0709K, value);
                        }
                        abstractC0728s_findSerializer.serialize(value, abstractC0540h, abstractC0709K);
                    }
                } catch (Exception e3) {
                    e = e3;
                    obj = key;
                    wrapAndThrow(abstractC0709K, e, map, String.valueOf(obj));
                    return;
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public void serializeFieldsUsing(Map<?, ?> map, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC0728s abstractC0728s) throws IOException {
        AbstractC0728s abstractC0728s2 = this._keySerializer;
        AbstractC1399h abstractC1399h = this._valueTypeSerializer;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            C1751p c1751p = this._inclusionChecker;
            if (c1751p == null || !c1751p.m3910a(key)) {
                if (key == null) {
                    abstractC0709K.f1974m.serialize(null, abstractC0540h, abstractC0709K);
                } else {
                    abstractC0728s2.serialize(key, abstractC0540h, abstractC0709K);
                }
                Object value = entry.getValue();
                if (value == null) {
                    abstractC0709K.m1719q(abstractC0540h);
                } else if (abstractC1399h == null) {
                    try {
                        abstractC0728s.serialize(value, abstractC0540h, abstractC0709K);
                    } catch (Exception e3) {
                        wrapAndThrow(abstractC0709K, e3, map, String.valueOf(key));
                    }
                } else {
                    abstractC0728s.serializeWithType(value, abstractC0540h, abstractC0709K, abstractC1399h);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void serializeFilteredAnyProperties(p069X0.AbstractC0709K r4, p042N0.AbstractC0540h r5, java.lang.Object r6, java.util.Map<?, ?> r7, p112k1.InterfaceC1641i r8, java.lang.Object r9) throws java.io.IOException {
        /*
            r3 = this;
            X0.e r5 = r3._property
            if (r5 != 0) goto L7
            X0.D r5 = p069X0.C0702D.f1918n
            goto Lb
        L7:
            X0.D r5 = r5.mo1804b()
        Lb:
            if (r5 != 0) goto Lf
            X0.D r5 = p069X0.C0702D.f1916l
        Lf:
            java.lang.Object r5 = com.fasterxml.jackson.databind.ser.std.MapSerializer.MARKER_FOR_EMPTY
            if (r5 != r9) goto L15
            r5 = 1
            goto L16
        L15:
            r5 = 0
        L16:
            java.util.Set r6 = r7.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L1e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L72
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            m1.p r2 = r3._inclusionChecker
            if (r2 == 0) goto L39
            boolean r2 = r2.m3910a(r1)
            if (r2 == 0) goto L39
            goto L1e
        L39:
            if (r1 != 0) goto L3d
            X0.s r2 = r4.f1974m
        L3d:
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L4b
            boolean r0 = r3._suppressNulls
            if (r0 == 0) goto L48
            goto L1e
        L48:
            X0.s r0 = r4.f1973l
            goto L65
        L4b:
            X0.s r2 = r3._valueSerializer
            if (r2 != 0) goto L53
            X0.s r2 = r3._findSerializer(r4, r0)
        L53:
            if (r5 == 0) goto L5c
            boolean r0 = r2.isEmpty(r4, r0)
            if (r0 == 0) goto L65
            goto L1e
        L5c:
            if (r9 == 0) goto L65
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L65
            goto L1e
        L65:
            r8.m3725a()     // Catch: java.lang.Exception -> L69
            goto L1e
        L69:
            r0 = move-exception
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r3.wrapAndThrow(r4, r0, r7, r1)
            goto L1e
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeFilteredAnyProperties(X0.K, N0.h, java.lang.Object, java.util.Map, k1.i, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void serializeFilteredFields(java.util.Map<?, ?> r5, p042N0.AbstractC0540h r6, p069X0.AbstractC0709K r7, p112k1.InterfaceC1641i r8, java.lang.Object r9) throws java.io.IOException {
        /*
            r4 = this;
            X0.e r6 = r4._property
            if (r6 != 0) goto L7
            X0.D r6 = p069X0.C0702D.f1918n
            goto Lb
        L7:
            X0.D r6 = r6.mo1804b()
        Lb:
            if (r6 != 0) goto Lf
            X0.D r6 = p069X0.C0702D.f1916l
        Lf:
            java.lang.Object r6 = com.fasterxml.jackson.databind.ser.std.MapSerializer.MARKER_FOR_EMPTY
            if (r6 != r9) goto L15
            r6 = 1
            goto L16
        L15:
            r6 = 0
        L16:
            java.util.Set r0 = r5.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L72
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            m1.p r3 = r4._inclusionChecker
            if (r3 == 0) goto L39
            boolean r3 = r3.m3910a(r2)
            if (r3 == 0) goto L39
            goto L1e
        L39:
            if (r2 != 0) goto L3d
            X0.s r3 = r7.f1974m
        L3d:
            java.lang.Object r1 = r1.getValue()
            if (r1 != 0) goto L4b
            boolean r1 = r4._suppressNulls
            if (r1 == 0) goto L48
            goto L1e
        L48:
            X0.s r1 = r7.f1973l
            goto L65
        L4b:
            X0.s r3 = r4._valueSerializer
            if (r3 != 0) goto L53
            X0.s r3 = r4._findSerializer(r7, r1)
        L53:
            if (r6 == 0) goto L5c
            boolean r1 = r3.isEmpty(r7, r1)
            if (r1 == 0) goto L65
            goto L1e
        L5c:
            if (r9 == 0) goto L65
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L65
            goto L1e
        L65:
            r8.m3725a()     // Catch: java.lang.Exception -> L69
            goto L1e
        L69:
            r1 = move-exception
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r4.wrapAndThrow(r7, r1, r5, r2)
            goto L1e
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeFilteredFields(java.util.Map, N0.h, X0.K, k1.i, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0061 A[EXC_TOP_SPLITTER, PHI: r5
      0x0061: PHI (r5v2 X0.s) = (r5v1 X0.s), (r5v4 X0.s), (r5v4 X0.s), (r5v4 X0.s) binds: [B:27:0x0044, B:33:0x0055, B:35:0x0058, B:37:0x005e] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void serializeOptionalFields(java.util.Map<?, ?> r8, p042N0.AbstractC0540h r9, p069X0.AbstractC0709K r10, java.lang.Object r11) throws java.io.IOException {
        /*
            r7 = this;
            g1.h r0 = r7._valueTypeSerializer
            if (r0 == 0) goto L8
            r7.serializeTypedFields(r8, r9, r10, r11)
            return
        L8:
            java.lang.Object r0 = com.fasterxml.jackson.databind.ser.std.MapSerializer.MARKER_FOR_EMPTY
            if (r0 != r11) goto Le
            r0 = 1
            goto Lf
        Le:
            r0 = 0
        Lf:
            java.util.Set r1 = r8.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L17:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L71
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            if (r3 != 0) goto L2c
            X0.s r4 = r10.f1974m
            goto L39
        L2c:
            m1.p r4 = r7._inclusionChecker
            if (r4 == 0) goto L37
            boolean r4 = r4.m3910a(r3)
            if (r4 == 0) goto L37
            goto L17
        L37:
            X0.s r4 = r7._keySerializer
        L39:
            java.lang.Object r2 = r2.getValue()
            if (r2 != 0) goto L47
            boolean r5 = r7._suppressNulls
            if (r5 == 0) goto L44
            goto L17
        L44:
            X0.s r5 = r10.f1973l
            goto L61
        L47:
            X0.s r5 = r7._valueSerializer
            if (r5 != 0) goto L4f
            X0.s r5 = r7._findSerializer(r10, r2)
        L4f:
            if (r0 == 0) goto L58
            boolean r6 = r5.isEmpty(r10, r2)
            if (r6 == 0) goto L61
            goto L17
        L58:
            if (r11 == 0) goto L61
            boolean r6 = r11.equals(r2)
            if (r6 == 0) goto L61
            goto L17
        L61:
            r4.serialize(r3, r9, r10)     // Catch: java.lang.Exception -> L68
            r5.serialize(r2, r9, r10)     // Catch: java.lang.Exception -> L68
            goto L17
        L68:
            r2 = move-exception
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r7.wrapAndThrow(r10, r2, r8, r3)
            goto L17
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeOptionalFields(java.util.Map, N0.h, X0.K, java.lang.Object):void");
    }

    public void serializeTypedFields(Map<?, ?> map, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, Object obj) throws IOException {
        AbstractC0728s abstractC0728s;
        AbstractC0728s abstractC0728s_findSerializer;
        boolean z3 = MARKER_FOR_EMPTY == obj;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            if (key == null) {
                abstractC0728s = abstractC0709K.f1974m;
            } else {
                C1751p c1751p = this._inclusionChecker;
                if (c1751p == null || !c1751p.m3910a(key)) {
                    abstractC0728s = this._keySerializer;
                }
            }
            Object value = entry.getValue();
            if (value != null) {
                abstractC0728s_findSerializer = this._valueSerializer;
                if (abstractC0728s_findSerializer == null) {
                    abstractC0728s_findSerializer = _findSerializer(abstractC0709K, value);
                }
                if (z3) {
                    if (!abstractC0728s_findSerializer.isEmpty(abstractC0709K, value)) {
                        abstractC0728s.serialize(key, abstractC0540h, abstractC0709K);
                        abstractC0728s_findSerializer.serializeWithType(value, abstractC0540h, abstractC0709K, this._valueTypeSerializer);
                    }
                } else if (obj == null || !obj.equals(value)) {
                    abstractC0728s.serialize(key, abstractC0540h, abstractC0709K);
                    abstractC0728s_findSerializer.serializeWithType(value, abstractC0540h, abstractC0709K, this._valueTypeSerializer);
                }
            } else if (!this._suppressNulls) {
                abstractC0728s_findSerializer = abstractC0709K.f1973l;
                abstractC0728s.serialize(key, abstractC0540h, abstractC0709K);
                try {
                    abstractC0728s_findSerializer.serializeWithType(value, abstractC0540h, abstractC0709K, this._valueTypeSerializer);
                } catch (Exception e3) {
                    wrapAndThrow(abstractC0709K, e3, map, String.valueOf(key));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void serializeWithoutTypeInfo(java.util.Map<?, ?> r3, p042N0.AbstractC0540h r4, p069X0.AbstractC0709K r5) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r3.isEmpty()
            if (r0 != 0) goto L37
            boolean r0 = r2._sortKeys
            if (r0 != 0) goto L14
            X0.J r0 = p069X0.EnumC0708J.ORDER_MAP_ENTRIES_BY_KEYS
            X0.I r1 = r5.f1966e
            boolean r0 = r1.m1698r(r0)
            if (r0 == 0) goto L18
        L14:
            java.util.Map r3 = r2._orderEntries(r3, r4, r5)
        L18:
            java.lang.Object r0 = r2._filterId
            if (r0 == 0) goto L1f
            r2.findPropertyFilter(r5, r0, r3)
        L1f:
            java.lang.Object r0 = r2._suppressableValue
            if (r0 != 0) goto L34
            boolean r1 = r2._suppressNulls
            if (r1 == 0) goto L28
            goto L34
        L28:
            X0.s r0 = r2._valueSerializer
            if (r0 == 0) goto L30
            r2.serializeFieldsUsing(r3, r4, r5, r0)
            goto L37
        L30:
            r2.serializeFields(r3, r4, r5)
            goto L37
        L34:
            r2.serializeOptionalFields(r3, r4, r5, r0)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapSerializer.serializeWithoutTypeInfo(java.util.Map, N0.h, X0.K):void");
    }

    public MapSerializer withContentInclusion(Object obj, boolean z3) {
        if (obj == this._suppressableValue && z3 == this._suppressNulls) {
            return this;
        }
        _ensureOverride("withContentInclusion");
        return new MapSerializer(this, this._valueTypeSerializer, obj, z3);
    }

    public MapSerializer withResolved(InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Set<String> set, Set<String> set2, boolean z3) {
        _ensureOverride("withResolved");
        MapSerializer mapSerializer = new MapSerializer(this, interfaceC0714e, abstractC0728s, abstractC0728s2, set, set2);
        return z3 != mapSerializer._sortKeys ? new MapSerializer(mapSerializer, this._filterId, z3) : mapSerializer;
    }

    @Deprecated
    public void _ensureOverride() {
        _ensureOverride("N/A");
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public MapSerializer _withValueTypeSerializer(AbstractC1399h abstractC1399h) {
        if (this._valueTypeSerializer == abstractC1399h) {
            return this;
        }
        _ensureOverride("_withValueTypeSerializer");
        return new MapSerializer(this, abstractC1399h, this._suppressableValue, this._suppressNulls);
    }

    @Override // com.fasterxml.jackson.databind.ser.ContainerSerializer
    public boolean hasSingleElement(Map<?, ?> map) {
        return map.size() == 1;
    }

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, Map<?, ?> map) {
        AbstractC0728s abstractC0728s_findSerializer;
        if (map.isEmpty()) {
            return true;
        }
        Object obj = this._suppressableValue;
        if (obj == null && !this._suppressNulls) {
            return false;
        }
        AbstractC0728s abstractC0728s = this._valueSerializer;
        boolean z3 = MARKER_FOR_EMPTY == obj;
        if (abstractC0728s != null) {
            for (Object obj2 : map.values()) {
                if (obj2 == null) {
                    if (!this._suppressNulls) {
                        return false;
                    }
                } else if (z3) {
                    if (!abstractC0728s.isEmpty(abstractC0709K, obj2)) {
                        return false;
                    }
                } else if (obj == null || !obj.equals(map)) {
                    return false;
                }
            }
            return true;
        }
        for (Object obj3 : map.values()) {
            if (obj3 != null) {
                try {
                    abstractC0728s_findSerializer = _findSerializer(abstractC0709K, obj3);
                } catch (AbstractC0716g unused) {
                }
                if (z3) {
                    if (!abstractC0728s_findSerializer.isEmpty(abstractC0709K, obj3)) {
                        return false;
                    }
                } else if (obj == null || !obj.equals(map)) {
                    return false;
                }
            } else if (!this._suppressNulls) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(Map<?, ?> map, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        abstractC0540h.mo1121N(map);
        serializeWithoutTypeInfo(map, abstractC0540h, abstractC0709K);
        abstractC0540h.mo1143p();
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(Map<?, ?> map, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        abstractC0540h.mo1136i(map);
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_OBJECT, map));
        serializeWithoutTypeInfo(map, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }

    @Override // p069X0.AbstractC0728s
    public MapSerializer withFilterId(Object obj) {
        if (this._filterId == obj) {
            return this;
        }
        _ensureOverride("withFilterId");
        return new MapSerializer(this, obj, this._sortKeys);
    }

    @Deprecated
    public MapSerializer withContentInclusion(Object obj) {
        return new MapSerializer(this, this._valueTypeSerializer, obj, this._suppressNulls);
    }

    public final AbstractC0728s _findAndAddDynamic(AbstractC1223k abstractC1223k, AbstractC0721l abstractC0721l, AbstractC0709K abstractC0709K) {
        C0009j c0009jM3093a = abstractC1223k.m3093a(abstractC0709K, this._property, abstractC0721l);
        AbstractC1223k abstractC1223k2 = (AbstractC1223k) c0009jM3093a.f31g;
        if (abstractC1223k != abstractC1223k2) {
            this._dynamicValueSerializers = abstractC1223k2;
        }
        return (AbstractC0728s) c0009jM3093a.f30f;
    }

    public MapSerializer withResolved(InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Set<String> set, boolean z3) {
        return withResolved(interfaceC0714e, abstractC0728s, abstractC0728s2, set, null, z3);
    }

    public static MapSerializer construct(Set<String> set, AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Object obj) {
        return construct(set, null, abstractC0721l, z3, abstractC1399h, abstractC0728s, abstractC0728s2, obj);
    }

    @Deprecated
    public static MapSerializer construct(String[] strArr, AbstractC0721l abstractC0721l, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Object obj) {
        return construct(C1739d.m3868a(strArr), abstractC0721l, z3, abstractC1399h, abstractC0728s, abstractC0728s2, obj);
    }

    @Deprecated
    public MapSerializer(Set<String> set, AbstractC0721l abstractC0721l, AbstractC0721l abstractC0721l2, boolean z3, AbstractC1399h abstractC1399h, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2) {
        this(set, null, abstractC0721l, abstractC0721l2, z3, abstractC1399h, abstractC0728s, abstractC0728s2);
    }

    public MapSerializer(MapSerializer mapSerializer, InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Set<String> set, Set<String> set2) {
        super(Map.class, false);
        set = (set == null || set.isEmpty()) ? null : set;
        this._ignoredEntries = set;
        this._includedEntries = set2;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = abstractC0728s;
        this._valueSerializer = abstractC0728s2;
        this._dynamicValueSerializers = C1219g.f4140b;
        this._property = interfaceC0714e;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = mapSerializer._suppressableValue;
        this._suppressNulls = mapSerializer._suppressNulls;
        this._inclusionChecker = AbstractC0473V.m991C(set, set2);
    }

    @Deprecated
    public MapSerializer(MapSerializer mapSerializer, InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s, AbstractC0728s abstractC0728s2, Set<String> set) {
        this(mapSerializer, interfaceC0714e, abstractC0728s, abstractC0728s2, set, null);
    }

    public MapSerializer(MapSerializer mapSerializer, AbstractC1399h abstractC1399h, Object obj, boolean z3) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._includedEntries = mapSerializer._includedEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = abstractC1399h;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = mapSerializer._dynamicValueSerializers;
        this._property = mapSerializer._property;
        this._filterId = mapSerializer._filterId;
        this._sortKeys = mapSerializer._sortKeys;
        this._suppressableValue = obj;
        this._suppressNulls = z3;
        this._inclusionChecker = mapSerializer._inclusionChecker;
    }

    public MapSerializer(MapSerializer mapSerializer, Object obj, boolean z3) {
        super(Map.class, false);
        this._ignoredEntries = mapSerializer._ignoredEntries;
        this._includedEntries = mapSerializer._includedEntries;
        this._keyType = mapSerializer._keyType;
        this._valueType = mapSerializer._valueType;
        this._valueTypeIsStatic = mapSerializer._valueTypeIsStatic;
        this._valueTypeSerializer = mapSerializer._valueTypeSerializer;
        this._keySerializer = mapSerializer._keySerializer;
        this._valueSerializer = mapSerializer._valueSerializer;
        this._dynamicValueSerializers = C1219g.f4140b;
        this._property = mapSerializer._property;
        this._filterId = obj;
        this._sortKeys = z3;
        this._suppressableValue = mapSerializer._suppressableValue;
        this._suppressNulls = mapSerializer._suppressNulls;
        this._inclusionChecker = mapSerializer._inclusionChecker;
    }

    @Deprecated
    public MapSerializer(MapSerializer mapSerializer, AbstractC1399h abstractC1399h, Object obj) {
        this(mapSerializer, abstractC1399h, obj, false);
    }
}

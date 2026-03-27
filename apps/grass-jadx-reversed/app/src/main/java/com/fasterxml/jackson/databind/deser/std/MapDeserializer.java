package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.AbstractC1208x;
import com.fasterxml.jackson.databind.deser.C1205u;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1178m;
import com.fasterxml.jackson.databind.deser.InterfaceC1179n;
import com.fasterxml.jackson.databind.deser.impl.C1143A;
import com.fasterxml.jackson.databind.deser.impl.C1171w;
import com.fasterxml.jackson.databind.deser.impl.C1174z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p039M0.AbstractC0473V;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p042N0.EnumC0552t;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0730u;
import p069X0.C0717h;
import p069X0.EnumC0731v;
import p071Y0.InterfaceC0738b;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;
import p118m1.C1739d;
import p118m1.C1751p;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class MapDeserializer extends ContainerDeserializerBase<Map<Object, Object>> implements InterfaceC1139f, InterfaceC1179n {
    private static final long serialVersionUID = 1;
    protected boolean _checkDupSquash;
    protected AbstractC0722m _delegateDeserializer;
    protected final boolean _hasDefaultCreator;
    protected Set<String> _ignorableProperties;
    protected Set<String> _includableProperties;
    protected C1751p _inclusionChecker;
    protected final AbstractC0730u _keyDeserializer;
    protected C1171w _propertyBasedCreator;
    protected boolean _standardStringKey;
    protected final AbstractC0722m _valueDeserializer;
    protected final AbstractC1208x _valueInstantiator;
    protected final AbstractC1398g _valueTypeDeserializer;

    public MapDeserializer(AbstractC0721l abstractC0721l, AbstractC1208x abstractC1208x, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g) {
        super(abstractC0721l, (InterfaceC1178m) null, (Boolean) null);
        this._keyDeserializer = abstractC0730u;
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
        this._valueInstantiator = abstractC1208x;
        this._hasDefaultCreator = abstractC1208x.mo3005j();
        this._delegateDeserializer = null;
        this._propertyBasedCreator = null;
        this._standardStringKey = _isStdKeyDeser(abstractC0721l, abstractC0730u);
        this._inclusionChecker = null;
        this._checkDupSquash = abstractC0721l.mo1874i().m1883r(Object.class);
    }

    private void handleUnresolvedReference(AbstractC0718i abstractC0718i, C1191g c1191g, Object obj, C1205u c1205u) throws C0850b {
        if (c1191g != null) {
            c1191g.f4060c.add(new C1190f(c1191g, c1205u, c1191g.f4058a, obj));
            c1205u.getClass();
            throw null;
        }
        abstractC0718i.m1841S(this, "Unresolved forward reference but no identity info: " + c1205u, new Object[0]);
        throw null;
    }

    public Map<Object, Object> _deserializeUsingCreator(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        Object objDeserialize;
        C1171w c1171w = this._propertyBasedCreator;
        C1143A c1143aM3014d = c1171w.m3014d(abstractC0545m, abstractC0718i, null);
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        String strMo1175T = abstractC0545m.mo1173R() ? abstractC0545m.mo1175T() : abstractC0545m.mo1168M(EnumC0548p.FIELD_NAME) ? abstractC0545m.mo1188d() : null;
        while (strMo1175T != null) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            C1751p c1751p = this._inclusionChecker;
            if (c1751p == null || !c1751p.m3910a(strMo1175T)) {
                AbstractC1204t abstractC1204tM3013c = c1171w.m3013c(strMo1175T);
                if (abstractC1204tM3013c == null) {
                    Object objMo1910a = this._keyDeserializer.mo1910a(abstractC0718i, strMo1175T);
                    try {
                        if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                            objDeserialize = abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                        } else if (!this._skipNullValues) {
                            objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
                        }
                        c1143aM3014d.f3960h = new C1174z(c1143aM3014d.f3960h, objDeserialize, objMo1910a, 0);
                    } catch (Exception e3) {
                        wrapAndThrow(abstractC0718i, e3, this._containerType.f2036e, strMo1175T);
                        return null;
                    }
                } else if (c1143aM3014d.m2977b(abstractC1204tM3013c, abstractC1204tM3013c.m3079j(abstractC0545m, abstractC0718i))) {
                    abstractC0545m.mo1177V();
                    try {
                        return _readAndBind(abstractC0545m, abstractC0718i, (Map) c1171w.m3012a(abstractC0718i, c1143aM3014d));
                    } catch (Exception e4) {
                        return (Map) wrapAndThrow(abstractC0718i, e4, this._containerType.f2036e, strMo1175T);
                    }
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            strMo1175T = abstractC0545m.mo1175T();
        }
        try {
            return (Map) c1171w.m3012a(abstractC0718i, c1143aM3014d);
        } catch (Exception e5) {
            wrapAndThrow(abstractC0718i, e5, this._containerType.f2036e, strMo1175T);
            return null;
        }
    }

    public final boolean _isStdKeyDeser(AbstractC0721l abstractC0721l, AbstractC0730u abstractC0730u) {
        AbstractC0721l abstractC0721lMo1877l;
        if (abstractC0730u == null || (abstractC0721lMo1877l = abstractC0721l.mo1877l()) == null) {
            return true;
        }
        Class cls = abstractC0721lMo1877l.f2036e;
        return (cls == String.class || cls == Object.class) && isDefaultKeyDeserializer(abstractC0730u);
    }

    public final Map<Object, Object> _readAndBind(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<Object, Object> map) throws IOException {
        String strMo1188d;
        AbstractC0730u abstractC0730u;
        String str;
        Object obj;
        Object objDeserialize;
        AbstractC0545m abstractC0545m2 = abstractC0545m;
        AbstractC0730u abstractC0730u2 = this._keyDeserializer;
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        boolean z3 = abstractC0722m.getObjectIdReader() != null;
        C1191g c1191g = z3 ? new C1191g(this._containerType.mo1874i().f2036e, map) : null;
        if (abstractC0545m.mo1173R()) {
            strMo1188d = abstractC0545m.mo1175T();
        } else {
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            EnumC0548p enumC0548p = EnumC0548p.FIELD_NAME;
            if (enumC0548pMo1190e != enumC0548p) {
                if (enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
                    return map;
                }
                abstractC0718i.m1844W(this, enumC0548p, null, new Object[0]);
                throw null;
            }
            strMo1188d = abstractC0545m.mo1188d();
        }
        String strMo1175T = strMo1188d;
        while (strMo1175T != null) {
            Object objMo1910a = abstractC0730u2.mo1910a(abstractC0718i, strMo1175T);
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            C1751p c1751p = this._inclusionChecker;
            if (c1751p == null || !c1751p.m3910a(strMo1175T)) {
                try {
                    if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                        objDeserialize = abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m2, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m2, abstractC0718i, abstractC1398g);
                    } else if (!this._skipNullValues) {
                        objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
                    }
                } catch (C1205u e3) {
                    e = e3;
                    obj = objMo1910a;
                    abstractC0730u = abstractC0730u2;
                } catch (Exception e4) {
                    e = e4;
                    abstractC0730u = abstractC0730u2;
                    str = strMo1175T;
                }
                if (z3) {
                    c1191g.m3041a(objMo1910a, objDeserialize);
                } else {
                    Object objPut = map.put(objMo1910a, objDeserialize);
                    if (objPut != null) {
                        obj = objMo1910a;
                        abstractC0730u = abstractC0730u2;
                        str = strMo1175T;
                        try {
                            _squashDups(abstractC0718i, map, objMo1910a, objPut, objDeserialize);
                        } catch (C1205u e5) {
                            e = e5;
                            handleUnresolvedReference(abstractC0718i, c1191g, obj, e);
                        } catch (Exception e6) {
                            e = e6;
                            wrapAndThrow(abstractC0718i, e, map, str);
                        }
                    }
                    strMo1175T = abstractC0545m.mo1175T();
                    abstractC0545m2 = abstractC0545m;
                    abstractC0730u2 = abstractC0730u;
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            abstractC0730u = abstractC0730u2;
            strMo1175T = abstractC0545m.mo1175T();
            abstractC0545m2 = abstractC0545m;
            abstractC0730u2 = abstractC0730u;
        }
        return map;
    }

    public final Map<Object, Object> _readAndBindStringKeyMap(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<Object, Object> map) throws IOException {
        String strMo1188d;
        Object objDeserialize;
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        boolean z3 = abstractC0722m.getObjectIdReader() != null;
        C1191g c1191g = z3 ? new C1191g(this._containerType.mo1874i().f2036e, map) : null;
        if (abstractC0545m.mo1173R()) {
            strMo1188d = abstractC0545m.mo1175T();
        } else {
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
                return map;
            }
            EnumC0548p enumC0548p = EnumC0548p.FIELD_NAME;
            if (enumC0548pMo1190e != enumC0548p) {
                abstractC0718i.m1844W(this, enumC0548p, null, new Object[0]);
                throw null;
            }
            strMo1188d = abstractC0545m.mo1188d();
        }
        while (strMo1188d != null) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            C1751p c1751p = this._inclusionChecker;
            if (c1751p == null || !c1751p.m3910a(strMo1188d)) {
                try {
                    if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                        objDeserialize = abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                    } else if (!this._skipNullValues) {
                        objDeserialize = this._nullProvider.getNullValue(abstractC0718i);
                    }
                    Object obj = objDeserialize;
                    if (z3) {
                        c1191g.m3041a(strMo1188d, obj);
                    } else {
                        Object objPut = map.put(strMo1188d, obj);
                        if (objPut != null) {
                            _squashDups(abstractC0718i, map, strMo1188d, objPut, obj);
                        }
                    }
                } catch (C1205u e3) {
                    handleUnresolvedReference(abstractC0718i, c1191g, strMo1188d, e3);
                } catch (Exception e4) {
                    wrapAndThrow(abstractC0718i, e4, map, strMo1188d);
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            strMo1188d = abstractC0545m.mo1175T();
        }
        return map;
    }

    public final void _readAndUpdate(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<Object, Object> map) throws IOException {
        String strMo1188d;
        AbstractC0730u abstractC0730u = this._keyDeserializer;
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        if (abstractC0545m.mo1173R()) {
            strMo1188d = abstractC0545m.mo1175T();
        } else {
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
                return;
            }
            EnumC0548p enumC0548p = EnumC0548p.FIELD_NAME;
            if (enumC0548pMo1190e != enumC0548p) {
                abstractC0718i.m1844W(this, enumC0548p, null, new Object[0]);
                throw null;
            }
            strMo1188d = abstractC0545m.mo1188d();
        }
        while (strMo1188d != null) {
            Object objMo1910a = abstractC0730u.mo1910a(abstractC0718i, strMo1188d);
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            C1751p c1751p = this._inclusionChecker;
            if (c1751p == null || !c1751p.m3910a(strMo1188d)) {
                try {
                    if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                        Object obj = map.get(objMo1910a);
                        Object objDeserialize = obj != null ? abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i, obj) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g, obj) : abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                        if (objDeserialize != obj) {
                            map.put(objMo1910a, objDeserialize);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(objMo1910a, this._nullProvider.getNullValue(abstractC0718i));
                    }
                } catch (Exception e3) {
                    wrapAndThrow(abstractC0718i, e3, map, strMo1188d);
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            strMo1188d = abstractC0545m.mo1175T();
        }
    }

    public final void _readAndUpdateStringKeyMap(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<Object, Object> map) throws IOException {
        String strMo1188d;
        AbstractC0722m abstractC0722m = this._valueDeserializer;
        AbstractC1398g abstractC1398g = this._valueTypeDeserializer;
        if (abstractC0545m.mo1173R()) {
            strMo1188d = abstractC0545m.mo1175T();
        } else {
            EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
            if (enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
                return;
            }
            EnumC0548p enumC0548p = EnumC0548p.FIELD_NAME;
            if (enumC0548pMo1190e != enumC0548p) {
                abstractC0718i.m1844W(this, enumC0548p, null, new Object[0]);
                throw null;
            }
            strMo1188d = abstractC0545m.mo1188d();
        }
        while (strMo1188d != null) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            C1751p c1751p = this._inclusionChecker;
            if (c1751p == null || !c1751p.m3910a(strMo1188d)) {
                try {
                    if (enumC0548pMo1177V != EnumC0548p.VALUE_NULL) {
                        Object obj = map.get(strMo1188d);
                        Object objDeserialize = obj != null ? abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i, obj) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g, obj) : abstractC1398g == null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0722m.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
                        if (objDeserialize != obj) {
                            map.put(strMo1188d, objDeserialize);
                        }
                    } else if (!this._skipNullValues) {
                        map.put(strMo1188d, this._nullProvider.getNullValue(abstractC0718i));
                    }
                } catch (Exception e3) {
                    wrapAndThrow(abstractC0718i, e3, map, strMo1188d);
                }
            } else {
                abstractC0545m.mo1187c0();
            }
            strMo1188d = abstractC0545m.mo1175T();
        }
    }

    public void _squashDups(AbstractC0718i abstractC0718i, Map<Object, Object> map, Object obj, Object obj2, Object obj3) {
        if (this._checkDupSquash && abstractC0718i.m1832J(EnumC0552t.f1335f)) {
            if (obj2 instanceof List) {
                ((List) obj2).add(obj3);
                map.put(obj, obj2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj2);
                arrayList.add(obj3);
                map.put(obj, arrayList);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b4 A[PHI: r0
      0x00b4: PHI (r0v9 java.util.Set<java.lang.String>) = (r0v8 java.util.Set<java.lang.String>), (r0v8 java.util.Set<java.lang.String>), (r0v10 java.util.Set<java.lang.String>) binds: [B:17:0x0041, B:19:0x0047, B:36:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0722m createContextual(p069X0.AbstractC0718i r10, p069X0.InterfaceC0714e r11) throws p078a1.C0850b {
        /*
            r9 = this;
            X0.u r0 = r9._keyDeserializer
            if (r0 != 0) goto Le
            X0.l r0 = r9._containerType
            X0.l r0 = r0.mo1877l()
            X0.u r0 = r10.m1854s(r0)
        Le:
            r2 = r0
            X0.m r0 = r9._valueDeserializer
            if (r11 == 0) goto L17
            X0.m r0 = r9.findConvertingContentDeserializer(r10, r11, r0)
        L17:
            X0.l r1 = r9._containerType
            X0.l r1 = r1.mo1874i()
            if (r0 != 0) goto L25
            X0.m r0 = r10.m1852q(r1, r11)
        L23:
            r4 = r0
            goto L2a
        L25:
            X0.m r0 = r10.m1823A(r0, r11, r1)
            goto L23
        L2a:
            g1.g r0 = r9._valueTypeDeserializer
            if (r0 == 0) goto L32
            g1.g r0 = r0.mo3404f(r11)
        L32:
            r3 = r0
            java.util.Set<java.lang.String> r0 = r9._ignorableProperties
            java.util.Set<java.lang.String> r1 = r9._includableProperties
            X0.h r5 = r10.f1998g
            X0.b r5 = r5.m2149d()
            boolean r6 = com.fasterxml.jackson.databind.deser.std.StdDeserializer._neitherNull(r5, r11)
            if (r6 == 0) goto Lb4
            b1.l r6 = r11.mo1805c()
            if (r6 == 0) goto Lb4
            M0.w r7 = r5.mo1737I(r6)
            if (r7 == 0) goto L82
            boolean r8 = r7.f1180h
            if (r8 == 0) goto L58
            java.util.Set r7 = java.util.Collections.emptySet()
            goto L5a
        L58:
            java.util.Set r7 = r7.f1177e
        L5a:
            boolean r8 = r7.isEmpty()
            if (r8 != 0) goto L82
            if (r0 != 0) goto L68
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            goto L6e
        L68:
            java.util.HashSet r8 = new java.util.HashSet
            r8.<init>(r0)
            r0 = r8
        L6e:
            java.util.Iterator r7 = r7.iterator()
        L72:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L82
            java.lang.Object r8 = r7.next()
            java.lang.String r8 = (java.lang.String) r8
            r0.add(r8)
            goto L72
        L82:
            M0.C r5 = r5.mo1740L(r6)
            java.util.Set r5 = r5.f1101e
            if (r5 == 0) goto Lb4
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            if (r1 != 0) goto L97
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>(r5)
            goto Lb1
        L97:
            java.util.Iterator r5 = r5.iterator()
        L9b:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto Lb1
            java.lang.Object r7 = r5.next()
            java.lang.String r7 = (java.lang.String) r7
            boolean r8 = r1.contains(r7)
            if (r8 == 0) goto L9b
            r6.add(r7)
            goto L9b
        Lb1:
            r7 = r6
            r6 = r0
            goto Lb6
        Lb4:
            r6 = r0
            r7 = r1
        Lb6:
            com.fasterxml.jackson.databind.deser.m r5 = r9.findContentNullProvider(r10, r11, r4)
            r1 = r9
            com.fasterxml.jackson.databind.deser.std.MapDeserializer r10 = r1.withResolved(r2, r3, r4, r5, r6, r7)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.MapDeserializer.createContextual(X0.i, X0.e):X0.m");
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return abstractC1398g.mo3402d(abstractC0545m, abstractC0718i);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public AbstractC0722m getContentDeserializer() {
        return this._valueDeserializer;
    }

    public final Class<?> getMapClass() {
        return this._containerType.f2036e;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC1208x getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public AbstractC0721l getValueType() {
        return this._containerType;
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return this._valueDeserializer == null && this._keyDeserializer == null && this._valueTypeDeserializer == null && this._ignorableProperties == null && this._includableProperties == null;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5891g;
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1179n
    public void resolve(AbstractC0718i abstractC0718i) throws C0850b {
        if (this._valueInstantiator.mo3061k()) {
            AbstractC1208x abstractC1208x = this._valueInstantiator;
            C0717h c0717h = abstractC0718i.f1998g;
            AbstractC0721l abstractC0721lMo3048C = abstractC1208x.mo3048C();
            if (abstractC0721lMo3048C == null) {
                abstractC0718i.mo1713k(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
                throw null;
            }
            this._delegateDeserializer = findDeserializer(abstractC0718i, abstractC0721lMo3048C, null);
        } else if (this._valueInstantiator.mo3060i()) {
            AbstractC1208x abstractC1208x2 = this._valueInstantiator;
            C0717h c0717h2 = abstractC0718i.f1998g;
            AbstractC0721l abstractC0721lMo3073z = abstractC1208x2.mo3073z();
            if (abstractC0721lMo3073z == null) {
                abstractC0718i.mo1713k(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", this._containerType, this._valueInstantiator.getClass().getName()));
                throw null;
            }
            this._delegateDeserializer = findDeserializer(abstractC0718i, abstractC0721lMo3073z, null);
        }
        if (this._valueInstantiator.mo3058g()) {
            AbstractC1204t[] abstractC1204tArrMo3039D = this._valueInstantiator.mo3039D(abstractC0718i.f1998g);
            this._propertyBasedCreator = C1171w.m3011b(abstractC0718i, this._valueInstantiator, abstractC1204tArrMo3039D, abstractC0718i.f1998g.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
        }
        this._standardStringKey = _isStdKeyDeser(this._containerType, this._keyDeserializer);
    }

    @Deprecated
    public void setIgnorableProperties(String[] strArr) {
        HashSet hashSetM3868a = (strArr == null || strArr.length == 0) ? null : C1739d.m3868a(strArr);
        this._ignorableProperties = hashSetM3868a;
        this._inclusionChecker = AbstractC0473V.m991C(hashSetM3868a, this._includableProperties);
    }

    public void setIncludableProperties(Set<String> set) {
        this._includableProperties = set;
        this._inclusionChecker = AbstractC0473V.m991C(this._ignorableProperties, set);
    }

    public MapDeserializer withResolved(AbstractC0730u abstractC0730u, AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m, Set<String> set) {
        return withResolved(abstractC0730u, abstractC1398g, abstractC0722m, interfaceC1178m, set, this._includableProperties);
    }

    public MapDeserializer withResolved(AbstractC0730u abstractC0730u, AbstractC1398g abstractC1398g, AbstractC0722m abstractC0722m, InterfaceC1178m interfaceC1178m, Set<String> set, Set<String> set2) {
        return (this._keyDeserializer == abstractC0730u && this._valueDeserializer == abstractC0722m && this._valueTypeDeserializer == abstractC1398g && this._nullProvider == interfaceC1178m && this._ignorableProperties == set && this._includableProperties == set2) ? this : new MapDeserializer(this, abstractC0730u, abstractC0722m, abstractC1398g, interfaceC1178m, set, set2);
    }

    @Override // p069X0.AbstractC0722m
    public Map<Object, Object> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingCreator(abstractC0545m, abstractC0718i);
        }
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        if (abstractC0722m != null) {
            return (Map) this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
        }
        if (this._hasDefaultCreator) {
            int iMo1191f = abstractC0545m.mo1191f();
            if (iMo1191f != 1 && iMo1191f != 2) {
                if (iMo1191f == 3) {
                    return _deserializeFromArray(abstractC0545m, abstractC0718i);
                }
                if (iMo1191f != 5) {
                    if (iMo1191f == 6) {
                        return _deserializeFromString(abstractC0545m, abstractC0718i);
                    }
                    abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                    throw null;
                }
            }
            Map<Object, Object> map = (Map) this._valueInstantiator.mo3007v(abstractC0718i);
            if (this._standardStringKey) {
                return _readAndBindStringKeyMap(abstractC0545m, abstractC0718i, map);
            }
            return _readAndBind(abstractC0545m, abstractC0718i, map);
        }
        abstractC0718i.m1860y(getMapClass(), getValueInstantiator(), "no default constructor found", new Object[0]);
        throw null;
    }

    public void setIgnorableProperties(Set<String> set) {
        if (set == null || set.isEmpty()) {
            set = null;
        }
        this._ignorableProperties = set;
        this._inclusionChecker = AbstractC0473V.m991C(set, this._includableProperties);
    }

    public MapDeserializer(MapDeserializer mapDeserializer) {
        super(mapDeserializer);
        this._keyDeserializer = mapDeserializer._keyDeserializer;
        this._valueDeserializer = mapDeserializer._valueDeserializer;
        this._valueTypeDeserializer = mapDeserializer._valueTypeDeserializer;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = mapDeserializer._ignorableProperties;
        this._includableProperties = mapDeserializer._includableProperties;
        this._inclusionChecker = mapDeserializer._inclusionChecker;
        this._standardStringKey = mapDeserializer._standardStringKey;
        this._checkDupSquash = mapDeserializer._checkDupSquash;
    }

    @Override // p069X0.AbstractC0722m
    public Map<Object, Object> deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<Object, Object> map) throws IOException {
        abstractC0545m.mo1183a0(map);
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e != EnumC0548p.START_OBJECT && enumC0548pMo1190e != EnumC0548p.FIELD_NAME) {
            abstractC0718i.m1825C(abstractC0545m, getMapClass());
            throw null;
        }
        if (this._standardStringKey) {
            _readAndUpdateStringKeyMap(abstractC0545m, abstractC0718i, map);
            return map;
        }
        _readAndUpdate(abstractC0545m, abstractC0718i, map);
        return map;
    }

    public MapDeserializer(MapDeserializer mapDeserializer, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m, Set<String> set) {
        this(mapDeserializer, abstractC0730u, abstractC0722m, abstractC1398g, interfaceC1178m, set, null);
    }

    public MapDeserializer(MapDeserializer mapDeserializer, AbstractC0730u abstractC0730u, AbstractC0722m abstractC0722m, AbstractC1398g abstractC1398g, InterfaceC1178m interfaceC1178m, Set<String> set, Set<String> set2) {
        super(mapDeserializer, interfaceC1178m, mapDeserializer._unwrapSingle);
        this._keyDeserializer = abstractC0730u;
        this._valueDeserializer = abstractC0722m;
        this._valueTypeDeserializer = abstractC1398g;
        this._valueInstantiator = mapDeserializer._valueInstantiator;
        this._propertyBasedCreator = mapDeserializer._propertyBasedCreator;
        this._delegateDeserializer = mapDeserializer._delegateDeserializer;
        this._hasDefaultCreator = mapDeserializer._hasDefaultCreator;
        this._ignorableProperties = set;
        this._includableProperties = set2;
        this._inclusionChecker = AbstractC0473V.m991C(set, set2);
        this._standardStringKey = _isStdKeyDeser(this._containerType, abstractC0730u);
        this._checkDupSquash = mapDeserializer._checkDupSquash;
    }
}

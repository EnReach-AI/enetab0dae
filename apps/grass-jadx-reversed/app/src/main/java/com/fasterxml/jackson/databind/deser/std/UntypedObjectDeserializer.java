package com.fasterxml.jackson.databind.deser.std;

import com.facebook.C1106c;
import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.InterfaceC1179n;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p042N0.EnumC0552t;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p071Y0.InterfaceC0738b;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.C1670l;
import p114l1.C1675q;
import p114l1.EnumC1664f;
import p118m1.AbstractC1745j;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
public class UntypedObjectDeserializer extends StdDeserializer<Object> implements InterfaceC1179n, InterfaceC1139f {
    protected static final Object[] NO_OBJECTS = new Object[0];
    private static final long serialVersionUID = 1;
    protected AbstractC0722m _listDeserializer;
    protected AbstractC0721l _listType;
    protected AbstractC0722m _mapDeserializer;
    protected AbstractC0721l _mapType;
    protected final boolean _nonMerging;
    protected AbstractC0722m _numberDeserializer;
    protected AbstractC0722m _stringDeserializer;

    @InterfaceC0738b
    @Deprecated
    public static class Vanilla extends StdDeserializer<Object> {
        private static final long serialVersionUID = 1;
        public static final Vanilla std = new Vanilla();
        protected final boolean _nonMerging;

        public Vanilla() {
            this(false);
        }

        private void _squashDups(Map<String, Object> map, String str, Object obj, Object obj2) {
            if (obj instanceof List) {
                ((List) obj).add(obj2);
                map.put(str, obj);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(obj);
                arrayList.add(obj2);
                map.put(str, arrayList);
            }
        }

        public static Vanilla instance(boolean z3) {
            return z3 ? new Vanilla(true) : std;
        }

        public Object _mapObjectWithDups(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<String, Object> map, String str, Object obj, Object obj2, String str2) throws C0850b {
            boolean zM1832J = abstractC0718i.m1832J(EnumC0552t.f1335f);
            if (zM1832J) {
                _squashDups(map, str, obj, obj2);
            }
            while (str2 != null) {
                abstractC0545m.mo1177V();
                Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
                Object objPut = map.put(str2, objDeserialize);
                if (objPut != null && zM1832J) {
                    _squashDups(map, str2, objPut, objDeserialize);
                }
                str2 = abstractC0545m.mo1175T();
            }
            return map;
        }

        @Override // p069X0.AbstractC0722m
        public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            switch (abstractC0545m.mo1191f()) {
                case 1:
                    if (abstractC0545m.mo1177V() == EnumC0548p.END_OBJECT) {
                        return new LinkedHashMap(2);
                    }
                    break;
                case 2:
                    return new LinkedHashMap(2);
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    return abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY ? abstractC0718i.m1833K(EnumC0719j.USE_JAVA_ARRAY_FOR_JSON_ARRAY) ? UntypedObjectDeserializer.NO_OBJECTS : new ArrayList(2) : abstractC0718i.m1833K(EnumC0719j.USE_JAVA_ARRAY_FOR_JSON_ARRAY) ? mapArrayToArray(abstractC0545m, abstractC0718i) : mapArray(abstractC0545m, abstractC0718i);
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                default:
                    abstractC0718i.m1825C(abstractC0545m, Object.class);
                    throw null;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    return abstractC0545m.mo1157B();
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    return abstractC0718i.m1830H(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(abstractC0545m, abstractC0718i) : abstractC0545m.mo1207v();
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    return abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) ? abstractC0545m.mo1200o() : abstractC0545m.mo1207v();
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    return Boolean.TRUE;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    return Boolean.FALSE;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    return null;
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                    return abstractC0545m.mo1202q();
            }
            return mapObject(abstractC0545m, abstractC0718i);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
        public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) throws C0850b {
            int iMo1191f = abstractC0545m.mo1191f();
            if (iMo1191f != 1 && iMo1191f != 3) {
                switch (iMo1191f) {
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                        break;
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                        return abstractC0545m.mo1157B();
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        return abstractC0718i.m1833K(EnumC0719j.USE_BIG_INTEGER_FOR_INTS) ? abstractC0545m.mo1192g() : abstractC0545m.mo1207v();
                    case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                        return abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) ? abstractC0545m.mo1200o() : abstractC0545m.mo1207v();
                    case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                        return Boolean.TRUE;
                    case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                        return Boolean.FALSE;
                    case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                        return null;
                    case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                        return abstractC0545m.mo1202q();
                    default:
                        abstractC0718i.m1825C(abstractC0545m, Object.class);
                        throw null;
                }
            }
            return abstractC1398g.mo3400b(abstractC0545m, abstractC0718i);
        }

        @Override // p069X0.AbstractC0722m
        public EnumC1664f logicalType() {
            return EnumC1664f.f5893i;
        }

        public Object mapArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
            if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(objDeserialize);
                return arrayList;
            }
            C1106c c1106cM1835M = abstractC0718i.m1835M();
            Object[] objArrM2885g = c1106cM1835M.m2885g();
            objArrM2885g[0] = objDeserialize;
            int i3 = 1;
            int i4 = 1;
            while (true) {
                Object objDeserialize2 = deserialize(abstractC0545m, abstractC0718i);
                i3++;
                if (i4 >= objArrM2885g.length) {
                    objArrM2885g = c1106cM1835M.m2881c(objArrM2885g);
                    i4 = 0;
                }
                int i5 = i4 + 1;
                objArrM2885g[i4] = objDeserialize2;
                if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
                    ArrayList arrayList2 = new ArrayList(i3);
                    c1106cM1835M.m2882d(objArrM2885g, i5, arrayList2);
                    abstractC0718i.m1845X(c1106cM1835M);
                    return arrayList2;
                }
                i4 = i5;
            }
        }

        public Object[] mapArrayToArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            C1106c c1106cM1835M = abstractC0718i.m1835M();
            Object[] objArrM2885g = c1106cM1835M.m2885g();
            int i3 = 0;
            while (true) {
                Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
                if (i3 >= objArrM2885g.length) {
                    objArrM2885g = c1106cM1835M.m2881c(objArrM2885g);
                    i3 = 0;
                }
                int i4 = i3 + 1;
                objArrM2885g[i3] = objDeserialize;
                if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
                    Object[] objArrM2883e = c1106cM1835M.m2883e(objArrM2885g, i4);
                    abstractC0718i.m1845X(c1106cM1835M);
                    return objArrM2883e;
                }
                i3 = i4;
            }
        }

        public Object mapObject(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            String strMo1188d = abstractC0545m.mo1188d();
            abstractC0545m.mo1177V();
            Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
            String strMo1175T = abstractC0545m.mo1175T();
            if (strMo1175T == null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap(2);
                linkedHashMap.put(strMo1188d, objDeserialize);
                return linkedHashMap;
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put(strMo1188d, objDeserialize);
            String strMo1175T2 = strMo1175T;
            do {
                abstractC0545m.mo1177V();
                Object objDeserialize2 = deserialize(abstractC0545m, abstractC0718i);
                Object objPut = linkedHashMap2.put(strMo1175T2, objDeserialize2);
                if (objPut != null) {
                    return _mapObjectWithDups(abstractC0545m, abstractC0718i, linkedHashMap2, strMo1175T2, objPut, objDeserialize2, abstractC0545m.mo1175T());
                }
                strMo1175T2 = abstractC0545m.mo1175T();
            } while (strMo1175T2 != null);
            return linkedHashMap2;
        }

        @Override // p069X0.AbstractC0722m
        public Boolean supportsUpdate(C0717h c0717h) {
            if (this._nonMerging) {
                return Boolean.FALSE;
            }
            return null;
        }

        public Vanilla(boolean z3) {
            super((Class<?>) Object.class);
            this._nonMerging = z3;
        }

        @Override // p069X0.AbstractC0722m
        public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) throws C0850b {
            Object objDeserialize;
            if (this._nonMerging) {
                return deserialize(abstractC0545m, abstractC0718i);
            }
            int iMo1191f = abstractC0545m.mo1191f();
            if (iMo1191f != 1) {
                if (iMo1191f != 2) {
                    if (iMo1191f == 3) {
                        if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
                            return obj;
                        }
                        if (obj instanceof Collection) {
                            Collection collection = (Collection) obj;
                            do {
                                collection.add(deserialize(abstractC0545m, abstractC0718i));
                            } while (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY);
                        }
                        return deserialize(abstractC0545m, abstractC0718i);
                    }
                    if (iMo1191f != 4) {
                        if (iMo1191f == 5) {
                        }
                        return deserialize(abstractC0545m, abstractC0718i);
                    }
                }
                return obj;
            }
            if (abstractC0545m.mo1177V() == EnumC0548p.END_OBJECT) {
                return obj;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                String strMo1188d = abstractC0545m.mo1188d();
                do {
                    abstractC0545m.mo1177V();
                    Object obj2 = map.get(strMo1188d);
                    if (obj2 != null) {
                        objDeserialize = deserialize(abstractC0545m, abstractC0718i, obj2);
                    } else {
                        objDeserialize = deserialize(abstractC0545m, abstractC0718i);
                    }
                    if (objDeserialize != obj2) {
                        map.put(strMo1188d, objDeserialize);
                    }
                    strMo1188d = abstractC0545m.mo1175T();
                } while (strMo1188d != null);
                return obj;
            }
            return deserialize(abstractC0545m, abstractC0718i);
        }
    }

    @Deprecated
    public UntypedObjectDeserializer() {
        this((AbstractC0721l) null, (AbstractC0721l) null);
    }

    private void _squashDups(Map<String, Object> map, String str, Object obj, Object obj2) {
        if (obj instanceof List) {
            ((List) obj).add(obj2);
            map.put(str, obj);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(obj);
            arrayList.add(obj2);
            map.put(str, arrayList);
        }
    }

    public AbstractC0722m _clearIfStdImpl(AbstractC0722m abstractC0722m) {
        if (AbstractC1745j.m3899v(abstractC0722m)) {
            return null;
        }
        return abstractC0722m;
    }

    public AbstractC0722m _findCustomDeser(AbstractC0718i abstractC0718i, AbstractC0721l abstractC0721l) {
        return abstractC0718i.f1996e.m3020f(abstractC0718i, abstractC0718i.f1997f, abstractC0721l);
    }

    public Object _mapObjectWithDups(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<String, Object> map, String str, Object obj, Object obj2, String str2) throws C0850b {
        boolean zM1832J = abstractC0718i.m1832J(EnumC0552t.f1335f);
        if (zM1832J) {
            _squashDups(map, str, obj, obj2);
        }
        while (str2 != null) {
            abstractC0545m.mo1177V();
            Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
            Object objPut = map.put(str2, objDeserialize);
            if (objPut != null && zM1832J) {
                _squashDups(map, str, objPut, objDeserialize);
            }
            str2 = abstractC0545m.mo1175T();
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0722m createContextual(p069X0.AbstractC0718i r3, p069X0.InterfaceC0714e r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L1f
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            X0.h r3 = r3.f1998g
            Z0.h r3 = r3.f2490m
            java.util.Map r0 = r3.f2447e
            if (r0 != 0) goto Ld
            goto L15
        Ld:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            java.lang.Object r0 = r0.get(r1)
            Z0.g r0 = (p074Z0.C0821g) r0
        L15:
            java.lang.Boolean r3 = r3.f2451i
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L1f
            r3 = 1
            goto L20
        L1f:
            r3 = 0
        L20:
            X0.m r4 = r2._stringDeserializer
            if (r4 != 0) goto L3d
            X0.m r4 = r2._numberDeserializer
            if (r4 != 0) goto L3d
            X0.m r4 = r2._mapDeserializer
            if (r4 != 0) goto L3d
            X0.m r4 = r2._listDeserializer
            if (r4 != 0) goto L3d
            java.lang.Class r4 = r2.getClass()
            java.lang.Class<com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer> r0 = com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.class
            if (r4 != r0) goto L3d
            com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializerNR r3 = com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializerNR.instance(r3)
            return r3
        L3d:
            boolean r4 = r2._nonMerging
            if (r3 == r4) goto L47
            com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer r4 = new com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer
            r4.<init>(r2, r3)
            return r4
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.createContextual(X0.i, X0.e):X0.m");
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        switch (abstractC0545m.mo1191f()) {
            case 1:
            case 2:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                AbstractC0722m abstractC0722m = this._mapDeserializer;
                return abstractC0722m != null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : mapObject(abstractC0545m, abstractC0718i);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                if (abstractC0718i.m1833K(EnumC0719j.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                    return mapArrayToArray(abstractC0545m, abstractC0718i);
                }
                AbstractC0722m abstractC0722m2 = this._listDeserializer;
                return abstractC0722m2 != null ? abstractC0722m2.deserialize(abstractC0545m, abstractC0718i) : mapArray(abstractC0545m, abstractC0718i);
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
            default:
                abstractC0718i.m1825C(abstractC0545m, Object.class);
                throw null;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                AbstractC0722m abstractC0722m3 = this._stringDeserializer;
                return abstractC0722m3 != null ? abstractC0722m3.deserialize(abstractC0545m, abstractC0718i) : abstractC0545m.mo1157B();
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                AbstractC0722m abstractC0722m4 = this._numberDeserializer;
                return abstractC0722m4 != null ? abstractC0722m4.deserialize(abstractC0545m, abstractC0718i) : abstractC0718i.m1830H(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(abstractC0545m, abstractC0718i) : abstractC0545m.mo1207v();
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                AbstractC0722m abstractC0722m5 = this._numberDeserializer;
                return abstractC0722m5 != null ? abstractC0722m5.deserialize(abstractC0545m, abstractC0718i) : abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) ? abstractC0545m.mo1200o() : abstractC0545m.mo1207v();
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return Boolean.TRUE;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return Boolean.FALSE;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                return null;
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return abstractC0545m.mo1202q();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f != 1 && iMo1191f != 3) {
            switch (iMo1191f) {
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    AbstractC0722m abstractC0722m = this._stringDeserializer;
                    return abstractC0722m != null ? abstractC0722m.deserialize(abstractC0545m, abstractC0718i) : abstractC0545m.mo1157B();
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    AbstractC0722m abstractC0722m2 = this._numberDeserializer;
                    return abstractC0722m2 != null ? abstractC0722m2.deserialize(abstractC0545m, abstractC0718i) : abstractC0718i.m1830H(StdDeserializer.F_MASK_INT_COERCIONS) ? _coerceIntegral(abstractC0545m, abstractC0718i) : abstractC0545m.mo1207v();
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    AbstractC0722m abstractC0722m3 = this._numberDeserializer;
                    return abstractC0722m3 != null ? abstractC0722m3.deserialize(abstractC0545m, abstractC0718i) : abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) ? abstractC0545m.mo1200o() : abstractC0545m.mo1207v();
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    return Boolean.TRUE;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    return Boolean.FALSE;
                case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                    return null;
                case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                    return abstractC0545m.mo1202q();
                default:
                    abstractC0718i.m1825C(abstractC0545m, Object.class);
                    throw null;
            }
        }
        return abstractC1398g.mo3400b(abstractC0545m, abstractC0718i);
    }

    @Override // p069X0.AbstractC0722m
    public boolean isCachable() {
        return true;
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5893i;
    }

    public Object mapArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
        EnumC0548p enumC0548p = EnumC0548p.END_ARRAY;
        int i3 = 2;
        if (enumC0548pMo1177V == enumC0548p) {
            return new ArrayList(2);
        }
        Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
        if (abstractC0545m.mo1177V() == enumC0548p) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(objDeserialize);
            return arrayList;
        }
        Object objDeserialize2 = deserialize(abstractC0545m, abstractC0718i);
        if (abstractC0545m.mo1177V() == enumC0548p) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(objDeserialize);
            arrayList2.add(objDeserialize2);
            return arrayList2;
        }
        C1106c c1106cM1835M = abstractC0718i.m1835M();
        Object[] objArrM2885g = c1106cM1835M.m2885g();
        objArrM2885g[0] = objDeserialize;
        objArrM2885g[1] = objDeserialize2;
        int i4 = 2;
        while (true) {
            Object objDeserialize3 = deserialize(abstractC0545m, abstractC0718i);
            i3++;
            if (i4 >= objArrM2885g.length) {
                objArrM2885g = c1106cM1835M.m2881c(objArrM2885g);
                i4 = 0;
            }
            int i5 = i4 + 1;
            objArrM2885g[i4] = objDeserialize3;
            if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
                ArrayList arrayList3 = new ArrayList(i3);
                c1106cM1835M.m2882d(objArrM2885g, i5, arrayList3);
                abstractC0718i.m1845X(c1106cM1835M);
                return arrayList3;
            }
            i4 = i5;
        }
    }

    public Object[] mapArrayToArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
            return NO_OBJECTS;
        }
        C1106c c1106cM1835M = abstractC0718i.m1835M();
        Object[] objArrM2885g = c1106cM1835M.m2885g();
        int i3 = 0;
        while (true) {
            Object objDeserialize = deserialize(abstractC0545m, abstractC0718i);
            if (i3 >= objArrM2885g.length) {
                objArrM2885g = c1106cM1835M.m2881c(objArrM2885g);
                i3 = 0;
            }
            int i4 = i3 + 1;
            objArrM2885g[i3] = objDeserialize;
            if (abstractC0545m.mo1177V() == EnumC0548p.END_ARRAY) {
                Object[] objArrM2883e = c1106cM1835M.m2883e(objArrM2885g, i4);
                abstractC0718i.m1845X(c1106cM1835M);
                return objArrM2883e;
            }
            i3 = i4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mapObject(p042N0.AbstractC0545m r12, p069X0.AbstractC0718i r13) throws p078a1.C0850b {
        /*
            r11 = this;
            N0.p r0 = r12.mo1190e()
            N0.p r1 = p042N0.EnumC0548p.START_OBJECT
            if (r0 != r1) goto Le
            java.lang.String r0 = r12.mo1175T()
        Lc:
            r7 = r0
            goto L1d
        Le:
            N0.p r1 = p042N0.EnumC0548p.FIELD_NAME
            if (r0 != r1) goto L17
            java.lang.String r0 = r12.mo1188d()
            goto Lc
        L17:
            N0.p r1 = p042N0.EnumC0548p.END_OBJECT
            r2 = 0
            if (r0 != r1) goto L9b
            r7 = r2
        L1d:
            r0 = 2
            if (r7 != 0) goto L26
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>(r0)
            return r12
        L26:
            r12.mo1177V()
            java.lang.Object r8 = r11.deserialize(r12, r13)
            java.lang.String r1 = r12.mo1175T()
            if (r1 != 0) goto L3c
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>(r0)
            r12.put(r7, r8)
            return r12
        L3c:
            r12.mo1177V()
            java.lang.Object r9 = r11.deserialize(r12, r13)
            java.lang.String r10 = r12.mo1175T()
            if (r10 != 0) goto L61
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r0 = 4
            r6.<init>(r0)
            r6.put(r7, r8)
            java.lang.Object r0 = r6.put(r1, r9)
            if (r0 == 0) goto L60
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r12 = r3._mapObjectWithDups(r4, r5, r6, r7, r8, r9, r10)
            return r12
        L60:
            return r6
        L61:
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            r6.put(r7, r8)
            java.lang.Object r0 = r6.put(r1, r9)
            if (r0 == 0) goto L77
            r3 = r11
            r4 = r12
            r5 = r13
            java.lang.Object r12 = r3._mapObjectWithDups(r4, r5, r6, r7, r8, r9, r10)
            return r12
        L77:
            r4 = r10
        L78:
            r12.mo1177V()
            java.lang.Object r7 = r11.deserialize(r12, r13)
            java.lang.Object r5 = r6.put(r4, r7)
            if (r5 == 0) goto L94
            java.lang.String r8 = r12.mo1175T()
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r6
            r6 = r7
            r7 = r8
            java.lang.Object r12 = r0._mapObjectWithDups(r1, r2, r3, r4, r5, r6, r7)
            return r12
        L94:
            java.lang.String r4 = r12.mo1175T()
            if (r4 != 0) goto L78
            return r6
        L9b:
            java.lang.Class r0 = r11.handledType()
            r13.m1825C(r12, r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.mapObject(N0.m, X0.i):java.lang.Object");
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1179n
    public void resolve(AbstractC0718i abstractC0718i) {
        AbstractC0721l abstractC0721lM1848m = abstractC0718i.m1848m(Object.class);
        AbstractC0721l abstractC0721lM1848m2 = abstractC0718i.m1848m(String.class);
        C1675q c1675qMo1711f = abstractC0718i.mo1711f();
        AbstractC0721l abstractC0721l = this._listType;
        if (abstractC0721l == null) {
            this._listDeserializer = _clearIfStdImpl(_findCustomDeser(abstractC0718i, c1675qMo1711f.m3777f(abstractC0721lM1848m, List.class)));
        } else {
            this._listDeserializer = _findCustomDeser(abstractC0718i, abstractC0721l);
        }
        AbstractC0721l abstractC0721l2 = this._mapType;
        if (abstractC0721l2 == null) {
            this._mapDeserializer = _clearIfStdImpl(_findCustomDeser(abstractC0718i, c1675qMo1711f.m3778h(Map.class, abstractC0721lM1848m2, abstractC0721lM1848m)));
        } else {
            this._mapDeserializer = _findCustomDeser(abstractC0718i, abstractC0721l2);
        }
        this._stringDeserializer = _clearIfStdImpl(_findCustomDeser(abstractC0718i, abstractC0721lM1848m2));
        this._numberDeserializer = _clearIfStdImpl(_findCustomDeser(abstractC0718i, c1675qMo1711f.m3780j(Number.class)));
        C1670l c1670lM3773n = C1675q.m3773n();
        this._mapDeserializer = abstractC0718i.m1823A(this._mapDeserializer, null, c1670lM3773n);
        this._listDeserializer = abstractC0718i.m1823A(this._listDeserializer, null, c1670lM3773n);
        this._stringDeserializer = abstractC0718i.m1823A(this._stringDeserializer, null, c1670lM3773n);
        this._numberDeserializer = abstractC0718i.m1823A(this._numberDeserializer, null, c1670lM3773n);
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return null;
    }

    public UntypedObjectDeserializer(AbstractC0721l abstractC0721l, AbstractC0721l abstractC0721l2) {
        super((Class<?>) Object.class);
        this._listType = abstractC0721l;
        this._mapType = abstractC0721l2;
        this._nonMerging = false;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, AbstractC0722m abstractC0722m, AbstractC0722m abstractC0722m2, AbstractC0722m abstractC0722m3, AbstractC0722m abstractC0722m4) {
        super((Class<?>) Object.class);
        this._mapDeserializer = abstractC0722m;
        this._listDeserializer = abstractC0722m2;
        this._stringDeserializer = abstractC0722m3;
        this._numberDeserializer = abstractC0722m4;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
        this._nonMerging = untypedObjectDeserializer._nonMerging;
    }

    public UntypedObjectDeserializer(UntypedObjectDeserializer untypedObjectDeserializer, boolean z3) {
        super((Class<?>) Object.class);
        this._mapDeserializer = untypedObjectDeserializer._mapDeserializer;
        this._listDeserializer = untypedObjectDeserializer._listDeserializer;
        this._stringDeserializer = untypedObjectDeserializer._stringDeserializer;
        this._numberDeserializer = untypedObjectDeserializer._numberDeserializer;
        this._listType = untypedObjectDeserializer._listType;
        this._mapType = untypedObjectDeserializer._mapType;
        this._nonMerging = z3;
    }

    public Object mapArray(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Collection<Object> collection) {
        while (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
            collection.add(deserialize(abstractC0545m, abstractC0718i));
        }
        return collection;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Object obj) {
        if (this._nonMerging) {
            return deserialize(abstractC0545m, abstractC0718i);
        }
        switch (abstractC0545m.mo1191f()) {
            case 1:
            case 2:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                AbstractC0722m abstractC0722m = this._mapDeserializer;
                if (abstractC0722m == null) {
                    if (!(obj instanceof Map)) {
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                AbstractC0722m abstractC0722m2 = this._listDeserializer;
                if (abstractC0722m2 == null) {
                    if (!(obj instanceof Collection)) {
                        if (!abstractC0718i.m1833K(EnumC0719j.USE_JAVA_ARRAY_FOR_JSON_ARRAY)) {
                        }
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                AbstractC0722m abstractC0722m3 = this._stringDeserializer;
                if (abstractC0722m3 == null) {
                }
                break;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                AbstractC0722m abstractC0722m4 = this._numberDeserializer;
                if (abstractC0722m4 == null) {
                    if (!abstractC0718i.m1830H(StdDeserializer.F_MASK_INT_COERCIONS)) {
                    }
                }
                break;
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                AbstractC0722m abstractC0722m5 = this._numberDeserializer;
                if (abstractC0722m5 == null) {
                    if (!abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    }
                }
                break;
        }
        return deserialize(abstractC0545m, abstractC0718i);
    }

    public Object mapObject(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, Map<Object, Object> map) throws C0850b {
        Object objDeserialize;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.START_OBJECT) {
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        if (enumC0548pMo1190e == EnumC0548p.END_OBJECT) {
            return map;
        }
        String strMo1188d = abstractC0545m.mo1188d();
        do {
            abstractC0545m.mo1177V();
            Object obj = map.get(strMo1188d);
            if (obj != null) {
                objDeserialize = deserialize(abstractC0545m, abstractC0718i, obj);
            } else {
                objDeserialize = deserialize(abstractC0545m, abstractC0718i);
            }
            if (objDeserialize != obj) {
                map.put(strMo1188d, objDeserialize);
            }
            strMo1188d = abstractC0545m.mo1175T();
        } while (strMo1188d != null);
        return map;
    }
}

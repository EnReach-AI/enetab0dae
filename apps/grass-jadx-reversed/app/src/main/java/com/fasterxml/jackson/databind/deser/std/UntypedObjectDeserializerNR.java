package com.fasterxml.jackson.databind.deser.std;

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
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p071Y0.InterfaceC0738b;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC0738b
final class UntypedObjectDeserializerNR extends StdDeserializer<Object> {
    private static final long serialVersionUID = 1;
    protected final boolean _nonMerging;
    protected static final Object[] NO_OBJECTS = new Object[0];
    public static final UntypedObjectDeserializerNR std = new UntypedObjectDeserializerNR();

    public UntypedObjectDeserializerNR() {
        this(false);
    }

    private Object _deserializeAnyScalar(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, int i3) throws C0850b {
        switch (i3) {
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
                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                throw null;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private Object _deserializeNR(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1203s c1203s) throws C0850b {
        C1203s c1203s2;
        Object objMo1157B;
        Object arrayList;
        Object objMo1157B2;
        boolean zM1830H = abstractC0718i.m1830H(StdDeserializer.F_MASK_INT_COERCIONS);
        boolean zM1833K = abstractC0718i.m1833K(EnumC0719j.USE_JAVA_ARRAY_FOR_JSON_ARRAY);
        C1203s c1203s3 = c1203s;
        while (true) {
            if (c1203s3.f4096b) {
                String strMo1175T = abstractC0545m.mo1175T();
                C1203s c1203s4 = c1203s3;
                while (strMo1175T != null) {
                    EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V == null) {
                        enumC0548pMo1177V = EnumC0548p.NOT_AVAILABLE;
                    }
                    int i3 = enumC0548pMo1177V.f1328h;
                    if (i3 == 1) {
                        c1203s4.f4098d = strMo1175T;
                        c1203s4 = new C1203s(c1203s4, c1203s4.f4097c);
                    } else if (i3 != 3) {
                        switch (i3) {
                            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                                objMo1157B = abstractC0545m.mo1157B();
                                break;
                            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                                objMo1157B = !zM1830H ? abstractC0545m.mo1207v() : _coerceIntegral(abstractC0545m, abstractC0718i);
                                break;
                            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                                objMo1157B = !abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) ? abstractC0545m.mo1207v() : abstractC0545m.mo1200o();
                                break;
                            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                                objMo1157B = Boolean.TRUE;
                                break;
                            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                                objMo1157B = Boolean.FALSE;
                                break;
                            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                                objMo1157B = null;
                                break;
                            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                                objMo1157B = abstractC0545m.mo1202q();
                                break;
                            default:
                                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                                throw null;
                        }
                        if (c1203s4.f4097c) {
                            c1203s4.m3074a(strMo1175T, objMo1157B);
                        } else {
                            if (c1203s4.f4099e == null) {
                                c1203s4.f4099e = new LinkedHashMap();
                            }
                            c1203s4.f4099e.put(strMo1175T, objMo1157B);
                        }
                    } else {
                        c1203s4.f4098d = strMo1175T;
                        c1203s2 = new C1203s(c1203s4);
                        c1203s3 = c1203s2;
                    }
                    strMo1175T = abstractC0545m.mo1175T();
                    c1203s4 = c1203s4;
                }
                if (c1203s4 == c1203s) {
                    LinkedHashMap linkedHashMap = c1203s4.f4099e;
                    return linkedHashMap == null ? new LinkedHashMap(2) : linkedHashMap;
                }
                LinkedHashMap linkedHashMap2 = c1203s4.f4099e;
                if (linkedHashMap2 == null) {
                    linkedHashMap2 = new LinkedHashMap();
                } else {
                    c1203s4.f4099e = null;
                }
                c1203s3 = c1203s4.f4095a;
                if (c1203s3.f4096b) {
                    c1203s3.m3076c(linkedHashMap2);
                } else {
                    c1203s3.m3075b(linkedHashMap2);
                }
            } else {
                while (true) {
                    EnumC0548p enumC0548pMo1177V2 = abstractC0545m.mo1177V();
                    if (enumC0548pMo1177V2 == null) {
                        enumC0548pMo1177V2 = EnumC0548p.NOT_AVAILABLE;
                    }
                    switch (enumC0548pMo1177V2.f1328h) {
                        case 1:
                            c1203s2 = new C1203s(c1203s3, c1203s3.f4097c);
                            break;
                        case 2:
                        case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                        default:
                            abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                            throw null;
                        case FromStringDeserializer.Std.STD_URI /* 3 */:
                            c1203s2 = new C1203s(c1203s3);
                            break;
                        case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                            if (c1203s3 == c1203s) {
                                ArrayList arrayList2 = c1203s3.f4100f;
                                return arrayList2 == null ? zM1833K ? NO_OBJECTS : new ArrayList(2) : zM1833K ? arrayList2.toArray(NO_OBJECTS) : arrayList2;
                            }
                            ArrayList arrayList3 = c1203s3.f4100f;
                            Object array = arrayList3;
                            if (arrayList3 == null) {
                                arrayList = zM1833K ? NO_OBJECTS : new ArrayList(2);
                            } else {
                                if (zM1833K) {
                                    array = arrayList3.toArray(NO_OBJECTS);
                                }
                                c1203s3.f4100f = null;
                                arrayList = array;
                            }
                            c1203s3 = c1203s3.f4095a;
                            if (!c1203s3.f4096b) {
                                c1203s3.m3075b(arrayList);
                            } else {
                                c1203s3.m3076c(arrayList);
                            }
                            break;
                        case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                            objMo1157B2 = abstractC0545m.mo1157B();
                            c1203s3.m3075b(objMo1157B2);
                            break;
                        case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                            objMo1157B2 = zM1830H ? _coerceIntegral(abstractC0545m, abstractC0718i) : abstractC0545m.mo1207v();
                            c1203s3.m3075b(objMo1157B2);
                            break;
                        case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                            objMo1157B2 = abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS) ? abstractC0545m.mo1200o() : abstractC0545m.mo1207v();
                            c1203s3.m3075b(objMo1157B2);
                            break;
                        case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                            objMo1157B2 = Boolean.TRUE;
                            c1203s3.m3075b(objMo1157B2);
                            break;
                        case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                            objMo1157B2 = Boolean.FALSE;
                            c1203s3.m3075b(objMo1157B2);
                            break;
                        case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                            objMo1157B2 = null;
                            c1203s3.m3075b(objMo1157B2);
                            break;
                        case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                            objMo1157B2 = abstractC0545m.mo1202q();
                            c1203s3.m3075b(objMo1157B2);
                            break;
                    }
                }
                c1203s3 = c1203s2;
            }
        }
    }

    private Object _deserializeObjectAtName(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        Object obj_deserializeNR;
        C1203s c1203s = new C1203s(null, abstractC0718i.m1832J(EnumC0552t.f1335f));
        String strMo1188d = abstractC0545m.mo1188d();
        while (strMo1188d != null) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (enumC0548pMo1177V == null) {
                enumC0548pMo1177V = EnumC0548p.NOT_AVAILABLE;
            }
            int i3 = enumC0548pMo1177V.f1328h;
            if (i3 == 1) {
                obj_deserializeNR = _deserializeNR(abstractC0545m, abstractC0718i, new C1203s(c1203s, c1203s.f4097c));
            } else {
                if (i3 == 2) {
                    LinkedHashMap linkedHashMap = c1203s.f4099e;
                    return linkedHashMap == null ? new LinkedHashMap(2) : linkedHashMap;
                }
                obj_deserializeNR = i3 != 3 ? _deserializeAnyScalar(abstractC0545m, abstractC0718i, i3) : _deserializeNR(abstractC0545m, abstractC0718i, new C1203s(c1203s));
            }
            if (c1203s.f4097c) {
                c1203s.m3074a(strMo1188d, obj_deserializeNR);
            } else {
                if (c1203s.f4099e == null) {
                    c1203s.f4099e = new LinkedHashMap();
                }
                c1203s.f4099e.put(strMo1188d, obj_deserializeNR);
            }
            strMo1188d = abstractC0545m.mo1175T();
        }
        LinkedHashMap linkedHashMap2 = c1203s.f4099e;
        return linkedHashMap2 == null ? new LinkedHashMap(2) : linkedHashMap2;
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

    public static UntypedObjectDeserializerNR instance(boolean z3) {
        return z3 ? new UntypedObjectDeserializerNR(true) : std;
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
                return _deserializeNR(abstractC0545m, abstractC0718i, new C1203s(null, abstractC0718i.m1832J(EnumC0552t.f1335f)));
            case 2:
                return new LinkedHashMap(2);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return _deserializeNR(abstractC0545m, abstractC0718i, new C1203s(null));
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
            default:
                abstractC0718i.m1824B(abstractC0545m, getValueType(abstractC0718i));
                throw null;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return _deserializeObjectAtName(abstractC0545m, abstractC0718i);
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
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        int iMo1191f = abstractC0545m.mo1191f();
        return (iMo1191f == 1 || iMo1191f == 3 || iMo1191f == 5) ? abstractC1398g.mo3400b(abstractC0545m, abstractC0718i) : _deserializeAnyScalar(abstractC0545m, abstractC0718i, abstractC0545m.mo1191f());
    }

    @Override // p069X0.AbstractC0722m
    public EnumC1664f logicalType() {
        return EnumC1664f.f5893i;
    }

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        if (this._nonMerging) {
            return Boolean.FALSE;
        }
        return null;
    }

    public UntypedObjectDeserializerNR(boolean z3) {
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

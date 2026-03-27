package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.InterfaceC1139f;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.Closeable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import p042N0.AbstractC0545m;
import p042N0.EnumC0544l;
import p042N0.EnumC0548p;
import p042N0.EnumC0552t;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0725p;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p069X0.InterfaceC0714e;
import p074Z0.C0822h;
import p074Z0.C0828n;
import p074Z0.EnumC0831q;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p109j1.C1493a;
import p109j1.C1495c;
import p109j1.C1496d;
import p109j1.C1497e;
import p109j1.C1499g;
import p109j1.C1500h;
import p109j1.C1501i;
import p109j1.C1502j;
import p109j1.C1505m;
import p109j1.C1506n;
import p109j1.C1512t;
import p109j1.C1514v;
import p109j1.C1515w;
import p114l1.EnumC1664f;
import p118m1.C1760y;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseNodeDeserializer<T extends AbstractC0725p> extends StdDeserializer<T> implements InterfaceC1139f {
    protected final boolean _mergeArrays;
    protected final boolean _mergeObjects;
    protected final Boolean _supportsUpdates;

    public BaseNodeDeserializer(Class<T> cls, Boolean bool) {
        super((Class<?>) cls);
        this._supportsUpdates = bool;
        this._mergeArrays = true;
        this._mergeObjects = true;
    }

    private static boolean _shouldMerge(Boolean bool, Boolean bool2) {
        if (bool != null) {
            return bool.booleanValue();
        }
        if (bool2 != null) {
            return bool2.booleanValue();
        }
        return true;
    }

    public abstract AbstractC0722m _createWithMerge(boolean z3, boolean z4);

    public final AbstractC0725p _deserializeAnyScalar(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        C1505m c1505m = abstractC0718i.f1998g.f1988r;
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 2) {
            c1505m.getClass();
            return new C1514v(c1505m);
        }
        switch (iMo1191f) {
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                String strMo1157B = abstractC0545m.mo1157B();
                c1505m.getClass();
                return C1505m.m3551a(strMo1157B);
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return _fromInt(abstractC0545m, abstractC0718i, c1505m);
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return _fromFloat(abstractC0545m, abstractC0718i, c1505m);
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                c1505m.getClass();
                return C1497e.f5432f;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                c1505m.getClass();
                return C1497e.f5433g;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                c1505m.getClass();
                return C1512t.f5463e;
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return _fromEmbedded(abstractC0545m, abstractC0718i);
            default:
                abstractC0718i.m1825C(abstractC0545m, handledType());
                throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p109j1.AbstractC1498f _deserializeContainerNoRecursion(p042N0.AbstractC0545m r17, p069X0.AbstractC0718i r18, p109j1.C1505m r19, com.fasterxml.jackson.databind.deser.std.C1185a r20, p109j1.AbstractC1498f r21) throws p078a1.C0850b {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer._deserializeContainerNoRecursion(N0.m, X0.i, j1.m, com.fasterxml.jackson.databind.deser.std.a, j1.f):j1.f");
    }

    public final C1514v _deserializeObjectAtName(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1505m c1505m, C1185a c1185a) throws C0850b {
        c1505m.getClass();
        C1514v c1514v = new C1514v(c1505m);
        String strMo1188d = abstractC0545m.mo1188d();
        while (strMo1188d != null) {
            EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
            if (enumC0548pMo1177V == null) {
                enumC0548pMo1177V = EnumC0548p.NOT_AVAILABLE;
            }
            int i3 = enumC0548pMo1177V.f1328h;
            AbstractC0725p abstractC0725p_deserializeAnyScalar = i3 != 1 ? i3 != 3 ? _deserializeAnyScalar(abstractC0545m, abstractC0718i) : _deserializeContainerNoRecursion(abstractC0545m, abstractC0718i, c1505m, c1185a, new C1493a(c1505m)) : _deserializeContainerNoRecursion(abstractC0545m, abstractC0718i, c1505m, c1185a, new C1514v(c1505m));
            AbstractC0725p abstractC0725pM3557q = c1514v.m3557q(strMo1188d, abstractC0725p_deserializeAnyScalar);
            if (abstractC0725pM3557q != null) {
                _handleDuplicateField(abstractC0545m, abstractC0718i, c1505m, strMo1188d, c1514v, abstractC0725pM3557q, abstractC0725p_deserializeAnyScalar);
            }
            strMo1188d = abstractC0545m.mo1175T();
        }
        return c1514v;
    }

    public final AbstractC0725p _deserializeRareScalar(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 2) {
            C1505m c1505m = abstractC0718i.f1998g.f1988r;
            c1505m.getClass();
            return new C1514v(c1505m);
        }
        if (iMo1191f == 8) {
            return _fromFloat(abstractC0545m, abstractC0718i, abstractC0718i.f1998g.f1988r);
        }
        if (iMo1191f == 12) {
            return _fromEmbedded(abstractC0545m, abstractC0718i);
        }
        abstractC0718i.m1825C(abstractC0545m, handledType());
        throw null;
    }

    public final AbstractC0725p _fromBigDecimal(AbstractC0718i abstractC0718i, C1505m c1505m, BigDecimal bigDecimal) {
        boolean zM2143a;
        C0828n c0828n = abstractC0718i.f1998g.f2491n;
        EnumC0831q enumC0831q = EnumC0831q.f2477h;
        c0828n.getClass();
        enumC0831q.getClass();
        if (enumC0831q.mo1643c(0)) {
            zM2143a = c0828n.m2143a(enumC0831q);
        } else {
            c1505m.getClass();
            zM2143a = true;
        }
        if (zM2143a) {
            try {
                bigDecimal = bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
            } catch (ArithmeticException unused) {
            }
        }
        c1505m.getClass();
        return bigDecimal == null ? C1512t.f5463e : new C1499g(bigDecimal);
    }

    public final AbstractC0725p _fromEmbedded(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        C1505m c1505m = abstractC0718i.f1998g.f1988r;
        Object objMo1202q = abstractC0545m.mo1202q();
        if (objMo1202q == null) {
            c1505m.getClass();
            return C1512t.f5463e;
        }
        if (objMo1202q.getClass() == byte[].class) {
            byte[] bArr = (byte[]) objMo1202q;
            c1505m.getClass();
            C1496d c1496d = C1496d.f5430f;
            return bArr.length == 0 ? C1496d.f5430f : new C1496d(bArr);
        }
        if (objMo1202q instanceof C1760y) {
            c1505m.getClass();
            return new C1515w((C1760y) objMo1202q);
        }
        if (objMo1202q instanceof AbstractC0725p) {
            return (AbstractC0725p) objMo1202q;
        }
        c1505m.getClass();
        return new C1515w(objMo1202q);
    }

    public final AbstractC0725p _fromFloat(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1505m c1505m) {
        EnumC0544l enumC0544lMo1206u = abstractC0545m.mo1206u();
        if (enumC0544lMo1206u == EnumC0544l.f1303j) {
            return _fromBigDecimal(abstractC0718i, c1505m, abstractC0545m.mo1200o());
        }
        if (abstractC0718i.m1833K(EnumC0719j.USE_BIG_DECIMAL_FOR_FLOATS)) {
            if (!abstractC0545m.mo1174S()) {
                return _fromBigDecimal(abstractC0718i, c1505m, abstractC0545m.mo1200o());
            }
            double dMo1201p = abstractC0545m.mo1201p();
            c1505m.getClass();
            return new C1500h(dMo1201p);
        }
        if (enumC0544lMo1206u == EnumC0544l.f1301h) {
            float fMo1203r = abstractC0545m.mo1203r();
            c1505m.getClass();
            return new C1501i(fMo1203r);
        }
        double dMo1201p2 = abstractC0545m.mo1201p();
        c1505m.getClass();
        return new C1500h(dMo1201p2);
    }

    public final AbstractC0725p _fromInt(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1505m c1505m) {
        int i3 = abstractC0718i.f1999h;
        int i4 = StdDeserializer.F_MASK_INT_COERCIONS & i3;
        EnumC0544l enumC0544l = EnumC0544l.f1299f;
        EnumC0544l enumC0544lMo1206u = i4 != 0 ? (EnumC0719j.USE_BIG_INTEGER_FOR_INTS.f2035f & i3) != 0 ? EnumC0544l.f1300g : (i3 & EnumC0719j.USE_LONG_FOR_INTS.f2035f) != 0 ? enumC0544l : abstractC0545m.mo1206u() : abstractC0545m.mo1206u();
        if (enumC0544lMo1206u == EnumC0544l.f1298e) {
            int iMo1204s = abstractC0545m.mo1204s();
            c1505m.getClass();
            C1502j[] c1502jArr = C1502j.f5443f;
            return (iMo1204s > 10 || iMo1204s < -1) ? new C1502j(iMo1204s) : C1502j.f5443f[iMo1204s - (-1)];
        }
        if (enumC0544lMo1206u == enumC0544l) {
            long jMo1205t = abstractC0545m.mo1205t();
            c1505m.getClass();
            return new C1506n(jMo1205t);
        }
        BigInteger bigIntegerMo1192g = abstractC0545m.mo1192g();
        c1505m.getClass();
        return bigIntegerMo1192g == null ? C1512t.f5463e : new C1495c(bigIntegerMo1192g);
    }

    public void _handleDuplicateField(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1505m c1505m, String str, C1514v c1514v, AbstractC0725p abstractC0725p, AbstractC0725p abstractC0725p2) throws C0850b {
        if (abstractC0718i.m1833K(EnumC0719j.FAIL_ON_READING_DUP_TREE_KEY)) {
            throw new C0850b((Closeable) abstractC0718i.f2002k, String.format("Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str));
        }
        if (abstractC0718i.m1832J(EnumC0552t.f1335f)) {
            abstractC0725p.getClass();
            if (abstractC0725p instanceof C1493a) {
                ((C1493a) abstractC0725p).m3542p(abstractC0725p2);
                c1514v.m3557q(str, abstractC0725p);
                return;
            }
            c1505m.getClass();
            C1493a c1493a = new C1493a(c1505m);
            c1493a.f5424f.add(abstractC0725p);
            c1493a.m3542p(abstractC0725p2);
            c1514v.m3557q(str, c1493a);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        C0717h c0717h = abstractC0718i.f1998g;
        C0822h c0822h = c0717h.f2490m;
        Map map = c0822h.f2447e;
        if (map != null) {
        }
        Boolean bool = c0822h.f2451i;
        C0822h c0822h2 = c0717h.f2490m;
        Map map2 = c0822h2.f2447e;
        if (map2 != null) {
        }
        Boolean bool2 = c0822h2.f2451i;
        Map map3 = c0822h2.f2447e;
        if (map3 != null) {
        }
        Boolean bool3 = c0822h2.f2451i;
        boolean z_shouldMerge = _shouldMerge(bool, bool3);
        boolean z_shouldMerge2 = _shouldMerge(bool2, bool3);
        return (z_shouldMerge == this._mergeArrays && z_shouldMerge2 == this._mergeObjects) ? this : _createWithMerge(z_shouldMerge, z_shouldMerge2);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
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

    @Override // p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return this._supportsUpdates;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p069X0.AbstractC0725p updateObject(p042N0.AbstractC0545m r9, p069X0.AbstractC0718i r10, p109j1.C1514v r11, com.fasterxml.jackson.databind.deser.std.C1185a r12) throws p078a1.C0850b {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.updateObject(N0.m, X0.i, j1.v, com.fasterxml.jackson.databind.deser.std.a):X0.p");
    }

    public BaseNodeDeserializer(BaseNodeDeserializer<?> baseNodeDeserializer, boolean z3, boolean z4) {
        super(baseNodeDeserializer);
        this._supportsUpdates = baseNodeDeserializer._supportsUpdates;
        this._mergeArrays = z3;
        this._mergeObjects = z4;
    }

    public final AbstractC0725p _fromInt(AbstractC0545m abstractC0545m, int i3, C1505m c1505m) {
        if (i3 != 0) {
            if ((i3 & EnumC0719j.USE_BIG_INTEGER_FOR_INTS.f2035f) != 0) {
                BigInteger bigIntegerMo1192g = abstractC0545m.mo1192g();
                c1505m.getClass();
                if (bigIntegerMo1192g == null) {
                    return C1512t.f5463e;
                }
                return new C1495c(bigIntegerMo1192g);
            }
            long jMo1205t = abstractC0545m.mo1205t();
            c1505m.getClass();
            return new C1506n(jMo1205t);
        }
        EnumC0544l enumC0544lMo1206u = abstractC0545m.mo1206u();
        if (enumC0544lMo1206u == EnumC0544l.f1298e) {
            int iMo1204s = abstractC0545m.mo1204s();
            c1505m.getClass();
            C1502j[] c1502jArr = C1502j.f5443f;
            if (iMo1204s <= 10 && iMo1204s >= -1) {
                return C1502j.f5443f[iMo1204s - (-1)];
            }
            return new C1502j(iMo1204s);
        }
        if (enumC0544lMo1206u == EnumC0544l.f1299f) {
            long jMo1205t2 = abstractC0545m.mo1205t();
            c1505m.getClass();
            return new C1506n(jMo1205t2);
        }
        BigInteger bigIntegerMo1192g2 = abstractC0545m.mo1192g();
        c1505m.getClass();
        if (bigIntegerMo1192g2 == null) {
            return C1512t.f5463e;
        }
        return new C1495c(bigIntegerMo1192g2);
    }
}

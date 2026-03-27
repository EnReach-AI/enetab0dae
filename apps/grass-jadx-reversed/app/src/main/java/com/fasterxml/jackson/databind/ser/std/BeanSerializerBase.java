package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.deser.impl.C1160l;
import com.fasterxml.jackson.databind.ser.impl.C1216d;
import com.fasterxml.jackson.databind.ser.impl.C1217e;
import com.fasterxml.jackson.databind.ser.impl.C1227o;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p039M0.AbstractC0473V;
import p039M0.AbstractC0485d0;
import p039M0.AbstractC0489f0;
import p039M0.C0455C;
import p039M0.C0502q;
import p039M0.C0508w;
import p039M0.EnumC0501p;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p050Q0.C0597j;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.C0703E;
import p069X0.C0707I;
import p069X0.C0724o;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p082b1.AbstractC1041l;
import p082b1.C1018N;
import p092e1.InterfaceC1338c;
import p096f1.InterfaceC1347a;
import p100g1.AbstractC1399h;
import p109j1.C1505m;
import p109j1.C1514v;
import p112k1.AbstractC1642j;
import p112k1.C1633a;
import p112k1.C1635c;
import p112k1.C1636d;
import p112k1.InterfaceC1638f;
import p112k1.InterfaceC1643k;
import p114l1.C1675q;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1757v;
import p118m1.C1739d;
import p118m1.InterfaceC1748m;

/* JADX INFO: loaded from: classes.dex */
public abstract class BeanSerializerBase extends StdSerializer<Object> implements InterfaceC1638f, InterfaceC1643k {
    protected static final C0703E NAME_FOR_OBJECT_REF = new C0703E("#object-ref", null);
    protected static final C1635c[] NO_PROPS = new C1635c[0];
    protected final C1633a _anyGetterWriter;
    protected final AbstractC0721l _beanType;
    protected final C1635c[] _filteredProps;
    protected final C1216d _objectIdWriter;
    protected final Object _propertyFilterId;
    protected final C1635c[] _props;
    protected final EnumC0501p _serializationShape;
    protected final AbstractC1041l _typeId;

    public BeanSerializerBase(AbstractC0721l abstractC0721l, C1636d c1636d, C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        super(abstractC0721l);
        this._beanType = abstractC0721l;
        this._props = c1635cArr;
        this._filteredProps = c1635cArr2;
        if (c1636d == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = c1636d.f5833g;
        this._anyGetterWriter = c1636d.f5831e;
        this._propertyFilterId = c1636d.f5832f;
        this._objectIdWriter = c1636d.f5834h;
        this._serializationShape = c1636d.f5827a.mo1800b().f1170f;
    }

    private static final C1635c[] rename(C1635c[] c1635cArr, AbstractC1757v abstractC1757v) {
        if (c1635cArr == null || c1635cArr.length == 0 || abstractC1757v == null || abstractC1757v == AbstractC1757v.f6136e) {
            return c1635cArr;
        }
        int length = c1635cArr.length;
        C1635c[] c1635cArr2 = new C1635c[length];
        for (int i3 = 0; i3 < length; i3++) {
            C1635c c1635c = c1635cArr[i3];
            if (c1635c != null) {
                c1635cArr2[i3] = c1635c.mo3086m(abstractC1757v);
            }
        }
        return c1635cArr2;
    }

    @Deprecated
    public final String _customTypeId(Object obj) {
        Object objMo2772l = this._typeId.mo2772l(obj);
        return objMo2772l == null ? "" : objMo2772l instanceof String ? (String) objMo2772l : objMo2772l.toString();
    }

    public void _serializeObjectId(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h, C1227o c1227o) throws IOException {
        C1216d c1216d = this._objectIdWriter;
        C0672b c0672b_typeIdDef = _typeIdDef(abstractC1399h, obj, EnumC0548p.START_OBJECT);
        abstractC1399h.mo3103e(abstractC0540h, c0672b_typeIdDef);
        abstractC0540h.mo1136i(obj);
        c1227o.m3098a(abstractC0540h, abstractC0709K, c1216d);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, abstractC0540h, abstractC0709K);
        } else {
            serializeFields(obj, abstractC0540h, abstractC0709K);
        }
        abstractC1399h.mo3104f(abstractC0540h, c0672b_typeIdDef);
    }

    public final void _serializeWithObjectId(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, boolean z3) throws IOException {
        C1216d c1216d = this._objectIdWriter;
        C1227o c1227oMo1723u = abstractC0709K.mo1723u(obj, c1216d.f4132c);
        if (c1227oMo1723u.m3099b(abstractC0540h, abstractC0709K, c1216d)) {
            return;
        }
        if (c1227oMo1723u.f4156b == null) {
            c1227oMo1723u.f4156b = c1227oMo1723u.f4155a.mo1003c(obj);
        }
        Object obj2 = c1227oMo1723u.f4156b;
        if (c1216d.f4134e) {
            c1216d.f4133d.serialize(obj2, abstractC0540h, abstractC0709K);
            return;
        }
        if (z3) {
            abstractC0540h.mo1121N(obj);
        }
        c1227oMo1723u.m3098a(abstractC0540h, abstractC0709K, c1216d);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, abstractC0540h, abstractC0709K);
        } else {
            serializeFields(obj, abstractC0540h, abstractC0709K);
        }
        if (z3) {
            abstractC0540h.mo1143p();
        }
    }

    public final C0672b _typeIdDef(AbstractC1399h abstractC1399h, Object obj, EnumC0548p enumC0548p) {
        AbstractC1041l abstractC1041l = this._typeId;
        if (abstractC1041l == null) {
            return abstractC1399h.m3406d(enumC0548p, obj);
        }
        Object objMo2772l = abstractC1041l.mo2772l(obj);
        if (objMo2772l == null) {
            objMo2772l = "";
        }
        C0672b c0672bM3406d = abstractC1399h.m3406d(enumC0548p, obj);
        c0672bM3406d.f1825c = objMo2772l;
        return c0672bM3406d;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
    }

    public abstract BeanSerializerBase asArraySerializer();

    @Override // p112k1.InterfaceC1638f
    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) throws C0850b {
        EnumC0501p enumC0501p;
        Object objMo1781n;
        Set<String> set;
        Set<String> setEmptySet;
        int i3;
        BeanSerializerBase beanSerializerBaseWithFilterId;
        Object obj;
        C1018N c1018nMo1729A;
        EnumC0501p enumC0501p2;
        AbstractC0711b abstractC0711bM2149d = abstractC0709K.f1966e.m2149d();
        C1635c[] c1635cArr = null;
        AbstractC1041l abstractC1041lMo1805c = (interfaceC0714e == null || abstractC0711bM2149d == null) ? null : interfaceC0714e.mo1805c();
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, this._handledType);
        if (c0502qFindFormatOverrides == null || (enumC0501p = c0502qFindFormatOverrides.f1170f) == (enumC0501p2 = EnumC0501p.f1157e)) {
            enumC0501p = null;
        } else if (enumC0501p != enumC0501p2 && enumC0501p != this._serializationShape) {
            if (this._beanType.m1888w()) {
                int iOrdinal = enumC0501p.ordinal();
                if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8) {
                    AbstractC0721l abstractC0721l = this._beanType;
                    C0707I c0707i = abstractC0709K.f1966e;
                    return abstractC0709K.m1703C(EnumSerializer.construct(this._beanType.f2036e, c0707i, c0707i.m2155j(abstractC0721l), c0502qFindFormatOverrides), interfaceC0714e);
                }
            } else if (enumC0501p == EnumC0501p.f1158f && ((!this._beanType.mo1890y() || !Map.class.isAssignableFrom(this._handledType)) && Map.Entry.class.isAssignableFrom(this._handledType))) {
                AbstractC0721l abstractC0721lMo1872g = this._beanType.mo1872g(Map.Entry.class);
                return abstractC0709K.m1703C(new MapEntrySerializer(this._beanType, abstractC0721lMo1872g.m1871f(0), abstractC0721lMo1872g.m1871f(1), false, null, interfaceC0714e), interfaceC0714e);
            }
        }
        C1216d c1216dM3090a = this._objectIdWriter;
        if (abstractC1041lMo1805c != null) {
            C0508w c0508wMo1737I = abstractC0711bM2149d.mo1737I(abstractC1041lMo1805c);
            setEmptySet = c0508wMo1737I.f1179g ? Collections.emptySet() : c0508wMo1737I.f1177e;
            C0455C c0455cMo1740L = abstractC0711bM2149d.mo1740L(abstractC1041lMo1805c);
            C1018N c1018nMo1798z = abstractC0711bM2149d.mo1798z(abstractC1041lMo1805c);
            if (c1018nMo1798z == null) {
                if (c1216dM3090a != null && (c1018nMo1729A = abstractC0711bM2149d.mo1729A(abstractC1041lMo1805c, null)) != null) {
                    c1216dM3090a = this._objectIdWriter;
                    boolean z3 = c1216dM3090a.f4134e;
                    boolean z4 = c1018nMo1729A.f3614e;
                    if (z4 != z3) {
                        c1216dM3090a = new C1216d(c1216dM3090a.f4130a, (C0597j) c1216dM3090a.f4131b, c1216dM3090a.f4132c, c1216dM3090a.f4133d, z4);
                    }
                }
                i3 = 0;
            } else {
                C1018N c1018nMo1729A2 = abstractC0711bM2149d.mo1729A(abstractC1041lMo1805c, c1018nMo1798z);
                Class cls = c1018nMo1729A2.f3611b;
                AbstractC0721l abstractC0721lM1811c = abstractC0709K.m1811c(cls);
                abstractC0709K.mo1711f().getClass();
                AbstractC0721l abstractC0721l2 = C1675q.m3771l(abstractC0721lM1811c, AbstractC0485d0.class)[0];
                boolean z5 = c1018nMo1729A2.f3614e;
                C0703E c0703e = c1018nMo1729A2.f3610a;
                if (cls == AbstractC0489f0.class) {
                    String str = c0703e.f1928e;
                    int length = this._props.length;
                    i3 = 0;
                    while (i3 != length) {
                        C1635c c1635c = this._props[i3];
                        if (str.equals(c1635c.f5810g.f1531e)) {
                            c1216dM3090a = C1216d.m3090a(c1635c.f5812i, null, new C1217e(c1018nMo1729A2.f3613d, c1635c), z5);
                        } else {
                            i3++;
                        }
                    }
                    abstractC0709K.mo1713k("Invalid Object Id definition for " + AbstractC1745j.m3903z(handledType()) + ": cannot find property with name " + AbstractC1745j.m3902y(str));
                    throw null;
                }
                c1216dM3090a = C1216d.m3090a(abstractC0721l2, c0703e, abstractC0709K.m1813h(c1018nMo1729A2), z5);
                i3 = 0;
            }
            objMo1781n = abstractC0711bM2149d.mo1781n(abstractC1041lMo1805c);
            set = c0455cMo1740L.f1101e;
            if (objMo1781n == null || ((obj = this._propertyFilterId) != null && objMo1781n.equals(obj))) {
                objMo1781n = null;
            }
        } else {
            objMo1781n = null;
            set = null;
            setEmptySet = null;
            i3 = 0;
        }
        if (i3 > 0) {
            C1635c[] c1635cArr2 = this._props;
            C1635c[] c1635cArr3 = (C1635c[]) Arrays.copyOf(c1635cArr2, c1635cArr2.length);
            C1635c c1635c2 = c1635cArr3[i3];
            System.arraycopy(c1635cArr3, 0, c1635cArr3, 1, i3);
            c1635cArr3[0] = c1635c2;
            C1635c[] c1635cArr4 = this._filteredProps;
            if (c1635cArr4 != null) {
                c1635cArr = (C1635c[]) Arrays.copyOf(c1635cArr4, c1635cArr4.length);
                C1635c c1635c3 = c1635cArr[i3];
                System.arraycopy(c1635cArr, 0, c1635cArr, 1, i3);
                c1635cArr[0] = c1635c3;
            }
            beanSerializerBaseWithFilterId = withProperties(c1635cArr3, c1635cArr);
        } else {
            beanSerializerBaseWithFilterId = this;
        }
        if (c1216dM3090a != null) {
            C1216d c1216d = new C1216d(c1216dM3090a.f4130a, (C0597j) c1216dM3090a.f4131b, c1216dM3090a.f4132c, abstractC0709K.m1727y(c1216dM3090a.f4130a, interfaceC0714e), c1216dM3090a.f4134e);
            if (c1216d != this._objectIdWriter) {
                beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withObjectIdWriter(c1216d);
            }
        }
        if ((setEmptySet != null && !setEmptySet.isEmpty()) || set != null) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withByNameInclusion(setEmptySet, set);
        }
        if (objMo1781n != null) {
            beanSerializerBaseWithFilterId = beanSerializerBaseWithFilterId.withFilterId(objMo1781n);
        }
        if (enumC0501p == null) {
            enumC0501p = this._serializationShape;
        }
        return enumC0501p == EnumC0501p.f1160h ? beanSerializerBaseWithFilterId.asArraySerializer() : beanSerializerBaseWithFilterId;
    }

    public AbstractC0728s findConvertingSerializer(AbstractC0709K abstractC0709K, C1635c c1635c) {
        AbstractC1041l abstractC1041l;
        Object objMo1746R;
        AbstractC0711b abstractC0711bM2149d = abstractC0709K.f1966e.m2149d();
        if (abstractC0711bM2149d == null || (abstractC1041l = c1635c.f5815l) == null || (objMo1746R = abstractC0711bM2149d.mo1746R(abstractC1041l)) == null) {
            return null;
        }
        InterfaceC1748m interfaceC1748mM1812d = abstractC0709K.m1812d(objMo1746R);
        abstractC0709K.mo1711f();
        AbstractC0721l abstractC0721l = ((C1160l) interfaceC1748mM1812d).f4009a;
        return new StdDelegatingSerializer(interfaceC1748mM1812d, abstractC0721l, abstractC0721l.m1889x() ? null : abstractC0709K.m1727y(abstractC0721l, c1635c));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) throws C0724o {
        AbstractC0725p schema;
        String strM3302id;
        C1514v c1514vCreateSchemaNode = createSchemaNode("object", true);
        InterfaceC1347a interfaceC1347a = (InterfaceC1347a) this._handledType.getAnnotation(InterfaceC1347a.class);
        if (interfaceC1347a != null && (strM3302id = interfaceC1347a.m3302id()) != null && !strM3302id.isEmpty()) {
            c1514vCreateSchemaNode.m3556p("id", strM3302id);
        }
        C1505m c1505m = c1514vCreateSchemaNode.f5435e;
        c1505m.getClass();
        C1514v c1514v = new C1514v(c1505m);
        Object obj = this._propertyFilterId;
        if (obj != null) {
            findPropertyFilter(abstractC0709K, obj, null);
        }
        int i3 = 0;
        while (true) {
            C1635c[] c1635cArr = this._props;
            if (i3 >= c1635cArr.length) {
                c1514vCreateSchemaNode.m3559s("properties", c1514v);
                return c1514vCreateSchemaNode;
            }
            C1635c c1635c = c1635cArr[i3];
            AbstractC0721l abstractC0721l = c1635c.f5812i;
            AbstractC0721l abstractC0721l2 = c1635c.f5813j;
            Type type2 = abstractC0721l2 == null ? abstractC0721l : abstractC0721l2.f2036e;
            AbstractC0728s abstractC0728sM1727y = c1635c.f5818o;
            if (abstractC0728sM1727y == null) {
                abstractC0728sM1727y = abstractC0709K.m1727y(abstractC0721l, c1635c);
            }
            boolean z3 = !c1635c.m2728g();
            if (abstractC0728sM1727y instanceof StdSerializer) {
                schema = ((StdSerializer) abstractC0728sM1727y).getSchema(abstractC0709K, type2, z3);
            } else {
                C1514v c1514v2 = new C1514v(C1505m.f5450e);
                c1514v2.m3556p("type", "any");
                schema = c1514v2;
            }
            c1635c.mo3096h(c1514v, schema);
            i3++;
        }
    }

    @Override // p069X0.AbstractC0728s
    public Iterator<AbstractC1642j> properties() {
        return Arrays.asList(this._props).iterator();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    @Override // p112k1.InterfaceC1643k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resolve(p069X0.AbstractC0709K r8) throws p069X0.C0724o {
        /*
            r7 = this;
            k1.c[] r0 = r7._filteredProps
            r1 = 0
            if (r0 != 0) goto L7
            r0 = r1
            goto L8
        L7:
            int r0 = r0.length
        L8:
            k1.c[] r2 = r7._props
            int r2 = r2.length
        Lb:
            if (r1 >= r2) goto L8f
            k1.c[] r3 = r7._props
            r3 = r3[r1]
            boolean r4 = r3.f5822s
            if (r4 != 0) goto L2c
            X0.s r4 = r3.f5819p
            if (r4 == 0) goto L1a
            goto L2c
        L1a:
            X0.s r4 = r8.f1973l
            if (r4 == 0) goto L2c
            r3.mo3084k(r4)
            if (r1 >= r0) goto L2c
            k1.c[] r5 = r7._filteredProps
            r5 = r5[r1]
            if (r5 == 0) goto L2c
            r5.mo3084k(r4)
        L2c:
            X0.s r4 = r3.f5818o
            if (r4 == 0) goto L31
            goto L8b
        L31:
            X0.s r4 = r7.findConvertingSerializer(r8, r3)
            if (r4 != 0) goto L7c
            X0.l r4 = r3.f5813j
            if (r4 != 0) goto L5c
            X0.l r4 = r3.f5812i
            java.lang.Class r5 = r4.f2036e
            int r5 = r5.getModifiers()
            boolean r5 = java.lang.reflect.Modifier.isFinal(r5)
            if (r5 != 0) goto L5c
            boolean r5 = r4.mo1887v()
            if (r5 != 0) goto L59
            r5 = r4
            l1.m r5 = (p114l1.AbstractC1671m) r5
            l1.p r5 = r5.f5913l
            X0.l[] r5 = r5.f5929f
            int r5 = r5.length
            if (r5 <= 0) goto L8b
        L59:
            r3.f5814k = r4
            goto L8b
        L5c:
            X0.s r5 = r8.m1727y(r4, r3)
            boolean r6 = r4.mo1887v()
            if (r6 == 0) goto L7b
            X0.l r4 = r4.mo1874i()
            java.lang.Object r4 = r4.f2039h
            g1.h r4 = (p100g1.AbstractC1399h) r4
            if (r4 == 0) goto L7b
            boolean r6 = r5 instanceof com.fasterxml.jackson.databind.ser.ContainerSerializer
            if (r6 == 0) goto L7b
            com.fasterxml.jackson.databind.ser.ContainerSerializer r5 = (com.fasterxml.jackson.databind.ser.ContainerSerializer) r5
            com.fasterxml.jackson.databind.ser.ContainerSerializer r4 = r5.withValueTypeSerializer(r4)
            goto L7c
        L7b:
            r4 = r5
        L7c:
            if (r1 >= r0) goto L88
            k1.c[] r5 = r7._filteredProps
            r5 = r5[r1]
            if (r5 == 0) goto L88
            r5.mo3085l(r4)
            goto L8b
        L88:
            r3.mo3085l(r4)
        L8b:
            int r1 = r1 + 1
            goto Lb
        L8f:
            k1.a r0 = r7._anyGetterWriter
            if (r0 == 0) goto La9
            X0.s r1 = r0.f5805c
            boolean r2 = r1 instanceof p112k1.InterfaceC1638f
            if (r2 == 0) goto La9
            X0.e r2 = r0.f5803a
            X0.s r8 = r8.m1703C(r1, r2)
            r0.f5805c = r8
            boolean r1 = r8 instanceof com.fasterxml.jackson.databind.ser.std.MapSerializer
            if (r1 == 0) goto La9
            com.fasterxml.jackson.databind.ser.std.MapSerializer r8 = (com.fasterxml.jackson.databind.ser.std.MapSerializer) r8
            r0.f5806d = r8
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.resolve(X0.K):void");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public abstract void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K);

    public void serializeFields(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        C1635c[] c1635cArr = this._filteredProps;
        if (c1635cArr == null || abstractC0709K.f1967f == null) {
            c1635cArr = this._props;
        }
        int i3 = 0;
        try {
            int length = c1635cArr.length;
            while (i3 < length) {
                C1635c c1635c = c1635cArr[i3];
                if (c1635c != null) {
                    c1635c.mo3088o(obj, abstractC0540h, abstractC0709K);
                }
                i3++;
            }
            C1633a c1633a = this._anyGetterWriter;
            if (c1633a != null) {
                c1633a.m3709a(obj, abstractC0540h, abstractC0709K);
            }
        } catch (Exception e3) {
            wrapAndThrow(abstractC0709K, e3, obj, i3 != c1635cArr.length ? c1635cArr[i3].f5810g.f1531e : "[anySetter]");
        } catch (StackOverflowError e4) {
            C0724o c0724o = new C0724o(abstractC0540h, "Infinite recursion (StackOverflowError)", e4);
            c0724o.mo1816d(i3 != c1635cArr.length ? c1635cArr[i3].f5810g.f1531e : "[anySetter]", obj);
            throw c0724o;
        }
    }

    public void serializeFieldsFiltered(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        if (this._filteredProps != null) {
            Class cls = abstractC0709K.f1967f;
        }
        findPropertyFilter(abstractC0709K, this._propertyFilterId, obj);
        serializeFields(obj, abstractC0540h, abstractC0709K);
    }

    @Override // p069X0.AbstractC0728s
    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        if (this._objectIdWriter != null) {
            _serializeWithObjectId(obj, abstractC0540h, abstractC0709K, abstractC1399h);
            return;
        }
        C0672b c0672b_typeIdDef = _typeIdDef(abstractC1399h, obj, EnumC0548p.START_OBJECT);
        abstractC1399h.mo3103e(abstractC0540h, c0672b_typeIdDef);
        abstractC0540h.mo1136i(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, abstractC0540h, abstractC0709K);
        } else {
            serializeFields(obj, abstractC0540h, abstractC0709K);
        }
        abstractC1399h.mo3104f(abstractC0540h, c0672b_typeIdDef);
    }

    @Override // p069X0.AbstractC0728s
    public boolean usesObjectId() {
        return this._objectIdWriter != null;
    }

    public abstract BeanSerializerBase withByNameInclusion(Set<String> set, Set<String> set2);

    @Override // p069X0.AbstractC0728s
    public abstract BeanSerializerBase withFilterId(Object obj);

    @Deprecated
    public BeanSerializerBase withIgnorals(Set<String> set) {
        return withByNameInclusion(set, null);
    }

    public abstract BeanSerializerBase withObjectIdWriter(C1216d c1216d);

    public abstract BeanSerializerBase withProperties(C1635c[] c1635cArr, C1635c[] c1635cArr2);

    @Deprecated
    public BeanSerializerBase withIgnorals(String[] strArr) {
        return withIgnorals(C1739d.m3868a(strArr));
    }

    public final void _serializeWithObjectId(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) throws IOException {
        C1216d c1216d = this._objectIdWriter;
        C1227o c1227oMo1723u = abstractC0709K.mo1723u(obj, c1216d.f4132c);
        if (c1227oMo1723u.m3099b(abstractC0540h, abstractC0709K, c1216d)) {
            return;
        }
        if (c1227oMo1723u.f4156b == null) {
            c1227oMo1723u.f4156b = c1227oMo1723u.f4155a.mo1003c(obj);
        }
        Object obj2 = c1227oMo1723u.f4156b;
        if (c1216d.f4134e) {
            c1216d.f4133d.serialize(obj2, abstractC0540h, abstractC0709K);
        } else {
            _serializeObjectId(obj, abstractC0540h, abstractC0709K, abstractC1399h, c1227oMo1723u);
        }
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = c1635cArr;
        this._filteredProps = c1635cArr2;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, C1216d c1216d) {
        this(beanSerializerBase, c1216d, beanSerializerBase._propertyFilterId);
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, C1216d c1216d, Object obj) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        this._props = beanSerializerBase._props;
        this._filteredProps = beanSerializerBase._filteredProps;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = c1216d;
        this._propertyFilterId = obj;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    @Deprecated
    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, String[] strArr) {
        this(beanSerializerBase, C1739d.m3868a(strArr), (Set<String>) null);
    }

    @Deprecated
    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set) {
        this(beanSerializerBase, set, (Set<String>) null);
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase._handledType);
        this._beanType = beanSerializerBase._beanType;
        C1635c[] c1635cArr = beanSerializerBase._props;
        C1635c[] c1635cArr2 = beanSerializerBase._filteredProps;
        int length = c1635cArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = c1635cArr2 == null ? null : new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            C1635c c1635c = c1635cArr[i3];
            if (!AbstractC0473V.m999L(c1635c.f5810g.f1531e, set, set2)) {
                arrayList.add(c1635c);
                if (c1635cArr2 != null) {
                    arrayList2.add(c1635cArr2[i3]);
                }
            }
        }
        this._props = (C1635c[]) arrayList.toArray(new C1635c[arrayList.size()]);
        this._filteredProps = arrayList2 != null ? (C1635c[]) arrayList2.toArray(new C1635c[arrayList2.size()]) : null;
        this._typeId = beanSerializerBase._typeId;
        this._anyGetterWriter = beanSerializerBase._anyGetterWriter;
        this._objectIdWriter = beanSerializerBase._objectIdWriter;
        this._propertyFilterId = beanSerializerBase._propertyFilterId;
        this._serializationShape = beanSerializerBase._serializationShape;
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase) {
        this(beanSerializerBase, beanSerializerBase._props, beanSerializerBase._filteredProps);
    }

    public BeanSerializerBase(BeanSerializerBase beanSerializerBase, AbstractC1757v abstractC1757v) {
        this(beanSerializerBase, rename(beanSerializerBase._props, abstractC1757v), rename(beanSerializerBase._filteredProps, abstractC1757v));
    }
}

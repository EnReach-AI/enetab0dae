package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.deser.impl.C1160l;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import p005B.AbstractC0032g;
import p039M0.C0453A;
import p039M0.C0502q;
import p039M0.EnumC0499n;
import p042N0.AbstractC0540h;
import p042N0.EnumC0544l;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.C0707I;
import p069X0.InterfaceC0714e;
import p074Z0.C0824j;
import p082b1.AbstractC1041l;
import p092e1.EnumC1337b;
import p092e1.EnumC1339d;
import p092e1.InterfaceC1338c;
import p109j1.C1497e;
import p109j1.C1505m;
import p109j1.C1514v;
import p112k1.InterfaceC1641i;
import p118m1.AbstractC1745j;
import p118m1.InterfaceC1748m;

/* JADX INFO: loaded from: classes.dex */
public abstract class StdSerializer<T> extends AbstractC0728s implements Serializable {
    private static final Object KEY_CONTENT_CONVERTER_LOCK = new Object();
    private static final long serialVersionUID = 1;
    protected final Class<T> _handledType;

    public StdSerializer(Class<T> cls) {
        this._handledType = cls;
    }

    public static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    public static final boolean _nonEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }

    @Override // p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    public C1514v createSchemaNode(String str) {
        C1514v c1514v = new C1514v(C1505m.f5450e);
        c1514v.m3556p("type", str);
        return c1514v;
    }

    public AbstractC0728s findAnnotatedContentSerializer(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        Object objMo1761d;
        if (interfaceC0714e == null) {
            return null;
        }
        AbstractC1041l abstractC1041lMo1805c = interfaceC0714e.mo1805c();
        AbstractC0711b abstractC0711bM2149d = abstractC0709K.f1966e.m2149d();
        if (abstractC1041lMo1805c == null || (objMo1761d = abstractC0711bM2149d.mo1761d(abstractC1041lMo1805c)) == null) {
            return null;
        }
        return abstractC0709K.mo1709I(abstractC1041lMo1805c, objMo1761d);
    }

    public AbstractC0728s findContextualConvertingSerializer(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s) {
        Object obj = KEY_CONTENT_CONVERTER_LOCK;
        Map identityHashMap = (Map) abstractC0709K.m1701A(obj);
        if (identityHashMap == null) {
            identityHashMap = new IdentityHashMap();
            C0824j c0824j = (C0824j) abstractC0709K.f1970i;
            C0824j c0824j2 = C0824j.f2454g;
            Map map = c0824j.f2456e;
            Map map2 = c0824j.f2457f;
            if (map2 == null) {
                HashMap map3 = new HashMap();
                map3.put(obj, identityHashMap);
                c0824j = new C0824j(map, map3);
            } else {
                map2.put(obj, identityHashMap);
            }
            abstractC0709K.f1970i = c0824j;
        } else if (identityHashMap.get(interfaceC0714e) != null) {
            return abstractC0728s;
        }
        identityHashMap.put(interfaceC0714e, Boolean.TRUE);
        try {
            AbstractC0728s abstractC0728sFindConvertingContentSerializer = findConvertingContentSerializer(abstractC0709K, interfaceC0714e, abstractC0728s);
            return abstractC0728sFindConvertingContentSerializer != null ? abstractC0709K.m1704D(abstractC0728sFindConvertingContentSerializer, interfaceC0714e) : abstractC0728s;
        } finally {
            identityHashMap.remove(interfaceC0714e);
        }
    }

    @Deprecated
    public AbstractC0728s findConvertingContentSerializer(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e, AbstractC0728s abstractC0728s) {
        AbstractC1041l abstractC1041lMo1805c;
        Object objMo1745Q;
        AbstractC0711b abstractC0711bM2149d = abstractC0709K.f1966e.m2149d();
        if (!_neitherNull(abstractC0711bM2149d, interfaceC0714e) || (abstractC1041lMo1805c = interfaceC0714e.mo1805c()) == null || (objMo1745Q = abstractC0711bM2149d.mo1745Q(abstractC1041lMo1805c)) == null) {
            return abstractC0728s;
        }
        interfaceC0714e.mo1805c();
        InterfaceC1748m interfaceC1748mM1812d = abstractC0709K.m1812d(objMo1745Q);
        abstractC0709K.mo1711f();
        AbstractC0721l abstractC0721l = ((C1160l) interfaceC1748mM1812d).f4009a;
        if (abstractC0728s == null && !abstractC0721l.m1889x() && (abstractC0728s = abstractC0709K.f1975n.m3094a(abstractC0721l)) == null && (abstractC0728s = abstractC0709K.f1969h.m39Q(abstractC0721l)) == null && (abstractC0728s = abstractC0709K.m1714l(abstractC0721l)) == null) {
            abstractC0728s = abstractC0709K.m1702B(abstractC0721l.f2036e);
        }
        return new StdDelegatingSerializer(interfaceC1748mM1812d, abstractC0721l, abstractC0728s);
    }

    public Boolean findFormatFeature(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e, Class<?> cls, EnumC0499n enumC0499n) {
        C0502q c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, cls);
        if (c0502qFindFormatOverrides != null) {
            return c0502qFindFormatOverrides.m1015b(enumC0499n);
        }
        return null;
    }

    public C0502q findFormatOverrides(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e, Class<?> cls) {
        return interfaceC0714e != null ? interfaceC0714e.mo1806d(abstractC0709K.f1966e, cls) : abstractC0709K.f1966e.mo2151f(cls);
    }

    public C0453A findIncludeOverrides(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e, Class<?> cls) {
        if (interfaceC0714e != null) {
            return interfaceC0714e.mo1807e(abstractC0709K.f1966e, cls);
        }
        C0707I c0707i = abstractC0709K.f1966e;
        c0707i.mo2150e(cls);
        C0453A c0453a = c0707i.f2490m.f2448f;
        if (c0453a == null) {
            return null;
        }
        return c0453a;
    }

    public InterfaceC1641i findPropertyFilter(AbstractC0709K abstractC0709K, Object obj, Object obj2) {
        abstractC0709K.f1966e.getClass();
        AbstractC0032g.m162t(abstractC0709K.m1815j(handledType(), "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured"));
        return null;
    }

    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        return createSchemaNode("string");
    }

    @Override // p069X0.AbstractC0728s
    public Class<T> handledType() {
        return this._handledType;
    }

    public boolean isDefaultSerializer(AbstractC0728s abstractC0728s) {
        return AbstractC1745j.m3899v(abstractC0728s);
    }

    @Override // p069X0.AbstractC0728s
    public abstract void serialize(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K);

    public void visitArrayFormat(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, AbstractC0728s abstractC0728s, AbstractC0721l abstractC0721l2) {
        interfaceC1338c.getClass();
        if (_neitherNull(null, abstractC0728s)) {
            throw null;
        }
    }

    public void visitFloatFormat(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, EnumC0544l enumC0544l) {
        interfaceC1338c.getClass();
    }

    public void visitIntFormat(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, EnumC0544l enumC0544l) {
        interfaceC1338c.getClass();
        if (_neitherNull(null, enumC0544l)) {
            throw null;
        }
    }

    public void visitStringFormat(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void wrapAndThrow(p069X0.AbstractC0709K r2, java.lang.Throwable r3, java.lang.Object r4, java.lang.String r5) throws java.io.IOException {
        /*
            r1 = this;
        L0:
            boolean r0 = r3 instanceof java.lang.reflect.InvocationTargetException
            if (r0 == 0) goto Lf
            java.lang.Throwable r0 = r3.getCause()
            if (r0 == 0) goto Lf
            java.lang.Throwable r3 = r3.getCause()
            goto L0
        Lf:
            p118m1.AbstractC1745j.m3873C(r3)
            if (r2 == 0) goto L21
            X0.J r0 = p069X0.EnumC0708J.WRAP_EXCEPTIONS
            X0.I r2 = r2.f1966e
            boolean r2 = r2.m1698r(r0)
            if (r2 == 0) goto L1f
            goto L21
        L1f:
            r2 = 0
            goto L22
        L21:
            r2 = 1
        L22:
            boolean r0 = r3 instanceof java.io.IOException
            if (r0 == 0) goto L2f
            if (r2 == 0) goto L2c
            boolean r2 = r3 instanceof p042N0.AbstractC0535c
            if (r2 != 0) goto L34
        L2c:
            java.io.IOException r3 = (java.io.IOException) r3
            throw r3
        L2f:
            if (r2 != 0) goto L34
            p118m1.AbstractC1745j.m3875E(r3)
        L34:
            int r2 = p069X0.C0724o.f2045h
            X0.n r2 = new X0.n
            r2.<init>(r5, r4)
            X0.o r2 = p069X0.C0724o.m1894g(r3, r2)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(X0.K, java.lang.Throwable, java.lang.Object, java.lang.String):void");
    }

    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type, boolean z3) {
        C1514v c1514v = (C1514v) getSchema(abstractC0709K, type);
        if (!z3) {
            boolean z4 = !z3;
            c1514v.f5435e.getClass();
            c1514v.f5464f.put("required", z4 ? C1497e.f5432f : C1497e.f5433g);
        }
        return c1514v;
    }

    public void visitStringFormat(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, EnumC1339d enumC1339d) {
        interfaceC1338c.getClass();
    }

    public StdSerializer(AbstractC0721l abstractC0721l) {
        this._handledType = abstractC0721l.f2036e;
    }

    public C1514v createSchemaNode(String str, boolean z3) {
        C1497e c1497e;
        C1514v c1514vCreateSchemaNode = createSchemaNode(str);
        if (!z3) {
            boolean z4 = !z3;
            c1514vCreateSchemaNode.f5435e.getClass();
            if (z4) {
                c1497e = C1497e.f5432f;
            } else {
                c1497e = C1497e.f5433g;
            }
            c1514vCreateSchemaNode.f5464f.put("required", c1497e);
        }
        return c1514vCreateSchemaNode;
    }

    public void visitArrayFormat(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, EnumC1337b enumC1337b) {
        interfaceC1338c.getClass();
    }

    public void visitIntFormat(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l, EnumC0544l enumC0544l, EnumC1339d enumC1339d) {
        interfaceC1338c.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StdSerializer(Class<?> cls, boolean z3) {
        this._handledType = cls;
    }

    public StdSerializer(StdSerializer<?> stdSerializer) {
        this._handledType = (Class<T>) stdSerializer._handledType;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void wrapAndThrow(p069X0.AbstractC0709K r2, java.lang.Throwable r3, java.lang.Object r4, int r5) throws java.io.IOException {
        /*
            r1 = this;
        L0:
            boolean r0 = r3 instanceof java.lang.reflect.InvocationTargetException
            if (r0 == 0) goto Lf
            java.lang.Throwable r0 = r3.getCause()
            if (r0 == 0) goto Lf
            java.lang.Throwable r3 = r3.getCause()
            goto L0
        Lf:
            p118m1.AbstractC1745j.m3873C(r3)
            if (r2 == 0) goto L21
            X0.J r0 = p069X0.EnumC0708J.WRAP_EXCEPTIONS
            X0.I r2 = r2.f1966e
            boolean r2 = r2.m1698r(r0)
            if (r2 == 0) goto L1f
            goto L21
        L1f:
            r2 = 0
            goto L22
        L21:
            r2 = 1
        L22:
            boolean r0 = r3 instanceof java.io.IOException
            if (r0 == 0) goto L2f
            if (r2 == 0) goto L2c
            boolean r2 = r3 instanceof p042N0.AbstractC0535c
            if (r2 != 0) goto L34
        L2c:
            java.io.IOException r3 = (java.io.IOException) r3
            throw r3
        L2f:
            if (r2 != 0) goto L34
            p118m1.AbstractC1745j.m3875E(r3)
        L34:
            X0.o r2 = p069X0.C0724o.m1895h(r3, r4, r5)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StdSerializer.wrapAndThrow(X0.K, java.lang.Throwable, java.lang.Object, int):void");
    }
}

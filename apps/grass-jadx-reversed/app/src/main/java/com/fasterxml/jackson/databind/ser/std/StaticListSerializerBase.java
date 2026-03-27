package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.util.Collection;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0725p;
import p069X0.AbstractC0728s;
import p069X0.InterfaceC0714e;
import p092e1.InterfaceC1336a;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p109j1.C1514v;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements InterfaceC1638f {
    protected final Boolean _unwrapSingle;

    public StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    public abstract AbstractC0728s _withResolved(InterfaceC0714e interfaceC0714e, Boolean bool);

    public abstract void acceptContentVisitor(InterfaceC1336a interfaceC1336a);

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    public abstract AbstractC0725p contentSchema();

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override // p112k1.InterfaceC1638f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public p069X0.AbstractC0728s createContextual(p069X0.AbstractC0709K r6, p069X0.InterfaceC0714e r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L1a
            X0.I r1 = r6.f1966e
            X0.b r1 = r1.m2149d()
            b1.l r2 = r7.mo1805c()
            if (r2 == 0) goto L1a
            java.lang.Object r1 = r1.mo1761d(r2)
            if (r1 == 0) goto L1a
            X0.s r1 = r6.mo1709I(r2, r1)
            goto L1b
        L1a:
            r1 = r0
        L1b:
            java.lang.Class r2 = r5.handledType()
            M0.q r2 = r5.findFormatOverrides(r6, r7, r2)
            if (r2 == 0) goto L2c
            M0.n r3 = p039M0.EnumC0499n.f1151i
            java.lang.Boolean r2 = r2.m1015b(r3)
            goto L2d
        L2c:
            r2 = r0
        L2d:
            X0.s r1 = r5.findContextualConvertingSerializer(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L39
            X0.s r1 = r6.m1721s(r3, r7)
        L39:
            boolean r4 = r5.isDefaultSerializer(r1)
            if (r4 == 0) goto L4d
            java.lang.Boolean r6 = r5._unwrapSingle
            boolean r6 = java.util.Objects.equals(r2, r6)
            if (r6 == 0) goto L48
            return r5
        L48:
            X0.s r6 = r5._withResolved(r7, r2)
            return r6
        L4d:
            com.fasterxml.jackson.databind.ser.std.CollectionSerializer r7 = new com.fasterxml.jackson.databind.ser.std.CollectionSerializer
            X0.l r6 = r6.m1811c(r3)
            r2 = 1
            r7.<init>(r6, r2, r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase.createContextual(X0.K, X0.e):X0.s");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer
    @Deprecated
    public AbstractC0725p getSchema(AbstractC0709K abstractC0709K, Type type) {
        C1514v c1514vCreateSchemaNode = createSchemaNode("array", true);
        c1514vCreateSchemaNode.m3559s("items", contentSchema());
        return c1514vCreateSchemaNode;
    }

    @Override // p069X0.AbstractC0728s
    public abstract void serializeWithType(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h);

    @Override // p069X0.AbstractC0728s
    public boolean isEmpty(AbstractC0709K abstractC0709K, T t3) {
        return t3 == null || t3.isEmpty();
    }

    public StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, Boolean bool) {
        super(staticListSerializerBase);
        this._unwrapSingle = bool;
    }
}

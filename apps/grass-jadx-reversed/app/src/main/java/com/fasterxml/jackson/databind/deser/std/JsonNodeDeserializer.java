package com.fasterxml.jackson.databind.deser.std;

import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0725p;
import p069X0.C0717h;
import p069X0.InterfaceC0714e;
import p078a1.C0850b;
import p100g1.AbstractC1398g;
import p109j1.C1493a;
import p109j1.C1505m;
import p109j1.C1512t;
import p109j1.C1514v;
import p114l1.EnumC1664f;

/* JADX INFO: loaded from: classes.dex */
public class JsonNodeDeserializer extends BaseNodeDeserializer<AbstractC0725p> {
    private static final JsonNodeDeserializer instance = new JsonNodeDeserializer();

    public static final class ArrayDeserializer extends BaseNodeDeserializer<C1493a> {
        protected static final ArrayDeserializer _instance = new ArrayDeserializer();
        private static final long serialVersionUID = 1;

        public ArrayDeserializer() {
            super(C1493a.class, Boolean.TRUE);
        }

        public static ArrayDeserializer getInstance() {
            return _instance;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
        public AbstractC0722m _createWithMerge(boolean z3, boolean z4) {
            return new ArrayDeserializer(this, z3, z4);
        }

        public ArrayDeserializer(ArrayDeserializer arrayDeserializer, boolean z3, boolean z4) {
            super(arrayDeserializer, z3, z4);
        }

        @Override // p069X0.AbstractC0722m
        public C1493a deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            if (abstractC0545m.mo1172Q()) {
                C1505m c1505m = abstractC0718i.f1998g.f1988r;
                c1505m.getClass();
                C1493a c1493a = new C1493a(c1505m);
                _deserializeContainerNoRecursion(abstractC0545m, abstractC0718i, c1505m, new C1185a(), c1493a);
                return c1493a;
            }
            abstractC0718i.m1825C(abstractC0545m, C1493a.class);
            throw null;
        }

        @Override // p069X0.AbstractC0722m
        public C1493a deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1493a c1493a) throws C0850b {
            if (abstractC0545m.mo1172Q()) {
                _deserializeContainerNoRecursion(abstractC0545m, abstractC0718i, abstractC0718i.f1998g.f1988r, new C1185a(), c1493a);
                return c1493a;
            }
            abstractC0718i.m1825C(abstractC0545m, C1493a.class);
            throw null;
        }
    }

    public static final class ObjectDeserializer extends BaseNodeDeserializer<C1514v> {
        protected static final ObjectDeserializer _instance = new ObjectDeserializer();
        private static final long serialVersionUID = 1;

        public ObjectDeserializer() {
            super(C1514v.class, Boolean.TRUE);
        }

        public static ObjectDeserializer getInstance() {
            return _instance;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
        public AbstractC0722m _createWithMerge(boolean z3, boolean z4) {
            return new ObjectDeserializer(this, z3, z4);
        }

        public ObjectDeserializer(ObjectDeserializer objectDeserializer, boolean z3, boolean z4) {
            super(objectDeserializer, z3, z4);
        }

        @Override // p069X0.AbstractC0722m
        public C1514v deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, C1514v c1514v) throws C0850b {
            if (!abstractC0545m.mo1173R() && !abstractC0545m.mo1168M(EnumC0548p.FIELD_NAME)) {
                abstractC0718i.m1825C(abstractC0545m, C1514v.class);
                throw null;
            }
            return (C1514v) updateObject(abstractC0545m, abstractC0718i, c1514v, new C1185a());
        }

        @Override // p069X0.AbstractC0722m
        public C1514v deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
            C1505m c1505m = abstractC0718i.f1998g.f1988r;
            if (abstractC0545m.mo1173R()) {
                c1505m.getClass();
                C1514v c1514v = new C1514v(c1505m);
                _deserializeContainerNoRecursion(abstractC0545m, abstractC0718i, c1505m, new C1185a(), c1514v);
                return c1514v;
            }
            if (abstractC0545m.mo1168M(EnumC0548p.FIELD_NAME)) {
                return _deserializeObjectAtName(abstractC0545m, abstractC0718i, c1505m, new C1185a());
            }
            if (abstractC0545m.mo1168M(EnumC0548p.END_OBJECT)) {
                c1505m.getClass();
                return new C1514v(c1505m);
            }
            abstractC0718i.m1825C(abstractC0545m, C1514v.class);
            throw null;
        }
    }

    public JsonNodeDeserializer() {
        super(AbstractC0725p.class, null);
    }

    public static AbstractC0722m getDeserializer(Class<?> cls) {
        return cls == C1514v.class ? ObjectDeserializer.getInstance() : cls == C1493a.class ? ArrayDeserializer.getInstance() : instance;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer
    public AbstractC0722m _createWithMerge(boolean z3, boolean z4) {
        return new JsonNodeDeserializer(this, z3, z4);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, com.fasterxml.jackson.databind.deser.InterfaceC1139f
    public /* bridge */ /* synthetic */ AbstractC0722m createContextual(AbstractC0718i abstractC0718i, InterfaceC0714e interfaceC0714e) {
        return super.createContextual(abstractC0718i, interfaceC0714e);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ Object deserializeWithType(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i, AbstractC1398g abstractC1398g) {
        return super.deserializeWithType(abstractC0545m, abstractC0718i, abstractC1398g);
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public Object getAbsentValue(AbstractC0718i abstractC0718i) {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ boolean isCachable() {
        return super.isCachable();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, p069X0.AbstractC0722m
    public /* bridge */ /* synthetic */ EnumC1664f logicalType() {
        return super.logicalType();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, p069X0.AbstractC0722m
    public Boolean supportsUpdate(C0717h c0717h) {
        return this._supportsUpdates;
    }

    public JsonNodeDeserializer(JsonNodeDeserializer jsonNodeDeserializer, boolean z3, boolean z4) {
        super(jsonNodeDeserializer, z3, z4);
    }

    @Override // p069X0.AbstractC0722m
    public AbstractC0725p deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        C1185a c1185a = new C1185a();
        C1505m c1505m = abstractC0718i.f1998g.f1988r;
        int iMo1191f = abstractC0545m.mo1191f();
        if (iMo1191f == 1) {
            c1505m.getClass();
            return _deserializeContainerNoRecursion(abstractC0545m, abstractC0718i, c1505m, c1185a, new C1514v(c1505m));
        }
        if (iMo1191f == 2) {
            c1505m.getClass();
            return new C1514v(c1505m);
        }
        if (iMo1191f != 3) {
            return iMo1191f != 5 ? _deserializeAnyScalar(abstractC0545m, abstractC0718i) : _deserializeObjectAtName(abstractC0545m, abstractC0718i, c1505m, c1185a);
        }
        c1505m.getClass();
        return _deserializeContainerNoRecursion(abstractC0545m, abstractC0718i, c1505m, c1185a, new C1493a(c1505m));
    }

    @Override // p069X0.AbstractC0722m, com.fasterxml.jackson.databind.deser.InterfaceC1178m
    public AbstractC0725p getNullValue(AbstractC0718i abstractC0718i) {
        abstractC0718i.f1998g.f1988r.getClass();
        return C1512t.f5463e;
    }
}

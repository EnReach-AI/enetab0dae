package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.JsonDeserializer$None;
import com.fasterxml.jackson.databind.deser.impl.AbstractC1145C;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p005B.AbstractC0032g;
import p039M0.AbstractC0485d0;
import p039M0.C0483c0;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p069X0.AbstractC0729t;
import p069X0.AbstractC0730u;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.EnumC0719j;
import p069X0.EnumC0731v;
import p078a1.C0850b;
import p118m1.AbstractC1745j;
import p118m1.C1761z;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1142i extends AbstractC0718i {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: p */
    public transient LinkedHashMap f3951p;

    /* JADX INFO: renamed from: q */
    public ArrayList f3952q;

    @Override // p069X0.AbstractC0718i
    /* JADX INFO: renamed from: L */
    public final AbstractC0730u mo1834L(Object obj) {
        AbstractC0730u abstractC0730u;
        if (obj == null) {
            return null;
        }
        if (obj instanceof AbstractC0730u) {
            abstractC0730u = (AbstractC0730u) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == AbstractC0729t.class || AbstractC1745j.m3897t(cls)) {
                return null;
            }
            if (!AbstractC0730u.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<KeyDeserializer>");
            }
            C0717h c0717h = this.f1998g;
            c0717h.m2153h();
            abstractC0730u = (AbstractC0730u) AbstractC1745j.m3885h(cls, c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        if (abstractC0730u instanceof InterfaceC1179n) {
            ((InterfaceC1179n) abstractC0730u).resolve(this);
        }
        return abstractC0730u;
    }

    /* JADX INFO: renamed from: a0 */
    public final void m2974a0() {
        if (this.f3951p != null && m1833K(EnumC0719j.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
            Iterator it = this.f3951p.entrySet().iterator();
            while (it.hasNext()) {
                ((AbstractC1145C) ((Map.Entry) it.next()).getValue()).getClass();
            }
        }
    }

    /* JADX INFO: renamed from: b0 */
    public final Object m2975b0(AbstractC0545m abstractC0545m, AbstractC0721l abstractC0721l, AbstractC0722m abstractC0722m, Object obj) throws C0850b {
        C0717h c0717h = this.f1998g;
        if (!(c0717h.f2486i != null ? !r1.m1688c() : c0717h.m1820r(EnumC0719j.UNWRAP_ROOT_VALUE))) {
            return obj == null ? abstractC0722m.deserialize(abstractC0545m, this) : abstractC0722m.deserialize(abstractC0545m, this, obj);
        }
        C0703E c0703eM3913a = c0717h.f2486i;
        if (c0703eM3913a == null) {
            C1761z c1761z = c0717h.f2489l;
            c1761z.getClass();
            c0703eM3913a = c1761z.m3913a(c0717h, abstractC0721l.f2036e);
        }
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        EnumC0548p enumC0548p = EnumC0548p.START_OBJECT;
        String str = c0703eM3913a.f1928e;
        if (enumC0548pMo1190e != enumC0548p) {
            m1843V(enumC0548p, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", AbstractC1745j.m3902y(str), abstractC0545m.mo1190e());
            throw null;
        }
        EnumC0548p enumC0548pMo1177V = abstractC0545m.mo1177V();
        EnumC0548p enumC0548p2 = EnumC0548p.FIELD_NAME;
        if (enumC0548pMo1177V != enumC0548p2) {
            m1843V(enumC0548p2, "Current token not FIELD_NAME (to contain expected root name %s), but %s", AbstractC1745j.m3902y(str), abstractC0545m.mo1190e());
            throw null;
        }
        String strMo1188d = abstractC0545m.mo1188d();
        if (!str.equals(strMo1188d)) {
            Object[] objArr = {AbstractC1745j.m3902y(strMo1188d), AbstractC1745j.m3880c(str), AbstractC1745j.m3895r(abstractC0721l)};
            Class cls = abstractC0721l.f2036e;
            C0850b c0850b = new C0850b((Closeable) this.f2002k, String.format("Root name (%s) does not match expected (%s) for type %s", objArr));
            if (strMo1188d == null) {
                throw c0850b;
            }
            c0850b.mo1816d(strMo1188d, cls);
            throw c0850b;
        }
        abstractC0545m.mo1177V();
        Object objDeserialize = obj == null ? abstractC0722m.deserialize(abstractC0545m, this) : abstractC0722m.deserialize(abstractC0545m, this, obj);
        EnumC0548p enumC0548pMo1177V2 = abstractC0545m.mo1177V();
        EnumC0548p enumC0548p3 = EnumC0548p.END_OBJECT;
        if (enumC0548pMo1177V2 == enumC0548p3) {
            return objDeserialize;
        }
        m1843V(enumC0548p3, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", AbstractC1745j.m3880c(str), abstractC0545m.mo1190e());
        throw null;
    }

    @Override // p069X0.AbstractC0718i
    /* JADX INFO: renamed from: n */
    public final AbstractC0722m mo1849n(Object obj) {
        AbstractC0722m abstractC0722m;
        if (obj == null) {
            return null;
        }
        if (obj instanceof AbstractC0722m) {
            abstractC0722m = (AbstractC0722m) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == JsonDeserializer$None.class || AbstractC1745j.m3897t(cls)) {
                return null;
            }
            if (!AbstractC0722m.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
            }
            C0717h c0717h = this.f1998g;
            c0717h.m2153h();
            abstractC0722m = (AbstractC0722m) AbstractC1745j.m3885h(cls, c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        if (abstractC0722m instanceof InterfaceC1179n) {
            ((InterfaceC1179n) abstractC0722m).resolve(this);
        }
        return abstractC0722m;
    }

    @Override // p069X0.AbstractC0718i
    /* JADX INFO: renamed from: t */
    public final AbstractC1145C mo1855t(Object obj, AbstractC0485d0 abstractC0485d0) {
        if (obj == null) {
            return null;
        }
        C0483c0 c0483c0Mo1004d = abstractC0485d0.mo1004d(obj);
        LinkedHashMap linkedHashMap = this.f3951p;
        if (linkedHashMap == null) {
            this.f3951p = new LinkedHashMap();
        }
        ArrayList arrayList = this.f3952q;
        if (arrayList == null) {
            this.f3952q = new ArrayList(8);
            throw null;
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw null;
        }
        AbstractC0032g.m162t(it.next());
        throw null;
    }
}

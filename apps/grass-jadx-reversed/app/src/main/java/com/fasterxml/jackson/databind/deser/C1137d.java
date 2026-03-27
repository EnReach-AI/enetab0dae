package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.deser.impl.C1149a;
import com.fasterxml.jackson.databind.deser.impl.C1167s;
import com.fasterxml.jackson.databind.deser.impl.C1169u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p039M0.EnumC0499n;
import p069X0.AbstractC0711b;
import p069X0.AbstractC0712c;
import p069X0.AbstractC0716g;
import p069X0.AbstractC0718i;
import p069X0.C0702D;
import p069X0.C0703E;
import p069X0.C0717h;
import p069X0.EnumC0731v;
import p082b1.C1005A;
import p082b1.C1043n;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1137d {

    /* JADX INFO: renamed from: a */
    public final C0717h f3931a;

    /* JADX INFO: renamed from: b */
    public final AbstractC0718i f3932b;

    /* JADX INFO: renamed from: c */
    public final AbstractC0712c f3933c;

    /* JADX INFO: renamed from: d */
    public final LinkedHashMap f3934d = new LinkedHashMap();

    /* JADX INFO: renamed from: e */
    public ArrayList f3935e;

    /* JADX INFO: renamed from: f */
    public HashMap f3936f;

    /* JADX INFO: renamed from: g */
    public HashSet f3937g;

    /* JADX INFO: renamed from: h */
    public HashSet f3938h;

    /* JADX INFO: renamed from: i */
    public AbstractC1208x f3939i;

    /* JADX INFO: renamed from: j */
    public C1167s f3940j;

    /* JADX INFO: renamed from: k */
    public AbstractC1183r f3941k;

    /* JADX INFO: renamed from: l */
    public boolean f3942l;

    /* JADX INFO: renamed from: m */
    public C1043n f3943m;

    public C1137d(C1005A c1005a, AbstractC0718i abstractC0718i) {
        this.f3933c = c1005a;
        this.f3932b = abstractC0718i;
        this.f3931a = abstractC0718i.f1998g;
    }

    /* JADX INFO: renamed from: a */
    public final Map m2948a(Collection collection) {
        AbstractC0711b abstractC0711bM2149d = this.f3931a.m2149d();
        HashMap map = null;
        if (abstractC0711bM2149d != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                AbstractC1204t abstractC1204t = (AbstractC1204t) it.next();
                List listMo1733E = abstractC0711bM2149d.mo1733E(abstractC1204t.mo1805c());
                if (listMo1733E != null && !listMo1733E.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(abstractC1204t.f4102g.f1928e, listMo1733E);
                }
            }
        }
        return map == null ? Collections.emptyMap() : map;
    }

    /* JADX INFO: renamed from: b */
    public final void m2949b(Collection collection) {
        C0717h c0717h = this.f3931a;
        c0717h.getClass();
        if (c0717h.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                try {
                    ((AbstractC1204t) it.next()).mo2969n(c0717h);
                } catch (IllegalArgumentException e3) {
                    m2950c(e3);
                    throw null;
                }
            }
        }
        AbstractC1183r abstractC1183r = this.f3941k;
        if (abstractC1183r != null) {
            try {
                abstractC1183r.getClass();
                abstractC1183r.f4044f.m2799h(c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            } catch (IllegalArgumentException e4) {
                m2950c(e4);
                throw null;
            }
        }
        C1043n c1043n = this.f3943m;
        if (c1043n != null) {
            try {
                c1043n.m2799h(c0717h.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            } catch (IllegalArgumentException e5) {
                m2950c(e5);
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2950c(IllegalArgumentException illegalArgumentException) {
        try {
            this.f3932b.m1839Q(this.f3933c, illegalArgumentException.getMessage(), new Object[0]);
            throw null;
        } catch (AbstractC0716g e3) {
            if (e3.getCause() == null) {
                e3.initCause(illegalArgumentException);
            }
            throw e3;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m2951d(String str) {
        if (this.f3937g == null) {
            this.f3937g = new HashSet();
        }
        this.f3937g.add(str);
    }

    /* JADX INFO: renamed from: e */
    public final void m2952e(AbstractC1204t abstractC1204t) {
        LinkedHashMap linkedHashMap = this.f3934d;
        C0703E c0703e = abstractC1204t.f4102g;
        AbstractC1204t abstractC1204t2 = (AbstractC1204t) linkedHashMap.put(c0703e.f1928e, abstractC1204t);
        if (abstractC1204t2 == null || abstractC1204t2 == abstractC1204t) {
            return;
        }
        throw new IllegalArgumentException("Duplicate property '" + c0703e.f1928e + "' for " + this.f3933c.f1980a);
    }

    /* JADX INFO: renamed from: f */
    public final BeanDeserializer m2953f() {
        boolean z3;
        Collection collectionValues = this.f3934d.values();
        m2949b(collectionValues);
        Map mapM2948a = m2948a(collectionValues);
        Boolean boolM1015b = this.f3933c.mo1800b().m1015b(EnumC0499n.f1148f);
        C0717h c0717h = this.f3931a;
        C1149a c1149a = new C1149a(boolM1015b == null ? c0717h.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES) : boolM1015b.booleanValue(), collectionValues, mapM2948a, c0717h.f2481f.f2427m);
        c1149a.m2983c();
        boolean z4 = !c0717h.m2157l(EnumC0731v.DEFAULT_VIEW_INCLUSION);
        if (z4) {
            z3 = z4;
        } else {
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((AbstractC1204t) it.next()).mo3036x()) {
                    z3 = true;
                    break;
                }
            }
            z3 = z4;
        }
        if (this.f3940j != null) {
            c1149a = c1149a.m2989i(new C1169u(this.f3940j, C0702D.f1916l));
        }
        return new BeanDeserializer(this, this.f3933c, c1149a, this.f3936f, this.f3937g, this.f3942l, this.f3938h, z3);
    }
}

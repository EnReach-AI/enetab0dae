package p112k1;

import com.fasterxml.jackson.databind.ser.impl.AbstractC1223k;
import com.fasterxml.jackson.databind.ser.impl.C1213a;
import p039M0.EnumC0511z;
import p042N0.AbstractC0540h;
import p050Q0.C0597j;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p100g1.AbstractC1399h;

/* JADX INFO: renamed from: k1.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1645m extends C1635c {
    private static final long serialVersionUID = 1;

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: n */
    public final void mo3087n(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Object objM1701A = abstractC0709K.m1701A(((C1213a) this).f4125w);
        if (objM1701A == null) {
            AbstractC0728s abstractC0728s = this.f5819p;
            if (abstractC0728s != null) {
                abstractC0728s.serialize(null, abstractC0540h, abstractC0709K);
                return;
            } else {
                abstractC0540h.mo1146s();
                return;
            }
        }
        AbstractC0728s abstractC0728sMo3097i = this.f5818o;
        if (abstractC0728sMo3097i == null) {
            Class<?> cls = objM1701A.getClass();
            AbstractC1223k abstractC1223k = this.f5821r;
            AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
            abstractC0728sMo3097i = abstractC0728sMo3092c == null ? mo3097i(abstractC1223k, cls, abstractC0709K) : abstractC0728sMo3092c;
        }
        Object obj2 = this.f5823t;
        if (obj2 != null) {
            if (EnumC0511z.f1184g == obj2) {
                if (abstractC0728sMo3097i.isEmpty(abstractC0709K, objM1701A)) {
                    m3717p(abstractC0540h, abstractC0709K);
                    return;
                }
            } else if (obj2.equals(objM1701A)) {
                m3717p(abstractC0540h, abstractC0709K);
                return;
            }
        }
        if (objM1701A == obj && m3716j(abstractC0540h, abstractC0709K, abstractC0728sMo3097i)) {
            return;
        }
        AbstractC1399h abstractC1399h = this.f5820q;
        if (abstractC1399h == null) {
            abstractC0728sMo3097i.serialize(objM1701A, abstractC0540h, abstractC0709K);
        } else {
            abstractC0728sMo3097i.serializeWithType(objM1701A, abstractC0540h, abstractC0709K, abstractC1399h);
        }
    }

    @Override // p112k1.C1635c
    /* JADX INFO: renamed from: o */
    public final void mo3088o(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        Object objM1701A = abstractC0709K.m1701A(((C1213a) this).f4125w);
        C0597j c0597j = this.f5810g;
        if (objM1701A == null) {
            if (this.f5819p != null) {
                abstractC0540h.mo1144q(c0597j);
                this.f5819p.serialize(null, abstractC0540h, abstractC0709K);
                return;
            }
            return;
        }
        AbstractC0728s abstractC0728sMo3097i = this.f5818o;
        if (abstractC0728sMo3097i == null) {
            Class<?> cls = objM1701A.getClass();
            AbstractC1223k abstractC1223k = this.f5821r;
            AbstractC0728s abstractC0728sMo3092c = abstractC1223k.mo3092c(cls);
            abstractC0728sMo3097i = abstractC0728sMo3092c == null ? mo3097i(abstractC1223k, cls, abstractC0709K) : abstractC0728sMo3092c;
        }
        Object obj2 = this.f5823t;
        if (obj2 != null) {
            if (EnumC0511z.f1184g == obj2) {
                if (abstractC0728sMo3097i.isEmpty(abstractC0709K, objM1701A)) {
                    return;
                }
            } else if (obj2.equals(objM1701A)) {
                return;
            }
        }
        if (objM1701A == obj && m3716j(abstractC0540h, abstractC0709K, abstractC0728sMo3097i)) {
            return;
        }
        abstractC0540h.mo1144q(c0597j);
        AbstractC1399h abstractC1399h = this.f5820q;
        if (abstractC1399h == null) {
            abstractC0728sMo3097i.serialize(objM1701A, abstractC0540h, abstractC0709K);
        } else {
            abstractC0728sMo3097i.serializeWithType(objM1701A, abstractC0540h, abstractC0709K, abstractC1399h);
        }
    }
}

package p103h1;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.C0538f;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0721l;
import p069X0.C0717h;
import p069X0.EnumC0731v;
import p069X0.InterfaceC0714e;
import p082b1.AbstractC1007C;
import p100g1.AbstractC1398g;
import p100g1.C1394c;
import p118m1.AbstractC1745j;
import p118m1.C1730E;

/* JADX INFO: renamed from: h1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1414b extends C1419g {

    /* JADX INFO: renamed from: r */
    public static final BitSet f5038r = new BitSet(0);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: p */
    public final Map f5039p;

    /* JADX INFO: renamed from: q */
    public final Map f5040q;

    public C1414b(AbstractC0721l abstractC0721l, AbstractC1429q abstractC1429q, AbstractC0721l abstractC0721l2, C0717h c0717h, ArrayList arrayList) {
        super(abstractC0721l, abstractC1429q, null, false, abstractC0721l2, null, true);
        this.f5039p = new HashMap();
        boolean zM2157l = c0717h.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            C1394c c1394c = (C1394c) it.next();
            List listM2698f = c0717h.m1818p(c0717h.f2481f.f2419e.m3780j(c1394c.f5024e)).m2698f();
            BitSet bitSet = new BitSet(listM2698f.size() + i3);
            Iterator it2 = listM2698f.iterator();
            while (it2.hasNext()) {
                String strMo1808f = ((AbstractC1007C) it2.next()).mo1808f();
                strMo1808f = zM2157l ? strMo1808f.toLowerCase() : strMo1808f;
                Map map2 = this.f5039p;
                Integer numValueOf = (Integer) map2.get(strMo1808f);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i3);
                    map2.put(strMo1808f, Integer.valueOf(i3));
                    i3++;
                }
                bitSet.set(numValueOf.intValue());
            }
            Class cls = c1394c.f5024e;
            String str = (String) map.put(bitSet, cls.getName());
            if (str != null) {
                throw new IllegalStateException(AbstractC0032g.m156n("Subtypes ", str, " and ", cls.getName(), " have the same signature and cannot be uniquely deduced."));
            }
        }
        this.f5040q = map;
    }

    @Override // p103h1.C1419g, p103h1.C1413a, p100g1.AbstractC1398g
    /* JADX INFO: renamed from: d */
    public final Object mo3402d(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0538f {
        String str;
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.START_OBJECT) {
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        } else if (enumC0548pMo1190e != EnumC0548p.FIELD_NAME) {
            return m3425m(abstractC0545m, abstractC0718i, null, "Unexpected input");
        }
        EnumC0548p enumC0548p = EnumC0548p.END_OBJECT;
        Map map = this.f5040q;
        if (enumC0548pMo1190e == enumC0548p && (str = (String) map.get(f5038r)) != null) {
            return m3424l(abstractC0545m, abstractC0718i, null, str);
        }
        LinkedList linkedList = new LinkedList(map.keySet());
        C1730E c1730eM1847l = abstractC0718i.m1847l(abstractC0545m);
        boolean zM2157l = abstractC0718i.f1998g.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            String strMo1188d = abstractC0545m.mo1188d();
            if (zM2157l) {
                strMo1188d = strMo1188d.toLowerCase();
            }
            c1730eM1847l.m3862g0(abstractC0545m);
            Integer num = (Integer) this.f5039p.get(strMo1188d);
            if (num != null) {
                int iIntValue = num.intValue();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    if (!((BitSet) it.next()).get(iIntValue)) {
                        it.remove();
                    }
                }
                if (linkedList.size() == 1) {
                    return m3424l(abstractC0545m, abstractC0718i, c1730eM1847l, (String) map.get(linkedList.get(0)));
                }
            }
            enumC0548pMo1190e = abstractC0545m.mo1177V();
        }
        return m3425m(abstractC0545m, abstractC0718i, c1730eM1847l, String.format("Cannot deduce unique subtype of %s (%d candidates match)", AbstractC1745j.m3895r(this.f5061f), Integer.valueOf(linkedList.size())));
    }

    @Override // p103h1.C1419g, p103h1.C1413a, p100g1.AbstractC1398g
    /* JADX INFO: renamed from: f */
    public final AbstractC1398g mo3404f(InterfaceC0714e interfaceC0714e) {
        return interfaceC0714e == this.f5062g ? this : new C1414b(this, interfaceC0714e);
    }

    public C1414b(C1414b c1414b, InterfaceC0714e interfaceC0714e) {
        super(c1414b, interfaceC0714e);
        this.f5039p = c1414b.f5039p;
        this.f5040q = c1414b.f5040q;
    }
}

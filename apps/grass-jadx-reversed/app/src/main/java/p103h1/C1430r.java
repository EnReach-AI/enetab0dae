package p103h1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import p069X0.AbstractC0715f;
import p069X0.AbstractC0721l;
import p069X0.EnumC0731v;
import p074Z0.AbstractC0832r;

/* JADX INFO: renamed from: h1.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1430r extends AbstractC1429q {

    /* JADX INFO: renamed from: c */
    public final AbstractC0832r f5070c;

    /* JADX INFO: renamed from: d */
    public final ConcurrentHashMap f5071d;

    /* JADX INFO: renamed from: e */
    public final HashMap f5072e;

    /* JADX INFO: renamed from: f */
    public final boolean f5073f;

    public C1430r(AbstractC0832r abstractC0832r, AbstractC0721l abstractC0721l, ConcurrentHashMap concurrentHashMap, HashMap map) {
        super(abstractC0721l, abstractC0832r.f2481f.f2419e);
        this.f5070c = abstractC0832r;
        this.f5071d = concurrentHashMap;
        this.f5072e = map;
        this.f5073f = abstractC0832r.m2157l(EnumC0731v.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: a */
    public final String mo3427a() {
        TreeSet treeSet = new TreeSet();
        for (Map.Entry entry : this.f5072e.entrySet()) {
            if (((AbstractC0721l) entry.getValue()).mo1886u()) {
                treeSet.add(entry.getKey());
            }
        }
        return treeSet.toString();
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: b */
    public final String mo3428b(Object obj) {
        return m3442e(obj.getClass());
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: c */
    public final String mo3429c(Object obj, Class cls) {
        return obj == null ? m3442e(cls) : m3442e(obj.getClass());
    }

    @Override // p103h1.AbstractC1429q
    /* JADX INFO: renamed from: d */
    public final AbstractC0721l mo3430d(AbstractC0715f abstractC0715f, String str) {
        if (this.f5073f) {
            str = str.toLowerCase();
        }
        return (AbstractC0721l) this.f5072e.get(str);
    }

    /* JADX INFO: renamed from: e */
    public final String m3442e(Class cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        ConcurrentHashMap concurrentHashMap = this.f5071d;
        String strMo1753Y = (String) concurrentHashMap.get(name);
        if (strMo1753Y == null) {
            Class cls2 = this.f5068a.m3780j(cls).f2036e;
            AbstractC0832r abstractC0832r = this.f5070c;
            abstractC0832r.getClass();
            if (abstractC0832r.m2157l(EnumC0731v.USE_ANNOTATIONS)) {
                strMo1753Y = abstractC0832r.m2149d().mo1753Y(abstractC0832r.m2156k(cls2).f3582e);
            }
            if (strMo1753Y == null) {
                String name2 = cls2.getName();
                int iLastIndexOf = name2.lastIndexOf(46);
                if (iLastIndexOf >= 0) {
                    name2 = name2.substring(iLastIndexOf + 1);
                }
                strMo1753Y = name2;
            }
            concurrentHashMap.put(name, strMo1753Y);
        }
        return strMo1753Y;
    }

    public final String toString() {
        return String.format("[%s; id-to-type=%s]", C1430r.class.getName(), this.f5072e);
    }
}

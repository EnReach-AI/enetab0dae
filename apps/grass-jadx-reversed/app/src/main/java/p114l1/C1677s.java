package p114l1;

import java.io.Serializable;
import java.util.ArrayList;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: l1.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1677s implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C1675q f5956e;

    public C1677s(C1675q c1675q) {
        this.f5956e = c1675q;
    }

    /* JADX INFO: renamed from: a */
    public static IllegalArgumentException m3781a(C1676r c1676r, String str) {
        int i3 = c1676r.f5954b;
        String str2 = c1676r.f5953a;
        return new IllegalArgumentException("Failed to parse type '" + str2 + "' (remaining: '" + str2.substring(i3) + "'): " + str);
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0721l m3782b(C1676r c1676r) {
        C1675q c1675q = this.f5956e;
        if (!c1676r.hasMoreTokens()) {
            throw m3781a(c1676r, "Unexpected end-of-string");
        }
        String strNextToken = c1676r.nextToken();
        try {
            c1675q.getClass();
            Class clsM3770k = C1675q.m3770k(strNextToken);
            if (c1676r.hasMoreTokens()) {
                String strNextToken2 = c1676r.nextToken();
                if ("<".equals(strNextToken2)) {
                    ArrayList arrayList = new ArrayList();
                    while (c1676r.hasMoreTokens()) {
                        arrayList.add(m3782b(c1676r));
                        if (!c1676r.hasMoreTokens()) {
                            break;
                        }
                        String strNextToken3 = c1676r.nextToken();
                        if (">".equals(strNextToken3)) {
                            AbstractC0721l[] abstractC0721lArr = C1674p.f5926j;
                            if (!arrayList.isEmpty()) {
                                abstractC0721lArr = (AbstractC0721l[]) arrayList.toArray(abstractC0721lArr);
                            }
                            return c1675q.m3775c(null, clsM3770k, C1674p.m3763c(clsM3770k, abstractC0721lArr));
                        }
                        if (!",".equals(strNextToken3)) {
                            throw m3781a(c1676r, "Unexpected token '" + strNextToken3 + "', expected ',' or '>')");
                        }
                    }
                    throw m3781a(c1676r, "Unexpected end-of-string");
                }
                c1676r.f5955c = strNextToken2;
            }
            return c1675q.m3775c(null, clsM3770k, C1674p.f5927k);
        } catch (Exception e3) {
            AbstractC1745j.m3875E(e3);
            throw m3781a(c1676r, "Cannot locate class '" + strNextToken + "', problem: " + e3.getMessage());
        }
    }
}

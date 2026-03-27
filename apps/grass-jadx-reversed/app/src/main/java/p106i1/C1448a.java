package p106i1;

import com.fasterxml.jackson.databind.deser.AbstractC1177l;
import java.io.Serializable;
import java.util.HashMap;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0722m;
import p114l1.C1660b;

/* JADX INFO: renamed from: i1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1448a extends AbstractC1177l implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public HashMap f5143e = null;

    /* JADX INFO: renamed from: f */
    public final boolean f5144f = false;

    /* JADX INFO: renamed from: a */
    public final AbstractC0722m m3456a(AbstractC0721l abstractC0721l) {
        HashMap map = this.f5143e;
        if (map == null) {
            return null;
        }
        return (AbstractC0722m) map.get(new C1660b(abstractC0721l.f2036e));
    }
}

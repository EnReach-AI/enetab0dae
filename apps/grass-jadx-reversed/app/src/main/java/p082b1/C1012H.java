package p082b1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import p074Z0.AbstractC0832r;
import p085c1.C1081b;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: b1.H */
/* JADX INFO: loaded from: classes.dex */
public final class C1012H extends C1013I {

    /* JADX INFO: renamed from: f */
    public final Set f3595f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1012H(AbstractC0832r abstractC0832r, C1033d c1033d) {
        super(abstractC0832r, null);
        String[] strArr = null;
        RuntimeException runtimeException = C1081b.f3771e;
        if (runtimeException != null) {
            throw runtimeException;
        }
        C1081b c1081b = C1081b.f3770d;
        Class cls = c1033d.f3666f;
        Object[] objArrM2822a = c1081b.m2822a(cls);
        if (objArrM2822a != null) {
            String[] strArr2 = new String[objArrM2822a.length];
            for (int i3 = 0; i3 < objArrM2822a.length; i3++) {
                try {
                    strArr2[i3] = (String) c1081b.f3773b.invoke(objArrM2822a[i3], null);
                } catch (Exception e3) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i3), Integer.valueOf(objArrM2822a.length), AbstractC1745j.m3903z(cls)), e3);
                }
            }
            strArr = strArr2;
        }
        this.f3595f = strArr == null ? Collections.emptySet() : new HashSet(Arrays.asList(strArr));
    }

    @Override // p082b1.C1013I
    /* JADX INFO: renamed from: c */
    public final String mo2729c(C1043n c1043n, String str) {
        return this.f3595f.contains(str) ? str : super.mo2729c(c1043n, str);
    }
}

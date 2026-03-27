package p109j1;

import java.io.Serializable;

/* JADX INFO: renamed from: j1.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1505m implements Serializable {

    /* JADX INFO: renamed from: e */
    public static final C1505m f5450e = new C1505m();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a */
    public static C1516x m3551a(String str) {
        C1516x c1516x = C1516x.f5466f;
        if (str == null) {
            return null;
        }
        return str.isEmpty() ? C1516x.f5466f : new C1516x(str);
    }
}

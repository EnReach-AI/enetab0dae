package p018F;

import java.util.Locale;

/* JADX INFO: renamed from: F.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0213e {

    /* JADX INFO: renamed from: b */
    public static final C0213e f517b = new C0213e(new C0214f(AbstractC0212d.m420a(new Locale[0])));

    /* JADX INFO: renamed from: a */
    public final C0214f f518a;

    public C0213e(C0214f c0214f) {
        this.f518a = c0214f;
    }

    /* JADX INFO: renamed from: a */
    public static C0213e m423a(String str) {
        if (str == null || str.isEmpty()) {
            return f517b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i3 = 0; i3 < length; i3++) {
            localeArr[i3] = AbstractC0211c.m418a(strArrSplit[i3]);
        }
        return new C0213e(new C0214f(AbstractC0212d.m420a(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0213e) {
            if (this.f518a.equals(((C0213e) obj).f518a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f518a.hashCode();
    }

    public final String toString() {
        return this.f518a.toString();
    }
}

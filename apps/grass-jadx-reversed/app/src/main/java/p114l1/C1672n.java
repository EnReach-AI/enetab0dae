package p114l1;

import p069X0.AbstractC0721l;

/* JADX INFO: renamed from: l1.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1672n {

    /* JADX INFO: renamed from: a */
    public final Class f5914a;

    /* JADX INFO: renamed from: b */
    public final AbstractC0721l[] f5915b;

    /* JADX INFO: renamed from: c */
    public final int f5916c;

    public C1672n(Class cls, AbstractC0721l[] abstractC0721lArr, int i3) {
        this.f5914a = cls;
        this.f5915b = abstractC0721lArr;
        this.f5916c = (cls.hashCode() * 31) + i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C1672n.class) {
            return false;
        }
        C1672n c1672n = (C1672n) obj;
        if (this.f5916c == c1672n.f5916c && this.f5914a == c1672n.f5914a) {
            AbstractC0721l[] abstractC0721lArr = this.f5915b;
            int length = abstractC0721lArr.length;
            AbstractC0721l[] abstractC0721lArr2 = c1672n.f5915b;
            if (length == abstractC0721lArr2.length) {
                for (int i3 = 0; i3 < length; i3++) {
                    if (!abstractC0721lArr[i3].equals(abstractC0721lArr2[i3])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5916c;
    }

    public final String toString() {
        return this.f5914a.getName().concat("<>");
    }
}

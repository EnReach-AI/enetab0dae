package p001A;

import android.content.res.Resources;
import p026I.AbstractC0294b;

/* JADX INFO: renamed from: A.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0013n {

    /* JADX INFO: renamed from: a */
    public final Resources f35a;

    /* JADX INFO: renamed from: b */
    public final Resources.Theme f36b;

    public C0013n(Resources resources, Resources.Theme theme) {
        this.f35a = resources;
        this.f36b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0013n.class != obj.getClass()) {
            return false;
        }
        C0013n c0013n = (C0013n) obj;
        return this.f35a.equals(c0013n.f35a) && AbstractC0294b.m569a(this.f36b, c0013n.f36b);
    }

    public final int hashCode() {
        return AbstractC0294b.m570b(this.f35a, this.f36b);
    }
}

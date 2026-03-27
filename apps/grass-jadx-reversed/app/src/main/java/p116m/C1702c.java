package p116m;

import java.util.Map;

/* JADX INFO: renamed from: m.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1702c implements Map.Entry {

    /* JADX INFO: renamed from: e */
    public final Object f5961e;

    /* JADX INFO: renamed from: f */
    public final Object f5962f;

    /* JADX INFO: renamed from: g */
    public C1702c f5963g;

    /* JADX INFO: renamed from: h */
    public C1702c f5964h;

    public C1702c(Object obj, Object obj2) {
        this.f5961e = obj;
        this.f5962f = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1702c)) {
            return false;
        }
        C1702c c1702c = (C1702c) obj;
        return this.f5961e.equals(c1702c.f5961e) && this.f5962f.equals(c1702c.f5962f);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5961e;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5962f;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f5961e.hashCode() ^ this.f5962f.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f5961e + "=" + this.f5962f;
    }
}

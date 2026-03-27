package p118m1;

import com.fasterxml.jackson.databind.util.internal.C1236e;
import com.fasterxml.jackson.databind.util.internal.ConcurrentMapC1248q;
import java.io.Serializable;

/* JADX INFO: renamed from: m1.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1752q implements Serializable {
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final int f6127e;

    /* JADX INFO: renamed from: f */
    public final int f6128f;

    /* JADX INFO: renamed from: g */
    public final transient ConcurrentMapC1248q f6129g;

    public C1752q(int i3, int i4) {
        this.f6127e = i3;
        this.f6128f = i4;
        C1236e c1236e = new C1236e();
        boolean z3 = i3 >= 0;
        int i5 = ConcurrentMapC1248q.f4192t;
        if (!z3) {
            throw new IllegalArgumentException();
        }
        c1236e.f4170b = i3;
        long j2 = i4;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException();
        }
        c1236e.f4171c = j2;
        c1236e.f4169a = 4;
        if (!(j2 >= 0)) {
            throw new IllegalStateException();
        }
        this.f6129g = new ConcurrentMapC1248q(c1236e);
    }

    public Object readResolve() {
        return new C1752q(this.f6127e, this.f6128f);
    }
}

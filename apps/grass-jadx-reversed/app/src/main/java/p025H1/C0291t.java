package p025H1;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: renamed from: H1.t */
/* JADX INFO: loaded from: classes.dex */
public final class C0291t {

    /* JADX INFO: renamed from: a */
    public float f785a;

    /* JADX INFO: renamed from: b */
    public float f786b;

    /* JADX INFO: renamed from: c */
    public float f787c;

    /* JADX INFO: renamed from: d */
    public float f788d;

    /* JADX INFO: renamed from: e */
    public float f789e;

    /* JADX INFO: renamed from: f */
    public float f790f;

    /* JADX INFO: renamed from: g */
    public final ArrayList f791g = new ArrayList();

    /* JADX INFO: renamed from: h */
    public final ArrayList f792h = new ArrayList();

    public C0291t() {
        m568d(0.0f, 270.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    public final void m565a(float f3) {
        float f4 = this.f789e;
        if (f4 == f3) {
            return;
        }
        float f5 = ((f3 - f4) + 360.0f) % 360.0f;
        if (f5 > 180.0f) {
            return;
        }
        float f6 = this.f787c;
        float f7 = this.f788d;
        C0287p c0287p = new C0287p(f6, f7, f6, f7);
        c0287p.f778f = this.f789e;
        c0287p.f779g = f5;
        this.f792h.add(new C0285n(c0287p));
        this.f789e = f3;
    }

    /* JADX INFO: renamed from: b */
    public final void m566b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f791g;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC0289r) arrayList.get(i3)).mo564a(matrix, path);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m567c(float f3, float f4) {
        C0288q c0288q = new C0288q();
        c0288q.f780b = f3;
        c0288q.f781c = f4;
        this.f791g.add(c0288q);
        C0286o c0286o = new C0286o(c0288q, this.f787c, this.f788d);
        float fM563b = c0286o.m563b() + 270.0f;
        float fM563b2 = c0286o.m563b() + 270.0f;
        m565a(fM563b);
        this.f792h.add(c0286o);
        this.f789e = fM563b2;
        this.f787c = f3;
        this.f788d = f4;
    }

    /* JADX INFO: renamed from: d */
    public final void m568d(float f3, float f4, float f5) {
        this.f785a = 0.0f;
        this.f786b = f3;
        this.f787c = 0.0f;
        this.f788d = f3;
        this.f789e = f4;
        this.f790f = (f4 + f5) % 360.0f;
        this.f791g.clear();
        this.f792h.clear();
    }
}

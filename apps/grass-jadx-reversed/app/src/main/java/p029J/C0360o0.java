package p029J;

import android.os.Build;
import android.view.View;
import p005B.C0029d;
import p026I.AbstractC0294b;

/* JADX INFO: renamed from: J.o0 */
/* JADX INFO: loaded from: classes.dex */
public class C0360o0 {

    /* JADX INFO: renamed from: b */
    public static final C0364q0 f871b;

    /* JADX INFO: renamed from: a */
    public final C0364q0 f872a;

    static {
        int i3 = Build.VERSION.SDK_INT;
        f871b = (i3 >= 30 ? new C0344g0() : i3 >= 29 ? new C0342f0() : new C0340e0()).mo736b().f874a.mo767a().f874a.mo762b().f874a.mo763c();
    }

    public C0360o0(C0364q0 c0364q0) {
        this.f872a = c0364q0;
    }

    /* JADX INFO: renamed from: a */
    public C0364q0 mo767a() {
        return this.f872a;
    }

    /* JADX INFO: renamed from: b */
    public C0364q0 mo762b() {
        return this.f872a;
    }

    /* JADX INFO: renamed from: c */
    public C0364q0 mo763c() {
        return this.f872a;
    }

    /* JADX INFO: renamed from: d */
    public void mo750d(View view) {
    }

    /* JADX INFO: renamed from: e */
    public C0347i mo768e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0360o0)) {
            return false;
        }
        C0360o0 c0360o0 = (C0360o0) obj;
        return mo754n() == c0360o0.mo754n() && mo765m() == c0360o0.mo765m() && AbstractC0294b.m569a(mo752j(), c0360o0.mo752j()) && AbstractC0294b.m569a(mo764h(), c0360o0.mo764h()) && AbstractC0294b.m569a(mo768e(), c0360o0.mo768e());
    }

    /* JADX INFO: renamed from: f */
    public C0029d mo751f(int i3) {
        return C0029d.f80e;
    }

    /* JADX INFO: renamed from: g */
    public C0029d mo777g() {
        return mo752j();
    }

    /* JADX INFO: renamed from: h */
    public C0029d mo764h() {
        return C0029d.f80e;
    }

    public int hashCode() {
        return AbstractC0294b.m570b(Boolean.valueOf(mo754n()), Boolean.valueOf(mo765m()), mo752j(), mo764h(), mo768e());
    }

    /* JADX INFO: renamed from: i */
    public C0029d mo778i() {
        return mo752j();
    }

    /* JADX INFO: renamed from: j */
    public C0029d mo752j() {
        return C0029d.f80e;
    }

    /* JADX INFO: renamed from: k */
    public C0029d mo779k() {
        return mo752j();
    }

    /* JADX INFO: renamed from: l */
    public C0364q0 mo753l(int i3, int i4, int i5, int i6) {
        return f871b;
    }

    /* JADX INFO: renamed from: m */
    public boolean mo765m() {
        return false;
    }

    /* JADX INFO: renamed from: n */
    public boolean mo754n() {
        return false;
    }

    /* JADX INFO: renamed from: o */
    public void mo755o(C0029d[] c0029dArr) {
    }

    /* JADX INFO: renamed from: p */
    public void mo756p(C0364q0 c0364q0) {
    }

    /* JADX INFO: renamed from: q */
    public void mo766q(C0029d c0029d) {
    }
}

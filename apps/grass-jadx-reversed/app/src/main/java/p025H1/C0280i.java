package p025H1;

import p033K0.AbstractC0406d;

/* JADX INFO: renamed from: H1.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0280i extends AbstractC0406d {
    @Override // p033K0.AbstractC0406d
    /* JADX INFO: renamed from: d */
    public final void mo530d(C0291t c0291t, float f3, float f4) {
        c0291t.m568d(f4 * f3, 180.0f, 90.0f);
        float f5 = f4 * 2.0f * f3;
        C0287p c0287p = new C0287p(0.0f, 0.0f, f5, f5);
        c0287p.f778f = 180.0f;
        c0287p.f779g = 90.0f;
        c0291t.f791g.add(c0287p);
        C0285n c0285n = new C0285n(c0287p);
        c0291t.m565a(180.0f);
        c0291t.f792h.add(c0285n);
        c0291t.f789e = 270.0f;
        float f6 = (0.0f + f5) * 0.5f;
        float f7 = (f5 - 0.0f) / 2.0f;
        double d = 270.0f;
        c0291t.f787c = (((float) Math.cos(Math.toRadians(d))) * f7) + f6;
        c0291t.f788d = (f7 * ((float) Math.sin(Math.toRadians(d)))) + f6;
    }
}

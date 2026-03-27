package p015D2;

import p005B.AbstractC0032g;
import p011C2.C0148a;
import p039M0.AbstractC0473V;
import p083b2.C1070o;
import p083b2.C1072q;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1794d;
import p142s2.AbstractC1899n;
import p166z0.C2068f;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: D2.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0185i extends AbstractC0473V {

    /* JADX INFO: renamed from: a */
    public final C0200x f428a;

    /* JADX INFO: renamed from: b */
    public final C2068f f429b;

    public C0185i(C0200x c0200x, C0148a c0148a) {
        AbstractC1766e.m3920e("lexer", c0200x);
        AbstractC1766e.m3920e("json", c0148a);
        this.f428a = c0200x;
        this.f429b = c0148a.f358b;
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: c */
    public final long mo91c() {
        C0200x c0200x = this.f428a;
        String strM380k = c0200x.m380k();
        try {
            AbstractC1766e.m3920e("<this>", strM380k);
            C1072q c1072qM3957o = AbstractC1794d.m3957o(strM380k);
            if (c1072qM3957o != null) {
                return c1072qM3957o.f3756e;
            }
            AbstractC1899n.m4228e(strM380k);
            throw null;
        } catch (IllegalArgumentException unused) {
            C0200x.m369o(c0200x, AbstractC0032g.m153k("Failed to parse type 'ULong' for input '", strM380k, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: h */
    public final int mo93h() {
        C0200x c0200x = this.f428a;
        String strM380k = c0200x.m380k();
        try {
            AbstractC1766e.m3920e("<this>", strM380k);
            C1070o c1070oM3956n = AbstractC1794d.m3956n(strM380k);
            if (c1070oM3956n != null) {
                return c1070oM3956n.f3754e;
            }
            AbstractC1899n.m4228e(strM380k);
            throw null;
        } catch (IllegalArgumentException unused) {
            C0200x.m369o(c0200x, AbstractC0032g.m153k("Failed to parse type 'UInt' for input '", strM380k, '\''), 0, null, 6);
            throw null;
        }
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: n */
    public final C2068f mo84n() {
        return this.f429b;
    }

    @Override // p004A2.InterfaceC0024a
    /* JADX INFO: renamed from: q */
    public final int mo86q(InterfaceC2095g interfaceC2095g) {
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        throw new IllegalStateException("unsupported".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte mo98r() {
        /*
            r5 = this;
            D2.x r0 = r5.f428a
            java.lang.String r1 = r0.m380k()
            r2 = 0
            java.lang.String r3 = "<this>"
            p119m2.AbstractC1766e.m3920e(r3, r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            b2.o r3 = p125o0.AbstractC1794d.m3956n(r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            if (r3 == 0) goto L1c
            int r3 = r3.f3754e     // Catch: java.lang.IllegalArgumentException -> L2d
            r4 = 255(0xff, float:3.57E-43)
            int r4 = java.lang.Integer.compareUnsigned(r3, r4)     // Catch: java.lang.IllegalArgumentException -> L2d
            if (r4 <= 0) goto L1e
        L1c:
            r4 = r2
            goto L24
        L1e:
            byte r3 = (byte) r3     // Catch: java.lang.IllegalArgumentException -> L2d
            b2.l r4 = new b2.l     // Catch: java.lang.IllegalArgumentException -> L2d
            r4.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L2d
        L24:
            if (r4 == 0) goto L29
            byte r0 = r4.f3749e     // Catch: java.lang.IllegalArgumentException -> L2d
            return r0
        L29:
            p142s2.AbstractC1899n.m4228e(r1)     // Catch: java.lang.IllegalArgumentException -> L2d
            throw r2     // Catch: java.lang.IllegalArgumentException -> L2d
        L2d:
            java.lang.String r3 = "Failed to parse type 'UByte' for input '"
            r4 = 39
            java.lang.String r1 = p005B.AbstractC0032g.m153k(r3, r1, r4)
            r3 = 6
            r4 = 0
            p015D2.C0200x.m369o(r0, r1, r4, r2, r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015D2.C0185i.mo98r():byte");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    @Override // p039M0.AbstractC0473V, p004A2.InterfaceC0025b
    /* JADX INFO: renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final short mo100u() {
        /*
            r5 = this;
            D2.x r0 = r5.f428a
            java.lang.String r1 = r0.m380k()
            r2 = 0
            java.lang.String r3 = "<this>"
            p119m2.AbstractC1766e.m3920e(r3, r1)     // Catch: java.lang.IllegalArgumentException -> L2e
            b2.o r3 = p125o0.AbstractC1794d.m3956n(r1)     // Catch: java.lang.IllegalArgumentException -> L2e
            if (r3 == 0) goto L1d
            int r3 = r3.f3754e     // Catch: java.lang.IllegalArgumentException -> L2e
            r4 = 65535(0xffff, float:9.1834E-41)
            int r4 = java.lang.Integer.compareUnsigned(r3, r4)     // Catch: java.lang.IllegalArgumentException -> L2e
            if (r4 <= 0) goto L1f
        L1d:
            r4 = r2
            goto L25
        L1f:
            short r3 = (short) r3     // Catch: java.lang.IllegalArgumentException -> L2e
            b2.t r4 = new b2.t     // Catch: java.lang.IllegalArgumentException -> L2e
            r4.<init>(r3)     // Catch: java.lang.IllegalArgumentException -> L2e
        L25:
            if (r4 == 0) goto L2a
            short r0 = r4.f3759e     // Catch: java.lang.IllegalArgumentException -> L2e
            return r0
        L2a:
            p142s2.AbstractC1899n.m4228e(r1)     // Catch: java.lang.IllegalArgumentException -> L2e
            throw r2     // Catch: java.lang.IllegalArgumentException -> L2e
        L2e:
            java.lang.String r3 = "Failed to parse type 'UShort' for input '"
            r4 = 39
            java.lang.String r1 = p005B.AbstractC0032g.m153k(r3, r1, r4)
            r3 = 6
            r4 = 0
            p015D2.C0200x.m369o(r0, r1, r4, r2, r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015D2.C0185i.mo100u():short");
    }
}

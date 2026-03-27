package p048P1;

import p051Q1.C0600a;

/* JADX INFO: renamed from: P1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0580d extends AbstractC0582f {

    /* JADX INFO: renamed from: c */
    public final short f1448c;

    /* JADX INFO: renamed from: d */
    public final short f1449d;

    public C0580d(AbstractC0582f abstractC0582f, int i3, int i4) {
        super(abstractC0582f);
        this.f1448c = (short) i3;
        this.f1449d = (short) i4;
    }

    @Override // p048P1.AbstractC0582f
    /* JADX INFO: renamed from: a */
    public final void mo1299a(C0600a c0600a, byte[] bArr) {
        c0600a.m1373b(this.f1448c, this.f1449d);
    }

    public final String toString() {
        short s3 = this.f1449d;
        return "<" + Integer.toBinaryString((1 << s3) | (((1 << s3) - 1) & this.f1448c) | (1 << s3)).substring(1) + '>';
    }
}

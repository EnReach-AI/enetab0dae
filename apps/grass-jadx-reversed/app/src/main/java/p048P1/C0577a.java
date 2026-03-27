package p048P1;

import p051Q1.C0600a;

/* JADX INFO: renamed from: P1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0577a extends AbstractC0582f {

    /* JADX INFO: renamed from: c */
    public final short f1440c;

    /* JADX INFO: renamed from: d */
    public final short f1441d;

    public C0577a(AbstractC0582f abstractC0582f, int i3, int i4) {
        super(abstractC0582f);
        this.f1440c = (short) i3;
        this.f1441d = (short) i4;
    }

    @Override // p048P1.AbstractC0582f
    /* JADX INFO: renamed from: a */
    public final void mo1299a(C0600a c0600a, byte[] bArr) {
        int i3 = 0;
        while (true) {
            short s3 = this.f1441d;
            if (i3 >= s3) {
                return;
            }
            if (i3 == 0 || (i3 == 31 && s3 <= 62)) {
                c0600a.m1373b(31, 5);
                if (s3 > 62) {
                    c0600a.m1373b(s3 - 31, 16);
                } else if (i3 == 0) {
                    c0600a.m1373b(Math.min((int) s3, 31), 5);
                } else {
                    c0600a.m1373b(s3 - 31, 5);
                }
            }
            c0600a.m1373b(bArr[this.f1440c + i3], 8);
            i3++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f1440c);
        sb.append("::");
        sb.append((r1 + this.f1441d) - 1);
        sb.append('>');
        return sb.toString();
    }
}

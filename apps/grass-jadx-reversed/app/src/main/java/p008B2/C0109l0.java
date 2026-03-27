package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.l0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0109l0 extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public short[] f300a;

    /* JADX INFO: renamed from: b */
    public int f301b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f300a, this.f301b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", sArrCopyOf);
        return sArrCopyOf;
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        short[] sArr = this.f300a;
        if (sArr.length < i3) {
            int length = sArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            short[] sArrCopyOf = Arrays.copyOf(sArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", sArrCopyOf);
            this.f300a = sArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f301b;
    }
}

package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0122s extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public double[] f320a;

    /* JADX INFO: renamed from: b */
    public int f321b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f320a, this.f321b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", dArrCopyOf);
        return dArrCopyOf;
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        double[] dArr = this.f320a;
        if (dArr.length < i3) {
            int length = dArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            double[] dArrCopyOf = Arrays.copyOf(dArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", dArrCopyOf);
            this.f320a = dArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f321b;
    }
}

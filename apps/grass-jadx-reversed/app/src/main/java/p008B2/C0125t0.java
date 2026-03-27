package p008B2;

import java.util.Arrays;
import p083b2.C1071p;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.t0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0125t0 extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public int[] f325a;

    /* JADX INFO: renamed from: b */
    public int f326b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f325a, this.f326b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", iArrCopyOf);
        return new C1071p(iArrCopyOf);
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        int[] iArr = this.f325a;
        if (iArr.length < i3) {
            int length = iArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", iArrCopyOf);
            this.f325a = iArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f326b;
    }
}

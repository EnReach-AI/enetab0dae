package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.I */
/* JADX INFO: loaded from: classes.dex */
public final class C0069I extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public int[] f228a;

    /* JADX INFO: renamed from: b */
    public int f229b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f228a, this.f229b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", iArrCopyOf);
        return iArrCopyOf;
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        int[] iArr = this.f228a;
        if (iArr.length < i3) {
            int length = iArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", iArrCopyOf);
            this.f228a = iArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f229b;
    }
}

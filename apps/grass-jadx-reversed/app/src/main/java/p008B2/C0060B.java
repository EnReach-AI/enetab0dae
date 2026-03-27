package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.B */
/* JADX INFO: loaded from: classes.dex */
public final class C0060B extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public float[] f208a;

    /* JADX INFO: renamed from: b */
    public int f209b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f208a, this.f209b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", fArrCopyOf);
        return fArrCopyOf;
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        float[] fArr = this.f208a;
        if (fArr.length < i3) {
            int length = fArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            float[] fArrCopyOf = Arrays.copyOf(fArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", fArrCopyOf);
            this.f208a = fArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f209b;
    }
}

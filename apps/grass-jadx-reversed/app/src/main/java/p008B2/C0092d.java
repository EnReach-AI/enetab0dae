package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0092d extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public boolean[] f267a;

    /* JADX INFO: renamed from: b */
    public int f268b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f267a, this.f268b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", zArrCopyOf);
        return zArrCopyOf;
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        boolean[] zArr = this.f267a;
        if (zArr.length < i3) {
            int length = zArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", zArrCopyOf);
            this.f267a = zArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f268b;
    }
}

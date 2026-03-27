package p008B2;

import java.util.Arrays;
import p083b2.C1073r;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.w0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0131w0 extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public long[] f339a;

    /* JADX INFO: renamed from: b */
    public int f340b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f339a, this.f340b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", jArrCopyOf);
        return new C1073r(jArrCopyOf);
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        long[] jArr = this.f339a;
        if (jArr.length < i3) {
            int length = jArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            long[] jArrCopyOf = Arrays.copyOf(jArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", jArrCopyOf);
            this.f339a = jArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f340b;
    }
}

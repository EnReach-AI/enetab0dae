package p008B2;

import java.util.Arrays;
import p083b2.C1069n;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.q0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0119q0 extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public byte[] f316a;

    /* JADX INFO: renamed from: b */
    public int f317b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f316a, this.f317b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", bArrCopyOf);
        return new C1069n(bArrCopyOf);
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        byte[] bArr = this.f316a;
        if (bArr.length < i3) {
            int length = bArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", bArrCopyOf);
            this.f316a = bArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f317b;
    }
}

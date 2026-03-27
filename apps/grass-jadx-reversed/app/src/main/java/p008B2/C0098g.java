package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0098g extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public byte[] f284a;

    /* JADX INFO: renamed from: b */
    public int f285b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f284a, this.f285b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", bArrCopyOf);
        return bArrCopyOf;
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        byte[] bArr = this.f284a;
        if (bArr.length < i3) {
            int length = bArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", bArrCopyOf);
            this.f284a = bArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f285b;
    }
}

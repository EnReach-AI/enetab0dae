package p008B2;

import java.util.Arrays;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: B2.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0110m extends AbstractC0095e0 {

    /* JADX INFO: renamed from: a */
    public char[] f302a;

    /* JADX INFO: renamed from: b */
    public int f303b;

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: a */
    public final Object mo227a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f302a, this.f303b);
        AbstractC1766e.m3919d("copyOf(this, newSize)", cArrCopyOf);
        return cArrCopyOf;
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: b */
    public final void mo228b(int i3) {
        char[] cArr = this.f302a;
        if (cArr.length < i3) {
            int length = cArr.length * 2;
            if (i3 < length) {
                i3 = length;
            }
            char[] cArrCopyOf = Arrays.copyOf(cArr, i3);
            AbstractC1766e.m3919d("copyOf(this, newSize)", cArrCopyOf);
            this.f302a = cArrCopyOf;
        }
    }

    @Override // p008B2.AbstractC0095e0
    /* JADX INFO: renamed from: d */
    public final int mo229d() {
        return this.f303b;
    }
}

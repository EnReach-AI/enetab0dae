package p158w2;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlinx.coroutines.scheduling.C1646a;

/* JADX INFO: renamed from: w2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C2003g {
    private volatile AtomicReferenceArray<Object> array;

    public C2003g(int i3) {
        this.array = new AtomicReferenceArray<>(i3);
    }

    /* JADX INFO: renamed from: a */
    public final int m4458a() {
        return this.array.length();
    }

    /* JADX INFO: renamed from: b */
    public final Object m4459b(int i3) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        if (i3 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i3);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final void m4460c(int i3, C1646a c1646a) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i3 < length) {
            atomicReferenceArray.set(i3, c1646a);
            return;
        }
        int i4 = i3 + 1;
        int i5 = length * 2;
        if (i4 < i5) {
            i4 = i5;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(i4);
        for (int i6 = 0; i6 < length; i6++) {
            atomicReferenceArray2.set(i6, atomicReferenceArray.get(i6));
        }
        atomicReferenceArray2.set(i3, c1646a);
        this.array = atomicReferenceArray2;
    }
}

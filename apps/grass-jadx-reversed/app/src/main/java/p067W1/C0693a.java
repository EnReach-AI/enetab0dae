package p067W1;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.WeakHashMap;
import p029J.AbstractC0323S;
import p056S0.C0633a;
import p073Z.AbstractC0763I;

/* JADX INFO: renamed from: W1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0693a {

    /* JADX INFO: renamed from: a */
    public int f1881a;

    /* JADX INFO: renamed from: b */
    public int f1882b;

    /* JADX INFO: renamed from: c */
    public int f1883c;

    /* JADX INFO: renamed from: d */
    public Object f1884d;

    /* JADX INFO: renamed from: a */
    public void m1667a(int i3, int i4) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i5 = this.f1883c;
        int i6 = i5 * 2;
        int[] iArr = (int[]) this.f1884d;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f1884d = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i6 >= iArr.length) {
            int[] iArr3 = new int[i5 * 4];
            this.f1884d = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.f1884d;
        iArr4[i6] = i3;
        iArr4[i6 + 1] = i4;
        this.f1883c++;
    }

    /* JADX INFO: renamed from: b */
    public void m1668b() {
        int i3 = this.f1883c;
        View view = (View) this.f1884d;
        int top = i3 - (view.getTop() - this.f1881a);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        view.offsetTopAndBottom(top);
        view.offsetLeftAndRight(0 - (view.getLeft() - this.f1882b));
    }

    /* JADX INFO: renamed from: c */
    public void m1669c(RecyclerView recyclerView, boolean z3) {
        this.f1883c = 0;
        int[] iArr = (int[]) this.f1884d;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        AbstractC0763I abstractC0763I = recyclerView.f3434p;
        if (recyclerView.f3432o == null || abstractC0763I == null || !abstractC0763I.f2147i) {
            return;
        }
        if (z3) {
            if (!recyclerView.f3418h.m3975j()) {
                abstractC0763I.mo2001i(recyclerView.f3432o.mo1944a(), this);
            }
        } else if (!recyclerView.m2585K()) {
            abstractC0763I.mo1999h(this.f1881a, this.f1882b, recyclerView.f3417g0, this);
        }
        int i3 = this.f1883c;
        if (i3 > abstractC0763I.f2148j) {
            abstractC0763I.f2148j = i3;
            abstractC0763I.f2149k = z3;
            recyclerView.f3414f.m2043k();
        }
    }

    /* JADX INFO: renamed from: d */
    public C0633a m1670d() {
        return ((C0633a[]) this.f1884d)[this.f1881a];
    }

    /* JADX INFO: renamed from: e */
    public byte[][] m1671e(int i3, int i4) {
        int i5 = this.f1882b;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i5 * i4, this.f1883c * i3);
        int i6 = i5 * i4;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = (i6 - i7) - 1;
            byte[] bArr2 = ((C0633a[]) this.f1884d)[i7 / i4].f1624b;
            int length = bArr2.length * i3;
            byte[] bArr3 = new byte[length];
            for (int i9 = 0; i9 < length; i9++) {
                bArr3[i9] = bArr2[i9 / i3];
            }
            bArr[i8] = bArr3;
        }
        return bArr;
    }
}

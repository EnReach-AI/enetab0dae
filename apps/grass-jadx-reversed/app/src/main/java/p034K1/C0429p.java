package p034K1;

import android.content.res.TypedArray;
import android.util.SparseArray;
import java.util.Arrays;
import p166z0.C2071i;

/* JADX INFO: renamed from: K1.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0429p {

    /* JADX INFO: renamed from: a */
    public final int f985a;

    /* JADX INFO: renamed from: b */
    public final int f986b;

    /* JADX INFO: renamed from: c */
    public final Object f987c;

    /* JADX INFO: renamed from: d */
    public final Object f988d;

    public C0429p(String str, int i3, int i4) {
        this.f987c = str;
        this.f986b = i3;
        this.f985a = i4;
        byte[] bArr = new byte[i3 * i4];
        this.f988d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    /* JADX INFO: renamed from: a */
    public void m939a(int i3, int i4, int i5, int i6) {
        if (i3 < 0) {
            int i7 = this.f985a;
            i3 += i7;
            i4 += 4 - ((i7 + 4) % 8);
        }
        int i8 = this.f986b;
        if (i4 < 0) {
            i4 += i8;
            i3 += 4 - ((i8 + 4) % 8);
        }
        ((byte[]) this.f988d)[(i3 * i8) + i4] = (byte) ((((CharSequence) this.f987c).charAt(i5) & (1 << (8 - i6))) == 0 ? 0 : 1);
    }

    /* JADX INFO: renamed from: b */
    public void m940b(int i3, int i4, int i5) {
        int i6 = i3 - 2;
        int i7 = i4 - 2;
        m939a(i6, i7, i5, 1);
        int i8 = i4 - 1;
        m939a(i6, i8, i5, 2);
        int i9 = i3 - 1;
        m939a(i9, i7, i5, 3);
        m939a(i9, i8, i5, 4);
        m939a(i9, i4, i5, 5);
        m939a(i3, i7, i5, 6);
        m939a(i3, i8, i5, 7);
        m939a(i3, i4, i5, 8);
    }

    public C0429p(C0430q c0430q, C2071i c2071i) {
        this.f987c = new SparseArray();
        this.f988d = c0430q;
        TypedArray typedArray = (TypedArray) c2071i.f7315b;
        this.f985a = typedArray.getResourceId(26, 0);
        this.f986b = typedArray.getResourceId(50, 0);
    }
}

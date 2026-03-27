package p110k;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: k.b0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1574b0 {

    /* JADX INFO: renamed from: a */
    public int f5600a = 0;

    /* JADX INFO: renamed from: b */
    public boolean f5601b = false;

    /* JADX INFO: renamed from: c */
    public float f5602c = -1.0f;

    /* JADX INFO: renamed from: d */
    public float f5603d = -1.0f;

    /* JADX INFO: renamed from: e */
    public float f5604e = -1.0f;

    /* JADX INFO: renamed from: f */
    public int[] f5605f = new int[0];

    /* JADX INFO: renamed from: g */
    public boolean f5606g = false;

    /* JADX INFO: renamed from: h */
    public final TextView f5607h;

    /* JADX INFO: renamed from: i */
    public final Context f5608i;

    static {
        new RectF();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public C1574b0(TextView textView) {
        this.f5607h = textView;
        this.f5608i = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            new C1568Z();
        } else {
            new C1566Y();
        }
    }

    /* JADX INFO: renamed from: a */
    public static int[] m3642a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            if (i3 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i3)) < 0) {
                arrayList.add(Integer.valueOf(i3));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr2;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m3643b() {
        if (m3645d() && this.f5600a == 1) {
            if (!this.f5606g || this.f5605f.length == 0) {
                int iFloor = ((int) Math.floor((this.f5604e - this.f5603d) / this.f5602c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i3 = 0; i3 < iFloor; i3++) {
                    iArr[i3] = Math.round((i3 * this.f5602c) + this.f5603d);
                }
                this.f5605f = m3642a(iArr);
            }
            this.f5601b = true;
        } else {
            this.f5601b = false;
        }
        return this.f5601b;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m3644c() {
        boolean z3 = this.f5605f.length > 0;
        this.f5606g = z3;
        if (z3) {
            this.f5600a = 1;
            this.f5603d = r0[0];
            this.f5604e = r0[r1 - 1];
            this.f5602c = -1.0f;
        }
        return z3;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m3645d() {
        return !(this.f5607h instanceof C1617t);
    }

    /* JADX INFO: renamed from: e */
    public final void m3646e(float f3, float f4, float f5) {
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f3 + "px) is less or equal to (0px)");
        }
        if (f4 <= f3) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f4 + "px) is less or equal to minimum auto-size text size (" + f3 + "px)");
        }
        if (f5 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f5 + "px) is less or equal to (0px)");
        }
        this.f5600a = 1;
        this.f5603d = f3;
        this.f5604e = f4;
        this.f5602c = f5;
        this.f5606g = false;
    }
}

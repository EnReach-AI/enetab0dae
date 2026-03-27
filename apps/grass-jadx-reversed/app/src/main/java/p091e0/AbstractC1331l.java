package p091e0;

import p005B.C0033h;
import p071Y0.AbstractC0752p;

/* JADX INFO: renamed from: e0.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1331l extends AbstractC1330k {

    /* JADX INFO: renamed from: a */
    public C0033h[] f4721a;

    /* JADX INFO: renamed from: b */
    public String f4722b;

    /* JADX INFO: renamed from: c */
    public int f4723c;

    /* JADX INFO: renamed from: d */
    public final int f4724d;

    public AbstractC1331l() {
        this.f4721a = null;
        this.f4723c = 0;
    }

    public C0033h[] getPathData() {
        return this.f4721a;
    }

    public String getPathName() {
        return this.f4722b;
    }

    public void setPathData(C0033h[] c0033hArr) {
        C0033h[] c0033hArr2 = this.f4721a;
        boolean z3 = false;
        if (c0033hArr2 != null && c0033hArr != null && c0033hArr2.length == c0033hArr.length) {
            int i3 = 0;
            while (true) {
                if (i3 >= c0033hArr2.length) {
                    z3 = true;
                    break;
                }
                C0033h c0033h = c0033hArr2[i3];
                char c3 = c0033h.f86a;
                C0033h c0033h2 = c0033hArr[i3];
                if (c3 != c0033h2.f86a || c0033h.f87b.length != c0033h2.f87b.length) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        if (!z3) {
            this.f4721a = AbstractC0752p.m1936e(c0033hArr);
            return;
        }
        C0033h[] c0033hArr3 = this.f4721a;
        for (int i4 = 0; i4 < c0033hArr.length; i4++) {
            c0033hArr3[i4].f86a = c0033hArr[i4].f86a;
            int i5 = 0;
            while (true) {
                float[] fArr = c0033hArr[i4].f87b;
                if (i5 < fArr.length) {
                    c0033hArr3[i4].f87b[i5] = fArr[i5];
                    i5++;
                }
            }
        }
    }

    public AbstractC1331l(AbstractC1331l abstractC1331l) {
        this.f4721a = null;
        this.f4723c = 0;
        this.f4722b = abstractC1331l.f4722b;
        this.f4724d = abstractC1331l.f4724d;
        this.f4721a = AbstractC0752p.m1936e(abstractC1331l.f4721a);
    }
}

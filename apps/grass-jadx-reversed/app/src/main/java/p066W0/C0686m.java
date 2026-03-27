package p066W0;

import java.io.IOException;
import java.util.ArrayList;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p118m1.C1728C;

/* JADX INFO: renamed from: W0.m */
/* JADX INFO: loaded from: classes.dex */
public final class C0686m extends AbstractC0685l {

    /* JADX INFO: renamed from: h */
    public final AbstractC0545m[] f1861h;

    /* JADX INFO: renamed from: i */
    public final boolean f1862i;

    /* JADX INFO: renamed from: j */
    public int f1863j;

    /* JADX INFO: renamed from: k */
    public boolean f1864k;

    public C0686m(AbstractC0545m[] abstractC0545mArr) {
        super(abstractC0545mArr[0]);
        this.f1862i = false;
        this.f1864k = false;
        this.f1861h = abstractC0545mArr;
        this.f1863j = 1;
    }

    /* JADX INFO: renamed from: f0 */
    public static C0686m m1645f0(C1728C c1728c, AbstractC0545m abstractC0545m) {
        if (!(abstractC0545m instanceof C0686m)) {
            return new C0686m(new AbstractC0545m[]{c1728c, abstractC0545m});
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c1728c);
        if (abstractC0545m instanceof C0686m) {
            ((C0686m) abstractC0545m).m1646e0(arrayList);
        } else {
            arrayList.add(abstractC0545m);
        }
        return new C0686m((AbstractC0545m[]) arrayList.toArray(new AbstractC0545m[arrayList.size()]));
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: V */
    public final EnumC0548p mo1177V() {
        EnumC0548p enumC0548pMo1177V;
        AbstractC0545m abstractC0545m = this.f1860g;
        if (abstractC0545m == null) {
            return null;
        }
        if (this.f1864k) {
            this.f1864k = false;
            return abstractC0545m.mo1190e();
        }
        EnumC0548p enumC0548pMo1177V2 = abstractC0545m.mo1177V();
        if (enumC0548pMo1177V2 != null) {
            return enumC0548pMo1177V2;
        }
        do {
            int i3 = this.f1863j;
            AbstractC0545m[] abstractC0545mArr = this.f1861h;
            if (i3 >= abstractC0545mArr.length) {
                return null;
            }
            this.f1863j = i3 + 1;
            AbstractC0545m abstractC0545m2 = abstractC0545mArr[i3];
            this.f1860g = abstractC0545m2;
            if (this.f1862i && abstractC0545m2.mo1166K()) {
                return this.f1860g.mo1199n();
            }
            enumC0548pMo1177V = this.f1860g.mo1177V();
        } while (enumC0548pMo1177V == null);
        return enumC0548pMo1177V;
    }

    @Override // p042N0.AbstractC0545m
    /* JADX INFO: renamed from: c0 */
    public final AbstractC0545m mo1187c0() {
        if (this.f1860g.mo1190e() != EnumC0548p.START_OBJECT && this.f1860g.mo1190e() != EnumC0548p.START_ARRAY) {
            return this;
        }
        int i3 = 1;
        while (true) {
            EnumC0548p enumC0548pMo1177V = mo1177V();
            if (enumC0548pMo1177V == null) {
                return this;
            }
            if (enumC0548pMo1177V.f1329i) {
                i3++;
            } else if (enumC0548pMo1177V.f1330j && i3 - 1 == 0) {
                return this;
            }
        }
    }

    @Override // p066W0.AbstractC0685l, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        while (true) {
            this.f1860g.close();
            int i3 = this.f1863j;
            AbstractC0545m[] abstractC0545mArr = this.f1861h;
            if (i3 >= abstractC0545mArr.length) {
                return;
            }
            this.f1863j = i3 + 1;
            this.f1860g = abstractC0545mArr[i3];
        }
    }

    /* JADX INFO: renamed from: e0 */
    public final void m1646e0(ArrayList arrayList) {
        AbstractC0545m[] abstractC0545mArr = this.f1861h;
        int length = abstractC0545mArr.length;
        for (int i3 = this.f1863j - 1; i3 < length; i3++) {
            AbstractC0545m abstractC0545m = abstractC0545mArr[i3];
            if (abstractC0545m instanceof C0686m) {
                ((C0686m) abstractC0545m).m1646e0(arrayList);
            } else {
                arrayList.add(abstractC0545m);
            }
        }
    }
}

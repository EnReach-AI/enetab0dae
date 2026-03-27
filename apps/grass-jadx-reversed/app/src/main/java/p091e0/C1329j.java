package p091e0;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;
import p128p.C1808b;

/* JADX INFO: renamed from: e0.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1329j extends AbstractC1330k {

    /* JADX INFO: renamed from: a */
    public final Matrix f4709a;

    /* JADX INFO: renamed from: b */
    public final ArrayList f4710b;

    /* JADX INFO: renamed from: c */
    public float f4711c;

    /* JADX INFO: renamed from: d */
    public float f4712d;

    /* JADX INFO: renamed from: e */
    public float f4713e;

    /* JADX INFO: renamed from: f */
    public float f4714f;

    /* JADX INFO: renamed from: g */
    public float f4715g;

    /* JADX INFO: renamed from: h */
    public float f4716h;

    /* JADX INFO: renamed from: i */
    public float f4717i;

    /* JADX INFO: renamed from: j */
    public final Matrix f4718j;

    /* JADX INFO: renamed from: k */
    public final int f4719k;

    /* JADX INFO: renamed from: l */
    public String f4720l;

    public C1329j() {
        this.f4709a = new Matrix();
        this.f4710b = new ArrayList();
        this.f4711c = 0.0f;
        this.f4712d = 0.0f;
        this.f4713e = 0.0f;
        this.f4714f = 1.0f;
        this.f4715g = 1.0f;
        this.f4716h = 0.0f;
        this.f4717i = 0.0f;
        this.f4718j = new Matrix();
        this.f4720l = null;
    }

    @Override // p091e0.AbstractC1330k
    /* JADX INFO: renamed from: a */
    public final boolean mo3285a() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f4710b;
            if (i3 >= arrayList.size()) {
                return false;
            }
            if (((AbstractC1330k) arrayList.get(i3)).mo3285a()) {
                return true;
            }
            i3++;
        }
    }

    @Override // p091e0.AbstractC1330k
    /* JADX INFO: renamed from: b */
    public final boolean mo3286b(int[] iArr) {
        int i3 = 0;
        boolean zMo3286b = false;
        while (true) {
            ArrayList arrayList = this.f4710b;
            if (i3 >= arrayList.size()) {
                return zMo3286b;
            }
            zMo3286b |= ((AbstractC1330k) arrayList.get(i3)).mo3286b(iArr);
            i3++;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m3287c() {
        Matrix matrix = this.f4718j;
        matrix.reset();
        matrix.postTranslate(-this.f4712d, -this.f4713e);
        matrix.postScale(this.f4714f, this.f4715g);
        matrix.postRotate(this.f4711c, 0.0f, 0.0f);
        matrix.postTranslate(this.f4716h + this.f4712d, this.f4717i + this.f4713e);
    }

    public String getGroupName() {
        return this.f4720l;
    }

    public Matrix getLocalMatrix() {
        return this.f4718j;
    }

    public float getPivotX() {
        return this.f4712d;
    }

    public float getPivotY() {
        return this.f4713e;
    }

    public float getRotation() {
        return this.f4711c;
    }

    public float getScaleX() {
        return this.f4714f;
    }

    public float getScaleY() {
        return this.f4715g;
    }

    public float getTranslateX() {
        return this.f4716h;
    }

    public float getTranslateY() {
        return this.f4717i;
    }

    public void setPivotX(float f3) {
        if (f3 != this.f4712d) {
            this.f4712d = f3;
            m3287c();
        }
    }

    public void setPivotY(float f3) {
        if (f3 != this.f4713e) {
            this.f4713e = f3;
            m3287c();
        }
    }

    public void setRotation(float f3) {
        if (f3 != this.f4711c) {
            this.f4711c = f3;
            m3287c();
        }
    }

    public void setScaleX(float f3) {
        if (f3 != this.f4714f) {
            this.f4714f = f3;
            m3287c();
        }
    }

    public void setScaleY(float f3) {
        if (f3 != this.f4715g) {
            this.f4715g = f3;
            m3287c();
        }
    }

    public void setTranslateX(float f3) {
        if (f3 != this.f4716h) {
            this.f4716h = f3;
            m3287c();
        }
    }

    public void setTranslateY(float f3) {
        if (f3 != this.f4717i) {
            this.f4717i = f3;
            m3287c();
        }
    }

    public C1329j(C1329j c1329j, C1808b c1808b) {
        AbstractC1331l c1327h;
        this.f4709a = new Matrix();
        this.f4710b = new ArrayList();
        this.f4711c = 0.0f;
        this.f4712d = 0.0f;
        this.f4713e = 0.0f;
        this.f4714f = 1.0f;
        this.f4715g = 1.0f;
        this.f4716h = 0.0f;
        this.f4717i = 0.0f;
        Matrix matrix = new Matrix();
        this.f4718j = matrix;
        this.f4720l = null;
        this.f4711c = c1329j.f4711c;
        this.f4712d = c1329j.f4712d;
        this.f4713e = c1329j.f4713e;
        this.f4714f = c1329j.f4714f;
        this.f4715g = c1329j.f4715g;
        this.f4716h = c1329j.f4716h;
        this.f4717i = c1329j.f4717i;
        String str = c1329j.f4720l;
        this.f4720l = str;
        this.f4719k = c1329j.f4719k;
        if (str != null) {
            c1808b.put(str, this);
        }
        matrix.set(c1329j.f4718j);
        ArrayList arrayList = c1329j.f4710b;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            Object obj = arrayList.get(i3);
            if (obj instanceof C1329j) {
                this.f4710b.add(new C1329j((C1329j) obj, c1808b));
            } else {
                if (obj instanceof C1328i) {
                    C1328i c1328i = (C1328i) obj;
                    C1328i c1328i2 = new C1328i(c1328i);
                    c1328i2.f4699f = 0.0f;
                    c1328i2.f4701h = 1.0f;
                    c1328i2.f4702i = 1.0f;
                    c1328i2.f4703j = 0.0f;
                    c1328i2.f4704k = 1.0f;
                    c1328i2.f4705l = 0.0f;
                    c1328i2.f4706m = Paint.Cap.BUTT;
                    c1328i2.f4707n = Paint.Join.MITER;
                    c1328i2.f4708o = 4.0f;
                    c1328i2.f4698e = c1328i.f4698e;
                    c1328i2.f4699f = c1328i.f4699f;
                    c1328i2.f4701h = c1328i.f4701h;
                    c1328i2.f4700g = c1328i.f4700g;
                    c1328i2.f4723c = c1328i.f4723c;
                    c1328i2.f4702i = c1328i.f4702i;
                    c1328i2.f4703j = c1328i.f4703j;
                    c1328i2.f4704k = c1328i.f4704k;
                    c1328i2.f4705l = c1328i.f4705l;
                    c1328i2.f4706m = c1328i.f4706m;
                    c1328i2.f4707n = c1328i.f4707n;
                    c1328i2.f4708o = c1328i.f4708o;
                    c1327h = c1328i2;
                } else if (obj instanceof C1327h) {
                    c1327h = new C1327h((C1327h) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f4710b.add(c1327h);
                Object obj2 = c1327h.f4722b;
                if (obj2 != null) {
                    c1808b.put(obj2, c1327h);
                }
            }
        }
    }
}

package p025H1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import p033K0.AbstractC0406d;
import p036L0.C0444d;
import p042N0.C0553u;
import p050Q0.C0590c;
import p066W0.C0674a;

/* JADX INFO: renamed from: H1.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0283l {

    /* JADX INFO: renamed from: a */
    public final boolean f755a;

    /* JADX INFO: renamed from: b */
    public final Serializable f756b;

    /* JADX INFO: renamed from: c */
    public final Object f757c;

    /* JADX INFO: renamed from: d */
    public Serializable f758d;

    /* JADX INFO: renamed from: e */
    public final Object f759e;

    /* JADX INFO: renamed from: f */
    public final Object f760f;

    /* JADX INFO: renamed from: g */
    public Object f761g;

    /* JADX INFO: renamed from: h */
    public Object f762h;

    /* JADX INFO: renamed from: i */
    public Object f763i;

    /* JADX INFO: renamed from: j */
    public Object f764j;

    /* JADX INFO: renamed from: k */
    public Object f765k;

    /* JADX INFO: renamed from: l */
    public Object f766l;

    /* JADX WARN: Type inference failed for: r1v0, types: [H1.t[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.graphics.Matrix[], java.io.Serializable] */
    public C0283l() {
        this.f756b = new C0291t[4];
        this.f757c = new Matrix[4];
        this.f758d = new Matrix[4];
        this.f759e = new PointF();
        this.f760f = new Path();
        this.f761g = new Path();
        this.f764j = new C0291t();
        this.f765k = new float[2];
        this.f766l = new float[2];
        this.f762h = new Path();
        this.f763i = new Path();
        this.f755a = true;
        for (int i3 = 0; i3 < 4; i3++) {
            ((C0291t[]) this.f756b)[i3] = new C0291t();
            ((Matrix[]) this.f757c)[i3] = new Matrix();
            ((Matrix[]) this.f758d)[i3] = new Matrix();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m556a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    /* JADX INFO: renamed from: b */
    public byte[] m557b() {
        m556a((byte[]) this.f763i);
        byte[] bArrM1632a = ((C0674a) this.f759e).m1632a(3);
        this.f763i = bArrM1632a;
        return bArrM1632a;
    }

    /* JADX INFO: renamed from: c */
    public void m558c(C0281j c0281j, float f3, RectF rectF, C0444d c0444d, Path path) {
        int i3;
        Matrix[] matrixArr;
        float[] fArr;
        Matrix[] matrixArr2;
        C0291t[] c0291tArr;
        int i4;
        C0283l c0283l = this;
        path.rewind();
        Path path2 = (Path) c0283l.f760f;
        path2.rewind();
        Path path3 = (Path) c0283l.f761g;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i5 = 0;
        while (true) {
            i3 = 4;
            matrixArr = (Matrix[]) c0283l.f758d;
            fArr = (float[]) c0283l.f765k;
            matrixArr2 = (Matrix[]) c0283l.f757c;
            c0291tArr = (C0291t[]) c0283l.f756b;
            if (i5 >= 4) {
                break;
            }
            InterfaceC0274c interfaceC0274c = i5 != 1 ? i5 != 2 ? i5 != 3 ? c0281j.f747f : c0281j.f746e : c0281j.f749h : c0281j.f748g;
            AbstractC0406d abstractC0406d = i5 != 1 ? i5 != 2 ? i5 != 3 ? c0281j.f743b : c0281j.f742a : c0281j.f745d : c0281j.f744c;
            C0291t c0291t = c0291tArr[i5];
            abstractC0406d.getClass();
            abstractC0406d.mo530d(c0291t, f3, interfaceC0274c.mo529a(rectF));
            int i6 = i5 + 1;
            float f4 = (i6 % 4) * 90;
            matrixArr2[i5].reset();
            PointF pointF = (PointF) c0283l.f759e;
            if (i5 == 1) {
                i4 = i6;
                pointF.set(rectF.right, rectF.bottom);
            } else if (i5 == 2) {
                i4 = i6;
                pointF.set(rectF.left, rectF.bottom);
            } else if (i5 != 3) {
                i4 = i6;
                pointF.set(rectF.right, rectF.top);
            } else {
                i4 = i6;
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i5].setTranslate(pointF.x, pointF.y);
            matrixArr2[i5].preRotate(f4);
            C0291t c0291t2 = c0291tArr[i5];
            fArr[0] = c0291t2.f787c;
            fArr[1] = c0291t2.f788d;
            matrixArr2[i5].mapPoints(fArr);
            matrixArr[i5].reset();
            matrixArr[i5].setTranslate(fArr[0], fArr[1]);
            matrixArr[i5].preRotate(f4);
            i5 = i4;
        }
        int i7 = 0;
        while (i7 < i3) {
            C0291t c0291t3 = c0291tArr[i7];
            fArr[0] = c0291t3.f785a;
            fArr[1] = c0291t3.f786b;
            matrixArr2[i7].mapPoints(fArr);
            if (i7 == 0) {
                path.moveTo(fArr[0], fArr[1]);
            } else {
                path.lineTo(fArr[0], fArr[1]);
            }
            c0291tArr[i7].m566b(matrixArr2[i7], path);
            if (c0444d != null) {
                C0291t c0291t4 = c0291tArr[i7];
                Matrix matrix = matrixArr2[i7];
                C0278g c0278g = (C0278g) c0444d.f1085e;
                BitSet bitSet = c0278g.f722h;
                c0291t4.getClass();
                bitSet.set(i7, false);
                c0291t4.m565a(c0291t4.f790f);
                c0278g.f720f[i7] = new C0284m(new ArrayList(c0291t4.f792h), new Matrix(matrix));
            }
            int i8 = i7 + 1;
            int i9 = i8 % 4;
            C0291t c0291t5 = c0291tArr[i7];
            fArr[0] = c0291t5.f787c;
            fArr[1] = c0291t5.f788d;
            matrixArr2[i7].mapPoints(fArr);
            C0291t c0291t6 = c0291tArr[i9];
            float f5 = c0291t6.f785a;
            float[] fArr2 = (float[]) c0283l.f766l;
            fArr2[0] = f5;
            fArr2[1] = c0291t6.f786b;
            matrixArr2[i9].mapPoints(fArr2);
            float fMax = Math.max(((float) Math.hypot(fArr[0] - fArr2[0], fArr[1] - fArr2[1])) - 0.001f, 0.0f);
            C0291t c0291t7 = c0291tArr[i7];
            fArr[0] = c0291t7.f787c;
            fArr[1] = c0291t7.f788d;
            matrixArr2[i7].mapPoints(fArr);
            if (i7 == 1 || i7 == 3) {
                Math.abs(rectF.centerX() - fArr[0]);
            } else {
                Math.abs(rectF.centerY() - fArr[1]);
            }
            C0291t c0291t8 = (C0291t) c0283l.f764j;
            c0291t8.m568d(0.0f, 270.0f, 0.0f);
            (i7 != 1 ? i7 != 2 ? i7 != 3 ? c0281j.f751j : c0281j.f750i : c0281j.f753l : c0281j.f752k).getClass();
            c0291t8.m567c(fMax, 0.0f);
            Path path4 = (Path) c0283l.f762h;
            path4.reset();
            c0291t8.m566b(matrixArr[i7], path4);
            if (c0283l.f755a && (c0283l.m559d(path4, i7) || c0283l.m559d(path4, i9))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr[0] = c0291t8.f785a;
                fArr[1] = c0291t8.f786b;
                matrixArr[i7].mapPoints(fArr);
                path2.moveTo(fArr[0], fArr[1]);
                c0291t8.m566b(matrixArr[i7], path2);
            } else {
                c0291t8.m566b(matrixArr[i7], path);
            }
            if (c0444d != null) {
                Matrix matrix2 = matrixArr[i7];
                C0278g c0278g2 = (C0278g) c0444d.f1085e;
                c0278g2.f722h.set(i7 + 4, false);
                c0291t8.m565a(c0291t8.f790f);
                c0278g2.f721g[i7] = new C0284m(new ArrayList(c0291t8.f792h), new Matrix(matrix2));
            }
            i3 = 4;
            c0283l = this;
            i7 = i8;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    /* JADX INFO: renamed from: d */
    public boolean m559d(Path path, int i3) {
        Path path2 = (Path) this.f763i;
        path2.reset();
        ((C0291t[]) this.f756b)[i3].m566b(((Matrix[]) this.f757c)[i3], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        if (rectF.isEmpty()) {
            return rectF.width() > 1.0f && rectF.height() > 1.0f;
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    public void m560e(byte[] bArr) {
        byte[] bArr2 = (byte[]) this.f763i;
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        this.f763i = null;
        ((C0674a) this.f759e).f1834a.set(3, bArr);
    }

    /* JADX INFO: renamed from: f */
    public void m561f(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = (byte[]) this.f761g;
            if (bArr != bArr2 && bArr.length < bArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            this.f761g = null;
            ((C0674a) this.f759e).f1834a.set(0, bArr);
        }
    }

    public C0283l(C0553u c0553u, C0674a c0674a, C0590c c0590c, boolean z3) {
        this.f760f = c0553u == null ? C0553u.f1339e : c0553u;
        this.f759e = c0674a;
        this.f756b = c0590c;
        this.f757c = c0590c.f1512e;
        this.f755a = z3;
    }
}

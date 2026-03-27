package p025H1;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import p022G1.C0237a;

/* JADX INFO: renamed from: H1.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0286o extends AbstractC0290s {

    /* JADX INFO: renamed from: c */
    public final C0288q f770c;

    /* JADX INFO: renamed from: d */
    public final float f771d;

    /* JADX INFO: renamed from: e */
    public final float f772e;

    public C0286o(C0288q c0288q, float f3, float f4) {
        this.f770c = c0288q;
        this.f771d = f3;
        this.f772e = f4;
    }

    @Override // p025H1.AbstractC0290s
    /* JADX INFO: renamed from: a */
    public final void mo562a(Matrix matrix, C0237a c0237a, int i3, Canvas canvas) {
        C0288q c0288q = this.f770c;
        float f3 = c0288q.f781c;
        float f4 = this.f772e;
        float f5 = c0288q.f780b;
        float f6 = this.f771d;
        RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(f3 - f4, f5 - f6), 0.0f);
        Matrix matrix2 = this.f784a;
        matrix2.set(matrix);
        matrix2.preTranslate(f6, f4);
        matrix2.preRotate(m563b());
        c0237a.getClass();
        rectF.bottom += i3;
        rectF.offset(0.0f, -i3);
        int[] iArr = C0237a.f570i;
        iArr[0] = c0237a.f579f;
        iArr[1] = c0237a.f578e;
        iArr[2] = c0237a.f577d;
        Paint paint = c0237a.f576c;
        float f7 = rectF.left;
        paint.setShader(new LinearGradient(f7, rectF.top, f7, rectF.bottom, iArr, C0237a.f571j, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF, paint);
        canvas.restore();
    }

    /* JADX INFO: renamed from: b */
    public final float m563b() {
        C0288q c0288q = this.f770c;
        return (float) Math.toDegrees(Math.atan((c0288q.f781c - this.f772e) / (c0288q.f780b - this.f771d)));
    }
}

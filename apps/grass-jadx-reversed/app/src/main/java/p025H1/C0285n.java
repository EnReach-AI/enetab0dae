package p025H1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import p022G1.C0237a;

/* JADX INFO: renamed from: H1.n */
/* JADX INFO: loaded from: classes.dex */
public final class C0285n extends AbstractC0290s {

    /* JADX INFO: renamed from: c */
    public final C0287p f769c;

    public C0285n(C0287p c0287p) {
        this.f769c = c0287p;
    }

    @Override // p025H1.AbstractC0290s
    /* JADX INFO: renamed from: a */
    public final void mo562a(Matrix matrix, C0237a c0237a, int i3, Canvas canvas) {
        C0287p c0287p = this.f769c;
        float f3 = c0287p.f778f;
        float f4 = c0287p.f779g;
        RectF rectF = new RectF(c0287p.f774b, c0287p.f775c, c0287p.f776d, c0287p.f777e);
        c0237a.getClass();
        boolean z3 = f4 < 0.0f;
        Path path = c0237a.f580g;
        int[] iArr = C0237a.f572k;
        if (z3) {
            iArr[0] = 0;
            iArr[1] = c0237a.f579f;
            iArr[2] = c0237a.f578e;
            iArr[3] = c0237a.f577d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f3, f4);
            path.close();
            float f5 = -i3;
            rectF.inset(f5, f5);
            iArr[0] = 0;
            iArr[1] = c0237a.f577d;
            iArr[2] = c0237a.f578e;
            iArr[3] = c0237a.f579f;
        }
        float fWidth = rectF.width() / 2.0f;
        if (fWidth <= 0.0f) {
            return;
        }
        float f6 = 1.0f - (i3 / fWidth);
        float[] fArr = C0237a.f573l;
        fArr[1] = f6;
        fArr[2] = ((1.0f - f6) / 2.0f) + f6;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), fWidth, iArr, fArr, Shader.TileMode.CLAMP);
        Paint paint = c0237a.f575b;
        paint.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.scale(1.0f, rectF.height() / rectF.width());
        if (!z3) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, c0237a.f581h);
        }
        canvas.drawArc(rectF, f3, f4, true, paint);
        canvas.restore();
    }
}

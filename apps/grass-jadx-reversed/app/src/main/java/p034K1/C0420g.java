package p034K1;

import android.graphics.Canvas;
import android.graphics.RectF;
import p025H1.C0278g;
import p025H1.C0281j;

/* JADX INFO: renamed from: K1.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0420g extends C0278g {

    /* JADX INFO: renamed from: C */
    public static final /* synthetic */ int f960C = 0;

    /* JADX INFO: renamed from: B */
    public final RectF f961B;

    public C0420g(C0281j c0281j) {
        super(c0281j == null ? new C0281j() : c0281j);
        this.f961B = new RectF();
    }

    @Override // p025H1.C0278g
    /* JADX INFO: renamed from: f */
    public final void mo542f(Canvas canvas) {
        RectF rectF = this.f961B;
        if (rectF.isEmpty()) {
            super.mo542f(canvas);
            return;
        }
        canvas.save();
        canvas.clipOutRect(rectF);
        super.mo542f(canvas);
        canvas.restore();
    }

    /* JADX INFO: renamed from: o */
    public final void m926o(float f3, float f4, float f5, float f6) {
        RectF rectF = this.f961B;
        if (f3 == rectF.left && f4 == rectF.top && f5 == rectF.right && f6 == rectF.bottom) {
            return;
        }
        rectF.set(f3, f4, f5, f6);
        invalidateSelf();
    }
}

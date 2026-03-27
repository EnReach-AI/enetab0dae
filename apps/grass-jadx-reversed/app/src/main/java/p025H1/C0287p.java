package p025H1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: renamed from: H1.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0287p extends AbstractC0289r {

    /* JADX INFO: renamed from: h */
    public static final RectF f773h = new RectF();

    /* JADX INFO: renamed from: b */
    public final float f774b;

    /* JADX INFO: renamed from: c */
    public final float f775c;

    /* JADX INFO: renamed from: d */
    public final float f776d;

    /* JADX INFO: renamed from: e */
    public final float f777e;

    /* JADX INFO: renamed from: f */
    public float f778f;

    /* JADX INFO: renamed from: g */
    public float f779g;

    public C0287p(float f3, float f4, float f5, float f6) {
        this.f774b = f3;
        this.f775c = f4;
        this.f776d = f5;
        this.f777e = f6;
    }

    @Override // p025H1.AbstractC0289r
    /* JADX INFO: renamed from: a */
    public final void mo564a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f782a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        RectF rectF = f773h;
        rectF.set(this.f774b, this.f775c, this.f776d, this.f777e);
        path.arcTo(rectF, this.f778f, this.f779g, false);
        path.transform(matrix);
    }
}

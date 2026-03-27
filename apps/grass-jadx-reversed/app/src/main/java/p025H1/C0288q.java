package p025H1;

import android.graphics.Matrix;
import android.graphics.Path;

/* JADX INFO: renamed from: H1.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0288q extends AbstractC0289r {

    /* JADX INFO: renamed from: b */
    public float f780b;

    /* JADX INFO: renamed from: c */
    public float f781c;

    @Override // p025H1.AbstractC0289r
    /* JADX INFO: renamed from: a */
    public final void mo564a(Matrix matrix, Path path) {
        Matrix matrix2 = this.f782a;
        matrix.invert(matrix2);
        path.transform(matrix2);
        path.lineTo(this.f780b, this.f781c);
        path.transform(matrix);
    }
}

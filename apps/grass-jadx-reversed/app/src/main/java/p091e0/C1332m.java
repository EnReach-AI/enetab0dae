package p091e0;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import p128p.C1808b;

/* JADX INFO: renamed from: e0.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1332m {

    /* JADX INFO: renamed from: p */
    public static final Matrix f4725p = new Matrix();

    /* JADX INFO: renamed from: a */
    public final Path f4726a;

    /* JADX INFO: renamed from: b */
    public final Path f4727b;

    /* JADX INFO: renamed from: c */
    public final Matrix f4728c;

    /* JADX INFO: renamed from: d */
    public Paint f4729d;

    /* JADX INFO: renamed from: e */
    public Paint f4730e;

    /* JADX INFO: renamed from: f */
    public PathMeasure f4731f;

    /* JADX INFO: renamed from: g */
    public final C1329j f4732g;

    /* JADX INFO: renamed from: h */
    public float f4733h;

    /* JADX INFO: renamed from: i */
    public float f4734i;

    /* JADX INFO: renamed from: j */
    public float f4735j;

    /* JADX INFO: renamed from: k */
    public float f4736k;

    /* JADX INFO: renamed from: l */
    public int f4737l;

    /* JADX INFO: renamed from: m */
    public String f4738m;

    /* JADX INFO: renamed from: n */
    public Boolean f4739n;

    /* JADX INFO: renamed from: o */
    public final C1808b f4740o;

    public C1332m() {
        this.f4728c = new Matrix();
        this.f4733h = 0.0f;
        this.f4734i = 0.0f;
        this.f4735j = 0.0f;
        this.f4736k = 0.0f;
        this.f4737l = 255;
        this.f4738m = null;
        this.f4739n = null;
        this.f4740o = new C1808b();
        this.f4732g = new C1329j();
        this.f4726a = new Path();
        this.f4727b = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e6  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r9v8, types: [android.graphics.PathMeasure] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3288a(p091e0.C1329j r19, android.graphics.Matrix r20, android.graphics.Canvas r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p091e0.C1332m.m3288a(e0.j, android.graphics.Matrix, android.graphics.Canvas, int, int):void");
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f4737l;
    }

    public void setAlpha(float f3) {
        setRootAlpha((int) (f3 * 255.0f));
    }

    public void setRootAlpha(int i3) {
        this.f4737l = i3;
    }

    public C1332m(C1332m c1332m) {
        this.f4728c = new Matrix();
        this.f4733h = 0.0f;
        this.f4734i = 0.0f;
        this.f4735j = 0.0f;
        this.f4736k = 0.0f;
        this.f4737l = 255;
        this.f4738m = null;
        this.f4739n = null;
        C1808b c1808b = new C1808b();
        this.f4740o = c1808b;
        this.f4732g = new C1329j(c1332m.f4732g, c1808b);
        this.f4726a = new Path(c1332m.f4726a);
        this.f4727b = new Path(c1332m.f4727b);
        this.f4733h = c1332m.f4733h;
        this.f4734i = c1332m.f4734i;
        this.f4735j = c1332m.f4735j;
        this.f4736k = c1332m.f4736k;
        this.f4737l = c1332m.f4737l;
        this.f4738m = c1332m.f4738m;
        String str = c1332m.f4738m;
        if (str != null) {
            c1808b.put(str, this);
        }
        this.f4739n = c1332m.f4739n;
    }
}

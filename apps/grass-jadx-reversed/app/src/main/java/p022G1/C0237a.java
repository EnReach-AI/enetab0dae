package p022G1;

import android.graphics.Paint;
import android.graphics.Path;
import p005B.AbstractC0026a;

/* JADX INFO: renamed from: G1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0237a {

    /* JADX INFO: renamed from: i */
    public static final int[] f570i = new int[3];

    /* JADX INFO: renamed from: j */
    public static final float[] f571j = {0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: k */
    public static final int[] f572k = new int[4];

    /* JADX INFO: renamed from: l */
    public static final float[] f573l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: a */
    public final Paint f574a;

    /* JADX INFO: renamed from: b */
    public final Paint f575b;

    /* JADX INFO: renamed from: c */
    public final Paint f576c;

    /* JADX INFO: renamed from: d */
    public int f577d;

    /* JADX INFO: renamed from: e */
    public int f578e;

    /* JADX INFO: renamed from: f */
    public int f579f;

    /* JADX INFO: renamed from: g */
    public final Path f580g = new Path();

    /* JADX INFO: renamed from: h */
    public final Paint f581h;

    public C0237a() {
        Paint paint = new Paint();
        this.f581h = paint;
        Paint paint2 = new Paint();
        this.f574a = paint2;
        this.f577d = AbstractC0026a.m107d(-16777216, 68);
        this.f578e = AbstractC0026a.m107d(-16777216, 20);
        this.f579f = AbstractC0026a.m107d(-16777216, 0);
        paint2.setColor(this.f577d);
        paint.setColor(0);
        Paint paint3 = new Paint(4);
        this.f575b = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.f576c = new Paint(paint3);
    }
}

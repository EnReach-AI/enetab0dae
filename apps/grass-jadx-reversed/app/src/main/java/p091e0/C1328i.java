package p091e0;

import android.graphics.Paint;
import p001A.C0003d;

/* JADX INFO: renamed from: e0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1328i extends AbstractC1331l {

    /* JADX INFO: renamed from: e */
    public C0003d f4698e;

    /* JADX INFO: renamed from: f */
    public float f4699f;

    /* JADX INFO: renamed from: g */
    public C0003d f4700g;

    /* JADX INFO: renamed from: h */
    public float f4701h;

    /* JADX INFO: renamed from: i */
    public float f4702i;

    /* JADX INFO: renamed from: j */
    public float f4703j;

    /* JADX INFO: renamed from: k */
    public float f4704k;

    /* JADX INFO: renamed from: l */
    public float f4705l;

    /* JADX INFO: renamed from: m */
    public Paint.Cap f4706m;

    /* JADX INFO: renamed from: n */
    public Paint.Join f4707n;

    /* JADX INFO: renamed from: o */
    public float f4708o;

    @Override // p091e0.AbstractC1330k
    /* JADX INFO: renamed from: a */
    public final boolean mo3285a() {
        return this.f4700g.m20d() || this.f4698e.m20d();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    @Override // p091e0.AbstractC1330k
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo3286b(int[] r7) {
        /*
            r6 = this;
            A.d r0 = r6.f4700g
            boolean r1 = r0.m20d()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f17d
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f15b
            if (r1 == r4) goto L1e
            r0.f15b = r1
            r0 = r3
            goto L1f
        L1e:
            r0 = r2
        L1f:
            A.d r1 = r6.f4698e
            boolean r4 = r1.m20d()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r1.f17d
            android.content.res.ColorStateList r4 = (android.content.res.ColorStateList) r4
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f15b
            if (r7 == r4) goto L3a
            r1.f15b = r7
            r2 = r3
        L3a:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p091e0.C1328i.mo3286b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f4702i;
    }

    public int getFillColor() {
        return this.f4700g.f15b;
    }

    public float getStrokeAlpha() {
        return this.f4701h;
    }

    public int getStrokeColor() {
        return this.f4698e.f15b;
    }

    public float getStrokeWidth() {
        return this.f4699f;
    }

    public float getTrimPathEnd() {
        return this.f4704k;
    }

    public float getTrimPathOffset() {
        return this.f4705l;
    }

    public float getTrimPathStart() {
        return this.f4703j;
    }

    public void setFillAlpha(float f3) {
        this.f4702i = f3;
    }

    public void setFillColor(int i3) {
        this.f4700g.f15b = i3;
    }

    public void setStrokeAlpha(float f3) {
        this.f4701h = f3;
    }

    public void setStrokeColor(int i3) {
        this.f4698e.f15b = i3;
    }

    public void setStrokeWidth(float f3) {
        this.f4699f = f3;
    }

    public void setTrimPathEnd(float f3) {
        this.f4704k = f3;
    }

    public void setTrimPathOffset(float f3) {
        this.f4705l = f3;
    }

    public void setTrimPathStart(float f3) {
        this.f4703j = f3;
    }
}

package p025H1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import p003A1.C0023a;
import p005B.AbstractC0026a;
import p022G1.C0237a;
import p026I.AbstractC0294b;
import p036L0.C0444d;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: H1.g */
/* JADX INFO: loaded from: classes.dex */
public class C0278g extends Drawable implements InterfaceC0292u {

    /* JADX INFO: renamed from: A */
    public static final Paint f718A;

    /* JADX INFO: renamed from: e */
    public C0277f f719e;

    /* JADX INFO: renamed from: f */
    public final AbstractC0290s[] f720f;

    /* JADX INFO: renamed from: g */
    public final AbstractC0290s[] f721g;

    /* JADX INFO: renamed from: h */
    public final BitSet f722h;

    /* JADX INFO: renamed from: i */
    public boolean f723i;

    /* JADX INFO: renamed from: j */
    public final Matrix f724j;

    /* JADX INFO: renamed from: k */
    public final Path f725k;

    /* JADX INFO: renamed from: l */
    public final Path f726l;

    /* JADX INFO: renamed from: m */
    public final RectF f727m;

    /* JADX INFO: renamed from: n */
    public final RectF f728n;

    /* JADX INFO: renamed from: o */
    public final Region f729o;

    /* JADX INFO: renamed from: p */
    public final Region f730p;

    /* JADX INFO: renamed from: q */
    public C0281j f731q;

    /* JADX INFO: renamed from: r */
    public final Paint f732r;

    /* JADX INFO: renamed from: s */
    public final Paint f733s;

    /* JADX INFO: renamed from: t */
    public final C0237a f734t;

    /* JADX INFO: renamed from: u */
    public final C0444d f735u;

    /* JADX INFO: renamed from: v */
    public final C0283l f736v;

    /* JADX INFO: renamed from: w */
    public PorterDuffColorFilter f737w;

    /* JADX INFO: renamed from: x */
    public PorterDuffColorFilter f738x;

    /* JADX INFO: renamed from: y */
    public final RectF f739y;

    /* JADX INFO: renamed from: z */
    public final boolean f740z;

    static {
        Paint paint = new Paint(1);
        f718A = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public C0278g() {
        this(new C0281j());
    }

    /* JADX INFO: renamed from: a */
    public final void m537a(RectF rectF, Path path) {
        C0277f c0277f = this.f719e;
        this.f736v.m558c(c0277f.f697a, c0277f.f706j, rectF, this.f735u, path);
        if (this.f719e.f705i != 1.0f) {
            Matrix matrix = this.f724j;
            matrix.reset();
            float f3 = this.f719e.f705i;
            matrix.setScale(f3, f3, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f739y, true);
    }

    /* JADX INFO: renamed from: b */
    public final PorterDuffColorFilter m538b(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z3) {
        int color;
        int iM539c;
        if (colorStateList == null || mode == null) {
            return (!z3 || (iM539c = m539c((color = paint.getColor()))) == color) ? null : new PorterDuffColorFilter(iM539c, PorterDuff.Mode.SRC_IN);
        }
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z3) {
            colorForState = m539c(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX INFO: renamed from: c */
    public final int m539c(int i3) {
        int i4;
        C0277f c0277f = this.f719e;
        float f3 = c0277f.f710n + c0277f.f711o + c0277f.f709m;
        C0023a c0023a = c0277f.f698b;
        if (c0023a == null || !c0023a.f74a || AbstractC0026a.m107d(i3, 255) != c0023a.f77d) {
            return i3;
        }
        float fMin = (c0023a.f78e <= 0.0f || f3 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f3 / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i3);
        int iM4309l = AbstractC1920f.m4309l(AbstractC0026a.m107d(i3, 255), c0023a.f75b, fMin);
        if (fMin > 0.0f && (i4 = c0023a.f76c) != 0) {
            iM4309l = AbstractC0026a.m105b(AbstractC0026a.m107d(i4, C0023a.f73f), iM4309l);
        }
        return AbstractC0026a.m107d(iM4309l, iAlpha);
    }

    /* JADX INFO: renamed from: d */
    public final void m540d(Canvas canvas) {
        if (this.f722h.cardinality() > 0) {
            Log.w("g", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i3 = this.f719e.f714r;
        Path path = this.f725k;
        C0237a c0237a = this.f734t;
        if (i3 != 0) {
            canvas.drawPath(path, c0237a.f574a);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            AbstractC0290s abstractC0290s = this.f720f[i4];
            int i5 = this.f719e.f713q;
            Matrix matrix = AbstractC0290s.f783b;
            abstractC0290s.mo562a(matrix, c0237a, i5, canvas);
            this.f721g[i4].mo562a(matrix, c0237a, this.f719e.f713q, canvas);
        }
        if (this.f740z) {
            int iSin = (int) (Math.sin(Math.toRadians(r0.f715s)) * ((double) this.f719e.f714r));
            int iCos = (int) (Math.cos(Math.toRadians(r2.f715s)) * ((double) this.f719e.f714r));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, f718A);
            canvas.translate(iSin, iCos);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instruction units count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p025H1.C0278g.draw(android.graphics.Canvas):void");
    }

    /* JADX INFO: renamed from: e */
    public final void m541e(Canvas canvas, Paint paint, Path path, C0281j c0281j, RectF rectF) {
        if (!c0281j.m554d(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fMo529a = c0281j.f747f.mo529a(rectF) * this.f719e.f706j;
            canvas.drawRoundRect(rectF, fMo529a, fMo529a, paint);
        }
    }

    /* JADX INFO: renamed from: f */
    public void mo542f(Canvas canvas) {
        Paint paint = this.f733s;
        Path path = this.f726l;
        C0281j c0281j = this.f731q;
        RectF rectF = this.f728n;
        rectF.set(m543g());
        float strokeWidth = m544h() ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        m541e(canvas, paint, path, c0281j, rectF);
    }

    /* JADX INFO: renamed from: g */
    public final RectF m543g() {
        RectF rectF = this.f727m;
        rectF.set(getBounds());
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f719e.f708l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f719e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        C0277f c0277f = this.f719e;
        if (c0277f.f712p == 2) {
            return;
        }
        if (c0277f.f697a.m554d(m543g())) {
            outline.setRoundRect(getBounds(), this.f719e.f697a.f746e.mo529a(m543g()) * this.f719e.f706j);
            return;
        }
        RectF rectFM543g = m543g();
        Path path = this.f725k;
        m537a(rectFM543g, path);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            outline.setPath(path);
            return;
        }
        if (i3 >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            outline.setConvexPath(path);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f719e.f704h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f729o;
        region.set(bounds);
        RectF rectFM543g = m543g();
        Path path = this.f725k;
        m537a(rectFM543g, path);
        Region region2 = this.f730p;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m544h() {
        Paint.Style style = this.f719e.f717u;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f733s.getStrokeWidth() > 0.0f;
    }

    /* JADX INFO: renamed from: i */
    public final void m545i(Context context) {
        this.f719e.f698b = new C0023a(context);
        m550n();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f723i = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f719e.f702f) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f719e.f701e) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f719e.f700d) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f719e.f699c) != null && colorStateList4.isStateful())));
    }

    /* JADX INFO: renamed from: j */
    public final void m546j(float f3) {
        C0277f c0277f = this.f719e;
        if (c0277f.f710n != f3) {
            c0277f.f710n = f3;
            m550n();
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m547k(ColorStateList colorStateList) {
        C0277f c0277f = this.f719e;
        if (c0277f.f699c != colorStateList) {
            c0277f.f699c = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: l */
    public final boolean m548l(int[] iArr) {
        boolean z3;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f719e.f699c == null || color2 == (colorForState2 = this.f719e.f699c.getColorForState(iArr, (color2 = (paint2 = this.f732r).getColor())))) {
            z3 = false;
        } else {
            paint2.setColor(colorForState2);
            z3 = true;
        }
        if (this.f719e.f700d == null || color == (colorForState = this.f719e.f700d.getColorForState(iArr, (color = (paint = this.f733s).getColor())))) {
            return z3;
        }
        paint.setColor(colorForState);
        return true;
    }

    /* JADX INFO: renamed from: m */
    public final boolean m549m() {
        PorterDuffColorFilter porterDuffColorFilter = this.f737w;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f738x;
        C0277f c0277f = this.f719e;
        this.f737w = m538b(c0277f.f702f, c0277f.f703g, this.f732r, true);
        C0277f c0277f2 = this.f719e;
        this.f738x = m538b(c0277f2.f701e, c0277f2.f703g, this.f733s, false);
        C0277f c0277f3 = this.f719e;
        if (c0277f3.f716t) {
            int colorForState = c0277f3.f702f.getColorForState(getState(), 0);
            C0237a c0237a = this.f734t;
            c0237a.getClass();
            c0237a.f577d = AbstractC0026a.m107d(colorForState, 68);
            c0237a.f578e = AbstractC0026a.m107d(colorForState, 20);
            c0237a.f579f = AbstractC0026a.m107d(colorForState, 0);
            c0237a.f574a.setColor(c0237a.f577d);
        }
        return (AbstractC0294b.m569a(porterDuffColorFilter, this.f737w) && AbstractC0294b.m569a(porterDuffColorFilter2, this.f738x)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        C0277f c0277f = this.f719e;
        C0277f c0277f2 = new C0277f();
        c0277f2.f699c = null;
        c0277f2.f700d = null;
        c0277f2.f701e = null;
        c0277f2.f702f = null;
        c0277f2.f703g = PorterDuff.Mode.SRC_IN;
        c0277f2.f704h = null;
        c0277f2.f705i = 1.0f;
        c0277f2.f706j = 1.0f;
        c0277f2.f708l = 255;
        c0277f2.f709m = 0.0f;
        c0277f2.f710n = 0.0f;
        c0277f2.f711o = 0.0f;
        c0277f2.f712p = 0;
        c0277f2.f713q = 0;
        c0277f2.f714r = 0;
        c0277f2.f715s = 0;
        c0277f2.f716t = false;
        c0277f2.f717u = Paint.Style.FILL_AND_STROKE;
        c0277f2.f697a = c0277f.f697a;
        c0277f2.f698b = c0277f.f698b;
        c0277f2.f707k = c0277f.f707k;
        c0277f2.f699c = c0277f.f699c;
        c0277f2.f700d = c0277f.f700d;
        c0277f2.f703g = c0277f.f703g;
        c0277f2.f702f = c0277f.f702f;
        c0277f2.f708l = c0277f.f708l;
        c0277f2.f705i = c0277f.f705i;
        c0277f2.f714r = c0277f.f714r;
        c0277f2.f712p = c0277f.f712p;
        c0277f2.f716t = c0277f.f716t;
        c0277f2.f706j = c0277f.f706j;
        c0277f2.f709m = c0277f.f709m;
        c0277f2.f710n = c0277f.f710n;
        c0277f2.f711o = c0277f.f711o;
        c0277f2.f713q = c0277f.f713q;
        c0277f2.f715s = c0277f.f715s;
        c0277f2.f701e = c0277f.f701e;
        c0277f2.f717u = c0277f.f717u;
        if (c0277f.f704h != null) {
            c0277f2.f704h = new Rect(c0277f.f704h);
        }
        this.f719e = c0277f2;
        return this;
    }

    /* JADX INFO: renamed from: n */
    public final void m550n() {
        C0277f c0277f = this.f719e;
        float f3 = c0277f.f710n + c0277f.f711o;
        c0277f.f713q = (int) Math.ceil(0.75f * f3);
        this.f719e.f714r = (int) Math.ceil(f3 * 0.25f);
        m549m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f723i = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z3 = m548l(iArr) || m549m();
        if (z3) {
            invalidateSelf();
        }
        return z3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        C0277f c0277f = this.f719e;
        if (c0277f.f708l != i3) {
            c0277f.f708l = i3;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f719e.getClass();
        super.invalidateSelf();
    }

    @Override // p025H1.InterfaceC0292u
    public final void setShapeAppearanceModel(C0281j c0281j) {
        this.f719e.f697a = c0281j;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i3) {
        setTintList(ColorStateList.valueOf(i3));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f719e.f702f = colorStateList;
        m549m();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        C0277f c0277f = this.f719e;
        if (c0277f.f703g != mode) {
            c0277f.f703g = mode;
            m549m();
            super.invalidateSelf();
        }
    }

    public C0278g(Context context, AttributeSet attributeSet, int i3, int i4) {
        this(C0281j.m552b(context, attributeSet, i3, i4).m4266a());
    }

    public C0278g(C0281j c0281j) {
        C0277f c0277f = new C0277f();
        c0277f.f699c = null;
        c0277f.f700d = null;
        c0277f.f701e = null;
        c0277f.f702f = null;
        c0277f.f703g = PorterDuff.Mode.SRC_IN;
        c0277f.f704h = null;
        c0277f.f705i = 1.0f;
        c0277f.f706j = 1.0f;
        c0277f.f708l = 255;
        c0277f.f709m = 0.0f;
        c0277f.f710n = 0.0f;
        c0277f.f711o = 0.0f;
        c0277f.f712p = 0;
        c0277f.f713q = 0;
        c0277f.f714r = 0;
        c0277f.f715s = 0;
        c0277f.f716t = false;
        c0277f.f717u = Paint.Style.FILL_AND_STROKE;
        c0277f.f697a = c0281j;
        c0277f.f698b = null;
        this(c0277f);
    }

    public C0278g(C0277f c0277f) {
        C0283l c0283l;
        this.f720f = new AbstractC0290s[4];
        this.f721g = new AbstractC0290s[4];
        this.f722h = new BitSet(8);
        this.f724j = new Matrix();
        this.f725k = new Path();
        this.f726l = new Path();
        this.f727m = new RectF();
        this.f728n = new RectF();
        this.f729o = new Region();
        this.f730p = new Region();
        Paint paint = new Paint(1);
        this.f732r = paint;
        Paint paint2 = new Paint(1);
        this.f733s = paint2;
        this.f734t = new C0237a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            c0283l = AbstractC0282k.f754a;
        } else {
            c0283l = new C0283l();
        }
        this.f736v = c0283l;
        this.f739y = new RectF();
        this.f740z = true;
        this.f719e = c0277f;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        m549m();
        m548l(getState());
        this.f735u = new C0444d(this);
    }
}

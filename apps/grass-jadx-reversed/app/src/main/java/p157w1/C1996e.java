package p157w1;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p007B1.C0050j;
import p007B1.C0052l;
import p007B1.InterfaceC0051k;
import p009C.AbstractC0139b;
import p009C.AbstractC0140c;
import p009C.AbstractC0146i;
import p009C.InterfaceC0145h;
import p016E1.C0206d;
import p025H1.C0272a;
import p025H1.C0277f;
import p025H1.C0278g;
import p130p1.C1825b;
import p144t0.C1916b;

/* JADX INFO: renamed from: w1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1996e extends C0278g implements Drawable.Callback, InterfaceC0051k {

    /* JADX INFO: renamed from: K0 */
    public static final int[] f7070K0 = {R.attr.state_enabled};

    /* JADX INFO: renamed from: L0 */
    public static final ShapeDrawable f7071L0 = new ShapeDrawable(new OvalShape());

    /* JADX INFO: renamed from: A0 */
    public ColorStateList f7072A0;

    /* JADX INFO: renamed from: B */
    public ColorStateList f7073B;

    /* JADX INFO: renamed from: B0 */
    public PorterDuff.Mode f7074B0;

    /* JADX INFO: renamed from: C */
    public ColorStateList f7075C;

    /* JADX INFO: renamed from: C0 */
    public int[] f7076C0;

    /* JADX INFO: renamed from: D */
    public float f7077D;

    /* JADX INFO: renamed from: D0 */
    public boolean f7078D0;

    /* JADX INFO: renamed from: E */
    public float f7079E;

    /* JADX INFO: renamed from: E0 */
    public ColorStateList f7080E0;

    /* JADX INFO: renamed from: F */
    public ColorStateList f7081F;

    /* JADX INFO: renamed from: F0 */
    public WeakReference f7082F0;

    /* JADX INFO: renamed from: G */
    public float f7083G;

    /* JADX INFO: renamed from: G0 */
    public TextUtils.TruncateAt f7084G0;

    /* JADX INFO: renamed from: H */
    public ColorStateList f7085H;

    /* JADX INFO: renamed from: H0 */
    public boolean f7086H0;

    /* JADX INFO: renamed from: I */
    public CharSequence f7087I;

    /* JADX INFO: renamed from: I0 */
    public int f7088I0;

    /* JADX INFO: renamed from: J */
    public boolean f7089J;

    /* JADX INFO: renamed from: J0 */
    public boolean f7090J0;

    /* JADX INFO: renamed from: K */
    public Drawable f7091K;

    /* JADX INFO: renamed from: L */
    public ColorStateList f7092L;

    /* JADX INFO: renamed from: M */
    public float f7093M;

    /* JADX INFO: renamed from: N */
    public boolean f7094N;

    /* JADX INFO: renamed from: O */
    public boolean f7095O;

    /* JADX INFO: renamed from: P */
    public Drawable f7096P;

    /* JADX INFO: renamed from: Q */
    public RippleDrawable f7097Q;

    /* JADX INFO: renamed from: R */
    public ColorStateList f7098R;

    /* JADX INFO: renamed from: S */
    public float f7099S;

    /* JADX INFO: renamed from: T */
    public SpannableStringBuilder f7100T;

    /* JADX INFO: renamed from: U */
    public boolean f7101U;

    /* JADX INFO: renamed from: V */
    public boolean f7102V;

    /* JADX INFO: renamed from: W */
    public Drawable f7103W;

    /* JADX INFO: renamed from: X */
    public ColorStateList f7104X;

    /* JADX INFO: renamed from: Y */
    public C1825b f7105Y;

    /* JADX INFO: renamed from: Z */
    public C1825b f7106Z;

    /* JADX INFO: renamed from: a0 */
    public float f7107a0;

    /* JADX INFO: renamed from: b0 */
    public float f7108b0;

    /* JADX INFO: renamed from: c0 */
    public float f7109c0;

    /* JADX INFO: renamed from: d0 */
    public float f7110d0;

    /* JADX INFO: renamed from: e0 */
    public float f7111e0;

    /* JADX INFO: renamed from: f0 */
    public float f7112f0;

    /* JADX INFO: renamed from: g0 */
    public float f7113g0;

    /* JADX INFO: renamed from: h0 */
    public float f7114h0;

    /* JADX INFO: renamed from: i0 */
    public final Context f7115i0;

    /* JADX INFO: renamed from: j0 */
    public final Paint f7116j0;

    /* JADX INFO: renamed from: k0 */
    public final Paint.FontMetrics f7117k0;

    /* JADX INFO: renamed from: l0 */
    public final RectF f7118l0;

    /* JADX INFO: renamed from: m0 */
    public final PointF f7119m0;

    /* JADX INFO: renamed from: n0 */
    public final Path f7120n0;

    /* JADX INFO: renamed from: o0 */
    public final C0052l f7121o0;

    /* JADX INFO: renamed from: p0 */
    public int f7122p0;

    /* JADX INFO: renamed from: q0 */
    public int f7123q0;

    /* JADX INFO: renamed from: r0 */
    public int f7124r0;

    /* JADX INFO: renamed from: s0 */
    public int f7125s0;

    /* JADX INFO: renamed from: t0 */
    public int f7126t0;

    /* JADX INFO: renamed from: u0 */
    public int f7127u0;

    /* JADX INFO: renamed from: v0 */
    public boolean f7128v0;

    /* JADX INFO: renamed from: w0 */
    public int f7129w0;

    /* JADX INFO: renamed from: x0 */
    public int f7130x0;

    /* JADX INFO: renamed from: y0 */
    public ColorFilter f7131y0;

    /* JADX INFO: renamed from: z0 */
    public PorterDuffColorFilter f7132z0;

    public C1996e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action);
        this.f7079E = -1.0f;
        this.f7116j0 = new Paint(1);
        this.f7117k0 = new Paint.FontMetrics();
        this.f7118l0 = new RectF();
        this.f7119m0 = new PointF();
        this.f7120n0 = new Path();
        this.f7130x0 = 255;
        this.f7074B0 = PorterDuff.Mode.SRC_IN;
        this.f7082F0 = new WeakReference(null);
        m545i(context);
        this.f7115i0 = context;
        C0052l c0052l = new C0052l(this);
        this.f7121o0 = c0052l;
        this.f7087I = "";
        c0052l.f191a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f7070K0;
        setState(iArr);
        if (!Arrays.equals(this.f7076C0, iArr)) {
            this.f7076C0 = iArr;
            if (m4437U()) {
                m4444w(getState(), iArr);
            }
        }
        this.f7086H0 = true;
        f7071L0.setTint(-1);
    }

    /* JADX INFO: renamed from: V */
    public static void m4414V(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* JADX INFO: renamed from: t */
    public static boolean m4415t(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    /* JADX INFO: renamed from: u */
    public static boolean m4416u(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* JADX INFO: renamed from: A */
    public final void m4417A(boolean z3) {
        if (this.f7102V != z3) {
            boolean zM4435S = m4435S();
            this.f7102V = z3;
            boolean zM4435S2 = m4435S();
            if (zM4435S != zM4435S2) {
                if (zM4435S2) {
                    m4438o(this.f7103W);
                } else {
                    m4414V(this.f7103W);
                }
                invalidateSelf();
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public final void m4418B(float f3) {
        if (this.f7079E != f3) {
            this.f7079E = f3;
            C1916b c1916bM555e = this.f719e.f697a.m555e();
            c1916bM555e.f6703e = new C0272a(f3);
            c1916bM555e.f6704f = new C0272a(f3);
            c1916bM555e.f6705g = new C0272a(f3);
            c1916bM555e.f6706h = new C0272a(f3);
            setShapeAppearanceModel(c1916bM555e.m4266a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX INFO: renamed from: C */
    public final void m4419C(Drawable drawable) {
        ?? r02;
        Object obj = this.f7091K;
        if (obj != null) {
            boolean z3 = obj instanceof InterfaceC0145h;
            r02 = obj;
            if (z3) {
                ((AbstractC0146i) ((InterfaceC0145h) obj)).getClass();
                r02 = 0;
            }
        } else {
            r02 = 0;
        }
        if (r02 != drawable) {
            float fM4440q = m4440q();
            this.f7091K = drawable != null ? drawable.mutate() : null;
            float fM4440q2 = m4440q();
            m4414V(r02);
            if (m4436T()) {
                m4438o(this.f7091K);
            }
            invalidateSelf();
            if (fM4440q != fM4440q2) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: D */
    public final void m4420D(float f3) {
        if (this.f7093M != f3) {
            float fM4440q = m4440q();
            this.f7093M = f3;
            float fM4440q2 = m4440q();
            invalidateSelf();
            if (fM4440q != fM4440q2) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: E */
    public final void m4421E(ColorStateList colorStateList) {
        this.f7094N = true;
        if (this.f7092L != colorStateList) {
            this.f7092L = colorStateList;
            if (m4436T()) {
                AbstractC0139b.m280h(this.f7091K, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: F */
    public final void m4422F(boolean z3) {
        if (this.f7089J != z3) {
            boolean zM4436T = m4436T();
            this.f7089J = z3;
            boolean zM4436T2 = m4436T();
            if (zM4436T != zM4436T2) {
                if (zM4436T2) {
                    m4438o(this.f7091K);
                } else {
                    m4414V(this.f7091K);
                }
                invalidateSelf();
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m4423G(ColorStateList colorStateList) {
        if (this.f7081F != colorStateList) {
            this.f7081F = colorStateList;
            if (this.f7090J0) {
                C0277f c0277f = this.f719e;
                if (c0277f.f700d != colorStateList) {
                    c0277f.f700d = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: H */
    public final void m4424H(float f3) {
        if (this.f7083G != f3) {
            this.f7083G = f3;
            this.f7116j0.setStrokeWidth(f3);
            if (this.f7090J0) {
                this.f719e.f707k = f3;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX INFO: renamed from: I */
    public final void m4425I(Drawable drawable) {
        ?? r02;
        Object obj = this.f7096P;
        if (obj != null) {
            boolean z3 = obj instanceof InterfaceC0145h;
            r02 = obj;
            if (z3) {
                ((AbstractC0146i) ((InterfaceC0145h) obj)).getClass();
                r02 = 0;
            }
        } else {
            r02 = 0;
        }
        if (r02 != drawable) {
            float fM4441r = m4441r();
            this.f7096P = drawable != null ? drawable.mutate() : null;
            ColorStateList colorStateListValueOf = this.f7085H;
            if (colorStateListValueOf == null) {
                colorStateListValueOf = ColorStateList.valueOf(0);
            }
            this.f7097Q = new RippleDrawable(colorStateListValueOf, this.f7096P, f7071L0);
            float fM4441r2 = m4441r();
            m4414V(r02);
            if (m4437U()) {
                m4438o(this.f7096P);
            }
            invalidateSelf();
            if (fM4441r != fM4441r2) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: J */
    public final void m4426J(float f3) {
        if (this.f7113g0 != f3) {
            this.f7113g0 = f3;
            invalidateSelf();
            if (m4437U()) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: K */
    public final void m4427K(float f3) {
        if (this.f7099S != f3) {
            this.f7099S = f3;
            invalidateSelf();
            if (m4437U()) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: L */
    public final void m4428L(float f3) {
        if (this.f7112f0 != f3) {
            this.f7112f0 = f3;
            invalidateSelf();
            if (m4437U()) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: M */
    public final void m4429M(ColorStateList colorStateList) {
        if (this.f7098R != colorStateList) {
            this.f7098R = colorStateList;
            if (m4437U()) {
                AbstractC0139b.m280h(this.f7096P, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: N */
    public final void m4430N(boolean z3) {
        if (this.f7095O != z3) {
            boolean zM4437U = m4437U();
            this.f7095O = z3;
            boolean zM4437U2 = m4437U();
            if (zM4437U != zM4437U2) {
                if (zM4437U2) {
                    m4438o(this.f7096P);
                } else {
                    m4414V(this.f7096P);
                }
                invalidateSelf();
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m4431O(float f3) {
        if (this.f7109c0 != f3) {
            float fM4440q = m4440q();
            this.f7109c0 = f3;
            float fM4440q2 = m4440q();
            invalidateSelf();
            if (fM4440q != fM4440q2) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: P */
    public final void m4432P(float f3) {
        if (this.f7108b0 != f3) {
            float fM4440q = m4440q();
            this.f7108b0 = f3;
            float fM4440q2 = m4440q();
            invalidateSelf();
            if (fM4440q != fM4440q2) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: Q */
    public final void m4433Q(ColorStateList colorStateList) {
        if (this.f7085H != colorStateList) {
            this.f7085H = colorStateList;
            if (!this.f7078D0) {
                colorStateList = null;
            } else if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.f7080E0 = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: R */
    public final void m4434R(C0206d c0206d) {
        C0052l c0052l = this.f7121o0;
        if (c0052l.f196f != c0206d) {
            c0052l.f196f = c0206d;
            if (c0206d != null) {
                TextPaint textPaint = c0052l.f191a;
                Context context = this.f7115i0;
                C0050j c0050j = c0052l.f192b;
                c0206d.m401f(context, textPaint, c0050j);
                InterfaceC0051k interfaceC0051k = (InterfaceC0051k) c0052l.f195e.get();
                if (interfaceC0051k != null) {
                    textPaint.drawableState = interfaceC0051k.getState();
                }
                c0206d.m400e(context, textPaint, c0050j);
                c0052l.f194d = true;
            }
            InterfaceC0051k interfaceC0051k2 = (InterfaceC0051k) c0052l.f195e.get();
            if (interfaceC0051k2 != null) {
                C1996e c1996e = (C1996e) interfaceC0051k2;
                c1996e.m4443v();
                c1996e.invalidateSelf();
                c1996e.onStateChange(interfaceC0051k2.getState());
            }
        }
    }

    /* JADX INFO: renamed from: S */
    public final boolean m4435S() {
        return this.f7102V && this.f7103W != null && this.f7128v0;
    }

    /* JADX INFO: renamed from: T */
    public final boolean m4436T() {
        return this.f7089J && this.f7091K != null;
    }

    /* JADX INFO: renamed from: U */
    public final boolean m4437U() {
        return this.f7095O && this.f7096P != null;
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i3;
        RectF rectF;
        int i4;
        int i5;
        int i6;
        RectF rectF2;
        float f3;
        int iSave;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i3 = this.f7130x0) == 0) {
            return;
        }
        int iSaveLayerAlpha = i3 < 255 ? canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i3) : 0;
        boolean z3 = this.f7090J0;
        Paint paint = this.f7116j0;
        RectF rectF3 = this.f7118l0;
        if (!z3) {
            paint.setColor(this.f7122p0);
            paint.setStyle(Paint.Style.FILL);
            rectF3.set(bounds);
            canvas.drawRoundRect(rectF3, m4442s(), m4442s(), paint);
        }
        if (!this.f7090J0) {
            paint.setColor(this.f7123q0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.f7131y0;
            if (colorFilter == null) {
                colorFilter = this.f7132z0;
            }
            paint.setColorFilter(colorFilter);
            rectF3.set(bounds);
            canvas.drawRoundRect(rectF3, m4442s(), m4442s(), paint);
        }
        if (this.f7090J0) {
            super.draw(canvas);
        }
        if (this.f7083G > 0.0f && !this.f7090J0) {
            paint.setColor(this.f7125s0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f7090J0) {
                ColorFilter colorFilter2 = this.f7131y0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f7132z0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f4 = bounds.left;
            float f5 = this.f7083G / 2.0f;
            rectF3.set(f4 + f5, bounds.top + f5, bounds.right - f5, bounds.bottom - f5);
            float f6 = this.f7079E - (this.f7083G / 2.0f);
            canvas.drawRoundRect(rectF3, f6, f6, paint);
        }
        paint.setColor(this.f7126t0);
        paint.setStyle(Paint.Style.FILL);
        rectF3.set(bounds);
        if (this.f7090J0) {
            RectF rectF4 = new RectF(bounds);
            Path path = this.f7120n0;
            C0277f c0277f = this.f719e;
            this.f736v.m558c(c0277f.f697a, c0277f.f706j, rectF4, this.f735u, path);
            m541e(canvas, paint, path, this.f719e.f697a, m543g());
        } else {
            canvas.drawRoundRect(rectF3, m4442s(), m4442s(), paint);
        }
        if (m4436T()) {
            m4439p(bounds, rectF3);
            float f7 = rectF3.left;
            float f8 = rectF3.top;
            canvas.translate(f7, f8);
            this.f7091K.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
            this.f7091K.draw(canvas);
            canvas.translate(-f7, -f8);
        }
        if (m4435S()) {
            m4439p(bounds, rectF3);
            float f9 = rectF3.left;
            float f10 = rectF3.top;
            canvas.translate(f9, f10);
            this.f7103W.setBounds(0, 0, (int) rectF3.width(), (int) rectF3.height());
            this.f7103W.draw(canvas);
            canvas.translate(-f9, -f10);
        }
        if (!this.f7086H0 || this.f7087I == null) {
            rectF = rectF3;
            i4 = iSaveLayerAlpha;
            i5 = 255;
            i6 = 0;
        } else {
            PointF pointF = this.f7119m0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f7087I;
            C0052l c0052l = this.f7121o0;
            if (charSequence != null) {
                float fM4440q = m4440q() + this.f7107a0 + this.f7110d0;
                if (AbstractC0140c.m282a(this) == 0) {
                    pointF.x = bounds.left + fM4440q;
                } else {
                    pointF.x = bounds.right - fM4440q;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = c0052l.f191a;
                Paint.FontMetrics fontMetrics = this.f7117k0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF3.setEmpty();
            if (this.f7087I != null) {
                float fM4440q2 = m4440q() + this.f7107a0 + this.f7110d0;
                float fM4441r = m4441r() + this.f7114h0 + this.f7111e0;
                if (AbstractC0140c.m282a(this) == 0) {
                    rectF3.left = bounds.left + fM4440q2;
                    rectF3.right = bounds.right - fM4441r;
                } else {
                    rectF3.left = bounds.left + fM4441r;
                    rectF3.right = bounds.right - fM4440q2;
                }
                rectF3.top = bounds.top;
                rectF3.bottom = bounds.bottom;
            }
            C0206d c0206d = c0052l.f196f;
            TextPaint textPaint2 = c0052l.f191a;
            if (c0206d != null) {
                textPaint2.drawableState = getState();
                c0052l.f196f.m400e(this.f7115i0, textPaint2, c0052l.f192b);
            }
            textPaint2.setTextAlign(align);
            String string = this.f7087I.toString();
            if (c0052l.f194d) {
                float fMeasureText = string != null ? textPaint2.measureText((CharSequence) string, 0, string.length()) : 0.0f;
                c0052l.f193c = fMeasureText;
                c0052l.f194d = false;
                f3 = fMeasureText;
            } else {
                f3 = c0052l.f193c;
            }
            boolean z4 = Math.round(f3) > Math.round(rectF3.width());
            if (z4) {
                iSave = canvas.save();
                canvas.clipRect(rectF3);
            } else {
                iSave = 0;
            }
            CharSequence charSequenceEllipsize = this.f7087I;
            if (z4 && this.f7084G0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF3.width(), this.f7084G0);
            }
            CharSequence charSequence2 = charSequenceEllipsize;
            int length = charSequence2.length();
            float f11 = pointF.x;
            float f12 = pointF.y;
            rectF = rectF3;
            i4 = iSaveLayerAlpha;
            i5 = 255;
            i6 = 0;
            canvas.drawText(charSequence2, 0, length, f11, f12, textPaint2);
            if (z4) {
                canvas.restoreToCount(iSave);
            }
        }
        if (m4437U()) {
            rectF.setEmpty();
            if (m4437U()) {
                float f13 = this.f7114h0 + this.f7113g0;
                if (AbstractC0140c.m282a(this) == 0) {
                    float f14 = bounds.right - f13;
                    rectF2 = rectF;
                    rectF2.right = f14;
                    rectF2.left = f14 - this.f7099S;
                } else {
                    rectF2 = rectF;
                    float f15 = bounds.left + f13;
                    rectF2.left = f15;
                    rectF2.right = f15 + this.f7099S;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f16 = this.f7099S;
                float f17 = fExactCenterY - (f16 / 2.0f);
                rectF2.top = f17;
                rectF2.bottom = f17 + f16;
            } else {
                rectF2 = rectF;
            }
            float f18 = rectF2.left;
            float f19 = rectF2.top;
            canvas.translate(f18, f19);
            this.f7096P.setBounds(i6, i6, (int) rectF2.width(), (int) rectF2.height());
            this.f7097Q.setBounds(this.f7096P.getBounds());
            this.f7097Q.jumpToCurrentState();
            this.f7097Q.draw(canvas);
            canvas.translate(-f18, -f19);
        }
        if (this.f7130x0 < i5) {
            canvas.restoreToCount(i4);
        }
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f7130x0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f7131y0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f7077D;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        float fMeasureText;
        float fM4440q = m4440q() + this.f7107a0 + this.f7110d0;
        String string = this.f7087I.toString();
        C0052l c0052l = this.f7121o0;
        if (c0052l.f194d) {
            fMeasureText = string == null ? 0.0f : c0052l.f191a.measureText((CharSequence) string, 0, string.length());
            c0052l.f193c = fMeasureText;
            c0052l.f194d = false;
        } else {
            fMeasureText = c0052l.f193c;
        }
        return Math.min(Math.round(m4441r() + fMeasureText + fM4440q + this.f7111e0 + this.f7114h0), this.f7088I0);
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        if (this.f7090J0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f7077D, this.f7079E);
        } else {
            outline.setRoundRect(bounds, this.f7079E);
        }
        outline.setAlpha(this.f7130x0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        C0206d c0206d;
        ColorStateList colorStateList;
        return m4415t(this.f7073B) || m4415t(this.f7075C) || m4415t(this.f7081F) || (this.f7078D0 && m4415t(this.f7080E0)) || (!((c0206d = this.f7121o0.f196f) == null || (colorStateList = c0206d.f507j) == null || !colorStateList.isStateful()) || ((this.f7102V && this.f7103W != null && this.f7101U) || m4416u(this.f7091K) || m4416u(this.f7103W) || m4415t(this.f7072A0)));
    }

    /* JADX INFO: renamed from: o */
    public final void m4438o(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        AbstractC0140c.m283b(drawable, AbstractC0140c.m282a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f7096P) {
            if (drawable.isStateful()) {
                drawable.setState(this.f7076C0);
            }
            AbstractC0139b.m280h(drawable, this.f7098R);
            return;
        }
        Drawable drawable2 = this.f7091K;
        if (drawable == drawable2 && this.f7094N) {
            AbstractC0139b.m280h(drawable2, this.f7092L);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i3) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i3);
        if (m4436T()) {
            zOnLayoutDirectionChanged |= AbstractC0140c.m283b(this.f7091K, i3);
        }
        if (m4435S()) {
            zOnLayoutDirectionChanged |= AbstractC0140c.m283b(this.f7103W, i3);
        }
        if (m4437U()) {
            zOnLayoutDirectionChanged |= AbstractC0140c.m283b(this.f7096P, i3);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i3) {
        boolean zOnLevelChange = super.onLevelChange(i3);
        if (m4436T()) {
            zOnLevelChange |= this.f7091K.setLevel(i3);
        }
        if (m4435S()) {
            zOnLevelChange |= this.f7103W.setLevel(i3);
        }
        if (m4437U()) {
            zOnLevelChange |= this.f7096P.setLevel(i3);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.f7090J0) {
            super.onStateChange(iArr);
        }
        return m4444w(iArr, this.f7076C0);
    }

    /* JADX INFO: renamed from: p */
    public final void m4439p(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m4436T() || m4435S()) {
            float f3 = this.f7107a0 + this.f7108b0;
            Drawable drawable = this.f7128v0 ? this.f7103W : this.f7091K;
            float intrinsicWidth = this.f7093M;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (AbstractC0140c.m282a(this) == 0) {
                float f4 = rect.left + f3;
                rectF.left = f4;
                rectF.right = f4 + intrinsicWidth;
            } else {
                float f5 = rect.right - f3;
                rectF.right = f5;
                rectF.left = f5 - intrinsicWidth;
            }
            Drawable drawable2 = this.f7128v0 ? this.f7103W : this.f7091K;
            float fCeil = this.f7093M;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f7115i0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    /* JADX INFO: renamed from: q */
    public final float m4440q() {
        if (!m4436T() && !m4435S()) {
            return 0.0f;
        }
        float f3 = this.f7108b0;
        Drawable drawable = this.f7128v0 ? this.f7103W : this.f7091K;
        float intrinsicWidth = this.f7093M;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f3 + this.f7109c0;
    }

    /* JADX INFO: renamed from: r */
    public final float m4441r() {
        if (m4437U()) {
            return this.f7112f0 + this.f7099S + this.f7113g0;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: s */
    public final float m4442s() {
        return this.f7090J0 ? this.f719e.f697a.f746e.mo529a(m543g()) : this.f7079E;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        if (this.f7130x0 != i3) {
            this.f7130x0 = i3;
            invalidateSelf();
        }
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f7131y0 != colorFilter) {
            this.f7131y0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f7072A0 != colorStateList) {
            this.f7072A0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // p025H1.C0278g, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f7074B0 != mode) {
            this.f7074B0 = mode;
            ColorStateList colorStateList = this.f7072A0;
            this.f7132z0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z3, boolean z4) {
        boolean visible = super.setVisible(z3, z4);
        if (m4436T()) {
            visible |= this.f7091K.setVisible(z3, z4);
        }
        if (m4435S()) {
            visible |= this.f7103W.setVisible(z3, z4);
        }
        if (m4437U()) {
            visible |= this.f7096P.setVisible(z3, z4);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX INFO: renamed from: v */
    public final void m4443v() {
        InterfaceC1995d interfaceC1995d = (InterfaceC1995d) this.f7082F0.get();
        if (interfaceC1995d != null) {
            Chip chip = (Chip) interfaceC1995d;
            chip.m3169b(chip.f4333t);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX INFO: renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m4444w(int[] r12, int[] r13) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p157w1.C1996e.m4444w(int[], int[]):boolean");
    }

    /* JADX INFO: renamed from: x */
    public final void m4445x(boolean z3) {
        if (this.f7101U != z3) {
            this.f7101U = z3;
            float fM4440q = m4440q();
            if (!z3 && this.f7128v0) {
                this.f7128v0 = false;
            }
            float fM4440q2 = m4440q();
            invalidateSelf();
            if (fM4440q != fM4440q2) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public final void m4446y(Drawable drawable) {
        if (this.f7103W != drawable) {
            float fM4440q = m4440q();
            this.f7103W = drawable;
            float fM4440q2 = m4440q();
            m4414V(this.f7103W);
            m4438o(this.f7103W);
            invalidateSelf();
            if (fM4440q != fM4440q2) {
                m4443v();
            }
        }
    }

    /* JADX INFO: renamed from: z */
    public final void m4447z(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f7104X != colorStateList) {
            this.f7104X = colorStateList;
            if (this.f7102V && (drawable = this.f7103W) != null && this.f7101U) {
                AbstractC0139b.m280h(drawable, colorStateList);
            }
            onStateChange(getState());
        }
    }
}

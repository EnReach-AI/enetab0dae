package p091e0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p001A.AbstractC0001b;
import p001A.AbstractC0002c;
import p009C.AbstractC0138a;
import p009C.AbstractC0139b;
import p009C.AbstractC0140c;
import p071Y0.AbstractC0752p;
import p117m0.AbstractC1720o;
import p128p.C1808b;

/* JADX INFO: renamed from: e0.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1335p extends AbstractC1326g {

    /* JADX INFO: renamed from: n */
    public static final PorterDuff.Mode f4754n = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: f */
    public C1333n f4755f;

    /* JADX INFO: renamed from: g */
    public PorterDuffColorFilter f4756g;

    /* JADX INFO: renamed from: h */
    public ColorFilter f4757h;

    /* JADX INFO: renamed from: i */
    public boolean f4758i;

    /* JADX INFO: renamed from: j */
    public boolean f4759j;

    /* JADX INFO: renamed from: k */
    public final float[] f4760k;

    /* JADX INFO: renamed from: l */
    public final Matrix f4761l;

    /* JADX INFO: renamed from: m */
    public final Rect f4762m;

    public C1335p() {
        this.f4759j = true;
        this.f4760k = new float[9];
        this.f4761l = new Matrix();
        this.f4762m = new Rect();
        C1333n c1333n = new C1333n();
        c1333n.f4743c = null;
        c1333n.f4744d = f4754n;
        c1333n.f4742b = new C1332m();
        this.f4755f = c1333n;
    }

    /* JADX INFO: renamed from: a */
    public final PorterDuffColorFilter m3289a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f4697e;
        if (drawable == null) {
            return false;
        }
        AbstractC0139b.m274b(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f4762m;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f4757h;
        if (colorFilter == null) {
            colorFilter = this.f4756g;
        }
        Matrix matrix = this.f4761l;
        canvas.getMatrix(matrix);
        float[] fArr = this.f4760k;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && AbstractC0140c.m282a(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        C1333n c1333n = this.f4755f;
        Bitmap bitmap = c1333n.f4746f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != c1333n.f4746f.getHeight()) {
            c1333n.f4746f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            c1333n.f4751k = true;
        }
        if (this.f4759j) {
            C1333n c1333n2 = this.f4755f;
            if (c1333n2.f4751k || c1333n2.f4747g != c1333n2.f4743c || c1333n2.f4748h != c1333n2.f4744d || c1333n2.f4750j != c1333n2.f4745e || c1333n2.f4749i != c1333n2.f4742b.getRootAlpha()) {
                C1333n c1333n3 = this.f4755f;
                c1333n3.f4746f.eraseColor(0);
                Canvas canvas2 = new Canvas(c1333n3.f4746f);
                C1332m c1332m = c1333n3.f4742b;
                c1332m.m3288a(c1332m.f4732g, C1332m.f4725p, canvas2, iMin, iMin2);
                C1333n c1333n4 = this.f4755f;
                c1333n4.f4747g = c1333n4.f4743c;
                c1333n4.f4748h = c1333n4.f4744d;
                c1333n4.f4749i = c1333n4.f4742b.getRootAlpha();
                c1333n4.f4750j = c1333n4.f4745e;
                c1333n4.f4751k = false;
            }
        } else {
            C1333n c1333n5 = this.f4755f;
            c1333n5.f4746f.eraseColor(0);
            Canvas canvas3 = new Canvas(c1333n5.f4746f);
            C1332m c1332m2 = c1333n5.f4742b;
            c1332m2.m3288a(c1332m2.f4732g, C1332m.f4725p, canvas3, iMin, iMin2);
        }
        C1333n c1333n6 = this.f4755f;
        if (c1333n6.f4742b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (c1333n6.f4752l == null) {
                Paint paint2 = new Paint();
                c1333n6.f4752l = paint2;
                paint2.setFilterBitmap(true);
            }
            c1333n6.f4752l.setAlpha(c1333n6.f4742b.getRootAlpha());
            c1333n6.f4752l.setColorFilter(colorFilter);
            paint = c1333n6.f4752l;
        }
        canvas.drawBitmap(c1333n6.f4746f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f4697e;
        return drawable != null ? AbstractC0138a.m268a(drawable) : this.f4755f.f4742b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f4755f.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f4697e;
        return drawable != null ? AbstractC0139b.m275c(drawable) : this.f4757h;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f4697e != null) {
            return new C1334o(this.f4697e.getConstantState());
        }
        this.f4755f.f4741a = getChangingConfigurations();
        return this.f4755f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f4755f.f4742b.f4734i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f4755f.f4742b.f4733h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f4697e;
        return drawable != null ? AbstractC0138a.m271d(drawable) : this.f4755f.f4745e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            C1333n c1333n = this.f4755f;
            if (c1333n != null) {
                C1332m c1332m = c1333n.f4742b;
                if (c1332m.f4739n == null) {
                    c1332m.f4739n = Boolean.valueOf(c1332m.f4732g.mo3285a());
                }
                if (c1332m.f4739n.booleanValue() || ((colorStateList = this.f4755f.f4743c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f4758i && super.mutate() == this) {
            C1333n c1333n = this.f4755f;
            C1333n c1333n2 = new C1333n();
            c1333n2.f4743c = null;
            c1333n2.f4744d = f4754n;
            if (c1333n != null) {
                c1333n2.f4741a = c1333n.f4741a;
                C1332m c1332m = new C1332m(c1333n.f4742b);
                c1333n2.f4742b = c1332m;
                if (c1333n.f4742b.f4730e != null) {
                    c1332m.f4730e = new Paint(c1333n.f4742b.f4730e);
                }
                if (c1333n.f4742b.f4729d != null) {
                    c1333n2.f4742b.f4729d = new Paint(c1333n.f4742b.f4729d);
                }
                c1333n2.f4743c = c1333n.f4743c;
                c1333n2.f4744d = c1333n.f4744d;
                c1333n2.f4745e = c1333n.f4745e;
            }
            this.f4755f = c1333n2;
            this.f4758i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z3;
        PorterDuff.Mode mode;
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        C1333n c1333n = this.f4755f;
        ColorStateList colorStateList = c1333n.f4743c;
        if (colorStateList == null || (mode = c1333n.f4744d) == null) {
            z3 = false;
        } else {
            this.f4756g = m3289a(colorStateList, mode);
            invalidateSelf();
            z3 = true;
        }
        C1332m c1332m = c1333n.f4742b;
        if (c1332m.f4739n == null) {
            c1332m.f4739n = Boolean.valueOf(c1332m.f4732g.mo3285a());
        }
        if (c1332m.f4739n.booleanValue()) {
            boolean zMo3286b = c1333n.f4742b.f4732g.mo3286b(iArr);
            c1333n.f4751k |= zMo3286b;
            if (zMo3286b) {
                invalidateSelf();
                return true;
            }
        }
        return z3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else if (this.f4755f.f4742b.getRootAlpha() != i3) {
            this.f4755f.f4742b.setRootAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z3) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0138a.m272e(drawable, z3);
        } else {
            this.f4755f.f4745e = z3;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4757h = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i3) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC1720o.m3822c(drawable, i3);
        } else {
            setTintList(ColorStateList.valueOf(i3));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0139b.m280h(drawable, colorStateList);
            return;
        }
        C1333n c1333n = this.f4755f;
        if (c1333n.f4743c != colorStateList) {
            c1333n.f4743c = colorStateList;
            this.f4756g = m3289a(colorStateList, c1333n.f4744d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0139b.m281i(drawable, mode);
            return;
        }
        C1333n c1333n = this.f4755f;
        if (c1333n.f4744d != mode) {
            c1333n.f4744d = mode;
            this.f4756g = m3289a(c1333n.f4743c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z3, boolean z4) {
        Drawable drawable = this.f4697e;
        return drawable != null ? drawable.setVisible(z3, z4) : super.setVisible(z3, z4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C1332m c1332m;
        int i3;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        Paint.Join join;
        Paint.Cap cap;
        Paint.Join join2;
        Drawable drawable = this.f4697e;
        if (drawable != null) {
            AbstractC0139b.m276d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C1333n c1333n = this.f4755f;
        c1333n.f4742b = new C1332m();
        TypedArray typedArrayM7f = AbstractC0001b.m7f(resources, theme, attributeSet, AbstractC1320a.f4679a);
        C1333n c1333n2 = this.f4755f;
        C1332m c1332m2 = c1333n2.f4742b;
        int i6 = !AbstractC0001b.m4c(xmlPullParser, "tintMode") ? -1 : typedArrayM7f.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i7 = 3;
        if (i6 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i6 != 5) {
            if (i6 != 9) {
                switch (i6) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        c1333n2.f4744d = mode;
        int i8 = 1;
        ColorStateList colorStateListM15a = null;
        boolean z5 = false;
        if (AbstractC0001b.m4c(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayM7f.getValue(1, typedValue);
            int i9 = typedValue.type;
            if (i9 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i9 >= 28 && i9 <= 31) {
                colorStateListM15a = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayM7f.getResources();
                int resourceId = typedArrayM7f.getResourceId(1, 0);
                ThreadLocal threadLocal = AbstractC0002c.f13a;
                try {
                    colorStateListM15a = AbstractC0002c.m15a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e3) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e3);
                }
            }
        }
        ColorStateList colorStateList = colorStateListM15a;
        if (colorStateList != null) {
            c1333n2.f4743c = colorStateList;
        }
        boolean z6 = c1333n2.f4745e;
        if (AbstractC0001b.m4c(xmlPullParser, "autoMirrored")) {
            z6 = typedArrayM7f.getBoolean(5, z6);
        }
        c1333n2.f4745e = z6;
        float f3 = c1332m2.f4735j;
        if (AbstractC0001b.m4c(xmlPullParser, "viewportWidth")) {
            f3 = typedArrayM7f.getFloat(7, f3);
        }
        c1332m2.f4735j = f3;
        float f4 = c1332m2.f4736k;
        if (AbstractC0001b.m4c(xmlPullParser, "viewportHeight")) {
            f4 = typedArrayM7f.getFloat(8, f4);
        }
        c1332m2.f4736k = f4;
        if (c1332m2.f4735j <= 0.0f) {
            throw new XmlPullParserException(typedArrayM7f.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f4 > 0.0f) {
            c1332m2.f4733h = typedArrayM7f.getDimension(3, c1332m2.f4733h);
            float dimension = typedArrayM7f.getDimension(2, c1332m2.f4734i);
            c1332m2.f4734i = dimension;
            if (c1332m2.f4733h <= 0.0f) {
                throw new XmlPullParserException(typedArrayM7f.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = c1332m2.getAlpha();
                if (AbstractC0001b.m4c(xmlPullParser, "alpha")) {
                    alpha = typedArrayM7f.getFloat(4, alpha);
                }
                c1332m2.setAlpha(alpha);
                String string = typedArrayM7f.getString(0);
                if (string != null) {
                    c1332m2.f4738m = string;
                    c1332m2.f4740o.put(string, c1332m2);
                }
                typedArrayM7f.recycle();
                c1333n.f4741a = getChangingConfigurations();
                c1333n.f4751k = true;
                C1333n c1333n3 = this.f4755f;
                C1332m c1332m3 = c1333n3.f4742b;
                ArrayDeque arrayDeque = new ArrayDeque();
                arrayDeque.push(c1332m3.f4732g);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z7 = true;
                while (eventType != i8 && (xmlPullParser.getDepth() >= depth || eventType != i7)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        C1329j c1329j = (C1329j) arrayDeque.peek();
                        boolean zEquals = "path".equals(name);
                        i3 = depth;
                        C1808b c1808b = c1332m3.f4740o;
                        if (zEquals) {
                            C1328i c1328i = new C1328i();
                            c1328i.f4699f = 0.0f;
                            c1328i.f4701h = 1.0f;
                            c1328i.f4702i = 1.0f;
                            c1328i.f4703j = 0.0f;
                            c1328i.f4704k = 1.0f;
                            c1328i.f4705l = 0.0f;
                            Paint.Cap cap2 = Paint.Cap.BUTT;
                            c1328i.f4706m = cap2;
                            Paint.Join join3 = Paint.Join.MITER;
                            c1328i.f4707n = join3;
                            c1332m = c1332m3;
                            c1328i.f4708o = 4.0f;
                            TypedArray typedArrayM7f2 = AbstractC0001b.m7f(resources, theme, attributeSet, AbstractC1320a.f4681c);
                            if (AbstractC0001b.m4c(xmlPullParser, "pathData")) {
                                String string2 = typedArrayM7f2.getString(0);
                                if (string2 != null) {
                                    c1328i.f4722b = string2;
                                }
                                String string3 = typedArrayM7f2.getString(2);
                                if (string3 != null) {
                                    c1328i.f4721a = AbstractC0752p.m1935d(string3);
                                }
                                c1328i.f4700g = AbstractC0001b.m3b(typedArrayM7f2, xmlPullParser, theme, "fillColor", 1);
                                float f5 = c1328i.f4702i;
                                if (AbstractC0001b.m4c(xmlPullParser, "fillAlpha")) {
                                    f5 = typedArrayM7f2.getFloat(12, f5);
                                }
                                c1328i.f4702i = f5;
                                int i10 = !AbstractC0001b.m4c(xmlPullParser, "strokeLineCap") ? -1 : typedArrayM7f2.getInt(8, -1);
                                Paint.Cap cap3 = c1328i.f4706m;
                                if (i10 != 0) {
                                    join = join3;
                                    if (i10 != 1) {
                                        cap = i10 != 2 ? cap3 : Paint.Cap.SQUARE;
                                    } else {
                                        cap = Paint.Cap.ROUND;
                                    }
                                } else {
                                    join = join3;
                                    cap = cap2;
                                }
                                c1328i.f4706m = cap;
                                int i11 = !AbstractC0001b.m4c(xmlPullParser, "strokeLineJoin") ? -1 : typedArrayM7f2.getInt(9, -1);
                                Paint.Join join4 = c1328i.f4707n;
                                if (i11 == 0) {
                                    join2 = join;
                                } else if (i11 != 1) {
                                    join2 = i11 != 2 ? join4 : Paint.Join.BEVEL;
                                } else {
                                    join2 = Paint.Join.ROUND;
                                }
                                c1328i.f4707n = join2;
                                float f6 = c1328i.f4708o;
                                if (AbstractC0001b.m4c(xmlPullParser, "strokeMiterLimit")) {
                                    f6 = typedArrayM7f2.getFloat(10, f6);
                                }
                                c1328i.f4708o = f6;
                                c1328i.f4698e = AbstractC0001b.m3b(typedArrayM7f2, xmlPullParser, theme, "strokeColor", 3);
                                float f7 = c1328i.f4701h;
                                if (AbstractC0001b.m4c(xmlPullParser, "strokeAlpha")) {
                                    f7 = typedArrayM7f2.getFloat(11, f7);
                                }
                                c1328i.f4701h = f7;
                                float f8 = c1328i.f4699f;
                                if (AbstractC0001b.m4c(xmlPullParser, "strokeWidth")) {
                                    f8 = typedArrayM7f2.getFloat(4, f8);
                                }
                                c1328i.f4699f = f8;
                                float f9 = c1328i.f4704k;
                                if (AbstractC0001b.m4c(xmlPullParser, "trimPathEnd")) {
                                    f9 = typedArrayM7f2.getFloat(6, f9);
                                }
                                c1328i.f4704k = f9;
                                float f10 = c1328i.f4705l;
                                if (AbstractC0001b.m4c(xmlPullParser, "trimPathOffset")) {
                                    f10 = typedArrayM7f2.getFloat(7, f10);
                                }
                                c1328i.f4705l = f10;
                                float f11 = c1328i.f4703j;
                                if (AbstractC0001b.m4c(xmlPullParser, "trimPathStart")) {
                                    f11 = typedArrayM7f2.getFloat(5, f11);
                                }
                                c1328i.f4703j = f11;
                                int i12 = c1328i.f4723c;
                                if (AbstractC0001b.m4c(xmlPullParser, "fillType")) {
                                    i12 = typedArrayM7f2.getInt(13, i12);
                                }
                                c1328i.f4723c = i12;
                            }
                            typedArrayM7f2.recycle();
                            c1329j.f4710b.add(c1328i);
                            if (c1328i.getPathName() != null) {
                                c1808b.put(c1328i.getPathName(), c1328i);
                            }
                            c1333n3.f4741a |= c1328i.f4724d;
                            z4 = false;
                            i4 = 1;
                            z7 = false;
                        } else {
                            c1332m = c1332m3;
                            if ("clip-path".equals(name)) {
                                C1327h c1327h = new C1327h();
                                if (AbstractC0001b.m4c(xmlPullParser, "pathData")) {
                                    TypedArray typedArrayM7f3 = AbstractC0001b.m7f(resources, theme, attributeSet, AbstractC1320a.f4682d);
                                    String string4 = typedArrayM7f3.getString(0);
                                    if (string4 != null) {
                                        c1327h.f4722b = string4;
                                    }
                                    String string5 = typedArrayM7f3.getString(1);
                                    if (string5 != null) {
                                        c1327h.f4721a = AbstractC0752p.m1935d(string5);
                                    }
                                    c1327h.f4723c = !AbstractC0001b.m4c(xmlPullParser, "fillType") ? 0 : typedArrayM7f3.getInt(2, 0);
                                    typedArrayM7f3.recycle();
                                }
                                c1329j.f4710b.add(c1327h);
                                if (c1327h.getPathName() != null) {
                                    c1808b.put(c1327h.getPathName(), c1327h);
                                }
                                c1333n3.f4741a = c1327h.f4724d | c1333n3.f4741a;
                            } else if ("group".equals(name)) {
                                C1329j c1329j2 = new C1329j();
                                TypedArray typedArrayM7f4 = AbstractC0001b.m7f(resources, theme, attributeSet, AbstractC1320a.f4680b);
                                float f12 = c1329j2.f4711c;
                                if (AbstractC0001b.m4c(xmlPullParser, "rotation")) {
                                    f12 = typedArrayM7f4.getFloat(5, f12);
                                }
                                c1329j2.f4711c = f12;
                                i4 = 1;
                                c1329j2.f4712d = typedArrayM7f4.getFloat(1, c1329j2.f4712d);
                                c1329j2.f4713e = typedArrayM7f4.getFloat(2, c1329j2.f4713e);
                                float f13 = c1329j2.f4714f;
                                if (AbstractC0001b.m4c(xmlPullParser, "scaleX")) {
                                    f13 = typedArrayM7f4.getFloat(3, f13);
                                }
                                c1329j2.f4714f = f13;
                                float f14 = c1329j2.f4715g;
                                if (AbstractC0001b.m4c(xmlPullParser, "scaleY")) {
                                    f14 = typedArrayM7f4.getFloat(4, f14);
                                }
                                c1329j2.f4715g = f14;
                                float f15 = c1329j2.f4716h;
                                if (AbstractC0001b.m4c(xmlPullParser, "translateX")) {
                                    f15 = typedArrayM7f4.getFloat(6, f15);
                                }
                                c1329j2.f4716h = f15;
                                float f16 = c1329j2.f4717i;
                                if (AbstractC0001b.m4c(xmlPullParser, "translateY")) {
                                    f16 = typedArrayM7f4.getFloat(7, f16);
                                }
                                c1329j2.f4717i = f16;
                                z4 = false;
                                String string6 = typedArrayM7f4.getString(0);
                                if (string6 != null) {
                                    c1329j2.f4720l = string6;
                                }
                                c1329j2.m3287c();
                                typedArrayM7f4.recycle();
                                c1329j.f4710b.add(c1329j2);
                                arrayDeque.push(c1329j2);
                                if (c1329j2.getGroupName() != null) {
                                    c1808b.put(c1329j2.getGroupName(), c1329j2);
                                }
                                c1333n3.f4741a = c1329j2.f4719k | c1333n3.f4741a;
                            }
                            z4 = false;
                            i4 = 1;
                        }
                        z3 = z4;
                        i5 = 3;
                    } else {
                        c1332m = c1332m3;
                        i3 = depth;
                        i4 = i8;
                        z3 = z5;
                        i5 = 3;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    i7 = i5;
                    z5 = z3;
                    i8 = i4;
                    depth = i3;
                    c1332m3 = c1332m;
                }
                if (!z7) {
                    this.f4756g = m3289a(c1333n.f4743c, c1333n.f4744d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayM7f.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayM7f.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    public C1335p(C1333n c1333n) {
        this.f4759j = true;
        this.f4760k = new float[9];
        this.f4761l = new Matrix();
        this.f4762m = new Rect();
        this.f4755f = c1333n;
        this.f4756g = m3289a(c1333n.f4743c, c1333n.f4744d);
    }
}

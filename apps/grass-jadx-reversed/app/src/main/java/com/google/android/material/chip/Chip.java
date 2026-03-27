package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;
import p007B1.AbstractC0054n;
import p007B1.C0050j;
import p007B1.C0052l;
import p007B1.InterfaceC0047g;
import p009C.AbstractC0140c;
import p009C.AbstractC0146i;
import p009C.InterfaceC0145h;
import p015D2.C0181e;
import p016E1.C0206d;
import p023H.AbstractC0245h;
import p023H.AbstractC0246i;
import p023H.C0239b;
import p025H1.C0281j;
import p025H1.InterfaceC0292u;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p039M0.AbstractC0473V;
import p040M1.AbstractC0512a;
import p110k.C1609p;
import p125o0.AbstractC1800j;
import p126o1.AbstractC1805a;
import p130p1.C1825b;
import p144t0.AbstractC1920f;
import p157w1.C1993b;
import p157w1.C1994c;
import p157w1.C1996e;
import p157w1.InterfaceC1995d;
import p165z.AbstractC2049e;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends C1609p implements InterfaceC1995d, InterfaceC0292u, Checkable {

    /* JADX INFO: renamed from: A */
    public static final Rect f4319A = new Rect();

    /* JADX INFO: renamed from: B */
    public static final int[] f4320B = {R.attr.state_selected};

    /* JADX INFO: renamed from: C */
    public static final int[] f4321C = {R.attr.state_checkable};

    /* JADX INFO: renamed from: i */
    public C1996e f4322i;

    /* JADX INFO: renamed from: j */
    public InsetDrawable f4323j;

    /* JADX INFO: renamed from: k */
    public RippleDrawable f4324k;

    /* JADX INFO: renamed from: l */
    public View.OnClickListener f4325l;

    /* JADX INFO: renamed from: m */
    public CompoundButton.OnCheckedChangeListener f4326m;

    /* JADX INFO: renamed from: n */
    public boolean f4327n;

    /* JADX INFO: renamed from: o */
    public boolean f4328o;

    /* JADX INFO: renamed from: p */
    public boolean f4329p;

    /* JADX INFO: renamed from: q */
    public boolean f4330q;

    /* JADX INFO: renamed from: r */
    public boolean f4331r;

    /* JADX INFO: renamed from: s */
    public int f4332s;

    /* JADX INFO: renamed from: t */
    public int f4333t;

    /* JADX INFO: renamed from: u */
    public CharSequence f4334u;

    /* JADX INFO: renamed from: v */
    public final C1994c f4335v;

    /* JADX INFO: renamed from: w */
    public boolean f4336w;

    /* JADX INFO: renamed from: x */
    public final Rect f4337x;

    /* JADX INFO: renamed from: y */
    public final RectF f4338y;

    /* JADX INFO: renamed from: z */
    public final C0050j f4339z;

    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int resourceId2;
        int resourceId3;
        super(AbstractC0512a.m1020a(context, attributeSet, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action), attributeSet, io.getgrass.www.R.attr.chipStyle);
        this.f4337x = new Rect();
        this.f4338y = new RectF();
        this.f4339z = new C0050j(1, this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
        C1996e c1996e = new C1996e(context2, attributeSet);
        int[] iArr = AbstractC1805a.f6226b;
        TypedArray typedArrayM216f = AbstractC0054n.m216f(c1996e.f7115i0, attributeSet, iArr, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        c1996e.f7090J0 = typedArrayM216f.hasValue(37);
        Context context3 = c1996e.f7115i0;
        ColorStateList colorStateListM4303d = AbstractC1920f.m4303d(context3, typedArrayM216f, 24);
        if (c1996e.f7073B != colorStateListM4303d) {
            c1996e.f7073B = colorStateListM4303d;
            c1996e.onStateChange(c1996e.getState());
        }
        ColorStateList colorStateListM4303d2 = AbstractC1920f.m4303d(context3, typedArrayM216f, 11);
        if (c1996e.f7075C != colorStateListM4303d2) {
            c1996e.f7075C = colorStateListM4303d2;
            c1996e.onStateChange(c1996e.getState());
        }
        float dimension = typedArrayM216f.getDimension(19, 0.0f);
        if (c1996e.f7077D != dimension) {
            c1996e.f7077D = dimension;
            c1996e.invalidateSelf();
            c1996e.m4443v();
        }
        if (typedArrayM216f.hasValue(12)) {
            c1996e.m4418B(typedArrayM216f.getDimension(12, 0.0f));
        }
        c1996e.m4423G(AbstractC1920f.m4303d(context3, typedArrayM216f, 22));
        c1996e.m4424H(typedArrayM216f.getDimension(23, 0.0f));
        c1996e.m4433Q(AbstractC1920f.m4303d(context3, typedArrayM216f, 36));
        String text = typedArrayM216f.getText(5);
        text = text == null ? "" : text;
        if (!TextUtils.equals(c1996e.f7087I, text)) {
            c1996e.f7087I = text;
            c1996e.f7121o0.f194d = true;
            c1996e.invalidateSelf();
            c1996e.m4443v();
        }
        C0206d c0206d = (!typedArrayM216f.hasValue(0) || (resourceId3 = typedArrayM216f.getResourceId(0, 0)) == 0) ? null : new C0206d(context3, resourceId3);
        c0206d.f508k = typedArrayM216f.getDimension(1, c0206d.f508k);
        c1996e.m4434R(c0206d);
        int i3 = typedArrayM216f.getInt(3, 0);
        if (i3 == 1) {
            c1996e.f7084G0 = TextUtils.TruncateAt.START;
        } else if (i3 == 2) {
            c1996e.f7084G0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i3 == 3) {
            c1996e.f7084G0 = TextUtils.TruncateAt.END;
        }
        c1996e.m4422F(typedArrayM216f.getBoolean(18, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            c1996e.m4422F(typedArrayM216f.getBoolean(15, false));
        }
        c1996e.m4419C(AbstractC1920f.m4305f(context3, typedArrayM216f, 14));
        if (typedArrayM216f.hasValue(17)) {
            c1996e.m4421E(AbstractC1920f.m4303d(context3, typedArrayM216f, 17));
        }
        c1996e.m4420D(typedArrayM216f.getDimension(16, -1.0f));
        c1996e.m4430N(typedArrayM216f.getBoolean(31, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            c1996e.m4430N(typedArrayM216f.getBoolean(26, false));
        }
        c1996e.m4425I(AbstractC1920f.m4305f(context3, typedArrayM216f, 25));
        c1996e.m4429M(AbstractC1920f.m4303d(context3, typedArrayM216f, 30));
        c1996e.m4427K(typedArrayM216f.getDimension(28, 0.0f));
        c1996e.m4445x(typedArrayM216f.getBoolean(6, false));
        c1996e.m4417A(typedArrayM216f.getBoolean(10, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            c1996e.m4417A(typedArrayM216f.getBoolean(8, false));
        }
        c1996e.m4446y(AbstractC1920f.m4305f(context3, typedArrayM216f, 7));
        if (typedArrayM216f.hasValue(9)) {
            c1996e.m4447z(AbstractC1920f.m4303d(context3, typedArrayM216f, 9));
        }
        c1996e.f7105Y = (!typedArrayM216f.hasValue(39) || (resourceId2 = typedArrayM216f.getResourceId(39, 0)) == 0) ? null : C1825b.m4070a(context3, resourceId2);
        c1996e.f7106Z = (!typedArrayM216f.hasValue(33) || (resourceId = typedArrayM216f.getResourceId(33, 0)) == 0) ? null : C1825b.m4070a(context3, resourceId);
        float dimension2 = typedArrayM216f.getDimension(21, 0.0f);
        if (c1996e.f7107a0 != dimension2) {
            c1996e.f7107a0 = dimension2;
            c1996e.invalidateSelf();
            c1996e.m4443v();
        }
        c1996e.m4432P(typedArrayM216f.getDimension(35, 0.0f));
        c1996e.m4431O(typedArrayM216f.getDimension(34, 0.0f));
        float dimension3 = typedArrayM216f.getDimension(41, 0.0f);
        if (c1996e.f7110d0 != dimension3) {
            c1996e.f7110d0 = dimension3;
            c1996e.invalidateSelf();
            c1996e.m4443v();
        }
        float dimension4 = typedArrayM216f.getDimension(40, 0.0f);
        if (c1996e.f7111e0 != dimension4) {
            c1996e.f7111e0 = dimension4;
            c1996e.invalidateSelf();
            c1996e.m4443v();
        }
        c1996e.m4428L(typedArrayM216f.getDimension(29, 0.0f));
        c1996e.m4426J(typedArrayM216f.getDimension(27, 0.0f));
        float dimension5 = typedArrayM216f.getDimension(13, 0.0f);
        if (c1996e.f7114h0 != dimension5) {
            c1996e.f7114h0 = dimension5;
            c1996e.invalidateSelf();
            c1996e.m4443v();
        }
        c1996e.f7088I0 = typedArrayM216f.getDimensionPixelSize(4, Integer.MAX_VALUE);
        typedArrayM216f.recycle();
        AbstractC0054n.m211a(context2, attributeSet, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action);
        AbstractC0054n.m212b(context2, attributeSet, iArr, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action);
        this.f4331r = typedArrayObtainStyledAttributes.getBoolean(32, false);
        this.f4333t = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(20, (float) Math.ceil(TypedValue.applyDimension(1, 48, getContext().getResources().getDisplayMetrics()))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(c1996e);
        c1996e.m546j(AbstractC0313H.m636i(this));
        AbstractC0054n.m211a(context2, attributeSet, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action);
        AbstractC0054n.m212b(context2, attributeSet, iArr, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr, io.getgrass.www.R.attr.chipStyle, io.getgrass.www.R.style.Widget_MaterialComponents_Chip_Action);
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(37);
        typedArrayObtainStyledAttributes2.recycle();
        this.f4335v = new C1994c(this, this);
        m3172e();
        if (!zHasValue) {
            setOutlineProvider(new C1993b(this));
        }
        setChecked(this.f4327n);
        setText(c1996e.f7087I);
        setEllipsize(c1996e.f7084G0);
        m3175h();
        if (!this.f4322i.f7086H0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        m3174g();
        if (this.f4331r) {
            setMinHeight(this.f4333t);
        }
        this.f4332s = AbstractC0308C.m607d(this);
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: w1.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f7067a.f4326m;
                if (onCheckedChangeListener != null) {
                    onCheckedChangeListener.onCheckedChanged(compoundButton, z3);
                }
            }
        });
    }

    private RectF getCloseIconTouchBounds() {
        RectF rectF = this.f4338y;
        rectF.setEmpty();
        if (m3170c() && this.f4325l != null) {
            C1996e c1996e = this.f4322i;
            Rect bounds = c1996e.getBounds();
            rectF.setEmpty();
            if (c1996e.m4437U()) {
                float f3 = c1996e.f7114h0 + c1996e.f7113g0 + c1996e.f7099S + c1996e.f7112f0 + c1996e.f7111e0;
                if (AbstractC0140c.m282a(c1996e) == 0) {
                    float f4 = bounds.right;
                    rectF.right = f4;
                    rectF.left = f4 - f3;
                } else {
                    float f5 = bounds.left;
                    rectF.left = f5;
                    rectF.right = f5 + f3;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i3 = (int) closeIconTouchBounds.left;
        int i4 = (int) closeIconTouchBounds.top;
        int i5 = (int) closeIconTouchBounds.right;
        int i6 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.f4337x;
        rect.set(i3, i4, i5, i6);
        return rect;
    }

    private C0206d getTextAppearance() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7121o0.f196f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z3) {
        if (this.f4329p != z3) {
            this.f4329p = z3;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z3) {
        if (this.f4328o != z3) {
            this.f4328o = z3;
            refreshDrawableState();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3169b(int i3) {
        this.f4333t = i3;
        if (!this.f4331r) {
            InsetDrawable insetDrawable = this.f4323j;
            if (insetDrawable == null) {
                m3173f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.f4323j = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    m3173f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i3 - ((int) this.f4322i.f7077D));
        int iMax2 = Math.max(0, i3 - this.f4322i.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.f4323j;
            if (insetDrawable2 == null) {
                m3173f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.f4323j = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    m3173f();
                    return;
                }
                return;
            }
        }
        int i4 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i5 = iMax > 0 ? iMax / 2 : 0;
        if (this.f4323j != null) {
            Rect rect = new Rect();
            this.f4323j.getPadding(rect);
            if (rect.top == i5 && rect.bottom == i5 && rect.left == i4 && rect.right == i4) {
                m3173f();
                return;
            }
        }
        if (getMinHeight() != i3) {
            setMinHeight(i3);
        }
        if (getMinWidth() != i3) {
            setMinWidth(i3);
        }
        this.f4323j = new InsetDrawable((Drawable) this.f4322i, i4, i5, i4, i5);
        m3173f();
    }

    /* JADX INFO: renamed from: c */
    public final boolean m3170c() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            Object obj = c1996e.f7096P;
            if (obj == null) {
                obj = null;
            } else if (obj instanceof InterfaceC0145h) {
                ((AbstractC0146i) ((InterfaceC0145h) obj)).getClass();
                obj = null;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m3171d() {
        C1996e c1996e = this.f4322i;
        return c1996e != null && c1996e.f7101U;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        int i3;
        if (!this.f4336w) {
            return super.dispatchHoverEvent(motionEvent);
        }
        C1994c c1994c = this.f4335v;
        AccessibilityManager accessibilityManager = c1994c.f1465h;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                float x3 = motionEvent.getX();
                float y2 = motionEvent.getY();
                Chip chip = c1994c.f7069q;
                int i4 = (chip.m3170c() && chip.getCloseIconTouchBounds().contains(x3, y2)) ? 1 : 0;
                int i5 = c1994c.f1470m;
                if (i5 != i4) {
                    c1994c.f1470m = i4;
                    c1994c.m1316q(i4, 128);
                    c1994c.m1316q(i5, 256);
                }
                if (i4 != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action == 10 && (i3 = c1994c.f1470m) != Integer.MIN_VALUE) {
                if (i3 == Integer.MIN_VALUE) {
                    return true;
                }
                c1994c.f1470m = Integer.MIN_VALUE;
                c1994c.m1316q(i3, 256);
                return true;
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.f4336w
            if (r0 != 0) goto L9
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        L9:
            w1.c r0 = r9.f4335v
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 0
            r3 = 1
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r3) goto L9f
            int r1 = r10.getKeyCode()
            r5 = 61
            r6 = 0
            if (r1 == r5) goto L89
            r5 = 66
            if (r1 == r5) goto L58
            switch(r1) {
                case 19: goto L2a;
                case 20: goto L2a;
                case 21: goto L2a;
                case 22: goto L2a;
                case 23: goto L58;
                default: goto L28;
            }
        L28:
            goto L9f
        L2a:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L9f
            r7 = 19
            if (r1 == r7) goto L42
            r7 = 21
            if (r1 == r7) goto L3f
            r7 = 22
            if (r1 == r7) goto L44
            r5 = 130(0x82, float:1.82E-43)
            goto L44
        L3f:
            r5 = 17
            goto L44
        L42:
            r5 = 33
        L44:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r3
            r7 = r2
        L4a:
            if (r2 >= r1) goto L56
            boolean r8 = r0.m1312m(r5, r6)
            if (r8 == 0) goto L56
            int r2 = r2 + 1
            r7 = r3
            goto L4a
        L56:
            r2 = r7
            goto L9f
        L58:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L9f
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L9f
            int r1 = r0.f1469l
            if (r1 == r4) goto L87
            com.google.android.material.chip.Chip r5 = r0.f7069q
            if (r1 != 0) goto L71
            boolean r2 = r5.performClick()
            goto L87
        L71:
            if (r1 != r3) goto L87
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r1 = r5.f4325l
            if (r1 == 0) goto L7e
            r1.onClick(r5)
            r2 = r3
        L7e:
            boolean r1 = r5.f4336w
            if (r1 == 0) goto L87
            w1.c r1 = r5.f4335v
            r1.m1316q(r3, r3)
        L87:
            r2 = r3
            goto L9f
        L89:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L95
            r1 = 2
            boolean r2 = r0.m1312m(r1, r6)
            goto L9f
        L95:
            boolean r1 = r10.hasModifiers(r3)
            if (r1 == 0) goto L9f
            boolean r2 = r0.m1312m(r3, r6)
        L9f:
            if (r2 == 0) goto La6
            int r0 = r0.f1469l
            if (r0 == r4) goto La6
            return r3
        La6:
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // p110k.C1609p, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i3;
        super.drawableStateChanged();
        C1996e c1996e = this.f4322i;
        boolean zM4444w = false;
        if (c1996e != null && C1996e.m4416u(c1996e.f7096P)) {
            C1996e c1996e2 = this.f4322i;
            ?? IsEnabled = isEnabled();
            int i4 = IsEnabled;
            if (this.f4330q) {
                i4 = IsEnabled + 1;
            }
            int i5 = i4;
            if (this.f4329p) {
                i5 = i4 + 1;
            }
            int i6 = i5;
            if (this.f4328o) {
                i6 = i5 + 1;
            }
            int i7 = i6;
            if (isChecked()) {
                i7 = i6 + 1;
            }
            int[] iArr = new int[i7];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (this.f4330q) {
                iArr[i3] = 16842908;
                i3++;
            }
            if (this.f4329p) {
                iArr[i3] = 16843623;
                i3++;
            }
            if (this.f4328o) {
                iArr[i3] = 16842919;
                i3++;
            }
            if (isChecked()) {
                iArr[i3] = 16842913;
            }
            if (!Arrays.equals(c1996e2.f7076C0, iArr)) {
                c1996e2.f7076C0 = iArr;
                if (c1996e2.m4437U()) {
                    zM4444w = c1996e2.m4444w(c1996e2.getState(), iArr);
                }
            }
        }
        if (zM4444w) {
            invalidate();
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m3172e() {
        C1996e c1996e;
        if (!m3170c() || (c1996e = this.f4322i) == null || !c1996e.f7095O || this.f4325l == null) {
            AbstractC0323S.m701k(this, null);
            this.f4336w = false;
        } else {
            AbstractC0323S.m701k(this, this.f4335v);
            this.f4336w = true;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m3173f() {
        ColorStateList colorStateListValueOf = this.f4322i.f7085H;
        if (colorStateListValueOf == null) {
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        this.f4324k = new RippleDrawable(colorStateListValueOf, getBackgroundDrawable(), null);
        C1996e c1996e = this.f4322i;
        if (c1996e.f7078D0) {
            c1996e.f7078D0 = false;
            c1996e.f7080E0 = null;
            c1996e.onStateChange(c1996e.getState());
        }
        RippleDrawable rippleDrawable = this.f4324k;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m601q(this, rippleDrawable);
        m3174g();
    }

    /* JADX INFO: renamed from: g */
    public final void m3174g() {
        C1996e c1996e;
        if (TextUtils.isEmpty(getText()) || (c1996e = this.f4322i) == null) {
            return;
        }
        int iM4441r = (int) (c1996e.m4441r() + c1996e.f7114h0 + c1996e.f7111e0);
        C1996e c1996e2 = this.f4322i;
        int iM4440q = (int) (c1996e2.m4440q() + c1996e2.f7107a0 + c1996e2.f7110d0);
        if (this.f4323j != null) {
            Rect rect = new Rect();
            this.f4323j.getPadding(rect);
            iM4440q += rect.left;
            iM4441r += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0308C.m614k(this, iM4440q, paddingTop, iM4441r, paddingBottom);
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f4334u)) {
            return this.f4334u;
        }
        if (!m3171d()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f4323j;
        return insetDrawable == null ? this.f4322i : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7103W;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7104X;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7075C;
        }
        return null;
    }

    public float getChipCornerRadius() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return Math.max(0.0f, c1996e.m4442s());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f4322i;
    }

    public float getChipEndPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7114h0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        C1996e c1996e = this.f4322i;
        if (c1996e == null || (drawable = c1996e.f7091K) == 0) {
            return null;
        }
        if (!(drawable instanceof InterfaceC0145h)) {
            return drawable;
        }
        ((AbstractC0146i) ((InterfaceC0145h) drawable)).getClass();
        return null;
    }

    public float getChipIconSize() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7093M;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7092L;
        }
        return null;
    }

    public float getChipMinHeight() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7077D;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7107a0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7081F;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7083G;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        C1996e c1996e = this.f4322i;
        if (c1996e == null || (drawable = c1996e.f7096P) == 0) {
            return null;
        }
        if (!(drawable instanceof InterfaceC0145h)) {
            return drawable;
        }
        ((AbstractC0146i) ((InterfaceC0145h) drawable)).getClass();
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7100T;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7113g0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7099S;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7112f0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7098R;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7084G0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.f4336w) {
            C1994c c1994c = this.f4335v;
            if (c1994c.f1469l == 1 || c1994c.f1468k == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public C1825b getHideMotionSpec() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7106Z;
        }
        return null;
    }

    public float getIconEndPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7109c0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7108b0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7085H;
        }
        return null;
    }

    public C0281j getShapeAppearanceModel() {
        return this.f4322i.f719e.f697a;
    }

    public C1825b getShowMotionSpec() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7105Y;
        }
        return null;
    }

    public float getTextEndPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7111e0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            return c1996e.f7110d0;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: h */
    public final void m3175h() {
        TextPaint paint = getPaint();
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            paint.drawableState = c1996e.getState();
        }
        C0206d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.m400e(getContext(), paint, this.f4339z);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC0473V.m998K(this, this.f4322i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f4320B);
        }
        if (m3171d()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f4321C);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z3, int i3, Rect rect) {
        super.onFocusChanged(z3, i3, rect);
        if (this.f4336w) {
            C1994c c1994c = this.f4335v;
            int i4 = c1994c.f1469l;
            if (i4 != Integer.MIN_VALUE) {
                c1994c.m1309j(i4);
            }
            if (z3) {
                c1994c.m1312m(i3, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(m3171d());
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i3) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        if (this.f4332s != i3) {
            this.f4332s = i3;
            m3174g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L4a
            if (r0 == r3) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.f4328o
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r2)
        L2a:
            r0 = r3
            goto L51
        L2c:
            boolean r0 = r5.f4328o
            if (r0 == 0) goto L45
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.f4325l
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.f4336w
            if (r0 == 0) goto L43
            w1.c r0 = r5.f4335v
            r0.m1316q(r3, r3)
        L43:
            r0 = r3
            goto L46
        L45:
            r0 = r2
        L46:
            r5.setCloseIconPressed(r2)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r3)
            goto L2a
        L50:
            r0 = r2
        L51:
            if (r0 != 0) goto L59
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
        L59:
            r2 = r3
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f4334u = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f4324k) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // p110k.C1609p, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f4324k) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // p110k.C1609p, android.view.View
    public void setBackgroundResource(int i3) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4445x(z3);
        }
    }

    public void setCheckableResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4445x(c1996e.f7115i0.getResources().getBoolean(i3));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z3) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null) {
            this.f4327n = z3;
        } else if (c1996e.f7101U) {
            super.setChecked(z3);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4446y(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z3) {
        setCheckedIconVisible(z3);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i3) {
        setCheckedIconVisible(i3);
    }

    public void setCheckedIconResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4446y(AbstractC1800j.m3991i(c1996e.f7115i0, i3));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4447z(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4447z(AbstractC2049e.m4525c(c1996e.f7115i0, i3));
        }
    }

    public void setCheckedIconVisible(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4417A(c1996e.f7115i0.getResources().getBoolean(i3));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7075C == colorStateList) {
            return;
        }
        c1996e.f7075C = colorStateList;
        c1996e.onStateChange(c1996e.getState());
    }

    public void setChipBackgroundColorResource(int i3) {
        ColorStateList colorStateListM4525c;
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7075C == (colorStateListM4525c = AbstractC2049e.m4525c(c1996e.f7115i0, i3))) {
            return;
        }
        c1996e.f7075C = colorStateListM4525c;
        c1996e.onStateChange(c1996e.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4418B(f3);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4418B(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    public void setChipDrawable(C1996e c1996e) {
        C1996e c1996e2 = this.f4322i;
        if (c1996e2 != c1996e) {
            if (c1996e2 != null) {
                c1996e2.f7082F0 = new WeakReference(null);
            }
            this.f4322i = c1996e;
            c1996e.f7086H0 = false;
            c1996e.f7082F0 = new WeakReference(this);
            m3169b(this.f4333t);
        }
    }

    public void setChipEndPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7114h0 == f3) {
            return;
        }
        c1996e.f7114h0 = f3;
        c1996e.invalidateSelf();
        c1996e.m4443v();
    }

    public void setChipEndPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            float dimension = c1996e.f7115i0.getResources().getDimension(i3);
            if (c1996e.f7114h0 != dimension) {
                c1996e.f7114h0 = dimension;
                c1996e.invalidateSelf();
                c1996e.m4443v();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4419C(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z3) {
        setChipIconVisible(z3);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i3) {
        setChipIconVisible(i3);
    }

    public void setChipIconResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4419C(AbstractC1800j.m3991i(c1996e.f7115i0, i3));
        }
    }

    public void setChipIconSize(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4420D(f3);
        }
    }

    public void setChipIconSizeResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4420D(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4421E(colorStateList);
        }
    }

    public void setChipIconTintResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4421E(AbstractC2049e.m4525c(c1996e.f7115i0, i3));
        }
    }

    public void setChipIconVisible(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4422F(c1996e.f7115i0.getResources().getBoolean(i3));
        }
    }

    public void setChipMinHeight(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7077D == f3) {
            return;
        }
        c1996e.f7077D = f3;
        c1996e.invalidateSelf();
        c1996e.m4443v();
    }

    public void setChipMinHeightResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            float dimension = c1996e.f7115i0.getResources().getDimension(i3);
            if (c1996e.f7077D != dimension) {
                c1996e.f7077D = dimension;
                c1996e.invalidateSelf();
                c1996e.m4443v();
            }
        }
    }

    public void setChipStartPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7107a0 == f3) {
            return;
        }
        c1996e.f7107a0 = f3;
        c1996e.invalidateSelf();
        c1996e.m4443v();
    }

    public void setChipStartPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            float dimension = c1996e.f7115i0.getResources().getDimension(i3);
            if (c1996e.f7107a0 != dimension) {
                c1996e.f7107a0 = dimension;
                c1996e.invalidateSelf();
                c1996e.m4443v();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4423G(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4423G(AbstractC2049e.m4525c(c1996e.f7115i0, i3));
        }
    }

    public void setChipStrokeWidth(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4424H(f3);
        }
    }

    public void setChipStrokeWidthResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4424H(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i3) {
        setText(getResources().getString(i3));
    }

    public void setCloseIcon(Drawable drawable) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4425I(drawable);
        }
        m3172e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7100T == charSequence) {
            return;
        }
        String str = C0239b.f587d;
        Locale locale = Locale.getDefault();
        int i3 = AbstractC0246i.f603a;
        C0239b c0239b = AbstractC0245h.m484a(locale) == 1 ? C0239b.f590g : C0239b.f589f;
        C0181e c0181e = c0239b.f593c;
        c1996e.f7100T = c0239b.m479c(charSequence);
        c1996e.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z3) {
        setCloseIconVisible(z3);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i3) {
        setCloseIconVisible(i3);
    }

    public void setCloseIconEndPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4426J(f3);
        }
    }

    public void setCloseIconEndPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4426J(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    public void setCloseIconResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4425I(AbstractC1800j.m3991i(c1996e.f7115i0, i3));
        }
        m3172e();
    }

    public void setCloseIconSize(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4427K(f3);
        }
    }

    public void setCloseIconSizeResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4427K(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    public void setCloseIconStartPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4428L(f3);
        }
    }

    public void setCloseIconStartPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4428L(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4429M(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4429M(AbstractC2049e.m4525c(c1996e.f7115i0, i3));
        }
    }

    public void setCloseIconVisible(int i3) {
        setCloseIconVisible(getResources().getBoolean(i3));
    }

    @Override // p110k.C1609p, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // p110k.C1609p, android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i3, int i4, int i5, int i6) {
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i5 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i3, i4, i5, i6);
    }

    @Override // android.view.View
    public void setElevation(float f3) {
        super.setElevation(f3);
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m546j(f3);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f4322i == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.f7084G0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z3) {
        this.f4331r = z3;
        m3169b(this.f4333t);
    }

    @Override // android.widget.TextView
    public void setGravity(int i3) {
        if (i3 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i3);
        }
    }

    public void setHideMotionSpec(C1825b c1825b) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.f7106Z = c1825b;
        }
    }

    public void setHideMotionSpecResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.f7106Z = C1825b.m4070a(c1996e.f7115i0, i3);
        }
    }

    public void setIconEndPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4431O(f3);
        }
    }

    public void setIconEndPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4431O(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    public void setIconStartPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4432P(f3);
        }
    }

    public void setIconStartPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4432P(c1996e.f7115i0.getResources().getDimension(i3));
        }
    }

    public void setInternalOnCheckedChangeListener(InterfaceC0047g interfaceC0047g) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i3) {
        if (this.f4322i == null) {
            return;
        }
        super.setLayoutDirection(i3);
    }

    @Override // android.widget.TextView
    public void setLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i3);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i3) {
        super.setMaxWidth(i3);
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.f7088I0 = i3;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i3) {
        if (i3 > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i3);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f4326m = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f4325l = onClickListener;
        m3172e();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4433Q(colorStateList);
        }
        if (this.f4322i.f7078D0) {
            return;
        }
        m3173f();
    }

    public void setRippleColorResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4433Q(AbstractC2049e.m4525c(c1996e.f7115i0, i3));
            if (this.f4322i.f7078D0) {
                return;
            }
            m3173f();
        }
    }

    @Override // p025H1.InterfaceC0292u
    public void setShapeAppearanceModel(C0281j c0281j) {
        this.f4322i.setShapeAppearanceModel(c0281j);
    }

    public void setShowMotionSpec(C1825b c1825b) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.f7105Y = c1825b;
        }
    }

    public void setShowMotionSpecResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.f7105Y = C1825b.m4070a(c1996e.f7115i0, i3);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z3) {
        if (!z3) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z3);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(c1996e.f7086H0 ? null : charSequence, bufferType);
        C1996e c1996e2 = this.f4322i;
        if (c1996e2 == null || TextUtils.equals(c1996e2.f7087I, charSequence)) {
            return;
        }
        c1996e2.f7087I = charSequence;
        c1996e2.f7121o0.f194d = true;
        c1996e2.invalidateSelf();
        c1996e2.m4443v();
    }

    public void setTextAppearance(C0206d c0206d) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4434R(c0206d);
        }
        m3175h();
    }

    public void setTextAppearanceResource(int i3) {
        setTextAppearance(getContext(), i3);
    }

    public void setTextEndPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7111e0 == f3) {
            return;
        }
        c1996e.f7111e0 = f3;
        c1996e.invalidateSelf();
        c1996e.m4443v();
    }

    public void setTextEndPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            float dimension = c1996e.f7115i0.getResources().getDimension(i3);
            if (c1996e.f7111e0 != dimension) {
                c1996e.f7111e0 = dimension;
                c1996e.invalidateSelf();
                c1996e.m4443v();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i3, float f3) {
        super.setTextSize(i3, f3);
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            float fApplyDimension = TypedValue.applyDimension(i3, f3, getResources().getDisplayMetrics());
            C0052l c0052l = c1996e.f7121o0;
            C0206d c0206d = c0052l.f196f;
            if (c0206d != null) {
                c0206d.f508k = fApplyDimension;
                c0052l.f191a.setTextSize(fApplyDimension);
                c1996e.m4443v();
                c1996e.invalidateSelf();
            }
        }
        m3175h();
    }

    public void setTextStartPadding(float f3) {
        C1996e c1996e = this.f4322i;
        if (c1996e == null || c1996e.f7110d0 == f3) {
            return;
        }
        c1996e.f7110d0 = f3;
        c1996e.invalidateSelf();
        c1996e.m4443v();
    }

    public void setTextStartPaddingResource(int i3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            float dimension = c1996e.f7115i0.getResources().getDimension(i3);
            if (c1996e.f7110d0 != dimension) {
                c1996e.f7110d0 = dimension;
                c1996e.invalidateSelf();
                c1996e.m4443v();
            }
        }
    }

    public void setCloseIconVisible(boolean z3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4430N(z3);
        }
        m3172e();
    }

    public void setCheckedIconVisible(boolean z3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4417A(z3);
        }
    }

    public void setChipIconVisible(boolean z3) {
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4422F(z3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4434R(new C0206d(c1996e.f7115i0, i3));
        }
        m3175h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i3) {
        super.setTextAppearance(i3);
        C1996e c1996e = this.f4322i;
        if (c1996e != null) {
            c1996e.m4434R(new C0206d(c1996e.f7115i0, i3));
        }
        m3175h();
    }
}

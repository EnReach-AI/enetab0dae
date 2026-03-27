package p073Z;

import android.R;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p007B1.RunnableC0055o;
import p029J.AbstractC0308C;
import p029J.AbstractC0323S;
import p034K1.C0410D;

/* JADX INFO: renamed from: Z.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0800l extends AbstractC0761G {

    /* JADX INFO: renamed from: C */
    public static final int[] f2316C = {R.attr.state_pressed};

    /* JADX INFO: renamed from: D */
    public static final int[] f2317D = new int[0];

    /* JADX INFO: renamed from: A */
    public int f2318A;

    /* JADX INFO: renamed from: B */
    public final RunnableC0055o f2319B;

    /* JADX INFO: renamed from: a */
    public final int f2320a;

    /* JADX INFO: renamed from: b */
    public final int f2321b;

    /* JADX INFO: renamed from: c */
    public final StateListDrawable f2322c;

    /* JADX INFO: renamed from: d */
    public final Drawable f2323d;

    /* JADX INFO: renamed from: e */
    public final int f2324e;

    /* JADX INFO: renamed from: f */
    public final int f2325f;

    /* JADX INFO: renamed from: g */
    public final StateListDrawable f2326g;

    /* JADX INFO: renamed from: h */
    public final Drawable f2327h;

    /* JADX INFO: renamed from: i */
    public final int f2328i;

    /* JADX INFO: renamed from: j */
    public final int f2329j;

    /* JADX INFO: renamed from: k */
    public int f2330k;

    /* JADX INFO: renamed from: l */
    public int f2331l;

    /* JADX INFO: renamed from: m */
    public float f2332m;

    /* JADX INFO: renamed from: n */
    public int f2333n;

    /* JADX INFO: renamed from: o */
    public int f2334o;

    /* JADX INFO: renamed from: p */
    public float f2335p;

    /* JADX INFO: renamed from: s */
    public final RecyclerView f2338s;

    /* JADX INFO: renamed from: z */
    public final ValueAnimator f2345z;

    /* JADX INFO: renamed from: q */
    public int f2336q = 0;

    /* JADX INFO: renamed from: r */
    public int f2337r = 0;

    /* JADX INFO: renamed from: t */
    public boolean f2339t = false;

    /* JADX INFO: renamed from: u */
    public boolean f2340u = false;

    /* JADX INFO: renamed from: v */
    public int f2341v = 0;

    /* JADX INFO: renamed from: w */
    public int f2342w = 0;

    /* JADX INFO: renamed from: x */
    public final int[] f2343x = new int[2];

    /* JADX INFO: renamed from: y */
    public final int[] f2344y = new int[2];

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public C0800l(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i3, int i4, int i5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f2345z = valueAnimatorOfFloat;
        this.f2318A = 0;
        RunnableC0055o runnableC0055o = new RunnableC0055o(5, this);
        this.f2319B = runnableC0055o;
        C0798j c0798j = new C0798j(this);
        this.f2322c = stateListDrawable;
        this.f2323d = drawable;
        this.f2326g = stateListDrawable2;
        this.f2327h = drawable2;
        this.f2324e = Math.max(i3, stateListDrawable.getIntrinsicWidth());
        this.f2325f = Math.max(i3, drawable.getIntrinsicWidth());
        this.f2328i = Math.max(i3, stateListDrawable2.getIntrinsicWidth());
        this.f2329j = Math.max(i3, drawable2.getIntrinsicWidth());
        this.f2320a = i4;
        this.f2321b = i5;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new C0799k(this));
        valueAnimatorOfFloat.addUpdateListener(new C0410D(true ? 1 : 0, this));
        RecyclerView recyclerView2 = this.f2338s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            AbstractC0763I abstractC0763I = recyclerView2.f3434p;
            if (abstractC0763I != null) {
                abstractC0763I.mo1990c("Cannot remove item decoration during a scroll  or layout");
            }
            ArrayList arrayList = recyclerView2.f3436q;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.m2588N();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.f2338s;
            recyclerView3.f3438r.remove(this);
            if (recyclerView3.f3440s == this) {
                recyclerView3.f3440s = null;
            }
            ArrayList arrayList2 = this.f2338s.f3421i0;
            if (arrayList2 != null) {
                arrayList2.remove(c0798j);
            }
            this.f2338s.removeCallbacks(runnableC0055o);
        }
        this.f2338s = recyclerView;
        if (recyclerView != null) {
            recyclerView.m2607g(this);
            this.f2338s.f3438r.add(this);
            this.f2338s.m2608h(c0798j);
        }
    }

    /* JADX INFO: renamed from: e */
    public static int m2092e(float f3, float f4, int[] iArr, int i3, int i4, int i5) {
        int i6 = iArr[1] - iArr[0];
        if (i6 == 0) {
            return 0;
        }
        int i7 = i3 - i5;
        int i8 = (int) (((f4 - f3) / i6) * i7);
        int i9 = i4 + i8;
        if (i9 >= i7 || i9 < 0) {
            return 0;
        }
        return i8;
    }

    @Override // p073Z.AbstractC0761G
    /* JADX INFO: renamed from: b */
    public final void mo1957b(Canvas canvas) {
        int i3 = this.f2336q;
        RecyclerView recyclerView = this.f2338s;
        if (i3 != recyclerView.getWidth() || this.f2337r != recyclerView.getHeight()) {
            this.f2336q = recyclerView.getWidth();
            this.f2337r = recyclerView.getHeight();
            m2095f(0);
            return;
        }
        if (this.f2318A != 0) {
            if (this.f2339t) {
                int i4 = this.f2336q;
                int i5 = this.f2324e;
                int i6 = i4 - i5;
                int i7 = this.f2331l;
                int i8 = this.f2330k;
                int i9 = i7 - (i8 / 2);
                StateListDrawable stateListDrawable = this.f2322c;
                stateListDrawable.setBounds(0, 0, i5, i8);
                int i10 = this.f2337r;
                int i11 = this.f2325f;
                Drawable drawable = this.f2323d;
                drawable.setBounds(0, 0, i11, i10);
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                if (AbstractC0308C.m607d(recyclerView) == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i5, i9);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate(-i5, -i9);
                } else {
                    canvas.translate(i6, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i9);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i6, -i9);
                }
            }
            if (this.f2340u) {
                int i12 = this.f2337r;
                int i13 = this.f2328i;
                int i14 = i12 - i13;
                int i15 = this.f2334o;
                int i16 = this.f2333n;
                int i17 = i15 - (i16 / 2);
                StateListDrawable stateListDrawable2 = this.f2326g;
                stateListDrawable2.setBounds(0, 0, i16, i13);
                int i18 = this.f2336q;
                int i19 = this.f2329j;
                Drawable drawable2 = this.f2327h;
                drawable2.setBounds(0, 0, i18, i19);
                canvas.translate(0.0f, i14);
                drawable2.draw(canvas);
                canvas.translate(i17, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i17, -i14);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m2093c(float f3, float f4) {
        if (f4 >= this.f2337r - this.f2328i) {
            int i3 = this.f2334o;
            int i4 = this.f2333n;
            if (f3 >= i3 - (i4 / 2) && f3 <= (i4 / 2) + i3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m2094d(float f3, float f4) {
        RecyclerView recyclerView = this.f2338s;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        boolean z3 = AbstractC0308C.m607d(recyclerView) == 1;
        int i3 = this.f2324e;
        if (z3) {
            if (f3 > i3 / 2) {
                return false;
            }
        } else if (f3 < this.f2336q - i3) {
            return false;
        }
        int i4 = this.f2331l;
        int i5 = this.f2330k / 2;
        return f4 >= ((float) (i4 - i5)) && f4 <= ((float) (i5 + i4));
    }

    /* JADX INFO: renamed from: f */
    public final void m2095f(int i3) {
        RunnableC0055o runnableC0055o = this.f2319B;
        StateListDrawable stateListDrawable = this.f2322c;
        if (i3 == 2 && this.f2341v != 2) {
            stateListDrawable.setState(f2316C);
            this.f2338s.removeCallbacks(runnableC0055o);
        }
        if (i3 == 0) {
            this.f2338s.invalidate();
        } else {
            m2096g();
        }
        if (this.f2341v == 2 && i3 != 2) {
            stateListDrawable.setState(f2317D);
            this.f2338s.removeCallbacks(runnableC0055o);
            this.f2338s.postDelayed(runnableC0055o, 1200);
        } else if (i3 == 1) {
            this.f2338s.removeCallbacks(runnableC0055o);
            this.f2338s.postDelayed(runnableC0055o, 1500);
        }
        this.f2341v = i3;
    }

    /* JADX INFO: renamed from: g */
    public final void m2096g() {
        int i3 = this.f2318A;
        ValueAnimator valueAnimator = this.f2345z;
        if (i3 != 0) {
            if (i3 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.f2318A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}

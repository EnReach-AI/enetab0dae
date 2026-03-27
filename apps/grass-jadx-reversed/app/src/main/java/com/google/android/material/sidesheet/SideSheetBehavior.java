package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import io.getgrass.www.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p019F0.C0221e;
import p025H1.C0278g;
import p025H1.C0281j;
import p028I1.C0302b;
import p028I1.C0303c;
import p028I1.C0305e;
import p029J.AbstractC0307B;
import p029J.AbstractC0310E;
import p029J.AbstractC0313H;
import p029J.AbstractC0317L;
import p029J.AbstractC0323S;
import p032K.C0390h;
import p032K.InterfaceC0402t;
import p049Q.C0587e;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;
import p155w.AbstractC1979a;
import p155w.C1982d;

/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends AbstractC1979a {

    /* JADX INFO: renamed from: a */
    public final C0221e f4439a;

    /* JADX INFO: renamed from: b */
    public final C0278g f4440b;

    /* JADX INFO: renamed from: c */
    public final ColorStateList f4441c;

    /* JADX INFO: renamed from: d */
    public final C0281j f4442d;

    /* JADX INFO: renamed from: e */
    public final C0305e f4443e;

    /* JADX INFO: renamed from: f */
    public final float f4444f;

    /* JADX INFO: renamed from: g */
    public final boolean f4445g;

    /* JADX INFO: renamed from: h */
    public int f4446h;

    /* JADX INFO: renamed from: i */
    public C0587e f4447i;

    /* JADX INFO: renamed from: j */
    public boolean f4448j;

    /* JADX INFO: renamed from: k */
    public final float f4449k;

    /* JADX INFO: renamed from: l */
    public int f4450l;

    /* JADX INFO: renamed from: m */
    public int f4451m;

    /* JADX INFO: renamed from: n */
    public WeakReference f4452n;

    /* JADX INFO: renamed from: o */
    public WeakReference f4453o;

    /* JADX INFO: renamed from: p */
    public final int f4454p;

    /* JADX INFO: renamed from: q */
    public VelocityTracker f4455q;

    /* JADX INFO: renamed from: r */
    public int f4456r;

    /* JADX INFO: renamed from: s */
    public final LinkedHashSet f4457s;

    /* JADX INFO: renamed from: t */
    public final C0302b f4458t;

    public SideSheetBehavior() {
        this.f4443e = new C0305e(this);
        this.f4445g = true;
        this.f4446h = 5;
        this.f4449k = 0.1f;
        this.f4454p = -1;
        this.f4457s = new LinkedHashSet();
        this.f4458t = new C0302b(this, 0);
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: c */
    public final void mo3148c(C1982d c1982d) {
        this.f4452n = null;
        this.f4447i = null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: e */
    public final void mo3149e() {
        this.f4452n = null;
        this.f4447i = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo3122f(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.MotionEvent r5) {
        /*
            r2 = this;
            boolean r3 = r4.isShown()
            r0 = 1
            r1 = 0
            if (r3 != 0) goto L10
            java.util.WeakHashMap r3 = p029J.AbstractC0323S.f816a
            java.lang.CharSequence r3 = p029J.AbstractC0317L.m674b(r4)
            if (r3 == 0) goto L5a
        L10:
            boolean r3 = r2.f4445g
            if (r3 == 0) goto L5a
            int r3 = r5.getActionMasked()
            if (r3 != 0) goto L24
            android.view.VelocityTracker r4 = r2.f4455q
            if (r4 == 0) goto L24
            r4.recycle()
            r4 = 0
            r2.f4455q = r4
        L24:
            android.view.VelocityTracker r4 = r2.f4455q
            if (r4 != 0) goto L2e
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r2.f4455q = r4
        L2e:
            android.view.VelocityTracker r4 = r2.f4455q
            r4.addMovement(r5)
            if (r3 == 0) goto L42
            if (r3 == r0) goto L3b
            r4 = 3
            if (r3 == r4) goto L3b
            goto L49
        L3b:
            boolean r3 = r2.f4448j
            if (r3 == 0) goto L49
            r2.f4448j = r1
            return r1
        L42:
            float r3 = r5.getX()
            int r3 = (int) r3
            r2.f4456r = r3
        L49:
            boolean r3 = r2.f4448j
            if (r3 != 0) goto L58
            Q.e r3 = r2.f4447i
            if (r3 == 0) goto L58
            boolean r3 = r3.m1332p(r5)
            if (r3 == 0) goto L58
            goto L59
        L58:
            r0 = r1
        L59:
            return r0
        L5a:
            r2.f4448j = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.mo3122f(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public final boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        int i4;
        View viewFindViewById;
        C0278g c0278g = this.f4440b;
        C0221e c0221e = this.f4439a;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0307B.m586b(coordinatorLayout) && !AbstractC0307B.m586b(view)) {
            view.setFitsSystemWindows(true);
        }
        int left = 0;
        if (this.f4452n == null) {
            this.f4452n = new WeakReference(view);
            if (c0278g != null) {
                AbstractC0307B.m601q(view, c0278g);
                float fM636i = this.f4444f;
                if (fM636i == -1.0f) {
                    fM636i = AbstractC0313H.m636i(view);
                }
                c0278g.m546j(fM636i);
            } else {
                ColorStateList colorStateList = this.f4441c;
                if (colorStateList != null) {
                    AbstractC0313H.m644q(view, colorStateList);
                }
            }
            int i5 = this.f4446h == 5 ? 4 : 0;
            if (view.getVisibility() != i5) {
                view.setVisibility(i5);
            }
            m3196u();
            if (AbstractC0307B.m587c(view) == 0) {
                AbstractC0307B.m603s(view, 1);
            }
            if (AbstractC0317L.m674b(view) == null) {
                AbstractC0323S.m702l(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        if (this.f4447i == null) {
            this.f4447i = new C0587e(coordinatorLayout.getContext(), coordinatorLayout, this.f4458t);
        }
        c0221e.getClass();
        int left2 = view.getLeft();
        coordinatorLayout.m2309q(view, i3);
        this.f4451m = coordinatorLayout.getWidth();
        this.f4450l = view.getWidth();
        int i6 = this.f4446h;
        if (i6 == 1 || i6 == 2) {
            c0221e.getClass();
            left = left2 - view.getLeft();
        } else if (i6 != 3) {
            if (i6 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f4446h);
            }
            left = ((SideSheetBehavior) c0221e.f534f).f4451m;
        }
        view.offsetLeftAndRight(left);
        if (this.f4453o == null && (i4 = this.f4454p) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i4)) != null) {
            this.f4453o = new WeakReference(viewFindViewById);
        }
        Iterator it = this.f4457s.iterator();
        while (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
        }
        return true;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: h */
    public final boolean mo3124h(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i3, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i5, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: m */
    public final void mo3127m(View view, Parcelable parcelable) {
        int i3 = ((C0303c) parcelable).f804g;
        if (i3 == 1 || i3 == 2) {
            i3 = 5;
        }
        this.f4446h = i3;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: n */
    public final Parcelable mo3128n(View view) {
        return new C0303c(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: q */
    public final boolean mo3131q(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f4446h == 1 && actionMasked == 0) {
            return true;
        }
        if (m3194s()) {
            this.f4447i.m1326j(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.f4455q) != null) {
            velocityTracker.recycle();
            this.f4455q = null;
        }
        if (this.f4455q == null) {
            this.f4455q = VelocityTracker.obtain();
        }
        this.f4455q.addMovement(motionEvent);
        if (m3194s() && actionMasked == 2 && !this.f4448j && m3194s()) {
            float fAbs = Math.abs(this.f4456r - motionEvent.getX());
            C0587e c0587e = this.f4447i;
            if (fAbs > c0587e.f1478b) {
                c0587e.m1318b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f4448j;
    }

    /* JADX INFO: renamed from: r */
    public final void m3193r(int i3) {
        View view;
        if (this.f4446h == i3) {
            return;
        }
        this.f4446h = i3;
        WeakReference weakReference = this.f4452n;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i4 = this.f4446h == 5 ? 4 : 0;
        if (view.getVisibility() != i4) {
            view.setVisibility(i4);
        }
        Iterator it = this.f4457s.iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            throw null;
        }
        m3196u();
    }

    /* JADX INFO: renamed from: s */
    public final boolean m3194s() {
        return this.f4447i != null && (this.f4445g || this.f4446h == 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r0.m1331o(r1, r3.getTop()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        m3193r(2);
        r2.f4443e.m583a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3195t(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            F0.e r0 = r2.f4439a
            java.lang.Object r0 = r0.f534f
            com.google.android.material.sidesheet.SideSheetBehavior r0 = (com.google.android.material.sidesheet.SideSheetBehavior) r0
            r1 = 3
            if (r4 == r1) goto L2c
            r1 = 5
            if (r4 != r1) goto L15
            F0.e r1 = r0.f4439a
            java.lang.Object r1 = r1.f534f
            com.google.android.material.sidesheet.SideSheetBehavior r1 = (com.google.android.material.sidesheet.SideSheetBehavior) r1
            int r1 = r1.f4451m
            goto L32
        L15:
            r0.getClass()
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid state to get outward edge offset: "
            r5.<init>(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.<init>(r4)
            throw r3
        L2c:
            F0.e r1 = r0.f4439a
            int r1 = r1.m458v()
        L32:
            Q.e r0 = r0.f4447i
            if (r0 == 0) goto L6a
            if (r5 == 0) goto L43
            int r3 = r3.getTop()
            boolean r3 = r0.m1331o(r1, r3)
            if (r3 == 0) goto L6a
            goto L60
        L43:
            int r5 = r3.getTop()
            r0.f1494r = r3
            r3 = -1
            r0.f1479c = r3
            r3 = 0
            boolean r3 = r0.m1324h(r1, r5, r3, r3)
            if (r3 != 0) goto L5e
            int r5 = r0.f1477a
            if (r5 != 0) goto L5e
            android.view.View r5 = r0.f1494r
            if (r5 == 0) goto L5e
            r5 = 0
            r0.f1494r = r5
        L5e:
            if (r3 == 0) goto L6a
        L60:
            r3 = 2
            r2.m3193r(r3)
            I1.e r3 = r2.f4443e
            r3.m583a(r4)
            goto L6d
        L6a:
            r2.m3193r(r4)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.m3195t(android.view.View, int, boolean):void");
    }

    /* JADX INFO: renamed from: u */
    public final void m3196u() {
        View view;
        WeakReference weakReference = this.f4452n;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        AbstractC0323S.m698h(view, 262144);
        AbstractC0323S.m696f(view, 0);
        AbstractC0323S.m698h(view, 1048576);
        AbstractC0323S.m696f(view, 0);
        final int i3 = 5;
        if (this.f4446h != 5) {
            AbstractC0323S.m699i(view, C0390h.f913j, new InterfaceC0402t() { // from class: I1.a
                /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
                @Override // p032K.InterfaceC0402t
                /* JADX INFO: renamed from: e */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final boolean mo338e(android.view.View r5) {
                    /*
                        r4 = this;
                        r5 = 1
                        com.google.android.material.sidesheet.SideSheetBehavior r0 = r4.f800e
                        r0.getClass()
                        int r1 = r2
                        if (r1 == r5) goto L46
                        r2 = 2
                        if (r1 != r2) goto Le
                        goto L46
                    Le:
                        java.lang.ref.WeakReference r2 = r0.f4452n
                        if (r2 == 0) goto L42
                        java.lang.Object r2 = r2.get()
                        if (r2 != 0) goto L19
                        goto L42
                    L19:
                        java.lang.ref.WeakReference r2 = r0.f4452n
                        java.lang.Object r2 = r2.get()
                        android.view.View r2 = (android.view.View) r2
                        A.p r3 = new A.p
                        r3.<init>(r0, r1, r5)
                        android.view.ViewParent r0 = r2.getParent()
                        if (r0 == 0) goto L3e
                        boolean r0 = r0.isLayoutRequested()
                        if (r0 == 0) goto L3e
                        java.util.WeakHashMap r0 = p029J.AbstractC0323S.f816a
                        boolean r0 = p029J.AbstractC0310E.m619b(r2)
                        if (r0 == 0) goto L3e
                        r2.post(r3)
                        goto L45
                    L3e:
                        r3.run()
                        goto L45
                    L42:
                        r0.m3193r(r1)
                    L45:
                        return r5
                    L46:
                        java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "STATE_"
                        r2.<init>(r3)
                        if (r1 != r5) goto L54
                        java.lang.String r5 = "DRAGGING"
                        goto L56
                    L54:
                        java.lang.String r5 = "SETTLING"
                    L56:
                        java.lang.String r1 = " should not be set externally."
                        java.lang.String r5 = p005B.AbstractC0032g.m157o(r2, r5, r1)
                        r0.<init>(r5)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: p028I1.C0301a.mo338e(android.view.View):boolean");
                }
            });
        }
        final int i4 = 3;
        if (this.f4446h != 3) {
            AbstractC0323S.m699i(view, C0390h.f911h, new InterfaceC0402t() { // from class: I1.a
                @Override // p032K.InterfaceC0402t
                /* JADX INFO: renamed from: e */
                public final boolean mo338e(View v3) {
                    /*
                        this = this;
                        r5 = 1
                        com.google.android.material.sidesheet.SideSheetBehavior r0 = r4.f800e
                        r0.getClass()
                        int r1 = r2
                        if (r1 == r5) goto L46
                        r2 = 2
                        if (r1 != r2) goto Le
                        goto L46
                    Le:
                        java.lang.ref.WeakReference r2 = r0.f4452n
                        if (r2 == 0) goto L42
                        java.lang.Object r2 = r2.get()
                        if (r2 != 0) goto L19
                        goto L42
                    L19:
                        java.lang.ref.WeakReference r2 = r0.f4452n
                        java.lang.Object r2 = r2.get()
                        android.view.View r2 = (android.view.View) r2
                        A.p r3 = new A.p
                        r3.<init>(r0, r1, r5)
                        android.view.ViewParent r0 = r2.getParent()
                        if (r0 == 0) goto L3e
                        boolean r0 = r0.isLayoutRequested()
                        if (r0 == 0) goto L3e
                        java.util.WeakHashMap r0 = p029J.AbstractC0323S.f816a
                        boolean r0 = p029J.AbstractC0310E.m619b(r2)
                        if (r0 == 0) goto L3e
                        r2.post(r3)
                        goto L45
                    L3e:
                        r3.run()
                        goto L45
                    L42:
                        r0.m3193r(r1)
                    L45:
                        return r5
                    L46:
                        java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder
                        java.lang.String r3 = "STATE_"
                        r2.<init>(r3)
                        if (r1 != r5) goto L54
                        java.lang.String r5 = "DRAGGING"
                        goto L56
                    L54:
                        java.lang.String r5 = "SETTLING"
                    L56:
                        java.lang.String r1 = " should not be set externally."
                        java.lang.String r5 = p005B.AbstractC0032g.m157o(r2, r5, r1)
                        r0.<init>(r5)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: p028I1.C0301a.mo338e(android.view.View):boolean");
                }
            });
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        int i3 = 4;
        this.f4443e = new C0305e(this);
        this.f4445g = true;
        this.f4446h = 5;
        this.f4449k = 0.1f;
        this.f4454p = -1;
        this.f4457s = new LinkedHashSet();
        this.f4458t = new C0302b(this, 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6246v);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f4441c = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.f4442d = C0281j.m552b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).m4266a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.f4454p = resourceId;
            WeakReference weakReference = this.f4453o;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f4453o = null;
            WeakReference weakReference2 = this.f4452n;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    if (AbstractC0310E.m620c(view)) {
                        view.requestLayout();
                    }
                }
            }
        }
        C0281j c0281j = this.f4442d;
        if (c0281j != null) {
            C0278g c0278g = new C0278g(c0281j);
            this.f4440b = c0278g;
            c0278g.m545i(context);
            ColorStateList colorStateList = this.f4441c;
            if (colorStateList != null) {
                this.f4440b.m547k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f4440b.setTint(typedValue.data);
            }
        }
        this.f4444f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.f4445g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        if (this.f4439a == null) {
            this.f4439a = new C0221e(i3, this);
        }
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}

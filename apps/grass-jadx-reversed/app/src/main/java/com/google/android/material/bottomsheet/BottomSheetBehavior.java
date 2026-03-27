package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.activity.RunnableC0869d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import io.getgrass.www.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p007B1.C0057q;
import p007B1.ViewOnAttachStateChangeListenerC0056p;
import p015D2.C0181e;
import p015D2.C0192p;
import p025H1.C0277f;
import p025H1.C0278g;
import p025H1.C0281j;
import p028I1.C0302b;
import p028I1.C0305e;
import p029J.AbstractC0307B;
import p029J.AbstractC0308C;
import p029J.AbstractC0310E;
import p029J.AbstractC0311F;
import p029J.AbstractC0313H;
import p029J.AbstractC0323S;
import p029J.C0331a;
import p029J.C0335c;
import p032K.C0390h;
import p034K1.C0410D;
import p049Q.C0587e;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1920f;
import p145t1.C1921a;
import p155w.AbstractC1979a;
import p155w.C1982d;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends AbstractC1979a {

    /* JADX INFO: renamed from: A */
    public final C0305e f4237A;

    /* JADX INFO: renamed from: B */
    public final ValueAnimator f4238B;

    /* JADX INFO: renamed from: C */
    public final int f4239C;

    /* JADX INFO: renamed from: D */
    public int f4240D;

    /* JADX INFO: renamed from: E */
    public int f4241E;

    /* JADX INFO: renamed from: F */
    public final float f4242F;

    /* JADX INFO: renamed from: G */
    public int f4243G;

    /* JADX INFO: renamed from: H */
    public final float f4244H;

    /* JADX INFO: renamed from: I */
    public boolean f4245I;

    /* JADX INFO: renamed from: J */
    public boolean f4246J;

    /* JADX INFO: renamed from: K */
    public final boolean f4247K;

    /* JADX INFO: renamed from: L */
    public int f4248L;

    /* JADX INFO: renamed from: M */
    public C0587e f4249M;

    /* JADX INFO: renamed from: N */
    public boolean f4250N;

    /* JADX INFO: renamed from: O */
    public int f4251O;

    /* JADX INFO: renamed from: P */
    public boolean f4252P;

    /* JADX INFO: renamed from: Q */
    public final float f4253Q;

    /* JADX INFO: renamed from: R */
    public int f4254R;

    /* JADX INFO: renamed from: S */
    public int f4255S;

    /* JADX INFO: renamed from: T */
    public int f4256T;

    /* JADX INFO: renamed from: U */
    public WeakReference f4257U;

    /* JADX INFO: renamed from: V */
    public WeakReference f4258V;

    /* JADX INFO: renamed from: W */
    public final ArrayList f4259W;

    /* JADX INFO: renamed from: X */
    public VelocityTracker f4260X;

    /* JADX INFO: renamed from: Y */
    public int f4261Y;

    /* JADX INFO: renamed from: Z */
    public int f4262Z;

    /* JADX INFO: renamed from: a */
    public final int f4263a;

    /* JADX INFO: renamed from: a0 */
    public boolean f4264a0;

    /* JADX INFO: renamed from: b */
    public boolean f4265b;

    /* JADX INFO: renamed from: b0 */
    public HashMap f4266b0;

    /* JADX INFO: renamed from: c */
    public final float f4267c;

    /* JADX INFO: renamed from: c0 */
    public final SparseIntArray f4268c0;

    /* JADX INFO: renamed from: d */
    public final int f4269d;

    /* JADX INFO: renamed from: d0 */
    public final C0302b f4270d0;

    /* JADX INFO: renamed from: e */
    public int f4271e;

    /* JADX INFO: renamed from: f */
    public boolean f4272f;

    /* JADX INFO: renamed from: g */
    public int f4273g;

    /* JADX INFO: renamed from: h */
    public final int f4274h;

    /* JADX INFO: renamed from: i */
    public final C0278g f4275i;

    /* JADX INFO: renamed from: j */
    public final ColorStateList f4276j;

    /* JADX INFO: renamed from: k */
    public final int f4277k;

    /* JADX INFO: renamed from: l */
    public final int f4278l;

    /* JADX INFO: renamed from: m */
    public int f4279m;

    /* JADX INFO: renamed from: n */
    public final boolean f4280n;

    /* JADX INFO: renamed from: o */
    public final boolean f4281o;

    /* JADX INFO: renamed from: p */
    public final boolean f4282p;

    /* JADX INFO: renamed from: q */
    public final boolean f4283q;

    /* JADX INFO: renamed from: r */
    public final boolean f4284r;

    /* JADX INFO: renamed from: s */
    public final boolean f4285s;

    /* JADX INFO: renamed from: t */
    public final boolean f4286t;

    /* JADX INFO: renamed from: u */
    public final boolean f4287u;

    /* JADX INFO: renamed from: v */
    public int f4288v;

    /* JADX INFO: renamed from: w */
    public int f4289w;

    /* JADX INFO: renamed from: x */
    public final boolean f4290x;

    /* JADX INFO: renamed from: y */
    public final C0281j f4291y;

    /* JADX INFO: renamed from: z */
    public boolean f4292z;

    public BottomSheetBehavior() {
        this.f4263a = 0;
        this.f4265b = true;
        this.f4277k = -1;
        this.f4278l = -1;
        this.f4237A = new C0305e(this);
        this.f4242F = 0.5f;
        this.f4244H = -1.0f;
        this.f4247K = true;
        this.f4248L = 4;
        this.f4253Q = 0.1f;
        this.f4259W = new ArrayList();
        this.f4268c0 = new SparseIntArray();
        this.f4270d0 = new C0302b(this, 1);
    }

    /* JADX INFO: renamed from: u */
    public static View m3139u(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0313H.m643p(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View viewM3139u = m3139u(viewGroup.getChildAt(i3));
                if (viewM3139u != null) {
                    return viewM3139u;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: v */
    public static int m3140v(int i3, int i4, int i5, int i6) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, i4, i6);
        if (i5 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i5), 1073741824);
        }
        if (size != 0) {
            i5 = Math.min(size, i5);
        }
        return View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: A */
    public final void m3141A(int i3) {
        if (this.f4248L == i3) {
            return;
        }
        this.f4248L = i3;
        if (i3 != 4 && i3 != 3 && i3 != 6) {
            boolean z3 = this.f4245I;
        }
        WeakReference weakReference = this.f4257U;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i3 == 3) {
            m3146F(true);
        } else if (i3 == 6 || i3 == 5 || i3 == 4) {
            m3146F(false);
        }
        m3145E(i3, true);
        ArrayList arrayList = this.f4259W;
        if (arrayList.size() <= 0) {
            m3144D();
        } else {
            AbstractC0032g.m162t(arrayList.get(0));
            throw null;
        }
    }

    /* JADX INFO: renamed from: B */
    public final boolean m3142B(View view, float f3) {
        if (this.f4246J) {
            return true;
        }
        if (view.getTop() < this.f4243G) {
            return false;
        }
        return Math.abs(((f3 * this.f4253Q) + ((float) view.getTop())) - ((float) this.f4243G)) / ((float) m3152s()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        m3141A(2);
        m3145E(r4, true);
        r2.f4237A.m583a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r1.m1331o(r3.getLeft(), r0) != false) goto L16;
     */
    /* JADX INFO: renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m3143C(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            int r0 = r2.m3155x(r4)
            Q.e r1 = r2.f4249M
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.m1331o(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.f1494r = r3
            r3 = -1
            r1.f1479c = r3
            r3 = 0
            boolean r3 = r1.m1324h(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.f1477a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.f1494r
            if (r5 == 0) goto L30
            r5 = 0
            r1.f1494r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.m3141A(r3)
            r3 = 1
            r2.m3145E(r4, r3)
            I1.e r3 = r2.f4237A
            r3.m583a(r4)
            goto L43
        L40:
            r2.m3141A(r4)
        L43:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.m3143C(android.view.View, int, boolean):void");
    }

    /* JADX INFO: renamed from: D */
    public final void m3144D() {
        View view;
        int iM867a;
        WeakReference weakReference = this.f4257U;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        AbstractC0323S.m698h(view, 524288);
        AbstractC0323S.m696f(view, 0);
        AbstractC0323S.m698h(view, 262144);
        AbstractC0323S.m696f(view, 0);
        AbstractC0323S.m698h(view, 1048576);
        AbstractC0323S.m696f(view, 0);
        SparseIntArray sparseIntArray = this.f4268c0;
        int i3 = sparseIntArray.get(0, -1);
        if (i3 != -1) {
            AbstractC0323S.m698h(view, i3);
            AbstractC0323S.m696f(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.f4265b && this.f4248L != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            C0192p c0192p = new C0192p(this, 6);
            ArrayList arrayListM694d = AbstractC0323S.m694d(view);
            int i4 = 0;
            while (true) {
                if (i4 >= arrayListM694d.size()) {
                    int i5 = 0;
                    int i6 = -1;
                    while (true) {
                        int[] iArr = AbstractC0323S.f819d;
                        if (i5 >= iArr.length || i6 != -1) {
                            break;
                        }
                        int i7 = iArr[i5];
                        boolean z3 = true;
                        for (int i8 = 0; i8 < arrayListM694d.size(); i8++) {
                            z3 &= ((C0390h) arrayListM694d.get(i8)).m867a() != i7;
                        }
                        if (z3) {
                            i6 = i7;
                        }
                        i5++;
                    }
                    iM867a = i6;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((C0390h) arrayListM694d.get(i4)).f916a).getLabel())) {
                        iM867a = ((C0390h) arrayListM694d.get(i4)).m867a();
                        break;
                    }
                    i4++;
                }
            }
            if (iM867a != -1) {
                C0390h c0390h = new C0390h(null, iM867a, string, c0192p, null);
                View.AccessibilityDelegate accessibilityDelegateM692b = AbstractC0323S.m692b(view);
                C0335c c0335c = accessibilityDelegateM692b == null ? null : accessibilityDelegateM692b instanceof C0331a ? ((C0331a) accessibilityDelegateM692b).f828a : new C0335c(accessibilityDelegateM692b);
                if (c0335c == null) {
                    c0335c = new C0335c();
                }
                AbstractC0323S.m701k(view, c0335c);
                AbstractC0323S.m698h(view, c0390h.m867a());
                AbstractC0323S.m694d(view).add(c0390h);
                AbstractC0323S.m696f(view, 0);
            }
            sparseIntArray.put(0, iM867a);
        }
        if (this.f4245I && this.f4248L != 5) {
            AbstractC0323S.m699i(view, C0390h.f913j, new C0192p(this, 5));
        }
        int i9 = this.f4248L;
        if (i9 == 3) {
            AbstractC0323S.m699i(view, C0390h.f912i, new C0192p(this, this.f4265b ? 4 : 6));
            return;
        }
        if (i9 == 4) {
            AbstractC0323S.m699i(view, C0390h.f911h, new C0192p(this, this.f4265b ? 3 : 6));
        } else {
            if (i9 != 6) {
                return;
            }
            AbstractC0323S.m699i(view, C0390h.f912i, new C0192p(this, 4));
            AbstractC0323S.m699i(view, C0390h.f911h, new C0192p(this, 3));
        }
    }

    /* JADX INFO: renamed from: E */
    public final void m3145E(int i3, boolean z3) {
        float f3;
        C0278g c0278g = this.f4275i;
        ValueAnimator valueAnimator = this.f4238B;
        if (i3 == 2) {
            return;
        }
        boolean z4 = this.f4248L == 3 && (this.f4290x || m3154w() == 0);
        if (this.f4292z == z4 || c0278g == null) {
            return;
        }
        this.f4292z = z4;
        if (z3 && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            }
            f3 = z4 ? 0.0f : 1.0f;
            valueAnimator.setFloatValues(1.0f - f3, f3);
            valueAnimator.start();
            return;
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        f3 = this.f4292z ? 0.0f : 1.0f;
        C0277f c0277f = c0278g.f719e;
        if (c0277f.f706j != f3) {
            c0277f.f706j = f3;
            c0278g.f723i = true;
            c0278g.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: F */
    public final void m3146F(boolean z3) {
        WeakReference weakReference = this.f4257U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z3) {
                if (this.f4266b0 != null) {
                    return;
                } else {
                    this.f4266b0 = new HashMap(childCount);
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (childAt != this.f4257U.get() && z3) {
                    this.f4266b0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z3) {
                return;
            }
            this.f4266b0 = null;
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m3147G() {
        View view;
        if (this.f4257U != null) {
            m3151r();
            if (this.f4248L != 4 || (view = (View) this.f4257U.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: c */
    public final void mo3148c(C1982d c1982d) {
        this.f4257U = null;
        this.f4249M = null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: e */
    public final void mo3149e() {
        this.f4257U = null;
        this.f4249M = null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: f */
    public final boolean mo3122f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C0587e c0587e;
        if (!view.isShown() || !this.f4247K) {
            this.f4250N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f4261Y = -1;
            VelocityTracker velocityTracker = this.f4260X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4260X = null;
            }
        }
        if (this.f4260X == null) {
            this.f4260X = VelocityTracker.obtain();
        }
        this.f4260X.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x3 = (int) motionEvent.getX();
            this.f4262Z = (int) motionEvent.getY();
            if (this.f4248L != 2) {
                WeakReference weakReference = this.f4258V;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.m2307o(view2, x3, this.f4262Z)) {
                    this.f4261Y = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.f4264a0 = true;
                }
            }
            this.f4250N = this.f4261Y == -1 && !coordinatorLayout.m2307o(view, x3, this.f4262Z);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4264a0 = false;
            this.f4261Y = -1;
            if (this.f4250N) {
                this.f4250N = false;
                return false;
            }
        }
        if (!this.f4250N && (c0587e = this.f4249M) != null && c0587e.m1332p(motionEvent)) {
            return true;
        }
        WeakReference weakReference2 = this.f4258V;
        View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
        return (actionMasked != 2 || view3 == null || this.f4250N || this.f4248L == 1 || coordinatorLayout.m2307o(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.f4249M == null || Math.abs(((float) this.f4262Z) - motionEvent.getY()) <= ((float) this.f4249M.f1478b)) ? false : true;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public final boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        C0278g c0278g = this.f4275i;
        int i4 = 1;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0307B.m586b(coordinatorLayout) && !AbstractC0307B.m586b(view)) {
            view.setFitsSystemWindows(true);
        }
        if (this.f4257U == null) {
            this.f4273g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            boolean z3 = (Build.VERSION.SDK_INT < 29 || this.f4280n || this.f4272f) ? false : true;
            if (this.f4281o || this.f4282p || this.f4283q || this.f4285s || this.f4286t || this.f4287u || z3) {
                C0181e c0181e = new C0181e(this, z3, 4);
                int iM609f = AbstractC0308C.m609f(view);
                view.getPaddingTop();
                int iM608e = AbstractC0308C.m608e(view);
                int paddingBottom = view.getPaddingBottom();
                C0057q c0057q = new C0057q();
                c0057q.f202a = iM609f;
                c0057q.f203b = iM608e;
                c0057q.f204c = paddingBottom;
                AbstractC0313H.m648u(view, new C0009j(c0181e, i4, c0057q));
                if (AbstractC0310E.m619b(view)) {
                    AbstractC0311F.m627c(view);
                } else {
                    view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0056p());
                }
            }
            this.f4257U = new WeakReference(view);
            if (c0278g != null) {
                AbstractC0307B.m601q(view, c0278g);
                float fM636i = this.f4244H;
                if (fM636i == -1.0f) {
                    fM636i = AbstractC0313H.m636i(view);
                }
                c0278g.m546j(fM636i);
            } else {
                ColorStateList colorStateList = this.f4276j;
                if (colorStateList != null) {
                    AbstractC0313H.m644q(view, colorStateList);
                }
            }
            m3144D();
            if (AbstractC0307B.m587c(view) == 0) {
                AbstractC0307B.m603s(view, 1);
            }
        }
        if (this.f4249M == null) {
            this.f4249M = new C0587e(coordinatorLayout.getContext(), coordinatorLayout, this.f4270d0);
        }
        int top = view.getTop();
        coordinatorLayout.m2309q(view, i3);
        this.f4255S = coordinatorLayout.getWidth();
        this.f4256T = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.f4254R = height;
        int i5 = this.f4256T;
        int i6 = i5 - height;
        int i7 = this.f4289w;
        if (i6 < i7) {
            if (this.f4284r) {
                this.f4254R = i5;
            } else {
                this.f4254R = i5 - i7;
            }
        }
        this.f4240D = Math.max(0, i5 - this.f4254R);
        this.f4241E = (int) ((1.0f - this.f4242F) * this.f4256T);
        m3151r();
        int i8 = this.f4248L;
        if (i8 == 3) {
            view.offsetTopAndBottom(m3154w());
        } else if (i8 == 6) {
            view.offsetTopAndBottom(this.f4241E);
        } else if (this.f4245I && i8 == 5) {
            view.offsetTopAndBottom(this.f4256T);
        } else if (i8 == 4) {
            view.offsetTopAndBottom(this.f4243G);
        } else if (i8 == 1 || i8 == 2) {
            view.offsetTopAndBottom(top - view.getTop());
        }
        m3145E(this.f4248L, false);
        this.f4258V = new WeakReference(m3139u(view));
        ArrayList arrayList = this.f4259W;
        if (arrayList.size() <= 0) {
            return true;
        }
        AbstractC0032g.m162t(arrayList.get(0));
        throw null;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: h */
    public final boolean mo3124h(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(m3140v(i3, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i4, this.f4277k, marginLayoutParams.width), m3140v(i5, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f4278l, marginLayoutParams.height));
        return true;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: i */
    public final boolean mo3150i(View view) {
        WeakReference weakReference = this.f4258V;
        return (weakReference == null || view != weakReference.get() || this.f4248L == 3) ? false : true;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: j */
    public final void mo3125j(CoordinatorLayout coordinatorLayout, View view, View view2, int i3, int i4, int[] iArr, int i5) {
        boolean z3 = this.f4247K;
        if (i5 == 1) {
            return;
        }
        WeakReference weakReference = this.f4258V;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i6 = top - i4;
        if (i4 > 0) {
            if (i6 < m3154w()) {
                int iM3154w = top - m3154w();
                iArr[1] = iM3154w;
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                view.offsetTopAndBottom(-iM3154w);
                m3141A(3);
            } else {
                if (!z3) {
                    return;
                }
                iArr[1] = i4;
                WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                view.offsetTopAndBottom(-i4);
                m3141A(1);
            }
        } else if (i4 < 0 && !view2.canScrollVertically(-1)) {
            int i7 = this.f4243G;
            if (i6 > i7 && !this.f4245I) {
                int i8 = top - i7;
                iArr[1] = i8;
                WeakHashMap weakHashMap3 = AbstractC0323S.f816a;
                view.offsetTopAndBottom(-i8);
                m3141A(4);
            } else {
                if (!z3) {
                    return;
                }
                iArr[1] = i4;
                WeakHashMap weakHashMap4 = AbstractC0323S.f816a;
                view.offsetTopAndBottom(-i4);
                m3141A(1);
            }
        }
        m3153t(view.getTop());
        this.f4251O = i4;
        this.f4252P = true;
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: k */
    public final void mo3126k(CoordinatorLayout coordinatorLayout, View view, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: m */
    public final void mo3127m(View view, Parcelable parcelable) {
        C1921a c1921a = (C1921a) parcelable;
        int i3 = this.f4263a;
        if (i3 != 0) {
            if (i3 == -1 || (i3 & 1) == 1) {
                this.f4271e = c1921a.f6724h;
            }
            if (i3 == -1 || (i3 & 2) == 2) {
                this.f4265b = c1921a.f6725i;
            }
            if (i3 == -1 || (i3 & 4) == 4) {
                this.f4245I = c1921a.f6726j;
            }
            if (i3 == -1 || (i3 & 8) == 8) {
                this.f4246J = c1921a.f6727k;
            }
        }
        int i4 = c1921a.f6723g;
        if (i4 == 1 || i4 == 2) {
            this.f4248L = 4;
        } else {
            this.f4248L = i4;
        }
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: n */
    public final Parcelable mo3128n(View view) {
        return new C1921a(View.BaseSavedState.EMPTY_STATE, this);
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: o */
    public final boolean mo3129o(View view, int i3, int i4) {
        this.f4251O = 0;
        this.f4252P = false;
        return (i3 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo3130p(android.view.View r4, android.view.View r5, int r6) {
        /*
            r3 = this;
            int r6 = r4.getTop()
            int r0 = r3.m3154w()
            r1 = 3
            if (r6 != r0) goto Lf
            r3.m3141A(r1)
            return
        Lf:
            java.lang.ref.WeakReference r6 = r3.f4258V
            if (r6 == 0) goto Lb5
            java.lang.Object r6 = r6.get()
            if (r5 != r6) goto Lb5
            boolean r5 = r3.f4252P
            if (r5 != 0) goto L1f
            goto Lb5
        L1f:
            int r5 = r3.f4251O
            r6 = 6
            if (r5 <= 0) goto L34
            boolean r5 = r3.f4265b
            if (r5 == 0) goto L2a
            goto Laf
        L2a:
            int r5 = r4.getTop()
            int r0 = r3.f4241E
            if (r5 <= r0) goto Laf
            goto Lae
        L34:
            boolean r5 = r3.f4245I
            if (r5 == 0) goto L55
            android.view.VelocityTracker r5 = r3.f4260X
            if (r5 != 0) goto L3e
            r5 = 0
            goto L4d
        L3e:
            r0 = 1000(0x3e8, float:1.401E-42)
            float r2 = r3.f4267c
            r5.computeCurrentVelocity(r0, r2)
            android.view.VelocityTracker r5 = r3.f4260X
            int r0 = r3.f4261Y
            float r5 = r5.getYVelocity(r0)
        L4d:
            boolean r5 = r3.m3142B(r4, r5)
            if (r5 == 0) goto L55
            r1 = 5
            goto Laf
        L55:
            int r5 = r3.f4251O
            r0 = 4
            if (r5 != 0) goto L93
            int r5 = r4.getTop()
            boolean r2 = r3.f4265b
            if (r2 == 0) goto L74
            int r6 = r3.f4240D
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r2 = r3.f4243G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r6 >= r5) goto L97
            goto Laf
        L74:
            int r2 = r3.f4241E
            if (r5 >= r2) goto L83
            int r0 = r3.f4243G
            int r0 = r5 - r0
            int r0 = java.lang.Math.abs(r0)
            if (r5 >= r0) goto Lae
            goto Laf
        L83:
            int r1 = r5 - r2
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f4243G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
            goto Lae
        L93:
            boolean r5 = r3.f4265b
            if (r5 == 0) goto L99
        L97:
            r1 = r0
            goto Laf
        L99:
            int r5 = r4.getTop()
            int r1 = r3.f4241E
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f4243G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
        Lae:
            r1 = r6
        Laf:
            r5 = 0
            r3.m3143C(r4, r1, r5)
            r3.f4252P = r5
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.mo3130p(android.view.View, android.view.View, int):void");
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: q */
    public final boolean mo3131q(View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i3 = this.f4248L;
        if (i3 == 1 && actionMasked == 0) {
            return true;
        }
        C0587e c0587e = this.f4249M;
        if (c0587e != null && (this.f4247K || i3 == 1)) {
            c0587e.m1326j(motionEvent);
        }
        if (actionMasked == 0) {
            this.f4261Y = -1;
            VelocityTracker velocityTracker = this.f4260X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4260X = null;
            }
        }
        if (this.f4260X == null) {
            this.f4260X = VelocityTracker.obtain();
        }
        this.f4260X.addMovement(motionEvent);
        if (this.f4249M != null && ((this.f4247K || this.f4248L == 1) && actionMasked == 2 && !this.f4250N)) {
            float fAbs = Math.abs(this.f4262Z - motionEvent.getY());
            C0587e c0587e2 = this.f4249M;
            if (fAbs > c0587e2.f1478b) {
                c0587e2.m1318b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.f4250N;
    }

    /* JADX INFO: renamed from: r */
    public final void m3151r() {
        int iM3152s = m3152s();
        if (this.f4265b) {
            this.f4243G = Math.max(this.f4256T - iM3152s, this.f4240D);
        } else {
            this.f4243G = this.f4256T - iM3152s;
        }
    }

    /* JADX INFO: renamed from: s */
    public final int m3152s() {
        int i3;
        return this.f4272f ? Math.min(Math.max(this.f4273g, this.f4256T - ((this.f4255S * 9) / 16)), this.f4254R) + this.f4288v : (this.f4280n || this.f4281o || (i3 = this.f4279m) <= 0) ? this.f4271e + this.f4288v : Math.max(this.f4271e, i3 + this.f4274h);
    }

    /* JADX INFO: renamed from: t */
    public final void m3153t(int i3) {
        if (((View) this.f4257U.get()) != null) {
            ArrayList arrayList = this.f4259W;
            if (arrayList.isEmpty()) {
                return;
            }
            int i4 = this.f4243G;
            if (i3 <= i4 && i4 != m3154w()) {
                m3154w();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            AbstractC0032g.m162t(arrayList.get(0));
            throw null;
        }
    }

    /* JADX INFO: renamed from: w */
    public final int m3154w() {
        if (this.f4265b) {
            return this.f4240D;
        }
        return Math.max(this.f4239C, this.f4284r ? 0 : this.f4289w);
    }

    /* JADX INFO: renamed from: x */
    public final int m3155x(int i3) {
        if (i3 == 3) {
            return m3154w();
        }
        if (i3 == 4) {
            return this.f4243G;
        }
        if (i3 == 5) {
            return this.f4256T;
        }
        if (i3 == 6) {
            return this.f4241E;
        }
        throw new IllegalArgumentException("Invalid state to get top offset: " + i3);
    }

    /* JADX INFO: renamed from: y */
    public final void m3156y(int i3) {
        if (i3 == -1) {
            if (this.f4272f) {
                return;
            } else {
                this.f4272f = true;
            }
        } else {
            if (!this.f4272f && this.f4271e == i3) {
                return;
            }
            this.f4272f = false;
            this.f4271e = Math.max(0, i3);
        }
        m3147G();
    }

    /* JADX INFO: renamed from: z */
    public final void m3157z(int i3) {
        if (i3 == 1 || i3 == 2) {
            throw new IllegalArgumentException(AbstractC0032g.m157o(new StringBuilder("STATE_"), i3 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.f4245I && i3 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i3);
            return;
        }
        int i4 = (i3 == 6 && this.f4265b && m3155x(i3) <= this.f4240D) ? 3 : i3;
        WeakReference weakReference = this.f4257U;
        if (weakReference == null || weakReference.get() == null) {
            m3141A(i3);
            return;
        }
        View view = (View) this.f4257U.get();
        RunnableC0869d runnableC0869d = new RunnableC0869d(this, view, i4, 4);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if (AbstractC0310E.m619b(view)) {
                view.post(runnableC0869d);
                return;
            }
        }
        runnableC0869d.run();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i3;
        int i4 = 2;
        this.f4263a = 0;
        this.f4265b = true;
        this.f4277k = -1;
        this.f4278l = -1;
        this.f4237A = new C0305e(this);
        this.f4242F = 0.5f;
        this.f4244H = -1.0f;
        this.f4247K = true;
        this.f4248L = 4;
        this.f4253Q = 0.1f;
        this.f4259W = new ArrayList();
        this.f4268c0 = new SparseIntArray();
        this.f4270d0 = new C0302b(this, 1);
        this.f4274h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1805a.f6225a);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.f4276j = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            this.f4291y = C0281j.m552b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).m4266a();
        }
        C0281j c0281j = this.f4291y;
        if (c0281j != null) {
            C0278g c0278g = new C0278g(c0281j);
            this.f4275i = c0278g;
            c0278g.m545i(context);
            ColorStateList colorStateList = this.f4276j;
            if (colorStateList != null) {
                this.f4275i.m547k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f4275i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4238B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.f4238B.addUpdateListener(new C0410D(i4, this));
        this.f4244H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.f4277k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.f4278l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue != null && (i3 = typedValuePeekValue.data) == -1) {
            m3156y(i3);
        } else {
            m3156y(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        }
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(8, false);
        if (this.f4245I != z3) {
            this.f4245I = z3;
            if (!z3 && this.f4248L == 5) {
                m3157z(4);
            }
            m3144D();
        }
        this.f4280n = typedArrayObtainStyledAttributes.getBoolean(13, false);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.f4265b != z4) {
            this.f4265b = z4;
            if (this.f4257U != null) {
                m3151r();
            }
            m3141A((this.f4265b && this.f4248L == 6) ? 3 : this.f4248L);
            m3145E(this.f4248L, true);
            m3144D();
        }
        this.f4246J = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.f4247K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.f4263a = typedArrayObtainStyledAttributes.getInt(10, 0);
        float f3 = typedArrayObtainStyledAttributes.getFloat(7, 0.5f);
        if (f3 > 0.0f && f3 < 1.0f) {
            this.f4242F = f3;
            if (this.f4257U != null) {
                this.f4241E = (int) ((1.0f - f3) * this.f4256T);
            }
            TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(5);
            if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
                int i5 = typedValuePeekValue2.data;
                if (i5 >= 0) {
                    this.f4239C = i5;
                    m3145E(this.f4248L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            } else {
                int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
                if (dimensionPixelOffset >= 0) {
                    this.f4239C = dimensionPixelOffset;
                    m3145E(this.f4248L, true);
                } else {
                    throw new IllegalArgumentException("offset must be greater than or equal to 0");
                }
            }
            this.f4269d = typedArrayObtainStyledAttributes.getInt(11, 500);
            this.f4281o = typedArrayObtainStyledAttributes.getBoolean(17, false);
            this.f4282p = typedArrayObtainStyledAttributes.getBoolean(18, false);
            this.f4283q = typedArrayObtainStyledAttributes.getBoolean(19, false);
            this.f4284r = typedArrayObtainStyledAttributes.getBoolean(20, true);
            this.f4285s = typedArrayObtainStyledAttributes.getBoolean(14, false);
            this.f4286t = typedArrayObtainStyledAttributes.getBoolean(15, false);
            this.f4287u = typedArrayObtainStyledAttributes.getBoolean(16, false);
            this.f4290x = typedArrayObtainStyledAttributes.getBoolean(23, true);
            typedArrayObtainStyledAttributes.recycle();
            this.f4267c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }
}

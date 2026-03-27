package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p029J.AbstractC0311F;
import p029J.AbstractC0323S;
import p029J.C0364q0;
import p057T.AbstractC0635a;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* JADX INFO: renamed from: e */
    public ArrayList f3071e;

    /* JADX INFO: renamed from: f */
    public ArrayList f3072f;

    /* JADX INFO: renamed from: g */
    public View.OnApplyWindowInsetsListener f3073g;

    /* JADX INFO: renamed from: h */
    public boolean f3074h;

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        String str;
        super(context, attributeSet, 0);
        this.f3074h = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0635a.f1629b);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute != null && !isInEditMode()) {
                throw new UnsupportedOperationException(AbstractC0032g.m156n("FragmentContainerView must be within a FragmentActivity to use ", str, "=\"", classAttribute, "\""));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m2413a(View view) {
        ArrayList arrayList = this.f3072f;
        if (arrayList == null || !arrayList.contains(view)) {
            return;
        }
        if (this.f3071e == null) {
            this.f3071e = new ArrayList();
        }
        this.f3071e.add(view);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof AbstractComponentCallbacksC0944o ? (AbstractComponentCallbacksC0944o) tag : null) != null) {
            super.addView(view, i3, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int i3, ViewGroup.LayoutParams layoutParams, boolean z3) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof AbstractComponentCallbacksC0944o ? (AbstractComponentCallbacksC0944o) tag : null) != null) {
            return super.addViewInLayout(view, i3, layoutParams, z3);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C0364q0 c0364q0M829g;
        C0364q0 c0364q0M829g2 = C0364q0.m829g(windowInsets, null);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f3073g;
        if (onApplyWindowInsetsListener != null) {
            c0364q0M829g = C0364q0.m829g(onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets), null);
        } else {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            WindowInsets windowInsetsM834f = c0364q0M829g2.m834f();
            if (windowInsetsM834f != null) {
                WindowInsets windowInsetsM626b = AbstractC0311F.m626b(this, windowInsetsM834f);
                if (!windowInsetsM626b.equals(windowInsetsM834f)) {
                    c0364q0M829g2 = C0364q0.m829g(windowInsetsM626b, this);
                }
            }
            c0364q0M829g = c0364q0M829g2;
        }
        if (!c0364q0M829g.f874a.mo765m()) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                WeakHashMap weakHashMap2 = AbstractC0323S.f816a;
                WindowInsets windowInsetsM834f2 = c0364q0M829g.m834f();
                if (windowInsetsM834f2 != null) {
                    WindowInsets windowInsetsM625a = AbstractC0311F.m625a(childAt, windowInsetsM834f2);
                    if (!windowInsetsM625a.equals(windowInsetsM834f2)) {
                        C0364q0.m829g(windowInsetsM625a, childAt);
                    }
                }
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.f3074h && this.f3071e != null) {
            for (int i3 = 0; i3 < this.f3071e.size(); i3++) {
                super.drawChild(canvas, (View) this.f3071e.get(i3), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j2) {
        ArrayList arrayList;
        if (!this.f3074h || (arrayList = this.f3071e) == null || arrayList.size() <= 0 || !this.f3071e.contains(view)) {
            return super.drawChild(canvas, view, j2);
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList arrayList = this.f3072f;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList arrayList2 = this.f3071e;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.f3074h = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            m2413a(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z3) {
        if (z3) {
            m2413a(view);
        }
        super.removeDetachedView(view, z3);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        m2413a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i3) {
        m2413a(getChildAt(i3));
        super.removeViewAt(i3);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        m2413a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            m2413a(getChildAt(i5));
        }
        super.removeViews(i3, i4);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            m2413a(getChildAt(i5));
        }
        super.removeViewsInLayout(i3, i4);
    }

    public void setDrawDisappearingViewsLast(boolean z3) {
        this.f3074h = z3;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.f3073g = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.f3072f == null) {
                this.f3072f = new ArrayList();
            }
            this.f3072f.add(view);
        }
        super.startViewTransition(view);
    }
}

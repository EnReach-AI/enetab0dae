package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p094f.AbstractC1343a;
import p110k.AbstractC1538J0;
import p110k.C1570a;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: e */
    public boolean f2681e;

    /* JADX INFO: renamed from: f */
    public View f2682f;

    /* JADX INFO: renamed from: g */
    public View f2683g;

    /* JADX INFO: renamed from: h */
    public Drawable f2684h;

    /* JADX INFO: renamed from: i */
    public Drawable f2685i;

    /* JADX INFO: renamed from: j */
    public Drawable f2686j;

    /* JADX INFO: renamed from: k */
    public final boolean f2687k;

    /* JADX INFO: renamed from: l */
    public boolean f2688l;

    /* JADX INFO: renamed from: m */
    public final int f2689m;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C1570a c1570a = new C1570a(this);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        AbstractC0307B.m601q(this, c1570a);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC1343a.f4777a);
        boolean z3 = false;
        this.f2684h = typedArrayObtainStyledAttributes.getDrawable(0);
        this.f2685i = typedArrayObtainStyledAttributes.getDrawable(2);
        this.f2689m = typedArrayObtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == R.id.split_action_bar) {
            this.f2687k = true;
            this.f2686j = typedArrayObtainStyledAttributes.getDrawable(1);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!this.f2687k ? !(this.f2684h != null || this.f2685i != null) : this.f2686j == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2684h;
        if (drawable != null && drawable.isStateful()) {
            this.f2684h.setState(getDrawableState());
        }
        Drawable drawable2 = this.f2685i;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f2685i.setState(getDrawableState());
        }
        Drawable drawable3 = this.f2686j;
        if (drawable3 == null || !drawable3.isStateful()) {
            return;
        }
        this.f2686j.setState(getDrawableState());
    }

    public View getTabContainer() {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2684h;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2685i;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f2686j;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f2682f = findViewById(R.id.action_bar);
        this.f2683g = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f2681e || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z3, int i3, int i4, int i5, int i6) {
        super.onLayout(z3, i3, i4, i5, i6);
        boolean z4 = true;
        if (this.f2687k) {
            Drawable drawable = this.f2686j;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z4 = false;
            }
        } else {
            if (this.f2684h == null) {
                z4 = false;
            } else if (this.f2682f.getVisibility() == 0) {
                this.f2684h.setBounds(this.f2682f.getLeft(), this.f2682f.getTop(), this.f2682f.getRight(), this.f2682f.getBottom());
            } else {
                View view = this.f2683g;
                if (view == null || view.getVisibility() != 0) {
                    this.f2684h.setBounds(0, 0, 0, 0);
                } else {
                    this.f2684h.setBounds(this.f2683g.getLeft(), this.f2683g.getTop(), this.f2683g.getRight(), this.f2683g.getBottom());
                }
            }
            this.f2688l = false;
        }
        if (z4) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i4) {
        int i5;
        if (this.f2682f == null && View.MeasureSpec.getMode(i4) == Integer.MIN_VALUE && (i5 = this.f2689m) >= 0) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i4)), Integer.MIN_VALUE);
        }
        super.onMeasure(i3, i4);
        if (this.f2682f == null) {
            return;
        }
        View.MeasureSpec.getMode(i4);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f2684h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2684h);
        }
        this.f2684h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f2682f;
            if (view != null) {
                this.f2684h.setBounds(view.getLeft(), this.f2682f.getTop(), this.f2682f.getRight(), this.f2682f.getBottom());
            }
        }
        boolean z3 = false;
        if (!this.f2687k ? !(this.f2684h != null || this.f2685i != null) : this.f2686j == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f2686j;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.f2686j);
        }
        this.f2686j = drawable;
        boolean z3 = this.f2687k;
        boolean z4 = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (z3 && (drawable2 = this.f2686j) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!z3 ? !(this.f2684h != null || this.f2685i != null) : this.f2686j == null) {
            z4 = true;
        }
        setWillNotDraw(z4);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f2685i;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f2685i);
        }
        this.f2685i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f2688l && this.f2685i != null) {
                throw null;
            }
        }
        boolean z3 = false;
        if (!this.f2687k ? !(this.f2684h != null || this.f2685i != null) : this.f2686j == null) {
            z3 = true;
        }
        setWillNotDraw(z3);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(AbstractC1538J0 abstractC1538J0) {
    }

    public void setTransitioning(boolean z3) {
        this.f2681e = z3;
        setDescendantFocusability(z3 ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z3 = i3 == 0;
        Drawable drawable = this.f2684h;
        if (drawable != null) {
            drawable.setVisible(z3, false);
        }
        Drawable drawable2 = this.f2685i;
        if (drawable2 != null) {
            drawable2.setVisible(z3, false);
        }
        Drawable drawable3 = this.f2686j;
        if (drawable3 != null) {
            drawable3.setVisible(z3, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2684h;
        boolean z3 = this.f2687k;
        return (drawable == drawable2 && !z3) || (drawable == this.f2685i && this.f2688l) || ((drawable == this.f2686j && z3) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i3) {
        if (i3 != 0) {
            return super.startActionModeForChild(view, callback, i3);
        }
        return null;
    }
}

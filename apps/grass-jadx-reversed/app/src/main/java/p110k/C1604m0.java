package p110k;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import io.getgrass.www.R;
import java.lang.reflect.InvocationTargetException;
import p007B1.RunnableC0055o;
import p041N.ViewOnTouchListenerC0519g;

/* JADX INFO: renamed from: k.m0 */
/* JADX INFO: loaded from: classes.dex */
public class C1604m0 extends ListView {

    /* JADX INFO: renamed from: e */
    public final Rect f5681e;

    /* JADX INFO: renamed from: f */
    public int f5682f;

    /* JADX INFO: renamed from: g */
    public int f5683g;

    /* JADX INFO: renamed from: h */
    public int f5684h;

    /* JADX INFO: renamed from: i */
    public int f5685i;

    /* JADX INFO: renamed from: j */
    public int f5686j;

    /* JADX INFO: renamed from: k */
    public C1600k0 f5687k;

    /* JADX INFO: renamed from: l */
    public boolean f5688l;

    /* JADX INFO: renamed from: m */
    public final boolean f5689m;

    /* JADX INFO: renamed from: n */
    public boolean f5690n;

    /* JADX INFO: renamed from: o */
    public ViewOnTouchListenerC0519g f5691o;

    /* JADX INFO: renamed from: p */
    public RunnableC0055o f5692p;

    public C1604m0(Context context, boolean z3) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f5681e = new Rect();
        this.f5682f = 0;
        this.f5683g = 0;
        this.f5684h = 0;
        this.f5685i = 0;
        this.f5689m = z3;
        setCacheColorHint(0);
    }

    /* JADX INFO: renamed from: a */
    public final int m3665a(int i3, int i4) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i5 = 0;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i7 = layoutParams.height;
            view.measure(i3, i7 > 0 ? View.MeasureSpec.makeMeasureSpec(i7, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i6 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return i4;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m3666b(android.view.MotionEvent r17, int r18) {
        /*
            Method dump skipped, instruction units count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p110k.C1604m0.m3666b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f5681e;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f5692p != null) {
            return;
        }
        super.drawableStateChanged();
        C1600k0 c1600k0 = this.f5687k;
        if (c1600k0 != null) {
            c1600k0.f5675f = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f5690n && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f5689m || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f5689m || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f5689m || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f5689m && this.f5688l) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f5692p = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i3 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f5692p == null) {
            RunnableC0055o runnableC0055o = new RunnableC0055o(15, this);
            this.f5692p = runnableC0055o;
            post(runnableC0055o);
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i3 < 30 || !AbstractC1595i0.f5666d) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            AbstractC1595i0.f5663a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                            AbstractC1595i0.f5664b.invoke(this, Integer.valueOf(iPointToPosition));
                            AbstractC1595i0.f5665c.invoke(this, Integer.valueOf(iPointToPosition));
                        } catch (IllegalAccessException e3) {
                            e3.printStackTrace();
                        } catch (InvocationTargetException e4) {
                            e4.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f5690n && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f5686j = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        RunnableC0055o runnableC0055o = this.f5692p;
        if (runnableC0055o != null) {
            C1604m0 c1604m0 = (C1604m0) runnableC0055o.f201f;
            c1604m0.f5692p = null;
            c1604m0.removeCallbacks(runnableC0055o);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z3) {
        this.f5688l = z3;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C1600k0 c1600k0 = null;
        if (drawable != null) {
            C1600k0 c1600k02 = new C1600k0();
            Drawable drawable2 = c1600k02.f5674e;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            c1600k02.f5674e = drawable;
            drawable.setCallback(c1600k02);
            c1600k02.f5675f = true;
            c1600k0 = c1600k02;
        }
        this.f5687k = c1600k0;
        super.setSelector(c1600k0);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f5682f = rect.left;
        this.f5683g = rect.top;
        this.f5684h = rect.right;
        this.f5685i = rect.bottom;
    }
}

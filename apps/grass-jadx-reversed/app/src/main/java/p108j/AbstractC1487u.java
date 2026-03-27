package p108j;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: j.u */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1487u implements InterfaceC1464D, InterfaceC1492z, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: e */
    public Rect f5410e;

    /* JADX INFO: renamed from: m */
    public static int m3535m(ListAdapter listAdapter, Context context, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i4 = 0;
        int i5 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = listAdapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i6, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i3) {
                return i3;
            }
            if (measuredWidth > i4) {
                i4 = measuredWidth;
            }
        }
        return i4;
    }

    /* JADX INFO: renamed from: u */
    public static boolean m3536u(MenuC1479m menuC1479m) {
        int size = menuC1479m.f5349f.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = menuC1479m.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: c */
    public final void mo3506c(Context context, MenuC1479m menuC1479m) {
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: e */
    public final boolean mo3507e(C1481o c1481o) {
        return false;
    }

    @Override // p108j.InterfaceC1492z
    /* JADX INFO: renamed from: h */
    public final boolean mo3508h(C1481o c1481o) {
        return false;
    }

    /* JADX INFO: renamed from: l */
    public abstract void mo3483l(MenuC1479m menuC1479m);

    /* JADX INFO: renamed from: n */
    public abstract void mo3484n(View view);

    /* JADX INFO: renamed from: o */
    public abstract void mo3485o(boolean z3);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (C1476j) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C1476j) listAdapter).f5337e.m3519q((MenuItem) listAdapter.getItem(i3), this, (this instanceof ViewOnKeyListenerC1473g) ^ true ? 0 : 4);
    }

    /* JADX INFO: renamed from: p */
    public abstract void mo3486p(int i3);

    /* JADX INFO: renamed from: q */
    public abstract void mo3487q(int i3);

    /* JADX INFO: renamed from: r */
    public abstract void mo3488r(PopupWindow.OnDismissListener onDismissListener);

    /* JADX INFO: renamed from: s */
    public abstract void mo3489s(boolean z3);

    /* JADX INFO: renamed from: t */
    public abstract void mo3490t(int i3);
}

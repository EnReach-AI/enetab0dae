package p110k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import p108j.C1476j;
import p108j.C1481o;
import p108j.MenuC1479m;

/* JADX INFO: renamed from: k.D0 */
/* JADX INFO: loaded from: classes.dex */
public final class C1526D0 extends C1604m0 {

    /* JADX INFO: renamed from: q */
    public final int f5479q;

    /* JADX INFO: renamed from: r */
    public final int f5480r;

    /* JADX INFO: renamed from: s */
    public InterfaceC1630z0 f5481s;

    /* JADX INFO: renamed from: t */
    public C1481o f5482t;

    public C1526D0(Context context, boolean z3) {
        super(context, z3);
        if (1 == AbstractC1524C0.m3568a(context.getResources().getConfiguration())) {
            this.f5479q = 21;
            this.f5480r = 22;
        } else {
            this.f5479q = 22;
            this.f5480r = 21;
        }
    }

    @Override // p110k.C1604m0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        C1476j c1476j;
        int headersCount;
        int iPointToPosition;
        int i3;
        if (this.f5481s != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                c1476j = (C1476j) headerViewListAdapter.getWrappedAdapter();
            } else {
                c1476j = (C1476j) adapter;
                headersCount = 0;
            }
            C1481o c1481oM3510b = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i3 = iPointToPosition - headersCount) < 0 || i3 >= c1476j.getCount()) ? null : c1476j.getItem(i3);
            C1481o c1481o = this.f5482t;
            if (c1481o != c1481oM3510b) {
                MenuC1479m menuC1479m = c1476j.f5337e;
                if (c1481o != null) {
                    this.f5481s.mo981n(menuC1479m, c1481o);
                }
                this.f5482t = c1481oM3510b;
                if (c1481oM3510b != null) {
                    this.f5481s.mo979c(menuC1479m, c1481oM3510b);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i3 == this.f5479q) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i3 != this.f5480r) {
            return super.onKeyDown(i3, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (C1476j) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (C1476j) adapter).f5337e.m3513c(false);
        return true;
    }

    public void setHoverListener(InterfaceC1630z0 interfaceC1630z0) {
        this.f5481s = interfaceC1630z0;
    }

    @Override // p110k.C1604m0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}

package p108j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: renamed from: j.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1476j extends BaseAdapter {

    /* JADX INFO: renamed from: e */
    public final MenuC1479m f5337e;

    /* JADX INFO: renamed from: f */
    public int f5338f = -1;

    /* JADX INFO: renamed from: g */
    public boolean f5339g;

    /* JADX INFO: renamed from: h */
    public final boolean f5340h;

    /* JADX INFO: renamed from: i */
    public final LayoutInflater f5341i;

    /* JADX INFO: renamed from: j */
    public final int f5342j;

    public C1476j(MenuC1479m menuC1479m, LayoutInflater layoutInflater, boolean z3, int i3) {
        this.f5340h = z3;
        this.f5341i = layoutInflater;
        this.f5337e = menuC1479m;
        this.f5342j = i3;
        m3509a();
    }

    /* JADX INFO: renamed from: a */
    public final void m3509a() {
        MenuC1479m menuC1479m = this.f5337e;
        C1481o c1481o = menuC1479m.f5365v;
        if (c1481o != null) {
            menuC1479m.m3516i();
            ArrayList arrayList = menuC1479m.f5353j;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((C1481o) arrayList.get(i3)) == c1481o) {
                    this.f5338f = i3;
                    return;
                }
            }
        }
        this.f5338f = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C1481o getItem(int i3) {
        ArrayList arrayListM3517l;
        boolean z3 = this.f5340h;
        MenuC1479m menuC1479m = this.f5337e;
        if (z3) {
            menuC1479m.m3516i();
            arrayListM3517l = menuC1479m.f5353j;
        } else {
            arrayListM3517l = menuC1479m.m3517l();
        }
        int i4 = this.f5338f;
        if (i4 >= 0 && i3 >= i4) {
            i3++;
        }
        return (C1481o) arrayListM3517l.get(i3);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListM3517l;
        boolean z3 = this.f5340h;
        MenuC1479m menuC1479m = this.f5337e;
        if (z3) {
            menuC1479m.m3516i();
            arrayListM3517l = menuC1479m.f5353j;
        } else {
            arrayListM3517l = menuC1479m.m3517l();
        }
        return this.f5338f < 0 ? arrayListM3517l.size() : arrayListM3517l.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        boolean z3 = false;
        if (view == null) {
            view = this.f5341i.inflate(this.f5342j, viewGroup, false);
        }
        int i4 = getItem(i3).f5375b;
        int i5 = i3 - 1;
        int i6 = i5 >= 0 ? getItem(i5).f5375b : i4;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f5337e.mo3496m() && i4 != i6) {
            z3 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z3);
        InterfaceC1461A interfaceC1461A = (InterfaceC1461A) view;
        if (this.f5339g) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC1461A.mo2221d(getItem(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        m3509a();
        super.notifyDataSetChanged();
    }
}

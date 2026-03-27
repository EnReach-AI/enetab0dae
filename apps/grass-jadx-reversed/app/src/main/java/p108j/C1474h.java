package p108j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import io.getgrass.www.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: j.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1474h extends BaseAdapter {

    /* JADX INFO: renamed from: e */
    public int f5329e = -1;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1475i f5330f;

    public C1474h(C1475i c1475i) {
        this.f5330f = c1475i;
        m3504a();
    }

    /* JADX INFO: renamed from: a */
    public final void m3504a() {
        MenuC1479m menuC1479m = this.f5330f.f5333g;
        C1481o c1481o = menuC1479m.f5365v;
        if (c1481o != null) {
            menuC1479m.m3516i();
            ArrayList arrayList = menuC1479m.f5353j;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (((C1481o) arrayList.get(i3)) == c1481o) {
                    this.f5329e = i3;
                    return;
                }
            }
        }
        this.f5329e = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final C1481o getItem(int i3) {
        C1475i c1475i = this.f5330f;
        MenuC1479m menuC1479m = c1475i.f5333g;
        menuC1479m.m3516i();
        ArrayList arrayList = menuC1479m.f5353j;
        c1475i.getClass();
        int i4 = this.f5329e;
        if (i4 >= 0 && i3 >= i4) {
            i3++;
        }
        return (C1481o) arrayList.get(i3);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        C1475i c1475i = this.f5330f;
        MenuC1479m menuC1479m = c1475i.f5333g;
        menuC1479m.m3516i();
        int size = menuC1479m.f5353j.size();
        c1475i.getClass();
        return this.f5329e < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5330f.f5332f.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((InterfaceC1461A) view).mo2221d(getItem(i3));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        m3504a();
        super.notifyDataSetChanged();
    }
}

package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import p108j.C1481o;
import p108j.InterfaceC1462B;
import p108j.InterfaceC1478l;
import p108j.MenuC1479m;
import p166z0.C2071i;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements InterfaceC1478l, InterfaceC1462B, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: f */
    public static final int[] f2662f = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: e */
    public MenuC1479m f2663e;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C2071i c2071iM4591v = C2071i.m4591v(context, attributeSet, f2662f, R.attr.listViewStyle, 0);
        TypedArray typedArray = (TypedArray) c2071iM4591v.f7315b;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(c2071iM4591v.m4601l(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(c2071iM4591v.m4601l(1));
        }
        c2071iM4591v.m4608x();
    }

    @Override // p108j.InterfaceC1462B
    /* JADX INFO: renamed from: a */
    public final void mo2224a(MenuC1479m menuC1479m) {
        this.f2663e = menuC1479m;
    }

    @Override // p108j.InterfaceC1478l
    /* JADX INFO: renamed from: b */
    public final boolean mo2225b(C1481o c1481o) {
        return this.f2663e.m3519q(c1481o, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j2) {
        mo2225b((C1481o) getAdapter().getItem(i3));
    }
}

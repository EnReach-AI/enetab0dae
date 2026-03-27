package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import p108j.InterfaceC1462B;
import p108j.MenuC1479m;

/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements InterfaceC1462B {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setLayoutManager(new LinearLayoutManager(1));
    }

    @Override // p108j.InterfaceC1462B
    /* JADX INFO: renamed from: a */
    public final void mo2224a(MenuC1479m menuC1479m) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}

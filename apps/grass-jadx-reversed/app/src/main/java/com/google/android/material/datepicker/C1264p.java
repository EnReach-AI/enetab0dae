package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p029J.AbstractC0323S;
import p029J.C0373x;
import p073Z.AbstractC0777X;

/* JADX INFO: renamed from: com.google.android.material.datepicker.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1264p extends AbstractC0777X {

    /* JADX INFO: renamed from: t */
    public final TextView f4413t;

    /* JADX INFO: renamed from: u */
    public final MaterialCalendarGridView f4414u;

    public C1264p(LinearLayout linearLayout, boolean z3) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
        this.f4413t = textView;
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        new C0373x(R.id.tag_accessibility_heading, Boolean.class, 0, 28, 2).m845e(textView, Boolean.TRUE);
        this.f4414u = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
        if (z3) {
            return;
        }
        textView.setVisibility(8);
    }
}

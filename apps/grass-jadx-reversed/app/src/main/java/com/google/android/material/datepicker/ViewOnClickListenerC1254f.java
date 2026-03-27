package com.google.android.material.datepicker;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p073Z.AbstractC0763I;

/* JADX INFO: renamed from: com.google.android.material.datepicker.f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC1254f implements View.OnClickListener {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f4356e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ C1265q f4357f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C1258j f4358g;

    public /* synthetic */ ViewOnClickListenerC1254f(C1258j c1258j, C1265q c1265q, int i3) {
        this.f4356e = i3;
        this.f4358g = c1258j;
        this.f4357f = c1265q;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4356e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C1258j c1258j = this.f4358g;
                int iM2550F0 = ((LinearLayoutManager) c1258j.f4371d0.getLayoutManager()).m2550F0() - 1;
                if (iM2550F0 >= 0) {
                    Calendar calendarM3189a = AbstractC1269u.m3189a(this.f4357f.f4415c.f4343e.f4399e);
                    calendarM3189a.add(2, iM2550F0);
                    c1258j.m3177P(new C1261m(calendarM3189a));
                }
                break;
            default:
                C1258j c1258j2 = this.f4358g;
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) c1258j2.f4371d0.getLayoutManager();
                View viewM2552H0 = linearLayoutManager.m2552H0(0, linearLayoutManager.m2027v(), false);
                int iM1958D = (viewM2552H0 == null ? -1 : AbstractC0763I.m1958D(viewM2552H0)) + 1;
                if (iM1958D < c1258j2.f4371d0.getAdapter().mo1944a()) {
                    Calendar calendarM3189a2 = AbstractC1269u.m3189a(this.f4357f.f4415c.f4343e.f4399e);
                    calendarM3189a2.add(2, iM1958D);
                    c1258j2.m3177P(new C1261m(calendarM3189a2));
                }
                break;
        }
    }
}

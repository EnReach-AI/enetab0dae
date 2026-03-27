package com.google.android.material.datepicker;

import android.R;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import p005B.AbstractC0032g;
import p007B1.C0041a;
import p021G.RunnableC0225b;
import p024H0.ViewOnClickListenerC0250d;
import p029J.AbstractC0323S;
import p036L0.C0444d;
import p041N.C0521i;
import p073Z.C0781a0;
import p073Z.C0813y;

/* JADX INFO: renamed from: com.google.android.material.datepicker.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1258j<S> extends AbstractC1266r {

    /* JADX INFO: renamed from: X */
    public int f4365X;

    /* JADX INFO: renamed from: Y */
    public C1250b f4366Y;

    /* JADX INFO: renamed from: Z */
    public C1261m f4367Z;

    /* JADX INFO: renamed from: a0 */
    public int f4368a0;

    /* JADX INFO: renamed from: b0 */
    public C1251c f4369b0;

    /* JADX INFO: renamed from: c0 */
    public RecyclerView f4370c0;

    /* JADX INFO: renamed from: d0 */
    public RecyclerView f4371d0;

    /* JADX INFO: renamed from: e0 */
    public View f4372e0;

    /* JADX INFO: renamed from: f0 */
    public View f4373f0;

    /* JADX INFO: renamed from: g0 */
    public View f4374g0;

    /* JADX INFO: renamed from: h0 */
    public View f4375h0;

    /* JADX INFO: renamed from: P */
    public final void m3177P(C1261m c1261m) {
        C1265q c1265q = (C1265q) this.f4371d0.getAdapter();
        int iM3185d = c1265q.f4415c.f4343e.m3185d(c1261m);
        int iM3185d2 = iM3185d - c1265q.f4415c.f4343e.m3185d(this.f4367Z);
        boolean z3 = Math.abs(iM3185d2) > 3;
        boolean z4 = iM3185d2 > 0;
        this.f4367Z = c1261m;
        if (z3 && z4) {
            this.f4371d0.m2601a0(iM3185d - 3);
            this.f4371d0.post(new RunnableC0225b(this, iM3185d, 2));
        } else if (!z3) {
            this.f4371d0.post(new RunnableC0225b(this, iM3185d, 2));
        } else {
            this.f4371d0.m2601a0(iM3185d + 3);
            this.f4371d0.post(new RunnableC0225b(this, iM3185d, 2));
        }
    }

    /* JADX INFO: renamed from: Q */
    public final void m3178Q(int i3) {
        this.f4368a0 = i3;
        if (i3 == 2) {
            this.f4370c0.getLayoutManager().mo2002i0(this.f4367Z.f4401g - ((C1271w) this.f4370c0.getAdapter()).f4421c.f4366Y.f4343e.f4401g);
            this.f4374g0.setVisibility(0);
            this.f4375h0.setVisibility(8);
            this.f4372e0.setVisibility(8);
            this.f4373f0.setVisibility(8);
            return;
        }
        if (i3 == 1) {
            this.f4374g0.setVisibility(8);
            this.f4375h0.setVisibility(0);
            this.f4372e0.setVisibility(0);
            this.f4373f0.setVisibility(0);
            m3177P(this.f4367Z);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: q */
    public final void mo518q(Bundle bundle) {
        super.mo518q(bundle);
        if (bundle == null) {
            bundle = this.f3227j;
        }
        this.f4365X = bundle.getInt("THEME_RES_ID_KEY");
        AbstractC0032g.m158p(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.f4366Y = (C1250b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        AbstractC0032g.m158p(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.f4367Z = (C1261m) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: r */
    public final View mo500r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i3;
        int i4;
        C0813y c0813y;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(m2492j(), this.f4365X);
        this.f4369b0 = new C1251c(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        C1261m c1261m = this.f4366Y.f4343e;
        if (C1259k.m3180U(contextThemeWrapper, R.attr.windowFullscreen)) {
            i3 = io.getgrass.www.R.layout.mtrl_calendar_vertical;
            i4 = 1;
        } else {
            i3 = io.getgrass.www.R.layout.mtrl_calendar_horizontal;
            i4 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i3, viewGroup, false);
        Resources resources = m2481I().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(io.getgrass.www.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(io.getgrass.www.R.dimen.mtrl_calendar_days_of_week_height);
        int i5 = C1262n.f4406h;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_calendar_month_vertical_padding) * (i5 - 1)) + (resources.getDimensionPixelSize(io.getgrass.www.R.dimen.mtrl_calendar_day_height) * i5) + resources.getDimensionPixelOffset(io.getgrass.www.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(io.getgrass.www.R.id.mtrl_calendar_days_of_week);
        AbstractC0323S.m701k(gridView, new C0521i(1));
        int i6 = this.f4366Y.f4347i;
        gridView.setAdapter((ListAdapter) (i6 > 0 ? new C1253e(i6) : new C1253e()));
        gridView.setNumColumns(c1261m.f4402h);
        gridView.setEnabled(false);
        this.f4371d0 = (RecyclerView) viewInflate.findViewById(io.getgrass.www.R.id.mtrl_calendar_months);
        m2492j();
        this.f4371d0.setLayoutManager(new C1255g(this, i4, i4));
        this.f4371d0.setTag("MONTHS_VIEW_GROUP_TAG");
        C1265q c1265q = new C1265q(contextThemeWrapper, this.f4366Y, new C0444d(this));
        this.f4371d0.setAdapter(c1265q);
        int integer = contextThemeWrapper.getResources().getInteger(io.getgrass.www.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(io.getgrass.www.R.id.mtrl_calendar_year_selector_frame);
        this.f4370c0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.f4370c0.setLayoutManager(new GridLayoutManager(integer));
            this.f4370c0.setAdapter(new C1271w(this));
            this.f4370c0.m2607g(new C1256h(this));
        }
        if (viewInflate.findViewById(io.getgrass.www.R.id.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(io.getgrass.www.R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            AbstractC0323S.m701k(materialButton, new C0041a(2, this));
            View viewFindViewById = viewInflate.findViewById(io.getgrass.www.R.id.month_navigation_previous);
            this.f4372e0 = viewFindViewById;
            viewFindViewById.setTag("NAVIGATION_PREV_TAG");
            View viewFindViewById2 = viewInflate.findViewById(io.getgrass.www.R.id.month_navigation_next);
            this.f4373f0 = viewFindViewById2;
            viewFindViewById2.setTag("NAVIGATION_NEXT_TAG");
            this.f4374g0 = viewInflate.findViewById(io.getgrass.www.R.id.mtrl_calendar_year_selector_frame);
            this.f4375h0 = viewInflate.findViewById(io.getgrass.www.R.id.mtrl_calendar_day_selector_frame);
            m3178Q(1);
            materialButton.setText(this.f4367Z.m3184c());
            this.f4371d0.m2608h(new C1257i(this, c1265q, materialButton));
            materialButton.setOnClickListener(new ViewOnClickListenerC0250d(2, this));
            this.f4373f0.setOnClickListener(new ViewOnClickListenerC1254f(this, c1265q, 1));
            this.f4372e0.setOnClickListener(new ViewOnClickListenerC1254f(this, c1265q, 0));
        }
        if (!C1259k.m3180U(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (c0813y = new C0813y()).f2413a) != (recyclerView = this.f4371d0)) {
            C0781a0 c0781a0 = c0813y.f2414b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f3421i0;
                if (arrayList != null) {
                    arrayList.remove(c0781a0);
                }
                c0813y.f2413a.setOnFlingListener(null);
            }
            c0813y.f2413a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                c0813y.f2413a.m2608h(c0781a0);
                c0813y.f2413a.setOnFlingListener(c0813y);
                new Scroller(c0813y.f2413a.getContext(), new DecelerateInterpolator());
                c0813y.m2134f();
            }
        }
        this.f4371d0.m2601a0(c1265q.f4415c.f4343e.m3185d(this.f4367Z));
        AbstractC0323S.m701k(this.f4371d0, new C0521i(2));
        return viewInflate;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: y */
    public final void mo502y(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f4365X);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4366Y);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f4367Z);
    }
}

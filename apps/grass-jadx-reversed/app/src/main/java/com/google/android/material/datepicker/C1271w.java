package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import io.getgrass.www.R;
import java.util.Locale;
import p019F0.C0217a;
import p073Z.AbstractC0756B;
import p073Z.AbstractC0777X;

/* JADX INFO: renamed from: com.google.android.material.datepicker.w */
/* JADX INFO: loaded from: classes.dex */
public final class C1271w extends AbstractC0756B {

    /* JADX INFO: renamed from: c */
    public final C1258j f4421c;

    public C1271w(C1258j c1258j) {
        this.f4421c = c1258j;
    }

    @Override // p073Z.AbstractC0756B
    /* JADX INFO: renamed from: a */
    public final int mo1944a() {
        return this.f4421c.f4366Y.f4348j;
    }

    @Override // p073Z.AbstractC0756B
    /* JADX INFO: renamed from: c */
    public final void mo1946c(AbstractC0777X abstractC0777X, int i3) {
        C1258j c1258j = this.f4421c;
        int i4 = c1258j.f4366Y.f4343e.f4401g + i3;
        String str = String.format(Locale.getDefault(), "%d", Integer.valueOf(i4));
        TextView textView = ((C1270v) abstractC0777X).f4420t;
        textView.setText(str);
        Context context = textView.getContext();
        textView.setContentDescription(AbstractC1269u.m3190b().get(1) == i4 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i4)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i4)));
        C1251c c1251c = c1258j.f4369b0;
        if (AbstractC1269u.m3190b().get(1) == i4) {
            C0217a c0217a = c1251c.f4351b;
        } else {
            C0217a c0217a2 = c1251c.f4350a;
        }
        throw null;
    }

    @Override // p073Z.AbstractC0756B
    /* JADX INFO: renamed from: d */
    public final AbstractC0777X mo1947d(ViewGroup viewGroup) {
        return new C1270v((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}

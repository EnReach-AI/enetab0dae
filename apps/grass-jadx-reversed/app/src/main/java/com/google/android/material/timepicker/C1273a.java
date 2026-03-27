package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import com.google.android.material.chip.Chip;
import p007B1.AbstractC0053m;

/* JADX INFO: renamed from: com.google.android.material.timepicker.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1273a extends AbstractC0053m {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ ChipTextInputComboView f4571e;

    public C1273a(ChipTextInputComboView chipTextInputComboView) {
        this.f4571e = chipTextInputComboView;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        boolean zIsEmpty = TextUtils.isEmpty(editable);
        ChipTextInputComboView chipTextInputComboView = this.f4571e;
        if (zIsEmpty) {
            chipTextInputComboView.f4539e.setText(ChipTextInputComboView.m3226a(chipTextInputComboView, "00"));
            return;
        }
        String strM3226a = ChipTextInputComboView.m3226a(chipTextInputComboView, editable);
        Chip chip = chipTextInputComboView.f4539e;
        if (TextUtils.isEmpty(strM3226a)) {
            strM3226a = ChipTextInputComboView.m3226a(chipTextInputComboView, "00");
        }
        chip.setText(strM3226a);
    }
}

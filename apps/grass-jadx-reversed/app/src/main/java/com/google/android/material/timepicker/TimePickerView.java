package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import io.getgrass.www.R;

/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout {

    /* JADX INFO: renamed from: u */
    public static final /* synthetic */ int f4569u = 0;

    /* JADX INFO: renamed from: t */
    public final Chip f4570t;

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        ViewOnClickListenerC1279g viewOnClickListenerC1279g = new ViewOnClickListenerC1279g(this);
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        materialButtonToggleGroup.f4311g.add(new C1278f(this));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.f4570t = chip2;
        ViewOnTouchListenerC1281i viewOnTouchListenerC1281i = new ViewOnTouchListenerC1281i(new GestureDetector(getContext(), new C1280h(this)));
        chip.setOnTouchListener(viewOnTouchListenerC1281i);
        chip2.setOnTouchListener(viewOnTouchListenerC1281i);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(viewOnClickListenerC1279g);
        chip2.setOnClickListener(viewOnClickListenerC1279g);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (view == this && i3 == 0) {
            this.f4570t.sendAccessibilityEvent(8);
        }
    }
}

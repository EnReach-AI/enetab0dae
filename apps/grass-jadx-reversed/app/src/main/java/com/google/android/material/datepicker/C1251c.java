package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import io.getgrass.www.R;
import p019F0.C0217a;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1919e;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: com.google.android.material.datepicker.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1251c {

    /* JADX INFO: renamed from: a */
    public final C0217a f4350a;

    /* JADX INFO: renamed from: b */
    public final C0217a f4351b;

    public C1251c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1919e.m4298s(context, R.attr.materialCalendarStyle, C1258j.class.getCanonicalName()).data, AbstractC1805a.f6235k);
        C0217a.m426a(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        C0217a.m426a(context, typedArrayObtainStyledAttributes.getResourceId(1, 0));
        C0217a.m426a(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        C0217a.m426a(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        ColorStateList colorStateListM4303d = AbstractC1920f.m4303d(context, typedArrayObtainStyledAttributes, 6);
        this.f4350a = C0217a.m426a(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
        C0217a.m426a(context, typedArrayObtainStyledAttributes.getResourceId(7, 0));
        this.f4351b = C0217a.m426a(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        new Paint().setColor(colorStateListM4303d.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}

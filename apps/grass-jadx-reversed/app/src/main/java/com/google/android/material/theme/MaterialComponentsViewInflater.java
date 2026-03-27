package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import io.getgrass.www.R;
import p007B1.AbstractC0054n;
import p014D1.C0176a;
import p034K1.C0437x;
import p037L1.C0450a;
import p040M1.AbstractC0512a;
import p041N.AbstractC0514b;
import p098g.C1385x;
import p110k.C1564X;
import p110k.C1603m;
import p110k.C1607o;
import p110k.C1609p;
import p110k.C1629z;
import p126o1.AbstractC1805a;
import p144t0.AbstractC1919e;
import p144t0.AbstractC1920f;
import p153v1.C1976c;

/* JADX INFO: loaded from: classes.dex */
public class MaterialComponentsViewInflater extends C1385x {
    @Override // p098g.C1385x
    /* JADX INFO: renamed from: a */
    public final C1603m mo3221a(Context context, AttributeSet attributeSet) {
        return new C0437x(context, attributeSet);
    }

    @Override // p098g.C1385x
    /* JADX INFO: renamed from: b */
    public final C1607o mo3222b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // p098g.C1385x
    /* JADX INFO: renamed from: c */
    public final C1609p mo3223c(Context context, AttributeSet attributeSet) {
        return new C1976c(context, attributeSet);
    }

    @Override // p098g.C1385x
    /* JADX INFO: renamed from: d */
    public final C1629z mo3224d(Context context, AttributeSet attributeSet) {
        C0176a c0176a = new C0176a(AbstractC0512a.m1020a(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = c0176a.getContext();
        TypedArray typedArrayM216f = AbstractC0054n.m216f(context2, attributeSet, AbstractC1805a.f6238n, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (typedArrayM216f.hasValue(0)) {
            AbstractC0514b.m1024c(c0176a, AbstractC1920f.m4303d(context2, typedArrayM216f, 0));
        }
        c0176a.f414j = typedArrayM216f.getBoolean(1, false);
        typedArrayM216f.recycle();
        return c0176a;
    }

    @Override // p098g.C1385x
    /* JADX INFO: renamed from: e */
    public final C1564X mo3225e(Context context, AttributeSet attributeSet) {
        C0450a c0450a = new C0450a(AbstractC0512a.m1020a(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = c0450a.getContext();
        if (AbstractC1919e.m4297r(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = AbstractC1805a.f6241q;
            TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int iM987g = C0450a.m987g(context2, typedArrayObtainStyledAttributes, 1, 2);
            typedArrayObtainStyledAttributes.recycle();
            if (iM987g == -1) {
                TypedArray typedArrayObtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, -1);
                typedArrayObtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray typedArrayObtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, AbstractC1805a.f6240p);
                    int iM987g2 = C0450a.m987g(c0450a.getContext(), typedArrayObtainStyledAttributes3, 1, 2);
                    typedArrayObtainStyledAttributes3.recycle();
                    if (iM987g2 >= 0) {
                        c0450a.setLineHeight(iM987g2);
                    }
                }
            }
        }
        return c0450a;
    }
}

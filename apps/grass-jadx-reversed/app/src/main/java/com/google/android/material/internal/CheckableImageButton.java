package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import p007B1.C0041a;
import p007B1.C0043c;
import p029J.AbstractC0323S;
import p110k.C1621v;

/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends C1621v implements Checkable {

    /* JADX INFO: renamed from: k */
    public static final int[] f4423k = {R.attr.state_checked};

    /* JADX INFO: renamed from: h */
    public boolean f4424h;

    /* JADX INFO: renamed from: i */
    public boolean f4425i;

    /* JADX INFO: renamed from: j */
    public boolean f4426j;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, io.getgrass.www.R.attr.imageButtonStyle);
        this.f4425i = true;
        this.f4426j = true;
        AbstractC0323S.m701k(this, new C0041a(0, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f4424h;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        return this.f4424h ? View.mergeDrawableStates(super.onCreateDrawableState(i3 + 1), f4423k) : super.onCreateDrawableState(i3);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0043c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0043c c0043c = (C0043c) parcelable;
        super.onRestoreInstanceState(c0043c.f1425e);
        setChecked(c0043c.f110g);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0043c c0043c = new C0043c(super.onSaveInstanceState());
        c0043c.f110g = this.f4424h;
        return c0043c;
    }

    public void setCheckable(boolean z3) {
        if (this.f4425i != z3) {
            this.f4425i = z3;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z3) {
        if (!this.f4425i || this.f4424h == z3) {
            return;
        }
        this.f4424h = z3;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z3) {
        this.f4426j = z3;
    }

    @Override // android.view.View
    public void setPressed(boolean z3) {
        if (this.f4426j) {
            super.setPressed(z3);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f4424h);
    }
}

package p110k;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import io.getgrass.www.R;

/* JADX INFO: renamed from: k.C */
/* JADX INFO: loaded from: classes.dex */
public final class C1523C extends SeekBar {

    /* JADX INFO: renamed from: e */
    public final C1525D f5472e;

    public C1523C(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarStyle);
        AbstractC1561V0.m3628a(this, getContext());
        C1525D c1525d = new C1525D(this);
        this.f5472e = c1525d;
        c1525d.mo3569d(attributeSet, R.attr.seekBarStyle);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C1525D c1525d = this.f5472e;
        Drawable drawable = c1525d.f5474f;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        SeekBar seekBar = c1525d.f5473e;
        if (drawable.setState(seekBar.getDrawableState())) {
            seekBar.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f5472e.f5474f;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f5472e.m3571i(canvas);
    }
}

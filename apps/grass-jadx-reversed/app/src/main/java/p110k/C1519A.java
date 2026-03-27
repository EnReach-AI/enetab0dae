package p110k;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import io.getgrass.www.R;

/* JADX INFO: renamed from: k.A */
/* JADX INFO: loaded from: classes.dex */
public final class C1519A extends RatingBar {

    /* JADX INFO: renamed from: e */
    public final C1627y f5471e;

    public C1519A(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.ratingBarStyle);
        AbstractC1561V0.m3628a(this, getContext());
        C1627y c1627y = new C1627y(this);
        this.f5471e = c1627y;
        c1627y.mo3569d(attributeSet, R.attr.ratingBarStyle);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final synchronized void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        Bitmap bitmap = (Bitmap) this.f5471e.f5763c;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i3, 0), getMeasuredHeight());
        }
    }
}

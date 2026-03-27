package p147u;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: renamed from: u.n */
/* JADX INFO: loaded from: classes.dex */
public final class C1938n extends View {
    public C1938n(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int i3) {
        C1928d c1928d = (C1928d) getLayoutParams();
        c1928d.f6780a = i3;
        setLayoutParams(c1928d);
    }

    public void setGuidelineEnd(int i3) {
        C1928d c1928d = (C1928d) getLayoutParams();
        c1928d.f6782b = i3;
        setLayoutParams(c1928d);
    }

    public void setGuidelinePercent(float f3) {
        C1928d c1928d = (C1928d) getLayoutParams();
        c1928d.f6784c = f3;
        setLayoutParams(c1928d);
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
    }
}

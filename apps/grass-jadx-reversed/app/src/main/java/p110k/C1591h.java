package p110k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import io.getgrass.www.R;
import p009C.AbstractC0139b;
import p108j.C1468b;

/* JADX INFO: renamed from: k.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1591h extends AppCompatImageView implements InterfaceC1597j {

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ C1594i f5639h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1591h(C1594i c1594i, Context context) {
        super(context, null, R.attr.actionOverflowButtonStyle);
        this.f5639h = c1594i;
        setClickable(true);
        setFocusable(true);
        setVisibility(0);
        setEnabled(true);
        AbstractC1587f1.m3650a(this, getContentDescription());
        setOnTouchListener(new C1468b(this, this));
    }

    @Override // p110k.InterfaceC1597j
    /* JADX INFO: renamed from: a */
    public final boolean mo2219a() {
        return false;
    }

    @Override // p110k.InterfaceC1597j
    /* JADX INFO: renamed from: b */
    public final boolean mo2220b() {
        return false;
    }

    @Override // android.view.View
    public final boolean performClick() {
        if (super.performClick()) {
            return true;
        }
        playSoundEffect(0);
        this.f5639h.m3657l();
        return true;
    }

    @Override // android.widget.ImageView
    public final boolean setFrame(int i3, int i4, int i5, int i6) {
        boolean frame = super.setFrame(i3, i4, i5, i6);
        Drawable drawable = getDrawable();
        Drawable background = getBackground();
        if (drawable != null && background != null) {
            int width = getWidth();
            int height = getHeight();
            int iMax = Math.max(width, height) / 2;
            int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
            int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
            AbstractC0139b.m278f(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
        }
        return frame;
    }
}

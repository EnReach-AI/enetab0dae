package p110k;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* JADX INFO: renamed from: k.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1570a extends Drawable {

    /* JADX INFO: renamed from: a */
    public final ActionBarContainer f5595a;

    public C1570a(ActionBarContainer actionBarContainer) {
        this.f5595a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f5595a;
        if (actionBarContainer.f2687k) {
            Drawable drawable = actionBarContainer.f2686j;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2684h;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Drawable drawable3 = actionBarContainer.f2685i;
        if (drawable3 == null || !actionBarContainer.f2688l) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f5595a;
        if (actionBarContainer.f2687k) {
            if (actionBarContainer.f2686j != null) {
                actionBarContainer.f2684h.getOutline(outline);
            }
        } else {
            Drawable drawable = actionBarContainer.f2684h;
            if (drawable != null) {
                drawable.getOutline(outline);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}

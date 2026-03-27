package p091e0;

import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: e0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1322c implements Drawable.Callback {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C1325f f4686e;

    public C1322c(C1325f c1325f) {
        this.f4686e = c1325f;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        this.f4686e.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        this.f4686e.scheduleSelf(runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f4686e.unscheduleSelf(runnable);
    }
}

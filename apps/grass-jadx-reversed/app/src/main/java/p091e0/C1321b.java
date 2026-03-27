package p091e0;

import android.content.res.ColorStateList;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;
import p009C.AbstractC0139b;
import p153v1.C1974a;
import p153v1.C1976c;

/* JADX INFO: renamed from: e0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1321b extends Animatable2.AnimationCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1974a f4685a;

    public C1321b(C1974a c1974a) {
        this.f4685a = c1974a;
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationEnd(Drawable drawable) {
        ColorStateList colorStateList = this.f4685a.f6995b.f7013s;
        if (colorStateList != null) {
            AbstractC0139b.m280h(drawable, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Animatable2.AnimationCallback
    public final void onAnimationStart(Drawable drawable) {
        C1976c c1976c = this.f4685a.f6995b;
        ColorStateList colorStateList = c1976c.f7013s;
        if (colorStateList != null) {
            AbstractC0139b.m279g(drawable, colorStateList.getColorForState(c1976c.f7017w, colorStateList.getDefaultColor()));
        }
    }
}

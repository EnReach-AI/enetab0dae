package p091e0;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: e0.e */
/* JADX INFO: loaded from: classes.dex */
public final class C1324e extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a */
    public final Drawable.ConstantState f4691a;

    public C1324e(Drawable.ConstantState constantState) {
        this.f4691a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f4691a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f4691a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        C1325f c1325f = new C1325f(null);
        Drawable drawableNewDrawable = this.f4691a.newDrawable();
        c1325f.f4697e = drawableNewDrawable;
        drawableNewDrawable.setCallback(c1325f.f4696j);
        return c1325f;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        C1325f c1325f = new C1325f(null);
        Drawable drawableNewDrawable = this.f4691a.newDrawable(resources);
        c1325f.f4697e = drawableNewDrawable;
        drawableNewDrawable.setCallback(c1325f.f4696j);
        return c1325f;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        C1325f c1325f = new C1325f(null);
        Drawable drawableNewDrawable = this.f4691a.newDrawable(resources, theme);
        c1325f.f4697e = drawableNewDrawable;
        drawableNewDrawable.setCallback(c1325f.f4696j);
        return c1325f;
    }
}

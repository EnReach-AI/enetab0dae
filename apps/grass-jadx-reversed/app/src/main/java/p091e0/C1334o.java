package p091e0;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* JADX INFO: renamed from: e0.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1334o extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a */
    public final Drawable.ConstantState f4753a;

    public C1334o(Drawable.ConstantState constantState) {
        this.f4753a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.f4753a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f4753a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        C1335p c1335p = new C1335p();
        c1335p.f4697e = (VectorDrawable) this.f4753a.newDrawable();
        return c1335p;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        C1335p c1335p = new C1335p();
        c1335p.f4697e = (VectorDrawable) this.f4753a.newDrawable(resources);
        return c1335p;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        C1335p c1335p = new C1335p();
        c1335p.f4697e = (VectorDrawable) this.f4753a.newDrawable(resources, theme);
        return c1335p;
    }
}

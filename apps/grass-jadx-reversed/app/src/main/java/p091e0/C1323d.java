package p091e0;

import android.animation.AnimatorSet;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import p128p.C1808b;

/* JADX INFO: renamed from: e0.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1323d extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a */
    public C1335p f4687a;

    /* JADX INFO: renamed from: b */
    public AnimatorSet f4688b;

    /* JADX INFO: renamed from: c */
    public ArrayList f4689c;

    /* JADX INFO: renamed from: d */
    public C1808b f4690d;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        throw new IllegalStateException("No constant state support for SDK < 24.");
    }
}

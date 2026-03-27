package p157w1;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* JADX INFO: renamed from: w1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1993b extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Chip f7068a;

    public C1993b(Chip chip) {
        this.f7068a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        C1996e c1996e = this.f7068a.f4322i;
        if (c1996e != null) {
            c1996e.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}

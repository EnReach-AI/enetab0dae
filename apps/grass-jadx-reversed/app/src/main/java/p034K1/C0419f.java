package p034K1;

import com.google.android.material.internal.CheckableImageButton;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p125o0.AbstractC1800j;

/* JADX INFO: renamed from: K1.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0419f extends AbstractC0431r {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f959e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0419f(C0430q c0430q, int i3) {
        super(c0430q);
        this.f959e = i3;
    }

    @Override // p034K1.AbstractC0431r
    /* JADX INFO: renamed from: r */
    public void mo922r() {
        switch (this.f959e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0430q c0430q = this.f1012b;
                c0430q.f1003s = null;
                CheckableImageButton checkableImageButton = c0430q.f995k;
                checkableImageButton.setOnLongClickListener(null);
                AbstractC1800j.m3994l(checkableImageButton, null);
                break;
        }
    }
}

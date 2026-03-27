package p029J;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* JADX INFO: renamed from: J.k0 */
/* JADX INFO: loaded from: classes.dex */
public class C0352k0 extends AbstractC0350j0 {
    public C0352k0(C0364q0 c0364q0, WindowInsets windowInsets) {
        super(c0364q0, windowInsets);
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: a */
    public C0364q0 mo767a() {
        return C0364q0.m829g(this.f856c.consumeDisplayCutout(), null);
    }

    @Override // p029J.C0360o0
    /* JADX INFO: renamed from: e */
    public C0347i mo768e() {
        DisplayCutout displayCutout = this.f856c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new C0347i(displayCutout);
    }

    @Override // p029J.C0360o0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0352k0)) {
            return false;
        }
        C0352k0 c0352k0 = (C0352k0) obj;
        return Objects.equals(this.f856c, c0352k0.f856c) && Objects.equals(this.f860g, c0352k0.f860g);
    }

    @Override // p029J.C0360o0
    public int hashCode() {
        return this.f856c.hashCode();
    }
}

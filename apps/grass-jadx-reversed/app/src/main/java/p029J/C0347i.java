package p029J;

import android.view.DisplayCutout;
import p026I.AbstractC0294b;

/* JADX INFO: renamed from: J.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0347i {

    /* JADX INFO: renamed from: a */
    public final DisplayCutout f850a;

    public C0347i(DisplayCutout displayCutout) {
        this.f850a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0347i.class != obj.getClass()) {
            return false;
        }
        return AbstractC0294b.m569a(this.f850a, ((C0347i) obj).f850a);
    }

    public final int hashCode() {
        DisplayCutout displayCutout = this.f850a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f850a + "}";
    }
}

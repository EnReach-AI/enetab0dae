package p087d0;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: renamed from: d0.x */
/* JADX INFO: loaded from: classes.dex */
public final class C1305x {

    /* JADX INFO: renamed from: a */
    public final WindowId f4667a;

    public C1305x(View view) {
        this.f4667a = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1305x) && ((C1305x) obj).f4667a.equals(this.f4667a);
    }

    public final int hashCode() {
        return this.f4667a.hashCode();
    }
}

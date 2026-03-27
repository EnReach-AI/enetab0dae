package p125o0;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: o0.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1796f {

    /* JADX INFO: renamed from: a */
    public final WeakReference f6201a;

    /* JADX INFO: renamed from: b */
    public final String f6202b;

    public C1796f(View view, String str) {
        this.f6201a = new WeakReference(view);
        this.f6202b = str;
    }

    /* JADX INFO: renamed from: a */
    public final View m3959a() {
        WeakReference weakReference = this.f6201a;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }
}

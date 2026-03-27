package p160x0;

import android.webkit.ValueCallback;
import java.util.HashMap;

/* JADX INFO: renamed from: x0.d */
/* JADX INFO: loaded from: classes.dex */
public final class C2009d implements ValueCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C2010e f7160a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2011f f7161b;

    public C2009d(C2011f c2011f, C2010e c2010e) {
        this.f7161b = c2011f;
        this.f7160a = c2010e;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        ((HashMap) this.f7161b.f7169b).put(this.f7160a.f7163a, (String) obj);
    }
}

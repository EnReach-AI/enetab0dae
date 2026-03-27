package p068X;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* JADX INFO: renamed from: X.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0697b {

    /* JADX INFO: renamed from: a */
    public final IntentFilter f1894a;

    /* JADX INFO: renamed from: b */
    public final BroadcastReceiver f1895b;

    /* JADX INFO: renamed from: c */
    public boolean f1896c;

    /* JADX INFO: renamed from: d */
    public boolean f1897d;

    public C0697b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.f1894a = intentFilter;
        this.f1895b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f1895b);
        sb.append(" filter=");
        sb.append(this.f1894a);
        if (this.f1897d) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}

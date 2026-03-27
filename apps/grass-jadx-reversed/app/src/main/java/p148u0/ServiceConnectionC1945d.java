package p148u0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: u0.d */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1945d implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    public final CountDownLatch f6940a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b */
    public IBinder f6941b;

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName componentName) {
        this.f6940a.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f6941b = iBinder;
        this.f6940a.countDown();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}

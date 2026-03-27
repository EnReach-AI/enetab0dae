package p141s0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: s0.l */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1882l implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        AbstractC1883m.f6624g = AbstractC1884n.m4209e(AbstractC1117n.f3882h, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}

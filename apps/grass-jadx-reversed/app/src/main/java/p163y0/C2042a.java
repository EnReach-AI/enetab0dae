package p163y0;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;

/* JADX INFO: renamed from: y0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C2042a implements NsdManager.RegistrationListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f7247a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f7248b;

    public C2042a(String str, String str2) {
        this.f7247a = str;
        this.f7248b = str2;
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i3) {
        AbstractC2043b.m4507a(this.f7248b);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onServiceRegistered(NsdServiceInfo nsdServiceInfo) {
        if (this.f7247a.equals(nsdServiceInfo.getServiceName())) {
            return;
        }
        AbstractC2043b.m4507a(this.f7248b);
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
    }

    @Override // android.net.nsd.NsdManager.RegistrationListener
    public final void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i3) {
    }
}

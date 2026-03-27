package p111k0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.ReferrerDetails;
import java.util.List;
import p020F2.AbstractC0223a;
import p122n1.C1780a;
import p122n1.InterfaceC1782c;
import p160x0.C2011f;

/* JADX INFO: renamed from: k0.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1632b extends InstallReferrerClient {

    /* JADX INFO: renamed from: a */
    public int f5799a = 0;

    /* JADX INFO: renamed from: b */
    public final Context f5800b;

    /* JADX INFO: renamed from: c */
    public InterfaceC1782c f5801c;

    /* JADX INFO: renamed from: d */
    public ServiceConnectionC1631a f5802d;

    public C1632b(Context context) {
        this.f5800b = context.getApplicationContext();
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    /* JADX INFO: renamed from: a */
    public final ReferrerDetails mo2843a() throws RemoteException {
        if (this.f5799a != 2 || this.f5801c == null || this.f5802d == null) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f5800b.getPackageName());
        try {
            return new ReferrerDetails(((C1780a) this.f5801c).m3943a(bundle));
        } catch (RemoteException e3) {
            AbstractC0223a.m471h("RemoteException getting install referrer information");
            this.f5799a = 0;
            throw e3;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3708b(C2011f c2011f) {
        ServiceInfo serviceInfo;
        int i3 = this.f5799a;
        if ((i3 != 2 || this.f5801c == null || this.f5802d == null) ? false : true) {
            AbstractC0223a.m470g("Service connection is valid. No need to re-initialize.");
            c2011f.m4465c(0);
            return;
        }
        if (i3 == 1) {
            AbstractC0223a.m471h("Client is already in the process of connecting to the service.");
            c2011f.m4465c(3);
            return;
        }
        if (i3 == 3) {
            AbstractC0223a.m471h("Client was already closed and can't be reused. Please create another instance.");
            c2011f.m4465c(3);
            return;
        }
        AbstractC0223a.m470g("Starting install referrer service setup.");
        this.f5802d = new ServiceConnectionC1631a(this, c2011f);
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        Context context = this.f5800b;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.f5799a = 0;
            AbstractC0223a.m470g("Install Referrer service unavailable on device.");
            c2011f.m4465c(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if ("com.android.vending".equals(str) && str2 != null) {
            try {
                if (context.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                    if (context.bindService(new Intent(intent), this.f5802d, 1)) {
                        AbstractC0223a.m470g("Service was bonded successfully.");
                        return;
                    }
                    AbstractC0223a.m471h("Connection to service is blocked.");
                    this.f5799a = 0;
                    c2011f.m4465c(1);
                    return;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        AbstractC0223a.m471h("Play Store missing or incompatible. Version 8.3.73 or later required.");
        this.f5799a = 0;
        c2011f.m4465c(2);
    }
}

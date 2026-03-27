package p111k0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.android.installreferrer.api.InstallReferrerStateListener;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p020F2.AbstractC0223a;
import p122n1.AbstractBinderC1781b;
import p122n1.C1780a;
import p122n1.InterfaceC1782c;
import p160x0.C2011f;

/* JADX INFO: renamed from: k0.a */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC1631a implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5796a;

    /* JADX INFO: renamed from: b */
    public final Object f5797b;

    /* JADX INFO: renamed from: c */
    public final Object f5798c;

    public ServiceConnectionC1631a(C1632b c1632b, C2011f c2011f) {
        this.f5796a = 0;
        this.f5798c = c1632b;
        this.f5797b = c2011f;
    }

    /* JADX INFO: renamed from: b */
    private final void m3706b(ComponentName componentName) {
    }

    /* JADX INFO: renamed from: a */
    public IBinder m3707a() {
        if (((AtomicBoolean) this.f5797b).compareAndSet(true, true)) {
            throw new IllegalStateException("Binder already consumed");
        }
        return (IBinder) ((LinkedBlockingDeque) this.f5798c).take();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC1782c interfaceC1782c;
        Object obj = this.f5798c;
        switch (this.f5796a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0223a.m470g("Install Referrer service connected.");
                int i3 = AbstractBinderC1781b.f6163a;
                if (iBinder == null) {
                    interfaceC1782c = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1782c)) {
                        C1780a c1780a = new C1780a();
                        c1780a.f6162a = iBinder;
                        interfaceC1782c = c1780a;
                    } else {
                        interfaceC1782c = (InterfaceC1782c) iInterfaceQueryLocalInterface;
                    }
                }
                C1632b c1632b = (C1632b) obj;
                c1632b.f5801c = interfaceC1782c;
                c1632b.f5799a = 2;
                ((C2011f) ((InstallReferrerStateListener) this.f5797b)).m4465c(0);
                break;
            default:
                if (iBinder != null) {
                    try {
                        ((LinkedBlockingDeque) obj).put(iBinder);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        switch (this.f5796a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0223a.m471h("Install Referrer service disconnected.");
                C1632b c1632b = (C1632b) this.f5798c;
                c1632b.f5801c = null;
                c1632b.f5799a = 0;
                ((InstallReferrerStateListener) this.f5797b).getClass();
                break;
        }
    }

    public ServiceConnectionC1631a() {
        this.f5796a = 1;
        this.f5797b = new AtomicBoolean(false);
        this.f5798c = new LinkedBlockingDeque();
    }
}

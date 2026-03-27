package p027I0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: I0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0299b extends Binder implements InterfaceC0300c {
    /* JADX INFO: renamed from: a */
    public static InterfaceC0300c m574a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.facebook.ppml.receiver.IReceiverService");
        if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof InterfaceC0300c)) {
            return (InterfaceC0300c) iInterfaceQueryLocalInterface;
        }
        C0298a c0298a = new C0298a();
        c0298a.f799a = iBinder;
        return c0298a;
    }
}

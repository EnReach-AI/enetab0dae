package p068X;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.C0009j;
import p010C0.AbstractC0147a;
import p024H0.ServiceConnectionC0258l;

/* JADX INFO: renamed from: X.a */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC0696a extends Handler {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1892a = 1;

    /* JADX INFO: renamed from: b */
    public Object f1893b;

    public /* synthetic */ HandlerC0696a() {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int size;
        C0009j[] c0009jArr;
        switch (this.f1892a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                C0698c c0698c = (C0698c) this.f1893b;
                while (true) {
                    synchronized (c0698c.f1901b) {
                        try {
                            size = c0698c.f1903d.size();
                            if (size <= 0) {
                                return;
                            }
                            c0009jArr = new C0009j[size];
                            c0698c.f1903d.toArray(c0009jArr);
                            c0698c.f1903d.clear();
                        } finally {
                        }
                    }
                    for (int i3 = 0; i3 < size; i3++) {
                        C0009j c0009j = c0009jArr[i3];
                        int size2 = ((ArrayList) c0009j.f31g).size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            C0697b c0697b = (C0697b) ((ArrayList) c0009j.f31g).get(i4);
                            if (!c0697b.f1897d) {
                                c0697b.f1895b.onReceive(c0698c.f1900a, (Intent) c0009j.f30f);
                            }
                        }
                    }
                }
                break;
            case 1:
                int i5 = message.what;
                if (i5 == -3 || i5 == -2 || i5 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.f1893b).get(), message.what);
                    return;
                } else {
                    if (i5 != 1) {
                        return;
                    }
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
            default:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    ServiceConnectionC0258l serviceConnectionC0258l = (ServiceConnectionC0258l) this.f1893b;
                    serviceConnectionC0258l.getClass();
                    if (message.what == serviceConnectionC0258l.f649g) {
                        Bundle data = message.getData();
                        if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                            serviceConnectionC0258l.m503a(null);
                        } else {
                            serviceConnectionC0258l.m503a(data);
                        }
                        try {
                            serviceConnectionC0258l.f643a.unbindService(serviceConnectionC0258l);
                            return;
                        } catch (IllegalArgumentException unused) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, this);
                    return;
                }
        }
    }

    public HandlerC0696a(ServiceConnectionC0258l serviceConnectionC0258l) {
        this.f1893b = serviceConnectionC0258l;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0696a(C0698c c0698c, Looper looper) {
        super(looper);
        this.f1893b = c0698c;
    }
}

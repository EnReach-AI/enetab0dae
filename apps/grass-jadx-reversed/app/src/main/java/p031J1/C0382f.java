package p031J1;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import p032K.C0391i;
import p032K.C0392j;

/* JADX INFO: renamed from: J1.f */
/* JADX INFO: loaded from: classes.dex */
public class C0382f {

    /* JADX INFO: renamed from: b */
    public static C0382f f902b;

    /* JADX INFO: renamed from: a */
    public final Object f903a;

    public /* synthetic */ C0382f(Object obj) {
        this.f903a = obj;
    }

    /* JADX INFO: renamed from: a */
    public C0391i mo846a(int i3) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public C0391i mo847b(int i3) {
        return null;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo848c(int i3, int i4, Bundle bundle) {
        return false;
    }

    public C0382f(int i3) {
        switch (i3) {
            case 1:
                this.f903a = new C0392j(this);
                break;
            default:
                this.f903a = new Object();
                new Handler(Looper.getMainLooper(), new C0381e(this));
                break;
        }
    }
}

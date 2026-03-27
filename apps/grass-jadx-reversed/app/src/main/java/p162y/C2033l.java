package p162y;

import android.app.Notification;
import android.os.Parcel;
import p005B.AbstractC0032g;
import p076a.C0839a;
import p076a.InterfaceC0841c;

/* JADX INFO: renamed from: y.l */
/* JADX INFO: loaded from: classes.dex */
public final class C2033l {

    /* JADX INFO: renamed from: a */
    public final String f7220a;

    /* JADX INFO: renamed from: b */
    public final int f7221b;

    /* JADX INFO: renamed from: c */
    public final String f7222c = null;

    /* JADX INFO: renamed from: d */
    public final Notification f7223d;

    public C2033l(String str, int i3, Notification notification) {
        this.f7220a = str;
        this.f7221b = i3;
        this.f7223d = notification;
    }

    /* JADX INFO: renamed from: a */
    public final void m4495a(InterfaceC0841c interfaceC0841c) {
        String str = this.f7220a;
        int i3 = this.f7221b;
        String str2 = this.f7222c;
        C0839a c0839a = (C0839a) interfaceC0841c;
        c0839a.getClass();
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
            parcelObtain.writeString(str);
            parcelObtain.writeInt(i3);
            parcelObtain.writeString(str2);
            Notification notification = this.f7223d;
            if (notification != null) {
                parcelObtain.writeInt(1);
                notification.writeToParcel(parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            c0839a.f2506a.transact(1, parcelObtain, null, 1);
        } finally {
            parcelObtain.recycle();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NotifyTask[packageName:");
        sb.append(this.f7220a);
        sb.append(", id:");
        sb.append(this.f7221b);
        sb.append(", tag:");
        return AbstractC0032g.m157o(sb, this.f7222c, "]");
    }
}

package p162y;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.facebook.C1100C;
import java.util.ArrayList;

/* JADX INFO: renamed from: y.j */
/* JADX INFO: loaded from: classes.dex */
public final class C2031j {

    /* JADX INFO: renamed from: a */
    public final Context f7199a;

    /* JADX INFO: renamed from: e */
    public CharSequence f7203e;

    /* JADX INFO: renamed from: f */
    public CharSequence f7204f;

    /* JADX INFO: renamed from: g */
    public PendingIntent f7205g;

    /* JADX INFO: renamed from: h */
    public Bitmap f7206h;

    /* JADX INFO: renamed from: i */
    public int f7207i;

    /* JADX INFO: renamed from: k */
    public C2030i f7209k;

    /* JADX INFO: renamed from: l */
    public CharSequence f7210l;

    /* JADX INFO: renamed from: m */
    public String f7211m;

    /* JADX INFO: renamed from: n */
    public boolean f7212n;

    /* JADX INFO: renamed from: o */
    public Bundle f7213o;

    /* JADX INFO: renamed from: r */
    public final String f7216r;

    /* JADX INFO: renamed from: s */
    public final boolean f7217s;

    /* JADX INFO: renamed from: t */
    public final Notification f7218t;

    /* JADX INFO: renamed from: u */
    public final ArrayList f7219u;

    /* JADX INFO: renamed from: b */
    public final ArrayList f7200b = new ArrayList();

    /* JADX INFO: renamed from: c */
    public final ArrayList f7201c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public final ArrayList f7202d = new ArrayList();

    /* JADX INFO: renamed from: j */
    public boolean f7208j = true;

    /* JADX INFO: renamed from: p */
    public int f7214p = 0;

    /* JADX INFO: renamed from: q */
    public int f7215q = 0;

    public C2031j(Context context, String str) {
        Notification notification = new Notification();
        this.f7218t = notification;
        this.f7199a = context;
        this.f7216r = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f7207i = 0;
        this.f7219u = new ArrayList();
        this.f7217s = true;
    }

    /* JADX INFO: renamed from: b */
    public static CharSequence m4488b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    /* JADX INFO: renamed from: a */
    public final Notification m4489a() {
        Bundle bundle;
        C1100C c1100c = new C1100C(this);
        C2031j c2031j = (C2031j) c1100c.f3800g;
        C2030i c2030i = c2031j.f7209k;
        if (c2030i != null) {
            c2030i.m4486b(c1100c);
        }
        Notification notificationBuild = ((Notification.Builder) c1100c.f3799f).build();
        if (c2030i != null) {
            c2031j.f7209k.getClass();
        }
        if (c2030i != null && (bundle = notificationBuild.extras) != null) {
            c2030i.m4485a(bundle);
        }
        return notificationBuild;
    }

    /* JADX INFO: renamed from: c */
    public final void m4490c(int i3, boolean z3) {
        Notification notification = this.f7218t;
        if (z3) {
            notification.flags = i3 | notification.flags;
        } else {
            notification.flags = (~i3) & notification.flags;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m4491d(C2030i c2030i) {
        if (this.f7209k != c2030i) {
            this.f7209k = c2030i;
            if (c2030i.f7193a != this) {
                c2030i.f7193a = this;
                m4491d(c2030i);
            }
        }
    }
}

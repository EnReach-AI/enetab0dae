package p162y;

import android.app.Notification;
import android.os.Bundle;
import com.facebook.C1100C;
import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: y.i */
/* JADX INFO: loaded from: classes.dex */
public final class C2030i {

    /* JADX INFO: renamed from: a */
    public C2031j f7193a;

    /* JADX INFO: renamed from: b */
    public CharSequence f7194b;

    /* JADX INFO: renamed from: c */
    public CharSequence f7195c;

    /* JADX INFO: renamed from: d */
    public boolean f7196d = false;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f7197e;

    /* JADX INFO: renamed from: f */
    public Object f7198f;

    public C2030i(int i3) {
        this.f7197e = i3;
    }

    /* JADX INFO: renamed from: a */
    public void m4485a(Bundle bundle) {
        if (this.f7196d) {
            bundle.putCharSequence("android.summaryText", this.f7195c);
        }
        CharSequence charSequence = this.f7194b;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", m4487c());
    }

    /* JADX INFO: renamed from: b */
    public final void m4486b(C1100C c1100c) {
        switch (this.f7197e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle((Notification.Builder) c1100c.f3799f).setBigContentTitle(this.f7194b).bigText((CharSequence) this.f7198f);
                if (this.f7196d) {
                    bigTextStyleBigText.setSummaryText(this.f7195c);
                }
                break;
            default:
                Notification.InboxStyle bigContentTitle = new Notification.InboxStyle((Notification.Builder) c1100c.f3799f).setBigContentTitle(this.f7194b);
                if (this.f7196d) {
                    bigContentTitle.setSummaryText(this.f7195c);
                }
                Iterator it = ((ArrayList) this.f7198f).iterator();
                while (it.hasNext()) {
                    bigContentTitle.addLine((CharSequence) it.next());
                }
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    public final String m4487c() {
        switch (this.f7197e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return "androidx.core.app.NotificationCompat$BigTextStyle";
            default:
                return "androidx.core.app.NotificationCompat$InboxStyle";
        }
    }
}

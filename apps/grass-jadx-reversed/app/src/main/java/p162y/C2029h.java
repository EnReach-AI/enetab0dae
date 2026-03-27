package p162y;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import p009C.AbstractC0143f;

/* JADX INFO: renamed from: y.h */
/* JADX INFO: loaded from: classes.dex */
public final class C2029h {

    /* JADX INFO: renamed from: a */
    public final Bundle f7184a;

    /* JADX INFO: renamed from: b */
    public IconCompat f7185b;

    /* JADX INFO: renamed from: c */
    public final C2041t[] f7186c;

    /* JADX INFO: renamed from: d */
    public final boolean f7187d;

    /* JADX INFO: renamed from: e */
    public final boolean f7188e;

    /* JADX INFO: renamed from: f */
    public final int f7189f;

    /* JADX INFO: renamed from: g */
    public final int f7190g;

    /* JADX INFO: renamed from: h */
    public final CharSequence f7191h;

    /* JADX INFO: renamed from: i */
    public final PendingIntent f7192i;

    public C2029h(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C2041t[] c2041tArr, C2041t[] c2041tArr2) {
        this.f7188e = true;
        this.f7185b = iconCompat;
        if (iconCompat != null) {
            int i3 = iconCompat.f2922a;
            if ((i3 == -1 ? AbstractC0143f.m291c(iconCompat.f2923b) : i3) == 2) {
                this.f7190g = iconCompat.m2317b();
            }
        }
        this.f7191h = C2031j.m4488b(charSequence);
        this.f7192i = pendingIntent;
        this.f7184a = bundle == null ? new Bundle() : bundle;
        this.f7186c = c2041tArr;
        this.f7187d = true;
        this.f7189f = 0;
        this.f7188e = true;
    }
}

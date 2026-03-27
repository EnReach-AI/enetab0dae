package p005B;

import android.content.res.Resources;
import android.os.Build;
import android.support.v4.media.session.AbstractC0864a;
import p128p.C1812f;

/* JADX INFO: renamed from: B.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0034i {

    /* JADX INFO: renamed from: a */
    public static final AbstractC0864a f88a;

    /* JADX INFO: renamed from: b */
    public static final C1812f f89b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f88a = new C0036k();
        } else {
            f88a = new C0035j();
        }
        f89b = new C1812f(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface m170a(android.content.Context r15, p001A.InterfaceC0005f r16, android.content.res.Resources r17, int r18, java.lang.String r19, int r20, int r21, p001A.AbstractC0001b r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p005B.AbstractC0034i.m170a(android.content.Context, A.f, android.content.res.Resources, int, java.lang.String, int, int, A.b, boolean):android.graphics.Typeface");
    }

    /* JADX INFO: renamed from: b */
    public static String m171b(Resources resources, int i3, String str, int i4, int i5) {
        return resources.getResourcePackageName(i3) + '-' + str + '-' + i4 + '-' + i3 + '-' + i5;
    }
}

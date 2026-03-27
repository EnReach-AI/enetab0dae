package p166z0;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.TreeSet;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: z0.x */
/* JADX INFO: loaded from: classes.dex */
public final class C2086x {

    /* JADX INFO: renamed from: a */
    public TreeSet f7379a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7380b;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #1 {all -> 0x000e, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x0010, B:19:0x0027, B:18:0x0024, B:15:0x001e), top: B:26:0x0003, inners: #0 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void m4629a(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L10
            java.util.TreeSet r3 = r2.f7379a     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L10
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> Le
            if (r3 == 0) goto L29
            goto L10
        Le:
            r3 = move-exception
            goto L2b
        L10:
            java.util.ArrayList r3 = p166z0.AbstractC2087y.f7381a     // Catch: java.lang.Throwable -> Le
            java.util.Set r3 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> Le
            java.lang.Class<z0.y> r0 = p166z0.AbstractC2087y.class
            boolean r3 = r3.contains(r0)     // Catch: java.lang.Throwable -> Le
            r1 = 0
            if (r3 == 0) goto L1e
            goto L27
        L1e:
            java.util.TreeSet r1 = p166z0.AbstractC2087y.m4636e(r2)     // Catch: java.lang.Throwable -> L23
            goto L27
        L23:
            r3 = move-exception
            p010C0.AbstractC0147a.m295a(r3, r0)     // Catch: java.lang.Throwable -> Le
        L27:
            r2.f7379a = r1     // Catch: java.lang.Throwable -> Le
        L29:
            monitor-exit(r2)
            return
        L2b:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p166z0.C2086x.m4629a(boolean):void");
    }

    /* JADX INFO: renamed from: b */
    public final String m4630b() {
        switch (this.f7380b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return null;
            case 1:
                return "com.facebook.lite.platform.LoginGDPDialogActivity";
            case 2:
                return "com.facebook.katana.ProxyAuth";
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return null;
            default:
                return "com.facebook.katana.ProxyAuth";
        }
    }

    /* JADX INFO: renamed from: c */
    public final String m4631c() {
        switch (this.f7380b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return "com.facebook.arstudio.player";
            case 1:
                return "com.facebook.lite";
            case 2:
                return "com.facebook.katana";
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return "com.facebook.orca";
            default:
                return "com.facebook.wakizashi";
        }
    }
}

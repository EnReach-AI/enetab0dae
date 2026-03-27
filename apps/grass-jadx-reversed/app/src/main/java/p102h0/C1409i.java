package p102h0;

import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p099g0.AbstractC1391d;

/* JADX INFO: renamed from: h0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1409i extends AbstractC1403c {

    /* JADX INFO: renamed from: d */
    public final Pattern f5035d;

    public C1409i() {
        super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        this.f5035d = Pattern.compile("\\A\\d+");
    }

    @Override // p102h0.AbstractC1403c
    /* JADX INFO: renamed from: a */
    public final boolean mo3407a() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @Override // p102h0.AbstractC1403c
    /* JADX INFO: renamed from: b */
    public final boolean mo3408b() {
        boolean zMo3408b = super.mo3408b();
        if (!zMo3408b || Build.VERSION.SDK_INT >= 29) {
            return zMo3408b;
        }
        int i3 = AbstractC1391d.f5021a;
        PackageInfo packageInfoM3409a = AbstractC1404d.m3409a();
        if (packageInfoM3409a == null) {
            return false;
        }
        Matcher matcher = this.f5035d.matcher(packageInfoM3409a.versionName);
        return matcher.find() && Integer.parseInt(packageInfoM3409a.versionName.substring(matcher.start(), matcher.end())) >= 105;
    }
}

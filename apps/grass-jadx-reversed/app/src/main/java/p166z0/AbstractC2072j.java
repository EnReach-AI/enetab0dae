package p166z0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;

/* JADX INFO: renamed from: z0.j */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2072j {

    /* JADX INFO: renamed from: a */
    public static final HashSet f7317a;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
        hashSet.add("cc2751449a350f668590264ed76692694a80308a");
        hashSet.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
        hashSet.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
        hashSet.add("df6b721c8b4d3b6eb44c861d4415007e5a35fc95");
        hashSet.add("9b8f518b086098de3d77736f9458a3d2f6f95a37");
        hashSet.add("2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3");
        f7317a = hashSet;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m4609a(Context context, String str) {
        String str2 = Build.BRAND;
        int i3 = context.getApplicationInfo().flags;
        if (str2.startsWith("generic") && (i3 & 2) != 0) {
            return true;
        }
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            if (signatureArr != null && signatureArr.length > 0) {
                for (Signature signature : signatureArr) {
                    if (!f7317a.contains(AbstractC2056E.m4547p("SHA-1", signature.toByteArray()))) {
                        return false;
                    }
                }
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }
}

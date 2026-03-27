package p102h0;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: renamed from: h0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1403c implements InterfaceC1406f {

    /* JADX INFO: renamed from: c */
    public static final HashSet f5030c = new HashSet();

    /* JADX INFO: renamed from: a */
    public final String f5031a;

    /* JADX INFO: renamed from: b */
    public final String f5032b;

    public AbstractC1403c(String str, String str2) {
        this.f5031a = str;
        this.f5032b = str2;
        f5030c.add(this);
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo3407a();

    /* JADX INFO: renamed from: b */
    public boolean mo3408b() {
        HashSet hashSet = AbstractC1401a.f5028a;
        String str = this.f5032b;
        if (!hashSet.contains(str)) {
            String str2 = Build.TYPE;
            if ("eng".equals(str2) || "userdebug".equals(str2)) {
                if (hashSet.contains(str + ":dev")) {
                }
            }
            return false;
        }
        return true;
    }
}

package p162y;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;

/* JADX INFO: renamed from: y.p */
/* JADX INFO: loaded from: classes.dex */
public final class C2037p {

    /* JADX INFO: renamed from: d */
    public static String f7236d;

    /* JADX INFO: renamed from: g */
    public static ServiceConnectionC2036o f7239g;

    /* JADX INFO: renamed from: a */
    public final Context f7240a;

    /* JADX INFO: renamed from: b */
    public final NotificationManager f7241b;

    /* JADX INFO: renamed from: c */
    public static final Object f7235c = new Object();

    /* JADX INFO: renamed from: e */
    public static HashSet f7237e = new HashSet();

    /* JADX INFO: renamed from: f */
    public static final Object f7238f = new Object();

    public C2037p(Context context) {
        this.f7240a = context;
        this.f7241b = (NotificationManager) context.getSystemService("notification");
    }
}

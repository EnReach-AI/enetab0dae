package p042N0;

/* JADX INFO: renamed from: N0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0534b {

    /* JADX INFO: renamed from: a */
    public static final C0533a f1227a;

    /* JADX INFO: renamed from: b */
    public static final C0533a f1228b;

    /* JADX INFO: renamed from: c */
    public static final C0533a f1229c;

    /* JADX INFO: renamed from: d */
    public static final C0533a f1230d;

    static {
        C0533a c0533a = new C0533a("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
        f1227a = c0533a;
        f1228b = new C0533a(c0533a, "MIME-NO-LINEFEEDS", true, '=', c0533a.f1226l, Integer.MAX_VALUE);
        f1229c = new C0533a(c0533a, "PEM", true, '=', c0533a.f1226l, 64);
        StringBuilder sb = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
        sb.setCharAt(sb.indexOf("+"), '-');
        sb.setCharAt(sb.indexOf("/"), '_');
        f1230d = new C0533a("MODIFIED-FOR-URL", sb.toString(), false, (char) 0, Integer.MAX_VALUE);
    }
}

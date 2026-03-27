package p099g0;

/* JADX INFO: renamed from: g0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1390c {

    /* JADX INFO: renamed from: a */
    public final boolean f5017a;

    /* JADX INFO: renamed from: b */
    public final String f5018b;

    /* JADX INFO: renamed from: c */
    public final String f5019c;

    /* JADX INFO: renamed from: d */
    public final C1389b f5020d;

    public C1390c(String str, String str2, C1389b c1389b) {
        if (str2.isEmpty() || str2.charAt(0) != '/') {
            throw new IllegalArgumentException("Path should start with a slash '/'.");
        }
        if (!str2.endsWith("/")) {
            throw new IllegalArgumentException("Path should end with a slash '/'");
        }
        this.f5018b = str;
        this.f5019c = str2;
        this.f5017a = false;
        this.f5020d = c1389b;
    }
}

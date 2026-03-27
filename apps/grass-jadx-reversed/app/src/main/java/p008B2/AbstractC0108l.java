package p008B2;

/* JADX INFO: renamed from: B2.l */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0108l {

    /* JADX INFO: renamed from: a */
    public static final boolean f299a;

    static {
        boolean z3;
        try {
            Class.forName("java.lang.ClassValue");
            z3 = true;
        } catch (Throwable unused) {
            z3 = false;
        }
        f299a = z3;
    }
}

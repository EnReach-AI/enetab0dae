package p104h2;

/* JADX INFO: renamed from: h2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1432a {

    /* JADX INFO: renamed from: a */
    public static final Integer f5076a;

    static {
        Object obj;
        Integer num = null;
        try {
            obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Throwable unused) {
        }
        Integer num2 = obj instanceof Integer ? (Integer) obj : null;
        if (num2 != null && num2.intValue() > 0) {
            num = num2;
        }
        f5076a = num;
    }
}

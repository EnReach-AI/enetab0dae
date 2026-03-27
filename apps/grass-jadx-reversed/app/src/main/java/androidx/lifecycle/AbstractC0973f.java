package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0973f {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f3315a;

    static {
        int[] iArr = new int[EnumC0978k.values().length];
        f3315a = iArr;
        try {
            iArr[EnumC0978k.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3315a[EnumC0978k.ON_START.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3315a[EnumC0978k.ON_RESUME.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3315a[EnumC0978k.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f3315a[EnumC0978k.ON_STOP.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f3315a[EnumC0978k.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f3315a[EnumC0978k.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}

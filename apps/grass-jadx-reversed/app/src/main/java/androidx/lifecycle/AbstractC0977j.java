package androidx.lifecycle;

/* JADX INFO: renamed from: androidx.lifecycle.j */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0977j {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int[] f3316a;

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int[] f3317b;

    static {
        int[] iArr = new int[EnumC0978k.values().length];
        f3317b = iArr;
        try {
            iArr[EnumC0978k.ON_CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3317b[EnumC0978k.ON_STOP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3317b[EnumC0978k.ON_START.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3317b[EnumC0978k.ON_PAUSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f3317b[EnumC0978k.ON_RESUME.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f3317b[EnumC0978k.ON_DESTROY.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f3317b[EnumC0978k.ON_ANY.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        int[] iArr2 = new int[EnumC0979l.values().length];
        f3316a = iArr2;
        try {
            iArr2[2] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f3316a[3] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f3316a[4] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f3316a[0] = 4;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f3316a[1] = 5;
        } catch (NoSuchFieldError unused12) {
        }
    }
}

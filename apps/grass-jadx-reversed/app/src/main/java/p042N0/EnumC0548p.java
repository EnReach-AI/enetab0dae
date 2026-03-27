package p042N0;

/* JADX INFO: renamed from: N0.p */
/* JADX INFO: loaded from: classes.dex */
public enum EnumC0548p {
    NOT_AVAILABLE(null, -1),
    START_OBJECT("{", 1),
    END_OBJECT("}", 2),
    START_ARRAY("[", 3),
    END_ARRAY("]", 4),
    FIELD_NAME(null, 5),
    VALUE_EMBEDDED_OBJECT(null, 12),
    VALUE_STRING(null, 6),
    VALUE_NUMBER_INT(null, 7),
    VALUE_NUMBER_FLOAT(null, 8),
    VALUE_TRUE("true", 9),
    VALUE_FALSE("false", 10),
    VALUE_NULL("null", 11);


    /* JADX INFO: renamed from: e */
    public final String f1325e;

    /* JADX INFO: renamed from: f */
    public final char[] f1326f;

    /* JADX INFO: renamed from: g */
    public final byte[] f1327g;

    /* JADX INFO: renamed from: h */
    public final int f1328h;

    /* JADX INFO: renamed from: i */
    public final boolean f1329i;

    /* JADX INFO: renamed from: j */
    public final boolean f1330j;

    /* JADX INFO: renamed from: k */
    public final boolean f1331k;

    /* JADX INFO: renamed from: l */
    public final boolean f1332l;

    EnumC0548p(String str, int i3) {
        boolean z3 = false;
        if (str == null) {
            this.f1325e = null;
            this.f1326f = null;
            this.f1327g = null;
        } else {
            this.f1325e = str;
            char[] charArray = str.toCharArray();
            this.f1326f = charArray;
            int length = charArray.length;
            this.f1327g = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                this.f1327g[i4] = (byte) this.f1326f[i4];
            }
        }
        this.f1328h = i3;
        if (i3 != 10) {
        }
        this.f1331k = i3 == 7 || i3 == 8;
        boolean z4 = i3 == 1 || i3 == 3;
        this.f1329i = z4;
        boolean z5 = i3 == 2 || i3 == 4;
        this.f1330j = z5;
        if (!z4 && !z5 && i3 != 5 && i3 != -1) {
            z3 = true;
        }
        this.f1332l = z3;
    }
}

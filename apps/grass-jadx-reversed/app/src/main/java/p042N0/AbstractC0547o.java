package p042N0;

import p050Q0.AbstractC0589b;

/* JADX INFO: renamed from: N0.o */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0547o {

    /* JADX INFO: renamed from: a */
    public int f1308a;

    /* JADX INFO: renamed from: b */
    public int f1309b;

    /* JADX INFO: renamed from: c */
    public int f1310c;

    public AbstractC0547o(AbstractC0547o abstractC0547o) {
        this.f1308a = abstractC0547o.f1308a;
        this.f1309b = abstractC0547o.f1309b;
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo1213a();

    /* JADX INFO: renamed from: b */
    public abstract Object mo1214b();

    /* JADX INFO: renamed from: c */
    public abstract AbstractC0547o mo1215c();

    /* JADX INFO: renamed from: d */
    public final boolean m1216d() {
        return this.f1308a == 1;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m1217e() {
        return this.f1308a == 2;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m1218f() {
        return this.f1308a == 0;
    }

    /* JADX INFO: renamed from: g */
    public abstract void mo1219g(Object obj);

    /* JADX INFO: renamed from: h */
    public final String m1220h() {
        int i3 = this.f1308a;
        return i3 != 0 ? i3 != 1 ? i3 != 2 ? "?" : "Object" : "Array" : "root";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i3 = this.f1308a;
        if (i3 != 0) {
            if (i3 != 1) {
                sb.append('{');
                String strMo1213a = mo1213a();
                if (strMo1213a != null) {
                    sb.append('\"');
                    int[] iArr = AbstractC0589b.f1509j;
                    int length = iArr.length;
                    int length2 = strMo1213a.length();
                    while (i < length2) {
                        char cCharAt = strMo1213a.charAt(i);
                        if (cCharAt >= length || iArr[cCharAt] == 0) {
                            sb.append(cCharAt);
                        } else {
                            sb.append('\\');
                            int i4 = iArr[cCharAt];
                            if (i4 < 0) {
                                sb.append("u00");
                                char[] cArr = AbstractC0589b.f1500a;
                                sb.append(cArr[cCharAt >> 4]);
                                sb.append(cArr[cCharAt & 15]);
                            } else {
                                sb.append((char) i4);
                            }
                        }
                        i++;
                    }
                    sb.append('\"');
                } else {
                    sb.append('?');
                }
                sb.append('}');
            } else {
                sb.append('[');
                int i5 = this.f1309b;
                sb.append(i5 >= 0 ? i5 : 0);
                sb.append(']');
            }
        } else {
            sb.append("/");
        }
        return sb.toString();
    }

    public AbstractC0547o(int i3) {
        this.f1308a = i3;
        this.f1309b = -1;
    }
}

package p042N0;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import p050Q0.AbstractC0589b;
import p050Q0.C0590c;

/* JADX INFO: renamed from: N0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0541i implements Serializable {

    /* JADX INFO: renamed from: k */
    public static final C0541i f1269k = new C0541i(C0590c.f1511g, -1, -1, -1, -1);
    private static final long serialVersionUID = 2;

    /* JADX INFO: renamed from: e */
    public final long f1270e;

    /* JADX INFO: renamed from: f */
    public final long f1271f;

    /* JADX INFO: renamed from: g */
    public final int f1272g;

    /* JADX INFO: renamed from: h */
    public final int f1273h;

    /* JADX INFO: renamed from: i */
    public final C0590c f1274i;

    /* JADX INFO: renamed from: j */
    public transient String f1275j;

    public C0541i(C0590c c0590c, long j2, long j3, int i3, int i4) {
        this.f1274i = c0590c == null ? C0590c.f1511g : c0590c;
        this.f1270e = j2;
        this.f1271f = j3;
        this.f1272g = i3;
        this.f1273h = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof C0541i)) {
            return false;
        }
        C0541i c0541i = (C0541i) obj;
        C0590c c0590c = c0541i.f1274i;
        C0590c c0590c2 = this.f1274i;
        if (c0590c2 == null) {
            if (c0590c != null) {
                return false;
            }
        } else if (!c0590c2.equals(c0590c)) {
            return false;
        }
        return this.f1272g == c0541i.f1272g && this.f1273h == c0541i.f1273h && this.f1271f == c0541i.f1271f && this.f1270e == c0541i.f1270e;
    }

    public final int hashCode() {
        return ((((this.f1274i == null ? 1 : 2) ^ this.f1272g) + this.f1273h) ^ ((int) this.f1271f)) + ((int) this.f1270e);
    }

    public final String toString() {
        String str;
        String str2 = this.f1275j;
        C0590c c0590c = this.f1274i;
        if (str2 == null) {
            StringBuilder sb = new StringBuilder(200);
            Object obj = c0590c.f1512e;
            if (obj == null) {
                sb.append("UNKNOWN");
            } else {
                Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
                String name = cls.getName();
                if (name.startsWith("java.")) {
                    name = cls.getSimpleName();
                } else if (obj instanceof byte[]) {
                    name = "byte[]";
                } else if (obj instanceof char[]) {
                    name = "char[]";
                }
                sb.append('(');
                sb.append(name);
                sb.append(')');
                if (c0590c.f1513f) {
                    int[] iArr = {-1, -1};
                    String str3 = " chars";
                    if (obj instanceof CharSequence) {
                        CharSequence charSequence = (CharSequence) obj;
                        C0590c.m1337a(iArr, charSequence.length());
                        int i3 = iArr[0];
                        str = charSequence.subSequence(i3, Math.min(iArr[1], 500) + i3).toString();
                    } else if (obj instanceof char[]) {
                        char[] cArr = (char[]) obj;
                        C0590c.m1337a(iArr, cArr.length);
                        str = new String(cArr, iArr[0], Math.min(iArr[1], 500));
                    } else if (obj instanceof byte[]) {
                        byte[] bArr = (byte[]) obj;
                        C0590c.m1337a(iArr, bArr.length);
                        str3 = " bytes";
                        str = new String(bArr, iArr[0], Math.min(iArr[1], 500), StandardCharsets.UTF_8);
                    } else {
                        str = null;
                    }
                    if (str != null) {
                        sb.append('\"');
                        int length = str.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            char cCharAt = str.charAt(i4);
                            if (!Character.isISOControl(cCharAt) || cCharAt == '\r' || cCharAt == '\n') {
                                sb.append(cCharAt);
                            } else {
                                sb.append("\\u");
                                char[] cArr2 = AbstractC0589b.f1500a;
                                sb.append(cArr2[(cCharAt >> '\f') & 15]);
                                sb.append(cArr2[(cCharAt >> '\b') & 15]);
                                sb.append(cArr2[(cCharAt >> 4) & 15]);
                                sb.append(cArr2[cCharAt & 15]);
                            }
                        }
                        sb.append('\"');
                        if (iArr[1] > 500) {
                            sb.append("[truncated ");
                            sb.append(iArr[1] - 500);
                            sb.append(str3);
                            sb.append(']');
                        }
                    }
                } else if (obj instanceof byte[]) {
                    int length2 = ((byte[]) obj).length;
                    sb.append('[');
                    sb.append(length2);
                    sb.append(" bytes]");
                }
            }
            this.f1275j = sb.toString();
        }
        String str4 = this.f1275j;
        StringBuilder sb2 = new StringBuilder(str4.length() + 40);
        sb2.append("[Source: ");
        sb2.append(str4);
        sb2.append("; ");
        boolean z3 = c0590c.f1513f;
        int i5 = this.f1273h;
        int i6 = this.f1272g;
        if (z3) {
            sb2.append("line: ");
            if (i6 >= 0) {
                sb2.append(i6);
            } else {
                sb2.append("UNKNOWN");
            }
            sb2.append(", column: ");
            if (i5 >= 0) {
                sb2.append(i5);
            } else {
                sb2.append("UNKNOWN");
            }
        } else if (i6 > 0) {
            sb2.append("line: ");
            sb2.append(i6);
            if (i5 > 0) {
                sb2.append(", column: ");
                sb2.append(i5);
            }
        } else {
            sb2.append("byte offset: #");
            long j2 = this.f1270e;
            if (j2 >= 0) {
                sb2.append(j2);
            } else {
                sb2.append("UNKNOWN");
            }
        }
        sb2.append(']');
        return sb2.toString();
    }
}

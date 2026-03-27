package p005B;

import android.graphics.Insets;

/* JADX INFO: renamed from: B.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0029d {

    /* JADX INFO: renamed from: e */
    public static final C0029d f80e = new C0029d(0, 0, 0, 0);

    /* JADX INFO: renamed from: a */
    public final int f81a;

    /* JADX INFO: renamed from: b */
    public final int f82b;

    /* JADX INFO: renamed from: c */
    public final int f83c;

    /* JADX INFO: renamed from: d */
    public final int f84d;

    public C0029d(int i3, int i4, int i5, int i6) {
        this.f81a = i3;
        this.f82b = i4;
        this.f83c = i5;
        this.f84d = i6;
    }

    /* JADX INFO: renamed from: a */
    public static C0029d m139a(int i3, int i4, int i5, int i6) {
        return (i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) ? f80e : new C0029d(i3, i4, i5, i6);
    }

    /* JADX INFO: renamed from: b */
    public static C0029d m140b(Insets insets) {
        return m139a(insets.left, insets.top, insets.right, insets.bottom);
    }

    /* JADX INFO: renamed from: c */
    public final Insets m141c() {
        return AbstractC0028c.m138a(this.f81a, this.f82b, this.f83c, this.f84d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0029d.class != obj.getClass()) {
            return false;
        }
        C0029d c0029d = (C0029d) obj;
        return this.f84d == c0029d.f84d && this.f81a == c0029d.f81a && this.f83c == c0029d.f83c && this.f82b == c0029d.f82b;
    }

    public final int hashCode() {
        return (((((this.f81a * 31) + this.f82b) * 31) + this.f83c) * 31) + this.f84d;
    }

    public final String toString() {
        return "Insets{left=" + this.f81a + ", top=" + this.f82b + ", right=" + this.f83c + ", bottom=" + this.f84d + '}';
    }
}

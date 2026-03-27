package p069X0;

import java.io.Serializable;
import p015D2.C0181e;
import p039M0.EnumC0481b0;

/* JADX INFO: renamed from: X0.D */
/* JADX INFO: loaded from: classes.dex */
public final class C0702D implements Serializable {

    /* JADX INFO: renamed from: l */
    public static final C0702D f1916l = new C0702D(Boolean.TRUE, null, null, null, null, null, null);

    /* JADX INFO: renamed from: m */
    public static final C0702D f1917m = new C0702D(Boolean.FALSE, null, null, null, null, null, null);

    /* JADX INFO: renamed from: n */
    public static final C0702D f1918n = new C0702D(null, null, null, null, null, null, null);
    private static final long serialVersionUID = -1;

    /* JADX INFO: renamed from: e */
    public final Boolean f1919e;

    /* JADX INFO: renamed from: f */
    public final String f1920f;

    /* JADX INFO: renamed from: g */
    public final Integer f1921g;

    /* JADX INFO: renamed from: h */
    public final String f1922h;

    /* JADX INFO: renamed from: i */
    public final transient C0181e f1923i;

    /* JADX INFO: renamed from: j */
    public final EnumC0481b0 f1924j;

    /* JADX INFO: renamed from: k */
    public final EnumC0481b0 f1925k;

    public C0702D(Boolean bool, String str, Integer num, String str2, C0181e c0181e, EnumC0481b0 enumC0481b0, EnumC0481b0 enumC0481b02) {
        this.f1919e = bool;
        this.f1920f = str;
        this.f1921g = num;
        this.f1922h = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f1923i = c0181e;
        this.f1924j = enumC0481b0;
        this.f1925k = enumC0481b02;
    }

    /* JADX INFO: renamed from: a */
    public static C0702D m1684a(Boolean bool, String str, Integer num, String str2) {
        return (str == null && num == null && str2 == null) ? bool == null ? f1918n : bool.booleanValue() ? f1916l : f1917m : new C0702D(bool, str, num, str2, null, null, null);
    }

    /* JADX INFO: renamed from: b */
    public final C0702D m1685b(C0181e c0181e) {
        return new C0702D(this.f1919e, this.f1920f, this.f1921g, this.f1922h, c0181e, this.f1924j, this.f1925k);
    }

    public Object readResolve() {
        if (this.f1920f != null || this.f1921g != null || this.f1922h != null || this.f1923i != null || this.f1924j != null || this.f1925k != null) {
            return this;
        }
        Boolean bool = this.f1919e;
        return bool == null ? f1918n : bool.booleanValue() ? f1916l : f1917m;
    }
}

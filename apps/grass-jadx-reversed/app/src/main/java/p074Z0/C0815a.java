package p074Z0;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;
import p042N0.C0533a;
import p069X0.AbstractC0705G;
import p069X0.AbstractC0711b;
import p082b1.AbstractC1009E;
import p082b1.AbstractC1030a;
import p082b1.C1006B;
import p082b1.C1011G;
import p082b1.C1014J;
import p100g1.AbstractC1396e;
import p103h1.C1423k;
import p103h1.C1426n;
import p114l1.C1675q;

/* JADX INFO: renamed from: Z0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0815a implements Serializable {

    /* JADX INFO: renamed from: p */
    public static final TimeZone f2418p = TimeZone.getTimeZone("UTC");
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C1675q f2419e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1009E f2420f;

    /* JADX INFO: renamed from: g */
    public final AbstractC0711b f2421g;

    /* JADX INFO: renamed from: h */
    public final AbstractC0705G f2422h;

    /* JADX INFO: renamed from: i */
    public final AbstractC1030a f2423i;

    /* JADX INFO: renamed from: j */
    public final C1426n f2424j;

    /* JADX INFO: renamed from: k */
    public final AbstractC1396e f2425k;

    /* JADX INFO: renamed from: l */
    public final DateFormat f2426l;

    /* JADX INFO: renamed from: m */
    public final Locale f2427m;

    /* JADX INFO: renamed from: n */
    public final TimeZone f2428n;

    /* JADX INFO: renamed from: o */
    public final C0533a f2429o;

    public C0815a(C1006B c1006b, C1014J c1014j, C1675q c1675q, DateFormat dateFormat, Locale locale, C0533a c0533a, C1011G c1011g) {
        C1423k c1423k = C1423k.f5049e;
        this.f2420f = c1006b;
        this.f2421g = c1014j;
        this.f2422h = null;
        this.f2419e = c1675q;
        this.f2424j = null;
        this.f2426l = dateFormat;
        this.f2427m = locale;
        this.f2428n = null;
        this.f2429o = c0533a;
        this.f2425k = c1423k;
        this.f2423i = c1011g;
    }
}

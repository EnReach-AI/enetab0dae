package p058T0;

import p005B.AbstractC0032g;
import p025H1.C0283l;
import p042N0.AbstractC0540h;
import p042N0.AbstractC0549q;
import p042N0.C0538f;
import p042N0.EnumC0539g;
import p042N0.InterfaceC0551s;
import p045O0.AbstractC0569a;
import p050Q0.AbstractC0589b;
import p066W0.AbstractC0692s;
import p066W0.C0680g;
import p125o0.C1803m;

/* JADX INFO: renamed from: T0.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0637b extends AbstractC0569a {

    /* JADX INFO: renamed from: q */
    public static final int[] f1638q = AbstractC0589b.f1509j;

    /* JADX INFO: renamed from: k */
    public final C0283l f1639k;

    /* JADX INFO: renamed from: l */
    public int[] f1640l;

    /* JADX INFO: renamed from: m */
    public int f1641m;

    /* JADX INFO: renamed from: n */
    public InterfaceC0551s f1642n;

    /* JADX INFO: renamed from: o */
    public boolean f1643o;

    /* JADX INFO: renamed from: p */
    public boolean f1644p;

    public AbstractC0637b(C0283l c0283l, int i3, AbstractC0549q abstractC0549q) {
        this.f1382g = i3;
        this.f1381f = abstractC0549q;
        this.f1384i = new C0640e(0, null, EnumC0539g.STRICT_DUPLICATE_DETECTION.m1106a(i3) ? new C1803m(this) : null);
        this.f1383h = EnumC0539g.WRITE_NUMBERS_AS_STRINGS.m1106a(i3);
        this.f1640l = f1638q;
        this.f1642n = C0680g.f1849l;
        this.f1639k = c0283l;
        if (EnumC0539g.ESCAPE_NON_ASCII.m1106a(i3)) {
            this.f1641m = 127;
        }
        this.f1644p = EnumC0539g.WRITE_HEX_UPPER_CASE.m1106a(i3);
        this.f1643o = !EnumC0539g.QUOTE_FIELD_NAMES.m1106a(i3);
    }

    /* JADX INFO: renamed from: Z */
    public final void m1462Z(String str) throws C0538f {
        m1129a(AbstractC0032g.m156n("Can not ", str, ", expecting field name (context: ", this.f1384i.m1220h(), ")"));
        throw null;
    }

    /* JADX INFO: renamed from: a0 */
    public final void m1463a0(int i3, String str) throws C0538f {
        if (i3 == 0) {
            if (this.f1384i.m1216d()) {
                this.f1268e.mo1224a(this);
                return;
            } else {
                if (this.f1384i.m1217e()) {
                    this.f1268e.mo1233j(this);
                    return;
                }
                return;
            }
        }
        if (i3 == 1) {
            this.f1268e.mo1232i(this);
            return;
        }
        if (i3 == 2) {
            this.f1268e.mo1226c(this);
            return;
        }
        if (i3 == 3) {
            this.f1268e.mo1231h(this);
        } else {
            if (i3 != 5) {
                AbstractC0692s.m1666a();
                throw null;
            }
            m1462Z(str);
            throw null;
        }
    }

    /* JADX INFO: renamed from: b0 */
    public final AbstractC0637b m1464b0(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        this.f1641m = i3;
        return this;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: e */
    public final AbstractC0540h mo1132e(EnumC0539g enumC0539g) {
        int i3 = enumC0539g.f1267f;
        this.f1382g &= ~i3;
        if ((i3 & AbstractC0569a.f1380j) != 0) {
            if (enumC0539g == EnumC0539g.WRITE_NUMBERS_AS_STRINGS) {
                this.f1383h = false;
            } else if (enumC0539g == EnumC0539g.ESCAPE_NON_ASCII) {
                m1464b0(0);
            } else if (enumC0539g == EnumC0539g.STRICT_DUPLICATE_DETECTION) {
                C0640e c0640e = this.f1384i;
                c0640e.f1659e = null;
                this.f1384i = c0640e;
            }
        }
        if (enumC0539g == EnumC0539g.QUOTE_FIELD_NAMES) {
            this.f1643o = true;
        } else if (enumC0539g == EnumC0539g.WRITE_HEX_UPPER_CASE) {
            this.f1644p = false;
        }
        return this;
    }

    @Override // p042N0.AbstractC0540h
    /* JADX INFO: renamed from: j */
    public final void mo1137j() {
        this.f1642n = null;
    }
}

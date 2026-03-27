package p140s;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p136r.AbstractC1849h;
import p136r.C1844c;
import p136r.C1846e;
import p136r.C1850i;

/* JADX INFO: renamed from: s.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1868h extends C1864d {

    /* JADX INFO: renamed from: d0 */
    public float f6586d0 = -1.0f;

    /* JADX INFO: renamed from: e0 */
    public int f6587e0 = -1;

    /* JADX INFO: renamed from: f0 */
    public int f6588f0 = -1;

    /* JADX INFO: renamed from: g0 */
    public C1863c f6589g0 = this.f6515y;

    /* JADX INFO: renamed from: h0 */
    public int f6590h0 = 0;

    public C1868h() {
        this.f6468G.clear();
        this.f6468G.add(this.f6589g0);
        int length = this.f6467F.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f6467F[i3] = this.f6589g0;
        }
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: A */
    public final void mo4146A(C1846e c1846e) {
        if (this.f6470I == null) {
            return;
        }
        C1863c c1863c = this.f6589g0;
        c1846e.getClass();
        int iM4097m = C1846e.m4097m(c1863c);
        if (this.f6590h0 == 1) {
            this.f6475N = iM4097m;
            this.f6476O = 0;
            m4166v(this.f6470I.m4153i());
            m4169y(0);
            return;
        }
        this.f6475N = 0;
        this.f6476O = iM4097m;
        m4169y(this.f6470I.m4156l());
        m4166v(0);
    }

    /* JADX INFO: renamed from: B */
    public final void m4185B(int i3) {
        if (this.f6590h0 == i3) {
            return;
        }
        this.f6590h0 = i3;
        ArrayList arrayList = this.f6468G;
        arrayList.clear();
        if (this.f6590h0 == 1) {
            this.f6589g0 = this.f6514x;
        } else {
            this.f6589g0 = this.f6515y;
        }
        arrayList.add(this.f6589g0);
        C1863c[] c1863cArr = this.f6467F;
        int length = c1863cArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            c1863cArr[i4] = this.f6589g0;
        }
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: a */
    public final void mo4135a(C1846e c1846e) {
        C1865e c1865e = (C1865e) this.f6470I;
        if (c1865e == null) {
            return;
        }
        C1863c c1863cMo4151g = c1865e.mo4151g(2);
        C1863c c1863cMo4151g2 = c1865e.mo4151g(4);
        C1864d c1864d = this.f6470I;
        boolean z3 = c1864d != null && c1864d.f6493c0[0] == 2;
        if (this.f6590h0 == 0) {
            c1863cMo4151g = c1865e.mo4151g(3);
            c1863cMo4151g2 = c1865e.mo4151g(5);
            C1864d c1864d2 = this.f6470I;
            z3 = c1864d2 != null && c1864d2.f6493c0[1] == 2;
        }
        if (this.f6587e0 != -1) {
            C1850i c1850iM4107j = c1846e.m4107j(this.f6589g0);
            c1846e.m4102e(c1850iM4107j, c1846e.m4107j(c1863cMo4151g), this.f6587e0, 8);
            if (z3) {
                c1846e.m4103f(c1846e.m4107j(c1863cMo4151g2), c1850iM4107j, 0, 5);
                return;
            }
            return;
        }
        if (this.f6588f0 != -1) {
            C1850i c1850iM4107j2 = c1846e.m4107j(this.f6589g0);
            C1850i c1850iM4107j3 = c1846e.m4107j(c1863cMo4151g2);
            c1846e.m4102e(c1850iM4107j2, c1850iM4107j3, -this.f6588f0, 8);
            if (z3) {
                c1846e.m4103f(c1850iM4107j2, c1846e.m4107j(c1863cMo4151g), 0, 5);
                c1846e.m4103f(c1850iM4107j3, c1850iM4107j2, 0, 5);
                return;
            }
            return;
        }
        if (this.f6586d0 != -1.0f) {
            C1850i c1850iM4107j4 = c1846e.m4107j(this.f6589g0);
            C1850i c1850iM4107j5 = c1846e.m4107j(c1863cMo4151g2);
            float f3 = this.f6586d0;
            C1844c c1844cM4108k = c1846e.m4108k();
            c1844cM4108k.f6374d.mo4085h(c1850iM4107j4, -1.0f);
            c1844cM4108k.f6374d.mo4085h(c1850iM4107j5, f3);
            c1846e.m4100c(c1844cM4108k);
        }
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: b */
    public final boolean mo4136b() {
        return true;
    }

    @Override // p140s.C1864d
    /* JADX INFO: renamed from: g */
    public final C1863c mo4151g(int i3) {
        switch (AbstractC1849h.m4118b(i3)) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return null;
            case 1:
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                if (this.f6590h0 == 1) {
                    return this.f6589g0;
                }
                break;
            case 2:
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                if (this.f6590h0 == 0) {
                    return this.f6589g0;
                }
                break;
        }
        throw new AssertionError(AbstractC0032g.m164v(i3));
    }
}

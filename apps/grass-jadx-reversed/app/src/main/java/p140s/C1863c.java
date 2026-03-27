package p140s;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.HashSet;
import java.util.Iterator;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p005B.AbstractC0032g;
import p136r.AbstractC1849h;
import p136r.C1850i;

/* JADX INFO: renamed from: s.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1863c {

    /* JADX INFO: renamed from: b */
    public final C1864d f6456b;

    /* JADX INFO: renamed from: c */
    public final int f6457c;

    /* JADX INFO: renamed from: d */
    public C1863c f6458d;

    /* JADX INFO: renamed from: g */
    public C1850i f6461g;

    /* JADX INFO: renamed from: a */
    public HashSet f6455a = null;

    /* JADX INFO: renamed from: e */
    public int f6459e = 0;

    /* JADX INFO: renamed from: f */
    public int f6460f = -1;

    public C1863c(C1864d c1864d, int i3) {
        this.f6456b = c1864d;
        this.f6457c = i3;
    }

    /* JADX INFO: renamed from: a */
    public final void m4137a(C1863c c1863c, int i3) {
        m4138b(c1863c, i3, -1, false);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m4138b(C1863c c1863c, int i3, int i4, boolean z3) {
        if (c1863c == null) {
            m4144h();
            return true;
        }
        if (!z3 && !m4143g(c1863c)) {
            return false;
        }
        this.f6458d = c1863c;
        if (c1863c.f6455a == null) {
            c1863c.f6455a = new HashSet();
        }
        this.f6458d.f6455a.add(this);
        if (i3 > 0) {
            this.f6459e = i3;
        } else {
            this.f6459e = 0;
        }
        this.f6460f = i4;
        return true;
    }

    /* JADX INFO: renamed from: c */
    public final int m4139c() {
        C1863c c1863c;
        if (this.f6456b.f6483V == 8) {
            return 0;
        }
        int i3 = this.f6460f;
        return (i3 <= -1 || (c1863c = this.f6458d) == null || c1863c.f6456b.f6483V != 8) ? this.f6459e : i3;
    }

    /* JADX INFO: renamed from: d */
    public final C1863c m4140d() {
        int i3 = this.f6457c;
        int iM4118b = AbstractC1849h.m4118b(i3);
        C1864d c1864d = this.f6456b;
        switch (iM4118b) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return null;
            case 1:
                return c1864d.f6516z;
            case 2:
                return c1864d.f6462A;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return c1864d.f6514x;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return c1864d.f6515y;
            default:
                throw new AssertionError(AbstractC0032g.m164v(i3));
        }
    }

    /* JADX INFO: renamed from: e */
    public final boolean m4141e() {
        HashSet hashSet = this.f6455a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((C1863c) it.next()).m4140d().m4142f()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m4142f() {
        return this.f6458d != null;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m4143g(C1863c c1863c) {
        if (c1863c == null) {
            return false;
        }
        int i3 = this.f6457c;
        C1864d c1864d = c1863c.f6456b;
        int i4 = c1863c.f6457c;
        if (i4 == i3) {
            return i3 != 6 || (c1864d.f6513w && this.f6456b.f6513w);
        }
        switch (AbstractC1849h.m4118b(i3)) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return false;
            case 1:
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                boolean z3 = i4 == 2 || i4 == 4;
                if (c1864d instanceof C1868h) {
                    return z3 || i4 == 8;
                }
                return z3;
            case 2:
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                boolean z4 = i4 == 3 || i4 == 5;
                if (c1864d instanceof C1868h) {
                    return z4 || i4 == 9;
                }
                return z4;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return (i4 == 6 || i4 == 8 || i4 == 9) ? false : true;
            default:
                throw new AssertionError(AbstractC0032g.m164v(i3));
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m4144h() {
        HashSet hashSet;
        C1863c c1863c = this.f6458d;
        if (c1863c != null && (hashSet = c1863c.f6455a) != null) {
            hashSet.remove(this);
        }
        this.f6458d = null;
        this.f6459e = 0;
        this.f6460f = -1;
    }

    /* JADX INFO: renamed from: i */
    public final void m4145i() {
        C1850i c1850i = this.f6461g;
        if (c1850i == null) {
            this.f6461g = new C1850i(1);
        } else {
            c1850i.m4121c();
        }
    }

    public final String toString() {
        return this.f6456b.f6484W + ":" + AbstractC0032g.m164v(this.f6457c);
    }
}

package p119m2;

import java.util.List;
import p086c2.AbstractC1085d;
import p135q2.InterfaceC1840a;
import p135q2.InterfaceC1841b;
import p148u0.AbstractC1946e;

/* JADX INFO: renamed from: m2.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1774m implements InterfaceC1841b {

    /* JADX INFO: renamed from: a */
    public final InterfaceC1840a f6148a;

    /* JADX INFO: renamed from: b */
    public final List f6149b;

    /* JADX INFO: renamed from: c */
    public final int f6150c;

    public C1774m(C1763b c1763b, List list) {
        AbstractC1766e.m3920e("arguments", list);
        this.f6148a = c1763b;
        this.f6149b = list;
        this.f6150c = 0;
    }

    @Override // p135q2.InterfaceC1841b
    /* JADX INFO: renamed from: a */
    public final List mo246a() {
        return this.f6149b;
    }

    @Override // p135q2.InterfaceC1841b
    /* JADX INFO: renamed from: b */
    public final boolean mo247b() {
        return (this.f6150c & 1) != 0;
    }

    @Override // p135q2.InterfaceC1841b
    /* JADX INFO: renamed from: c */
    public final InterfaceC1840a mo248c() {
        return this.f6148a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1774m) {
            C1774m c1774m = (C1774m) obj;
            if (AbstractC1766e.m3916a(this.f6148a, c1774m.f6148a) && AbstractC1766e.m3916a(this.f6149b, c1774m.f6149b) && AbstractC1766e.m3916a(null, null) && this.f6150c == c1774m.f6150c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f6150c) + ((this.f6149b.hashCode() + (this.f6148a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        InterfaceC1840a interfaceC1840a = this.f6148a;
        InterfaceC1840a interfaceC1840a2 = interfaceC1840a instanceof InterfaceC1840a ? interfaceC1840a : null;
        Class clsM4344b = interfaceC1840a2 != null ? AbstractC1946e.m4344b(interfaceC1840a2) : null;
        sb.append((clsM4344b == null ? interfaceC1840a.toString() : (this.f6150c & 4) != 0 ? "kotlin.Nothing" : clsM4344b.isArray() ? clsM4344b.equals(boolean[].class) ? "kotlin.BooleanArray" : clsM4344b.equals(char[].class) ? "kotlin.CharArray" : clsM4344b.equals(byte[].class) ? "kotlin.ByteArray" : clsM4344b.equals(short[].class) ? "kotlin.ShortArray" : clsM4344b.equals(int[].class) ? "kotlin.IntArray" : clsM4344b.equals(float[].class) ? "kotlin.FloatArray" : clsM4344b.equals(long[].class) ? "kotlin.LongArray" : clsM4344b.equals(double[].class) ? "kotlin.DoubleArray" : "kotlin.Array" : clsM4344b.getName()) + (this.f6149b.isEmpty() ? "" : AbstractC1085d.m2834x(this.f6149b, ", ", "<", ">", new C1773l(1), 24)) + (mo247b() ? "?" : ""));
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }
}

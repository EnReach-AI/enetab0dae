package p025H1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: renamed from: H1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0273b implements InterfaceC0274c {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0274c f693a;

    /* JADX INFO: renamed from: b */
    public final float f694b;

    public C0273b(float f3, InterfaceC0274c interfaceC0274c) {
        while (interfaceC0274c instanceof C0273b) {
            interfaceC0274c = ((C0273b) interfaceC0274c).f693a;
            f3 += ((C0273b) interfaceC0274c).f694b;
        }
        this.f693a = interfaceC0274c;
        this.f694b = f3;
    }

    @Override // p025H1.InterfaceC0274c
    /* JADX INFO: renamed from: a */
    public final float mo529a(RectF rectF) {
        return Math.max(0.0f, this.f693a.mo529a(rectF) + this.f694b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0273b)) {
            return false;
        }
        C0273b c0273b = (C0273b) obj;
        return this.f693a.equals(c0273b.f693a) && this.f694b == c0273b.f694b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f693a, Float.valueOf(this.f694b)});
    }
}

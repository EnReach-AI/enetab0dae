package p025H1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: renamed from: H1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0272a implements InterfaceC0274c {

    /* JADX INFO: renamed from: a */
    public final float f692a;

    public C0272a(float f3) {
        this.f692a = f3;
    }

    @Override // p025H1.InterfaceC0274c
    /* JADX INFO: renamed from: a */
    public final float mo529a(RectF rectF) {
        return this.f692a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0272a) && this.f692a == ((C0272a) obj).f692a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f692a)});
    }
}

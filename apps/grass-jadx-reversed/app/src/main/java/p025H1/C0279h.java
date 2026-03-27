package p025H1;

import android.graphics.RectF;
import java.util.Arrays;

/* JADX INFO: renamed from: H1.h */
/* JADX INFO: loaded from: classes.dex */
public final class C0279h implements InterfaceC0274c {

    /* JADX INFO: renamed from: a */
    public final float f741a;

    public C0279h(float f3) {
        this.f741a = f3;
    }

    @Override // p025H1.InterfaceC0274c
    /* JADX INFO: renamed from: a */
    public final float mo529a(RectF rectF) {
        return Math.min(rectF.width(), rectF.height()) * this.f741a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0279h) && this.f741a == ((C0279h) obj).f741a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f741a)});
    }
}

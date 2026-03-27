package p026I;

import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p136r.C1844c;

/* JADX INFO: renamed from: I.d */
/* JADX INFO: loaded from: classes.dex */
public class C0296d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f795a;

    /* JADX INFO: renamed from: b */
    public final Object[] f796b;

    /* JADX INFO: renamed from: c */
    public int f797c;

    public C0296d(int i3) {
        this.f795a = 0;
        if (i3 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f796b = new Object[i3];
    }

    /* JADX INFO: renamed from: a */
    public Object mo571a() {
        switch (this.f795a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                int i3 = this.f797c;
                if (i3 <= 0) {
                    return null;
                }
                int i4 = i3 - 1;
                Object[] objArr = this.f796b;
                Object obj = objArr[i4];
                objArr[i4] = null;
                this.f797c = i3 - 1;
                return obj;
            default:
                int i5 = this.f797c;
                if (i5 <= 0) {
                    return null;
                }
                int i6 = i5 - 1;
                Object[] objArr2 = this.f796b;
                Object obj2 = objArr2[i6];
                objArr2[i6] = null;
                this.f797c = i5 - 1;
                return obj2;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m572b(C1844c c1844c) {
        int i3 = this.f797c;
        Object[] objArr = this.f796b;
        if (i3 < objArr.length) {
            objArr[i3] = c1844c;
            this.f797c = i3 + 1;
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean mo573c(Object obj) {
        int i3 = 0;
        while (true) {
            int i4 = this.f797c;
            Object[] objArr = this.f796b;
            if (i3 >= i4) {
                if (i4 >= objArr.length) {
                    return false;
                }
                objArr[i4] = obj;
                this.f797c = i4 + 1;
                return true;
            }
            if (objArr[i3] == obj) {
                throw new IllegalStateException("Already in the pool!");
            }
            i3++;
        }
    }

    public C0296d() {
        this.f795a = 1;
        this.f796b = new Object[256];
    }
}

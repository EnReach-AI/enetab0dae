package p049Q;

import android.view.accessibility.AccessibilityNodeInfo;
import p031J1.C0382f;
import p032K.C0391i;

/* JADX INFO: renamed from: Q.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0583a extends C0382f {

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ AbstractC0584b f1457c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0583a(AbstractC0584b abstractC0584b) {
        super(1);
        this.f1457c = abstractC0584b;
    }

    @Override // p031J1.C0382f
    /* JADX INFO: renamed from: a */
    public final C0391i mo846a(int i3) {
        return new C0391i(AccessibilityNodeInfo.obtain(this.f1457c.m1313n(i3).f920a));
    }

    @Override // p031J1.C0382f
    /* JADX INFO: renamed from: b */
    public final C0391i mo847b(int i3) {
        AbstractC0584b abstractC0584b = this.f1457c;
        int i4 = i3 == 2 ? abstractC0584b.f1468k : abstractC0584b.f1469l;
        if (i4 == Integer.MIN_VALUE) {
            return null;
        }
        return mo846a(i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    @Override // p031J1.C0382f
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean mo848c(int r7, int r8, android.os.Bundle r9) {
        /*
            r6 = this;
            Q.b r0 = r6.f1457c
            android.view.View r1 = r0.f1466i
            r2 = -1
            if (r7 == r2) goto L86
            r9 = 1
            if (r8 == r9) goto L81
            r2 = 2
            if (r8 == r2) goto L7c
            r2 = 64
            r3 = 65536(0x10000, float:9.1835E-41)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 0
            if (r8 == r2) goto L51
            r2 = 128(0x80, float:1.8E-43)
            if (r8 == r2) goto L41
            w1.c r0 = (p157w1.C1994c) r0
            r1 = 16
            if (r8 != r1) goto L8c
            com.google.android.material.chip.Chip r8 = r0.f7069q
            if (r7 != 0) goto L2a
            boolean r5 = r8.performClick()
            goto L8c
        L2a:
            if (r7 != r9) goto L8c
            r8.playSoundEffect(r5)
            android.view.View$OnClickListener r7 = r8.f4325l
            if (r7 == 0) goto L37
            r7.onClick(r8)
            r5 = r9
        L37:
            boolean r7 = r8.f4336w
            if (r7 == 0) goto L8c
            w1.c r7 = r8.f4335v
            r7.m1316q(r9, r9)
            goto L8c
        L41:
            int r8 = r0.f1468k
            if (r8 != r7) goto L4e
            r0.f1468k = r4
            r1.invalidate()
            r0.m1316q(r7, r3)
            goto L4f
        L4e:
            r9 = r5
        L4f:
            r5 = r9
            goto L8c
        L51:
            android.view.accessibility.AccessibilityManager r8 = r0.f1465h
            boolean r2 = r8.isEnabled()
            if (r2 == 0) goto L4e
            boolean r8 = r8.isTouchExplorationEnabled()
            if (r8 != 0) goto L60
            goto L4e
        L60:
            int r8 = r0.f1468k
            if (r8 == r7) goto L4e
            if (r8 == r4) goto L70
            r0.f1468k = r4
            android.view.View r2 = r0.f1466i
            r2.invalidate()
            r0.m1316q(r8, r3)
        L70:
            r0.f1468k = r7
            r1.invalidate()
            r8 = 32768(0x8000, float:4.5918E-41)
            r0.m1316q(r7, r8)
            goto L4f
        L7c:
            boolean r5 = r0.m1309j(r7)
            goto L8c
        L81:
            boolean r5 = r0.m1315p(r7)
            goto L8c
        L86:
            java.util.WeakHashMap r7 = p029J.AbstractC0323S.f816a
            boolean r5 = p029J.AbstractC0307B.m594j(r1, r8, r9)
        L8c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p049Q.C0583a.mo848c(int, int, android.os.Bundle):boolean");
    }
}

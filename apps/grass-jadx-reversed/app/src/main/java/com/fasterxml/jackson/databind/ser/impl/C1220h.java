package com.fasterxml.jackson.databind.ser.impl;

import java.util.Arrays;
import p069X0.AbstractC0728s;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.ser.impl.h */
/* JADX INFO: loaded from: classes.dex */
public final class C1220h extends AbstractC1223k {

    /* JADX INFO: renamed from: b */
    public final C1222j[] f4141b;

    public C1220h(AbstractC1223k abstractC1223k, C1222j[] c1222jArr) {
        super(abstractC1223k);
        this.f4141b = c1222jArr;
    }

    @Override // com.fasterxml.jackson.databind.ser.impl.AbstractC1223k
    /* JADX INFO: renamed from: b */
    public final AbstractC1223k mo3091b(Class cls, AbstractC0728s abstractC0728s) {
        C1222j[] c1222jArr = this.f4141b;
        int length = c1222jArr.length;
        if (length == 8) {
            return this.f4146a ? new C1221i(this, cls, abstractC0728s) : this;
        }
        C1222j[] c1222jArr2 = (C1222j[]) Arrays.copyOf(c1222jArr, length + 1);
        c1222jArr2[length] = new C1222j(cls, abstractC0728s);
        return new C1220h(this, c1222jArr2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0057 A[ORIG_RETURN, RETURN] */
    @Override // com.fasterxml.jackson.databind.ser.impl.AbstractC1223k
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final p069X0.AbstractC0728s mo3092c(java.lang.Class r4) {
        /*
            r3 = this;
            r0 = 0
            com.fasterxml.jackson.databind.ser.impl.j[] r1 = r3.f4141b
            r0 = r1[r0]
            java.lang.Class r2 = r0.f4144a
            if (r2 != r4) goto Lc
            X0.s r4 = r0.f4145b
            return r4
        Lc:
            r0 = 1
            r0 = r1[r0]
            java.lang.Class r2 = r0.f4144a
            if (r2 != r4) goto L16
            X0.s r4 = r0.f4145b
            return r4
        L16:
            r0 = 2
            r0 = r1[r0]
            java.lang.Class r2 = r0.f4144a
            if (r2 != r4) goto L20
            X0.s r4 = r0.f4145b
            return r4
        L20:
            int r0 = r1.length
            switch(r0) {
                case 4: goto L4d;
                case 5: goto L43;
                case 6: goto L39;
                case 7: goto L2f;
                case 8: goto L25;
                default: goto L24;
            }
        L24:
            goto L57
        L25:
            r0 = 7
            r0 = r1[r0]
            java.lang.Class r2 = r0.f4144a
            if (r2 != r4) goto L2f
            X0.s r4 = r0.f4145b
            return r4
        L2f:
            r0 = 6
            r0 = r1[r0]
            java.lang.Class r2 = r0.f4144a
            if (r2 != r4) goto L39
            X0.s r4 = r0.f4145b
            return r4
        L39:
            r0 = 5
            r0 = r1[r0]
            java.lang.Class r2 = r0.f4144a
            if (r2 != r4) goto L43
            X0.s r4 = r0.f4145b
            return r4
        L43:
            r0 = 4
            r0 = r1[r0]
            java.lang.Class r2 = r0.f4144a
            if (r2 != r4) goto L4d
            X0.s r4 = r0.f4145b
            return r4
        L4d:
            r0 = 3
            r0 = r1[r0]
            java.lang.Class r1 = r0.f4144a
            if (r1 != r4) goto L57
            X0.s r4 = r0.f4145b
            return r4
        L57:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.impl.C1220h.mo3092c(java.lang.Class):X0.s");
    }
}

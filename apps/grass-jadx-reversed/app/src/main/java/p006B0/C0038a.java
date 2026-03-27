package p006B0;

import java.util.Comparator;

/* JADX INFO: renamed from: B0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0038a implements Comparator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f102a;

    public /* synthetic */ C0038a(int i3) {
        this.f102a = i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if (r3 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
    
        return -1;
     */
    @Override // java.util.Comparator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int compare(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            r2 = -1
            int r3 = r6.f102a
            switch(r3) {
                case 0: goto L8c;
                case 1: goto L7e;
                case 2: goto L6a;
                case 3: goto L60;
                case 4: goto L2c;
                case 5: goto L22;
                default: goto L8;
            }
        L8:
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = (android.view.View) r8
            java.util.WeakHashMap r3 = p029J.AbstractC0323S.f816a
            float r7 = p029J.AbstractC0313H.m640m(r7)
            float r8 = p029J.AbstractC0313H.m640m(r8)
            int r3 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r3 <= 0) goto L1c
            r0 = r2
            goto L21
        L1c:
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 >= 0) goto L21
            r0 = r1
        L21:
            return r0
        L22:
            r.i r7 = (p136r.C1850i) r7
            r.i r8 = (p136r.C1850i) r8
            int r7 = r7.f6400b
            int r8 = r8.f6400b
            int r7 = r7 - r8
            return r7
        L2c:
            Z.m r7 = (p073Z.C0801m) r7
            Z.m r8 = (p073Z.C0801m) r8
            androidx.recyclerview.widget.RecyclerView r3 = r7.f2349d
            if (r3 != 0) goto L36
            r4 = r1
            goto L37
        L36:
            r4 = r0
        L37:
            androidx.recyclerview.widget.RecyclerView r5 = r8.f2349d
            if (r5 != 0) goto L3d
            r5 = r1
            goto L3e
        L3d:
            r5 = r0
        L3e:
            if (r4 == r5) goto L45
            if (r3 != 0) goto L43
            goto L55
        L43:
            r0 = r2
            goto L5f
        L45:
            boolean r3 = r7.f2346a
            boolean r4 = r8.f2346a
            if (r3 == r4) goto L4e
            if (r3 == 0) goto L55
            goto L43
        L4e:
            int r1 = r8.f2347b
            int r2 = r7.f2347b
            int r1 = r1 - r2
            if (r1 == 0) goto L57
        L55:
            r0 = r1
            goto L5f
        L57:
            int r7 = r7.f2348c
            int r8 = r8.f2348c
            int r7 = r7 - r8
            if (r7 == 0) goto L5f
            r0 = r7
        L5f:
            return r0
        L60:
            P1.e r7 = (p048P1.C0581e) r7
            P1.e r8 = (p048P1.C0581e) r8
            int r7 = r7.f1454d
            int r8 = r8.f1454d
            int r7 = r7 - r8
            return r7
        L6a:
            D0.a r7 = (p013D0.C0175a) r7
            D0.a r8 = (p013D0.C0175a) r8
            java.lang.Long r7 = r7.f411c
            if (r7 != 0) goto L74
            r1 = r2
            goto L7d
        L74:
            java.lang.Long r8 = r8.f411c
            if (r8 != 0) goto L79
            goto L7d
        L79:
            int r1 = r8.compareTo(r7)
        L7d:
            return r1
        L7e:
            android.view.View r7 = (android.view.View) r7
            android.view.View r8 = (android.view.View) r8
            int r7 = r7.getTop()
            int r8 = r8.getTop()
            int r7 = r7 - r8
            return r7
        L8c:
            A0.c r7 = (p002A0.C0021c) r7
            A0.c r8 = (p002A0.C0021c) r8
            java.lang.Long r7 = r7.f71g
            if (r7 != 0) goto L96
            r1 = r2
            goto L9f
        L96:
            java.lang.Long r8 = r8.f71g
            if (r8 != 0) goto L9b
            goto L9f
        L9b:
            int r1 = r8.compareTo(r7)
        L9f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p006B0.C0038a.compare(java.lang.Object, java.lang.Object):int");
    }
}

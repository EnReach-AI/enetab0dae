package p087d0;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.HashMap;
import p073Z.C0799k;

/* JADX INFO: renamed from: d0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1290i extends AbstractC1293l {

    /* JADX INFO: renamed from: B */
    public static final String[] f4606B = {"android:visibility:visibility", "android:visibility:parent"};

    /* JADX INFO: renamed from: A */
    public final int f4607A;

    public C1290i(int i3) {
        this();
        this.f4607A = i3;
    }

    /* JADX INFO: renamed from: F */
    public static void m3258F(C1298q c1298q) {
        int visibility = c1298q.f4643b.getVisibility();
        HashMap map = c1298q.f4642a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        View view = c1298q.f4643b;
        map.put("android:visibility:parent", view.getParent());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /* JADX INFO: renamed from: H */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p087d0.C1304w m3259H(p087d0.C1298q r8, p087d0.C1298q r9) {
        /*
            d0.w r0 = new d0.w
            r0.<init>()
            r1 = 0
            r0.f4661a = r1
            r0.f4662b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.f4642a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.f4663c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f4665e = r6
            goto L33
        L2f:
            r0.f4663c = r3
            r0.f4665e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.f4642a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.f4664d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f4666f = r2
            goto L56
        L52:
            r0.f4664d = r3
            r0.f4666f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.f4663c
            int r9 = r0.f4664d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.f4665e
            android.view.ViewGroup r4 = r0.f4666f
            if (r3 != r4) goto L68
            return r0
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.f4662b = r1
            r0.f4661a = r2
            goto L9f
        L71:
            if (r9 != 0) goto L9f
            r0.f4662b = r2
            r0.f4661a = r2
            goto L9f
        L78:
            android.view.ViewGroup r8 = r0.f4666f
            if (r8 != 0) goto L81
            r0.f4662b = r1
            r0.f4661a = r2
            goto L9f
        L81:
            android.view.ViewGroup r8 = r0.f4665e
            if (r8 != 0) goto L9f
            r0.f4662b = r2
            r0.f4661a = r2
            goto L9f
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.f4664d
            if (r8 != 0) goto L95
            r0.f4662b = r2
            r0.f4661a = r2
            goto L9f
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.f4663c
            if (r8 != 0) goto L9f
            r0.f4662b = r1
            r0.f4661a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p087d0.C1290i.m3259H(d0.q, d0.q):d0.w");
    }

    /* JADX INFO: renamed from: G */
    public final ObjectAnimator m3260G(View view, float f3, float f4) {
        int i3 = 0;
        if (f3 == f4) {
            return null;
        }
        AbstractC1299r.f4645a.mo1940h(view, f3);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, AbstractC1299r.f4646b, f4);
        objectAnimatorOfFloat.addListener(new C0799k(view));
        m3266a(new C1289h(i3, view));
        return objectAnimatorOfFloat;
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: c */
    public final void mo3239c(C1298q c1298q) {
        m3258F(c1298q);
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: f */
    public final void mo3241f(C1298q c1298q) {
        m3258F(c1298q);
        c1298q.f4642a.put("android:fade:transitionAlpha", Float.valueOf(AbstractC1299r.f4645a.mo1939f(c1298q.f4643b)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        if (m3259H(m3271m(r3, false), m3272p(r3, false)).f4661a != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020d  */
    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.Animator mo3255j(android.view.ViewGroup r22, p087d0.C1298q r23, p087d0.C1298q r24) {
        /*
            Method dump skipped, instruction units count: 712
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p087d0.C1290i.mo3255j(android.view.ViewGroup, d0.q, d0.q):android.animation.Animator");
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: o */
    public final String[] mo3256o() {
        return f4606B;
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: q */
    public final boolean mo3261q(C1298q c1298q, C1298q c1298q2) {
        if (c1298q == null && c1298q2 == null) {
            return false;
        }
        if (c1298q != null && c1298q2 != null && c1298q2.f4642a.containsKey("android:visibility:visibility") != c1298q.f4642a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C1304w c1304wM3259H = m3259H(c1298q, c1298q2);
        if (c1304wM3259H.f4661a) {
            return c1304wM3259H.f4663c == 0 || c1304wM3259H.f4664d == 0;
        }
        return false;
    }

    public C1290i() {
        this.f4607A = 3;
    }
}

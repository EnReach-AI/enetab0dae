package p015D2;

import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import p011C2.AbstractC0156i;
import p011C2.AbstractC0172y;
import p011C2.C0150c;
import p011C2.C0154g;
import p011C2.C0162o;
import p011C2.C0165r;
import p011C2.C0168u;
import p029J.InterfaceC0332a0;
import p083b2.AbstractC1056a;
import p083b2.C1062g;
import p083b2.C1077v;
import p089d2.C1318l;
import p089d2.InterfaceC1312f;
import p089d2.InterfaceC1317k;
import p093e2.C1341b;
import p093e2.C1342c;
import p093e2.EnumC1340a;
import p097f2.AbstractC1348a;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1772k;
import p125o0.C1803m;

/* JADX INFO: renamed from: D2.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0195s implements InterfaceC0332a0 {

    /* JADX INFO: renamed from: a */
    public boolean f456a;

    /* JADX INFO: renamed from: b */
    public int f457b;

    /* JADX INFO: renamed from: c */
    public final Object f458c;

    public C0195s(C0154g c0154g, C0200x c0200x) {
        AbstractC1766e.m3920e("configuration", c0154g);
        AbstractC1766e.m3920e("lexer", c0200x);
        this.f458c = c0200x;
        this.f456a = c0154g.f368c;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m340d(p015D2.C0195s r12, p125o0.C1803m r13, p089d2.InterfaceC1312f r14) throws java.lang.Throwable {
        /*
            r12.getClass()
            boolean r0 = r14 instanceof p015D2.C0194r
            if (r0 == 0) goto L16
            r0 = r14
            D2.r r0 = (p015D2.C0194r) r0
            int r1 = r0.f455n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f455n = r1
            goto L1b
        L16:
            D2.r r0 = new D2.r
            r0.<init>(r12, r14)
        L1b:
            java.lang.Object r14 = r0.f453l
            e2.a r1 = p093e2.EnumC1340a.f4774e
            int r2 = r0.f455n
            r3 = 0
            r4 = 6
            r5 = 0
            r6 = 7
            r7 = 1
            r8 = 4
            if (r2 == 0) goto L5e
            if (r2 != r7) goto L56
            java.lang.String r12 = r0.f452k
            java.util.LinkedHashMap r13 = r0.f451j
            D2.s r2 = r0.f450i
            o0.m r9 = r0.f449h
            p083b2.AbstractC1056a.m2816c(r14)
            C2.i r14 = (p011C2.AbstractC0156i) r14
            r13.put(r12, r14)
            java.lang.Object r12 = r2.f458c
            D2.x r12 = (p015D2.C0200x) r12
            byte r12 = r12.m375f()
            if (r12 == r8) goto L52
            if (r12 != r6) goto L48
            goto La8
        L48:
            java.lang.Object r12 = r2.f458c
            D2.x r12 = (p015D2.C0200x) r12
            java.lang.String r13 = "Expected end of the object or comma"
            p015D2.C0200x.m369o(r12, r13, r3, r5, r4)
            throw r5
        L52:
            r11 = r2
            r2 = r12
            r12 = r11
            goto L76
        L56:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L5e:
            p083b2.AbstractC1056a.m2816c(r14)
            java.lang.Object r14 = r12.f458c
            D2.x r14 = (p015D2.C0200x) r14
            byte r2 = r14.m376g(r4)
            byte r9 = r14.m387s()
            if (r9 == r8) goto Lc0
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>()
            r9 = r13
            r13 = r14
        L76:
            java.lang.Object r14 = r12.f458c
            D2.x r14 = (p015D2.C0200x) r14
            boolean r10 = r14.m371b()
            if (r10 == 0) goto La5
            boolean r2 = r12.f456a
            if (r2 == 0) goto L89
            java.lang.String r2 = r14.m380k()
            goto L8d
        L89:
            java.lang.String r2 = r14.m379j()
        L8d:
            r3 = 5
            r14.m376g(r3)
            b2.v r14 = p083b2.C1077v.f3761a
            r0.f449h = r9
            r0.f450i = r12
            r0.f451j = r13
            r0.f452k = r2
            r0.f455n = r7
            r9.getClass()
            r9.f6222h = r0
            r9.f6221g = r14
            goto Lb9
        La5:
            r11 = r2
            r2 = r12
            r12 = r11
        La8:
            java.lang.Object r14 = r2.f458c
            D2.x r14 = (p015D2.C0200x) r14
            if (r12 != r4) goto Lb2
            r14.m376g(r6)
            goto Lb4
        Lb2:
            if (r12 == r8) goto Lba
        Lb4:
            C2.u r1 = new C2.u
            r1.<init>(r13)
        Lb9:
            return r1
        Lba:
            java.lang.String r12 = "Unexpected trailing comma"
            p015D2.C0200x.m369o(r14, r12, r3, r5, r4)
            throw r5
        Lc0:
            java.lang.String r12 = "Unexpected leading comma"
            p015D2.C0200x.m369o(r14, r12, r3, r5, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015D2.C0195s.m340d(D2.s, o0.m, d2.f):java.lang.Object");
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: a */
    public void mo341a() {
        if (this.f456a) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f458c;
        actionBarContextView.f2695j = null;
        super/*android.view.View*/.setVisibility(this.f457b);
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: b */
    public void mo342b(View view) {
        this.f456a = true;
    }

    @Override // p029J.InterfaceC0332a0
    /* JADX INFO: renamed from: c */
    public void mo343c() {
        super/*android.view.View*/.setVisibility(0);
        this.f456a = false;
    }

    /* JADX INFO: renamed from: e */
    public AbstractC0156i m344e() throws Throwable {
        AbstractC0156i c0168u;
        Object obj;
        Object objMo339g;
        C0200x c0200x = (C0200x) this.f458c;
        byte bM387s = c0200x.m387s();
        if (bM387s == 1) {
            return m346g(true);
        }
        if (bM387s == 0) {
            return m346g(false);
        }
        if (bM387s != 6) {
            if (bM387s == 8) {
                return m345f();
            }
            C0200x.m369o(c0200x, "Cannot read Json element because of unexpected ".concat(AbstractC0190n.m333o(bM387s)), 0, null, 6);
            throw null;
        }
        int i3 = this.f457b + 1;
        this.f457b = i3;
        if (i3 == 200) {
            C0193q c0193q = new C0193q(this, null);
            C1077v c1077v = C1077v.f3761a;
            C1803m c1803m = new C1803m();
            c1803m.f6220f = c0193q;
            c1803m.f6221g = c1077v;
            c1803m.f6222h = c1803m;
            EnumC1340a enumC1340a = AbstractC1056a.f3732a;
            c1803m.f6219e = enumC1340a;
            while (true) {
                obj = c1803m.f6219e;
                InterfaceC1312f interfaceC1312f = (InterfaceC1312f) c1803m.f6222h;
                if (interfaceC1312f == null) {
                    break;
                }
                if (AbstractC1766e.m3916a(enumC1340a, obj)) {
                    try {
                        C0193q c0193q2 = (C0193q) c1803m.f6220f;
                        Object obj2 = c1803m.f6221g;
                        if (c0193q2 instanceof AbstractC1348a) {
                            AbstractC1772k.m3929a(c0193q2);
                            c0193q2.getClass();
                            C0193q c0193q3 = new C0193q(c0193q2.f448i, interfaceC1312f);
                            c0193q3.f447h = c1803m;
                            objMo339g = c0193q3.mo339g(c1077v);
                        } else {
                            AbstractC1766e.m3920e("<this>", c0193q2);
                            InterfaceC1317k interfaceC1317kMo3283d = interfaceC1312f.mo3283d();
                            InterfaceC1312f c1341b = interfaceC1317kMo3283d == C1318l.f4678e ? new C1341b(interfaceC1312f) : new C1342c(interfaceC1312f, interfaceC1317kMo3283d);
                            AbstractC1772k.m3929a(c0193q2);
                            C0193q c0193q4 = new C0193q(c0193q2.f448i, c1341b);
                            c0193q4.f447h = c1803m;
                            objMo339g = c0193q4.mo339g(c1077v);
                        }
                        if (objMo339g != EnumC1340a.f4774e) {
                            interfaceC1312f.mo3284e(objMo339g);
                        }
                    } catch (Throwable th) {
                        interfaceC1312f.mo3284e(new C1062g(th));
                    }
                } else {
                    c1803m.f6219e = enumC1340a;
                    interfaceC1312f.mo3284e(obj);
                }
            }
            AbstractC1056a.m2816c(obj);
            c0168u = (AbstractC0156i) obj;
        } else {
            byte bM376g = c0200x.m376g((byte) 6);
            if (c0200x.m387s() == 4) {
                C0200x.m369o(c0200x, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                if (!c0200x.m371b()) {
                    break;
                }
                String strM380k = this.f456a ? c0200x.m380k() : c0200x.m379j();
                c0200x.m376g((byte) 5);
                linkedHashMap.put(strM380k, m344e());
                bM376g = c0200x.m375f();
                if (bM376g != 4) {
                    if (bM376g != 7) {
                        C0200x.m369o(c0200x, "Expected end of the object or comma", 0, null, 6);
                        throw null;
                    }
                }
            }
            if (bM376g == 6) {
                c0200x.m376g((byte) 7);
            } else if (bM376g == 4) {
                C0200x.m369o(c0200x, "Unexpected trailing comma", 0, null, 6);
                throw null;
            }
            c0168u = new C0168u(linkedHashMap);
        }
        this.f457b--;
        return c0168u;
    }

    /* JADX INFO: renamed from: f */
    public C0150c m345f() {
        C0200x c0200x = (C0200x) this.f458c;
        byte bM375f = c0200x.m375f();
        if (c0200x.m387s() == 4) {
            C0200x.m369o(c0200x, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (c0200x.m371b()) {
            arrayList.add(m344e());
            bM375f = c0200x.m375f();
            if (bM375f != 4) {
                boolean z3 = bM375f == 9;
                int i3 = c0200x.f475a;
                if (!z3) {
                    C0200x.m369o(c0200x, "Expected end of the array or comma", i3, null, 4);
                    throw null;
                }
            }
        }
        if (bM375f == 8) {
            c0200x.m376g((byte) 9);
        } else if (bM375f == 4) {
            C0200x.m369o(c0200x, "Unexpected trailing comma", 0, null, 6);
            throw null;
        }
        return new C0150c(arrayList);
    }

    /* JADX INFO: renamed from: g */
    public AbstractC0172y m346g(boolean z3) {
        boolean z4 = this.f456a;
        C0200x c0200x = (C0200x) this.f458c;
        String strM380k = (z4 || !z3) ? c0200x.m380k() : c0200x.m379j();
        return (z3 || !AbstractC1766e.m3916a(strM380k, "null")) ? new C0162o(strM380k, z3) : C0165r.INSTANCE;
    }

    public C0195s(ActionBarContextView actionBarContextView) {
        this.f458c = actionBarContextView;
        this.f456a = false;
    }
}

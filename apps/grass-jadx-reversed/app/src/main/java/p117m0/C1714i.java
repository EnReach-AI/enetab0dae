package p117m0;

import com.facebook.AbstractC1117n;
import com.facebook.C1114k;
import com.facebook.C1125v;
import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import p010C0.AbstractC0147a;
import p015D2.C0192p;

/* JADX INFO: renamed from: m0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1714i implements InterfaceC1121r {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C1707b f5993a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C1724s f5994b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C0192p f5995c;

    public C1714i(C1707b c1707b, C1125v c1125v, C1724s c1724s, C0192p c0192p) {
        this.f5993a = c1707b;
        this.f5994b = c1724s;
        this.f5995c = c0192p;
    }

    @Override // com.facebook.InterfaceC1121r
    /* JADX INFO: renamed from: a */
    public final void mo74a(C1128y c1128y) {
        EnumC1721p enumC1721p;
        C1707b c1707b = this.f5993a;
        C1724s c1724s = this.f5994b;
        C0192p c0192p = this.f5995c;
        if (AbstractC0147a.f354a.contains(AbstractC1715j.class)) {
            return;
        }
        try {
            C1114k c1114k = c1128y.f3921c;
            EnumC1721p enumC1721p2 = EnumC1721p.f6006e;
            EnumC1721p enumC1721p3 = EnumC1721p.f6008g;
            if (c1114k == null) {
                enumC1721p = enumC1721p2;
            } else if (c1114k.f3865f == -1) {
                enumC1721p = enumC1721p3;
            } else {
                c1128y.toString();
                c1114k.toString();
                enumC1721p = EnumC1721p.f6007f;
            }
            AbstractC1117n.m2896f();
            c1724s.m3825b(c1114k != null);
            if (enumC1721p == enumC1721p3) {
                AbstractC1117n.m2891a().execute(new RunnableC1713h(c1707b, 1, c1724s));
            }
            if (enumC1721p == enumC1721p2 || ((EnumC1721p) c0192p.f444g) == enumC1721p3) {
                return;
            }
            c0192p.f444g = enumC1721p;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1715j.class);
        }
    }
}

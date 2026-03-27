package p015D2;

import p011C2.AbstractC0156i;
import p083b2.AbstractC1056a;
import p083b2.InterfaceC1057b;
import p089d2.InterfaceC1312f;
import p093e2.EnumC1340a;
import p097f2.AbstractC1354g;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;
import p119m2.InterfaceC1765d;
import p125o0.C1803m;

/* JADX INFO: renamed from: D2.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0193q extends AbstractC1354g implements InterfaceC1765d, InterfaceC1057b {

    /* JADX INFO: renamed from: f */
    public final int f445f;

    /* JADX INFO: renamed from: g */
    public int f446g;

    /* JADX INFO: renamed from: h */
    public /* synthetic */ C1803m f447h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ C0195s f448i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0193q(C0195s c0195s, InterfaceC1312f interfaceC1312f) {
        super(interfaceC1312f);
        this.f448i = c0195s;
        this.f445f = 3;
    }

    @Override // p119m2.InterfaceC1765d
    /* JADX INFO: renamed from: b */
    public final int mo316b() {
        return this.f445f;
    }

    @Override // p097f2.AbstractC1348a
    /* JADX INFO: renamed from: g */
    public final Object mo339g(Object obj) throws Throwable {
        EnumC1340a enumC1340a = EnumC1340a.f4774e;
        int i3 = this.f446g;
        if (i3 == 0) {
            AbstractC1056a.m2816c(obj);
            C1803m c1803m = this.f447h;
            C0195s c0195s = this.f448i;
            byte bM387s = ((C0200x) c0195s.f458c).m387s();
            if (bM387s == 1) {
                return c0195s.m346g(true);
            }
            if (bM387s == 0) {
                return c0195s.m346g(false);
            }
            if (bM387s != 6) {
                if (bM387s == 8) {
                    return c0195s.m345f();
                }
                C0200x.m369o((C0200x) c0195s.f458c, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.f446g = 1;
            obj = C0195s.m340d(c0195s, c1803m, this);
            if (obj == enumC1340a) {
                return enumC1340a;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC1056a.m2816c(obj);
        }
        return (AbstractC0156i) obj;
    }

    @Override // p097f2.AbstractC1348a
    public final String toString() {
        if (this.f4814e != null) {
            return super.toString();
        }
        AbstractC1770i.f6147a.getClass();
        String string = C0193q.class.getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        AbstractC1766e.m3919d("renderLambdaToString(...)", string);
        return string;
    }
}

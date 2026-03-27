package p083b2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p093e2.EnumC1340a;
import p101g2.AbstractC1400a;
import p104h2.AbstractC1432a;
import p115l2.InterfaceC1678a;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: b2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1056a {

    /* JADX INFO: renamed from: a */
    public static final EnumC1340a f3732a = EnumC1340a.f4774e;

    /* JADX INFO: renamed from: a */
    public static void m2814a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        AbstractC1766e.m3920e("<this>", th);
        AbstractC1766e.m3920e("exception", th2);
        if (th != th2) {
            Integer num = AbstractC1432a.f5076a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = AbstractC1400a.f5027a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC1059d m2815b(InterfaceC1678a interfaceC1678a) {
        C1074s c1074s = C1074s.f3758a;
        C1064i c1064i = new C1064i();
        c1064i.f3741e = interfaceC1678a;
        c1064i.f3742f = c1074s;
        return c1064i;
    }

    /* JADX INFO: renamed from: c */
    public static final void m2816c(Object obj) throws Throwable {
        if (obj instanceof C1062g) {
            throw ((C1062g) obj).f3738e;
        }
    }
}

package p150u2;

import kotlinx.coroutines.scheduling.ExecutorC1648c;
import p089d2.InterfaceC1317k;
import p154v2.C1977a;
import p158w2.AbstractC2002f;
import p158w2.AbstractC2004h;

/* JADX INFO: renamed from: u2.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1959h {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f6979a = 0;

    static {
        String property;
        int i3 = AbstractC2004h.f7147a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (!(property == null ? false : Boolean.parseBoolean(property))) {
            RunnableC1958g runnableC1958g = RunnableC1958g.f6977g;
            return;
        }
        ExecutorC1648c executorC1648c = AbstractC1962k.f6981a;
        InterfaceC1317k interfaceC1317k = AbstractC2002f.f7146a;
        C1977a c1977a = ((C1977a) interfaceC1317k).f7024i;
        if (interfaceC1317k instanceof InterfaceC1960i) {
        } else {
            RunnableC1958g runnableC1958g2 = RunnableC1958g.f6977g;
        }
    }
}

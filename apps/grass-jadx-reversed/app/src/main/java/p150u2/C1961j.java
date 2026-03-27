package p150u2;

import p089d2.C1318l;
import p089d2.InterfaceC1317k;

/* JADX INFO: renamed from: u2.j */
/* JADX INFO: loaded from: classes.dex */
public final class C1961j extends RuntimeException {

    /* JADX INFO: renamed from: e */
    public final InterfaceC1317k f6980e = C1318l.f4678e;

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f6980e.toString();
    }
}

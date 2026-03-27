package p154v2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.scheduling.ExecutorC1648c;
import p005B.AbstractC0032g;
import p089d2.InterfaceC1317k;
import p119m2.AbstractC1766e;
import p150u2.AbstractC1962k;
import p150u2.AbstractC1967p;
import p150u2.C1955d;
import p150u2.InterfaceC1960i;
import p158w2.AbstractC2002f;

/* JADX INFO: renamed from: v2.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1977a extends AbstractC1967p implements InterfaceC1960i {
    private volatile C1977a _immediate;

    /* JADX INFO: renamed from: f */
    public final Handler f7021f;

    /* JADX INFO: renamed from: g */
    public final String f7022g;

    /* JADX INFO: renamed from: h */
    public final boolean f7023h;

    /* JADX INFO: renamed from: i */
    public final C1977a f7024i;

    public C1977a(Handler handler, String str, boolean z3) {
        this.f7021f = handler;
        this.f7022g = str;
        this.f7023h = z3;
        this._immediate = z3 ? this : null;
        C1977a c1977a = this._immediate;
        if (c1977a == null) {
            c1977a = new C1977a(handler, str, true);
            this._immediate = c1977a;
        }
        this.f7024i = c1977a;
    }

    @Override // p150u2.AbstractC1954c
    /* JADX INFO: renamed from: a */
    public final void mo3742a(InterfaceC1317k interfaceC1317k, Runnable runnable) {
        if (this.f7021f.post(runnable)) {
            return;
        }
        m4369c(interfaceC1317k, runnable);
    }

    @Override // p150u2.AbstractC1954c
    /* JADX INFO: renamed from: b */
    public final boolean mo4358b() {
        return (this.f7023h && AbstractC1766e.m3916a(Looper.myLooper(), this.f7021f.getLooper())) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public final void m4369c(InterfaceC1317k interfaceC1317k, Runnable runnable) {
        new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        AbstractC0032g.m159q(interfaceC1317k.get(C1955d.f6975b));
        AbstractC1962k.f6981a.mo3742a(interfaceC1317k, runnable);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C1977a) && ((C1977a) obj).f7021f == this.f7021f;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f7021f);
    }

    @Override // p150u2.AbstractC1954c
    public final String toString() {
        C1977a c1977a;
        String str;
        ExecutorC1648c executorC1648c = AbstractC1962k.f6981a;
        AbstractC1967p abstractC1967p = AbstractC2002f.f7146a;
        if (this == abstractC1967p) {
            str = "Dispatchers.Main";
        } else {
            try {
                c1977a = ((C1977a) abstractC1967p).f7024i;
            } catch (UnsupportedOperationException unused) {
                c1977a = null;
            }
            str = this == c1977a ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String string = this.f7022g;
        if (string == null) {
            string = this.f7021f.toString();
        }
        return this.f7023h ? AbstractC1766e.m3923h(string, ".immediate") : string;
    }

    public C1977a(Handler handler) {
        this(handler, null, false);
    }
}

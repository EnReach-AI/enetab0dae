package kotlinx.coroutines.android;

import android.os.Looper;
import java.util.List;
import p150u2.AbstractC1967p;
import p154v2.AbstractC1978b;
import p154v2.C1977a;
import p158w2.InterfaceC2001e;

/* JADX INFO: loaded from: classes.dex */
public final class AndroidDispatcherFactory implements InterfaceC2001e {
    @Override // p158w2.InterfaceC2001e
    public AbstractC1967p createDispatcher(List<? extends InterfaceC2001e> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C1977a(AbstractC1978b.m4370a(mainLooper));
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // p158w2.InterfaceC2001e
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // p158w2.InterfaceC2001e
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }
}

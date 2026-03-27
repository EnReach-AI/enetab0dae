package p031J1;

import android.os.Handler;
import android.os.Message;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: J1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0377a implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 == 0) {
            AbstractC0032g.m162t(message.obj);
            throw null;
        }
        if (i3 != 1) {
            return false;
        }
        AbstractC0032g.m162t(message.obj);
        throw null;
    }
}

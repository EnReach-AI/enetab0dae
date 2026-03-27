package p031J1;

import android.os.Handler;
import android.os.Message;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: J1.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0381e implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0382f f901a;

    public C0381e(C0382f c0382f) {
        this.f901a = c0382f;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        C0382f c0382f = this.f901a;
        AbstractC0032g.m162t(message.obj);
        synchronized (c0382f.f903a) {
            throw null;
        }
    }
}

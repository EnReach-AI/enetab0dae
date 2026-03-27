package p029J;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;
import p016E1.AbstractC0207e;
import p019F0.C0221e;
import p041N.C0531s;

/* JADX INFO: renamed from: J.P */
/* JADX INFO: loaded from: classes.dex */
public final class OnReceiveContentListenerC0321P implements OnReceiveContentListener {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0369t f815a;

    public OnReceiveContentListenerC0321P(InterfaceC0369t interfaceC0369t) {
        this.f815a = interfaceC0369t;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        C0343g c0343g = new C0343g(new C0221e(contentInfo));
        C0343g c0343gM1070a = ((C0531s) this.f815a).m1070a(view, c0343g);
        if (c0343gM1070a == null) {
            return null;
        }
        if (c0343gM1070a == c0343g) {
            return contentInfo;
        }
        ContentInfo contentInfoMo448h = c0343gM1070a.f849a.mo448h();
        Objects.requireNonNull(contentInfoMo448h);
        return AbstractC0207e.m408f(contentInfoMo448h);
    }
}

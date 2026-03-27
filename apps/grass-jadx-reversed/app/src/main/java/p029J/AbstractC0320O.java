package p029J;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;
import p016E1.AbstractC0207e;
import p019F0.C0221e;

/* JADX INFO: renamed from: J.O */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0320O {
    /* JADX INFO: renamed from: a */
    public static String[] m688a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    /* JADX INFO: renamed from: b */
    public static C0343g m689b(View view, C0343g c0343g) {
        ContentInfo contentInfoMo448h = c0343g.f849a.mo448h();
        Objects.requireNonNull(contentInfoMo448h);
        ContentInfo contentInfoM408f = AbstractC0207e.m408f(contentInfoMo448h);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoM408f);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoM408f ? c0343g : new C0343g(new C0221e(contentInfoPerformReceiveContent));
    }

    /* JADX INFO: renamed from: c */
    public static void m690c(View view, String[] strArr, InterfaceC0369t interfaceC0369t) {
        if (interfaceC0369t == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new OnReceiveContentListenerC0321P(interfaceC0369t));
        }
    }
}

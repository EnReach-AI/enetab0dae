package androidx.emoji2.text;

import android.content.Context;
import android.support.v4.media.session.AbstractC0864a;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: androidx.emoji2.text.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0905l implements InterfaceC0901h {

    /* JADX INFO: renamed from: a */
    public Context f2986a;

    @Override // androidx.emoji2.text.InterfaceC0901h
    /* JADX INFO: renamed from: a */
    public void mo2340a(AbstractC0864a abstractC0864a) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0894a("EmojiCompatInitializer"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new RunnableC0903j(this, abstractC0864a, threadPoolExecutor, 0));
    }
}

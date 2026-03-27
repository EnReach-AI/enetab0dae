package androidx.emoji2.text;

import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.InterfaceC0971d;
import androidx.lifecycle.InterfaceC0984q;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import p019F0.RunnableC0218b;
import p081b0.C1003a;
import p081b0.InterfaceC1004b;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements InterfaceC1004b {
    @Override // p081b0.InterfaceC1004b
    /* JADX INFO: renamed from: a */
    public final List mo2335a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // p081b0.InterfaceC1004b
    /* JADX INFO: renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo2336b(Context context) {
        m2337c(context);
        return Boolean.TRUE;
    }

    /* JADX INFO: renamed from: c */
    public final void m2337c(Context context) {
        Object objM2695b;
        C0905l c0905l = new C0905l();
        c0905l.f2986a = context.getApplicationContext();
        C0909p c0909p = new C0909p(c0905l);
        c0909p.f2409a = 1;
        if (C0902i.f2971j == null) {
            synchronized (C0902i.f2970i) {
                try {
                    if (C0902i.f2971j == null) {
                        C0902i.f2971j = new C0902i(c0909p);
                    }
                } finally {
                }
            }
        }
        C1003a c1003aM2693c = C1003a.m2693c(context);
        c1003aM2693c.getClass();
        synchronized (C1003a.f3574e) {
            try {
                objM2695b = c1003aM2693c.f3575a.get(ProcessLifecycleInitializer.class);
                if (objM2695b == null) {
                    objM2695b = c1003aM2693c.m2695b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        final C0986s c0986sMo2199d = ((InterfaceC0984q) objM2695b).mo2199d();
        c0986sMo2199d.m2515a(new InterfaceC0971d() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.InterfaceC0971d
            /* JADX INFO: renamed from: a */
            public final void mo2338a() {
                EmojiCompatInitializer.this.getClass();
                AbstractC0895b.m2339a(Looper.getMainLooper()).postDelayed(new RunnableC0218b(1), 500L);
                c0986sMo2199d.m2520f(this);
            }
        });
    }
}

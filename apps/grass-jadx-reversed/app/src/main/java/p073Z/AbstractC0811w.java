package p073Z;

import android.graphics.Rect;
import android.view.View;
import androidx.emoji2.text.C0896c;
import androidx.emoji2.text.InterfaceC0901h;

/* JADX INFO: renamed from: Z.w */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0811w {

    /* JADX INFO: renamed from: a */
    public int f2409a;

    /* JADX INFO: renamed from: b */
    public final Object f2410b;

    /* JADX INFO: renamed from: c */
    public final Object f2411c;

    public AbstractC0811w(AbstractC0763I abstractC0763I) {
        this.f2409a = Integer.MIN_VALUE;
        this.f2411c = new Rect();
        this.f2410b = abstractC0763I;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0811w m2127a(AbstractC0763I abstractC0763I, int i3) {
        if (i3 == 0) {
            return new C0810v(abstractC0763I, 0);
        }
        if (i3 == 1) {
            return new C0810v(abstractC0763I, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    /* JADX INFO: renamed from: b */
    public abstract int mo2113b(View view);

    /* JADX INFO: renamed from: c */
    public abstract int mo2114c(View view);

    /* JADX INFO: renamed from: d */
    public abstract int mo2115d(View view);

    /* JADX INFO: renamed from: e */
    public abstract int mo2116e(View view);

    /* JADX INFO: renamed from: f */
    public abstract int mo2117f();

    /* JADX INFO: renamed from: g */
    public abstract int mo2118g();

    /* JADX INFO: renamed from: h */
    public abstract int mo2119h();

    /* JADX INFO: renamed from: i */
    public abstract int mo2120i();

    /* JADX INFO: renamed from: j */
    public abstract int mo2121j();

    /* JADX INFO: renamed from: k */
    public abstract int mo2122k();

    /* JADX INFO: renamed from: l */
    public abstract int mo2123l();

    /* JADX INFO: renamed from: m */
    public int m2128m() {
        if (Integer.MIN_VALUE == this.f2409a) {
            return 0;
        }
        return mo2123l() - this.f2409a;
    }

    /* JADX INFO: renamed from: n */
    public abstract int mo2124n(View view);

    /* JADX INFO: renamed from: o */
    public abstract int mo2125o(View view);

    /* JADX INFO: renamed from: p */
    public abstract void mo2126p(int i3);

    public AbstractC0811w(InterfaceC0901h interfaceC0901h) {
        this.f2409a = 0;
        this.f2411c = new C0896c();
        this.f2410b = interfaceC0901h;
    }
}

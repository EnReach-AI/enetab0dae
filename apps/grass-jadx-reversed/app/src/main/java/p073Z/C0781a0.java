package p073Z;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: renamed from: Z.a0 */
/* JADX INFO: loaded from: classes.dex */
public final class C0781a0 extends AbstractC0766L {

    /* JADX INFO: renamed from: a */
    public boolean f2228a = false;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0813y f2229b;

    public C0781a0(C0813y c0813y) {
        this.f2229b = c0813y;
    }

    @Override // p073Z.AbstractC0766L
    /* JADX INFO: renamed from: a */
    public final void mo2030a(RecyclerView recyclerView, int i3) {
        if (i3 == 0 && this.f2228a) {
            this.f2228a = false;
            this.f2229b.m2134f();
        }
    }

    @Override // p073Z.AbstractC0766L
    /* JADX INFO: renamed from: b */
    public final void mo2031b(RecyclerView recyclerView, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.f2228a = true;
    }
}

package p134q1;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import p067W1.C0693a;
import p155w.AbstractC1979a;

/* JADX INFO: renamed from: q1.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1839a extends AbstractC1979a {

    /* JADX INFO: renamed from: a */
    public C0693a f6359a;

    /* JADX INFO: renamed from: b */
    public int f6360b = 0;

    public AbstractC1839a() {
    }

    @Override // p155w.AbstractC1979a
    /* JADX INFO: renamed from: g */
    public boolean mo3123g(CoordinatorLayout coordinatorLayout, View view, int i3) {
        mo3136r(coordinatorLayout, view, i3);
        if (this.f6359a == null) {
            C0693a c0693a = new C0693a();
            c0693a.f1884d = view;
            this.f6359a = c0693a;
        }
        C0693a c0693a2 = this.f6359a;
        View view2 = (View) c0693a2.f1884d;
        c0693a2.f1881a = view2.getTop();
        c0693a2.f1882b = view2.getLeft();
        this.f6359a.m1668b();
        int i4 = this.f6360b;
        if (i4 == 0) {
            return true;
        }
        C0693a c0693a3 = this.f6359a;
        if (c0693a3.f1883c != i4) {
            c0693a3.f1883c = i4;
            c0693a3.m1668b();
        }
        this.f6360b = 0;
        return true;
    }

    /* JADX INFO: renamed from: r */
    public void mo3136r(CoordinatorLayout coordinatorLayout, View view, int i3) {
        coordinatorLayout.m2309q(view, i3);
    }

    public AbstractC1839a(int i3) {
    }
}

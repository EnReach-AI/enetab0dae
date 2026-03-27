package p105i;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
import p029J.C0330Z;
import p029J.InterfaceC0332a0;

/* JADX INFO: renamed from: i.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1444l {

    /* JADX INFO: renamed from: c */
    public Interpolator f5139c;

    /* JADX INFO: renamed from: d */
    public InterfaceC0332a0 f5140d;

    /* JADX INFO: renamed from: e */
    public boolean f5141e;

    /* JADX INFO: renamed from: b */
    public long f5138b = -1;

    /* JADX INFO: renamed from: f */
    public final C1443k f5142f = new C1443k(this);

    /* JADX INFO: renamed from: a */
    public final ArrayList f5137a = new ArrayList();

    /* JADX INFO: renamed from: a */
    public final void m3450a() {
        if (this.f5141e) {
            Iterator it = this.f5137a.iterator();
            while (it.hasNext()) {
                ((C0330Z) it.next()).m716b();
            }
            this.f5141e = false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3451b() {
        View view;
        if (this.f5141e) {
            return;
        }
        for (C0330Z c0330z : this.f5137a) {
            long j2 = this.f5138b;
            if (j2 >= 0) {
                c0330z.m717c(j2);
            }
            Interpolator interpolator = this.f5139c;
            if (interpolator != null && (view = (View) c0330z.f827a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f5140d != null) {
                c0330z.m718d(this.f5142f);
            }
            View view2 = (View) c0330z.f827a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f5141e = true;
    }
}

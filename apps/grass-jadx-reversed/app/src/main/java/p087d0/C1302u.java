package p087d0;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import io.getgrass.www.R;
import java.util.ArrayList;

/* JADX INFO: renamed from: d0.u */
/* JADX INFO: loaded from: classes.dex */
public final class C1302u extends AbstractC1294m {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ViewGroup f4651a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f4652b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f4653c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C1290i f4654d;

    public C1302u(C1290i c1290i, ViewGroup viewGroup, View view, View view2) {
        this.f4654d = c1290i;
        this.f4651a = viewGroup;
        this.f4652b = view;
        this.f4653c = view2;
    }

    @Override // p087d0.AbstractC1294m, p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: c */
    public final void mo3251c() {
        this.f4651a.getOverlay().remove(this.f4652b);
    }

    @Override // p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: d */
    public final void mo3252d(AbstractC1293l abstractC1293l) {
        this.f4653c.setTag(R.id.save_overlay_view, null);
        this.f4651a.getOverlay().remove(this.f4652b);
        abstractC1293l.m3274u(this);
    }

    @Override // p087d0.AbstractC1294m, p087d0.InterfaceC1292k
    /* JADX INFO: renamed from: e */
    public final void mo3253e() {
        View view = this.f4652b;
        if (view.getParent() == null) {
            this.f4651a.getOverlay().add(view);
            return;
        }
        C1290i c1290i = this.f4654d;
        ArrayList arrayList = c1290i.f4628q;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = c1290i.f4632u;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            return;
        }
        ArrayList arrayList3 = (ArrayList) c1290i.f4632u.clone();
        int size2 = arrayList3.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((InterfaceC1292k) arrayList3.get(i3)).mo3250a();
        }
    }
}

package p087d0;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import p019F0.C0222f;
import p039M0.AbstractC0473V;
import p125o0.C1803m;

/* JADX INFO: renamed from: d0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1282a extends AbstractC1293l {

    /* JADX INFO: renamed from: A */
    public ArrayList f4582A;

    /* JADX INFO: renamed from: B */
    public boolean f4583B;

    /* JADX INFO: renamed from: C */
    public int f4584C;

    /* JADX INFO: renamed from: D */
    public boolean f4585D;

    /* JADX INFO: renamed from: E */
    public int f4586E;

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: A */
    public final void mo3234A(C0222f c0222f) {
        super.mo3234A(c0222f);
        this.f4586E |= 4;
        if (this.f4582A != null) {
            for (int i3 = 0; i3 < this.f4582A.size(); i3++) {
                ((AbstractC1293l) this.f4582A.get(i3)).mo3234A(c0222f);
            }
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: B */
    public final void mo3235B() {
        this.f4586E |= 2;
        int size = this.f4582A.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC1293l) this.f4582A.get(i3)).mo3235B();
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: C */
    public final void mo3236C(long j2) {
        this.f4617f = j2;
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: E */
    public final String mo3237E(String str) {
        String strMo3237E = super.mo3237E(str);
        for (int i3 = 0; i3 < this.f4582A.size(); i3++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strMo3237E);
            sb.append("\n");
            sb.append(((AbstractC1293l) this.f4582A.get(i3)).mo3237E(str + "  "));
            strMo3237E = sb.toString();
        }
        return strMo3237E;
    }

    /* JADX INFO: renamed from: F */
    public final void m3238F(AbstractC1293l abstractC1293l) {
        this.f4582A.add(abstractC1293l);
        abstractC1293l.f4624m = this;
        long j2 = this.f4618g;
        if (j2 >= 0) {
            abstractC1293l.mo3247x(j2);
        }
        if ((this.f4586E & 1) != 0) {
            abstractC1293l.mo3249z(this.f4619h);
        }
        if ((this.f4586E & 2) != 0) {
            abstractC1293l.mo3235B();
        }
        if ((this.f4586E & 4) != 0) {
            abstractC1293l.mo3234A(this.f4634w);
        }
        if ((this.f4586E & 8) != 0) {
            abstractC1293l.mo3248y(null);
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: c */
    public final void mo3239c(C1298q c1298q) {
        if (m3273r(c1298q.f4643b)) {
            for (AbstractC1293l abstractC1293l : this.f4582A) {
                if (abstractC1293l.m3273r(c1298q.f4643b)) {
                    abstractC1293l.mo3239c(c1298q);
                    c1298q.f4644c.add(abstractC1293l);
                }
            }
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: e */
    public final void mo3240e(C1298q c1298q) {
        int size = this.f4582A.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC1293l) this.f4582A.get(i3)).mo3240e(c1298q);
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: f */
    public final void mo3241f(C1298q c1298q) {
        if (m3273r(c1298q.f4643b)) {
            for (AbstractC1293l abstractC1293l : this.f4582A) {
                if (abstractC1293l.m3273r(c1298q.f4643b)) {
                    abstractC1293l.mo3241f(c1298q);
                    c1298q.f4644c.add(abstractC1293l);
                }
            }
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: i */
    public final AbstractC1293l clone() {
        C1282a c1282a = (C1282a) super.clone();
        c1282a.f4582A = new ArrayList();
        int size = this.f4582A.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC1293l abstractC1293lClone = ((AbstractC1293l) this.f4582A.get(i3)).clone();
            c1282a.f4582A.add(abstractC1293lClone);
            abstractC1293lClone.f4624m = c1282a;
        }
        return c1282a;
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: k */
    public final void mo3243k(ViewGroup viewGroup, C1803m c1803m, C1803m c1803m2, ArrayList arrayList, ArrayList arrayList2) {
        long j2 = this.f4617f;
        int size = this.f4582A.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC1293l abstractC1293l = (AbstractC1293l) this.f4582A.get(i3);
            if (j2 > 0 && (this.f4583B || i3 == 0)) {
                long j3 = abstractC1293l.f4617f;
                if (j3 > 0) {
                    abstractC1293l.mo3236C(j3 + j2);
                } else {
                    abstractC1293l.mo3236C(j2);
                }
            }
            abstractC1293l.mo3243k(viewGroup, c1803m, c1803m2, arrayList, arrayList2);
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: t */
    public final void mo3244t(View view) {
        super.mo3244t(view);
        int size = this.f4582A.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC1293l) this.f4582A.get(i3)).mo3244t(view);
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: v */
    public final void mo3245v(View view) {
        super.mo3245v(view);
        int size = this.f4582A.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC1293l) this.f4582A.get(i3)).mo3245v(view);
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: w */
    public final void mo3246w() {
        if (this.f4582A.isEmpty()) {
            m3265D();
            m3270l();
            return;
        }
        C1289h c1289h = new C1289h();
        c1289h.f4605b = this;
        Iterator it = this.f4582A.iterator();
        while (it.hasNext()) {
            ((AbstractC1293l) it.next()).m3266a(c1289h);
        }
        this.f4584C = this.f4582A.size();
        if (this.f4583B) {
            Iterator it2 = this.f4582A.iterator();
            while (it2.hasNext()) {
                ((AbstractC1293l) it2.next()).mo3246w();
            }
            return;
        }
        for (int i3 = 1; i3 < this.f4582A.size(); i3++) {
            ((AbstractC1293l) this.f4582A.get(i3 - 1)).m3266a(new C1289h(1, (AbstractC1293l) this.f4582A.get(i3)));
        }
        AbstractC1293l abstractC1293l = (AbstractC1293l) this.f4582A.get(0);
        if (abstractC1293l != null) {
            abstractC1293l.mo3246w();
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: x */
    public final void mo3247x(long j2) {
        ArrayList arrayList;
        this.f4618g = j2;
        if (j2 < 0 || (arrayList = this.f4582A) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC1293l) this.f4582A.get(i3)).mo3247x(j2);
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: y */
    public final void mo3248y(AbstractC0473V abstractC0473V) {
        this.f4586E |= 8;
        int size = this.f4582A.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((AbstractC1293l) this.f4582A.get(i3)).mo3248y(abstractC0473V);
        }
    }

    @Override // p087d0.AbstractC1293l
    /* JADX INFO: renamed from: z */
    public final void mo3249z(TimeInterpolator timeInterpolator) {
        this.f4586E |= 1;
        ArrayList arrayList = this.f4582A;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((AbstractC1293l) this.f4582A.get(i3)).mo3249z(timeInterpolator);
            }
        }
        this.f4619h = timeInterpolator;
    }
}

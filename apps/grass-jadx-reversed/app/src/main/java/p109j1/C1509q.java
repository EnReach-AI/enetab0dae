package p109j1;

import p042N0.AbstractC0547o;
import p042N0.EnumC0548p;
import p069X0.AbstractC0725p;

/* JADX INFO: renamed from: j1.q */
/* JADX INFO: loaded from: classes.dex */
public final class C1509q extends AbstractC1510r {

    /* JADX INFO: renamed from: g */
    public AbstractC0725p f5457g;

    /* JADX INFO: renamed from: h */
    public boolean f5458h;

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: c */
    public final AbstractC0547o mo1215c() {
        return this.f5459d;
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: i */
    public final AbstractC0725p mo3552i() {
        if (this.f5458h) {
            return this.f5457g;
        }
        return null;
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: j */
    public final EnumC0548p mo3553j() {
        if (this.f5458h) {
            this.f5457g = null;
            return null;
        }
        this.f1309b++;
        this.f5458h = true;
        return this.f5457g.mo1240b();
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: k */
    public final C1507o mo3554k() {
        return new C1507o(this.f5457g, this);
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: l */
    public final C1508p mo3555l() {
        return new C1508p(this.f5457g, this);
    }
}

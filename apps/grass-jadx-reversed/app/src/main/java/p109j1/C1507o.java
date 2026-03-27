package p109j1;

import java.util.Iterator;
import p042N0.AbstractC0547o;
import p042N0.EnumC0548p;
import p069X0.AbstractC0725p;

/* JADX INFO: renamed from: j1.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1507o extends AbstractC1510r {

    /* JADX INFO: renamed from: g */
    public final Iterator f5452g;

    /* JADX INFO: renamed from: h */
    public AbstractC0725p f5453h;

    public C1507o(AbstractC0725p abstractC0725p, AbstractC1510r abstractC1510r) {
        super(1, abstractC1510r);
        this.f5452g = abstractC0725p.mo1902j();
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: c */
    public final AbstractC0547o mo1215c() {
        return this.f5459d;
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: i */
    public final AbstractC0725p mo3552i() {
        return this.f5453h;
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: j */
    public final EnumC0548p mo3553j() {
        Iterator it = this.f5452g;
        if (!it.hasNext()) {
            this.f5453h = null;
            return EnumC0548p.END_ARRAY;
        }
        this.f1309b++;
        AbstractC0725p abstractC0725p = (AbstractC0725p) it.next();
        this.f5453h = abstractC0725p;
        return abstractC0725p.mo1240b();
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: k */
    public final C1507o mo3554k() {
        return new C1507o(this.f5453h, this);
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: l */
    public final C1508p mo3555l() {
        return new C1508p(this.f5453h, this);
    }
}

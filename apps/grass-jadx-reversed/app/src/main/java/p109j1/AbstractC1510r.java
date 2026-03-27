package p109j1;

import p042N0.AbstractC0547o;
import p042N0.EnumC0548p;
import p069X0.AbstractC0725p;

/* JADX INFO: renamed from: j1.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1510r extends AbstractC0547o {

    /* JADX INFO: renamed from: d */
    public final AbstractC1510r f5459d;

    /* JADX INFO: renamed from: e */
    public String f5460e;

    /* JADX INFO: renamed from: f */
    public Object f5461f;

    public AbstractC1510r(int i3, AbstractC1510r abstractC1510r) {
        this.f1308a = i3;
        this.f1309b = -1;
        this.f5459d = abstractC1510r;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: a */
    public final String mo1213a() {
        return this.f5460e;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: b */
    public final Object mo1214b() {
        return this.f5461f;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: g */
    public final void mo1219g(Object obj) {
        this.f5461f = obj;
    }

    /* JADX INFO: renamed from: i */
    public abstract AbstractC0725p mo3552i();

    /* JADX INFO: renamed from: j */
    public abstract EnumC0548p mo3553j();

    /* JADX INFO: renamed from: k */
    public abstract C1507o mo3554k();

    /* JADX INFO: renamed from: l */
    public abstract C1508p mo3555l();
}

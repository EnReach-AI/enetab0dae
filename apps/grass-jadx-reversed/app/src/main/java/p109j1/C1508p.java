package p109j1;

import java.util.Iterator;
import java.util.Map;
import p042N0.AbstractC0547o;
import p042N0.EnumC0548p;
import p069X0.AbstractC0725p;

/* JADX INFO: renamed from: j1.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1508p extends AbstractC1510r {

    /* JADX INFO: renamed from: g */
    public final Iterator f5454g;

    /* JADX INFO: renamed from: h */
    public Map.Entry f5455h;

    /* JADX INFO: renamed from: i */
    public boolean f5456i;

    public C1508p(AbstractC0725p abstractC0725p, AbstractC1510r abstractC1510r) {
        super(2, abstractC1510r);
        this.f5454g = abstractC0725p.mo1903k();
        this.f5456i = true;
    }

    @Override // p042N0.AbstractC0547o
    /* JADX INFO: renamed from: c */
    public final AbstractC0547o mo1215c() {
        return this.f5459d;
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: i */
    public final AbstractC0725p mo3552i() {
        Map.Entry entry = this.f5455h;
        if (entry == null) {
            return null;
        }
        return (AbstractC0725p) entry.getValue();
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: j */
    public final EnumC0548p mo3553j() {
        if (!this.f5456i) {
            this.f5456i = true;
            return ((AbstractC0725p) this.f5455h.getValue()).mo1240b();
        }
        Iterator it = this.f5454g;
        if (!it.hasNext()) {
            this.f5460e = null;
            this.f5455h = null;
            return EnumC0548p.END_OBJECT;
        }
        this.f1309b++;
        this.f5456i = false;
        Map.Entry entry = (Map.Entry) it.next();
        this.f5455h = entry;
        this.f5460e = entry != null ? (String) entry.getKey() : null;
        return EnumC0548p.FIELD_NAME;
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: k */
    public final C1507o mo3554k() {
        return new C1507o(mo3552i(), this);
    }

    @Override // p109j1.AbstractC1510r
    /* JADX INFO: renamed from: l */
    public final C1508p mo3555l() {
        return new C1508p(mo3552i(), this);
    }
}

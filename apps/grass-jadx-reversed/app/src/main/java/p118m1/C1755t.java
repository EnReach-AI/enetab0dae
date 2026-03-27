package p118m1;

import java.io.Serializable;

/* JADX INFO: renamed from: m1.t */
/* JADX INFO: loaded from: classes.dex */
public final class C1755t extends AbstractC1757v implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f */
    public final AbstractC1757v f6134f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1757v f6135g;

    public C1755t(AbstractC1757v abstractC1757v, AbstractC1757v abstractC1757v2) {
        this.f6134f = abstractC1757v;
        this.f6135g = abstractC1757v2;
    }

    @Override // p118m1.AbstractC1757v
    /* JADX INFO: renamed from: a */
    public final String mo3911a(String str) {
        return this.f6134f.mo3911a(this.f6135g.mo3911a(str));
    }

    public final String toString() {
        return "[ChainedTransformer(" + this.f6134f + ", " + this.f6135g + ")]";
    }
}

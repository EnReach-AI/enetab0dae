package p118m1;

import p005B.AbstractC0032g;

/* JADX INFO: renamed from: m1.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1753r extends AbstractC1757v {

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ String f6130f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ String f6131g;

    public C1753r(String str, String str2) {
        this.f6130f = str;
        this.f6131g = str2;
    }

    @Override // p118m1.AbstractC1757v
    /* JADX INFO: renamed from: a */
    public final String mo3911a(String str) {
        return this.f6130f + str + this.f6131g;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[PreAndSuffixTransformer('");
        sb.append(this.f6130f);
        sb.append("','");
        return AbstractC0032g.m157o(sb, this.f6131g, "')]");
    }
}

package p114l1;

import java.util.StringTokenizer;

/* JADX INFO: renamed from: l1.r */
/* JADX INFO: loaded from: classes.dex */
public final class C1676r extends StringTokenizer {

    /* JADX INFO: renamed from: a */
    public final String f5953a;

    /* JADX INFO: renamed from: b */
    public int f5954b;

    /* JADX INFO: renamed from: c */
    public String f5955c;

    public C1676r(String str) {
        super(str, "<,>", true);
        this.f5953a = str;
    }

    @Override // java.util.StringTokenizer
    public final boolean hasMoreTokens() {
        return this.f5955c != null || super.hasMoreTokens();
    }

    @Override // java.util.StringTokenizer
    public final String nextToken() {
        String str = this.f5955c;
        if (str != null) {
            this.f5955c = null;
            return str;
        }
        String strNextToken = super.nextToken();
        this.f5954b = strNextToken.length() + this.f5954b;
        return strNextToken.trim();
    }
}

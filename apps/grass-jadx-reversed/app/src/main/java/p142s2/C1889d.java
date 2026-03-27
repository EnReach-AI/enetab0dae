package p142s2;

import java.io.Serializable;
import java.util.regex.Pattern;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: s2.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1889d implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: e */
    public final String f6642e;

    /* JADX INFO: renamed from: f */
    public final int f6643f;

    public C1889d(int i3, String str) {
        this.f6642e = str;
        this.f6643f = i3;
    }

    private final Object readResolve() {
        Pattern patternCompile = Pattern.compile(this.f6642e, this.f6643f);
        AbstractC1766e.m3919d("compile(...)", patternCompile);
        return new C1890e(patternCompile);
    }
}

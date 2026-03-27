package p142s2;

import java.nio.charset.Charset;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: s2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1886a {

    /* JADX INFO: renamed from: a */
    public static final Charset f6631a;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        AbstractC1766e.m3919d("forName(...)", charsetForName);
        f6631a = charsetForName;
        AbstractC1766e.m3919d("forName(...)", Charset.forName("UTF-16"));
        AbstractC1766e.m3919d("forName(...)", Charset.forName("UTF-16BE"));
        AbstractC1766e.m3919d("forName(...)", Charset.forName("UTF-16LE"));
        AbstractC1766e.m3919d("forName(...)", Charset.forName("US-ASCII"));
        AbstractC1766e.m3919d("forName(...)", Charset.forName("ISO-8859-1"));
    }
}

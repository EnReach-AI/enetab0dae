package p066W0;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: W0.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0682i extends ConcurrentHashMap {

    /* JADX INFO: renamed from: f */
    public static final C0682i f1857f = new C0682i();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Object f1858e;

    public C0682i() {
        super(180, 0.8f, 4);
        this.f1858e = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final String m1642a(String str) {
        String str2 = (String) get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.f1858e) {
                try {
                    if (size() >= 180) {
                        clear();
                    }
                } finally {
                }
            }
        }
        String strIntern = str.intern();
        put(strIntern, strIntern);
        return strIntern;
    }
}

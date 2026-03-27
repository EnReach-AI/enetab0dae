package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: renamed from: androidx.lifecycle.K */
/* JADX INFO: loaded from: classes.dex */
public final class C0966K {

    /* JADX INFO: renamed from: a */
    public final HashMap f3303a = new HashMap();

    /* JADX INFO: renamed from: a */
    public final void m2505a() {
        for (AbstractC0964I abstractC0964I : this.f3303a.values()) {
            HashMap map = abstractC0964I.f3299a;
            if (map != null) {
                synchronized (map) {
                    try {
                        for (Object obj : abstractC0964I.f3299a.values()) {
                            if (obj instanceof Closeable) {
                                try {
                                    ((Closeable) obj).close();
                                } catch (IOException e3) {
                                    throw new RuntimeException(e3);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = abstractC0964I.f3300b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        for (Closeable closeable : abstractC0964I.f3300b) {
                            if (closeable instanceof Closeable) {
                                try {
                                    closeable.close();
                                } catch (IOException e4) {
                                    throw new RuntimeException(e4);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            abstractC0964I.mo1631a();
        }
        this.f3303a.clear();
    }
}

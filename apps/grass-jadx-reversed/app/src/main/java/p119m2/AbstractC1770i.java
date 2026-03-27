package p119m2;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: m2.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1770i {

    /* JADX INFO: renamed from: a */
    public static final C1771j f6147a;

    static {
        C1771j c1771j = null;
        try {
            c1771j = (C1771j) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c1771j == null) {
            c1771j = new C1771j();
        }
        f6147a = c1771j;
    }

    /* JADX INFO: renamed from: a */
    public static C1763b m3927a(Class cls) {
        f6147a.getClass();
        return new C1763b(cls);
    }

    /* JADX INFO: renamed from: b */
    public static C1774m m3928b(Class cls) {
        C1763b c1763bM3927a = m3927a(cls);
        List listEmptyList = Collections.emptyList();
        f6147a.getClass();
        return new C1774m(c1763bM3927a, listEmptyList);
    }
}

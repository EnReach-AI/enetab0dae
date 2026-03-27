package p086c2;

import java.util.Collection;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: c2.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1087f extends AbstractC1086e {
    /* JADX INFO: renamed from: v */
    public static int m2838v(Iterable iterable, int i3) {
        AbstractC1766e.m3920e("<this>", iterable);
        return iterable instanceof Collection ? ((Collection) iterable).size() : i3;
    }
}

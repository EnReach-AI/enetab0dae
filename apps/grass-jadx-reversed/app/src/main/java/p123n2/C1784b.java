package p123n2;

import java.util.Random;

/* JADX INFO: renamed from: n2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1784b extends ThreadLocal {
    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        return new Random();
    }
}

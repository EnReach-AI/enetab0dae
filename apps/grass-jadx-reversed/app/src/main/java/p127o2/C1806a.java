package p127o2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import p119m2.AbstractC1766e;
import p123n2.AbstractC1783a;

/* JADX INFO: renamed from: o2.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1806a extends AbstractC1783a {
    @Override // p123n2.AbstractC1783a
    /* JADX INFO: renamed from: a */
    public final Random mo3944a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        AbstractC1766e.m3919d("current(...)", threadLocalRandomCurrent);
        return threadLocalRandomCurrent;
    }
}

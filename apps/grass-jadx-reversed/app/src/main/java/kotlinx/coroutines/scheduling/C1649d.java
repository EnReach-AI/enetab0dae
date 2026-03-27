package kotlinx.coroutines.scheduling;

/* JADX INFO: renamed from: kotlinx.coroutines.scheduling.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1649d extends AbstractC1652g {

    /* JADX INFO: renamed from: g */
    public static final C1649d f5860g = new C1649d(AbstractC1654i.f5867b, AbstractC1654i.f5868c, AbstractC1654i.f5869d);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // p150u2.AbstractC1954c
    public final String toString() {
        return "Dispatchers.Default";
    }
}

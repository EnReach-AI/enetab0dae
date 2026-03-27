package p131p2;

import java.util.Iterator;
import p125o0.AbstractC1794d;

/* JADX INFO: renamed from: p2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1827a implements Iterable {

    /* JADX INFO: renamed from: e */
    public final char f6331e;

    /* JADX INFO: renamed from: f */
    public final char f6332f;

    /* JADX INFO: renamed from: g */
    public final int f6333g = 1;

    public AbstractC1827a(char c3, char c4) {
        this.f6331e = c3;
        this.f6332f = (char) AbstractC1794d.m3950f(c3, c4, 1);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new C1828b(this.f6331e, this.f6332f, this.f6333g);
    }
}

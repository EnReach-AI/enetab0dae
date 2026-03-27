package p142s2;

import java.util.Iterator;
import p115l2.InterfaceC1693p;
import p119m2.AbstractC1766e;
import p139r2.InterfaceC1855b;

/* JADX INFO: renamed from: s2.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1888c implements InterfaceC1855b {

    /* JADX INFO: renamed from: a */
    public final CharSequence f6638a;

    /* JADX INFO: renamed from: b */
    public final int f6639b;

    /* JADX INFO: renamed from: c */
    public final int f6640c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1693p f6641d;

    public C1888c(CharSequence charSequence, int i3, int i4, C1901p c1901p) {
        AbstractC1766e.m3920e("input", charSequence);
        this.f6638a = charSequence;
        this.f6639b = i3;
        this.f6640c = i4;
        this.f6641d = c1901p;
    }

    @Override // p139r2.InterfaceC1855b
    public final Iterator iterator() {
        return new C1887b(this);
    }
}

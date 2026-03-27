package p015D2;

import java.util.LinkedHashMap;
import p089d2.InterfaceC1312f;
import p097f2.AbstractC1350c;
import p125o0.C1803m;

/* JADX INFO: renamed from: D2.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0194r extends AbstractC1350c {

    /* JADX INFO: renamed from: h */
    public C1803m f449h;

    /* JADX INFO: renamed from: i */
    public C0195s f450i;

    /* JADX INFO: renamed from: j */
    public LinkedHashMap f451j;

    /* JADX INFO: renamed from: k */
    public String f452k;

    /* JADX INFO: renamed from: l */
    public /* synthetic */ Object f453l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C0195s f454m;

    /* JADX INFO: renamed from: n */
    public int f455n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0194r(C0195s c0195s, InterfaceC1312f interfaceC1312f) {
        super(interfaceC1312f, interfaceC1312f != null ? interfaceC1312f.mo3283d() : null);
        this.f454m = c0195s;
    }

    @Override // p097f2.AbstractC1348a
    /* JADX INFO: renamed from: g */
    public final Object mo339g(Object obj) {
        this.f453l = obj;
        this.f455n |= Integer.MIN_VALUE;
        return C0195s.m340d(this.f454m, null, this);
    }
}

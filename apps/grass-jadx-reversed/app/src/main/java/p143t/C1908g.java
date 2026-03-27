package p143t;

/* JADX INFO: renamed from: t.g */
/* JADX INFO: loaded from: classes.dex */
public class C1908g extends C1907f {

    /* JADX INFO: renamed from: m */
    public int f6680m;

    public C1908g(AbstractC1914m abstractC1914m) {
        super(abstractC1914m);
        if (abstractC1914m instanceof C1911j) {
            this.f6672e = 2;
        } else {
            this.f6672e = 3;
        }
    }

    @Override // p143t.C1907f
    /* JADX INFO: renamed from: d */
    public final void mo4250d(int i3) {
        if (this.f6677j) {
            return;
        }
        this.f6677j = true;
        this.f6674g = i3;
        for (InterfaceC1905d interfaceC1905d : this.f6678k) {
            interfaceC1905d.mo4233a(interfaceC1905d);
        }
    }
}

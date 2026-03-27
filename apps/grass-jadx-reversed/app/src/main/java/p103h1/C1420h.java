package p103h1;

import p039M0.EnumC0471T;
import p069X0.InterfaceC0714e;

/* JADX INFO: renamed from: h1.h */
/* JADX INFO: loaded from: classes.dex */
public class C1420h extends C1415c {

    /* JADX INFO: renamed from: e */
    public final String f5047e;

    public C1420h(AbstractC1429q abstractC1429q, InterfaceC0714e interfaceC0714e, String str) {
        super(abstractC1429q, interfaceC0714e, 1);
        this.f5047e = str;
    }

    @Override // p103h1.AbstractC1431s, p100g1.AbstractC1399h
    /* JADX INFO: renamed from: b */
    public final String mo3101b() {
        return this.f5047e;
    }

    @Override // p103h1.C1415c, p100g1.AbstractC1399h
    /* JADX INFO: renamed from: c */
    public EnumC0471T mo3102c() {
        return EnumC0471T.f1107e;
    }

    @Override // p103h1.C1415c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public C1420h mo3422g(InterfaceC0714e interfaceC0714e) {
        return this.f5075b == interfaceC0714e ? this : new C1420h(this.f5074a, interfaceC0714e, this.f5047e);
    }
}

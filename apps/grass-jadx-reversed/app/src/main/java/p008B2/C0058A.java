package p008B2;

import java.util.Arrays;
import p004A2.InterfaceC0025b;
import p015D2.C0198v;
import p083b2.C1065j;
import p086c2.AbstractC1084c;
import p119m2.AbstractC1766e;
import p161x2.C2017f;
import p161x2.InterfaceC2012a;
import p167z2.InterfaceC2095g;

/* JADX INFO: renamed from: B2.A */
/* JADX INFO: loaded from: classes.dex */
public final class C0058A implements InterfaceC2012a {

    /* JADX INFO: renamed from: a */
    public final Enum[] f205a;

    /* JADX INFO: renamed from: b */
    public final C1065j f206b;

    public C0058A(String str, Enum[] enumArr) {
        this.f205a = enumArr;
        this.f206b = new C1065j(new C0136z(this, 0, str));
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: a */
    public final void mo219a(C0198v c0198v, Object obj) {
        Enum r5 = (Enum) obj;
        AbstractC1766e.m3920e("encoder", c0198v);
        AbstractC1766e.m3920e("value", r5);
        Enum[] enumArr = this.f205a;
        int iM2832z = AbstractC1084c.m2832z(enumArr, r5);
        if (iM2832z != -1) {
            c0198v.m355g(mo221c(), iM2832z);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(r5);
        sb.append(" is not a valid enum ");
        sb.append(mo221c().mo233d());
        sb.append(", must be one of ");
        String string = Arrays.toString(enumArr);
        AbstractC1766e.m3919d("toString(this)", string);
        sb.append(string);
        throw new C2017f(sb.toString());
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: b */
    public final Object mo220b(InterfaceC0025b interfaceC0025b) {
        AbstractC1766e.m3920e("decoder", interfaceC0025b);
        int iMo103y = interfaceC0025b.mo103y(mo221c());
        Enum[] enumArr = this.f205a;
        if (iMo103y >= 0 && iMo103y < enumArr.length) {
            return enumArr[iMo103y];
        }
        throw new C2017f(iMo103y + " is not among valid " + mo221c().mo233d() + " enum values, values size is " + enumArr.length);
    }

    @Override // p161x2.InterfaceC2012a
    /* JADX INFO: renamed from: c */
    public final InterfaceC2095g mo221c() {
        return (InterfaceC2095g) this.f206b.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + mo221c().mo233d() + '>';
    }
}

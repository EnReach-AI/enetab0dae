package p118m1;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import p042N0.InterfaceC0551s;
import p050Q0.C0597j;
import p074Z0.AbstractC0832r;
import p074Z0.EnumC0830p;

/* JADX INFO: renamed from: m1.o */
/* JADX INFO: loaded from: classes.dex */
public final class C1750o implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Class f6123e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC0551s[] f6124f;

    public C1750o(Class cls, InterfaceC0551s[] interfaceC0551sArr) {
        this.f6123e = cls;
        this.f6124f = interfaceC0551sArr;
    }

    /* JADX INFO: renamed from: a */
    public static C1750o m3909a(AbstractC0832r abstractC0832r, Class cls) {
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        Class superclass = cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
        Enum[] enumArr = (Enum[]) superclass.getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("Cannot determine enum constants for Class ".concat(cls.getName()));
        }
        String[] strArrMo1779m = abstractC0832r.m2149d().mo1779m(superclass, enumArr, new String[enumArr.length]);
        InterfaceC0551s[] interfaceC0551sArr = new InterfaceC0551s[enumArr.length];
        int length = enumArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Enum r5 = enumArr[i3];
            String lowerCase = strArrMo1779m[i3];
            if (lowerCase == null) {
                lowerCase = r5.name();
            }
            if (abstractC0832r.mo1694m(EnumC0830p.f2472g)) {
                lowerCase = lowerCase.toLowerCase();
            }
            interfaceC0551sArr[r5.ordinal()] = new C0597j(lowerCase);
        }
        return new C1750o(cls, interfaceC0551sArr);
    }
}

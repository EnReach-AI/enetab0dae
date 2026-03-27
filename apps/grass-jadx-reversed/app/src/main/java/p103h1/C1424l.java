package p103h1;

import p069X0.AbstractC0715f;
import p069X0.AbstractC0721l;
import p100g1.AbstractC1396e;
import p114l1.C1675q;

/* JADX INFO: renamed from: h1.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1424l extends C1422j {

    /* JADX INFO: renamed from: d */
    public final String f5050d;

    /* JADX INFO: renamed from: e */
    public final String f5051e;

    public C1424l(AbstractC0721l abstractC0721l, C1675q c1675q, AbstractC1396e abstractC1396e) {
        super(abstractC0721l, c1675q, abstractC1396e);
        String name = abstractC0721l.f2036e.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.f5050d = "";
            this.f5051e = ".";
        } else {
            this.f5051e = name.substring(0, iLastIndexOf + 1);
            this.f5050d = name.substring(0, iLastIndexOf);
        }
    }

    @Override // p103h1.C1422j, p103h1.AbstractC1429q
    /* JADX INFO: renamed from: b */
    public final String mo3428b(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.f5051e) ? name.substring(r0.length() - 1) : name;
    }

    @Override // p103h1.C1422j
    /* JADX INFO: renamed from: f */
    public final AbstractC0721l mo3432f(AbstractC0715f abstractC0715f, String str) {
        if (str.startsWith(".")) {
            int length = str.length();
            String str2 = this.f5050d;
            StringBuilder sb = new StringBuilder(str2.length() + length);
            if (str2.isEmpty()) {
                sb.append(str.substring(1));
            } else {
                sb.append(str2);
                sb.append(str);
            }
            str = sb.toString();
        }
        return super.mo3432f(abstractC0715f, str);
    }
}

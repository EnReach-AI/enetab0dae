package p078a1;

import java.lang.annotation.Annotation;
import p069X0.AbstractC0718i;
import p069X0.C0703E;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: a1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0852d extends C0850b {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: i */
    public static C0852d m2187i(AbstractC0718i abstractC0718i, C0703E c0703e) {
        String str;
        Annotation[] annotationArr = AbstractC1745j.f6110a;
        if (c0703e == null) {
            str = "<UNKNOWN>";
        } else {
            str = "\"" + c0703e + "\"";
        }
        return new C0852d(abstractC0718i.f2002k, "Invalid `null` value encountered for property ".concat(str));
    }
}

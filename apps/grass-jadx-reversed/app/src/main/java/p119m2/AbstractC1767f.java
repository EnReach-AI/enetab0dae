package p119m2;

import java.io.Serializable;

/* JADX INFO: renamed from: m2.f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1767f implements InterfaceC1765d, Serializable {

    /* JADX INFO: renamed from: e */
    public final int f6144e;

    public AbstractC1767f(int i3) {
        this.f6144e = i3;
    }

    @Override // p119m2.InterfaceC1765d
    /* JADX INFO: renamed from: b */
    public final int mo316b() {
        return this.f6144e;
    }

    public final String toString() {
        AbstractC1770i.f6147a.getClass();
        String string = getClass().getGenericInterfaces()[0].toString();
        if (string.startsWith("kotlin.jvm.functions.")) {
            string = string.substring(21);
        }
        AbstractC1766e.m3919d("renderLambdaToString(...)", string);
        return string;
    }
}

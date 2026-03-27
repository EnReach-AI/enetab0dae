package p079a2;

import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: a2.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0862g implements Cloneable {

    /* JADX INFO: renamed from: f */
    public static final C0862g f2541f;

    /* JADX INFO: renamed from: e */
    public String f2542e;

    static {
        C0862g c0862g = new C0862g();
        f2541f = c0862g;
        c0862g.f2542e = "GrassStorage";
    }

    public final Object clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        AbstractC1766e.m3918c("null cannot be cast to non-null type io.getgrass.plugin.PreferencesConfiguration", objClone);
        return (C0862g) objClone;
    }
}

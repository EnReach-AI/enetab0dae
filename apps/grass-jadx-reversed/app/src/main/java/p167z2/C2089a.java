package p167z2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p086c2.C1093l;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: z2.a */
/* JADX INFO: loaded from: classes.dex */
public final class C2089a {

    /* JADX INFO: renamed from: a */
    public final String f7385a;

    /* JADX INFO: renamed from: b */
    public List f7386b;

    /* JADX INFO: renamed from: c */
    public final ArrayList f7387c;

    /* JADX INFO: renamed from: d */
    public final HashSet f7388d;

    /* JADX INFO: renamed from: e */
    public final ArrayList f7389e;

    /* JADX INFO: renamed from: f */
    public final ArrayList f7390f;

    /* JADX INFO: renamed from: g */
    public final ArrayList f7391g;

    public C2089a(String str) {
        AbstractC1766e.m3920e("serialName", str);
        this.f7385a = str;
        this.f7386b = C1093l.f3782e;
        this.f7387c = new ArrayList();
        this.f7388d = new HashSet();
        this.f7389e = new ArrayList();
        this.f7390f = new ArrayList();
        this.f7391g = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    public static void m4643a(C2089a c2089a, String str, InterfaceC2095g interfaceC2095g) {
        C1093l c1093l = C1093l.f3782e;
        c2089a.getClass();
        AbstractC1766e.m3920e("descriptor", interfaceC2095g);
        if (c2089a.f7388d.add(str)) {
            c2089a.f7387c.add(str);
            c2089a.f7389e.add(interfaceC2095g);
            c2089a.f7390f.add(c1093l);
            c2089a.f7391g.add(false);
            return;
        }
        throw new IllegalArgumentException(("Element with name '" + str + "' is already registered in " + c2089a.f7385a).toString());
    }
}

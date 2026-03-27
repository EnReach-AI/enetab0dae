package p116m;

import java.util.HashMap;

/* JADX INFO: renamed from: m.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1700a extends C1705f {

    /* JADX INFO: renamed from: i */
    public final HashMap f5957i = new HashMap();

    @Override // p116m.C1705f
    /* JADX INFO: renamed from: a */
    public final C1702c mo3783a(Object obj) {
        return (C1702c) this.f5957i.get(obj);
    }

    @Override // p116m.C1705f
    /* JADX INFO: renamed from: b */
    public final Object mo3784b(Object obj) {
        Object objMo3784b = super.mo3784b(obj);
        this.f5957i.remove(obj);
        return objMo3784b;
    }

    /* JADX INFO: renamed from: c */
    public final Object m3785c(Object obj, Object obj2) {
        C1702c c1702cMo3783a = mo3783a(obj);
        if (c1702cMo3783a != null) {
            return c1702cMo3783a.f5962f;
        }
        HashMap map = this.f5957i;
        C1702c c1702c = new C1702c(obj, obj2);
        this.f5971h++;
        C1702c c1702c2 = this.f5969f;
        if (c1702c2 == null) {
            this.f5968e = c1702c;
            this.f5969f = c1702c;
        } else {
            c1702c2.f5963g = c1702c;
            c1702c.f5964h = c1702c2;
            this.f5969f = c1702c;
        }
        map.put(obj, c1702c);
        return null;
    }
}

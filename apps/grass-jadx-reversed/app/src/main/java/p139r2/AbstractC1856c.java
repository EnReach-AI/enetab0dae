package p139r2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p086c2.C1093l;
import p144t0.AbstractC1920f;

/* JADX INFO: renamed from: r2.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1856c extends AbstractC1857d {
    /* JADX INFO: renamed from: j */
    public static List m4134j(InterfaceC1855b interfaceC1855b) {
        Iterator it = interfaceC1855b.iterator();
        if (!it.hasNext()) {
            return C1093l.f3782e;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC1920f.m4310m(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}

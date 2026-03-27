package p116m;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: m.f */
/* JADX INFO: loaded from: classes.dex */
public class C1705f implements Iterable {

    /* JADX INFO: renamed from: e */
    public C1702c f5968e;

    /* JADX INFO: renamed from: f */
    public C1702c f5969f;

    /* JADX INFO: renamed from: g */
    public final WeakHashMap f5970g = new WeakHashMap();

    /* JADX INFO: renamed from: h */
    public int f5971h = 0;

    /* JADX INFO: renamed from: a */
    public C1702c mo3783a(Object obj) {
        C1702c c1702c = this.f5968e;
        while (c1702c != null && !c1702c.f5961e.equals(obj)) {
            c1702c = c1702c.f5963g;
        }
        return c1702c;
    }

    /* JADX INFO: renamed from: b */
    public Object mo3784b(Object obj) {
        C1702c c1702cMo3783a = mo3783a(obj);
        if (c1702cMo3783a == null) {
            return null;
        }
        this.f5971h--;
        WeakHashMap weakHashMap = this.f5970g;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((InterfaceC1704e) it.next()).mo3786a(c1702cMo3783a);
            }
        }
        C1702c c1702c = c1702cMo3783a.f5964h;
        if (c1702c != null) {
            c1702c.f5963g = c1702cMo3783a.f5963g;
        } else {
            this.f5968e = c1702cMo3783a.f5963g;
        }
        C1702c c1702c2 = c1702cMo3783a.f5963g;
        if (c1702c2 != null) {
            c1702c2.f5964h = c1702c;
        } else {
            this.f5969f = c1702c;
        }
        c1702cMo3783a.f5963g = null;
        c1702cMo3783a.f5964h = null;
        return c1702cMo3783a.f5962f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((p116m.C1701b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof p116m.C1705f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            m.f r7 = (p116m.C1705f) r7
            int r1 = r6.f5971h
            int r3 = r7.f5971h
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            m.b r3 = (p116m.C1701b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            m.b r4 = (p116m.C1701b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            m.b r7 = (p116m.C1701b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = r2
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p116m.C1705f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            C1701b c1701b = (C1701b) it;
            if (!c1701b.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) c1701b.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        C1701b c1701b = new C1701b(this.f5968e, this.f5969f, 0);
        this.f5970g.put(c1701b, Boolean.FALSE);
        return c1701b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            C1701b c1701b = (C1701b) it;
            if (!c1701b.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) c1701b.next()).toString());
            if (c1701b.hasNext()) {
                sb.append(", ");
            }
        }
    }
}

package p142s2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import p119m2.AbstractC1766e;
import p131p2.C1832f;

/* JADX INFO: renamed from: s2.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1887b implements Iterator {

    /* JADX INFO: renamed from: e */
    public int f6632e = -1;

    /* JADX INFO: renamed from: f */
    public int f6633f;

    /* JADX INFO: renamed from: g */
    public int f6634g;

    /* JADX INFO: renamed from: h */
    public C1832f f6635h;

    /* JADX INFO: renamed from: i */
    public int f6636i;

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1888c f6637j;

    public C1887b(C1888c c1888c) {
        this.f6637j = c1888c;
        int i3 = c1888c.f6639b;
        int length = c1888c.f6638a.length();
        if (length < 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > length) {
            i3 = length;
        }
        this.f6633f = i3;
        this.f6634g = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4216a() {
        /*
            r7 = this;
            int r0 = r7.f6634g
            r1 = 0
            if (r0 >= 0) goto Lb
            r7.f6632e = r1
            r0 = 0
            r7.f6635h = r0
            goto L7b
        Lb:
            s2.c r2 = r7.f6637j
            int r3 = r2.f6640c
            r4 = -1
            r5 = 1
            if (r3 <= 0) goto L1a
            int r6 = r7.f6636i
            int r6 = r6 + r5
            r7.f6636i = r6
            if (r6 >= r3) goto L22
        L1a:
            java.lang.CharSequence r3 = r2.f6638a
            int r3 = r3.length()
            if (r0 <= r3) goto L34
        L22:
            p2.f r0 = new p2.f
            int r1 = r7.f6633f
            java.lang.CharSequence r2 = r2.f6638a
            int r2 = p142s2.AbstractC1892g.m4219l(r2)
            r0.<init>(r1, r2, r5)
            r7.f6635h = r0
            r7.f6634g = r4
            goto L79
        L34:
            l2.p r0 = r2.f6641d
            java.lang.CharSequence r3 = r2.f6638a
            int r6 = r7.f6634g
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r0 = r0.mo317c(r3, r6)
            b2.f r0 = (p083b2.C1061f) r0
            if (r0 != 0) goto L58
            p2.f r0 = new p2.f
            int r1 = r7.f6633f
            java.lang.CharSequence r2 = r2.f6638a
            int r2 = p142s2.AbstractC1892g.m4219l(r2)
            r0.<init>(r1, r2, r5)
            r7.f6635h = r0
            r7.f6634g = r4
            goto L79
        L58:
            java.lang.Object r2 = r0.f3736e
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.f3737f
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r7.f6633f
            p2.f r3 = p071Y0.AbstractC0752p.m1938j(r3, r2)
            r7.f6635h = r3
            int r2 = r2 + r0
            r7.f6633f = r2
            if (r0 != 0) goto L76
            r1 = r5
        L76:
            int r2 = r2 + r1
            r7.f6634g = r2
        L79:
            r7.f6632e = r5
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p142s2.C1887b.m4216a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6632e == -1) {
            m4216a();
        }
        return this.f6632e == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f6632e == -1) {
            m4216a();
        }
        if (this.f6632e == 0) {
            throw new NoSuchElementException();
        }
        C1832f c1832f = this.f6635h;
        AbstractC1766e.m3918c("null cannot be cast to non-null type kotlin.ranges.IntRange", c1832f);
        this.f6635h = null;
        this.f6632e = -1;
        return c1832f;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

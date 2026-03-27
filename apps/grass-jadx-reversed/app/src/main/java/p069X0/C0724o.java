package p069X0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import p005B.AbstractC0032g;
import p042N0.AbstractC0535c;
import p042N0.AbstractC0545m;
import p042N0.AbstractC0546n;
import p042N0.C0541i;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: X0.o */
/* JADX INFO: loaded from: classes.dex */
public class C0724o extends AbstractC0716g {

    /* JADX INFO: renamed from: h */
    public static final /* synthetic */ int f2045h = 0;
    private static final long serialVersionUID = 3;

    /* JADX INFO: renamed from: f */
    public LinkedList f2046f;

    /* JADX INFO: renamed from: g */
    public final transient Closeable f2047g;

    public C0724o(Closeable closeable, String str) {
        super(str);
        this.f2047g = closeable;
        if (closeable instanceof AbstractC0545m) {
            this.f1307e = ((AbstractC0545m) closeable).mo1161F();
        }
    }

    /* JADX INFO: renamed from: f */
    public static C0724o m1893f(IOException iOException) {
        return new C0724o(null, AbstractC0032g.m155m("Unexpected IOException (of type ", iOException.getClass().getName(), "): ", AbstractC1745j.m3886i(iOException)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /* JADX INFO: renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p069X0.C0724o m1894g(java.lang.Throwable r3, p069X0.C0723n r4) {
        /*
            boolean r0 = r3 instanceof p069X0.C0724o
            if (r0 == 0) goto L7
            X0.o r3 = (p069X0.C0724o) r3
            goto L47
        L7:
            java.lang.String r0 = p118m1.AbstractC1745j.m3886i(r3)
            if (r0 == 0) goto L13
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L2e
        L13:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "(was "
            r0.<init>(r1)
            java.lang.Class r1 = r3.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L2e:
            boolean r1 = r3 instanceof p042N0.AbstractC0535c
            if (r1 == 0) goto L40
            r1 = r3
            N0.c r1 = (p042N0.AbstractC0535c) r1
            java.lang.Object r1 = r1.mo1083b()
            boolean r2 = r1 instanceof java.io.Closeable
            if (r2 == 0) goto L40
            java.io.Closeable r1 = (java.io.Closeable) r1
            goto L41
        L40:
            r1 = 0
        L41:
            X0.o r2 = new X0.o
            r2.<init>(r1, r0, r3)
            r3 = r2
        L47:
            java.util.LinkedList r0 = r3.f2046f
            if (r0 != 0) goto L52
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            r3.f2046f = r0
        L52:
            java.util.LinkedList r0 = r3.f2046f
            int r0 = r0.size()
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 >= r1) goto L61
            java.util.LinkedList r0 = r3.f2046f
            r0.addFirst(r4)
        L61:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p069X0.C0724o.m1894g(java.lang.Throwable, X0.n):X0.o");
    }

    /* JADX INFO: renamed from: h */
    public static C0724o m1895h(Throwable th, Object obj, int i3) {
        C0723n c0723n = new C0723n();
        c0723n.f2041e = obj;
        c0723n.f2043g = i3;
        return m1894g(th, c0723n);
    }

    @Override // p042N0.AbstractC0546n, p042N0.AbstractC0535c
    /* JADX INFO: renamed from: b */
    public final Object mo1083b() {
        return this.f2047g;
    }

    @Override // p069X0.AbstractC0716g
    /* JADX INFO: renamed from: d */
    public final void mo1816d(String str, Object obj) {
        C0723n c0723n = new C0723n(str, obj);
        if (this.f2046f == null) {
            this.f2046f = new LinkedList();
        }
        if (this.f2046f.size() < 1000) {
            this.f2046f.addFirst(c0723n);
        }
    }

    /* JADX INFO: renamed from: e */
    public final String m1896e() {
        String message = super.getMessage();
        if (this.f2046f == null) {
            return message;
        }
        StringBuilder sb = message == null ? new StringBuilder() : new StringBuilder(message);
        sb.append(" (through reference chain: ");
        LinkedList linkedList = this.f2046f;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(((C0723n) it.next()).m1892a());
                if (it.hasNext()) {
                    sb.append("->");
                }
            }
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return m1896e();
    }

    @Override // p042N0.AbstractC0546n, java.lang.Throwable
    public String getMessage() {
        return m1896e();
    }

    @Override // p042N0.AbstractC0546n, java.lang.Throwable
    public final String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public C0724o(Closeable closeable, String str, C0541i c0541i) {
        super(str, c0541i, null);
        this.f2047g = closeable;
    }

    public C0724o(Closeable closeable, String str, Throwable th) {
        super(str, null, th);
        this.f2047g = closeable;
        if (th instanceof AbstractC0535c) {
            this.f1307e = ((AbstractC0546n) ((AbstractC0535c) th)).f1307e;
        } else if (closeable instanceof AbstractC0545m) {
            this.f1307e = ((AbstractC0545m) closeable).mo1161F();
        }
    }
}

package p112k1;

import com.fasterxml.jackson.databind.ser.BeanSerializer;
import com.fasterxml.jackson.databind.ser.impl.C1216d;
import java.util.Collections;
import java.util.List;
import p069X0.AbstractC0712c;
import p069X0.C0707I;
import p069X0.EnumC0731v;
import p082b1.AbstractC1041l;
import p082b1.C1005A;

/* JADX INFO: renamed from: k1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1636d {

    /* JADX INFO: renamed from: i */
    public static final C1635c[] f5826i = new C1635c[0];

    /* JADX INFO: renamed from: a */
    public final AbstractC0712c f5827a;

    /* JADX INFO: renamed from: b */
    public C0707I f5828b;

    /* JADX INFO: renamed from: c */
    public List f5829c = Collections.emptyList();

    /* JADX INFO: renamed from: d */
    public C1635c[] f5830d;

    /* JADX INFO: renamed from: e */
    public C1633a f5831e;

    /* JADX INFO: renamed from: f */
    public Object f5832f;

    /* JADX INFO: renamed from: g */
    public AbstractC1041l f5833g;

    /* JADX INFO: renamed from: h */
    public C1216d f5834h;

    public C1636d(C1005A c1005a) {
        this.f5827a = c1005a;
    }

    /* JADX INFO: renamed from: a */
    public final BeanSerializer m3718a() {
        C1635c[] c1635cArr;
        if (this.f5833g != null && this.f5828b.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
            this.f5833g.m2799h(this.f5828b.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        C1633a c1633a = this.f5831e;
        if (c1633a != null) {
            c1633a.f5804b.m2799h(this.f5828b.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        List list = this.f5829c;
        if (list == null || list.isEmpty()) {
            if (this.f5831e == null && this.f5834h == null) {
                return null;
            }
            c1635cArr = f5826i;
        } else {
            List list2 = this.f5829c;
            c1635cArr = (C1635c[]) list2.toArray(new C1635c[list2.size()]);
            if (this.f5828b.m2157l(EnumC0731v.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
                for (C1635c c1635c : c1635cArr) {
                    C0707I c0707i = this.f5828b;
                    c1635c.getClass();
                    c1635c.f5815l.m2799h(c0707i.m2157l(EnumC0731v.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                }
            }
        }
        C1635c[] c1635cArr2 = this.f5830d;
        if (c1635cArr2 == null || c1635cArr2.length == this.f5829c.size()) {
            return new BeanSerializer(this.f5827a.f1980a, this, c1635cArr, this.f5830d);
        }
        throw new IllegalStateException(String.format("Mismatch between `properties` size (%d), `filteredProperties` (%s): should have as many (or `null` for latter)", Integer.valueOf(this.f5829c.size()), Integer.valueOf(this.f5830d.length)));
    }
}

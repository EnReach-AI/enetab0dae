package p112k1;

import com.fasterxml.jackson.databind.ser.std.MapSerializer;
import java.util.Map;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p069X0.C0713d;
import p069X0.InterfaceC0714e;
import p082b1.AbstractC1041l;

/* JADX INFO: renamed from: k1.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1633a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC0714e f5803a;

    /* JADX INFO: renamed from: b */
    public final AbstractC1041l f5804b;

    /* JADX INFO: renamed from: c */
    public AbstractC0728s f5805c;

    /* JADX INFO: renamed from: d */
    public MapSerializer f5806d;

    public C1633a(C0713d c0713d, AbstractC1041l abstractC1041l, AbstractC0728s abstractC0728s) {
        this.f5804b = abstractC1041l;
        this.f5803a = c0713d;
        this.f5805c = abstractC0728s;
        if (abstractC0728s instanceof MapSerializer) {
            this.f5806d = (MapSerializer) abstractC0728s;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3709a(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        AbstractC1041l abstractC1041l = this.f5804b;
        Object objMo2772l = abstractC1041l.mo2772l(obj);
        if (objMo2772l == null) {
            return;
        }
        if (objMo2772l instanceof Map) {
            MapSerializer mapSerializer = this.f5806d;
            if (mapSerializer != null) {
                mapSerializer.serializeWithoutTypeInfo((Map) objMo2772l, abstractC0540h, abstractC0709K);
                return;
            } else {
                this.f5805c.serialize(objMo2772l, abstractC0540h, abstractC0709K);
                return;
            }
        }
        this.f5803a.getType();
        abstractC0709K.mo1713k("Value returned by 'any-getter' " + abstractC1041l.mo2767d() + "() not java.util.Map but " + objMo2772l.getClass().getName());
        throw null;
    }
}

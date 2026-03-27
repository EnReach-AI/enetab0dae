package p069X0;

import java.util.Iterator;
import p005B.AbstractC0032g;
import p042N0.AbstractC0540h;
import p092e1.InterfaceC1338c;
import p100g1.AbstractC1399h;
import p112k1.AbstractC1642j;
import p118m1.AbstractC1745j;
import p118m1.AbstractC1757v;

/* JADX INFO: renamed from: X0.s */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0728s {
    public void acceptJsonFormatVisitor(InterfaceC1338c interfaceC1338c, AbstractC0721l abstractC0721l) {
        interfaceC1338c.getClass();
    }

    public AbstractC0728s getDelegatee() {
        return null;
    }

    public Class<Object> handledType() {
        return null;
    }

    @Deprecated
    public boolean isEmpty(Object obj) {
        return isEmpty(null, obj);
    }

    public boolean isUnwrappingSerializer() {
        return false;
    }

    public Iterator<AbstractC1642j> properties() {
        return AbstractC1745j.f6112c;
    }

    public AbstractC0728s replaceDelegatee(AbstractC0728s abstractC0728s) {
        throw new UnsupportedOperationException();
    }

    public abstract void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K);

    public void serializeWithType(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        Class<?> clsHandledType = handledType();
        if (clsHandledType == null) {
            clsHandledType = obj.getClass();
        }
        abstractC0709K.m1815j(clsHandledType, AbstractC0032g.m156n("Type id handling not implemented for type ", clsHandledType.getName(), " (by serializer of type ", getClass().getName(), ")"));
    }

    public AbstractC0728s unwrappingSerializer(AbstractC1757v abstractC1757v) {
        return this;
    }

    public boolean usesObjectId() {
        return false;
    }

    public AbstractC0728s withFilterId(Object obj) {
        return this;
    }

    public boolean isEmpty(AbstractC0709K abstractC0709K, Object obj) {
        return obj == null;
    }
}

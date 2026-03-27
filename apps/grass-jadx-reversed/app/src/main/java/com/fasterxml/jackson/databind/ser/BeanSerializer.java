package com.fasterxml.jackson.databind.ser;

import com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.C1216d;
import com.fasterxml.jackson.databind.ser.impl.UnwrappingBeanSerializer;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import java.io.IOException;
import java.util.Set;
import p042N0.AbstractC0540h;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0721l;
import p069X0.AbstractC0728s;
import p112k1.C1635c;
import p112k1.C1636d;
import p118m1.AbstractC1757v;

/* JADX INFO: loaded from: classes.dex */
public class BeanSerializer extends BeanSerializerBase {
    private static final long serialVersionUID = 29;

    public BeanSerializer(AbstractC0721l abstractC0721l, C1636d c1636d, C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        super(abstractC0721l, c1636d, c1635cArr, c1635cArr2);
    }

    @Deprecated
    public static BeanSerializer createDummy(AbstractC0721l abstractC0721l) {
        return new BeanSerializer(abstractC0721l, null, BeanSerializerBase.NO_PROPS, null);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase asArraySerializer() {
        return (this._objectIdWriter == null && this._anyGetterWriter == null && this._propertyFilterId == null) ? new BeanAsArraySerializer(this) : this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public final void serialize(Object obj, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) throws IOException {
        if (this._objectIdWriter != null) {
            abstractC0540h.mo1136i(obj);
            _serializeWithObjectId(obj, abstractC0540h, abstractC0709K, true);
            return;
        }
        abstractC0540h.mo1121N(obj);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, abstractC0540h, abstractC0709K);
        } else {
            serializeFields(obj, abstractC0540h, abstractC0709K);
        }
        abstractC0540h.mo1143p();
    }

    public String toString() {
        return "BeanSerializer for ".concat(handledType().getName());
    }

    @Override // p069X0.AbstractC0728s
    public AbstractC0728s unwrappingSerializer(AbstractC1757v abstractC1757v) {
        return new UnwrappingBeanSerializer(this, abstractC1757v);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withByNameInclusion(Set<String> set, Set<String> set2) {
        return new BeanSerializer(this, set, set2);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withObjectIdWriter(C1216d c1216d) {
        return new BeanSerializer(this, c1216d, this._propertyFilterId);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase
    public BeanSerializerBase withProperties(C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        return new BeanSerializer(this, c1635cArr, c1635cArr2);
    }

    public BeanSerializer(BeanSerializerBase beanSerializerBase) {
        super(beanSerializerBase);
    }

    public static BeanSerializer createDummy(AbstractC0721l abstractC0721l, C1636d c1636d) {
        return new BeanSerializer(abstractC0721l, c1636d, BeanSerializerBase.NO_PROPS, null);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.BeanSerializerBase, p069X0.AbstractC0728s
    public BeanSerializerBase withFilterId(Object obj) {
        return new BeanSerializer(this, this._objectIdWriter, obj);
    }

    public BeanSerializer(BeanSerializerBase beanSerializerBase, C1216d c1216d) {
        super(beanSerializerBase, c1216d);
    }

    public BeanSerializer(BeanSerializerBase beanSerializerBase, C1216d c1216d, Object obj) {
        super(beanSerializerBase, c1216d, obj);
    }

    public BeanSerializer(BeanSerializerBase beanSerializerBase, Set<String> set, Set<String> set2) {
        super(beanSerializerBase, set, set2);
    }

    public BeanSerializer(BeanSerializerBase beanSerializerBase, C1635c[] c1635cArr, C1635c[] c1635cArr2) {
        super(beanSerializerBase, c1635cArr, c1635cArr2);
    }
}

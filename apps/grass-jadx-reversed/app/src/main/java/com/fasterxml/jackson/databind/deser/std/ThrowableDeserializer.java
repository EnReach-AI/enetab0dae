package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.deser.AbstractC1183r;
import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import java.io.IOException;
import java.util.Set;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p118m1.AbstractC1757v;

/* JADX INFO: loaded from: classes.dex */
public class ThrowableDeserializer extends BeanDeserializer {
    protected static final String PROP_NAME_LOCALIZED_MESSAGE = "localizedMessage";
    protected static final String PROP_NAME_MESSAGE = "message";
    protected static final String PROP_NAME_SUPPRESSED = "suppressed";
    private static final long serialVersionUID = 1;

    @Deprecated
    public ThrowableDeserializer(BeanDeserializer beanDeserializer) {
        super(beanDeserializer);
        this._vanillaProcessing = false;
    }

    public static ThrowableDeserializer construct(AbstractC0718i abstractC0718i, BeanDeserializer beanDeserializer) {
        return new ThrowableDeserializer(beanDeserializer);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializer, com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public Object deserializeFromObject(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws IOException {
        if (this._propertyBasedCreator != null) {
            return _deserializeUsingPropertyBased(abstractC0545m, abstractC0718i);
        }
        AbstractC0722m abstractC0722m = this._delegateDeserializer;
        if (abstractC0722m != null) {
            return this._valueInstantiator.mo3071x(abstractC0718i, abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
        }
        if (this._beanType.mo1884s()) {
            abstractC0718i.m1860y(handledType(), getValueInstantiator(), "abstract type (need to add/enable type information?)", new Object[0]);
            throw null;
        }
        boolean zMo3059h = this._valueInstantiator.mo3059h();
        boolean zMo3005j = this._valueInstantiator.mo3005j();
        if (!zMo3059h && !zMo3005j) {
            abstractC0718i.m1860y(handledType(), getValueInstantiator(), "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
            throw null;
        }
        Throwable th = null;
        Object[] objArr = null;
        Throwable[] thArr = null;
        int i3 = 0;
        while (!abstractC0545m.mo1168M(EnumC0548p.END_OBJECT)) {
            String strMo1188d = abstractC0545m.mo1188d();
            AbstractC1204t abstractC1204tM2984d = this._beanProperties.m2984d(strMo1188d);
            abstractC0545m.mo1177V();
            if (abstractC1204tM2984d != null) {
                if (th != null) {
                    abstractC1204tM2984d.mo2967k(abstractC0545m, abstractC0718i, th);
                } else {
                    if (objArr == null) {
                        int i4 = this._beanProperties.f3970g;
                        objArr = new Object[i4 + i4];
                    }
                    int i5 = i3 + 1;
                    objArr[i3] = abstractC1204tM2984d;
                    i3 += 2;
                    objArr[i5] = abstractC1204tM2984d.m3079j(abstractC0545m, abstractC0718i);
                }
            } else if (PROP_NAME_MESSAGE.equalsIgnoreCase(strMo1188d) && zMo3059h) {
                th = (Throwable) this._valueInstantiator.mo3068t(abstractC0718i, abstractC0545m.mo1165J());
            } else {
                Set<String> set = this._ignorableProps;
                if (set != null && set.contains(strMo1188d)) {
                    abstractC0545m.mo1187c0();
                } else if (PROP_NAME_SUPPRESSED.equalsIgnoreCase(strMo1188d)) {
                    thArr = (Throwable[]) abstractC0718i.m1837O(abstractC0545m, Throwable[].class);
                } else if (PROP_NAME_LOCALIZED_MESSAGE.equalsIgnoreCase(strMo1188d)) {
                    abstractC0545m.mo1187c0();
                } else {
                    AbstractC1183r abstractC1183r = this._anySetter;
                    if (abstractC1183r != null) {
                        abstractC1183r.mo3023c(abstractC0545m, abstractC0718i, th, strMo1188d);
                    } else {
                        handleUnknownProperty(abstractC0545m, abstractC0718i, th, strMo1188d);
                    }
                }
            }
            abstractC0545m.mo1177V();
        }
        if (th == null) {
            th = zMo3059h ? (Throwable) this._valueInstantiator.mo3068t(abstractC0718i, null) : (Throwable) this._valueInstantiator.mo3007v(abstractC0718i);
        }
        if (objArr != null) {
            for (int i6 = 0; i6 < i3; i6 += 2) {
                ((AbstractC1204t) objArr[i6]).mo2961B(th, objArr[i6 + 1]);
            }
        }
        if (thArr != null) {
            for (Throwable th2 : thArr) {
                th.addSuppressed(th2);
            }
        }
        return th;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializer, com.fasterxml.jackson.databind.deser.BeanDeserializerBase, p069X0.AbstractC0722m
    public AbstractC0722m unwrappingDeserializer(AbstractC1757v abstractC1757v) {
        return getClass() != ThrowableDeserializer.class ? this : new ThrowableDeserializer(this, abstractC1757v);
    }

    public ThrowableDeserializer(BeanDeserializer beanDeserializer, AbstractC1757v abstractC1757v) {
        super(beanDeserializer, abstractC1757v);
    }
}

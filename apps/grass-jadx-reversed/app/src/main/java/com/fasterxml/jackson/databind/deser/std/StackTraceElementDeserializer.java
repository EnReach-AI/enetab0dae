package com.fasterxml.jackson.databind.deser.std;

import p005B.AbstractC0032g;
import p042N0.AbstractC0545m;
import p042N0.EnumC0548p;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;
import p069X0.EnumC0719j;
import p078a1.C0850b;

/* JADX INFO: loaded from: classes.dex */
public class StackTraceElementDeserializer extends StdScalarDeserializer<StackTraceElement> {
    private static final long serialVersionUID = 1;
    protected final AbstractC0722m _adapterDeserializer;

    @Deprecated
    public StackTraceElementDeserializer() {
        this(null);
    }

    public static AbstractC0722m construct(AbstractC0718i abstractC0718i) {
        if (abstractC0718i == null) {
            return new StackTraceElementDeserializer();
        }
        return new StackTraceElementDeserializer(abstractC0718i.f1996e.m3020f(abstractC0718i, abstractC0718i.f1997f, abstractC0718i.m1848m(AbstractC1193i.class)));
    }

    public StackTraceElement constructValue(AbstractC0718i abstractC0718i, AbstractC1193i abstractC1193i) {
        throw null;
    }

    public StackTraceElementDeserializer(AbstractC0722m abstractC0722m) {
        super((Class<?>) StackTraceElement.class);
        this._adapterDeserializer = abstractC0722m;
    }

    @Deprecated
    public StackTraceElement constructValue(AbstractC0718i abstractC0718i, String str, String str2, String str3, int i3, String str4, String str5) {
        return constructValue(abstractC0718i, str, str2, str3, i3, str4, str5, null);
    }

    @Override // p069X0.AbstractC0722m
    public StackTraceElement deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) throws C0850b {
        EnumC0548p enumC0548pMo1190e = abstractC0545m.mo1190e();
        if (enumC0548pMo1190e == EnumC0548p.START_OBJECT || enumC0548pMo1190e == EnumC0548p.FIELD_NAME) {
            AbstractC0722m abstractC0722m = this._adapterDeserializer;
            if (abstractC0722m == null) {
                AbstractC0032g.m162t(abstractC0718i.m1837O(abstractC0545m, AbstractC1193i.class));
            } else {
                AbstractC0032g.m162t(abstractC0722m.deserialize(abstractC0545m, abstractC0718i));
            }
            return constructValue(abstractC0718i, null);
        }
        if (enumC0548pMo1190e != EnumC0548p.START_ARRAY || !abstractC0718i.m1833K(EnumC0719j.UNWRAP_SINGLE_VALUE_ARRAYS)) {
            abstractC0718i.m1825C(abstractC0545m, this._valueClass);
            throw null;
        }
        abstractC0545m.mo1177V();
        StackTraceElement stackTraceElementDeserialize = deserialize(abstractC0545m, abstractC0718i);
        if (abstractC0545m.mo1177V() != EnumC0548p.END_ARRAY) {
            handleMissingEndArrayForSingle(abstractC0545m, abstractC0718i);
        }
        return stackTraceElementDeserialize;
    }

    public StackTraceElement constructValue(AbstractC0718i abstractC0718i, String str, String str2, String str3, int i3, String str4, String str5, String str6) {
        return new StackTraceElement(str, str2, str3, i3);
    }
}

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import java.util.Objects;
import p039M0.C0502q;
import p039M0.EnumC0499n;
import p042N0.AbstractC0540h;
import p042N0.EnumC0548p;
import p064V0.C0672b;
import p069X0.AbstractC0709K;
import p069X0.AbstractC0728s;
import p069X0.EnumC0708J;
import p069X0.InterfaceC0714e;
import p100g1.AbstractC1399h;
import p112k1.InterfaceC1638f;

/* JADX INFO: loaded from: classes.dex */
public abstract class ArraySerializerBase<T> extends ContainerSerializer<T> implements InterfaceC1638f {
    protected final InterfaceC0714e _property;
    protected final Boolean _unwrapSingle;

    public ArraySerializerBase(Class<T> cls) {
        super(cls);
        this._property = null;
        this._unwrapSingle = null;
    }

    public final boolean _shouldUnwrapSingle(AbstractC0709K abstractC0709K) {
        Boolean bool = this._unwrapSingle;
        if (bool != null) {
            return bool.booleanValue();
        }
        return abstractC0709K.f1966e.m1698r(EnumC0708J.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
    }

    public abstract AbstractC0728s _withResolved(InterfaceC0714e interfaceC0714e, Boolean bool);

    public AbstractC0728s createContextual(AbstractC0709K abstractC0709K, InterfaceC0714e interfaceC0714e) {
        C0502q c0502qFindFormatOverrides;
        if (interfaceC0714e != null && (c0502qFindFormatOverrides = findFormatOverrides(abstractC0709K, interfaceC0714e, handledType())) != null) {
            Boolean boolM1015b = c0502qFindFormatOverrides.m1015b(EnumC0499n.f1151i);
            if (!Objects.equals(boolM1015b, this._unwrapSingle)) {
                return _withResolved(interfaceC0714e, boolM1015b);
            }
        }
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, p069X0.AbstractC0728s
    public void serialize(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K) {
        if (_shouldUnwrapSingle(abstractC0709K) && hasSingleElement(t3)) {
            serializeContents(t3, abstractC0540h, abstractC0709K);
            return;
        }
        abstractC0540h.mo1118K(t3);
        serializeContents(t3, abstractC0540h, abstractC0709K);
        abstractC0540h.mo1142o();
    }

    public abstract void serializeContents(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K);

    @Override // p069X0.AbstractC0728s
    public final void serializeWithType(T t3, AbstractC0540h abstractC0540h, AbstractC0709K abstractC0709K, AbstractC1399h abstractC1399h) {
        C0672b c0672bMo3103e = abstractC1399h.mo3103e(abstractC0540h, abstractC1399h.m3406d(EnumC0548p.START_ARRAY, t3));
        abstractC0540h.mo1136i(t3);
        serializeContents(t3, abstractC0540h, abstractC0709K);
        abstractC1399h.mo3104f(abstractC0540h, c0672bMo3103e);
    }

    @Deprecated
    public ArraySerializerBase(Class<T> cls, InterfaceC0714e interfaceC0714e) {
        super(cls);
        this._property = interfaceC0714e;
        this._unwrapSingle = null;
    }

    public ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase) {
        super(arraySerializerBase._handledType, false);
        this._property = arraySerializerBase._property;
        this._unwrapSingle = arraySerializerBase._unwrapSingle;
    }

    public ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, InterfaceC0714e interfaceC0714e, Boolean bool) {
        super(arraySerializerBase._handledType, false);
        this._property = interfaceC0714e;
        this._unwrapSingle = bool;
    }

    @Deprecated
    public ArraySerializerBase(ArraySerializerBase<?> arraySerializerBase, InterfaceC0714e interfaceC0714e) {
        super(arraySerializerBase._handledType, false);
        this._property = interfaceC0714e;
        this._unwrapSingle = arraySerializerBase._unwrapSingle;
    }
}

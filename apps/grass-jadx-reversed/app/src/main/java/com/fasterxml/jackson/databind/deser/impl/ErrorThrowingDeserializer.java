package com.fasterxml.jackson.databind.deser.impl;

import p042N0.AbstractC0545m;
import p069X0.AbstractC0718i;
import p069X0.AbstractC0722m;

/* JADX INFO: loaded from: classes.dex */
public class ErrorThrowingDeserializer extends AbstractC0722m {
    private final Error _cause;

    public ErrorThrowingDeserializer(NoClassDefFoundError noClassDefFoundError) {
        this._cause = noClassDefFoundError;
    }

    @Override // p069X0.AbstractC0722m
    public Object deserialize(AbstractC0545m abstractC0545m, AbstractC0718i abstractC0718i) {
        throw this._cause;
    }
}

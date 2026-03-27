package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.AbstractC1204t;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.v */
/* JADX INFO: loaded from: classes.dex */
public final class C1170v extends HashMap {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final Locale f4030e;

    public C1170v(Locale locale) {
        this.f4030e = locale;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        return (AbstractC1204t) super.get(((String) obj).toLowerCase(this.f4030e));
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        return (AbstractC1204t) super.put(((String) obj).toLowerCase(this.f4030e), (AbstractC1204t) obj2);
    }
}

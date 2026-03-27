package com.fasterxml.jackson.databind.util.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.b */
/* JADX INFO: loaded from: classes.dex */
public final class C1233b implements Iterator {

    /* JADX INFO: renamed from: e */
    public InterfaceC1232a f4162e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f4163f;

    public C1233b(InterfaceC1232a interfaceC1232a, int i3) {
        this.f4163f = i3;
        this.f4162e = interfaceC1232a;
    }

    /* JADX INFO: renamed from: a */
    public final C1243l m3106a() {
        switch (this.f4163f) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return ((C1243l) this.f4162e).f4185g;
            default:
                return ((C1243l) this.f4162e).f4184f;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4162e != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        InterfaceC1232a interfaceC1232a = this.f4162e;
        this.f4162e = m3106a();
        return interfaceC1232a;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

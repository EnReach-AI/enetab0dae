package com.fasterxml.jackson.databind.deser;

import java.util.ArrayList;
import java.util.Iterator;
import p069X0.C0724o;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.u */
/* JADX INFO: loaded from: classes.dex */
public final class C1205u extends C0724o {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: i */
    public ArrayList f4111i;

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        synchronized (this) {
        }
        return this;
    }

    @Override // p069X0.C0724o, p042N0.AbstractC0546n, java.lang.Throwable
    public final String getMessage() {
        String strM1896e = m1896e();
        ArrayList arrayList = this.f4111i;
        if (arrayList == null) {
            return strM1896e;
        }
        StringBuilder sb = new StringBuilder(strM1896e);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(((C1206v) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('.');
        return sb.toString();
    }

    /* JADX INFO: renamed from: i */
    public final void m3081i() {
        super.fillInStackTrace();
    }
}

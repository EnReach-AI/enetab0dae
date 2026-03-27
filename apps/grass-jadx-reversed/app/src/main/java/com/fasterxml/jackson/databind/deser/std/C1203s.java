package com.fasterxml.jackson.databind.deser.std;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.s */
/* JADX INFO: loaded from: classes.dex */
public final class C1203s {

    /* JADX INFO: renamed from: a */
    public final C1203s f4095a;

    /* JADX INFO: renamed from: b */
    public final boolean f4096b;

    /* JADX INFO: renamed from: c */
    public final boolean f4097c;

    /* JADX INFO: renamed from: d */
    public String f4098d;

    /* JADX INFO: renamed from: e */
    public LinkedHashMap f4099e;

    /* JADX INFO: renamed from: f */
    public ArrayList f4100f;

    public C1203s(C1203s c1203s) {
        this.f4095a = c1203s;
        this.f4096b = false;
        this.f4097c = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m3074a(String str, Object obj) {
        LinkedHashMap linkedHashMap = this.f4099e;
        if (linkedHashMap == null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            this.f4099e = linkedHashMap2;
            linkedHashMap2.put(str, obj);
            return;
        }
        Object objPut = linkedHashMap.put(str, obj);
        if (objPut != null) {
            if (objPut instanceof List) {
                ((List) objPut).add(obj);
                this.f4099e.put(str, objPut);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(objPut);
                arrayList.add(obj);
                this.f4099e.put(str, arrayList);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3075b(Object obj) {
        if (this.f4100f == null) {
            this.f4100f = new ArrayList();
        }
        this.f4100f.add(obj);
    }

    /* JADX INFO: renamed from: c */
    public final void m3076c(Object obj) {
        String str = this.f4098d;
        Objects.requireNonNull(str);
        this.f4098d = null;
        if (this.f4097c) {
            m3074a(str, obj);
            return;
        }
        if (this.f4099e == null) {
            this.f4099e = new LinkedHashMap();
        }
        this.f4099e.put(str, obj);
    }

    public C1203s(C1203s c1203s, boolean z3) {
        this.f4095a = c1203s;
        this.f4096b = true;
        this.f4097c = z3;
    }
}

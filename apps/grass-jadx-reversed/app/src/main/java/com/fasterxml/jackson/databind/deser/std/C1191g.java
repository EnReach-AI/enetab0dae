package com.fasterxml.jackson.databind.deser.std;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.g */
/* JADX INFO: loaded from: classes.dex */
public final class C1191g {

    /* JADX INFO: renamed from: a */
    public final Class f4058a;

    /* JADX INFO: renamed from: b */
    public final Map f4059b;

    /* JADX INFO: renamed from: c */
    public final ArrayList f4060c = new ArrayList();

    public C1191g(Class cls, Map map) {
        this.f4058a = cls;
        this.f4059b = map;
    }

    /* JADX INFO: renamed from: a */
    public final void m3041a(Object obj, Object obj2) {
        ArrayList arrayList = this.f4060c;
        if (arrayList.isEmpty()) {
            this.f4059b.put(obj, obj2);
        } else {
            ((C1190f) arrayList.get(arrayList.size() - 1)).f4056c.put(obj, obj2);
        }
    }
}

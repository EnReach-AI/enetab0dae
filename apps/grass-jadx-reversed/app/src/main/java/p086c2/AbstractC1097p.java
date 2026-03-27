package p086c2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import p083b2.C1061f;
import p119m2.AbstractC1766e;
import p148u0.AbstractC1944c;

/* JADX INFO: renamed from: c2.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1097p extends AbstractC1944c {
    /* JADX INFO: renamed from: h */
    public static Object m2839h(Map map, Object obj) {
        AbstractC1766e.m3920e("<this>", map);
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }

    /* JADX INFO: renamed from: i */
    public static int m2840i(int i3) {
        if (i3 < 0) {
            return i3;
        }
        if (i3 < 3) {
            return i3 + 1;
        }
        if (i3 < 1073741824) {
            return (int) ((i3 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: j */
    public static Map m2841j(C1061f... c1061fArr) {
        if (c1061fArr.length <= 0) {
            return C1094m.f3783e;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(m2840i(c1061fArr.length));
        for (C1061f c1061f : c1061fArr) {
            linkedHashMap.put(c1061f.f3736e, c1061f.f3737f);
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: k */
    public static Map m2842k(ArrayList arrayList) {
        C1094m c1094m = C1094m.f3783e;
        int size = arrayList.size();
        if (size == 0) {
            return c1094m;
        }
        if (size == 1) {
            C1061f c1061f = (C1061f) arrayList.get(0);
            AbstractC1766e.m3920e("pair", c1061f);
            Map mapSingletonMap = Collections.singletonMap(c1061f.f3736e, c1061f.f3737f);
            AbstractC1766e.m3919d("singletonMap(...)", mapSingletonMap);
            return mapSingletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(m2840i(arrayList.size()));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C1061f c1061f2 = (C1061f) it.next();
            linkedHashMap.put(c1061f2.f3736e, c1061f2.f3737f);
        }
        return linkedHashMap;
    }
}

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p069X0.AbstractC0721l;
import p118m1.InterfaceC1748m;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.impl.l */
/* JADX INFO: loaded from: classes.dex */
public final class C1160l implements InterfaceC1748m {

    /* JADX INFO: renamed from: a */
    public final AbstractC0721l f4009a;

    /* JADX INFO: renamed from: b */
    public final int f4010b;

    public C1160l(int i3, AbstractC0721l abstractC0721l) {
        this.f4009a = abstractC0721l;
        this.f4010b = i3;
    }

    /* JADX INFO: renamed from: a */
    public static void m3008a(int i3) {
        if (i3 == 1) {
            return;
        }
        throw new IllegalArgumentException("Can not deserialize Singleton container from " + i3 + " entries");
    }

    /* JADX INFO: renamed from: b */
    public final Object m3009b(Object obj) {
        if (obj == null) {
            return null;
        }
        switch (this.f4010b) {
            case 1:
                Set set = (Set) obj;
                m3008a(set.size());
                return Collections.singleton(set.iterator().next());
            case 2:
                List list = (List) obj;
                m3008a(list.size());
                return Collections.singletonList(list.get(0));
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                Map map = (Map) obj;
                m3008a(map.size());
                Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                return Collections.singletonMap(entry.getKey(), entry.getValue());
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return Collections.unmodifiableSet((Set) obj);
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return Collections.unmodifiableList((List) obj);
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return Collections.unmodifiableMap((Map) obj);
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return Collections.synchronizedSet((Set) obj);
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return Collections.synchronizedCollection((Collection) obj);
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return Collections.synchronizedList((List) obj);
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return Collections.synchronizedMap((Map) obj);
            default:
                return obj;
        }
    }
}

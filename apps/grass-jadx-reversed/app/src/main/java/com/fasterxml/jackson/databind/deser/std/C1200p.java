package com.fasterxml.jackson.databind.deser.std;

import java.util.function.Predicate;
import p039M0.EnumC0495j;
import p082b1.C1032c;
import p082b1.C1043n;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.deser.std.p */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1200p implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        C1032c c1032c = (C1032c) obj;
        if (((C1043n) c1032c.f3662a).f3704h.getParameterCount() == 1 && ((C1043n) c1032c.f3662a).mo2792u(0) == String.class) {
            return c1032c.f3663b == EnumC0495j.f1144g;
        }
        return true;
    }
}

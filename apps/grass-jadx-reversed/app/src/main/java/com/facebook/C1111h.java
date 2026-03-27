package com.facebook;

import java.util.Random;
import p166z0.AbstractC2077o;
import p166z0.EnumC2076n;

/* JADX INFO: renamed from: com.facebook.h */
/* JADX INFO: loaded from: classes.dex */
public class C1111h extends RuntimeException {
    static final long serialVersionUID = 1;

    public C1111h(String str) {
        super(str);
        Random random = new Random();
        if (str == null || !AbstractC1117n.m2895e() || random.nextInt(100) <= 50) {
            return;
        }
        AbstractC2077o.m4612a(new C1110g(0, str), EnumC2076n.ErrorReport);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }
}

package com.facebook;

import p005B.AbstractC0032g;

/* JADX INFO: renamed from: com.facebook.f */
/* JADX INFO: loaded from: classes.dex */
public final class C1109f extends C1111h {
    static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final int f3859e;

    /* JADX INFO: renamed from: f */
    public final String f3860f;

    public C1109f(int i3, String str, String str2) {
        super(str);
        this.f3859e = i3;
        this.f3860f = str2;
    }

    @Override // com.facebook.C1111h, java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder("{FacebookDialogException: errorCode: ");
        sb.append(this.f3859e);
        sb.append(", message: ");
        sb.append(getMessage());
        sb.append(", url: ");
        return AbstractC0032g.m157o(sb, this.f3860f, "}");
    }
}

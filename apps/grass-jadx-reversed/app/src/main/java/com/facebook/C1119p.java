package com.facebook;

import p005B.AbstractC0032g;

/* JADX INFO: renamed from: com.facebook.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1119p extends C1111h {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final C1114k f3891e;

    public C1119p(C1114k c1114k, String str) {
        super(str);
        this.f3891e = c1114k;
    }

    @Override // com.facebook.C1111h, java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder("{FacebookServiceException: httpResponseCode: ");
        C1114k c1114k = this.f3891e;
        sb.append(c1114k.f3864e);
        sb.append(", facebookErrorCode: ");
        sb.append(c1114k.f3865f);
        sb.append(", facebookErrorType: ");
        sb.append(c1114k.f3867h);
        sb.append(", message: ");
        String localizedMessage = c1114k.f3868i;
        if (localizedMessage == null) {
            localizedMessage = c1114k.f3872m.getLocalizedMessage();
        }
        return AbstractC0032g.m157o(sb, localizedMessage, "}");
    }
}

package com.facebook;

/* JADX INFO: renamed from: com.facebook.i */
/* JADX INFO: loaded from: classes.dex */
public final class C1112i extends C1111h {

    /* JADX INFO: renamed from: e */
    public final C1128y f3863e;

    public C1112i(C1128y c1128y, String str) {
        super(str);
        this.f3863e = c1128y;
    }

    @Override // com.facebook.C1111h, java.lang.Throwable
    public final String toString() {
        C1128y c1128y = this.f3863e;
        C1114k c1114k = c1128y != null ? c1128y.f3921c : null;
        StringBuilder sb = new StringBuilder("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (c1114k != null) {
            sb.append("httpResponseCode: ");
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
            sb.append(localizedMessage);
            sb.append("}");
        }
        return sb.toString();
    }
}

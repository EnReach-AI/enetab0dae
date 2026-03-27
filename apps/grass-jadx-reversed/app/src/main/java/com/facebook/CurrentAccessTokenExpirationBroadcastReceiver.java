package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class CurrentAccessTokenExpirationBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction()) && AbstractC1117n.m2895e()) {
            C1107d c1107dM2887a = C1107d.m2887a();
            C1104a c1104a = (C1104a) c1107dM2887a.f3849d;
            c1107dM2887a.m2889c(c1104a, c1104a);
        }
    }
}

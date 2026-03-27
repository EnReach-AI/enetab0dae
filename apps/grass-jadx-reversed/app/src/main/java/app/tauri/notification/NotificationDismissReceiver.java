package app.tauri.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import app.tauri.Logger;
import p069X0.C0734y;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationDismissReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        AbstractC1766e.m3920e("context", context);
        AbstractC1766e.m3920e("intent", intent);
        int intExtra = intent.getIntExtra("NotificationId", Integer.MIN_VALUE);
        if (intExtra == Integer.MIN_VALUE) {
            Logger.Companion.m2656a(Logger.Companion.m2657b("Notification"), "Invalid notification dismiss operation");
        } else if (intent.getBooleanExtra("NotificationRepeating", true)) {
            new NotificationStorage(context, new C0734y()).m2670b(String.valueOf(intExtra));
        }
    }
}

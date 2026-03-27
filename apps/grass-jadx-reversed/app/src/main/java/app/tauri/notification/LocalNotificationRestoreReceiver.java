package app.tauri.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserManager;
import app.tauri.notification.NotificationSchedule;
import app.tauri.plugin.PluginManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import p069X0.C0734y;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class LocalNotificationRestoreReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        PluginConfig pluginConfig;
        AbstractC1766e.m3920e("context", context);
        AbstractC1766e.m3920e("intent", intent);
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        if (userManager == null || !userManager.isUserUnlocked()) {
            return;
        }
        NotificationStorage notificationStorage = new NotificationStorage(context, new C0734y());
        Map<String, ?> all = notificationStorage.m2672d("NOTIFICATION_STORE").getAll();
        ArrayList arrayList = all != null ? new ArrayList(all.keySet()) : new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Notification notificationM2671c = notificationStorage.m2671c((String) it.next());
            if (notificationM2671c != null) {
                NotificationSchedule schedule = notificationM2671c.getSchedule();
                if (schedule != null && (schedule instanceof NotificationSchedule.C0994At)) {
                    NotificationSchedule.C0994At c0994At = (NotificationSchedule.C0994At) schedule;
                    if (c0994At.getDate().before(new Date())) {
                        c0994At.setDate(new Date(new Date().getTime() + ((long) 15000)));
                        arrayList3.add(notificationM2671c);
                    }
                }
                arrayList2.add(notificationM2671c);
            }
        }
        if (arrayList3.size() > 0) {
            notificationStorage.m2669a(arrayList3);
        }
        try {
            pluginConfig = (PluginConfig) PluginManager.Companion.m2691a(context);
        } catch (Exception e3) {
            e3.printStackTrace();
            pluginConfig = null;
        }
        new TauriNotificationManager(notificationStorage, null, context, pluginConfig).m2677d(arrayList2);
    }
}

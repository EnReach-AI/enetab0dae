package app.tauri.notification;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import p069X0.C0734y;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationStorage {

    /* JADX INFO: renamed from: a */
    public final Context f3513a;

    /* JADX INFO: renamed from: b */
    public final C0734y f3514b;

    public NotificationStorage(Context context, C0734y c0734y) {
        AbstractC1766e.m3920e("context", context);
        AbstractC1766e.m3920e("jsonMapper", c0734y);
        this.f3513a = context;
        this.f3514b = c0734y;
    }

    /* JADX INFO: renamed from: a */
    public final void m2669a(List list) {
        AbstractC1766e.m3920e("localNotifications", list);
        SharedPreferences.Editor editorEdit = m2672d("NOTIFICATION_STORE").edit();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Notification notification = (Notification) it.next();
            if (notification.getSchedule() != null) {
                editorEdit.putString(String.valueOf(notification.getId()), String.valueOf(notification.getSourceJson()));
            }
        }
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: b */
    public final void m2670b(String str) {
        SharedPreferences.Editor editorEdit = m2672d("NOTIFICATION_STORE").edit();
        editorEdit.remove(str);
        editorEdit.apply();
    }

    /* JADX INFO: renamed from: c */
    public final Notification m2671c(String str) {
        AbstractC1766e.m3920e("key", str);
        try {
            String string = m2672d("NOTIFICATION_STORE").getString(str, null);
            if (string == null) {
                return null;
            }
            return (Notification) this.f3514b.m1918k(Notification.class, string);
        } catch (ClassCastException | JSONException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public final SharedPreferences m2672d(String str) {
        SharedPreferences sharedPreferences = this.f3513a.getSharedPreferences(str, 0);
        AbstractC1766e.m3919d("getSharedPreferences(...)", sharedPreferences);
        return sharedPreferences;
    }
}

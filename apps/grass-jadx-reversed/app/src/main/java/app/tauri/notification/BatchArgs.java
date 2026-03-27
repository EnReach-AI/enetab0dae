package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import java.util.List;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class BatchArgs {
    public List<Notification> notifications;

    public final List<Notification> getNotifications() {
        List<Notification> list = this.notifications;
        if (list != null) {
            return list;
        }
        AbstractC1766e.m3924i("notifications");
        throw null;
    }

    public final void setNotifications(List<Notification> list) {
        AbstractC1766e.m3920e("<set-?>", list);
        this.notifications = list;
    }
}

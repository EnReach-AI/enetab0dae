package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import java.util.List;
import p086c2.C1093l;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class RemoveActiveArgs {
    private List<ActiveNotification> notifications = C1093l.f3782e;

    public final List<ActiveNotification> getNotifications() {
        return this.notifications;
    }

    public final void setNotifications(List<ActiveNotification> list) {
        AbstractC1766e.m3920e("<set-?>", list);
        this.notifications = list;
    }
}

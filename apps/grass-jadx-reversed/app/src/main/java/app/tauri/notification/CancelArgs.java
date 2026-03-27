package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import java.util.List;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class CancelArgs {
    public List<Integer> notifications;

    public final List<Integer> getNotifications() {
        List<Integer> list = this.notifications;
        if (list != null) {
            return list;
        }
        AbstractC1766e.m3924i("notifications");
        throw null;
    }

    public final void setNotifications(List<Integer> list) {
        AbstractC1766e.m3920e("<set-?>", list);
        this.notifications = list;
    }
}

package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import java.util.List;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class ActionType {
    public List<NotificationAction> actions;

    /* JADX INFO: renamed from: id */
    public String f3487id;

    public final List<NotificationAction> getActions() {
        List<NotificationAction> list = this.actions;
        if (list != null) {
            return list;
        }
        AbstractC1766e.m3924i("actions");
        throw null;
    }

    public final String getId() {
        String str = this.f3487id;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("id");
        throw null;
    }

    public final void setActions(List<NotificationAction> list) {
        AbstractC1766e.m3920e("<set-?>", list);
        this.actions = list;
    }

    public final void setId(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.f3487id = str;
    }
}

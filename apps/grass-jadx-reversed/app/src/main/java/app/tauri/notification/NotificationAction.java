package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class NotificationAction {

    /* JADX INFO: renamed from: id */
    public String f3505id;
    private Boolean input;
    private String title;

    public final String getId() {
        String str = this.f3505id;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("id");
        throw null;
    }

    public final Boolean getInput() {
        return this.input;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setId(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.f3505id = str;
    }

    public final void setInput(Boolean bool) {
        this.input = bool;
    }

    public final void setTitle(String str) {
        this.title = str;
    }
}

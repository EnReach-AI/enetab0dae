package app.tauri.notification;

import app.tauri.annotation.InvokeArg;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class ActiveNotification {

    /* JADX INFO: renamed from: id */
    private int f3488id;
    private String tag;

    public final int getId() {
        return this.f3488id;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setId(int i3) {
        this.f3488id = i3;
    }

    public final void setTag(String str) {
        this.tag = str;
    }
}

package app.tauri.plugin;

import app.tauri.annotation.InvokeArg;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class RequestPermissionsArgs {
    private List<String> permissions;

    public final List<String> getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(List<String> list) {
        this.permissions = list;
    }
}

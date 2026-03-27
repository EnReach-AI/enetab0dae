package app.tauri.notification;

import app.tauri.annotation.InvokeArg;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class PluginConfig {
    private String icon;
    private String iconColor;
    private String sound;

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconColor() {
        return this.iconColor;
    }

    public final String getSound() {
        return this.sound;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setIconColor(String str) {
        this.iconColor = str;
    }

    public final void setSound(String str) {
        this.sound = str;
    }
}

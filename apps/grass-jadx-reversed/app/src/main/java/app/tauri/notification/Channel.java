package app.tauri.notification;

import app.tauri.annotation.InvokeArg;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class Channel {
    private String description;

    /* JADX INFO: renamed from: id */
    public String f3489id;
    private Importance importance;
    private Boolean lights;
    private String lightsColor;
    public String name;
    private String sound;
    private Boolean vibration;
    private Visibility visibility;

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        String str = this.f3489id;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("id");
        throw null;
    }

    public final Importance getImportance() {
        return this.importance;
    }

    public final Boolean getLights() {
        return this.lights;
    }

    public final String getLightsColor() {
        return this.lightsColor;
    }

    public final String getName() {
        String str = this.name;
        if (str != null) {
            return str;
        }
        AbstractC1766e.m3924i("name");
        throw null;
    }

    public final String getSound() {
        return this.sound;
    }

    public final Boolean getVibration() {
        return this.vibration;
    }

    public final Visibility getVisibility() {
        return this.visibility;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setId(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.f3489id = str;
    }

    public final void setImportance(Importance importance) {
        this.importance = importance;
    }

    public final void setLights(Boolean bool) {
        this.lights = bool;
    }

    public final void setLightsColor(String str) {
        this.lightsColor = str;
    }

    public final void setName(String str) {
        AbstractC1766e.m3920e("<set-?>", str);
        this.name = str;
    }

    public final void setSound(String str) {
        this.sound = str;
    }

    public final void setVibration(Boolean bool) {
        this.vibration = bool;
    }

    public final void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
}

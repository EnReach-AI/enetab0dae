package app.tauri.notification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import app.tauri.annotation.InvokeArg;
import app.tauri.notification.AssetUtils;
import app.tauri.plugin.JSObject;
import java.util.List;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@InvokeArg
public final class Notification {
    public static final Companion Companion = new Companion();
    private String actionTypeId;
    private List<NotificationAttachment> attachments;
    private String body;
    private String channelId;
    private JSObject extra;
    private String group;
    private String icon;
    private String iconColor;

    /* JADX INFO: renamed from: id */
    private int f3504id;
    private List<String> inboxLines;
    private boolean isAutoCancel;
    private boolean isGroupSummary;
    private boolean isOngoing;
    private String largeBody;
    private String largeIcon;
    private Integer number;
    private NotificationSchedule schedule;
    private String sound;
    private String sourceJson;
    private String summary;
    private String title;
    private Integer visibility;

    public static final class Companion {
    }

    public final String getActionTypeId() {
        return this.actionTypeId;
    }

    public final List<NotificationAttachment> getAttachments() {
        return this.attachments;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final JSObject getExtra() {
        return this.extra;
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIconColor() {
        return this.iconColor;
    }

    public final int getId() {
        return this.f3504id;
    }

    public final List<String> getInboxLines() {
        return this.inboxLines;
    }

    public final String getLargeBody() {
        return this.largeBody;
    }

    public final String getLargeIcon() {
        return this.largeIcon;
    }

    public final Integer getNumber() {
        return this.number;
    }

    public final NotificationSchedule getSchedule() {
        return this.schedule;
    }

    public final int getSmallIcon(Context context, int i3) {
        AbstractC1766e.m3920e("context", context);
        String str = this.icon;
        int iM2663b = str != null ? AssetUtils.Companion.m2663b(context, str, "drawable") : 0;
        return iM2663b == 0 ? i3 : iM2663b;
    }

    public final String getSound() {
        return this.sound;
    }

    public final String getSourceJson() {
        return this.sourceJson;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getVisibility() {
        return this.visibility;
    }

    public final boolean isAutoCancel() {
        return this.isAutoCancel;
    }

    public final boolean isGroupSummary() {
        return this.isGroupSummary;
    }

    public final boolean isOngoing() {
        return this.isOngoing;
    }

    public final void setActionTypeId(String str) {
        this.actionTypeId = str;
    }

    public final void setAttachments(List<NotificationAttachment> list) {
        this.attachments = list;
    }

    public final void setAutoCancel(boolean z3) {
        this.isAutoCancel = z3;
    }

    public final void setBody(String str) {
        this.body = str;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final void setExtra(JSObject jSObject) {
        this.extra = jSObject;
    }

    public final void setGroup(String str) {
        this.group = str;
    }

    public final void setGroupSummary(boolean z3) {
        this.isGroupSummary = z3;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setIconColor(String str) {
        this.iconColor = str;
    }

    public final void setId(int i3) {
        this.f3504id = i3;
    }

    public final void setInboxLines(List<String> list) {
        this.inboxLines = list;
    }

    public final void setLargeBody(String str) {
        this.largeBody = str;
    }

    public final void setLargeIcon(String str) {
        this.largeIcon = str;
    }

    public final void setNumber(Integer num) {
        this.number = num;
    }

    public final void setOngoing(boolean z3) {
        this.isOngoing = z3;
    }

    public final void setSchedule(NotificationSchedule notificationSchedule) {
        this.schedule = notificationSchedule;
    }

    public final void setSound(String str) {
        this.sound = str;
    }

    public final void setSourceJson(String str) {
        this.sourceJson = str;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setVisibility(Integer num) {
        this.visibility = num;
    }

    public final String getIconColor(String str) {
        AbstractC1766e.m3920e("globalColor", str);
        String str2 = this.iconColor;
        return str2 == null ? str : str2;
    }

    public final Bitmap getLargeIcon(Context context) {
        AbstractC1766e.m3920e("context", context);
        String str = this.largeIcon;
        if (str == null) {
            return null;
        }
        return BitmapFactory.decodeResource(context.getResources(), AssetUtils.Companion.m2663b(context, str, "drawable"));
    }

    public final String getSound(Context context, int i3) {
        AbstractC1766e.m3920e("context", context);
        String strM2662a = AssetUtils.Companion.m2662a(this.sound);
        int iM2663b = strM2662a != null ? AssetUtils.Companion.m2663b(context, strM2662a, "raw") : 0;
        if (iM2663b != 0) {
            i3 = iM2663b;
        }
        if (i3 == 0) {
            return null;
        }
        return "android.resource://" + context.getPackageName() + '/' + i3;
    }
}

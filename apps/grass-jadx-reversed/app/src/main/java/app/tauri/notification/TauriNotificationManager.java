package app.tauri.notification;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import app.tauri.Logger;
import app.tauri.notification.AssetUtils;
import app.tauri.notification.NotificationPlugin;
import app.tauri.notification.NotificationSchedule;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONException;
import p069X0.C0706H;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1892g;
import p162y.C2029h;
import p162y.C2030i;
import p162y.C2031j;
import p162y.C2033l;
import p162y.C2037p;
import p162y.C2041t;
import p162y.ServiceConnectionC2036o;

/* JADX INFO: loaded from: classes.dex */
public final class TauriNotificationManager {

    /* JADX INFO: renamed from: a */
    public final NotificationStorage f3515a;

    /* JADX INFO: renamed from: b */
    public final Activity f3516b;

    /* JADX INFO: renamed from: c */
    public final Context f3517c;

    /* JADX INFO: renamed from: d */
    public final PluginConfig f3518d;

    /* JADX INFO: renamed from: e */
    public int f3519e;

    /* JADX INFO: renamed from: f */
    public int f3520f;

    public TauriNotificationManager(NotificationStorage notificationStorage, Activity activity, Context context, PluginConfig pluginConfig) {
        AbstractC1766e.m3920e("context", context);
        this.f3515a = notificationStorage;
        this.f3516b = activity;
        this.f3517c = context;
        this.f3518d = pluginConfig;
    }

    /* JADX INFO: renamed from: e */
    public static void m2673e(AlarmManager alarmManager, NotificationSchedule notificationSchedule, long j2, PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT < 31 || alarmManager.canScheduleExactAlarms()) {
            if (notificationSchedule.allowWhileIdle()) {
                alarmManager.setExactAndAllowWhileIdle(0, j2, pendingIntent);
                return;
            } else {
                alarmManager.setExact(1, j2, pendingIntent);
                return;
            }
        }
        if (notificationSchedule.allowWhileIdle()) {
            alarmManager.setAndAllowWhileIdle(0, j2, pendingIntent);
        } else {
            alarmManager.set(1, j2, pendingIntent);
        }
    }

    /* JADX INFO: renamed from: a */
    public final Intent m2674a(Notification notification, String str) {
        Intent launchIntentForPackage;
        Context context = this.f3517c;
        Activity activity = this.f3516b;
        if (activity != null) {
            launchIntentForPackage = new Intent(context, activity.getClass());
        } else {
            launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            AbstractC1766e.m3917b(launchIntentForPackage);
        }
        launchIntentForPackage.setAction("android.intent.action.MAIN");
        launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        launchIntentForPackage.setFlags(603979776);
        launchIntentForPackage.putExtra("NotificationId", notification.getId());
        launchIntentForPackage.putExtra("NotificationUserAction", str);
        launchIntentForPackage.putExtra("LocalNotficationObject", notification.getSourceJson());
        NotificationSchedule schedule = notification.getSchedule();
        launchIntentForPackage.putExtra("NotificationRepeating", schedule == null || schedule.isRemovable());
        return launchIntentForPackage;
    }

    /* JADX INFO: renamed from: b */
    public final void m2675b(int i3) {
        Context context = this.f3517c;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i3, new Intent(context, (Class<?>) TimedNotificationPublisher.class), Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
        if (broadcast != null) {
            Object systemService = context.getSystemService("alarm");
            AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.AlarmManager", systemService);
            ((AlarmManager) systemService).cancel(broadcast);
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m2676c(Context context) {
        int i3 = this.f3519e;
        if (i3 != 0) {
            return i3;
        }
        PluginConfig pluginConfig = this.f3518d;
        String strM2662a = AssetUtils.Companion.m2662a(pluginConfig != null ? pluginConfig.getSound() : null);
        int iM2663b = strM2662a != null ? AssetUtils.Companion.m2663b(context, strM2662a, "raw") : 0;
        this.f3519e = iM2663b;
        return iM2663b;
    }

    /* JADX INFO: renamed from: d */
    public final ArrayList m2677d(List list) {
        AbstractC1766e.m3920e("notifications", list);
        ArrayList arrayList = new ArrayList();
        C2037p c2037p = new C2037p(this.f3517c);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(m2678f(c2037p, (Notification) it.next())));
        }
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: f */
    public final int m2678f(C2037p c2037p, Notification notification) throws Exception {
        String iconColor;
        long j2;
        long j3;
        int i3;
        int iM4220m;
        ArrayList<C2041t> arrayList;
        Set set;
        boolean z3 = true;
        new C2037p(this.f3517c).f7241b.cancel(null, notification.getId());
        m2675b(notification.getId());
        String channelId = notification.getChannelId();
        if (channelId == null) {
            channelId = "default";
        }
        Context context = this.f3517c;
        C2031j c2031j = new C2031j(context, channelId);
        c2031j.f7203e = C2031j.m4488b(notification.getTitle());
        c2031j.f7204f = C2031j.m4488b(notification.getBody());
        c2031j.m4490c(16, notification.isAutoCancel());
        c2031j.m4490c(2, notification.isOngoing());
        c2031j.f7207i = 0;
        c2031j.f7212n = notification.isGroupSummary();
        if (notification.getLargeBody() != null) {
            C2030i c2030i = new C2030i(0);
            c2030i.f7198f = C2031j.m4488b(notification.getLargeBody());
            c2030i.f7195c = C2031j.m4488b(notification.getSummary());
            c2030i.f7196d = true;
            c2031j.m4491d(c2030i);
        } else if (notification.getInboxLines() != null) {
            C2030i c2030i2 = new C2030i(1);
            c2030i2.f7198f = new ArrayList();
            List<String> inboxLines = notification.getInboxLines();
            if (inboxLines == null) {
                inboxLines = C1093l.f3782e;
            }
            for (String str : inboxLines) {
                if (str != null) {
                    ((ArrayList) c2030i2.f7198f).add(C2031j.m4488b(str));
                }
            }
            c2030i2.f7194b = C2031j.m4488b(notification.getTitle());
            c2030i2.f7195c = C2031j.m4488b(notification.getSummary());
            c2030i2.f7196d = true;
            c2031j.m4491d(c2030i2);
        }
        String sound = notification.getSound(context, m2676c(context));
        if (sound != null) {
            Uri uri = Uri.parse(sound);
            context.grantUriPermission("com.android.systemui", uri, 1);
            android.app.Notification notification2 = c2031j.f7218t;
            notification2.sound = uri;
            notification2.audioStreamType = -1;
            notification2.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            android.app.Notification notification3 = c2031j.f7218t;
            notification3.defaults = 6;
            notification3.flags |= 1;
        } else {
            android.app.Notification notification4 = c2031j.f7218t;
            notification4.defaults = -1;
            notification4.flags |= 1;
        }
        String group = notification.getGroup();
        if (group != null) {
            c2031j.f7211m = group;
            if (notification.isGroupSummary()) {
                c2031j.f7210l = C2031j.m4488b(notification.getSummary());
            }
        }
        Integer visibility = notification.getVisibility();
        c2031j.f7215q = visibility != null ? visibility.intValue() : 0;
        c2031j.m4490c(8, true);
        int iM2663b = this.f3520f;
        PluginConfig pluginConfig = this.f3518d;
        if (iM2663b == 0) {
            String strM2662a = AssetUtils.Companion.m2662a(pluginConfig != null ? pluginConfig.getIcon() : null);
            iM2663b = strM2662a != null ? AssetUtils.Companion.m2663b(context, strM2662a, "drawable") : 0;
            if (iM2663b == 0) {
                iM2663b = android.R.drawable.ic_dialog_info;
            }
            this.f3520f = iM2663b;
        }
        c2031j.f7218t.icon = notification.getSmallIcon(context, iM2663b);
        c2031j.f7206h = notification.getLargeIcon(context);
        if (pluginConfig == null || (iconColor = pluginConfig.getIconColor()) == null) {
            iconColor = "";
        }
        String iconColor2 = notification.getIconColor(iconColor);
        if (iconColor2.length() > 0) {
            try {
                c2031j.f7214p = Color.parseColor(iconColor2);
            } catch (IllegalArgumentException unused) {
                throw new Exception("Invalid color provided. Must be a hex string (ex: #ff0000");
            }
        }
        Intent intentM2674a = m2674a(notification, "tap");
        int i4 = Build.VERSION.SDK_INT >= 31 ? 301989888 : 268435456;
        c2031j.f7205g = PendingIntent.getActivity(context, notification.getId(), intentM2674a, i4);
        String actionTypeId = notification.getActionTypeId();
        if (actionTypeId != null) {
            NotificationStorage notificationStorage = this.f3515a;
            notificationStorage.getClass();
            SharedPreferences sharedPreferencesM2672d = notificationStorage.m2672d("ACTION_TYPE_STORE".concat(actionTypeId));
            int i5 = sharedPreferencesM2672d.getInt("count", 0);
            NotificationAction[] notificationActionArr = new NotificationAction[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                String string = sharedPreferencesM2672d.getString("id" + i6, "");
                String string2 = sharedPreferencesM2672d.getString("title" + i6, "");
                boolean z4 = sharedPreferencesM2672d.getBoolean("input" + i6, false);
                NotificationAction notificationAction = new NotificationAction();
                if (string == null) {
                    string = "";
                }
                notificationAction.setId(string);
                notificationAction.setTitle(string2);
                notificationAction.setInput(Boolean.valueOf(z4));
                notificationActionArr[i6] = notificationAction;
            }
            for (int i7 = 0; i7 < i5; i7++) {
                NotificationAction notificationAction2 = notificationActionArr[i7];
                AbstractC1766e.m3917b(notificationAction2);
                PendingIntent activity = PendingIntent.getActivity(context, notificationAction2.getId().hashCode() + notification.getId(), m2674a(notification, notificationAction2.getId()), i4);
                String title = notificationAction2.getTitle();
                IconCompat iconCompatM2316a = IconCompat.m2316a(io.getgrass.www.R.drawable.ic_transparent);
                Bundle bundle = new Bundle();
                CharSequence charSequenceM4488b = C2031j.m4488b(title);
                if (AbstractC1766e.m3916a(notificationAction2.getInput(), Boolean.TRUE)) {
                    C2041t c2041t = new C2041t(notificationAction2.getTitle(), new Bundle(), new HashSet());
                    arrayList = new ArrayList();
                    arrayList.add(c2041t);
                } else {
                    arrayList = null;
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                if (arrayList != null) {
                    for (C2041t c2041t2 : arrayList) {
                        if (c2041t2.f7244c || (set = c2041t2.f7246e) == null || set.isEmpty()) {
                            arrayList3.add(c2041t2);
                        } else {
                            arrayList2.add(c2041t2);
                        }
                    }
                }
                c2031j.f7200b.add(new C2029h(iconCompatM2316a, charSequenceM4488b, activity, bundle, arrayList3.isEmpty() ? null : (C2041t[]) arrayList3.toArray(new C2041t[arrayList3.size()]), arrayList2.isEmpty() ? null : (C2041t[]) arrayList2.toArray(new C2041t[arrayList2.size()])));
            }
            z3 = true;
        }
        Intent intent = new Intent(context, (Class<?>) NotificationDismissReceiver.class);
        intent.setFlags(268468224);
        intent.putExtra("NotificationId", notification.getId());
        intent.putExtra("NotificationUserAction", "dismiss");
        NotificationSchedule schedule = notification.getSchedule();
        if (schedule != null && !schedule.isRemovable()) {
            z3 = false;
        }
        intent.putExtra("NotificationRepeating", z3);
        int i8 = Build.VERSION.SDK_INT;
        c2031j.f7218t.deleteIntent = PendingIntent.getBroadcast(context, notification.getId(), intent, i8 >= 31 ? 33554432 : 0);
        android.app.Notification notificationM4489a = c2031j.m4489a();
        AbstractC1766e.m3919d("build(...)", notificationM4489a);
        if (notification.getSchedule() != null) {
            Object systemService = context.getSystemService("alarm");
            AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.AlarmManager", systemService);
            AlarmManager alarmManager = (AlarmManager) systemService;
            NotificationSchedule schedule2 = notification.getSchedule();
            Intent intent2 = new Intent(context, (Class<?>) TimedNotificationPublisher.class);
            intent2.putExtra("NotificationId", notification.getId());
            int i9 = TimedNotificationPublisher.f3521a;
            intent2.putExtra("NotificationPublisher.notification", notificationM4489a);
            int i10 = i8 >= 31 ? 301989888 : 268435456;
            PendingIntent broadcast = PendingIntent.getBroadcast(context, notification.getId(), intent2, i10);
            if (schedule2 instanceof NotificationSchedule.C0994At) {
                NotificationSchedule.C0994At c0994At = (NotificationSchedule.C0994At) schedule2;
                if (c0994At.getDate().getTime() < new Date().getTime()) {
                    Logger.Companion.m2656a(Logger.Companion.m2657b("Notification"), "Scheduled time must be *after* current time");
                } else if (c0994At.getRepeating()) {
                    alarmManager.setRepeating(1, c0994At.getDate().getTime(), c0994At.getDate().getTime() - new Date().getTime(), broadcast);
                } else {
                    long time = c0994At.getDate().getTime();
                    AbstractC1766e.m3917b(broadcast);
                    m2673e(alarmManager, schedule2, time, broadcast);
                }
            } else if (schedule2 instanceof NotificationSchedule.Interval) {
                NotificationSchedule.Interval interval = (NotificationSchedule.Interval) schedule2;
                long jM2664a = interval.getInterval().m2664a(new Date());
                DateMatch interval2 = interval.getInterval();
                StringBuilder sb = new StringBuilder();
                sb.append(interval2.f3492a);
                sb.append(' ');
                sb.append(interval2.f3493b);
                sb.append(' ');
                sb.append(interval2.f3494c);
                sb.append(' ');
                sb.append(interval2.f3495d);
                sb.append(' ');
                sb.append(interval2.f3496e);
                sb.append(' ');
                sb.append(interval2.f3497f);
                sb.append(' ');
                sb.append(interval2.f3498g);
                sb.append(' ');
                sb.append(interval2.f3499h);
                String string3 = sb.toString();
                AbstractC1766e.m3920e("<this>", string3);
                int iM4220m2 = AbstractC1892g.m4220m(string3, "null", 0, false);
                if (iM4220m2 >= 0) {
                    int length = string3.length() - 3;
                    if (length < 0) {
                        throw new OutOfMemoryError();
                    }
                    StringBuilder sb2 = new StringBuilder(length);
                    int i11 = 0;
                    while (true) {
                        sb2.append((CharSequence) string3, i11, iM4220m2);
                        sb2.append("*");
                        i3 = iM4220m2 + 4;
                        if (iM4220m2 >= string3.length() || (iM4220m = AbstractC1892g.m4220m(string3, "null", i3, false)) <= 0) {
                            break;
                        }
                        iM4220m2 = iM4220m;
                        i11 = i3;
                    }
                    sb2.append((CharSequence) string3, i3, string3.length());
                    string3 = sb2.toString();
                    AbstractC1766e.m3919d("toString(...)", string3);
                }
                intent2.putExtra("NotificationPublisher.cron", string3);
                PendingIntent broadcast2 = PendingIntent.getBroadcast(context, notification.getId(), intent2, i10);
                AbstractC1766e.m3917b(broadcast2);
                m2673e(alarmManager, schedule2, jM2664a, broadcast2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String strM2657b = Logger.Companion.m2657b("Notification");
                String str2 = "notification " + notification.getId() + " will next fire at " + simpleDateFormat.format(new Date(jM2664a));
                AbstractC1766e.m3920e("tag", strM2657b);
                AbstractC1766e.m3920e("message", str2);
            } else if (schedule2 instanceof NotificationSchedule.Every) {
                NotificationSchedule.Every every = (NotificationSchedule.Every) schedule2;
                NotificationInterval interval3 = every.getInterval();
                int count = every.getCount();
                AbstractC1766e.m3920e("interval", interval3);
                long j4 = 86400000;
                switch (interval3.ordinal()) {
                    case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                        j2 = ((long) count) * 604800000;
                        j4 = 52;
                        j3 = j2 * j4;
                        long j5 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j5, j5, broadcast);
                        break;
                    case 1:
                        count *= 30;
                        j2 = count;
                        j3 = j2 * j4;
                        long j52 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j52, j52, broadcast);
                        break;
                    case 2:
                        count *= 2;
                        j3 = ((long) count) * 604800000;
                        long j522 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j522, j522, broadcast);
                        break;
                    case FromStringDeserializer.Std.STD_URI /* 3 */:
                        j3 = ((long) count) * 604800000;
                        long j5222 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j5222, j5222, broadcast);
                        break;
                    case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                        j2 = count;
                        j3 = j2 * j4;
                        long j52222 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j52222, j52222, broadcast);
                        break;
                    case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                        j2 = count;
                        j4 = 3600000;
                        j3 = j2 * j4;
                        long j522222 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j522222, j522222, broadcast);
                        break;
                    case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                        j2 = count;
                        j4 = 60000;
                        j3 = j2 * j4;
                        long j5222222 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j5222222, j5222222, broadcast);
                        break;
                    case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                        j2 = count;
                        j4 = 1000;
                        j3 = j2 * j4;
                        long j52222222 = j3;
                        alarmManager.setRepeating(1, new Date().getTime() + j52222222, j52222222, broadcast);
                        break;
                    default:
                        throw new C0706H();
                }
            }
        } else {
            int id = notification.getId();
            Bundle bundle2 = notificationM4489a.extras;
            NotificationManager notificationManager = c2037p.f7241b;
            if (bundle2 == null || !bundle2.getBoolean("android.support.useSideChannel")) {
                notificationManager.notify(null, id, notificationM4489a);
            } else {
                C2033l c2033l = new C2033l(c2037p.f7240a.getPackageName(), id, notificationM4489a);
                synchronized (C2037p.f7238f) {
                    try {
                        if (C2037p.f7239g == null) {
                            C2037p.f7239g = new ServiceConnectionC2036o(c2037p.f7240a.getApplicationContext());
                        }
                        C2037p.f7239g.f7232b.obtainMessage(0, c2033l).sendToTarget();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                notificationManager.cancel(null, id);
            }
            try {
                NotificationPlugin.Companion.m2668a(notification);
            } catch (JSONException unused2) {
            }
        }
        return notification.getId();
    }
}

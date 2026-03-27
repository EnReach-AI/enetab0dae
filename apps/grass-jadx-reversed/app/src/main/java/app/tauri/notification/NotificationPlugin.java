package app.tauri.notification;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.webkit.WebView;
import app.tauri.Logger;
import app.tauri.PermissionState;
import app.tauri.annotation.Command;
import app.tauri.annotation.Permission;
import app.tauri.annotation.PermissionCallback;
import app.tauri.annotation.TauriPlugin;
import app.tauri.plugin.Invoke;
import app.tauri.plugin.JSArray;
import app.tauri.plugin.JSObject;
import app.tauri.plugin.Plugin;
import app.tauri.plugin.PluginHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import p005B.AbstractC0032g;
import p042N0.AbstractC0546n;
import p086c2.C1093l;
import p119m2.AbstractC1766e;
import p142s2.AbstractC1892g;
import p162y.AbstractC2038q;
import p162y.C2037p;

/* JADX INFO: loaded from: classes.dex */
@TauriPlugin(permissions = {@Permission(alias = "permissionState", strings = {"android.permission.POST_NOTIFICATIONS"})})
public final class NotificationPlugin extends Plugin {

    /* JADX INFO: renamed from: i */
    public static NotificationPlugin f3507i;

    /* JADX INFO: renamed from: d */
    public final Activity f3508d;

    /* JADX INFO: renamed from: e */
    public TauriNotificationManager f3509e;

    /* JADX INFO: renamed from: f */
    public NotificationManager f3510f;

    /* JADX INFO: renamed from: g */
    public NotificationStorage f3511g;

    /* JADX INFO: renamed from: h */
    public final ChannelManager f3512h;

    public static final class Companion {
        /* JADX INFO: renamed from: a */
        public static void m2668a(Notification notification) throws AbstractC0546n {
            List list;
            AbstractC1766e.m3920e("notification", notification);
            NotificationPlugin notificationPlugin = NotificationPlugin.f3507i;
            if (notificationPlugin == null || (list = (List) notificationPlugin.f3539c.get("notification")) == null || list.isEmpty()) {
                return;
            }
            for (app.tauri.plugin.Channel channel : new CopyOnWriteArrayList(list)) {
                channel.getClass();
                String strM1921n = channel.f3527c.m1921n(notification);
                AbstractC1766e.m3919d("writeValueAsString(...)", strM1921n);
                channel.f3526b.mo249f(strM1921n);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationPlugin(Activity activity) {
        super(activity);
        AbstractC1766e.m3920e("activity", activity);
        this.f3508d = activity;
        ChannelManager channelManager = new ChannelManager();
        channelManager.f3490a = activity;
        channelManager.f3491b = (NotificationManager) activity.getSystemService("notification");
        this.f3512h = channelManager;
    }

    @PermissionCallback
    private final void permissionsCallback(Invoke invoke) {
        JSObject jSObject = new JSObject();
        jSObject.put("permissionState", m2666f());
        invoke.m2683d(jSObject);
    }

    @Override // app.tauri.plugin.Plugin
    /* JADX INFO: renamed from: b */
    public final void mo2660b(WebView webView) {
        Uri uri;
        AbstractC1766e.m3920e("webView", webView);
        f3507i = this;
        PluginHandle pluginHandle = this.f3538b;
        AbstractC1766e.m3917b(pluginHandle);
        Activity activity = this.f3508d;
        NotificationStorage notificationStorage = new NotificationStorage(activity, pluginHandle.f3543d);
        this.f3511g = notificationStorage;
        PluginHandle pluginHandle2 = this.f3538b;
        AbstractC1766e.m3917b(pluginHandle2);
        PluginHandle pluginHandle3 = this.f3538b;
        AbstractC1766e.m3917b(pluginHandle3);
        TauriNotificationManager tauriNotificationManager = new TauriNotificationManager(notificationStorage, activity, activity, (PluginConfig) pluginHandle2.f3543d.m1918k(PluginConfig.class, pluginHandle3.f3542c));
        NotificationChannel notificationChannel = new NotificationChannel("default", "Default", 3);
        notificationChannel.setDescription("Default");
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(4).setUsage(4).build();
        int iM2676c = tauriNotificationManager.m2676c(activity);
        if (iM2676c != 0) {
            uri = Uri.parse("android.resource://" + activity.getPackageName() + '/' + iM2676c);
        } else {
            uri = null;
        }
        if (uri != null) {
            notificationChannel.setSound(uri, audioAttributesBuild);
        }
        ((NotificationManager) activity.getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
        this.f3509e = tauriNotificationManager;
        Object systemService = activity.getSystemService("notification");
        AbstractC1766e.m3918c("null cannot be cast to non-null type android.app.NotificationManager", systemService);
        this.f3510f = (NotificationManager) systemService;
        Intent intent = activity.getIntent();
        if (intent != null) {
            m2667g(intent);
        }
    }

    @Command
    public final void batch(Invoke invoke) throws AbstractC0546n {
        AbstractC1766e.m3920e("invoke", invoke);
        BatchArgs batchArgs = (BatchArgs) invoke.f3536f.m1918k(BatchArgs.class, invoke.f3535e);
        TauriNotificationManager tauriNotificationManager = this.f3509e;
        if (tauriNotificationManager == null) {
            AbstractC1766e.m3924i("manager");
            throw null;
        }
        ArrayList arrayListM2677d = tauriNotificationManager.m2677d(batchArgs.getNotifications());
        NotificationStorage notificationStorage = this.f3511g;
        if (notificationStorage == null) {
            AbstractC1766e.m3924i("notificationStorage");
            throw null;
        }
        notificationStorage.m2669a(batchArgs.getNotifications());
        invoke.m2684e(arrayListM2677d);
    }

    @Override // app.tauri.plugin.Plugin
    /* JADX INFO: renamed from: c */
    public final void mo2661c(Intent intent) {
        AbstractC1766e.m3920e("intent", intent);
        m2667g(intent);
    }

    @Command
    public final void cancel(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        CancelArgs cancelArgs = (CancelArgs) invoke.f3536f.m1918k(CancelArgs.class, invoke.f3535e);
        TauriNotificationManager tauriNotificationManager = this.f3509e;
        if (tauriNotificationManager == null) {
            AbstractC1766e.m3924i("manager");
            throw null;
        }
        List<Integer> notifications = cancelArgs.getNotifications();
        AbstractC1766e.m3920e("notifications", notifications);
        Iterator<Integer> it = notifications.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            new C2037p(tauriNotificationManager.f3517c).f7241b.cancel(null, iIntValue);
            tauriNotificationManager.m2675b(iIntValue);
            tauriNotificationManager.f3515a.m2670b(String.valueOf(iIntValue));
        }
        invoke.m2682c();
    }

    @Override // app.tauri.plugin.Plugin
    @Command
    public void checkPermissions(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        if (Build.VERSION.SDK_INT >= 33) {
            super.checkPermissions(invoke);
            return;
        }
        JSObject jSObject = new JSObject();
        jSObject.put("permissionState", m2666f());
        invoke.m2683d(jSObject);
    }

    @Command
    public final void createChannel(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        ChannelManager channelManager = this.f3512h;
        channelManager.getClass();
        Channel channel = (Channel) invoke.f3536f.m1918k(Channel.class, invoke.f3535e);
        String id = channel.getId();
        String name = channel.getName();
        Importance importance = channel.getImportance();
        if (importance == null) {
            importance = Importance.Default;
        }
        NotificationChannel notificationChannel = new NotificationChannel(id, name, importance.f3503e);
        notificationChannel.setDescription(channel.getDescription());
        Visibility visibility = channel.getVisibility();
        if (visibility == null) {
            visibility = Visibility.Private;
        }
        notificationChannel.setLockscreenVisibility(visibility.f3524e);
        Boolean vibration = channel.getVibration();
        notificationChannel.enableVibration(vibration != null ? vibration.booleanValue() : false);
        Boolean lights = channel.getLights();
        notificationChannel.enableLights(lights != null ? lights.booleanValue() : false);
        String lightsColor = channel.getLightsColor();
        if (lightsColor == null) {
            lightsColor = "";
        }
        if (lightsColor.length() > 0) {
            try {
                notificationChannel.setLightColor(Color.parseColor(lightsColor));
            } catch (IllegalArgumentException unused) {
                Logger.Companion.m2656a(Logger.Companion.m2657b("NotificationChannel"), "Invalid color provided for light color.");
            }
        }
        String sound = channel.getSound();
        String strSubstring = sound != null ? sound : "";
        if (strSubstring.length() > 0) {
            if (AbstractC1892g.m4217j(strSubstring, ".")) {
                strSubstring = strSubstring.substring(0, AbstractC1892g.m4223p(strSubstring, '.'));
                AbstractC1766e.m3919d("substring(...)", strSubstring);
            }
            notificationChannel.setSound(Uri.parse("android.resource://" + channelManager.f3490a.getPackageName() + "/raw/" + strSubstring), new AudioAttributes.Builder().setContentType(4).setUsage(5).build());
        }
        NotificationManager notificationManager = channelManager.f3491b;
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        invoke.m2682c();
    }

    @Command
    public final void deleteChannel(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        ChannelManager channelManager = this.f3512h;
        channelManager.getClass();
        DeleteChannelArgs deleteChannelArgs = (DeleteChannelArgs) invoke.m2680a(DeleteChannelArgs.class);
        NotificationManager notificationManager = channelManager.f3491b;
        if (notificationManager != null) {
            notificationManager.deleteNotificationChannel(deleteChannelArgs.getId());
        }
        invoke.m2682c();
    }

    /* JADX INFO: renamed from: f */
    public final String m2666f() {
        TauriNotificationManager tauriNotificationManager = this.f3509e;
        if (tauriNotificationManager != null) {
            return new C2037p(tauriNotificationManager.f3517c).f7241b.areNotificationsEnabled() ? "granted" : "denied";
        }
        AbstractC1766e.m3924i("manager");
        throw null;
    }

    /* JADX INFO: renamed from: g */
    public final void m2667g(Intent intent) {
        AbstractC1766e.m3920e("intent", intent);
        if ("android.intent.action.MAIN".equals(intent.getAction())) {
            TauriNotificationManager tauriNotificationManager = this.f3509e;
            JSObject jSObject = null;
            if (tauriNotificationManager == null) {
                AbstractC1766e.m3924i("manager");
                throw null;
            }
            NotificationStorage notificationStorage = this.f3511g;
            if (notificationStorage == null) {
                AbstractC1766e.m3924i("notificationStorage");
                throw null;
            }
            String strM2657b = Logger.Companion.m2657b("Notification");
            String str = "Notification received: " + intent.getDataString();
            AbstractC1766e.m3920e("tag", strM2657b);
            AbstractC1766e.m3920e("message", str);
            int intExtra = intent.getIntExtra("NotificationId", Integer.MIN_VALUE);
            if (intExtra == Integer.MIN_VALUE) {
                AbstractC1766e.m3920e("tag", Logger.Companion.m2657b("Notification"));
            } else {
                if (intent.getBooleanExtra("NotificationRepeating", true)) {
                    notificationStorage.m2670b(String.valueOf(intExtra));
                }
                JSObject jSObject2 = new JSObject();
                Bundle bundleM4499b = AbstractC2038q.m4499b(intent);
                CharSequence charSequence = bundleM4499b != null ? bundleM4499b.getCharSequence("NotificationRemoteInput") : null;
                jSObject2.put("inputValue", charSequence != null ? charSequence.toString() : null);
                String stringExtra = intent.getStringExtra("NotificationUserAction");
                new C2037p(tauriNotificationManager.f3517c).f7241b.cancel(null, intExtra);
                jSObject2.put("actionId", stringExtra);
                try {
                    String stringExtra2 = intent.getStringExtra("LocalNotficationObject");
                    if (stringExtra2 != null) {
                        jSObject = new JSObject(stringExtra2);
                    }
                } catch (JSONException unused) {
                }
                jSObject2.put("notification", (Object) jSObject);
                jSObject = jSObject2;
            }
            if (jSObject != null) {
                m2687e("actionPerformed", jSObject);
            }
        }
    }

    @Command
    @SuppressLint({"ObsoleteSdkInt"})
    public final void getActive(Invoke invoke) throws AbstractC0546n {
        AbstractC1766e.m3920e("invoke", invoke);
        JSArray jSArray = new JSArray();
        NotificationManager notificationManager = this.f3510f;
        if (notificationManager == null) {
            AbstractC1766e.m3924i("notificationManager");
            throw null;
        }
        StatusBarNotification[] activeNotifications = notificationManager.getActiveNotifications();
        AbstractC1766e.m3917b(activeNotifications);
        for (StatusBarNotification statusBarNotification : activeNotifications) {
            JSObject jSObject = new JSObject();
            jSObject.put("id", statusBarNotification.getId());
            jSObject.put("tag", statusBarNotification.getTag());
            android.app.Notification notification = statusBarNotification.getNotification();
            if (notification != null) {
                jSObject.put("title", (Object) notification.extras.getCharSequence("android.title"));
                jSObject.put("body", (Object) notification.extras.getCharSequence("android.text"));
                jSObject.put("group", notification.getGroup());
                jSObject.put("groupSummary", (notification.flags & 512) != 0);
                JSObject jSObject2 = new JSObject();
                for (String str : notification.extras.keySet()) {
                    AbstractC1766e.m3917b(str);
                    jSObject2.put(str, notification.extras.getString(str));
                }
                jSObject.put("data", (Object) jSObject2);
            }
            jSArray.put(jSObject);
        }
        invoke.m2684e(jSArray);
    }

    @Command
    public final void getPending(Invoke invoke) throws AbstractC0546n {
        ArrayList<Notification> arrayList;
        AbstractC1766e.m3920e("invoke", invoke);
        NotificationStorage notificationStorage = this.f3511g;
        if (notificationStorage == null) {
            AbstractC1766e.m3924i("notificationStorage");
            throw null;
        }
        Map<String, ?> all = notificationStorage.m2672d("NOTIFICATION_STORE").getAll();
        if (all != null) {
            arrayList = new ArrayList();
            Iterator<String> it = all.keySet().iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((Notification) notificationStorage.f3514b.m1918k(Notification.class, (String) all.get(it.next())));
                } catch (Exception unused) {
                }
            }
        } else {
            arrayList = new ArrayList();
        }
        Notification.Companion.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (Notification notification : arrayList) {
            notification.getId();
            notification.getTitle();
            notification.getBody();
            notification.getSchedule();
            notification.getExtra();
            arrayList2.add(new PendingNotification());
        }
        invoke.m2684e(arrayList2);
    }

    @Command
    public final void listChannels(Invoke invoke) throws AbstractC0546n {
        Importance importance;
        Visibility visibility;
        AbstractC1766e.m3920e("invoke", invoke);
        ChannelManager channelManager = this.f3512h;
        channelManager.getClass();
        NotificationManager notificationManager = channelManager.f3491b;
        List<NotificationChannel> notificationChannels = notificationManager != null ? notificationManager.getNotificationChannels() : null;
        if (notificationChannels == null) {
            notificationChannels = C1093l.f3782e;
        }
        ArrayList arrayList = new ArrayList();
        for (NotificationChannel notificationChannel : notificationChannels) {
            Channel channel = new Channel();
            String id = notificationChannel.getId();
            AbstractC1766e.m3919d("getId(...)", id);
            channel.setId(id);
            channel.setName(notificationChannel.getName().toString());
            channel.setDescription(notificationChannel.getDescription());
            channel.setSound(notificationChannel.getSound().toString());
            channel.setLights(Boolean.valueOf(notificationChannel.shouldShowLights()));
            String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & notificationChannel.getLightColor())}, 1));
            channel.setVibration(Boolean.valueOf(notificationChannel.shouldVibrate()));
            Importance[] importanceArrValues = Importance.values();
            int length = importanceArrValues.length;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    importance = null;
                    break;
                }
                importance = importanceArrValues[i4];
                if (importance.f3503e == notificationChannel.getImportance()) {
                    break;
                } else {
                    i4++;
                }
            }
            channel.setImportance(importance);
            Visibility[] visibilityArrValues = Visibility.values();
            int length2 = visibilityArrValues.length;
            while (true) {
                if (i3 >= length2) {
                    visibility = null;
                    break;
                }
                visibility = visibilityArrValues[i3];
                if (visibility.f3524e == notificationChannel.getLockscreenVisibility()) {
                    break;
                } else {
                    i3++;
                }
            }
            channel.setVisibility(visibility);
            arrayList.add(channel);
        }
        invoke.m2684e(arrayList);
    }

    @Command
    public final void permissionState(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        JSObject jSObject = new JSObject();
        jSObject.put("permissionState", m2666f());
        invoke.m2683d(jSObject);
    }

    @Command
    public final void registerActionTypes(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        RegisterActionTypesArgs registerActionTypesArgs = (RegisterActionTypesArgs) invoke.m2680a(RegisterActionTypesArgs.class);
        NotificationStorage notificationStorage = this.f3511g;
        if (notificationStorage == null) {
            AbstractC1766e.m3924i("notificationStorage");
            throw null;
        }
        List<ActionType> types = registerActionTypesArgs.getTypes();
        AbstractC1766e.m3920e("actions", types);
        for (ActionType actionType : types) {
            String id = actionType.getId();
            SharedPreferences.Editor editorEdit = notificationStorage.m2672d("ACTION_TYPE_STORE" + actionType.getId()).edit();
            editorEdit.clear();
            editorEdit.putInt("count", actionType.getActions().size());
            for (NotificationAction notificationAction : actionType.getActions()) {
                editorEdit.putString(AbstractC0032g.m152j("id", id), notificationAction.getId());
                editorEdit.putString("title" + id, notificationAction.getTitle());
                String str = "input" + id;
                Boolean input = notificationAction.getInput();
                editorEdit.putBoolean(str, input != null ? input.booleanValue() : false);
            }
            editorEdit.apply();
        }
        invoke.m2682c();
    }

    @Command
    public final void removeActive(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        RemoveActiveArgs removeActiveArgs = (RemoveActiveArgs) invoke.m2680a(RemoveActiveArgs.class);
        if (removeActiveArgs.getNotifications().isEmpty()) {
            NotificationManager notificationManager = this.f3510f;
            if (notificationManager == null) {
                AbstractC1766e.m3924i("notificationManager");
                throw null;
            }
            notificationManager.cancelAll();
            invoke.m2682c();
            return;
        }
        for (ActiveNotification activeNotification : removeActiveArgs.getNotifications()) {
            if (activeNotification.getTag() == null) {
                NotificationManager notificationManager2 = this.f3510f;
                if (notificationManager2 == null) {
                    AbstractC1766e.m3924i("notificationManager");
                    throw null;
                }
                notificationManager2.cancel(activeNotification.getId());
            } else {
                NotificationManager notificationManager3 = this.f3510f;
                if (notificationManager3 == null) {
                    AbstractC1766e.m3924i("notificationManager");
                    throw null;
                }
                notificationManager3.cancel(activeNotification.getTag(), activeNotification.getId());
            }
        }
        invoke.m2682c();
    }

    @Override // app.tauri.plugin.Plugin
    @Command
    public void requestPermissions(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        if (Build.VERSION.SDK_INT < 33) {
            permissionState(invoke);
        } else if (((PermissionState) m2685a().get("permissionState")) != PermissionState.f3478g) {
            m2686d(new String[]{"permissionState"}, invoke, "permissionsCallback");
        }
    }

    @Command
    public final void show(Invoke invoke) throws AbstractC0546n {
        AbstractC1766e.m3920e("invoke", invoke);
        Notification notification = (Notification) invoke.m2680a(Notification.class);
        TauriNotificationManager tauriNotificationManager = this.f3509e;
        if (tauriNotificationManager == null) {
            AbstractC1766e.m3924i("manager");
            throw null;
        }
        AbstractC1766e.m3920e("notification", notification);
        invoke.m2684e(Integer.valueOf(tauriNotificationManager.m2678f(new C2037p(tauriNotificationManager.f3517c), notification)));
    }
}

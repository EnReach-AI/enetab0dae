package app.tauri.plugin;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import app.tauri.Logger;
import app.tauri.PermissionState;
import app.tauri.annotation.Command;
import app.tauri.annotation.Permission;
import app.tauri.annotation.PermissionCallback;
import app.tauri.annotation.TauriPlugin;
import app.tauri.plugin.PluginManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import p083b2.C1077v;
import p086c2.AbstractC1084c;
import p086c2.C1082a;
import p119m2.AbstractC1766e;
import p165z.AbstractC2049e;

/* JADX INFO: loaded from: classes.dex */
public abstract class Plugin {

    /* JADX INFO: renamed from: a */
    public final Activity f3537a;

    /* JADX INFO: renamed from: b */
    public PluginHandle f3538b;

    /* JADX INFO: renamed from: c */
    public final LinkedHashMap f3539c;

    public Plugin(Activity activity) {
        AbstractC1766e.m3920e("activity", activity);
        this.f3537a = activity;
        this.f3539c = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: a */
    public final HashMap m2685a() {
        PermissionState permissionStateValueOf;
        Plugin plugin = this;
        HashMap map = new HashMap();
        PluginHandle pluginHandle = plugin.f3538b;
        TauriPlugin tauriPlugin = pluginHandle != null ? pluginHandle.f3547h : null;
        if (tauriPlugin != null) {
            Permission[] permissionArrPermissions = tauriPlugin.permissions();
            int length = permissionArrPermissions.length;
            int i3 = 0;
            while (i3 < length) {
                Permission permission = permissionArrPermissions[i3];
                int length2 = permission.strings().length;
                PermissionState permissionState = PermissionState.f3478g;
                if (length2 == 0 || (permission.strings().length == 1 && permission.strings()[0].length() == 0)) {
                    String strAlias = permission.alias();
                    if (strAlias.length() > 0 && ((PermissionState) map.get(strAlias)) == null) {
                        map.put(strAlias, permissionState);
                    }
                } else {
                    String[] strArrStrings = permission.strings();
                    int length3 = strArrStrings.length;
                    int i4 = 0;
                    while (i4 < length3) {
                        String str = strArrStrings[i4];
                        String strAlias2 = permission.alias();
                        if (strAlias2.length() == 0) {
                            strAlias2 = str;
                        }
                        Activity activity = plugin.f3537a;
                        if (AbstractC2049e.m4523a(activity, str) == 0) {
                            permissionStateValueOf = permissionState;
                        } else {
                            permissionStateValueOf = PermissionState.f3479h;
                            String string = activity.getSharedPreferences("PluginPermStates", 0).getString(str, null);
                            if (string != null) {
                                PermissionState.f3477f.getClass();
                                Locale locale = Locale.ROOT;
                                AbstractC1766e.m3919d("ROOT", locale);
                                String upperCase = string.toUpperCase(locale);
                                AbstractC1766e.m3919d("toUpperCase(...)", upperCase);
                                String strReplace = upperCase.replace('-', '_');
                                AbstractC1766e.m3919d("replace(...)", strReplace);
                                permissionStateValueOf = PermissionState.valueOf(strReplace);
                            }
                        }
                        PermissionState permissionState2 = (PermissionState) map.get(strAlias2);
                        if (permissionState2 == null || permissionState2 == permissionState) {
                            map.put(strAlias2, permissionStateValueOf);
                        }
                        i4++;
                        plugin = this;
                    }
                }
                i3++;
                plugin = this;
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: b */
    public void mo2660b(WebView webView) {
        AbstractC1766e.m3920e("webView", webView);
    }

    /* JADX INFO: renamed from: c */
    public void mo2661c(Intent intent) {
        AbstractC1766e.m3920e("intent", intent);
    }

    @PermissionCallback
    @Command
    public void checkPermissions(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        HashMap mapM2685a = m2685a();
        if (mapM2685a.isEmpty()) {
            invoke.m2682c();
            return;
        }
        JSObject jSObject = new JSObject();
        Iterator it = mapM2685a.entrySet().iterator();
        while (it.hasNext()) {
            jSObject.put((String) ((Map.Entry) it.next()).getKey(), r2.getValue());
        }
        invoke.m2683d(jSObject);
    }

    /* JADX INFO: renamed from: d */
    public final void m2686d(String[] strArr, final Invoke invoke, final String str) {
        AbstractC1766e.m3920e("invoke", invoke);
        if (strArr.length == 0) {
            Logger.Companion.m2656a("Tauri", "No permission alias was provided");
            return;
        }
        PluginHandle pluginHandle = this.f3538b;
        TauriPlugin tauriPlugin = pluginHandle != null ? pluginHandle.f3547h : null;
        HashSet hashSet = new HashSet();
        if (tauriPlugin != null) {
            for (Permission permission : tauriPlugin.permissions()) {
                if (AbstractC1084c.m2832z(strArr, permission.alias()) >= 0) {
                    String[] strArrStrings = permission.strings();
                    AbstractC1766e.m3920e("elements", strArrStrings);
                    hashSet.addAll(AbstractC1084c.m2829w(strArrStrings));
                }
            }
        }
        Object[] array = hashSet.toArray(new String[0]);
        AbstractC1766e.m3919d("toArray(...)", array);
        String[] strArr2 = (String[]) array;
        if (!(strArr2.length == 0)) {
            final PluginHandle pluginHandle2 = this.f3538b;
            AbstractC1766e.m3917b(pluginHandle2);
            PluginManager.RequestPermissionsCallback requestPermissionsCallback = new PluginManager.RequestPermissionsCallback() { // from class: app.tauri.plugin.a
                /* JADX WARN: Removed duplicated region for block: B:34:0x00d0  */
                /* JADX WARN: Removed duplicated region for block: B:37:0x00d5 A[LOOP:1: B:21:0x00a1->B:37:0x00d5, LOOP_END] */
                /* JADX WARN: Removed duplicated region for block: B:70:0x00d3 A[SYNTHETIC] */
                @Override // app.tauri.plugin.PluginManager.RequestPermissionsCallback
                /* JADX INFO: renamed from: a */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void mo2692a(java.util.Map r13) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
                    /*
                        Method dump skipped, instruction units count: 350
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: app.tauri.plugin.C0996a.mo2692a(java.util.Map):void");
                }
            };
            PluginManager pluginManager = pluginHandle2.f3540a;
            pluginManager.getClass();
            pluginManager.f3552d = requestPermissionsCallback;
            pluginManager.f3551c.m2213f(strArr2);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m2687e(String str, JSObject jSObject) {
        AbstractC1766e.m3920e("event", str);
        AbstractC1766e.m3920e("payload", jSObject);
        List list = (List) this.f3539c.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = new CopyOnWriteArrayList(list).iterator();
        while (it.hasNext()) {
            ((Channel) it.next()).m2679a(jSObject);
        }
    }

    @Command
    public void registerListener(Invoke invoke) {
        AbstractC1766e.m3920e("invoke", invoke);
        RegisterListenerArgs registerListenerArgs = (RegisterListenerArgs) invoke.f3536f.m1918k(RegisterListenerArgs.class, invoke.f3535e);
        LinkedHashMap linkedHashMap = this.f3539c;
        List list = (List) linkedHashMap.get(registerListenerArgs.getEvent());
        if (list == null || list.isEmpty()) {
            linkedHashMap.put(registerListenerArgs.getEvent(), new ArrayList(new C1082a(new Channel[]{registerListenerArgs.getHandler()}, true)));
        } else {
            list.add(registerListenerArgs.getHandler());
        }
        invoke.m2682c();
    }

    @Command
    public void removeListener(Invoke invoke) {
        Object next;
        AbstractC1766e.m3920e("invoke", invoke);
        RemoveListenerArgs removeListenerArgs = (RemoveListenerArgs) invoke.f3536f.m1918k(RemoveListenerArgs.class, invoke.f3535e);
        List list = (List) this.f3539c.get(removeListenerArgs.getEvent());
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((Channel) next).f3525a == removeListenerArgs.getChannelId()) {
                        break;
                    }
                }
            }
            Channel channel = (Channel) next;
            if (channel != null) {
                list.remove(channel);
            }
        }
        invoke.m2682c();
    }

    @Command
    public void requestPermissions(Invoke invoke) {
        Object[] array;
        C1077v c1077v;
        AbstractC1766e.m3920e("invoke", invoke);
        PluginHandle pluginHandle = this.f3538b;
        C1077v c1077v2 = null;
        TauriPlugin tauriPlugin = pluginHandle != null ? pluginHandle.f3547h : null;
        if (tauriPlugin != null) {
            HashSet hashSet = new HashSet();
            List<String> permissions = ((RequestPermissionsArgs) invoke.m2680a(RequestPermissionsArgs.class)).getPermissions();
            C1077v c1077v3 = C1077v.f3761a;
            if (permissions != null) {
                HashSet hashSet2 = new HashSet();
                for (Permission permission : tauriPlugin.permissions()) {
                    if (permissions.contains(permission.alias())) {
                        hashSet2.add(permission.alias());
                    }
                }
                if (hashSet2.isEmpty()) {
                    invoke.m2681b("No valid permission alias was requested of this plugin.");
                    return;
                } else {
                    array = hashSet2.toArray(new String[0]);
                    c1077v = c1077v3;
                }
            } else {
                array = null;
                c1077v = null;
            }
            if (c1077v == null) {
                HashSet hashSet3 = new HashSet();
                for (Permission permission2 : tauriPlugin.permissions()) {
                    if (permission2.strings().length != 0 && (permission2.strings().length != 1 || permission2.strings()[0].length() != 0)) {
                        hashSet3.add(permission2.alias());
                    } else if (permission2.alias().length() > 0) {
                        hashSet.add(permission2.alias());
                    }
                }
                array = hashSet3.toArray(new String[0]);
            }
            String[] strArr = (String[]) array;
            if (strArr != null) {
                m2686d(strArr, invoke, "checkPermissions");
                c1077v2 = c1077v3;
            }
            if (c1077v2 == null) {
                if (!(true ^ hashSet.isEmpty())) {
                    invoke.m2682c();
                    return;
                }
                JSObject jSObject = new JSObject();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSObject.put((String) it.next(), "granted");
                }
                invoke.m2683d(jSObject);
            }
        }
    }
}

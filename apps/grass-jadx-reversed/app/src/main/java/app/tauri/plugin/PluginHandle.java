package app.tauri.plugin;

import app.tauri.annotation.ActivityCallback;
import app.tauri.annotation.Command;
import app.tauri.annotation.PermissionCallback;
import app.tauri.annotation.TauriPlugin;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import p069X0.C0734y;
import p086c2.AbstractC1086e;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class PluginHandle {

    /* JADX INFO: renamed from: a */
    public final PluginManager f3540a;

    /* JADX INFO: renamed from: b */
    public final Plugin f3541b;

    /* JADX INFO: renamed from: c */
    public final String f3542c;

    /* JADX INFO: renamed from: d */
    public final C0734y f3543d;

    /* JADX INFO: renamed from: e */
    public final HashMap f3544e;

    /* JADX INFO: renamed from: f */
    public final HashMap f3545f;

    /* JADX INFO: renamed from: g */
    public final HashMap f3546g;

    /* JADX INFO: renamed from: h */
    public final TauriPlugin f3547h;

    /* JADX INFO: renamed from: i */
    public boolean f3548i;

    public PluginHandle(PluginManager pluginManager, String str, Plugin plugin, String str2, C0734y c0734y) {
        AbstractC1766e.m3920e("manager", pluginManager);
        AbstractC1766e.m3920e("name", str);
        AbstractC1766e.m3920e("instance", plugin);
        AbstractC1766e.m3920e("config", str2);
        AbstractC1766e.m3920e("jsonMapper", c0734y);
        this.f3540a = pluginManager;
        this.f3541b = plugin;
        this.f3542c = str2;
        this.f3543d = c0734y;
        this.f3544e = new HashMap();
        this.f3545f = new HashMap();
        this.f3546g = new HashMap();
        ArrayList<Method> arrayList = new ArrayList();
        Class<?> superclass = plugin.getClass();
        while (!superclass.getName().equals(Object.class.getName())) {
            Method[] declaredMethods = superclass.getDeclaredMethods();
            AbstractC1766e.m3919d("getDeclaredMethods(...)", declaredMethods);
            arrayList.addAll(AbstractC1086e.m2837u(Arrays.copyOf(declaredMethods, declaredMethods.length)));
            superclass = superclass.getSuperclass();
            AbstractC1766e.m3919d("getSuperclass(...)", superclass);
        }
        for (Method method : arrayList) {
            if (method.isAnnotationPresent(Command.class)) {
                Command command = (Command) method.getAnnotation(Command.class);
                if (command != null) {
                    CommandData commandData = new CommandData(method, command);
                    String name = method.getName();
                    AbstractC1766e.m3919d("getName(...)", name);
                    this.f3544e.put(name, commandData);
                }
            }
            if (method.isAnnotationPresent(ActivityCallback.class)) {
                String name2 = method.getName();
                AbstractC1766e.m3919d("getName(...)", name2);
                this.f3546g.put(name2, method);
            }
            if (method.isAnnotationPresent(PermissionCallback.class)) {
                String name3 = method.getName();
                AbstractC1766e.m3919d("getName(...)", name3);
                this.f3545f.put(name3, method);
            }
        }
        Plugin plugin2 = this.f3541b;
        plugin2.f3538b = this;
        this.f3547h = (TauriPlugin) plugin2.getClass().getAnnotation(TauriPlugin.class);
    }

    /* JADX INFO: renamed from: a */
    public final void m2688a(Invoke invoke) throws InvalidCommandException, IllegalAccessException, InvocationTargetException {
        HashMap map = this.f3544e;
        String str = invoke.f3531a;
        CommandData commandData = (CommandData) map.get(str);
        Plugin plugin = this.f3541b;
        if (commandData != null) {
            commandData.f3530a.invoke(plugin, invoke);
        } else {
            throw new InvalidCommandException("No command " + str + " found for plugin " + plugin.getClass().getName());
        }
    }
}

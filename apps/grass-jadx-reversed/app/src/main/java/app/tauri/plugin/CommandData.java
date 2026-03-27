package app.tauri.plugin;

import app.tauri.annotation.Command;
import java.lang.reflect.Method;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
public final class CommandData {

    /* JADX INFO: renamed from: a */
    public final Method f3530a;

    public CommandData(Method method, Command command) {
        this.f3530a = method;
        AbstractC1766e.m3919d("getName(...)", method.getName());
    }
}

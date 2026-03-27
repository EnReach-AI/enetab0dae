package com.plugin.safeareainsets;

import android.app.Activity;
import android.view.View;
import app.tauri.annotation.Command;
import app.tauri.annotation.TauriPlugin;
import app.tauri.plugin.Invoke;
import app.tauri.plugin.JSObject;
import app.tauri.plugin.Plugin;
import java.util.WeakHashMap;
import p029J.AbstractC0314I;
import p029J.AbstractC0323S;
import p029J.C0364q0;
import p083b2.C1077v;
import p119m2.AbstractC1766e;

/* JADX INFO: loaded from: classes.dex */
@TauriPlugin
public final class InsetPlugin extends Plugin {

    /* JADX INFO: renamed from: d */
    public final Activity f4581d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InsetPlugin(Activity activity) {
        super(activity);
        AbstractC1766e.m3920e("activity", activity);
        this.f4581d = activity;
    }

    /* JADX INFO: renamed from: f */
    public final float m3233f(float f3) {
        return f3 / this.f4581d.getResources().getDisplayMetrics().density;
    }

    @Command
    public final void getInsets(Invoke invoke) {
        C1077v c1077v;
        AbstractC1766e.m3920e("invoke", invoke);
        View decorView = this.f4581d.getWindow().getDecorView();
        AbstractC1766e.m3919d("getDecorView(...)", decorView);
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        C0364q0 c0364q0M654a = AbstractC0314I.m654a(decorView);
        if (c0364q0M654a != null) {
            AbstractC1766e.m3919d("getInsets(...)", c0364q0M654a.f874a.mo751f(7));
            JSObject jSObject = new JSObject();
            jSObject.put("top", m3233f(r0.f82b));
            jSObject.put("bottom", m3233f(r0.f84d));
            jSObject.put("left", m3233f(r0.f81a));
            jSObject.put("right", m3233f(r0.f83c));
            invoke.m2683d(jSObject);
            c1077v = C1077v.f3761a;
        } else {
            c1077v = null;
        }
        if (c1077v == null) {
            invoke.m2681b("Failed to get window insets");
        }
    }
}

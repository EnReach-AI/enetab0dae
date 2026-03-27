package com.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.AbstractComponentCallbacksC0944o;
import androidx.fragment.app.C0918D;
import androidx.fragment.app.C0930a;
import androidx.fragment.app.C0946q;
import io.getgrass.www.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p010C0.AbstractC0147a;
import p024H0.C0264r;
import p030J0.C0376a;
import p033K0.C0404b;
import p036L0.AbstractC0441a;
import p166z0.AbstractC2087y;
import p166z0.C2070h;
import p166z0.C2071i;

/* JADX INFO: loaded from: classes.dex */
public class FacebookActivity extends AbstractActivityC0947r {

    /* JADX INFO: renamed from: x */
    public AbstractComponentCallbacksC0944o f3819x;

    @Override // androidx.fragment.app.AbstractActivityC0947r, android.app.Activity
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            if (C2071i.m4589t(str, printWriter, strArr)) {
                return;
            }
            super.dump(str, fileDescriptor, printWriter, strArr);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, androidx.activity.AbstractActivityC0873h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3819x;
        if (abstractComponentCallbacksC0944o != null) {
            abstractComponentCallbacksC0944o.onConfigurationChanged(configuration);
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0947r, androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void onCreate(Bundle bundle) {
        AbstractComponentCallbacksC0944o c0264r;
        C1111h c1111h;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (!AbstractC1117n.m2895e()) {
            Context applicationContext = getApplicationContext();
            synchronized (AbstractC1117n.class) {
                AbstractC1117n.m2900j(applicationContext);
            }
        }
        setContentView(R.layout.com_facebook_activity_layout);
        if ("PassThrough".equals(intent.getAction())) {
            Bundle bundleM4639h = AbstractC2087y.m4639h(getIntent());
            if (AbstractC0147a.f354a.contains(AbstractC2087y.class) || bundleM4639h == null) {
                c1111h = null;
            } else {
                try {
                    String string = bundleM4639h.getString("error_type");
                    if (string == null) {
                        string = bundleM4639h.getString("com.facebook.platform.status.ERROR_TYPE");
                    }
                    String string2 = bundleM4639h.getString("error_description");
                    if (string2 == null) {
                        string2 = bundleM4639h.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
                    }
                    c1111h = (string == null || !string.equalsIgnoreCase("UserCanceled")) ? new C1111h(string2) : new C1113j(string2);
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, AbstractC2087y.class);
                    c1111h = null;
                }
            }
            setResult(0, AbstractC2087y.m4635d(getIntent(), null, c1111h));
            finish();
            return;
        }
        Intent intent2 = getIntent();
        C0918D c0918d = ((C0946q) this.f3251s.f534f).f3249h;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM2408x = c0918d.m2408x("SingleFragment");
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = abstractComponentCallbacksC0944oM2408x;
        if (abstractComponentCallbacksC0944oM2408x == null) {
            if ("FacebookDialogFragment".equals(intent2.getAction())) {
                C2070h c2070h = new C2070h();
                c2070h.m2486N();
                c2070h.m2470R(c0918d, "SingleFragment");
                abstractComponentCallbacksC0944o = c2070h;
            } else if ("DeviceShareDialogFragment".equals(intent2.getAction())) {
                C0404b c0404b = new C0404b();
                c0404b.m2486N();
                c0404b.f932r0 = (AbstractC0441a) intent2.getParcelableExtra("content");
                c0404b.m2470R(c0918d, "SingleFragment");
                abstractComponentCallbacksC0944o = c0404b;
            } else {
                if ("ReferralFragment".equals(intent2.getAction())) {
                    c0264r = new C0376a();
                    c0264r.m2486N();
                    C0930a c0930a = new C0930a(c0918d);
                    c0930a.m2442e(R.id.com_facebook_fragment_container, c0264r, "SingleFragment", 1);
                    c0930a.m2441d(false);
                } else {
                    c0264r = new C0264r();
                    c0264r.m2486N();
                    C0930a c0930a2 = new C0930a(c0918d);
                    c0930a2.m2442e(R.id.com_facebook_fragment_container, c0264r, "SingleFragment", 1);
                    c0930a2.m2441d(false);
                }
                abstractComponentCallbacksC0944o = c0264r;
            }
        }
        this.f3819x = abstractComponentCallbacksC0944o;
    }
}

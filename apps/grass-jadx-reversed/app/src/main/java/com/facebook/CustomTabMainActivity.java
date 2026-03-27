package com.facebook;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import p010C0.AbstractC0147a;
import p068X.C0698c;
import p162y.AbstractC2027f;
import p165z.AbstractC2045a;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2087y;
import p166z0.C2065c;
import p166z0.C2068f;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabMainActivity extends Activity {

    /* JADX INFO: renamed from: g */
    public static final /* synthetic */ int f3803g = 0;

    /* JADX INFO: renamed from: e */
    public boolean f3804e = true;

    /* JADX INFO: renamed from: f */
    public C2065c f3805f;

    /* JADX INFO: renamed from: a */
    public final void m2862a(int i3, Intent intent) {
        Bundle bundle;
        C0698c.m1678a(this).m1681d(this.f3805f);
        if (intent != null) {
            String stringExtra = intent.getStringExtra("CustomTabMainActivity.extra_url");
            if (stringExtra != null) {
                Uri uri = Uri.parse(stringExtra);
                bundle = AbstractC2056E.m4554w(uri.getQuery());
                bundle.putAll(AbstractC2056E.m4554w(uri.getFragment()));
            } else {
                bundle = new Bundle();
            }
            Intent intentM4635d = AbstractC2087y.m4635d(getIntent(), bundle, null);
            if (intentM4635d != null) {
                intent = intentM4635d;
            }
            setResult(i3, intent);
        } else {
            setResult(i3, AbstractC2087y.m4635d(getIntent(), null, null));
        }
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        boolean z3;
        super.onCreate(bundle);
        if ("CustomTabActivity.action_customTabRedirect".equals(getIntent().getAction())) {
            setResult(0);
            finish();
            return;
        }
        if (bundle == null) {
            String stringExtra = getIntent().getStringExtra("CustomTabMainActivity.extra_action");
            Bundle bundleExtra = getIntent().getBundleExtra("CustomTabMainActivity.extra_params");
            String stringExtra2 = getIntent().getStringExtra("CustomTabMainActivity.extra_chromePackage");
            C2068f c2068f = new C2068f(0);
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            Uri uriM4574f = C2068f.m4574f(bundleExtra, stringExtra);
            if (AbstractC0147a.f354a.contains(c2068f)) {
                z3 = false;
            } else {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    Bundle bundle2 = new Bundle();
                    AbstractC2027f.m4481b(bundle2, "android.support.customtabs.extra.SESSION", null);
                    intent.putExtras(bundle2);
                    intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                    intent.setPackage(stringExtra2);
                    intent.addFlags(1073741824);
                    try {
                        intent.setData(uriM4574f);
                        AbstractC2045a.m4513b(this, intent, null);
                        z3 = true;
                    } catch (ActivityNotFoundException unused) {
                        z3 = false;
                    }
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, c2068f);
                }
            }
            this.f3804e = false;
            if (z3) {
                this.f3805f = new C2065c(2, this);
                C0698c.m1678a(this).m1679b(this.f3805f, new IntentFilter("CustomTabActivity.action_customTabRedirect"));
            } else {
                setResult(0, getIntent().putExtra("CustomTabMainActivity.no_activity_exception", true));
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if ("CustomTabMainActivity.action_refresh".equals(intent.getAction())) {
            C0698c.m1678a(this).m1680c(new Intent("CustomTabActivity.action_destroy"));
            m2862a(-1, intent);
        } else if ("CustomTabActivity.action_customTabRedirect".equals(intent.getAction())) {
            m2862a(-1, intent);
        }
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f3804e) {
            m2862a(0, null);
        }
        this.f3804e = true;
    }
}

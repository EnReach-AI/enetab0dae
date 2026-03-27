package com.facebook;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import p068X.C0698c;
import p166z0.C2065c;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabActivity extends Activity {

    /* JADX INFO: renamed from: e */
    public C2065c f3802e;

    @Override // android.app.Activity
    public final void onActivityResult(int i3, int i4, Intent intent) {
        super.onActivityResult(i3, i4, intent);
        if (i4 == 0) {
            Intent intent2 = new Intent("CustomTabActivity.action_customTabRedirect");
            intent2.putExtra("CustomTabMainActivity.extra_url", getIntent().getDataString());
            C0698c.m1678a(this).m1680c(intent2);
            this.f3802e = new C2065c(1, this);
            C0698c.m1678a(this).m1679b(this.f3802e, new IntentFilter("CustomTabActivity.action_destroy"));
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, (Class<?>) CustomTabMainActivity.class);
        intent.setAction("CustomTabActivity.action_customTabRedirect");
        intent.putExtra("CustomTabMainActivity.extra_url", getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        C0698c.m1678a(this).m1681d(this.f3802e);
        super.onDestroy();
    }
}

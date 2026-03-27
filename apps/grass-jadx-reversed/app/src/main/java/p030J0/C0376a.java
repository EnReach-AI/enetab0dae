package p030J0;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.AbstractComponentCallbacksC0944o;
import com.facebook.AbstractC1117n;
import com.facebook.CustomTabMainActivity;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;
import p166z0.C2068f;
import p166z0.C2071i;

/* JADX INFO: renamed from: J0.a */
/* JADX INFO: loaded from: classes.dex */
public class C0376a extends AbstractComponentCallbacksC0944o {

    /* JADX INFO: renamed from: W */
    public C2071i f889W;

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: o */
    public final void mo517o(int i3, int i4, Intent intent) {
        AbstractActivityC0947r abstractActivityC0947rM2490h;
        super.mo517o(i3, i4, intent);
        C2071i c2071i = this.f889W;
        c2071i.getClass();
        boolean zEquals = true;
        if (i3 != 1) {
            return;
        }
        if (intent != null) {
            int i5 = CustomTabMainActivity.f3803g;
            String stringExtra = intent.getStringExtra("CustomTabMainActivity.extra_url");
            if (stringExtra != null) {
                StringBuilder sb = new StringBuilder("fb");
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                sb.append(AbstractC1117n.f3877c);
                sb.append("://authorize");
                if (stringExtra.startsWith(AbstractC2069g.m4579c(sb.toString()))) {
                    Bundle bundleM4554w = AbstractC2056E.m4554w(Uri.parse(stringExtra).getQuery());
                    if (((String) c2071i.f7316c) != null) {
                        zEquals = ((String) c2071i.f7316c).equals(bundleM4554w.getString("state"));
                        c2071i.f7316c = null;
                    }
                    if (zEquals) {
                        intent.putExtras(bundleM4554w);
                    } else {
                        intent.putExtra("error_message", "The referral response was missing a valid challenge string.");
                        i4 = 0;
                    }
                }
            }
        }
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = (AbstractComponentCallbacksC0944o) c2071i.f7314a;
        if (!abstractComponentCallbacksC0944o.m2496n() || (abstractActivityC0947rM2490h = abstractComponentCallbacksC0944o.m2490h()) == null) {
            return;
        }
        abstractActivityC0947rM2490h.setResult(i4, intent);
        abstractActivityC0947rM2490h.finish();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: q */
    public final void mo518q(Bundle bundle) {
        super.mo518q(bundle);
        C2071i c2071i = new C2071i();
        c2071i.f7314a = this;
        this.f889W = c2071i;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: x */
    public final void mo521x() {
        AbstractActivityC0947r abstractActivityC0947rM2490h;
        this.f3208H = true;
        C2071i c2071i = this.f889W;
        if (((AbstractComponentCallbacksC0944o) c2071i.f7314a).m2490h() != null && ((AbstractComponentCallbacksC0944o) c2071i.f7314a).m2490h().checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
            if (((String) c2071i.f7315b) == null) {
                c2071i.f7315b = AbstractC2069g.m4577a();
            }
            if (((String) c2071i.f7315b) != null) {
                Bundle bundle = new Bundle();
                c2071i.f7316c = new BigInteger(100, new Random()).toString(32);
                StringBuilder sb = new StringBuilder("fb");
                HashSet hashSet = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                sb.append(AbstractC1117n.f3877c);
                sb.append("://authorize");
                bundle.putString("redirect_uri", AbstractC2069g.m4579c(sb.toString()));
                AbstractC2069g.m4584h();
                bundle.putString("app_id", AbstractC1117n.f3877c);
                bundle.putString("state", (String) c2071i.f7316c);
                if (AbstractC1117n.f3886l) {
                    C2068f.m4574f(bundle, "share_referral");
                }
                Intent intent = new Intent(((AbstractComponentCallbacksC0944o) c2071i.f7314a).m2490h(), (Class<?>) CustomTabMainActivity.class);
                int i3 = CustomTabMainActivity.f3803g;
                intent.putExtra("CustomTabMainActivity.extra_action", "share_referral");
                intent.putExtra("CustomTabMainActivity.extra_params", bundle);
                if (((String) c2071i.f7315b) == null) {
                    c2071i.f7315b = AbstractC2069g.m4577a();
                }
                intent.putExtra("CustomTabMainActivity.extra_chromePackage", (String) c2071i.f7315b);
                ((AbstractComponentCallbacksC0944o) c2071i.f7314a).m2487O(1, intent);
                return;
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("error_message", "Failed to open Referral dialog: Chrome custom tab could not be started. Please make sure internet permission is granted and Chrome is installed");
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = (AbstractComponentCallbacksC0944o) c2071i.f7314a;
        if (!abstractComponentCallbacksC0944o.m2496n() || (abstractActivityC0947rM2490h = abstractComponentCallbacksC0944o.m2490h()) == null) {
            return;
        }
        abstractActivityC0947rM2490h.setResult(0, intent2);
        abstractActivityC0947rM2490h.finish();
    }
}

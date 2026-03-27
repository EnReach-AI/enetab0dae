package p166z0;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1107d;
import com.facebook.C1111h;
import java.util.Date;
import java.util.HashSet;
import p005B.AbstractC0032g;
import p019F0.C0221e;
import p036L0.C0444d;

/* JADX INFO: renamed from: z0.h */
/* JADX INFO: loaded from: classes.dex */
public class C2070h extends DialogInterfaceOnCancelListenerC0941l {

    /* JADX INFO: renamed from: m0 */
    public Dialog f7309m0;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l
    /* JADX INFO: renamed from: Q */
    public final Dialog mo492Q() {
        if (this.f7309m0 == null) {
            AbstractActivityC0947r abstractActivityC0947rM2490h = m2490h();
            abstractActivityC0947rM2490h.setResult(-1, AbstractC2087y.m4635d(abstractActivityC0947rM2490h.getIntent(), null, null));
            abstractActivityC0947rM2490h.finish();
            this.f3179d0 = false;
        }
        return this.f7309m0;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.f3208H = true;
        Dialog dialog = this.f7309m0;
        if (!(dialog instanceof DialogC2062K) || this.f3222e < 7) {
            return;
        }
        ((DialogC2062K) dialog).m4564e();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: q */
    public final void mo518q(Bundle bundle) {
        DialogC2062K dialogC2062KM4562c;
        String str;
        super.mo518q(bundle);
        if (this.f7309m0 == null) {
            AbstractActivityC0947r abstractActivityC0947rM2490h = m2490h();
            Bundle bundleM4639h = AbstractC2087y.m4639h(abstractActivityC0947rM2490h.getIntent());
            if (bundleM4639h.getBoolean("is_fallback", false)) {
                String string = bundleM4639h.getString("url");
                if (AbstractC2056E.m4550s(string)) {
                    HashSet hashSet = AbstractC1117n.f3875a;
                    abstractActivityC0947rM2490h.finish();
                    return;
                }
                HashSet hashSet2 = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                String strM154l = AbstractC0032g.m154l("fb", AbstractC1117n.f3877c, "://bridge/");
                int i3 = DialogC2073k.f7318s;
                DialogC2062K.m4561b(abstractActivityC0947rM2490h);
                AbstractC2069g.m4584h();
                int i4 = DialogC2062K.f7281q;
                if (i4 == 0) {
                    AbstractC2069g.m4584h();
                    i4 = DialogC2062K.f7281q;
                }
                DialogC2073k dialogC2073k = new DialogC2073k(abstractActivityC0947rM2490h, i4);
                dialogC2073k.f7290m = false;
                dialogC2073k.f7291n = false;
                dialogC2073k.f7292o = false;
                dialogC2073k.f7282e = string;
                dialogC2073k.f7283f = strM154l;
                dialogC2073k.f7284g = new C0221e(23, this);
                dialogC2062KM4562c = dialogC2073k;
            } else {
                String string2 = bundleM4639h.getString("action");
                Bundle bundle2 = bundleM4639h.getBundle("params");
                if (AbstractC2056E.m4550s(string2)) {
                    HashSet hashSet3 = AbstractC1117n.f3875a;
                    abstractActivityC0947rM2490h.finish();
                    return;
                }
                Date date = C1104a.f3820p;
                C1104a c1104a = (C1104a) C1107d.m2887a().f3849d;
                if (C1104a.m2876b()) {
                    str = null;
                } else {
                    AbstractC2069g.m4582f("context", abstractActivityC0947rM2490h);
                    HashSet hashSet4 = AbstractC1117n.f3875a;
                    synchronized (AbstractC1117n.class) {
                        AbstractC1117n.m2900j(abstractActivityC0947rM2490h);
                    }
                    AbstractC2069g.m4584h();
                    str = AbstractC1117n.f3877c;
                    if (str == null) {
                        throw new C1111h("Attempted to create a builder without a valid access token or a valid default Application ID.");
                    }
                }
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                C0444d c0444d = new C0444d(this);
                if (c1104a != null) {
                    bundle2.putString("app_id", c1104a.f3830l);
                    bundle2.putString("access_token", c1104a.f3827i);
                } else {
                    bundle2.putString("app_id", str);
                }
                dialogC2062KM4562c = DialogC2062K.m4562c(abstractActivityC0947rM2490h, string2, bundle2, c0444d);
            }
            this.f7309m0 = dialogC2062KM4562c;
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: t */
    public final void mo501t() {
        Dialog dialog = this.f3183h0;
        if (dialog != null && this.f3205E) {
            dialog.setDismissMessage(null);
        }
        super.mo501t();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: x */
    public final void mo521x() {
        this.f3208H = true;
        Dialog dialog = this.f7309m0;
        if (dialog instanceof DialogC2062K) {
            ((DialogC2062K) dialog).m4564e();
        }
    }
}

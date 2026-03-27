package p024H0;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l;
import com.facebook.AbstractC1117n;
import com.facebook.AsyncTaskC1126w;
import com.facebook.C1104a;
import com.facebook.C1111h;
import com.facebook.C1125v;
import com.facebook.EnumC1108e;
import com.facebook.EnumC1129z;
import com.facebook.FacebookActivity;
import io.getgrass.www.R;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p007B1.RunnableC0055o;
import p163y0.AbstractC2043b;
import p166z0.AbstractC2069g;
import p166z0.C2071i;

/* JADX INFO: renamed from: H0.i */
/* JADX INFO: loaded from: classes.dex */
public class C0255i extends DialogInterfaceOnCancelListenerC0941l {

    /* JADX INFO: renamed from: m0 */
    public View f630m0;

    /* JADX INFO: renamed from: n0 */
    public TextView f631n0;

    /* JADX INFO: renamed from: o0 */
    public TextView f632o0;

    /* JADX INFO: renamed from: p0 */
    public C0256j f633p0;

    /* JADX INFO: renamed from: r0 */
    public volatile AsyncTaskC1126w f635r0;

    /* JADX INFO: renamed from: s0 */
    public volatile ScheduledFuture f636s0;

    /* JADX INFO: renamed from: t0 */
    public volatile C0254h f637t0;

    /* JADX INFO: renamed from: u0 */
    public Dialog f638u0;

    /* JADX INFO: renamed from: q0 */
    public final AtomicBoolean f634q0 = new AtomicBoolean();

    /* JADX INFO: renamed from: v0 */
    public boolean f639v0 = false;

    /* JADX INFO: renamed from: w0 */
    public boolean f640w0 = false;

    /* JADX INFO: renamed from: x0 */
    public C0261o f641x0 = null;

    /* JADX INFO: renamed from: S */
    public static void m490S(C0255i c0255i, String str, Long l3, Long l4) {
        c0255i.getClass();
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        Date date = l3.longValue() != 0 ? new Date((l3.longValue() * 1000) + new Date().getTime()) : null;
        Date date2 = l4.longValue() != 0 ? new Date(l4.longValue() * 1000) : null;
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        new C1125v(new C1104a(str, AbstractC1117n.f3877c, "0", null, null, null, null, date, null, date2, null), "me", bundle, EnumC1129z.f3922e, new C0253g(c0255i, str, date, date2)).m2924e();
    }

    /* JADX INFO: renamed from: T */
    public static void m491T(C0255i c0255i, String str, C2071i c2071i, String str2, Date date, Date date2) {
        C0256j c0256j = c0255i.f633p0;
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        String str3 = AbstractC1117n.f3877c;
        List list = (List) c2071i.f7314a;
        List list2 = (List) c2071i.f7315b;
        List list3 = (List) c2071i.f7316c;
        EnumC1108e enumC1108e = EnumC1108e.DEVICE_AUTH;
        c0256j.getClass();
        c0256j.f688f.m512d(new C0262p(c0256j.f688f.f675k, 1, new C1104a(str2, str3, str, list, list2, list3, enumC1108e, date, null, date2, null), null, null));
        c0255i.f638u0.dismiss();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l
    /* JADX INFO: renamed from: Q */
    public final Dialog mo492Q() {
        this.f638u0 = new Dialog(m2490h(), R.style.com_facebook_auth_dialog);
        this.f638u0.setContentView(m493U(AbstractC2043b.m4510d() && !this.f640w0));
        return this.f638u0;
    }

    /* JADX INFO: renamed from: U */
    public final View m493U(boolean z3) {
        View viewInflate = m2490h().getLayoutInflater().inflate(z3 ? R.layout.com_facebook_smart_device_dialog_fragment : R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.f630m0 = viewInflate.findViewById(R.id.progress_bar);
        this.f631n0 = (TextView) viewInflate.findViewById(R.id.confirmation_code);
        ((Button) viewInflate.findViewById(R.id.cancel_button)).setOnClickListener(new ViewOnClickListenerC0250d(0, this));
        TextView textView = (TextView) viewInflate.findViewById(R.id.com_facebook_device_auth_instructions);
        this.f632o0 = textView;
        textView.setText(Html.fromHtml(m2495m().getString(R.string.com_facebook_device_auth_instructions)));
        return viewInflate;
    }

    /* JADX INFO: renamed from: V */
    public final void m494V() {
        if (this.f634q0.compareAndSet(false, true)) {
            if (this.f637t0 != null) {
                AbstractC2043b.m4507a(this.f637t0.f626f);
            }
            C0256j c0256j = this.f633p0;
            if (c0256j != null) {
                c0256j.f688f.m512d(new C0262p(c0256j.f688f.f675k, 2, null, "User canceled log in.", null));
            }
            this.f638u0.dismiss();
        }
    }

    /* JADX INFO: renamed from: W */
    public final void m495W(C1111h c1111h) {
        if (this.f634q0.compareAndSet(false, true)) {
            if (this.f637t0 != null) {
                AbstractC2043b.m4507a(this.f637t0.f626f);
            }
            C0256j c0256j = this.f633p0;
            c0256j.f688f.m512d(C0262p.m507a(c0256j.f688f.f675k, null, c1111h.getMessage(), null));
            this.f638u0.dismiss();
        }
    }

    /* JADX INFO: renamed from: X */
    public final void m496X() {
        this.f637t0.f629i = new Date().getTime();
        Bundle bundle = new Bundle();
        bundle.putString("code", this.f637t0.f627g);
        this.f635r0 = new C1125v(null, "device/login_status", bundle, EnumC1129z.f3923f, new C0249c(this, 1)).m2924e();
    }

    /* JADX INFO: renamed from: Y */
    public final void m497Y() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (C0256j.class) {
            try {
                if (C0256j.f642g == null) {
                    C0256j.f642g = new ScheduledThreadPoolExecutor(1);
                }
                scheduledThreadPoolExecutor = C0256j.f642g;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f636s0 = scheduledThreadPoolExecutor.schedule(new RunnableC0055o(1, this), this.f637t0.f628h, TimeUnit.SECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX INFO: renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m498Z(p024H0.C0254h r18) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p024H0.C0255i.m498Z(H0.h):void");
    }

    /* JADX INFO: renamed from: a0 */
    public final void m499a0(C0261o c0261o) {
        this.f641x0 = c0261o;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", c0261o.f654f));
        String str = c0261o.f659k;
        if (str != null) {
            bundle.putString("redirect_uri", str);
        }
        String str2 = c0261o.f661m;
        if (str2 != null) {
            bundle.putString("target_user_id", str2);
        }
        StringBuilder sb = new StringBuilder();
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        String str3 = AbstractC1117n.f3877c;
        if (str3 == null) {
            throw new IllegalStateException("No App ID found, please set the App ID.");
        }
        sb.append(str3);
        sb.append("|");
        AbstractC2069g.m4584h();
        String str4 = AbstractC1117n.f3879e;
        if (str4 == null) {
            throw new IllegalStateException("No Client Token found, please set the Client Token.");
        }
        sb.append(str4);
        bundle.putString("access_token", sb.toString());
        bundle.putString("device_info", AbstractC2043b.m4509c());
        new C1125v(null, "device/login", bundle, EnumC1129z.f3923f, new C0249c(this, 0)).m2924e();
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f639v0) {
            return;
        }
        m494V();
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: r */
    public final View mo500r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0254h c0254h;
        this.f633p0 = (C0256j) ((C0264r) ((FacebookActivity) m2490h()).f3819x).f682X.m513e();
        if (bundle == null || (c0254h = (C0254h) bundle.getParcelable("request_state")) == null) {
            return null;
        }
        m498Z(c0254h);
        return null;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: t */
    public final void mo501t() {
        this.f639v0 = true;
        this.f634q0.set(true);
        super.mo501t();
        if (this.f635r0 != null) {
            this.f635r0.cancel(true);
        }
        if (this.f636s0 != null) {
            this.f636s0.cancel(true);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: y */
    public final void mo502y(Bundle bundle) {
        super.mo502y(bundle);
        if (this.f637t0 != null) {
            bundle.putParcelable("request_state", this.f637t0);
        }
    }
}

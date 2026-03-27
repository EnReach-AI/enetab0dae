package p033K0;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.C0918D;
import androidx.fragment.app.C0930a;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import com.facebook.C1114k;
import com.facebook.C1125v;
import com.facebook.EnumC1129z;
import io.getgrass.www.R;
import java.util.HashSet;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p002A0.C0019a;
import p007B1.RunnableC0055o;
import p010C0.AbstractC0147a;
import p019F0.C0222f;
import p024H0.ViewOnClickListenerC0250d;
import p036L0.AbstractC0441a;
import p036L0.C0442b;
import p036L0.C0443c;
import p036L0.C0445e;
import p036L0.C0446f;
import p163y0.AbstractC2043b;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: K0.b */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class C0404b extends DialogInterfaceOnCancelListenerC0941l {

    /* JADX INFO: renamed from: s0 */
    public static ScheduledThreadPoolExecutor f926s0;

    /* JADX INFO: renamed from: m0 */
    public ProgressBar f927m0;

    /* JADX INFO: renamed from: n0 */
    public TextView f928n0;

    /* JADX INFO: renamed from: o0 */
    public Dialog f929o0;

    /* JADX INFO: renamed from: p0 */
    public volatile C0403a f930p0;

    /* JADX INFO: renamed from: q0 */
    public volatile ScheduledFuture f931q0;

    /* JADX INFO: renamed from: r0 */
    public AbstractC0441a f932r0;

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l
    /* JADX INFO: renamed from: Q */
    public final Dialog mo492Q() {
        Bundle bundle;
        this.f929o0 = new Dialog(m2490h(), R.style.com_facebook_auth_dialog);
        Bundle bundle2 = null;
        jSONObjectM890l = null;
        JSONObject jSONObjectM890l = null;
        bundle2 = null;
        View viewInflate = m2490h().getLayoutInflater().inflate(R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.f927m0 = (ProgressBar) viewInflate.findViewById(R.id.progress_bar);
        this.f928n0 = (TextView) viewInflate.findViewById(R.id.confirmation_code);
        ((Button) viewInflate.findViewById(R.id.cancel_button)).setOnClickListener(new ViewOnClickListenerC0250d(1, this));
        ((TextView) viewInflate.findViewById(R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(m2495m().getString(R.string.com_facebook_device_auth_instructions)));
        this.f929o0.setContentView(viewInflate);
        AbstractC0441a abstractC0441a = this.f932r0;
        if (abstractC0441a != null) {
            if (abstractC0441a instanceof C0443c) {
                C0443c c0443c = (C0443c) abstractC0441a;
                bundle2 = new Bundle();
                C0442b c0442b = c0443c.f1079j;
                if (c0442b != null) {
                    String str = c0442b.f1080e;
                    if (!AbstractC2056E.m4550s(str)) {
                        bundle2.putString("hashtag", str);
                    }
                }
                Uri uri = c0443c.f1074e;
                if (uri != null) {
                    String string = uri.toString();
                    if (!AbstractC2056E.m4550s(string)) {
                        bundle2.putString("href", string);
                    }
                }
                String str2 = c0443c.f1084n;
                if (!AbstractC2056E.m4550s(str2)) {
                    bundle2.putString("quote", str2);
                }
            } else if (abstractC0441a instanceof C0446f) {
                C0446f c0446f = (C0446f) abstractC0441a;
                Bundle bundle3 = new Bundle();
                C0442b c0442b2 = c0446f.f1079j;
                if (c0442b2 != null) {
                    String str3 = c0442b2.f1080e;
                    if (!AbstractC2056E.m4550s(str3)) {
                        bundle3.putString("hashtag", str3);
                    }
                }
                C0445e c0445e = c0446f.f1086k;
                String string2 = c0445e.f1088e.getString("og:type");
                if (!AbstractC2056E.m4550s(string2)) {
                    bundle3.putString("action_type", string2);
                }
                try {
                    if (!AbstractC0147a.f354a.contains(AbstractC0406d.class)) {
                        try {
                            jSONObjectM890l = AbstractC0405c.m890l(c0445e, new C0222f(2));
                        } catch (Throwable th) {
                            AbstractC0147a.m295a(th, AbstractC0406d.class);
                        }
                    }
                    JSONObject jSONObjectM903m = AbstractC0406d.m903m(jSONObjectM890l, false);
                    if (jSONObjectM903m != null) {
                        String string3 = jSONObjectM903m.toString();
                        if (!AbstractC2056E.m4550s(string3)) {
                            bundle3.putString("action_properties", string3);
                        }
                    }
                    bundle = bundle3;
                } catch (JSONException e3) {
                    throw new C1111h("Unable to serialize the ShareOpenGraphContent to JSON", e3);
                }
            }
            bundle = bundle2;
        } else {
            bundle = bundle2;
        }
        if (bundle == null || bundle.size() == 0) {
            m880T(new C1114k(0, "", "Failed to get share content"));
        }
        StringBuilder sb = new StringBuilder();
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        String str4 = AbstractC1117n.f3877c;
        if (str4 == null) {
            throw new IllegalStateException("No App ID found, please set the App ID.");
        }
        sb.append(str4);
        sb.append("|");
        AbstractC2069g.m4584h();
        String str5 = AbstractC1117n.f3879e;
        if (str5 == null) {
            throw new IllegalStateException("No Client Token found, please set the Client Token.");
        }
        sb.append(str5);
        bundle.putString("access_token", sb.toString());
        bundle.putString("device_info", AbstractC2043b.m4509c());
        new C1125v(null, "device/share", bundle, EnumC1129z.f3923f, new C0019a(1, this)).m2924e();
        return this.f929o0;
    }

    /* JADX INFO: renamed from: S */
    public final void m879S(Intent intent) {
        if (this.f930p0 != null) {
            AbstractC2043b.m4507a(this.f930p0.f924e);
        }
        C1114k c1114k = (C1114k) intent.getParcelableExtra("error");
        if (c1114k != null) {
            Context contextM2492j = m2492j();
            String localizedMessage = c1114k.f3868i;
            if (localizedMessage == null) {
                localizedMessage = c1114k.f3872m.getLocalizedMessage();
            }
            Toast.makeText(contextM2492j, localizedMessage, 0).show();
        }
        if (m2496n()) {
            AbstractActivityC0947r abstractActivityC0947rM2490h = m2490h();
            abstractActivityC0947rM2490h.setResult(-1, intent);
            abstractActivityC0947rM2490h.finish();
        }
    }

    /* JADX INFO: renamed from: T */
    public final void m880T(C1114k c1114k) {
        if (m2496n()) {
            C0918D c0918d = this.f3239v;
            c0918d.getClass();
            C0930a c0930a = new C0930a(c0918d);
            c0930a.m2446i(this);
            c0930a.m2441d(false);
        }
        Intent intent = new Intent();
        intent.putExtra("error", c1114k);
        m879S(intent);
    }

    /* JADX INFO: renamed from: U */
    public final void m881U(C0403a c0403a) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        this.f930p0 = c0403a;
        this.f928n0.setText(c0403a.f924e);
        this.f928n0.setVisibility(0);
        this.f927m0.setVisibility(8);
        synchronized (C0404b.class) {
            try {
                if (f926s0 == null) {
                    f926s0 = new ScheduledThreadPoolExecutor(1);
                }
                scheduledThreadPoolExecutor = f926s0;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f931q0 = scheduledThreadPoolExecutor.schedule(new RunnableC0055o(2, this), c0403a.f925f, TimeUnit.SECONDS);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.f931q0 != null) {
            this.f931q0.cancel(true);
        }
        m879S(new Intent());
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: r */
    public final View mo500r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0403a c0403a;
        if (bundle == null || (c0403a = (C0403a) bundle.getParcelable("request_state")) == null) {
            return null;
        }
        m881U(c0403a);
        return null;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l, androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: y */
    public final void mo502y(Bundle bundle) {
        super.mo502y(bundle);
        if (this.f930p0 != null) {
            bundle.putParcelable("request_state", this.f930p0);
        }
    }
}

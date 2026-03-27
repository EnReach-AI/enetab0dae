package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0989v;
import androidx.lifecycle.C0990w;
import io.getgrass.www.R;
import p007B1.RunnableC0055o;
import p036L0.C0444d;
import p125o0.AbstractC1794d;

/* JADX INFO: renamed from: androidx.fragment.app.l */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceOnCancelListenerC0941l extends AbstractComponentCallbacksC0944o implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: W */
    public Handler f3172W;

    /* JADX INFO: renamed from: f0 */
    public boolean f3181f0;

    /* JADX INFO: renamed from: h0 */
    public Dialog f3183h0;

    /* JADX INFO: renamed from: i0 */
    public boolean f3184i0;

    /* JADX INFO: renamed from: j0 */
    public boolean f3185j0;

    /* JADX INFO: renamed from: k0 */
    public boolean f3186k0;

    /* JADX INFO: renamed from: X */
    public final RunnableC0055o f3173X = new RunnableC0055o(11, this);

    /* JADX INFO: renamed from: Y */
    public final DialogInterfaceOnCancelListenerC0938i f3174Y = new DialogInterfaceOnCancelListenerC0938i(this, 0);

    /* JADX INFO: renamed from: Z */
    public final DialogInterfaceOnDismissListenerC0939j f3175Z = new DialogInterfaceOnDismissListenerC0939j(this);

    /* JADX INFO: renamed from: a0 */
    public int f3176a0 = 0;

    /* JADX INFO: renamed from: b0 */
    public int f3177b0 = 0;

    /* JADX INFO: renamed from: c0 */
    public boolean f3178c0 = true;

    /* JADX INFO: renamed from: d0 */
    public boolean f3179d0 = true;

    /* JADX INFO: renamed from: e0 */
    public int f3180e0 = -1;

    /* JADX INFO: renamed from: g0 */
    public final C0444d f3182g0 = new C0444d(this);

    /* JADX INFO: renamed from: l0 */
    public boolean f3187l0 = false;

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: A */
    public void mo2466A() {
        this.f3208H = true;
        Dialog dialog = this.f3183h0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: B */
    public final void mo2467B(Bundle bundle) {
        Bundle bundle2;
        this.f3208H = true;
        if (this.f3183h0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3183h0.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: C */
    public final void mo2468C(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.mo2468C(layoutInflater, viewGroup, bundle);
        if (this.f3210J != null || this.f3183h0 == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f3183h0.onRestoreInstanceState(bundle2);
    }

    /* JADX INFO: renamed from: P */
    public final void m2469P(boolean z3, boolean z4) {
        if (this.f3185j0) {
            return;
        }
        this.f3185j0 = true;
        this.f3186k0 = false;
        Dialog dialog = this.f3183h0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.f3183h0.dismiss();
            if (!z4) {
                if (Looper.myLooper() == this.f3172W.getLooper()) {
                    onDismiss(this.f3183h0);
                } else {
                    this.f3172W.post(this.f3173X);
                }
            }
        }
        this.f3184i0 = true;
        if (this.f3180e0 < 0) {
            C0930a c0930a = new C0930a(m2494l());
            c0930a.m2446i(this);
            if (z3) {
                c0930a.m2441d(true);
                return;
            } else {
                c0930a.m2441d(false);
                return;
            }
        }
        C0918D c0918dM2494l = m2494l();
        int i3 = this.f3180e0;
        if (i3 >= 0) {
            c0918dM2494l.m2402r(new C0917C(c0918dM2494l, i3), false);
            this.f3180e0 = -1;
        } else {
            throw new IllegalArgumentException("Bad id: " + i3);
        }
    }

    /* JADX INFO: renamed from: Q */
    public Dialog mo492Q() {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new Dialog(m2481I(), this.f3177b0);
    }

    /* JADX INFO: renamed from: R */
    public final void m2470R(C0918D c0918d, String str) {
        this.f3185j0 = false;
        this.f3186k0 = true;
        c0918d.getClass();
        C0930a c0930a = new C0930a(c0918d);
        c0930a.m2442e(0, this, str, 1);
        c0930a.m2441d(false);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: e */
    public final AbstractC1794d mo2471e() {
        return new C0940k(this, new C0942m(this));
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f3184i0) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        m2469P(true, true);
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: p */
    public final void mo2472p(Context context) {
        super.mo2472p(context);
        this.f3219S.m2529d(this.f3182g0);
        if (this.f3186k0) {
            return;
        }
        this.f3185j0 = false;
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: q */
    public void mo518q(Bundle bundle) {
        super.mo518q(bundle);
        this.f3172W = new Handler();
        this.f3179d0 = this.f3201A == 0;
        if (bundle != null) {
            this.f3176a0 = bundle.getInt("android:style", 0);
            this.f3177b0 = bundle.getInt("android:theme", 0);
            this.f3178c0 = bundle.getBoolean("android:cancelable", true);
            this.f3179d0 = bundle.getBoolean("android:showsDialog", this.f3179d0);
            this.f3180e0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: t */
    public void mo501t() {
        this.f3208H = true;
        Dialog dialog = this.f3183h0;
        if (dialog != null) {
            this.f3184i0 = true;
            dialog.setOnDismissListener(null);
            this.f3183h0.dismiss();
            if (!this.f3185j0) {
                onDismiss(this.f3183h0);
            }
            this.f3183h0 = null;
            this.f3187l0 = false;
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: u */
    public final void mo2473u() {
        this.f3208H = true;
        if (!this.f3186k0 && !this.f3185j0) {
            this.f3185j0 = true;
        }
        C0444d c0444d = this.f3182g0;
        C0990w c0990w = this.f3219S;
        c0990w.getClass();
        C0990w.m2526a("removeObserver");
        AbstractC0989v abstractC0989v = (AbstractC0989v) c0990w.f3343b.mo3784b(c0444d);
        if (abstractC0989v == null) {
            return;
        }
        abstractC0989v.mo2506d();
        abstractC0989v.m2525c(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046 A[Catch: all -> 0x004e, TryCatch #0 {all -> 0x004e, blocks: (B:12:0x001a, B:14:0x0026, B:24:0x003e, B:26:0x0046, B:29:0x0050, B:20:0x0030, B:22:0x0036, B:23:0x003b, B:30:0x0068), top: B:48:0x001a }] */
    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.LayoutInflater mo2474v(android.os.Bundle r8) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l.mo2474v(android.os.Bundle):android.view.LayoutInflater");
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: y */
    public void mo502y(Bundle bundle) {
        Dialog dialog = this.f3183h0;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i3 = this.f3176a0;
        if (i3 != 0) {
            bundle.putInt("android:style", i3);
        }
        int i4 = this.f3177b0;
        if (i4 != 0) {
            bundle.putInt("android:theme", i4);
        }
        boolean z3 = this.f3178c0;
        if (!z3) {
            bundle.putBoolean("android:cancelable", z3);
        }
        boolean z4 = this.f3179d0;
        if (!z4) {
            bundle.putBoolean("android:showsDialog", z4);
        }
        int i5 = this.f3180e0;
        if (i5 != -1) {
            bundle.putInt("android:backStackId", i5);
        }
    }

    @Override // androidx.fragment.app.AbstractComponentCallbacksC0944o
    /* JADX INFO: renamed from: z */
    public void mo2475z() {
        this.f3208H = true;
        Dialog dialog = this.f3183h0;
        if (dialog != null) {
            this.f3184i0 = false;
            dialog.show();
            View decorView = this.f3183h0.getWindow().getDecorView();
            decorView.setTag(R.id.view_tree_lifecycle_owner, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        }
    }
}

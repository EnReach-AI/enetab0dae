package p166z0;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.autofill.AutofillManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0938i;
import com.facebook.AbstractC1117n;
import com.facebook.C1111h;
import com.facebook.C1113j;
import io.getgrass.www.R;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import p005B.AbstractC0032g;
import p024H0.ViewOnClickListenerC0250d;
import p031J1.ViewOnTouchListenerC0378b;

/* JADX INFO: renamed from: z0.K */
/* JADX INFO: loaded from: classes.dex */
public class DialogC2062K extends Dialog {

    /* JADX INFO: renamed from: q */
    public static volatile int f7281q;

    /* JADX INFO: renamed from: e */
    public String f7282e;

    /* JADX INFO: renamed from: f */
    public String f7283f;

    /* JADX INFO: renamed from: g */
    public InterfaceC2059H f7284g;

    /* JADX INFO: renamed from: h */
    public C2057F f7285h;

    /* JADX INFO: renamed from: i */
    public ProgressDialog f7286i;

    /* JADX INFO: renamed from: j */
    public ImageView f7287j;

    /* JADX INFO: renamed from: k */
    public FrameLayout f7288k;

    /* JADX INFO: renamed from: l */
    public AsyncTaskC2061J f7289l;

    /* JADX INFO: renamed from: m */
    public boolean f7290m;

    /* JADX INFO: renamed from: n */
    public boolean f7291n;

    /* JADX INFO: renamed from: o */
    public boolean f7292o;

    /* JADX INFO: renamed from: p */
    public WindowManager.LayoutParams f7293p;

    /* JADX INFO: renamed from: a */
    public static int m4560a(int i3, float f3, int i4, int i5) {
        int i6 = (int) (i3 / f3);
        return (int) (((double) i3) * (i6 <= i4 ? 1.0d : i6 >= i5 ? 0.5d : ((((double) (i5 - i6)) / ((double) (i5 - i4))) * 0.5d) + 0.5d));
    }

    /* JADX INFO: renamed from: b */
    public static void m4561b(AbstractActivityC0947r abstractActivityC0947r) {
        try {
            ApplicationInfo applicationInfo = abstractActivityC0947r.getPackageManager().getApplicationInfo(abstractActivityC0947r.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || f7281q != 0) {
                return;
            }
            int i3 = applicationInfo.metaData.getInt("com.facebook.sdk.WebDialogTheme");
            if (i3 == 0) {
                i3 = R.style.com_facebook_activity_theme;
            }
            f7281q = i3;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    public static DialogC2062K m4562c(AbstractActivityC0947r abstractActivityC0947r, String str, Bundle bundle, InterfaceC2059H interfaceC2059H) {
        m4561b(abstractActivityC0947r);
        AbstractC2069g.m4584h();
        DialogC2062K dialogC2062K = new DialogC2062K(abstractActivityC0947r, f7281q);
        dialogC2062K.f7283f = "fbconnect://success";
        dialogC2062K.f7290m = false;
        dialogC2062K.f7291n = false;
        dialogC2062K.f7292o = false;
        if (bundle == null) {
            bundle = new Bundle();
        }
        String str2 = abstractActivityC0947r.getPackageManager().hasSystemFeature("android.hardware.type.pc") ? "fbconnect://chrome_os_success" : "fbconnect://success";
        dialogC2062K.f7283f = str2;
        bundle.putString("redirect_uri", str2);
        bundle.putString("display", "touch");
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        bundle.putString("client_id", AbstractC1117n.f3877c);
        Locale locale = Locale.ROOT;
        bundle.putString("sdk", "android-8.2.0");
        dialogC2062K.f7284g = interfaceC2059H;
        if (str.equals("share") && bundle.containsKey("media")) {
            dialogC2062K.f7289l = new AsyncTaskC2061J(dialogC2062K, str, bundle);
        } else {
            Collection collection = AbstractC2052A.f7256a;
            dialogC2062K.f7282e = AbstractC2056E.m4533b(AbstractC0032g.m152j("m.", AbstractC1117n.f3881g), AbstractC1117n.m2892b() + "/dialog/" + str, bundle).toString();
        }
        return dialogC2062K;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        if (this.f7284g == null || this.f7290m) {
            return;
        }
        m4565f(new C1113j());
    }

    /* JADX INFO: renamed from: d */
    public Bundle mo4563d(String str) {
        Uri uri = Uri.parse(str);
        Bundle bundleM4554w = AbstractC2056E.m4554w(uri.getQuery());
        bundleM4554w.putAll(AbstractC2056E.m4554w(uri.getFragment()));
        return bundleM4554w;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ProgressDialog progressDialog;
        C2057F c2057f = this.f7285h;
        if (c2057f != null) {
            c2057f.stopLoading();
        }
        if (!this.f7291n && (progressDialog = this.f7286i) != null && progressDialog.isShowing()) {
            this.f7286i.dismiss();
        }
        super.dismiss();
    }

    /* JADX INFO: renamed from: e */
    public final void m4564e() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int i5 = i3 < i4 ? i3 : i4;
        if (i3 < i4) {
            i3 = i4;
        }
        getWindow().setLayout(Math.min(m4560a(i5, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(m4560a(i3, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    /* JADX INFO: renamed from: f */
    public final void m4565f(Exception exc) {
        if (this.f7284g == null || this.f7290m) {
            return;
        }
        this.f7290m = true;
        this.f7284g.mo59s(null, exc instanceof C1111h ? (C1111h) exc : new C1111h(exc));
        dismiss();
    }

    /* JADX INFO: renamed from: g */
    public final void m4566g(int i3) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        C2057F c2057f = new C2057F(getContext());
        this.f7285h = c2057f;
        c2057f.setVerticalScrollBarEnabled(false);
        this.f7285h.setHorizontalScrollBarEnabled(false);
        this.f7285h.setWebViewClient(new C2058G(this));
        this.f7285h.getSettings().setJavaScriptEnabled(true);
        this.f7285h.loadUrl(this.f7282e);
        this.f7285h.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f7285h.setVisibility(4);
        this.f7285h.getSettings().setSavePassword(false);
        this.f7285h.getSettings().setSaveFormData(false);
        this.f7285h.setFocusable(true);
        this.f7285h.setFocusableInTouchMode(true);
        this.f7285h.setOnTouchListener(new ViewOnTouchListenerC0378b(1));
        linearLayout.setPadding(i3, i3, i3, i3);
        linearLayout.addView(this.f7285h);
        linearLayout.setBackgroundColor(-872415232);
        this.f7288k.addView(linearLayout);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onAttachedToWindow() {
        WindowManager.LayoutParams layoutParams;
        this.f7291n = false;
        AutofillManager autofillManager = (AutofillManager) getContext().getSystemService(AutofillManager.class);
        if (autofillManager != null && autofillManager.isAutofillSupported() && autofillManager.isEnabled() && (layoutParams = this.f7293p) != null && layoutParams.token == null) {
            layoutParams.token = getOwnerActivity().getWindow().getAttributes().token;
            Objects.toString(this.f7293p.token);
            HashSet hashSet = AbstractC1117n.f3875a;
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        this.f7286i = progressDialog;
        progressDialog.requestWindowFeature(1);
        this.f7286i.setMessage(getContext().getString(R.string.com_facebook_loading));
        this.f7286i.setCanceledOnTouchOutside(false);
        this.f7286i.setOnCancelListener(new DialogInterfaceOnCancelListenerC0938i(this, 1));
        requestWindowFeature(1);
        this.f7288k = new FrameLayout(getContext());
        m4564e();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        ImageView imageView = new ImageView(getContext());
        this.f7287j = imageView;
        imageView.setOnClickListener(new ViewOnClickListenerC0250d(7, this));
        this.f7287j.setImageDrawable(getContext().getResources().getDrawable(R.drawable.com_facebook_close));
        this.f7287j.setVisibility(4);
        if (this.f7282e != null) {
            m4566g((this.f7287j.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.f7288k.addView(this.f7287j, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.f7288k);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f7291n = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            C2057F c2057f = this.f7285h;
            if (c2057f != null && c2057f.canGoBack()) {
                this.f7285h.goBack();
                return true;
            }
            cancel();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        AsyncTaskC2061J asyncTaskC2061J = this.f7289l;
        if (asyncTaskC2061J == null || asyncTaskC2061J.getStatus() != AsyncTask.Status.PENDING) {
            m4564e();
        } else {
            asyncTaskC2061J.execute(new Void[0]);
            this.f7286i.show();
        }
    }

    @Override // android.app.Dialog
    public final void onStop() {
        AsyncTaskC2061J asyncTaskC2061J = this.f7289l;
        if (asyncTaskC2061J != null) {
            asyncTaskC2061J.cancel(true);
            this.f7286i.dismiss();
        }
        super.onStop();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (layoutParams.token == null) {
            this.f7293p = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }
}

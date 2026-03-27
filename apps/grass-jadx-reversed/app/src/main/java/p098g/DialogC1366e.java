package p098g;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.C0878m;
import androidx.activity.InterfaceC0879n;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.InterfaceC0984q;
import io.getgrass.www.R;
import java.util.WeakHashMap;
import p024H0.ViewOnClickListenerC0250d;
import p028I1.RunnableC0304d;
import p029J.AbstractC0314I;
import p029J.AbstractC0323S;
import p105i.C1444l;
import p119m2.AbstractC1766e;

/* JADX INFO: renamed from: g.e */
/* JADX INFO: loaded from: classes.dex */
public final class DialogC1366e extends Dialog implements DialogInterface, InterfaceC1368g, InterfaceC0984q, InterfaceC0879n {

    /* JADX INFO: renamed from: e */
    public C0986s f4902e;

    /* JADX INFO: renamed from: f */
    public final C0878m f4903f;

    /* JADX INFO: renamed from: g */
    public LayoutInflaterFactory2C1382u f4904g;

    /* JADX INFO: renamed from: h */
    public final C1383v f4905h;

    /* JADX INFO: renamed from: i */
    public final C1365d f4906i;

    public DialogC1366e(ContextThemeWrapper contextThemeWrapper, int i3) {
        int i4;
        int iM3334i = m3334i(contextThemeWrapper, i3);
        if (iM3334i == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i4 = typedValue.resourceId;
        } else {
            i4 = iM3334i;
        }
        super(contextThemeWrapper, i4);
        this.f4903f = new C0878m(new RunnableC0304d(4, this));
        this.f4905h = new C1383v(this);
        AbstractC1371j abstractC1371jM3335c = m3335c();
        if (iM3334i == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            iM3334i = typedValue2.resourceId;
        }
        ((LayoutInflaterFactory2C1382u) abstractC1371jM3335c).f4975X = iM3334i;
        abstractC1371jM3335c.mo3351f();
        this.f4906i = new C1365d(getContext(), this, getWindow());
    }

    /* JADX INFO: renamed from: a */
    public static void m3333a(DialogC1366e dialogC1366e) {
        AbstractC1766e.m3920e("this$0", dialogC1366e);
        super.onBackPressed();
    }

    /* JADX INFO: renamed from: i */
    public static int m3334i(Context context, int i3) {
        if (((i3 >>> 24) & 255) >= 1) {
            return i3;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3335c();
        layoutInflaterFactory2C1382u.m3387w();
        ((ViewGroup) layoutInflaterFactory2C1382u.f4956E.findViewById(android.R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C1382u.f4992q.m3365a(layoutInflaterFactory2C1382u.f4991p.getCallback());
    }

    /* JADX INFO: renamed from: c */
    public final AbstractC1371j m3335c() {
        if (this.f4904g == null) {
            ExecutorC1355A executorC1355A = AbstractC1371j.f4908e;
            this.f4904g = new LayoutInflaterFactory2C1382u(getContext(), getWindow(), this, this);
        }
        return this.f4904g;
    }

    @Override // androidx.lifecycle.InterfaceC0984q
    /* JADX INFO: renamed from: d */
    public final C0986s mo2199d() {
        return m3336e();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        m3335c().mo3352g();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        C1383v c1383v = this.f4905h;
        if (c1383v == null) {
            return false;
        }
        return c1383v.f5002e.m3341k(keyEvent);
    }

    /* JADX INFO: renamed from: e */
    public final C0986s m3336e() {
        C0986s c0986s = this.f4902e;
        if (c0986s != null) {
            return c0986s;
        }
        C0986s c0986s2 = new C0986s(this);
        this.f4902e = c0986s2;
        return c0986s2;
    }

    /* JADX INFO: renamed from: f */
    public final void m3337f(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            C0878m c0878m = this.f4903f;
            c0878m.f2620e = onBackInvokedDispatcher;
            c0878m.m2212c();
        }
        m3336e().m2518d(EnumC0978k.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final View findViewById(int i3) {
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3335c();
        layoutInflaterFactory2C1382u.m3387w();
        return layoutInflaterFactory2C1382u.f4991p.findViewById(i3);
    }

    /* JADX INFO: renamed from: g */
    public final void m3338g(Bundle bundle) {
        m3335c().mo3349a();
        m3337f(bundle);
        m3335c().mo3351f();
    }

    /* JADX INFO: renamed from: h */
    public final void m3339h() {
        m3336e().m2518d(EnumC0978k.ON_DESTROY);
        this.f4902e = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        m3335c().mo3350b();
    }

    /* JADX INFO: renamed from: j */
    public final void m3340j(CharSequence charSequence) {
        super.setTitle(charSequence);
        m3335c().mo3357m(charSequence);
    }

    /* JADX INFO: renamed from: k */
    public final boolean m3341k(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f4903f.m2211b();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i3;
        ListAdapter listAdapter;
        View viewFindViewById;
        m3338g(bundle);
        C1365d c1365d = this.f4906i;
        c1365d.f4879b.setContentView(c1365d.f4895r);
        Window window = c1365d.f4880c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        window.setFlags(131072, 131072);
        viewGroup.setVisibility(8);
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupM3332a = C1365d.m3332a(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupM3332a2 = C1365d.m3332a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM3332a3 = C1365d.m3332a(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c1365d.f4886i = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c1365d.f4886i.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupM3332a2.findViewById(android.R.id.message);
        c1365d.f4891n = textView;
        if (textView != null) {
            textView.setVisibility(8);
            c1365d.f4886i.removeView(c1365d.f4891n);
            if (c1365d.f4882e != null) {
                ViewGroup viewGroup2 = (ViewGroup) c1365d.f4886i.getParent();
                int iIndexOfChild = viewGroup2.indexOfChild(c1365d.f4886i);
                viewGroup2.removeViewAt(iIndexOfChild);
                viewGroup2.addView(c1365d.f4882e, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            } else {
                viewGroupM3332a2.setVisibility(8);
            }
        }
        Button button = (Button) viewGroupM3332a3.findViewById(android.R.id.button1);
        c1365d.f4883f = button;
        ViewOnClickListenerC0250d viewOnClickListenerC0250d = c1365d.f4901x;
        button.setOnClickListener(viewOnClickListenerC0250d);
        if (TextUtils.isEmpty(null)) {
            c1365d.f4883f.setVisibility(8);
            i3 = 0;
        } else {
            c1365d.f4883f.setText((CharSequence) null);
            c1365d.f4883f.setVisibility(0);
            i3 = 1;
        }
        Button button2 = (Button) viewGroupM3332a3.findViewById(android.R.id.button2);
        c1365d.f4884g = button2;
        button2.setOnClickListener(viewOnClickListenerC0250d);
        if (TextUtils.isEmpty(null)) {
            c1365d.f4884g.setVisibility(8);
        } else {
            c1365d.f4884g.setText((CharSequence) null);
            c1365d.f4884g.setVisibility(0);
            i3 |= 2;
        }
        Button button3 = (Button) viewGroupM3332a3.findViewById(android.R.id.button3);
        c1365d.f4885h = button3;
        button3.setOnClickListener(viewOnClickListenerC0250d);
        if (TextUtils.isEmpty(null)) {
            c1365d.f4885h.setVisibility(8);
        } else {
            c1365d.f4885h.setText((CharSequence) null);
            c1365d.f4885h.setVisibility(0);
            i3 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        c1365d.f4878a.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i3 == 1) {
                Button button4 = c1365d.f4883f;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i3 == 2) {
                Button button5 = c1365d.f4884g;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i3 == 4) {
                Button button6 = c1365d.f4885h;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i3 == 0) {
            viewGroupM3332a3.setVisibility(8);
        }
        if (c1365d.f4892o != null) {
            viewGroupM3332a.addView(c1365d.f4892o, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            c1365d.f4889l = (ImageView) window.findViewById(android.R.id.icon);
            if ((!TextUtils.isEmpty(c1365d.f4881d)) && c1365d.f4899v) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c1365d.f4890m = textView2;
                textView2.setText(c1365d.f4881d);
                int i4 = c1365d.f4887j;
                if (i4 != 0) {
                    c1365d.f4889l.setImageResource(i4);
                } else {
                    Drawable drawable = c1365d.f4888k;
                    if (drawable != null) {
                        c1365d.f4889l.setImageDrawable(drawable);
                    } else {
                        c1365d.f4890m.setPadding(c1365d.f4889l.getPaddingLeft(), c1365d.f4889l.getPaddingTop(), c1365d.f4889l.getPaddingRight(), c1365d.f4889l.getPaddingBottom());
                        c1365d.f4889l.setVisibility(8);
                    }
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                c1365d.f4889l.setVisibility(8);
                viewGroupM3332a.setVisibility(8);
            }
        }
        boolean z3 = viewGroup.getVisibility() != 8;
        int i5 = (viewGroupM3332a == null || viewGroupM3332a.getVisibility() == 8) ? 0 : 1;
        boolean z4 = viewGroupM3332a3.getVisibility() != 8;
        if (!z4 && (viewFindViewById = viewGroupM3332a2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i5 != 0) {
            NestedScrollView nestedScrollView2 = c1365d.f4886i;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = c1365d.f4882e != null ? viewGroupM3332a.findViewById(R.id.titleDividerNoCustom) : null;
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupM3332a2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c1365d.f4882e;
        if (alertController$RecycleListView instanceof AlertController$RecycleListView) {
            alertController$RecycleListView.getClass();
            if (!z4 || i5 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i5 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f2649e, alertController$RecycleListView.getPaddingRight(), z4 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f2650f);
            }
        }
        if (!z3) {
            View view = c1365d.f4882e;
            if (view == null) {
                view = c1365d.f4886i;
            }
            if (view != null) {
                int i6 = (z4 ? 2 : 0) | i5;
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = AbstractC0323S.f816a;
                AbstractC0314I.m657d(view, i6, 3);
                if (viewFindViewById11 != null) {
                    viewGroupM3332a2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupM3332a2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = c1365d.f4882e;
        if (alertController$RecycleListView2 == null || (listAdapter = c1365d.f4893p) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i7 = c1365d.f4894q;
        if (i7 > -1) {
            alertController$RecycleListView2.setItemChecked(i7, true);
            alertController$RecycleListView2.setSelection(i7);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4906i.f4886i;
        if (nestedScrollView == null || !nestedScrollView.m2323j(keyEvent)) {
            return super.onKeyDown(i3, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i3, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4906i.f4886i;
        if (nestedScrollView == null || !nestedScrollView.m2323j(keyEvent)) {
            return super.onKeyUp(i3, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        m3336e().m2518d(EnumC0978k.ON_RESUME);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        m3339h();
        LayoutInflaterFactory2C1382u layoutInflaterFactory2C1382u = (LayoutInflaterFactory2C1382u) m3335c();
        layoutInflaterFactory2C1382u.m3371A();
        C1361G c1361g = layoutInflaterFactory2C1382u.f4994s;
        if (c1361g != null) {
            c1361g.f4861t = false;
            C1444l c1444l = c1361g.f4860s;
            if (c1444l != null) {
                c1444l.m3450a();
            }
        }
    }

    @Override // android.app.Dialog
    public final void setContentView(int i3) {
        m3335c().mo3354j(i3);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i3) {
        super.setTitle(i3);
        m3335c().mo3357m(getContext().getString(i3));
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        m3335c().mo3355k(view);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m3335c().mo3356l(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        m3340j(charSequence);
        C1365d c1365d = this.f4906i;
        c1365d.f4881d = charSequence;
        TextView textView = c1365d.f4890m;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}

package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.AbstractActivityC0873h;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.EnumC0979l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p001A.C0009j;
import p019F0.C0221e;
import p077a0.C0842a;
import p162y.InterfaceC2024c;

/* JADX INFO: renamed from: androidx.fragment.app.r */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0947r extends AbstractActivityC0873h implements InterfaceC2024c {

    /* JADX INFO: renamed from: u */
    public boolean f3253u;

    /* JADX INFO: renamed from: v */
    public boolean f3254v;

    /* JADX INFO: renamed from: s */
    public final C0221e f3251s = new C0221e(11, new C0946q(this));

    /* JADX INFO: renamed from: t */
    public final C0986s f3252t = new C0986s(this);

    /* JADX INFO: renamed from: w */
    public boolean f3255w = true;

    public AbstractActivityC0947r() {
        this.f2601i.f2519b.m2176f("android:support:fragments", new C0842a(this, 1));
        m2200f(new C0945p(this, 0));
    }

    /* JADX INFO: renamed from: m */
    public static boolean m2497m(C0918D c0918d) {
        boolean zM2497m = false;
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : c0918d.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                C0946q c0946q = abstractComponentCallbacksC0944o.f3240w;
                if ((c0946q == null ? null : c0946q.f3250i) != null) {
                    zM2497m |= m2497m(abstractComponentCallbacksC0944o.m2491i());
                }
                C0925K c0925k = abstractComponentCallbacksC0944o.f3218R;
                EnumC0979l enumC0979l = EnumC0979l.f3321h;
                EnumC0979l enumC0979l2 = EnumC0979l.f3320g;
                if (c0925k != null) {
                    c0925k.m2433f();
                    if (c0925k.f3102f.f3328b.m2513a(enumC0979l)) {
                        C0986s c0986s = abstractComponentCallbacksC0944o.f3218R.f3102f;
                        c0986s.m2517c("setCurrentState");
                        c0986s.m2519e(enumC0979l2);
                        zM2497m = true;
                    }
                }
                if (abstractComponentCallbacksC0944o.f3217Q.f3328b.m2513a(enumC0979l)) {
                    C0986s c0986s2 = abstractComponentCallbacksC0944o.f3217Q;
                    c0986s2.m2517c("setCurrentState");
                    c0986s2.m2519e(enumC0979l2);
                    zM2497m = true;
                }
            }
        }
        return zM2497m;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f3253u);
        printWriter.print(" mResumed=");
        printWriter.print(this.f3254v);
        printWriter.print(" mStopped=");
        printWriter.print(this.f3255w);
        if (getApplication() != null) {
            new C0009j(this, mo2198c()).m64x(str2, printWriter);
        }
        ((C0946q) this.f3251s.f534f).f3249h.m2401q(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void onActivityResult(int i3, int i4, Intent intent) {
        this.f3251s.m460z();
        super.onActivityResult(i3, i4, intent);
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C0221e c0221e = this.f3251s;
        c0221e.m460z();
        super.onConfigurationChanged(configuration);
        ((C0946q) c0221e.f534f).f3249h.m2392h(configuration);
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3252t.m2518d(EnumC0978k.ON_CREATE);
        C0918D c0918d = ((C0946q) this.f3251s.f534f).f3249h;
        c0918d.f3053y = false;
        c0918d.f3054z = false;
        c0918d.f3027F.f3069h = false;
        c0918d.m2400p(1);
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            super.onCreatePanelMenu(i3, menu);
            return true;
        }
        super.onCreatePanelMenu(i3, menu);
        getMenuInflater();
        ((C0946q) this.f3251s.f534f).f3249h.m2394j();
        return true;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((C0946q) this.f3251s.f534f).f3249h.f3034f.onCreateView(view, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ((C0946q) this.f3251s.f534f).f3249h.m2395k();
        this.f3252t.m2518d(EnumC0978k.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : ((C0946q) this.f3251s.f534f).f3249h.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.m2477E();
            }
        }
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        C0221e c0221e = this.f3251s;
        if (i3 == 0) {
            return ((C0946q) c0221e.f534f).f3249h.m2396l();
        }
        if (i3 != 6) {
            return false;
        }
        return ((C0946q) c0221e.f534f).f3249h.m2393i();
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z3) {
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : ((C0946q) this.f3251s.f534f).f3249h.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.m2478F(z3);
            }
        }
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public void onNewIntent(Intent intent) {
        this.f3251s.m460z();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        if (i3 == 0) {
            ((C0946q) this.f3251s.f534f).f3249h.m2397m();
        }
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.f3254v = false;
        ((C0946q) this.f3251s.f534f).f3249h.m2400p(5);
        this.f3252t.m2518d(EnumC0978k.ON_PAUSE);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z3) {
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : ((C0946q) this.f3251s.f534f).f3249h.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.m2479G(z3);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        this.f3252t.m2518d(EnumC0978k.ON_RESUME);
        C0918D c0918d = ((C0946q) this.f3251s.f534f).f3249h;
        c0918d.f3053y = false;
        c0918d.f3054z = false;
        c0918d.f3027F.f3069h = false;
        c0918d.m2400p(7);
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            super.onPreparePanel(i3, view, menu);
            return true;
        }
        super.onPreparePanel(0, view, menu);
        ((C0946q) this.f3251s.f534f).f3249h.m2399o();
        return true;
    }

    @Override // androidx.activity.AbstractActivityC0873h, android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        this.f3251s.m460z();
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        C0221e c0221e = this.f3251s;
        c0221e.m460z();
        super.onResume();
        this.f3254v = true;
        ((C0946q) c0221e.f534f).f3249h.m2404t(true);
    }

    @Override // android.app.Activity
    public void onStart() {
        C0221e c0221e = this.f3251s;
        c0221e.m460z();
        super.onStart();
        this.f3255w = false;
        boolean z3 = this.f3253u;
        C0946q c0946q = (C0946q) c0221e.f534f;
        if (!z3) {
            this.f3253u = true;
            C0918D c0918d = c0946q.f3249h;
            c0918d.f3053y = false;
            c0918d.f3054z = false;
            c0918d.f3027F.f3069h = false;
            c0918d.m2400p(4);
        }
        c0946q.f3249h.m2404t(true);
        this.f3252t.m2518d(EnumC0978k.ON_START);
        C0918D c0918d2 = c0946q.f3249h;
        c0918d2.f3053y = false;
        c0918d2.f3054z = false;
        c0918d2.f3027F.f3069h = false;
        c0918d2.m2400p(5);
    }

    @Override // android.app.Activity
    public final void onStateNotSaved() {
        this.f3251s.m460z();
    }

    @Override // android.app.Activity
    public void onStop() {
        C0221e c0221e;
        super.onStop();
        this.f3255w = true;
        do {
            c0221e = this.f3251s;
        } while (m2497m(((C0946q) c0221e.f534f).f3249h));
        C0918D c0918d = ((C0946q) c0221e.f534f).f3249h;
        c0918d.f3054z = true;
        c0918d.f3027F.f3069h = true;
        c0918d.m2400p(4);
        this.f3252t.m2518d(EnumC0978k.ON_STOP);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView = ((C0946q) this.f3251s.f534f).f3249h.f3034f.onCreateView(null, str, context, attributeSet);
        return viewOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewOnCreateView;
    }
}

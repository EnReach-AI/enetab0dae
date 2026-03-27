package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.C0883d;
import androidx.activity.result.InterfaceC0882c;
import androidx.activity.result.InterfaceC0887h;
import androidx.fragment.app.AbstractActivityC0947r;
import androidx.lifecycle.AbstractC0960E;
import androidx.lifecycle.C0962G;
import androidx.lifecycle.C0965J;
import androidx.lifecycle.C0966K;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.EnumC0979l;
import androidx.lifecycle.FragmentC0958C;
import androidx.lifecycle.InterfaceC0967L;
import androidx.lifecycle.InterfaceC0975h;
import androidx.lifecycle.InterfaceC0982o;
import androidx.lifecycle.InterfaceC0984q;
import androidx.lifecycle.SavedStateHandleAttacher;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p005B.AbstractC0032g;
import p007B1.RunnableC0055o;
import p019F0.C0217a;
import p026I.InterfaceC0293a;
import p029J.AbstractC0323S;
import p029J.InterfaceC0351k;
import p033K0.AbstractC0406d;
import p036L0.C0444d;
import p063V.AbstractC0668b;
import p063V.C0667a;
import p063V.C0669c;
import p077a0.C0846e;
import p077a0.C0847f;
import p077a0.InterfaceC0845d;
import p077a0.InterfaceC0848g;
import p084c.C1078a;
import p084c.InterfaceC1079b;
import p116m.C1701b;
import p116m.C1705f;
import p119m2.AbstractC1766e;
import p137r0.AbstractC1852a;
import p156w0.AbstractC1986a;
import p166z0.C2068f;

/* JADX INFO: renamed from: androidx.activity.h */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0873h extends Activity implements InterfaceC0967L, InterfaceC0975h, InterfaceC0848g, InterfaceC0879n, InterfaceC0887h, InterfaceC0984q, InterfaceC0351k {

    /* JADX INFO: renamed from: e */
    public C0986s f2597e = new C0986s(this);

    /* JADX INFO: renamed from: f */
    public final C1078a f2598f = new C1078a();

    /* JADX INFO: renamed from: g */
    public final C0444d f2599g = new C0444d(5);

    /* JADX INFO: renamed from: h */
    public final C0986s f2600h;

    /* JADX INFO: renamed from: i */
    public final C0847f f2601i;

    /* JADX INFO: renamed from: j */
    public C0966K f2602j;

    /* JADX INFO: renamed from: k */
    public final C0878m f2603k;

    /* JADX INFO: renamed from: l */
    public final AtomicInteger f2604l;

    /* JADX INFO: renamed from: m */
    public final C0870e f2605m;

    /* JADX INFO: renamed from: n */
    public final CopyOnWriteArrayList f2606n;

    /* JADX INFO: renamed from: o */
    public final CopyOnWriteArrayList f2607o;

    /* JADX INFO: renamed from: p */
    public final CopyOnWriteArrayList f2608p;

    /* JADX INFO: renamed from: q */
    public final CopyOnWriteArrayList f2609q;

    /* JADX INFO: renamed from: r */
    public final CopyOnWriteArrayList f2610r;

    public AbstractActivityC0873h() {
        InterfaceC0845d interfaceC0845d;
        final AbstractActivityC0947r abstractActivityC0947r = (AbstractActivityC0947r) this;
        C0986s c0986s = new C0986s(this);
        this.f2600h = c0986s;
        C0847f c0847f = new C0847f(this);
        this.f2601i = c0847f;
        this.f2603k = new C0878m(new RunnableC0055o(9, abstractActivityC0947r));
        this.f2604l = new AtomicInteger();
        this.f2605m = new C0870e(abstractActivityC0947r);
        this.f2606n = new CopyOnWriteArrayList();
        this.f2607o = new CopyOnWriteArrayList();
        this.f2608p = new CopyOnWriteArrayList();
        this.f2609q = new CopyOnWriteArrayList();
        this.f2610r = new CopyOnWriteArrayList();
        c0986s.m2515a(new InterfaceC0982o() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.InterfaceC0982o
            /* JADX INFO: renamed from: b */
            public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
                if (enumC0978k == EnumC0978k.ON_STOP) {
                    Window window = abstractActivityC0947r.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        c0986s.m2515a(new InterfaceC0982o() { // from class: androidx.activity.ComponentActivity$4
            @Override // androidx.lifecycle.InterfaceC0982o
            /* JADX INFO: renamed from: b */
            public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
                if (enumC0978k == EnumC0978k.ON_DESTROY) {
                    abstractActivityC0947r.f2598f.f3763b = null;
                    if (abstractActivityC0947r.isChangingConfigurations()) {
                        return;
                    }
                    abstractActivityC0947r.mo2198c().m2505a();
                }
            }
        });
        c0986s.m2515a(new InterfaceC0982o() { // from class: androidx.activity.ComponentActivity$5
            @Override // androidx.lifecycle.InterfaceC0982o
            /* JADX INFO: renamed from: b */
            public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
                AbstractActivityC0873h abstractActivityC0873h = abstractActivityC0947r;
                if (abstractActivityC0873h.f2602j == null) {
                    C0872g c0872g = (C0872g) abstractActivityC0873h.getLastNonConfigurationInstance();
                    if (c0872g != null) {
                        abstractActivityC0873h.f2602j = c0872g.f2596a;
                    }
                    if (abstractActivityC0873h.f2602j == null) {
                        abstractActivityC0873h.f2602j = new C0966K();
                    }
                }
                abstractActivityC0873h.f2600h.m2520f(this);
            }
        });
        c0847f.m2183a();
        EnumC0979l enumC0979l = c0986s.f3328b;
        AbstractC1766e.m3919d("lifecycle.currentState", enumC0979l);
        if (enumC0979l != EnumC0979l.f3319f && enumC0979l != EnumC0979l.f3320g) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        C0846e c0846e = c0847f.f2519b;
        c0846e.getClass();
        Iterator it = ((C1705f) c0846e.f2515e).iterator();
        while (true) {
            C1701b c1701b = (C1701b) it;
            if (!c1701b.hasNext()) {
                interfaceC0845d = null;
                break;
            }
            Map.Entry entry = (Map.Entry) c1701b.next();
            AbstractC1766e.m3919d("components", entry);
            String str = (String) entry.getKey();
            interfaceC0845d = (InterfaceC0845d) entry.getValue();
            if (AbstractC1766e.m3916a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                break;
            }
        }
        if (interfaceC0845d == null) {
            C0962G c0962g = new C0962G(this.f2601i.f2519b, abstractActivityC0947r);
            this.f2601i.f2519b.m2176f("androidx.lifecycle.internal.SavedStateHandlesProvider", c0962g);
            this.f2600h.m2515a(new SavedStateHandleAttacher(c0962g));
        }
        this.f2601i.f2519b.m2176f("android:support:activity-result", new InterfaceC0845d() { // from class: androidx.activity.b
            @Override // p077a0.InterfaceC0845d
            /* JADX INFO: renamed from: a */
            public final Bundle mo2169a() {
                AbstractActivityC0873h abstractActivityC0873h = abstractActivityC0947r;
                abstractActivityC0873h.getClass();
                Bundle bundle = new Bundle();
                C0870e c0870e = abstractActivityC0873h.f2605m;
                c0870e.getClass();
                HashMap map = c0870e.f2639c;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(c0870e.f2641e));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) c0870e.f2644h.clone());
                bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", c0870e.f2637a);
                return bundle;
            }
        });
        m2200f(new InterfaceC1079b() { // from class: androidx.activity.c
            @Override // p084c.InterfaceC1079b
            /* JADX INFO: renamed from: a */
            public final void mo2193a() {
                AbstractActivityC0873h abstractActivityC0873h = abstractActivityC0947r;
                Bundle bundleM2174d = abstractActivityC0873h.f2601i.f2519b.m2174d("android:support:activity-result");
                if (bundleM2174d != null) {
                    C0870e c0870e = abstractActivityC0873h.f2605m;
                    c0870e.getClass();
                    ArrayList<Integer> integerArrayList = bundleM2174d.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleM2174d.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    c0870e.f2641e = bundleM2174d.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    c0870e.f2637a = (Random) bundleM2174d.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                    Bundle bundle = bundleM2174d.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    Bundle bundle2 = c0870e.f2644h;
                    bundle2.putAll(bundle);
                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                        String str2 = stringArrayList.get(i3);
                        HashMap map = c0870e.f2639c;
                        boolean zContainsKey = map.containsKey(str2);
                        HashMap map2 = c0870e.f2638b;
                        if (zContainsKey) {
                            Integer num = (Integer) map.remove(str2);
                            if (!bundle2.containsKey(str2)) {
                                map2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i3);
                        num2.intValue();
                        String str3 = stringArrayList.get(i3);
                        map2.put(num2, str3);
                        map.put(str3, num2);
                    }
                }
            }
        });
    }

    @Override // androidx.lifecycle.InterfaceC0975h
    /* JADX INFO: renamed from: a */
    public final AbstractC0668b mo2197a() {
        C0669c c0669c = new C0669c(C0667a.f1819b);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = c0669c.f1820a;
        if (application != null) {
            linkedHashMap.put(C0965J.f3301a, getApplication());
        }
        linkedHashMap.put(AbstractC0960E.f3287a, this);
        linkedHashMap.put(AbstractC0960E.f3288b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            linkedHashMap.put(AbstractC0960E.f3289c, getIntent().getExtras());
        }
        return c0669c;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2201g();
        super.addContentView(view, layoutParams);
    }

    @Override // p077a0.InterfaceC0848g
    /* JADX INFO: renamed from: b */
    public final C0846e mo2186b() {
        return this.f2601i.f2519b;
    }

    @Override // androidx.lifecycle.InterfaceC0967L
    /* JADX INFO: renamed from: c */
    public final C0966K mo2198c() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f2602j == null) {
            C0872g c0872g = (C0872g) getLastNonConfigurationInstance();
            if (c0872g != null) {
                this.f2602j = c0872g.f2596a;
            }
            if (this.f2602j == null) {
                this.f2602j = new C0966K();
            }
        }
        return this.f2602j;
    }

    @Override // androidx.lifecycle.InterfaceC0984q
    /* JADX INFO: renamed from: d */
    public final C0986s mo2199d() {
        return this.f2600h;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
        }
        return m2205k(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    /* JADX INFO: renamed from: f */
    public final void m2200f(InterfaceC1079b interfaceC1079b) {
        C1078a c1078a = this.f2598f;
        if (c1078a.f3763b != null) {
            interfaceC1079b.mo2193a();
        }
        c1078a.f3762a.add(interfaceC1079b);
    }

    /* JADX INFO: renamed from: g */
    public final void m2201g() {
        getWindow().getDecorView().setTag(R.id.view_tree_lifecycle_owner, this);
        getWindow().getDecorView().setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView = getWindow().getDecorView();
        AbstractC1766e.m3920e("<this>", decorView);
        decorView.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView2 = getWindow().getDecorView();
        AbstractC1766e.m3920e("<this>", decorView2);
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
    }

    /* JADX INFO: renamed from: h */
    public final void m2202h(Bundle bundle) {
        super.onCreate(bundle);
        FragmentC0958C.m2503c(this);
    }

    /* JADX INFO: renamed from: i */
    public final void m2203i(Bundle bundle) {
        C0986s c0986s = this.f2597e;
        c0986s.m2517c("markState");
        EnumC0979l enumC0979l = EnumC0979l.f3320g;
        c0986s.m2517c("setCurrentState");
        c0986s.m2519e(enumC0979l);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: renamed from: j */
    public final C0883d m2204j(AbstractC0406d abstractC0406d, InterfaceC0882c interfaceC0882c) {
        return this.f2605m.m2216d("activity_rq#" + this.f2604l.getAndIncrement(), this, abstractC0406d, interfaceC0882c);
    }

    /* JADX INFO: renamed from: k */
    public final boolean m2205k(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: renamed from: l */
    public void mo2206l() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i3, int i4, Intent intent) {
        if (this.f2605m.m2214a(i3, i4, intent)) {
            return;
        }
        super.onActivityResult(i3, i4, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        this.f2603k.m2211b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator it = this.f2606n.iterator();
        while (it.hasNext()) {
            ((InterfaceC0293a) it.next()).mo474a(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f2601i.m2184b(bundle);
        C1078a c1078a = this.f2598f;
        c1078a.f3763b = this;
        Iterator it = c1078a.f3762a.iterator();
        while (it.hasNext()) {
            ((InterfaceC1079b) it.next()).mo2193a();
        }
        m2202h(bundle);
        FragmentC0958C.m2503c(this);
        if (AbstractC1986a.m4379g()) {
            C0878m c0878m = this.f2603k;
            c0878m.f2620e = AbstractC0871f.m2195a(this);
            c0878m.m2212c();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i3, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i3, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f2599g.f1085e).iterator();
        if (!it.hasNext()) {
            return true;
        }
        AbstractC0032g.m162t(it.next());
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i3, MenuItem menuItem) {
        if (super.onMenuItemSelected(i3, menuItem)) {
            return true;
        }
        if (i3 != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.f2599g.f1085e).iterator();
        if (!it.hasNext()) {
            return false;
        }
        AbstractC0032g.m162t(it.next());
        throw null;
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z3, Configuration configuration) {
        super.onMultiWindowModeChanged(z3, configuration);
        Iterator it = this.f2609q.iterator();
        while (it.hasNext()) {
            ((InterfaceC0293a) it.next()).mo474a(new C2068f(12));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator it = this.f2608p.iterator();
        while (it.hasNext()) {
            ((InterfaceC0293a) it.next()).mo474a(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i3, Menu menu) {
        Iterator it = ((CopyOnWriteArrayList) this.f2599g.f1085e).iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            throw null;
        }
        super.onPanelClosed(i3, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z3, Configuration configuration) {
        super.onPictureInPictureModeChanged(z3, configuration);
        Iterator it = this.f2610r.iterator();
        while (it.hasNext()) {
            ((InterfaceC0293a) it.next()).mo474a(new C0217a(13));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i3, View view, Menu menu) {
        if (i3 != 0) {
            return true;
        }
        super.onPreparePanel(i3, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f2599g.f1085e).iterator();
        if (!it.hasNext()) {
            return true;
        }
        AbstractC0032g.m162t(it.next());
        throw null;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        if (this.f2605m.m2214a(i3, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i3, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        C0872g c0872g;
        C0966K c0966k = this.f2602j;
        if (c0966k == null && (c0872g = (C0872g) getLastNonConfigurationInstance()) != null) {
            c0966k = c0872g.f2596a;
        }
        if (c0966k == null) {
            return null;
        }
        C0872g c0872g2 = new C0872g();
        c0872g2.f2596a = c0966k;
        return c0872g2;
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        C0986s c0986s = this.f2600h;
        if (c0986s instanceof C0986s) {
            EnumC0979l enumC0979l = EnumC0979l.f3320g;
            c0986s.m2517c("setCurrentState");
            c0986s.m2519e(enumC0979l);
        }
        m2203i(bundle);
        this.f2601i.m2185c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i3) {
        super.onTrimMemory(i3);
        Iterator it = this.f2607o.iterator();
        while (it.hasNext()) {
            ((InterfaceC0293a) it.next()).mo474a(Integer.valueOf(i3));
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (AbstractC1852a.m4128c()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i3) {
        m2201g();
        super.setContentView(i3);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        m2201g();
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m2201g();
        super.setContentView(view, layoutParams);
    }
}

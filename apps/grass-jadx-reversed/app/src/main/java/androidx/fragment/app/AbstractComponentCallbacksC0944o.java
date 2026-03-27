package androidx.fragment.app;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.C0966K;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.C0990w;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.EnumC0979l;
import androidx.lifecycle.InterfaceC0967L;
import androidx.lifecycle.InterfaceC0975h;
import androidx.lifecycle.InterfaceC0984q;
import io.getgrass.www.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p065W.C0673a;
import p077a0.C0846e;
import p077a0.C0847f;
import p077a0.InterfaceC0848g;
import p119m2.AbstractC1766e;
import p125o0.AbstractC1794d;
import p128p.C1818l;
import p136r.AbstractC1849h;
import p165z.AbstractC2045a;

/* JADX INFO: renamed from: androidx.fragment.app.o */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractComponentCallbacksC0944o implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0984q, InterfaceC0967L, InterfaceC0975h, InterfaceC0848g {

    /* JADX INFO: renamed from: V */
    public static final Object f3200V = new Object();

    /* JADX INFO: renamed from: A */
    public int f3201A;

    /* JADX INFO: renamed from: B */
    public String f3202B;

    /* JADX INFO: renamed from: C */
    public boolean f3203C;

    /* JADX INFO: renamed from: D */
    public boolean f3204D;

    /* JADX INFO: renamed from: E */
    public boolean f3205E;

    /* JADX INFO: renamed from: F */
    public boolean f3206F;

    /* JADX INFO: renamed from: H */
    public boolean f3208H;

    /* JADX INFO: renamed from: I */
    public ViewGroup f3209I;

    /* JADX INFO: renamed from: J */
    public View f3210J;

    /* JADX INFO: renamed from: K */
    public boolean f3211K;

    /* JADX INFO: renamed from: M */
    public C0943n f3213M;

    /* JADX INFO: renamed from: N */
    public boolean f3214N;

    /* JADX INFO: renamed from: O */
    public boolean f3215O;

    /* JADX INFO: renamed from: Q */
    public C0986s f3217Q;

    /* JADX INFO: renamed from: R */
    public C0925K f3218R;

    /* JADX INFO: renamed from: T */
    public C0847f f3220T;

    /* JADX INFO: renamed from: U */
    public final ArrayList f3221U;

    /* JADX INFO: renamed from: f */
    public Bundle f3223f;

    /* JADX INFO: renamed from: g */
    public SparseArray f3224g;

    /* JADX INFO: renamed from: h */
    public Bundle f3225h;

    /* JADX INFO: renamed from: j */
    public Bundle f3227j;

    /* JADX INFO: renamed from: k */
    public AbstractComponentCallbacksC0944o f3228k;

    /* JADX INFO: renamed from: m */
    public int f3230m;

    /* JADX INFO: renamed from: o */
    public boolean f3232o;

    /* JADX INFO: renamed from: p */
    public boolean f3233p;

    /* JADX INFO: renamed from: q */
    public boolean f3234q;

    /* JADX INFO: renamed from: r */
    public boolean f3235r;

    /* JADX INFO: renamed from: s */
    public boolean f3236s;

    /* JADX INFO: renamed from: t */
    public boolean f3237t;

    /* JADX INFO: renamed from: u */
    public int f3238u;

    /* JADX INFO: renamed from: v */
    public C0918D f3239v;

    /* JADX INFO: renamed from: w */
    public C0946q f3240w;

    /* JADX INFO: renamed from: y */
    public AbstractComponentCallbacksC0944o f3242y;

    /* JADX INFO: renamed from: z */
    public int f3243z;

    /* JADX INFO: renamed from: e */
    public int f3222e = -1;

    /* JADX INFO: renamed from: i */
    public String f3226i = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: l */
    public String f3229l = null;

    /* JADX INFO: renamed from: n */
    public Boolean f3231n = null;

    /* JADX INFO: renamed from: x */
    public C0918D f3241x = new C0918D();

    /* JADX INFO: renamed from: G */
    public final boolean f3207G = true;

    /* JADX INFO: renamed from: L */
    public boolean f3212L = true;

    /* JADX INFO: renamed from: P */
    public EnumC0979l f3216P = EnumC0979l.f3322i;

    /* JADX INFO: renamed from: S */
    public final C0990w f3219S = new C0990w();

    public AbstractComponentCallbacksC0944o() {
        new AtomicInteger();
        this.f3221U = new ArrayList();
        this.f3217Q = new C0986s(this);
        this.f3220T = new C0847f(this);
    }

    /* JADX INFO: renamed from: A */
    public void mo2466A() {
        this.f3208H = true;
    }

    /* JADX INFO: renamed from: B */
    public void mo2467B(Bundle bundle) {
        this.f3208H = true;
    }

    /* JADX INFO: renamed from: C */
    public void mo2468C(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3241x.m2371G();
        this.f3237t = true;
        this.f3218R = new C0925K(mo2198c());
        View viewMo500r = mo500r(layoutInflater, viewGroup, bundle);
        this.f3210J = viewMo500r;
        if (viewMo500r == null) {
            if (this.f3218R.f3102f != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.f3218R = null;
            return;
        }
        this.f3218R.m2433f();
        this.f3210J.setTag(R.id.view_tree_lifecycle_owner, this.f3218R);
        this.f3210J.setTag(R.id.view_tree_view_model_store_owner, this.f3218R);
        View view = this.f3210J;
        C0925K c0925k = this.f3218R;
        AbstractC1766e.m3920e("<this>", view);
        view.setTag(R.id.view_tree_saved_state_registry_owner, c0925k);
        this.f3219S.m2530e(this.f3218R);
    }

    /* JADX INFO: renamed from: D */
    public final void m2476D() {
        this.f3241x.m2400p(1);
        if (this.f3210J != null) {
            C0925K c0925k = this.f3218R;
            c0925k.m2433f();
            if (c0925k.f3102f.f3328b.m2513a(EnumC0979l.f3320g)) {
                this.f3218R.m2432e(EnumC0978k.ON_DESTROY);
            }
        }
        this.f3222e = 1;
        this.f3208H = false;
        mo501t();
        if (!this.f3208H) {
            throw new C0929O("Fragment " + this + " did not call through to super.onDestroyView()");
        }
        C1818l c1818l = ((C0673a) new C0009j(this, mo2198c()).f31g).f1831c;
        if (c1818l.f6301g <= 0) {
            this.f3237t = false;
        } else {
            AbstractC0032g.m162t(c1818l.f6300f[0]);
            throw null;
        }
    }

    /* JADX INFO: renamed from: E */
    public final void m2477E() {
        this.f3208H = true;
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3241x.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.m2477E();
            }
        }
    }

    /* JADX INFO: renamed from: F */
    public final void m2478F(boolean z3) {
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3241x.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.m2478F(z3);
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public final void m2479G(boolean z3) {
        for (AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o : this.f3241x.f3031c.m4604o()) {
            if (abstractComponentCallbacksC0944o != null) {
                abstractComponentCallbacksC0944o.m2479G(z3);
            }
        }
    }

    /* JADX INFO: renamed from: H */
    public final boolean m2480H() {
        if (this.f3203C) {
            return false;
        }
        return this.f3241x.m2399o();
    }

    /* JADX INFO: renamed from: I */
    public final Context m2481I() {
        Context contextM2492j = m2492j();
        if (contextM2492j != null) {
            return contextM2492j;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    /* JADX INFO: renamed from: J */
    public final View m2482J() {
        View view = this.f3210J;
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* JADX INFO: renamed from: K */
    public final void m2483K(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.f3241x.m2376L(parcelable);
        C0918D c0918d = this.f3241x;
        c0918d.f3053y = false;
        c0918d.f3054z = false;
        c0918d.f3027F.f3069h = false;
        c0918d.m2400p(1);
    }

    /* JADX INFO: renamed from: L */
    public final void m2484L(int i3, int i4, int i5, int i6) {
        if (this.f3213M == null && i3 == 0 && i4 == 0 && i5 == 0 && i6 == 0) {
            return;
        }
        m2489g().f3190b = i3;
        m2489g().f3191c = i4;
        m2489g().f3192d = i5;
        m2489g().f3193e = i6;
    }

    /* JADX INFO: renamed from: M */
    public final void m2485M(Bundle bundle) {
        C0918D c0918d = this.f3239v;
        if (c0918d != null && (c0918d.f3053y || c0918d.f3054z)) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f3227j = bundle;
    }

    /* JADX INFO: renamed from: N */
    public final void m2486N() {
        this.f3205E = true;
        C0918D c0918d = this.f3239v;
        if (c0918d != null) {
            c0918d.f3027F.m2411b(this);
        } else {
            this.f3206F = true;
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m2487O(int i3, Intent intent) {
        if (this.f3240w == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        C0918D c0918dM2494l = m2494l();
        if (c0918dM2494l.f3048t == null) {
            C0946q c0946q = c0918dM2494l.f3042n;
            if (i3 == -1) {
                AbstractC2045a.m4513b(c0946q.f3247f, intent, null);
                return;
            } else {
                c0946q.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        String str = this.f3226i;
        C0915A c0915a = new C0915A();
        c0915a.f3017e = str;
        c0915a.f3018f = i3;
        c0918dM2494l.f3051w.addLast(c0915a);
        c0918dM2494l.f3048t.m2213f(intent);
    }

    @Override // p077a0.InterfaceC0848g
    /* JADX INFO: renamed from: b */
    public final C0846e mo2186b() {
        return this.f3220T.f2519b;
    }

    @Override // androidx.lifecycle.InterfaceC0967L
    /* JADX INFO: renamed from: c */
    public final C0966K mo2198c() {
        if (this.f3239v == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (m2493k() == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.f3239v.f3027F.f3066e;
        C0966K c0966k = (C0966K) map.get(this.f3226i);
        if (c0966k != null) {
            return c0966k;
        }
        C0966K c0966k2 = new C0966K();
        map.put(this.f3226i, c0966k2);
        return c0966k2;
    }

    @Override // androidx.lifecycle.InterfaceC0984q
    /* JADX INFO: renamed from: d */
    public final C0986s mo2199d() {
        return this.f3217Q;
    }

    /* JADX INFO: renamed from: e */
    public AbstractC1794d mo2471e() {
        return new C0942m(this);
    }

    /* JADX INFO: renamed from: f */
    public final void m2488f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f3243z));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f3201A));
        printWriter.print(" mTag=");
        printWriter.println(this.f3202B);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f3222e);
        printWriter.print(" mWho=");
        printWriter.print(this.f3226i);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f3238u);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f3232o);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f3233p);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f3234q);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f3235r);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f3203C);
        printWriter.print(" mDetached=");
        printWriter.print(this.f3204D);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f3207G);
        printWriter.print(" mHasMenu=");
        printWriter.println(false);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f3205E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f3212L);
        if (this.f3239v != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f3239v);
        }
        if (this.f3240w != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f3240w);
        }
        if (this.f3242y != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f3242y);
        }
        if (this.f3227j != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f3227j);
        }
        if (this.f3223f != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f3223f);
        }
        if (this.f3224g != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f3224g);
        }
        if (this.f3225h != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f3225h);
        }
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM4596e = this.f3228k;
        if (abstractComponentCallbacksC0944oM4596e == null) {
            C0918D c0918d = this.f3239v;
            abstractComponentCallbacksC0944oM4596e = (c0918d == null || (str2 = this.f3229l) == null) ? null : c0918d.f3031c.m4596e(str2);
        }
        if (abstractComponentCallbacksC0944oM4596e != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(abstractComponentCallbacksC0944oM4596e);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f3230m);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        C0943n c0943n = this.f3213M;
        printWriter.println(c0943n == null ? false : c0943n.f3189a);
        C0943n c0943n2 = this.f3213M;
        if ((c0943n2 == null ? 0 : c0943n2.f3190b) != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            C0943n c0943n3 = this.f3213M;
            printWriter.println(c0943n3 == null ? 0 : c0943n3.f3190b);
        }
        C0943n c0943n4 = this.f3213M;
        if ((c0943n4 == null ? 0 : c0943n4.f3191c) != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            C0943n c0943n5 = this.f3213M;
            printWriter.println(c0943n5 == null ? 0 : c0943n5.f3191c);
        }
        C0943n c0943n6 = this.f3213M;
        if ((c0943n6 == null ? 0 : c0943n6.f3192d) != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            C0943n c0943n7 = this.f3213M;
            printWriter.println(c0943n7 == null ? 0 : c0943n7.f3192d);
        }
        C0943n c0943n8 = this.f3213M;
        if ((c0943n8 == null ? 0 : c0943n8.f3193e) != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            C0943n c0943n9 = this.f3213M;
            printWriter.println(c0943n9 != null ? c0943n9.f3193e : 0);
        }
        if (this.f3209I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f3209I);
        }
        if (this.f3210J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f3210J);
        }
        C0943n c0943n10 = this.f3213M;
        if (c0943n10 != null) {
            c0943n10.getClass();
        }
        if (m2492j() != null) {
            new C0009j(this, mo2198c()).m64x(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.f3241x + ":");
        this.f3241x.m2401q(AbstractC1849h.m4117a(str, "  "), fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: renamed from: g */
    public final C0943n m2489g() {
        if (this.f3213M == null) {
            C0943n c0943n = new C0943n();
            Object obj = f3200V;
            c0943n.f3195g = obj;
            c0943n.f3196h = obj;
            c0943n.f3197i = obj;
            c0943n.f3198j = 1.0f;
            c0943n.f3199k = null;
            this.f3213M = c0943n;
        }
        return this.f3213M;
    }

    /* JADX INFO: renamed from: h */
    public final AbstractActivityC0947r m2490h() {
        C0946q c0946q = this.f3240w;
        if (c0946q == null) {
            return null;
        }
        return (AbstractActivityC0947r) c0946q.f3246e;
    }

    /* JADX INFO: renamed from: i */
    public final C0918D m2491i() {
        if (this.f3240w != null) {
            return this.f3241x;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    /* JADX INFO: renamed from: j */
    public final Context m2492j() {
        C0946q c0946q = this.f3240w;
        if (c0946q == null) {
            return null;
        }
        return c0946q.f3247f;
    }

    /* JADX INFO: renamed from: k */
    public final int m2493k() {
        EnumC0979l enumC0979l = this.f3216P;
        return (enumC0979l == EnumC0979l.f3319f || this.f3242y == null) ? enumC0979l.ordinal() : Math.min(enumC0979l.ordinal(), this.f3242y.m2493k());
    }

    /* JADX INFO: renamed from: l */
    public final C0918D m2494l() {
        C0918D c0918d = this.f3239v;
        if (c0918d != null) {
            return c0918d;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    /* JADX INFO: renamed from: m */
    public final Resources m2495m() {
        return m2481I().getResources();
    }

    /* JADX INFO: renamed from: n */
    public final boolean m2496n() {
        return this.f3240w != null && this.f3232o;
    }

    /* JADX INFO: renamed from: o */
    public void mo517o(int i3, int i4, Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i3 + " resultCode: " + i4 + " data: " + intent);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f3208H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        AbstractActivityC0947r abstractActivityC0947rM2490h = m2490h();
        if (abstractActivityC0947rM2490h != null) {
            abstractActivityC0947rM2490h.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f3208H = true;
    }

    /* JADX INFO: renamed from: p */
    public void mo2472p(Context context) {
        this.f3208H = true;
        C0946q c0946q = this.f3240w;
        if ((c0946q == null ? null : c0946q.f3246e) != null) {
            this.f3208H = true;
        }
    }

    /* JADX INFO: renamed from: q */
    public void mo518q(Bundle bundle) {
        this.f3208H = true;
        m2483K(bundle);
        C0918D c0918d = this.f3241x;
        if (c0918d.f3041m >= 1) {
            return;
        }
        c0918d.f3053y = false;
        c0918d.f3054z = false;
        c0918d.f3027F.f3069h = false;
        c0918d.m2400p(1);
    }

    /* JADX INFO: renamed from: r */
    public View mo500r(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* JADX INFO: renamed from: s */
    public void mo519s() {
        this.f3208H = true;
    }

    /* JADX INFO: renamed from: t */
    public void mo501t() {
        this.f3208H = true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.f3226i);
        if (this.f3243z != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f3243z));
        }
        if (this.f3202B != null) {
            sb.append(" tag=");
            sb.append(this.f3202B);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: u */
    public void mo2473u() {
        this.f3208H = true;
    }

    /* JADX INFO: renamed from: v */
    public LayoutInflater mo2474v(Bundle bundle) {
        C0946q c0946q = this.f3240w;
        if (c0946q == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        AbstractActivityC0947r abstractActivityC0947r = c0946q.f3250i;
        LayoutInflater layoutInflaterCloneInContext = abstractActivityC0947r.getLayoutInflater().cloneInContext(abstractActivityC0947r);
        layoutInflaterCloneInContext.setFactory2(this.f3241x.f3034f);
        return layoutInflaterCloneInContext;
    }

    /* JADX INFO: renamed from: w */
    public void mo520w() {
        this.f3208H = true;
    }

    /* JADX INFO: renamed from: x */
    public void mo521x() {
        this.f3208H = true;
    }

    /* JADX INFO: renamed from: y */
    public void mo502y(Bundle bundle) {
    }

    /* JADX INFO: renamed from: z */
    public void mo2475z() {
        this.f3208H = true;
    }
}

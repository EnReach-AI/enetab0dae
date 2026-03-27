package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.C0966K;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.EnumC0979l;
import androidx.lifecycle.InterfaceC0967L;
import androidx.lifecycle.InterfaceC0982o;
import androidx.lifecycle.InterfaceC0984q;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import io.getgrass.www.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.C0009j;
import p005B.AbstractC0032g;
import p029J.AbstractC0310E;
import p029J.AbstractC0311F;
import p029J.AbstractC0323S;
import p034K1.ViewOnAttachStateChangeListenerC0428o;
import p077a0.C0847f;
import p166z0.C2071i;

/* JADX INFO: renamed from: androidx.fragment.app.I */
/* JADX INFO: loaded from: classes.dex */
public final class C0923I {

    /* JADX INFO: renamed from: a */
    public final C0009j f3088a;

    /* JADX INFO: renamed from: b */
    public final C2071i f3089b;

    /* JADX INFO: renamed from: c */
    public final AbstractComponentCallbacksC0944o f3090c;

    /* JADX INFO: renamed from: d */
    public boolean f3091d = false;

    /* JADX INFO: renamed from: e */
    public int f3092e = -1;

    public C0923I(C0009j c0009j, C2071i c2071i, AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        this.f3088a = c0009j;
        this.f3089b = c2071i;
        this.f3090c = abstractComponentCallbacksC0944o;
    }

    /* JADX INFO: renamed from: a */
    public final void m2415a() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + abstractComponentCallbacksC0944o);
        }
        Bundle bundle = abstractComponentCallbacksC0944o.f3223f;
        abstractComponentCallbacksC0944o.f3241x.m2371G();
        abstractComponentCallbacksC0944o.f3222e = 3;
        abstractComponentCallbacksC0944o.f3208H = true;
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + abstractComponentCallbacksC0944o);
        }
        View view = abstractComponentCallbacksC0944o.f3210J;
        if (view != null) {
            Bundle bundle2 = abstractComponentCallbacksC0944o.f3223f;
            SparseArray<Parcelable> sparseArray = abstractComponentCallbacksC0944o.f3224g;
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
                abstractComponentCallbacksC0944o.f3224g = null;
            }
            if (abstractComponentCallbacksC0944o.f3210J != null) {
                abstractComponentCallbacksC0944o.f3218R.f3103g.m2184b(abstractComponentCallbacksC0944o.f3225h);
                abstractComponentCallbacksC0944o.f3225h = null;
            }
            abstractComponentCallbacksC0944o.f3208H = false;
            abstractComponentCallbacksC0944o.mo2467B(bundle2);
            if (!abstractComponentCallbacksC0944o.f3208H) {
                throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onViewStateRestored()");
            }
            if (abstractComponentCallbacksC0944o.f3210J != null) {
                abstractComponentCallbacksC0944o.f3218R.m2432e(EnumC0978k.ON_CREATE);
            }
        }
        abstractComponentCallbacksC0944o.f3223f = null;
        C0918D c0918d = abstractComponentCallbacksC0944o.f3241x;
        c0918d.f3053y = false;
        c0918d.f3054z = false;
        c0918d.f3027F.f3069h = false;
        c0918d.m2400p(4);
        this.f3088a.m45e(false);
    }

    /* JADX INFO: renamed from: b */
    public final void m2416b() {
        View view;
        View view2;
        C2071i c2071i = this.f3089b;
        c2071i.getClass();
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        ViewGroup viewGroup = abstractComponentCallbacksC0944o.f3209I;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = (ArrayList) c2071i.f7314a;
            int iIndexOf = arrayList.indexOf(abstractComponentCallbacksC0944o);
            int i3 = iIndexOf - 1;
            while (true) {
                if (i3 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = (AbstractComponentCallbacksC0944o) arrayList.get(iIndexOf);
                        if (abstractComponentCallbacksC0944o2.f3209I == viewGroup && (view = abstractComponentCallbacksC0944o2.f3210J) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o3 = (AbstractComponentCallbacksC0944o) arrayList.get(i3);
                    if (abstractComponentCallbacksC0944o3.f3209I == viewGroup && (view2 = abstractComponentCallbacksC0944o3.f3210J) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i3--;
                }
            }
        }
        abstractComponentCallbacksC0944o.f3209I.addView(abstractComponentCallbacksC0944o.f3210J, iIndexOfChild);
    }

    /* JADX INFO: renamed from: c */
    public final void m2417c() {
        C0923I c0923i;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ATTACHED: " + abstractComponentCallbacksC0944o);
        }
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = abstractComponentCallbacksC0944o.f3228k;
        C2071i c2071i = this.f3089b;
        if (abstractComponentCallbacksC0944o2 != null) {
            c0923i = (C0923I) ((HashMap) c2071i.f7315b).get(abstractComponentCallbacksC0944o2.f3226i);
            if (c0923i == null) {
                throw new IllegalStateException("Fragment " + abstractComponentCallbacksC0944o + " declared target fragment " + abstractComponentCallbacksC0944o.f3228k + " that does not belong to this FragmentManager!");
            }
            abstractComponentCallbacksC0944o.f3229l = abstractComponentCallbacksC0944o.f3228k.f3226i;
            abstractComponentCallbacksC0944o.f3228k = null;
        } else {
            String str = abstractComponentCallbacksC0944o.f3229l;
            if (str != null) {
                c0923i = (C0923I) ((HashMap) c2071i.f7315b).get(str);
                if (c0923i == null) {
                    StringBuilder sb = new StringBuilder("Fragment ");
                    sb.append(abstractComponentCallbacksC0944o);
                    sb.append(" declared target fragment ");
                    throw new IllegalStateException(AbstractC0032g.m157o(sb, abstractComponentCallbacksC0944o.f3229l, " that does not belong to this FragmentManager!"));
                }
            } else {
                c0923i = null;
            }
        }
        if (c0923i != null) {
            c0923i.m2425k();
        }
        C0918D c0918d = abstractComponentCallbacksC0944o.f3239v;
        abstractComponentCallbacksC0944o.f3240w = c0918d.f3042n;
        abstractComponentCallbacksC0944o.f3242y = c0918d.f3044p;
        C0009j c0009j = this.f3088a;
        c0009j.m55o(false);
        ArrayList arrayList = abstractComponentCallbacksC0944o.f3221U;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            AbstractC0032g.m162t(it.next());
            throw null;
        }
        arrayList.clear();
        abstractComponentCallbacksC0944o.f3241x.m2386b(abstractComponentCallbacksC0944o.f3240w, abstractComponentCallbacksC0944o.mo2471e(), abstractComponentCallbacksC0944o);
        abstractComponentCallbacksC0944o.f3222e = 0;
        abstractComponentCallbacksC0944o.f3208H = false;
        abstractComponentCallbacksC0944o.mo2472p(abstractComponentCallbacksC0944o.f3240w.f3247f);
        if (!abstractComponentCallbacksC0944o.f3208H) {
            throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onAttach()");
        }
        Iterator it2 = abstractComponentCallbacksC0944o.f3239v.f3040l.iterator();
        while (it2.hasNext()) {
            ((InterfaceC0921G) it2.next()).mo2414a();
        }
        C0918D c0918d2 = abstractComponentCallbacksC0944o.f3241x;
        c0918d2.f3053y = false;
        c0918d2.f3054z = false;
        c0918d2.f3027F.f3069h = false;
        c0918d2.m2400p(0);
        c0009j.m50j(false);
    }

    /* JADX INFO: renamed from: d */
    public final int m2418d() {
        C0928N c0928n;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (abstractComponentCallbacksC0944o.f3239v == null) {
            return abstractComponentCallbacksC0944o.f3222e;
        }
        int iMin = this.f3092e;
        int iOrdinal = abstractComponentCallbacksC0944o.f3216P.ordinal();
        if (iOrdinal == 1) {
            iMin = Math.min(iMin, 0);
        } else if (iOrdinal == 2) {
            iMin = Math.min(iMin, 1);
        } else if (iOrdinal == 3) {
            iMin = Math.min(iMin, 5);
        } else if (iOrdinal != 4) {
            iMin = Math.min(iMin, -1);
        }
        if (abstractComponentCallbacksC0944o.f3234q) {
            if (abstractComponentCallbacksC0944o.f3235r) {
                iMin = Math.max(this.f3092e, 2);
                View view = abstractComponentCallbacksC0944o.f3210J;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f3092e < 4 ? Math.min(iMin, abstractComponentCallbacksC0944o.f3222e) : Math.min(iMin, 1);
            }
        }
        if (!abstractComponentCallbacksC0944o.f3232o) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = abstractComponentCallbacksC0944o.f3209I;
        if (viewGroup != null) {
            C0937h c0937hM2456f = C0937h.m2456f(viewGroup, abstractComponentCallbacksC0944o.m2494l().m2368A());
            c0937hM2456f.getClass();
            C0928N c0928nM2460d = c0937hM2456f.m2460d(abstractComponentCallbacksC0944o);
            i = c0928nM2460d != null ? c0928nM2460d.f3110b : 0;
            Iterator it = c0937hM2456f.f3164c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0928n = null;
                    break;
                }
                c0928n = (C0928N) it.next();
                if (c0928n.f3111c.equals(abstractComponentCallbacksC0944o) && !c0928n.f3114f) {
                    break;
                }
            }
            if (c0928n != null && (i == 0 || i == 1)) {
                i = c0928n.f3110b;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (abstractComponentCallbacksC0944o.f3233p) {
            iMin = abstractComponentCallbacksC0944o.f3238u > 0 ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (abstractComponentCallbacksC0944o.f3211K && abstractComponentCallbacksC0944o.f3222e < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + abstractComponentCallbacksC0944o);
        }
        return iMin;
    }

    /* JADX INFO: renamed from: e */
    public final void m2419e() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        final AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto CREATED: " + abstractComponentCallbacksC0944o);
        }
        if (abstractComponentCallbacksC0944o.f3215O) {
            abstractComponentCallbacksC0944o.m2483K(abstractComponentCallbacksC0944o.f3223f);
            abstractComponentCallbacksC0944o.f3222e = 1;
            return;
        }
        C0009j c0009j = this.f3088a;
        c0009j.m56p(false);
        Bundle bundle = abstractComponentCallbacksC0944o.f3223f;
        abstractComponentCallbacksC0944o.f3241x.m2371G();
        abstractComponentCallbacksC0944o.f3222e = 1;
        abstractComponentCallbacksC0944o.f3208H = false;
        abstractComponentCallbacksC0944o.f3217Q.m2515a(new InterfaceC0982o() { // from class: androidx.fragment.app.Fragment$5
            @Override // androidx.lifecycle.InterfaceC0982o
            /* JADX INFO: renamed from: b */
            public final void mo2170b(InterfaceC0984q interfaceC0984q, EnumC0978k enumC0978k) {
                View view;
                if (enumC0978k != EnumC0978k.ON_STOP || (view = abstractComponentCallbacksC0944o.f3210J) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        abstractComponentCallbacksC0944o.f3220T.m2184b(bundle);
        abstractComponentCallbacksC0944o.mo518q(bundle);
        abstractComponentCallbacksC0944o.f3215O = true;
        if (abstractComponentCallbacksC0944o.f3208H) {
            abstractComponentCallbacksC0944o.f3217Q.m2518d(EnumC0978k.ON_CREATE);
            c0009j.m51k(false);
        } else {
            throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onCreate()");
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m2420f() {
        String resourceName;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (abstractComponentCallbacksC0944o.f3234q) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + abstractComponentCallbacksC0944o);
        }
        LayoutInflater layoutInflaterMo2474v = abstractComponentCallbacksC0944o.mo2474v(abstractComponentCallbacksC0944o.f3223f);
        ViewGroup viewGroup = abstractComponentCallbacksC0944o.f3209I;
        if (viewGroup == null) {
            int i3 = abstractComponentCallbacksC0944o.f3201A;
            if (i3 == 0) {
                viewGroup = null;
            } else {
                if (i3 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + abstractComponentCallbacksC0944o + " for a container view with no id");
                }
                viewGroup = (ViewGroup) abstractComponentCallbacksC0944o.f3239v.f3043o.mo2464j(i3);
                if (viewGroup == null && !abstractComponentCallbacksC0944o.f3236s) {
                    try {
                        resourceName = abstractComponentCallbacksC0944o.m2495m().getResourceName(abstractComponentCallbacksC0944o.f3201A);
                    } catch (Resources.NotFoundException unused) {
                        resourceName = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(abstractComponentCallbacksC0944o.f3201A) + " (" + resourceName + ") for fragment " + abstractComponentCallbacksC0944o);
                }
            }
        }
        abstractComponentCallbacksC0944o.f3209I = viewGroup;
        abstractComponentCallbacksC0944o.mo2468C(layoutInflaterMo2474v, viewGroup, abstractComponentCallbacksC0944o.f3223f);
        View view = abstractComponentCallbacksC0944o.f3210J;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            abstractComponentCallbacksC0944o.f3210J.setTag(R.id.fragment_container_view_tag, abstractComponentCallbacksC0944o);
            if (viewGroup != null) {
                m2416b();
            }
            if (abstractComponentCallbacksC0944o.f3203C) {
                abstractComponentCallbacksC0944o.f3210J.setVisibility(8);
            }
            View view2 = abstractComponentCallbacksC0944o.f3210J;
            WeakHashMap weakHashMap = AbstractC0323S.f816a;
            if (AbstractC0310E.m619b(view2)) {
                AbstractC0311F.m627c(abstractComponentCallbacksC0944o.f3210J);
            } else {
                View view3 = abstractComponentCallbacksC0944o.f3210J;
                view3.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0428o(1, view3));
            }
            abstractComponentCallbacksC0944o.f3241x.m2400p(2);
            this.f3088a.m62v(false);
            int visibility = abstractComponentCallbacksC0944o.f3210J.getVisibility();
            abstractComponentCallbacksC0944o.m2489g().f3198j = abstractComponentCallbacksC0944o.f3210J.getAlpha();
            if (abstractComponentCallbacksC0944o.f3209I != null && visibility == 0) {
                View viewFindFocus = abstractComponentCallbacksC0944o.f3210J.findFocus();
                if (viewFindFocus != null) {
                    abstractComponentCallbacksC0944o.m2489g().f3199k = viewFindFocus;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + abstractComponentCallbacksC0944o);
                    }
                }
                abstractComponentCallbacksC0944o.f3210J.setAlpha(0.0f);
            }
        }
        abstractComponentCallbacksC0944o.f3222e = 2;
    }

    /* JADX INFO: renamed from: g */
    public final void m2421g() {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM4596e;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATED: " + abstractComponentCallbacksC0944o);
        }
        boolean zIsChangingConfigurations = true;
        boolean z3 = abstractComponentCallbacksC0944o.f3233p && abstractComponentCallbacksC0944o.f3238u <= 0;
        C2071i c2071i = this.f3089b;
        if (!z3) {
            C0920F c0920f = (C0920F) c2071i.f7316c;
            if (!((c0920f.f3064c.containsKey(abstractComponentCallbacksC0944o.f3226i) && c0920f.f3067f) ? c0920f.f3068g : true)) {
                String str = abstractComponentCallbacksC0944o.f3229l;
                if (str != null && (abstractComponentCallbacksC0944oM4596e = c2071i.m4596e(str)) != null && abstractComponentCallbacksC0944oM4596e.f3205E) {
                    abstractComponentCallbacksC0944o.f3228k = abstractComponentCallbacksC0944oM4596e;
                }
                abstractComponentCallbacksC0944o.f3222e = 0;
                return;
            }
        }
        C0946q c0946q = abstractComponentCallbacksC0944o.f3240w;
        if (c0946q instanceof InterfaceC0967L) {
            zIsChangingConfigurations = ((C0920F) c2071i.f7316c).f3068g;
        } else {
            Context context = c0946q.f3247f;
            if (context instanceof Activity) {
                zIsChangingConfigurations = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if (z3 || zIsChangingConfigurations) {
            C0920F c0920f2 = (C0920F) c2071i.f7316c;
            c0920f2.getClass();
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + abstractComponentCallbacksC0944o);
            }
            HashMap map = c0920f2.f3065d;
            C0920F c0920f3 = (C0920F) map.get(abstractComponentCallbacksC0944o.f3226i);
            if (c0920f3 != null) {
                c0920f3.mo1631a();
                map.remove(abstractComponentCallbacksC0944o.f3226i);
            }
            HashMap map2 = c0920f2.f3066e;
            C0966K c0966k = (C0966K) map2.get(abstractComponentCallbacksC0944o.f3226i);
            if (c0966k != null) {
                c0966k.m2505a();
                map2.remove(abstractComponentCallbacksC0944o.f3226i);
            }
        }
        abstractComponentCallbacksC0944o.f3241x.m2395k();
        abstractComponentCallbacksC0944o.f3217Q.m2518d(EnumC0978k.ON_DESTROY);
        abstractComponentCallbacksC0944o.f3222e = 0;
        abstractComponentCallbacksC0944o.f3208H = false;
        abstractComponentCallbacksC0944o.f3215O = false;
        abstractComponentCallbacksC0944o.mo519s();
        if (!abstractComponentCallbacksC0944o.f3208H) {
            throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onDestroy()");
        }
        this.f3088a.m52l(false);
        for (C0923I c0923i : c2071i.m4598h()) {
            if (c0923i != null) {
                String str2 = abstractComponentCallbacksC0944o.f3226i;
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = c0923i.f3090c;
                if (str2.equals(abstractComponentCallbacksC0944o2.f3229l)) {
                    abstractComponentCallbacksC0944o2.f3228k = abstractComponentCallbacksC0944o;
                    abstractComponentCallbacksC0944o2.f3229l = null;
                }
            }
        }
        String str3 = abstractComponentCallbacksC0944o.f3229l;
        if (str3 != null) {
            abstractComponentCallbacksC0944o.f3228k = c2071i.m4596e(str3);
        }
        c2071i.m4607s(this);
    }

    /* JADX INFO: renamed from: h */
    public final void m2422h() {
        View view;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + abstractComponentCallbacksC0944o);
        }
        ViewGroup viewGroup = abstractComponentCallbacksC0944o.f3209I;
        if (viewGroup != null && (view = abstractComponentCallbacksC0944o.f3210J) != null) {
            viewGroup.removeView(view);
        }
        abstractComponentCallbacksC0944o.m2476D();
        this.f3088a.m63w(false);
        abstractComponentCallbacksC0944o.f3209I = null;
        abstractComponentCallbacksC0944o.f3210J = null;
        abstractComponentCallbacksC0944o.f3218R = null;
        abstractComponentCallbacksC0944o.f3219S.m2530e(null);
        abstractComponentCallbacksC0944o.f3235r = false;
    }

    /* JADX INFO: renamed from: i */
    public final void m2423i() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + abstractComponentCallbacksC0944o);
        }
        abstractComponentCallbacksC0944o.f3222e = -1;
        abstractComponentCallbacksC0944o.f3208H = false;
        abstractComponentCallbacksC0944o.mo2473u();
        if (!abstractComponentCallbacksC0944o.f3208H) {
            throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onDetach()");
        }
        C0918D c0918d = abstractComponentCallbacksC0944o.f3241x;
        if (!c0918d.f3022A) {
            c0918d.m2395k();
            abstractComponentCallbacksC0944o.f3241x = new C0918D();
        }
        this.f3088a.m53m(false);
        abstractComponentCallbacksC0944o.f3222e = -1;
        abstractComponentCallbacksC0944o.f3240w = null;
        abstractComponentCallbacksC0944o.f3242y = null;
        abstractComponentCallbacksC0944o.f3239v = null;
        if (!abstractComponentCallbacksC0944o.f3233p || abstractComponentCallbacksC0944o.f3238u > 0) {
            C0920F c0920f = (C0920F) this.f3089b.f7316c;
            boolean z3 = true;
            if (c0920f.f3064c.containsKey(abstractComponentCallbacksC0944o.f3226i) && c0920f.f3067f) {
                z3 = c0920f.f3068g;
            }
            if (!z3) {
                return;
            }
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "initState called for fragment: " + abstractComponentCallbacksC0944o);
        }
        abstractComponentCallbacksC0944o.f3217Q = new C0986s(abstractComponentCallbacksC0944o);
        abstractComponentCallbacksC0944o.f3220T = new C0847f(abstractComponentCallbacksC0944o);
        abstractComponentCallbacksC0944o.f3226i = UUID.randomUUID().toString();
        abstractComponentCallbacksC0944o.f3232o = false;
        abstractComponentCallbacksC0944o.f3233p = false;
        abstractComponentCallbacksC0944o.f3234q = false;
        abstractComponentCallbacksC0944o.f3235r = false;
        abstractComponentCallbacksC0944o.f3236s = false;
        abstractComponentCallbacksC0944o.f3238u = 0;
        abstractComponentCallbacksC0944o.f3239v = null;
        abstractComponentCallbacksC0944o.f3241x = new C0918D();
        abstractComponentCallbacksC0944o.f3240w = null;
        abstractComponentCallbacksC0944o.f3243z = 0;
        abstractComponentCallbacksC0944o.f3201A = 0;
        abstractComponentCallbacksC0944o.f3202B = null;
        abstractComponentCallbacksC0944o.f3203C = false;
        abstractComponentCallbacksC0944o.f3204D = false;
    }

    /* JADX INFO: renamed from: j */
    public final void m2424j() {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (abstractComponentCallbacksC0944o.f3234q && abstractComponentCallbacksC0944o.f3235r && !abstractComponentCallbacksC0944o.f3237t) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + abstractComponentCallbacksC0944o);
            }
            abstractComponentCallbacksC0944o.mo2468C(abstractComponentCallbacksC0944o.mo2474v(abstractComponentCallbacksC0944o.f3223f), null, abstractComponentCallbacksC0944o.f3223f);
            View view = abstractComponentCallbacksC0944o.f3210J;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                abstractComponentCallbacksC0944o.f3210J.setTag(R.id.fragment_container_view_tag, abstractComponentCallbacksC0944o);
                if (abstractComponentCallbacksC0944o.f3203C) {
                    abstractComponentCallbacksC0944o.f3210J.setVisibility(8);
                }
                abstractComponentCallbacksC0944o.f3241x.m2400p(2);
                this.f3088a.m62v(false);
                abstractComponentCallbacksC0944o.f3222e = 2;
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public final void m2425k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z3 = this.f3091d;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (z3) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + abstractComponentCallbacksC0944o);
                return;
            }
            return;
        }
        try {
            this.f3091d = true;
            while (true) {
                int iM2418d = m2418d();
                int i3 = abstractComponentCallbacksC0944o.f3222e;
                if (iM2418d == i3) {
                    if (abstractComponentCallbacksC0944o.f3214N) {
                        if (abstractComponentCallbacksC0944o.f3210J != null && (viewGroup = abstractComponentCallbacksC0944o.f3209I) != null) {
                            C0937h c0937hM2456f = C0937h.m2456f(viewGroup, abstractComponentCallbacksC0944o.m2494l().m2368A());
                            if (abstractComponentCallbacksC0944o.f3203C) {
                                c0937hM2456f.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + abstractComponentCallbacksC0944o);
                                }
                                c0937hM2456f.m2457a(3, 1, this);
                            } else {
                                c0937hM2456f.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + abstractComponentCallbacksC0944o);
                                }
                                c0937hM2456f.m2457a(2, 1, this);
                            }
                        }
                        C0918D c0918d = abstractComponentCallbacksC0944o.f3239v;
                        if (c0918d != null && abstractComponentCallbacksC0944o.f3232o && C0918D.m2364C(abstractComponentCallbacksC0944o)) {
                            c0918d.f3052x = true;
                        }
                        abstractComponentCallbacksC0944o.f3214N = false;
                    }
                    this.f3091d = false;
                    return;
                }
                if (iM2418d <= i3) {
                    switch (i3 - 1) {
                        case -1:
                            m2423i();
                            break;
                        case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                            m2421g();
                            break;
                        case 1:
                            m2422h();
                            abstractComponentCallbacksC0944o.f3222e = 1;
                            break;
                        case 2:
                            abstractComponentCallbacksC0944o.f3235r = false;
                            abstractComponentCallbacksC0944o.f3222e = 2;
                            break;
                        case FromStringDeserializer.Std.STD_URI /* 3 */:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + abstractComponentCallbacksC0944o);
                            }
                            if (abstractComponentCallbacksC0944o.f3210J != null && abstractComponentCallbacksC0944o.f3224g == null) {
                                m2429o();
                            }
                            if (abstractComponentCallbacksC0944o.f3210J != null && (viewGroup3 = abstractComponentCallbacksC0944o.f3209I) != null) {
                                C0937h c0937hM2456f2 = C0937h.m2456f(viewGroup3, abstractComponentCallbacksC0944o.m2494l().m2368A());
                                c0937hM2456f2.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + abstractComponentCallbacksC0944o);
                                }
                                c0937hM2456f2.m2457a(1, 3, this);
                            }
                            abstractComponentCallbacksC0944o.f3222e = 3;
                            break;
                        case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                            m2431q();
                            break;
                        case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                            abstractComponentCallbacksC0944o.f3222e = 5;
                            break;
                        case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                            m2426l();
                            break;
                    }
                } else {
                    switch (i3 + 1) {
                        case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                            m2417c();
                            break;
                        case 1:
                            m2419e();
                            break;
                        case 2:
                            m2424j();
                            m2420f();
                            break;
                        case FromStringDeserializer.Std.STD_URI /* 3 */:
                            m2415a();
                            break;
                        case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                            if (abstractComponentCallbacksC0944o.f3210J != null && (viewGroup2 = abstractComponentCallbacksC0944o.f3209I) != null) {
                                C0937h c0937hM2456f3 = C0937h.m2456f(viewGroup2, abstractComponentCallbacksC0944o.m2494l().m2368A());
                                int iM145c = AbstractC0032g.m145c(abstractComponentCallbacksC0944o.f3210J.getVisibility());
                                c0937hM2456f3.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + abstractComponentCallbacksC0944o);
                                }
                                c0937hM2456f3.m2457a(iM145c, 2, this);
                            }
                            abstractComponentCallbacksC0944o.f3222e = 4;
                            break;
                        case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                            m2430p();
                            break;
                        case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                            abstractComponentCallbacksC0944o.f3222e = 6;
                            break;
                        case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                            m2428n();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.f3091d = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m2426l() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom RESUMED: " + abstractComponentCallbacksC0944o);
        }
        abstractComponentCallbacksC0944o.f3241x.m2400p(5);
        if (abstractComponentCallbacksC0944o.f3210J != null) {
            abstractComponentCallbacksC0944o.f3218R.m2432e(EnumC0978k.ON_PAUSE);
        }
        abstractComponentCallbacksC0944o.f3217Q.m2518d(EnumC0978k.ON_PAUSE);
        abstractComponentCallbacksC0944o.f3222e = 6;
        abstractComponentCallbacksC0944o.f3208H = false;
        abstractComponentCallbacksC0944o.mo520w();
        if (abstractComponentCallbacksC0944o.f3208H) {
            this.f3088a.m54n(false);
            return;
        }
        throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onPause()");
    }

    /* JADX INFO: renamed from: m */
    public final void m2427m(ClassLoader classLoader) {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        Bundle bundle = abstractComponentCallbacksC0944o.f3223f;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        abstractComponentCallbacksC0944o.f3224g = abstractComponentCallbacksC0944o.f3223f.getSparseParcelableArray("android:view_state");
        abstractComponentCallbacksC0944o.f3225h = abstractComponentCallbacksC0944o.f3223f.getBundle("android:view_registry_state");
        String string = abstractComponentCallbacksC0944o.f3223f.getString("android:target_state");
        abstractComponentCallbacksC0944o.f3229l = string;
        if (string != null) {
            abstractComponentCallbacksC0944o.f3230m = abstractComponentCallbacksC0944o.f3223f.getInt("android:target_req_state", 0);
        }
        boolean z3 = abstractComponentCallbacksC0944o.f3223f.getBoolean("android:user_visible_hint", true);
        abstractComponentCallbacksC0944o.f3212L = z3;
        if (z3) {
            return;
        }
        abstractComponentCallbacksC0944o.f3211K = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX INFO: renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2428n() {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0923I.m2428n():void");
    }

    /* JADX INFO: renamed from: o */
    public final void m2429o() {
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (abstractComponentCallbacksC0944o.f3210J == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        abstractComponentCallbacksC0944o.f3210J.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            abstractComponentCallbacksC0944o.f3224g = sparseArray;
        }
        Bundle bundle = new Bundle();
        abstractComponentCallbacksC0944o.f3218R.f3103g.m2185c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        abstractComponentCallbacksC0944o.f3225h = bundle;
    }

    /* JADX INFO: renamed from: p */
    public final void m2430p() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto STARTED: " + abstractComponentCallbacksC0944o);
        }
        abstractComponentCallbacksC0944o.f3241x.m2371G();
        abstractComponentCallbacksC0944o.f3241x.m2404t(true);
        abstractComponentCallbacksC0944o.f3222e = 5;
        abstractComponentCallbacksC0944o.f3208H = false;
        abstractComponentCallbacksC0944o.mo2475z();
        if (!abstractComponentCallbacksC0944o.f3208H) {
            throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onStart()");
        }
        C0986s c0986s = abstractComponentCallbacksC0944o.f3217Q;
        EnumC0978k enumC0978k = EnumC0978k.ON_START;
        c0986s.m2518d(enumC0978k);
        if (abstractComponentCallbacksC0944o.f3210J != null) {
            abstractComponentCallbacksC0944o.f3218R.m2432e(enumC0978k);
        }
        C0918D c0918d = abstractComponentCallbacksC0944o.f3241x;
        c0918d.f3053y = false;
        c0918d.f3054z = false;
        c0918d.f3027F.f3069h = false;
        c0918d.m2400p(5);
        this.f3088a.m60t(false);
    }

    /* JADX INFO: renamed from: q */
    public final void m2431q() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = this.f3090c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom STARTED: " + abstractComponentCallbacksC0944o);
        }
        C0918D c0918d = abstractComponentCallbacksC0944o.f3241x;
        c0918d.f3054z = true;
        c0918d.f3027F.f3069h = true;
        c0918d.m2400p(4);
        if (abstractComponentCallbacksC0944o.f3210J != null) {
            abstractComponentCallbacksC0944o.f3218R.m2432e(EnumC0978k.ON_STOP);
        }
        abstractComponentCallbacksC0944o.f3217Q.m2518d(EnumC0978k.ON_STOP);
        abstractComponentCallbacksC0944o.f3222e = 4;
        abstractComponentCallbacksC0944o.f3208H = false;
        abstractComponentCallbacksC0944o.mo2466A();
        if (abstractComponentCallbacksC0944o.f3208H) {
            this.f3088a.m61u(false);
            return;
        }
        throw new C0929O("Fragment " + abstractComponentCallbacksC0944o + " did not call through to super.onStop()");
    }

    public C0923I(C0009j c0009j, C2071i c2071i, ClassLoader classLoader, C0953x c0953x, C0922H c0922h) {
        this.f3088a = c0009j;
        this.f3089b = c2071i;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944oM2500a = c0953x.m2500a(c0922h.f3075e);
        this.f3090c = abstractComponentCallbacksC0944oM2500a;
        Bundle bundle = c0922h.f3084n;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        abstractComponentCallbacksC0944oM2500a.m2485M(bundle);
        abstractComponentCallbacksC0944oM2500a.f3226i = c0922h.f3076f;
        abstractComponentCallbacksC0944oM2500a.f3234q = c0922h.f3077g;
        abstractComponentCallbacksC0944oM2500a.f3236s = true;
        abstractComponentCallbacksC0944oM2500a.f3243z = c0922h.f3078h;
        abstractComponentCallbacksC0944oM2500a.f3201A = c0922h.f3079i;
        abstractComponentCallbacksC0944oM2500a.f3202B = c0922h.f3080j;
        abstractComponentCallbacksC0944oM2500a.f3205E = c0922h.f3081k;
        abstractComponentCallbacksC0944oM2500a.f3233p = c0922h.f3082l;
        abstractComponentCallbacksC0944oM2500a.f3204D = c0922h.f3083m;
        abstractComponentCallbacksC0944oM2500a.f3203C = c0922h.f3085o;
        abstractComponentCallbacksC0944oM2500a.f3216P = EnumC0979l.values()[c0922h.f3086p];
        Bundle bundle2 = c0922h.f3087q;
        if (bundle2 != null) {
            abstractComponentCallbacksC0944oM2500a.f3223f = bundle2;
        } else {
            abstractComponentCallbacksC0944oM2500a.f3223f = new Bundle();
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Instantiated fragment " + abstractComponentCallbacksC0944oM2500a);
        }
    }

    public C0923I(C0009j c0009j, C2071i c2071i, AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o, C0922H c0922h) {
        this.f3088a = c0009j;
        this.f3089b = c2071i;
        this.f3090c = abstractComponentCallbacksC0944o;
        abstractComponentCallbacksC0944o.f3224g = null;
        abstractComponentCallbacksC0944o.f3225h = null;
        abstractComponentCallbacksC0944o.f3238u = 0;
        abstractComponentCallbacksC0944o.f3235r = false;
        abstractComponentCallbacksC0944o.f3232o = false;
        AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o2 = abstractComponentCallbacksC0944o.f3228k;
        abstractComponentCallbacksC0944o.f3229l = abstractComponentCallbacksC0944o2 != null ? abstractComponentCallbacksC0944o2.f3226i : null;
        abstractComponentCallbacksC0944o.f3228k = null;
        Bundle bundle = c0922h.f3087q;
        if (bundle != null) {
            abstractComponentCallbacksC0944o.f3223f = bundle;
        } else {
            abstractComponentCallbacksC0944o.f3223f = new Bundle();
        }
    }
}

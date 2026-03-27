package p021G;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1105b;
import com.facebook.C1107d;
import com.facebook.C1127x;
import com.facebook.C1128y;
import com.facebook.InterfaceC1121r;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.google.android.material.behavior.SwipeDismissBehavior;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.WeakHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p001A.AbstractC0001b;
import p010C0.AbstractC0147a;
import p019F0.C0221e;
import p026I.InterfaceC0293a;
import p029J.AbstractC0307B;
import p029J.AbstractC0323S;
import p049Q.C0587e;
import p117m0.C1711f;
import p121n0.ViewTreeObserverOnGlobalFocusChangeListenerC1779d;
import p125o0.C1803m;
import p148u0.AbstractC1946e;
import p156w0.ViewOnClickListenerC1991f;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: G.a */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0224a implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f538e;

    /* JADX INFO: renamed from: f */
    public final Object f539f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f540g;

    public /* synthetic */ RunnableC0224a(Object obj, int i3, Object obj2) {
        this.f538e = i3;
        this.f539f = obj;
        this.f540g = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = null;
        switch (this.f538e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                AbstractC0001b abstractC0001b = (AbstractC0001b) ((C0221e) this.f539f).f534f;
                if (abstractC0001b != null) {
                    abstractC0001b.mo14h((Typeface) this.f540g);
                }
                break;
            case 1:
                ((InterfaceC0293a) this.f539f).mo474a(this.f540g);
                break;
            case 2:
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        AbstractC1117n.m2898h((Context) this.f539f, (String) this.f540g);
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, this);
                        return;
                    }
                    break;
                }
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                C1127x c1127x = (C1127x) this.f540g;
                if (!AbstractC0147a.f354a.contains(this)) {
                    try {
                        for (Pair pair : (ArrayList) this.f539f) {
                            ((InterfaceC1121r) pair.first).mo74a((C1128y) pair.second);
                        }
                        Iterator it = c1127x.f3917g.iterator();
                        while (it.hasNext()) {
                            ((C1105b) it.next()).m2878a();
                        }
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, this);
                        return;
                    }
                    break;
                }
                break;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                Set set = AbstractC0147a.f354a;
                if (!set.contains(this)) {
                    try {
                        View view = (View) this.f539f;
                        if (view instanceof EditText) {
                            ViewTreeObserverOnGlobalFocusChangeListenerC1779d viewTreeObserverOnGlobalFocusChangeListenerC1779d = (ViewTreeObserverOnGlobalFocusChangeListenerC1779d) this.f540g;
                            if (!set.contains(ViewTreeObserverOnGlobalFocusChangeListenerC1779d.class)) {
                                try {
                                    viewTreeObserverOnGlobalFocusChangeListenerC1779d.m3942b(view);
                                } catch (Throwable th3) {
                                    AbstractC0147a.m295a(th3, ViewTreeObserverOnGlobalFocusChangeListenerC1779d.class);
                                }
                            }
                            break;
                        }
                    } catch (Throwable th4) {
                        AbstractC0147a.m295a(th4, this);
                        return;
                    }
                    break;
                }
                break;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                C1803m c1803m = (C1803m) this.f540g;
                Set set2 = AbstractC0147a.f354a;
                if (!set2.contains(this)) {
                    try {
                        try {
                            if (C1803m.m3997h(c1803m) != null) {
                                C1803m.m3997h(c1803m).cancel();
                            }
                            if (!set2.contains(C1803m.class)) {
                                try {
                                    c1803m.f6219e = null;
                                } catch (Throwable th5) {
                                    AbstractC0147a.m295a(th5, C1803m.class);
                                }
                            }
                            Timer timer = new Timer();
                            if (!AbstractC0147a.f354a.contains(C1803m.class)) {
                                try {
                                    c1803m.f6222h = timer;
                                } catch (Throwable th6) {
                                    AbstractC0147a.m295a(th6, C1803m.class);
                                }
                            }
                            C1803m.m3997h(c1803m).scheduleAtFixedRate((TimerTask) this.f539f, 0L, 1000L);
                        } catch (Throwable th7) {
                            AbstractC0147a.m295a(th7, this);
                            return;
                        }
                    } catch (Exception e3) {
                        Log.e(C1803m.m3996b(), "Error scheduling indexing job", e3);
                        return;
                    }
                    break;
                }
                break;
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                Set set3 = AbstractC0147a.f354a;
                if (!set3.contains(this)) {
                    try {
                        String strM4547p = AbstractC2056E.m4547p("MD5", ((String) this.f539f).getBytes());
                        Date date = C1104a.f3820p;
                        C1104a c1104a = (C1104a) C1107d.m2887a().f3849d;
                        if (strM4547p != null) {
                            C1803m c1803m2 = (C1803m) this.f540g;
                            if (!set3.contains(C1803m.class)) {
                                try {
                                    str = (String) c1803m2.f6219e;
                                } catch (Throwable th8) {
                                    AbstractC0147a.m295a(th8, C1803m.class);
                                }
                            }
                            if (strM4547p.equals(str)) {
                            }
                        }
                        String str2 = (String) this.f539f;
                        HashSet hashSet = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        ((C1803m) this.f540g).m4003n(C1803m.m3998i(str2, c1104a, AbstractC1117n.f3877c), strM4547p);
                    } catch (Throwable th9) {
                        AbstractC0147a.m295a(th9, this);
                        return;
                    }
                    break;
                }
                break;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                C0587e c0587e = ((SwipeDismissBehavior) this.f540g).f4229a;
                if (c0587e != null && c0587e.m1322f()) {
                    WeakHashMap weakHashMap = AbstractC0323S.f816a;
                    AbstractC0307B.m597m((View) this.f539f, this);
                    break;
                }
                break;
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                Set set4 = AbstractC0147a.f354a;
                if (!set4.contains(this)) {
                    try {
                        String str3 = (String) this.f539f;
                        List listAsList = Arrays.asList((C1711f) this.f540g);
                        if (!set4.contains(AbstractC1946e.class)) {
                            try {
                                AbstractC1946e.m4349g(2, str3, listAsList);
                            } catch (Throwable th10) {
                                AbstractC0147a.m295a(th10, AbstractC1946e.class);
                                return;
                            }
                            break;
                        }
                    } catch (Throwable th11) {
                        AbstractC0147a.m295a(th11, this);
                        return;
                    }
                }
                break;
            default:
                Set set5 = AbstractC0147a.f354a;
                if (!set5.contains(this)) {
                    try {
                        String str4 = (String) this.f539f;
                        String str5 = (String) this.f540g;
                        float[] fArr = new float[0];
                        if (!set5.contains(ViewOnClickListenerC1991f.class)) {
                            try {
                                ViewOnClickListenerC1991f.m4410c(str4, str5, fArr);
                            } catch (Throwable th12) {
                                AbstractC0147a.m295a(th12, ViewOnClickListenerC1991f.class);
                                return;
                            }
                            break;
                        }
                    } catch (Throwable th13) {
                        AbstractC0147a.m295a(th13, this);
                    }
                }
                break;
        }
    }

    public /* synthetic */ RunnableC0224a(Object obj, Object obj2, int i3, boolean z3) {
        this.f538e = i3;
        this.f540g = obj;
        this.f539f = obj2;
    }

    public RunnableC0224a(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z3) {
        this.f538e = 7;
        this.f540g = swipeDismissBehavior;
        this.f539f = view;
    }
}

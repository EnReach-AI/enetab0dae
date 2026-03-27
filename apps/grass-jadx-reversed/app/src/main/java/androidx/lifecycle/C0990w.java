package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC0941l;
import java.util.Map;
import p005B.AbstractC0032g;
import p036L0.C0444d;
import p113l.C1657a;
import p116m.C1702c;
import p116m.C1703d;
import p116m.C1705f;

/* JADX INFO: renamed from: androidx.lifecycle.w */
/* JADX INFO: loaded from: classes.dex */
public class C0990w {

    /* JADX INFO: renamed from: j */
    public static final Object f3341j = new Object();

    /* JADX INFO: renamed from: a */
    public final Object f3342a;

    /* JADX INFO: renamed from: b */
    public final C1705f f3343b = new C1705f();

    /* JADX INFO: renamed from: c */
    public int f3344c = 0;

    /* JADX INFO: renamed from: d */
    public boolean f3345d;

    /* JADX INFO: renamed from: e */
    public volatile Object f3346e;

    /* JADX INFO: renamed from: f */
    public volatile Object f3347f;

    /* JADX INFO: renamed from: g */
    public int f3348g;

    /* JADX INFO: renamed from: h */
    public boolean f3349h;

    /* JADX INFO: renamed from: i */
    public boolean f3350i;

    public C0990w() {
        Object obj = f3341j;
        this.f3347f = obj;
        this.f3346e = obj;
        this.f3348g = -1;
    }

    /* JADX INFO: renamed from: a */
    public static void m2526a(String str) {
        ((C1657a) C1657a.m3748u().f5880f).getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(AbstractC0032g.m154l("Cannot invoke ", str, " on a background thread"));
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m2527b(AbstractC0989v abstractC0989v) {
        if (abstractC0989v.f3338b) {
            if (!abstractC0989v.mo2507e()) {
                abstractC0989v.m2525c(false);
                return;
            }
            int i3 = abstractC0989v.f3339c;
            int i4 = this.f3348g;
            if (i3 >= i4) {
                return;
            }
            abstractC0989v.f3339c = i4;
            C0444d c0444d = abstractC0989v.f3337a;
            Object obj = this.f3346e;
            c0444d.getClass();
            if (((InterfaceC0984q) obj) != null) {
                DialogInterfaceOnCancelListenerC0941l dialogInterfaceOnCancelListenerC0941l = (DialogInterfaceOnCancelListenerC0941l) c0444d.f1085e;
                if (dialogInterfaceOnCancelListenerC0941l.f3179d0) {
                    View viewM2482J = dialogInterfaceOnCancelListenerC0941l.m2482J();
                    if (viewM2482J.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    if (dialogInterfaceOnCancelListenerC0941l.f3183h0 != null) {
                        if (Log.isLoggable("FragmentManager", 3)) {
                            Log.d("FragmentManager", "DialogFragment " + c0444d + " setting the content view on " + dialogInterfaceOnCancelListenerC0941l.f3183h0);
                        }
                        dialogInterfaceOnCancelListenerC0941l.f3183h0.setContentView(viewM2482J);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2528c(AbstractC0989v abstractC0989v) {
        if (this.f3349h) {
            this.f3350i = true;
            return;
        }
        this.f3349h = true;
        do {
            this.f3350i = false;
            if (abstractC0989v != null) {
                m2527b(abstractC0989v);
                abstractC0989v = null;
            } else {
                C1705f c1705f = this.f3343b;
                c1705f.getClass();
                C1703d c1703d = new C1703d(c1705f);
                c1705f.f5970g.put(c1703d, Boolean.FALSE);
                while (c1703d.hasNext()) {
                    m2527b((AbstractC0989v) ((Map.Entry) c1703d.next()).getValue());
                    if (this.f3350i) {
                        break;
                    }
                }
            }
        } while (this.f3350i);
        this.f3349h = false;
    }

    /* JADX INFO: renamed from: d */
    public final void m2529d(C0444d c0444d) {
        Object obj;
        m2526a("observeForever");
        C0988u c0988u = new C0988u(this, c0444d);
        C1705f c1705f = this.f3343b;
        C1702c c1702cMo3783a = c1705f.mo3783a(c0444d);
        if (c1702cMo3783a != null) {
            obj = c1702cMo3783a.f5962f;
        } else {
            C1702c c1702c = new C1702c(c0444d, c0988u);
            c1705f.f5971h++;
            C1702c c1702c2 = c1705f.f5969f;
            if (c1702c2 == null) {
                c1705f.f5968e = c1702c;
                c1705f.f5969f = c1702c;
            } else {
                c1702c2.f5963g = c1702c;
                c1702c.f5964h = c1702c2;
                c1705f.f5969f = c1702c;
            }
            obj = null;
        }
        AbstractC0989v abstractC0989v = (AbstractC0989v) obj;
        if (abstractC0989v instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0989v != null) {
            return;
        }
        c0988u.m2525c(true);
    }

    /* JADX INFO: renamed from: e */
    public final void m2530e(Object obj) {
        m2526a("setValue");
        this.f3348g++;
        this.f3346e = obj;
        m2528c(null);
    }
}

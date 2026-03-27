package p125o0;

import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.facebook.AbstractC1117n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import p010C0.AbstractC0147a;
import p129p0.AbstractC1823e;
import p129p0.C1819a;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2082t;
import p166z0.C2079q;

/* JADX INFO: renamed from: o0.g */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC1797g implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {

    /* JADX INFO: renamed from: e */
    public final WeakReference f6203e;

    /* JADX INFO: renamed from: f */
    public ArrayList f6204f;

    /* JADX INFO: renamed from: g */
    public final HashSet f6205g;

    /* JADX INFO: renamed from: h */
    public final String f6206h;

    public ViewTreeObserverOnGlobalLayoutListenerC1797g(View view, Handler handler, HashSet hashSet, String str) {
        this.f6203e = new WeakReference(view);
        this.f6205g = hashSet;
        this.f6206h = str;
        handler.postDelayed(this, 200L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0159, code lost:
    
        if (r11.equals(r10) == false) goto L73;
     */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList m3960d(android.view.View r7, java.util.List r8, int r9, int r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p125o0.ViewTreeObserverOnGlobalLayoutListenerC1797g.m3960d(android.view.View, java.util.List, int, int, java.lang.String):java.util.ArrayList");
    }

    /* JADX INFO: renamed from: e */
    public static ArrayList m3961e(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final void m3962a(C1796f c1796f, View view, C1819a c1819a) {
        View viewM3959a = c1796f.m3959a();
        if (viewM3959a == null) {
            return;
        }
        View.OnClickListener onClickListenerM4060f = AbstractC1823e.m4060f(viewM3959a);
        boolean z3 = (onClickListenerM4060f instanceof ViewOnClickListenerC1792b) && ((ViewOnClickListenerC1792b) onClickListenerM4060f).f6187i;
        HashSet hashSet = this.f6205g;
        String str = c1796f.f6202b;
        if (hashSet.contains(str) || z3) {
            return;
        }
        ViewOnClickListenerC1792b viewOnClickListenerC1792b = null;
        if (!AbstractC0147a.f354a.contains(AbstractC1794d.class)) {
            try {
                ViewOnClickListenerC1792b viewOnClickListenerC1792b2 = new ViewOnClickListenerC1792b();
                viewOnClickListenerC1792b2.f6187i = false;
                viewOnClickListenerC1792b2.f6186h = AbstractC1823e.m4060f(viewM3959a);
                viewOnClickListenerC1792b2.f6183e = c1819a;
                viewOnClickListenerC1792b2.f6184f = new WeakReference(viewM3959a);
                viewOnClickListenerC1792b2.f6185g = new WeakReference(view);
                viewOnClickListenerC1792b2.f6187i = true;
                viewOnClickListenerC1792b = viewOnClickListenerC1792b2;
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1794d.class);
            }
        }
        viewM3959a.setOnClickListener(viewOnClickListenerC1792b);
        hashSet.add(str);
    }

    /* JADX INFO: renamed from: b */
    public final void m3963b(C1796f c1796f, View view, C1819a c1819a) {
        AdapterView adapterView = (AdapterView) c1796f.m3959a();
        if (adapterView == null) {
            return;
        }
        AdapterView.OnItemClickListener onItemClickListener = adapterView.getOnItemClickListener();
        boolean z3 = (onItemClickListener instanceof C1793c) && ((C1793c) onItemClickListener).f6192i;
        HashSet hashSet = this.f6205g;
        String str = c1796f.f6202b;
        if (hashSet.contains(str) || z3) {
            return;
        }
        C1793c c1793c = null;
        if (!AbstractC0147a.f354a.contains(AbstractC1794d.class)) {
            try {
                C1793c c1793c2 = new C1793c();
                c1793c2.f6192i = false;
                c1793c2.f6191h = adapterView.getOnItemClickListener();
                c1793c2.f6188e = c1819a;
                c1793c2.f6189f = new WeakReference(adapterView);
                c1793c2.f6190g = new WeakReference(view);
                c1793c2.f6192i = true;
                c1793c = c1793c2;
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1794d.class);
            }
        }
        adapterView.setOnItemClickListener(c1793c);
        hashSet.add(str);
    }

    /* JADX INFO: renamed from: c */
    public final void m3964c(C1796f c1796f, View view, C1819a c1819a) {
        View viewM3959a = c1796f.m3959a();
        if (viewM3959a == null) {
            return;
        }
        View.OnTouchListener onTouchListenerM4061g = AbstractC1823e.m4061g(viewM3959a);
        boolean z3 = (onTouchListenerM4061g instanceof ViewOnTouchListenerC1799i) && ((ViewOnTouchListenerC1799i) onTouchListenerM4061g).f6217i;
        HashSet hashSet = this.f6205g;
        String str = c1796f.f6202b;
        if (hashSet.contains(str) || z3) {
            return;
        }
        ViewOnTouchListenerC1799i viewOnTouchListenerC1799i = null;
        if (!AbstractC0147a.f354a.contains(AbstractC1800j.class)) {
            try {
                ViewOnTouchListenerC1799i viewOnTouchListenerC1799i2 = new ViewOnTouchListenerC1799i();
                viewOnTouchListenerC1799i2.f6217i = false;
                viewOnTouchListenerC1799i2.f6216h = AbstractC1823e.m4061g(viewM3959a);
                viewOnTouchListenerC1799i2.f6213e = c1819a;
                viewOnTouchListenerC1799i2.f6214f = new WeakReference(viewM3959a);
                viewOnTouchListenerC1799i2.f6215g = new WeakReference(view);
                viewOnTouchListenerC1799i2.f6217i = true;
                viewOnTouchListenerC1799i = viewOnTouchListenerC1799i2;
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC1800j.class);
            }
        }
        viewM3959a.setOnTouchListener(viewOnTouchListenerC1799i);
        hashSet.add(str);
    }

    /* JADX INFO: renamed from: f */
    public final void m3965f() {
        if (this.f6204f != null) {
            WeakReference weakReference = this.f6203e;
            if (weakReference.get() != null) {
                for (int i3 = 0; i3 < this.f6204f.size(); i3++) {
                    C1819a c1819a = (C1819a) this.f6204f.get(i3);
                    View view = (View) weakReference.get();
                    if (c1819a != null && view != null) {
                        String str = c1819a.f6305d;
                        boolean zIsEmpty = TextUtils.isEmpty(str);
                        String str2 = this.f6206h;
                        if (zIsEmpty || str.equals(str2)) {
                            List listUnmodifiableList = Collections.unmodifiableList(c1819a.f6303b);
                            if (listUnmodifiableList.size() <= 25) {
                                for (C1796f c1796f : m3960d(view, listUnmodifiableList, 0, -1, str2)) {
                                    try {
                                        View viewM3959a = c1796f.m3959a();
                                        if (viewM3959a != null) {
                                            View viewM4055a = AbstractC1823e.m4055a(viewM3959a);
                                            if (viewM4055a != null && AbstractC1823e.m4066l(viewM3959a, viewM4055a)) {
                                                m3964c(c1796f, view, c1819a);
                                            } else if (!viewM3959a.getClass().getName().startsWith("com.facebook.react")) {
                                                if (!(viewM3959a instanceof AdapterView)) {
                                                    m3962a(c1796f, view, c1819a);
                                                } else if (viewM3959a instanceof ListView) {
                                                    m3963b(c1796f, view, c1819a);
                                                }
                                            }
                                        }
                                    } catch (Exception unused) {
                                        AbstractC0147a.f354a.contains(C1798h.class);
                                        HashSet hashSet = AbstractC1117n.f3875a;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        m3965f();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        m3965f();
    }

    @Override // java.lang.Runnable
    public final void run() {
        int length;
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079qM4621b = AbstractC2082t.m4621b(AbstractC1117n.f3877c);
            if (c2079qM4621b != null && c2079qM4621b.f7356g) {
                JSONArray jSONArray = c2079qM4621b.f7358i;
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null) {
                    try {
                        length = jSONArray.length();
                    } catch (IllegalArgumentException | JSONException unused) {
                    }
                } else {
                    length = 0;
                }
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(C1819a.m4046a(jSONArray.getJSONObject(i3)));
                }
                this.f6204f = arrayList;
                View view = (View) this.f6203e.get();
                if (view == null) {
                    return;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnGlobalLayoutListener(this);
                    viewTreeObserver.addOnScrollChangedListener(this);
                }
                m3965f();
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}

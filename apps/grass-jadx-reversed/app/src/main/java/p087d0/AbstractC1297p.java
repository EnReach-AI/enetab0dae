package p087d0;

import android.view.ViewGroup;
import io.getgrass.www.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import p005B.AbstractC0032g;
import p029J.AbstractC0310E;
import p029J.AbstractC0323S;
import p128p.C1808b;

/* JADX INFO: renamed from: d0.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1297p {

    /* JADX INFO: renamed from: a */
    public static final C1282a f4639a;

    /* JADX INFO: renamed from: b */
    public static final ThreadLocal f4640b;

    /* JADX INFO: renamed from: c */
    public static final ArrayList f4641c;

    static {
        C1282a c1282a = new C1282a();
        c1282a.f4582A = new ArrayList();
        c1282a.f4583B = true;
        c1282a.f4585D = false;
        c1282a.f4586E = 0;
        c1282a.f4583B = false;
        c1282a.m3238F(new C1290i(2));
        c1282a.m3238F(new C1288g());
        c1282a.m3238F(new C1290i(1));
        f4639a = c1282a;
        f4640b = new ThreadLocal();
        f4641c = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    public static void m3275a(ViewGroup viewGroup, AbstractC1293l abstractC1293l) {
        ArrayList arrayList = f4641c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC0323S.f816a;
        if (AbstractC0310E.m620c(viewGroup)) {
            arrayList.add(viewGroup);
            if (abstractC1293l == null) {
                abstractC1293l = f4639a;
            }
            AbstractC1293l abstractC1293lClone = abstractC1293l.clone();
            ArrayList arrayList2 = (ArrayList) m3276b().getOrDefault(viewGroup, null);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((AbstractC1293l) it.next()).mo3244t(viewGroup);
                }
            }
            if (abstractC1293lClone != null) {
                abstractC1293lClone.m3268g(viewGroup, true);
            }
            AbstractC0032g.m162t(viewGroup.getTag(R.id.transition_current_scene));
            viewGroup.setTag(R.id.transition_current_scene, null);
            if (abstractC1293lClone != null) {
                ViewTreeObserverOnPreDrawListenerC1296o viewTreeObserverOnPreDrawListenerC1296o = new ViewTreeObserverOnPreDrawListenerC1296o();
                viewTreeObserverOnPreDrawListenerC1296o.f4637e = abstractC1293lClone;
                viewTreeObserverOnPreDrawListenerC1296o.f4638f = viewGroup;
                viewGroup.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC1296o);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC1296o);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static C1808b m3276b() {
        C1808b c1808b;
        ThreadLocal threadLocal = f4640b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (c1808b = (C1808b) weakReference.get()) != null) {
            return c1808b;
        }
        C1808b c1808b2 = new C1808b();
        threadLocal.set(new WeakReference(c1808b2));
        return c1808b2;
    }
}

package p125o0;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import com.facebook.AbstractC1117n;
import com.facebook.CallableC1116m;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p021G.RunnableC0224a;
import p129p0.AbstractC1823e;
import p141s0.AbstractC1875e;

/* JADX INFO: renamed from: o0.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1801k extends TimerTask {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C1803m f6218e;

    public C1801k(C1803m c1803m) {
        this.f6218e = c1803m;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        boolean z3;
        boolean z4 = false;
        try {
            boolean zContains = AbstractC0147a.f354a.contains(C1803m.class);
            Handler handler = null;
            C1803m c1803m = this.f6218e;
            if (zContains) {
                weakReference = null;
            } else {
                try {
                    weakReference = (WeakReference) c1803m.f6221g;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, C1803m.class);
                    weakReference = null;
                }
            }
            Activity activity = (Activity) weakReference.get();
            View viewM4196b = AbstractC1875e.m4196b(activity);
            if (activity != null && viewM4196b != null) {
                String simpleName = activity.getClass().getSimpleName();
                C1804n c1804n = AbstractC1795e.f6193a;
                if (AbstractC0147a.f354a.contains(AbstractC1795e.class)) {
                    z3 = false;
                } else {
                    try {
                        z3 = AbstractC1795e.f6198f.get();
                    } catch (Throwable th2) {
                        AbstractC0147a.m295a(th2, AbstractC1795e.class);
                        z3 = false;
                    }
                }
                if (z3) {
                    CallableC1116m callableC1116m = new CallableC1116m();
                    callableC1116m.f3874b = new WeakReference(viewM4196b);
                    FutureTask futureTask = new FutureTask(callableC1116m);
                    if (!AbstractC0147a.f354a.contains(C1803m.class)) {
                        try {
                            handler = (Handler) c1803m.f6220f;
                        } catch (Throwable th3) {
                            AbstractC0147a.m295a(th3, C1803m.class);
                        }
                    }
                    handler.post(futureTask);
                    String str = "";
                    try {
                        str = (String) futureTask.get(1L, TimeUnit.SECONDS);
                    } catch (Exception e3) {
                        Log.e(C1803m.m3996b(), "Failed to take screenshot.", e3);
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("screenname", simpleName);
                        jSONObject.put("screenshot", str);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(AbstractC1823e.m4058d(viewM4196b));
                        jSONObject.put("view", jSONArray);
                    } catch (JSONException unused) {
                        Log.e(C1803m.m3996b(), "Failed to create JSONObject");
                    }
                    String string = jSONObject.toString();
                    Set set = AbstractC0147a.f354a;
                    if (set.contains(C1803m.class)) {
                        return;
                    }
                    try {
                        c1803m.getClass();
                        if (!set.contains(c1803m)) {
                            try {
                                AbstractC1117n.m2891a().execute(new RunnableC0224a(c1803m, string, 6, z4));
                            } catch (Throwable th4) {
                                AbstractC0147a.m295a(th4, c1803m);
                            }
                        }
                    } catch (Throwable th5) {
                        AbstractC0147a.m295a(th5, C1803m.class);
                    }
                }
            }
        } catch (Exception e4) {
            Log.e(C1803m.m3996b(), "UI Component tree indexing failure!", e4);
        }
    }
}

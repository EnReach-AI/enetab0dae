package p166z0;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1107d;
import com.facebook.C1111h;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import p010C0.AbstractC0147a;
import p033K0.AbstractC0406d;

/* JADX INFO: renamed from: z0.J */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskC2061J extends AsyncTask {

    /* JADX INFO: renamed from: a */
    public final String f7277a;

    /* JADX INFO: renamed from: b */
    public final Bundle f7278b;

    /* JADX INFO: renamed from: c */
    public Exception[] f7279c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ DialogC2062K f7280d;

    public AsyncTaskC2061J(DialogC2062K dialogC2062K, String str, Bundle bundle) {
        this.f7280d = dialogC2062K;
        this.f7277a = str;
        this.f7278b = bundle;
    }

    /* JADX INFO: renamed from: a */
    public final String[] m4558a() {
        if (AbstractC0147a.f354a.contains(this)) {
            return null;
        }
        try {
            String[] stringArray = this.f7278b.getStringArray("media");
            String[] strArr = new String[stringArray.length];
            this.f7279c = new Exception[stringArray.length];
            CountDownLatch countDownLatch = new CountDownLatch(stringArray.length);
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            Date date = C1104a.f3820p;
            C1104a c1104a = (C1104a) C1107d.m2887a().f3849d;
            for (int i3 = 0; i3 < stringArray.length; i3++) {
                try {
                    if (isCancelled()) {
                        Iterator it = concurrentLinkedQueue.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        return null;
                    }
                    Uri uri = Uri.parse(stringArray[i3]);
                    if (AbstractC2056E.m4551t(uri)) {
                        strArr[i3] = uri.toString();
                        countDownLatch.countDown();
                    } else {
                        concurrentLinkedQueue.add(AbstractC0406d.m899h(c1104a, uri, new C2060I(this, strArr, i3, countDownLatch)).m2924e());
                    }
                } catch (Exception unused) {
                    Iterator it2 = concurrentLinkedQueue.iterator();
                    while (it2.hasNext()) {
                        ((AsyncTask) it2.next()).cancel(true);
                    }
                    return null;
                }
            }
            countDownLatch.await();
            return strArr;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4559b(String[] strArr) {
        Bundle bundle = this.f7278b;
        DialogC2062K dialogC2062K = this.f7280d;
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            dialogC2062K.f7286i.dismiss();
            for (Exception exc : this.f7279c) {
                if (exc != null) {
                    dialogC2062K.m4565f(exc);
                    return;
                }
            }
            if (strArr == null) {
                dialogC2062K.m4565f(new C1111h("Failed to stage photos for web dialog"));
                return;
            }
            List listAsList = Arrays.asList(strArr);
            if (listAsList.contains(null)) {
                dialogC2062K.m4565f(new C1111h("Failed to stage photos for web dialog"));
                return;
            }
            AbstractC2056E.m4555x(bundle, new JSONArray((Collection) listAsList));
            Collection collection = AbstractC2052A.f7256a;
            dialogC2062K.f7282e = AbstractC2056E.m4533b("m." + AbstractC1117n.f3881g, AbstractC1117n.m2892b() + "/dialog/" + this.f7277a, bundle).toString();
            dialogC2062K.m4566g((dialogC2062K.f7287j.getDrawable().getIntrinsicWidth() / 2) + 1);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        if (AbstractC0147a.f354a.contains(this)) {
            return null;
        }
        try {
            return m4558a();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            m4559b((String[]) obj);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }
}

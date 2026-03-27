package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: com.facebook.w */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskC1126w extends AsyncTask {

    /* JADX INFO: renamed from: a */
    public final C1127x f3912a;

    /* JADX INFO: renamed from: b */
    public Exception f3913b;

    public AsyncTaskC1126w(C1127x c1127x) {
        this.f3912a = c1127x;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        Set set = AbstractC0147a.f354a;
        ArrayList arrayListM2909f = null;
        if (set.contains(this)) {
            return null;
        }
        try {
            if (set.contains(this)) {
                return null;
            }
            try {
                try {
                    C1127x c1127x = this.f3912a;
                    c1127x.getClass();
                    arrayListM2909f = C1125v.m2909f(c1127x);
                    return arrayListM2909f;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, this);
                    return null;
                }
            } catch (Exception e3) {
                this.f3913b = e3;
                return null;
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
            return arrayListM2909f;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            List list = (List) obj;
            if (set.contains(this)) {
                return;
            }
            try {
                super.onPostExecute(list);
                Exception exc = this.f3913b;
                if (exc != null) {
                    exc.getMessage();
                    HashSet hashSet = AbstractC1117n.f3875a;
                }
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, this);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }

    @Override // android.os.AsyncTask
    public final void onPreExecute() {
        C1127x c1127x = this.f3912a;
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            super.onPreExecute();
            HashSet hashSet = AbstractC1117n.f3875a;
            if (c1127x.f3915e == null) {
                c1127x.f3915e = Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper());
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    public final String toString() {
        return "{RequestAsyncTask:  connection: null, requests: " + this.f3912a + "}";
    }
}

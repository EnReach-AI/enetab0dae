package p141s0;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Set;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: s0.k */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncTaskC1881k extends AsyncTask {

    /* JADX INFO: renamed from: a */
    public InterfaceC1880j f6615a;

    /* JADX INFO: renamed from: b */
    public File f6616b;

    /* JADX INFO: renamed from: c */
    public String f6617c;

    /* JADX INFO: renamed from: a */
    public final Boolean m4202a() {
        try {
            if (AbstractC0147a.f354a.contains(this)) {
                return null;
            }
            try {
                URL url = new URL(this.f6617c);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.f6616b));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        if (AbstractC0147a.f354a.contains(this)) {
            return null;
        }
        try {
            return m4202a();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Boolean bool;
        Set set = AbstractC0147a.f354a;
        if (set.contains(this)) {
            return;
        }
        try {
            bool = (Boolean) obj;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
        if (set.contains(this)) {
            return;
        }
        try {
            if (bool.booleanValue()) {
                this.f6615a.mo49i(this.f6616b);
                return;
            }
            return;
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
            return;
        }
        AbstractC0147a.m295a(th, this);
    }
}

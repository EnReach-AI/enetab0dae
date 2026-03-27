package p024H0;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.AbstractActivityC0947r;
import com.facebook.C1100C;
import com.facebook.C1125v;
import com.facebook.EnumC1129z;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
import p001A.C0009j;
import p019F0.C0221e;
import p068X.HandlerC0696a;
import p166z0.AbstractC2088z;
import p166z0.C2054C;

/* JADX INFO: renamed from: H0.l */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceConnectionC0258l implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    public final Context f643a;

    /* JADX INFO: renamed from: b */
    public final HandlerC0696a f644b;

    /* JADX INFO: renamed from: c */
    public C0009j f645c;

    /* JADX INFO: renamed from: d */
    public boolean f646d;

    /* JADX INFO: renamed from: e */
    public Messenger f647e;

    /* JADX INFO: renamed from: f */
    public final int f648f;

    /* JADX INFO: renamed from: g */
    public final int f649g;

    /* JADX INFO: renamed from: h */
    public final String f650h;

    /* JADX INFO: renamed from: i */
    public final int f651i;

    public ServiceConnectionC0258l(AbstractActivityC0947r abstractActivityC0947r, String str) {
        Context applicationContext = abstractActivityC0947r.getApplicationContext();
        this.f643a = applicationContext != null ? applicationContext : abstractActivityC0947r;
        this.f648f = 65536;
        this.f649g = 65537;
        this.f650h = str;
        this.f651i = 20121101;
        this.f644b = new HandlerC0696a(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m503a(Bundle bundle) {
        if (this.f646d) {
            this.f646d = false;
            C0009j c0009j = this.f645c;
            if (c0009j != null) {
                C0259m c0259m = (C0259m) c0009j.f31g;
                ServiceConnectionC0258l serviceConnectionC0258l = c0259m.f652g;
                if (serviceConnectionC0258l != null) {
                    serviceConnectionC0258l.f645c = null;
                }
                c0259m.f652g = null;
                C0221e c0221e = c0259m.f688f.f673i;
                if (c0221e != null) {
                    ((View) c0221e.f534f).setVisibility(8);
                }
                if (bundle != null) {
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
                    C0261o c0261o = (C0261o) c0009j.f30f;
                    Set<String> set = c0261o.f654f;
                    if (stringArrayList != null && (set == null || stringArrayList.containsAll(set))) {
                        String string = bundle.getString("com.facebook.platform.extra.USER_ID");
                        if (string != null && !string.isEmpty()) {
                            c0259m.m505j(c0261o, bundle);
                            return;
                        }
                        C0221e c0221e2 = c0259m.f688f.f673i;
                        if (c0221e2 != null) {
                            ((View) c0221e2.f534f).setVisibility(0);
                        }
                        String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
                        C1100C c1100c = new C1100C(c0259m, bundle, c0261o);
                        JSONObject jSONObject = (JSONObject) AbstractC2088z.f7384a.get(string2);
                        if (jSONObject != null) {
                            c1100c.mo2846b(jSONObject);
                            return;
                        }
                        C2054C c2054c = new C2054C(c1100c, string2);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("fields", "id,name,first_name,middle_name,last_name");
                        bundle2.putString("access_token", string2);
                        C1125v c1125v = new C1125v(null, "me", bundle2, EnumC1129z.f3922e, null);
                        c1125v.m2927s(c2054c);
                        c1125v.m2924e();
                        return;
                    }
                    HashSet hashSet = new HashSet();
                    for (String str : set) {
                        if (!stringArrayList.contains(str)) {
                            hashSet.add(str);
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        c0259m.m524a("new_permissions", TextUtils.join(",", hashSet));
                    }
                    c0261o.f654f = hashSet;
                }
                c0259m.f688f.m516i();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f647e = new Messenger(iBinder);
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f650h);
        Message messageObtain = Message.obtain((Handler) null, this.f648f);
        messageObtain.arg1 = this.f651i;
        messageObtain.setData(bundle);
        messageObtain.replyTo = new Messenger(this.f644b);
        try {
            this.f647e.send(messageObtain);
        } catch (RemoteException unused) {
            m503a(null);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f647e = null;
        try {
            this.f643a.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        m503a(null);
    }
}

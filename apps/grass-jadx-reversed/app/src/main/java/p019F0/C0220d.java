package p019F0;

import android.content.Context;
import android.os.Build;
import com.facebook.AbstractC1117n;
import com.facebook.C1125v;
import com.facebook.C1127x;
import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005B.AbstractC0032g;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: F0.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0220d {

    /* JADX INFO: renamed from: c */
    public static C0220d f527c;

    /* JADX INFO: renamed from: d */
    public static final String f528d = Build.VERSION.RELEASE;

    /* JADX INFO: renamed from: e */
    public static final String f529e = Build.MODEL;

    /* JADX INFO: renamed from: a */
    public C0221e f530a;

    /* JADX INFO: renamed from: b */
    public C0222f f531b;

    /* JADX INFO: renamed from: a */
    public final void m437a() throws Throwable {
        ObjectInputStream objectInputStream;
        C1125v c1125vM2913l;
        this.f531b.getClass();
        Collection arrayList = new ArrayList();
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        Context context = AbstractC1117n.f3882h;
        ObjectInputStream objectInputStream2 = null;
        try {
            objectInputStream = new ObjectInputStream(new BufferedInputStream(context.openFileInput("facebooksdk.monitoring.persistedlogs")));
        } catch (Exception unused) {
            objectInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Collection collection = (Collection) objectInputStream.readObject();
            AbstractC2056E.m4535d(objectInputStream);
            try {
                context.getFileStreamPath("facebooksdk.monitoring.persistedlogs").delete();
            } catch (Exception unused2) {
            }
            arrayList = collection;
        } catch (Exception unused3) {
            AbstractC2056E.m4535d(objectInputStream);
            try {
                context.getFileStreamPath("facebooksdk.monitoring.persistedlogs").delete();
            } catch (Exception unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
            objectInputStream2 = objectInputStream;
            AbstractC2056E.m4535d(objectInputStream2);
            try {
                context.getFileStreamPath("facebooksdk.monitoring.persistedlogs").delete();
            } catch (Exception unused5) {
            }
            throw th;
        }
        LinkedList linkedList = (LinkedList) this.f530a.f534f;
        if (arrayList != null) {
            linkedList.addAll(arrayList);
        }
        linkedList.size();
        C0221e c0221e = this.f530a;
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet2 = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        if (!AbstractC2056E.m4550s(AbstractC1117n.f3877c)) {
            while (!((LinkedList) c0221e.f534f).isEmpty()) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < 100 && !((LinkedList) c0221e.f534f).isEmpty(); i3++) {
                    AbstractC0032g.m162t(((LinkedList) c0221e.f534f).poll());
                    arrayList3.add(null);
                }
                HashSet hashSet3 = AbstractC1117n.f3875a;
                AbstractC2069g.m4584h();
                String packageName = AbstractC1117n.f3882h.getPackageName();
                JSONArray jSONArray = new JSONArray();
                Iterator it = arrayList3.iterator();
                if (it.hasNext()) {
                    AbstractC0032g.m162t(it.next());
                    throw null;
                }
                if (jSONArray.length() == 0) {
                    c1125vM2913l = null;
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("device_os_version", f528d);
                        jSONObject.put("device_model", f529e);
                        jSONObject.put("unique_application_identifier", packageName);
                        jSONObject.put("entries", jSONArray.toString());
                        AbstractC2069g.m4584h();
                        c1125vM2913l = C1125v.m2913l(null, AbstractC1117n.f3877c + "/monitorings", jSONObject, null);
                    } catch (JSONException unused6) {
                        c1125vM2913l = null;
                    }
                }
                if (c1125vM2913l != null) {
                    arrayList2.add(c1125vM2913l);
                }
            }
        }
        try {
            C1125v.m2910g(new C1127x(arrayList2));
        } catch (Exception unused7) {
        }
    }
}

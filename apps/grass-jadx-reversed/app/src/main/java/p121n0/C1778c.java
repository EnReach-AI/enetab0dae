package p121n0;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;
import p010C0.AbstractC0147a;

/* JADX INFO: renamed from: n0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C1778c {

    /* JADX INFO: renamed from: d */
    public static final CopyOnWriteArraySet f6153d = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: a */
    public String f6154a;

    /* JADX INFO: renamed from: b */
    public List f6155b;

    /* JADX INFO: renamed from: c */
    public String f6156c;

    /* JADX INFO: renamed from: a */
    public static void m3935a(JSONObject jSONObject) {
        if (AbstractC0147a.f354a.contains(C1778c.class)) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("k");
                    String strOptString2 = jSONObjectOptJSONObject.optString("v");
                    if (!strOptString.isEmpty()) {
                        CopyOnWriteArraySet copyOnWriteArraySet = f6153d;
                        List listAsList = Arrays.asList(strOptString.split(","));
                        C1778c c1778c = new C1778c();
                        c1778c.f6154a = next;
                        c1778c.f6155b = listAsList;
                        c1778c.f6156c = strOptString2;
                        copyOnWriteArraySet.add(c1778c);
                    }
                }
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1778c.class);
        }
    }

    /* JADX INFO: renamed from: b */
    public static HashSet m3936b() {
        if (AbstractC0147a.f354a.contains(C1778c.class)) {
            return null;
        }
        try {
            HashSet hashSet = new HashSet();
            Iterator it = f6153d.iterator();
            while (it.hasNext()) {
                hashSet.add(((C1778c) it.next()).m3938c());
            }
            return hashSet;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1778c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static HashSet m3937d() {
        if (AbstractC0147a.f354a.contains(C1778c.class)) {
            return null;
        }
        try {
            return new HashSet(f6153d);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1778c.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public final String m3938c() {
        if (AbstractC0147a.f354a.contains(this)) {
            return null;
        }
        try {
            return this.f6154a;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
            return null;
        }
    }
}

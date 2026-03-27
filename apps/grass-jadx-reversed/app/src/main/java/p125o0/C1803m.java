package p125o0;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.emoji2.text.C0906m;
import androidx.emoji2.text.C0910q;
import com.facebook.AbstractC1117n;
import com.facebook.C1104a;
import com.facebook.C1125v;
import com.facebook.C1128y;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p012D.InterfaceMenuItemC0174a;
import p021G.RunnableC0224a;
import p026I.C0296d;
import p039M0.AbstractC0493h0;
import p052R.C0603a;
import p052R.C0604b;
import p089d2.C1318l;
import p089d2.InterfaceC1312f;
import p089d2.InterfaceC1317k;
import p105i.AbstractC1434b;
import p105i.C1439g;
import p105i.InterfaceC1433a;
import p108j.MenuC1463C;
import p108j.MenuC1479m;
import p108j.MenuItemC1486t;
import p128p.C1808b;
import p128p.C1811e;
import p128p.C1817k;
import p166z0.AbstractC2069g;
import p166z0.C2085w;

/* JADX INFO: renamed from: o0.m */
/* JADX INFO: loaded from: classes.dex */
public final class C1803m implements InterfaceC1312f, InterfaceC1433a {

    /* JADX INFO: renamed from: e */
    public Object f6219e;

    /* JADX INFO: renamed from: f */
    public Object f6220f;

    /* JADX INFO: renamed from: g */
    public Object f6221g;

    /* JADX INFO: renamed from: h */
    public Object f6222h;

    public C1803m(int i3) {
        switch (i3) {
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                this.f6220f = new C0296d(10);
                this.f6221g = new C1817k();
                this.f6222h = new ArrayList();
                this.f6219e = new HashSet();
                break;
            default:
                this.f6220f = new C1808b();
                this.f6221g = new SparseArray();
                this.f6222h = new C1811e();
                this.f6219e = new C1808b();
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m3996b() {
        if (AbstractC0147a.f354a.contains(C1803m.class)) {
            return null;
        }
        return "o0.m";
    }

    /* JADX INFO: renamed from: h */
    public static Timer m3997h(C1803m c1803m) {
        if (AbstractC0147a.f354a.contains(C1803m.class)) {
            return null;
        }
        try {
            return (Timer) c1803m.f6222h;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1803m.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: i */
    public static C1125v m3998i(String str, C1104a c1104a, String str2) {
        String str3;
        if (AbstractC0147a.f354a.contains(C1803m.class) || str == null) {
            return null;
        }
        try {
            Locale locale = Locale.US;
            C1125v c1125vM2913l = C1125v.m2913l(c1104a, str2 + "/app_indexing", null, null);
            Bundle bundle = c1125vM2913l.f3907e;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString("tree", str);
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            Context context = AbstractC1117n.f3882h;
            try {
                str3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                str3 = "";
            }
            bundle.putString("app_version", str3);
            bundle.putString("platform", "android");
            bundle.putString("request_type", "app_indexing");
            bundle.putString("device_session_id", AbstractC1795e.m3958a());
            c1125vM2913l.f3907e = bundle;
            c1125vM2913l.m2927s(new C1802l());
            return c1125vM2913l;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, C1803m.class);
            return null;
        }
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: a */
    public boolean mo41a(AbstractC1434b abstractC1434b, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f6220f).onActionItemClicked(m4001l(abstractC1434b), new MenuItemC1486t((Context) this.f6221g, (InterfaceMenuItemC0174a) menuItem));
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: c */
    public boolean mo43c(AbstractC1434b abstractC1434b, MenuC1479m menuC1479m) {
        C1439g c1439gM4001l = m4001l(abstractC1434b);
        C1817k c1817k = (C1817k) this.f6219e;
        Menu menuC1463C = (Menu) c1817k.getOrDefault(menuC1479m, null);
        if (menuC1463C == null) {
            menuC1463C = new MenuC1463C((Context) this.f6221g, menuC1479m);
            c1817k.put(menuC1479m, menuC1463C);
        }
        return ((ActionMode.Callback) this.f6220f).onCreateActionMode(c1439gM4001l, menuC1463C);
    }

    @Override // p089d2.InterfaceC1312f
    /* JADX INFO: renamed from: d */
    public InterfaceC1317k mo3283d() {
        return C1318l.f4678e;
    }

    @Override // p089d2.InterfaceC1312f
    /* JADX INFO: renamed from: e */
    public void mo3284e(Object obj) {
        this.f6222h = null;
        this.f6219e = obj;
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: f */
    public boolean mo46f(AbstractC1434b abstractC1434b, Menu menu) {
        C1439g c1439gM4001l = m4001l(abstractC1434b);
        C1817k c1817k = (C1817k) this.f6219e;
        Menu menuC1463C = (Menu) c1817k.getOrDefault(menu, null);
        if (menuC1463C == null) {
            menuC1463C = new MenuC1463C((Context) this.f6221g, (MenuC1479m) menu);
            c1817k.put(menu, menuC1463C);
        }
        return ((ActionMode.Callback) this.f6220f).onPrepareActionMode(c1439gM4001l, menuC1463C);
    }

    @Override // p105i.InterfaceC1433a
    /* JADX INFO: renamed from: g */
    public void mo47g(AbstractC1434b abstractC1434b) {
        ((ActionMode.Callback) this.f6220f).onDestroyActionMode(m4001l(abstractC1434b));
    }

    /* JADX INFO: renamed from: j */
    public C1803m m3999j() {
        return new C1803m(this.f6220f);
    }

    /* JADX INFO: renamed from: k */
    public void m4000k(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((C1817k) this.f6221g).getOrDefault(obj, null);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i3 = 0; i3 < size; i3++) {
                m4000k(arrayList2.get(i3), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: l */
    public C1439g m4001l(AbstractC1434b abstractC1434b) {
        ArrayList arrayList = (ArrayList) this.f6222h;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C1439g c1439g = (C1439g) arrayList.get(i3);
            if (c1439g != null && c1439g.f5092b == abstractC1434b) {
                return c1439g;
            }
        }
        C1439g c1439g2 = new C1439g((Context) this.f6221g, abstractC1434b);
        arrayList.add(c1439g2);
        return c1439g2;
    }

    /* JADX INFO: renamed from: m */
    public boolean m4002m(String str) {
        String str2 = (String) this.f6219e;
        if (str2 == null) {
            this.f6219e = str;
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        String str3 = (String) this.f6221g;
        if (str3 == null) {
            this.f6221g = str;
            return false;
        }
        if (str.equals(str3)) {
            return true;
        }
        if (((HashSet) this.f6222h) == null) {
            HashSet hashSet = new HashSet(16);
            this.f6222h = hashSet;
            hashSet.add((String) this.f6219e);
            ((HashSet) this.f6222h).add((String) this.f6221g);
        }
        return !((HashSet) this.f6222h).add(str);
    }

    /* JADX INFO: renamed from: n */
    public void m4003n(C1125v c1125v, String str) {
        Set set = AbstractC0147a.f354a;
        if (set.contains(this) || c1125v == null) {
            return;
        }
        try {
            C1128y c1128yM2923d = c1125v.m2923d();
            try {
                JSONObject jSONObject = c1128yM2923d.f3920b;
                if (jSONObject == null) {
                    Log.e("o0.m", "Error sending UI component tree to Facebook: " + c1128yM2923d.f3921c);
                    return;
                }
                if ("true".equals(jSONObject.optString("success"))) {
                    HashMap map = C2085w.f7377b;
                    AbstractC1117n.m2896f();
                    this.f6219e = str;
                }
                if (jSONObject.has("is_app_indexing_enabled")) {
                    boolean z3 = jSONObject.getBoolean("is_app_indexing_enabled");
                    if (set.contains(AbstractC1795e.class)) {
                        return;
                    }
                    try {
                        AbstractC1795e.f6198f.set(z3);
                    } catch (Throwable th) {
                        AbstractC0147a.m295a(th, AbstractC1795e.class);
                    }
                }
            } catch (JSONException e3) {
                Log.e("o0.m", "Error decoding server response.", e3);
            }
        } catch (Throwable th2) {
            AbstractC0147a.m295a(th2, this);
        }
    }

    /* JADX INFO: renamed from: o */
    public void m4004o() {
        if (AbstractC0147a.f354a.contains(this)) {
            return;
        }
        try {
            try {
                AbstractC1117n.m2891a().execute(new RunnableC0224a(this, new C1801k(this), 5, false));
            } catch (RejectedExecutionException e3) {
                Log.e("o0.m", "Error scheduling indexing job", e3);
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, this);
        }
    }

    public C1803m(Object obj) {
        this.f6220f = obj;
    }

    public C1803m(Typeface typeface, C0604b c0604b) {
        int i3;
        int i4;
        this.f6219e = typeface;
        this.f6220f = c0604b;
        this.f6222h = new C0910q(1024);
        int iM843a = c0604b.m843a(6);
        if (iM843a != 0) {
            int i5 = iM843a + c0604b.f885a;
            i3 = ((ByteBuffer) c0604b.f888d).getInt(((ByteBuffer) c0604b.f888d).getInt(i5) + i5);
        } else {
            i3 = 0;
        }
        this.f6221g = new char[i3 * 2];
        int iM843a2 = c0604b.m843a(6);
        if (iM843a2 != 0) {
            int i6 = iM843a2 + c0604b.f885a;
            i4 = ((ByteBuffer) c0604b.f888d).getInt(((ByteBuffer) c0604b.f888d).getInt(i6) + i6);
        } else {
            i4 = 0;
        }
        for (int i7 = 0; i7 < i4; i7++) {
            C0906m c0906m = new C0906m(this, i7);
            C0603a c0603aM2350c = c0906m.m2350c();
            int iM843a3 = c0603aM2350c.m843a(4);
            Character.toChars(iM843a3 != 0 ? ((ByteBuffer) c0603aM2350c.f888d).getInt(iM843a3 + c0603aM2350c.f885a) : 0, (char[]) this.f6221g, i7 * 2);
            AbstractC0493h0.m1008a("invalid metadata codepoint length", c0906m.m2349b() > 0);
            ((C0910q) this.f6222h).m2357a(c0906m, 0, c0906m.m2349b() - 1);
        }
    }
}

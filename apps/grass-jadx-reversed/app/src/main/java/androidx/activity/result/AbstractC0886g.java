package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.C0986s;
import androidx.lifecycle.EnumC0978k;
import androidx.lifecycle.EnumC0979l;
import androidx.lifecycle.InterfaceC0982o;
import androidx.lifecycle.InterfaceC0984q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import p033K0.AbstractC0406d;

/* JADX INFO: renamed from: androidx.activity.result.g */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0886g {

    /* JADX INFO: renamed from: a */
    public Random f2637a = new Random();

    /* JADX INFO: renamed from: b */
    public final HashMap f2638b = new HashMap();

    /* JADX INFO: renamed from: c */
    public final HashMap f2639c = new HashMap();

    /* JADX INFO: renamed from: d */
    public final HashMap f2640d = new HashMap();

    /* JADX INFO: renamed from: e */
    public ArrayList f2641e = new ArrayList();

    /* JADX INFO: renamed from: f */
    public final transient HashMap f2642f = new HashMap();

    /* JADX INFO: renamed from: g */
    public final HashMap f2643g = new HashMap();

    /* JADX INFO: renamed from: h */
    public final Bundle f2644h = new Bundle();

    /* JADX INFO: renamed from: a */
    public final boolean m2214a(int i3, int i4, Intent intent) {
        InterfaceC0882c interfaceC0882c;
        String str = (String) this.f2638b.get(Integer.valueOf(i3));
        if (str == null) {
            return false;
        }
        C0884e c0884e = (C0884e) this.f2642f.get(str);
        if (c0884e == null || (interfaceC0882c = c0884e.f2633a) == null || !this.f2641e.contains(str)) {
            this.f2643g.remove(str);
            this.f2644h.putParcelable(str, new C0881b(i4, intent));
            return true;
        }
        interfaceC0882c.mo449j(c0884e.f2634b.mo909j(i4, intent));
        this.f2641e.remove(str);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo2194b(int i3, AbstractC0406d abstractC0406d, Object obj);

    /* JADX INFO: renamed from: c */
    public final C0883d m2215c(String str, AbstractC0406d abstractC0406d, InterfaceC0882c interfaceC0882c) {
        m2217e(str);
        this.f2642f.put(str, new C0884e(abstractC0406d, interfaceC0882c));
        HashMap map = this.f2643g;
        if (map.containsKey(str)) {
            Object obj = map.get(str);
            map.remove(str);
            interfaceC0882c.mo449j(obj);
        }
        Bundle bundle = this.f2644h;
        C0881b c0881b = (C0881b) bundle.getParcelable(str);
        if (c0881b != null) {
            bundle.remove(str);
            interfaceC0882c.mo449j(abstractC0406d.mo909j(c0881b.f2627e, c0881b.f2628f));
        }
        return new C0883d(this, str, abstractC0406d, 1);
    }

    /* JADX INFO: renamed from: d */
    public final C0883d m2216d(final String str, InterfaceC0984q interfaceC0984q, final AbstractC0406d abstractC0406d, final InterfaceC0882c interfaceC0882c) {
        C0986s c0986sMo2199d = interfaceC0984q.mo2199d();
        if (c0986sMo2199d.f3328b.m2513a(EnumC0979l.f3321h)) {
            throw new IllegalStateException("LifecycleOwner " + interfaceC0984q + " is attempting to register while current state is " + c0986sMo2199d.f3328b + ". LifecycleOwners must call register before they are STARTED.");
        }
        m2217e(str);
        HashMap map = this.f2640d;
        C0885f c0885f = (C0885f) map.get(str);
        if (c0885f == null) {
            c0885f = new C0885f(c0986sMo2199d);
        }
        InterfaceC0982o interfaceC0982o = new InterfaceC0982o() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.InterfaceC0982o
            /* JADX INFO: renamed from: b */
            public final void mo2170b(InterfaceC0984q interfaceC0984q2, EnumC0978k enumC0978k) {
                boolean zEquals = EnumC0978k.ON_START.equals(enumC0978k);
                String str2 = str;
                AbstractC0886g abstractC0886g = this.f2625d;
                if (!zEquals) {
                    if (EnumC0978k.ON_STOP.equals(enumC0978k)) {
                        abstractC0886g.f2642f.remove(str2);
                        return;
                    } else {
                        if (EnumC0978k.ON_DESTROY.equals(enumC0978k)) {
                            abstractC0886g.m2218f(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap map2 = abstractC0886g.f2642f;
                InterfaceC0882c interfaceC0882c2 = interfaceC0882c;
                AbstractC0406d abstractC0406d2 = abstractC0406d;
                map2.put(str2, new C0884e(abstractC0406d2, interfaceC0882c2));
                HashMap map3 = abstractC0886g.f2643g;
                if (map3.containsKey(str2)) {
                    Object obj = map3.get(str2);
                    map3.remove(str2);
                    interfaceC0882c2.mo449j(obj);
                }
                Bundle bundle = abstractC0886g.f2644h;
                C0881b c0881b = (C0881b) bundle.getParcelable(str2);
                if (c0881b != null) {
                    bundle.remove(str2);
                    interfaceC0882c2.mo449j(abstractC0406d2.mo909j(c0881b.f2627e, c0881b.f2628f));
                }
            }
        };
        c0885f.f2635a.m2515a(interfaceC0982o);
        c0885f.f2636b.add(interfaceC0982o);
        map.put(str, c0885f);
        return new C0883d(this, str, abstractC0406d, 0);
    }

    /* JADX INFO: renamed from: e */
    public final void m2217e(String str) {
        HashMap map = this.f2639c;
        if (((Integer) map.get(str)) != null) {
            return;
        }
        int iNextInt = this.f2637a.nextInt(2147418112);
        while (true) {
            int i3 = iNextInt + 65536;
            HashMap map2 = this.f2638b;
            if (!map2.containsKey(Integer.valueOf(i3))) {
                map2.put(Integer.valueOf(i3), str);
                map.put(str, Integer.valueOf(i3));
                return;
            }
            iNextInt = this.f2637a.nextInt(2147418112);
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m2218f(String str) {
        Integer num;
        if (!this.f2641e.contains(str) && (num = (Integer) this.f2639c.remove(str)) != null) {
            this.f2638b.remove(num);
        }
        this.f2642f.remove(str);
        HashMap map = this.f2643g;
        if (map.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + map.get(str));
            map.remove(str);
        }
        Bundle bundle = this.f2644h;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + bundle.getParcelable(str));
            bundle.remove(str);
        }
        HashMap map2 = this.f2640d;
        C0885f c0885f = (C0885f) map2.get(str);
        if (c0885f != null) {
            ArrayList arrayList = c0885f.f2636b;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c0885f.f2635a.m2520f((InterfaceC0982o) it.next());
            }
            arrayList.clear();
            map2.remove(str);
        }
    }
}

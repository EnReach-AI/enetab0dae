package p019F0;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.emoji2.text.C0902i;
import com.facebook.AbstractC1117n;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p018F.AbstractC0215g;
import p018F.AbstractC0216h;
import p036L0.C0444d;
import p110k.C1605n;
import p117m0.AbstractC1708c;
import p117m0.AbstractC1715j;
import p117m0.AbstractC1717l;
import p117m0.AbstractC1725t;
import p117m0.C1707b;
import p117m0.C1718m;
import p121n0.AbstractC1776a;
import p137r0.AbstractC1852a;
import p141s0.AbstractC1874d;
import p141s0.AbstractC1883m;
import p141s0.AbstractC1884n;
import p144t0.AbstractC1918d;
import p156w0.AbstractC1989d;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2077o;
import p166z0.AbstractC2078p;
import p166z0.AbstractC2082t;
import p166z0.AbstractC2087y;
import p166z0.C2064b;
import p166z0.C2086x;
import p166z0.EnumC2076n;

/* JADX INFO: renamed from: F0.b */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0218b implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f523e;

    public /* synthetic */ RunnableC0218b(int i3) {
        this.f523e = i3;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Override // java.lang.Runnable
    public final void run() {
        Set setKeySet;
        ConcurrentHashMap concurrentHashMap;
        SharedPreferences sharedPreferences;
        AtomicBoolean atomicBoolean;
        ArrayList arrayList;
        Set set = null;
        jSONObjectM4274d = null;
        atomicBoolean = null;
        atomicBoolean = null;
        atomicBoolean = null;
        AtomicBoolean atomicBoolean2 = null;
        AtomicBoolean atomicBoolean3 = null;
        AtomicBoolean atomicBoolean4 = null;
        JSONObject jSONObjectM4274d = null;
        set = null;
        switch (this.f523e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    JSONObject jSONObjectM435a = AbstractC0219c.m435a();
                    if (jSONObjectM435a != null) {
                        AbstractC0219c.m436b(jSONObjectM435a);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    AbstractC0147a.m295a(th, this);
                    return;
                }
            case 1:
                try {
                    int i3 = AbstractC0216h.f520a;
                    AbstractC0215g.m424a("EmojiCompat.EmojiCompatInitializer.run");
                    if (C0902i.f2971j != null) {
                        C0902i.m2341a().m2343c();
                        break;
                    }
                    AbstractC0215g.m425b();
                    return;
                } catch (Throwable th2) {
                    int i4 = AbstractC0216h.f520a;
                    AbstractC0215g.m425b();
                    throw th2;
                }
            case 2:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    AbstractC1708c.m3789a();
                    return;
                } catch (Throwable th3) {
                    AbstractC0147a.m295a(th3, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                Set set2 = AbstractC0147a.f354a;
                if (set2.contains(this)) {
                    return;
                }
                try {
                    if (!set2.contains(AbstractC1715j.class)) {
                        try {
                            AbstractC1715j.f5998c = null;
                        } catch (Throwable th4) {
                            AbstractC0147a.m295a(th4, AbstractC1715j.class);
                        }
                        break;
                    }
                    if (C1718m.m3810a() != 2) {
                        AbstractC1715j.m3796e(2);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    AbstractC0147a.m295a(th5, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                Set set3 = AbstractC0147a.f354a;
                if (set3.contains(this)) {
                    return;
                }
                try {
                    AbstractC1717l.m3805h(AbstractC1715j.m3792a());
                    C0444d c0444d = new C0444d(21);
                    if (set3.contains(AbstractC1715j.class)) {
                        return;
                    }
                    try {
                        AbstractC1715j.f5996a = c0444d;
                        return;
                    } catch (Throwable th6) {
                        AbstractC0147a.m295a(th6, AbstractC1715j.class);
                        return;
                    }
                } catch (Throwable th7) {
                    AbstractC0147a.m295a(th7, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                Set set4 = AbstractC0147a.f354a;
                if (set4.contains(this)) {
                    return;
                }
                try {
                    HashSet hashSet = new HashSet();
                    C0444d c0444d2 = AbstractC1715j.f5996a;
                    if (!set4.contains(AbstractC1715j.class)) {
                        try {
                            C0444d c0444d3 = AbstractC1715j.f5996a;
                            synchronized (c0444d3) {
                                setKeySet = ((HashMap) c0444d3.f1085e).keySet();
                            }
                            set = setKeySet;
                        } catch (Throwable th8) {
                            AbstractC0147a.m295a(th8, AbstractC1715j.class);
                        }
                    }
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(((C1707b) it.next()).f5975f);
                    }
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        AbstractC2082t.m4625f((String) it2.next(), true);
                    }
                    return;
                } catch (Throwable th9) {
                    AbstractC0147a.m295a(th9, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                Set set5 = AbstractC0147a.f354a;
                if (set5.contains(this)) {
                    return;
                }
                try {
                    if (!AbstractC1725t.m3829a().get()) {
                        Log.w(set5.contains(AbstractC1725t.class) ? null : "t", "initStore should have been called before calling setUserData");
                        AbstractC1725t.m3830b();
                    }
                    if (!AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
                        try {
                            concurrentHashMap = AbstractC1725t.f6019c;
                        } catch (Throwable th10) {
                            AbstractC0147a.m295a(th10, AbstractC1725t.class);
                            concurrentHashMap = null;
                        }
                        break;
                    } else {
                        concurrentHashMap = null;
                    }
                    concurrentHashMap.clear();
                    if (!AbstractC0147a.f354a.contains(AbstractC1725t.class)) {
                        try {
                            sharedPreferences = AbstractC1725t.f6017a;
                        } catch (Throwable th11) {
                            AbstractC0147a.m295a(th11, AbstractC1725t.class);
                            sharedPreferences = null;
                        }
                        break;
                    } else {
                        sharedPreferences = null;
                    }
                    sharedPreferences.edit().putString("com.facebook.appevents.UserDataStore.userData", null).apply();
                    return;
                } catch (Throwable th12) {
                    AbstractC0147a.m295a(th12, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                Set set6 = AbstractC0147a.f354a;
                if (set6.contains(this)) {
                    return;
                }
                try {
                    HashSet hashSet2 = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    C2064b c2064bM4569b = C2064b.m4569b(AbstractC1117n.f3882h);
                    if (c2064bM4569b == null || !c2064bM4569b.f7299d) {
                        if (!set6.contains(AbstractC1776a.class)) {
                            try {
                                AbstractC1776a.m3931a();
                            } catch (Throwable th13) {
                                AbstractC0147a.m295a(th13, AbstractC1776a.class);
                            }
                        }
                        Boolean bool = Boolean.TRUE;
                        if (AbstractC0147a.f354a.contains(AbstractC1776a.class)) {
                            return;
                        }
                        try {
                            AbstractC1776a.f6152a = bool;
                            return;
                        } catch (Throwable th14) {
                            AbstractC0147a.m295a(th14, AbstractC1776a.class);
                            return;
                        }
                        break;
                    }
                    return;
                } catch (Throwable th15) {
                    AbstractC0147a.m295a(th15, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    if (AbstractC1874d.f6604e == null) {
                        AbstractC1874d.f6604e = C1605n.m3668c();
                        return;
                    }
                    return;
                } catch (Throwable th16) {
                    AbstractC0147a.m295a(th16, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    HashSet hashSet3 = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    Context context = AbstractC1117n.f3882h;
                    AbstractC1883m.m4203a(context, AbstractC1884n.m4205a(AbstractC1884n.m4208d(context, AbstractC1883m.f6624g, "inapp")), false);
                    AbstractC1883m.m4203a(context, AbstractC1884n.m4205a(AbstractC1884n.m4208d(context, AbstractC1883m.f6624g, "subs")), true);
                    return;
                } catch (Throwable th17) {
                    AbstractC0147a.m295a(th17, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    HashSet hashSet4 = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    Context context2 = AbstractC1117n.f3882h;
                    ArrayList arrayListM4205a = AbstractC1884n.m4205a(AbstractC1884n.m4208d(context2, AbstractC1883m.f6624g, "inapp"));
                    if (arrayListM4205a.isEmpty()) {
                        arrayListM4205a = AbstractC1884n.m4207c(context2, AbstractC1883m.f6624g);
                    }
                    AbstractC1883m.m4203a(context2, arrayListM4205a, false);
                    return;
                } catch (Throwable th18) {
                    AbstractC0147a.m295a(th18, this);
                    return;
                }
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                Set set7 = AbstractC0147a.f354a;
                if (set7.contains(this)) {
                    return;
                }
                try {
                    HashSet hashSet5 = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    SharedPreferences sharedPreferences2 = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.internal.MODEL_STORE", 0);
                    String string = sharedPreferences2.getString("models", null);
                    JSONObject jSONObject = (string == null || string.isEmpty()) ? new JSONObject() : new JSONObject(string);
                    long j2 = sharedPreferences2.getLong("model_request_timestamp", 0L);
                    if (!AbstractC2077o.m4613b(EnumC2076n.ModelRequest) || jSONObject.length() == 0 || !AbstractC1918d.m4271a(j2)) {
                        if (!set7.contains(AbstractC1918d.class)) {
                            try {
                                jSONObjectM4274d = AbstractC1918d.m4274d();
                            } catch (Throwable th19) {
                                AbstractC0147a.m295a(th19, AbstractC1918d.class);
                            }
                        }
                        if (jSONObjectM4274d == null) {
                            return;
                        }
                        sharedPreferences2.edit().putString("models", jSONObjectM4274d.toString()).putLong("model_request_timestamp", System.currentTimeMillis()).apply();
                        jSONObject = jSONObjectM4274d;
                    }
                    AbstractC1918d.m4272b(jSONObject);
                    if (AbstractC0147a.f354a.contains(AbstractC1918d.class)) {
                        return;
                    }
                    try {
                        AbstractC1918d.m4273c();
                        return;
                    } catch (Throwable th20) {
                        AbstractC0147a.m295a(th20, AbstractC1918d.class);
                        return;
                    }
                } catch (Exception unused) {
                    return;
                } catch (Throwable th21) {
                    AbstractC0147a.m295a(th21, this);
                    return;
                }
                break;
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                if (AbstractC0147a.f354a.contains(this)) {
                    return;
                }
                try {
                    AbstractC1989d.m4401a();
                    return;
                } catch (Throwable th22) {
                    AbstractC0147a.m295a(th22, this);
                    return;
                }
            case 13:
                Set set8 = AbstractC0147a.f354a;
                if (set8.contains(this)) {
                    return;
                }
                try {
                    if (set8.contains(AbstractC1852a.class)) {
                        return;
                    }
                    try {
                        AbstractC1852a.f6422a = true;
                        HashSet hashSet6 = AbstractC1117n.f3875a;
                        AbstractC2069g.m4584h();
                        AbstractC1852a.f6423b = AbstractC2078p.m4615b("FBSDKFeatureIntegritySample", AbstractC1117n.f3877c, false);
                        return;
                    } catch (Throwable th23) {
                        AbstractC0147a.m295a(th23, AbstractC1852a.class);
                        return;
                    }
                } catch (Throwable th24) {
                    AbstractC0147a.m295a(th24, this);
                    return;
                }
            case 14:
                Set set9 = AbstractC0147a.f354a;
                if (set9.contains(this)) {
                    return;
                }
                try {
                    if (set9.contains(AbstractC1989d.class)) {
                        atomicBoolean = null;
                    } else {
                        try {
                            atomicBoolean = AbstractC1989d.f7055a;
                        } catch (Throwable th25) {
                            AbstractC0147a.m295a(th25, AbstractC1989d.class);
                            atomicBoolean = null;
                        }
                    }
                    if (atomicBoolean.get()) {
                        return;
                    }
                    if (!AbstractC0147a.f354a.contains(AbstractC1989d.class)) {
                        try {
                            atomicBoolean4 = AbstractC1989d.f7055a;
                        } catch (Throwable th26) {
                            AbstractC0147a.m295a(th26, AbstractC1989d.class);
                        }
                    }
                    atomicBoolean4.set(true);
                    if (set9.contains(AbstractC1989d.class)) {
                        return;
                    }
                    try {
                        AbstractC1989d.m4402b();
                        return;
                    } catch (Throwable th27) {
                        AbstractC0147a.m295a(th27, AbstractC1989d.class);
                        return;
                    }
                } catch (Throwable th28) {
                    AbstractC0147a.m295a(th28, this);
                    return;
                }
                break;
            default:
                Set set10 = AbstractC0147a.f354a;
                if (set10.contains(this)) {
                    return;
                }
                try {
                    try {
                        if (!set10.contains(AbstractC2087y.class)) {
                            try {
                                arrayList = AbstractC2087y.f7381a;
                            } catch (Throwable th29) {
                                AbstractC0147a.m295a(th29, AbstractC2087y.class);
                                arrayList = null;
                            }
                            break;
                        } else {
                            arrayList = null;
                        }
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            ((C2086x) it3.next()).m4629a(true);
                            break;
                        }
                        if (!AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
                            try {
                                atomicBoolean2 = AbstractC2087y.f7382b;
                            } catch (Throwable th30) {
                                AbstractC0147a.m295a(th30, AbstractC2087y.class);
                            }
                            break;
                        }
                        atomicBoolean2.set(false);
                        return;
                    } catch (Throwable th31) {
                        AbstractC0147a.m295a(th31, this);
                        return;
                    }
                } catch (Throwable th32) {
                    if (!AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
                        try {
                            atomicBoolean3 = AbstractC2087y.f7382b;
                        } catch (Throwable th33) {
                            AbstractC0147a.m295a(th33, AbstractC2087y.class);
                        }
                        break;
                    }
                    atomicBoolean3.set(false);
                    throw th32;
                }
        }
    }
}

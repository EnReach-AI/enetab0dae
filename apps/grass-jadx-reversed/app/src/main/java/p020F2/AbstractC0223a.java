package p020F2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import com.fasterxml.jackson.databind.deser.C1207w;
import com.fasterxml.jackson.databind.deser.impl.C1156h;
import com.fasterxml.jackson.databind.deser.impl.C1157i;
import com.fasterxml.jackson.databind.deser.impl.C1158j;
import com.fasterxml.jackson.databind.deser.impl.C1159k;
import com.fasterxml.jackson.databind.deser.std.C1189e;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import p002A0.C0021c;
import p002A0.EnumC0020b;
import p033K0.AbstractC0406d;
import p042N0.C0541i;
import p162y.AbstractC2028g;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2077o;
import p166z0.EnumC2076n;

/* JADX INFO: renamed from: F2.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0223a {

    /* JADX INFO: renamed from: a */
    public static boolean f537a = false;

    /* JADX INFO: renamed from: a */
    public static Object m464a(Class cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(AbstractC0223a.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* JADX INFO: renamed from: b */
    public static void m465b(Throwable th) {
        HashMap map;
        EnumC2076n enumC2076n;
        if (f537a) {
            HashSet hashSet = new HashSet();
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                HashMap map2 = AbstractC2077o.f7345a;
                synchronized (AbstractC2077o.class) {
                    map = AbstractC2077o.f7345a;
                    if (map.isEmpty()) {
                        map.put(EnumC2076n.AAM, new String[]{"com.facebook.appevents.aam."});
                        map.put(EnumC2076n.CodelessEvents, new String[]{"com.facebook.appevents.codeless."});
                        map.put(EnumC2076n.ErrorReport, new String[]{"com.facebook.internal.instrument.errorreport."});
                        map.put(EnumC2076n.PrivacyProtection, new String[]{"com.facebook.appevents.ml."});
                        map.put(EnumC2076n.SuggestedEvents, new String[]{"com.facebook.appevents.suggestedevents."});
                        map.put(EnumC2076n.RestrictiveDataFiltering, new String[]{"com.facebook.appevents.restrictivedatafilter.RestrictiveDataManager"});
                        map.put(EnumC2076n.IntelligentIntegrity, new String[]{"com.facebook.appevents.integrity.IntegrityManager"});
                        map.put(EnumC2076n.EventDeactivation, new String[]{"com.facebook.appevents.eventdeactivation."});
                        map.put(EnumC2076n.OnDeviceEventProcessing, new String[]{"com.facebook.appevents.ondeviceprocessing."});
                        map.put(EnumC2076n.Monitoring, new String[]{"com.facebook.internal.logging.monitor"});
                    }
                }
                Iterator it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        enumC2076n = EnumC2076n.Unknown;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    for (String str : (String[]) entry.getValue()) {
                        if (className.startsWith(str)) {
                            enumC2076n = (EnumC2076n) entry.getKey();
                            break;
                        }
                    }
                }
                if (enumC2076n != EnumC2076n.Unknown) {
                    HashSet hashSet2 = AbstractC1117n.f3875a;
                    AbstractC2069g.m4584h();
                    AbstractC1117n.f3882h.getSharedPreferences("com.facebook.internal.FEATURE_MANAGER", 0).edit().putString("FBSDKFeature".concat(enumC2076n.toString()), "8.2.0").apply();
                    hashSet.add(enumC2076n.toString());
                }
            }
            HashSet hashSet3 = AbstractC1117n.f3875a;
            if (!AbstractC1103F.m2866c() || hashSet.isEmpty()) {
                return;
            }
            JSONArray jSONArray = new JSONArray((Collection) hashSet);
            C0021c c0021c = new C0021c();
            c0021c.f66b = EnumC0020b.f60f;
            Long lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
            c0021c.f71g = lValueOf;
            c0021c.f67c = jSONArray;
            StringBuffer stringBuffer = new StringBuffer("analysis_log_");
            stringBuffer.append(lValueOf.toString());
            stringBuffer.append(".json");
            c0021c.f65a = stringBuffer.toString();
            if (c0021c.m75a()) {
                AbstractC0406d.m906p(c0021c.f65a, c0021c.toString());
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static C1207w m466c(Class cls) {
        if (cls == C0541i.class) {
            return new C1189e(C0541i.class);
        }
        if (Collection.class.isAssignableFrom(cls)) {
            if (cls == ArrayList.class) {
                return C1156h.f4005f;
            }
            Set set = Collections.EMPTY_SET;
            if (set.getClass() == cls) {
                return new C1157i(set);
            }
            List list = Collections.EMPTY_LIST;
            if (list.getClass() == cls) {
                return new C1157i(list);
            }
            return null;
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (cls == LinkedHashMap.class) {
            return C1159k.f4008f;
        }
        if (cls == HashMap.class) {
            return C1158j.f4007f;
        }
        Map map = Collections.EMPTY_MAP;
        if (map.getClass() == cls) {
            return new C1157i(map);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static Intent m467d(Activity activity) {
        Intent intentM4482a = AbstractC2028g.m4482a(activity);
        if (intentM4482a != null) {
            return intentM4482a;
        }
        try {
            String strM469f = m469f(activity, activity.getComponentName());
            if (strM469f == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, strM469f);
            try {
                return m469f(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strM469f + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    /* JADX INFO: renamed from: e */
    public static Intent m468e(Context context, ComponentName componentName) {
        String strM469f = m469f(context, componentName);
        if (strM469f == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strM469f);
        return m469f(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    /* JADX INFO: renamed from: f */
    public static String m469f(Context context, ComponentName componentName) {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    /* JADX INFO: renamed from: g */
    public static void m470g(String str) {
        if (Log.isLoggable("InstallReferrerClient", 2)) {
            Log.v("InstallReferrerClient", str);
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m471h(String str) {
        if (Log.isLoggable("InstallReferrerClient", 5)) {
            Log.w("InstallReferrerClient", str);
        }
    }
}

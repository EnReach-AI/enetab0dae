package p141s0;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.facebook.AbstractC1103F;
import com.facebook.AbstractC1117n;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import p010C0.AbstractC0147a;
import p036L0.C0444d;
import p117m0.C1718m;
import p166z0.AbstractC2069g;
import p166z0.AbstractC2078p;
import p166z0.AbstractC2082t;
import p166z0.C2071i;
import p166z0.C2079q;

/* JADX INFO: renamed from: s0.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1883m {

    /* JADX INFO: renamed from: a */
    public static final AtomicBoolean f6618a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b */
    public static Boolean f6619b = null;

    /* JADX INFO: renamed from: c */
    public static Boolean f6620c = null;

    /* JADX INFO: renamed from: d */
    public static ServiceConnectionC1882l f6621d;

    /* JADX INFO: renamed from: e */
    public static C1871a f6622e;

    /* JADX INFO: renamed from: f */
    public static Intent f6623f;

    /* JADX INFO: renamed from: g */
    public static Object f6624g;

    /* JADX INFO: renamed from: a */
    public static void m4203a(Context context, ArrayList arrayList, boolean z3) {
        SharedPreferences sharedPreferences;
        C2071i c2071i;
        String strOptString;
        if (arrayList.isEmpty()) {
            return;
        }
        HashMap map = new HashMap();
        ArrayList<String> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                String string = new JSONObject(str).getString("productId");
                map.put(string, str);
                arrayList2.add(string);
            } catch (JSONException e3) {
                Log.e("s0.m", "Error parsing in-app purchase data.", e3);
            }
        }
        Object obj = f6624g;
        HashMap map2 = AbstractC1884n.f6625a;
        HashMap map3 = new HashMap();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it2 = arrayList2.iterator();
        while (true) {
            boolean zHasNext = it2.hasNext();
            sharedPreferences = AbstractC1884n.f6628d;
            if (!zHasNext) {
                break;
            }
            String str2 = (String) it2.next();
            String string2 = sharedPreferences.getString(str2, null);
            if (string2 != null) {
                String[] strArrSplit = string2.split(";", 2);
                if (jCurrentTimeMillis - Long.parseLong(strArrSplit[0]) < 43200) {
                    map3.put(str2, strArrSplit[1]);
                }
            }
        }
        ArrayList<String> arrayList3 = new ArrayList<>();
        for (String str3 : arrayList2) {
            if (!map3.containsKey(str3)) {
                arrayList3.add(str3);
            }
        }
        HashMap map4 = new HashMap();
        if (obj != null && !arrayList3.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            Object objM4209e = AbstractC1884n.m4209e(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, new Object[]{3, AbstractC1884n.f6627c, z3 ? "subs" : "inapp", bundle});
            if (objM4209e != null) {
                Bundle bundle2 = (Bundle) objM4209e;
                if (bundle2.getInt("RESPONSE_CODE") == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList != null && arrayList3.size() == stringArrayList.size()) {
                        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                            map4.put(arrayList3.get(i3), stringArrayList.get(i3));
                        }
                    }
                    long jCurrentTimeMillis2 = System.currentTimeMillis() / 1000;
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    for (Map.Entry entry : map4.entrySet()) {
                        editorEdit.putString((String) entry.getKey(), jCurrentTimeMillis2 + ";" + ((String) entry.getValue()));
                    }
                    editorEdit.apply();
                }
            }
        }
        map3.putAll(map4);
        for (Map.Entry entry2 : map3.entrySet()) {
            String str4 = (String) map.get(entry2.getKey());
            String str5 = (String) entry2.getValue();
            C0444d c0444d = AbstractC1879i.f6614a;
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079qM4621b = AbstractC2082t.m4621b(AbstractC1117n.f3877c);
            if (c2079qM4621b != null && AbstractC1103F.m2866c() && c2079qM4621b.f7355f) {
                HashMap map5 = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject(str4);
                    JSONObject jSONObject2 = new JSONObject(str5);
                    Bundle bundle3 = new Bundle(1);
                    bundle3.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
                    bundle3.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
                    bundle3.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
                    bundle3.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
                    bundle3.putCharSequence("fb_iap_product_title", jSONObject2.optString("title"));
                    bundle3.putCharSequence("fb_iap_product_description", jSONObject2.optString("description"));
                    String strOptString2 = jSONObject2.optString("type");
                    bundle3.putCharSequence("fb_iap_product_type", strOptString2);
                    if (strOptString2.equals("subs")) {
                        bundle3.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                        bundle3.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                        bundle3.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                        String strOptString3 = jSONObject2.optString("introductoryPriceCycles");
                        if (!strOptString3.isEmpty()) {
                            bundle3.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                            bundle3.putCharSequence("fb_intro_price_cycles", strOptString3);
                        }
                    }
                    for (String str6 : map5.keySet()) {
                        bundle3.putCharSequence(str6, (CharSequence) map5.get(str6));
                    }
                    BigDecimal bigDecimal = new BigDecimal(jSONObject2.getLong("price_amount_micros") / 1000000.0d);
                    Currency currency = Currency.getInstance(jSONObject2.getString("price_currency_code"));
                    c2071i = new C2071i();
                    c2071i.f7314a = bigDecimal;
                    c2071i.f7315b = currency;
                    c2071i.f7316c = bundle3;
                } catch (JSONException e4) {
                    Log.e("s0.i", "Error parsing in-app subscription data.", e4);
                    c2071i = null;
                }
                if (c2071i != null) {
                    if (z3) {
                        AbstractC2069g.m4584h();
                        if (AbstractC2078p.m4615b("app_events_if_auto_log_subs", AbstractC1117n.f3877c, false)) {
                            HashMap map6 = AbstractC1884n.f6625a;
                            try {
                                strOptString = new JSONObject(str5).optString("freeTrialPeriod");
                            } catch (JSONException unused) {
                            }
                            String str7 = (strOptString == null || strOptString.isEmpty()) ? "Subscribe" : "StartTrial";
                            String str8 = str7;
                            C0444d c0444d2 = AbstractC1879i.f6614a;
                            BigDecimal bigDecimal2 = (BigDecimal) c2071i.f7314a;
                            Currency currency2 = (Currency) c2071i.f7315b;
                            Bundle bundle4 = (Bundle) c2071i.f7316c;
                            c0444d2.getClass();
                            HashSet hashSet2 = AbstractC1117n.f3875a;
                            if (AbstractC1103F.m2866c()) {
                                C1718m c1718m = (C1718m) c0444d2.f1085e;
                                c1718m.getClass();
                                if (!AbstractC0147a.f354a.contains(c1718m) && bigDecimal2 != null && currency2 != null) {
                                    if (bundle4 == null) {
                                        try {
                                            bundle4 = new Bundle();
                                        } catch (Throwable th) {
                                            AbstractC0147a.m295a(th, c1718m);
                                        }
                                    }
                                    Bundle bundle5 = bundle4;
                                    bundle5.putString("fb_currency", currency2.getCurrencyCode());
                                    c1718m.m3816e(str8, Double.valueOf(bigDecimal2.doubleValue()), bundle5, true, AbstractC1874d.m4193b());
                                }
                            }
                        }
                    }
                    C0444d c0444d3 = AbstractC1879i.f6614a;
                    BigDecimal bigDecimal3 = (BigDecimal) c2071i.f7314a;
                    Currency currency3 = (Currency) c2071i.f7315b;
                    Bundle bundle6 = (Bundle) c2071i.f7316c;
                    c0444d3.getClass();
                    HashSet hashSet3 = AbstractC1117n.f3875a;
                    if (AbstractC1103F.m2866c()) {
                        C1718m c1718m2 = (C1718m) c0444d3.f1085e;
                        c1718m2.getClass();
                        if (!AbstractC0147a.f354a.contains(c1718m2)) {
                            try {
                                c1718m2.m3818h(bigDecimal3, currency3, bundle6);
                            } catch (Throwable th2) {
                                AbstractC0147a.m295a(th2, c1718m2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4204b() {
        int i3 = 1;
        if (f6619b == null) {
            try {
                Class.forName("com.android.vending.billing.IInAppBillingService$Stub");
                Boolean bool = Boolean.TRUE;
                f6619b = bool;
                try {
                    Class.forName("com.android.billingclient.api.ProxyBillingActivity");
                    f6620c = bool;
                } catch (ClassNotFoundException unused) {
                    f6620c = Boolean.FALSE;
                }
                HashMap map = AbstractC1884n.f6625a;
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences sharedPreferences = AbstractC1884n.f6628d;
                long j2 = sharedPreferences.getLong("LAST_CLEARED_TIME", 0L);
                if (j2 == 0) {
                    sharedPreferences.edit().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
                } else if (jCurrentTimeMillis - j2 > 604800) {
                    sharedPreferences.edit().clear().putLong("LAST_CLEARED_TIME", jCurrentTimeMillis).apply();
                }
                f6623f = new Intent("com.android.vending.billing.InAppBillingService.BIND").setPackage("com.android.vending");
                f6621d = new ServiceConnectionC1882l();
                f6622e = new C1871a(i3);
            } catch (ClassNotFoundException unused2) {
                f6619b = Boolean.FALSE;
            }
        }
        if (f6619b.booleanValue()) {
            C0444d c0444d = AbstractC1879i.f6614a;
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            C2079q c2079qM4621b = AbstractC2082t.m4621b(AbstractC1117n.f3877c);
            if (c2079qM4621b != null && AbstractC1103F.m2866c() && c2079qM4621b.f7355f && f6618a.compareAndSet(false, true)) {
                AbstractC2069g.m4584h();
                Context context = AbstractC1117n.f3882h;
                if (context instanceof Application) {
                    ((Application) context).registerActivityLifecycleCallbacks(f6622e);
                    context.bindService(f6623f, f6621d, 1);
                }
            }
        }
    }
}

package p141s0;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.AbstractC1117n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: s0.n */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1884n {

    /* JADX INFO: renamed from: a */
    public static final HashMap f6625a = new HashMap();

    /* JADX INFO: renamed from: b */
    public static final HashMap f6626b = new HashMap();

    /* JADX INFO: renamed from: c */
    public static final String f6627c;

    /* JADX INFO: renamed from: d */
    public static final SharedPreferences f6628d;

    /* JADX INFO: renamed from: e */
    public static final SharedPreferences f6629e;

    static {
        HashSet hashSet = AbstractC1117n.f3875a;
        AbstractC2069g.m4584h();
        f6627c = AbstractC1117n.f3882h.getPackageName();
        AbstractC2069g.m4584h();
        f6628d = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
        AbstractC2069g.m4584h();
        f6629e = AbstractC1117n.f3882h.getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    }

    /* JADX INFO: renamed from: a */
    public static ArrayList m4205a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        SharedPreferences sharedPreferences = f6629e;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("productId");
                long j2 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (jCurrentTimeMillis - (j2 / 1000) <= 86400 && !sharedPreferences.getString(string, "").equals(string2)) {
                    editorEdit.putString(string, string2);
                    arrayList2.add(str);
                }
            } catch (JSONException unused) {
            }
        }
        editorEdit.apply();
        return arrayList2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method m4206b(java.lang.Class r9, java.lang.String r10) {
        /*
            java.util.HashMap r0 = p141s0.AbstractC1884n.f6625a
            java.lang.Object r1 = r0.get(r10)
            java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1
            if (r1 == 0) goto Lb
            return r1
        Lb:
            int r2 = r10.hashCode()     // Catch: java.lang.NoSuchMethodException -> L83
            r3 = 3
            r4 = 2
            r5 = 4
            r6 = 1
            switch(r2) {
                case -1801122596: goto L3f;
                case -1450694211: goto L35;
                case -1123215065: goto L2b;
                case -594356707: goto L21;
                case -573310373: goto L17;
                default: goto L16;
            }     // Catch: java.lang.NoSuchMethodException -> L83
        L16:
            goto L49
        L17:
            java.lang.String r2 = "getSkuDetails"
            boolean r2 = r10.equals(r2)     // Catch: java.lang.NoSuchMethodException -> L83
            if (r2 == 0) goto L49
            r2 = r6
            goto L4a
        L21:
            java.lang.String r2 = "getPurchaseHistory"
            boolean r2 = r10.equals(r2)     // Catch: java.lang.NoSuchMethodException -> L83
            if (r2 == 0) goto L49
            r2 = r5
            goto L4a
        L2b:
            java.lang.String r2 = "asInterface"
            boolean r2 = r10.equals(r2)     // Catch: java.lang.NoSuchMethodException -> L83
            if (r2 == 0) goto L49
            r2 = 0
            goto L4a
        L35:
            java.lang.String r2 = "isBillingSupported"
            boolean r2 = r10.equals(r2)     // Catch: java.lang.NoSuchMethodException -> L83
            if (r2 == 0) goto L49
            r2 = r4
            goto L4a
        L3f:
            java.lang.String r2 = "getPurchases"
            boolean r2 = r10.equals(r2)     // Catch: java.lang.NoSuchMethodException -> L83
            if (r2 == 0) goto L49
            r2 = r3
            goto L4a
        L49:
            r2 = -1
        L4a:
            if (r2 == 0) goto L76
            java.lang.Class<android.os.Bundle> r7 = android.os.Bundle.class
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            if (r2 == r6) goto L6f
            if (r2 == r4) goto L68
            if (r2 == r3) goto L61
            if (r2 == r5) goto L5a
            r2 = 0
            goto L7c
        L5a:
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L83
            java.lang.Class[] r2 = new java.lang.Class[]{r2, r8, r8, r8, r7}     // Catch: java.lang.NoSuchMethodException -> L83
            goto L7c
        L61:
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L83
            java.lang.Class[] r2 = new java.lang.Class[]{r2, r8, r8, r8}     // Catch: java.lang.NoSuchMethodException -> L83
            goto L7c
        L68:
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L83
            java.lang.Class[] r2 = new java.lang.Class[]{r2, r8, r8}     // Catch: java.lang.NoSuchMethodException -> L83
            goto L7c
        L6f:
            java.lang.Class r2 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L83
            java.lang.Class[] r2 = new java.lang.Class[]{r2, r8, r8, r7}     // Catch: java.lang.NoSuchMethodException -> L83
            goto L7c
        L76:
            java.lang.Class<android.os.IBinder> r2 = android.os.IBinder.class
            java.lang.Class[] r2 = new java.lang.Class[]{r2}     // Catch: java.lang.NoSuchMethodException -> L83
        L7c:
            java.lang.reflect.Method r1 = r9.getDeclaredMethod(r10, r2)     // Catch: java.lang.NoSuchMethodException -> L83
            r0.put(r10, r1)     // Catch: java.lang.NoSuchMethodException -> L83
        L83:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p141s0.AbstractC1884n.m4206b(java.lang.Class, java.lang.String):java.lang.reflect.Method");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList m4207c(android.content.Context r20, java.lang.Object r21) {
        /*
            r0 = r20
            r1 = r21
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r1 != 0) goto Lc
            return r2
        Lc:
            java.util.HashMap r3 = p141s0.AbstractC1884n.f6626b
            java.lang.String r4 = "com.android.vending.billing.IInAppBillingService"
            java.lang.Object r5 = r3.get(r4)
            java.lang.Class r5 = (java.lang.Class) r5
            if (r5 == 0) goto L19
            goto L24
        L19:
            java.lang.ClassLoader r6 = r20.getClassLoader()     // Catch: java.lang.ClassNotFoundException -> L24
            java.lang.Class r5 = r6.loadClass(r4)     // Catch: java.lang.ClassNotFoundException -> L24
            r3.put(r4, r5)     // Catch: java.lang.ClassNotFoundException -> L24
        L24:
            if (r5 != 0) goto L27
            return r2
        L27:
            java.lang.String r3 = "getPurchaseHistory"
            java.lang.reflect.Method r5 = m4206b(r5, r3)
            if (r5 != 0) goto L30
            return r2
        L30:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r5 = "inapp"
            java.lang.Boolean r6 = m4210f(r0, r1, r5)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto Lbc
            r6 = 0
            r8 = r6
            r9 = 0
        L44:
            r10 = 6
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.os.Bundle r11 = new android.os.Bundle
            r11.<init>()
            java.lang.String r12 = p141s0.AbstractC1884n.f6627c
            java.lang.Object[] r9 = new java.lang.Object[]{r10, r12, r5, r9, r11}
            java.lang.Object r9 = m4209e(r0, r4, r3, r1, r9)
            if (r9 == 0) goto Lb3
            long r10 = java.lang.System.currentTimeMillis()
            r12 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 / r12
            android.os.Bundle r9 = (android.os.Bundle) r9
            java.lang.String r14 = "RESPONSE_CODE"
            int r14 = r9.getInt(r14)
            if (r14 != 0) goto Lb3
            java.lang.String r14 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r14 = r9.getStringArrayList(r14)
            if (r14 != 0) goto L74
            goto Lb3
        L74:
            java.util.Iterator r14 = r14.iterator()
        L78:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto Lab
            java.lang.Object r15 = r14.next()
            java.lang.String r15 = (java.lang.String) r15
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: org.json.JSONException -> La6
            r7.<init>(r15)     // Catch: org.json.JSONException -> La6
            java.lang.String r12 = "purchaseTime"
            long r12 = r7.getLong(r12)     // Catch: org.json.JSONException -> La3
            r16 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 / r16
            long r12 = r10 - r12
            r18 = 1200(0x4b0, double:5.93E-321)
            int r7 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r7 <= 0) goto L9d
            r8 = 1
            goto Lab
        L9d:
            r2.add(r15)     // Catch: org.json.JSONException -> La8
            int r6 = r6 + 1
            goto La8
        La3:
            r16 = 1000(0x3e8, double:4.94E-321)
            goto La8
        La6:
            r16 = r12
        La8:
            r12 = r16
            goto L78
        Lab:
            java.lang.String r7 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r7 = r9.getString(r7)
            r9 = r7
            goto Lb4
        Lb3:
            r9 = 0
        Lb4:
            r7 = 30
            if (r6 >= r7) goto Lbc
            if (r9 == 0) goto Lbc
            if (r8 == 0) goto L44
        Lbc:
            java.util.ArrayList r0 = m4205a(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p141s0.AbstractC1884n.m4207c(android.content.Context, java.lang.Object):java.util.ArrayList");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList m4208d(android.content.Context r6, java.lang.Object r7, java.lang.String r8) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r7 != 0) goto L8
            return r0
        L8:
            java.lang.Boolean r1 = m4210f(r6, r7, r8)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L54
            r1 = 0
            r2 = 0
            r3 = r1
        L15:
            r4 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = p141s0.AbstractC1884n.f6627c
            java.lang.Object[] r3 = new java.lang.Object[]{r4, r5, r8, r3}
            java.lang.String r4 = "com.android.vending.billing.IInAppBillingService"
            java.lang.String r5 = "getPurchases"
            java.lang.Object r3 = m4209e(r6, r4, r5, r7, r3)
            if (r3 == 0) goto L4d
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.lang.String r4 = "RESPONSE_CODE"
            int r4 = r3.getInt(r4)
            if (r4 != 0) goto L4d
            java.lang.String r4 = "INAPP_PURCHASE_DATA_LIST"
            java.util.ArrayList r4 = r3.getStringArrayList(r4)
            if (r4 == 0) goto L54
            int r5 = r4.size()
            int r5 = r5 + r2
            r0.addAll(r4)
            java.lang.String r2 = "INAPP_CONTINUATION_TOKEN"
            java.lang.String r2 = r3.getString(r2)
            r3 = r2
            r2 = r5
            goto L4e
        L4d:
            r3 = r1
        L4e:
            r4 = 30
            if (r2 >= r4) goto L54
            if (r3 != 0) goto L15
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p141s0.AbstractC1884n.m4208d(android.content.Context, java.lang.Object, java.lang.String):java.util.ArrayList");
    }

    /* JADX INFO: renamed from: e */
    public static Object m4209e(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method methodM4206b;
        HashMap map = f6626b;
        Class<?> clsLoadClass = (Class) map.get(str);
        if (clsLoadClass == null) {
            try {
                clsLoadClass = context.getClassLoader().loadClass(str);
                map.put(str, clsLoadClass);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (clsLoadClass == null || (methodM4206b = m4206b(clsLoadClass, str2)) == null) {
            return null;
        }
        if (obj != null) {
            obj = clsLoadClass.cast(obj);
        }
        try {
            return methodM4206b.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: f */
    public static Boolean m4210f(Context context, Object obj, String str) {
        if (obj == null) {
            return Boolean.FALSE;
        }
        Object objM4209e = m4209e(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, f6627c, str});
        return Boolean.valueOf(objM4209e != null && ((Integer) objM4209e).intValue() == 0);
    }
}

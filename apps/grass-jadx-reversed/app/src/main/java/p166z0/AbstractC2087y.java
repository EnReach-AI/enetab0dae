package p166z0;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AbstractC1117n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import p005B.AbstractC0032g;
import p010C0.AbstractC0147a;
import p019F0.RunnableC0218b;
import p066W0.C0684k;

/* JADX INFO: renamed from: z0.y */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2087y {

    /* JADX INFO: renamed from: a */
    public static final ArrayList f7381a = m4632a();

    /* JADX INFO: renamed from: b */
    public static final AtomicBoolean f7382b;

    /* JADX INFO: renamed from: c */
    public static final List f7383c;

    static {
        ArrayList arrayList = null;
        if (!AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            try {
                ArrayList arrayList2 = new ArrayList(m4632a());
                arrayList2.add(0, new C2086x(0));
                arrayList = arrayList2;
            } catch (Throwable th) {
                AbstractC0147a.m295a(th, AbstractC2087y.class);
            }
        }
        if (!AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            try {
                HashMap map = new HashMap();
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(new C2086x(3));
                ArrayList arrayList4 = f7381a;
                map.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", arrayList4);
                map.put("com.facebook.platform.action.request.FEED_DIALOG", arrayList4);
                map.put("com.facebook.platform.action.request.LIKE_DIALOG", arrayList4);
                map.put("com.facebook.platform.action.request.APPINVITES_DIALOG", arrayList4);
                map.put("com.facebook.platform.action.request.MESSAGE_DIALOG", arrayList3);
                map.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", arrayList3);
                map.put("com.facebook.platform.action.request.CAMERA_EFFECT", arrayList);
                map.put("com.facebook.platform.action.request.SHARE_STORY", arrayList4);
            } catch (Throwable th2) {
                AbstractC0147a.m295a(th2, AbstractC2087y.class);
            }
        }
        f7382b = new AtomicBoolean(false);
        f7383c = Arrays.asList(20170417, 20160327, 20141218, 20141107, 20141028, 20141001, 20140701, 20140324, 20140204, 20131107, 20130618, 20130502, 20121101);
    }

    /* JADX INFO: renamed from: a */
    public static ArrayList m4632a() {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new C2086x(2));
            arrayList.add(new C2086x(4));
            return arrayList;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m4633b(TreeSet treeSet, int i3, int[] iArr) {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return 0;
        }
        try {
            int length = iArr.length - 1;
            Iterator itDescendingIterator = treeSet.descendingIterator();
            int iMax = -1;
            while (itDescendingIterator.hasNext()) {
                int iIntValue = ((Integer) itDescendingIterator.next()).intValue();
                iMax = Math.max(iMax, iIntValue);
                while (length >= 0 && iArr[length] > iIntValue) {
                    length--;
                }
                if (length < 0) {
                    return -1;
                }
                if (iArr[length] == iIntValue) {
                    if (length % 2 == 0) {
                        return Math.min(iMax, i3);
                    }
                    return -1;
                }
            }
            return -1;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return 0;
        }
    }

    /* JADX INFO: renamed from: c */
    public static Intent m4634c(C2086x c2086x, String str, Collection collection, String str2, boolean z3, int i3, String str3, String str4, boolean z4) {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return null;
        }
        try {
            String strM4630b = c2086x.m4630b();
            if (strM4630b == null) {
                return null;
            }
            Intent intentPutExtra = new Intent().setClassName(c2086x.m4631c(), strM4630b).putExtra("client_id", str);
            HashSet hashSet = AbstractC1117n.f3875a;
            intentPutExtra.putExtra("facebook_sdk_version", "8.2.0");
            if (collection != null && collection.size() != 0) {
                intentPutExtra.putExtra("scope", TextUtils.join(",", collection));
            }
            if (!AbstractC2056E.m4550s(str2)) {
                intentPutExtra.putExtra("e2e", str2);
            }
            intentPutExtra.putExtra("state", str3);
            intentPutExtra.putExtra("response_type", "token,signed_request,graph_domain");
            intentPutExtra.putExtra("return_scopes", "true");
            if (z3) {
                intentPutExtra.putExtra("default_audience", AbstractC0032g.m151i(i3));
            }
            intentPutExtra.putExtra("legacy_override", AbstractC1117n.m2892b());
            intentPutExtra.putExtra("auth_type", str4);
            if (z4) {
                intentPutExtra.putExtra("fail_on_logged_out", true);
            }
            return intentPutExtra;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent m4635d(android.content.Intent r8, android.os.Bundle r9, com.facebook.C1111h r10) {
        /*
            java.util.Set r0 = p010C0.AbstractC0147a.f354a
            java.lang.Class<z0.y> r1 = p166z0.AbstractC2087y.class
            boolean r2 = r0.contains(r1)
            r3 = 0
            if (r2 == 0) goto Lc
            return r3
        Lc:
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "action_id"
            java.lang.String r4 = "com.facebook.platform.protocol.BRIDGE_ARGS"
            if (r0 == 0) goto L18
        L16:
            r0 = r3
            goto L45
        L18:
            if (r8 != 0) goto L1b
            goto L16
        L1b:
            int r0 = m4640i(r8)     // Catch: java.lang.Throwable -> L30
            boolean r0 = m4641j(r0)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L34
            android.os.Bundle r0 = r8.getBundleExtra(r4)     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L32
            java.lang.String r0 = r0.getString(r2)     // Catch: java.lang.Throwable -> L30
            goto L3a
        L30:
            r0 = move-exception
            goto L41
        L32:
            r0 = r3
            goto L3a
        L34:
            java.lang.String r0 = "com.facebook.platform.protocol.CALL_ID"
            java.lang.String r0 = r8.getStringExtra(r0)     // Catch: java.lang.Throwable -> L30
        L3a:
            if (r0 == 0) goto L16
            java.util.UUID r0 = java.util.UUID.fromString(r0)     // Catch: java.lang.IllegalArgumentException -> L16 java.lang.Throwable -> L30
            goto L45
        L41:
            p010C0.AbstractC0147a.m295a(r0, r1)     // Catch: java.lang.Throwable -> L93
            goto L16
        L45:
            if (r0 != 0) goto L48
            return r3
        L48:
            android.content.Intent r5 = new android.content.Intent     // Catch: java.lang.Throwable -> L93
            r5.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r6 = "com.facebook.platform.protocol.PROTOCOL_VERSION"
            int r8 = m4640i(r8)     // Catch: java.lang.Throwable -> L93
            r5.putExtra(r6, r8)     // Catch: java.lang.Throwable -> L93
            android.os.Bundle r8 = new android.os.Bundle     // Catch: java.lang.Throwable -> L93
            r8.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L93
            r8.putString(r2, r0)     // Catch: java.lang.Throwable -> L93
            if (r10 == 0) goto L95
            java.lang.String r0 = "error"
            java.util.Set r2 = p010C0.AbstractC0147a.f354a     // Catch: java.lang.Throwable -> L93
            boolean r2 = r2.contains(r1)     // Catch: java.lang.Throwable -> L93
            if (r2 == 0) goto L70
        L6e:
            r2 = r3
            goto L8f
        L70:
            android.os.Bundle r2 = new android.os.Bundle     // Catch: java.lang.Throwable -> L8a
            r2.<init>()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r6 = "error_description"
            java.lang.String r7 = r10.toString()     // Catch: java.lang.Throwable -> L8a
            r2.putString(r6, r7)     // Catch: java.lang.Throwable -> L8a
            boolean r10 = r10 instanceof com.facebook.C1113j     // Catch: java.lang.Throwable -> L8a
            if (r10 == 0) goto L8f
            java.lang.String r10 = "error_type"
            java.lang.String r6 = "UserCanceled"
            r2.putString(r10, r6)     // Catch: java.lang.Throwable -> L8a
            goto L8f
        L8a:
            r10 = move-exception
            p010C0.AbstractC0147a.m295a(r10, r1)     // Catch: java.lang.Throwable -> L93
            goto L6e
        L8f:
            r8.putBundle(r0, r2)     // Catch: java.lang.Throwable -> L93
            goto L95
        L93:
            r8 = move-exception
            goto La0
        L95:
            r5.putExtra(r4, r8)     // Catch: java.lang.Throwable -> L93
            if (r9 == 0) goto L9f
            java.lang.String r8 = "com.facebook.platform.protocol.RESULT_ARGS"
            r5.putExtra(r8, r9)     // Catch: java.lang.Throwable -> L93
        L9f:
            return r5
        La0:
            p010C0.AbstractC0147a.m295a(r8, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p166z0.AbstractC2087y.m4635d(android.content.Intent, android.os.Bundle, com.facebook.h):android.content.Intent");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7 A[Catch: all -> 0x00a2, TryCatch #1 {all -> 0x00a2, blocks: (B:5:0x0014, B:43:0x00a7, B:44:0x00aa, B:38:0x009e, B:11:0x004e, B:8:0x0032), top: B:49:0x0014, inners: #4 }] */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.TreeSet m4636e(p166z0.C2086x r15) {
        /*
            java.lang.String r1 = ".provider.PlatformProvider"
            java.lang.String r2 = "Failed to query content resolver."
            java.lang.String r3 = "z0.y"
            java.lang.String r4 = "version"
            java.util.Set r0 = p010C0.AbstractC0147a.f354a
            java.lang.Class<z0.y> r5 = p166z0.AbstractC2087y.class
            boolean r6 = r0.contains(r5)
            r7 = 0
            if (r6 == 0) goto L14
            return r7
        L14:
            java.util.TreeSet r6 = new java.util.TreeSet     // Catch: java.lang.Throwable -> La2
            r6.<init>()     // Catch: java.lang.Throwable -> La2
            java.util.HashSet r8 = com.facebook.AbstractC1117n.f3875a     // Catch: java.lang.Throwable -> La2
            p166z0.AbstractC2069g.m4584h()     // Catch: java.lang.Throwable -> La2
            android.content.Context r8 = com.facebook.AbstractC1117n.f3882h     // Catch: java.lang.Throwable -> La2
            android.content.ContentResolver r9 = r8.getContentResolver()     // Catch: java.lang.Throwable -> La2
            java.lang.String[] r11 = new java.lang.String[]{r4}     // Catch: java.lang.Throwable -> La2
            java.lang.String r8 = "content://"
            boolean r0 = r0.contains(r5)     // Catch: java.lang.Throwable -> La2
            if (r0 == 0) goto L32
        L30:
            r10 = r7
            goto L52
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r0.<init>(r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = r15.m4631c()     // Catch: java.lang.Throwable -> L4d
            r0.append(r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = ".provider.PlatformProvider/versions"
            r0.append(r8)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L4d
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch: java.lang.Throwable -> L4d
            r10 = r0
            goto L52
        L4d:
            r0 = move-exception
            p010C0.AbstractC0147a.m295a(r0, r5)     // Catch: java.lang.Throwable -> La2
            goto L30
        L52:
            p166z0.AbstractC2069g.m4584h()     // Catch: java.lang.Throwable -> L69
            android.content.Context r0 = com.facebook.AbstractC1117n.f3882h     // Catch: java.lang.Throwable -> L69
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Throwable -> L69
            java.lang.String r8 = r15.m4631c()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r8.concat(r1)     // Catch: java.lang.Throwable -> L69
            r8 = 0
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r1, r8)     // Catch: java.lang.Throwable -> L69 java.lang.RuntimeException -> L6c
            goto L72
        L69:
            r0 = move-exception
            r1 = r7
            goto La5
        L6c:
            r0 = move-exception
            r1 = r0
            android.util.Log.e(r3, r2, r1)     // Catch: java.lang.Throwable -> L69
            r0 = r7
        L72:
            if (r0 == 0) goto L9b
            r14 = 0
            r12 = 0
            r13 = 0
            android.database.Cursor r0 = r9.query(r10, r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L69 java.lang.Throwable -> L7d
            r1 = r0
            goto L81
        L7d:
            android.util.Log.e(r3, r2)     // Catch: java.lang.Throwable -> L69
            r1 = r7
        L81:
            if (r1 == 0) goto L9c
        L83:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L9c
            int r0 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L99
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L99
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L99
            r6.add(r0)     // Catch: java.lang.Throwable -> L99
            goto L83
        L99:
            r0 = move-exception
            goto La5
        L9b:
            r1 = r7
        L9c:
            if (r1 == 0) goto La4
            r1.close()     // Catch: java.lang.Throwable -> La2
            goto La4
        La2:
            r0 = move-exception
            goto Lab
        La4:
            return r6
        La5:
            if (r1 == 0) goto Laa
            r1.close()     // Catch: java.lang.Throwable -> La2
        Laa:
            throw r0     // Catch: java.lang.Throwable -> La2
        Lab:
            p010C0.AbstractC0147a.m295a(r0, r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p166z0.AbstractC2087y.m4636e(z0.x):java.util.TreeSet");
    }

    /* JADX INFO: renamed from: f */
    public static C0684k m4637f(int[] iArr) {
        ArrayList<C2086x> arrayList = f7381a;
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return null;
        }
        try {
            m4642k();
            if (arrayList == null) {
                C0684k c0684k = new C0684k();
                c0684k.f1859a = -1;
                return c0684k;
            }
            for (C2086x c2086x : arrayList) {
                TreeSet treeSet = c2086x.f7379a;
                if (treeSet == null || treeSet.isEmpty()) {
                    c2086x.m4629a(false);
                }
                int iM4633b = m4633b(c2086x.f7379a, m4638g(), iArr);
                if (iM4633b != -1) {
                    C0684k c0684k2 = new C0684k();
                    c0684k2.f1859a = iM4633b;
                    return c0684k2;
                }
            }
            C0684k c0684k3 = new C0684k();
            c0684k3.f1859a = -1;
            return c0684k3;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static final int m4638g() {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return 0;
        }
        try {
            return ((Integer) f7383c.get(0)).intValue();
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return 0;
        }
    }

    /* JADX INFO: renamed from: h */
    public static Bundle m4639h(Intent intent) {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return null;
        }
        try {
            return !m4641j(m4640i(intent)) ? intent.getExtras() : intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return null;
        }
    }

    /* JADX INFO: renamed from: i */
    public static int m4640i(Intent intent) {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return 0;
        }
        try {
            return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return 0;
        }
    }

    /* JADX INFO: renamed from: j */
    public static boolean m4641j(int i3) {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return false;
        }
        try {
            return f7383c.contains(Integer.valueOf(i3)) && i3 >= 20140701;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
            return false;
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m4642k() {
        if (AbstractC0147a.f354a.contains(AbstractC2087y.class)) {
            return;
        }
        try {
            if (f7382b.compareAndSet(false, true)) {
                AbstractC1117n.m2891a().execute(new RunnableC0218b(15));
            }
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC2087y.class);
        }
    }
}

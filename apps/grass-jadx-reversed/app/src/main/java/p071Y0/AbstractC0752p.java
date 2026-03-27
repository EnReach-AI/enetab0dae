package p071Y0;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.emoji2.text.C0908o;
import androidx.emoji2.text.C0909p;
import com.facebook.C1107d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import p005B.C0033h;
import p039M0.AbstractC0493h0;
import p131p2.C1832f;

/* JADX INFO: renamed from: Y0.p */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0752p {

    /* JADX INFO: renamed from: a */
    public static Field f2112a = null;

    /* JADX INFO: renamed from: b */
    public static boolean f2113b = false;

    /* JADX INFO: renamed from: c */
    public static boolean f2114c = true;

    /* JADX INFO: renamed from: a */
    public static long m1932a(long j2) {
        if (j2 < -4611686018427387903L) {
            return -4611686018427387903L;
        }
        if (j2 > 4611686018427387903L) {
            return 4611686018427387903L;
        }
        return j2;
    }

    /* JADX INFO: renamed from: b */
    public static float[] m1933b(float[] fArr, int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int iMin = Math.min(i3, length);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX INFO: renamed from: c */
    public static C0909p m1934c(Context context) {
        ProviderInfo providerInfo;
        C1107d c1107d;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        AbstractC0493h0.m1010c("Package manager required to locate emoji font provider", packageManager);
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            c1107d = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArr = packageManager.getPackageInfo(str2, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                c1107d = new C1107d(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList));
            } catch (PackageManager.NameNotFoundException e3) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e3);
                c1107d = null;
            }
        }
        if (c1107d == null) {
            return null;
        }
        return new C0909p(new C0908o(context, c1107d));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009b A[Catch: NumberFormatException -> 0x00af, LOOP:3: B:29:0x006d->B:48:0x009b, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00af, blocks: (B:26:0x0059, B:29:0x006d, B:31:0x0073, B:35:0x007f, B:48:0x009b, B:50:0x00a1, B:56:0x00b6, B:57:0x00b9), top: B:71:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a1 A[Catch: NumberFormatException -> 0x00af, TryCatch #0 {NumberFormatException -> 0x00af, blocks: (B:26:0x0059, B:29:0x006d, B:31:0x0073, B:35:0x007f, B:48:0x009b, B:50:0x00a1, B:56:0x00b6, B:57:0x00b9), top: B:71:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6 A[Catch: NumberFormatException -> 0x00af, TryCatch #0 {NumberFormatException -> 0x00af, blocks: (B:26:0x0059, B:29:0x006d, B:31:0x0073, B:35:0x007f, B:48:0x009b, B:50:0x00a1, B:56:0x00b6, B:57:0x00b9), top: B:71:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009a A[SYNTHETIC] */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p005B.C0033h[] m1935d(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p071Y0.AbstractC0752p.m1935d(java.lang.String):B.h[]");
    }

    /* JADX INFO: renamed from: e */
    public static C0033h[] m1936e(C0033h[] c0033hArr) {
        if (c0033hArr == null) {
            return null;
        }
        C0033h[] c0033hArr2 = new C0033h[c0033hArr.length];
        for (int i3 = 0; i3 < c0033hArr.length; i3++) {
            C0033h c0033h = c0033hArr[i3];
            C0033h c0033h2 = new C0033h();
            c0033h2.f86a = c0033h.f86a;
            float[] fArr = c0033h.f87b;
            c0033h2.f87b = m1933b(fArr, fArr.length);
            c0033hArr2[i3] = c0033h2;
        }
        return c0033hArr2;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m1937g(MotionEvent motionEvent, int i3) {
        return (motionEvent.getSource() & i3) == i3;
    }

    /* JADX INFO: renamed from: j */
    public static C1832f m1938j(int i3, int i4) {
        if (i4 > Integer.MIN_VALUE) {
            return new C1832f(i3, i4 - 1, 1);
        }
        C1832f c1832f = C1832f.f6345h;
        return C1832f.f6345h;
    }

    /* JADX INFO: renamed from: f */
    public float mo1939f(View view) {
        if (f2114c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2114c = false;
            }
        }
        return view.getAlpha();
    }

    /* JADX INFO: renamed from: h */
    public void mo1940h(View view, float f3) {
        if (f2114c) {
            try {
                view.setTransitionAlpha(f3);
                return;
            } catch (NoSuchMethodError unused) {
                f2114c = false;
            }
        }
        view.setAlpha(f3);
    }

    /* JADX INFO: renamed from: i */
    public void mo1941i(View view, int i3) {
        if (!f2113b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f2112a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f2113b = true;
        }
        Field field = f2112a;
        if (field != null) {
            try {
                f2112a.setInt(view, i3 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }
}

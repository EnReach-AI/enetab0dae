package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.C0881b;
import androidx.activity.result.C0888i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p031J1.C0382f;
import p033K0.AbstractC0406d;
import p083b2.C1061f;
import p086c2.AbstractC1087f;
import p086c2.AbstractC1097p;
import p086c2.C1094m;
import p119m2.AbstractC1766e;
import p165z.AbstractC2049e;

/* JADX INFO: renamed from: androidx.fragment.app.z */
/* JADX INFO: loaded from: classes.dex */
public final class C0955z extends AbstractC0406d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3273a;

    public /* synthetic */ C0955z(int i3) {
        this.f3273a = i3;
    }

    @Override // p033K0.AbstractC0406d
    /* JADX INFO: renamed from: a */
    public final Intent mo907a(Context context, Object obj) {
        Bundle bundleExtra;
        switch (this.f3273a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0888i c0888i = (C0888i) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = c0888i.f2646f;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        c0888i = new C0888i(c0888i.f2645e, c0888i.f2647g, c0888i.f2648h);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", c0888i);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                String[] strArr = (String[]) obj;
                AbstractC1766e.m3920e("context", context);
                AbstractC1766e.m3920e("input", strArr);
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                AbstractC1766e.m3919d("Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)", intentPutExtra);
                return intentPutExtra;
            case 2:
                Intent intent3 = (Intent) obj;
                AbstractC1766e.m3920e("context", context);
                AbstractC1766e.m3920e("input", intent3);
                return intent3;
            default:
                C0888i c0888i2 = (C0888i) obj;
                AbstractC1766e.m3920e("context", context);
                AbstractC1766e.m3920e("input", c0888i2);
                Intent intentPutExtra2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", c0888i2);
                AbstractC1766e.m3919d("Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)", intentPutExtra2);
                return intentPutExtra2;
        }
    }

    @Override // p033K0.AbstractC0406d
    /* JADX INFO: renamed from: g */
    public C0382f mo908g(Context context, Object obj) {
        switch (this.f3273a) {
            case 1:
                String[] strArr = (String[]) obj;
                AbstractC1766e.m3920e("context", context);
                AbstractC1766e.m3920e("input", strArr);
                if (strArr.length == 0) {
                    return new C0382f(C1094m.f3783e);
                }
                for (String str : strArr) {
                    if (AbstractC2049e.m4523a(context, str) != 0) {
                        return null;
                    }
                }
                int iM2840i = AbstractC1097p.m2840i(strArr.length);
                if (iM2840i < 16) {
                    iM2840i = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iM2840i);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new C0382f(linkedHashMap);
            default:
                return super.mo908g(context, obj);
        }
    }

    @Override // p033K0.AbstractC0406d
    /* JADX INFO: renamed from: j */
    public final Object mo909j(int i3, Intent intent) {
        switch (this.f3273a) {
            case 1:
                C1094m c1094m = C1094m.f3783e;
                if (i3 == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i4 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i4 == 0));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArrayExtra) {
                            if (str != null) {
                                arrayList2.add(str);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList3 = new ArrayList(Math.min(AbstractC1087f.m2838v(arrayList2, 10), AbstractC1087f.m2838v(arrayList, 10)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList3.add(new C1061f(it.next(), it2.next()));
                        }
                        break;
                    }
                }
                break;
        }
        return new C0881b(i3, intent);
    }
}

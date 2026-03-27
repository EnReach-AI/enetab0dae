package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.activity.result.AbstractC0886g;
import androidx.activity.result.C0888i;
import androidx.fragment.app.AbstractActivityC0947r;
import java.util.Arrays;
import java.util.HashSet;
import p005B.AbstractC0032g;
import p031J1.C0382f;
import p033K0.AbstractC0406d;
import p156w0.AbstractC1986a;
import p162y.AbstractC2022a;
import p162y.AbstractC2023b;
import p162y.InterfaceC2024c;

/* JADX INFO: renamed from: androidx.activity.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0870e extends AbstractC0886g {

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ AbstractActivityC0873h f2595i;

    public C0870e(AbstractActivityC0947r abstractActivityC0947r) {
        this.f2595i = abstractActivityC0947r;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.result.AbstractC0886g
    /* JADX INFO: renamed from: b */
    public final void mo2194b(int i3, AbstractC0406d abstractC0406d, Object obj) {
        Bundle bundle;
        AbstractActivityC0873h abstractActivityC0873h = this.f2595i;
        C0382f c0382fMo908g = abstractC0406d.mo908g(abstractActivityC0873h, obj);
        if (c0382fMo908g != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0869d(this, i3, c0382fMo908g, 0));
            return;
        }
        Intent intentMo907a = abstractC0406d.mo907a(abstractActivityC0873h, obj);
        if (intentMo907a.getExtras() != null && intentMo907a.getExtras().getClassLoader() == null) {
            intentMo907a.setExtrasClassLoader(abstractActivityC0873h.getClassLoader());
        }
        if (intentMo907a.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = intentMo907a.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentMo907a.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if (!"androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentMo907a.getAction())) {
            if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentMo907a.getAction())) {
                AbstractC2022a.m4468b(abstractActivityC0873h, intentMo907a, i3, bundle);
                return;
            }
            C0888i c0888i = (C0888i) intentMo907a.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
            try {
                AbstractC2022a.m4469c(abstractActivityC0873h, c0888i.f2645e, i3, c0888i.f2646f, c0888i.f2647g, c0888i.f2648h, 0, bundle);
                return;
            } catch (IntentSender.SendIntentException e3) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0869d(this, i3, e3, 1));
                return;
            }
        }
        String[] stringArrayExtra = intentMo907a.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        if (stringArrayExtra == null) {
            stringArrayExtra = new String[0];
        }
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < stringArrayExtra.length; i4++) {
            if (TextUtils.isEmpty(stringArrayExtra[i4])) {
                throw new IllegalArgumentException(AbstractC0032g.m157o(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
            }
            if (!AbstractC1986a.m4379g() && TextUtils.equals(stringArrayExtra[i4], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i4));
            }
        }
        int size = hashSet.size();
        String[] strArr = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
        if (size > 0) {
            if (size == stringArrayExtra.length) {
                return;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < stringArrayExtra.length; i6++) {
                if (!hashSet.contains(Integer.valueOf(i6))) {
                    strArr[i5] = stringArrayExtra[i6];
                    i5++;
                }
            }
        }
        if (abstractActivityC0873h instanceof InterfaceC2024c) {
        }
        AbstractC2023b.m4471b(abstractActivityC0873h, stringArrayExtra, i3);
    }
}

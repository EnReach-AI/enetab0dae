package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.C0884e;
import androidx.activity.result.InterfaceC0882c;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.fasterxml.jackson.databind.util.internal.C1234c;
import com.fasterxml.jackson.databind.util.internal.C1243l;
import com.fasterxml.jackson.databind.util.internal.ConcurrentMapC1248q;
import com.fasterxml.jackson.databind.util.internal.InterfaceC1232a;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.concurrent.atomic.AtomicLong;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p031J1.C0382f;

/* JADX INFO: renamed from: androidx.activity.d */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0869d implements Runnable {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ int f2591e;

    /* JADX INFO: renamed from: f */
    public final int f2592f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f2593g;

    /* JADX INFO: renamed from: h */
    public final Object f2594h;

    public /* synthetic */ RunnableC0869d(C0870e c0870e, int i3, Object obj, int i4) {
        this.f2591e = i4;
        this.f2593g = c0870e;
        this.f2592f = i3;
        this.f2594h = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0882c interfaceC0882c;
        switch (this.f2591e) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                Object obj = ((C0382f) this.f2594h).f903a;
                C0870e c0870e = (C0870e) this.f2593g;
                String str = (String) c0870e.f2638b.get(Integer.valueOf(this.f2592f));
                if (str != null) {
                    C0884e c0884e = (C0884e) c0870e.f2642f.get(str);
                    if (c0884e == null || (interfaceC0882c = c0884e.f2633a) == null) {
                        c0870e.f2644h.remove(str);
                        c0870e.f2643g.put(str, obj);
                    } else if (c0870e.f2641e.remove(str)) {
                        interfaceC0882c.mo449j(obj);
                    }
                    break;
                }
                break;
            case 1:
                ((C0870e) this.f2593g).m2214a(this.f2592f, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f2594h));
                break;
            case 2:
                ConcurrentMapC1248q concurrentMapC1248q = (ConcurrentMapC1248q) this.f2593g;
                AtomicLong atomicLong = concurrentMapC1248q.f4198i;
                atomicLong.lazySet(atomicLong.get() + ((long) this.f2592f));
                C1234c c1234c = concurrentMapC1248q.f4197h;
                C1243l c1243l = (C1243l) this.f2594h;
                if (c1234c.m3108b(c1243l) && c1243l != c1234c.f4165f) {
                    C1243l c1243l2 = c1243l.f4184f;
                    C1243l c1243l3 = c1243l.f4185g;
                    if (c1243l2 == null) {
                        c1234c.f4164e = c1243l3;
                    } else {
                        c1243l2.f4185g = c1243l3;
                        c1243l.f4184f = null;
                    }
                    if (c1243l3 == null) {
                        c1234c.f4165f = c1243l2;
                    } else {
                        c1243l3.f4184f = c1243l2;
                        c1243l.f4185g = null;
                    }
                    InterfaceC1232a interfaceC1232a = c1234c.f4165f;
                    c1234c.f4165f = c1243l;
                    if (interfaceC1232a == null) {
                        c1234c.f4164e = c1243l;
                    } else {
                        ((C1243l) interfaceC1232a).f4185g = c1243l;
                        c1243l.f4184f = (C1243l) interfaceC1232a;
                    }
                }
                concurrentMapC1248q.m3118d();
                break;
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                ((TextView) this.f2594h).setTypeface((Typeface) this.f2593g, this.f2592f);
                break;
            default:
                ((BottomSheetBehavior) this.f2593g).m3143C((View) this.f2594h, this.f2592f, false);
                break;
        }
    }

    public /* synthetic */ RunnableC0869d(Object obj, Object obj2, int i3, int i4) {
        this.f2591e = i4;
        this.f2593g = obj;
        this.f2592f = i3;
        this.f2594h = obj2;
    }

    public RunnableC0869d(TextView textView, Typeface typeface, int i3) {
        this.f2591e = 3;
        this.f2594h = textView;
        this.f2593g = typeface;
        this.f2592f = i3;
    }
}

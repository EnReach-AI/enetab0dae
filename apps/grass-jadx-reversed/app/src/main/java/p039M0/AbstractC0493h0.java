package p039M0;

import android.os.Build;
import android.view.ViewGroup;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import p119m2.AbstractC1766e;
import p119m2.AbstractC1770i;

/* JADX INFO: renamed from: M0.h0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0493h0 {

    /* JADX INFO: renamed from: b */
    public static boolean f1140b = true;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1141a;

    public /* synthetic */ AbstractC0493h0(int i3) {
        this.f1141a = i3;
    }

    /* JADX INFO: renamed from: a */
    public static void m1008a(String str, boolean z3) {
        if (!z3) {
            throw new IllegalArgumentException(str);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1009b(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m1010c(String str, Object obj) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m1012e(ViewGroup viewGroup, boolean z3) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z3);
        } else if (f1140b) {
            try {
                viewGroup.suppressLayout(z3);
            } catch (NoSuchMethodError unused) {
                f1140b = false;
            }
        }
    }

    public int hashCode() {
        switch (this.f1141a) {
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f1141a) {
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                String strM3915b = AbstractC1770i.m3927a(getClass()).m3915b();
                AbstractC1766e.m3917b(strM3915b);
                return strM3915b;
            default:
                return super.toString();
        }
    }
}

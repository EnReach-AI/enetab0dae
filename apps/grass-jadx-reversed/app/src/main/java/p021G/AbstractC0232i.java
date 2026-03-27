package p021G;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import com.facebook.C1107d;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p005B.AbstractC0034i;
import p015D2.C0192p;
import p128p.C1812f;
import p128p.C1817k;

/* JADX INFO: renamed from: G.i */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0232i {

    /* JADX INFO: renamed from: a */
    public static final C1812f f554a = new C1812f(16);

    /* JADX INFO: renamed from: b */
    public static final ThreadPoolExecutor f555b;

    /* JADX INFO: renamed from: c */
    public static final Object f556c;

    /* JADX INFO: renamed from: d */
    public static final C1817k f557d;

    static {
        ThreadFactoryC0235l threadFactoryC0235l = new ThreadFactoryC0235l();
        threadFactoryC0235l.f564a = "fonts-androidx";
        threadFactoryC0235l.f565b = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), threadFactoryC0235l);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f555b = threadPoolExecutor;
        f556c = new Object();
        f557d = new C1817k();
    }

    /* JADX INFO: renamed from: a */
    public static C0231h m475a(String str, Context context, C1107d c1107d, int i3) {
        C1812f c1812f = f554a;
        Typeface typeface = (Typeface) c1812f.m4030a(str);
        if (typeface != null) {
            return new C0231h(typeface);
        }
        try {
            C0192p c0192pM473a = AbstractC0228e.m473a(context, c1107d);
            int i4 = 1;
            C0233j[] c0233jArr = (C0233j[]) c0192pM473a.f444g;
            int i5 = c0192pM473a.f443f;
            if (i5 != 0) {
                i4 = i5 != 1 ? -3 : -2;
            } else if (c0233jArr != null && c0233jArr.length != 0) {
                int length = c0233jArr.length;
                i4 = 0;
                int i6 = 0;
                while (true) {
                    if (i6 >= length) {
                        break;
                    }
                    int i7 = c0233jArr[i6].f562e;
                    if (i7 == 0) {
                        i6++;
                    } else if (i7 >= 0) {
                        i4 = i7;
                    }
                }
            }
            if (i4 != 0) {
                return new C0231h(i4);
            }
            Typeface typefaceMo176e = AbstractC0034i.f88a.mo176e(context, c0233jArr, i3);
            if (typefaceMo176e == null) {
                return new C0231h(-3);
            }
            c1812f.m4031b(str, typefaceMo176e);
            return new C0231h(typefaceMo176e);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0231h(-1);
        }
    }
}

package p006B0;

import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONArray;
import p002A0.C0021c;
import p002A0.C0022d;
import p002A0.EnumC0020b;
import p020F2.AbstractC0223a;
import p033K0.AbstractC0405c;
import p033K0.AbstractC0406d;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: B0.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0040c implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: b */
    public static C0040c f105b;

    /* JADX INFO: renamed from: a */
    public final Thread.UncaughtExceptionHandler f106a;

    public C0040c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f106a = uncaughtExceptionHandler;
    }

    /* JADX INFO: renamed from: a */
    public static void m190a() {
        File[] fileArrListFiles;
        if (AbstractC2056E.m4549r()) {
            return;
        }
        File fileM898f = AbstractC0406d.m898f();
        if (fileM898f == null) {
            fileArrListFiles = new File[0];
        } else {
            fileArrListFiles = fileM898f.listFiles(new C0022d(1));
            if (fileArrListFiles == null) {
                fileArrListFiles = new File[0];
            }
        }
        ArrayList arrayList = new ArrayList();
        for (File file : fileArrListFiles) {
            C0021c c0021cM889k = AbstractC0405c.m889k(file);
            if (c0021cM889k.m75a()) {
                arrayList.add(c0021cM889k);
            }
        }
        Collections.sort(arrayList, new C0038a(0));
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size() && i3 < 5; i3++) {
            jSONArray.put(arrayList.get(i3));
        }
        AbstractC0406d.m905o("crash_reports", jSONArray, new C0039b(arrayList, 0));
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            Throwable th2 = null;
            Throwable cause = th;
            while (true) {
                if (cause == null || cause == th2) {
                    break;
                }
                for (StackTraceElement stackTraceElement : cause.getStackTrace()) {
                    if (stackTraceElement.getClassName().startsWith("com.facebook")) {
                        AbstractC0223a.m465b(th);
                        C0021c c0021cM884c = AbstractC0405c.m884c(th, EnumC0020b.f61g);
                        if (c0021cM884c.m75a()) {
                            AbstractC0406d.m906p(c0021cM884c.f65a, c0021cM884c.toString());
                        }
                    }
                }
                th2 = cause;
                cause = cause.getCause();
            }
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f106a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}

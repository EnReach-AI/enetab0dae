package p125o0;

import android.hardware.SensorManager;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import p010C0.AbstractC0147a;
import p019F0.C0222f;

/* JADX INFO: renamed from: o0.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1795e {

    /* JADX INFO: renamed from: b */
    public static SensorManager f6194b;

    /* JADX INFO: renamed from: c */
    public static C1803m f6195c;

    /* JADX INFO: renamed from: d */
    public static String f6196d;

    /* JADX INFO: renamed from: a */
    public static final C1804n f6193a = new C1804n();

    /* JADX INFO: renamed from: e */
    public static final AtomicBoolean f6197e = new AtomicBoolean(true);

    /* JADX INFO: renamed from: f */
    public static final AtomicBoolean f6198f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g */
    public static volatile Boolean f6199g = Boolean.FALSE;

    /* JADX INFO: renamed from: h */
    public static final C0222f f6200h = new C0222f(12);

    /* JADX INFO: renamed from: a */
    public static String m3958a() {
        if (AbstractC0147a.f354a.contains(AbstractC1795e.class)) {
            return null;
        }
        try {
            if (f6196d == null) {
                f6196d = UUID.randomUUID().toString();
            }
            return f6196d;
        } catch (Throwable th) {
            AbstractC0147a.m295a(th, AbstractC1795e.class);
            return null;
        }
    }
}

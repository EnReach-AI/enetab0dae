package p117m0;

import android.preference.PreferenceManager;
import com.facebook.AbstractC1117n;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: m0.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1708c {

    /* JADX INFO: renamed from: b */
    public static String f5977b;

    /* JADX INFO: renamed from: a */
    public static final ReentrantReadWriteLock f5976a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c */
    public static volatile boolean f5978c = false;

    /* JADX INFO: renamed from: a */
    public static void m3789a() {
        if (f5978c) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = f5976a;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (f5978c) {
                reentrantReadWriteLock.writeLock().unlock();
                return;
            }
            HashSet hashSet = AbstractC1117n.f3875a;
            AbstractC2069g.m4584h();
            f5977b = PreferenceManager.getDefaultSharedPreferences(AbstractC1117n.f3882h).getString("com.facebook.appevents.AnalyticsUserIDStore.userID", null);
            f5978c = true;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            f5976a.writeLock().unlock();
            throw th;
        }
    }
}

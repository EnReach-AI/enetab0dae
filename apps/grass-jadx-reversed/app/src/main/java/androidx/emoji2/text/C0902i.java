package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p021G.RunnableC0225b;
import p039M0.AbstractC0493h0;
import p125o0.C1803m;
import p128p.C1809c;
import p166z0.C2068f;
import p166z0.C2071i;

/* JADX INFO: renamed from: androidx.emoji2.text.i */
/* JADX INFO: loaded from: classes.dex */
public final class C0902i {

    /* JADX INFO: renamed from: i */
    public static final Object f2970i = new Object();

    /* JADX INFO: renamed from: j */
    public static volatile C0902i f2971j;

    /* JADX INFO: renamed from: a */
    public final ReentrantReadWriteLock f2972a;

    /* JADX INFO: renamed from: b */
    public final C1809c f2973b;

    /* JADX INFO: renamed from: c */
    public volatile int f2974c;

    /* JADX INFO: renamed from: d */
    public final Handler f2975d;

    /* JADX INFO: renamed from: e */
    public final C0898e f2976e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC0901h f2977f;

    /* JADX INFO: renamed from: g */
    public final int f2978g;

    /* JADX INFO: renamed from: h */
    public final C0896c f2979h;

    public C0902i(C0909p c0909p) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f2972a = reentrantReadWriteLock;
        this.f2974c = 3;
        InterfaceC0901h interfaceC0901h = (InterfaceC0901h) c0909p.f2410b;
        this.f2977f = interfaceC0901h;
        int i3 = c0909p.f2409a;
        this.f2978g = i3;
        this.f2979h = (C0896c) c0909p.f2411c;
        this.f2975d = new Handler(Looper.getMainLooper());
        this.f2973b = new C1809c(0);
        C0898e c0898e = new C0898e(this);
        this.f2976e = c0898e;
        reentrantReadWriteLock.writeLock().lock();
        if (i3 == 0) {
            try {
                this.f2974c = 0;
            } catch (Throwable th) {
                this.f2972a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (m2342b() == 0) {
            try {
                interfaceC0901h.mo2340a(new C0897d(c0898e));
            } catch (Throwable th2) {
                m2344d(th2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0902i m2341a() {
        C0902i c0902i;
        synchronized (f2970i) {
            try {
                c0902i = f2971j;
                if (!(c0902i != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return c0902i;
    }

    /* JADX INFO: renamed from: b */
    public final int m2342b() {
        this.f2972a.readLock().lock();
        try {
            return this.f2974c;
        } finally {
            this.f2972a.readLock().unlock();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m2343c() {
        if (!(this.f2978g == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (m2342b() == 1) {
            return;
        }
        this.f2972a.writeLock().lock();
        try {
            if (this.f2974c == 0) {
                return;
            }
            this.f2974c = 0;
            this.f2972a.writeLock().unlock();
            C0898e c0898e = this.f2976e;
            C0902i c0902i = c0898e.f2967a;
            try {
                c0902i.f2977f.mo2340a(new C0897d(c0898e));
            } catch (Throwable th) {
                c0902i.m2344d(th);
            }
        } finally {
            this.f2972a.writeLock().unlock();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m2344d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f2972a.writeLock().lock();
        try {
            this.f2974c = 2;
            arrayList.addAll(this.f2973b);
            this.f2973b.clear();
            this.f2972a.writeLock().unlock();
            this.f2975d.post(new RunnableC0225b(arrayList, this.f2974c, th));
        } catch (Throwable th2) {
            this.f2972a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m2345e() {
        ArrayList arrayList = new ArrayList();
        this.f2972a.writeLock().lock();
        try {
            this.f2974c = 1;
            arrayList.addAll(this.f2973b);
            this.f2973b.clear();
            this.f2972a.writeLock().unlock();
            this.f2975d.post(new RunnableC0225b(arrayList, this.f2974c, (Throwable) null));
        } catch (Throwable th) {
            this.f2972a.writeLock().unlock();
            throw th;
        }
    }

    /* JADX INFO: renamed from: f */
    public final CharSequence m2346f(CharSequence charSequence, int i3, int i4) {
        int iCharCount;
        C0913t[] c0913tArr;
        if (!(m2342b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        AbstractC0493h0.m1008a("start should be <= than end", i3 <= i4);
        C0914u c0914u = null;
        if (charSequence == null) {
            return null;
        }
        AbstractC0493h0.m1008a("start should be < than charSequence length", i3 <= charSequence.length());
        AbstractC0493h0.m1008a("end should be < than charSequence length", i4 <= charSequence.length());
        if (charSequence.length() == 0 || i3 == i4) {
            return charSequence;
        }
        C2071i c2071i = this.f2976e.f2968b;
        c2071i.getClass();
        boolean z3 = charSequence instanceof C0912s;
        if (z3) {
            ((C0912s) charSequence).m2358a();
        }
        if (z3) {
            c0914u = new C0914u((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    c0914u = new C0914u((Spannable) charSequence);
                } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i3 - 1, i4 + 1, C0913t.class) <= i4) {
                    c0914u = new C0914u(charSequence);
                }
            } finally {
                if (z3) {
                    ((C0912s) charSequence).m2359b();
                }
            }
        }
        if (c0914u != null && (c0913tArr = (C0913t[]) c0914u.f3016f.getSpans(i3, i4, C0913t.class)) != null && c0913tArr.length > 0) {
            for (C0913t c0913t : c0913tArr) {
                int spanStart = c0914u.f3016f.getSpanStart(c0913t);
                int spanEnd = c0914u.f3016f.getSpanEnd(c0913t);
                if (spanStart != i4) {
                    c0914u.removeSpan(c0913t);
                }
                i3 = Math.min(spanStart, i3);
                i4 = Math.max(spanEnd, i4);
            }
        }
        if (i3 != i4 && i3 < charSequence.length()) {
            C0907n c0907n = new C0907n((C0910q) ((C1803m) c2071i.f7315b).f6222h);
            int iCodePointAt = Character.codePointAt(charSequence, i3);
            int i5 = 0;
            C0914u c0914u2 = c0914u;
            loop1: while (true) {
                iCharCount = i3;
                while (i3 < i4 && i5 < Integer.MAX_VALUE) {
                    int iM2351a = c0907n.m2351a(iCodePointAt);
                    if (iM2351a == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i4) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i3 = iCharCount;
                    } else if (iM2351a == 2) {
                        i3 += Character.charCount(iCodePointAt);
                        if (i3 < i4) {
                            iCodePointAt = Character.codePointAt(charSequence, i3);
                        }
                    } else if (iM2351a == 3) {
                        if (!c2071i.m4605q(charSequence, iCharCount, i3, c0907n.f2994d.f3007b)) {
                            if (c0914u2 == null) {
                                c0914u2 = new C0914u((Spannable) new SpannableString(charSequence));
                            }
                            C0906m c0906m = c0907n.f2994d.f3007b;
                            ((C2068f) c2071i.f7314a).getClass();
                            c0914u2.setSpan(new C0913t(c0906m), iCharCount, i3, 33);
                            i5++;
                        }
                    }
                }
                break loop1;
            }
            if (c0907n.f2991a == 2 && c0907n.f2993c.f3007b != null && ((c0907n.f2996f > 1 || c0907n.m2353c()) && i5 < Integer.MAX_VALUE && !c2071i.m4605q(charSequence, iCharCount, i3, c0907n.f2993c.f3007b))) {
                if (c0914u2 == null) {
                    c0914u2 = new C0914u(charSequence);
                }
                C0906m c0906m2 = c0907n.f2993c.f3007b;
                ((C2068f) c2071i.f7314a).getClass();
                c0914u2.setSpan(new C0913t(c0906m2), iCharCount, i3, 33);
            }
            if (c0914u2 != null) {
                Spannable spannable = c0914u2.f3016f;
                if (z3) {
                    ((C0912s) charSequence).m2359b();
                }
                return spannable;
            }
            if (!z3) {
                return charSequence;
            }
        } else if (!z3) {
            return charSequence;
        }
        return charSequence;
    }

    /* JADX INFO: renamed from: g */
    public final void m2347g(AbstractC0900g abstractC0900g) {
        AbstractC0493h0.m1010c("initCallback cannot be null", abstractC0900g);
        this.f2972a.writeLock().lock();
        try {
            if (this.f2974c == 1 || this.f2974c == 2) {
                this.f2975d.post(new RunnableC0225b(Arrays.asList(abstractC0900g), this.f2974c, (Throwable) null));
            } else {
                this.f2973b.add(abstractC0900g);
            }
            this.f2972a.writeLock().unlock();
        } catch (Throwable th) {
            this.f2972a.writeLock().unlock();
            throw th;
        }
    }
}

package com.fasterxml.jackson.databind.util.internal;

import androidx.activity.RunnableC0869d;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: com.fasterxml.jackson.databind.util.internal.q */
/* JADX INFO: loaded from: classes.dex */
public final class ConcurrentMapC1248q extends AbstractMap implements ConcurrentMap, Serializable {
    static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: t */
    public static final int f4192t;

    /* JADX INFO: renamed from: u */
    public static final int f4193u;

    /* JADX INFO: renamed from: e */
    public final ConcurrentHashMap f4194e;

    /* JADX INFO: renamed from: f */
    public final int f4195f;

    /* JADX INFO: renamed from: g */
    public final long[] f4196g;

    /* JADX INFO: renamed from: h */
    public final C1234c f4197h;

    /* JADX INFO: renamed from: i */
    public final AtomicLong f4198i;

    /* JADX INFO: renamed from: j */
    public final AtomicLong f4199j;

    /* JADX INFO: renamed from: k */
    public final ReentrantLock f4200k;

    /* JADX INFO: renamed from: l */
    public final ConcurrentLinkedQueue f4201l;

    /* JADX INFO: renamed from: m */
    public final AtomicLongArray f4202m;

    /* JADX INFO: renamed from: n */
    public final AtomicLongArray f4203n;

    /* JADX INFO: renamed from: o */
    public final AtomicReferenceArray f4204o;

    /* JADX INFO: renamed from: p */
    public final AtomicReference f4205p;

    /* JADX INFO: renamed from: q */
    public transient C1242k f4206q;

    /* JADX INFO: renamed from: r */
    public transient C1245n f4207r;

    /* JADX INFO: renamed from: s */
    public transient C1242k f4208s;

    static {
        int iMin = Math.min(4, 1 << (32 - Integer.numberOfLeadingZeros(Runtime.getRuntime().availableProcessors() - 1)));
        f4192t = iMin;
        f4193u = iMin - 1;
    }

    public ConcurrentMapC1248q(C1236e c1236e) {
        int i3 = c1236e.f4169a;
        this.f4195f = i3;
        this.f4199j = new AtomicLong(Math.min(c1236e.f4171c, 9223372034707292160L));
        this.f4194e = new ConcurrentHashMap(c1236e.f4170b, 0.75f, i3);
        this.f4200k = new ReentrantLock();
        this.f4198i = new AtomicLong();
        this.f4197h = new C1234c();
        this.f4201l = new ConcurrentLinkedQueue();
        this.f4205p = new AtomicReference(EnumC1240i.f4172e);
        int i4 = f4192t;
        this.f4196g = new long[i4];
        this.f4202m = new AtomicLongArray(i4);
        this.f4203n = new AtomicLongArray(i4);
        this.f4204o = new AtomicReferenceArray(i4 * 16);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    /* JADX INFO: renamed from: a */
    public final void m3115a(C1243l c1243l) {
        int id = ((int) Thread.currentThread().getId()) & f4193u;
        AtomicLongArray atomicLongArray = this.f4202m;
        long j2 = atomicLongArray.get(id);
        atomicLongArray.lazySet(id, serialVersionUID + j2);
        this.f4204o.lazySet((id * 16) + ((int) (15 & j2)), c1243l);
        if (((EnumC1240i) this.f4205p.get()).mo3112a(j2 - this.f4203n.get(id) < 4)) {
            m3121g();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m3116b(Runnable runnable) {
        this.f4201l.add(runnable);
        this.f4205p.lazySet(EnumC1240i.f4173f);
        m3121g();
    }

    /* JADX INFO: renamed from: c */
    public final void m3117c() {
        int i3;
        Runnable runnable;
        int id = (int) Thread.currentThread().getId();
        int i4 = f4192t + id;
        while (true) {
            i3 = 0;
            if (id >= i4) {
                break;
            }
            int i5 = f4193u & id;
            long j2 = this.f4202m.get(i5);
            while (i3 < 8) {
                long[] jArr = this.f4196g;
                int i6 = (i5 * 16) + ((int) (jArr[i5] & 15));
                AtomicReferenceArray atomicReferenceArray = this.f4204o;
                C1243l c1243l = (C1243l) atomicReferenceArray.get(i6);
                if (c1243l == null) {
                    break;
                }
                atomicReferenceArray.lazySet(i6, null);
                C1234c c1234c = this.f4197h;
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
                jArr[i5] = jArr[i5] + serialVersionUID;
                i3++;
            }
            this.f4203n.lazySet(i5, j2);
            id++;
        }
        while (i3 < 16 && (runnable = (Runnable) this.f4201l.poll()) != null) {
            runnable.run();
            i3++;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        ReentrantLock reentrantLock = this.f4200k;
        reentrantLock.lock();
        while (true) {
            try {
                C1243l c1243l = (C1243l) this.f4197h.pollFirst();
                if (c1243l == null) {
                    break;
                }
                this.f4194e.remove(c1243l.f4183e, c1243l);
                m3119e(c1243l);
            } finally {
                reentrantLock.unlock();
            }
        }
        int i3 = 0;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f4204o;
            if (i3 >= atomicReferenceArray.length()) {
                break;
            }
            atomicReferenceArray.lazySet(i3, null);
            i3++;
        }
        while (true) {
            Runnable runnable = (Runnable) this.f4201l.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f4194e.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        obj.getClass();
        Iterator it = this.f4194e.values().iterator();
        while (it.hasNext()) {
            if (((C1243l) it.next()).m3113a().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public final void m3118d() {
        C1243l c1243l;
        while (this.f4198i.get() > this.f4199j.get() && (c1243l = (C1243l) this.f4197h.pollFirst()) != null) {
            this.f4194e.remove(c1243l.f4183e, c1243l);
            m3119e(c1243l);
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m3119e(C1243l c1243l) {
        C1246o c1246o;
        do {
            c1246o = (C1246o) c1243l.get();
        } while (!c1243l.compareAndSet(c1246o, new C1246o(0, c1246o.f4190b)));
        AtomicLong atomicLong = this.f4198i;
        atomicLong.lazySet(atomicLong.get() - ((long) Math.abs(c1246o.f4189a)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        C1242k c1242k = this.f4208s;
        if (c1242k != null) {
            return c1242k;
        }
        C1242k c1242k2 = new C1242k(this, 0);
        this.f4208s = c1242k2;
        return c1242k2;
    }

    /* JADX INFO: renamed from: f */
    public final Object m3120f(Object obj, Object obj2, boolean z3) {
        C1246o c1246o;
        obj.getClass();
        obj2.getClass();
        C1246o c1246o2 = new C1246o(1, obj2);
        C1243l c1243l = new C1243l(obj, c1246o2);
        while (true) {
            C1243l c1243l2 = (C1243l) this.f4194e.putIfAbsent(c1243l.f4183e, c1243l);
            if (c1243l2 == null) {
                m3116b(new RunnableC1235d(this, c1243l, 0));
                return null;
            }
            if (z3) {
                m3115a(c1243l2);
                return c1243l2.m3113a();
            }
            do {
                c1246o = (C1246o) c1243l2.get();
                if (!c1246o.m3114a()) {
                    break;
                }
            } while (!c1243l2.compareAndSet(c1246o, c1246o2));
            int i3 = 1 - c1246o.f4189a;
            if (i3 == 0) {
                m3115a(c1243l2);
            } else {
                m3116b(new RunnableC0869d(this, c1243l2, i3, 2));
            }
            return c1246o.f4190b;
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m3121g() {
        C1237f c1237f = EnumC1240i.f4172e;
        C1239h c1239h = EnumC1240i.f4174g;
        AtomicReference atomicReference = this.f4205p;
        ReentrantLock reentrantLock = this.f4200k;
        if (reentrantLock.tryLock()) {
            try {
                atomicReference.lazySet(c1239h);
                m3117c();
                while (!atomicReference.compareAndSet(c1239h, c1237f) && atomicReference.get() == c1239h) {
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                while (!atomicReference.compareAndSet(c1239h, c1237f) && atomicReference.get() == c1239h) {
                }
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        C1243l c1243l = (C1243l) this.f4194e.get(obj);
        if (c1243l == null) {
            return null;
        }
        m3115a(c1243l);
        return c1243l.m3113a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return this.f4194e.isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        C1242k c1242k = this.f4206q;
        if (c1242k != null) {
            return c1242k;
        }
        C1242k c1242k2 = new C1242k(this, 1);
        this.f4206q = c1242k2;
        return c1242k2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        return m3120f(obj, obj2, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        return m3120f(obj, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        C1246o c1246o;
        C1243l c1243l = (C1243l) this.f4194e.remove(obj);
        if (c1243l == null) {
            return null;
        }
        do {
            c1246o = (C1246o) c1243l.get();
            if (!c1246o.m3114a()) {
                break;
            }
        } while (!c1243l.compareAndSet(c1246o, new C1246o(-c1246o.f4189a, c1246o.f4190b)));
        m3116b(new RunnableC1235d(this, c1243l, 1));
        return c1243l.m3113a();
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        C1246o c1246o;
        obj.getClass();
        obj2.getClass();
        C1246o c1246o2 = new C1246o(1, obj2);
        C1243l c1243l = (C1243l) this.f4194e.get(obj);
        if (c1243l == null) {
            return null;
        }
        do {
            c1246o = (C1246o) c1243l.get();
            if (!c1246o.m3114a()) {
                return null;
            }
        } while (!c1243l.compareAndSet(c1246o, c1246o2));
        int i3 = 1 - c1246o.f4189a;
        if (i3 == 0) {
            m3115a(c1243l);
        } else {
            m3116b(new RunnableC0869d(this, c1243l, i3, 2));
        }
        return c1246o.f4190b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f4194e.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        C1245n c1245n = this.f4207r;
        if (c1245n != null) {
            return c1245n;
        }
        C1245n c1245n2 = new C1245n(this);
        this.f4207r = c1245n2;
        return c1245n2;
    }

    public Object writeReplace() {
        return new C1244m(this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        ConcurrentHashMap concurrentHashMap = this.f4194e;
        C1243l c1243l = (C1243l) concurrentHashMap.get(obj);
        if (c1243l != null && obj2 != null) {
            C1246o c1246o = (C1246o) c1243l.get();
            while (true) {
                Object obj3 = c1246o.f4190b;
                if (obj2 != obj3 && !obj3.equals(obj2)) {
                    break;
                }
                if (c1246o.m3114a() ? c1243l.compareAndSet(c1246o, new C1246o(-c1246o.f4189a, c1246o.f4190b)) : false) {
                    if (concurrentHashMap.remove(obj, c1243l)) {
                        m3116b(new RunnableC1235d(this, c1243l, 1));
                        return true;
                    }
                } else {
                    c1246o = (C1246o) c1243l.get();
                    if (!c1246o.m3114a()) {
                        break;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        C1246o c1246o;
        Object obj4;
        obj.getClass();
        obj2.getClass();
        obj3.getClass();
        C1246o c1246o2 = new C1246o(1, obj3);
        C1243l c1243l = (C1243l) this.f4194e.get(obj);
        if (c1243l == null) {
            return false;
        }
        do {
            c1246o = (C1246o) c1243l.get();
            if (!c1246o.m3114a() || (obj2 != (obj4 = c1246o.f4190b) && !obj4.equals(obj2))) {
                return false;
            }
        } while (!c1243l.compareAndSet(c1246o, c1246o2));
        int i3 = 1 - c1246o.f4189a;
        if (i3 == 0) {
            m3115a(c1243l);
        } else {
            m3116b(new RunnableC0869d(this, c1243l, i3, 2));
        }
        return true;
    }
}

package p118m1;

import java.lang.reflect.Array;
import java.util.HashSet;
import p001A.C0003d;

/* JADX INFO: renamed from: m1.d */
/* JADX INFO: loaded from: classes.dex */
public final class C1739d {

    /* JADX INFO: renamed from: a */
    public C1738c f6090a;

    /* JADX INFO: renamed from: b */
    public C1738c f6091b;

    /* JADX INFO: renamed from: c */
    public C1738c f6092c;

    /* JADX INFO: renamed from: d */
    public C1738c f6093d;

    /* JADX INFO: renamed from: e */
    public C1738c f6094e;

    /* JADX INFO: renamed from: f */
    public C1738c f6095f;

    /* JADX INFO: renamed from: g */
    public C1738c f6096g;

    /* JADX INFO: renamed from: a */
    public static HashSet m3868a(Object[] objArr) {
        if (objArr == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet(objArr.length);
        for (Object obj : objArr) {
            hashSet.add(obj);
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: b */
    public static C0003d m3869b(Object obj) {
        return new C0003d(obj.getClass(), Array.getLength(obj), obj);
    }
}

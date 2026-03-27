package p119m2;

import p015D2.C0193q;
import p083b2.InterfaceC1057b;
import p115l2.InterfaceC1678a;
import p115l2.InterfaceC1689l;
import p115l2.InterfaceC1693p;

/* JADX INFO: renamed from: m2.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1772k {
    /* JADX INFO: renamed from: a */
    public static void m3929a(Object obj) {
        if (obj == null || m3930b(3, obj)) {
            return;
        }
        ClassCastException classCastException = new ClassCastException(obj.getClass().getName().concat(" cannot be cast to kotlin.jvm.functions.Function3"));
        AbstractC1766e.m3922g(classCastException, AbstractC1772k.class.getName());
        throw classCastException;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3930b(int i3, Object obj) {
        if (obj instanceof InterfaceC1057b) {
            return (obj instanceof InterfaceC1765d ? ((InterfaceC1765d) obj).mo316b() : obj instanceof InterfaceC1678a ? 0 : obj instanceof InterfaceC1689l ? 1 : obj instanceof InterfaceC1693p ? 2 : obj instanceof C0193q ? 3 : -1) == i3;
        }
        return false;
    }
}

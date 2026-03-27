package androidx.fragment.app;

import android.util.Log;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* JADX INFO: renamed from: androidx.fragment.app.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0930a implements InterfaceC0916B {

    /* JADX INFO: renamed from: a */
    public final ArrayList f3117a;

    /* JADX INFO: renamed from: b */
    public int f3118b;

    /* JADX INFO: renamed from: c */
    public int f3119c;

    /* JADX INFO: renamed from: d */
    public int f3120d;

    /* JADX INFO: renamed from: e */
    public int f3121e;

    /* JADX INFO: renamed from: f */
    public int f3122f;

    /* JADX INFO: renamed from: g */
    public boolean f3123g;

    /* JADX INFO: renamed from: h */
    public String f3124h;

    /* JADX INFO: renamed from: i */
    public int f3125i;

    /* JADX INFO: renamed from: j */
    public CharSequence f3126j;

    /* JADX INFO: renamed from: k */
    public int f3127k;

    /* JADX INFO: renamed from: l */
    public CharSequence f3128l;

    /* JADX INFO: renamed from: m */
    public ArrayList f3129m;

    /* JADX INFO: renamed from: n */
    public ArrayList f3130n;

    /* JADX INFO: renamed from: o */
    public boolean f3131o;

    /* JADX INFO: renamed from: p */
    public final C0918D f3132p;

    /* JADX INFO: renamed from: q */
    public boolean f3133q;

    /* JADX INFO: renamed from: r */
    public int f3134r;

    public C0930a(C0918D c0918d) {
        c0918d.m2410z();
        C0946q c0946q = c0918d.f3042n;
        if (c0946q != null) {
            c0946q.f3247f.getClassLoader();
        }
        this.f3117a = new ArrayList();
        this.f3131o = false;
        this.f3134r = -1;
        this.f3132p = c0918d;
    }

    @Override // androidx.fragment.app.InterfaceC0916B
    /* JADX INFO: renamed from: a */
    public final boolean mo2363a(ArrayList arrayList, ArrayList arrayList2) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f3123g) {
            return true;
        }
        C0918D c0918d = this.f3132p;
        if (c0918d.f3032d == null) {
            c0918d.f3032d = new ArrayList();
        }
        c0918d.f3032d.add(this);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public final void m2439b(C0924J c0924j) {
        this.f3117a.add(c0924j);
        c0924j.f3095c = this.f3118b;
        c0924j.f3096d = this.f3119c;
        c0924j.f3097e = this.f3120d;
        c0924j.f3098f = this.f3121e;
    }

    /* JADX INFO: renamed from: c */
    public final void m2440c(int i3) {
        if (this.f3123g) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i3);
            }
            ArrayList arrayList = this.f3117a;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0924J c0924j = (C0924J) arrayList.get(i4);
                AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0924j.f3094b;
                if (abstractComponentCallbacksC0944o != null) {
                    abstractComponentCallbacksC0944o.f3238u += i3;
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Bump nesting of " + c0924j.f3094b + " to " + c0924j.f3094b.f3238u);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m2441d(boolean z3) {
        if (this.f3133q) {
            throw new IllegalStateException("commit already called");
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new C0926L());
            m2443f("  ", printWriter, true);
            printWriter.close();
        }
        this.f3133q = true;
        boolean z4 = this.f3123g;
        C0918D c0918d = this.f3132p;
        if (z4) {
            this.f3134r = c0918d.f3037i.getAndIncrement();
        } else {
            this.f3134r = -1;
        }
        c0918d.m2402r(this, z3);
        return this.f3134r;
    }

    /* JADX INFO: renamed from: e */
    public final void m2442e(int i3, AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o, String str, int i4) {
        Class<?> cls = abstractComponentCallbacksC0944o.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = abstractComponentCallbacksC0944o.f3202B;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + abstractComponentCallbacksC0944o + ": was " + abstractComponentCallbacksC0944o.f3202B + " now " + str);
            }
            abstractComponentCallbacksC0944o.f3202B = str;
        }
        if (i3 != 0) {
            if (i3 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + abstractComponentCallbacksC0944o + " with tag " + str + " to container view with no id");
            }
            int i5 = abstractComponentCallbacksC0944o.f3243z;
            if (i5 != 0 && i5 != i3) {
                throw new IllegalStateException("Can't change container ID of fragment " + abstractComponentCallbacksC0944o + ": was " + abstractComponentCallbacksC0944o.f3243z + " now " + i3);
            }
            abstractComponentCallbacksC0944o.f3243z = i3;
            abstractComponentCallbacksC0944o.f3201A = i3;
        }
        m2439b(new C0924J(i4, abstractComponentCallbacksC0944o));
        abstractComponentCallbacksC0944o.f3239v = this.f3132p;
    }

    /* JADX INFO: renamed from: f */
    public final void m2443f(String str, PrintWriter printWriter, boolean z3) {
        String str2;
        if (z3) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f3124h);
            printWriter.print(" mIndex=");
            printWriter.print(this.f3134r);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f3133q);
            if (this.f3122f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f3122f));
            }
            if (this.f3118b != 0 || this.f3119c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3118b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3119c));
            }
            if (this.f3120d != 0 || this.f3121e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f3120d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f3121e));
            }
            if (this.f3125i != 0 || this.f3126j != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3125i));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f3126j);
            }
            if (this.f3127k != 0 || this.f3128l != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f3127k));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f3128l);
            }
        }
        ArrayList arrayList = this.f3117a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0924J c0924j = (C0924J) arrayList.get(i3);
            switch (c0924j.f3093a) {
                case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    str2 = "REMOVE";
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    str2 = "HIDE";
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    str2 = "SHOW";
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    str2 = "DETACH";
                    break;
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    str2 = "ATTACH";
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + c0924j.f3093a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i3);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(c0924j.f3094b);
            if (z3) {
                if (c0924j.f3095c != 0 || c0924j.f3096d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0924j.f3095c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0924j.f3096d));
                }
                if (c0924j.f3097e != 0 || c0924j.f3098f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0924j.f3097e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0924j.f3098f));
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m2444g() {
        ArrayList arrayList = this.f3117a;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            C0924J c0924j = (C0924J) arrayList.get(i3);
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0924j.f3094b;
            if (abstractComponentCallbacksC0944o != null) {
                if (abstractComponentCallbacksC0944o.f3213M != null) {
                    abstractComponentCallbacksC0944o.m2489g().f3189a = false;
                }
                int i4 = this.f3122f;
                if (abstractComponentCallbacksC0944o.f3213M != null || i4 != 0) {
                    abstractComponentCallbacksC0944o.m2489g();
                    abstractComponentCallbacksC0944o.f3213M.f3194f = i4;
                }
                abstractComponentCallbacksC0944o.m2489g();
                abstractComponentCallbacksC0944o.f3213M.getClass();
            }
            int i5 = c0924j.f3093a;
            C0918D c0918d = this.f3132p;
            switch (i5) {
                case 1:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2379O(abstractComponentCallbacksC0944o, false);
                    c0918d.m2385a(abstractComponentCallbacksC0944o);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0924j.f3093a);
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2374J(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2369B(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2379O(abstractComponentCallbacksC0944o, false);
                    C0918D.m2367S(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2391g(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2379O(abstractComponentCallbacksC0944o, false);
                    c0918d.m2387c(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    c0918d.m2381Q(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    c0918d.m2381Q(null);
                    break;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    c0918d.m2380P(abstractComponentCallbacksC0944o, c0924j.f3100h);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m2445h() {
        ArrayList arrayList = this.f3117a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            C0924J c0924j = (C0924J) arrayList.get(size);
            AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o = c0924j.f3094b;
            if (abstractComponentCallbacksC0944o != null) {
                if (abstractComponentCallbacksC0944o.f3213M != null) {
                    abstractComponentCallbacksC0944o.m2489g().f3189a = true;
                }
                int i3 = this.f3122f;
                int i4 = i3 != 4097 ? i3 != 4099 ? i3 != 8194 ? 0 : 4097 : 4099 : 8194;
                if (abstractComponentCallbacksC0944o.f3213M != null || i4 != 0) {
                    abstractComponentCallbacksC0944o.m2489g();
                    abstractComponentCallbacksC0944o.f3213M.f3194f = i4;
                }
                abstractComponentCallbacksC0944o.m2489g();
                abstractComponentCallbacksC0944o.f3213M.getClass();
            }
            int i5 = c0924j.f3093a;
            C0918D c0918d = this.f3132p;
            switch (i5) {
                case 1:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2379O(abstractComponentCallbacksC0944o, true);
                    c0918d.m2374J(abstractComponentCallbacksC0944o);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0924j.f3093a);
                case FromStringDeserializer.Std.STD_URI /* 3 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2385a(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.getClass();
                    C0918D.m2367S(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2379O(abstractComponentCallbacksC0944o, true);
                    c0918d.m2369B(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2387c(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                    abstractComponentCallbacksC0944o.m2484L(c0924j.f3095c, c0924j.f3096d, c0924j.f3097e, c0924j.f3098f);
                    c0918d.m2379O(abstractComponentCallbacksC0944o, true);
                    c0918d.m2391g(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                    c0918d.m2381Q(null);
                    break;
                case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                    c0918d.m2381Q(abstractComponentCallbacksC0944o);
                    break;
                case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                    c0918d.m2380P(abstractComponentCallbacksC0944o, c0924j.f3099g);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m2446i(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        C0918D c0918d = abstractComponentCallbacksC0944o.f3239v;
        if (c0918d == null || c0918d == this.f3132p) {
            m2439b(new C0924J(3, abstractComponentCallbacksC0944o));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + abstractComponentCallbacksC0944o.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f3134r >= 0) {
            sb.append(" #");
            sb.append(this.f3134r);
        }
        if (this.f3124h != null) {
            sb.append(" ");
            sb.append(this.f3124h);
        }
        sb.append("}");
        return sb.toString();
    }
}

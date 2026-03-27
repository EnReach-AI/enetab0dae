package p114l1;

import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p069X0.AbstractC0721l;
import p118m1.AbstractC1745j;

/* JADX INFO: renamed from: l1.p */
/* JADX INFO: loaded from: classes.dex */
public final class C1674p implements Serializable {

    /* JADX INFO: renamed from: i */
    public static final String[] f5925i;

    /* JADX INFO: renamed from: j */
    public static final AbstractC0721l[] f5926j;

    /* JADX INFO: renamed from: k */
    public static final C1674p f5927k;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: e */
    public final String[] f5928e;

    /* JADX INFO: renamed from: f */
    public final AbstractC0721l[] f5929f;

    /* JADX INFO: renamed from: g */
    public final String[] f5930g;

    /* JADX INFO: renamed from: h */
    public final int f5931h;

    static {
        String[] strArr = new String[0];
        f5925i = strArr;
        AbstractC0721l[] abstractC0721lArr = new AbstractC0721l[0];
        f5926j = abstractC0721lArr;
        f5927k = new C1674p(strArr, abstractC0721lArr, null);
    }

    public C1674p(String[] strArr, AbstractC0721l[] abstractC0721lArr, String[] strArr2) {
        strArr = strArr == null ? f5925i : strArr;
        this.f5928e = strArr;
        abstractC0721lArr = abstractC0721lArr == null ? f5926j : abstractC0721lArr;
        this.f5929f = abstractC0721lArr;
        if (strArr.length == abstractC0721lArr.length) {
            this.f5930g = strArr2;
            this.f5931h = Arrays.hashCode(abstractC0721lArr);
            return;
        }
        throw new IllegalArgumentException("Mismatching names (" + strArr.length + "), types (" + abstractC0721lArr.length + ")");
    }

    /* JADX INFO: renamed from: a */
    public static C1674p m3761a(AbstractC0721l abstractC0721l, Class cls) {
        TypeVariable[] typeParameters;
        if (cls == Collection.class) {
            typeParameters = AbstractC1673o.f5918b;
        } else if (cls == List.class) {
            typeParameters = AbstractC1673o.f5920d;
        } else if (cls == ArrayList.class) {
            typeParameters = AbstractC1673o.f5921e;
        } else if (cls == AbstractList.class) {
            typeParameters = AbstractC1673o.f5917a;
        } else if (cls == Iterable.class) {
            typeParameters = AbstractC1673o.f5919c;
        } else {
            TypeVariable[] typeVariableArr = AbstractC1673o.f5917a;
            typeParameters = cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 1) {
            return new C1674p(new String[]{typeParameters[0].getName()}, new AbstractC0721l[]{abstractC0721l}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 1 type parameter: class expects " + length);
    }

    /* JADX INFO: renamed from: b */
    public static C1674p m3762b(Class cls, AbstractC0721l abstractC0721l, AbstractC0721l abstractC0721l2) {
        TypeVariable[] typeParameters;
        if (cls == Map.class) {
            typeParameters = AbstractC1673o.f5922f;
        } else if (cls == HashMap.class) {
            typeParameters = AbstractC1673o.f5923g;
        } else if (cls == LinkedHashMap.class) {
            typeParameters = AbstractC1673o.f5924h;
        } else {
            TypeVariable[] typeVariableArr = AbstractC1673o.f5917a;
            typeParameters = cls.getTypeParameters();
        }
        int length = typeParameters == null ? 0 : typeParameters.length;
        if (length == 2) {
            return new C1674p(new String[]{typeParameters[0].getName(), typeParameters[1].getName()}, new AbstractC0721l[]{abstractC0721l, abstractC0721l2}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + cls.getName() + " with 2 type parameters: class expects " + length);
    }

    /* JADX INFO: renamed from: c */
    public static C1674p m3763c(Class cls, AbstractC0721l[] abstractC0721lArr) {
        String[] strArr;
        if (abstractC0721lArr == null) {
            abstractC0721lArr = f5926j;
        } else {
            int length = abstractC0721lArr.length;
            if (length == 1) {
                return m3761a(abstractC0721lArr[0], cls);
            }
            if (length == 2) {
                return m3762b(cls, abstractC0721lArr[0], abstractC0721lArr[1]);
            }
        }
        TypeVariable[] typeParameters = cls.getTypeParameters();
        if (typeParameters == null || typeParameters.length == 0) {
            strArr = f5925i;
        } else {
            int length2 = typeParameters.length;
            strArr = new String[length2];
            for (int i3 = 0; i3 < length2; i3++) {
                strArr[i3] = typeParameters[i3].getName();
            }
        }
        if (strArr.length == abstractC0721lArr.length) {
            return new C1674p(strArr, abstractC0721lArr, null);
        }
        StringBuilder sb = new StringBuilder("Cannot create TypeBindings for class ");
        sb.append(cls.getName());
        sb.append(" with ");
        sb.append(abstractC0721lArr.length);
        sb.append(" type parameter");
        sb.append(abstractC0721lArr.length == 1 ? "" : "s");
        sb.append(": class expects ");
        sb.append(strArr.length);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC0721l m3764d(int i3) {
        if (i3 < 0) {
            return null;
        }
        AbstractC0721l[] abstractC0721lArr = this.f5929f;
        if (i3 >= abstractC0721lArr.length) {
            return null;
        }
        return abstractC0721lArr[i3];
    }

    /* JADX INFO: renamed from: e */
    public final List m3765e() {
        AbstractC0721l[] abstractC0721lArr = this.f5929f;
        return abstractC0721lArr.length == 0 ? Collections.emptyList() : Arrays.asList(abstractC0721lArr);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!AbstractC1745j.m3896s(obj, C1674p.class)) {
            return false;
        }
        C1674p c1674p = (C1674p) obj;
        return this.f5931h == c1674p.f5931h && Arrays.equals(this.f5929f, c1674p.f5929f);
    }

    /* JADX INFO: renamed from: f */
    public final boolean m3766f() {
        return this.f5929f.length == 0;
    }

    public final int hashCode() {
        return this.f5931h;
    }

    public Object readResolve() {
        String[] strArr = this.f5928e;
        return (strArr == null || strArr.length == 0) ? f5927k : this;
    }

    public final String toString() {
        AbstractC0721l[] abstractC0721lArr = this.f5929f;
        if (abstractC0721lArr.length == 0) {
            return "<>";
        }
        StringBuilder sb = new StringBuilder("<");
        int length = abstractC0721lArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 > 0) {
                sb.append(',');
            }
            AbstractC0721l abstractC0721l = abstractC0721lArr[i3];
            StringBuilder sb2 = new StringBuilder(40);
            abstractC0721l.mo1876k(sb2);
            sb.append(sb2.toString());
        }
        sb.append('>');
        return sb.toString();
    }
}

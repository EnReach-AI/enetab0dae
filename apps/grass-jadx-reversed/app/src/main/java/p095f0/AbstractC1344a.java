package p095f0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p128p.C1808b;

/* JADX INFO: renamed from: f0.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1344a {

    /* JADX INFO: renamed from: a */
    public final C1808b f4803a;

    /* JADX INFO: renamed from: b */
    public final C1808b f4804b;

    /* JADX INFO: renamed from: c */
    public final C1808b f4805c;

    public AbstractC1344a(C1808b c1808b, C1808b c1808b2, C1808b c1808b3) {
        this.f4803a = c1808b;
        this.f4804b = c1808b2;
        this.f4805c = c1808b3;
    }

    /* JADX INFO: renamed from: a */
    public abstract C1345b mo3291a();

    /* JADX INFO: renamed from: b */
    public final Class m3292b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        C1808b c1808b = this.f4805c;
        Class cls2 = (Class) c1808b.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        c1808b.put(cls.getName(), cls3);
        return cls3;
    }

    /* JADX INFO: renamed from: c */
    public final Method m3293c(String str) throws NoSuchMethodException {
        C1808b c1808b = this.f4803a;
        Method method = (Method) c1808b.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC1344a.class.getClassLoader()).getDeclaredMethod("read", AbstractC1344a.class);
        c1808b.put(str, declaredMethod);
        return declaredMethod;
    }

    /* JADX INFO: renamed from: d */
    public final Method m3294d(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        String name = cls.getName();
        C1808b c1808b = this.f4804b;
        Method method = (Method) c1808b.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class clsM3292b = m3292b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsM3292b.getDeclaredMethod("write", cls, AbstractC1344a.class);
        c1808b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* JADX INFO: renamed from: e */
    public abstract boolean mo3295e(int i3);

    /* JADX INFO: renamed from: f */
    public final int m3296f(int i3, int i4) {
        return !mo3295e(i4) ? i3 : ((C1345b) this).f4807e.readInt();
    }

    /* JADX INFO: renamed from: g */
    public final Parcelable m3297g(Parcelable parcelable, int i3) {
        if (!mo3295e(i3)) {
            return parcelable;
        }
        return ((C1345b) this).f4807e.readParcelable(C1345b.class.getClassLoader());
    }

    /* JADX INFO: renamed from: h */
    public final InterfaceC1346c m3298h() {
        String string = ((C1345b) this).f4807e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (InterfaceC1346c) m3293c(string).invoke(null, mo3291a());
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
        } catch (InvocationTargetException e6) {
            if (e6.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e6.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
        }
    }

    /* JADX INFO: renamed from: i */
    public abstract void mo3299i(int i3);

    /* JADX INFO: renamed from: j */
    public final void m3300j(int i3, int i4) {
        mo3299i(i4);
        ((C1345b) this).f4807e.writeInt(i3);
    }

    /* JADX INFO: renamed from: k */
    public final void m3301k(InterfaceC1346c interfaceC1346c) {
        if (interfaceC1346c == null) {
            ((C1345b) this).f4807e.writeString(null);
            return;
        }
        try {
            ((C1345b) this).f4807e.writeString(m3292b(interfaceC1346c.getClass()).getName());
            C1345b c1345bMo3291a = mo3291a();
            try {
                m3294d(interfaceC1346c.getClass()).invoke(null, interfaceC1346c, c1345bMo3291a);
                int i3 = c1345bMo3291a.f4811i;
                if (i3 >= 0) {
                    int i4 = c1345bMo3291a.f4806d.get(i3);
                    Parcel parcel = c1345bMo3291a.f4807e;
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i4);
                    parcel.writeInt(iDataPosition - i4);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e3) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e3);
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e5);
            } catch (InvocationTargetException e6) {
                if (!(e6.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e6);
                }
                throw ((RuntimeException) e6.getCause());
            }
        } catch (ClassNotFoundException e7) {
            throw new RuntimeException(interfaceC1346c.getClass().getSimpleName().concat(" does not have a Parcelizer"), e7);
        }
    }
}

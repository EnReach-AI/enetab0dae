package p007B1;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p028I1.C0303c;
import p034K1.C0413G;
import p046P.AbstractC0573b;
import p073Z.C0771Q;
import p110k.C1553R0;
import p110k.C1578c1;
import p145t1.C1921a;
import p149u1.C1948b;
import p155w.C1984f;

/* JADX INFO: renamed from: B1.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0042b implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f109a;

    public /* synthetic */ C0042b(int i3) {
        this.f109a = i3;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f109a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C0043c(parcel, classLoader);
            case 1:
                return new C0303c(parcel, classLoader);
            case 2:
                return new C0413G(parcel, classLoader);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                if (parcel.readParcelable(classLoader) == null) {
                    return AbstractC0573b.f1424f;
                }
                throw new IllegalStateException("superState must be null");
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return new C0771Q(parcel, classLoader);
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C1553R0(parcel, classLoader);
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return new C1578c1(parcel, classLoader);
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return new C1921a(parcel, classLoader);
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return new C1948b(parcel, classLoader);
            default:
                return new C1984f(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f109a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C0043c[i3];
            case 1:
                return new C0303c[i3];
            case 2:
                return new C0413G[i3];
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return new AbstractC0573b[i3];
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return new C0771Q[i3];
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C1553R0[i3];
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return new C1578c1[i3];
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return new C1921a[i3];
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return new C1948b[i3];
            default:
                return new C1984f[i3];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f109a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C0043c(parcel, null);
            case 1:
                return new C0303c(parcel, (ClassLoader) null);
            case 2:
                return new C0413G(parcel, null);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                if (parcel.readParcelable(null) == null) {
                    return AbstractC0573b.f1424f;
                }
                throw new IllegalStateException("superState must be null");
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return new C0771Q(parcel, null);
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C1553R0(parcel, null);
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return new C1578c1(parcel, null);
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return new C1921a(parcel, (ClassLoader) null);
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return new C1948b(parcel, null);
            default:
                return new C1984f(parcel, null);
        }
    }
}

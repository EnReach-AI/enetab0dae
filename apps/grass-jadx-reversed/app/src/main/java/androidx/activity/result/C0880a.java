package androidx.activity.result;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.C0915A;
import androidx.fragment.app.C0919E;
import androidx.fragment.app.C0922H;
import androidx.fragment.app.C0931b;
import androidx.versionedparcelable.ParcelImpl;
import com.facebook.C1099B;
import com.facebook.C1104a;
import com.facebook.C1114k;
import com.facebook.C1123t;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import com.google.android.material.datepicker.C1250b;
import com.google.android.material.datepicker.C1252d;
import com.google.android.material.datepicker.C1261m;
import java.util.ArrayList;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p080b.BinderC1001c;
import p080b.C0999a;
import p080b.C1002d;
import p080b.InterfaceC1000b;
import p110k.C1543M;
import p153v1.C1975b;

/* JADX INFO: renamed from: androidx.activity.result.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0880a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2626a;

    public /* synthetic */ C0880a(int i3) {
        this.f2626a = i3;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        InterfaceC1000b interfaceC1000b = null;
        switch (this.f2626a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C0881b(parcel);
            case 1:
                return new C0888i(parcel);
            case 2:
                return new C0931b(parcel);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                C0915A c0915a = new C0915A();
                c0915a.f3017e = parcel.readString();
                c0915a.f3018f = parcel.readInt();
                return c0915a;
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                C0919E c0919e = new C0919E();
                c0919e.f3059i = null;
                c0919e.f3060j = new ArrayList();
                c0919e.f3061k = new ArrayList();
                c0919e.f3055e = parcel.createTypedArrayList(C0922H.CREATOR);
                c0919e.f3056f = parcel.createStringArrayList();
                c0919e.f3057g = (C0931b[]) parcel.createTypedArray(C0931b.CREATOR);
                c0919e.f3058h = parcel.readInt();
                c0919e.f3059i = parcel.readString();
                c0919e.f3060j = parcel.createStringArrayList();
                c0919e.f3061k = parcel.createTypedArrayList(Bundle.CREATOR);
                c0919e.f3062l = parcel.createTypedArrayList(C0915A.CREATOR);
                return c0919e;
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C0922H(parcel);
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                C1002d c1002d = new C1002d();
                IBinder strongBinder = parcel.readStrongBinder();
                int i3 = BinderC1001c.f3570b;
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1000b)) {
                        C0999a c0999a = new C0999a();
                        c0999a.f3569a = strongBinder;
                        interfaceC1000b = c0999a;
                    } else {
                        interfaceC1000b = (InterfaceC1000b) iInterfaceQueryLocalInterface;
                    }
                }
                c1002d.f3572e = interfaceC1000b;
                return c1002d;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return new C1104a(parcel);
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return new C1114k(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null);
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return new C1123t(parcel);
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return new C1099B(parcel);
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                return new C1250b((C1261m) parcel.readParcelable(C1261m.class.getClassLoader()), (C1261m) parcel.readParcelable(C1261m.class.getClassLoader()), (C1252d) parcel.readParcelable(C1252d.class.getClassLoader()), (C1261m) parcel.readParcelable(C1261m.class.getClassLoader()), parcel.readInt());
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return new C1252d(parcel.readLong());
            case 13:
                return C1261m.m3182a(parcel.readInt(), parcel.readInt());
            case 14:
                return new ParcelImpl(parcel);
            case 15:
                C1543M c1543m = new C1543M(parcel);
                c1543m.f5519e = parcel.readByte() != 0;
                return c1543m;
            default:
                C1975b c1975b = new C1975b(parcel);
                c1975b.f6996e = ((Integer) parcel.readValue(C1975b.class.getClassLoader())).intValue();
                return c1975b;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f2626a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C0881b[i3];
            case 1:
                return new C0888i[i3];
            case 2:
                return new C0931b[i3];
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return new C0915A[i3];
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return new C0919E[i3];
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C0922H[i3];
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return new C1002d[i3];
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return new C1104a[i3];
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return new C1114k[i3];
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return new C1123t[i3];
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return new C1099B[i3];
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                return new C1250b[i3];
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return new C1252d[i3];
            case 13:
                return new C1261m[i3];
            case 14:
                return new ParcelImpl[i3];
            case 15:
                return new C1543M[i3];
            default:
                return new C1975b[i3];
        }
    }
}

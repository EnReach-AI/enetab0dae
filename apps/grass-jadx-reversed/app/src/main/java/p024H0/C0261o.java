package p024H0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: H0.o */
/* JADX INFO: loaded from: classes.dex */
public final class C0261o implements Parcelable {
    public static final Parcelable.Creator<C0261o> CREATOR = new C0247a(7);

    /* JADX INFO: renamed from: e */
    public final int f653e;

    /* JADX INFO: renamed from: f */
    public Set f654f;

    /* JADX INFO: renamed from: g */
    public final int f655g;

    /* JADX INFO: renamed from: h */
    public final String f656h;

    /* JADX INFO: renamed from: i */
    public final String f657i;

    /* JADX INFO: renamed from: j */
    public final boolean f658j;

    /* JADX INFO: renamed from: k */
    public final String f659k;

    /* JADX INFO: renamed from: l */
    public final String f660l;

    /* JADX INFO: renamed from: m */
    public final String f661m;

    public C0261o(Parcel parcel) {
        int i3;
        int i4;
        this.f658j = false;
        String string = parcel.readString();
        if (string == null) {
            i3 = 0;
        } else {
            if (string == null) {
                throw new NullPointerException("Name is null");
            }
            if (string.equals("NATIVE_WITH_FALLBACK")) {
                i3 = 1;
            } else if (string.equals("NATIVE_ONLY")) {
                i3 = 2;
            } else if (string.equals("KATANA_ONLY")) {
                i3 = 3;
            } else if (string.equals("WEB_ONLY")) {
                i3 = 4;
            } else if (string.equals("WEB_VIEW_ONLY")) {
                i3 = 5;
            } else if (string.equals("DIALOG_ONLY")) {
                i3 = 6;
            } else {
                if (!string.equals("DEVICE_AUTH")) {
                    throw new IllegalArgumentException("No enum constant com.facebook.login.LoginBehavior.".concat(string));
                }
                i3 = 7;
            }
        }
        this.f653e = i3;
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f654f = new HashSet(arrayList);
        String string2 = parcel.readString();
        if (string2 == null) {
            i4 = 0;
        } else {
            if (string2 == null) {
                throw new NullPointerException("Name is null");
            }
            if (string2.equals("NONE")) {
                i4 = 1;
            } else if (string2.equals("ONLY_ME")) {
                i4 = 2;
            } else if (string2.equals("FRIENDS")) {
                i4 = 3;
            } else {
                if (!string2.equals("EVERYONE")) {
                    throw new IllegalArgumentException("No enum constant com.facebook.login.DefaultAudience.".concat(string2));
                }
                i4 = 4;
            }
        }
        this.f655g = i4;
        this.f656h = parcel.readString();
        this.f657i = parcel.readString();
        this.f658j = parcel.readByte() != 0;
        this.f659k = parcel.readString();
        this.f660l = parcel.readString();
        this.f661m = parcel.readString();
    }

    /* JADX INFO: renamed from: a */
    public final boolean m506a() {
        for (String str : this.f654f) {
            Set set = AbstractC0267u.f686a;
            if (str != null && (str.startsWith("publish") || str.startsWith("manage") || AbstractC0267u.f686a.contains(str))) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = null;
        int i4 = this.f653e;
        parcel.writeString(i4 != 0 ? AbstractC0032g.m163u(i4) : null);
        parcel.writeStringList(new ArrayList(this.f654f));
        int i5 = this.f655g;
        if (i5 != 0) {
            if (i5 == 1) {
                str = "NONE";
            } else if (i5 == 2) {
                str = "ONLY_ME";
            } else if (i5 == 3) {
                str = "FRIENDS";
            } else {
                if (i5 != 4) {
                    throw null;
                }
                str = "EVERYONE";
            }
        }
        parcel.writeString(str);
        parcel.writeString(this.f656h);
        parcel.writeString(this.f657i);
        parcel.writeByte(this.f658j ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f659k);
        parcel.writeString(this.f660l);
        parcel.writeString(this.f661m);
    }
}

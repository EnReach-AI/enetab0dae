package p024H0;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.C1104a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p005B.AbstractC0032g;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: H0.p */
/* JADX INFO: loaded from: classes.dex */
public final class C0262p implements Parcelable {
    public static final Parcelable.Creator<C0262p> CREATOR = new C0247a(8);

    /* JADX INFO: renamed from: e */
    public final int f662e;

    /* JADX INFO: renamed from: f */
    public final C1104a f663f;

    /* JADX INFO: renamed from: g */
    public final String f664g;

    /* JADX INFO: renamed from: h */
    public final String f665h;

    /* JADX INFO: renamed from: i */
    public final C0261o f666i;

    /* JADX INFO: renamed from: j */
    public Map f667j;

    /* JADX INFO: renamed from: k */
    public HashMap f668k;

    public C0262p(C0261o c0261o, int i3, C1104a c1104a, String str, String str2) {
        if (i3 == 0) {
            throw new NullPointerException(AbstractC0032g.m154l("Argument '", "code", "' cannot be null"));
        }
        this.f666i = c0261o;
        this.f663f = c1104a;
        this.f664g = str;
        this.f662e = i3;
        this.f665h = str2;
    }

    /* JADX INFO: renamed from: a */
    public static C0262p m507a(C0261o c0261o, String str, String str2, String str3) {
        String[] strArr = {str, str2};
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 2; i3++) {
            String str4 = strArr[i3];
            if (str4 != null) {
                arrayList.add(str4);
            }
        }
        return new C0262p(c0261o, 3, null, TextUtils.join(": ", arrayList), str3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str;
        int i4 = this.f662e;
        if (i4 == 1) {
            str = "SUCCESS";
        } else if (i4 == 2) {
            str = "CANCEL";
        } else {
            if (i4 != 3) {
                throw null;
            }
            str = "ERROR";
        }
        parcel.writeString(str);
        parcel.writeParcelable(this.f663f, i3);
        parcel.writeString(this.f664g);
        parcel.writeString(this.f665h);
        parcel.writeParcelable(this.f666i, i3);
        AbstractC2056E.m4531C(parcel, this.f667j);
        AbstractC2056E.m4531C(parcel, this.f668k);
    }

    public C0262p(Parcel parcel) {
        int i3;
        String string = parcel.readString();
        if (string == null) {
            throw new NullPointerException("Name is null");
        }
        if (string.equals("SUCCESS")) {
            i3 = 1;
        } else if (string.equals("CANCEL")) {
            i3 = 2;
        } else {
            if (!string.equals("ERROR")) {
                throw new IllegalArgumentException("No enum constant com.facebook.login.LoginClient.Result.Code.".concat(string));
            }
            i3 = 3;
        }
        this.f662e = i3;
        this.f663f = (C1104a) parcel.readParcelable(C1104a.class.getClassLoader());
        this.f664g = parcel.readString();
        this.f665h = parcel.readString();
        this.f666i = (C0261o) parcel.readParcelable(C0261o.class.getClassLoader());
        this.f667j = AbstractC2056E.m4557z(parcel);
        this.f668k = AbstractC2056E.m4557z(parcel);
    }
}

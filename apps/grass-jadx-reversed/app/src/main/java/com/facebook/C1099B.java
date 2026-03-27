package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;
import org.json.JSONObject;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: com.facebook.B */
/* JADX INFO: loaded from: classes.dex */
public final class C1099B implements Parcelable {
    public static final Parcelable.Creator<C1099B> CREATOR = new C0880a(10);

    /* JADX INFO: renamed from: e */
    public final String f3791e;

    /* JADX INFO: renamed from: f */
    public final String f3792f;

    /* JADX INFO: renamed from: g */
    public final String f3793g;

    /* JADX INFO: renamed from: h */
    public final String f3794h;

    /* JADX INFO: renamed from: i */
    public final String f3795i;

    /* JADX INFO: renamed from: j */
    public final Uri f3796j;

    public C1099B(String str, String str2, String str3, String str4, String str5, Uri uri) {
        AbstractC2069g.m4583g(str, "id");
        this.f3791e = str;
        this.f3792f = str2;
        this.f3793g = str3;
        this.f3794h = str4;
        this.f3795i = str5;
        this.f3796j = uri;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1099B)) {
            return false;
        }
        C1099B c1099b = (C1099B) obj;
        String str = this.f3791e;
        if (str != null ? str.equals(c1099b.f3791e) : c1099b.f3791e == null) {
            String str2 = this.f3792f;
            if (str2 != null ? str2.equals(c1099b.f3792f) : c1099b.f3792f == null) {
                String str3 = this.f3793g;
                if (str3 != null ? str3.equals(c1099b.f3793g) : c1099b.f3793g == null) {
                    String str4 = this.f3794h;
                    if (str4 != null ? str4.equals(c1099b.f3794h) : c1099b.f3794h == null) {
                        String str5 = this.f3795i;
                        if (str5 != null ? str5.equals(c1099b.f3795i) : c1099b.f3795i == null) {
                            Uri uri = this.f3796j;
                            Uri uri2 = c1099b.f3796j;
                            if (uri == null) {
                                if (uri2 == null) {
                                    return true;
                                }
                            } else if (uri.equals(uri2)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f3791e.hashCode() + 527;
        String str = this.f3792f;
        if (str != null) {
            iHashCode = (iHashCode * 31) + str.hashCode();
        }
        String str2 = this.f3793g;
        if (str2 != null) {
            iHashCode = (iHashCode * 31) + str2.hashCode();
        }
        String str3 = this.f3794h;
        if (str3 != null) {
            iHashCode = (iHashCode * 31) + str3.hashCode();
        }
        String str4 = this.f3795i;
        if (str4 != null) {
            iHashCode = (iHashCode * 31) + str4.hashCode();
        }
        Uri uri = this.f3796j;
        return uri != null ? (iHashCode * 31) + uri.hashCode() : iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f3791e);
        parcel.writeString(this.f3792f);
        parcel.writeString(this.f3793g);
        parcel.writeString(this.f3794h);
        parcel.writeString(this.f3795i);
        Uri uri = this.f3796j;
        parcel.writeString(uri == null ? null : uri.toString());
    }

    public C1099B(JSONObject jSONObject) {
        this.f3791e = jSONObject.optString("id", null);
        this.f3792f = jSONObject.optString("first_name", null);
        this.f3793g = jSONObject.optString("middle_name", null);
        this.f3794h = jSONObject.optString("last_name", null);
        this.f3795i = jSONObject.optString("name", null);
        String strOptString = jSONObject.optString("link_uri", null);
        this.f3796j = strOptString != null ? Uri.parse(strOptString) : null;
    }

    public C1099B(Parcel parcel) {
        this.f3791e = parcel.readString();
        this.f3792f = parcel.readString();
        this.f3793g = parcel.readString();
        this.f3794h = parcel.readString();
        this.f3795i = parcel.readString();
        String string = parcel.readString();
        this.f3796j = string == null ? null : Uri.parse(string);
    }
}

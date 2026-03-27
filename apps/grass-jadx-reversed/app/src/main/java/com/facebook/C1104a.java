package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.activity.result.C0880a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p166z0.AbstractC2056E;
import p166z0.AbstractC2069g;

/* JADX INFO: renamed from: com.facebook.a */
/* JADX INFO: loaded from: classes.dex */
public final class C1104a implements Parcelable {

    /* JADX INFO: renamed from: e */
    public final Date f3823e;

    /* JADX INFO: renamed from: f */
    public final Set f3824f;

    /* JADX INFO: renamed from: g */
    public final Set f3825g;

    /* JADX INFO: renamed from: h */
    public final Set f3826h;

    /* JADX INFO: renamed from: i */
    public final String f3827i;

    /* JADX INFO: renamed from: j */
    public final EnumC1108e f3828j;

    /* JADX INFO: renamed from: k */
    public final Date f3829k;

    /* JADX INFO: renamed from: l */
    public final String f3830l;

    /* JADX INFO: renamed from: m */
    public final String f3831m;

    /* JADX INFO: renamed from: n */
    public final Date f3832n;

    /* JADX INFO: renamed from: o */
    public final String f3833o;

    /* JADX INFO: renamed from: p */
    public static final Date f3820p = new Date(Long.MAX_VALUE);

    /* JADX INFO: renamed from: q */
    public static final Date f3821q = new Date();

    /* JADX INFO: renamed from: r */
    public static final EnumC1108e f3822r = EnumC1108e.FACEBOOK_APPLICATION_WEB;
    public static final Parcelable.Creator<C1104a> CREATOR = new C0880a(7);

    public C1104a(String str, String str2, String str3, Collection collection, Collection collection2, Collection collection3, EnumC1108e enumC1108e, Date date, Date date2, Date date3, String str4) {
        AbstractC2069g.m4583g(str, "accessToken");
        AbstractC2069g.m4583g(str2, "applicationId");
        AbstractC2069g.m4583g(str3, "userId");
        Date date4 = f3820p;
        this.f3823e = date == null ? date4 : date;
        this.f3824f = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.f3825g = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.f3826h = Collections.unmodifiableSet(collection3 != null ? new HashSet(collection3) : new HashSet());
        this.f3827i = str;
        this.f3828j = enumC1108e == null ? f3822r : enumC1108e;
        this.f3829k = date2 == null ? f3821q : date2;
        this.f3830l = str2;
        this.f3831m = str3;
        this.f3832n = (date3 == null || date3.getTime() == 0) ? date4 : date3;
        this.f3833o = str4;
    }

    /* JADX INFO: renamed from: a */
    public static C1104a m2875a(JSONObject jSONObject) throws JSONException {
        if (jSONObject.getInt("version") > 1) {
            throw new C1111h("Unknown AccessToken serialization format.");
        }
        String string = jSONObject.getString("token");
        Date date = new Date(jSONObject.getLong("expires_at"));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray("declined_permissions");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("expired_permissions");
        Date date2 = new Date(jSONObject.getLong("last_refresh"));
        EnumC1108e enumC1108eValueOf = EnumC1108e.valueOf(jSONObject.getString("source"));
        return new C1104a(string, jSONObject.getString("application_id"), jSONObject.getString("user_id"), AbstractC2056E.m4552u(jSONArray), AbstractC2056E.m4552u(jSONArray2), jSONArrayOptJSONArray == null ? new ArrayList() : AbstractC2056E.m4552u(jSONArrayOptJSONArray), enumC1108eValueOf, date, date2, new Date(jSONObject.optLong("data_access_expiration_time", 0L)), jSONObject.optString("graph_domain", null));
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2876b() {
        C1104a c1104a = (C1104a) C1107d.m2887a().f3849d;
        return (c1104a == null || new Date().after(c1104a.f3823e)) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public final JSONObject m2877c() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put("token", this.f3827i);
        jSONObject.put("expires_at", this.f3823e.getTime());
        jSONObject.put("permissions", new JSONArray((Collection) this.f3824f));
        jSONObject.put("declined_permissions", new JSONArray((Collection) this.f3825g));
        jSONObject.put("expired_permissions", new JSONArray((Collection) this.f3826h));
        jSONObject.put("last_refresh", this.f3829k.getTime());
        jSONObject.put("source", this.f3828j.name());
        jSONObject.put("application_id", this.f3830l);
        jSONObject.put("user_id", this.f3831m);
        jSONObject.put("data_access_expiration_time", this.f3832n.getTime());
        String str = this.f3833o;
        if (str != null) {
            jSONObject.put("graph_domain", str);
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1104a)) {
            return false;
        }
        C1104a c1104a = (C1104a) obj;
        if (this.f3823e.equals(c1104a.f3823e) && this.f3824f.equals(c1104a.f3824f) && this.f3825g.equals(c1104a.f3825g) && this.f3826h.equals(c1104a.f3826h) && this.f3827i.equals(c1104a.f3827i) && this.f3828j == c1104a.f3828j && this.f3829k.equals(c1104a.f3829k)) {
            String str = c1104a.f3830l;
            String str2 = this.f3830l;
            if (str2 != null ? str2.equals(str) : str == null) {
                if (this.f3831m.equals(c1104a.f3831m) && this.f3832n.equals(c1104a.f3832n)) {
                    String str3 = c1104a.f3833o;
                    String str4 = this.f3833o;
                    if (str4 == null) {
                        if (str3 == null) {
                            return true;
                        }
                    } else if (str4.equals(str3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f3829k.hashCode() + ((this.f3828j.hashCode() + ((this.f3827i.hashCode() + ((this.f3826h.hashCode() + ((this.f3825g.hashCode() + ((this.f3824f.hashCode() + ((this.f3823e.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f3830l;
        int iHashCode2 = (this.f3832n.hashCode() + ((this.f3831m.hashCode() + ((iHashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31;
        String str2 = this.f3833o;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("{AccessToken token:");
        if (this.f3827i == null) {
            str = "null";
        } else {
            AbstractC1117n.m2896f();
            str = "ACCESS_TOKEN_REMOVED";
        }
        sb.append(str);
        sb.append(" permissions:");
        Set set = this.f3824f;
        if (set == null) {
            sb.append("null");
        } else {
            sb.append("[");
            sb.append(TextUtils.join(", ", set));
            sb.append("]");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f3823e.getTime());
        parcel.writeStringList(new ArrayList(this.f3824f));
        parcel.writeStringList(new ArrayList(this.f3825g));
        parcel.writeStringList(new ArrayList(this.f3826h));
        parcel.writeString(this.f3827i);
        parcel.writeString(this.f3828j.name());
        parcel.writeLong(this.f3829k.getTime());
        parcel.writeString(this.f3830l);
        parcel.writeString(this.f3831m);
        parcel.writeLong(this.f3832n.getTime());
        parcel.writeString(this.f3833o);
    }

    public C1104a(Parcel parcel) {
        this.f3823e = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.f3824f = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.f3825g = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.f3826h = Collections.unmodifiableSet(new HashSet(arrayList));
        this.f3827i = parcel.readString();
        this.f3828j = EnumC1108e.valueOf(parcel.readString());
        this.f3829k = new Date(parcel.readLong());
        this.f3830l = parcel.readString();
        this.f3831m = parcel.readString();
        this.f3832n = new Date(parcel.readLong());
        this.f3833o = parcel.readString();
    }
}

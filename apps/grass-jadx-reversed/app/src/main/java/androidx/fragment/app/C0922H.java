package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;

/* JADX INFO: renamed from: androidx.fragment.app.H */
/* JADX INFO: loaded from: classes.dex */
public final class C0922H implements Parcelable {
    public static final Parcelable.Creator<C0922H> CREATOR = new C0880a(5);

    /* JADX INFO: renamed from: e */
    public final String f3075e;

    /* JADX INFO: renamed from: f */
    public final String f3076f;

    /* JADX INFO: renamed from: g */
    public final boolean f3077g;

    /* JADX INFO: renamed from: h */
    public final int f3078h;

    /* JADX INFO: renamed from: i */
    public final int f3079i;

    /* JADX INFO: renamed from: j */
    public final String f3080j;

    /* JADX INFO: renamed from: k */
    public final boolean f3081k;

    /* JADX INFO: renamed from: l */
    public final boolean f3082l;

    /* JADX INFO: renamed from: m */
    public final boolean f3083m;

    /* JADX INFO: renamed from: n */
    public final Bundle f3084n;

    /* JADX INFO: renamed from: o */
    public final boolean f3085o;

    /* JADX INFO: renamed from: p */
    public final int f3086p;

    /* JADX INFO: renamed from: q */
    public Bundle f3087q;

    public C0922H(AbstractComponentCallbacksC0944o abstractComponentCallbacksC0944o) {
        this.f3075e = abstractComponentCallbacksC0944o.getClass().getName();
        this.f3076f = abstractComponentCallbacksC0944o.f3226i;
        this.f3077g = abstractComponentCallbacksC0944o.f3234q;
        this.f3078h = abstractComponentCallbacksC0944o.f3243z;
        this.f3079i = abstractComponentCallbacksC0944o.f3201A;
        this.f3080j = abstractComponentCallbacksC0944o.f3202B;
        this.f3081k = abstractComponentCallbacksC0944o.f3205E;
        this.f3082l = abstractComponentCallbacksC0944o.f3233p;
        this.f3083m = abstractComponentCallbacksC0944o.f3204D;
        this.f3084n = abstractComponentCallbacksC0944o.f3227j;
        this.f3085o = abstractComponentCallbacksC0944o.f3203C;
        this.f3086p = abstractComponentCallbacksC0944o.f3216P.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f3075e);
        sb.append(" (");
        sb.append(this.f3076f);
        sb.append(")}:");
        if (this.f3077g) {
            sb.append(" fromLayout");
        }
        int i3 = this.f3079i;
        if (i3 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i3));
        }
        String str = this.f3080j;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f3081k) {
            sb.append(" retainInstance");
        }
        if (this.f3082l) {
            sb.append(" removing");
        }
        if (this.f3083m) {
            sb.append(" detached");
        }
        if (this.f3085o) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f3075e);
        parcel.writeString(this.f3076f);
        parcel.writeInt(this.f3077g ? 1 : 0);
        parcel.writeInt(this.f3078h);
        parcel.writeInt(this.f3079i);
        parcel.writeString(this.f3080j);
        parcel.writeInt(this.f3081k ? 1 : 0);
        parcel.writeInt(this.f3082l ? 1 : 0);
        parcel.writeInt(this.f3083m ? 1 : 0);
        parcel.writeBundle(this.f3084n);
        parcel.writeInt(this.f3085o ? 1 : 0);
        parcel.writeBundle(this.f3087q);
        parcel.writeInt(this.f3086p);
    }

    public C0922H(Parcel parcel) {
        this.f3075e = parcel.readString();
        this.f3076f = parcel.readString();
        this.f3077g = parcel.readInt() != 0;
        this.f3078h = parcel.readInt();
        this.f3079i = parcel.readInt();
        this.f3080j = parcel.readString();
        this.f3081k = parcel.readInt() != 0;
        this.f3082l = parcel.readInt() != 0;
        this.f3083m = parcel.readInt() != 0;
        this.f3084n = parcel.readBundle();
        this.f3085o = parcel.readInt() != 0;
        this.f3087q = parcel.readBundle();
        this.f3086p = parcel.readInt();
    }
}

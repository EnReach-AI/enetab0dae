package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.C0880a;
import p005B.AbstractC0032g;

/* JADX INFO: renamed from: com.facebook.k */
/* JADX INFO: loaded from: classes.dex */
public final class C1114k implements Parcelable {
    public static final Parcelable.Creator<C1114k> CREATOR = new C0880a(8);

    /* JADX INFO: renamed from: e */
    public final int f3864e;

    /* JADX INFO: renamed from: f */
    public final int f3865f;

    /* JADX INFO: renamed from: g */
    public final int f3866g;

    /* JADX INFO: renamed from: h */
    public final String f3867h;

    /* JADX INFO: renamed from: i */
    public final String f3868i;

    /* JADX INFO: renamed from: j */
    public final String f3869j;

    /* JADX INFO: renamed from: k */
    public final String f3870k;

    /* JADX INFO: renamed from: l */
    public final Object f3871l;

    /* JADX INFO: renamed from: m */
    public final C1111h f3872m;

    /* JADX WARN: Removed duplicated region for block: B:40:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1114k(int r1, int r2, int r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, boolean r8, java.lang.Object r9, com.facebook.C1111h r10) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.C1114k.<init>(int, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, java.lang.Object, com.facebook.h):void");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{HttpStatus: ");
        sb.append(this.f3864e);
        sb.append(", errorCode: ");
        sb.append(this.f3865f);
        sb.append(", subErrorCode: ");
        sb.append(this.f3866g);
        sb.append(", errorType: ");
        sb.append(this.f3867h);
        sb.append(", errorMessage: ");
        String localizedMessage = this.f3868i;
        if (localizedMessage == null) {
            localizedMessage = this.f3872m.getLocalizedMessage();
        }
        return AbstractC0032g.m157o(sb, localizedMessage, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f3864e);
        parcel.writeInt(this.f3865f);
        parcel.writeInt(this.f3866g);
        parcel.writeString(this.f3867h);
        parcel.writeString(this.f3868i);
        parcel.writeString(this.f3869j);
        parcel.writeString(this.f3870k);
    }

    public C1114k(Exception exc) {
        this(-1, -1, -1, null, null, null, null, false, null, exc instanceof C1111h ? (C1111h) exc : new C1111h(exc));
    }

    public C1114k(int i3, String str, String str2) {
        this(-1, i3, -1, str, str2, null, null, false, null, null);
    }
}

package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import p024H0.C0247a;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new C0247a(22);

    /* JADX INFO: renamed from: e */
    public final String f2545e;

    /* JADX INFO: renamed from: f */
    public final CharSequence f2546f;

    /* JADX INFO: renamed from: g */
    public final CharSequence f2547g;

    /* JADX INFO: renamed from: h */
    public final CharSequence f2548h;

    /* JADX INFO: renamed from: i */
    public final Bitmap f2549i;

    /* JADX INFO: renamed from: j */
    public final Uri f2550j;

    /* JADX INFO: renamed from: k */
    public final Bundle f2551k;

    /* JADX INFO: renamed from: l */
    public final Uri f2552l;

    /* JADX INFO: renamed from: m */
    public Object f2553m;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f2545e = str;
        this.f2546f = charSequence;
        this.f2547g = charSequence2;
        this.f2548h = charSequence3;
        this.f2549i = bitmap;
        this.f2550j = uri;
        this.f2551k = bundle;
        this.f2552l = uri2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f2546f) + ", " + ((Object) this.f2547g) + ", " + ((Object) this.f2548h);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        Object objBuild = this.f2553m;
        if (objBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f2545e);
            builder.setTitle(this.f2546f);
            builder.setSubtitle(this.f2547g);
            builder.setDescription(this.f2548h);
            builder.setIconBitmap(this.f2549i);
            builder.setIconUri(this.f2550j);
            builder.setExtras(this.f2551k);
            builder.setMediaUri(this.f2552l);
            objBuild = builder.build();
            this.f2553m = objBuild;
        }
        ((MediaDescription) objBuild).writeToParcel(parcel, i3);
    }
}

package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import p024H0.C0247a;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new C0247a(29);

    /* JADX INFO: renamed from: e */
    public final int f2566e;

    /* JADX INFO: renamed from: f */
    public final long f2567f;

    /* JADX INFO: renamed from: g */
    public final long f2568g;

    /* JADX INFO: renamed from: h */
    public final float f2569h;

    /* JADX INFO: renamed from: i */
    public final long f2570i;

    /* JADX INFO: renamed from: j */
    public final int f2571j;

    /* JADX INFO: renamed from: k */
    public final CharSequence f2572k;

    /* JADX INFO: renamed from: l */
    public final long f2573l;

    /* JADX INFO: renamed from: m */
    public final ArrayList f2574m;

    /* JADX INFO: renamed from: n */
    public final long f2575n;

    /* JADX INFO: renamed from: o */
    public final Bundle f2576o;

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new C0865b();

        /* JADX INFO: renamed from: e */
        public final String f2577e;

        /* JADX INFO: renamed from: f */
        public final CharSequence f2578f;

        /* JADX INFO: renamed from: g */
        public final int f2579g;

        /* JADX INFO: renamed from: h */
        public final Bundle f2580h;

        public CustomAction(Parcel parcel) {
            this.f2577e = parcel.readString();
            this.f2578f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2579g = parcel.readInt();
            this.f2580h = parcel.readBundle(AbstractC0864a.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f2578f) + ", mIcon=" + this.f2579g + ", mExtras=" + this.f2580h;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f2577e);
            TextUtils.writeToParcel(this.f2578f, parcel, i3);
            parcel.writeInt(this.f2579g);
            parcel.writeBundle(this.f2580h);
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f2566e = parcel.readInt();
        this.f2567f = parcel.readLong();
        this.f2569h = parcel.readFloat();
        this.f2573l = parcel.readLong();
        this.f2568g = parcel.readLong();
        this.f2570i = parcel.readLong();
        this.f2572k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2574m = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f2575n = parcel.readLong();
        this.f2576o = parcel.readBundle(AbstractC0864a.class.getClassLoader());
        this.f2571j = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f2566e + ", position=" + this.f2567f + ", buffered position=" + this.f2568g + ", speed=" + this.f2569h + ", updated=" + this.f2573l + ", actions=" + this.f2570i + ", error code=" + this.f2571j + ", error message=" + this.f2572k + ", custom actions=" + this.f2574m + ", active item id=" + this.f2575n + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f2566e);
        parcel.writeLong(this.f2567f);
        parcel.writeFloat(this.f2569h);
        parcel.writeLong(this.f2573l);
        parcel.writeLong(this.f2568g);
        parcel.writeLong(this.f2570i);
        TextUtils.writeToParcel(this.f2572k, parcel, i3);
        parcel.writeTypedList(this.f2574m);
        parcel.writeLong(this.f2575n);
        parcel.writeBundle(this.f2576o);
        parcel.writeInt(this.f2571j);
    }
}

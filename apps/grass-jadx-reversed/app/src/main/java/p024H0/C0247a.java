package p024H0;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.AbstractC0864a;
import android.support.v4.media.session.MediaSessionCompat$QueueItem;
import android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.C1111h;
import com.fasterxml.jackson.databind.deser.std.FromStringDeserializer;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import p024H0.C0247a;
import p033K0.C0403a;
import p036L0.C0442b;
import p036L0.C0443c;
import p036L0.C0445e;
import p036L0.C0446f;
import p036L0.C0447g;
import p036L0.C0449i;
import p041N.C0524l;
import p073Z.C0787d0;
import p073Z.C0789e0;
import p073Z.C0808t;
import p166z0.AbstractC2056E;

/* JADX INFO: renamed from: H0.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0247a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f604a;

    public /* synthetic */ C0247a(int i3) {
        this.f604a = i3;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Uri mediaUri;
        Bundle bundle;
        switch (this.f604a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                C0248b c0248b = new C0248b(parcel);
                c0248b.f608j = "";
                c0248b.f607i = parcel.readString();
                return c0248b;
            case 1:
                C0254h c0254h = new C0254h();
                c0254h.f625e = parcel.readString();
                c0254h.f626f = parcel.readString();
                c0254h.f627g = parcel.readString();
                c0254h.f628h = parcel.readLong();
                c0254h.f629i = parcel.readLong();
                return c0254h;
            case 2:
                return new C0256j(parcel);
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return new C0257k(parcel);
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return new C0259m(parcel);
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C0260n(parcel);
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                C0263q c0263q = new C0263q();
                c0263q.f670f = -1;
                c0263q.f679o = 0;
                c0263q.f680p = 0;
                Parcelable[] parcelableArray = parcel.readParcelableArray(AbstractC0268v.class.getClassLoader());
                c0263q.f669e = new AbstractC0268v[parcelableArray.length];
                for (int i3 = 0; i3 < parcelableArray.length; i3++) {
                    AbstractC0268v[] abstractC0268vArr = c0263q.f669e;
                    AbstractC0268v abstractC0268v = (AbstractC0268v) parcelableArray[i3];
                    abstractC0268vArr[i3] = abstractC0268v;
                    if (abstractC0268v.f688f != null) {
                        throw new C1111h("Can't set LoginClient if it is already set.");
                    }
                    abstractC0268v.f688f = c0263q;
                }
                c0263q.f670f = parcel.readInt();
                c0263q.f675k = (C0261o) parcel.readParcelable(C0261o.class.getClassLoader());
                c0263q.f676l = AbstractC2056E.m4557z(parcel);
                c0263q.f677m = AbstractC2056E.m4557z(parcel);
                return c0263q;
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return new C0261o(parcel);
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return new C0262p(parcel);
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                C0271y c0271y = new C0271y(parcel);
                c0271y.f691i = parcel.readString();
                return c0271y;
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                C0403a c0403a = new C0403a();
                c0403a.f924e = parcel.readString();
                c0403a.f925f = parcel.readLong();
                return c0403a;
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                return new C0442b(parcel);
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return new C0443c(parcel);
            case 13:
                return new C0445e(parcel);
            case 14:
                return new C0446f(parcel);
            case 15:
                return new C0447g(parcel);
            case 16:
                return new C0449i(parcel);
            case 17:
                C0524l c0524l = new C0524l(parcel);
                c0524l.f1218e = parcel.readInt();
                return c0524l;
            case 18:
                C0808t c0808t = new C0808t();
                c0808t.f2389e = parcel.readInt();
                c0808t.f2390f = parcel.readInt();
                c0808t.f2391g = parcel.readInt() == 1;
                return c0808t;
            case 19:
                C0787d0 c0787d0 = new C0787d0();
                c0787d0.f2248e = parcel.readInt();
                c0787d0.f2249f = parcel.readInt();
                c0787d0.f2251h = parcel.readInt() == 1;
                int i4 = parcel.readInt();
                if (i4 > 0) {
                    int[] iArr = new int[i4];
                    c0787d0.f2250g = iArr;
                    parcel.readIntArray(iArr);
                }
                return c0787d0;
            case 20:
                C0789e0 c0789e0 = new C0789e0();
                c0789e0.f2258e = parcel.readInt();
                c0789e0.f2259f = parcel.readInt();
                int i5 = parcel.readInt();
                c0789e0.f2260g = i5;
                if (i5 > 0) {
                    int[] iArr2 = new int[i5];
                    c0789e0.f2261h = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i6 = parcel.readInt();
                c0789e0.f2262i = i6;
                if (i6 > 0) {
                    int[] iArr3 = new int[i6];
                    c0789e0.f2263j = iArr3;
                    parcel.readIntArray(iArr3);
                }
                c0789e0.f2265l = parcel.readInt() == 1;
                c0789e0.f2266m = parcel.readInt() == 1;
                c0789e0.f2267n = parcel.readInt() == 1;
                c0789e0.f2264k = parcel.readArrayList(C0787d0.class.getClassLoader());
                return c0789e0;
            case 21:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new C0247a(21);

                    /* JADX INFO: renamed from: e */
                    public final int f2543e;

                    /* JADX INFO: renamed from: f */
                    public final MediaDescriptionCompat f2544f;

                    {
                        this.f2543e = parcel.readInt();
                        this.f2544f = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f2543e + ", mDescription=" + this.f2544f + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i7) {
                        parcel2.writeInt(this.f2543e);
                        this.f2544f.writeToParcel(parcel2, i7);
                    }
                };
            case 22:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String mediaId = mediaDescription.getMediaId();
                CharSequence title = mediaDescription.getTitle();
                CharSequence subtitle = mediaDescription.getSubtitle();
                CharSequence description = mediaDescription.getDescription();
                Bitmap iconBitmap = mediaDescription.getIconBitmap();
                Uri iconUri = mediaDescription.getIconUri();
                Bundle extras = mediaDescription.getExtras();
                if (extras != null) {
                    extras.setClassLoader(AbstractC0864a.class.getClassLoader());
                    mediaUri = (Uri) extras.getParcelable("android.support.v4.media.description.MEDIA_URI");
                } else {
                    mediaUri = null;
                }
                if (mediaUri == null) {
                    bundle = extras;
                } else if (extras.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && extras.size() == 2) {
                    bundle = null;
                } else {
                    extras.remove("android.support.v4.media.description.MEDIA_URI");
                    extras.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = extras;
                }
                if (mediaUri == null) {
                    mediaUri = mediaDescription.getMediaUri();
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
                mediaDescriptionCompat.f2553m = objCreateFromParcel;
                return mediaDescriptionCompat;
            case 23:
                return new MediaMetadataCompat(parcel);
            case 24:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 25:
                return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new C0247a(25);

                    /* JADX INFO: renamed from: e */
                    public final MediaDescriptionCompat f2557e;

                    /* JADX INFO: renamed from: f */
                    public final long f2558f;

                    {
                        this.f2557e = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        this.f2558f = parcel.readLong();
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaSession.QueueItem {Description=" + this.f2557e + ", Id=" + this.f2558f + " }";
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i7) {
                        this.f2557e.writeToParcel(parcel2, i7);
                        parcel2.writeLong(this.f2558f);
                    }
                };
            case 26:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f2559e = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 27:
                final Parcelable parcelable = parcel.readParcelable(null);
                return new Parcelable(parcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new C0247a(27);

                    /* JADX INFO: renamed from: e */
                    public final Object f2560e;

                    {
                        this.f2560e = parcelable;
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MediaSessionCompat$Token)) {
                            return false;
                        }
                        MediaSessionCompat$Token mediaSessionCompat$Token = (MediaSessionCompat$Token) obj;
                        Object obj2 = this.f2560e;
                        if (obj2 == null) {
                            return mediaSessionCompat$Token.f2560e == null;
                        }
                        Object obj3 = mediaSessionCompat$Token.f2560e;
                        if (obj3 == null) {
                            return false;
                        }
                        return obj2.equals(obj3);
                    }

                    public final int hashCode() {
                        Object obj = this.f2560e;
                        if (obj == null) {
                            return 0;
                        }
                        return obj.hashCode();
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i7) {
                        parcel2.writeParcelable((Parcelable) this.f2560e, i7);
                    }
                };
            case 28:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f2561e = parcel.readInt();
                parcelableVolumeInfo.f2563g = parcel.readInt();
                parcelableVolumeInfo.f2564h = parcel.readInt();
                parcelableVolumeInfo.f2565i = parcel.readInt();
                parcelableVolumeInfo.f2562f = parcel.readInt();
                return parcelableVolumeInfo;
            default:
                return new PlaybackStateCompat(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f604a) {
            case WebSettingsBoundaryInterface.ForceDarkBehavior.FORCE_DARK_ONLY /* 0 */:
                return new C0248b[i3];
            case 1:
                return new C0254h[i3];
            case 2:
                return new C0256j[i3];
            case FromStringDeserializer.Std.STD_URI /* 3 */:
                return new C0257k[i3];
            case FromStringDeserializer.Std.STD_CLASS /* 4 */:
                return new C0259m[i3];
            case FromStringDeserializer.Std.STD_JAVA_TYPE /* 5 */:
                return new C0260n[i3];
            case FromStringDeserializer.Std.STD_CURRENCY /* 6 */:
                return new C0263q[i3];
            case FromStringDeserializer.Std.STD_PATTERN /* 7 */:
                return new C0261o[i3];
            case FromStringDeserializer.Std.STD_LOCALE /* 8 */:
                return new C0262p[i3];
            case FromStringDeserializer.Std.STD_CHARSET /* 9 */:
                return new C0271y[i3];
            case FromStringDeserializer.Std.STD_TIME_ZONE /* 10 */:
                return new C0403a[i3];
            case FromStringDeserializer.Std.STD_INET_ADDRESS /* 11 */:
                return new C0442b[i3];
            case FromStringDeserializer.Std.STD_INET_SOCKET_ADDRESS /* 12 */:
                return new C0443c[i3];
            case 13:
                return new C0445e[i3];
            case 14:
                return new C0446f[i3];
            case 15:
                return new C0447g[i3];
            case 16:
                return new C0449i[i3];
            case 17:
                return new C0524l[i3];
            case 18:
                return new C0808t[i3];
            case 19:
                return new C0787d0[i3];
            case 20:
                return new C0789e0[i3];
            case 21:
                return new MediaBrowserCompat$MediaItem[i3];
            case 22:
                return new MediaDescriptionCompat[i3];
            case 23:
                return new MediaMetadataCompat[i3];
            case 24:
                return new RatingCompat[i3];
            case 25:
                return new MediaSessionCompat$QueueItem[i3];
            case 26:
                return new MediaSessionCompat$ResultReceiverWrapper[i3];
            case 27:
                return new MediaSessionCompat$Token[i3];
            case 28:
                return new ParcelableVolumeInfo[i3];
            default:
                return new PlaybackStateCompat[i3];
        }
    }
}

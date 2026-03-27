package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.AbstractC0864a;
import p080b.C1002d;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends C1002d {
    @Override // p080b.C1002d
    /* JADX INFO: renamed from: a */
    public final void mo2190a(int i3, Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(AbstractC0864a.class.getClassLoader());
        }
        if (i3 != 0 || bundle == null || !bundle.containsKey("media_item")) {
            throw null;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
            throw null;
        }
        throw null;
    }
}

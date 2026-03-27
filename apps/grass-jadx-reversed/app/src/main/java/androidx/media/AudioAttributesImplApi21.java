package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(21)
class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* JADX INFO: renamed from: a */
    public AudioAttributes f3353a;

    /* JADX INFO: renamed from: b */
    public int f3354b = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f3353a.equals(((AudioAttributesImplApi21) obj).f3353a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3353a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3353a;
    }
}

package androidx.media;

import android.util.SparseIntArray;
import p095f0.InterfaceC1346c;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements InterfaceC1346c {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ int f3351b = 0;

    /* JADX INFO: renamed from: a */
    public AudioAttributesImpl f3352a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f3352a;
        return audioAttributesImpl == null ? audioAttributesCompat.f3352a == null : audioAttributesImpl.equals(audioAttributesCompat.f3352a);
    }

    public final int hashCode() {
        return this.f3352a.hashCode();
    }

    public final String toString() {
        return this.f3352a.toString();
    }
}

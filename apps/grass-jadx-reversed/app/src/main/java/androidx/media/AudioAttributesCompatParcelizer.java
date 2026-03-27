package androidx.media;

import p095f0.AbstractC1344a;
import p095f0.InterfaceC1346c;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC1344a abstractC1344a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        InterfaceC1346c interfaceC1346cM3298h = audioAttributesCompat.f3352a;
        if (abstractC1344a.mo3295e(1)) {
            interfaceC1346cM3298h = abstractC1344a.m3298h();
        }
        audioAttributesCompat.f3352a = (AudioAttributesImpl) interfaceC1346cM3298h;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC1344a abstractC1344a) {
        abstractC1344a.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f3352a;
        abstractC1344a.mo3299i(1);
        abstractC1344a.m3301k(audioAttributesImpl);
    }
}

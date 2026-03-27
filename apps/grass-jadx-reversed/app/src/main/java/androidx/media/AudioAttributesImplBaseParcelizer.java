package androidx.media;

import p095f0.AbstractC1344a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC1344a abstractC1344a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3355a = abstractC1344a.m3296f(audioAttributesImplBase.f3355a, 1);
        audioAttributesImplBase.f3356b = abstractC1344a.m3296f(audioAttributesImplBase.f3356b, 2);
        audioAttributesImplBase.f3357c = abstractC1344a.m3296f(audioAttributesImplBase.f3357c, 3);
        audioAttributesImplBase.f3358d = abstractC1344a.m3296f(audioAttributesImplBase.f3358d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC1344a abstractC1344a) {
        abstractC1344a.getClass();
        abstractC1344a.m3300j(audioAttributesImplBase.f3355a, 1);
        abstractC1344a.m3300j(audioAttributesImplBase.f3356b, 2);
        abstractC1344a.m3300j(audioAttributesImplBase.f3357c, 3);
        abstractC1344a.m3300j(audioAttributesImplBase.f3358d, 4);
    }
}

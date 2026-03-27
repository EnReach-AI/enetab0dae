package androidx.media;

import android.media.AudioAttributes;
import p095f0.AbstractC1344a;
import p095f0.C1345b;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC1344a abstractC1344a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f3353a = (AudioAttributes) abstractC1344a.m3297g(audioAttributesImplApi21.f3353a, 1);
        audioAttributesImplApi21.f3354b = abstractC1344a.m3296f(audioAttributesImplApi21.f3354b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC1344a abstractC1344a) {
        abstractC1344a.getClass();
        AudioAttributes audioAttributes = audioAttributesImplApi21.f3353a;
        abstractC1344a.mo3299i(1);
        ((C1345b) abstractC1344a).f4807e.writeParcelable(audioAttributes, 0);
        abstractC1344a.m3300j(audioAttributesImplApi21.f3354b, 2);
    }
}
